package com.bytedance.caijing.sdk.infra.base.impl.fresco;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vd4.a f202572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animatable f202573b;

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationRepeat(AnimatedDrawable2 r100) {
        vd4.a r101 = this.f202572a;
        if (r101 == null) goto L6;
        r101.onRepeat(this.f202573b);
        return;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
        vd4.a r101 = this.f202572a;
        if (r101 == null) goto L6;
        r101.onStart(r100);
        return;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        if (r100 == null) goto L5;
        r100.setAutoMirrored(false);
    L5:
        vd4.a r101 = this.f202572a;
        if (r101 == null) goto L9;
        r101.onStop(this.f202573b);
        return;
    }

    public a(vd4.a r100, Animatable r101) {
        this.f202572a = r100;
        this.f202573b = r101;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        vd4.a r102 = this.f202572a;
        if (r102 == null) goto L6;
        r102.onFrame(r100, r101);
        return;
    }
}
