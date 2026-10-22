package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("carrier_source", r0, r1);
        appendParam("ecom_entrance_form", this.b, r1);
        appendParam("ecom_group_type", this.c, r1);
    }

    public n0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
