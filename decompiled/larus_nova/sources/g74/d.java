package g74;

import com.baidu.mapapi.animation.Animation;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f480227a;

    @Override // com.baidu.mapapi.animation.Animation.AnimationListener
    public final void onAnimationCancel() {
    }

    @Override // com.baidu.mapapi.animation.Animation.AnimationListener
    public final void onAnimationRepeat() {
    }

    @Override // com.baidu.mapapi.animation.Animation.AnimationListener
    public final void onAnimationStart() {
    }

    @Override // com.baidu.mapapi.animation.Animation.AnimationListener
    public final void onAnimationEnd() {
        this.f480227a.setVisible(false);
    }

    public d(e r100) {
        this.f480227a = r100;
    }
}
