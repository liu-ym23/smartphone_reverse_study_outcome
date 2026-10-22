package io.ktor.utils.io.pool;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class d<T> implements e<T> {
    public d() {
    }

    @Override // io.ktor.utils.io.pool.e
    public void Rl(T r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
