package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public Integer k;
    public String l;

    public static final class a {
    }

    static {
    }

    public o0() {
        super("share_product");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("group_id", r0, r1);
        appendParam("commodity_id", this.b, r1);
        appendParam("author_id", this.c, r1);
        appendParam(PdpOpenThirdParam.KEY_CARRIER_TYPE, this.d, r1);
        appendParam("commodity_type", this.e, r1);
        appendParam("platform", null, r1);
        appendParam("to_user_id", null, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.f, r1);
        appendParam("source_method", this.h, r1);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.g, r1);
        appendParam("previous_page", null, r1);
        appendParam("enter_method", this.i, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.j, r1);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, followStatus(this.k, this.c), r1);
        appendParam("share_third_party", null, r1);
        appendParam("carrier_source", this.l, r1);
    }
}
