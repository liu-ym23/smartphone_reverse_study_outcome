package com.bytedance.android.shopping.buynow.container;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.buynow.controller.q;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ BuyNowFragment a;

    public h(BuyNowFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        BuyNowFragment r6 = this.a;
        q r0 = r6.o;
        if (r0 != null) goto L5;
    L7:
        int r1 = com.bytedance.android.shopping.buynow.controller.f.a;
        Context r7 = r6.getContext();
        BuyNowFragment r2 = this.a;
        AndroidYaTaInstance r3 = r2.q;
        boolean r4 = r2.W90().getStaticState().c();
        Intrinsics.checkNotNullParameter(r2, "fragment");
        if (r4 == true) goto L10;
    L12:
        com.bytedance.android.shopping.buynow.controller.f.b(r7, BuyNowCloseMethod.MASK, r2);
        return;
    L10:
        if (com.bytedance.android.shopping.buynow.controller.f.d(r3) == false) goto L12;
        return;
    L5:
        if (r0.b == true) goto L7;
    }
}
