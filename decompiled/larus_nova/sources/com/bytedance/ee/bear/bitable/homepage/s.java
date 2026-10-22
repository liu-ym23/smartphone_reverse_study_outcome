package com.bytedance.ee.bear.bitable.homepage;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class s implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f213086a;

    public s(RoundFrameLayout r100) {
        this.f213086a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        View r101 = this.f213086a;
        Integer r102 = null;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L7:
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L10:
        int r105 = 0;
        if (r104 == null) goto L20;
        Object r106 = r100.getAnimatedValue();
        if ((r106 instanceof Integer) == false) goto L15;
        Integer r107 = (Integer) r106;
    L16:
        if (r107 == null) goto L18;
        int r108 = r107.intValue();
    L19:
        r104.leftMargin = r108;
        goto L20
    L18:
        r108 = 0;
        goto L19
    L15:
        r107 = null;
    L20:
        if (r104 == null) goto L28;
        Object r109 = r100.getAnimatedValue();
        if ((r109 instanceof Integer) == false) goto L24;
        r102 = (Integer) r109;
    L24:
        if (r102 == null) goto L26;
        r105 = r102.intValue();
    L26:
        r104.rightMargin = r105;
        return;
    L28:
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }
}
