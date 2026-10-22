package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("EVENT_ORIGIN_FEATURE", "TEMAI", r0);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page", r0);
        appendParam("group_id", this.a, r0);
        appendParam("amount", this.b, r0);
        appendParam("expired_minute", this.c, r0);
        appendParam("benefit_type", null, r0);
    }

    public y0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
