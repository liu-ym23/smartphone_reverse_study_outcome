package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000*\u00011\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00103\u001a\u000204H\u0002J(\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0014J\u0018\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0014J\u0018\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020\u0015H\u0016J\u0010\u0010B\u001a\u0002042\u0006\u0010A\u001a\u00020\u0015H\u0002J\u0006\u0010C\u001a\u000204J\u0006\u0010D\u001a\u000204J\u0006\u0010E\u001a\u000204J\u000e\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020\u0015J\u0006\u0010H\u001a\u000204J\u0006\u0010I\u001a\u000204J\u0006\u0010J\u001a\u00020\u0015J\b\u0010K\u001a\u000204H\u0014J\b\u0010L\u001a\u000204H\u0014J\u0010\u0010M\u001a\u0002042\u0006\u0010N\u001a\u00020OH\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u0015X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R$\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00078B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u0006P"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/MinuteHardwareSyncBarDashedLoadingView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewportSize", "", "getViewportSize", "()F", "strokeWidthFactor", "getStrokeWidthFactor", "dashWidthFactor", "getDashWidthFactor", "dashGapFactor", "getDashGapFactor", "isClockwise", "", "()Z", "normalDeltaAngle", "getNormalDeltaAngle", "()I", "fastDeltaAngle", "getFastDeltaAngle", "basePath", "Landroid/graphics/Path;", "drawPath", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "refreshRate", "_deltaAngle", "Ljava/lang/Integer;", "value", "deltaAngle", "getDeltaAngle", "setDeltaAngle", "(I)V", "rotateDelay", "", "currentAngle", "isRunning", "hostVisible", "updateAngle", "com/ss/android/lark/feed/cardcomponent/preview/MinuteHardwareSyncBarDashedLoadingView$updateAngle$1", "Lcom/ss/android/lark/feed/cardcomponent/preview/MinuteHardwareSyncBarDashedLoadingView$updateAngle$1;", "buildBasePath", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updatePathForSize", "width", "height", "setEnabled", "enabled", "updatePaintColor", "startRotateAnim", "pauseRotateAnim", "stopRotateAnim", "setFastRotate", "isFast", "onHostInvisible", "onHostVisible", "isRunningAnim", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinuteHardwareSyncBarDashedLoadingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f420905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f420906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f420907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f420908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f420909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f420910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f420911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f420912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f420913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f420914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f420915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f420916l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f420917m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f420918n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f420919o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f420920p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f420921q;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MinuteHardwareSyncBarDashedLoadingView f420922a;

        public final void a() {
            MinuteHardwareSyncBarDashedLoadingView r100 = this.f420922a;
            if (r100.f420919o == true) goto L5;
            return;
        L5:
            if (r100.f420920p == false) goto L20;
            float r101 = r100.f420918n;
            if (r100.f420909e == false) goto L10;
            int r102 = MinuteHardwareSyncBarDashedLoadingView.a(r100);
        L11:
            r100.f420918n = r101 + r102;
            MinuteHardwareSyncBarDashedLoadingView r103 = this.f420922a;
            float r104 = r103.f420918n;
            if (r104 < 360.0f) goto L15;
            r103.f420918n = r104 - 360.0f;
        L17:
            r103.invalidate();
            MinuteHardwareSyncBarDashedLoadingView r105 = this.f420922a;
            r105.postDelayed(this, r105.f420917m);
            return;
        L15:
            if (r104 > (-360.0f)) goto L17;
            r103.f420918n = r104 + 360.0f;
            goto L17
        L10:
            r102 = -MinuteHardwareSyncBarDashedLoadingView.a(r100);
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(MinuteHardwareSyncBarDashedLoadingView r100) {
            this.f420922a = r100;
        }
    }

    public MinuteHardwareSyncBarDashedLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MinuteHardwareSyncBarDashedLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b() {
        this.f420919o = false;
        removeCallbacks(this.f420921q);
        this.f420918n = 0.0f;
        setRotation(0.0f);
        setDeltaAngle(this.f420910f);
        if (getLayerType() == 0) goto L6;
        setLayerType(0, null);
        return;
    }

    private final int getDeltaAngle() {
        Integer r100 = this.f420916l;
        if (r100 == null) goto L6;
        return r100.intValue();
    L6:
        return this.f420910f;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isEnabled() == true) goto L6;
        c(false);
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public final float getDashGapFactor() {
        return this.f420908d;
    }

    public final float getDashWidthFactor() {
        return this.f420907c;
    }

    public final int getFastDeltaAngle() {
        return this.f420911g;
    }

    public final int getNormalDeltaAngle() {
        return this.f420910f;
    }

    public final float getStrokeWidthFactor() {
        return this.f420906b;
    }

    public final float getViewportSize() {
        return this.f420905a;
    }

    public static final /* synthetic */ int a(MinuteHardwareSyncBarDashedLoadingView r100) {
        return r100.getDeltaAngle();
    }

    private final void setDeltaAngle(int r100) {
        this.f420916l = Integer.valueOf(r100);
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = R.color.ud_B300;
    L5:
        this.f420915k.setColor(UDColorUtils.getColor(getContext(), r101));
        invalidate();
        return;
    L4:
        r101 = R.color.icon_disable;
        goto L5
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        r100.save();
        r100.rotate(this.f420918n, r101, r102);
        r100.drawPath(this.f420913i, this.f420915k);
        r100.restore();
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        c(r100);
    }

    public final void setFastRotate(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = this.f420911g;
    L5:
        setDeltaAngle(r101);
        return;
    L4:
        r101 = this.f420910f;
        goto L5
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        Resources r102 = getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        int r104 = RangesKt.coerceAtLeast((int) (this.f420905a * r103), 1);
        setMeasuredDimension(View.resolveSize(r104, r100), View.resolveSize(r104, r101));
    }

    public MinuteHardwareSyncBarDashedLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f420905a = 16.0f;
        this.f420906b = 2.0f;
        this.f420907c = 1.2f;
        this.f420908d = 1.5f;
        this.f420909e = true;
        this.f420910f = 4;
        this.f420911g = 4;
        this.f420912h = new Path();
        this.f420913i = new Path();
        this.f420914j = new Matrix();
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        this.f420915k = r103;
        this.f420917m = 1000 / ((long) 20);
        this.f420920p = true;
        this.f420921q = new a(this);
        c(isEnabled());
    }

    public /* synthetic */ MinuteHardwareSyncBarDashedLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L11;
        if (r101 <= 0) goto L12;
        this.f420912h.reset();
        float r104 = this.f420905a / 2.0f;
        this.f420912h.addCircle(r104, r104, r104 - (this.f420906b / 2), Path.Direction.CW);
        float r105 = Math.min(r100, r101);
        float r106 = this.f420905a;
        float r107 = r105 / r106;
        float r108 = r106 * r107;
        this.f420914j.reset();
        this.f420914j.postScale(r107, r107);
        this.f420914j.postTranslate((r100 - r108) / 2.0f, (r101 - r108) / 2.0f);
        this.f420912h.transform(this.f420914j, this.f420913i);
        float r109 = this.f420906b * r107;
        float r110 = this.f420907c * r107;
        float r111 = (this.f420908d * r107) + r110;
        float r112 = new PathMeasure(this.f420913i, true).getLength();
        int r113 = RangesKt.coerceAtLeast((int) (r112 / r111), 1);
        if (r113 <= 0) goto L8;
        float r114 = r112 / r113;
    L9:
        float r115 = (r110 / r111) * r114;
        this.f420915k.setStrokeWidth(r109);
        this.f420915k.setPathEffect(new DashPathEffect(new float[]{r115, r114 - r115}, 0.0f));
        return;
    L8:
        r114 = r111;
        goto L9
    L12:
        return;
    }
}
