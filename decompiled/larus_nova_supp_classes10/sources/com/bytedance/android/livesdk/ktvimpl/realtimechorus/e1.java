package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e1 implements AnimationListener {
    public final /* synthetic */ g1 a;
    public final /* synthetic */ Animatable b;

    public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
    }

    public final void onAnimationRepeat(AnimatedDrawable2 r1) {
    }

    public final void onAnimationReset(AnimatedDrawable2 r1) {
    }

    public final void onAnimationStart(AnimatedDrawable2 r1) {
    }

    public final void onAnimationStop(AnimatedDrawable2 r1) {
        this.a.a.invoke();
    }

    public e1(g1 r1, Animatable r2) {
        this.a = r1;
        this.b = r2;
    }
}
