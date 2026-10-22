package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, r0, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.b, r1);
        appendParam("commodity_id", this.c, r1);
        appendParam("commodity_type", this.d, r1);
    }

    public d1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
    }
}
