package com.bytedance.ee.bear.bitable.baseadd.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T, R> f206985a = null;

    static {
        f206985a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SubmitRecordResponse r101 = (SubmitRecordResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getRecordData();
    }
}
