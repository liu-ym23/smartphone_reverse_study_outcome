package com.bytedance.android.shopping.buynow.slice.counter;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends BaseSlcViewManager<BuyNowCounterView> {
    public int H3;
    public String I3;
    public int J3;
    public String K3;
    public int L3;
    public String M3;
    public boolean N3;
    public String O3;
    public final SlcTemplateContext P3;

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.P3 = r2;
        this.H3 = 1;
        this.I3 = "";
        this.J3 = 1;
        this.K3 = "";
        this.L3 = 1;
        this.M3 = "";
        this.O3 = "";
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.android.shopping.buynow.slice.counter.BuyNowCounterView] */
    public final View A0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new BuyNowCounterView(r5, null, 0);
        r0.c(((BaseSlcViewManager) this).a.w.f);
        SlcTemplateContext r6 = this.P3;
        Intrinsics.checkNotNullParameter(r6, "slcTemplateContext");
        r6.w.n(new e(r0.n, new BuyNowCounterView$registerKeyboardChangedListener$1(r0)));
        return r0;
    }

    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((BuyNowCounterView) getView()).dispatchHoverEvent(r2) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    public final void H0(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L77;
        Map.Entry<String, ? extends Object> r0 = r11.next();
        String r1 = r0.getKey();
        String r3 = "";
        int r4 = 1;
        Object r5 = null;
        switch(r1.hashCode()) {
            case -1648597450: goto L67;
            case -1285004149: goto L57;
            case -538158520: goto L46;
            case -35132843: goto L43;
            case 107876: goto L33;
            case 108114: goto L23;
            case 20361897: goto L12;
            case 1753008747: goto L9;
            default: goto L4;
        };
    L9:
        if (r1.equals(PdpOpenThirdParam.KEY_PRODUCT_ID) == false) goto L4;
        this.O3 = String.valueOf(r0.getValue());
        goto L4
    L12:
        if (r1.equals("counter_active") == false) goto L4;
        Object r2 = r0.getValue();
        if ((r2 instanceof Boolean) == false) goto L17;
        r5 = r2;
    L17:
        Boolean r6 = (Boolean) r5;
        if (r6 == null) goto L20;
        boolean r7 = r6.booleanValue();
    L21:
        this.N3 = r7;
        goto L4
    L20:
        r7 = false;
        goto L21
    L23:
        if (r1.equals("min") == false) goto L4;
        Object r8 = r0.getValue();
        if ((r8 instanceof Number) == false) goto L28;
        r5 = r8;
    L28:
        Number r9 = (Number) r5;
        if (r9 == null) goto L31;
        r4 = r9.intValue();
    L31:
        this.H3 = r4;
        goto L4
    L33:
        if (r1.equals("max") == false) goto L4;
        Object r12 = r0.getValue();
        if ((r12 instanceof Number) == false) goto L38;
        r5 = r12;
    L38:
        Number r13 = (Number) r5;
        if (r13 == null) goto L41;
        r4 = r13.intValue();
    L41:
        this.J3 = r4;
        goto L4
    L43:
        if (r1.equals("change_quantity_event") == false) goto L4;
        this.M3 = String.valueOf(r0.getValue());
        goto L4
    L46:
        if (r1.equals("max_limit_toast") == false) goto L4;
        Object r14 = r0.getValue();
        if ((r14 instanceof String) == false) goto L51;
        r5 = r14;
    L51:
        String r15 = (String) r5;
        if (r15 == null) goto L55;
        r3 = r15;
    L55:
        this.K3 = r3;
        goto L4
    L57:
        if (r1.equals("quantity") == false) goto L4;
        Object r16 = r0.getValue();
        if ((r16 instanceof Number) == false) goto L62;
        r5 = r16;
    L62:
        Number r17 = (Number) r5;
        if (r17 == null) goto L65;
        r4 = r17.intValue();
    L65:
        this.L3 = r4;
        goto L4
    L67:
        if (r1.equals("min_limit_toast") == false) goto L4;
        Object r18 = r0.getValue();
        if ((r18 instanceof String) == false) goto L72;
        r5 = r18;
    L72:
        String r19 = (String) r5;
        if (r19 == null) goto L76;
        r3 = r19;
    L76:
        this.I3 = r3;
        goto L4
    L77:
        ((BuyNowCounterView) getView()).b(this.N3, this.L3, this.H3, this.J3, this.I3, this.K3, this.O3, this.M3);
    }
}
