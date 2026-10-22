package yb3;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f567077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f567078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f567079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f567080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f567081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f567082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f567083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f567084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f567085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f567086j;

    public static final class a {
    }

    static {
    }

    public b() {
        super("comment_content_exit");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f567082f);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("show_num", r100, r101);
        appendParam("action_type", String.valueOf(this.f567083g), r101);
        appendParam("content_type", this.f567077a, r101);
        appendParam("comment_id", this.f567078b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, String.valueOf(this.f567079c), r101);
        appendParam("picture_num", String.valueOf(this.f567080d), r101);
        appendParam("video_num", String.valueOf(this.f567081e), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_SWITCH_TYPE, String.valueOf(this.f567084h), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_USER_COMMENT_LEVEL, String.valueOf(this.f567085i), r101);
        appendParam("content_rank", String.valueOf(this.f567086j), r101);
    }
}
