package com.larksuite.framework.thread;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f285746h = 0;

    static {
        f285746h = Math.max(Runtime.getRuntime().availableProcessors() * 8, 64);
    }

    public d(BlockingQueue r100, n r110) {
        super(CoreThreadPool.DEFAULT_IO_POOLNAME, 1, f285746h, 30, r100, r110);
        this.f285798b = this.f285797a + "-IOExecutor";
    }
}
