package mh1;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.LiveResUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f513882a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public n(o r100) {
        this.f513882a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f513882a.f513887e.clearAnimation();
        RelativeLayout.LayoutParams r101 = (RelativeLayout.LayoutParams) this.f513882a.f513887e.getLayoutParams();
        r101.rightMargin = LiveResUtil.dp2Px(10.0f);
        this.f513882a.f513887e.setLayoutParams(r101);
    }
}
