package com.bytedance.android.shopping.prepurchase.business.pdp.debug;

import com.bytedance.android.shopping.anchorv4.helper.JisooManager;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e;
import kotlin.jvm.internal.Intrinsics;
import vg3.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements o {
    public final JissoAbilityImpl$jisooListener$1 a;
    public final j b;
    public final e c;

    @Override // vg3.o
    public final boolean isEnable() {
        return JisooManager.d.a();
    }

    public a(j r2, ProductDetailDebugComponent r3) {
        Intrinsics.checkNotNullParameter(r2, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        this.b = r2;
        this.c = r3;
        if (JisooManager.d.a() == false) goto L5;
        JissoAbilityImpl$jisooListener$1 r4 = new JissoAbilityImpl$jisooListener$1(this);
    L6:
        this.a = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
