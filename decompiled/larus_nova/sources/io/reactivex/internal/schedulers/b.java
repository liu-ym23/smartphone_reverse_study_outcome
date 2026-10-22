package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements Future<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Disposable f494955a;

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return false;
    }

    public b(Disposable r100) {
        this.f494955a = r100;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r100) {
        this.f494955a.dispose();
        return false;
    }
}
