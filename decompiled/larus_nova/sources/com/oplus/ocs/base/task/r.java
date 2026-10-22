package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public final class r implements Executor {
    public r() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        com.oplus.ocs.base.utils.d.a(r100);
        r100.run();
    }
}
