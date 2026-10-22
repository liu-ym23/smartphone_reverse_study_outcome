package com.bytedance.android.uicomponent.loading;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import km3.b;
import km3.c;
import km3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class CircularProgressView extends View {
    public Paint a;
    public int b;
    public RectF c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public float p;
    public AnimatorSet q;

    public class a extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ CircularProgressView b;

        public a(CircularProgressView r1) {
            this.b = r1;
            this.a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            if (this.a == true) goto L6;
            this.b.b();
            return;
        }
    }

    public final void c() {
        this.f = false;
        AnimatorSet r0 = this.q;
        if (r0 == null) goto L6;
        r0.cancel();
        this.q = null;
        return;
    }

    public final void b() {
        if (this.g == true) goto L6;
        this.f = true;
        return;
    L6:
        this.f = false;
        AnimatorSet r3 = this.q;
        if (r3 == null) goto L12;
        if (r3.isRunning() == false) goto L12;
        this.q.cancel();
    L12:
        if (this.d == false) goto L25;
        float r4 = 15.0f;
        this.j = 15.0f;
        this.q = new AnimatorSet();
        AnimatorSet r5 = null;
        int r6 = 0;
    L14:
        int r7 = this.o;
        if (r6 >= r7) goto L20;
        float r8 = r6;
        float r9 = (((r7 - 1) * 360.0f) / r7) + r4;
        float r10 = ((r9 - r4) * r8) - 90.0f;
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{r4, r9});
        r11.setDuration((this.n / this.o) / 2);
        r11.setInterpolator(new DecelerateInterpolator(1.0f));
        r11.addUpdateListener(new km3.a(this));
        float r15 = this.o;
        float r14 = (0.5f + r8) * 720.0f;
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{(r8 * 720.0f) / r15, r14 / r15});
        r12.setDuration((this.n / this.o) / 2);
        r12.setInterpolator(new LinearInterpolator());
        r12.addUpdateListener(new b(this));
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{r10, (r10 + r9) - r4});
        AnimatorSet r16 = r5;
        r13.setDuration((this.n / this.o) / 2);
        r13.setInterpolator(new DecelerateInterpolator(1.0f));
        r13.addUpdateListener(new c(this, r9, r10));
        float r17 = this.o;
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{r14 / r17, ((r8 + 1.0f) * 720.0f) / r17});
        r18.setDuration((this.n / this.o) / 2);
        r18.setInterpolator(new LinearInterpolator());
        r18.addUpdateListener(new d(this));
        r5 = new AnimatorSet();
        r5.play(r11).with(r12);
        r5.play(r13).with(r18).after(r12);
        AnimatorSet.Builder r19 = this.q.play(r5);
        if (r16 == null) goto L19;
        r19.after(r16);
    L19:
        r6 = r6 + 1;
        r4 = 15.0f;
        goto L14
    L20:
        this.q.addListener(new a(this));
        this.q.start();
        return;
    }

    public final void e() {
        this.a.setColor(this.m);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.l);
        this.a.setStrokeCap(Paint.Cap.ROUND);
    }

    public final void d() {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        RectF r2 = this.c;
        int r3 = this.l;
        int r6 = this.b;
        r2.set(r0 + r3, r1 + r3, (r6 - r0) - r3, (r6 - r1) - r3);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g = true;
        if (this.e == false) goto L5;
    L6:
        b();
        return;
    L5:
        if (this.f == true) goto L6;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
        c();
    }

    public int getColor() {
        return this.m;
    }

    public float getMaxProgress() {
        return this.i;
    }

    public float getProgress() {
        return this.h;
    }

    public int getThickness() {
        return this.l;
    }

    public CircularProgressView(Context r2) {
        super(r2);
        this.b = 0;
        a(null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        super.onDraw(r14);
        isInEditMode();
        float r0 = (this.h / this.i) * 360.0f;
        if (this.d == true) goto L5;
        r14.drawArc(this.c, this.p, r0, false, this.a);
        return;
    L5:
        r14.drawArc(this.c, this.p + this.k, this.j, false, this.a);
    }

    public void setColor(int r1) {
        this.m = r1;
        e();
        invalidate();
    }

    public void setIndeterminate(boolean r2) {
        if (this.d == r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        this.d = r2;
        b();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setMaxProgress(float r1) {
        this.i = r1;
        invalidate();
    }

    public void setProgress(float r1) {
        this.h = r1;
        if (this.d == false) goto L5;
    L5:
        invalidate();
    }

    public void setThickness(int r1) {
        this.l = r1;
        e();
        d();
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        int r0 = getVisibility();
        super.setVisibility(r2);
        if (r2 == r0) goto L12;
        if (r2 != 0) goto L7;
        b();
        return;
    L7:
        if (r2 != 8) goto L9;
    L10:
        c();
        return;
    L9:
        if (r2 == 4) goto L10;
        return;
    }

    public CircularProgressView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = 0;
        a(r2, 0);
    }

    public final void a(AttributeSet r7, int r8) {
        TypedArray r9 = getContext().obtainStyledAttributes(r7, new int[]{2130969655, 2130969656, 2130969657, 2130969658, 2130969659, 2130969660, 2130969661, 2130969662, 2130969663, 2130969664, 2130969665}, r8, 0);
        Resources r10 = getResources();
        this.h = r9.getFloat(8, r10.getInteger(2131427348));
        this.i = r9.getFloat(7, r10.getInteger(2131427347));
        this.l = r9.getDimensionPixelSize(10, r10.getDimensionPixelSize(2131165747));
        this.d = r9.getBoolean(6, r10.getBoolean(2131034116));
        this.e = r9.getBoolean(0, r10.getBoolean(2131034115));
        this.p = r9.getFloat(9, r10.getInteger(2131427349));
        int r0 = getContext().getResources().getIdentifier("colorAccent", "attr", getContext().getPackageName());
        if (r9.hasValue(5) == false) goto L5;
        this.m = r9.getColor(5, r10.getColor(2131109145));
    L8:
        this.n = r9.getInteger(1, r10.getInteger(2131427343));
        r9.getInteger(3, r10.getInteger(2131427345));
        r9.getInteger(4, r10.getInteger(2131427346));
        this.o = r9.getInteger(2, r10.getInteger(2131427344));
        r9.recycle();
        this.a = new Paint(1);
        e();
        this.c = new RectF();
        return;
    L5:
        if (r0 == 0) goto L7;
        TypedValue r1 = new TypedValue();
        getContext().getTheme().resolveAttribute(r0, r1, true);
        this.m = r1.data;
        goto L8
    L7:
        TypedArray r2 = getContext().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        this.m = r2.getColor(0, r10.getColor(2131109145));
        r2.recycle();
        goto L8
    }

    @Override // android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = getPaddingLeft() + getPaddingRight();
        int r6 = getPaddingTop() + getPaddingBottom();
        int r0 = getMeasuredWidth() - r5;
        int r1 = getMeasuredHeight() - r6;
        if (r0 < r1) goto L6;
        r0 = r1;
    L6:
        this.b = r0;
        setMeasuredDimension(r5 + r0, r0 + r6);
    }

    public CircularProgressView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = 0;
        a(r2, r3);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 < r2) goto L6;
        r1 = r2;
    L6:
        this.b = r1;
        d();
    }
}
