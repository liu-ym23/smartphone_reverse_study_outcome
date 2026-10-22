package com.ss.android.lark.chameleon.widgetv2.emptyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: classes35.dex */
public class BearLottieView extends LottieAnimationView {
    private static final String TAG = "BearLottieView";
    private boolean mHasInit;
    private boolean needPlay;

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        j.e(TAG, "xxx:playAnimation: ");
        if (isVisible() == false) goto L5;
        forcePlayAnimation();
        return;
    L5:
        this.needPlay = true;
    }

    private void forcePlayAnimation() {
        super.playAnimation();
        if (isAnimating() == false) goto L5;
        return;
    L5:
        if ((getDrawable() instanceof LottieDrawable) == false) goto L9;
        ((LottieDrawable) getDrawable()).k();
        return;
    }

    private boolean isVisible() {
        if (getVisibility() == 0) goto L5;
    L9:
        return false;
    L5:
        if (getHeight() <= 0) goto L9;
        if (getWidth() <= 0) goto L9;
        return true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.needPlay = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAnimating() == false) goto L6;
        j.e(TAG, "xxx: onAttachedToWindow: cancel animator");
        super.cancelAnimation();
        this.needPlay = true;
        return;
    }

    public BearLottieView(Context r100) {
        super(r100);
        init(null, null, 0);
    }

    private void checkAnimation(int r100) {
        if (this.mHasInit == true) goto L6;
        return;
    L6:
        if (r100 != 0) goto L13;
        if (isVisible() == false) goto L13;
        if (this.needPlay == false) goto L13;
        j.e(TAG, "xxx: checkAnimation: play " + hashCode());
        super.playAnimation();
        return;
    L13:
        if (isAnimating() == false) goto L17;
        this.needPlay = true;
        j.a(TAG, "xxx: checkAnimation: cancel " + hashCode());
        super.cancelAnimation();
        return;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        if (this.mHasInit == true) goto L7;
        super.invalidateDrawable(r100);
        return;
    L7:
        if (isVisible() == true) goto L13;
        j.e(TAG, "invalidateDrawable not visible, return");
        if (isAnimating() == false) goto L11;
        this.needPlay = true;
    L11:
        super.cancelAnimation();
        return;
    L13:
        super.invalidateDrawable(r100);
    }

    public BearLottieView(Context r100, AttributeSet r101) {
        super(r100, r101);
        init(r100, r101, 0);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        j.e(TAG, "xxx: onVisibilityChanged: " + r101);
        checkAnimation(r101);
    }

    public BearLottieView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100, r101, r102);
    }

    private void init(Context r100, AttributeSet r110, int r111) {
        if (r110 == null) goto L21;
        if (r100 == null) goto L21;
        TypedArray r101 = null;
        r101 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.lottie_autoPlay, R.attr.lottie_cacheStrategy, R.attr.lottie_colorFilter, R.attr.lottie_enableMergePathsForKitKatAndAbove, R.attr.lottie_fileName, R.attr.lottie_imageAssetsFolder, R.attr.lottie_lazyLoad, R.attr.lottie_loop, R.attr.lottie_progress, R.attr.lottie_rawRes, R.attr.lottie_repeatCount, R.attr.lottie_repeatMode, R.attr.lottie_scale, R.attr.lottie_url}, r111, 0);     // Catch: Throwable -> L11 Exception -> L13
        if (r101.getBoolean(0, false) == false) goto L9;
        this.needPlay = true;     // Catch: Throwable -> L11 Exception -> L13
    L9:
        j.e(TAG, "init, needPlay = " + this.needPlay);     // Catch: Throwable -> L11 Exception -> L13
    L16:
        r101.recycle();
        goto L21
    L13:
        e = move-exception;
        j.b(TAG, e.toString());     // Catch: Throwable -> L11
        if (r101 == null) goto L21;
    L11:
        th = move-exception;
        if (r101 == null) goto L19;
        r101.recycle();
    L19:
        throw th;
    L21:
        if (isAnimating() == false) goto L23;
        j.e(TAG, "xxx:init: cancel animator");
        super.cancelAnimation();
        this.needPlay = true;
    L23:
        this.mHasInit = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        j.e(TAG, "xxx: onSizeChanged: ");
        checkAnimation(getVisibility());
    }
}
