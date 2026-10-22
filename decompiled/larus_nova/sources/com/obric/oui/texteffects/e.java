package com.obric.oui.texteffects;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import qma.g;
import qma.k;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f403307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OProtocolTextEffectTextView f403308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f403309c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f403307a.element = true;
        int r101 = f.f403310a;
        this.f403308b.getLogTag();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        int r101 = f.f403310a;
        this.f403308b.getLogTag();
        k r102 = this.f403309c;
        if (this.f403307a.element == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r102.f533974d, g.b.f533959a) == true) goto L13;
        OProtocolTextEffectTextView r103 = this.f403308b;
        r103.getClass();
        r103.getLogTag();
        CharSequence r104 = r103.f403282f;
        if (r104 == null) goto L10;
        r103.setText(r104);
    L10:
        r103.f403279c = null;
        r103.f403288l = "none";
        r103.f403281e = 0;
        r103.f403282f = null;
        r103.f403283g = null;
        r103.f403284h = null;
        r103.f403286j = null;
        r103.f403287k = null;
        r103.f403280d = null;
        r103.q();
        r103.invalidate();
        return;
    }

    public e(Ref.BooleanRef r100, OProtocolTextEffectTextView r101, k r102) {
        this.f403307a = r100;
        this.f403308b = r101;
        this.f403309c = r102;
    }
}
