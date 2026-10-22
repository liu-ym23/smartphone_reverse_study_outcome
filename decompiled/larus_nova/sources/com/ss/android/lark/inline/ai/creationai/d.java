package com.ss.android.lark.inline.ai.creationai;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f427050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f427051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f427053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f427054e;

    public d(int r100, int r101, CreationAIDragView r102, int r103, int r104) {
        this.f427050a = r100;
        this.f427051b = r101;
        this.f427052c = r102;
        this.f427053d = r103;
        this.f427054e = r104;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        int r103 = this.f427050a;
        float r104 = r103 + ((this.f427051b - r103) * r102);
        ViewGroup r105 = this.f427052c.f426920c;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (this.f427052c.f426932j != null) goto L5;
        int r107 = -2;
    L6:
        r106.height = r107;
        r105.setLayoutParams(r106);
        int r108 = this.f427053d;
        float r109 = r108 + ((this.f427054e - r108) * r102);
        ViewGroup r110 = this.f427052c.f426920c;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        r112.bottomMargin = (int) r109;
        r110.setLayoutParams(r112);
        CreationAIDragView r113 = this.f427052c;
        int r114 = r113.f426935m;
        int r115 = r113.f426936n;
        if (r114 >= r115) goto L9;
        float r116 = r115 - (r115 * r102);
    L10:
        Log.i("CreationAIDragView", "doKeyboardAnimation, real keyboard height: " + r116);
        if (r116 >= 1.0f) goto L13;
        this.f427052c.n();
        return;
    L13:
        this.f427052c.s();
        return;
    L9:
        r116 = r115 * r102;
        goto L10
    L5:
        r107 = (int) r104;
        goto L6
    }
}
