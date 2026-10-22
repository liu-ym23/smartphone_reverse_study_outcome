package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import com.bytedance.android.livesdk.gift.model.d3;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class o<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f252309a = null;

    static {
        f252309a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        d3 r101 = (d3) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Long.valueOf(r101.getSortStrategy());
    }
}
