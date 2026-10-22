package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class s0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498465f;

    public static final class a {
    }

    static {
    }

    public s0() {
        super("show_store_entrance");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498460a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, this.f498461b, r101);
        appendParam("author_id", this.f498462c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, this.f498463d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, this.f498464e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, this.f498465f, r101);
    }
}
