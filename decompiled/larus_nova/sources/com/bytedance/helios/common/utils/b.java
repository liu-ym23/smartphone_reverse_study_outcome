package com.bytedance.helios.common.utils;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f245391a;

    public b(Handler r100) {
        this.f245391a = r100;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if (this.f245391a.post(r100) == false) goto L6;
        return;
    L6:
        throw new RejectedExecutionException(this.f245391a + " is shutting down");
    }
}
