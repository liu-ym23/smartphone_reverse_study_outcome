package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.slice.widgets.CartHeaderTab;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeaderTabVM extends BaseSlcViewManager<CartHeaderTab> {
    public static final /* synthetic */ int M3 = 0;
    public final Lazy H3;
    public final Lazy I3;
    public final Lazy J3;
    public final SlcTemplateContext K3;
    public final Function0<CartSliceCustomWidgetAdapterComponent> L3;

    public final View A0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new CartHeaderTab(r5, this.K3, (CartObjectContainer) this.H3.getValue(), (b0) this.J3.getValue());
    }

    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((CartHeaderTab) getView()).dispatchHoverEvent(r2) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    public final void H0(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "props");
        ArrayList r0 = new ArrayList();
        Object r1 = r8.get("tab_list");
        Object r2 = null;
        if (r1 == null) goto L27;
        boolean r3 = r1 instanceof List;
        if (r3 == false) goto L27;
        if (r3 == true) goto L8;
        r1 = null;
    L8:
        List r4 = (List) r1;
        if (r4 == null) goto L27;
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L27;
        Map r6 = (Map) r5.next();
        bg3.a r7 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartViewModel r9 = (CartViewModel) this.I3.getValue();
        Intrinsics.checkNotNullParameter(u.class, "objectClass");
        if (r6 != null) goto L16;
    L23:
        Object r10 = null;
    L24:
        u r11 = (u) r10;
        if (r11 == null) goto L12;
        r0.add(r11);
        goto L12
    L16:
        if (r6.isEmpty() == true) goto L23;
        r10 = u0.b(com.bytedance.android.ec.hybrid.list.util.k.d(r6), u.class);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r9 == null) goto L23;
        bg3.a r12 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.g(r9, "getObjectFromMap", th.getMessage(), MapsKt.emptyMap());
    L27:
        Object r13 = r8.get("tab_color");
        if ((r13 instanceof String) == true) goto L30;
        r13 = null;
    L30:
        String r14 = (String) r13;
        if (r14 != null) goto L33;
        r14 = "#FF3344";
    L33:
        CartHeaderTab r15 = (CartHeaderTab) getView();
        Object r16 = r8.get("selected_tab_type");
        if ((r16 instanceof String) == false) goto L37;
        r2 = r16;
    L37:
        r15.e(r0, (String) r2, r14);
    }

    public HeaderTabVM(SlcTemplateContext r2, Function0<CartSliceCustomWidgetAdapterComponent> r3) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2);
        this.K3 = r2;
        this.L3 = r3;
        this.H3 = LazyKt.lazy(new HeaderTabVM$objectContainer$2(this));
        this.I3 = LazyKt.lazy(new HeaderTabVM$cartViewModel$2(this));
        this.J3 = LazyKt.lazy(new HeaderTabVM$actions$2(this));
    }
}
