package com.heytap.mcssdk.utils;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f276415a = "mcssdk---";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f276416b = "MCS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f276417c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f276418d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f276419e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f276420f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f276421g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f276422h = "-->";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f276423i = true;

    public d() {
    }

    public static String a() {
        return f276416b;
    }

    public static void a(Exception r100) {
        if (f276421g == false) goto L8;
        if (r100 != null) goto L6;
        return;
    L6:
        r100.getMessage();
        return;
    }

    public static void a(String r100) {
        if (f276417c == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void a(String r100, String r101) {
        if (f276417c == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void a(String r100, Throwable r101) {
        if (f276421g == false) goto L6;
        r101.toString();
        return;
    }

    public static void a(boolean r100) {
        f276417c = r100;
    }

    public static void b(String r100) {
        if (f276419e == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void b(String r100, String r101) {
        if (f276419e == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void b(boolean r100) {
        f276419e = r100;
    }

    public static boolean b() {
        return f276417c;
    }

    public static void c(String r100) {
        if (f276418d == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void c(String r100, String r101) {
        if (f276418d == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void c(boolean r100) {
        f276418d = r100;
    }

    public static boolean c() {
        return f276419e;
    }

    public static void d(String r100) {
        if (f276420f == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void d(String r100, String r101) {
        if (f276420f == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void d(boolean r100) {
        f276420f = r100;
    }

    public static boolean d() {
        return f276418d;
    }

    public static void e(String r100) {
        if (f276421g == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void e(String r100, String r101) {
        if (f276421g == true) goto L5;
        return;
    L5:
        if (f276423i == true) goto L7;
        return;
    }

    public static void e(boolean r100) {
        f276421g = r100;
    }

    public static boolean e() {
        return f276420f;
    }

    public static void f(String r100) {
        f276416b = r100;
    }

    public static void f(boolean r100) {
        f276423i = r100;
        if (r100 == false) goto L5;
        boolean r101 = true;
    L6:
        f276417c = r101;
        f276419e = r101;
        f276418d = r101;
        f276420f = r101;
        f276421g = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static boolean f() {
        return f276421g;
    }

    public static void g(String r100) {
        f276422h = r100;
    }

    public static boolean g() {
        return f276423i;
    }

    public static String h() {
        return f276422h;
    }
}
