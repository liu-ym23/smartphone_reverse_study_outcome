package com.larus.bmhome.chat.mode;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f307423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l0 f307424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f307425c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        int r101 = this.f307423a;
        l0 r102 = this.f307424b;
        if (r101 == r102.f307417v) goto L5;
        return;
    L5:
        r102.f307416u = false;
        float r103 = this.f307425c;
        r102.f307414s = r103;
        r102.b(r103, Integer.valueOf(r102.f307410o));
        this.f307424b.f307403h.setAlpha(1.0f);
    }

    public m0(int r100, l0 r101, float r102) {
        this.f307423a = r100;
        this.f307424b = r101;
        this.f307425c = r102;
    }
}
