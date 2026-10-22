package ta2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.animator.OptScrollItemAnimator;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f545158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f545159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f545160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f545161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ OptScrollItemAnimator f545162e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        if (this.f545162e.f140229i != 2) goto L6;
        this.f545158a.setLayerType(0, null);
    L6:
        if (this.f545160c == 0) goto L9;
        this.f545158a.setTranslationY(0.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        if (this.f545162e.f140229i != 2) goto L5;
        this.f545158a.setLayerType(0, null);
    L5:
        this.f545161d.setListener(null);
        this.f545162e.dispatchMoveFinished(this.f545159b);
        this.f545162e.f140227g.remove(this.f545159b);
        OptScrollItemAnimator r101 = this.f545162e;
        if (r101.isRunning() == true) goto L9;
        r101.dispatchAnimationsFinished();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        if (this.f545162e.f140229i != 2) goto L5;
        this.f545158a.setLayerType(2, null);
    L5:
        this.f545162e.dispatchMoveStarting(this.f545159b);
    }

    public b(OptScrollItemAnimator r100, View r101, RecyclerView.ViewHolder r102, int r103, ViewPropertyAnimator r104) {
        this.f545162e = r100;
        this.f545158a = r101;
        this.f545159b = r102;
        this.f545160c = r103;
        this.f545161d = r104;
    }
}
