package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("label_content_type", "product_card", r0);
        appendParam("label_id", this.a, r0);
        appendParam("label_name", this.b, r0);
        appendParam("label_info", this.c, r0);
    }

    public p1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
