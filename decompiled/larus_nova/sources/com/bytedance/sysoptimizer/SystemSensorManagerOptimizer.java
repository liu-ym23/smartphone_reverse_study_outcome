package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class SystemSensorManagerOptimizer {
    private static final String TAG = "SSMO";
    private static boolean sOptimized;

    public SystemSensorManagerOptimizer() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(SystemSensorManagerOptimizer.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L9;
        monitor-exit(SystemSensorManagerOptimizer.class);
        return;
    L9:
        if (Build.VERSION.SDK_INT == 23) goto L11;
    L13:
        monitor-exit(SystemSensorManagerOptimizer.class);
        return;
    L11:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L13;
        optimize();     // Catch: Throwable -> L18 Throwable -> L15
        sOptimized = true;     // Catch: Throwable -> L18 Throwable -> L15
        goto L13
    }
}
