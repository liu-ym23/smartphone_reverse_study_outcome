package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f498374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f498375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f498376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f498377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498380g;

    public static final class a {
    }

    static {
    }

    public l() {
        super("comment_label_jump_guide_pop_click");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        Long r100 = this.f498374a;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.longValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r103 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r102, r103);
        Long r104 = this.f498375b;
        if (r104 == null) goto L9;
        String r105 = String.valueOf(r104.longValue());
    L10:
        appendParam("order_id", r105, r103);
        Long r106 = this.f498376c;
        if (r106 == null) goto L13;
        String r107 = String.valueOf(r106.longValue());
    L14:
        appendParam("comment_id", r107, r103);
        Long r108 = this.f498377d;
        if (r108 == null) goto L17;
        r101 = String.valueOf(r108.longValue());
    L17:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, r101, r103);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498378e, r103);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, this.f498379f, r103);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, this.f498380g, r103);
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
