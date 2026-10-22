package zj1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f572438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f572439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f572440c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        f.b(this.f572440c, this.f572438a, this.f572439b);
    }

    public g(f r100, int r101, String r102) {
        this.f572440c = r100;
        this.f572438a = r101;
        this.f572439b = r102;
    }
}
