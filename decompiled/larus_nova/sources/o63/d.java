package o63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f522182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f522183f;

    public static final class a {
    }

    static {
    }

    @Override // o63.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f522181d;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_PRODUCT_ID, this.f522182e, r101);
        appendParam("carrier_type", "full_screen_card", r101);
        appendParam("combination_status", this.f522183f, r101);
        appendParam("btm_id", null, r101);
        super.buildParams();
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
