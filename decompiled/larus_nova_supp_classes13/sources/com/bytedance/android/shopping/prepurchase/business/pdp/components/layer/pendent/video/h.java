package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3 != Lifecycle.Event.ON_PAUSE) goto L10;
        i.a r4 = this.a.c;
        if (r4 == null) goto L10;
        s r5 = r4.b;
        if (r5 == null) goto L10;
        r5.Q0();
    L10:
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L17;
        i.a r6 = this.a.c;
        if (r6 == null) goto L18;
        s r7 = r6.b;
        if (r7 == null) goto L19;
        r7.onPageDestroy();
        return;
    L19:
        return;
    L18:
        return;
    }
}
