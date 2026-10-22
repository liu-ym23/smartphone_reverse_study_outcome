package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public static final class a {
    }

    static {
    }

    public s() {
        super("click_comment_button");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("request_id", r0, r1);
        appendParam(SimilarProductParam.ENTER_FROM, this.b, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.c, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.d, r1);
        appendParam("group_id", this.e, r1);
        appendParam("module_label", this.f, r1);
        appendParam("inflow_product_card_mode", this.g);
    }
}
