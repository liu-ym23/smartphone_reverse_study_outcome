package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    public static <V> SettableFuture<V> create() {
        return new SettableFuture();
    }

    private SettableFuture() {
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(@ParametricNullness V r100) {
        return super.set(r100);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable r100) {
        return super.setException(r100);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setFuture(ListenableFuture<? extends V> r100) {
        return super.setFuture(r100);
    }
}
