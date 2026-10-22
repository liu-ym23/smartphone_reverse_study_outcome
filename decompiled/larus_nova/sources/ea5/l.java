package ea5;

import android.animation.Animator;

/* JADX INFO: loaded from: classes16.dex */
public final class l extends com.bytedance.ee.util.ui.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f471598a;

    public l(m r100) {
        this.f471598a = r100;
    }

    @Override // com.bytedance.ee.util.ui.g.a, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f471598a.f471610k = true;
    }
}
