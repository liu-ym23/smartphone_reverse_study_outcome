package com.bytedance.common.jato.boost.sched;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.common.jato.JatoXL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class PriorityManager {
    private static Map<Integer, Integer> curPriorityMap = null;
    private static volatile boolean isAlreadyPromote = false;
    private static boolean isStartFetchAndPromote = false;
    private static volatile int renderThreadTid = -1;

    /* JADX INFO: renamed from: com.bytedance.common.jato.boost.sched.PriorityManager$1, reason: invalid class name */
    public class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ Application val$application;
        final /* synthetic */ int val$priority;
        final /* synthetic */ ExecutorService val$singleThreadExecutor;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
            this.val$application.unregisterActivityLifecycleCallbacks(this);
            this.val$singleThreadExecutor.execute(new RunnableC29501(this));
        }

        public AnonymousClass1(Application r100, ExecutorService r101, int r102) {
            this.val$application = r100;
            this.val$singleThreadExecutor = r101;
            this.val$priority = r102;
        }
    }

    static {
        curPriorityMap = new ConcurrentHashMap();
    }

    public static void resetPriority() {
        if (curPriorityMap.get(-1) != null) goto L5;
        return;
    L5:
        Process.setThreadPriority(0, curPriorityMap.get(-1).intValue());     // Catch: Throwable -> L7
        return;
    }

    public static synchronized void resetRenderThread() {
        monitor-enter(PriorityManager.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isAlreadyPromote == true) goto L7;
    L12:
        monitor-exit(PriorityManager.class);
        return;
    L7:
        if (renderThreadTid == (-1)) goto L12;
        JatoXL.resetPriority(renderThreadTid);     // Catch: Throwable -> L14
        isAlreadyPromote = false;     // Catch: Throwable -> L14
        monitor-exit(PriorityManager.class);
    }

    public static /* synthetic */ int access$002(int r100) {
        renderThreadTid = r100;
        return r100;
    }

    public static /* synthetic */ boolean access$102(boolean r100) {
        isAlreadyPromote = r100;
        return r100;
    }

    public static void resetPriority(int r100) {
        if (curPriorityMap.get(Integer.valueOf(r100)) != null) goto L5;
        return;
    L5:
        Process.setThreadPriority(r100, curPriorityMap.get(Integer.valueOf(r100)).intValue());     // Catch: Throwable -> L7
        return;
    }

    public static void setPriority(int r100) {
        setPriority(-1, r100);
    }

    public static void setPriority(int r100, int r101) {
        int r102 = 0;
        if (curPriorityMap.get(Integer.valueOf(r100)) != null) goto L8;
        if (r100 == (-1)) goto L6;
        int r103 = Process.getThreadPriority(r100);     // Catch: Throwable -> L13
    L7:
        r102 = r103;
        curPriorityMap.put(Integer.valueOf(r100), Integer.valueOf(r102));     // Catch: Throwable -> L13
        goto L8
    L6:
        r103 = Process.getThreadPriority(0);     // Catch: Throwable -> L13
    L8:
        if (r102 == r101) goto L15;
        if (r100 == (-1)) goto L11;
        Process.setThreadPriority(r100, r101);     // Catch: Throwable -> L13
        return;
    L11:
        Process.setThreadPriority(r101);     // Catch: Throwable -> L13
        return;
    L15:
        return;
    }

    public static synchronized void promoteRenderThread(Application r100, ExecutorService r101, int r102) {
        monitor-enter(PriorityManager.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isAlreadyPromote == true) goto L12;
        if (renderThreadTid == (-1)) goto L12;
        isAlreadyPromote = true;     // Catch: Throwable -> L22
        setPriority(renderThreadTid, r102);     // Catch: Throwable -> L22
        monitor-exit(PriorityManager.class);
        return;
    L12:
        if (JatoNativeLoader.loadLibrary() == true) goto L16;
        monitor-exit(PriorityManager.class);
        return;
    L16:
        if (isStartFetchAndPromote == false) goto L19;
        monitor-exit(PriorityManager.class);
        return;
    L19:
        isStartFetchAndPromote = true;     // Catch: Throwable -> L22
        r100.registerActivityLifecycleCallbacks(new AnonymousClass1(r100, r101, r102));     // Catch: Throwable -> L22
        monitor-exit(PriorityManager.class);
    }
}
