package com.bytedance.android.shopping.collect.slice;

import com.bytedance.android.shopping.collect.slice.widgets.ProductCardContainerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final Function0<ProductCardContainerView> a;
    public final Function1<ProductCardContainerView, Unit> b;
    public final Function0<ProductCardContainerView> c;
    public final Function1<ProductCardContainerView, Unit> d;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<ProductCardContainerView> r2, Function1<? super ProductCardContainerView, Unit> r3, Function0<ProductCardContainerView> r4, Function1<? super ProductCardContainerView, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "getExpandProductCard");
        Intrinsics.checkNotNullParameter(r3, "setExpandProductCard");
        Intrinsics.checkNotNullParameter(r4, "getFirstTouchProductCard");
        Intrinsics.checkNotNullParameter(r5, "setFirstTouchProductCard");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
