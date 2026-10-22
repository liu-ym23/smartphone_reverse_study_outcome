package com.bytedance.push.utils;

import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f267065a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f267066b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f267067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f267068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile ALog.p f267069e;

    static {
        new x67.a();
        f267068d = "";
    }

    public static void a(String r100) {
        b("", r100);
    }

    public static void d(String r100) {
        e("", r100);
    }

    public static void b(String r100, String r101) {
        if (f267067c == false) goto L9;
        if (f267069e == null) goto L7;
        f267069e.b(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L7:
        ALog.i(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L9:
        if (f267066b <= 3) goto L11;
        return;
    L11:
        if (f267065a == true) goto L13;
        return;
    }

    public static void e(String r100, String r101) {
        if (f267067c == false) goto L9;
        if (f267069e == null) goto L7;
        f267069e.a(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L7:
        ALog.e(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L9:
        if (f267066b <= 6) goto L11;
        return;
    L11:
        if (f267065a == true) goto L13;
        return;
    }

    public static void g(String r100, String r101) {
        if (f267067c == false) goto L9;
        if (f267069e == null) goto L7;
        f267069e.b(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L7:
        ALog.i(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L9:
        if (f267066b <= 4) goto L11;
        return;
    L11:
        if (f267065a == true) goto L13;
        return;
    }

    public static void h(String r100, String r101) {
        if (f267067c == false) goto L9;
        if (f267069e == null) goto L7;
        f267069e.b(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L7:
        ALog.i(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L9:
        if (f267066b <= 2) goto L11;
        return;
    L11:
        if (f267065a == true) goto L13;
        return;
    }

    public static void i(String r100, String r101) {
        if (f267067c == false) goto L9;
        if (f267069e == null) goto L7;
        f267069e.c(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L7:
        ALog.w(f267068d, r100 + "\t>>>\t" + r101);
        return;
    L9:
        if (f267066b <= 5) goto L11;
        return;
    L11:
        if (f267065a == true) goto L13;
        return;
    }

    public static void c(String r100, String r101, Throwable r102) {
        b(f267068d, r100 + "\t>>>\t" + r101 + r102.getMessage());
    }

    public static void f(String r100, String r101, Throwable r102) {
        e(f267068d, r100 + "\t>>>\t" + r101 + r102.getMessage());
    }
}
