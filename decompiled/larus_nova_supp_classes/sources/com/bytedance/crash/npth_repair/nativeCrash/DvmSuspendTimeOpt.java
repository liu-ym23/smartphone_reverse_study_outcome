package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class DvmSuspendTimeOpt {
    public static boolean a;
    public static int b;

    public DvmSuspendTimeOpt() {
    }

    private static native int nSuspendTimeOpt();

    public static synchronized int a() {
        monitor-enter(DvmSuspendTimeOpt.class);
    L26:
        th = move-exception;
        throw th;
    L6:
        if (NpthRepair.c != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L14;
        monitor-exit(DvmSuspendTimeOpt.class);
        return -1;
    L14:
        if (a == false) goto L18;
        monitor-exit(DvmSuspendTimeOpt.class);
        return -2;
    L18:
        a = true;     // Catch: Throwable -> L26
        b = nSuspendTimeOpt();     // Catch: Throwable -> L21
    L23:
        int r2 = b;     // Catch: Throwable -> L26
        monitor-exit(DvmSuspendTimeOpt.class);
        return r2;
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        b = -4;     // Catch: Throwable -> L26
        goto L23
    L8:
        r1 = false;
        goto L9
    }
}
