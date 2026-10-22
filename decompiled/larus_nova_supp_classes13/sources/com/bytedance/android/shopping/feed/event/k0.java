package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ rd3.a d;

    public k0(Integer r1, Context r2, List r3, rd3.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        d1 r0 = new d1("inflow_sku_component_show");
        r0.a = "product_flow_page";
        rd3.a r1 = this.d;
        Integer r2 = null;
        if (r1 == null) goto L11;
        Promotion r3 = r1.f();
        if (r3 == null) goto L11;
        PromotionProductStruct r4 = r3.getPromotionInfo();
        if (r4 == null) goto L11;
        PromotionProductBaseStruct r5 = r4.getBaseInfo();
        if (r5 == null) goto L11;
        String r6 = r5.getProductId();
    L12:
        r0.b = r6;
        rd3.a r7 = this.d;
        if (r7 == null) goto L21;
        Promotion r8 = r7.f();
        if (r8 == null) goto L21;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L21;
        PromotionProductBaseStruct r10 = r9.getBaseInfo();
        if (r10 == null) goto L21;
        String r11 = r10.getPromotionId();
    L22:
        r0.c = r11;
        rd3.a r12 = this.d;
        if (r12 == null) goto L31;
        Promotion r13 = r12.f();
        if (r13 == null) goto L31;
        PromotionProductStruct r14 = r13.getPromotionInfo();
        if (r14 == null) goto L31;
        PromotionProductBaseStruct r15 = r14.getBaseInfo();
        if (r15 == null) goto L31;
        r2 = r15.getPromotionSource();
    L31:
        r0.d = String.valueOf(r2);
        Integer r16 = this.a;
        if (r16 != null) goto L35;
    L37:
        if (r16 != null) goto L40;
    L42:
        r0.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r0;
    L40:
        if (r16.intValue() != 0) goto L42;
        g.b(r0, this.b);
        goto L42
    L35:
        if (r16.intValue() != 2) goto L37;
        g.a(r0, this.b, this.c);
    L21:
        r11 = null;
    L11:
        r6 = null;
        goto L12
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
