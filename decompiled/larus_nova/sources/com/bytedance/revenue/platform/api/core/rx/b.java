package com.bytedance.revenue.platform.api.core.rx;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<T> f267508a;

    @Override // com.bytedance.revenue.platform.api.core.rx.a
    public final T getValue() {
        return this.f267508a.getValue();
    }

    public b(Observable<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "upstream");
        int r101 = c.f267509a;
        BehaviorSubject<T> r102 = BehaviorSubject.create();
        this.f267508a = r102;
        r100.subscribe(r102);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f267508a.subscribe(r100);
    }
}
