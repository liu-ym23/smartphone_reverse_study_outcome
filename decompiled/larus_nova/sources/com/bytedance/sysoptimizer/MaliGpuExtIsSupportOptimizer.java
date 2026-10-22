package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class MaliGpuExtIsSupportOptimizer {
    private static final String TAG = "MaliGpuExtIsSupportOpt";
    private static boolean sOptimized;

    public MaliGpuExtIsSupportOptimizer() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(MaliGpuExtIsSupportOptimizer.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L10;
        monitor-exit(MaliGpuExtIsSupportOptimizer.class);
        return;
    L10:
        if (Build.VERSION.SDK_INT == 21) goto L14;
        monitor-exit(MaliGpuExtIsSupportOptimizer.class);
        return;
    L14:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L24;
    L16:
        monitor-exit(MaliGpuExtIsSupportOptimizer.class);
        return;
    L24:
        optimize();     // Catch: Throwable -> L21 Throwable -> L18
        sOptimized = true;     // Catch: Throwable -> L21 Throwable -> L18
        goto L16
    }
}
