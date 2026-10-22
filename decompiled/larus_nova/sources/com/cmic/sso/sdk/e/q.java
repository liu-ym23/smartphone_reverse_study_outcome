package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f273522a = null;

    static {
        f273522a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static byte[] a() {
        byte[] r100 = new byte[16];
        new SecureRandom().nextBytes(r100);
        return r100;
    }

    public static String b() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String c() {
        return d().replace("-", "");
    }

    private static String d() {
        return UUID.randomUUID().toString();
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        char[] r101 = new char[r100.length * 2];
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r102) goto L9;
        byte r105 = r100[r103];
        int r106 = r104 + 1;
        char[] r107 = f273522a;
        r101[r104] = r107[(r105 >>> 4) & 15];
        r104 = r106 + 1;
        r101[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L6
    L9:
        return new String(r101);
    }

    public static boolean a(com.cmic.sso.sdk.a.a r100) {
        if ((k.a("logCloseTime", 0) + ((long) (((r100.l() * 60) * 60) * 1000))) < System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(com.cmic.sso.sdk.a r100, String r101) {
        if (TextUtils.isEmpty(r100.b("interfaceType", "")) == false) goto L5;
        r100.a("interfaceType", r101);
        return;
    L5:
        r100.a("interfaceType", r100.b("interfaceType") + com.alipay.sdk.m.u.i.f25853b + r101);
    }

    public static void b(com.cmic.sso.sdk.a r100, String r101) {
        if (TextUtils.isEmpty(r100.b("interfaceCode", "")) == false) goto L5;
        r100.a("interfaceCode", r101);
        return;
    L5:
        r100.a("interfaceCode", r100.b("interfaceCode") + com.alipay.sdk.m.u.i.f25853b + r101);
    }

    public static void c(com.cmic.sso.sdk.a r100, String r101) {
        if (TextUtils.isEmpty(r100.b("interfaceElasped", "")) == false) goto L5;
        r100.a("interfaceElasped", r101);
        return;
    L5:
        r100.a("interfaceElasped", r100.b("interfaceElasped") + com.alipay.sdk.m.u.i.f25853b + r101);
    }
}
