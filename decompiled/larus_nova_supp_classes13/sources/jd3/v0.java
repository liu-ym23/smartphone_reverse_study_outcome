package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public Integer c;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("inflow_recommend_type", r0, r1);
        appendParam("previous_page", null, r1);
        appendParam("inflow_product_card_mode", this.b);
        Integer r2 = this.c;
        if (r2 == null) goto L6;
        String r3 = String.valueOf(r2.intValue());
        if (r3 == null) goto L6;
    L7:
        appendParam("is_inflow_auto_expand", r3);
        return;
    L6:
        r3 = "0";
        goto L7
    }

    public v0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
