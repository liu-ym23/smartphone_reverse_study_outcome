package com.larus.dora.impl.device.manage.widget;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements Animator.AnimatorListener {
    public e() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeRefreshingAnimator onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeRefreshingAnimator onAnimationEnd");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeRefreshingAnimator onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeRefreshingAnimator onAnimationStart");
    }
}
