package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.view.FloatingTagLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<h83.c> {
    public FloatingTagLayout i;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r5) {
        Intrinsics.checkNotNullParameter(r5, "nodeVO");
        return new h83.c(r5.b, r5.g, r5.u, r5.v);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b, com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void i(float r4) {
        FloatingTagLayout r0 = this.i;
        if (r0 == null) goto L8;
        Iterator r1 = ((ArrayList) r0.c).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((Function1) r1.next()).invoke(Float.valueOf(r4));
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View w(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r9) {
        h83.c r10 = (h83.c) r9;
        if (r10 == null) goto L5;
        CombinationVO r1 = r10.b;
    L6:
        if (r1 == null) goto L10;
        FloatingTagLayout r2 = new FloatingTagLayout(getContext(), null, 6, 0);
        r2.a(r10.b, r10.c, new i(this), r10.d, this.g);
        this.i = r2;
        return r2;
    L10:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public j(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
