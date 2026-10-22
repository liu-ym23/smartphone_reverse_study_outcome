package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class RedmiTypeFaceOptimizer {
    private static final String TAG = "RedmiTypeFaceOptimizer";
    private static boolean mOptimized;

    public RedmiTypeFaceOptimizer() {
    }

    private static native boolean optimize(boolean r100);

    public static void fixOnAndroidQ(Context r100) {
        fixOnAndroidQ(r100, false);
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static void fixOnAndroidQ(Context r100, boolean r101) {
        if (mOptimized == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT == 29) goto L9;
        return;
    L9:
        if (loadOptimizerOnNeed(r100) == false) goto L15;
        optimize(r101);     // Catch: UnsatisfiedLinkError -> L12
        mOptimized = true;     // Catch: UnsatisfiedLinkError -> L12
        return;
    L16:
        return;
    }
}
