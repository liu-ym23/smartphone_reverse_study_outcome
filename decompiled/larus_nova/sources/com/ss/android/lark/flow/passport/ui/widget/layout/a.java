package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f423877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommonContainerLayout f423878b;

    public a(View r100, CommonContainerLayout r101) {
        this.f423877a = r100;
        this.f423878b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (this.f423877a != null) goto L5;
        return;
    L5:
        this.f423878b.getFooterContainer().getLocationOnScreen(this.f423878b.f423863c);
        CommonContainerLayout r101 = this.f423878b;
        int r102 = r101.f423863c[1];
        int r103 = r101.R5(this.f423877a) - r102;
        if (r103 <= 0) goto L9;
        this.f423878b.getContentScrollView().scrollBy(0, r103);
        return;
    }
}
