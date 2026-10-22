package gp;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f481985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f481986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f481987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f481988d;

    public static final class a {
    }

    static {
    }

    public b() {
        super("store_search_input_duration");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f481985a);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("duration", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_FINAL_STATUS, this.f481986b, r101);
        appendParam("author_id", this.f481987c, r101);
        appendParam("source_page", this.f481988d, r101);
    }
}
