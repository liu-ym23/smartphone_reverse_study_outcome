package com.hihonor.mcs.system.diagnosis.core;

import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f276640a;

    public a(Handler r100) {
        Objects.requireNonNull(r100);
        this.f276640a = r100;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if (this.f276640a.post(r100) == false) goto L6;
        return;
    L6:
        throw new RejectedExecutionException(this.f276640a + " is shutting down");
    }
}
