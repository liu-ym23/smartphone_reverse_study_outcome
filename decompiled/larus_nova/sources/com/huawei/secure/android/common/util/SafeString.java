package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: classes23.dex */
public class SafeString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278218a = "SafeString";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278219b = "";

    public SafeString() {
    }

    public static String substring(String r100, int r101) {
        if (r100 != null) goto L5;
    L12:
        return "";
    L5:
        if (r100.length() < r101) goto L12;
        if (r101 < 0) goto L12;
        return r100.substring(r101);
    L10:
        e = move-exception;
        e.getMessage();
        goto L12
    }

    public static String replace(String r100, CharSequence r101, CharSequence r102) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L10;
        if (r102 == null) goto L10;
        return r100.replace(r101, r102);
    L8:
        e = move-exception;
        e.getMessage();
    L10:
        return r100;
    }

    public static String substring(String r100, int r101, int r102) {
        if (r100 == null) goto L13;
        if (r101 < 0) goto L13;
        if (r102 > r100.length()) goto L13;
        if (r102 < r101) goto L13;
        return r100.substring(r101, r102);
    L11:
        e = move-exception;
        e.getMessage();
    L13:
        return "";
    }
}
