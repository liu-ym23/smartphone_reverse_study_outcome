package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class x extends u.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f394177a;

    public x(u r100) {
        this.f394177a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f394177a.f394149b.setVisibility(0);
    }
}
