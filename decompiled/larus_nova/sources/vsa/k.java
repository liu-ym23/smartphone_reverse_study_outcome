package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;
import com.ss.android.bytedcert.view.AudioProgressTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.b f557141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f557143c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        n.b r101 = this.f557141a;
        if (r101 != null) goto L5;
    L7:
        n.a(this.f557142b, this.f557143c);
        return;
    L5:
        if (((FaceDetectFullActivity.c.b) r101).c() == false) goto L7;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        n.b r101 = this.f557141a;
        if (r101 == null) goto L6;
        ((FaceDetectFullActivity.c.b) r101).a(r100);
        return;
    }

    public k(FaceDetectFullActivity.c.b r100, AudioProgressTextView r101, j r102) {
        this.f557141a = r100;
        this.f557142b = r101;
        this.f557143c = r102;
    }
}
