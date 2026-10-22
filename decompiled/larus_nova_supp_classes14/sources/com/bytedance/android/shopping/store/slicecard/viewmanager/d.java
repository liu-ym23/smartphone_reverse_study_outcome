package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.store.view.ECShopFlowLightMarqueeView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECShopFlowLightMarqueeView> {
    public boolean H3;

    public static final class a {
    }

    static {
    }

    public d(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        if (k1() != null) goto L5;
        return;
    L5:
        dm.a.a("ShopMarqueeViewManager").a("onUpdateProp, props: " + r4);
        if (this.H3 == false) goto L8;
        return;
    L8:
        Iterator<Map.Entry<String, ? extends Object>> r5 = r4.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L62;
        Map.Entry<String, ? extends Object> r0 = r5.next();
        String r1 = r0.getKey();
        Object r2 = r0.getValue();
        switch(r1.hashCode()) {
            case -1383304148: goto L55;
            case -1282947541: goto L47;
            case -938578798: goto L39;
            case -714691314: goto L31;
            case -146398136: goto L23;
            case 1459027253: goto L15;
            default: goto L10;
        };
    L15:
        if (r1.equals("rotation_duration") == false) goto L10;
        if (r2 == null) goto L10;
        Long r3 = com.bytedance.android.ecom.arch.slice.render.util.b.n(r2);
        if (r3 == null) goto L10;
        long r6 = r3.longValue();
        ECShopFlowLightMarqueeView r7 = k1();
        if (r7 == null) goto L10;
        r7.setRotationDuration(r6);
        goto L10
    L23:
        if (r1.equals("fade_out_duration") == false) goto L10;
        if (r2 == null) goto L10;
        Long r8 = com.bytedance.android.ecom.arch.slice.render.util.b.n(r2);
        if (r8 == null) goto L10;
        long r9 = r8.longValue();
        ECShopFlowLightMarqueeView r10 = k1();
        if (r10 == null) goto L10;
        r10.setFadeOutDuration(r9);
        goto L10
    L31:
        if (r1.equals("rotation_count") == false) goto L10;
        if (r2 == null) goto L10;
        Integer r11 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r2);
        if (r11 == null) goto L10;
        int r12 = r11.intValue();
        ECShopFlowLightMarqueeView r13 = k1();
        if (r13 == null) goto L10;
        r13.setRotationCount(r12);
        goto L10
    L39:
        if (r1.equals("radius") == false) goto L10;
        if (r2 == null) goto L10;
        Float r14 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r2);
        if (r14 == null) goto L10;
        float r15 = r14.floatValue();
        ECShopFlowLightMarqueeView r16 = k1();
        if (r16 == null) goto L10;
        r16.setRadius(r15);
        goto L10
    L47:
        if (r1.equals("fade_in_duration") == false) goto L10;
        if (r2 == null) goto L10;
        Long r17 = com.bytedance.android.ecom.arch.slice.render.util.b.n(r2);
        if (r17 == null) goto L10;
        long r18 = r17.longValue();
        ECShopFlowLightMarqueeView r19 = k1();
        if (r19 == null) goto L10;
        r19.setFadeInDuration(r18);
        goto L10
    L55:
        if (r1.equals("border") == false) goto L10;
        if (r2 == null) goto L10;
        Float r20 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r2);
        if (r20 == null) goto L10;
        float r21 = r20.floatValue();
        ECShopFlowLightMarqueeView r22 = k1();
        if (r22 == null) goto L10;
        r22.setBorder(r21);
        goto L10
    L62:
        this.H3 = true;
        ECShopFlowLightMarqueeView r23 = k1();
        if (r23 == null) goto L135;
        r23.s = true;
        r23.post(new com.bytedance.android.ec.store.view.d(r23));     // Catch: Exception -> L67
        return;
    L67:
        e = move-exception;
        dm.a.a("ECShopFlowLightMarqueeView").b("startAnimator", e);
        return;
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new ECShopFlowLightMarqueeView(r5, null, 6, 0);
    }
}
