package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;

/* JADX INFO: loaded from: classes.dex */
public class DvmSuspendTimeOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f203325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f203326b;

    public DvmSuspendTimeOpt() {
    }

    private static native int nSuspendTimeOpt();

    public static synchronized int a() {
        monitor-enter(DvmSuspendTimeOpt.class);
    L26:
        th = move-exception;
        throw th;
    L6:
        if (NpthRepair.f203320c != 0) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == true) goto L14;
        monitor-exit(DvmSuspendTimeOpt.class);
        return -1;
    L14:
        if (f203325a == false) goto L18;
        monitor-exit(DvmSuspendTimeOpt.class);
        return -2;
    L18:
        f203325a = true;     // Catch: Throwable -> L26
        f203326b = nSuspendTimeOpt();     // Catch: Throwable -> L21
    L23:
        int r101 = f203326b;     // Catch: Throwable -> L26
        monitor-exit(DvmSuspendTimeOpt.class);
        return r101;
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        f203326b = -4;     // Catch: Throwable -> L26
        goto L23
    L8:
        r100 = false;
        goto L9
    }
}
