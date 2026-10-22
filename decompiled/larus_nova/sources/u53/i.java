package u53;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f548835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f548836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f548837c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f548835a, r100);
        appendParam("product_id", this.f548836b, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW_SKU, this.f548837c, r100);
    }

    public i() {
        super("show_select_comment");
    }
}
