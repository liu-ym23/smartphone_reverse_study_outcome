package jd3;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.ECAdInfo;

/* JADX INFO: loaded from: classes13.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f498492J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f498500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f498501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f498502j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f498503k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f498504l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f498505m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f498506n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f498507o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f498508p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f498509q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f498510r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f498511s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f498512t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f498513u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f498514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f498515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f498516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f498517y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f498518z;

    public static final class a {
    }

    static {
    }

    public u() {
        super(com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT);
        this.f498497e = "0";
        this.f498498f = "0";
        this.C = "0";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498493a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("group_id", r100, r101);
        appendParam("enter_method", null, r101);
        appendParam("author_id", this.f498494b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f498495c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f498496d, r101);
        appendParam("carrier_type", null, r101);
        appendParam("scene_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_LABEL, productLabel(null), r101);
        appendParam("source_page", this.f498499g, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_COUPON, this.f498497e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_LINK, this.f498498f, r101);
        appendParam("enter_from", null, r101);
        appendParam("room_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ORDER_TYPE, null, r101);
        appendParam("follow_status", followStatus(this.f498500h, this.f498494b), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_SELF, null, r101);
        appendParam("search_id", this.f498501i, r101);
        appendParam("search_keyword", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f498502j, r101);
        appendParam("page_name", this.f498503k, r101);
        appendParam("product_id", this.f498504l, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, this.f498505m, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, this.f498506n, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f498509q, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f498507o, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_ACTIVITY, null, r101);
        appendParam("display_rank", this.f498508p, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE, this.f498511s, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE_ID, this.f498510r, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f498512t, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RANK_ID, null, r101);
        appendParam("request_id", this.f498513u, r101);
        ECAdInfo r102 = g33.b.f479797b.A(null);
        if (r102 == null) goto L9;
        Long r103 = r102.getCid();
        if (r103 == null) goto L7;
        String r104 = String.valueOf(r103.longValue());
    L8:
        appendParam("cid", r104, r101);
        appendParam("log_extra", r102.getLogExtra(), r101);
        goto L9
    L7:
        r104 = null;
    L9:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_FLOW_TYPE, this.f498514v, r101);
        appendParam("insurance_commodity_flag", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PD_BUTTON_STATUS, this.f498515w, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_MESSAGE_BAR, this.f498516x, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_WHITE_BASE, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, this.f498518z, r101);
        appendParam("item_id", this.f498517y, com.bytedance.android.ec.core.event.a.b.C0794a.f44004b);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BELT_DETAIL, this.A, r101);
        appendParam("aftersale_information", this.B, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card", r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW_INFLOW_VIDEO, this.C, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_NUM_LABEL_TYPE, this.D, r101);
        appendParam("is_other_channel", null, r101);
        appendParam("creative_id", null, r101);
        appendParam("log_extra", null, r101);
        appendParam("outflow_order", null, r101);
        appendParam("previous_page", null, r101);
        appendParam("inflow_product_card_mode", this.E);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COST_PRICE, this.F, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_REAL_PRICE, this.G, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MIN_SKU_PRICE, this.H, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MAX_SKU_PRICE, this.I, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, this.f498492J, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, this.M, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_NEW_GIFT_TYPE, this.K, r101);
        appendParam("btm_id", this.L);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_ACTIVITY_TYPE, this.O, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_ACTIVITY_ID, this.P, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRICE_TYPE, this.Q, r101);
        if (com.bytedance.android.shopping.anchorv3.a.b(this.N) == false) goto L12;
        appendParam("cid", this.N);
    L12:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRICE_INFO, this.R, r101);
        if (ECSettingKeys.g0() == false) goto L16;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STANDARD_TRACK_PARAM, this.S, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STANDARD_PRODUCT_MARKETING_PARAM, this.T, r101);
        return;
    }
}
