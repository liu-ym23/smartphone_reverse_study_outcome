package com.lynx.clay.embedding.android;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes32.dex */
public final class s extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f380683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f380684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SurfaceSnapshotController f380685c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f380683a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        if (this.f380683a == true) goto L14;
        SurfaceSnapshotController r101 = this.f380685c;
        if (r101.f380593c == this.f380684b) goto L7;
        return;
    L7:
        if (r101.f380595e != SurfaceSnapshotController.OverlayState.FADING_OUT) goto L16;
        FlutterSurfaceView r102 = r101.f380592b;
        if (r102 == null) goto L12;
        SurfaceSnapshotTracker r103 = r102.f380499b;
        r103.j();
        r103.f380609d = false;
        r103.i();
        r103.f380606a.animate().cancel();
        r103.f380606a.setAlpha(1.0f);
    L12:
        r101.h();
        return;
    L16:
        return;
    }

    public s(SurfaceSnapshotController r100, k r101) {
        this.f380685c = r100;
        this.f380684b = r101;
        this.f380683a = false;
    }
}
