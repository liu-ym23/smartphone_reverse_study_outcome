package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public Integer d;

    public static final class a {
    }

    static {
    }

    public k1() {
        super("product_slide_show");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, r0, r1);
        appendParam("module_label", this.b, r1);
        appendParam("slide_type", this.c, r1);
        Integer r2 = this.d;
        if (r2 == null) goto L5;
        String r3 = String.valueOf(r2.intValue());
    L6:
        appendParam("is_first_slide", r3, r1);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
