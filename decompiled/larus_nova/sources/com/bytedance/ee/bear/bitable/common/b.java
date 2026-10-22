package com.bytedance.ee.bear.bitable.common;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class b implements Animator.AnimatorListener {
    public b() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public static void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.animate().setListener(null);
    }
}
