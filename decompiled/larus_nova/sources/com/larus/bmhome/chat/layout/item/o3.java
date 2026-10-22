package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.ClipDrawable;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o3 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l3 f304549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f304550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ClipDrawable f304551c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (Intrinsics.areEqual(this.f304549a.f304472f, r100) == false) goto L5;
        this.f304549a.f304472f = null;
    L5:
        ViewGroup r101 = this.f304550b;
        if (r101 == null) goto L11;
        ViewGroupOverlay r102 = r101.getOverlay();
        if (r102 == null) goto L12;
        r102.remove(this.f304551c);
        return;
    L12:
        return;
    }

    public o3(l3 r100, ViewGroup r101, ClipDrawable r102) {
        this.f304549a = r100;
        this.f304550b = r101;
        this.f304551c = r102;
    }
}
