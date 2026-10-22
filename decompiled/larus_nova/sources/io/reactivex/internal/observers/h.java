package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class h<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f492884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f492885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Disposable> f492886c;

    public h() {
        super(1);
        this.f492886c = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f492886c.get());
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.f492884a != null) goto L6;
        onError(new NoSuchElementException("The source is empty"));
        return;
    L6:
        Disposable r100 = this.f492886c.get();
        if (r100 == this) goto L30;
        if (r100 == DisposableHelper.DISPOSED) goto L31;
        AtomicReference<Disposable> r101 = this.f492886c;
    L13:
        if (r101.compareAndSet(r100, this) == true) goto L14;
        if (r101.get() == r100) goto L13;
        boolean r102 = false;
    L18:
        if (r102 == false) goto L6;
        countDown();
        return;
    L14:
        r102 = true;
        goto L18
    L31:
        return;
    }

    @Override // java.util.concurrent.Future
    public final T get() throws InterruptedException, ExecutionException {
        if (getCount() == 0) goto L6;
        io.reactivex.internal.util.c.b();
        await();
    L6:
        if (isCancelled() == true) goto L14;
        Throwable r100 = this.f492885b;
        if (r100 != null) goto L12;
        return this.f492884a;
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
        Disposable r101 = this.f492886c.get();
        boolean r102 = false;
        if (r101 == this) goto L18;
        DisposableHelper r103 = DisposableHelper.DISPOSED;
        if (r101 == r103) goto L18;
        AtomicReference<Disposable> r104 = this.f492886c;
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

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        if (this.f492885b != null) goto L22;
        this.f492885b = r100;
    L5:
        Disposable r101 = this.f492886c.get();
        if (r101 == this) goto L20;
        if (r101 == DisposableHelper.DISPOSED) goto L20;
        AtomicReference<Disposable> r102 = this.f492886c;
    L12:
        if (r102.compareAndSet(r101, this) == true) goto L13;
        if (r102.get() == r101) goto L12;
        boolean r103 = false;
    L17:
        if (r103 == false) goto L5;
        countDown();
        return;
    L13:
        r103 = true;
    L20:
        RxJavaPlugins.onError(r100);
        return;
    L22:
        RxJavaPlugins.onError(r100);
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        if (this.f492884a == null) goto L6;
        this.f492886c.get().dispose();
        onError(new IndexOutOfBoundsException("More than one element received"));
        return;
    L6:
        this.f492884a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        DisposableHelper.setOnce(this.f492886c, r100);
    }

    @Override // java.util.concurrent.Future
    public final T get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() == 0) goto L10;
        io.reactivex.internal.util.c.b();
        if (await(r100, r101) == true) goto L10;
        throw new TimeoutException(ExceptionHelper.c(r100, r101));
    L10:
        if (isCancelled() == true) goto L18;
        Throwable r102 = this.f492885b;
        if (r102 != null) goto L16;
        return this.f492884a;
    L16:
        throw new ExecutionException(r102);
    L18:
        throw new CancellationException();
    }
}
