package com.facebook.common.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes22.dex */
public class DefaultSerialExecutorService extends ConstrainedExecutorService implements SerialExecutorService {
    public DefaultSerialExecutorService(Executor r100) {
        super("SerialExecutor", 1, r100, new LinkedBlockingQueue());
    }

    @Override // com.facebook.common.executors.ConstrainedExecutorService, java.util.concurrent.Executor
    public synchronized void execute(Runnable r100) {
        monitor-enter(this);
        super.execute(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
