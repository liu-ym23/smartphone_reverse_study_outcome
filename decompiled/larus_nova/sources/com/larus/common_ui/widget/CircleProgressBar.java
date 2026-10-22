package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020\u0014H\u0002J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/widget/CircleProgressBar;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRadius", "mStrokeWidth", "mProgressbarInset", "mProgressbarBgColor", "mProgressColor", "mProgressGradientStartColor", "Ljava/lang/Integer;", "mProgressGradientEndColor", "mStartAngle", "mCurrentAngle", "", "mSweepAngle", "mMaxProgress", "mCurrentProgress", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawProgressbarBg", "rectF", "Landroid/graphics/RectF;", "drawProgress", "createProgressGradient", "Landroid/graphics/SweepGradient;", "sweepAngle", "setProgress", "progress", "getProgress", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f328400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f328401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f328402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f328403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f328404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f328405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f328406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f328407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f328408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f328409l;

    public static final class a {
    }

    static {
    }

    public CircleProgressBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CircleProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getProgress() {
        return this.f328409l;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        int r100 = getWidth() / 2;
        RectF r110 = new RectF();
        int r101 = this.f328400c;
        r110.left = r101;
        r110.top = r101;
        int r102 = r100 * 2;
        r110.right = r102 - r101;
        r110.bottom = r102 - r101;
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(this.f328399b);
        r103.setAntiAlias(true);
        r103.setColor(this.f328401d);
        r103.setStrokeCap(Paint.Cap.ROUND);
        r210.drawArc(r110, this.f328405h, this.f328407j, false, r103);
        Paint r104 = new Paint();
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(this.f328399b);
        r104.setAntiAlias(true);
        r104.setStrokeCap(Paint.Cap.ROUND);
        float r105 = 360 * ((this.f328409l * 1.0f) / this.f328408k);
        this.f328406i = r105;
        Integer r106 = this.f328403f;
        if (r106 == null) goto L18;
        int r107 = r106.intValue();
        Integer r108 = this.f328404g;
        if (r108 == null) goto L18;
        int r109 = r108.intValue();
        if (r105 <= 0.0f) goto L18;
        float r111 = RangesKt.coerceIn(r105 / this.f328407j, 0.0f, 1.0f);
        if (r111 >= 1.0f) goto L16;
        float r112 = r110.width() / 2.0f;
        if (r112 <= 0.0f) goto L14;
        float r113 = (float) (Math.asin(RangesKt.coerceIn((this.f328399b / 2.0f) / r112, 0.0f, 1.0f)) / 6.283185307179586d);
    L15:
        float r114 = RangesKt.coerceAtLeast(1.0f - r113, r111);
        SweepGradient r115 = new SweepGradient(r110.centerX(), r110.centerY(), new int[]{r107, ColorUtils.blendARGB(r107, r109, 0.5f), r109, r109, r107, r107}, new float[]{0.0f, 0.25f * r111, r111, RangesKt.coerceAtMost(r113 + r111, r114), r114, 1.0f});
    L17:
        Matrix r116 = new Matrix();
        r116.setRotate(this.f328405h, r110.centerX(), r110.centerY());
        r115.setLocalMatrix(r116);
    L19:
        r104.setShader(r115);
        if (r104.getShader() != null) goto L22;
        r104.setColor(this.f328402e);
    L22:
        r210.drawArc(r110, this.f328405h, this.f328406i, false, r104);
        return;
    L14:
        r113 = 0.0f;
        goto L15
    L16:
        r115 = new SweepGradient(r110.centerX(), r110.centerY(), r107, r109);
    L18:
        r115 = null;
        goto L19
    }

    public final void setProgress(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L12;
        int r102 = this.f328408k;
        if (r100 <= r102) goto L9;
        r100 = r102;
    L9:
        this.f328409l = r100;
        this.f328406i = 360 * ((r100 * 1.0f) / r102);
        invalidate();
        return;
    L12:
        throw new IllegalArgumentException("Progress value can not be less than 0".toString());
    L4:
        r101 = false;
        goto L5
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getMode(r100);
        if (r102 == Integer.MIN_VALUE) goto L9;
        if (r102 == 0) goto L9;
        if (r102 == 1073741824) goto L8;
        int r103 = 0;
    L10:
        setMeasuredDimension(r103, r103);
        return;
    L8:
        r103 = View.MeasureSpec.getSize(r100);
    L9:
        r103 = this.f328398a * 2;
        goto L10
    }

    public CircleProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328405h = -90;
        this.f328407j = 360;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_maxProgress, R.attr.larus_progress, R.attr.larus_progressbarBackgroundColor, R.attr.larus_progressbarColor, R.attr.larus_progressbarGradientEndColor, R.attr.larus_progressbarGradientStartColor, R.attr.larus_progressbarInset, R.attr.larus_radius, R.attr.larus_strokeWidth});
        this.f328398a = r103.getDimensionPixelSize(7, 10);
        int r104 = r103.getDimensionPixelSize(8, 8);
        this.f328399b = r104;
        this.f328400c = r103.getDimensionPixelSize(6, r104);
        this.f328401d = r103.getColor(2, ContextCompat.getColor(r100, c.b(R.attr.larus_neutral_50, r100, R.color.larus_neutral_50)));
        int r105 = r103.getColor(3, ContextCompat.getColor(r100, c.b(R.attr.larus_primary_50, r100, R.color.larus_primary_50)));
        this.f328402e = r105;
        Integer r106 = null;
        if (r103.hasValue(5) == false) goto L5;
        Integer r107 = Integer.valueOf(r103.getColor(5, r105));
    L6:
        this.f328403f = r107;
        if (r103.hasValue(4) == false) goto L9;
        r106 = Integer.valueOf(r103.getColor(4, r105));
    L9:
        this.f328404g = r106;
        this.f328408k = r103.getInt(0, 100);
        this.f328409l = r103.getInt(1, 0);
        r103.recycle();
        return;
    L5:
        r107 = null;
        goto L6
    }

    public /* synthetic */ CircleProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
