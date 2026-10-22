package com.huawei.secure.android.common.util;

import android.util.Base64;

/* JADX INFO: loaded from: classes23.dex */
public class SafeBase64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278217a = "SafeBase64";

    private SafeBase64() {
    }

    public static byte[] decode(String r100, int r101) {
        return Base64.decode(r100, r101);
    L4:
        e = move-exception;
        e.getMessage();
        return new byte[0];
    }

    public static byte[] encode(byte[] r100, int r101) {
        return Base64.encode(r100, r101);
    L4:
        e = move-exception;
        e.getMessage();
        return new byte[0];
    }

    public static String encodeToString(byte[] r100, int r101) {
        return Base64.encodeToString(r100, r101);
    L4:
        e = move-exception;
        e.getMessage();
        return "";
    }

    public static byte[] decode(byte[] r100, int r101) {
        return Base64.decode(r100, r101);
    L4:
        e = move-exception;
        e.getMessage();
        return new byte[0];
    }

    public static byte[] decode(byte[] r100, int r101, int r102, int r103) {
        return Base64.decode(r100, r101, r102, r103);
    L4:
        e = move-exception;
        e.getMessage();
        return new byte[0];
    }

    public static byte[] encode(byte[] r100, int r101, int r102, int r103) {
        return Base64.encode(r100, r101, r102, r103);
    L4:
        e = move-exception;
        e.getMessage();
        return new byte[0];
    }

    public static String encodeToString(byte[] r100, int r101, int r102, int r103) {
        return Base64.encodeToString(r100, r101, r102, r103);
    L4:
        e = move-exception;
        e.getMessage();
        return "";
    }
}
