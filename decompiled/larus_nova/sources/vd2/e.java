package vd2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl.MvLyricSurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MvLyricSurfaceView f554186a;

    public e(MvLyricSurfaceView r100) {
        this.f554186a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MvLyricSurfaceView r101 = this.f554186a;
        int r102 = MvLyricSurfaceView.L;
        r101.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MvLyricSurfaceView r101 = this.f554186a;
        int r102 = MvLyricSurfaceView.L;
        r101.getClass();
    }
}
