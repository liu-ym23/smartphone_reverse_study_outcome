package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T, R> f212003a = null;

    static {
        f212003a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        LinkFilterValueEditViewHolder.LinkRecordOptionListResult r101 = (LinkFilterValueEditViewHolder.LinkRecordOptionListResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getOptions();
    }
}
