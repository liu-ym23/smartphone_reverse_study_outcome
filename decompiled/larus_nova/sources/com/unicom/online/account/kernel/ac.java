package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes5.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f461949a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f461950b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f461951c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f461952d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f461953e = "MD5";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f461954f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f461955g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f461956h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f461957i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f461958j = true;

    static {
        f461955g = new String(o.b("bXN2Ni53b3Ntcy5jbg=="));
    }

    public static void a(boolean r100) {
        f461956h = r100;
    }

    public static boolean a() {
        return f461956h;
    }

    public static boolean a(int r100) {
        if (5 != r100) goto L5;
        return true;
    L5:
        if (3 != r100) goto L7;
        return true;
    L7:
        if (4 != r100) goto L9;
        return true;
    L9:
        if (2 == r100) goto L17;
        return false;
    L17:
        return true;
    }

    public static void b(boolean r100) {
        f461957i = r100;
    }

    public static boolean b() {
        return f461957i;
    }

    public static boolean b(int r100) {
        if (24 != r100) goto L5;
        return true;
    L5:
        if (25 == r100) goto L11;
        return false;
    L11:
        return true;
    }

    public static void c(boolean r100) {
        f461958j = r100;
    }

    public static boolean c() {
        return f461958j;
    }

    public static String d() {
        return "6.3.0CR001B0812";
    }

    public static String e() {
        return "6.3.0CR001B0812_20240812v1";
    }
}
