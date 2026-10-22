package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ nc5.a<Result<?>> a;

    public b(nc5.a<Result<?>> r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Result<?> r3 = (Result) r2;
        nc5.a<Result<?>> r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.onSuccess(r3);
    }
}
