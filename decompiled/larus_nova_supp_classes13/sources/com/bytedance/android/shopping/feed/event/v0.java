package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v0 extends com.bytedance.android.ec.core.event.a {
    public int a;
    public String b;
    public int c;
    public String d;

    public static final class a {
    }

    static {
    }

    public v0() {
        super("inflow_ngroup_product_click");
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("EVENT_ORIGIN_FEATURE", "TEMAI", r0);
        appendParam("module_label", this.d, r0);
        appendParam("is_multigroupbuying", String.valueOf(this.a), r0);
        appendParam("multigroupbuying_state", this.b, r0);
        appendParam("ngroup_buy_type", String.valueOf(this.c), r0);
    }
}
