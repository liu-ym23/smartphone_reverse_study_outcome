package com.bytedance.android.shopping.feed.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ ViewGroup g;
    public final /* synthetic */ LottieAnimationView h;
    public final /* synthetic */ VideoProductFeedFragment i;

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.h.removeAllUpdateListeners();
        this.g.removeView(this.i.s);
    }

    public k(ViewGroup r1, LottieAnimationView r2, VideoProductFeedFragment r3) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        super(null, null, 3);
    }
}
