package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean> {
    public k() {
    }

    @Override // io.reactivex.functions.Function
    public final Boolean apply(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        if (r101.f241920h != 2) goto L5;
        boolean r102 = true;
    L7:
        return Boolean.valueOf(r102);
    L5:
        r102 = false;
        goto L7
    }
}
