package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<T, R> implements Observer<T>, vtc.e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<? super R> f492867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f492868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vtc.e<T> f492869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f492870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f492871e;

    @Override // vtc.j
    public void clear() {
        this.f492869c.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f492868b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f492868b.isDisposed();
    }

    @Override // vtc.j
    public final boolean isEmpty() {
        return this.f492869c.isEmpty();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f492870d == false) goto L5;
        return;
    L5:
        this.f492870d = true;
        this.f492867a.onComplete();
    }

    public a(Observer<? super R> r100) {
        this.f492867a = r100;
    }

    public final void b(Throwable r100) {
        Exceptions.throwIfFatal(r100);
        this.f492868b.dispose();
        onError(r100);
    }

    public final int d(int r100) {
        vtc.e<T> r101 = this.f492869c;
        if (r101 != null) goto L5;
        return 0;
    L5:
        if ((r100 & 4) != 0) goto L12;
        int r102 = r101.requestFusion(r100);
        if (r102 == 0) goto L9;
        this.f492871e = r102;
    L9:
        return r102;
    L12:
        return 0;
    }

    @Override // vtc.j
    public final boolean offer(R r100) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        if (this.f492870d == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.f492870d = true;
        this.f492867a.onError(r100);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        if (DisposableHelper.validate(this.f492868b, r100) == false) goto L9;
        this.f492868b = r100;
        if ((r100 instanceof vtc.e) == false) goto L7;
        this.f492869c = (vtc.e) r100;
    L7:
        this.f492867a.onSubscribe(this);
        return;
    }
}
