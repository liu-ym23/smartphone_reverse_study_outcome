package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.b f557122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f557124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f557125d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f557123b.setAlpha(this.f557124c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f557123b.setAlpha(this.f557124c);
        c.b r101 = this.f557122a;
        if (r101 == null) goto L11;
        FaceDetectDialogActivity.a.C4715a r102 = ((FaceDetectDialogActivity.a) r101).f407454a;
        if (r102 == null) goto L8;
        r102.onAnimationEnd(r100);
    L8:
        if (((FaceDetectDialogActivity.a) this.f557122a).f407455b.f407439i == false) goto L12;
        this.f557125d.start();
        return;
    L12:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        c.b r101 = this.f557122a;
        if (r101 == null) goto L8;
        FaceDetectDialogActivity.a.C4715a r102 = ((FaceDetectDialogActivity.a) r101).f407454a;
        if (r102 == null) goto L9;
        r102.onAnimationStart(r100);
        return;
    L9:
        return;
    }

    public e(FaceDetectDialogActivity.a r100, View r101, float r102, AnimatorSet r103) {
        this.f557122a = r100;
        this.f557123b = r101;
        this.f557124c = r102;
        this.f557125d = r103;
    }
}
