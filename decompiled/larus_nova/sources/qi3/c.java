package qi3;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f533126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f533127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f533128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f533129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f533130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f533131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f533132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f533133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f533134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f533135j;

    public static final class a {
    }

    static {
    }

    public c() {
        super("show_product_list");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f533129d;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("author_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, this.f533130e, r101);
        appendParam("enter_from", this.f533126a, r101);
        appendParam("source_page", this.f533131f, r101);
        appendParam("page_name", this.f533127b, r101);
        appendParam("page_type", this.f533128c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, this.f533132g, r101);
        appendParam("click_type", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, this.f533133h, r101);
        appendParam("customer_id", this.f533134i, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_ENTER_PREVIEW, this.f533135j, r101);
    }
}
