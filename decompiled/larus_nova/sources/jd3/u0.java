package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class u0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f498523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f498526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f498527i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f498528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f498529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f498530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f498531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f498532n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f498533o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f498534p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f498535q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f498536r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f498537s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f498538t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f498539u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f498540v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f498541w;

    public static final class a {
    }

    static {
    }

    public u0() {
        super("single_comment_show");
        this.f498519a = "";
        this.f498520b = "";
        this.f498521c = "";
        this.f498522d = "";
        this.f498523e = "";
        this.f498524f = "";
        this.f498525g = "";
        this.f498526h = "";
        this.f498527i = "";
        this.f498528j = "";
        this.f498529k = "";
        this.f498530l = "";
        this.f498533o = "";
        this.f498534p = "";
        this.f498535q = "";
        this.f498536r = "";
        this.f498537s = "";
        this.f498538t = "0";
        this.f498539u = "";
        this.f498540v = "";
        this.f498541w = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498526h;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, r100, r101);
        appendParam("product_id", this.f498519a, r101);
        appendParam("author_id", this.f498520b, r101);
        appendParam("comment_id", this.f498521c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, this.f498522d, r101);
        appendParam("source_page", this.f498523e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498524f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, this.f498525g, r101);
        appendParam("page_name", this.f498528j, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_APPEND, this.f498529k, r101);
        appendParam("business_type", this.f498527i, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_USER_COMMENT_LEVEL, this.f498530l, r101);
        appendParam("picture_num", String.valueOf(this.f498531m), r101);
        appendParam("video_num", String.valueOf(this.f498532n), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SAME_COMMENT, this.f498534p, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498533o, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS, this.f498535q, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_REPEAT_CUSTOMER, this.f498536r, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_LIVE_FAN_GROUP, this.f498537s, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TYPE, this.f498538t, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, this.f498539u, r101);
        appendParam("tag_name", this.f498540v, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IF_POSITIVE, this.f498541w, r101);
    }
}
