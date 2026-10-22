package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j2 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("request_id", r0, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.b, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.c, r1);
        appendParam("group_id", this.d, r1);
        appendParam("module_label", this.e, r1);
        appendParam("carrier_source", this.f, r1);
        appendParam("ecom_group_type", this.g, r1);
        appendParam("inflow_product_card_mode", this.h);
        appendParam("cost_price", this.i, r1);
        appendParam("real_price", this.j, r1);
        appendParam("min_sku_price", this.k, r1);
        appendParam("max_sku_price", this.l, r1);
    }

    public j2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
    }
}
