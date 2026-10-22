package com.scwang.smartrefresh.layout.header;

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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;
import cqa.h;

/* JADX INFO: loaded from: classes34.dex */
public class BezierRadarHeader extends fqa.b implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f405952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f405953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f405954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f405955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f405956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f405957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f405958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f405959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f405960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f405961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f405962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f405963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f405964p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f405965q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f405966r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f405967s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f405968t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f405969u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f405970v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f405971w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Animator f405972x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f405973y;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f405974a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f405974a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f405974a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f405975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BezierRadarHeader f405976b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            byte r101 = this.f405975a;
            if (r101 != 0) goto L6;
            BezierRadarHeader r102 = this.f405976b;
            r102.f405971w = ((Float) r100.getAnimatedValue()).floatValue();
        L20:
            this.f405976b.invalidate();
            return;
        L6:
            if (1 != r101) goto L12;
            BezierRadarHeader r103 = this.f405976b;
            if (r103.f405956h == false) goto L11;
            r100.cancel();
            return;
        L11:
            r103.f405961m = ((Integer) r100.getAnimatedValue()).intValue() / 2;
            goto L20
        L12:
            if (2 != r101) goto L15;
            BezierRadarHeader r104 = this.f405976b;
            r104.f405964p = ((Float) r100.getAnimatedValue()).floatValue();
            goto L20
        L15:
            if (3 != r101) goto L18;
            BezierRadarHeader r105 = this.f405976b;
            r105.f405967s = ((Float) r100.getAnimatedValue()).floatValue();
            goto L20
        L18:
            if (4 != r101) goto L20;
            BezierRadarHeader r106 = this.f405976b;
            r106.f405968t = ((Integer) r100.getAnimatedValue()).intValue();
            goto L20
        }

        public b(BezierRadarHeader r100, byte r101) {
            this.f405976b = r100;
            this.f405975a = r101;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator r100 = this.f405972x;
        if (r100 == null) goto L6;
        r100.removeAllListeners();
        this.f405972x.end();
        this.f405972x = null;
        return;
    }

    @Override // fqa.b, cqa.f
    public final boolean a() {
        return this.f405957i;
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
        this.f405958j.reset();
        this.f405958j.lineTo(0.0f, this.f405960l);
        Path r103 = this.f405958j;
        int r104 = this.f405962n;
        float r110 = 2.0f;
        if (r104 < 0) goto L9;
        float r105 = r104;
    L10:
        int r106 = this.f405960l;
        float r111 = r100;
        r103.quadTo(r105, this.f405961m + r106, r111, r106);
        this.f405958j.lineTo(r111, 0.0f);
        this.f405959k.setColor(this.f405953e);
        r210.drawPath(this.f405958j, this.f405959k);
        if (this.f405964p <= 0.0f) goto L26;
        this.f405959k.setColor(this.f405952d);
        float r107 = r102;
        float r108 = r107 / hqa.b.f486829b;
        float r109 = 1.0f;
        float r112 = 7.0f;
        float r113 = (r111 * 1.0f) / 7.0f;
        float r114 = this.f405965q;
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
        this.f405959k.setAlpha((int) (((double) (this.f405964p * ((r109 - ((Math.abs(r121) / r112) * r110)) * 255.0f))) * (1.0d - (1.0d / Math.pow((((double) r108) / 800.0d) + 1.0d, 15.0d)))));
        float r122 = this.f405966r * (1.0f - (1.0f / ((r108 / 10.0f) + 1.0f)));
        r210.drawCircle(((r111 / 2.0f) - (r122 / 2.0f)) + (r117 * r121), r119 / 2.0f, r122, this.f405959k);
        r120 = r120 + 1;
        r109 = 1.0f;
        r112 = 7.0f;
        r110 = 2.0f;
        goto L22
    L24:
        this.f405959k.setAlpha(255);
        goto L26
    L19:
        r118 = 0.0f;
        goto L20
    L15:
        r116 = 0.0f;
    L26:
        if (this.f405972x == null) goto L28;
    L29:
        float r123 = this.f405969u;
        float r124 = this.f405971w;
        float r125 = r123 * r124;
        float r126 = this.f405970v * r124;
        this.f405959k.setColor(this.f405952d);
        this.f405959k.setStyle(Paint.Style.FILL);
        float r127 = r111 / 2.0f;
        float r128 = r102 / 2.0f;
        r210.drawCircle(r127, r128, r125, this.f405959k);
        this.f405959k.setStyle(Paint.Style.STROKE);
        float r129 = r126 + r125;
        r210.drawCircle(r127, r128, r129, this.f405959k);
        this.f405959k.setColor((this.f405953e & 16777215) | 1426063360);
        this.f405959k.setStyle(Paint.Style.FILL);
        this.f405973y.set(r127 - r125, r128 - r125, r127 + r125, r125 + r128);
        r210.drawArc(this.f405973y, 270.0f, this.f405968t, true, this.f405959k);
        this.f405959k.setStyle(Paint.Style.STROKE);
        this.f405973y.set(r127 - r129, r128 - r129, r127 + r129, r128 + r129);
        r210.drawArc(this.f405973y, 270.0f, this.f405968t, false, this.f405959k);
        this.f405959k.setStyle(Paint.Style.FILL);
    L31:
        if (this.f405967s <= 0.0f) goto L33;
        this.f405959k.setColor(this.f405952d);
        r210.drawCircle(r111 / 2.0f, r102 / 2.0f, this.f405967s, this.f405959k);
    L33:
        super.dispatchDraw(r210);
        return;
    L28:
        if (isInEditMode() == false) goto L31;
    L9:
        r105 = r100 / 2.0f;
        goto L10
    L5:
        r101 = this.f405963o;
        goto L6
    }

    @Override // fqa.b, cqa.f
    public void setPrimaryColors(int... r100) {
        if (r100.length <= 0) goto L8;
        if (this.f405954f == true) goto L8;
        this.f405953e = r100[0];
        this.f405954f = false;
    L8:
        if (r100.length > 1) goto L10;
        return;
    L10:
        if (this.f405955g == true) goto L14;
        this.f405952d = r100[1];
        this.f405955g = false;
        return;
    }

    public BezierRadarHeader(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.f405957i = false;
        this.f405962n = -1;
        this.f405963o = 0;
        this.f405968t = 0;
        this.f405969u = 0.0f;
        this.f405970v = 0.0f;
        this.f405971w = 0.0f;
        this.f405973y = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f478467b = dqa.b.f469718e;
        this.f405958j = new Path();
        Paint r102 = new Paint();
        this.f405959k = r102;
        r102.setAntiAlias(true);
        this.f405966r = hqa.b.c(7.0f);
        this.f405969u = hqa.b.c(20.0f);
        this.f405970v = hqa.b.c(7.0f);
        r102.setStrokeWidth(hqa.b.c(3.0f));
        setMinimumHeight(hqa.b.c(100.0f));
        if (isInEditMode() == false) goto L5;
        this.f405960l = 1000;
        this.f405971w = 1.0f;
        this.f405968t = 270;
    L6:
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.srlAccentColor, R.attr.srlEnableHorizontalDrag, R.attr.srlPrimaryColor});
        this.f405957i = r103.getBoolean(1, false);
        this.f405952d = r103.getColor(0, -1);
        this.f405955g = true;
        this.f405953e = r103.getColor(2, -14540254);
        this.f405954f = true;
        this.f405955g = r103.hasValue(0);
        this.f405954f = r103.hasValue(2);
        r103.recycle();
        return;
    L5:
        this.f405971w = 0.0f;
        goto L6
    }

    @Override // fqa.b, cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Animator r102 = this.f405972x;
        if (r102 == null) goto L5;
        r102.removeAllListeners();
        this.f405972x.end();
        this.f405972x = null;
    L5:
        int r103 = getWidth();
        int r104 = this.f405963o;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{this.f405969u, (float) Math.sqrt((r103 * r103) + (r104 * r104))});
        r105.setDuration(400);
        r105.addUpdateListener(new b(this, (byte) 3));
        r105.start();
        return 400;
    }

    @Override // fqa.b, cqa.f
    public final void d(float r100, int r101, int r102) {
        this.f405962n = r101;
        invalidate();
    }

    @Override // fqa.b, gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        int r103 = a.f405974a[r102.ordinal()];
        if (r103 != 1) goto L5;
    L7:
        this.f405964p = 1.0f;
        this.f405971w = 0.0f;
        this.f405967s = 0.0f;
        return;
    L5:
        if (r103 == 2) goto L7;
    }

    @Override // fqa.b, cqa.f
    public final void i(h r100, int r101, int r110) {
        this.f405960l = r101 - 1;
        this.f405956h = false;
        hqa.b r111 = new hqa.b(1);
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
        int r105 = this.f405961m;
        float r106 = r105;
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{r105, 0, -((int) (0.8f * r106)), 0, -((int) (r106 * 0.4f)), 0});
        r107.addUpdateListener(new b(this, (byte) 1));
        r107.setInterpolator(new hqa.b(1));
        r107.setDuration(800);
        r107.start();
        this.f405972x = r104;
    }

    @Override // fqa.b, cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
        this.f405963o = r102;
        if (r100 == false) goto L5;
    L6:
        this.f405956h = true;
        this.f405960l = Math.min(r103, r102);
        this.f405961m = (int) (Math.max(0, r102 - r103) * 1.9f);
        this.f405965q = r101;
        invalidate();
        return;
    L5:
        if (this.f405956h == true) goto L6;
    }
}
