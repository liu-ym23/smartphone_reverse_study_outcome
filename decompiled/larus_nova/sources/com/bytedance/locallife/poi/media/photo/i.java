package com.bytedance.locallife.poi.media.photo;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f262769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f262770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PoiSlidesPhotosProgressBar f262771c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        int r101 = this.f262769a - 1;
        if (this.f262770b > r101) goto L10;
    L4:
        View r102 = this.f262771c.getChildAt(r101);
        if (r102 == null) goto L8;
        this.f262771c.removeView(r102);
    L8:
        if (r101 == this.f262770b) goto L12;
        r101 = r101 - 1;
        goto L4
    L12:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        int r101 = this.f262769a - 1;
        if (this.f262770b > r101) goto L10;
    L4:
        View r102 = this.f262771c.getChildAt(r101);
        if (r102 == null) goto L8;
        this.f262771c.removeView(r102);
    L8:
        if (r101 == this.f262770b) goto L12;
        r101 = r101 - 1;
        goto L4
    L12:
        return;
    }

    public i(int r100, int r101, PoiSlidesPhotosProgressBar r102) {
        this.f262769a = r100;
        this.f262770b = r101;
        this.f262771c = r102;
    }
}
