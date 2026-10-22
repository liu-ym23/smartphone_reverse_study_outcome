package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.shopping.new_cart.slice.widgets.ProductCardContainerView;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartSliceCustomWidgetAdapterComponent extends com.bytedance.android.shopping.new_cart.components.a {
    public WeakReference<ProductCardContainerView> b;
    public String c;
    public boolean d;
    public final Lazy e;
    public final b0 f;
    public final CartObjectContainer g;

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void k() {
        CartTemplateMgr.INSTANCE.updateCurrentAdapter(this);
    }

    public CartSliceCustomWidgetAdapterComponent(CartObjectContainer r8) {
        Intrinsics.checkNotNullParameter(r8, "objectContainer");
        super(r8);
        this.g = r8;
        this.b = new WeakReference(null);
        this.e = LazyKt.lazy(new CartSliceCustomWidgetAdapterComponent$cartbackToTopBtnManageComponent$2(this));
        this.f = new b0(new CartSliceCustomWidgetAdapterComponent$actions$1(this), new CartSliceCustomWidgetAdapterComponent$actions$2(this), new CartSliceCustomWidgetAdapterComponent$actions$3(this), new CartSliceCustomWidgetAdapterComponent$actions$4(this), new CartSliceCustomWidgetAdapterComponent$actions$5(this), new CartSliceCustomWidgetAdapterComponent$actions$6(this));
        CartTemplateMgr.INSTANCE.updateCurrentAdapter(this);
    }
}
