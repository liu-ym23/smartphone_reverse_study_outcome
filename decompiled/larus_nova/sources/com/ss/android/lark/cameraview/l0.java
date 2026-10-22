package com.ss.android.lark.cameraview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayout f410997a;

    public l0(CaptureLayout r100) {
        this.f410997a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        a1 r101 = this.f410997a.f410813g;
        a1 r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r101 = null;
    L5:
        r101.setClickable(true);
        a1 r103 = this.f410997a.f410812f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
    L9:
        r102.setClickable(true);
        return;
    L8:
        r102 = r103;
        goto L9
    }
}
