package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436084a;

    public f(MmAINotePanelAnimator r100) {
        this.f436084a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MmAINotePanelAnimator r101 = this.f436084a;
        int r102 = r101.q();
        Object r103 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
        r101.g(r102, ((Float) r103).floatValue());
    }
}
