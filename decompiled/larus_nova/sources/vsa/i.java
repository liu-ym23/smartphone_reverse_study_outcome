package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;
import com.ss.android.bytedcert.view.AudioProgressTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.b f557135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f557137c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        n.b r101 = this.f557135a;
        if (r101 != null) goto L5;
    L7:
        n.a(this.f557136b, this.f557137c);
        return;
    L5:
        if (((FaceDetectFullActivity.c.b) r101).c() == false) goto L7;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        n.b r101 = this.f557135a;
        if (r101 == null) goto L6;
        ((FaceDetectFullActivity.c.b) r101).a(r100);
        return;
    }

    public i(FaceDetectFullActivity.c.b r100, AudioProgressTextView r101, f r102) {
        this.f557135a = r100;
        this.f557136b = r101;
        this.f557137c = r102;
    }
}
