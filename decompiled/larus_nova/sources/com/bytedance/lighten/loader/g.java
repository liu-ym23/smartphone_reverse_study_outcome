package com.bytedance.lighten.loader;

import com.facebook.common.executors.ConstrainedExecutorService;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes20.dex */
public final class g extends ConstrainedExecutorService {
    public g(Executor r100) {
        super("FixSizeSerialExecutor", 1, r100, new FrameBlockingQueue(10));
    }

    @Override // com.facebook.common.executors.ConstrainedExecutorService, java.util.concurrent.Executor
    public final synchronized void execute(Runnable r100) {
        monitor-enter(this);
        super.execute(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
