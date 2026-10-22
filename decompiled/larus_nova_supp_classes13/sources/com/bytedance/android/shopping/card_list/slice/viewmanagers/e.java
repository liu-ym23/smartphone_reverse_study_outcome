package com.bytedance.android.shopping.card_list.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.card_list.slice.widgets.CounterView;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends BaseSlcViewManager<CounterView> {
    public int H3;
    public String I3;
    public int J3;
    public String K3;
    public int L3;
    public boolean M3;
    public String N3;
    public int O3;
    public final SlcTemplateContext P3;
    public final boolean Q3;

    public e(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.P3 = r2;
        this.Q3 = true;
        this.I3 = "";
        this.K3 = "";
        this.N3 = "";
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.android.shopping.card_list.slice.widgets.CounterView] */
    public final View A0(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ?? r0 = new CounterView(r4, this.P3, this.Q3);
        r0.f(((BaseSlcViewManager) this).a.w.f);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H0(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L85;
        Map.Entry<String, ? extends Object> r0 = r11.next();
        String r1 = r0.getKey();
        String r3 = "";
        int r4 = 0;
        boolean r5 = false;
        int r6 = 0;
        int r7 = 0;
        Object r8 = null;
        switch(r1.hashCode()) {
            case -1648597450: goto L75;
            case -1285004149: goto L65;
            case -538158520: goto L54;
            case -320275964: goto L51;
            case -113151983: goto L42;
            case 107876: goto L32;
            case 108114: goto L22;
            case 20361897: goto L12;
            case 1753008747: goto L9;
            default: goto L4;
        };
    L9:
        if (r1.equals(PdpOpenThirdParam.KEY_PRODUCT_ID) == false) goto L4;
        this.N3 = String.valueOf(r0.getValue());
        goto L4
    L12:
        if (r1.equals("counter_active") == false) goto L4;
        Object r2 = r0.getValue();
        if ((r2 instanceof Boolean) == false) goto L17;
        r8 = r2;
    L17:
        Boolean r9 = (Boolean) r8;
        if (r9 == null) goto L20;
        r5 = r9.booleanValue();
    L20:
        this.M3 = r5;
        goto L4
    L22:
        if (r1.equals("min") == false) goto L4;
        Object r12 = r0.getValue();
        if ((r12 instanceof Number) == false) goto L27;
        r8 = r12;
    L27:
        Number r13 = (Number) r8;
        if (r13 == null) goto L30;
        r6 = r13.intValue();
    L30:
        this.H3 = r6;
        goto L4
    L32:
        if (r1.equals("max") == false) goto L4;
        Object r14 = r0.getValue();
        if ((r14 instanceof Number) == false) goto L37;
        r8 = r14;
    L37:
        Number r15 = (Number) r8;
        if (r15 == null) goto L40;
        r7 = r15.intValue();
    L40:
        this.J3 = r7;
        goto L4
    L42:
        if (r1.equals("invalid_update") == false) goto L4;
        Object r16 = r0.getValue();
        if ((r16 instanceof String) == false) goto L47;
        r8 = r16;
    L47:
        String r17 = (String) r8;
        if (r17 == null) goto L4;
        Boolean.parseBoolean(r17);
        goto L4
    L51:
        if (r1.equals("counter_edit_status") == false) goto L4;
        this.O3 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r0.getValue(), 0);
        goto L4
    L54:
        if (r1.equals("max_limit_toast") == false) goto L4;
        Object r18 = r0.getValue();
        if ((r18 instanceof String) == false) goto L59;
        r8 = r18;
    L59:
        String r19 = (String) r8;
        if (r19 == null) goto L63;
        r3 = r19;
    L63:
        this.K3 = r3;
        goto L4
    L65:
        if (r1.equals("quantity") == false) goto L4;
        Object r20 = r0.getValue();
        if ((r20 instanceof Number) == false) goto L70;
        r8 = r20;
    L70:
        Number r21 = (Number) r8;
        if (r21 == null) goto L73;
        r4 = r21.intValue();
    L73:
        this.L3 = r4;
        goto L4
    L75:
        if (r1.equals("min_limit_toast") == false) goto L4;
        Object r22 = r0.getValue();
        if ((r22 instanceof String) == false) goto L80;
        r8 = r22;
    L80:
        String r23 = (String) r8;
        if (r23 == null) goto L84;
        r3 = r23;
    L84:
        this.I3 = r3;
        goto L4
    L85:
        ((CounterView) getView()).e(this.M3, this.L3, this.H3, this.J3, this.I3, this.K3, this.N3, this.O3);
    }

    public final void v(int r14, int r15, int r16, int r17) {
        super.v(r14, r15, r16, r17);
        CounterView r7 = (CounterView) getView();
        r7.getClass();
        Intrinsics.checkNotNullParameter(this, "viewManager");
        View r1 = r7.o;
        List<Integer> r0 = r7.v;
        Object r8 = 12;
        if (CollectionsKt.getLastIndex(r0) < 0) goto L5;
        Object r2 = ListProtector.get(r0, 0);
    L6:
        int r3 = SlcDimensExtensionsKt.a((Number) r2, ((BaseSlcViewManager) this).a.m());
        List<Integer> r4 = r7.v;
        if (1 > CollectionsKt.getLastIndex(r4)) goto L9;
        Object r5 = ListProtector.get(r4, 1);
    L10:
        int r6 = SlcDimensExtensionsKt.a((Number) r5, ((BaseSlcViewManager) this).a.m());
        List<Integer> r9 = r7.v;
        if (2 > CollectionsKt.getLastIndex(r9)) goto L13;
        Object r10 = ListProtector.get(r9, 2);
    L14:
        int r11 = SlcDimensExtensionsKt.a((Number) r10, ((BaseSlcViewManager) this).a.m());
        List<Integer> r12 = r7.v;
        if (3 > CollectionsKt.getLastIndex(r12)) goto L17;
        Object r13 = ListProtector.get(r12, 3);
    L18:
        c1(r1, r3, r6, r11, SlcDimensExtensionsKt.a((Number) r13, ((BaseSlcViewManager) this).a.m()));
        ImageView r18 = r7.r;
        List<Integer> r19 = r7.w;
        if (CollectionsKt.getLastIndex(r19) < 0) goto L21;
        Object r20 = ListProtector.get(r19, 0);
    L22:
        int r21 = SlcDimensExtensionsKt.a((Number) r20, ((BaseSlcViewManager) this).a.m());
        List<Integer> r22 = r7.w;
        if (1 > CollectionsKt.getLastIndex(r22)) goto L25;
        Object r23 = ListProtector.get(r22, 1);
    L26:
        int r24 = SlcDimensExtensionsKt.a((Number) r23, ((BaseSlcViewManager) this).a.m());
        List<Integer> r25 = r7.w;
        if (3 > CollectionsKt.getLastIndex(r25)) goto L29;
        Object r26 = ListProtector.get(r25, 3);
    L30:
        c1(r18, r21, r24, 0, SlcDimensExtensionsKt.a((Number) r26, ((BaseSlcViewManager) this).a.m()));
        ImageView r27 = r7.s;
        List<Integer> r28 = r7.x;
        if (1 > CollectionsKt.getLastIndex(r28)) goto L33;
        Object r29 = ListProtector.get(r28, 1);
    L34:
        int r30 = SlcDimensExtensionsKt.a((Number) r29, ((BaseSlcViewManager) this).a.m());
        List<Integer> r31 = r7.x;
        if (2 > CollectionsKt.getLastIndex(r31)) goto L37;
        Object r32 = ListProtector.get(r31, 2);
    L38:
        int r33 = SlcDimensExtensionsKt.a((Number) r32, ((BaseSlcViewManager) this).a.m());
        List<Integer> r34 = r7.x;
        if (3 > CollectionsKt.getLastIndex(r34)) goto L41;
        r8 = ListProtector.get(r34, 3);
    L41:
        c1(r27, 0, r30, r33, SlcDimensExtensionsKt.a((Number) r8, ((BaseSlcViewManager) this).a.m()));
        return;
    L37:
        r32 = r8;
        goto L38
    L33:
        r29 = r8;
        goto L34
    L29:
        r26 = r8;
        goto L30
    L25:
        r23 = r8;
        goto L26
    L21:
        r20 = r8;
        goto L22
    L17:
        r13 = r8;
        goto L18
    L13:
        r10 = r8;
        goto L14
    L9:
        r5 = r8;
        goto L10
    L5:
        r2 = r8;
        goto L6
    }
}
