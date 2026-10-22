package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public static final class a {
    }

    static {
    }

    public x0() {
        super("inflow_rd_core_params_monitor");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("c_biz_combo", r0, r1);
        appendParam("buyin_track", this.b, r1);
        appendParam(PdpOpenThirdParam.KEY_ITEM_ID, this.c, r1);
        appendParam(PdpOpenThirdParam.KEY_PROMOTION_ID, this.d, r1);
        appendParam("author_id", this.e, r1);
        appendParam("request_id", this.f, r1);
        appendParam("user_id", this.g, r1);
        appendParam("is_preload", this.h, r1);
    }
}
