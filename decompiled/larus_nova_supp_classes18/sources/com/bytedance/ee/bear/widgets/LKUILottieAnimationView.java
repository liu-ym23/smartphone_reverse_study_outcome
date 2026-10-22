package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LKUILottieAnimationView extends LottieAnimationView {
    public final void onDetachedFromWindow() {
        cancelAnimation();
        super.onDetachedFromWindow();
    }

    public LKUILottieAnimationView(Context r1) {
        super(r1);
    }

    public LKUILottieAnimationView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public LKUILottieAnimationView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
