package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class v extends u.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f394174a;

    public v(u r100) {
        this.f394174a = r100;
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f394174a.f394150c.setVisibility(8);
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f394174a.f394150c.setVisibility(8);
    }
}
