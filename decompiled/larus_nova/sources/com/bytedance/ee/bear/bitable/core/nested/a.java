package com.bytedance.ee.bear.bitable.core.nested;

import android.animation.ValueAnimator;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f210585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f210586b;

    public a(AppBarLayout r100) {
        this.f210586b = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        int r102 = ((Integer) r101).intValue();
        if (this.f210586b.getTop() >= Math.abs(this.f210585a - r102)) goto L5;
        int r103 = -this.f210586b.getTop();
    L6:
        ViewCompat.offsetTopAndBottom(this.f210586b, r103);
        this.f210585a = r102;
        return;
    L5:
        r103 = this.f210585a - r102;
        goto L6
    }
}
