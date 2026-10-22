package com.bytedance.android.shopping.buynow.eventcenter.handle;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends com.bytedance.kmp.ec.yata.event.common.b {
    public final ia3.a a;

    public static final class a {
    }

    static {
    }

    public m(ia3.a r1) {
        this.a = r1;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        ia3.a r4 = this.a;
        if (r4 == null) goto L5;
        r4.a.setVisibility(0);
    L5:
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
