package re2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends AnimatorListenerAdapter {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        this.a.b();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        super.onAnimationStart(r5);
        b r6 = this.a;
        Drawable r0 = ((com.bytedance.android.live.liveinteract.a) r6).g.getBackground();
        if (r0 == null) goto L16;
        GradientDrawable r1 = (GradientDrawable) r0;
        int[] r2 = new int[2];
        if (((com.bytedance.android.live.liveinteract.a) this.a).B == false) goto L7;
        long r3 = 4294967295L;
    L8:
        r2[0] = (int) r3;
        r2[1] = 0;
        ObjectAnimator r4 = ObjectAnimator.ofInt(r1, "color", r2);
        r4.setDuration(400);
        r4.setEvaluator(new ArgbEvaluator());
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this.a).i).add(r4);
        Unit r7 = Unit.INSTANCE;
        r6.N = r4;
        ObjectAnimator r8 = this.a.N;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("buttonBgColorGone");
    L11:
        r8.start();
        b r9 = this.a;
        if (((com.bytedance.android.live.liveinteract.a) r9).B == false) goto L17;
        ((com.bytedance.android.live.liveinteract.a) r9).q.start();
        return;
    L17:
        return;
    L7:
        r3 = 3003121664L;
        goto L8
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }
}
