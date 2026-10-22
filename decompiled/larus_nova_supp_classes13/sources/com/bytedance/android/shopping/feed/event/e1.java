package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public e1() {
        super("inflow_toast_show");
    }

    public final void buildParams() {
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, "product_detail", r0);
        appendParam(SimilarProductParam.ENTER_FROM, "ecom_video_product_inner", r0);
        appendParam("coupon_info", this.a);
        appendParam("coupon_id", this.b);
        appendParam("coupon_type", this.c);
    }
}
