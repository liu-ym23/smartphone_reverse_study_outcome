package com.ss.android.bytedcert.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.AppCompatButton;
import com.larus.nova.R;
import com.ss.android.bytedcert.manager.AutoTestManager;
import java.util.concurrent.atomic.AtomicBoolean;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class CircleMotionView extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f407720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f407721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f407722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f407723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f407724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f407725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f407726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f407727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Rect f407728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f407729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile float f407730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile float f407731l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f407732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f407733n;

    public static class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f407734a;

        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            if (r100 >= 0.5d) goto L5;
            float r101 = r100 * 2.0f;
            this.f407734a = (float) (((double) ((r101 * r101) * ((1.3f * r101) - 0.3f))) * 0.5d);
        L7:
            return this.f407734a;
        L5:
            float r102 = (r100 * 2.0f) - 2.0f;
            this.f407734a = (float) (((double) (((r102 * r102) * ((1.3f * r102) + 0.3f)) + 2.0f)) * 0.5d);
            goto L7
        }
    }

    public int getProgressBgColor() {
        Integer r100 = this.f407721b;
        if (r100 != null) goto L5;
        return 16749994;
    L5:
        return r100.intValue();
    }

    public int getProgressColor() {
        Integer r100 = this.f407722c;
        if (r100 != null) goto L5;
        return 16749994;
    L5:
        return r100.intValue();
    }

    public CircleMotionView(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        this.f407726g.reset();
        getDrawingRect(this.f407728i);
        this.f407724e = this.f407728i.centerX();
        this.f407725f = this.f407728i.centerY();
        if (AutoTestManager.getInstance().isAutoTest() == false) goto L5;
        this.f407725f = (int) (((double) this.f407728i.centerY()) * 0.74d);
    L5:
        float r100 = i.d(getContext());
        float r101 = (this.f407723d / 2.0f) + r100;
        this.f407726g.setAntiAlias(true);
        this.f407726g.setColor(this.f407720a.intValue());
        this.f407726g.setStyle(Paint.Style.STROKE);
        this.f407726g.setStrokeWidth(this.f407723d);
        this.f407726g.setStyle(Paint.Style.FILL);
        r110.drawRect(this.f407728i, this.f407726g);
        r110.drawCircle(this.f407724e, this.f407725f, r100, this.f407727h);
        this.f407726g.setAntiAlias(true);
        this.f407726g.setColor(getProgressBgColor());
        this.f407726g.setAlpha(255);
        this.f407726g.setStyle(Paint.Style.STROKE);
        this.f407726g.setStrokeWidth(this.f407723d);
        float r102 = r101 + 10.0f;
        RectF r103 = this.f407729j;
        float r104 = this.f407724e;
        r103.left = (int) (r104 - r102);
        float r105 = this.f407725f;
        r103.top = (int) (r105 - r102);
        r103.right = (int) (r104 + r102);
        r103.bottom = (int) (r105 + r102);
        r110.drawArc(r103, (-35.0f) - (this.f407731l * 180.0f), 180.0f, false, this.f407726g);
        this.f407726g.setStrokeWidth(this.f407723d * 3.0f);
        this.f407726g.setAlpha(255);
        r110.drawArc(this.f407729j, 145.0f - (this.f407731l * 180.0f), 180.0f, false, this.f407726g);
        float r106 = (i.d(getContext()) + (this.f407723d / 2.0f)) + i.b(getContext(), 16.0f);
        this.f407726g.reset();
        this.f407726g.setAntiAlias(true);
        this.f407726g.setStrokeWidth(this.f407723d);
        this.f407726g.setStyle(Paint.Style.STROKE);
        this.f407726g.setColor(getProgressColor());
        this.f407726g.setAlpha(255);
        this.f407726g.setStrokeWidth(this.f407723d);
        this.f407726g.setPathEffect(new DashPathEffect(new float[]{20.0f, 20.0f}, 0.0f));
        this.f407726g.setStrokeCap(Paint.Cap.ROUND);
        RectF r107 = this.f407729j;
        float r108 = this.f407724e;
        r107.left = (int) (r108 - r106);
        float r109 = this.f407725f;
        r107.top = (int) (r109 - r106);
        r107.right = (int) (r108 + r106);
        r107.bottom = (int) (r109 + r106);
        r110.drawArc(r107, ((-this.f407730k) * 180.0f) + 145.0f, 358.0f, false, this.f407726g);
        this.f407726g.reset();
        this.f407726g.setAntiAlias(true);
        this.f407726g.setStrokeWidth(this.f407723d);
        this.f407726g.setStyle(Paint.Style.STROKE);
        this.f407726g.setColor(getProgressColor());
        this.f407726g.setAlpha(255);
        this.f407726g.setStrokeCap(Paint.Cap.ROUND);
        this.f407726g.setStrokeWidth((float) (((double) this.f407723d) * 3.0d));
        r110.drawArc(this.f407729j, (this.f407730k * 180.0f) - 35.0f, 180.0f, false, this.f407726g);
    }

    public void setBgColor(int r100) {
        this.f407720a = Integer.valueOf(r100);
        setBackgroundColor(r100);
        postInvalidate();
    }

    public void setProgressBgColor(int r100) {
        this.f407721b = Integer.valueOf(r100);
    }

    public void setProgressColor(int r100) {
        this.f407722c = Integer.valueOf(r100);
    }

    public void setProgressLineWidth(float r100) {
        this.f407723d = r100;
    }

    public CircleMotionView(Context r100, AttributeSet r101) {
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

    public CircleMotionView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407720a = -1;
        this.f407730k = 0.0f;
        this.f407731l = 0.0f;
        this.f407733n = new AtomicBoolean(false);
        getContext().obtainStyledAttributes(r101, new int[]{R.attr.byted_circleBgColr, R.attr.byted_circleEndColor, R.attr.byted_delayTime, R.attr.byted_progressBgColor, R.attr.byted_progressColor, R.attr.byted_progressLineWidth, R.attr.byted_totalTime}).recycle();
        this.f407728i = new Rect();
        this.f407729j = new RectF();
        this.f407726g = new Paint();
        new Path();
        new Point();
        this.f407726g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        Paint r103 = new Paint();
        this.f407727h = r103;
        r103.setAntiAlias(true);
        this.f407727h.setAlpha(0);
        this.f407727h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }
}
