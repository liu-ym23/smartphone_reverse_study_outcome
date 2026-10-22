package gh3;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f481249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f481250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f481251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f481252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f481253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f481254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f481255g;

    /* JADX INFO: renamed from: gh3.a$a, reason: collision with other inner class name */
    public static final class C6020a {
    }

    static {
    }

    public a() {
        super("click_ecom_dislike");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f481249a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_KEY_ID, r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_KEY_RANK, this.f481250b, r101);
        appendParam("product_id", this.f481251c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CONFIRM_CONTENT, this.f481252d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f481253e, r101);
        appendParam("request_id", this.f481254f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SIMILAR_TYPE, this.f481255g, r101);
    }
}
