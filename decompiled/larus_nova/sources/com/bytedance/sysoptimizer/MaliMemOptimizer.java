package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;

/* JADX INFO: loaded from: classes22.dex */
public class MaliMemOptimizer {
    private static final String TAG = "MaliMemOptimizer";
    private static volatile boolean hasEnableEglSetDamageRegionKHRErrorSkip;
    private static volatile boolean hasEnableMaliGLErrorRegionSpaceSkip;
    private static volatile boolean hasEnableMaliGLErrorSkip;
    private static volatile boolean hasSetTimeMillsDelayed;

    private MaliMemOptimizer() {
    }

    private static native void enable_egl_set_damage_region_khr_error_skip(boolean r100);

    private static native void enable_gl_error_region_space_skip();

    private static native void enable_gl_error_skip(boolean r100);

    private static native void set_time_mills_delayed(int r100, int r101);

    public static synchronized void enableMaliGLErrorRegionSpaceSkip(Context r100) {
        monitor-enter(MaliMemOptimizer.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (hasEnableMaliGLErrorRegionSpaceSkip == false) goto L9;
        monitor-exit(MaliMemOptimizer.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L18;
        ByteHook.init();     // Catch: Throwable -> L21
        enable_gl_error_region_space_skip();     // Catch: NoSuchMethodError -> L13 UnsatisfiedLinkError -> L15 Throwable -> L21
    L14:
        return;
    L16:
        return;
    L18:
        hasEnableMaliGLErrorRegionSpaceSkip = true;     // Catch: Throwable -> L21
        monitor-exit(MaliMemOptimizer.class);
    }

    public static synchronized void enableEglSetDamageRegionKHRErrorSkip(Context r100, boolean r101) {
        monitor-enter(MaliMemOptimizer.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (hasEnableEglSetDamageRegionKHRErrorSkip == false) goto L9;
        monitor-exit(MaliMemOptimizer.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L18;
        ByteHook.init();     // Catch: Throwable -> L21
        enable_egl_set_damage_region_khr_error_skip(r101);     // Catch: NoSuchMethodError -> L13 UnsatisfiedLinkError -> L15 Throwable -> L21
    L14:
        return;
    L16:
        return;
    L18:
        hasEnableEglSetDamageRegionKHRErrorSkip = true;     // Catch: Throwable -> L21
        monitor-exit(MaliMemOptimizer.class);
    }

    public static synchronized void enableMaliGLErrorSkip(Context r100, boolean r101) {
        monitor-enter(MaliMemOptimizer.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (hasEnableMaliGLErrorSkip == false) goto L9;
        monitor-exit(MaliMemOptimizer.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L18;
        ByteHook.init();     // Catch: Throwable -> L21
        enable_gl_error_skip(r101);     // Catch: NoSuchMethodError -> L13 UnsatisfiedLinkError -> L15 Throwable -> L21
    L14:
        return;
    L16:
        return;
    L18:
        hasEnableMaliGLErrorSkip = true;     // Catch: Throwable -> L21
        monitor-exit(MaliMemOptimizer.class);
    }

    public static synchronized void setTimeMillsDelayed(int r100, int r101, Context r102) {
        monitor-enter(MaliMemOptimizer.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (hasSetTimeMillsDelayed == false) goto L8;
        monitor-exit(MaliMemOptimizer.class);
        return;
    L8:
        ByteHook.init();     // Catch: Throwable -> L11
        SysOptimizer.loadOptimizerLibrary(r102);     // Catch: Throwable -> L11
        set_time_mills_delayed(r100, r101);     // Catch: Throwable -> L11
        hasSetTimeMillsDelayed = true;     // Catch: Throwable -> L11
        monitor-exit(MaliMemOptimizer.class);
    }
}
