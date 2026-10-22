package in;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f490560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f490561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f490562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f490563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f490564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f490565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f490566g;

    /* JADX INFO: renamed from: in.a$a, reason: collision with other inner class name */
    public static final class C6290a {
    }

    static {
    }

    public a() {
        super("ec_click_aweme_return");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f490566g);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("duration", r100, r101);
        appendParam("enter_method", this.f490565f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f490560a, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f490561b, r101);
        appendParam("group_id", this.f490562c, r101);
        appendParam("author_id", this.f490563d, r101);
        appendParam("previous_page", this.f490564e, r101);
    }
}
