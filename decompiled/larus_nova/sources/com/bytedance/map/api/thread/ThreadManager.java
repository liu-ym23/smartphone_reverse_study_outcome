package com.bytedance.map.api.thread;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes21.dex */
public class ThreadManager {
    private static volatile ThreadManager sInstance;
    private final Executor DISK_EXECUTOR;
    private final Executor MAIN_EXECUTOR;
    private final Executor NETWORK_EXECUTOR;

    /* JADX INFO: renamed from: com.bytedance.map.api.thread.ThreadManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MainThreadExecutor implements Executor {
        private Handler mMainHandler;

        private MainThreadExecutor() {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }

        public /* synthetic */ MainThreadExecutor(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.mMainHandler.post(r100);
        }
    }

    public static ThreadManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ThreadManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ThreadManager(PThreadExecutorsUtils.newFixedThreadPool(3, new DefaultThreadFactory("ThreadManager")), PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ThreadManager")), new MainThreadExecutor(null));     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean isMainThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public Executor getDiskThread() {
        return this.DISK_EXECUTOR;
    }

    public Executor getMainThread() {
        return this.MAIN_EXECUTOR;
    }

    public Executor getNetworkThread() {
        return this.NETWORK_EXECUTOR;
    }

    private ThreadManager(Executor r100, Executor r101, Executor r102) {
        this.NETWORK_EXECUTOR = r100;
        this.DISK_EXECUTOR = r101;
        this.MAIN_EXECUTOR = r102;
    }
}
