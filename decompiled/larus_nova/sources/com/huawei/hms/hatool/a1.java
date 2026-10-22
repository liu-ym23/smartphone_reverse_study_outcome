package com.huawei.hms.hatool;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a1 {
    public static void a(String r100, String r101, long r102) {
        s0 r103 = h(r100, r101);
        if (r103 == null) goto L6;
        r103.a(r102);
        return;
    }

    public static boolean a(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return true;
    L5:
        return r102.a();
    }

    public static int b(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return 7;
    L5:
        return r102.d();
    }

    public static boolean c(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return true;
    L5:
        return r102.g();
    }

    public static String d(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.f();
    }

    public static boolean e(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.i();
    }

    public static String f(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.h();
    }

    public static String g(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.n();
    }

    private static s0 h(String r100, String r101) {
        l1 r102 = s.c().a(r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        if ("alltype".equals(r101) == false) goto L11;
        s0 r103 = r102.a("oper");
        if (r103 == null) goto L9;
        return r103;
    L9:
        return r102.a("maint");
    L11:
        return r102.a(r101);
    }

    public static Map<String, String> i(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.k();
    }

    public static long j(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return 0;
    L5:
        return r102.l();
    }

    public static int k(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return 10;
    L5:
        return r102.b();
    }

    public static String l(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.o();
    }

    public static String m(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.q();
    }

    public static String n(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.m();
    }

    public static String o(String r100, String r101) {
        s0 r102 = h(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.p();
    }
}
