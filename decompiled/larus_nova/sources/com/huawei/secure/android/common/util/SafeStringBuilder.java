package com.huawei.secure.android.common.util;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public class SafeStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278222a = "SafeStringBuilder";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278223b = "";

    public SafeStringBuilder() {
    }

    public static String substring(StringBuilder r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
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

    public static String substring(StringBuilder r100, int r101, int r102) {
        if (TextUtils.isEmpty(r100) == true) goto L13;
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
