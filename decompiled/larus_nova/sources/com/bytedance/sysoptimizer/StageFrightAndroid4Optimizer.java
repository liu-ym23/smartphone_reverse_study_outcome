package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class StageFrightAndroid4Optimizer {
    private static final String TAG = "StageFrightOptimizer";
    private static boolean mOptimized;

    public StageFrightAndroid4Optimizer() {
    }

    private static native boolean optimize();

    public static void fixStageFrightAndroid4(Context r100) {
        if (mOptimized == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        return;
    L9:
        if (loadOptimizerOnNeed(r100) == false) goto L15;
        optimize();     // Catch: UnsatisfiedLinkError -> L12
        mOptimized = true;     // Catch: UnsatisfiedLinkError -> L12
        return;
    L16:
        return;
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        return SysOptimizer.loadOptimizerLibrary(r100);
    }
}
