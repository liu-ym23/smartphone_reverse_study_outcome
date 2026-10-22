package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public abstract class i0 {
    public static String a(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(z.a(r101, r102)) == false) goto L5;
        v.a("hmsSdk", "getAndroidId(): to getConfigByType()");
        return c(r100, r101, r102);
    L5:
        return z.a(r101, r102);
    }

    public static String b(Context r100, String r101, String r102) {
        if (r102.equals("oper") == false) goto L7;
        return d(r100, r101, r102);
    L7:
        if (r102.equals("maint") == false) goto L11;
        return d(r100, r101, r102);
    L11:
        if (r102.equals("diffprivacy") == false) goto L15;
        return d(r100, r101, r102);
    L15:
        if (r102.equals("preins") == true) goto L17;
        v.f("hmsSdk", "getChannel(): Invalid type: ".concat(r102));
        return "";
    L17:
        return d(r100, r101, r102);
    }

    private static String c(Context r100, String r101, String r102) {
        if (z.b(r101, r102) == true) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(q0.d()) == false) goto L8;
        String r103 = o.a(r100);
        s.c().b().b(r103);
    L8:
        return q0.d();
    }

    private static String d(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(a1.d(r101, r102)) == false) goto L5;
        g1 r103 = s.c().b();
        if (TextUtils.isEmpty(r103.h()) == false) goto L13;
        String r104 = o.b(r100);
        if (e1.a("channel", r104, 256) == true) goto L11;
        r104 = "";
    L11:
        r103.f(r104);
    L13:
        return r103.h();
    L5:
        return a1.d(r101, r102);
    }
}
