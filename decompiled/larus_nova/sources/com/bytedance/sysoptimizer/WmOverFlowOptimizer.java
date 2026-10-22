package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class WmOverFlowOptimizer {
    private static final String TAG = "WmOverFlowOptimizer";
    private static boolean mOptimized;

    public WmOverFlowOptimizer() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(WmOverFlowOptimizer.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L8;
        monitor-exit(WmOverFlowOptimizer.class);
        return;
    L8:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L20
        if (r101 > 23) goto L11;
    L18:
        monitor-exit(WmOverFlowOptimizer.class);
        return;
    L11:
        if (r101 > 25) goto L18;
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L24;
    L16:
        monitor-exit(WmOverFlowOptimizer.class);
        return;
    L24:
        optimize();     // Catch: Throwable -> L23 Throwable -> L20
        mOptimized = true;     // Catch: Throwable -> L23 Throwable -> L20
        goto L16
    }
}
