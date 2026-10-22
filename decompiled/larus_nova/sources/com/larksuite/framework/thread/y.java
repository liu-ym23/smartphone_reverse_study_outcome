package com.larksuite.framework.thread;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes24.dex */
public final class y<V> implements ScheduledFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture<?> f285816a;

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        return (V) this.f285816a.get();
    L7:
        ThreadMethodProxy.currentThread().interrupt();
        e = null;
    L10:
        if (e == null) goto L12;
        a.c().b(e);
    L12:
        return null;
    L8:
        e = move-exception;
        e = e.getCause();
    L5:
        e = e;
        goto L10
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f285816a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f285816a.isDone();
    }

    public y(ScheduledFuture<?> r100) {
        this.f285816a = r100;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r100) {
        return this.f285816a.cancel(r100);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed r100) {
        ScheduledFuture<?> r101 = this.f285816a;
        return r101.compareTo(r100);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit r100) {
        return this.f285816a.getDelay(r100);
    }

    @Override // java.util.concurrent.Future
    public final V get(long r100, TimeUnit r101) throws ExecutionException, InterruptedException, TimeoutException {
        return (V) this.f285816a.get(r100, r101);
    L7:
        ThreadMethodProxy.currentThread().interrupt();
        e = null;
    L10:
        if (e == null) goto L12;
        a.c().b(e);
    L12:
        return null;
    L8:
        e = move-exception;
        e = e.getCause();
    L5:
        e = e;
        goto L10
    }
}
