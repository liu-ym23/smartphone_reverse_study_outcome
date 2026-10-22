package com.larus.common_ui.widget.shimmer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.larus.utils.CubicBezierInterpolator;
import com.ss.android.lark.utils.statistics.PerfLog;
import d29.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\u001fJ\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020\u001fH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "shader", "Landroid/graphics/LinearGradient;", "bandWidth", "", "matrix", "Landroid/graphics/Matrix;", "CENTER_COLOR", "getCENTER_COLOR", "()I", "CENTER_COLOR$delegate", "Lkotlin/Lazy;", "interpolator", "Landroid/view/animation/Interpolator;", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animating", "", "onSizeChanged", "", "w", "h", "oldw", "oldh", "rebuildShader", "width", "startShimmer", "cancelShimmer", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShimmerMaskView extends View {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f328734i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f328735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearGradient f328736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f328737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f328738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f328739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CubicBezierInterpolator f328740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ValueAnimator f328741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f328742h;

    public static final class a {
    }

    static {
    }

    public ShimmerMaskView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShimmerMaskView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f328742h = false;
        this.f328741g.cancel();
        setVisibility(8);
    }

    private final int getCENTER_COLOR() {
        return ((Number) this.f328739e.getValue()).intValue();
    }

    public final void c() {
        if (this.f328742h == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        this.f328742h = true;
        if (getVisibility() == 0) goto L9;
        r100 = false;
    L9:
        if (r100 == true) goto L11;
        setVisibility(0);
    L11:
        this.f328741g.cancel();
        this.f328741g.start();
        invalidate();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public final void b(int r100) {
        if (r100 > 0) goto L5;
        this.f328736b = null;
        this.f328737c = 0.0f;
        return;
    L5:
        this.f328737c = r100 * 0.3f;
        this.f328736b = new LinearGradient(0.0f, 0.0f, this.f328737c, 0.0f, new int[]{16777215, getCENTER_COLOR(), 16777215}, null, Shader.TileMode.CLAMP);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = getWidth();
        int r101 = getHeight();
        if (r100 <= 0) goto L16;
        if (r101 > 0) goto L7;
        return;
    L7:
        if (this.f328742h == true) goto L9;
        return;
    L9:
        LinearGradient r102 = this.f328736b;
        if (r102 != null) goto L14;
        b(r100);
        r102 = this.f328736b;
        if (r102 != null) goto L14;
        return;
    L14:
        float r103 = this.f328740f.getInterpolation(RangesKt.coerceAtMost((this.f328741g.getAnimatedFraction() * 1300) / 900, 1.0f));
        float r104 = -this.f328737c;
        float r105 = r100;
        this.f328738d.reset();
        this.f328738d.postTranslate(r104 + ((r105 - r104) * r103), 0.0f);
        r102.setLocalMatrix(this.f328738d);
        this.f328735a.setShader(r102);
        this.f328735a.setColor(-1);
        r110.drawRect(0.0f, 0.0f, r105, r101, this.f328735a);
        return;
    }

    public ShimmerMaskView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328735a = new Paint(1);
        this.f328738d = new Matrix();
        this.f328739e = LazyKt.lazy(new d29.a(r100));
        this.f328740f = new CubicBezierInterpolator(0.25f, 1.0f, 0.25f);
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(1300);
        r103.setRepeatCount(-1);
        r103.setRepeatMode(1);
        r103.addUpdateListener(new b(this));
        this.f328741g = r103;
        setVisibility(8);
    }

    public /* synthetic */ ShimmerMaskView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        b(r100);
    }
}
