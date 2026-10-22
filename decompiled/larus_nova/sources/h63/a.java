package h63;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f483903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f483904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f483905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f483906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f483907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f483908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f483909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f483910h;

    public a() {
        super("open_appback_c");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f483903a);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("return_timestamp", r100, r101);
        appendParam("duration", String.valueOf(this.f483904b), r101);
        appendParam("source_page", this.f483905c, r101);
        appendParam("author_id", this.f483906d, r101);
        appendParam("group_id", this.f483907e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f483908f, r101);
        appendParam("product_id", this.f483909g, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f483910h, r101);
    }
}
