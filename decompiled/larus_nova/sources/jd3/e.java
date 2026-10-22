package jd3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f498282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f498283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f498284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f498285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f498286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f498287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f498288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f498289o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f498290p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f498291q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f498292r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f498293s;

    public e() {
        super("click_add_to_cart");
    }

    @Override // jd3.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        super.buildParams();
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE, this.f498278d, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE_ID, this.f498277c, r100);
        appendParam("page_type", this.f498279e, r100);
        appendParam("cid", this.f498280f, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f498281g, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, this.f498282h, r100);
        String r101 = this.f498283i;
        if (r101 != null) goto L5;
        r101 = new JSONObject().toString();
    L5:
        appendParam("search_params", r101, r100);
        appendParam("previous_page", this.f498284j, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, this.f498285k, r100);
        appendParam("product_id", this.f498286l, r100);
        String r102 = this.f498287m;
        if (r102 == null) goto L8;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r102, r100);
    L8:
        appendParam("inflow_product_card_mode", this.f498288n);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COST_PRICE, this.f498289o, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_REAL_PRICE, this.f498290p, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MIN_SKU_PRICE, this.f498291q, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MAX_SKU_PRICE, this.f498292r, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, this.f498293s, r100);
    }
}
