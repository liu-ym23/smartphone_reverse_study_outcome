package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;

    public r0() {
        super("show_ecom_similar");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("ecom_type", r0, r1);
        appendParam("enter_method", this.b, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.c, r1);
        appendParam("commodity_type", this.d, r1);
    }
}
