package qfc;

import android.animation.Animator;
import android.graphics.RectF;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.crop_rotate.PhotoClipView;

/* JADX INFO: loaded from: classes38.dex */
public final class q implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f532812a;

    public q(w r100) {
        this.f532812a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        w r101 = this.f532812a;
        r101.f532837t = false;
        ((x.f) r101.f532833p).f532852b.f532845b.f449184m = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        w r101 = this.f532812a;
        r101.f532837t = false;
        ((x.f) r101.f532833p).f532852b.f532845b.f449184m = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        this.f532812a.f532837t = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Log.i("PhotoClipRect", "onAnimationStart, clipRectRegion = " + this.f532812a.f532827j);
        w r101 = this.f532812a;
        w.d r102 = r101.f532833p;
        RectF r103 = r101.f532827j;
        x.f r104 = (x.f) r102;
        PhotoClipView r105 = r104.f532852b.f532845b;
        r105.f449184m = true;
        r105.f449179h = new RectF(r103);
        r104.f532851a = new y(r104.f532852b.f532845b.f449183l);
        Log.i("PhotoClipView", "onTransitionStart : clipRegion = " + r103 + ", locationBeforeTransition = " + r104.f532851a);
        this.f532812a.f532837t = true;
    }
}
