package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w0 extends com.bytedance.android.ec.core.event.a {
    public int a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public w0() {
        super("inflow_ngroup_product_show");
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("EVENT_ORIGIN_FEATURE", "TEMAI", r0);
        appendParam("module_label", this.c, r0);
        appendParam("is_multigroupbuying", String.valueOf(this.a), r0);
        appendParam("multigroupbuying_state", this.b, r0);
    }
}
