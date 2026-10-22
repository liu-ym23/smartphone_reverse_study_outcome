package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> implements g {
    public final /* synthetic */ StandardPrefService a;

    public c(xg3.d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        k r3 = (k) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if ((r3 instanceof k.c.b) == false) goto L5;
    L6:
        StandardPrefService r4 = this.a;
        if (r4.i == true) goto L9;
        r4.i = true;
        r4.l.onRenderStart();
    L9:
        this.a.m.a();
        return;
    L5:
        if ((r3 instanceof k.d) == true) goto L6;
    }
}
