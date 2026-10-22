package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class t0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f498476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f498479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f498480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f498481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f498482k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f498483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f498484m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f498485n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f498486o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f498487p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f498488q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f498489r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f498490s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f498491t;

    public static final class a {
    }

    static {
    }

    public t0() {
        super("single_comment_click");
        this.f498472a = "";
        this.f498473b = "";
        this.f498474c = "";
        this.f498475d = "";
        this.f498476e = "";
        this.f498477f = "";
        this.f498478g = "";
        this.f498479h = "";
        this.f498480i = "";
        this.f498481j = "";
        this.f498482k = "";
        this.f498485n = "";
        this.f498486o = "";
        this.f498487p = "";
        this.f498488q = "";
        this.f498489r = "";
        this.f498490s = "";
        this.f498491t = "0";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498479h;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, r100, r101);
        appendParam("product_id", this.f498472a, r101);
        appendParam("author_id", this.f498473b, r101);
        appendParam("comment_id", this.f498474c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, this.f498475d, r101);
        appendParam("source_page", this.f498476e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498477f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, this.f498478g, r101);
        appendParam("page_name", this.f498480i, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_APPEND, this.f498481j, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_USER_COMMENT_LEVEL, this.f498482k, r101);
        appendParam("picture_num", String.valueOf(this.f498483l), r101);
        appendParam("video_num", String.valueOf(this.f498484m), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SAME_COMMENT, this.f498486o, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498485n, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS, this.f498487p, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_REPEAT_CUSTOMER, this.f498488q, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_LIVE_FAN_GROUP, this.f498489r, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, this.f498490s, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TYPE, this.f498491t, r101);
    }
}
