package com.bytedance.assem.arch.viewModel;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Closeable, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f193082a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        JobKt.cancel(this.f193082a);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f193082a;
    }

    public c(CoroutineContext r100) {
        this.f193082a = r100;
    }
}
