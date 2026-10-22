package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: classes24.dex */
public class LKUILottieAnimationView extends LottieAnimationView {
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        cancelAnimation();
        super.onDetachedFromWindow();
    }

    public LKUILottieAnimationView(Context r100) {
        super(r100);
    }

    public LKUILottieAnimationView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public LKUILottieAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
