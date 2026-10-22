package com.bytedance.sysoptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class LogVerbosityUtil {
    public LogVerbosityUtil() {
    }

    private static native void nOpen();

    public static void open() {
        if (SysOptimizer.loadOptimizerLibrary(null) == false) goto L6;
        nOpen();
        return;
    }
}
