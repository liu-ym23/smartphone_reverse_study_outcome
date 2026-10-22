package com.cmic.ida.sdk;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.UUID;

/* JADX INFO: loaded from: classes22.dex */
public class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f273269a = null;

    static {
        f273269a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static byte[] b() {
        byte[] r100 = new byte[16];
        new SecureRandom().nextBytes(r100);
        return r100;
    }

    public static String a() {
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
        char[] r107 = f273269a;
        r101[r104] = r107[(r105 >>> 4) & 15];
        r104 = r106 + 1;
        r101[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L6
    L9:
        return new String(r101);
    }

    public static void a(g r100, String r101) {
        if (TextUtils.isEmpty(r100.a("interfaceCode", "")) == false) goto L5;
        r100.b("interfaceCode", r101);
        return;
    L5:
        r100.b("interfaceCode", r100.b("interfaceCode") + com.alipay.sdk.m.u.i.f25853b + r101);
    }

    public static void b(g r100, String r101) {
        if (TextUtils.isEmpty(r100.a("interfaceElasped", "")) == false) goto L5;
        r100.b("interfaceElasped", r101);
        return;
    L5:
        r100.b("interfaceElasped", r100.b("interfaceElasped") + com.alipay.sdk.m.u.i.f25853b + r101);
    }

    public static void c(g r100, String r101) {
        if (TextUtils.isEmpty(r100.a("interfaceType", "")) == false) goto L5;
        r100.b("interfaceType", r101);
        return;
    L5:
        r100.b("interfaceType", r100.b("interfaceType") + com.alipay.sdk.m.u.i.f25853b + r101);
    }
}
