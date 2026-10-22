package com.obric.assistant.common.ui.progressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u00014B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eJ\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0014J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0015J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J(\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/assistant/common/ui/progressbar/CustomUpdateCircleProgressBar;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackPaint", "Landroid/graphics/Paint;", "mFrontPaint", "mStrokeWidth", "", "mRadius", "isStableRadius", "", "mRect", "Landroid/graphics/RectF;", "mProgress", "", "mMax", "mWidth", "mHeight", "centerDrawable", "Landroid/graphics/drawable/Drawable;", "centerDrawableSize", "centerDrawableRect", "Landroid/graphics/Rect;", "init", "", "setProp", "radiusDp", "strokeDp", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getRealSize", "measureSpec", "setProgress", "progress", "initRect", "updateDrawableBounds", "onSizeChanged", "w", "h", "oldw", "oldh", "Companion", "utils_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomUpdateCircleProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f387858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f387859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f387860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f387861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f387862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f387863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f387864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f387865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f387866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f387867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f387868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f387869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f387870m;

    public static final class a {
        public static float a(Context r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Resources r102 = r100.getResources();
            return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
        }
    }

    static {
    }

    public CustomUpdateCircleProgressBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomUpdateCircleProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f387862e == false) goto L5;
        float r100 = this.f387861d * 2;
    L6:
        int r101 = (int) r100;
        int r102 = (this.f387866i - r101) / 2;
        int r103 = (this.f387867j - r101) / 2;
        this.f387863f.set(r102, r103, r102 + r101, r101 + r103);
        float r104 = (this.f387864g / this.f387865h) * 360;
        float r105 = this.f387866i / 2;
        float r106 = this.f387867j / 2;
        if (this.f387862e == false) goto L9;
        float r107 = this.f387861d;
    L10:
        r110.drawCircle(r105, r106, r107, this.f387858a);
        r110.drawArc(this.f387863f, -90.0f, r104, false, this.f387859b);
        Drawable r108 = this.f387868k;
        if (r108 == null) goto L14;
        r108.setBounds(this.f387870m);
        r108.draw(r110);
        return;
    L14:
        return;
    L9:
        r107 = this.f387861d - (this.f387860c / 2);
        goto L10
    L5:
        float r109 = 2;
        r100 = (this.f387861d - (this.f387860c / r109)) * r109;
        goto L6
    }

    public final void setProgress(long r100) {
        this.f387864g = r100;
        postInvalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 == Integer.MIN_VALUE) goto L6;
        if (r102 == 0) goto L6;
    L7:
        this.f387866i = r103;
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r104 == Integer.MIN_VALUE) goto L11;
        if (r104 == 0) goto L11;
    L12:
        this.f387867j = r105;
        setMeasuredDimension(this.f387866i, r105);
        int r106 = this.f387866i / 2;
        int r107 = this.f387867j / 2;
        int r108 = this.f387869l / 2;
        this.f387870m.set(r106 - r108, r107 - r108, r106 + r108, r107 + r108);
        return;
    L11:
        r105 = (int) ((this.f387861d * 2) + this.f387860c);
    L6:
        r103 = (int) ((this.f387861d * 2) + this.f387860c);
        goto L7
    }

    public CustomUpdateCircleProgressBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f387858a = new Paint();
        this.f387859b = new Paint();
        float r103 = a.a(getContext(), 4.0f);
        this.f387860c = r103;
        this.f387861d = a.a(getContext(), 15.0f);
        this.f387862e = true;
        this.f387863f = new RectF();
        this.f387865h = 100;
        this.f387870m = new Rect();
        Paint r104 = new Paint();
        this.f387858a = r104;
        Context r105 = getContext();
        if (r105 != null) goto L5;
        r105 = AppHost.f326268a.getApplication();
    L5:
        r104.setColor(ContextCompat.getColor(r105, c.b(R.attr.larus_neutral_transparent_1, getContext(), R.color.larus_neutral_transparent_1)));
        this.f387858a.setAntiAlias(true);
        this.f387858a.setStyle(Paint.Style.STROKE);
        this.f387858a.setStrokeWidth(r103);
        Paint r106 = new Paint();
        this.f387859b = r106;
        Context r107 = getContext();
        if (r107 != null) goto L8;
        r107 = AppHost.f326268a.getApplication();
    L8:
        r106.setColor(ContextCompat.getColor(r107, c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
        this.f387859b.setAntiAlias(true);
        this.f387859b.setStyle(Paint.Style.STROKE);
        this.f387859b.setStrokeWidth(r103);
        Context r108 = getContext();
        if (r108 != null) goto L11;
        r108 = AppHost.f326268a.getApplication();
    L11:
        this.f387868k = ContextCompat.getDrawable(r108, R.drawable.ic_obric_paused);
        this.f387869l = (int) a.a(getContext(), 8.0f);
    }

    public /* synthetic */ CustomUpdateCircleProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = this.f387866i / 2;
        int r105 = this.f387867j / 2;
        int r106 = this.f387869l / 2;
        this.f387870m.set(r104 - r106, r105 - r106, r104 + r106, r105 + r106);
    }
}
