package com.bytedance.ee.bear.bitable.homepage;

import android.animation.ValueAnimator;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoundFrameLayout f213087a;

    public t(RoundFrameLayout r100) {
        this.f213087a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Integer) == false) goto L5;
        Integer r102 = (Integer) r101;
    L6:
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L9:
        RoundFrameLayout r104 = this.f213087a;
        if (r104 == null) goto L13;
        r104.a(r103, r103, r103, r103);
        return;
    L13:
        return;
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }
}
