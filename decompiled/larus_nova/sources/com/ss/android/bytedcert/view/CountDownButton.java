package com.ss.android.bytedcert.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.larus.nova.R;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;
import com.ss.android.bytedcert.manager.AutoTestManager;
import jsa.k;
import rsa.i;
import usa.b;

/* JADX INFO: loaded from: classes34.dex */
public class CountDownButton extends AppCompatButton {
    public float A;
    public Integer B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f407742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f407743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f407744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f407745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f407746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f407747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f407748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f407749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DashPathEffect f407750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SweepGradient f407751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f407752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RectF f407753l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Rect f407754m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f407755n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f407756o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f407757p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile float f407758q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f407759r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f407760s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a f407761t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f407762u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f407763v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f407764w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f407765x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f407766y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f407767z;

    public interface a {
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f407755n.removeCallbacksAndMessages(null);
    }

    public int getProgressBgColor() {
        return this.f407745d;
    }

    public int getProgressColor() {
        return this.f407746e;
    }

    public CountDownButton(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        getDrawingRect(this.f407754m);
        int r100 = this.f407754m.centerX();
        int r101 = this.f407754m.centerY();
        if (AutoTestManager.getInstance().isAutoTest() == false) goto L5;
        r101 = (int) (((double) this.f407754m.centerY()) * 0.74d);
    L5:
        this.f407748g.reset();
        this.f407748g.setAntiAlias(true);
        this.f407748g.setColor(this.B.intValue());
        this.f407748g.setStyle(Paint.Style.STROKE);
        this.f407748g.setStrokeWidth(this.f407747f);
        float r102 = this.A;
        if (this.f407762u == r102) goto L10;
        a r103 = this.f407761t;
        if (r103 == null) goto L10;
        this.f407762u = r102;
        k r104 = (k) r103;
        FaceDetectFullActivity r111 = r104.f500259b;
        float r105 = r104.f500258a;
        int r112 = FaceDetectFullActivity.H;
        r111.K1(r105);
        this.f407750i = new DashPathEffect(new float[]{3.0f, (((float) (((double) ((((this.f407747f / 2.0f) + r102) + this.f407763v) * 2.0f)) * 3.141592653589793d)) / 64.0f) - 5.0f}, 0.0f);
    L10:
        this.f407748g.setStyle(Paint.Style.FILL);
        r110.drawRect(this.f407754m, this.f407748g);
        float r106 = r100;
        float r107 = r101;
        r110.drawCircle(r106, r107, r102, this.f407749h);
        this.f407748g.setAntiAlias(true);
        this.f407748g.setColor(this.f407745d);
        this.f407748g.setStyle(Paint.Style.STROKE);
        this.f407748g.setStrokeWidth(this.f407747f);
        float r108 = ((this.f407747f / 2.0f) + r102) + this.f407763v;
        RectF r109 = this.f407753l;
        if (r109 != null) goto L13;
        this.f407753l = new RectF(r106 - r108, r107 - r108, r106 + r108, r107 + r108);
    L15:
        if (this.f407764w == true) goto L17;
        r110.drawArc(this.f407753l, this.f407744c, this.f407743b, false, this.f407748g);
    L22:
        if (this.f407766y == false) goto L25;
        this.f407748g.setColor(this.f407767z);
        this.f407748g.setStrokeCap(Paint.Cap.ROUND);
        this.f407748g.setStrokeWidth(this.f407747f);
        this.f407748g.setPathEffect(null);
        r110.drawArc(this.f407753l, 90.0f - (this.f407742a / 2.0f), this.f407743b, false, this.f407748g);
        return;
    L25:
        if (this.f407765x == true) goto L27;
        this.f407748g.setColor(this.f407746e);
        this.f407748g.setStrokeCap(Paint.Cap.ROUND);
    L31:
        this.f407748g.setStrokeWidth(this.f407747f);
        this.f407748g.setPathEffect(null);
        float r113 = this.f407758q;
        float r114 = this.f407757p;
        if (r113 <= r114) goto L35;
        this.f407758q = r114;
    L35:
        if (this.f407758q >= 0.0f) goto L37;
        this.f407758q = 0.0f;
    L37:
        r110.drawArc(this.f407753l, 90.0f - (this.f407742a / 2.0f), (-(this.f407758q / this.f407757p)) * this.f407743b, false, this.f407748g);
        return;
    L27:
        if (this.f407751j != null) goto L29;
        this.f407751j = new SweepGradient(r106, r107, this.f407752k, null);
    L29:
        this.f407748g.setColor(-1);
        this.f407748g.setShader(this.f407751j);
        this.f407748g.setStrokeCap(Paint.Cap.BUTT);
        goto L31
    L17:
        if (this.f407750i != null) goto L19;
        this.f407750i = new DashPathEffect(new float[]{3.0f, (((float) (((double) (((r102 + (this.f407747f / 2.0f)) + this.f407763v) * 2.0f)) * 3.141592653589793d)) / 64.0f) - 5.0f}, 0.0f);
    L19:
        this.f407748g.setPathEffect(this.f407750i);
        this.f407748g.setStrokeCap(Paint.Cap.BUTT);
        r110.drawCircle(r106, r107, r108, this.f407748g);
        goto L22
    L13:
        r109.set(r106 - r108, r107 - r108, r106 + r108, r107 + r108);
        goto L15
    }

    public void setAngleHole(int r100) {
        this.f407742a = r100;
        this.f407743b = 360 - r100;
        this.f407744c = (-180) - (90 - (r100 / 2));
    }

    public void setBgColor(int r100) {
        this.B = Integer.valueOf(r100);
        setBackgroundColor(r100);
        postInvalidate();
    }

    public void setDash(boolean r100) {
        this.f407764w = r100;
    }

    public void setOnSizeChangedListener(a r100) {
        this.f407761t = r100;
    }

    public void setProgressBgColor(int r100) {
        this.f407745d = r100;
    }

    public void setProgressColor(int r100) {
        this.f407746e = r100;
    }

    public void setProgressGap(float r100) {
        this.f407763v = r100;
    }

    public void setProgressLineWidth(float r100) {
        this.f407747f = r100;
    }

    public CountDownButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        if (r102 <= r103) goto L5;
        r103 = r102;
    L7:
        setMeasuredDimension(r102, r103);
        return;
    L5:
        if (r102 >= r103) goto L7;
        r102 = r103;
        goto L7
    }

    public CountDownButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407747f = 2.0f;
        this.f407755n = new Handler(Looper.getMainLooper());
        this.f407757p = 10.0f;
        this.f407758q = 10.0f;
        this.f407760s = -1;
        this.B = null;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.byted_circleBgColr, R.attr.byted_circleEndColor, R.attr.byted_delayTime, R.attr.byted_progressBgColor, R.attr.byted_progressColor, R.attr.byted_progressLineWidth, R.attr.byted_totalTime});
        this.f407745d = r103.getColor(3, -1);
        this.f407746e = r103.getColor(4, -1);
        r103.recycle();
        this.f407763v = i.b(getContext(), 4.0f);
        this.f407754m = new Rect();
        this.f407748g = new Paint();
        Paint r104 = new Paint();
        this.f407749h = r104;
        r104.setAntiAlias(true);
        this.f407749h.setAlpha(0);
        this.f407749h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        setAngleHole(30);
        this.f407756o = new b(this);
        this.A = i.d(getContext());
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.A = i.d(getContext());
    }
}
