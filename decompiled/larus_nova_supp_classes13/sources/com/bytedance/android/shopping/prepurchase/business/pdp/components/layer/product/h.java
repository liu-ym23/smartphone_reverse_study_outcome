package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {
    public final /* synthetic */ ji3.i a;

    public h(ji3.i r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4 != Lifecycle.Event.ON_START) goto L6;
        ji3.i r5 = this.a;
        r5.a = true;
        r5.a(r5.e);
    L6:
        if (r4 != Lifecycle.Event.ON_STOP) goto L9;
        ji3.i r6 = this.a;
        r6.a = false;
        r6.b.removeCallbacks(r6.c);
        return;
    }
}
