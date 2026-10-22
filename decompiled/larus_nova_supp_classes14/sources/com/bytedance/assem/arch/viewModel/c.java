package com.bytedance.assem.arch.viewModel;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Closeable, CoroutineScope {
    public final CoroutineContext a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        JobKt.cancel(this.a);
    }

    public final CoroutineContext getCoroutineContext() {
        return this.a;
    }

    public c(CoroutineContext r1) {
        this.a = r1;
    }
}
