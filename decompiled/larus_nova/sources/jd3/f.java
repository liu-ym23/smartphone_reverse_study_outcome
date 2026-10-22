package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f498300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f498301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f498302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f498304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f498305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f498306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f498307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f498308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f498309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f498310m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f498311n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f498312o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f498313p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f498314q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f498315r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f498316s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f498317t;

    public static final class a {
    }

    static {
    }

    public f() {
        super("click_comment_like");
        this.f498298a = "";
        this.f498299b = "";
        this.f498300c = "";
        this.f498301d = "";
        this.f498302e = "";
        this.f498303f = "";
        this.f498304g = "";
        this.f498305h = "";
        this.f498306i = "";
        this.f498307j = "";
        this.f498308k = "";
        this.f498309l = "";
        this.f498310m = "";
        this.f498311n = "";
        this.f498312o = "";
        this.f498313p = "";
        this.f498314q = "";
        this.f498315r = "0";
        this.f498316s = "";
        this.f498317t = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r100);
        appendParam("source_page", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r100);
        appendParam("enter_method", this.f498300c, r100);
        appendParam("author_id", this.f498298a, r100);
        appendParam("group_id", this.f498299b, r100);
        appendParam("follow_status", this.f498301d, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f498302e, r100);
        appendParam("product_id", this.f498303f, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f498304g, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, this.f498305h, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, this.f498306i, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f498307j, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, this.f498312o, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TAG, this.f498308k, r100);
        appendParam("search_id", this.f498309l, r100);
        appendParam("comment_id", this.f498310m, r100);
        appendParam("type", this.f498311n, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_APPEND, this.f498313p, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_SWITCH_TYPE, this.f498314q, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_COMMENT_BIG_PIC_LIKE, this.f498315r, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498316s, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SAME_COMMENT, this.f498317t, r100);
    }

    public final String getType() {
        return this.f498311n;
    }
}
