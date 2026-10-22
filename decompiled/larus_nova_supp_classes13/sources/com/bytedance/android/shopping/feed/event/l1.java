package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("base_verified_category", null, r0);
        appendParam("brand_verified", this.a, r0);
        appendParam("page_type", this.b, r0);
    }

    public l1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
    }
}
