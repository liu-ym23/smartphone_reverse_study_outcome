package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;

    public static final class a {
    }

    static {
    }

    public w() {
        super("click_order_entrance");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(SimilarProductParam.ENTER_FROM, r0, r1);
        appendParam("carrier_source", this.b, r1);
        appendParam("inflow_product_card_mode", null);
    }
}
