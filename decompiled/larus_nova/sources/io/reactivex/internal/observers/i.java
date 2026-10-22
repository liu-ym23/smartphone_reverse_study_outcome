package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class i<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f492887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f492888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Disposable> f492889c;

    public i() {
        super(1);
        this.f492889c = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f492889c.get());
    }

    @Override // java.util.concurrent.Future
    public final T get() throws InterruptedException, ExecutionException {
        if (getCount() == 0) goto L6;
        io.reactivex.internal.util.c.b();
        await();
    L6:
        if (isCancelled() == true) goto L14;
        Throwable r100 = this.f492888b;
        if (r100 != null) goto L12;
        return this.f492887a;
    L12:
        throw new ExecutionException(r100);
    L14:
        throw new CancellationException();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        if (getCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r100) {
    L2:
        Disposable r101 = this.f492889c.get();
        boolean r102 = false;
        if (r101 == this) goto L18;
        DisposableHelper r103 = DisposableHelper.DISPOSED;
        if (r101 == r103) goto L18;
        AtomicReference<Disposable> r104 = this.f492889c;
    L9:
        if (r104.compareAndSet(r101, r103) == true) goto L10;
        if (r104.get() == r101) goto L9;
    L13:
        if (r102 == false) goto L2;
        if (r101 == null) goto L16;
        r101.dispose();
    L16:
        countDown();
        return true;
    L10:
        r102 = true;
    L18:
        return false;
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
    L2:
        Disposable r101 = this.f492889c.get();
        if (r101 == DisposableHelper.DISPOSED) goto L4;
        this.f492888b = r100;
        AtomicReference<Disposable> r102 = this.f492889c;
    L8:
        if (r102.compareAndSet(r101, this) == true) goto L9;
        if (r102.get() == r101) goto L8;
        boolean r103 = false;
    L13:
        if (r103 == false) goto L2;
        countDown();
        return;
    L9:
        r103 = true;
        goto L13
    L4:
        RxJavaPlugins.onError(r100);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        DisposableHelper.setOnce(this.f492889c, r100);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T r100) {
        Disposable r101 = this.f492889c.get();
        if (r101 != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        this.f492887a = r100;
        AtomicReference<Disposable> r102 = this.f492889c;
    L7:
        if (r102.compareAndSet(r101, this) == true) goto L11;
        if (r102.get() == r101) goto L7;
    L11:
        countDown();
    }

    @Override // java.util.concurrent.Future
    public final T get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() == 0) goto L10;
        io.reactivex.internal.util.c.b();
        if (await(r100, r101) == true) goto L10;
        throw new TimeoutException(ExceptionHelper.c(r100, r101));
    L10:
        if (isCancelled() == true) goto L18;
        Throwable r102 = this.f492888b;
        if (r102 != null) goto L16;
        return this.f492887a;
    L16:
        throw new ExecutionException(r102);
    L18:
        throw new CancellationException();
    }
}
