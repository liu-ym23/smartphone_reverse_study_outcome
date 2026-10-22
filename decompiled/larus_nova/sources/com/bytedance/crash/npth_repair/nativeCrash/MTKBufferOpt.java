package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;

/* JADX INFO: loaded from: classes.dex */
public class MTKBufferOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f203327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f203328b;

    public MTKBufferOpt() {
    }

    private static native int nOptMTKBuffer(int r100);

    public static synchronized int a(int r100) {
        monitor-enter(MTKBufferOpt.class);
    L26:
        th = move-exception;
        throw th;
    L6:
        if (NpthRepair.f203320c != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L14;
        monitor-exit(MTKBufferOpt.class);
        return -1;
    L14:
        if (f203327a == false) goto L18;
        monitor-exit(MTKBufferOpt.class);
        return -2;
    L18:
        f203327a = true;     // Catch: Throwable -> L26
        f203328b = nOptMTKBuffer(r100);     // Catch: Throwable -> L21
    L23:
        int r102 = f203328b;     // Catch: Throwable -> L26
        monitor-exit(MTKBufferOpt.class);
        return r102;
    L22:
        f203328b = -4;     // Catch: Throwable -> L26
        goto L23
    L8:
        r101 = false;
        goto L9
    }
}
