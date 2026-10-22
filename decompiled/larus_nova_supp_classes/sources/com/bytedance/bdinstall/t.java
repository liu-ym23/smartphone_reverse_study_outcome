package com.bytedance.bdinstall;

import i84.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class t {
    public static final int a = 0;
    public static f0 b;

    static {
        int r0 = h.b;
        a = 4030291;
    }

    public static void a(String r3) {
        f0 r0 = b;
        if (r0 == null) goto L6;
        r0.d("bdinstall# " + r3, null);
        return;
    }

    public static void b(String r3) {
        f0 r0 = b;
        if (r0 == null) goto L6;
        r0.e("bdinstall# " + r3, null);
        return;
    }

    public static void d(String r3) {
        f0 r0 = b;
        if (r0 == null) goto L6;
        r0.v("bdinstall# " + r3, null);
        return;
    }

    public static void e(Throwable r2) {
        f0 r0 = b;
        if (r0 == null) goto L6;
        r0.e("U SHALL NOT PASS!", r2);
        return;
    }

    public static void c(String r3, Throwable r4) {
        f0 r0 = b;
        if (r0 == null) goto L6;
        r0.e("bdinstall# " + r3, r4);
        return;
    }
}
