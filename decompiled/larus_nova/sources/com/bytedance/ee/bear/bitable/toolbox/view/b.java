package com.bytedance.ee.bear.bitable.toolbox.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableToolboxFragment f216036a;

    public b(BitableToolboxFragment r100) {
        this.f216036a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LinearLayout r101 = this.f216036a.f216010g;
        LinearLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        Object r104 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Float");
        r103.height = (int) ((Float) r104).floatValue();
        LinearLayout r105 = this.f216036a.f216010g;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
    L9:
        r102.setLayoutParams(r103);
        return;
    L8:
        r102 = r105;
        goto L9
    }
}
