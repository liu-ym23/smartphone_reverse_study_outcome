package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class m extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f498382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f498383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f498384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f498385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498387f;

    public static final class a {
    }

    static {
    }

    public m() {
        super("comment_label_jump_guide_pop_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        Long r100 = this.f498382a;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.longValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r103 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r102, r103);
        Long r104 = this.f498383b;
        if (r104 == null) goto L9;
        String r105 = String.valueOf(r104.longValue());
    L10:
        appendParam("order_id", r105, r103);
        Long r106 = this.f498384c;
        if (r106 == null) goto L13;
        String r107 = String.valueOf(r106.longValue());
    L14:
        appendParam("comment_id", r107, r103);
        Long r108 = this.f498385d;
        if (r108 == null) goto L17;
        r101 = String.valueOf(r108.longValue());
    L17:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, r101, r103);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498386e, r103);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, this.f498387f, r103);
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
