package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes23.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m0 f277465a;

    static {
        f277465a = new m0();
    }

    public static void a(int r100) {
        f277465a.a(r100);
    }

    public static void a(String r100, String r101) {
        if (a() == false) goto L8;
        if (r100 == null) goto L9;
        if (r101 == null) goto L10;
        f277465a.b(3, r100, r101);
        return;
    L10:
        return;
    L9:
        return;
    }

    public static void a(String r100, String r101, Object... r102) {
        if (c() == false) goto L8;
        if (r100 == null) goto L9;
        if (r101 == null) goto L10;
        String r103 = String.format(r101, r102);
        f277465a.b(4, r100, r103);
        return;
    L10:
        return;
    L9:
        return;
    }

    private static boolean a() {
        return f277465a.b(3);
    }

    public static void b(String r100, String r101) {
        if (b() == false) goto L8;
        if (r100 == null) goto L9;
        if (r101 == null) goto L10;
        f277465a.b(6, r100, r101);
        return;
    L10:
        return;
    L9:
        return;
    }

    public static void b(String r100, String r101, Object... r102) {
        d(r100, String.format(r101, r102));
    }

    private static boolean b() {
        return f277465a.b(6);
    }

    public static void c(String r100, String r101) {
        if (c() == false) goto L8;
        if (r100 == null) goto L9;
        if (r101 == null) goto L10;
        f277465a.b(4, r100, r101);
        return;
    L10:
        return;
    L9:
        return;
    }

    private static boolean c() {
        return f277465a.b(4);
    }

    public static void d(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        f277465a.b(4, r100, r101);
        return;
    L7:
        return;
    }

    private static boolean d() {
        return f277465a.b(5);
    }

    public static void e(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        f277465a.b(5, r100, r101);
        return;
    L7:
        return;
    }

    public static void f(String r100, String r101) {
        if (d() == false) goto L8;
        if (r100 == null) goto L9;
        if (r101 == null) goto L10;
        f277465a.b(5, r100, r101);
        return;
    L10:
        return;
    L9:
        return;
    }
}
