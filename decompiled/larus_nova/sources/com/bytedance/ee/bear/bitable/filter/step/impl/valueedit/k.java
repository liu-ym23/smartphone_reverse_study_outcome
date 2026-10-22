package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class k<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T1, T2, R> f212000a = null;

    static {
        f212000a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        List r102 = (List) r100;
        LinkFilterValueEditViewHolder.LinkRecordOption[] r103 = (LinkFilterValueEditViewHolder.LinkRecordOption[]) r101;
        Intrinsics.checkNotNullParameter(r102, "original");
        Intrinsics.checkNotNullParameter(r103, "appended");
        return ArraysKt.toList(ArraysKt.plus(r103, r102));
    }
}
