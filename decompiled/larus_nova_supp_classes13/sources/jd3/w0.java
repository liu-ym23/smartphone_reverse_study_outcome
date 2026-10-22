package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public Integer b;
    public String c;
    public String d;
    public String e;

    public static final class a {
    }

    static {
    }

    public w0() {
        super("slide_product_main_picture");
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("commodity_id", null, r0);
        appendParam("commodity_type", null, r0);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, null, r0);
        appendParam(PdpOpenThirdParam.KEY_CARRIER_TYPE, null, r0);
        appendParam("group_id", null, r0);
        appendParam("author_id", null, r0);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, null, r0);
        appendParam("source_method", null, r0);
        appendParam("previous_page", null, r0);
        appendParam("enter_method", null, r0);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a, r0);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, followStatus(null, null), r0);
        Integer r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = String.valueOf(r1.intValue());
    L6:
        appendParam("item_order", r2, r0);
        appendParam("search_id", this.c, r0);
        appendParam("entrance_info", null, r0);
        appendParam("carrier_source", null, r0);
        appendParam("page_type", this.d, r0);
        String r3 = this.e;
        if (r3 == null) goto L10;
        appendParam("module_label", r3, r0);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
