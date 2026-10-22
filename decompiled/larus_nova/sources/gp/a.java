package gp;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f481966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f481967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f481968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f481969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f481970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f481971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f481972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f481973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f481974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f481975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f481976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f481977l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f481978m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f481979n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f481980o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f481981p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f481982q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f481983r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f481984s;

    public a() {
        super("search");
        this.f481976k = "store_page";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f481981p;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r100, r101);
        appendParam(ECFindSimilarConfig.ENTER_FROM_SECOND, this.f481980o, r101);
        appendParam("follow_status", this.f481979n, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f481978m, r101);
        appendParam("author_id", this.f481977l, r101);
        appendParam("source_page", this.f481976k, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SORT_BY, this.f481975j, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, this.f481974i, r101);
        appendParam("is_success", this.f481973h, r101);
        appendParam("search_keyword", this.f481972g, r101);
        appendParam("page_name", this.f481971f, r101);
        appendParam("enter_method", this.f481970e, r101);
        appendParam("impr_id", this.f481969d, r101);
        appendParam("log_pb", this.f481968c, r101);
        appendParam("search_type", this.f481967b, r101);
        appendParam("enter_from", this.f481966a, r101);
        appendParam("group_id", this.f481982q, r101);
        appendParam("sug_type", this.f481983r, r101);
        appendParam("request_id", this.f481984s, r101);
    }
}
