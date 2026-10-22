package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends com.bytedance.kmp.ec.yata.event.common.b {
    public final AndroidYaTaInstance a;
    public final BuyNowViewModel b;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Object r0 = r7.p(Reflection.getOrCreateKotlinClass(String.class), "filter_key");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfMultiRegexCheck", "filter key is null or empty", r7);
        int r8 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "filter key is null or empty", null, null, 57);
    L15:
        com.bytedance.android.shopping.buynow.eventcenter.common.b r3 = com.bytedance.android.shopping.buynow.eventcenter.common.b.a;
        AndroidYaTaInstance r4 = this.a;
        BuyNowViewModel r5 = this.b;
        r3.getClass();
        return com.bytedance.android.shopping.buynow.eventcenter.common.b.a(r4, r5, r7, r1);
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public l(AndroidYaTaInstance r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "yataInstance");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }
}
