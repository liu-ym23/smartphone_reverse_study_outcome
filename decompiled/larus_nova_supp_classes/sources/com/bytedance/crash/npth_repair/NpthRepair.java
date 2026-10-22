package com.bytedance.crash.npth_repair;

import android.content.Context;
import android.os.Build;
import kh4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class NpthRepair {
    public static boolean a = false;
    public static boolean b = false;
    public static int c = -1;

    public NpthRepair() {
    }

    private static native boolean nGetDebuggable();

    private static native int nInit(int r0, boolean r1);

    private static native void nSetDebuggable(boolean r0);

    public static synchronized int a(Context r3, boolean r4) {
        monitor-enter(NpthRepair.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (b == false) goto L9;
        int r5 = c;     // Catch: Throwable -> L25
        monitor-exit(NpthRepair.class);
        return r5;
    L9:
        a.a = r4;     // Catch: Throwable -> L25
        b = true;     // Catch: Throwable -> L25
        if (a == false) goto L30;
    L12:
        boolean r6 = a;     // Catch: Throwable -> L25
        if (r6 == true) goto L32;
        c = -5;     // Catch: Throwable -> L25
    L22:
        int r7 = c;     // Catch: Throwable -> L25
        monitor-exit(NpthRepair.class);
        return r7;
    L32:
        a.a = r4;     // Catch: Throwable -> L19
        if (r6 == false) goto L17;
        nSetDebuggable(r4);     // Catch: Throwable -> L19
    L17:
        c = nInit(Build.VERSION.SDK_INT, r4);     // Catch: Throwable -> L19
    L20:
        c = -3;     // Catch: Throwable -> L25
        goto L22
    L30:
        com.bytedance.librarian.a.e("npth_repair", true, r3);     // Catch: Throwable -> L28
        a = true;     // Catch: Throwable -> L28
        goto L12
    }
}
