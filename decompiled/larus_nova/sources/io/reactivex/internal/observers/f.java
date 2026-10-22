package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes41.dex */
public final class f<T> extends CountDownLatch implements SingleObserver<T>, io.reactivex.b, io.reactivex.k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f492876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f492877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f492878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f492879d;

    public f() {
        super(1);
    }

    public final void b() {
        this.f492879d = true;
        Disposable r100 = this.f492878c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final T a() {
        if (getCount() != 0) goto L15;
    L9:
        Throwable r100 = this.f492877b;
        if (r100 != null) goto L14;
        return this.f492876a;
    L14:
        throw ExceptionHelper.d(r100);
    L15:
        io.reactivex.internal.util.c.b();     // Catch: InterruptedException -> L6
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        b();
        throw ExceptionHelper.d(e);
    }

    @Override // io.reactivex.b
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        this.f492877b = r100;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        this.f492878c = r100;
        if (this.f492879d == false) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T r100) {
        this.f492876a = r100;
        countDown();
    }
}
