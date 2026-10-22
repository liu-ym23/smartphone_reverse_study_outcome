package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nc5.a<Result<?>> f227666a;

    public b(nc5.a<Result<?>> r100) {
        this.f227666a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result<?> r101 = (Result) r100;
        nc5.a<Result<?>> r102 = this.f227666a;
        Intrinsics.checkNotNull(r101);
        r102.onSuccess(r101);
    }
}
