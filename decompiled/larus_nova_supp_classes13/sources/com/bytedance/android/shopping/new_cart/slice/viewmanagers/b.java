package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.slice.widgets.BottomButtonContainerView;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends BaseSlcViewManager<BottomButtonContainerView> {
    public final Function0<CartSliceCustomWidgetAdapterComponent> H3;

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        CartSliceCustomWidgetAdapterComponent r0 = (CartSliceCustomWidgetAdapterComponent) this.H3.invoke();
        if (r0 == null) goto L5;
        b0 r1 = r0.f;
    L7:
        return new BottomButtonContainerView(r3, r1);
    L5:
        r1 = null;
        goto L7
    }

    public final void H0(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "props");
        Object r4 = r3.get("bottom_buttons");
        if ((r4 instanceof List) == true) goto L5;
        r4 = null;
    L5:
        BottomButtonContainerView r0 = (BottomButtonContainerView) getView();
        r0.c((List) r4, ((BaseSlcViewManager) this).a.w.f);
    }

    public b(SlcTemplateContext r2, Function0<CartSliceCustomWidgetAdapterComponent> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2);
        this.H3 = r3;
    }
}
