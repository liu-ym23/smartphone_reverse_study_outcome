package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends b {
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;

    public e() {
        super("click_add_to_cart");
    }

    @Override // jd3.b
    public final void buildParams() {
        super.buildParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("product_activity_type", null, r0);
        appendParam("cash_rebate", this.d, r0);
        appendParam("cash_rebate_id", this.c, r0);
        appendParam("page_type", this.e, r0);
        appendParam("cid", this.f, r0);
        appendParam("shop_id", this.g, r0);
        appendParam("base_verified_category", null, r0);
        appendParam("with_sku", this.h, r0);
        String r1 = this.i;
        if (r1 != null) goto L5;
        r1 = new JSONObject().toString();
    L5:
        appendParam("search_params", r1, r0);
        appendParam("previous_page", this.j, r0);
        appendParam("ecom_group_type", this.k, r0);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.l, r0);
        String r2 = this.m;
        if (r2 == null) goto L8;
        appendParam("module_label", r2, r0);
    L8:
        appendParam("inflow_product_card_mode", this.n);
        appendParam("cost_price", this.o, r0);
        appendParam("real_price", this.p, r0);
        appendParam("min_sku_price", this.q, r0);
        appendParam("max_sku_price", this.r, r0);
        appendParam("bst_group_type", this.s, r0);
    }
}
