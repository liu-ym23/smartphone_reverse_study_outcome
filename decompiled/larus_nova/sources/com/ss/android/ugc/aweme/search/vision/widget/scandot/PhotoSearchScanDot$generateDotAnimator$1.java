package com.ss.android.ugc.aweme.search.vision.widget.scandot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/aweme/search/vision/widget/scandot/PhotoSearchScanDot$generateDotAnimator$1", "Landroid/animation/AnimatorListenerAdapter;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchScanDot$generateDotAnimator$1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoSearchScanDot f454108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f454109b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f454108a.post(new PhotoSearchScanDot$generateDotAnimator$1$onAnimationEnd$1(this));
    }

    public PhotoSearchScanDot$generateDotAnimator$1(PhotoSearchScanDot r100, AnimatorSet r101) {
        this.f454108a = r100;
        this.f454109b = r101;
    }
}
