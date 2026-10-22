package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0 extends com.bytedance.android.ec.core.event.a {
    public Integer a;
    public String b;
    public String c;
    public String d;

    public static final class a {
    }

    static {
    }

    public d0() {
        super("enter_product_flow_page_fail");
    }

    public final void buildParams() {
        Integer r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = String.valueOf(r0.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r2 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("status_code", r1, r2);
        appendParam("status_msg", this.b, r2);
        appendParam("is_preload", this.d, r2);
        appendParam("log_id", this.c, r2);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
