package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;

/* JADX INFO: loaded from: classes22.dex */
public class JemallocAllocatorOptimizer {
    private static final String TAG = "JemallocAllocator";

    public JemallocAllocatorOptimizer() {
    }

    private static native boolean do_arena_chunk_hooks();

    private static native boolean do_arena_decay();

    private static native int do_arena_decay_time(long r100);

    private static native boolean do_arena_destroy();

    private static native int do_arena_dirty_decay_ms(long r100);

    private static native int do_arena_dss(String r100);

    private static native boolean do_arena_extent_hooks();

    private static native int do_arena_lg_dirty_mult(long r100);

    private static native int do_arena_muzzy_decay_ms(long r100);

    private static native boolean do_arena_purge();

    private static native boolean do_arena_reset();

    private static native int do_arena_retain_grow_limit(long r100);

    private static native int do_arenas_decay_time(long r100);

    private static native int do_arenas_dirty_decay_ms(long r100);

    private static native int do_arenas_lg_dirty_mult(long r100);

    private static native int do_arenas_muzzy_decay_ms(long r100);

    private static native boolean do_arenas_purge();

    private static native String do_get_arena_dss();

    private static native boolean do_get_boolean_option_value(String r100);

    private static native int do_get_integer_option_value(String r100);

    private static native boolean do_opt_retain(boolean r100);

    private static native int do_tcache_create();

    private static native boolean do_tcache_destroy(int r100);

    private static native boolean do_tcache_flush();

    private static native boolean do_thread_arena(int r100);

    private static native int do_thread_tcache_enabled(boolean r100);

    private static native boolean do_thread_tcache_flush();

    public static synchronized void getJemallocOptions(Context r100) {
        monitor-enter(JemallocAllocatorOptimizer.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        ByteHook.init();     // Catch: Throwable -> L9
        String.format("raw thread.arena is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("thread.arena"))});     // Catch: Throwable -> L9
        String.format("thread.tcache.enabled is %b\n", new Object[]{Boolean.valueOf(do_get_boolean_option_value("thread.tcache.enabled"))});     // Catch: Throwable -> L9
        String.format("arenas.narenas is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arenas.narenas"))});     // Catch: Throwable -> L9
        String.format("arena.<i>.lg_dirty_mult is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arena.0.lg_dirty_mult"))});     // Catch: Throwable -> L9
        String.format("arena.<i>.decay_time is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arena.0.decay_time"))});     // Catch: Throwable -> L9
        String.format("arena.<i>.dirty_decay_ms is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arena.0.dirty_decay_ms"))});     // Catch: Throwable -> L9
        String.format("arena.<i>.muzzy_decay_ms is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arena.0.muzzy_decay_ms"))});     // Catch: Throwable -> L9
        String.format("arena.<i>.retain_grow_limit is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arena.0.retain_grow_limit"))});     // Catch: Throwable -> L9
        String.format("arenas.lg_dirty_mult is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arenas.lg_dirty_mult"))});     // Catch: Throwable -> L9
        String.format("arenas.decay_time is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arenas.decay_time"))});     // Catch: Throwable -> L9
        String.format("arenas.dirty_decay_ms is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arenas.dirty_decay_ms"))});     // Catch: Throwable -> L9
        String.format("arenas.muzzy_decay_ms is %d\n", new Object[]{Integer.valueOf(do_get_integer_option_value("arenas.muzzy_decay_ms"))});     // Catch: Throwable -> L9
    L7:
        monitor-exit(JemallocAllocatorOptimizer.class);
    }

    public static synchronized void setJemallocOptions(Context r100) {
        monitor-enter(JemallocAllocatorOptimizer.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L13;
        ByteHook.init();     // Catch: Throwable -> L15
        do_thread_arena(0);     // Catch: Throwable -> L15
        if (do_thread_tcache_enabled(true) != 0) goto L9;
        do_thread_tcache_enabled(false);     // Catch: Throwable -> L15
    L9:
        do_thread_tcache_flush();     // Catch: Throwable -> L15
        int r101 = do_tcache_create();     // Catch: Throwable -> L15
        do_tcache_flush();     // Catch: Throwable -> L15
        if (r101 != 0) goto L12;
        do_tcache_destroy(r101);     // Catch: Throwable -> L15
    L12:
        do_arena_decay();     // Catch: Throwable -> L15
        do_arena_purge();     // Catch: Throwable -> L15
        do_arena_destroy();     // Catch: Throwable -> L15
        String.format("get jemalloc arena.<i>.dss, result: %s\n", new Object[]{do_get_arena_dss()});     // Catch: Throwable -> L15
        do_arena_dss("secondary");     // Catch: Throwable -> L15
        do_arena_lg_dirty_mult(1000);     // Catch: Throwable -> L15
        do_arena_decay_time(1000);     // Catch: Throwable -> L15
        do_arena_dirty_decay_ms(1000);     // Catch: Throwable -> L15
        do_arena_muzzy_decay_ms(1000);     // Catch: Throwable -> L15
        do_arena_retain_grow_limit(1048576);     // Catch: Throwable -> L15
        do_arena_extent_hooks();     // Catch: Throwable -> L15
        do_arena_chunk_hooks();     // Catch: Throwable -> L15
        do_arenas_lg_dirty_mult(1000);     // Catch: Throwable -> L15
        do_arenas_decay_time(1000);     // Catch: Throwable -> L15
        do_arenas_dirty_decay_ms(1000);     // Catch: Throwable -> L15
        do_arenas_muzzy_decay_ms(1000);     // Catch: Throwable -> L15
        do_arenas_purge();     // Catch: Throwable -> L15
    L13:
        monitor-exit(JemallocAllocatorOptimizer.class);
    }

    public static JemallocSettingResult doJemallocArenaDecayTime(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arena.0.decay_time");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arena.<i>.decay_time(ssize_t)", String.valueOf(r102), String.valueOf(r101), do_arena_decay_time(r101));
    L7:
        return new JemallocSettingResult("arena.<i>.decay_time(ssize_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocArenaDirtyDecayMs(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arena.0.dirty_decay_ms");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arena.<i>.dirty_decay_ms(ssize_t)", String.valueOf(r102), String.valueOf(r101), do_arena_dirty_decay_ms(r101));
    L7:
        return new JemallocSettingResult("arena.<i>.dirty_decay_ms(ssize_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocArenaDss(Context r100, String r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        return new JemallocSettingResult("arena.<i>.dss(const char*)", do_get_arena_dss(), r101, do_arena_dss(r101));
    L7:
        return new JemallocSettingResult("arena.<i>.dss(const char*)", "", r101, -1);
    }

    public static JemallocSettingResult doJemallocArenaLgDirtyMult(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arena.0.lg_dirty_mult");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arena.<i>.lg_dirty_mult(ssize_t)", String.valueOf(r102), String.valueOf(r101), do_arena_lg_dirty_mult(r101));
    L7:
        return new JemallocSettingResult("arena.<i>.lg_dirty_mult(ssize_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocArenaMuzzyDecayMs(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arena.0.muzzy_decay_ms");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arena.<i>.muzzy_decay_ms(ssize_t)", String.valueOf(r102), String.valueOf(r101), do_arena_muzzy_decay_ms(r101));
    L7:
        return new JemallocSettingResult("arena.<i>.muzzy_decay_ms(ssize_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocArenaRetainGrowLimit(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arena.0.retain_grow_limit");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arena.<i>.retain_grow_limit(size_t)", String.valueOf(r102), String.valueOf(r101), do_arena_retain_grow_limit(r101));
    L7:
        return new JemallocSettingResult("arena.<i>.retain_grow_limit(size_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocArenasDecayTime(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arenas.decay_time");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arenas.decay_time(ssize_t)", String.valueOf(r102), String.valueOf(r101), do_arenas_decay_time(r101));
    L7:
        return new JemallocSettingResult("arenas.decay_time(ssize_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocArenasDirtyDecayMs(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arenas.dirty_decay_ms");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arenas.dirty_decay_ms(ssize_t)", String.valueOf(r102), String.valueOf(r101), do_arenas_dirty_decay_ms(r101));
    L7:
        return new JemallocSettingResult("arenas.dirty_decay_ms(ssize_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocArenasLgDirtyMult(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arenas.lg_dirty_mult");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arenas.lg_dirty_mult(ssize_t)", String.valueOf(r102), String.valueOf(r101), do_arenas_lg_dirty_mult(r101));
    L7:
        return new JemallocSettingResult("arenas.lg_dirty_mult(ssize_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocArenasMuzzyDecayMs(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        int r102 = do_get_integer_option_value("arenas.muzzy_decay_ms");     // Catch: Throwable -> L8
        return new JemallocSettingResult("arenas.muzzy_decay_ms(ssize_t)", String.valueOf(r102), String.valueOf(r101), do_arenas_muzzy_decay_ms(r101));
    L7:
        return new JemallocSettingResult("arenas.muzzy_decay_ms(ssize_t)", "", String.valueOf(r101), -1);
    }

    public static JemallocSettingResult doJemallocThreadTcacheEnabled(Context r100, boolean r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        boolean r102 = do_get_boolean_option_value("thread.tcache.enabled");     // Catch: Throwable -> L8
        do_thread_tcache_enabled(r101);     // Catch: Throwable -> L8
        return new JemallocSettingResult("thread.tcache.enabled(bool)", String.valueOf(r102), String.valueOf(r101), 0);
    L7:
        return new JemallocSettingResult("thread.tcache.enabled", "", String.valueOf(r101), -1);
    }
}
