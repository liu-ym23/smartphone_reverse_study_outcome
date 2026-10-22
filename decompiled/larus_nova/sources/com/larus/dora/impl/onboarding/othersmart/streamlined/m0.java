package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes27.dex */
public final class m0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraHStreamlinedWakeupFragment f337283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f337284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f337285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f337286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f337287e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        DoraHStreamlinedWakeupFragment r101 = this.f337283a;
        r101.A = null;
        this.f337284b.element = true;
        r101.f337227w = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f337283a.A = null;
        if (this.f337284b.element == false) goto L5;
        return;
    L5:
        int r101 = MathKt.roundToInt(this.f337285c - this.f337286d.element);
        if (r101 == 0) goto L8;
        this.f337287e.scrollBy(0, r101);
    L8:
        DoraHStreamlinedWakeupFragment r102 = this.f337283a;
        r102.f337227w = false;
        r102.la0(r102.f337225u + 1, false);
    }

    public m0(DoraHStreamlinedWakeupFragment r100, Ref.BooleanRef r101, float r102, Ref.FloatRef r103, RecyclerView r104) {
        this.f337283a = r100;
        this.f337284b = r101;
        this.f337285c = r102;
        this.f337286d = r103;
        this.f337287e = r104;
    }
}
