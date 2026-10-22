package pe3;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f528703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f528704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f528705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f528706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f528707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f528708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f528709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f528710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f528711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f528712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f528713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f528714l;

    /* JADX INFO: renamed from: pe3.a$a, reason: collision with other inner class name */
    public static final class C7185a {
    }

    static {
    }

    public a() {
        super("product_ranking_entrance_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        appendParam("page_name", this.f528703a, r100);
        appendParam("entrance_position", this.f528710h, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RANK_ID, this.f528713k, r100);
        appendParam("product_id", this.f528714l, r100);
        appendParam("spu_rank", this.f528711i, r100);
        appendParam("display_rank", this.f528705c, r100);
        appendParam("inflow_list_type", this.f528712j, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f528704b, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f528706d, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f528707e, r100);
        appendParam("source_page", this.f528708f, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f528709g, r100);
    }
}
