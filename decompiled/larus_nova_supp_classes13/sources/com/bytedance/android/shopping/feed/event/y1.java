package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y1 extends com.bytedance.android.ec.core.event.a {
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
        appendParam("recommend_info", this.d, r1);
        appendParam("module_label", this.i, r1);
        appendParam("request_id", this.e, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.f, r1);
        appendParam("previous_page", this.g, r1);
        appendParam("group_id", this.h, r1);
        appendParam(SimilarProductParam.ENTER_FROM, this.a, r1);
        appendParam("chnid", this.j, r1);
        appendParam("product_id_group", this.k, r1);
        appendParam("ecom_mall_type", this.l);
        appendParam("inflow_coupon_type", this.m, r1);
        appendParam("coupon_id", this.n, r1);
        appendParam("coupon_value", this.o, r1);
        appendParam("is_category", this.p, r1);
        appendParam("category_name", this.q, r1);
        appendParam("resource_id", this.s, r1);
        appendParam("mall_enter_from", this.t, r1);
        String r2 = this.r;
        if (r2 == null) goto L6;
        appendParam("bsk", r2, r1);
        return;
    }

    public final String getType() {
        return this.b;
    }

    public y1(String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r7, "carrierSource");
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r9, "displayRank");
        Intrinsics.checkNotNullParameter(r10, "recommendInfo");
        super("show_ecom_inflow_card");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
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
    }
}
