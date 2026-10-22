package vd2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl.MvLyricSurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ MvLyricSurfaceView a;

    public e(MvLyricSurfaceView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        MvLyricSurfaceView r3 = this.a;
        int r0 = MvLyricSurfaceView.L;
        r3.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        MvLyricSurfaceView r3 = this.a;
        int r0 = MvLyricSurfaceView.L;
        r3.getClass();
    }
}
