package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class MTK_PVR_Optimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized;
    private static boolean sAlwaysCatchSIGSEGV;
    private static boolean sCatchSIGSEGV;

    public MTK_PVR_Optimizer() {
    }

    private static native void optimize();

    private static native void setCatchOption(boolean r100);

    public static synchronized void enable(Context r100) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L9;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L9:
        if (loadOptimizerOnNeed(r100) == true) goto L24;
    L18:
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L24:
        if (sAlwaysCatchSIGSEGV == false) goto L13;
    L16:
        boolean r101 = true;
    L17:
        setCatchOption(r101);     // Catch: UnsatisfiedLinkError -> L23 Throwable -> L20
        optimize();     // Catch: UnsatisfiedLinkError -> L23 Throwable -> L20
        mOptimized = true;     // Catch: UnsatisfiedLinkError -> L23 Throwable -> L20
        goto L18
    L13:
        if (sCatchSIGSEGV == true) goto L16;
        r101 = false;
        goto L17
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 23) goto L5;
        return false;
    L5:
        if (r101 <= 29) goto L8;
        return false;
    L8:
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static synchronized void setAlwaysCatchSIGSEGV(boolean r100) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sAlwaysCatchSIGSEGV != r100) goto L8;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L8:
        sAlwaysCatchSIGSEGV = r100;     // Catch: Throwable -> L19
        if (mOptimized == false) goto L17;
        if (r100 == false) goto L12;
    L15:
        boolean r101 = true;
    L16:
        setCatchOption(r101);     // Catch: Throwable -> L19
        goto L17
    L12:
        if (sCatchSIGSEGV == true) goto L15;
        r101 = false;
    L17:
        monitor-exit(MTK_PVR_Optimizer.class);
    }

    public static synchronized void setCatchSIGSEGV(boolean r100) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sCatchSIGSEGV != r100) goto L8;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L8:
        sCatchSIGSEGV = r100;     // Catch: Throwable -> L19
        if (mOptimized == true) goto L11;
    L17:
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L11:
        if (sAlwaysCatchSIGSEGV == true) goto L15;
        if (r100 == true) goto L15;
        boolean r101 = false;
    L16:
        setCatchOption(r101);     // Catch: Throwable -> L19
    L15:
        r101 = true;
        goto L16
    }
}
