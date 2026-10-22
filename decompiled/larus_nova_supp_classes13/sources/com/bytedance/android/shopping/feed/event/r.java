package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends com.bytedance.android.ec.core.event.a {
    public String a;

    public static final class a {
    }

    static {
    }

    public r() {
        super("click_cart");
    }

    public final void buildParams() {
        appendParam("inflow_product_card_mode", this.a);
    }
}
