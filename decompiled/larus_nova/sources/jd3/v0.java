package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f498547c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498545a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("inflow_recommend_type", r100, r101);
        appendParam("previous_page", null, r101);
        appendParam("inflow_product_card_mode", this.f498546b);
        Integer r102 = this.f498547c;
        if (r102 == null) goto L6;
        String r103 = String.valueOf(r102.intValue());
        if (r103 == null) goto L6;
    L7:
        appendParam("is_inflow_auto_expand", r103);
        return;
    L6:
        r103 = "0";
        goto L7
    }

    public v0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
