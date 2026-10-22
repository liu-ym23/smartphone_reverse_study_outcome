package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 extends com.bytedance.android.ec.core.event.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public final void buildParams() {
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a);
        appendParam("module_label", this.b);
        appendParam("author_id", this.c);
        appendParam("commodity_id", this.d);
        appendParam("commodity_type", this.e);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, this.f);
        appendParam("group_id", this.g);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.h);
        appendParam("ecom_entrance_form", this.i);
    }

    public a0(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "productId");
        Intrinsics.checkNotNullParameter(r3, "moduleLabel");
        Intrinsics.checkNotNullParameter(r4, "authorId");
        Intrinsics.checkNotNullParameter(r5, "commodityId");
        Intrinsics.checkNotNullParameter(r6, "commodityType");
        Intrinsics.checkNotNullParameter(r7, "followStatus");
        Intrinsics.checkNotNullParameter(r8, "groupId");
        Intrinsics.checkNotNullParameter(r9, "sourcePage");
        Intrinsics.checkNotNullParameter(r10, "ecomEntranceForm");
        super("comment_group_show");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
