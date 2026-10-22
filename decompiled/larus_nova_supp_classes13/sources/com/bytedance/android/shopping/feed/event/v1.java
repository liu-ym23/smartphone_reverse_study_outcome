package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v1 extends com.bytedance.android.ec.core.event.a {
    public String a;

    public static final class a {
    }

    static {
    }

    public v1() {
        super("show_cart_entrance");
    }

    public final void buildParams() {
        appendParam("inflow_product_card_mode", this.a);
    }
}
