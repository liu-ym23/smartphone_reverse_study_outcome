package i75;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends e.a {
    public final /* synthetic */ View b;

    public d(View r1) {
        this.b = r1;
    }

    @Override // i75.e.a, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r3) {
        this.b.setVisibility(8);
        super.onAnimationEnd(r3);
    }
}
