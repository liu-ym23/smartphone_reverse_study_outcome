package mz3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryLayout;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ GalleryLayout a;

    public h(GalleryLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        GalleryLayout r4 = this.a;
        GalleryLayout.g(r4.s, (int) n0.a(r4.getContext(), 44.0f));
        this.a.r = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.r = null;
    }
}
