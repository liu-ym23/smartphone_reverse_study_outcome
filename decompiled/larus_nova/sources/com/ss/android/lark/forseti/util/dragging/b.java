package com.ss.android.lark.forseti.util.dragging;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f424614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f424615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f424616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC5019a f424617d;

    public b(ForsetiNormalChainDraggingView r100, float r101, float r102, a.InterfaceC5019a r103) {
        this.f424614a = r100;
        this.f424615b = r101;
        this.f424616c = r102;
        this.f424617d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        this.f424614a.setTranslationX((this.f424615b + r102) - this.f424616c);
        d.f424619a.getClass();
        a.InterfaceC5019a r103 = this.f424617d;
        if (r103 == null) goto L6;
        r103.c(r102, r102 - this.f424616c);
        return;
    }
}
