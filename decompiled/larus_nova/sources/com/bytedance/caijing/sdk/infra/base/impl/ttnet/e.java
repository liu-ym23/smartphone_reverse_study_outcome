package com.bytedance.caijing.sdk.infra.base.impl.ttnet;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Executor {
    public e() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        r100.run();
    }
}
