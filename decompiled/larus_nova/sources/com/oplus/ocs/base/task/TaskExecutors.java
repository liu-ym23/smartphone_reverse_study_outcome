package com.oplus.ocs.base.task;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public class TaskExecutors {
    public static final Executor CURRENT_THREAD = null;
    public static final Executor MAIN_THREAD = null;

    public static class MainExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f404256a;

        public MainExecutor() {
            this.f404256a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            com.oplus.ocs.base.utils.d.a(r100);
            this.f404256a.post(r100);
        }
    }

    static {
        MAIN_THREAD = new MainExecutor();
        CURRENT_THREAD = new r();
    }

    private TaskExecutors() {
    }
}
