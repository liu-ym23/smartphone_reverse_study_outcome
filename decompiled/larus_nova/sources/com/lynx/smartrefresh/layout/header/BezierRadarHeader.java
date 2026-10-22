package com.lynx.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.larus.nova.R;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.f;
import m6a.i;

/* JADX INFO: loaded from: classes32.dex */
public class BezierRadarHeader extends p6a.b implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f381570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f381571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f381572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f381573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f381574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f381575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f381576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f381577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f381578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f381579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f381580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f381581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f381582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f381583q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f381584r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f381585s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f381586t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f381587u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f381588v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f381589w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Animator f381590x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f381591y;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381592a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f381592a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f381592a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f381593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BezierRadarHeader f381594b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            byte r101 = this.f381593a;
            if (r101 != 0) goto L6;
            BezierRadarHeader r102 = this.f381594b;
            r102.f381589w = ((Float) r100.getAnimatedValue()).floatValue();
        L20:
            this.f381594b.invalidate();
            return;
        L6:
            if (1 != r101) goto L12;
            BezierRadarHeader r103 = this.f381594b;
            if (r103.f381574h == false) goto L11;
            r100.cancel();
            return;
        L11:
            r103.f381579m = ((Integer) r100.getAnimatedValue()).intValue() / 2;
            goto L20
        L12:
            if (2 != r101) goto L15;
            BezierRadarHeader r104 = this.f381594b;
            r104.f381582p = ((Float) r100.getAnimatedValue()).floatValue();
            goto L20
        L15:
            if (3 != r101) goto L18;
            BezierRadarHeader r105 = this.f381594b;
            r105.f381585s = ((Float) r100.getAnimatedValue()).floatValue();
            goto L20
        L18:
            if (4 != r101) goto L20;
            BezierRadarHeader r106 = this.f381594b;
            r106.f381586t = ((Integer) r100.getAnimatedValue()).intValue();
            goto L20
        }

        public b(BezierRadarHeader r100, byte r101) {
            this.f381594b = r100;
            this.f381593a = r101;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator r100 = this.f381590x;
        if (r100 == null) goto L6;
        r100.removeAllListeners();
        this.f381590x.end();
        this.f381590x = null;
        return;
    }

    @Override // p6a.b, m6a.g
    public final boolean a() {
        return this.f381575i;
    }

    public BezierRadarHeader(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r210) {
        int r100 = getWidth();
        if (isInEditMode() == false) goto L5;
        int r101 = getHeight();
    L6:
        int r102 = r101;
        this.f381576j.reset();
        this.f381576j.lineTo(0.0f, this.f381578l);
        Path r103 = this.f381576j;
        int r104 = this.f381580n;
        float r110 = 2.0f;
        if (r104 < 0) goto L9;
        float r105 = r104;
    L10:
        int r106 = this.f381578l;
        float r111 = r100;
        r103.quadTo(r105, this.f381579m + r106, r111, r106);
        this.f381576j.lineTo(r111, 0.0f);
        this.f381577k.setColor(this.f381571e);
        r210.drawPath(this.f381576j, this.f381577k);
        if (this.f381582p <= 0.0f) goto L26;
        this.f381577k.setColor(this.f381570d);
        float r107 = r102;
        float r108 = r107 / r6a.b.f536385b;
        float r109 = 1.0f;
        float r112 = 7.0f;
        float r113 = (r111 * 1.0f) / 7.0f;
        float r114 = this.f381583q;
        float r115 = r113 * r114;
        if (r114 <= 1.0f) goto L15;
        float r116 = ((r114 - 1.0f) * r113) / r114;
    L16:
        float r117 = r115 - r116;
        if (r114 <= 1.0f) goto L19;
        float r118 = (((r114 - 1.0f) * r107) / 2.0f) / r114;
    L20:
        float r119 = r107 - r118;
        int r120 = 0;
    L22:
        if (r120 >= 7) goto L24;
        float r121 = (r120 + r109) - 4.0f;
        this.f381577k.setAlpha((int) (((double) (this.f381582p * ((r109 - ((Math.abs(r121) / r112) * r110)) * 255.0f))) * (1.0d - (1.0d / Math.pow((((double) r108) / 800.0d) + 1.0d, 15.0d)))));
        float r122 = this.f381584r * (1.0f - (1.0f / ((r108 / 10.0f) + 1.0f)));
        r210.drawCircle(((r111 / 2.0f) - (r122 / 2.0f)) + (r117 * r121), r119 / 2.0f, r122, this.f381577k);
        r120 = r120 + 1;
        r109 = 1.0f;
        r112 = 7.0f;
        r110 = 2.0f;
        goto L22
    L24:
        this.f381577k.setAlpha(255);
        goto L26
    L19:
        r118 = 0.0f;
        goto L20
    L15:
        r116 = 0.0f;
    L26:
        if (this.f381590x == null) goto L28;
    L29:
        float r123 = this.f381587u;
        float r124 = this.f381589w;
        float r125 = r123 * r124;
        float r126 = this.f381588v * r124;
        this.f381577k.setColor(this.f381570d);
        this.f381577k.setStyle(Paint.Style.FILL);
        float r127 = r111 / 2.0f;
        float r128 = r102 / 2.0f;
        r210.drawCircle(r127, r128, r125, this.f381577k);
        this.f381577k.setStyle(Paint.Style.STROKE);
        float r129 = r126 + r125;
        r210.drawCircle(r127, r128, r129, this.f381577k);
        this.f381577k.setColor((this.f381571e & 16777215) | 1426063360);
        this.f381577k.setStyle(Paint.Style.FILL);
        this.f381591y.set(r127 - r125, r128 - r125, r127 + r125, r125 + r128);
        r210.drawArc(this.f381591y, 270.0f, this.f381586t, true, this.f381577k);
        this.f381577k.setStyle(Paint.Style.STROKE);
        this.f381591y.set(r127 - r129, r128 - r129, r127 + r129, r128 + r129);
        r210.drawArc(this.f381591y, 270.0f, this.f381586t, false, this.f381577k);
        this.f381577k.setStyle(Paint.Style.FILL);
    L31:
        if (this.f381585s <= 0.0f) goto L33;
        this.f381577k.setColor(this.f381570d);
        r210.drawCircle(r111 / 2.0f, r102 / 2.0f, this.f381585s, this.f381577k);
    L33:
        super.dispatchDraw(r210);
        return;
    L28:
        if (isInEditMode() == false) goto L31;
    L9:
        r105 = r100 / 2.0f;
        goto L10
    L5:
        r101 = this.f381581o;
        goto L6
    }

    @Override // p6a.b, m6a.g
    public void setPrimaryColors(int... r100) {
        if (r100.length <= 0) goto L8;
        if (this.f381572f == true) goto L8;
        this.f381571e = r100[0];
        this.f381572f = false;
    L8:
        if (r100.length > 1) goto L10;
        return;
    L10:
        if (this.f381573g == true) goto L14;
        this.f381570d = r100[1];
        this.f381573g = false;
        return;
    }

    public BezierRadarHeader(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.f381575i = false;
        this.f381580n = -1;
        this.f381581o = 0;
        this.f381586t = 0;
        this.f381587u = 0.0f;
        this.f381588v = 0.0f;
        this.f381589w = 0.0f;
        this.f381591y = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f527945b = n6a.b.f518184e;
        this.f381576j = new Path();
        Paint r102 = new Paint();
        this.f381577k = r102;
        r102.setAntiAlias(true);
        this.f381584r = r6a.b.c(7.0f);
        this.f381587u = r6a.b.c(20.0f);
        this.f381588v = r6a.b.c(7.0f);
        r102.setStrokeWidth(r6a.b.c(3.0f));
        setMinimumHeight(r6a.b.c(100.0f));
        if (isInEditMode() == false) goto L5;
        this.f381578l = 1000;
        this.f381589w = 1.0f;
        this.f381586t = 270;
    L6:
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.srlAccentColor, R.attr.srlEnableHorizontalDrag, R.attr.srlPrimaryColor});
        this.f381575i = r103.getBoolean(1, false);
        this.f381570d = r103.getColor(0, -1);
        this.f381573g = true;
        this.f381571e = r103.getColor(2, -14540254);
        this.f381572f = true;
        this.f381573g = r103.hasValue(0);
        this.f381572f = r103.hasValue(2);
        r103.recycle();
        return;
    L5:
        this.f381589w = 0.0f;
        goto L6
    }

    @Override // p6a.b, m6a.g
    public final int e(SmartRefreshLayout r100, boolean r101) {
        Animator r102 = this.f381590x;
        if (r102 == null) goto L5;
        r102.removeAllListeners();
        this.f381590x.end();
        this.f381590x = null;
    L5:
        int r103 = getWidth();
        int r104 = this.f381581o;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{this.f381587u, (float) Math.sqrt((r103 * r103) + (r104 * r104))});
        r105.setDuration(400);
        r105.addUpdateListener(new b(this, (byte) 3));
        r105.start();
        return 400;
    }

    @Override // p6a.b, m6a.g
    public final void d(float r100, int r101, int r102) {
        this.f381580n = r101;
        invalidate();
    }

    @Override // p6a.b, q6a.e
    public final void i(i r100, RefreshState r101, RefreshState r102) {
        int r103 = a.f381592a[r102.ordinal()];
        if (r103 != 1) goto L5;
    L7:
        this.f381582p = 1.0f;
        this.f381589w = 0.0f;
        this.f381585s = 0.0f;
        return;
    L5:
        if (r103 == 2) goto L7;
    }

    @Override // p6a.b, m6a.g
    public final void k(i r100, int r101, int r110) {
        this.f381578l = r101 - 1;
        this.f381574h = false;
        r6a.b r111 = new r6a.b(1);
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r102.setInterpolator(r111);
        r102.addUpdateListener(new b(this, (byte) 2));
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setInterpolator(r111);
        r103.addUpdateListener(new b(this, (byte) 0));
        ValueAnimator r112 = ValueAnimator.ofInt(new int[]{0, 360});
        r112.setDuration(720);
        r112.setRepeatCount(-1);
        r112.setInterpolator(new AccelerateDecelerateInterpolator());
        r112.addUpdateListener(new b(this, (byte) 4));
        AnimatorSet r104 = new AnimatorSet();
        r104.playSequentially(new Animator[]{r102, r103, r112});
        r104.start();
        int r105 = this.f381579m;
        float r106 = r105;
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{r105, 0, -((int) (0.8f * r106)), 0, -((int) (r106 * 0.4f)), 0});
        r107.addUpdateListener(new b(this, (byte) 1));
        r107.setInterpolator(new r6a.b(1));
        r107.setDuration(800);
        r107.start();
        this.f381590x = r104;
    }

    @Override // p6a.b, m6a.g
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
        this.f381581o = r102;
        if (r100 == false) goto L5;
    L6:
        this.f381574h = true;
        this.f381578l = Math.min(r103, r102);
        this.f381579m = (int) (Math.max(0, r102 - r103) * 1.9f);
        this.f381583q = r101;
        invalidate();
        return;
    L5:
        if (this.f381574h == true) goto L6;
    }
}
