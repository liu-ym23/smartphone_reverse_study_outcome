package com.bytedance.sysoptimizer.allocatorx;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class JemallocExtend {
    private static final String TAG = "JemallocExtend";

    public JemallocExtend() {
    }

    private static native boolean art_extend_arena(int r100);

    private static native boolean extend_arena();

    private static native boolean extend_arena_specific(String r100, int r101);

    private static native boolean extend_arena_specific_2(String r100, int r101);

    private static native boolean extend_multi_arena_to_auto(int r100, int r101);

    private static native String get_jemalloc_stats();

    private static native boolean hwui_purge_control(int r100);

    private static native boolean other_core_libs_extend_arena(int r100);

    private static native boolean player_lib_extend_arena(int r100);

    private static native boolean renderthread_extend_arena();

    public static boolean extendArena(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (extend_arena() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Nullable
    public static String getJemallocStats(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        ByteHook.init();
        return get_jemalloc_stats();
    L12:
        return null;
    L7:
        return null;
    }

    public static boolean renderThreadExtendArena(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (renderthread_extend_arena() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean artThreadExtendArena(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (art_extend_arena(r101) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean hwuiPurgeCtl(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (hwui_purge_control(r101) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean otherCoreLibsExtendArena(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (other_core_libs_extend_arena(r101) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean playerExtendArena(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (player_lib_extend_arena(r101) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean extendArenaSpecific(Context r100, String r101, int r102) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L10;
        ByteHook.init();
        if (extend_arena_specific(r101, r102) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean extendArenaSpecific2(Context r100, String r101, int r102) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L10;
        ByteHook.init();
        if (extend_arena_specific_2(r101, r102) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean extendMultiArenaToAuto(Context r100, int r101, int r102) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (extend_multi_arena_to_auto(r101, r102) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
