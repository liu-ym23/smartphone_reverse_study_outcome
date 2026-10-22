package com.github.rahatarmanahmed.cpv;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f274312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f274314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f274315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f274316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f274317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f274318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f274319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f274320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f274321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f274322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f274323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f274324m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f274325n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f274326o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<su7.e> f274327p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f274328q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f274329r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ValueAnimator f274330s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f274331t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f274332u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f274333v;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f274334a;

        public a(CircularProgressView r100) {
            this.f274334a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            CircularProgressView r101 = this.f274334a;
            r101.f274329r = ((Float) r100.getAnimatedValue()).floatValue();
            this.f274334a.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f274335a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Iterator r101 = ((ArrayList) this.f274335a.f274327p).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((su7.e) r101.next()).c();
            goto L4
        }

        public b(CircularProgressView r100, float r101) {
            this.f274335a = r100;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f274336a;

        public c(CircularProgressView r100) {
            this.f274336a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            CircularProgressView r101 = this.f274336a;
            r101.f274328q = ((Float) r100.getAnimatedValue()).floatValue();
            this.f274336a.invalidate();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f274337a;

        public d(CircularProgressView r100) {
            this.f274337a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            CircularProgressView r101 = this.f274337a;
            r101.f274329r = ((Float) r100.getAnimatedValue()).floatValue();
            this.f274337a.invalidate();
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f274338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f274339b;

        public e(CircularProgressView r100) {
            this.f274339b = r100;
            this.f274338a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f274338a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f274338a == true) goto L6;
            this.f274339b.b();
            return;
        }
    }

    public final void b() {
        ValueAnimator r100 = this.f274330s;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = this.f274331t;
        if (r101 != null) goto L10;
    L12:
        AnimatorSet r102 = this.f274332u;
        if (r102 != null) goto L15;
    L17:
        float r103 = 360.0f;
        if (this.f274315d == true) goto L20;
        float r104 = this.f274333v;
        this.f274328q = r104;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{r104, r104 + 360.0f});
        this.f274330s = r105;
        r105.setDuration(this.f274324m);
        this.f274330s.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f274330s.addUpdateListener(new c(this));
        this.f274330s.start();
        this.f274329r = 0.0f;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{0.0f, this.f274317f});
        this.f274331t = r106;
        r106.setDuration(this.f274325n);
        this.f274331t.setInterpolator(new LinearInterpolator());
        this.f274331t.addUpdateListener(new d(this));
        this.f274331t.start();
        return;
    L20:
        this.f274319h = 15.0f;
        this.f274332u = new AnimatorSet();
        AnimatorSet r107 = null;
        int r108 = 0;
    L21:
        int r109 = this.f274326o;
        if (r108 >= r109) goto L27;
        float r110 = r108;
        float r111 = (((r109 - 1) * r103) / r109) + 15.0f;
        float r112 = ((r111 - 15.0f) * r110) - 90.0f;
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{15.0f, r111});
        r113.setDuration((this.f274323l / this.f274326o) / 2);
        r113.setInterpolator(new DecelerateInterpolator(1.0f));
        r113.addUpdateListener(new su7.a(this));
        float r114 = this.f274326o;
        float r115 = (0.5f + r110) * 720.0f;
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{(r110 * 720.0f) / r114, r115 / r114});
        r116.setDuration((this.f274323l / this.f274326o) / 2);
        r116.setInterpolator(new LinearInterpolator());
        r116.addUpdateListener(new su7.b(this));
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{r112, (r112 + r111) - 15.0f});
        r117.setDuration((this.f274323l / this.f274326o) / 2);
        r117.setInterpolator(new DecelerateInterpolator(1.0f));
        r117.addUpdateListener(new su7.c(this, r111, r112));
        float r118 = this.f274326o;
        ValueAnimator r119 = ValueAnimator.ofFloat(new float[]{r115 / r118, ((r110 + 1.0f) * 720.0f) / r118});
        r119.setDuration((this.f274323l / this.f274326o) / 2);
        r119.setInterpolator(new LinearInterpolator());
        r119.addUpdateListener(new su7.d(this));
        AnimatorSet r120 = new AnimatorSet();
        r120.play(r113).with(r116);
        r120.play(r117).with(r119).after(r116);
        AnimatorSet.Builder r121 = this.f274332u.play(r120);
        if (r107 == null) goto L26;
        r121.after(r107);
    L26:
        r108 = r108 + 1;
        r107 = r120;
        r103 = 360.0f;
        goto L21
    L27:
        this.f274332u.addListener(new e(this));
        this.f274332u.start();
        Iterator r122 = ((ArrayList) this.f274327p).iterator();
    L29:
        if (r122.hasNext() == false) goto L36;
        ((su7.e) r122.next()).d();
        goto L29
    L36:
        return;
    L15:
        if (r102.isRunning() == false) goto L17;
        this.f274332u.cancel();
        goto L17
    L10:
        if (r101.isRunning() == false) goto L12;
        this.f274331t.cancel();
        goto L12
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f274330s.cancel();
        goto L7
    }

    public final void c() {
        ValueAnimator r100 = this.f274330s;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f274330s = null;
    L5:
        ValueAnimator r101 = this.f274331t;
        if (r101 == null) goto L8;
        r101.cancel();
        this.f274331t = null;
    L8:
        AnimatorSet r102 = this.f274332u;
        if (r102 == null) goto L12;
        r102.cancel();
        this.f274332u = null;
        return;
    }

    public final void e() {
        this.f274312a.setColor(this.f274322k);
        this.f274312a.setStyle(Paint.Style.STROKE);
        this.f274312a.setStrokeWidth(this.f274321j);
        this.f274312a.setStrokeCap(Paint.Cap.BUTT);
    }

    public final void d() {
        int r100 = getPaddingLeft();
        int r101 = getPaddingTop();
        RectF r102 = this.f274314c;
        int r103 = this.f274321j;
        int r104 = this.f274313b;
        r102.set(r100 + r103, r101 + r103, (r104 - r100) - r103, (r104 - r101) - r103);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f274316e == false) goto L6;
        b();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public int getColor() {
        return this.f274322k;
    }

    public float getMaxProgress() {
        return this.f274318g;
    }

    public float getProgress() {
        return this.f274317f;
    }

    public int getThickness() {
        return this.f274321j;
    }

    public CircularProgressView(Context r100) {
        super(r100);
        this.f274313b = 0;
        a(null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        float r100 = this.f274317f;
    L6:
        float r101 = (r100 / this.f274318g) * 360.0f;
        if (this.f274315d == true) goto L9;
        r110.drawArc(this.f274314c, this.f274328q, r101, false, this.f274312a);
        return;
    L9:
        r110.drawArc(this.f274314c, this.f274328q + this.f274320i, this.f274319h, false, this.f274312a);
        return;
    L5:
        r100 = this.f274329r;
        goto L6
    }

    public void setColor(int r100) {
        this.f274322k = r100;
        e();
        invalidate();
    }

    public void setIndeterminate(boolean r100) {
        boolean r101 = this.f274315d;
        if (r101 != r100) goto L5;
        boolean r102 = true;
    L6:
        this.f274315d = r100;
        if (r102 == false) goto L9;
        b();
    L9:
        if (r101 == r100) goto L14;
        Iterator r103 = ((ArrayList) this.f274327p).iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        ((su7.e) r103.next()).b();
        goto L12
    L16:
        return;
    L14:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setMaxProgress(float r100) {
        this.f274318g = r100;
        invalidate();
    }

    public void setProgress(float r100) {
        this.f274317f = r100;
        if (this.f274315d == true) goto L10;
        ValueAnimator r101 = this.f274331t;
        if (r101 != null) goto L7;
    L9:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{this.f274329r, r100});
        this.f274331t = r102;
        r102.setDuration(this.f274325n);
        this.f274331t.setInterpolator(new LinearInterpolator());
        this.f274331t.addUpdateListener(new a(this));
        this.f274331t.addListener(new b(this, r100));
        this.f274331t.start();
        goto L10
    L7:
        if (r101.isRunning() == false) goto L9;
        this.f274331t.cancel();
    L10:
        invalidate();
        Iterator r103 = ((ArrayList) this.f274327p).iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        ((su7.e) r103.next()).a();
        goto L12
    }

    public void setThickness(int r100) {
        this.f274321j = r100;
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
        this.f274313b = 0;
        a(r101, 0);
    }

    public final void a(AttributeSet r100, int r101) {
        this.f274327p = new ArrayList();
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.cpv_animAutostart, R.attr.cpv_animDuration, R.attr.cpv_animSteps, R.attr.cpv_animSwoopDuration, R.attr.cpv_animSyncDuration, R.attr.cpv_color, R.attr.cpv_indeterminate, R.attr.cpv_maxProgress, R.attr.cpv_progress, R.attr.cpv_startAngle, R.attr.cpv_thickness}, r101, 0);
        Resources r103 = getResources();
        this.f274317f = r102.getFloat(8, r103.getInteger(R.integer.cpv_default_progress));
        this.f274318g = r102.getFloat(7, r103.getInteger(R.integer.cpv_default_max_progress));
        this.f274321j = r102.getDimensionPixelSize(10, r103.getDimensionPixelSize(R.dimen.cpv_default_thickness));
        this.f274315d = r102.getBoolean(6, r103.getBoolean(R.bool.cpv_default_is_indeterminate));
        this.f274316e = r102.getBoolean(0, r103.getBoolean(R.bool.cpv_default_anim_autostart));
        float r104 = r102.getFloat(9, r103.getInteger(R.integer.cpv_default_start_angle));
        this.f274333v = r104;
        this.f274328q = r104;
        int r105 = getContext().getResources().getIdentifier("colorAccent", SlcElement.KEY_ATTR, getContext().getPackageName());
        if (r102.hasValue(5) == false) goto L5;
        this.f274322k = r102.getColor(5, r103.getColor(R.color.cpv_default_color));
    L8:
        this.f274323l = r102.getInteger(1, r103.getInteger(R.integer.cpv_default_anim_duration));
        this.f274324m = r102.getInteger(3, r103.getInteger(R.integer.cpv_default_anim_swoop_duration));
        this.f274325n = r102.getInteger(4, r103.getInteger(R.integer.cpv_default_anim_sync_duration));
        this.f274326o = r102.getInteger(2, r103.getInteger(R.integer.cpv_default_anim_steps));
        r102.recycle();
        this.f274312a = new Paint(1);
        e();
        this.f274314c = new RectF();
        return;
    L5:
        if (r105 == 0) goto L7;
        TypedValue r106 = new TypedValue();
        getContext().getTheme().resolveAttribute(r105, r106, true);
        this.f274322k = r106.data;
        goto L8
    L7:
        this.f274322k = getContext().obtainStyledAttributes(new int[]{android.R.attr.colorAccent}).getColor(0, r103.getColor(R.color.cpv_default_color));
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
        this.f274313b = r104;
        setMeasuredDimension(r102 + r104, r104 + r103);
    }

    public CircularProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f274313b = 0;
        a(r101, r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 < r101) goto L6;
        r100 = r101;
    L6:
        this.f274313b = r100;
        d();
    }
}
