package com.huawei.hms.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class Checker {
    private Checker() {
    }

    public static void assertHandlerThread(Handler r100) {
        assertHandlerThread(r100, "Must be called on the handler thread");
    }

    public static void assertNonEmpty(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Given String is empty or null");
    }

    public static <T> T assertNonNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("Null reference");
    }

    public static void assertNotUiThread(String r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100);
    }

    public static void assertUiThread(String r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100);
    }

    public static String checkNonEmpty(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static <T> T checkNonNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("Null reference");
    }

    public static int checkNonZero(int r100) {
        if (r100 == 0) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static long checkNotZero(long r100) {
        if (r100 == 0) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Given Long is zero");
    }

    public static void assertHandlerThread(Handler r100, String r101) {
        if (Looper.myLooper() != r100.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException(r101);
    }

    public static void assertNonEmpty(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.valueOf(r101));
    }

    public static <T> T assertNonNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static String checkNonEmpty(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static <T> T checkNonNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static int checkNonZero(int r100, String r101) {
        if (r100 == 0) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static long checkNotZero(long r100, String r101) {
        if (r100 == 0) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(String.valueOf(r101));
    }
}
