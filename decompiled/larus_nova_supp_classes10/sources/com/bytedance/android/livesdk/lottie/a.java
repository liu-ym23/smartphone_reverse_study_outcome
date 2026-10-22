package com.bytedance.android.livesdk.lottie;

import com.airbnb.lottie.LottieAnimationView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ CommonLottieAnimationWidget a;

    public a(CommonLottieAnimationWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        LottieAnimationView r4 = this.a.a;
        if (r4 == null) goto L6;
        r4.setVisibility(8);
        return;
    }
}
