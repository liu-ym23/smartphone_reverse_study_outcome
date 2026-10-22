package com.bytedance.android.shopping.buynow.ultimate.func;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowFragment a;

    public static final class a {
    }

    static {
    }

    public i(BuyNowFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        PageFinder r0 = this.a.W90().getStaticState().d;
        if (r0 != null) goto L6;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "pageFinder is null", null, null, 57));
        return;
    L6:
        com.bytedance.android.shopping.sku.common.ability.b r1 = this.a.W90().getSkuService();
        FragmentActivity r2 = this.a.requireActivity();
        Float r3 = this.a.W90().getStaticState().f;
        if (r3 == null) goto L9;
        float r4 = r3.floatValue();
    L10:
        r1.k(r2, r7, r0, (int) (r4 * 100.0f));
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L9:
        r4 = 0.73f;
        goto L10
    }
}
