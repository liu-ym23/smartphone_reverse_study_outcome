package ev;

import android.view.animation.Animation;
import com.bytedance.android.gamecp.common.ui.pullrefresh.SwipeRefreshLayout;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animation.AnimationListener f474185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f474186b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        Animation.AnimationListener r101 = this.f474185a;
        if (r101 == null) goto L5;
        r101.onAnimationEnd(r100);
    L5:
        this.f474186b.b(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        Animation.AnimationListener r101 = this.f474185a;
        if (r101 == null) goto L6;
        r101.onAnimationRepeat(r100);
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        Animation.AnimationListener r101 = this.f474185a;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }

    public b(SwipeRefreshLayout.e r100, SwipeRefreshLayout.b r101) {
        this.f474186b = r100;
        this.f474185a = r101;
    }
}
