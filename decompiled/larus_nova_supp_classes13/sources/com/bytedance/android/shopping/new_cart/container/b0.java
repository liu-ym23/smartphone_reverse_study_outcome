package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.shopping.new_cart.slice.widgets.ProductCardContainerView;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0 {
    public final Function0<WeakReference<ProductCardContainerView>> a;
    public final Function1<WeakReference<ProductCardContainerView>, Unit> b;
    public final Function1<String, Unit> c;
    public final Function1<Boolean, Unit> d;
    public final Function1<Integer, Unit> e;
    public final Function0<Integer> f;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(Function0<? extends WeakReference<ProductCardContainerView>> r2, Function1<? super WeakReference<ProductCardContainerView>, Unit> r3, Function1<? super String, Unit> r4, Function1<? super Boolean, Unit> r5, Function1<? super Integer, Unit> r6, Function0<Integer> r7) {
        Intrinsics.checkNotNullParameter(r2, "getExpandProductCard");
        Intrinsics.checkNotNullParameter(r3, "setExpandProductCard");
        Intrinsics.checkNotNullParameter(r4, "setSelectedTabType");
        Intrinsics.checkNotNullParameter(r5, "setHasCounterExpand");
        Intrinsics.checkNotNullParameter(r6, "updateBackToTopButtonBottom");
        Intrinsics.checkNotNullParameter(r7, "getScreenWidth");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
