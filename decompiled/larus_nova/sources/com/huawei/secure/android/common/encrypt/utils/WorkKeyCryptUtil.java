package com.huawei.secure.android.common.encrypt.utils;

import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;

/* JADX INFO: loaded from: classes23.dex */
public class WorkKeyCryptUtil {
    private WorkKeyCryptUtil() {
    }

    public static String decryptWorkKey(String r100, RootKeyUtil r101) {
        return AesCbc.decrypt(r100, r101.getRootKey());
    }

    public static String decryptWorkKeyGcm(String r100, RootKeyUtil r101) {
        return AesGcm.decrypt(r100, r101.getRootKey());
    }

    public static String encryptWorkKey(String r100, RootKeyUtil r101) {
        return AesCbc.encrypt(r100, r101.getRootKey());
    }

    public static String encryptWorkKeyGcm(String r100, RootKeyUtil r101) {
        return AesGcm.encrypt(r100, r101.getRootKey());
    }

    public static String decryptWorkKey(String r100, byte[] r101) {
        return AesCbc.decrypt(r100, r101);
    }

    public static String decryptWorkKeyGcm(String r100, byte[] r101) {
        return AesGcm.decrypt(r100, r101);
    }

    public static String encryptWorkKey(String r100, byte[] r101) {
        return AesCbc.encrypt(r100, r101);
    }

    public static String encryptWorkKeyGcm(String r100, byte[] r101) {
        return AesGcm.encrypt(r100, r101);
    }

    public static byte[] decryptWorkKey2Byte(byte[] r100, RootKeyUtil r101, byte[] r102) {
        return AesCbc.decrypt(r100, r101.getRootKey(), r102);
    }

    public static byte[] decryptWorkKey2ByteGcm(byte[] r100, RootKeyUtil r101, byte[] r102) {
        return AesGcm.decrypt(r100, r101.getRootKey(), r102);
    }

    public static byte[] encryptWorkKey2Byte(byte[] r100, RootKeyUtil r101, byte[] r102) {
        return AesCbc.encrypt(r100, r101.getRootKey(), r102);
    }

    public static byte[] encryptWorkKey2ByteGcm(byte[] r100, RootKeyUtil r101, byte[] r102) {
        return AesGcm.encrypt(r100, r101.getRootKey(), r102);
    }

    public static byte[] decryptWorkKey2Byte(byte[] r100, byte[] r101, byte[] r102) {
        return AesCbc.decrypt(r100, r101, r102);
    }

    public static byte[] decryptWorkKey2ByteGcm(byte[] r100, byte[] r101, byte[] r102) {
        return AesGcm.decrypt(r100, r101, r102);
    }

    public static byte[] encryptWorkKey2Byte(byte[] r100, byte[] r101, byte[] r102) {
        return AesCbc.encrypt(r100, r101, r102);
    }

    public static byte[] encryptWorkKey2ByteGcm(byte[] r100, byte[] r101, byte[] r102) {
        return AesGcm.encrypt(r100, r101, r102);
    }
}
