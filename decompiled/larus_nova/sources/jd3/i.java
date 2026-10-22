package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498340b;

    public static final class a {
    }

    static {
    }

    public i() {
        super("close_product_detail");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498339a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLOSE_METHOD, r100, r101);
        appendParam("page_type", this.f498340b, r101);
    }
}
