package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.locallife.poi.fragment.b f264071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiTransitionSkeletonPlugin.c f264072b;

    public h(SkeletonItemDecoration r100, PoiTransitionSkeletonPlugin.c r101) {
        this.f264071a = r100;
        this.f264072b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        this.f264071a.b(r102);
        this.f264072b.f264016a.f264020b = r102;
    }
}
