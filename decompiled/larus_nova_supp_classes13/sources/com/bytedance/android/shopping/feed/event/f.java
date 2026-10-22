package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static final class a {
    }

    static {
    }

    public f() {
        super("aftersale_information_right");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, r0, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.b, r1);
        appendParam("group_id", this.c, r1);
        appendParam("text", this.d, r1);
        appendParam("module_label", this.e, r1);
    }
}
