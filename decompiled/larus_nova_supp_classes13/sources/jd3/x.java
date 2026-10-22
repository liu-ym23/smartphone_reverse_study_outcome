package jd3;

import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public final String c;
    public final String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;

    public static final class a {
    }

    static {
    }

    public x() {
        super("groupbuying_rule_click");
        this.c = "0";
        this.d = "0";
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        String r2 = null;
        appendParam("group_id", null, r0);
        appendParam("enter_method", null, r0);
        appendParam("author_id", this.a, r0);
        appendParam("commodity_id", null, r0);
        appendParam("commodity_type", null, r0);
        appendParam(PdpOpenThirdParam.KEY_CARRIER_TYPE, null, r0);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, null, r0);
        appendParam("order_type", null, r0);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, followStatus(null, this.a), r0);
        appendParam("is_self", null, r0);
        appendParam("search_keyword", null, r0);
        appendParam("button_status", null, r0);
        appendParam("log_pb", null, r0);
        appendParam("previous_page", null, r0);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, null, r0);
        appendParam("search_id", this.b, r0);
        appendParam("entrance_info", null, r0);
        appendParam("room_id", null, r0);
        appendParam("live_group_id", null, r0);
        appendParam("source_method", null, r0);
        appendParam("carrier_source", null, r0);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, null, r0);
        appendParam("virtual_commodity_flag", this.c, r0);
        appendParam("with_coupon", this.d, r0);
        appendParam("is_receptor", this.e, r0);
        appendParam("ecom_tag_activity_id", null, r0);
        appendParam("ecom_tag_activity_type", null, r0);
        appendParam("product_activity_type", null, r0);
        appendParam("live_list_channel", null, r0);
        appendParam("auto_coupon", String.valueOf(this.f), r0);
        appendParam("page_type", this.g, r0);
        appendParam("cash_rebate", this.i, r0);
        appendParam("cash_rebate_id", this.h, r0);
        appendParam("avl_discount", this.j, r0);
        appendParam("which_account", this.k, r0);
        appendParam("cid", this.l, r0);
        appendParam("params_for_special", "tppp", r0);
        appendParam("is_special", this.m, r0);
        appendParam("is_groupbuying", this.n, r0);
        ECAdInfo r1 = ih3.g.b.A(this.a);
        if (r1 == null) goto L9;
        Long r4 = r1.getCid();
        if (r4 == null) goto L7;
        r2 = String.valueOf(r4.longValue());
    L7:
        appendParam("cid", r2, r0);
        appendParam("log_extra", r1.getLogExtra(), r0);
        return;
    }
}
