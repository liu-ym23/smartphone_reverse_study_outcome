package ea5;

import android.animation.Animator;

/* JADX INFO: loaded from: classes16.dex */
public final class k extends com.bytedance.ee.util.ui.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f471596a;

    public k(m r100) {
        this.f471596a = r100;
    }

    @Override // com.bytedance.ee.util.ui.g.a, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f471596a.f471610k = false;
    }
}
