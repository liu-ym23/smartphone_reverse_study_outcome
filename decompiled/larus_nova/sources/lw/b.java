package lw;

import android.animation.ValueAnimator;
import com.bytedance.android.gamecp.hybrid_impl.lynx.ui.gamecpWaveProgress.GamecpWaveProgressView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GamecpWaveProgressView f510981a;

    public b(GamecpWaveProgressView r100) {
        this.f510981a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Integer) == true) goto L5;
        r101 = null;
    L5:
        Integer r102 = (Integer) r101;
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
        GamecpWaveProgressView r104 = this.f510981a;
        r104.f57719g = r103;
        r104.invalidate();
        return;
    }
}
