package com.larus.avatar.impl.scan.component;

import android.animation.Animator;
import android.widget.ImageView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: classes23.dex */
public final class o0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScanCameraComponent f290961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f290962b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        ScanCameraComponent r101 = this.f290961a;
        if (r101.f290905p != r100) goto L5;
        r101.f290905p = null;
        this.f290962b.setImageDrawable(null);
        e1.o(this.f290962b);
    L5:
        r100.removeAllListeners();
    }

    public o0(ScanCameraComponent r100, ImageView r101) {
        this.f290961a = r100;
        this.f290962b = r101;
    }
}
