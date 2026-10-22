package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.container.v;
import com.bytedance.android.shopping.new_cart.slice.widgets.ProductCardContainerView;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductCardContainerVM extends com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b implements View.OnAttachStateChangeListener {
    public final Lazy W3;
    public final ProductCardContainerVM$callback$1 X3;
    public final Function0<CartSliceCustomWidgetAdapterComponent> Y3;

    public final /* bridge */ /* synthetic */ View A0(Context r1) {
        return J1(r1);
    }

    public final void H0(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "props");
        Object r0 = r8.get("slide_threshold");
        Object r2 = null;
        if ((r0 instanceof Number) == true) goto L5;
        r0 = null;
    L5:
        Number r1 = (Number) r0;
        if (r1 == null) goto L8;
        int r3 = r1.intValue();
    L9:
        Object r4 = r8.get("bottom_buttons");
        if ((r4 instanceof List) == true) goto L12;
        r4 = null;
    L12:
        List r5 = (List) r4;
        if (r5 != null) goto L15;
        r5 = CollectionsKt.emptyList();
    L15:
        Object r9 = r8.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
        if ((r9 instanceof String) == true) goto L18;
        r9 = null;
    L18:
        String r10 = (String) r9;
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        View r6 = getView();
        if ((r6 instanceof ProductCardContainerView) == false) goto L25;
        r2 = r6;
    L25:
        ProductCardContainerView r7 = (ProductCardContainerView) r2;
        if (r7 == null) goto L41;
        int r11 = SlcDimensExtensionsKt.a(Integer.valueOf(r3), ((BaseSlcViewManager) this).a.m());
        List r12 = r5;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L29:
        if (r14.hasNext() == false) goto L36;
        Object r15 = ((Map) r14.next()).get("key");
        if (r15 == null) goto L34;
        String r16 = r15.toString();
        if (r16 == null) goto L34;
    L35:
        r13.add(r16);
    L34:
        r16 = "";
        goto L35
    L36:
        Intrinsics.checkNotNullParameter(r10, "productId");
        Intrinsics.checkNotNullParameter(r13, "buttonList");
        r7.g = r11;
        r7.o = r10;
        r7.n = r13;
        return;
    L41:
        return;
    L8:
        r3 = 210;
        goto L9
    }

    public final SlcFlexElementView J1(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        CartSliceCustomWidgetAdapterComponent r0 = (CartSliceCustomWidgetAdapterComponent) this.Y3.invoke();
        CartObjectContainer r1 = null;
        if (r0 == null) goto L5;
        b0 r2 = r0.f;
    L6:
        CartSliceCustomWidgetAdapterComponent r3 = (CartSliceCustomWidgetAdapterComponent) this.Y3.invoke();
        if (r3 == null) goto L9;
        r1 = r3.g;
    L9:
        SlcFlexElementView r5 = new ProductCardContainerView(r4, r2, r1);
        r5.addOnAttachStateChangeListener(this);
        return r5;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(final View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        Lazy r0 = CartCommonLog.a;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass1(this, r3));
        boolean r1 = r3 instanceof ProductCardContainerView;
        Object r4 = r3;
        if (r1 == true) goto L5;
        r4 = null;
    L5:
        ProductCardContainerView r5 = (ProductCardContainerView) r4;
        if (r5 == null) goto L8;
        r5.h();
    L8:
        CartSliceCustomWidgetAdapterComponent r6 = (CartSliceCustomWidgetAdapterComponent) this.Y3.invoke();
        if (r6 == null) goto L18;
        CartObjectContainer r7 = r6.g;
        if (r7 == null) goto L19;
        com.bytedance.android.shopping.new_cart.container.b r8 = r7.e;
        if (r8 == null) goto L20;
        List<v> r9 = r8.e;
        if (r9 == null) goto L21;
        r9.add(this.X3);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(final View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        Lazy r0 = CartCommonLog.a;
        CartCommonLog.a("ProductCardContainerView", new C02821(this, r3));
        boolean r1 = r3 instanceof ProductCardContainerView;
        Object r4 = r3;
        if (r1 == true) goto L5;
        r4 = null;
    L5:
        ProductCardContainerView r5 = (ProductCardContainerView) r4;
        if (r5 == null) goto L8;
        r5.h();
    L8:
        CartSliceCustomWidgetAdapterComponent r6 = (CartSliceCustomWidgetAdapterComponent) this.Y3.invoke();
        if (r6 == null) goto L18;
        CartObjectContainer r7 = r6.g;
        if (r7 == null) goto L19;
        com.bytedance.android.shopping.new_cart.container.b r8 = r7.e;
        if (r8 == null) goto L20;
        List<v> r9 = r8.e;
        if (r9 == null) goto L21;
        r9.remove(this.X3);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void w0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.w0(r2);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.shopping.new_cart.slice.viewmanagers.ProductCardContainerVM$callback$1] */
    public ProductCardContainerVM(SlcTemplateContext r2, Function0<CartSliceCustomWidgetAdapterComponent> r3) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2);
        this.Y3 = r3;
        this.W3 = LazyKt.lazy(new ProductCardContainerVM$delOpt$2(this));
        this.X3 = new ProductCardContainerVM$callback$1(this);
    }
}
