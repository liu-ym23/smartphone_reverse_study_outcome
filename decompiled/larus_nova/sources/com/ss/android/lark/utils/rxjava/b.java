package com.ss.android.lark.utils.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Observer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Observer<Object> f444760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c<Object> f444761b;

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.f444760a.onComplete();
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f444760a.onError(new TracedException(r100, this.f444761b.f444762a));
    }

    @Override // io.reactivex.Observer
    public final void onNext(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        this.f444760a.onNext(r100);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f444760a.onSubscribe(r100);
    }

    public b(Observer<Object> r100, c<Object> r101) {
        this.f444760a = r100;
        this.f444761b = r101;
    }
}
