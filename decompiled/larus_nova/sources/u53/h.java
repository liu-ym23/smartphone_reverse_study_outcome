package u53;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f548831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f548832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f548833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f548834d;

    public static final class a {
    }

    static {
    }

    public h() {
        super("comfirm_select_comment");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f548831a, r100);
        appendParam("product_id", this.f548832b, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, this.f548833c, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CONFIRM_STATUS, this.f548834d, r100);
    }
}
