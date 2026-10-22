package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public Integer d;
    public String e;
    public String f;

    public static final class a {
    }

    static {
    }

    public c0() {
        super("enter_product_flow_page");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("log_id", r0, r1);
        appendParam("inflow_recommend_type", this.b, r1);
        String r2 = null;
        appendParam("previous_page", null, r1);
        appendParam("inflow_product_card_mode", this.c);
        Integer r3 = this.d;
        if (r3 == null) goto L5;
        r2 = String.valueOf(r3.intValue());
    L5:
        appendParam("is_similar_product_na", r2, r1);
        appendParam("video_product_is_unsale", this.e);
        if (com.bytedance.android.shopping.extensions.k.c(this.f) == false) goto L9;
        appendParam("cid", this.f);
        return;
    }
}
