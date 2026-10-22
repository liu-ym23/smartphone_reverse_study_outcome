package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class JitGetMethodHashOptimizer {
    private static final String TAG = "JitGetMethodHashOptimizer";
    private static boolean mOptimized;

    public JitGetMethodHashOptimizer() {
    }

    private static native boolean optimize();

    public static void fix(Context r100) {
        if (mOptimized == false) goto L6;
        return;
    L6:
        if (loadOptimizerOnNeed(r100) == false) goto L12;
        optimize();     // Catch: UnsatisfiedLinkError -> L9
        mOptimized = true;     // Catch: UnsatisfiedLinkError -> L9
        return;
    L13:
        return;
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        return SysOptimizer.loadOptimizerLibrary(r100);
    }
}
