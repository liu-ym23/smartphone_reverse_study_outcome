package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class g extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f498327g;

    public static final class a {
    }

    static {
    }

    public g() {
        super("click_store_entrance");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498321a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f498322b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, this.f498323c, r101);
        appendParam("author_id", this.f498324d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, this.f498325e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, this.f498326f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, this.f498327g, r101);
    }
}
