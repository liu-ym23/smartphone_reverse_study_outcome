package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.animation.ValueAnimator;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.service.ECAnchorV3Service;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ LastPageVideoZoomer a;
    public final /* synthetic */ CompatFrameLayout b;

    public j(LastPageVideoZoomer r1, CompatFrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r5) {
        float r6 = ((Number) r5).floatValue();
        LastPageVideoZoomer r0 = this.a;
        r0.c = r6;
        ValueAnimator r1 = r0.b;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L6:
        ValueAnimator r3 = r0.f;
        if (r3 != null) goto L9;
    L11:
        r2 = false;
    L12:
        if (r2 == true) goto L14;
        LastPageVideoZoomer.b(this.a, r6, this.b);
    L14:
        LastPageVideoZoomer r4 = this.a;
        if (r4.e == true) goto L22;
        String r7 = LastPageVideoZoomer.a(r4);
        if (r7 == null) goto L24;
        Iterator<Function2<String, Float, Unit>> r8 = ECAnchorV3Service.a.iterator();
    L20:
        if (r8.hasNext() == false) goto L25;
        r8.next().invoke(r7, Float.valueOf(r6));
        goto L20
    L25:
        return;
    L24:
        return;
    L22:
        return;
    L9:
        if (r3.isRunning() != true) goto L11;
    L5:
        if (r1.isRunning() == true) goto L12;
        goto L6
    }
}
