package com.bytedance.android.shopping.buynow.ultimate.func;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowFragment a;

    public static final class a {
    }

    static {
    }

    public m(BuyNowFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "chainNextCallback");
        View r0 = this.a.getView();
        if (r0 == null) goto L5;
        RecyclerView r1 = (RecyclerView) r0.findViewById(2131364334);
    L6:
        BuyNowFragment r2 = this.a;
        SlcRenderContext r3 = r2.r;
        if (r1 == null) goto L10;
        if (r3 == null) goto L10;
        r2.W90().getSkuService().y(r5, r1, r3);
    L10:
        int r7 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r6.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
