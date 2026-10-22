package com.bytedance.android.window.shop.home.tab.presenter;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowTabPresenter$observableSourceFromLiveData$1<T> implements ObservableSource {
    public final /* synthetic */ ECWindowTabPresenter a;
    public final /* synthetic */ zn.a b;
    public final /* synthetic */ Function1 c;

    public ECWindowTabPresenter$observableSourceFromLiveData$1(ECWindowTabPresenter r1, zn.a r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(final Observer<? super T> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Object r0 = this.b.getValue();
        if (r0 == null) goto L6;
        Object r1 = this.c.invoke(r0);
        Intrinsics.checkNotNull(r1);
        r3.onNext(r1);
        r3.onComplete();
        return;
    L6:
        ECWindowTabPresenter r2 = this.a;
        int r4 = ECWindowTabPresenter.C;
        r2.a0().post(new AnonymousClass1(this, r3));
    }
}
