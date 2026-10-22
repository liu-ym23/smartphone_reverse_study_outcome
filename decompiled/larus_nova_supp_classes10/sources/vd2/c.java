package vd2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl.MvLyricSurfaceView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ MvLyricSurfaceView a;
    public final /* synthetic */ int b;

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

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        MvLyricSurfaceView r5 = this.a;
        int r0 = MvLyricSurfaceView.L;
        r5.getClass();
        int r6 = this.a.p.size();
        int r1 = this.b;
        if ((r1 % 2) != 0) goto L14;
        MvLyricSurfaceView r2 = this.a;
        if (r2.l == false) goto L14;
        if (r1 < 0) goto L14;
        if (r1 >= (r6 - 1)) goto L14;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r2.p, r1)).i == false) goto L14;
        int r7 = this.a.p.size();
        int r3 = this.b;
        if (r3 >= (r7 - 1)) goto L14;
        com.bytedance.component.lyric.model.b r8 = new com.bytedance.component.lyric.model.b();
        r8.a = 1;
        Unit r9 = Unit.INSTANCE;
        ListProtector.add(this.a.p, r3 + 1, r8);
    L14:
        MvLyricSurfaceView r10 = this.a;
        r10.y = this.b;
        MvLyricSurfaceView r11 = this.a;
        if (r11.l == false) goto L18;
        r11.getClass();
        return;
    }

    public c(MvLyricSurfaceView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
