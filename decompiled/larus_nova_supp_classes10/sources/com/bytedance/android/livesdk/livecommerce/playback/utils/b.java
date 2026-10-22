package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.ec.common.api.model.PlaybackSmallCardViewState;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ PlaybackSmallCardViewState a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ View e;
    public final /* synthetic */ int f;
    public final /* synthetic */ Function0 g;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r12) {
        Intrinsics.checkNotNullParameter(r12, "animation");
        int r13 = this.a.getSmallCardViewWidth();
        int r0 = this.a.getSmallCardViewHeight();
        int r1 = this.a.getProductImageSize();
        if (r13 <= 0) goto L8;
        if (r0 <= 0) goto L9;
        if (r1 <= 0) goto L10;
        int r14 = g.a;
        View r15 = this.b;
        int r2 = this.c;
        int r3 = this.d;
        View r4 = this.e;
        int r5 = this.f;
        PlaybackSmallCardViewState r6 = this.a;
        Function0 r7 = this.g;
        AnimatorSet r8 = new AnimatorSet();
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{r5, r6.getProductImageSize()});
        r9.setTarget(r4);
        r9.addUpdateListener(new c(r4));
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r2, r6.getSmallCardViewWidth()});
        r10.setTarget(r15);
        r10.addUpdateListener(new d(r15));
        ValueAnimator r11 = ValueAnimator.ofInt(new int[]{r3, r6.getSmallCardViewHeight()});
        r11.setTarget(r15);
        r11.addUpdateListener(new e(r15));
        r8.playTogether(new Animator[]{r9, r10, r11});
        r8.setDuration(300);
        r8.addListener(new f(r15, r7));
        r8.start();
        return;
    L10:
        return;
    L9:
        return;
    }

    public b(PlaybackSmallCardViewState r1, View r2, int r3, int r4, View r5, int r6, Function0 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
