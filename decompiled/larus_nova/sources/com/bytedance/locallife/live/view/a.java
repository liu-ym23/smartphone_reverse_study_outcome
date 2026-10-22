package com.bytedance.locallife.live.view;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f260812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f260813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f260814c;

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationRepeat(AnimatedDrawable2 r100) {
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationReset(AnimatedDrawable2 r100) {
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        if (r100 == null) goto L5;
        r100.jumpToFrame(0);
        return;
    }

    public a(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onAnimationComplate");
        this.f260812a = r100;
        this.f260813b = r101;
        this.f260814c = -1;
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        if (this.f260814c <= r101) goto L5;
    L7:
        this.f260813b.invoke();
        return;
    L5:
        if (r101 >= (this.f260812a - 1)) goto L7;
        this.f260814c = r101;
    }
}
