package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.ss.android.bytedcert.view.AudioProgressTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f557155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f557157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f557158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f557159e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f557156b.setScaleX(this.f557157c);
        this.f557156b.setScaleY(this.f557158d);
        this.f557156b.setAlpha(this.f557159e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f557156b.setScaleX(this.f557157c);
        this.f557156b.setScaleY(this.f557158d);
        this.f557156b.setAlpha(this.f557159e);
        Animator.AnimatorListener r101 = this.f557155a;
        if (r101 == null) goto L6;
        r101.onAnimationEnd(r100);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Animator.AnimatorListener r101 = this.f557155a;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }

    public o(Animator.AnimatorListener r100, AudioProgressTextView r101, float r102, float r103, float r104) {
        this.f557155a = r100;
        this.f557156b = r101;
        this.f557157c = r102;
        this.f557158d = r103;
        this.f557159e = r104;
    }
}
