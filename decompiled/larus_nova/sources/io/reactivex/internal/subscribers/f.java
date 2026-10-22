package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
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
public final class f<T> extends CountDownLatch implements io.reactivex.g<T>, Future<T>, wwc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f495026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f495027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<wwc.c> f495028c;

    public f() {
        super(1);
        this.f495028c = new AtomicReference();
    }

    @Override // wwc.c
    public final void cancel() {
    }

    @Override // wwc.c
    public final void request(long r100) {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        if (this.f495028c.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // wwc.b
    public final void onComplete() {
        if (this.f495026a != null) goto L6;
        onError(new NoSuchElementException("The source is empty"));
        return;
    L6:
        wwc.c r100 = this.f495028c.get();
        if (r100 == this) goto L30;
        if (r100 == SubscriptionHelper.CANCELLED) goto L31;
        AtomicReference<wwc.c> r101 = this.f495028c;
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
        Throwable r100 = this.f495027b;
        if (r100 != null) goto L12;
        return this.f495026a;
    L12:
        throw new ExecutionException(r100);
    L14:
        throw new CancellationException();
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
        wwc.c r101 = this.f495028c.get();
        boolean r102 = false;
        if (r101 == this) goto L18;
        SubscriptionHelper r103 = SubscriptionHelper.CANCELLED;
        if (r101 == r103) goto L18;
        AtomicReference<wwc.c> r104 = this.f495028c;
    L9:
        if (r104.compareAndSet(r101, r103) == true) goto L10;
        if (r104.get() == r101) goto L9;
    L13:
        if (r102 == false) goto L2;
        if (r101 == null) goto L16;
        r101.cancel();
    L16:
        countDown();
        return true;
    L10:
        r102 = true;
    L18:
        return false;
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
    L2:
        wwc.c r101 = this.f495028c.get();
        if (r101 == this) goto L17;
        if (r101 == SubscriptionHelper.CANCELLED) goto L17;
        this.f495027b = r100;
        AtomicReference<wwc.c> r102 = this.f495028c;
    L9:
        if (r102.compareAndSet(r101, this) == true) goto L10;
        if (r102.get() == r101) goto L9;
        boolean r103 = false;
    L14:
        if (r103 == false) goto L2;
        countDown();
        return;
    L10:
        r103 = true;
    L17:
        RxJavaPlugins.onError(r100);
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        if (this.f495026a == null) goto L6;
        this.f495028c.get().cancel();
        onError(new IndexOutOfBoundsException("More than one element received"));
        return;
    L6:
        this.f495026a = r100;
    }

    @Override // io.reactivex.g, wwc.b
    public final void onSubscribe(wwc.c r100) {
        SubscriptionHelper.setOnce(this.f495028c, r100, Long.MAX_VALUE);
    }

    @Override // java.util.concurrent.Future
    public final T get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() == 0) goto L10;
        io.reactivex.internal.util.c.b();
        if (await(r100, r101) == true) goto L10;
        throw new TimeoutException(ExceptionHelper.c(r100, r101));
    L10:
        if (isCancelled() == true) goto L18;
        Throwable r102 = this.f495027b;
        if (r102 != null) goto L16;
        return this.f495026a;
    L16:
        throw new ExecutionException(r102);
    L18:
        throw new CancellationException();
    }
}
