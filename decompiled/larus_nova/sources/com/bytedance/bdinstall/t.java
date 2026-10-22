package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f199790a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f0 f199791b;

    static {
        int r100 = i84.h.f488620b;
        f199790a = 4030291;
    }

    public static void a(String r100) {
        f0 r101 = f199791b;
        if (r101 == null) goto L6;
        r101.d("bdinstall# " + r100, null);
        return;
    }

    public static void b(String r100) {
        f0 r101 = f199791b;
        if (r101 == null) goto L6;
        r101.e("bdinstall# " + r100, null);
        return;
    }

    public static void d(String r100) {
        f0 r101 = f199791b;
        if (r101 == null) goto L6;
        r101.v("bdinstall# " + r100, null);
        return;
    }

    public static void e(Throwable r100) {
        f0 r101 = f199791b;
        if (r101 == null) goto L6;
        r101.e("U SHALL NOT PASS!", r100);
        return;
    }

    public static void c(String r100, Throwable r101) {
        f0 r102 = f199791b;
        if (r102 == null) goto L6;
        r102.e("bdinstall# " + r100, r101);
        return;
    }
}
