package com.larus.canvas.feature.component.logic.provider;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.bigimg.widget.CreationSidebarView;
import com.larus.gallery.impl.databinding.LarusLayoutGalleryCreationSideBarBinding;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f323460a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public t(v r100) {
        this.f323460a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LarusLayoutGalleryCreationSideBarBinding r101 = this.f323460a.f323464g;
        if (r101 == null) goto L8;
        CreationSidebarView r102 = r101.f343988b;
        if (r102 == null) goto L9;
        e1.o(r102);
        return;
    L9:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LarusLayoutGalleryCreationSideBarBinding r101 = this.f323460a.f323464g;
        if (r101 == null) goto L8;
        CreationSidebarView r102 = r101.f343988b;
        if (r102 == null) goto L9;
        r102.setAlpha(1.0f);
        return;
    L9:
        return;
    }
}
