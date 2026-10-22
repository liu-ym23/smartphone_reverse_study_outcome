package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static final class a {
    }

    static {
    }

    public e() {
        super("add_cart_toast_show");
    }

    public final void buildParams() {
        appendParam("module_label", this.a);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, null);
        appendParam("ecom_group_type", this.b);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, null);
        appendParam("ecom_entrance_form", null);
        appendParam("author_id", null);
        appendParam("group_id", null);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, null);
        appendParam("commodity_id", this.c);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.d);
        appendParam("commodity_type", this.e);
    }
}
