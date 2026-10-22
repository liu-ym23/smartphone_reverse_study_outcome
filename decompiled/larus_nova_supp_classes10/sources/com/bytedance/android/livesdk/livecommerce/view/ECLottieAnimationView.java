package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECLottieAnimationView extends LottieAnimationView {
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimation();
    }

    public ECLottieAnimationView(Context r1) {
        super(r1);
        setImageFolder("images");
    }

    private void setImageFolder(String r1) {
        setImageAssetsFolder(r1);
    }

    public ECLottieAnimationView(Context r1, AttributeSet r2) {
        super(r1, r2);
        setImageFolder("images");
    }

    public ECLottieAnimationView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setImageFolder("images");
    }
}
