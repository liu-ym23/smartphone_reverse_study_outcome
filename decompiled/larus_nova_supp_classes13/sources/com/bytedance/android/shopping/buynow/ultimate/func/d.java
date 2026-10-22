package com.bytedance.android.shopping.buynow.ultimate.func;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.kmp.ec.yata.event.common.a {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "chainNextCallback");
        BuyNowLog.d("selfDoNothing", "selfDoNothing");
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r4.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
