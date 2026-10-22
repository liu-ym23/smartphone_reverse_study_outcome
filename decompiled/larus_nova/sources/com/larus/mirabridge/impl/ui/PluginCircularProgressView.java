package com.larus.mirabridge.impl.ui;

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
import gl9.c;
import gl9.d;

/* JADX INFO: loaded from: classes30.dex */
public class PluginCircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f359335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f359336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f359337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f359338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f359339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f359340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f359341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f359342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f359343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f359344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f359345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f359346l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f359347m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f359348n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f359349o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ValueAnimator f359350p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnimatorSet f359351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f359352r;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PluginCircularProgressView f359353a;

        public a(PluginCircularProgressView r100) {
            this.f359353a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            PluginCircularProgressView r101 = this.f359353a;
            r101.f359349o = ((Float) r100.getAnimatedValue()).floatValue();
            this.f359353a.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f359354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PluginCircularProgressView f359355b;

        public b(PluginCircularProgressView r100) {
            this.f359355b = r100;
            this.f359354a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f359354a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f359354a == true) goto L6;
            this.f359355b.b();
            return;
        }
    }

    public final void b() {
        ValueAnimator r100 = this.f359350p;
        if (r100 != null) goto L5;
    L7:
        AnimatorSet r101 = this.f359351q;
        if (r101 != null) goto L10;
    L12:
        float r102 = 360.0f;
        if (this.f359338d == true) goto L15;
        float r103 = this.f359352r;
        this.f359349o = r103;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r103, r103 + 360.0f});
        this.f359350p = r104;
        r104.setDuration(this.f359347m);
        this.f359350p.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f359350p.addUpdateListener(new a(this));
        this.f359350p.start();
        return;
    L15:
        this.f359342h = 15.0f;
        this.f359351q = new AnimatorSet();
        AnimatorSet r105 = null;
        int r106 = 0;
    L16:
        int r107 = this.f359348n;
        if (r106 >= r107) goto L22;
        float r108 = r106;
        float r110 = (((r107 - 1) * r102) / r107) + 15.0f;
        float r109 = ((r110 - 15.0f) * r108) - 90.0f;
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{15.0f, r110});
        r111.setDuration((this.f359346l / this.f359348n) / 2);
        r111.setInterpolator(new DecelerateInterpolator(1.0f));
        r111.addUpdateListener(new gl9.a(this));
        float r112 = this.f359348n;
        float r113 = (0.5f + r108) * 720.0f;
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{(r108 * 720.0f) / r112, r113 / r112});
        r114.setDuration((this.f359346l / this.f359348n) / 2);
        r114.setInterpolator(new LinearInterpolator());
        r114.addUpdateListener(new gl9.b(this));
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{r109, (r109 + r110) - 15.0f});
        r115.setDuration((this.f359346l / this.f359348n) / 2);
        r115.setInterpolator(new DecelerateInterpolator(1.0f));
        r115.addUpdateListener(new c(this, r110, r109));
        float r116 = this.f359348n;
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{r113 / r116, ((r108 + 1.0f) * 720.0f) / r116});
        r117.setDuration((this.f359346l / this.f359348n) / 2);
        r117.setInterpolator(new LinearInterpolator());
        r117.addUpdateListener(new d(this));
        AnimatorSet r118 = new AnimatorSet();
        r118.play(r111).with(r114);
        r118.play(r115).with(r117).after(r114);
        AnimatorSet.Builder r119 = this.f359351q.play(r118);
        if (r105 == null) goto L21;
        r119.after(r105);
    L21:
        r106 = r106 + 1;
        r105 = r118;
        r102 = 360.0f;
        goto L16
    L22:
        this.f359351q.addListener(new b(this));
        this.f359351q.start();
        return;
    L10:
        if (r101.isRunning() == false) goto L12;
        this.f359351q.cancel();
        goto L12
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f359350p.cancel();
        goto L7
    }

    public final void c() {
        ValueAnimator r100 = this.f359350p;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f359350p = null;
    L5:
        AnimatorSet r101 = this.f359351q;
        if (r101 == null) goto L9;
        r101.cancel();
        this.f359351q = null;
        return;
    }

    public final void e() {
        this.f359335a.setColor(this.f359345k);
        this.f359335a.setStyle(Paint.Style.STROKE);
        this.f359335a.setStrokeWidth(this.f359344j);
        this.f359335a.setStrokeCap(Paint.Cap.ROUND);
    }

    public final void d() {
        int r100 = getPaddingLeft();
        int r101 = getPaddingTop();
        RectF r102 = this.f359337c;
        int r103 = this.f359344j;
        int r104 = this.f359336b;
        r102.set(r100 + r103, r101 + r103, (r104 - r100) - r103, (r104 - r101) - r103);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f359339e == false) goto L6;
        b();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public int getColor() {
        return this.f359345k;
    }

    public float getMaxProgress() {
        return this.f359341g;
    }

    public float getProgress() {
        return this.f359340f;
    }

    public int getThickness() {
        return this.f359344j;
    }

    public PluginCircularProgressView(Context r100) {
        super(r100);
        this.f359336b = 0;
        a(null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        isInEditMode();
        float r100 = (this.f359340f / this.f359341g) * 360.0f;
        if (this.f359338d == true) goto L5;
        r110.drawArc(this.f359337c, this.f359349o, r100, false, this.f359335a);
        return;
    L5:
        r110.drawArc(this.f359337c, this.f359349o + this.f359343i, this.f359342h, false, this.f359335a);
    }

    public void setColor(int r100) {
        this.f359345k = r100;
        e();
        invalidate();
    }

    public void setIndeterminate(boolean r100) {
        if (this.f359338d == r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        this.f359338d = r100;
        b();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setMaxProgress(float r100) {
        this.f359341g = r100;
        invalidate();
    }

    public void setProgress(float r100) {
        this.f359340f = r100;
        invalidate();
    }

    public void setThickness(int r100) {
        this.f359344j = r100;
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

    public PluginCircularProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f359336b = 0;
        a(r101, 0);
    }

    public final void a(AttributeSet r100, int r101) {
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.larus_cpv_animAutostart, R.attr.larus_cpv_animDuration, R.attr.larus_cpv_animSteps, R.attr.larus_cpv_animSwoopDuration, R.attr.larus_cpv_animSyncDuration, R.attr.larus_cpv_color, R.attr.larus_cpv_indeterminate, R.attr.larus_cpv_maxProgress, R.attr.larus_cpv_progress, R.attr.larus_cpv_startAngle, R.attr.larus_cpv_thickness}, r101, 0);
        Resources r103 = getResources();
        this.f359340f = r102.getFloat(8, r103.getInteger(R.integer.larus_plugin_cpv_default_progress));
        this.f359341g = r102.getFloat(7, r103.getInteger(R.integer.larus_plugin_cpv_default_max_progress));
        this.f359344j = r102.getDimensionPixelSize(10, r103.getDimensionPixelSize(R.dimen.larus_plugin_cpv_default_thickness));
        this.f359338d = r102.getBoolean(6, r103.getBoolean(R.bool.larus_plugin_cpv_default_is_indeterminate));
        this.f359339e = r102.getBoolean(0, r103.getBoolean(R.bool.larus_plugin_cpv_default_anim_autostart));
        float r104 = r102.getFloat(9, r103.getInteger(R.integer.larus_plugin_cpv_default_start_angle));
        this.f359352r = r104;
        this.f359349o = r104;
        int r105 = getContext().getResources().getIdentifier("colorAccent", SlcElement.KEY_ATTR, getContext().getPackageName());
        if (r102.hasValue(5) == false) goto L5;
        this.f359345k = r102.getColor(5, r103.getColor(R.color.larus_plugin_cpv_default_color));
    L8:
        this.f359346l = r102.getInteger(1, r103.getInteger(R.integer.larus_plugin_cpv_default_anim_duration));
        this.f359347m = r102.getInteger(3, r103.getInteger(R.integer.larus_plugin_cpv_default_anim_swoop_duration));
        r102.getInteger(4, r103.getInteger(R.integer.larus_plugin_cpv_default_anim_sync_duration));
        this.f359348n = r102.getInteger(2, r103.getInteger(R.integer.larus_plugin_cpv_default_anim_steps));
        r102.recycle();
        this.f359335a = new Paint(1);
        e();
        this.f359337c = new RectF();
        return;
    L5:
        if (r105 == 0) goto L7;
        TypedValue r106 = new TypedValue();
        getContext().getTheme().resolveAttribute(r105, r106, true);
        this.f359345k = r106.data;
        goto L8
    L7:
        TypedArray r107 = getContext().obtainStyledAttributes(new int[]{android.R.attr.colorAccent});
        this.f359345k = r107.getColor(0, r103.getColor(R.color.larus_plugin_cpv_default_color));
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
        this.f359336b = r104;
        setMeasuredDimension(r102 + r104, r104 + r103);
    }

    public PluginCircularProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f359336b = 0;
        a(r101, r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 < r101) goto L6;
        r100 = r101;
    L6:
        this.f359336b = r100;
        d();
    }
}
