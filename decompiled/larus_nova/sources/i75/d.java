package i75;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f488465b;

    public d(View r100) {
        this.f488465b = r100;
    }

    @Override // i75.e.a, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f488465b.setVisibility(8);
        super.onAnimationEnd(r100);
    }
}
