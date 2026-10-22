package jd3;

import com.bytedance.android.ec.model.ECAdInfo;

/* JADX INFO: loaded from: classes13.dex */
public final class x extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f498559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f498560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f498562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f498564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f498565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f498566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f498567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f498568l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f498569m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f498570n;

    public static final class a {
    }

    static {
    }

    public x() {
        super("groupbuying_rule_click");
        this.f498559c = "0";
        this.f498560d = "0";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        String r101 = null;
        appendParam("group_id", null, r100);
        appendParam("enter_method", null, r100);
        appendParam("author_id", this.f498557a, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, null, r100);
        appendParam("carrier_type", null, r100);
        appendParam("source_page", null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ORDER_TYPE, null, r100);
        appendParam("follow_status", followStatus(null, this.f498557a), r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_SELF, null, r100);
        appendParam("search_keyword", null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, null, r100);
        appendParam("log_pb", null, r100);
        appendParam("previous_page", null, r100);
        appendParam("product_id", null, r100);
        appendParam("search_id", this.f498558b, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, null, r100);
        appendParam("room_id", null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LIVE_GROUP_ID, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, null, r100);
        appendParam("page_name", null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_VIRTUAL_COMMODITY_FLAG, this.f498559c, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_COUPON, this.f498560d, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_RECEPTOR, this.f498561e, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_ACTIVITY_ID, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_ACTIVITY_TYPE, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, String.valueOf(this.f498562f), r100);
        appendParam("page_type", this.f498563g, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE, this.f498565i, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE_ID, this.f498564h, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, this.f498566j, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WHICH_ACCOUNT, this.f498567k, r100);
        appendParam("cid", this.f498568l, r100);
        appendParam("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL, r100);
        appendParam("is_special", this.f498569m, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, this.f498570n, r100);
        ECAdInfo r102 = ih3.g.f489807b.A(this.f498557a);
        if (r102 == null) goto L9;
        Long r103 = r102.getCid();
        if (r103 == null) goto L7;
        r101 = String.valueOf(r103.longValue());
    L7:
        appendParam("cid", r101, r100);
        appendParam("log_extra", r102.getLogExtra(), r100);
        return;
    }
}
