package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T, R> f211988a = null;

    static {
        f211988a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        DateFilterValueEditViewHolder.DurationListResult r101 = (DateFilterValueEditViewHolder.DurationListResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getData();
    }
}
