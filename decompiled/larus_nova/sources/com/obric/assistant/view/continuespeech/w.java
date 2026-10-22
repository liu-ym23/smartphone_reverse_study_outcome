package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class w extends u.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f394175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f394176b;

    public w(u r100) {
        this.f394176b = r100;
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f394175a = true;
        AudioGradientView r101 = this.f394176b.f394148a;
        if (r101 == null) goto L5;
        r101.setAnimating(false);
    L5:
        this.f394176b.f394150c.setAnimating(false);
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        AudioGradientView r101 = this.f394176b.f394148a;
        if (r101 == null) goto L6;
        r101.setAnimating(false);
    L6:
        if (this.f394175a == true) goto L9;
        this.f394176b.f394150c.setAnimating(false);
        return;
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f394175a = false;
        AudioGradientView r101 = this.f394176b.f394148a;
        if (r101 == null) goto L5;
        r101.setAnimating(true);
    L5:
        this.f394176b.f394150c.setAnimating(true);
    }
}
