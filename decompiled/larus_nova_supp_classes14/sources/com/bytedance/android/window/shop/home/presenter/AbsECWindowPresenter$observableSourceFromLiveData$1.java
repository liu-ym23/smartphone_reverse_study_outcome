package com.bytedance.android.window.shop.home.presenter;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AbsECWindowPresenter$observableSourceFromLiveData$1<T> implements ObservableSource {
    public final /* synthetic */ AbsECWindowPresenter a;
    public final /* synthetic */ zn.a b;

    public AbsECWindowPresenter$observableSourceFromLiveData$1(AbsECWindowPresenter r1, zn.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(final Observer<? super T> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Object r0 = this.b.getValue();
        if (r0 == null) goto L6;
        r3.onNext(r0);
        r3.onComplete();
        return;
    L6:
        this.a.y().post(new AnonymousClass1(this, r3));
    }
}
