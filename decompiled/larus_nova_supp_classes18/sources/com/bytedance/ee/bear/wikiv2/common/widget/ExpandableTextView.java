package com.bytedance.ee.bear.wikiv2.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ExpandableTextView extends LinearLayout implements View.OnClickListener {
    public TextView a;
    public ExpandButton b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Drawable i;
    public Drawable j;
    public String k;
    public String l;
    public int m;
    public boolean n;

    public class a implements Animation.AnimationListener {
        public final /* synthetic */ ExpandableTextView a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(ExpandableTextView r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            this.a.clearAnimation();
            ExpandableTextView r3 = this.a;
            r3.n = false;
            r3.getClass();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ExpandableTextView a;

        @Override // java.lang.Runnable
        public final void run() {
            ExpandableTextView r0 = this.a;     // Catch: Throwable -> L4
            r0.h = r0.getHeight() - this.a.a.getHeight();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ExpandableTextView r1) {
            this.a = r1;
        }
    }

    public class c extends Animation {
        public final View a;
        public final int b;
        public final int c;
        public final /* synthetic */ ExpandableTextView d;

        @Override // android.view.animation.Animation
        public final boolean willChangeBounds() {
            return true;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r2, Transformation r3) {
            int r4 = this.c;
            int r0 = this.b;
            int r5 = (int) (((r4 - r0) * r2) + r0);
            ExpandableTextView r6 = this.d;
            r6.a.setMaxHeight(r5 - r6.h);
            this.a.getLayoutParams().height = r5;
            this.a.requestLayout();
        }

        public c(ExpandableTextView r1, View r2, int r3, int r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            setDuration(r1.m);
        }

        @Override // android.view.animation.Animation
        public final void initialize(int r1, int r2, int r3, int r4) {
            super.initialize(r1, r2, r3, r4);
        }
    }

    public interface d {
    }

    public void setOnExpandStateChangeListener(d r1) {
    }

    public CharSequence getText() {
        TextView r0 = this.a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getText();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(2131371911);
        ExpandButton r0 = (ExpandButton) findViewById(2131371885);
        this.b = r0;
        boolean r1 = this.d;
        if (r1 == false) goto L5;
        Drawable r2 = this.i;
    L6:
        if (r1 == false) goto L8;
        String r3 = this.k;
    L9:
        r0.a.setImageDrawable(r2);
        r0.b.setText(r3);
        this.b.setOnClickListener(this);
        return;
    L8:
        r3 = this.l;
        goto L9
    L5:
        r2 = this.j;
        goto L6
    }

    public ExpandableTextView(Context r2) {
        this(r2, null);
    }

    public final void a(AttributeSet r6) {
        TypedArray r7 = getContext().obtainStyledAttributes(r6, new int[]{2130968789, 2130968790, 2130969551, 2130969553, 2130969991, 2130969993, 2130969994, 2130969996, 2130969997, 2130970001, 2130972693});
        this.g = r7.getInt(10, 8);
        this.m = r7.getInt(1, 300);
        r7.getFloat(0, 1.0f);
        this.i = r7.getDrawable(5);
        this.j = r7.getDrawable(2);
        if (this.i != null) goto L6;
        Context r2 = getContext();
        this.i = r2.getResources().getDrawable(kac.a.b(2131235301), r2.getTheme());
    L6:
        if (this.j != null) goto L8;
        Context r3 = getContext();
        this.j = r3.getResources().getDrawable(kac.a.b(2131235302), r3.getTheme());
    L8:
        this.k = getResources().getString(2131888344);
        this.l = getResources().getString(2131888343);
        r7.recycle();
        setOrientation(1);
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        if (this.b.getVisibility() == 0) goto L5;
        return;
    L5:
        boolean r11 = !this.d;
        this.d = r11;
        this.n = true;
        if (r11 == false) goto L8;
        c r12 = new c(this, this, getHeight(), this.e);
    L9:
        final ExpandButton r1 = this.b;
        boolean r2 = this.d;
        if (r2 == false) goto L12;
        Drawable r3 = this.i;
    L13:
        if (r2 == false) goto L15;
        String r4 = this.k;
    L16:
        int r5 = this.m;
        r1.c.cancel();
        long r7 = r5 / 2;
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(r7);
        r6.addUpdateListener(new vp5.a(r1));
        r6.addListener(new vp5.c(r1, r3, r4));
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r7);
        r8.addUpdateListener(new vp5.b(r1));
        r1.c.play(r8).after(r6);
        r1.c.start();
        r12.setFillAfter(true);
        r12.setAnimationListener(new a(this));
        clearAnimation();
        startAnimation(r12);
        return;
    L15:
        r4 = this.l;
        goto L16
    L12:
        r3 = this.j;
        goto L13
    L8:
        r12 = new c(this, this, getHeight(), (getHeight() + this.f) - this.a.getHeight());
        goto L9
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return this.n;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r2) {
        if (r2 == 0) goto L6;
        super.setOrientation(r2);
        return;
    L6:
        throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
    }

    public void setText(CharSequence r2) {
        this.c = true;
        this.a.setText(r2);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public ExpandableTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.d = true;
        a(r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        if (this.c == true) goto L5;
    L17:
        super.onMeasure(r5, r6);
        return;
    L5:
        if (getVisibility() == 8) goto L17;
        this.c = false;
        this.b.setVisibility(8);
        this.a.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(r5, r6);
        if (this.a.getLineCount() > this.g) goto L10;
        return;
    L10:
        TextView r1 = this.a;
        this.f = r1.getLayout().getLineTop(r1.getLineCount()) + (r1.getCompoundPaddingTop() + r1.getCompoundPaddingBottom());
        if (this.d == false) goto L13;
        this.a.setMaxLines(this.g);
    L13:
        this.b.setVisibility(0);
        ((LinearLayout.LayoutParams) this.a.getLayoutParams()).bottomMargin = 0;
        super.onMeasure(r5, r6);
        if (this.d == false) goto L19;
        this.a.post(new b(this));
        this.e = getMeasuredHeight();
        return;
    }

    public ExpandableTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.d = true;
        a(r2);
    }
}
