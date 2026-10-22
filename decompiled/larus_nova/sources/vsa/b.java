package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f557114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f557115b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f557114a.setTranslationX(0.0f);
        Animator.AnimatorListener r101 = this.f557115b;
        if (r101 == null) goto L6;
        r101.onAnimationEnd(r100);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Animator.AnimatorListener r101 = this.f557115b;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }

    public b(View r100, FaceDetectDialogActivity.b.a r101) {
        this.f557114a = r100;
        this.f557115b = r101;
    }
}
