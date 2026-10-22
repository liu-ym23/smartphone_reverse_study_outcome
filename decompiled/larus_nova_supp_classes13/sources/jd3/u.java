package jd3;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u extends com.bytedance.android.ec.core.event.a {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public final String f;
    public String g;
    public Integer h;
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

    public u() {
        super("show_product");
        this.e = "0";
        this.f = "0";
        this.C = "0";
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("group_id", r0, r1);
        appendParam("enter_method", null, r1);
        appendParam("author_id", this.b, r1);
        appendParam("commodity_id", this.c, r1);
        appendParam("commodity_type", this.d, r1);
        appendParam(PdpOpenThirdParam.KEY_CARRIER_TYPE, null, r1);
        appendParam("scene_id", null, r1);
        appendParam("product_label", productLabel(null), r1);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.g, r1);
        appendParam("with_coupon", this.e, r1);
        appendParam("with_link", this.f, r1);
        appendParam(SimilarProductParam.ENTER_FROM, null, r1);
        appendParam("room_id", null, r1);
        appendParam("order_type", null, r1);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, followStatus(this.h, this.b), r1);
        appendParam("is_self", null, r1);
        appendParam("search_id", this.i, r1);
        appendParam("search_keyword", null, r1);
        appendParam("entrance_info", this.j, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.k, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.l, r1);
        appendParam("carrier_source", this.m, r1);
        appendParam("source_method", this.n, r1);
        appendParam("ecom_entrance_form", this.q, r1);
        appendParam("module_label", this.o, r1);
        appendParam("is_activity", null, r1);
        appendParam("display_rank", this.p, r1);
        appendParam("cash_rebate", this.s, r1);
        appendParam("cash_rebate_id", this.r, r1);
        appendParam("recommend_info", this.t, r1);
        appendParam("rank_id", null, r1);
        appendParam("request_id", this.u, r1);
        ECAdInfo r2 = g33.b.b.A(null);
        if (r2 == null) goto L9;
        Long r5 = r2.getCid();
        if (r5 == null) goto L7;
        String r6 = String.valueOf(r5.longValue());
    L8:
        appendParam("cid", r6, r1);
        appendParam("log_extra", r2.getLogExtra(), r1);
        goto L9
    L7:
        r6 = null;
    L9:
        appendParam("label_name", null, r1);
        appendParam("product_flow_type", this.v, r1);
        appendParam("insurance_commodity_flag", null, r1);
        appendParam("pd_button_status", this.w, r1);
        appendParam("promotion_message_bar", this.x, r1);
        appendParam("is_white_base", null, r1);
        appendParam("ecom_type", this.z, r1);
        appendParam(PdpOpenThirdParam.KEY_ITEM_ID, this.y, com.bytedance.android.ec.core.event.a.b.a.b);
        appendParam("belt_detail", this.A, r1);
        appendParam("aftersale_information", this.B, r1);
        appendParam("ecom_group_type", "product_card", r1);
        appendParam("is_show_inflow_video", this.C, r1);
        appendParam("num_label_type", this.D, r1);
        appendParam("is_other_channel", null, r1);
        appendParam("creative_id", null, r1);
        appendParam("log_extra", null, r1);
        appendParam("outflow_order", null, r1);
        appendParam("previous_page", null, r1);
        appendParam("inflow_product_card_mode", this.E);
        appendParam("cost_price", this.F, r1);
        appendParam("real_price", this.G, r1);
        appendParam("min_sku_price", this.H, r1);
        appendParam("max_sku_price", this.I, r1);
        appendParam("bst_group_type", this.J, r1);
        appendParam("with_sku", this.M, r1);
        appendParam("new_gift_type", this.K, r1);
        appendParam("btm_id", this.L);
        appendParam("discount_activity_type", this.O, r1);
        appendParam("discount_activity_id", this.P, r1);
        appendParam("price_type", this.Q, r1);
        if (com.bytedance.android.shopping.anchorv3.a.b(this.N) == false) goto L12;
        appendParam("cid", this.N);
    L12:
        appendParam("price_info", this.R, r1);
        if (ECSettingKeys.g0() == false) goto L16;
        appendParam("standard_track_param", this.S, r1);
        appendParam("standard_product_marketing_param", this.T, r1);
        return;
    }
}
