package com.oplus.ocs.base.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static void b(String r100) {
        if (b.a() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100);
    }

    public static <T> T a(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("null reference");
    }

    public static <T> T a(T r100, Object r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static void a(boolean r100, Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r101));
    }
}
