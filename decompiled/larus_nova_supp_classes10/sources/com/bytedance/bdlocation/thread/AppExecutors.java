package com.bytedance.bdlocation.thread;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class AppExecutors {
    private static volatile AppExecutors instance;
    private final Executor DISK_IO;
    private final ThreadPoolExecutor LBS_LIGHT_LOCATION_EXECUTOR;
    private final Executor MAIN_THREAD;
    private final Executor NETWORK_IO;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.thread.AppExecutors$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MainThreadExecutor implements Executor {
        private Handler mMainThreadHandler;

        private MainThreadExecutor() {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }

        public /* synthetic */ MainThreadExecutor(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r2) {
            this.mMainThreadHandler.post(r2);
        }
    }

    public static AppExecutors getInstance() {
        if (instance != null) goto L15;
        monitor-enter(AppExecutors.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new AppExecutors(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("/AppExecutors")), LocationFixedThreadPool.newFixedThreadPool(5), new MainThreadExecutor(null), LocationFixedThreadPool.newFixedThreadPool(3));     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppExecutors.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public boolean isMainThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public Executor diskIO() {
        return this.DISK_IO;
    }

    public ThreadPoolExecutor lbsLightLocationExecutor() {
        return this.LBS_LIGHT_LOCATION_EXECUTOR;
    }

    public Executor mainThread() {
        return this.MAIN_THREAD;
    }

    public Executor networkIO() {
        return this.NETWORK_IO;
    }

    private AppExecutors(Executor r1, Executor r2, Executor r3, ThreadPoolExecutor r4) {
        this.DISK_IO = r1;
        this.NETWORK_IO = r2;
        this.MAIN_THREAD = r3;
        this.LBS_LIGHT_LOCATION_EXECUTOR = r4;
    }
}
