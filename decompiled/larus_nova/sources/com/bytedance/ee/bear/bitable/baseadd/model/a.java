package com.bytedance.ee.bear.bitable.baseadd.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f206983a = null;

    static {
        f206983a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        CascadeResponse r101 = (CascadeResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getList();
    }
}
