package jd3;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.model.ECAdInfo;

/* JADX INFO: loaded from: classes13.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f498428J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498430b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public String f498431b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498436g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public String f498437g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f498438h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public String f498439h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f498440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f498441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f498442k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f498443k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f498444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f498445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f498446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f498447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f498448p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public String f498449p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f498450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f498451r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f498452s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f498453t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f498454u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f498455v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f498456w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f498457x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f498458y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f498459z;

    public static final class a {
    }

    static {
    }

    public s() {
        super(com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT);
        this.f498436g = "0";
        this.f498438h = "0";
        this.f498440i = 1;
        this.f498441j = "";
        this.f498444l = "0";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public void buildParams() {
        String r100 = this.f498429a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("group_id", r100, r101);
        appendParam("author_id", this.f498430b, r101);
        appendParam("room_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f498432c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f498433d, r101);
        appendParam("carrier_type", this.f498434e, r101);
        appendParam("enter_method", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_LABEL, productLabel(this.f498440i), r101);
        appendParam("source_page", this.f498435f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_COUPON, this.f498436g, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_LINK, this.f498438h, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_SELF, null, r101);
        appendParam("next_page", this.f498441j, r101);
        appendParam("follow_status", followStatus(this.f498442k, this.f498430b), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_VIRTUAL_COMMODITY_FLAG, this.f498444l, r101);
        appendParam("enter_from", this.f498445m, r101);
        appendParam("search_id", this.f498446n, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f498447o, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LIVE_GROUP_ID, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, this.f498448p, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, this.f498450q, r101);
        appendParam("page_name", this.f498451r, r101);
        appendParam("product_id", this.f498453t, r101);
        appendParam("previous_page", this.f498452s, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_ACTIVITY_ID, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_ACTIVITY_TYPE, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f498455v, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_ACTIVITY, null, r101);
        appendParam("display_rank", this.f498456w, r101);
        appendParam("cid", this.G, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, this.f498431b1, r101);
        boolean r102 = ECServiceManager.f42805a;
        ECAdInfo r103 = ((s83.g) ECServiceManager.c(s83.g.class)).A(this.f498430b);
        if (r103 == null) goto L9;
        Long r104 = r103.getCid();
        if (r104 == null) goto L7;
        String r105 = String.valueOf(r104.longValue());
    L8:
        appendParam("cid", r105, r101);
        appendParam("log_extra", r103.getLogExtra(), r101);
        goto L9
    L7:
        r105 = null;
    L9:
        appendParam("page_type", this.f498454u, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_MESSAGE_SHOW_PV, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, String.valueOf(this.A), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE, this.f498458y, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE_ID, this.f498457x, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, this.B, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WHICH_ACCOUNT, this.f498459z, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.C, r101);
        appendParam("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL, r101);
        appendParam("log_extra", this.D, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, this.E, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.F, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, this.H, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EXTRA_CAMPAIGN_TYPE, this.I, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f498428J, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT_STATUS, this.L, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, this.K, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_AUTHENTIC_INSURE, this.P, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, this.M, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_TO_AREACODE, this.N, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, this.O, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_FAST_DISPATCH, String.valueOf(this.Q), r101);
        appendParam("search_params", this.R, r101);
        appendParam("request_id", this.S, r101);
        String r106 = this.T;
        if (r106 == null) goto L12;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_FLOW_TYPE, r106, r101);
    L12:
        String r107 = this.U;
        if (r107 == null) goto L15;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r107, r101);
    L15:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_WITH_VIDEO, String.valueOf(this.V), r101);
        appendParam("insurance_commodity_flag", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PD_BUTTON_STATUS, this.W, r101);
        appendParam("campaign_sub_type", this.X, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_WHITE_BASE, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, this.H0, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_ACTIVITY_BANNER, this.L0, r101);
        appendParam("item_id", this.Y, com.bytedance.android.ec.core.event.a.b.C0794a.f44004b);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BELT_DETAIL, this.Z, r101);
        appendParam("aftersale_information", this.f498443k0, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_MESSAGE_BAR, this.f498449p0, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, this.P0, r101);
        appendParam("coupon_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MEMBERSHIP, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_MEMBER, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BAR_TEXT, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, this.V0, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CAMPAIGN_EXTRA_TYPE, "null", r101);
        appendParam("is_other_channel", null, r101);
        appendParam("creative_id", null, r101);
        appendParam("log_extra", null, r101);
        appendParam("outflow_order", null, r101);
        appendParam("btm_id", this.f498437g1);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRICE_INFO, this.f498439h1, r101);
    }
}
