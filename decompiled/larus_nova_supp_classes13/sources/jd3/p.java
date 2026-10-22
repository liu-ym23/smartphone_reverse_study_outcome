package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p extends com.bytedance.android.ec.core.event.a {
    public String a;
    public final String b;
    public final String c;
    public String d;
    public String e;
    public String f;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("duration", r0, r1);
        appendParam("final_status", null, r1);
        appendParam("from_group_id", null, r1);
        appendParam("author_id", null, r1);
        appendParam("room_id", null, r1);
        appendParam("live_group_id", null, r1);
        appendParam("source_method", null, r1);
        appendParam("carrier_source", null, r1);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, null, r1);
        appendParam("previous_page", null, r1);
        appendParam("enter_method", null, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, null, r1);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, followStatus(null, null), r1);
        appendParam("entrance_info", null, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, null, r1);
        appendParam("group_id", null, r1);
        appendParam("commodity_id", null, r1);
        appendParam("commodity_type", null, r1);
        appendParam("virtual_commodity_flag", this.b, r1);
        appendParam("with_coupon", this.c, r1);
        appendParam("button_status", null, r1);
        appendParam("search_id", this.d, r1);
        appendParam("entrance_info", null, r1);
        appendParam("page_type", this.e, r1);
        appendParam("ecom_message_show_pv", null, r1);
        appendParam("close_method", this.f, r1);
    }

    public p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
        this.b = "0";
        this.c = "0";
    }
}
