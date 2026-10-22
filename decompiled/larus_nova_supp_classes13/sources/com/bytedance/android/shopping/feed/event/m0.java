package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ AnchorV3Param d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ PromotionProductStruct f;
    public final /* synthetic */ rd3.a g;
    public final /* synthetic */ String h;

    public m0(Integer r1, Context r2, AnchorV3Param r3, boolean r4, PromotionProductStruct r5, rd3.a r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        w1 r0 = new w1();
        String r1 = this.d.getEntranceInfo();
        String r2 = null;
        if (r1 == null) goto L7;
        JSONObject r3 = com.bytedance.android.ec.core.utils.z1.g(r1);
        if (r3 == null) goto L7;
        String r4 = r3.optString("carrier_source");
    L8:
        r0.a = r4;
        r0.d = this.d.getRequestParam().getItemId();
        r0.b = "product_flow_page";
        if (this.e == false) goto L11;
        String r5 = "guess_you_like_product";
    L12:
        r0.e = r5;
        PromotionProductStruct r6 = this.f;
        if (r6 == null) goto L17;
        PromotionProductBaseStruct r7 = r6.getBaseInfo();
        if (r7 == null) goto L17;
        r2 = r7.getProductId();
    L17:
        r0.c = r2;
        r0.f = "product_comment";
        r0.g = this.g.m;
        String r8 = this.h;
        if (r8 != null) goto L20;
    L22:
        Integer r9 = this.a;
        if (r9 != null) goto L26;
    L28:
        if (r9 != null) goto L31;
    L33:
        r0.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r0;
    L31:
        if (r9.intValue() != 0) goto L33;
        g.b(r0, this.b);
        goto L33
    L26:
        if (r9.intValue() != 2) goto L28;
        g.a(r0, this.b, this.c);
        goto L33
    L20:
        if (com.bytedance.android.ec.core.utils.a2.d(r8) == null) goto L22;
        String r10 = this.h;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("btm_id", r10, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L22
    L11:
        r5 = null;
    L7:
        r4 = null;
        goto L8
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
