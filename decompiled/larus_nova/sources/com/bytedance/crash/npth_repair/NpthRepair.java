package com.bytedance.crash.npth_repair;

import android.content.Context;
import android.os.Build;
import kh4.a;

/* JADX INFO: loaded from: classes.dex */
public class NpthRepair {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f203318a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f203319b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f203320c = -1;

    public NpthRepair() {
    }

    private static native boolean nGetDebuggable();

    private static native int nInit(int r100, boolean r101);

    private static native void nSetDebuggable(boolean r100);

    public static synchronized int a(Context r100, boolean r101) {
        monitor-enter(NpthRepair.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (f203319b == false) goto L9;
        int r102 = f203320c;     // Catch: Throwable -> L25
        monitor-exit(NpthRepair.class);
        return r102;
    L9:
        a.f503457a = r101;     // Catch: Throwable -> L25
        f203319b = true;     // Catch: Throwable -> L25
        if (f203318a == false) goto L30;
    L12:
        boolean r103 = f203318a;     // Catch: Throwable -> L25
        if (r103 == true) goto L32;
        f203320c = -5;     // Catch: Throwable -> L25
    L22:
        int r104 = f203320c;     // Catch: Throwable -> L25
        monitor-exit(NpthRepair.class);
        return r104;
    L32:
        a.f503457a = r101;     // Catch: Throwable -> L19
        if (r103 == false) goto L17;
        nSetDebuggable(r101);     // Catch: Throwable -> L19
    L17:
        f203320c = nInit(Build.VERSION.SDK_INT, r101);     // Catch: Throwable -> L19
    L20:
        f203320c = -3;     // Catch: Throwable -> L25
        goto L22
    L30:
        com.bytedance.librarian.a.e("npth_repair", true, r100);     // Catch: Throwable -> L28
        f203318a = true;     // Catch: Throwable -> L28
        goto L12
    }
}
