package u53;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f548817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f548818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f548819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f548820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f548821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f548822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f548823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f548824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f548825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f548826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f548827k;

    public static final class a {
    }

    static {
    }

    public f() {
        super("comment_content_show");
        this.f548822f = "";
        this.f548823g = "";
        this.f548826j = "";
        this.f548827k = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f548817a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("content_type", r100, r101);
        appendParam("comment_id", this.f548818b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, String.valueOf(this.f548819c), r101);
        appendParam("content_rank", String.valueOf(this.f548824h), r101);
        appendParam("picture_num", String.valueOf(this.f548820d), r101);
        appendParam("video_num", String.valueOf(this.f548821e), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_SWITCH_TYPE, this.f548823g, r101);
        if (this.f548825i == false) goto L5;
        String r102 = "1";
    L6:
        appendParam("is_comment_big_pic", r102, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_USER_COMMENT_LEVEL, this.f548822f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f548826j, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SAME_COMMENT, this.f548827k, r101);
        return;
    L5:
        r102 = "0";
        goto L6
    }
}
