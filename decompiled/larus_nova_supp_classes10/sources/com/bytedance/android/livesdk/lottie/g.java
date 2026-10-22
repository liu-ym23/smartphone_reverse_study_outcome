package com.bytedance.android.livesdk.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import vl2.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ CommonLottieAnimationWidget a;
    public final /* synthetic */ k b;

    public g(CommonLottieAnimationWidget r1, k r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Pair r5 = (Pair) r4;
        CommonLottieAnimationWidget r0 = this.a;
        m r1 = (m) r5.component2();
        LottieComposition r6 = (LottieComposition) r5.component1();
        LottieAnimationView r2 = r0.a;
        if (r2 == null) goto L5;
        r2.cancelAnimation();
        r2.setProgress(0.0f);
        r2.setImageAssetDelegate(new d(r1));
        r2.setComposition(r6);
    L5:
        LottieAnimationView r7 = this.a.a;
        if (r7 == null) goto L8;
        r7.addAnimatorListener(new f(this));
    L8:
        LottieAnimationView r8 = this.a.a;
        if (r8 == null) goto L11;
        r8.setVisibility(0);
    L11:
        LottieAnimationView r9 = this.a.a;
        if (r9 == null) goto L15;
        r9.playAnimation();
        return;
    }
}
