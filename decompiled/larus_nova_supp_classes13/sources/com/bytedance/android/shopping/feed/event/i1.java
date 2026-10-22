package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        appendParam("entrance_location", String.valueOf(this.a));
        appendParam(SimilarProductParam.ENTER_FROM, this.b);
    }

    public i1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
