package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class r0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498427d;

    public r0() {
        super("show_ecom_similar");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498424a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, r100, r101);
        appendParam("enter_method", this.f498425b, r101);
        appendParam("product_id", this.f498426c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f498427d, r101);
    }
}
