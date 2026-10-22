package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class p<T> implements io.reactivex.b, wwc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wwc.b<? super T> f492898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f492899b;

    @Override // wwc.c
    public final void request(long r100) {
    }

    @Override // wwc.c
    public final void cancel() {
        this.f492899b.dispose();
    }

    @Override // io.reactivex.b
    public final void onComplete() {
        this.f492898a.onComplete();
    }

    public p(wwc.b<? super T> r100) {
        this.f492898a = r100;
    }

    @Override // io.reactivex.b
    public final void onError(Throwable r100) {
        this.f492898a.onError(r100);
    }

    @Override // io.reactivex.b
    public final void onSubscribe(Disposable r100) {
        if (DisposableHelper.validate(this.f492899b, r100) == false) goto L6;
        this.f492899b = r100;
        this.f492898a.onSubscribe(this);
        return;
    }
}
