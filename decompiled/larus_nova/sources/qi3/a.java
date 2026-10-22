package qi3;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f533107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f533108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f533109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f533110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f533111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f533112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f533113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f533114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f533115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f533116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f533117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f533118l;

    /* JADX INFO: renamed from: qi3.a$a, reason: collision with other inner class name */
    public static final class C7331a {
    }

    static {
    }

    public a() {
        super("click_cart");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f533110d;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("author_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f533111e, r101);
        appendParam("sec_shop_id", this.f533112f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, this.f533113g, r101);
        appendParam("enter_from", this.f533107a, r101);
        appendParam("source_page", this.f533114h, r101);
        appendParam("page_name", this.f533108b, r101);
        appendParam("page_type", this.f533109c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, this.f533115i, r101);
        appendParam("click_type", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, this.f533116j, r101);
        appendParam("customer_id", this.f533117k, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_ENTER_PREVIEW, this.f533118l, r101);
    }
}
