package com.bytedance.assem.arch.threadpool;

import android.os.Handler;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HandlerExecutor implements Executor {
    public final Lazy a;
    public final Lazy b;

    public HandlerExecutor() {
        this.a = LazyKt.lazy(HandlerExecutor$thread$2.INSTANCE);
        this.b = LazyKt.lazy(new HandlerExecutor$handler$2(this));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r2) {
        ((Handler) this.b.getValue()).post(r2);
    }
}
