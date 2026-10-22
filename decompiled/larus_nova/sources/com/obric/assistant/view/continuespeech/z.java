package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class z extends u.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f394179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f394180b;

    public z(u r100) {
        this.f394180b = r100;
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f394179a = true;
        u.a(this.f394180b, r100, true);
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        u.a(this.f394180b, r100, this.f394179a);
    }
}
