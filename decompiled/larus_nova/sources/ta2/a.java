package ta2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.animator.OptScrollItemAnimator;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f545153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f545154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f545155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f545156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ OptScrollItemAnimator f545157e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        if (this.f545157e.f140229i != 2) goto L6;
        this.f545153a.setLayerType(0, null);
    L6:
        if (this.f545155c == 0) goto L8;
        this.f545153a.setTranslationY(0.0f);
    L8:
        this.f545153a.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        if (this.f545157e.f140229i != 2) goto L5;
        this.f545153a.setLayerType(0, null);
    L5:
        this.f545156d.setListener(null);
        this.f545157e.dispatchAddFinished(this.f545154b);
        this.f545157e.f140226f.remove(this.f545154b);
        OptScrollItemAnimator r101 = this.f545157e;
        if (r101.isRunning() == true) goto L9;
        r101.dispatchAnimationsFinished();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        if (this.f545157e.f140229i != 2) goto L5;
        this.f545153a.setLayerType(2, null);
    L5:
        this.f545157e.dispatchAddStarting(this.f545154b);
    }

    public a(OptScrollItemAnimator r100, View r101, RecyclerView.ViewHolder r102, int r103, ViewPropertyAnimator r104) {
        this.f545157e = r100;
        this.f545153a = r101;
        this.f545154b = r102;
        this.f545155c = r103;
        this.f545156d = r104;
    }
}
