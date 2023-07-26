package com.lzk;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{9,1,4,2,8,5,6,7,3};
//        selectSort(array);
//        bubbleSort(array);
//        insertSort(array);
//        quickSort(array, 0, array.length - 1);
        mergeSort(array, 0, array.length - 1);

        //打印数组方式一
        System.out.println("排序结果：" + Arrays.toString(array));

        //打印数组方式二
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

        //打印数组方式三
//        System.out.print("[");
//        for (int a :
//                array) {
//            System.out.print(a + " ");
//        }
//        System.out.print("]");
    }

    //1, 选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(arr, i, min);
            }

        }
    }

    //2, 冒泡排序
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            boolean flag = true;
            for (int j = 0; j< arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j + 1, j);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    //3, 插入排序
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]){
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    //4, 快速排序
    public static void quickSort(int[] arr, int low, int high){
        int p, i, j;

        if(low >= high){
            return;
        }

        p = arr[low];
        i = low;
        j = high;

        while (i < j){
            while (arr[j] >= p && i < j){
                j--;
            }
            while (arr[i] <= p && i < j){
                i++;
            }
            swap(arr, i, j);
        }

        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr, low, i - 1);
        quickSort(arr, j + 1, high);
    }

    //5, 归并排序
    public static void merge(int[] arr, int low, int mid, int high){

        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid){
            temp[k++] = arr[i++];
        }
        while (j <= high){
            temp[k++] = arr[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++){
            arr[k2 + low] = temp[k2];
        }
    }

    public static void mergeSort(int[] a, int low, int high){
        int mid = (low + high) / 2;
        if(low < high){
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tepm = arr[i];
        arr[i] = arr[j];
        arr[j] = tepm;
    }
}