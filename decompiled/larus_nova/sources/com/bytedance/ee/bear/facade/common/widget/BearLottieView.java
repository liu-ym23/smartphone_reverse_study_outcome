package com.bytedance.ee.bear.facade.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class BearLottieView extends LottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f226438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f226439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f226440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f226441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animatable f226442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObjectAnimator f226443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f226444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f226445h;

    private ObjectAnimator getOfficeProgressAnimator() {
        if (this.f226443f != null) goto L6;
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this, View.ROTATION, new float[]{0.0f, 360.0f});
        this.f226443f = r100;
        r100.setDuration(1000);
        this.f226443f.setInterpolator(new LinearInterpolator());
        this.f226443f.setRepeatCount(-1);
        this.f226443f.setRepeatMode(1);
    L6:
        return this.f226443f;
    }

    private int getOfficeProgressLoadingSize() {
        int r100 = this.f226444g;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        int r101 = getResources().getDimensionPixelSize(R.dimen.ccm_office_loading_size);
        this.f226444g = r101;
        return r101;
    }

    public final void j() {
        Animatable r100 = this.f226442e;
        if (r100 == null) goto L8;
        if (r100.isRunning() == true) goto L17;
        this.f226442e.start();
    L17:
        this.f226438a = false;
        return;
    L8:
        if (this.f226441d == null) goto L17;
        ObjectAnimator r101 = this.f226443f;
        if (r101 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == true) goto L17;
        this.f226445h = getRotation();
        getOfficeProgressAnimator().start();
        goto L17
    L12:
        if (r101.isRunning() == false) goto L14;
        r102 = true;
        goto L15
    }

    public final void l() {
        Animatable r100 = this.f226442e;
        if (r100 != null) goto L5;
    L7:
        ObjectAnimator r101 = this.f226443f;
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L16;
        this.f226443f.cancel();
        setRotation(this.f226445h);
        return;
    L16:
        return;
    L10:
        if (r101.isRunning() == false) goto L12;
        r102 = true;
        goto L13
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f226442e.stop();
        goto L7
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        tt5.a.h("BearLottieView", "xxx:playAnimation: ");
        if (this.f226440c == false) goto L10;
        if (isVisible() == false) goto L7;
        j();
        return;
    L7:
        this.f226438a = true;
        return;
    L10:
        if (isVisible() == true) goto L12;
        this.f226438a = true;
        return;
    L12:
        if (this.f226440c == false) goto L14;
        j();
        return;
    L14:
        super.playAnimation();
        if (isAnimating() == false) goto L17;
        return;
    L17:
        if ((getDrawable() instanceof LottieDrawable) == false) goto L24;
        ((LottieDrawable) getDrawable()).k();
        return;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        l();
        super.cancelAnimation();
        this.f226438a = false;
    }

    public final boolean isVisible() {
        if (getVisibility() == 0) goto L5;
    L9:
        return false;
    L5:
        if (getHeight() <= 0) goto L9;
        if (getWidth() <= 0) goto L9;
        return true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAnimating() == false) goto L6;
        tt5.a.h("BearLottieView", "xxx: onAttachedToWindow: cancel animator");
        super.cancelAnimation();
        this.f226438a = true;
        return;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        l();
        super.onDetachedFromWindow();
    }

    public BearLottieView(Context r100) {
        super(r100);
        init(null, null, 0);
    }

    public final void checkAnimation(int r100) {
        if (this.f226439b == true) goto L6;
        return;
    L6:
        if (r100 != 0) goto L16;
        if (isVisible() == false) goto L16;
        if (this.f226438a == false) goto L16;
        tt5.a.h("BearLottieView", "xxx: checkAnimation: play " + hashCode());
        if (this.f226440c == false) goto L14;
        j();
        return;
    L14:
        super.playAnimation();
        return;
    L16:
        if (isAnimating() == true) goto L37;
        Animatable r101 = this.f226442e;
        boolean r102 = false;
        if (r101 != null) goto L20;
    L22:
        boolean r103 = false;
    L23:
        if (r103 == true) goto L31;
        ObjectAnimator r104 = this.f226443f;
        if (r104 != null) goto L27;
    L29:
        boolean r105 = false;
    L30:
        if (r105 == true) goto L31;
    L32:
        if (r102 == true) goto L37;
        if (this.f226440c == false) goto L44;
        l();
        return;
    L44:
        return;
    L27:
        if (r104.isRunning() == false) goto L29;
        r105 = true;
    L31:
        r102 = true;
        goto L32
    L20:
        if (r101.isRunning() == false) goto L22;
        r103 = true;
    L37:
        this.f226438a = true;
        tt5.a.b("BearLottieView", "xxx: checkAnimation: cancel " + hashCode());
        if (this.f226440c == false) goto L40;
        l();
        return;
    L40:
        super.cancelAnimation();
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        if (this.f226439b == true) goto L7;
        super.invalidateDrawable(r100);
        return;
    L7:
        if (isVisible() == true) goto L34;
        tt5.a.h("BearLottieView", "invalidateDrawable not visible, return");
        if (this.f226440c == false) goto L30;
        Animatable r101 = this.f226442e;
        boolean r102 = false;
        if (r101 != null) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L24;
        ObjectAnimator r104 = this.f226443f;
        if (r104 != null) goto L20;
    L22:
        boolean r105 = false;
    L23:
        if (r105 == true) goto L24;
    L25:
        if (r102 == false) goto L27;
        this.f226438a = true;
    L27:
        l();
        return;
    L20:
        if (r104.isRunning() == false) goto L22;
        r105 = true;
    L24:
        r102 = true;
        goto L25
    L13:
        if (r101.isRunning() == false) goto L15;
        r103 = true;
        goto L16
    L30:
        if (isAnimating() == false) goto L32;
        this.f226438a = true;
    L32:
        super.cancelAnimation();
        return;
    L34:
        super.invalidateDrawable(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f226440c == true) goto L5;
    L8:
        super.onDraw(r100);
        return;
    L5:
        if (this.f226441d == null) goto L8;
        int r101 = getOfficeProgressLoadingSize();
        int r102 = (getWidth() - r101) / 2;
        int r103 = (getHeight() - r101) / 2;
        this.f226441d.setBounds(r102, r103, r102 + r101, r101 + r103);
        this.f226441d.draw(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimation(int r100) {
        if (r100 == R.raw.loading_anim) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L24;
        this.f226440c = true;
        if (this.f226441d != null) goto L18;
        Drawable r102 = ContextCompat.getDrawable(getContext(), R.drawable.ccm_office_loading_more);
        if (r102 == null) goto L14;
        Drawable r103 = DrawableCompat.wrap(r102).mutate();
    L15:
        this.f226441d = r103;
        if ((r103 instanceof Animatable) == false) goto L18;
        this.f226442e = (Animatable) r103;
        goto L18
    L14:
        r103 = 0;
    L18:
        setImageDrawable(this.f226441d);
        if (this.f226438a == false) goto L21;
    L22:
        j();
        return;
    L21:
        if (isVisible() == true) goto L22;
        return;
    L24:
        l();
        this.f226440c = false;
        super.setAnimation(r100);
        return;
    L5:
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L7;
        r101 = true;
        goto L8
    }

    public BearLottieView(Context r100, AttributeSet r101) {
        super(r100, r101);
        init(r100, r101, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f226440c == false) goto L6;
        int r102 = View.MeasureSpec.makeMeasureSpec(getOfficeProgressLoadingSize(), 1073741824);
        super.onMeasure(r102, r102);
        return;
    L6:
        super.onMeasure(r100, r101);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        tt5.a.h("BearLottieView", "xxx: onVisibilityChanged: " + r101);
        checkAnimation(r101);
    }

    public BearLottieView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100, r101, r102);
    }

    public final void init(Context r100, AttributeSet r110, int r111) {
        if (r110 == null) goto L21;
        if (r100 == null) goto L21;
        TypedArray r101 = null;
        r101 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.lottie_autoPlay, R.attr.lottie_cacheStrategy, R.attr.lottie_colorFilter, R.attr.lottie_enableMergePathsForKitKatAndAbove, R.attr.lottie_fileName, R.attr.lottie_imageAssetsFolder, R.attr.lottie_lazyLoad, R.attr.lottie_loop, R.attr.lottie_progress, R.attr.lottie_rawRes, R.attr.lottie_repeatCount, R.attr.lottie_repeatMode, R.attr.lottie_scale, R.attr.lottie_url}, r111, 0);     // Catch: Throwable -> L11 Exception -> L13
        if (r101.getBoolean(0, false) == false) goto L9;
        this.f226438a = true;     // Catch: Throwable -> L11 Exception -> L13
    L9:
        tt5.a.h("BearLottieView", "init, needPlay = " + this.f226438a);     // Catch: Throwable -> L11 Exception -> L13
    L16:
        r101.recycle();
        goto L21
    L13:
        e = move-exception;
        tt5.a.f("BearLottieView", e, false);     // Catch: Throwable -> L11
        if (r101 == null) goto L21;
    L11:
        th = move-exception;
        if (r101 == null) goto L19;
        r101.recycle();
    L19:
        throw th;
    L21:
        if (isAnimating() == false) goto L23;
        tt5.a.h("BearLottieView", "xxx:init: cancel animator");
        super.cancelAnimation();
        this.f226438a = true;
    L23:
        this.f226439b = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        tt5.a.h("BearLottieView", "xxx: onSizeChanged: ");
        checkAnimation(getVisibility());
    }
}
