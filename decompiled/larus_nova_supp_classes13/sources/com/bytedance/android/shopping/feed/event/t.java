package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t extends com.bytedance.android.ec.core.event.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final Integer v;
    public final String w;
    public final String x;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("carrier_source", r0, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page", r1);
        appendParam("ecom_type", this.b, r1);
        appendParam("display_rank", this.c, r1);
        appendParam("click_area", this.d, r1);
        appendParam("recommend_info", this.e, r1);
        appendParam("module_label", this.i, r1);
        appendParam("request_id", this.f, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.g, r1);
        appendParam(SimilarProductParam.ENTER_FROM, this.a, r1);
        appendParam("group_id", this.k, r1);
        appendParam("previous_page", this.h, r1);
        appendParam("chnid", this.j, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.l, r1);
        String r2 = this.p;
        if (r2 == null) goto L5;
        appendParam("btm_id", r2, r1);
    L5:
        appendParam("coupon_id", this.m, r1);
        appendParam("coupon_value", this.n, r1);
        appendParam("inflow_coupon_type", this.o, r1);
        appendParam("ecom_mall_type", this.q);
        appendParam("is_category", this.r, r1);
        appendParam("category_name", this.s, r1);
        String r3 = this.t;
        if (r3 == null) goto L8;
        appendParam("product_id_group", r3, r1);
    L8:
        String r4 = this.u;
        if (r4 == null) goto L11;
        appendParam("bsk", r4, r1);
    L11:
        Integer r5 = this.v;
        if (r5 == null) goto L15;
        String r6 = String.valueOf(r5.intValue());
        if (r6 == null) goto L15;
    L16:
        appendParam("is_inflow_auto_expand", r6);
        appendParam("resource_id", this.w, r1);
        appendParam("mall_enter_from", this.x, r1);
        return;
    L15:
        r6 = "0";
        goto L16
    }

    public t(String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, Integer r28, String r29, String r30) {
        Intrinsics.checkNotNullParameter(r8, "carrierSource");
        Intrinsics.checkNotNullParameter(r9, "ecomType");
        Intrinsics.checkNotNullParameter(r10, "displayRank");
        Intrinsics.checkNotNullParameter(r11, "clickArea");
        Intrinsics.checkNotNullParameter(r12, "recommendInfo");
        super("click_ecom_inflow_card");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = null;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r21;
        this.p = r22;
        this.q = r23;
        this.r = r24;
        this.s = r25;
        this.t = r26;
        this.u = r27;
        this.v = r28;
        this.w = r29;
        this.x = r30;
    }
}
