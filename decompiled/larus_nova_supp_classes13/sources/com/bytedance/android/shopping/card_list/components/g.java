package com.bytedance.android.shopping.card_list.components;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final Function2<String, String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function2<? super String, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "putSkuRenderNodeKey");
        this.a = r2;
    }
}
