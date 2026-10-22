package jd3;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public g0() {
        super("presell_reserve_success_show");
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("carrier_source", null, r0);
        appendParam("is_special", this.a, r0);
        appendParam("campaign_sub_type", null, r0);
        appendParam("page_type", this.b, r0);
        appendParam(SimilarProductParam.ENTER_FROM, this.c, r0);
        appendParam("product_flow_type", null, r0);
    }
}
