package com.ss.bytertc.engine.handler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes40.dex */
public class AppExecutors {
    private static final AppExecutors INSTANCE = null;
    private final Executor mMainThread;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.handler.AppExecutors$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler;

        private MainThreadExecutor() {
            this.mainThreadHandler = new Handler(Looper.getMainLooper());
        }

        public /* synthetic */ MainThreadExecutor(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.mainThreadHandler.post(r100);
        }
    }

    static {
        INSTANCE = new AppExecutors(new MainThreadExecutor(null));
    }

    public static AppExecutors getInstance() {
        return INSTANCE;
    }

    public Executor mainThread() {
        return this.mMainThread;
    }

    private AppExecutors(Executor r100) {
        this.mMainThread = r100;
    }
}
