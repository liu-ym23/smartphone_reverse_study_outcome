package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes23.dex */
public abstract class z {
    public static String a(String r100, String r101) {
        j0 r102 = c(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.a();
    }

    public static boolean b(String r100, String r101) {
        j0 r102 = c(r100, r101);
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.e() == false) goto L7;
        return true;
    }

    private static j0 c(String r100, String r101) {
        l1 r102 = s.c().a(r100);
        if (r102 == null) goto L8;
        s0 r103 = r102.a(r101);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.j();
    L8:
        return null;
    }

    public static String d(String r100, String r101) {
        j0 r102 = c(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.b();
    }

    public static boolean e(String r100, String r101) {
        j0 r102 = c(r100, r101);
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.f() == false) goto L7;
        return true;
    }

    public static boolean f(String r100, String r101) {
        l1 r102 = s.c().a(r100);
        if (r102 == null) goto L8;
        s0 r103 = r102.a(r101);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.c();
    L8:
        return false;
    }

    public static String g(String r100, String r101) {
        j0 r102 = c(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.d();
    }

    public static boolean h(String r100, String r101) {
        j0 r102 = c(r100, r101);
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.g() == false) goto L7;
        return true;
    }

    public static boolean i(String r100, String r101) {
        l1 r102 = s.c().a(r100);
        if (r102 == null) goto L8;
        s0 r103 = r102.a(r101);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.e();
    L8:
        return false;
    }

    public static String j(String r100, String r101) {
        j0 r102 = c(r100, r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.c();
    }

    public static boolean k(String r100, String r101) {
        j0 r102 = c(r100, r101);
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.h() == false) goto L7;
        return true;
    }
}
