package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public Integer g;
    public String h;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("author_id", r0, r1);
        appendParam("group_id", this.e, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.b, r1);
        appendParam(PdpOpenThirdParam.KEY_PROMOTION_ID, this.c, r1);
        appendParam(SimilarProductParam.ENTER_FROM, this.d, r1);
        appendParam("log_id", this.f, r1);
        Integer r2 = this.g;
        if (r2 == null) goto L5;
        String r3 = String.valueOf(r2.intValue());
    L6:
        appendParam("status_code", r3, r1);
        appendParam("status_msg", this.h, r1);
        appendParam("log_id", this.f, r1);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public m1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
