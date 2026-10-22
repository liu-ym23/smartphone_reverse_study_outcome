package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorListResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class q<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<T, R> f212020a = null;

    static {
        f212020a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ColorListResult r101 = (ColorListResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getColorList();
    }
}
