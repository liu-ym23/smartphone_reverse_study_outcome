package u53;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f548805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f548806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f548807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f548808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f548809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f548810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f548811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f548812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f548813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f548814j;

    /* JADX INFO: renamed from: u53.a$a, reason: collision with other inner class name */
    public static final class C7835a {
    }

    static {
    }

    public a() {
        super("comment_content_click");
        this.f548810f = "";
        this.f548811g = "";
        this.f548813i = "";
        this.f548814j = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f548805a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("content_type", r100, r101);
        appendParam("comment_id", this.f548806b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, String.valueOf(this.f548807c), r101);
        appendParam("content_rank", String.valueOf(this.f548812h), r101);
        appendParam("picture_num", String.valueOf(this.f548808d), r101);
        appendParam("video_num", String.valueOf(this.f548809e), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_SWITCH_TYPE, this.f548811g, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_USER_COMMENT_LEVEL, this.f548810f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f548813i, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SAME_COMMENT, this.f548814j, r101);
    }
}
