package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o extends com.bytedance.awemeopen.infra.base.anim.lottie.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AvatarElementView f196658a;

    public o(AvatarElementView r100) {
        this.f196658a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ((p) this.f196658a.f195897b).f196663e.b(Unit.INSTANCE);
    }
}
