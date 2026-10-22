package mz3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryLayout;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalleryLayout f516482a;

    public g(GalleryLayout r100) {
        this.f516482a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        GalleryLayout r101 = this.f516482a;
        GalleryLayout.g(r101.f195208y, (int) n0.a(r101.getContext(), 37.0f));
        this.f516482a.f195207x = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f516482a.f195207x = null;
    }
}
