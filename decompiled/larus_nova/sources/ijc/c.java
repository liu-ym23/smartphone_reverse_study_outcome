package ijc;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hjc.f f490159a;

    public c(hjc.f r100) {
        this.f490159a = r100;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation r100, float r101, float r102) {
        hjc.f r103 = this.f490159a;
        r103.a((r101 * 1.0f) / a.b(r103.f485508a, null), 4);
    }
}
