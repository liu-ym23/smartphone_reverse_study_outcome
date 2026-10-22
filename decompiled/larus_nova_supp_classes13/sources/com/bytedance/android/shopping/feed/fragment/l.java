package com.bytedance.android.shopping.feed.fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements Runnable {
    public final /* synthetic */ LottieAnimationView a;

    public l(LottieAnimationView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.setImageAssetsFolder("images");     // Catch: Throwable -> L4
        this.a.setAnimation("commerce_anchor_v3_guide.json");     // Catch: Throwable -> L4
        this.a.loop(true);     // Catch: Throwable -> L4
        this.a.setRepeatCount(1);     // Catch: Throwable -> L4
        this.a.playAnimation();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
