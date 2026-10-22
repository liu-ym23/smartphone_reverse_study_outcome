package com.bytedance.badger.network;

import com.bytedance.badger.e;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 implements RejectedExecutionHandler {
    public x0() {
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
        e.e("BadgerReportThreadPool", "Task rejected: " + r100 + ", Active: " + r101.getActiveCount() + ", Queue: " + r101.getQueue().size());
        throw new RejectedExecutionException("Task " + r100 + " rejected from " + r101);
    }
}
