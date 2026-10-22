package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import android.os.Message;
import android.view.GestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.awemeopen.apps.framework.feed.pinch.ui.ImageCanvasView;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class u implements r0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f195739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r14.c f195740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f195741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b f195742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GestureDetector f195743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f195744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f195745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f195746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f195747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f195748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f195749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Float f195750l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f195751m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f195752n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f195753o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f195754p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f195755q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f195756r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f195757s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f195758t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f195759u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function0<Integer> f195760v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f195761w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f195762x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f195763y;

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r100) {
    }

    public u(j r100) {
        Intrinsics.checkNotNullParameter(r100, "pinchScaleListener");
        this.f195739a = r100;
        this.f195751m = -1;
        this.f195752n = -1;
        this.f195753o = 1.0f;
        this.f195754p = 1.0f;
        this.f195755q = 1.0f;
        this.f195756r = 1.0f;
        this.f195757s = true;
        this.f195761w = 1.0f;
    }

    public static final void a(u r100) {
        if (r100.f195745g == false) goto L5;
        return;
    L5:
        if (r100.f195757s == false) goto L29;
        VelocityTracker r101 = r100.f195744f;
        if (r101 == null) goto L9;
        r101.computeCurrentVelocity(1000);
    L9:
        VelocityTracker r102 = r100.f195744f;
        float r103 = 0.0f;
        if (r102 == null) goto L12;
        float r104 = r102.getXVelocity(0);
    L13:
        VelocityTracker r105 = r100.f195744f;
        if (r105 == null) goto L16;
        float r106 = r105.getYVelocity(0);
    L17:
        VelocityTracker r107 = r100.f195744f;
        if (r107 == null) goto L20;
        float r108 = r107.getXVelocity(1);
    L21:
        VelocityTracker r109 = r100.f195744f;
        if (r109 == null) goto L24;
        r103 = r109.getYVelocity(1);
    L24:
        float r110 = Math.max(Math.max(Math.abs(r104), Math.abs(r106)), Math.max(Math.abs(r108), Math.abs(r103)));
        r100.f195739a.j(r110);
        r100.f195745g = true;
        if (r100.f195759u == true) goto L30;
        r100.f195754p = 1.0f;
        r100.f195755q = 1.0f;
        r100.f195756r = 1.0f;
        r100.f195753o = 1.0f;
        return;
    L30:
        return;
    L20:
        r108 = 0.0f;
        goto L21
    L16:
        r106 = 0.0f;
        goto L17
    L12:
        r104 = 0.0f;
        goto L13
    }

    public final void c(View r110) {
        Rect r100 = new Rect();
        r110.getGlobalVisibleRect(r100);
        float r101 = r110.getTranslationX();
        float r102 = r110.getTranslationY();
        float r103 = 0.0f;
        boolean r104 = false;
        if ((((r110.getLeft() + ((r110.getWidth() - r110.getPivotX()) * r110.getScaleX())) + r110.getTranslationX()) + r110.getPivotX()) >= com.bytedance.awemeopen.apps.framework.utils.d0.d(r110.getContext())) goto L5;
        r101 = com.bytedance.awemeopen.apps.framework.utils.d0.d(r110.getContext()) - ((r110.getLeft() + ((r110.getWidth() - r110.getPivotX()) * r110.getScaleX())) + r110.getPivotX());
    L9:
        if ((r110.getHeight() * r110.getScaleY()) < com.bytedance.awemeopen.apps.framework.utils.d0.c(r110.getContext())) goto L11;
    L15:
        float r105 = 0;
        if ((((r110.getTop() + ((r105 - r110.getPivotY()) * r110.getScaleY())) + r110.getTranslationY()) + r110.getPivotY()) <= 0.0f) goto L19;
        r102 = 0.0f - ((r110.getTop() + ((r105 - r110.getPivotY()) * r110.getScaleY())) + r110.getPivotY());
    L21:
        r103 = r102;
        boolean r106 = false;
    L22:
        if (r106 == false) goto L25;
        f(this.f195753o, r101, r103);
    L35:
        if (r100.right >= 0) goto L37;
    L42:
        float r111 = this.f195753o;
        float r107 = this.f195746h;
        Float r108 = this.f195750l;
        if (r108 == null) goto L45;
        float r109 = r108.floatValue();
    L46:
        f(r111, r107, r109);
        return;
    L45:
        r109 = this.f195747i;
        goto L46
    L37:
        if (r100.left > com.bytedance.awemeopen.apps.framework.utils.d0.d(r110.getContext())) goto L42;
        if (r100.bottom < 0) goto L42;
        if (r100.top > com.bytedance.awemeopen.apps.framework.utils.d0.c(r110.getContext())) goto L42;
        return;
    L25:
        if (r101 != r110.getTranslationX()) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == true) goto L30;
    L33:
        b(r110, r101, r103);
        goto L35
    L30:
        if (r103 != r110.getTranslationY()) goto L32;
        r104 = true;
    L32:
        if (r104 == true) goto L35;
    L27:
        r112 = false;
        goto L28
    L19:
        if ((((r110.getTop() + ((r110.getHeight() - r110.getPivotY()) * r110.getScaleY())) + r110.getTranslationY()) + r110.getPivotY()) >= com.bytedance.awemeopen.apps.framework.utils.d0.c(r110.getContext())) goto L21;
        r102 = com.bytedance.awemeopen.apps.framework.utils.d0.c(r110.getContext()) - ((r110.getTop() + ((r110.getHeight() - r110.getPivotY()) * r110.getScaleY())) + r110.getPivotY());
        goto L21
    L11:
        if (r100.top <= 0) goto L13;
    L14:
        r106 = true;
        goto L22
    L13:
        if (r100.bottom >= com.bytedance.awemeopen.apps.framework.utils.d0.c(r110.getContext())) goto L15;
    L5:
        float r113 = 0;
        if ((((r110.getLeft() + ((r113 - r110.getPivotX()) * r110.getScaleX())) + r110.getTranslationX()) + r110.getPivotX()) <= 0.0f) goto L9;
        r101 = 0.0f - ((r110.getLeft() + ((r113 - r110.getPivotX()) * r110.getScaleX())) + r110.getPivotX());
        goto L9
    }

    public final void d(View r100) {
        this.f195741c = r100;
        float r101 = 0.0f;
        if (r100 == null) goto L5;
        float r102 = r100.getTranslationX();
    L6:
        this.f195748j = r102;
        View r103 = this.f195741c;
        if (r103 == null) goto L9;
        r101 = r103.getTranslationY();
    L9:
        this.f195749k = r101;
        this.f195746h = this.f195748j;
        this.f195747i = r101;
        this.f195750l = Float.valueOf(r101);
        this.f195751m = -1;
        this.f195752n = -1;
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public static void b(View r100, float r101, float r102) {
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r100.getTranslationX(), r101});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r100.getTranslationY(), r102});
        r103.setDuration(100);
        r104.setDuration(100);
        r103.start();
        r104.start();
    }

    public final void f(float r100, float r101, float r102) {
        View r103 = this.f195741c;
        if (r103 == null) goto L5;
        ObjectAnimator r104 = ObjectAnimator.ofPropertyValuesHolder(r103, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{r100}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{r100}), PropertyValuesHolder.ofFloat("pivotX", new float[]{r103.getWidth() / 2.0f}), PropertyValuesHolder.ofFloat("pivotY", new float[]{r103.getHeight() / 2.0f})});
        r104.setDuration(100);
        r104.addListener(new t(this, r103));
        r104.start();
    L5:
        this.f195754p = r100;
        this.f195753o = r100;
        View r105 = this.f195741c;
        if (r105 == null) goto L9;
        this.f195761w = r100;
        this.f195762x = r105.getWidth() / 2.0f;
        this.f195763y = r105.getHeight() / 2.0f;
        return;
    }

    public final void e(ImageCanvasView r100, Integer r101, Integer r102, Float r103) {
        d(r100);
        if (r103 != null) goto L5;
        r103 = Float.valueOf(this.f195747i);
    L5:
        this.f195750l = r103;
        int r104 = -1;
        if (r101 == null) goto L8;
        int r105 = r101.intValue();
    L9:
        this.f195751m = r105;
        if (r102 == null) goto L12;
        r104 = r102.intValue();
    L12:
        this.f195752n = r104;
        return;
    L8:
        r105 = -1;
        goto L9
    }
}
