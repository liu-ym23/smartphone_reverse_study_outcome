package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f436087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f436088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f436089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f436090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f436091f;

    public h(MmAINotePanelAnimator r100, int r101, int r102, int r103, int r104, String r105) {
        this.f436086a = r100;
        this.f436087b = r101;
        this.f436088c = r102;
        this.f436089d = r103;
        this.f436090e = r104;
        this.f436091f = r105;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        MmAINotePanelAnimator r103 = this.f436086a;
        int r104 = this.f436087b;
        int r105 = MathKt.roundToInt(r104 + ((this.f436088c - r104) * r102));
        int r106 = this.f436089d;
        r103.f(r105, MathKt.roundToInt(r106 + ((this.f436090e - r106) * r102)), this.f436091f, false);
    }
}
