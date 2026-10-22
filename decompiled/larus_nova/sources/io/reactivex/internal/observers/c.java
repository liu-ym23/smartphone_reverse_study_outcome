package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f492872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f492873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f492874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f492875d;

    public c() {
        super(1);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f492875d = true;
        Disposable r100 = this.f492874c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final T b() {
        if (getCount() != 0) goto L15;
    L9:
        Throwable r100 = this.f492873b;
        if (r100 != null) goto L14;
        return this.f492872a;
    L14:
        throw ExceptionHelper.d(r100);
    L15:
        io.reactivex.internal.util.c.b();     // Catch: InterruptedException -> L6
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        dispose();
        throw ExceptionHelper.d(e);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f492875d;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        this.f492874c = r100;
        if (this.f492875d == false) goto L6;
        r100.dispose();
        return;
    }
}
