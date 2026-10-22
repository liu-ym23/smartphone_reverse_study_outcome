package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.keva.Keva;

/* JADX INFO: loaded from: classes22.dex */
public class NativeAllocatorOptimizer {
    private static final String JEMALLOC_KEVA_REPO = "jemalloc_repo";
    private static final int KEVA_ININTED_FALSE = 1;
    private static final int KEVA_ININTED_TRUE = 2;
    private static final int KEVA_NO_TINITED = 0;
    private static final String KEY_IS_JEMALLOC_ALLOCATOR = "is_jemalloc_allocator";
    private static final String TAG = "NativeAllocator";
    private static boolean sIsInvoked;
    private static boolean sIsJemalloc;

    public NativeAllocatorOptimizer() {
    }

    private static native boolean do_jemalloc_decay_opt(int r100);

    private static native boolean do_jemalloc_purge();

    private static native boolean do_set_extra_graphic_buffer(int r100);

    private static native boolean do_set_gui_extra_graphic_buffer(int r100);

    private static native boolean do_shrink_native_thread(int r100);

    private static native boolean is_jemalloc_allocator();

    private static native boolean optimize(int r100);

    private static int getIsJemallocAllocatorFromKeva() {
        return Keva.getRepo(JEMALLOC_KEVA_REPO).getInt(KEY_IS_JEMALLOC_ALLOCATOR, 0);
    }

    public static boolean doJemallocPurge() {
        if (do_jemalloc_purge() == false) goto L6;
        return true;
    L6:
        return false;
    L11:
        return false;
    }

    public static boolean isJemallocAllocator(Context r100) {
        if (sIsInvoked == false) goto L7;
        return sIsJemalloc;
    L7:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L16;
    L14:
        return false;
    L16:
        if (is_jemalloc_allocator() == false) goto L11;
        sIsJemalloc = true;     // Catch: Throwable -> L15
    L12:
        sIsInvoked = true;     // Catch: Throwable -> L15
        return sIsJemalloc;
    L11:
        sIsJemalloc = false;     // Catch: Throwable -> L15
        goto L12
    }

    private static void setIsJemallocAllocatorToKeva(int r100) {
        Keva.getRepo(JEMALLOC_KEVA_REPO).storeInt(KEY_IS_JEMALLOC_ALLOCATOR, r100);
    }

    public static boolean doJemallocDecayOpt(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L11;
        return false;
    L11:
        if (do_jemalloc_decay_opt(r101) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public static boolean doSetExtraGraphicBuffer(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (do_set_extra_graphic_buffer(r101) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    L9:
        return false;
    }

    public static boolean doSetGUIExtraGraphicBuffer(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (do_set_gui_extra_graphic_buffer(r101) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    L9:
        return false;
    }

    public static boolean doShrinkNativeThread(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (do_shrink_native_thread(r101) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    L9:
        return false;
    }

    public static synchronized void optimize(Context r100, int r101) {
        monitor-enter(NativeAllocatorOptimizer.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L13;
    L7:
        monitor-exit(NativeAllocatorOptimizer.class);
        return;
    L13:
        optimize(r101);     // Catch: Throwable -> L12 Throwable -> L9
        goto L7
    }
}
