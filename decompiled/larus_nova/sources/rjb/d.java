package rjb;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewParent f538208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f538209b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        ViewParent r101 = this.f538208a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r101).removeView(this.f538209b.f538205i);
    }

    public d(ViewParent r100, c r101) {
        this.f538208a = r100;
        this.f538209b = r101;
    }
}
