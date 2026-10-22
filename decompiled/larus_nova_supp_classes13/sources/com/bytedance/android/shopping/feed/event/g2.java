package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g2 extends com.bytedance.android.ec.core.event.a {
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
    public String k;
    public String l;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("duration", r0, r1);
        appendParam("author_id", this.b, r1);
        appendParam("source_method", null, r1);
        appendParam("carrier_source", null, r1);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, null, r1);
        appendParam("enter_method", null, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.c, r1);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, followStatus(null, this.b), r1);
        appendParam("entrance_info", null, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, null, r1);
        appendParam("group_id", null, r1);
        appendParam("commodity_id", null, r1);
        appendParam("commodity_type", null, r1);
        appendParam("search_id", this.e, r1);
        appendParam("entrance_info", null, r1);
        appendParam("entrance_location", this.d, r1);
        appendParam("which_account", null, r1);
        appendParam("brand_verified", this.f, r1);
        appendParam("shop_id", this.g, r1);
        appendParam("store_type", this.h, r1);
        appendParam("shop_label_name", null, r1);
        appendParam("inflow_product_card_mode", this.i);
        appendParam("display_rank", this.l);
        appendParam("click_area", this.k);
        appendParam("store_source_page", this.j);
    }

    public g2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
