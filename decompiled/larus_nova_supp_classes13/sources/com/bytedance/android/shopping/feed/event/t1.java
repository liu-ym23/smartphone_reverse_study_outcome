package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public Integer c;
    public String d;

    public static final class a {
    }

    static {
    }

    public t1() {
        super("scrolling_info");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, r0, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.b, r1);
        Integer r2 = this.c;
        if (r2 != null) goto L6;
    L8:
        if (r2 != null) goto L11;
    L13:
        if (r2 != null) goto L16;
    L18:
        String r3 = "";
    L19:
        appendParam("info_type", r3, r1);
        appendParam("group_id", this.d, r1);
        return;
    L16:
        if (r2.intValue() != 1000) goto L18;
        r3 = "coupon";
        goto L19
    L11:
        if (r2.intValue() != 2) goto L13;
        r3 = "comment";
        goto L19
    L6:
        if (r2.intValue() != 1) goto L8;
        r3 = "purchase";
        goto L19
    }
}
