package qi3;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f533119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f533120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f533121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f533122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f533123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f533124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f533125g;

    public static final class a {
    }

    static {
    }

    public b() {
        super("enter_search");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f533119a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("source_page", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, this.f533120b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, this.f533121c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_ENTER_PREVIEW, String.valueOf(this.f533122d), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, this.f533123e, r101);
        appendParam("page_name", this.f533124f, r101);
        appendParam("author_id", this.f533125g, r101);
    }
}
