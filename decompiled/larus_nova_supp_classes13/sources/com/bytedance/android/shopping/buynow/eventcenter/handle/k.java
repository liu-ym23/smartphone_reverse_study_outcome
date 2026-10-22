package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.kmp.ec.yata.event.common.a {
    public final ia3.b a;

    public static final class a {
    }

    static {
    }

    public k(ia3.b r1) {
        this.a = r1;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "chainNextCallback");
        BuyNowLog.d("selfLoading", "selfLoading starts");
        Map r6 = r4.q();
        if (r6 == null) goto L9;
        Object r7 = r6.get("flag");
        if (r7 == null) goto L9;
        String r8 = r7.toString();
        if (r8 == null) goto L9;
        boolean r9 = com.bytedance.android.shopping.extensions.k.n(r8, false);
    L10:
        if (r9 == false) goto L14;
        ia3.b r10 = this.a;
        if (r10 == null) goto L17;
        r10.b(new ia3.c(false, false));
    L17:
        BuyNowLog.d("selfLoading", "selfLoading finishes");
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r5.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L14:
        ia3.b r12 = this.a;
        if (r12 == null) goto L17;
        r12.c();
    L9:
        r9 = false;
        goto L10
    }
}
