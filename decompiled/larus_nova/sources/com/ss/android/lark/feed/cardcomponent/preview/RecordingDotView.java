package com.ss.android.lark.feed.cardcomponent.preview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.byted.cast.common.CastMonitor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 02\u00020\u0001:\u00010B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0014J0\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J\b\u0010*\u001a\u00020\u001eH\u0014J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001cH\u0016J\u0006\u0010-\u001a\u00020\u001eJ\u0006\u0010.\u001a\u00020\u001eJ\b\u0010/\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/RecordingDotView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dotBaseColor", "circleColor", "maxDotRadius", "", "dotRadius", "pausedDotRadius", "outerStrokeWidth", "animFps", "animationDuration", "", "outerRadius", "currentFillOpacity", "outerStrokePaint", "Landroid/graphics/Paint;", "innerFillPaint", "animator", "Landroid/animation/ValueAnimator;", "breathingEnabled", "", "setBreathingEnabled", "", "enabled", "updatePaintColors", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onDetachedFromWindow", "onVisibilityAggregated", "isVisible", "startBreathing", "stopBreathing", "getPausedDotRadius", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordingDotView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f420923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f420924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f420925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f420926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f420927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f420928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f420929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f420930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f420931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f420932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f420933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f420934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f420935m;

    public static final class a {
    }

    static {
    }

    public RecordingDotView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecordingDotView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final float getPausedDotRadius() {
        return Math.min(this.f420924b, this.f420926d);
    }

    public final void a() {
        ValueAnimator r100 = this.f420934l;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == true) goto L18;
        Log.d("RecordingDotView", "startBreathing");
        ValueAnimator r102 = this.f420934l;
        if (r102 == null) goto L12;
        r102.cancel();
    L12:
        if (this.f420934l != null) goto L14;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(this.f420929g);
        r103.setRepeatCount(-1);
        r103.setRepeatMode(2);
        r103.setInterpolator(new LinearInterpolator());
        int r104 = this.f420928f;
        Function1<ValueAnimator, Unit> r105 = new RecordingDotView$startBreathing$2(this);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r105, "block");
        long r106 = 1000 / ((long) RangesKt.coerceIn(r104, new IntRange(1, 60)));
        Ref.LongRef r107 = new Ref.LongRef();
        r103.removeAllUpdateListeners();
        r103.addUpdateListener(new f(r107, r106, r105));
        this.f420934l = r103;
    L14:
        ValueAnimator r108 = this.f420934l;
        if (r108 == null) goto L19;
        r108.start();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void b() {
        Log.d("RecordingDotView", "stopBreathing");
        ValueAnimator r100 = this.f420934l;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f420934l = null;
        this.f420931i = 1.0f;
        if (this.f420935m == false) goto L8;
        float r101 = this.f420924b;
    L9:
        this.f420925c = r101;
        c();
        invalidate();
        return;
    L8:
        r101 = getPausedDotRadius();
        goto L9
    }

    public final void c() {
        int r100 = RangesKt.coerceIn((int) (this.f420931i * 255.0f), 0, 255);
        int r101 = this.f420923a & 16777215;
        this.f420933k.setColor((r100 << 24) | r101);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        float r103 = Math.max(0.0f, this.f420925c);
        float r104 = this.f420930h;
        if (r104 <= 0.0f) goto L6;
        r100.drawCircle(r101, r102, r104, this.f420932j);
    L6:
        if (r103 <= 0.0f) goto L9;
        r100.drawCircle(r101, r102, r103, this.f420933k);
        return;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        b();
    L7:
        super.onVisibilityAggregated(r100);
        return;
    L4:
        if (this.f420935m == false) goto L6;
        a();
        goto L7
    }

    public final void setBreathingEnabled(boolean r100) {
        if (this.f420935m != r100) goto L5;
        return;
    L5:
        this.f420935m = r100;
        if (r100 == true) goto L8;
    L10:
        b();
        return;
    L8:
        if (isShown() == false) goto L10;
        a();
    }

    public RecordingDotView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f420923a = UIUtils.getColor(r100, R.color.function_danger_fill_default);
        int r103 = UIUtils.getColor(r100, R.color.function_danger_fill_hover);
        float r104 = UIUtils.dp2px(r100, 3.0f);
        this.f420924b = r104;
        this.f420925c = r104;
        this.f420926d = UIUtils.dp2px(r100, 3.0f);
        float r105 = UIUtils.dp2px(r100, 1.0f);
        this.f420927e = r105;
        this.f420928f = 20;
        this.f420929g = 700;
        this.f420931i = 1.0f;
        Paint r106 = new Paint(1);
        r106.setStyle(Paint.Style.STROKE);
        r106.setStrokeWidth(r105);
        r106.setColor(r103);
        this.f420932j = r106;
        Paint r107 = new Paint(1);
        r107.setStyle(Paint.Style.FILL);
        this.f420933k = r107;
        this.f420935m = true;
        c();
    }

    public /* synthetic */ RecordingDotView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        float r105 = Math.max(0.0f, (Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f) - (this.f420927e / 2.0f));
        this.f420930h = r105;
        float r106 = Math.max(0.0f, r105 - this.f420927e);
        this.f420924b = r106;
        if (this.f420935m == true) goto L6;
        r106 = getPausedDotRadius();
    L6:
        this.f420925c = r106;
    }
}
