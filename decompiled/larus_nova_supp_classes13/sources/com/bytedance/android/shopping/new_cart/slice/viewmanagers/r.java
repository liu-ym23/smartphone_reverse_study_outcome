package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.slice.widgets.CounterViewV2;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends com.bytedance.android.ecom.arch.slice.render.elements.b<CounterViewV2> {
    public int H3;
    public String I3;
    public int J3;
    public String K3;
    public int L3;
    public boolean M3;
    public String N3;
    public int O3;
    public final Function0<CartSliceCustomWidgetAdapterComponent> P3;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.widget.FrameLayout, com.bytedance.android.shopping.new_cart.slice.widgets.CounterViewV2] */
    public final void H0(Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "props");
        Iterator<Map.Entry<String, ? extends Object>> r14 = r13.entrySet().iterator();
    L3:
        int r1 = 0;
        boolean r2 = false;
        int r3 = 0;
        int r4 = 0;
        if (r14.hasNext() == false) goto L85;
        Map.Entry<String, ? extends Object> r0 = r14.next();
        String r5 = r0.getKey();
        String r6 = "";
        Object r7 = null;
        switch(r5.hashCode()) {
            case -1648597450: goto L75;
            case -1285004149: goto L65;
            case -538158520: goto L54;
            case -320275964: goto L51;
            case -113151983: goto L42;
            case 107876: goto L32;
            case 108114: goto L22;
            case 20361897: goto L12;
            case 1753008747: goto L9;
            default: goto L3;
        };
    L9:
        if (r5.equals(PdpOpenThirdParam.KEY_PRODUCT_ID) == false) goto L3;
        this.N3 = String.valueOf(r0.getValue());
        goto L3
    L12:
        if (r5.equals("counter_active") == false) goto L3;
        Object r8 = r0.getValue();
        if ((r8 instanceof Boolean) == false) goto L17;
        r7 = r8;
    L17:
        Boolean r9 = (Boolean) r7;
        if (r9 == null) goto L20;
        r2 = r9.booleanValue();
    L20:
        this.M3 = r2;
        goto L3
    L22:
        if (r5.equals("min") == false) goto L3;
        Object r10 = r0.getValue();
        if ((r10 instanceof Number) == false) goto L27;
        r7 = r10;
    L27:
        Number r11 = (Number) r7;
        if (r11 == null) goto L30;
        r3 = r11.intValue();
    L30:
        this.H3 = r3;
        goto L3
    L32:
        if (r5.equals("max") == false) goto L3;
        Object r12 = r0.getValue();
        if ((r12 instanceof Number) == false) goto L37;
        r7 = r12;
    L37:
        Number r15 = (Number) r7;
        if (r15 == null) goto L40;
        r4 = r15.intValue();
    L40:
        this.J3 = r4;
        goto L3
    L42:
        if (r5.equals("invalid_update") == false) goto L3;
        Object r16 = r0.getValue();
        if ((r16 instanceof String) == false) goto L47;
        r7 = r16;
    L47:
        String r17 = (String) r7;
        if (r17 == null) goto L3;
        Boolean.parseBoolean(r17);
        goto L3
    L51:
        if (r5.equals("counter_edit_status") == false) goto L3;
        this.O3 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r0.getValue(), 0);
        goto L3
    L54:
        if (r5.equals("max_limit_toast") == false) goto L3;
        Object r18 = r0.getValue();
        if ((r18 instanceof String) == false) goto L59;
        r7 = r18;
    L59:
        String r19 = (String) r7;
        if (r19 == null) goto L63;
        r6 = r19;
    L63:
        this.K3 = r6;
        goto L3
    L65:
        if (r5.equals("quantity") == false) goto L3;
        Object r20 = r0.getValue();
        if ((r20 instanceof Number) == false) goto L70;
        r7 = r20;
    L70:
        Number r21 = (Number) r7;
        if (r21 == null) goto L73;
        r1 = r21.intValue();
    L73:
        this.L3 = r1;
        goto L3
    L75:
        if (r5.equals("min_limit_toast") == false) goto L3;
        Object r22 = r0.getValue();
        if ((r22 instanceof String) == false) goto L80;
        r7 = r22;
    L80:
        String r23 = (String) r7;
        if (r23 == null) goto L84;
        r6 = r23;
    L84:
        this.I3 = r6;
        goto L3
    L85:
        ?? r110 = (CounterViewV2) l1();
        boolean r24 = this.M3;
        int r25 = this.L3;
        int r26 = this.H3;
        int r27 = this.J3;
        String r28 = this.I3;
        String r29 = this.K3;
        String r30 = this.N3;
        int r31 = this.O3;
        Intrinsics.checkNotNullParameter(r28, "minLimitToast");
        Intrinsics.checkNotNullParameter(r29, "maxLimitToast");
        Intrinsics.checkNotNullParameter(r30, "productId");
        if (r110.e == false) goto L93;
        if (r24 == true) goto L93;
        Integer r32 = CartViewExtentionsKt.a(r110.r.getText().toString());
        if (r32 == null) goto L91;
        int r33 = r32.intValue();
    L92:
        r110.d(r33);
        goto L93
    L91:
        r33 = r26;
    L93:
        r110.l = r31;
        boolean r34 = true;
        if (r24 == true) goto L96;
        r110.o.setVisibility(8);
        r110.m.setVisibility(0);
    L110:
        if (r110.e == r24) goto L112;
        r110.requestLayout();
        r110.invalidate();
    L112:
        r110.e = r24;
        r110.f = r25;
        r110.g = r26;
        r110.h = r27;
        r110.i = r28;
        r110.j = r29;
        r110.k = r30;
        r110.e(r25);
        if (r110.g >= r110.f) goto L115;
        boolean r35 = true;
    L117:
        if (r35 == false) goto L119;
        r110.p.setImageResource(2131234311);
        bg3.a r36 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r110.p, "button", "减少商品数量", false);
    L121:
        if (r110.f < r110.h) goto L124;
        r34 = false;
    L124:
        if (r34 == false) goto L126;
        r110.q.setImageResource(2131234313);
        bg3.a r37 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r110.q, "button", "增加商品数量", false);
    L127:
        TextView r38 = r110.n;
        ViewExtensionsKt.e(r38, r38.getPaint(), 400);
        r110.n.setBackgroundColor(ContextCompat.getColor(r110.getContext(), 2131101517));
        EditText r111 = r110.r;
        ViewExtensionsKt.e(r111, r111.getPaint(), 400);
        return;
    L126:
        r110.q.setImageResource(2131234312);
        bg3.a r39 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r110.q, "button", r110.f + "为最大数量, 不可增加", false);
        goto L127
    L119:
        r110.p.setImageResource(2131234310);
        bg3.a r40 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r110.p, "button", r110.f + "为最小数量, 不可减少", false);
        goto L121
    L115:
        r35 = false;
        goto L117
    L96:
        if (r110.o.getVisibility() == 0) goto L98;
        boolean r112 = true;
    L99:
        r110.o.setVisibility(0);
        r110.m.setVisibility(8);
        b0 r41 = r110.x;
        if (r41 == null) goto L104;
        Function1<Boolean, Unit> r42 = r41.d;
        if (r42 == null) goto L104;
        Unit r43 = (Unit) r42.invoke(Boolean.TRUE);
    L104:
        if (r112 == false) goto L110;
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L110;
        r110.post(new com.bytedance.android.shopping.new_cart.slice.widgets.i(r110));
        goto L110
    L98:
        r112 = false;
        goto L99
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.android.shopping.new_cart.slice.widgets.CounterViewV2] */
    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        CartSliceCustomWidgetAdapterComponent r1 = (CartSliceCustomWidgetAdapterComponent) this.P3.invoke();
        CartObjectContainer r2 = null;
        if (r1 == null) goto L5;
        b0 r3 = r1.f;
    L6:
        CartSliceCustomWidgetAdapterComponent r4 = (CartSliceCustomWidgetAdapterComponent) this.P3.invoke();
        if (r4 == null) goto L9;
        r2 = r4.g;
    L9:
        ?? r0 = new CounterViewV2(r5, r3, r2);
        r0.c(((BaseSlcViewManager) this).a.w.f);
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    public r(SlcTemplateContext r2, Function0<CartSliceCustomWidgetAdapterComponent> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2);
        this.P3 = r3;
        this.I3 = "";
        this.K3 = "";
        this.N3 = "";
    }

    public final void v(int r1, int r2, int r3, int r4) {
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager*/.v(r1, r2, r3, r4);
        ((CounterViewV2) l1()).b(this);
    }
}
