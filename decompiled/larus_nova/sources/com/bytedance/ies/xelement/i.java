package com.bytedance.ies.xelement;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxLottieView f250007a;

    public i(LynxLottieView r100) {
        this.f250007a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        LynxLottieView r101 = this.f250007a;
        LottieAnimationView r102 = (LottieAnimationView) LynxLottieView.O(r101);
        if (r102 == null) goto L5;
        int r103 = r102.getFrame();
    L6:
        LottieComposition r104 = ((LottieAnimationView) LynxLottieView.O(this.f250007a)).getComposition();
        if (r104 == null) goto L9;
        float r105 = r104.getDurationFrames();
    L10:
        int r106 = (int) r105;
        LynxLottieView r107 = this.f250007a;
        r101.S("cancel", r103, r106, r107.f249616h, r107.f249626r);
        return;
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        LottieAnimationView r101 = (LottieAnimationView) LynxLottieView.O(this.f250007a);
        if (r101 == null) goto L10;
        LynxLottieView r102 = this.f250007a;
        boolean r103 = r102.f249609a;
        LottieAnimationView r104 = (LottieAnimationView) LynxLottieView.O(r102);
        if (r103 == false) goto L8;
        float r105 = r104.getMaxFrame();
    L9:
        r101.setFrame((int) r105);
        goto L10
    L8:
        r105 = r104.getMinFrame();
    L10:
        LynxLottieView r106 = this.f250007a;
        LottieAnimationView r107 = (LottieAnimationView) LynxLottieView.O(r106);
        if (r107 == null) goto L13;
        int r108 = r107.getFrame();
    L14:
        LottieComposition r109 = ((LottieAnimationView) LynxLottieView.O(this.f250007a)).getComposition();
        if (r109 == null) goto L17;
        float r110 = r109.getDurationFrames();
    L18:
        int r111 = (int) r110;
        LynxLottieView r112 = this.f250007a;
        r106.S("completion", r108, r111, r112.f249616h, r112.f249626r);
        return;
    L17:
        r110 = 0.0f;
        goto L18
    L13:
        r108 = 0;
        goto L14
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        LynxLottieView r101 = this.f250007a;
        r101.f249616h++;
        LottieAnimationView r102 = (LottieAnimationView) LynxLottieView.O(r101);
        if (r102 == null) goto L5;
        int r103 = r102.getFrame();
    L6:
        LottieComposition r104 = ((LottieAnimationView) LynxLottieView.O(this.f250007a)).getComposition();
        if (r104 == null) goto L9;
        float r105 = r104.getDurationFrames();
    L10:
        int r106 = (int) r105;
        LynxLottieView r107 = this.f250007a;
        r101.S(SalesInfoStruct.REPEAT, r103, r106, r107.f249616h, r107.f249626r);
        return;
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r110) {
        LynxLottieView r100 = this.f250007a;
        r100.f249616h = 0;
        LottieAnimationView r101 = (LottieAnimationView) LynxLottieView.O(r100);
        if (r101 == null) goto L5;
        int r102 = r101.getFrame();
    L6:
        LottieComposition r103 = ((LottieAnimationView) LynxLottieView.O(this.f250007a)).getComposition();
        float r104 = 0.0f;
        if (r103 == null) goto L9;
        float r105 = r103.getDurationFrames();
    L10:
        LynxLottieView r106 = this.f250007a;
        r100.S("ready", r102, (int) r105, r106.f249616h, r106.f249626r);
        LynxLottieView r107 = this.f250007a;
        LottieAnimationView r108 = (LottieAnimationView) LynxLottieView.O(r107);
        if (r108 == null) goto L13;
        int r111 = r108.getFrame();
    L14:
        LottieComposition r112 = ((LottieAnimationView) LynxLottieView.O(this.f250007a)).getComposition();
        if (r112 == null) goto L17;
        r104 = r112.getDurationFrames();
    L17:
        LynxLottieView r113 = this.f250007a;
        r107.S("start", r111, (int) r104, r113.f249616h, r113.f249626r);
        return;
    L13:
        r111 = 0;
        goto L14
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }
}
