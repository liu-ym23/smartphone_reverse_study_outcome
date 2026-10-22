package com.larksuite.framework.thread;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes24.dex */
public final class x<V> implements Future<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<?> f285815a;

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        return (V) this.f285815a.get();
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
        return this.f285815a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f285815a.isDone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(Future<V> r100) {
        this.f285815a = r100;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r100) {
        return this.f285815a.cancel(r100);
    }

    @Override // java.util.concurrent.Future
    public final V get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) this.f285815a.get(r100, r101);
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
