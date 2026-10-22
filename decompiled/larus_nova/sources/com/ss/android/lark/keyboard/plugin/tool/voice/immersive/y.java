package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class y implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImmersiveVoiceInputView f430721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int[] f430722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int[] f430723c;

    public y(ImmersiveVoiceInputView r100, int[] r101, int[] r102) {
        this.f430721a = r100;
        this.f430722b = r101;
        this.f430723c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        float r100 = r110.getAnimatedFraction();
        GradientDrawable r101 = this.f430721a.f430117g;
        int[] r102 = this.f430722b;
        int[] r103 = new int[r102.length];
        int[] r104 = this.f430723c;
        int r105 = r102.length;
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r106 >= r105) goto L5;
        int r108 = r102[r106];
        int r111 = r102[r107];
        int r112 = r104[r107];
        r103[r107] = Color.argb((int) (Color.alpha(r111) + ((Color.alpha(r112) - Color.alpha(r111)) * r100)), (int) (Color.red(r111) + ((Color.red(r112) - Color.red(r111)) * r100)), (int) (Color.green(r111) + ((Color.green(r112) - Color.green(r111)) * r100)), (int) (Color.blue(r111) + ((Color.blue(r112) - Color.blue(r111)) * r100)));
        r106 = r106 + 1;
        r107 = r107 + 1;
        goto L3
    L5:
        if (r101 == null) goto L9;
        r101.setColors(r103);
        return;
    }
}
