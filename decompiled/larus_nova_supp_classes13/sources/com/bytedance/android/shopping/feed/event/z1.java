package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public static final class a {
    }

    static {
    }

    public z1() {
        super("show_exchange_coupon_entrance");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, r0, r1);
        appendParam("previous_page", this.b, r1);
        appendParam("panel_name", this.c, r1);
        appendParam("exchange_coupon_activity_name", this.d, r1);
        appendParam("content_id", this.e, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.f, r1);
    }
}
