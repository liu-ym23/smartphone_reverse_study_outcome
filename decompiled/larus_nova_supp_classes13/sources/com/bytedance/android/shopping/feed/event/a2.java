package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a2 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;

    public static final class a {
    }

    static {
    }

    public a2() {
        super("product_flow_page_guide_show");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("trigger", r0, r1);
        appendParam("EVENT_ORIGIN_FEATURE", "TEMAI", r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page", r1);
        appendParam("group_id", this.b, r1);
        appendParam("author_id", this.c, r1);
        appendParam(SimilarProductParam.ENTER_FROM, this.d, r1);
    }
}
