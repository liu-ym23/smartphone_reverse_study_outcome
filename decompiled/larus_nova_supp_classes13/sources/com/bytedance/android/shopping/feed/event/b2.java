package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b2 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public b2() {
        super("show_inflow_switch_tab");
    }

    public final void buildParams() {
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.a);
        appendParam("ecom_entrance_form", this.b);
        appendParam("author_id", this.c);
        appendParam("group_id", this.d);
        appendParam("inflow_product_card_mode", this.e);
    }
}
