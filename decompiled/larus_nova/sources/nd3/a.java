package nd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f518770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f518771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f518772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f518773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f518774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f518775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f518776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f518777h;

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        appendParam("page_name", this.f518770a, r100);
        appendParam("coupon_id", this.f518771b, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, this.f518772c, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO, this.f518773d, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f518774e, r100);
        appendParam("source_page", this.f518775f, r100);
        appendParam("group_id", this.f518776g, r100);
        appendParam("product_id", this.f518777h, r100);
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }
}
