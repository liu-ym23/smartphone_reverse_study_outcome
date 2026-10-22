package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ MoreVideoComponent a;

    public i(MoreVideoComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r7) {
        float r8 = ((Number) r7).floatValue();
        View r0 = this.a.e2();
        vg3.l r1 = (vg3.l) this.a.N1(vg3.l.class);
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r0.getVisibility() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L23;
        if (r2 == false) goto L23;
        if (r8 == 1.0f) goto L17;
    L19:
        if (r8 >= 1.0f) goto L23;
        if (r0.getAlpha() == 0.0f) goto L23;
        r0.setAlpha(0.0f);
        goto L23
    L17:
        if (r0.getAlpha() == 1.0f) goto L19;
        r0.setAlpha(1.0f);
    L23:
        float r3 = MoreVideoComponent.h2(this.a) + ((((Number) this.a.p.getValue()).intValue() - MoreVideoComponent.h2(this.a)) * (1 - r8));
        if (r8 >= 0) goto L26;
        r3 = ((Number) this.a.p.getValue()).intValue() + (((com.bytedance.android.shopping.prepurchase.business.pdp.e) this.a.O1().f().b).b.b * Math.abs(r8));
    L26:
        MoreVideoComponent r9 = this.a;
        float r5 = r3 - r9.n;
        r9.n = r3;
        MoreVideoComponent.b r10 = r9.m;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L29:
        r10.offsetTopAndBottom((int) r5);
        return;
    L11:
        r4 = false;
        goto L12
    L5:
        if (r1.s() != true) goto L7;
        r2 = true;
        goto L9
    }
}
