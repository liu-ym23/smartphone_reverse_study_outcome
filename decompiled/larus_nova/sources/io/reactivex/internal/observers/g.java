package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class g<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<? super T> f492880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer<? super Disposable> f492881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Action f492882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f492883d;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Disposable r100 = this.f492883d;
        DisposableHelper r101 = DisposableHelper.DISPOSED;
        if (r100 == r101) goto L13;
        this.f492883d = r101;
        this.f492882c.run();     // Catch: Throwable -> L7
    L9:
        r100.dispose();
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        goto L9
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f492883d.isDisposed();
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        Disposable r100 = this.f492883d;
        DisposableHelper r101 = DisposableHelper.DISPOSED;
        if (r100 == r101) goto L6;
        this.f492883d = r101;
        this.f492880a.onComplete();
        return;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Disposable r101 = this.f492883d;
        DisposableHelper r102 = DisposableHelper.DISPOSED;
        if (r101 == r102) goto L5;
        this.f492883d = r102;
        this.f492880a.onError(r100);
        return;
    L5:
        RxJavaPlugins.onError(r100);
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        this.f492880a.onNext(r100);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        this.f492881b.accept(r100);     // Catch: Throwable -> L7
        if (DisposableHelper.validate(this.f492883d, r100) == false) goto L12;
        this.f492883d = r100;
        this.f492880a.onSubscribe(this);
        return;
    L12:
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r100.dispose();
        this.f492883d = DisposableHelper.DISPOSED;
        EmptyDisposable.error(th, this.f492880a);
    }

    public g(Observer<? super T> r100, Consumer<? super Disposable> r101, Action r102) {
        this.f492880a = r100;
        this.f492881b = r101;
        this.f492882c = r102;
    }
}
