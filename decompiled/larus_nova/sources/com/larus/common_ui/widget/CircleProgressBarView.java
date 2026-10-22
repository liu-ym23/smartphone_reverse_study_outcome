package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0014J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0015J\b\u0010(\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/widget/CircleProgressBarView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackPaint", "Landroid/graphics/Paint;", "mFrontPaint", "mStrokeWidth", "", "mRadius", "isStableRadius", "", "mRect", "Landroid/graphics/RectF;", "mProgress", "", "mMax", "mWidth", "mHeight", "init", "", "setProp", "radiusDp", "strokeDp", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getRealSize", "measureSpec", "setProgress", "progress", "initRect", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleProgressBarView extends View {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f328410k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f328411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f328412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f328413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f328414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f328415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f328416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f328417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f328418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f328419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f328420j;

    public static final class a {
        public static float a(Context r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Resources r102 = r100.getResources();
            return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
        }
    }

    static {
    }

    public CircleProgressBarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CircleProgressBarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f328415e == false) goto L5;
        float r100 = this.f328414d * 2;
    L6:
        int r101 = (int) r100;
        int r102 = (this.f328419i - r101) / 2;
        int r103 = (this.f328420j - r101) / 2;
        this.f328416f.set(r102, r103, r102 + r101, r101 + r103);
        float r104 = (this.f328417g / this.f328418h) * 360;
        float r105 = this.f328419i / 2;
        float r106 = this.f328420j / 2;
        if (this.f328415e == false) goto L9;
        float r107 = this.f328414d;
    L10:
        r110.drawCircle(r105, r106, r107, this.f328411a);
        r110.drawArc(this.f328416f, -90.0f, r104, false, this.f328412b);
        return;
    L9:
        r107 = this.f328414d - (this.f328413c / 2);
        goto L10
    L5:
        float r108 = 2;
        r100 = (this.f328414d - (this.f328413c / r108)) * r108;
        goto L6
    }

    public final void setProgress(long r100) {
        this.f328417g = r100;
        postInvalidate();
    }

    public final void a(float r100, float r101) {
        this.f328415e = false;
        this.f328414d = a.a(getContext(), r100);
        this.f328413c = a.a(getContext(), r101);
        this.f328411a.setStrokeWidth(a.a(getContext(), r101));
        this.f328412b.setStrokeWidth(a.a(getContext(), r101));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 == Integer.MIN_VALUE) goto L6;
        if (r102 == 0) goto L6;
    L7:
        this.f328419i = r103;
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r104 == Integer.MIN_VALUE) goto L11;
        if (r104 == 0) goto L11;
    L12:
        this.f328420j = r105;
        setMeasuredDimension(this.f328419i, r105);
        return;
    L11:
        r105 = (int) ((this.f328414d * 2) + this.f328413c);
    L6:
        r103 = (int) ((this.f328414d * 2) + this.f328413c);
        goto L7
    }

    public CircleProgressBarView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f328411a = new Paint();
        this.f328412b = new Paint();
        this.f328413c = a.a(getContext(), 4.0f);
        this.f328414d = a.a(getContext(), 15.0f);
        this.f328415e = true;
        this.f328416f = new RectF();
        this.f328418h = 100;
        Paint r103 = new Paint();
        this.f328411a = r103;
        AppHost.Companion r104 = AppHost.f326268a;
        r103.setColor(ContextCompat.getColor(r104.getApplication(), R.color.larus_static_white));
        this.f328411a.setAlpha(153);
        this.f328411a.setAntiAlias(true);
        this.f328411a.setStyle(Paint.Style.STROKE);
        this.f328411a.setStrokeWidth(this.f328413c);
        Paint r105 = new Paint();
        this.f328412b = r105;
        r105.setColor(ContextCompat.getColor(r104.getApplication(), R.color.larus_static_white));
        this.f328412b.setAntiAlias(true);
        this.f328412b.setStyle(Paint.Style.STROKE);
        this.f328412b.setStrokeWidth(this.f328413c);
    }

    public /* synthetic */ CircleProgressBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
