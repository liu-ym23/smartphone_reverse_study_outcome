package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a1 extends com.bytedance.android.ec.core.event.a {
    public Integer a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public a1() {
        super("trending_show");
    }

    public final void buildParams() {
        appendParam("words_num", String.valueOf(this.a));
        appendParam(SimilarProductParam.ENTER_FROM, "search_order_center_product_flow_page");
        appendParam("impr_id", this.b);
        appendParam("words_source", this.c);
        appendParam("enter_from_second", this.d);
        appendParam("from_gid", this.e);
        appendParam("guess_like_item_rank", this.f);
    }
}
