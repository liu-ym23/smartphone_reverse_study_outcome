package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d2 extends com.bytedance.android.ec.core.event.a {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public static final class a {
    }

    static {
    }

    public d2() {
        super("show_product");
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("product_flow_type", "product_fullscreen_card", r0);
        appendParam("promotion_message_bar", this.a, r0);
        appendParam("campaign_sub_type", this.b, r0);
        appendParam("label_name", this.e, r0);
        appendParam("belt_detail", this.c, r0);
        appendParam("aftersale_information", this.d, r0);
        appendParam("display_rank", this.f, r0);
        appendParam("ecom_type", this.g, r0);
        appendParam("is_with_video", this.h, r0);
        appendParam("num_label_type", this.i, r0);
        appendParam("inflow_recommend_type", this.j, r0);
        appendParam("previous_page", this.k, r0);
        appendParam("inflow_product_card_mode", this.l);
        appendParam("cost_price", this.m, r0);
        appendParam("real_price", this.n, r0);
        appendParam("min_sku_price", this.o, r0);
        appendParam("max_sku_price", this.p, r0);
        appendParam("recommend_info", this.q, r0);
        appendParam(SimilarProductParam.ENTER_FROM, this.r, r0);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.s, r0);
        appendParam("module_label", this.t, r0);
        appendParam("user_type", this.u, r0);
        appendParam("coupon_name", this.v, r0);
        appendParam("bst_group_type", this.w, r0);
        appendParam("with_sku", this.x, r0);
        appendParam("new_gift_type", this.y, r0);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.A, r0);
        appendParam("discount_activity_type", this.C, r0);
        appendParam("discount_activity_id", this.D, r0);
        appendParam("price_type", this.E, r0);
        if (com.bytedance.android.shopping.extensions.k.c(this.B) == false) goto L5;
        appendParam("cid", this.B);
    L5:
        appendParam("btm_id", this.z);
        appendParam("price_info", this.F, r0);
        appendParam("standard_track_param", this.G, r0);
        appendParam("standard_product_marketing_param", this.H, r0);
    }
}
