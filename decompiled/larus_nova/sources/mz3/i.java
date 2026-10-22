package mz3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryLayout;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalleryLayout f516484a;

    public i(GalleryLayout r100) {
        this.f516484a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        GalleryLayout r101 = this.f516484a;
        GalleryLayout.g(r101.f195204u, (int) n0.a(r101.getContext(), 64.0f));
        this.f516484a.f195203t = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f516484a.f195203t = null;
    }
}
