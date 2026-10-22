package jd3;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class s extends com.bytedance.android.ec.core.event.a {
    public int A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String H0;
    public String I;
    public String J;
    public String K;
    public String L;
    public String L0;
    public String M;
    public String N;
    public String O;
    public String P;
    public String P0;
    public Integer Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public Integer V;
    public String V0;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public String a;
    public String b;
    public String b1;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String g1;
    public final String h;
    public String h1;
    public final Integer i;
    public final String j;
    public Integer k;
    public String k0;
    public final String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String p0;
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

    public s() {
        super("click_product");
        this.g = "0";
        this.h = "0";
        this.i = 1;
        this.j = "";
        this.l = "0";
    }

    public void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("group_id", r0, r1);
        appendParam("author_id", this.b, r1);
        appendParam("room_id", null, r1);
        appendParam("commodity_id", this.c, r1);
        appendParam("commodity_type", this.d, r1);
        appendParam(PdpOpenThirdParam.KEY_CARRIER_TYPE, this.e, r1);
        appendParam("enter_method", null, r1);
        appendParam("product_label", productLabel(this.i), r1);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.f, r1);
        appendParam("with_coupon", this.g, r1);
        appendParam("with_link", this.h, r1);
        appendParam("is_self", null, r1);
        appendParam("next_page", this.j, r1);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, followStatus(this.k, this.b), r1);
        appendParam("virtual_commodity_flag", this.l, r1);
        appendParam(SimilarProductParam.ENTER_FROM, this.m, r1);
        appendParam("search_id", this.n, r1);
        appendParam("entrance_info", this.o, r1);
        appendParam("live_group_id", null, r1);
        appendParam("source_method", this.p, r1);
        appendParam("carrier_source", this.q, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.r, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.t, r1);
        appendParam("previous_page", this.s, r1);
        appendParam("ecom_tag_activity_id", null, r1);
        appendParam("ecom_tag_activity_type", null, r1);
        appendParam("product_activity_type", null, r1);
        appendParam("live_list_channel", null, r1);
        appendParam("module_label", this.v, r1);
        appendParam("is_activity", null, r1);
        appendParam("display_rank", this.w, r1);
        appendParam("cid", this.G, r1);
        appendParam("bst_group_type", this.b1, r1);
        boolean r2 = ECServiceManager.a;
        ECAdInfo r3 = ((s83.g) ECServiceManager.c(s83.g.class)).A(this.b);
        if (r3 == null) goto L9;
        Long r5 = r3.getCid();
        if (r5 == null) goto L7;
        String r6 = String.valueOf(r5.longValue());
    L8:
        appendParam("cid", r6, r1);
        appendParam("log_extra", r3.getLogExtra(), r1);
        goto L9
    L7:
        r6 = null;
    L9:
        appendParam("page_type", this.u, r1);
        appendParam("ecom_message_show_pv", null, r1);
        appendParam("auto_coupon", String.valueOf(this.A), r1);
        appendParam("cash_rebate", this.y, r1);
        appendParam("cash_rebate_id", this.x, r1);
        appendParam("avl_discount", this.B, r1);
        appendParam("which_account", this.z, r1);
        appendParam("ecom_entrance_form", this.C, r1);
        appendParam("params_for_special", "tppp", r1);
        appendParam("log_extra", this.D, r1);
        appendParam("with_sku", this.E, r1);
        appendParam("recommend_info", this.F, r1);
        appendParam("is_groupbuying", this.H, r1);
        appendParam("extra_campaign_type", this.I, r1);
        appendParam("shop_id", this.J, r1);
        appendParam("click_product_status", this.L, r1);
        appendParam("base_verified_category", null, r1);
        appendParam("brand_verified", this.K, r1);
        appendParam("is_authentic_insure", this.P, r1);
        appendParam("new_source_type", this.M, r1);
        appendParam("click_to_areacode", this.N, r1);
        appendParam("label_name", this.O, r1);
        appendParam("fast_dispatch", String.valueOf(this.Q), r1);
        appendParam("search_params", this.R, r1);
        appendParam("request_id", this.S, r1);
        String r4 = this.T;
        if (r4 == null) goto L12;
        appendParam("product_flow_type", r4, r1);
    L12:
        String r7 = this.U;
        if (r7 == null) goto L15;
        appendParam("click_area", r7, r1);
    L15:
        appendParam("is_with_video", String.valueOf(this.V), r1);
        appendParam("insurance_commodity_flag", null, r1);
        appendParam("pd_button_status", this.W, r1);
        appendParam("campaign_sub_type", this.X, r1);
        appendParam("is_white_base", null, r1);
        appendParam("upfront_presell", this.H0, r1);
        appendParam("is_activity_banner", this.L0, r1);
        appendParam(PdpOpenThirdParam.KEY_ITEM_ID, this.Y, com.bytedance.android.ec.core.event.a.b.a.b);
        appendParam("belt_detail", this.Z, r1);
        appendParam("aftersale_information", this.k0, r1);
        appendParam("promotion_message_bar", this.p0, r1);
        appendParam("product_source_page", this.P0, r1);
        appendParam("coupon_id", null, r1);
        appendParam("membership_prd", null, r1);
        appendParam("is_membership", null, r1);
        appendParam("bar_text", null, r1);
        appendParam("ecom_group_type", this.V0, r1);
        appendParam("campaign_extra_type", "null", r1);
        appendParam("is_other_channel", null, r1);
        appendParam("creative_id", null, r1);
        appendParam("log_extra", null, r1);
        appendParam("outflow_order", null, r1);
        appendParam("btm_id", this.g1);
        appendParam("price_info", this.h1, r1);
    }
}
