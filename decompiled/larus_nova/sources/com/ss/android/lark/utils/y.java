package com.ss.android.lark.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f444791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f444792b = null;

    static {
        String r100 = new String(w28.a.a(x28.a.a("ee")));
        f444791a = r100.substring(r100.length() - 6);
        f444792b = r100.substring(0, 6);
    }

    public static String a(String r100) {
        return new String(w28.a.a(x28.a.b("08a441".concat(new String(w28.a.a(x28.a.a(r100 + "42b91e")))))));
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        return new String(w28.a.a(x28.a.b(f444792b + new String(w28.a.a(x28.a.a(r100 + f444791a))))));
    }
}
