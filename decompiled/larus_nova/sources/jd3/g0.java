package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class g0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498330c;

    public static final class a {
    }

    static {
    }

    public g0() {
        super("presell_reserve_success_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, null, r100);
        appendParam("is_special", this.f498328a, r100);
        appendParam("campaign_sub_type", null, r100);
        appendParam("page_type", this.f498329b, r100);
        appendParam("enter_from", this.f498330c, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_FLOW_TYPE, null, r100);
    }
}
