package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t0 extends com.bytedance.android.ec.core.event.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, r0, r1);
        appendParam("module_label", this.b, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.c, r1);
        appendParam("author_id", this.d, r1);
        appendParam("commodity_id", this.e, r1);
        appendParam("commodity_type", this.f, r1);
        appendParam("group_id", this.g, r1);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.h, r1);
        appendParam("chnid", this.i, r1);
        String r2 = this.j;
        if (r2 == null) goto L6;
        appendParam("btm_id", r2, r1);
        return;
    }

    public t0(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        super("inflow_big_sale_entrance_click");
        this.a = r2;
        this.b = r3;
        this.c = "product_flow_page";
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
