package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class ImmediateFuture<V> implements ListenableFuture<V> {
    static final ListenableFuture<?> NULL = null;
    private static final Logger log = null;

    @ParametricNullness
    private final V value;

    public static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {

        @CheckForNull
        static final ImmediateCancelledFuture<Object> INSTANCE = null;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES == false) goto L5;
            ImmediateCancelledFuture<Object> r100 = null;
        L6:
            INSTANCE = r100;
            return;
        L5:
            r100 = new ImmediateCancelledFuture();
            goto L6
        }

        public ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    public static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        public ImmediateFailedFuture(Throwable r100) {
            setException(r100);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    static {
        NULL = new ImmediateFuture(null);
        log = Logger.getLogger(ImmediateFuture.class.getName());
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.value + "]]";
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get() {
        return this.value;
    }

    public ImmediateFuture(@ParametricNullness V r100) {
        this.value = r100;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r100, Executor r101) {
        com.google.common.base.m.l(r100, "Runnable was null.");
        com.google.common.base.m.l(r101, "Executor was null.");
        r101.execute(r100);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r100 + " with executor " + r101, e);
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get(long r100, TimeUnit r101) throws ExecutionException {
        r101.getClass();
        return get();
    }
}
