package com.bytedance.android.livesdk.livecommerce.playback.guide;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.widget.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends d {
    public final /* synthetic */ ViewGroup g;
    public final /* synthetic */ LottieAnimationView h;
    public final /* synthetic */ FrameLayout i;
    public final /* synthetic */ ExplainPlaybackGuidePresenter j;

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        ExplainPlaybackGuidePresenter.d0(this.j);
        this.h.removeAllUpdateListeners();
        this.g.removeView(this.i);
    }

    public a(ViewGroup r1, LottieAnimationView r2, FrameLayout r3, ExplainPlaybackGuidePresenter r4) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        this.j = r4;
        super(null, null, 3);
    }
}
