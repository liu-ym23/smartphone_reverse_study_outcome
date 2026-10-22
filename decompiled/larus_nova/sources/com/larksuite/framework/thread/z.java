package com.larksuite.framework.thread;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes24.dex */
public final class z extends p {
    public z(BlockingQueue r100, n r110) {
        super("reject", 3, 3, 10, r100, r110);
        allowCoreThreadTimeOut(true);
        this.f285798b = this.f285797a + "-CPUExecutor";
    }
}
