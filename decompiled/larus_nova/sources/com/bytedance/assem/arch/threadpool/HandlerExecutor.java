package com.bytedance.assem.arch.threadpool;

import android.os.Handler;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class HandlerExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f193046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f193047b;

    public HandlerExecutor() {
        this.f193046a = LazyKt.lazy(HandlerExecutor$thread$2.INSTANCE);
        this.f193047b = LazyKt.lazy(new HandlerExecutor$handler$2(this));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        ((Handler) this.f193047b.getValue()).post(r100);
    }
}
