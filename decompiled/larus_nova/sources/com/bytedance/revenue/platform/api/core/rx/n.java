package com.bytedance.revenue.platform.api.core.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n<T> extends k<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f267517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<T, T, T> f267518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<T> f267519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f267520d;

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.f267519c.onComplete();
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f267519c.onError(r100);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f267519c.onSubscribe(r100);
    }

    @Override // com.bytedance.revenue.platform.api.core.rx.m
    public final T getValue() {
        return this.f267520d;
    }

    public final void a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        T r101 = this.f267518b.invoke(this.f267520d, r100);
        if (r101 == null) goto L6;
        this.f267520d = r101;
        this.f267519c.onNext(r101);
        return;
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        a(r100);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f267519c.subscribe(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(T r100, Function2<? super T, ? super T, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "initialValue");
        Intrinsics.checkNotNullParameter(r101, "onChange");
        PublishSubject<T> r102 = PublishSubject.create();
        this.f267517a = r100;
        this.f267518b = r101;
        this.f267519c = r102;
        this.f267520d = r100;
    }
}
