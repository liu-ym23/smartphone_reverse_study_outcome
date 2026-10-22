package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.slice.widgets.ProductCardContainerView;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListSliceCustomWidgetAdapterComponent extends b {
    public WeakReference<ProductCardContainerView> d;
    public WeakReference<ProductCardContainerView> e;
    public String f;
    public boolean g;
    public final Lazy h;
    public final s i;
    public final CardListObjectContainer j;

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onDestroy() {
        super.onDestroy();
        this.d.clear();
        this.e.clear();
    }

    public CardListSliceCustomWidgetAdapterComponent(CardListObjectContainer r10, SlcRenderContext r11) {
        Intrinsics.checkNotNullParameter(r10, "objectContainer");
        super(r10);
        this.j = r10;
        this.d = new WeakReference(null);
        this.e = new WeakReference(null);
        this.h = LazyKt.lazy(new CardListSliceCustomWidgetAdapterComponent$cardListBackToTopBtnManageComponent$2(this));
        this.i = new s(new CardListSliceCustomWidgetAdapterComponent$actions$1(this), new CardListSliceCustomWidgetAdapterComponent$actions$2(this), new CardListSliceCustomWidgetAdapterComponent$actions$3(this), new CardListSliceCustomWidgetAdapterComponent$actions$4(this), new CardListSliceCustomWidgetAdapterComponent$actions$5(this), new CardListSliceCustomWidgetAdapterComponent$actions$6(this), new CardListSliceCustomWidgetAdapterComponent$actions$7(this), new CardListSliceCustomWidgetAdapterComponent$actions$8(this));
        if (r11 == null) goto L6;
        r11.o("CardListSliceCustomWidgetAdapterComponent", this);
        return;
    }
}
