package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u0 extends jd3.s {
    public String G1;
    public String H1;
    public String L1;
    public String M1;
    public String P1;
    public String Q1;
    public String S1;
    public String T1;
    public String V1;
    public String b2;
    public Integer g2;
    public String h2;
    public String k1;
    public String p1;
    public String p2;
    public String v1;
    public final String v2;
    public String x1;
    public final String x2;
    public String y1;

    @Override // jd3.s
    public final void buildParams() {
        super.buildParams();
        String r0 = this.x2;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("ecom_type", r0, r1);
        String r2 = this.p1;
        if (r2 == null) goto L5;
        appendParam("share_content", r2, r1);
    L5:
        String r3 = this.k1;
        if (r3 == null) goto L8;
        appendParam("share_object", r3, r1);
    L8:
        appendParam("is_show_inflow_video", this.v1, r1);
        appendParam("inflow_recommend_type", this.x1, r1);
        appendParam("inflow_product_card_mode", this.y1);
        appendParam("module_label", this.v, r1);
        appendParam("cost_price", this.G1, r1);
        appendParam("real_price", this.H1, r1);
        appendParam("min_sku_price", this.L1, r1);
        appendParam("max_sku_price", this.M1, r1);
        appendParam("display_rank", this.w, r1);
        appendParam("user_type", this.P1, r1);
        appendParam("coupon_name", this.Q1, r1);
        appendParam("new_gift_type", this.S1, r1);
        appendParam("discount_activity_type", this.T1, r1);
        appendParam("discount_activity_id", this.V1, r1);
        appendParam("price_type", this.b2, r1);
        Integer r4 = this.g2;
        if (r4 == null) goto L12;
        String r5 = String.valueOf(r4.intValue());
        if (r5 == null) goto L12;
    L13:
        appendParam("is_inflow_auto_expand", r5);
        if (ECSettingKeys.g0() == false) goto L17;
        appendParam("standard_track_param", this.h2, r1);
        appendParam("standard_product_marketing_param", this.p2, r1);
        return;
    L17:
        return;
    L12:
        r5 = "0";
        goto L13
    }

    public final String getCheckScriptPath() {
        return VmSdkSetting.a().k();
    }

    public final String getCheckScene() {
        return this.v2;
    }

    public u0(String r1) {
        this.x2 = r1;
        this.v1 = "0";
        this.v2 = "click_product";
    }
}
