package com.bytedance.android.shopping.yata.business.function;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.yata.business.function.a$a, reason: collision with other inner class name */
    public static final class C0025a {
    }

    static {
    }

    public a(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        ll3.a.a("selfCloseDialog", "selfCloseDialog starts");
        this.a.b().k(false);
        ll3.a.a("selfCloseDialog", "selfCloseDialog finishes");
        int r4 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
