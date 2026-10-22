package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.ClipDrawable;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m3 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l3 f304510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ClipDrawable f304511b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f304510a.f304467a.getOverlay().remove(this.f304511b);
    }

    public m3(l3 r100, ClipDrawable r101) {
        this.f304510a = r100;
        this.f304511b = r101;
    }
}
