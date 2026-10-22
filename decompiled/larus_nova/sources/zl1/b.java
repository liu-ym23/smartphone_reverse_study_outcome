package zl1;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.replay.player.tips.ReplayPlayTipsWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPlayTipsWidget f572782a;

    public b(ReplayPlayTipsWidget r100) {
        this.f572782a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L9;
        float r102 = ((Float) r101).floatValue();
        ViewGroup r103 = this.f572782a.containerView;
        if (r103 == null) goto L10;
        r103.setTranslationY(r102);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
