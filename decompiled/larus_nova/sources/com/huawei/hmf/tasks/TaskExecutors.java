package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes23.dex */
public final class TaskExecutors {
    public static final TaskExecutors INSTANCE = null;
    public final ExecutorService mBackground;
    public final Executor mImmediate;
    public final Executor mUiThread;

    public static final class ImmediateExecutor implements Executor {
        public ImmediateExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            r100.run();
        }
    }

    static {
        INSTANCE = new TaskExecutors();
    }

    public TaskExecutors() {
        this.mBackground = a.a();
        this.mImmediate = new ImmediateExecutor();
        this.mUiThread = a.b();
    }

    public static ExecutorService background() {
        return INSTANCE.mBackground;
    }

    public static Executor immediate() {
        return INSTANCE.mImmediate;
    }

    public static Executor uiThread() {
        return INSTANCE.mUiThread;
    }
}
