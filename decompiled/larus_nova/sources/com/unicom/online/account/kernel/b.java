package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f462020a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f462021b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f462022c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f462023d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f462024e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f462025f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f462026g = "CU";

    public static void a() {
        f462021b = "";
        f462022c = "";
        f462025f = 0;
        f462024e = 0;
    }

    public static void a(long r100) {
        f462025f = r100;
    }

    public static void a(String r100) {
        f462026g = r100;
    }

    public static void b(long r100) {
        f462024e = r100;
    }

    public static void b(String r100) {
        f462022c = r100;
    }

    public static void c(String r100) {
        f462021b = r100;
    }

    public static void d(String r100) {
        f462023d = r100;
    }

    public static Boolean e(String r100) {
        if (r100 == null) goto L15;
        if (r100.length() == 0) goto L15;
        if (r100.trim().length() == 0) goto L15;
        if ("null".equals(r100) == true) goto L15;
        if (r100.equals("") == true) goto L15;
        return Boolean.TRUE;
    L15:
        return Boolean.FALSE;
    }
}
