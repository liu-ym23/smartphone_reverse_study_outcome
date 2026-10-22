package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class o0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f498402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f498403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f498404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f498405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f498406l;

    public static final class a {
    }

    static {
    }

    public o0() {
        super("share_product");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498395a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("group_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f498396b, r101);
        appendParam("author_id", this.f498397c, r101);
        appendParam("carrier_type", this.f498398d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f498399e, r101);
        appendParam("platform", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, null, r101);
        appendParam("page_name", this.f498400f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, this.f498402h, r101);
        appendParam("source_page", this.f498401g, r101);
        appendParam("previous_page", null, r101);
        appendParam("enter_method", this.f498403i, r101);
        appendParam("product_id", this.f498404j, r101);
        appendParam("follow_status", followStatus(this.f498405k, this.f498397c), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHARE_THIRD_PARTY, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, this.f498406l, r101);
    }
}
