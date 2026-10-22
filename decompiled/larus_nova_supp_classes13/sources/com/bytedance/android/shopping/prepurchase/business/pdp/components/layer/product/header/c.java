package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.w;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import kotlin.jvm.internal.Intrinsics;
import vg3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements w {
    public final j a;

    public c(j r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceRegistry");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.w
    public final void y(d r3, Object r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "watcher");
        Intrinsics.checkNotNullParameter(r4, "identifier");
        m r0 = (m) this.a.getService(m.class);
        if (r0 == null) goto L6;
        r0.y(r3, r4, r5);
        return;
    }
}
