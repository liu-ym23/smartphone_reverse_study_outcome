package com.bytedance.sysoptimizer.jarvis;

import android.content.Context;
import android.os.Build;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class BlastPreloader {
    public BlastPreloader() {
    }

    private static native void nativePreloadAndPrepare();

    public static void preload(Context r100) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        nativePreloadAndPrepare();
        return;
    }
}
