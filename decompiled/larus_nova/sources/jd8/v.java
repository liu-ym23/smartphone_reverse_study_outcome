package jd8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f498749a;

    public v(u r100) {
        this.f498749a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        u r101 = this.f498749a;
        r101.f498748d = null;
        r101.f498747c = 255;
        r101.invalidateSelf();
    }
}
