package com.bytedance.android.shopping.orderlist.common.controller;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r<T> implements ObservableOnSubscribe {
    public final /* synthetic */ v a;

    public r(v r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "emitter");
        this.a.a();
        r2.onComplete();
    }
}
