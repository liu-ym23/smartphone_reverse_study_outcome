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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BearLottieView extends LottieAnimationView {
    public boolean a;
    public boolean b;
    public boolean c;
    public Drawable d;
    public Animatable e;
    public ObjectAnimator f;
    public int g;
    public float h;

    private ObjectAnimator getOfficeProgressAnimator() {
        if (this.f != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, View.ROTATION, new float[]{0.0f, 360.0f});
        this.f = r0;
        r0.setDuration(1000);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setRepeatCount(-1);
        this.f.setRepeatMode(1);
    L6:
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getOfficeProgressLoadingSize() {
        int r0 = this.g;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r1 = getResources().getDimensionPixelSize(2131165488);
        this.g = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        Animatable r0 = this.e;
        if (r0 == null) goto L8;
        if (r0.isRunning() == true) goto L17;
        this.e.start();
    L17:
        this.a = false;
        return;
    L8:
        if (this.d == null) goto L17;
        ObjectAnimator r1 = this.f;
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L17;
        this.h = getRotation();
        getOfficeProgressAnimator().start();
        goto L17
    L12:
        if (r1.isRunning() == false) goto L14;
        r2 = true;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        Animatable r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        ObjectAnimator r1 = this.f;
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L16;
        this.f.cancel();
        setRotation(this.h);
        return;
    L16:
        return;
    L10:
        if (r1.isRunning() == false) goto L12;
        r2 = true;
        goto L13
    L5:
        if (r0.isRunning() == false) goto L7;
        this.e.stop();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void playAnimation() {
        tt5.a.h("BearLottieView", "xxx:playAnimation: ");
        if (this.c == false) goto L10;
        if (isVisible() == false) goto L7;
        j();
        return;
    L7:
        this.a = true;
        return;
    L10:
        if (isVisible() == true) goto L12;
        this.a = true;
        return;
    L12:
        if (this.c == false) goto L14;
        j();
        return;
    L14:
        super.playAnimation();
        if (isAnimating() == false) goto L17;
        return;
    L17:
        if ((getDrawable() instanceof LottieDrawable) == false) goto L24;
        getDrawable().k();
        return;
    }

    public void cancelAnimation() {
        l();
        super.cancelAnimation();
        this.a = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isVisible() {
        if (getVisibility() == 0) goto L5;
    L9:
        return false;
    L5:
        if (getHeight() <= 0) goto L9;
        if (getWidth() <= 0) goto L9;
        return true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAnimating() == false) goto L6;
        tt5.a.h("BearLottieView", "xxx: onAttachedToWindow: cancel animator");
        super.cancelAnimation();
        this.a = true;
        return;
    }

    public void onDetachedFromWindow() {
        l();
        super.onDetachedFromWindow();
    }

    public BearLottieView(Context r2) {
        super(r2);
        init(null, null, 0);
    }

    public final void checkAnimation(int r4) {
        if (this.b == true) goto L6;
        return;
    L6:
        if (r4 != 0) goto L16;
        if (isVisible() == false) goto L16;
        if (this.a == false) goto L16;
        tt5.a.h("BearLottieView", "xxx: checkAnimation: play " + hashCode());
        if (this.c == false) goto L14;
        j();
        return;
    L14:
        super.playAnimation();
        return;
    L16:
        if (isAnimating() == true) goto L37;
        Animatable r5 = this.e;
        boolean r2 = false;
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == true) goto L31;
        ObjectAnimator r7 = this.f;
        if (r7 != null) goto L27;
    L29:
        boolean r8 = false;
    L30:
        if (r8 == true) goto L31;
    L32:
        if (r2 == true) goto L37;
        if (this.c == false) goto L44;
        l();
        return;
    L44:
        return;
    L27:
        if (r7.isRunning() == false) goto L29;
        r8 = true;
    L31:
        r2 = true;
        goto L32
    L20:
        if (r5.isRunning() == false) goto L22;
        r6 = true;
    L37:
        this.a = true;
        tt5.a.b("BearLottieView", "xxx: checkAnimation: cancel " + hashCode());
        if (this.c == false) goto L40;
        l();
        return;
    L40:
        super.cancelAnimation();
    }

    public void invalidateDrawable(Drawable r3) {
        if (this.b == true) goto L7;
        super.invalidateDrawable(r3);
        return;
    L7:
        if (isVisible() == true) goto L34;
        tt5.a.h("BearLottieView", "invalidateDrawable not visible, return");
        if (this.c == false) goto L30;
        Animatable r4 = this.e;
        boolean r1 = false;
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L24;
        ObjectAnimator r6 = this.f;
        if (r6 != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == true) goto L24;
    L25:
        if (r1 == false) goto L27;
        this.a = true;
    L27:
        l();
        return;
    L20:
        if (r6.isRunning() == false) goto L22;
        r7 = true;
    L24:
        r1 = true;
        goto L25
    L13:
        if (r4.isRunning() == false) goto L15;
        r5 = true;
        goto L16
    L30:
        if (isAnimating() == false) goto L32;
        this.a = true;
    L32:
        super.cancelAnimation();
        return;
    L34:
        super.invalidateDrawable(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r6) {
        if (this.c == true) goto L5;
    L8:
        super/*android.widget.ImageView*/.onDraw(r6);
        return;
    L5:
        if (this.d == null) goto L8;
        int r0 = getOfficeProgressLoadingSize();
        int r1 = (getWidth() - r0) / 2;
        int r2 = (getHeight() - r0) / 2;
        this.d.setBounds(r1, r2, r1 + r0, r0 + r2);
        this.d.draw(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAnimation(int r5) {
        if (r5 == 2131820626) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L24;
        this.c = true;
        if (this.d != null) goto L18;
        Drawable r6 = ContextCompat.getDrawable(getContext(), 2131232566);
        if (r6 == null) goto L14;
        Drawable r7 = DrawableCompat.wrap(r6).mutate();
    L15:
        this.d = r7;
        if ((r7 instanceof Animatable) == false) goto L18;
        this.e = (Animatable) r7;
        goto L18
    L14:
        r7 = 0;
    L18:
        setImageDrawable(this.d);
        if (this.a == false) goto L21;
    L22:
        j();
        return;
    L21:
        if (isVisible() == true) goto L22;
        return;
    L24:
        l();
        this.c = false;
        super.setAnimation(r5);
        return;
    L5:
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L7;
        r0 = true;
        goto L8
    }

    public BearLottieView(Context r2, AttributeSet r3) {
        super(r2, r3);
        init(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r2, int r3) {
        if (this.c == false) goto L6;
        int r4 = View.MeasureSpec.makeMeasureSpec(getOfficeProgressLoadingSize(), 1073741824);
        super/*android.widget.ImageView*/.onMeasure(r4, r4);
        return;
    L6:
        super/*android.widget.ImageView*/.onMeasure(r2, r3);
    }

    public void onVisibilityChanged(View r2, int r3) {
        tt5.a.h("BearLottieView", "xxx: onVisibilityChanged: " + r3);
        checkAnimation(r3);
    }

    public BearLottieView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init(Context r9, AttributeSet r10, int r11) {
        if (r10 == null) goto L21;
        if (r9 == null) goto L21;
        TypedArray r3 = null;
        r3 = getContext().obtainStyledAttributes(r10, new int[]{2130972609, 2130972610, 2130972611, 2130972626, 2130972627, 2130972628, 2130972629, 2130972630, 2130972631, 2130972632, 2130972633, 2130972634, 2130972635, 2130972636}, r11, 0);     // Catch: Throwable -> L11 Exception -> L13
        if (r3.getBoolean(0, false) == false) goto L9;
        this.a = true;     // Catch: Throwable -> L11 Exception -> L13
    L9:
        tt5.a.h("BearLottieView", "init, needPlay = " + this.a);     // Catch: Throwable -> L11 Exception -> L13
    L16:
        r3.recycle();
        goto L21
    L13:
        e = move-exception;
        tt5.a.f("BearLottieView", e, false);     // Catch: Throwable -> L11
        if (r3 == null) goto L21;
    L11:
        th = move-exception;
        if (r3 == null) goto L19;
        r3.recycle();
    L19:
        throw th;
    L21:
        if (isAnimating() == false) goto L23;
        tt5.a.h("BearLottieView", "xxx:init: cancel animator");
        super.cancelAnimation();
        this.a = true;
    L23:
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        tt5.a.h("BearLottieView", "xxx: onSizeChanged: ");
        checkAnimation(getVisibility());
    }
}
