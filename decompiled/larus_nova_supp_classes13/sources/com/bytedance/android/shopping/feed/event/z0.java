package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a);
        appendParam("search_words_group", this.b);
        appendParam("module_label", "guess_you_like_product");
        appendParam("search_words_content", this.c);
    }

    public z0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
    }
}
