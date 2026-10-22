package com.larus.gallery.adapter.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.gallery.adapter.GalleryCenterStatusSaver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseScaleGalleryView f343772a;

    public g(BaseScaleGalleryView r100) {
        this.f343772a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        BaseScaleGalleryView r101 = this.f343772a;
        r101.f343738j = !r101.f343738j;
        r101.f343739k = false;
        r101.getControllerImp().S = true;
        this.f343772a.getControllerImp().C = false;
        BaseScaleGalleryView r102 = this.f343772a;
        GalleryCenterStatusSaver r103 = r102.f343742n;
        if (r103 == null) goto L6;
        r103.a(r102.f343738j);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f343772a.getControllerImp().S = false;
    }
}
