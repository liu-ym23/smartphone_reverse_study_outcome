package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q3 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l3 f304571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f304572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f304573c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (Intrinsics.areEqual(this.f304571a.f304473g, r100) == false) goto L5;
        this.f304571a.f304473g = null;
    L5:
        int r101 = this.f304572b;
        l3 r102 = this.f304571a;
        if (r101 == r102.f304481o) goto L8;
        return;
    L8:
        r102.f304467a.setAlpha(1.0f);
        FLogger.f375446a.i(this.f304571a.f304468b, "refreshCombinedEnd contentKey=" + this.f304573c);
    }

    public q3(l3 r100, int r101, String r102) {
        this.f304571a = r100;
        this.f304572b = r101;
        this.f304573c = r102;
    }
}
