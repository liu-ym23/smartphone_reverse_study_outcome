package com.ss.android.ugc.tools.view.widget;

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
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes40.dex */
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f455004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f455005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f455006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f455007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f455008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f455009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f455010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f455011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f455012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f455013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f455014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f455015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f455016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f455017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f455018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f455019p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f455020q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f455021r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AnimatorSet f455022s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f455023t;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f455024a;

        public a(CircularProgressView r100) {
            this.f455024a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            CircularProgressView r101 = this.f455024a;
            if (r101.f455011h == 0.0f) goto L6;
            r101.f455020q = ((Float) r100.getAnimatedValue()).floatValue();
            this.f455024a.invalidate();
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f455025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f455026b;

        public b(CircularProgressView r100) {
            this.f455026b = r100;
            this.f455025a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f455025a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f455025a == true) goto L6;
            this.f455026b.b();
            return;
        }
    }

    public final void c() {
        this.f455009f = false;
        ValueAnimator r100 = this.f455021r;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f455021r = null;
    L5:
        AnimatorSet r101 = this.f455022s;
        if (r101 == null) goto L9;
        r101.cancel();
        this.f455022s = null;
        return;
    }

    public final void b() {
        if (this.f455010g == true) goto L6;
        this.f455009f = true;
        return;
    L6:
        this.f455009f = false;
        ValueAnimator r100 = this.f455021r;
        if (r100 != null) goto L9;
    L11:
        AnimatorSet r101 = this.f455022s;
        if (r101 != null) goto L14;
    L16:
        float r102 = 360.0f;
        if (this.f455007d == true) goto L19;
        float r103 = this.f455023t;
        this.f455020q = r103;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r103, r103 + 360.0f});
        this.f455021r = r104;
        r104.setDuration(this.f455018o);
        this.f455021r.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f455021r.addUpdateListener(new a(this));
        this.f455021r.start();
        return;
    L19:
        this.f455013j = 15.0f;
        this.f455022s = new AnimatorSet();
        AnimatorSet r105 = null;
        int r106 = 0;
    L20:
        int r107 = this.f455019p;
        if (r106 >= r107) goto L26;
        float r108 = r106;
        float r110 = (((r107 - 1) * r102) / r107) + 15.0f;
        float r109 = ((r110 - 15.0f) * r108) - 90.0f;
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{15.0f, r110});
        r111.setDuration((this.f455017n / this.f455019p) / 2);
        r111.setInterpolator(new DecelerateInterpolator(1.0f));
        r111.addUpdateListener(new com.ss.android.ugc.tools.view.widget.a(this));
        float r112 = this.f455019p;
        float r113 = (0.5f + r108) * 720.0f;
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{(r108 * 720.0f) / r112, r113 / r112});
        r114.setDuration((this.f455017n / this.f455019p) / 2);
        r114.setInterpolator(new LinearInterpolator());
        r114.addUpdateListener(new com.ss.android.ugc.tools.view.widget.b(this));
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{r109, (r109 + r110) - 15.0f});
        r115.setDuration((this.f455017n / this.f455019p) / 2);
        r115.setInterpolator(new DecelerateInterpolator(1.0f));
        r115.addUpdateListener(new c(this, r110, r109));
        float r116 = this.f455019p;
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{r113 / r116, ((r108 + 1.0f) * 720.0f) / r116});
        r117.setDuration((this.f455017n / this.f455019p) / 2);
        r117.setInterpolator(new LinearInterpolator());
        r117.addUpdateListener(new d(this));
        AnimatorSet r118 = new AnimatorSet();
        r118.play(r111).with(r114);
        r118.play(r115).with(r117).after(r114);
        AnimatorSet.Builder r119 = this.f455022s.play(r118);
        if (r105 == null) goto L25;
        r119.after(r105);
    L25:
        r106 = r106 + 1;
        r105 = r118;
        r102 = 360.0f;
        goto L20
    L26:
        this.f455022s.addListener(new b(this));
        this.f455022s.start();
        return;
    L14:
        if (r101.isRunning() == false) goto L16;
        this.f455022s.cancel();
        goto L16
    L9:
        if (r100.isRunning() == false) goto L11;
        this.f455021r.cancel();
        goto L11
    }

    public final void e() {
        this.f455004a.setColor(this.f455016m);
        this.f455004a.setStyle(Paint.Style.STROKE);
        this.f455004a.setStrokeWidth(this.f455015l);
        this.f455004a.setStrokeCap(Paint.Cap.ROUND);
    }

    public final void d() {
        int r100 = getPaddingLeft();
        int r101 = getPaddingTop();
        RectF r102 = this.f455006c;
        int r103 = this.f455015l;
        int r104 = this.f455005b;
        r102.set(r100 + r103, r101 + r103, (r104 - r100) - r103, (r104 - r101) - r103);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f455010g = true;
        if (this.f455008e == false) goto L5;
    L6:
        b();
        return;
    L5:
        if (this.f455009f == true) goto L6;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f455010g = false;
        c();
    }

    public int getColor() {
        return this.f455016m;
    }

    public float getMaxProgress() {
        return this.f455012i;
    }

    public float getProgress() {
        return this.f455011h;
    }

    public int getThickness() {
        return this.f455015l;
    }

    public CircularProgressView(Context r100) {
        super(r100);
        this.f455005b = 0;
        a(null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        isInEditMode();
        float r100 = (this.f455011h / this.f455012i) * 360.0f;
        if (this.f455007d == true) goto L5;
        r110.drawArc(this.f455006c, this.f455020q, r100, false, this.f455004a);
        return;
    L5:
        r110.drawArc(this.f455006c, this.f455020q + this.f455014k, this.f455013j, false, this.f455004a);
    }

    public void setColor(int r100) {
        this.f455016m = r100;
        e();
        invalidate();
    }

    public void setIndeterminate(boolean r100) {
        if (this.f455007d == r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        this.f455007d = r100;
        b();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setMaxProgress(float r100) {
        this.f455012i = r100;
        invalidate();
    }

    public void setProgress(float r100) {
        if (this.f455011h != r100) goto L5;
        return;
    L5:
        this.f455011h = r100;
        if (this.f455007d == false) goto L8;
    L8:
        invalidate();
    }

    public void setThickness(int r100) {
        this.f455015l = r100;
        e();
        d();
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        int r101 = getVisibility();
        super.setVisibility(r100);
        if (r100 == r101) goto L12;
        if (r100 != 0) goto L7;
        b();
        return;
    L7:
        if (r100 != 8) goto L9;
    L10:
        c();
        return;
    L9:
        if (r100 == 4) goto L10;
        return;
    }

    public CircularProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f455005b = 0;
        a(r101, 0);
    }

    public final void a(AttributeSet r100, int r101) {
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.cpv_animAutostart, R.attr.cpv_animDuration, R.attr.cpv_animSteps, R.attr.cpv_animSwoopDuration, R.attr.cpv_animSyncDuration, R.attr.cpv_color, R.attr.cpv_indeterminate, R.attr.cpv_maxProgress, R.attr.cpv_progress, R.attr.cpv_startAngle, R.attr.cpv_thickness}, r101, 0);
        Resources r103 = getResources();
        this.f455011h = r102.getFloat(8, r103.getInteger(R.integer.cpv_default_progress));
        this.f455012i = r102.getFloat(7, r103.getInteger(R.integer.cpv_default_max_progress));
        this.f455015l = r102.getDimensionPixelSize(10, r103.getDimensionPixelSize(R.dimen.cpv_default_thickness));
        this.f455007d = r102.getBoolean(6, r103.getBoolean(R.bool.cpv_default_is_indeterminate));
        this.f455008e = r102.getBoolean(0, r103.getBoolean(R.bool.cpv_default_anim_autostart));
        float r104 = r102.getFloat(9, r103.getInteger(R.integer.cpv_default_start_angle));
        this.f455023t = r104;
        this.f455020q = r104;
        int r105 = getContext().getResources().getIdentifier("colorAccent", SlcElement.KEY_ATTR, getContext().getPackageName());
        if (r102.hasValue(5) == false) goto L5;
        this.f455016m = r102.getColor(5, r103.getColor(R.color.cpv_default_color));
    L8:
        this.f455017n = r102.getInteger(1, r103.getInteger(R.integer.cpv_default_anim_duration));
        this.f455018o = r102.getInteger(3, r103.getInteger(R.integer.cpv_default_anim_swoop_duration));
        r102.getInteger(4, r103.getInteger(R.integer.cpv_default_anim_sync_duration));
        this.f455019p = r102.getInteger(2, r103.getInteger(R.integer.cpv_default_anim_steps));
        r102.recycle();
        this.f455004a = new Paint(1);
        e();
        this.f455006c = new RectF();
        return;
    L5:
        if (r105 == 0) goto L7;
        TypedValue r106 = new TypedValue();
        getContext().getTheme().resolveAttribute(r105, r106, true);
        this.f455016m = r106.data;
        goto L8
    L7:
        TypedArray r107 = getContext().obtainStyledAttributes(new int[]{android.R.attr.colorAccent});
        this.f455016m = r107.getColor(0, r103.getColor(R.color.cpv_default_color));
        r107.recycle();
        goto L8
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getPaddingLeft() + getPaddingRight();
        int r103 = getPaddingTop() + getPaddingBottom();
        int r104 = getMeasuredWidth() - r102;
        int r105 = getMeasuredHeight() - r103;
        if (r104 < r105) goto L6;
        r104 = r105;
    L6:
        this.f455005b = r104;
        setMeasuredDimension(r102 + r104, r104 + r103);
    }

    public CircularProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f455005b = 0;
        a(r101, r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 < r101) goto L6;
        r100 = r101;
    L6:
        this.f455005b = r100;
        d();
    }
}
