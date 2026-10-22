package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import android.os.Message;
import android.view.GestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.feed.pinch.ui.ImageCanvasView;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements r0.a {
    public final j a;
    public r14.c b;
    public View c;
    public com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b d;
    public GestureDetector e;
    public VelocityTracker f;
    public boolean g;
    public float h;
    public float i;
    public float j;
    public float k;
    public Float l;
    public int m;
    public int n;
    public float o;
    public float p;
    public float q;
    public float r;
    public final boolean s;
    public boolean t;
    public boolean u;
    public Function0<Integer> v;
    public float w;
    public float x;
    public float y;

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r1) {
    }

    public u(j r2) {
        Intrinsics.checkNotNullParameter(r2, "pinchScaleListener");
        this.a = r2;
        this.m = -1;
        this.n = -1;
        this.o = 1.0f;
        this.p = 1.0f;
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        this.w = 1.0f;
    }

    public static final void a(u r6) {
        if (r6.g == false) goto L5;
        return;
    L5:
        if (r6.s == false) goto L29;
        VelocityTracker r0 = r6.f;
        if (r0 == null) goto L9;
        r0.computeCurrentVelocity(ECDraweeView.SQUARE);
    L9:
        VelocityTracker r1 = r6.f;
        float r2 = 0.0f;
        if (r1 == null) goto L12;
        float r3 = r1.getXVelocity(0);
    L13:
        VelocityTracker r4 = r6.f;
        if (r4 == null) goto L16;
        float r5 = r4.getYVelocity(0);
    L17:
        VelocityTracker r7 = r6.f;
        if (r7 == null) goto L20;
        float r8 = r7.getXVelocity(1);
    L21:
        VelocityTracker r9 = r6.f;
        if (r9 == null) goto L24;
        r2 = r9.getYVelocity(1);
    L24:
        float r10 = Math.max(Math.max(Math.abs(r3), Math.abs(r5)), Math.max(Math.abs(r8), Math.abs(r2)));
        r6.a.j(r10);
        r6.g = true;
        if (r6.u == true) goto L30;
        r6.p = 1.0f;
        r6.q = 1.0f;
        r6.r = 1.0f;
        r6.o = 1.0f;
        return;
    L30:
        return;
    L20:
        r8 = 0.0f;
        goto L21
    L16:
        r5 = 0.0f;
        goto L17
    L12:
        r3 = 0.0f;
        goto L13
    }

    public final void c(View r11) {
        Rect r0 = new Rect();
        r11.getGlobalVisibleRect(r0);
        float r1 = r11.getTranslationX();
        float r2 = r11.getTranslationY();
        float r5 = 0.0f;
        boolean r6 = false;
        if ((((r11.getLeft() + ((r11.getWidth() - r11.getPivotX()) * r11.getScaleX())) + r11.getTranslationX()) + r11.getPivotX()) >= com.bytedance.awemeopen.apps.framework.utils.d0.d(r11.getContext())) goto L5;
        r1 = com.bytedance.awemeopen.apps.framework.utils.d0.d(r11.getContext()) - ((r11.getLeft() + ((r11.getWidth() - r11.getPivotX()) * r11.getScaleX())) + r11.getPivotX());
    L9:
        if ((r11.getHeight() * r11.getScaleY()) < com.bytedance.awemeopen.apps.framework.utils.d0.c(r11.getContext())) goto L11;
    L15:
        float r4 = 0;
        if ((((r11.getTop() + ((r4 - r11.getPivotY()) * r11.getScaleY())) + r11.getTranslationY()) + r11.getPivotY()) <= 0.0f) goto L19;
        r2 = 0.0f - ((r11.getTop() + ((r4 - r11.getPivotY()) * r11.getScaleY())) + r11.getPivotY());
    L21:
        r5 = r2;
        boolean r3 = false;
    L22:
        if (r3 == false) goto L25;
        f(this.o, r1, r5);
    L35:
        if (r0.right >= 0) goto L37;
    L42:
        float r12 = this.o;
        float r7 = this.h;
        Float r8 = this.l;
        if (r8 == null) goto L45;
        float r9 = r8.floatValue();
    L46:
        f(r12, r7, r9);
        return;
    L45:
        r9 = this.i;
        goto L46
    L37:
        if (r0.left > com.bytedance.awemeopen.apps.framework.utils.d0.d(r11.getContext())) goto L42;
        if (r0.bottom < 0) goto L42;
        if (r0.top > com.bytedance.awemeopen.apps.framework.utils.d0.c(r11.getContext())) goto L42;
        return;
    L25:
        if (r1 != r11.getTranslationX()) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == true) goto L30;
    L33:
        b(r11, r1, r5);
        goto L35
    L30:
        if (r5 != r11.getTranslationY()) goto L32;
        r6 = true;
    L32:
        if (r6 == true) goto L35;
    L27:
        r10 = false;
        goto L28
    L19:
        if ((((r11.getTop() + ((r11.getHeight() - r11.getPivotY()) * r11.getScaleY())) + r11.getTranslationY()) + r11.getPivotY()) >= com.bytedance.awemeopen.apps.framework.utils.d0.c(r11.getContext())) goto L21;
        r2 = com.bytedance.awemeopen.apps.framework.utils.d0.c(r11.getContext()) - ((r11.getTop() + ((r11.getHeight() - r11.getPivotY()) * r11.getScaleY())) + r11.getPivotY());
        goto L21
    L11:
        if (r0.top <= 0) goto L13;
    L14:
        r3 = true;
        goto L22
    L13:
        if (r0.bottom >= com.bytedance.awemeopen.apps.framework.utils.d0.c(r11.getContext())) goto L15;
    L5:
        float r13 = 0;
        if ((((r11.getLeft() + ((r13 - r11.getPivotX()) * r11.getScaleX())) + r11.getTranslationX()) + r11.getPivotX()) <= 0.0f) goto L9;
        r1 = 0.0f - ((r11.getLeft() + ((r13 - r11.getPivotX()) * r11.getScaleX())) + r11.getPivotX());
        goto L9
    }

    public final void d(View r2) {
        this.c = r2;
        float r0 = 0.0f;
        if (r2 == null) goto L5;
        float r3 = r2.getTranslationX();
    L6:
        this.j = r3;
        View r4 = this.c;
        if (r4 == null) goto L9;
        r0 = r4.getTranslationY();
    L9:
        this.k = r0;
        this.h = this.j;
        this.i = r0;
        this.l = Float.valueOf(r0);
        this.m = -1;
        this.n = -1;
        return;
    L5:
        r3 = 0.0f;
        goto L6
    }

    public static void b(View r4, float r5, float r6) {
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r4, "translationX", new float[]{r4.getTranslationX(), r5});
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r4, "translationY", new float[]{r4.getTranslationY(), r6});
        r7.setDuration(100);
        r8.setDuration(100);
        r7.start();
        r8.start();
    }

    public final void f(float r7, float r8, float r9) {
        View r0 = this.c;
        if (r0 == null) goto L5;
        ObjectAnimator r10 = ObjectAnimator.ofPropertyValuesHolder(r0, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("translationX", new float[]{r8}), PropertyValuesHolder.ofFloat("translationY", new float[]{r9}), PropertyValuesHolder.ofFloat("scaleX", new float[]{r7}), PropertyValuesHolder.ofFloat("scaleY", new float[]{r7}), PropertyValuesHolder.ofFloat("pivotX", new float[]{r0.getWidth() / 2.0f}), PropertyValuesHolder.ofFloat("pivotY", new float[]{r0.getHeight() / 2.0f})});
        r10.setDuration(100);
        r10.addListener(new t(this, r0));
        r10.start();
    L5:
        this.p = r7;
        this.o = r7;
        View r11 = this.c;
        if (r11 == null) goto L9;
        this.w = r7;
        this.x = r11.getWidth() / 2.0f;
        this.y = r11.getHeight() / 2.0f;
        return;
    }

    public final void e(ImageCanvasView r1, Integer r2, Integer r3, Float r4) {
        d(r1);
        if (r4 != null) goto L5;
        r4 = Float.valueOf(this.i);
    L5:
        this.l = r4;
        int r5 = -1;
        if (r2 == null) goto L8;
        int r6 = r2.intValue();
    L9:
        this.m = r6;
        if (r3 == null) goto L12;
        r5 = r3.intValue();
    L12:
        this.n = r5;
        return;
    L8:
        r6 = -1;
        goto L9
    }
}
