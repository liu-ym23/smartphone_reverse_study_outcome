package com.bytedance.ee.bear.bitable.baseadd.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f206984a = null;

    static {
        f206984a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SubmitRecordStatusResponse r101 = (SubmitRecordStatusResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getRecordStatus();
    }
}
