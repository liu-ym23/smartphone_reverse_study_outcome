package com.bytedance.ee.bear.profile;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.facade.common.widget.d.b {
    public final /* synthetic */ j a;
    public final /* synthetic */ HalfProfileActivity b;

    public c(j r1, HalfProfileActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(int r4) {
        View r0 = ((com.bytedance.ee.bear.facade.common.widget.d) this.a).e;
        if (r0 == null) goto L5;
        Float r1 = Float.valueOf(r0.getTranslationY());
    L7:
        if (Intrinsics.areEqual(r1, 0.0f) == false) goto L9;
        HalfProfileActivity r5 = this.b;
        int r2 = HalfProfileActivity.q;
        r5.D1(true, true);
        return;
    L9:
        if (r4 != 0) goto L11;
        this.b.finish();
        return;
    L11:
        HalfProfileActivity r6 = this.b;
        ValueAnimator r3 = ((com.bytedance.ee.bear.facade.common.widget.d) this.a).f;
        if (r3 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        r6.D1(false, !r7);
        return;
    L14:
        if (r3.isRunning() != true) goto L16;
        r7 = true;
        goto L17
    L5:
        r1 = null;
        goto L7
    }
}
