package com.bytedance.sysoptimizer.perflock;

import android.content.Context;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class TaskScheduler {
    public static final int GC_THREAD = 3;
    public static final int JIT_THREAD = 4;
    public static final int MAIN_THREAD = 1;
    public static final int RENDER_THREAD = 2;
    private static final String TAG = "TaskScheduler";
    private static volatile boolean sPopulated;

    public TaskScheduler() {
    }

    private static native boolean bind_task_core(String r100, int r101);

    private static native boolean do_concurrent_optimize(int r100, int r101);

    private static native void dump_data();

    private static native int get_thread_tid(String r100);

    private static native boolean native_populate(boolean r100);

    private static native boolean native_schedule_important_task(int r100, int r101, int r102);

    private static native boolean native_schedule_task(String r100, int r101, int r102);

    private static native boolean set_task_priority(String r100, int r101);

    private static native void unbind_task_core(String r100, boolean r101);

    public static boolean isDataPopulated() {
        return sPopulated;
    }

    public static synchronized void dump(Context r100) {
        monitor-enter(TaskScheduler.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sPopulated == false) goto L7;
        dump_data();     // Catch: Throwable -> L9
    L7:
        monitor-exit(TaskScheduler.class);
    }

    public static synchronized boolean populateDatas(Context r100) {
        monitor-enter(TaskScheduler.class);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L21;
    L13:
        monitor-exit(TaskScheduler.class);
        return false;
    L21:
        if (native_populate(false) == false) goto L10;
        sPopulated = true;     // Catch: Throwable -> L18 Throwable -> L15
    L10:
        boolean r101 = sPopulated;     // Catch: Throwable -> L18 Throwable -> L15
        monitor-exit(TaskScheduler.class);
        return r101;
        goto L13
    }

    public static synchronized boolean bindTaskCore(String r100, int r101) {
        monitor-enter(TaskScheduler.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sPopulated == false) goto L9;
        boolean r102 = bind_task_core(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(TaskScheduler.class);
        return r102;
    L9:
        monitor-exit(TaskScheduler.class);
        return false;
    }

    public static synchronized boolean doConcurrentOptimize(Context r100, int r101) {
        monitor-enter(TaskScheduler.class);
        boolean r102 = doConcurrentOptimize(r100, r101, -1);     // Catch: Throwable -> L8
        monitor-exit(TaskScheduler.class);
        return r102;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean populateDatas(Context r100, boolean r101) {
        monitor-enter(TaskScheduler.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L21;
    L12:
        monitor-exit(TaskScheduler.class);
        return false;
    L21:
        if (native_populate(r101) == false) goto L9;
        sPopulated = true;     // Catch: Throwable -> L18 Throwable -> L15
    L9:
        boolean r102 = sPopulated;     // Catch: Throwable -> L18 Throwable -> L15
        monitor-exit(TaskScheduler.class);
        return r102;
        goto L12
    }

    public static synchronized boolean setTaskPriority(String r100, int r101) {
        monitor-enter(TaskScheduler.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sPopulated == false) goto L9;
        boolean r102 = set_task_priority(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(TaskScheduler.class);
        return r102;
    L9:
        monitor-exit(TaskScheduler.class);
        return false;
    }

    public static synchronized void unbindTaskCore(String r100, boolean r101) {
        monitor-enter(TaskScheduler.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sPopulated == false) goto L7;
        unbind_task_core(r100, r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(TaskScheduler.class);
    }

    public static synchronized boolean doConcurrentOptimize(Context r100, int r101, int r102) {
        monitor-enter(TaskScheduler.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L18;
    L9:
        monitor-exit(TaskScheduler.class);
        return false;
    L18:
        boolean r103 = do_concurrent_optimize(r101, r102);     // Catch: Throwable -> L15 Throwable -> L12
        monitor-exit(TaskScheduler.class);
        return r103;
        goto L9
    }

    public static int getThreadTid(Context r100, String r101, boolean r102) {
        if (r102 == false) goto L7;
        if (sPopulated == true) goto L7;
        populateDatas(r100);
    L7:
        if (sPopulated == true) goto L9;
        return -1;
    L9:
        return get_thread_tid(r101);
    }

    public static synchronized boolean scheduleTask(String r100, int r101, int r102) {
        monitor-enter(TaskScheduler.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sPopulated == false) goto L9;
        boolean r103 = native_schedule_task(r100, r101, r102);     // Catch: Throwable -> L12
        monitor-exit(TaskScheduler.class);
        return r103;
    L9:
        monitor-exit(TaskScheduler.class);
        return false;
    }

    public static synchronized boolean scheduleImportantTask(Context r100, int r101, int r102, int r103) {
        monitor-enter(TaskScheduler.class);
        if (r101 != 1) goto L12;
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L23;
    L16:
        monitor-exit(TaskScheduler.class);
        return false;
    L23:
        boolean r104 = native_schedule_important_task(r101, r102, r103);     // Catch: Throwable -> L22 Throwable -> L19
        monitor-exit(TaskScheduler.class);
        return r104;
    L12:
        if (sPopulated == false) goto L16;
        boolean r105 = native_schedule_important_task(r101, r102, r103);     // Catch: Throwable -> L19
        monitor-exit(TaskScheduler.class);
        return r105;
    L19:
        th = move-exception;
        throw th;
    }
}
