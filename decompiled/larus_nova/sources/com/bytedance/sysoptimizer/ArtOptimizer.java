package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class ArtOptimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized;

    private ArtOptimizer() {
    }

    private static native boolean disableDumpOatFile(int r100);

    private static native boolean increaseSuspendTime(int r100);

    public static synchronized boolean disableDumpOatFileForANR(Context r100) {
        monitor-enter(ArtOptimizer.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L9;
        monitor-exit(ArtOptimizer.class);
        return true;
    L9:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L20
        if (r101 == 29) goto L12;
    L18:
        monitor-exit(ArtOptimizer.class);
        return false;
    L12:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L18;
        boolean r102 = disableDumpOatFile(r101);     // Catch: UnsatisfiedLinkError -> L16 Throwable -> L20
        mOptimized = r102;     // Catch: UnsatisfiedLinkError -> L16 Throwable -> L20
        monitor-exit(ArtOptimizer.class);
        return r102;
    L17:
        return false;
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        if (Build.VERSION.SDK_INT <= 23) goto L7;
        return false;
    L7:
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static synchronized boolean optSuspendTimeout(Context r100) {
        monitor-enter(ArtOptimizer.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L11;
        monitor-exit(ArtOptimizer.class);
        return true;
    L11:
        if (loadOptimizerOnNeed(r100) == true) goto L22;
        monitor-exit(ArtOptimizer.class);
        return false;
    L22:
        boolean r101 = increaseSuspendTime(Build.VERSION.SDK_INT);     // Catch: UnsatisfiedLinkError -> L15 Throwable -> L19
        mOptimized = r101;     // Catch: UnsatisfiedLinkError -> L15 Throwable -> L19
        monitor-exit(ArtOptimizer.class);
        return r101;
    L16:
        return false;
    }
}
