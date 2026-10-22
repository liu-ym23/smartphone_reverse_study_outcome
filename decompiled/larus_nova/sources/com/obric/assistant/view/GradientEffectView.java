package com.obric.assistant.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0002:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u0012J\b\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020\u001cH\u0014J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0012H\u0016J\b\u0010+\u001a\u00020\u001cH\u0014J\u0006\u0010,\u001a\u00020\u001cJ\u0006\u0010-\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\rJ\u000e\u00101\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\rJ\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\rH\u0016J\u000e\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\rJ\u0006\u00106\u001a\u00020\u000bJ\u0006\u00107\u001a\u00020\rJ\u0006\u00108\u001a\u00020\rJ\u0006\u00109\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/assistant/view/GradientEffectView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shape", "Lcom/obric/assistant/view/GradientEffectView$Shape;", "cornerRadius", "", "blurRadius", "animationSpeed", "rotationAngle", "animationRunning", "", "lastFrameUptimeMs", "", "rectF", "Landroid/graphics/RectF;", "gradientMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "updateGradientShader", "toCancel", "updateGradientMatrix", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawFrame", "onAttachedToWindow", "onVisibilityAggregated", "isVisible", "onDetachedFromWindow", "startAnimation", "stopAnimation", "setShape", "setCornerRadius", "radius", "setBlurRadius", "setAlpha", "alpha", "setAnimationSpeed", "factor", "getShape", "getCornerRadius", "getBlurRadius", "getAnimationSpeed", "Shape", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GradientEffectView extends View {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f393911k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Shape f393912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f393913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f393914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f393915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f393916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f393917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f393918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f393919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f393920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f393921j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/view/GradientEffectView$Shape;", "", "<init>", "(Ljava/lang/String;I)V", "RECT", "OVAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Shape extends Enum<Shape> {
        public static final Shape OVAL = null;
        public static final Shape RECT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Shape[] f393922a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f393923b = null;

        public static EnumEntries<Shape> getEntries() {
            return f393923b;
        }

        static {
            Shape r100 = new Shape("RECT", 0);
            RECT = r100;
            Shape r101 = new Shape("OVAL", 1);
            OVAL = r101;
            Shape[] r102 = {r100, r101};
            f393922a = r102;
            f393923b = EnumEntriesKt.enumEntries(r102);
        }

        public static Shape[] values() {
            return (Shape[]) f393922a.clone();
        }

        public static Shape valueOf(String r100) {
            return (Shape) r27.a.a(Shape.class, r100);
        }

        public Shape(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f393924a = null;

        static {
            int[] r100 = new int[Shape.values().length];
            r100[Shape.RECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Shape.OVAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f393924a = r100;
        }
    }

    public GradientEffectView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GradientEffectView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f393917f = false;
        this.f393918g = 0;
        super.onDetachedFromWindow();
    }

    static {
        String[] r100 = {"#5F85FF", "#FF9090", "#FEC183"};
        ArrayList r101 = new ArrayList(3);
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= 3) goto L5;
        r101.add(Integer.valueOf(ColorProtector.parseColor(r100[r103])));
        r103 = r103 + 1;
        goto L3
    L5:
        f393911k = CollectionsKt.toIntArray(r101);
        String[] r104 = {"#FF9595", "#FF9595", "#FF9595"};
        ArrayList r105 = new ArrayList(3);
    L6:
        if (r102 >= 3) goto L8;
        r105.add(Integer.valueOf(ColorProtector.parseColor(r104[r102])));
        r102 = r102 + 1;
        goto L6
    L8:
        CollectionsKt.toIntArray(r105);
    }

    public final void c() {
        Shader r100 = this.f393921j.getShader();
        if (r100 == null) goto L6;
        this.f393920i.reset();
        this.f393920i.postRotate(this.f393916e, getWidth() / 2.0f, getHeight() / 2.0f);
        r100.setLocalMatrix(this.f393920i);
        return;
    }

    public final void b() {
        if (isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (isShown() == true) goto L7;
        return;
    L7:
        if (getWindowVisibility() == 0) goto L9;
        return;
    L9:
        if (getAlpha() > 0.0f) goto L11;
        return;
    L11:
        if (this.f393917f == true) goto L18;
        this.f393917f = true;
        this.f393918g = SystemClock.uptimeMillis();
        postInvalidate();
        return;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    public final float getAnimationSpeed() {
        return this.f393915d;
    }

    public final float getBlurRadius() {
        return this.f393914c;
    }

    public final float getCornerRadius() {
        return this.f393913b;
    }

    public final Shape getShape() {
        return this.f393912a;
    }

    public final void a(Canvas r110) {
        super.onDraw(r110);
        float r100 = this.f393914c;
        if (r100 <= 0.0f) goto L5;
        float r101 = r100 * 1.5f;
    L6:
        float r102 = 2 * r101;
        float r103 = getWidth() - r102;
        float r104 = getHeight() - r102;
        if (r103 > 0.0f) goto L9;
        return;
    L9:
        if (r104 > 0.0f) goto L12;
        return;
    L12:
        if (this.f393917f == false) goto L14;
        long r105 = SystemClock.uptimeMillis();
        this.f393916e = (this.f393916e + (((this.f393915d * 360.0f) * RangesKt.coerceAtLeast(r105 - this.f393918g, 0)) / 5000)) % 360.0f;
        this.f393918g = r105;
        c();
    L14:
        this.f393919h.set(r101, r101, r103 + r101, r104 + r101);
        int r106 = b.f393924a[this.f393912a.ordinal()];
        if (r106 == 1) goto L20;
        if (r106 != 2) goto L19;
        r110.drawOval(this.f393919h, this.f393921j);
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        RectF r107 = this.f393919h;
        float r108 = this.f393913b;
        r110.drawRoundRect(r107, r108, r108, this.f393921j);
        return;
    L5:
        r101 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        a(r100);     // Catch: Throwable -> L8
        if (this.f393917f == false) goto L15;
        postInvalidate();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (this.f393917f == false) goto L12;
        postInvalidate();
    L12:
        throw th;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        if (r100 == false) goto L5;
        b();
        return;
    L5:
        this.f393917f = false;
        this.f393918g = 0;
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        super.setAlpha(r100);
        if (r100 > 0.0f) goto L5;
        this.f393917f = false;
        this.f393918g = 0;
        return;
    L5:
        b();
    }

    public final void setAnimationSpeed(float r100) {
        this.f393915d = Math.max(0.1f, r100);
    }

    public final void setBlurRadius(float r100) {
        this.f393914c = r100;
        Paint r101 = this.f393921j;
        if (r100 <= 0.0f) goto L5;
        BlurMaskFilter r102 = new BlurMaskFilter(r100, BlurMaskFilter.Blur.NORMAL);
    L6:
        r101.setMaskFilter(r102);
        invalidate();
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setCornerRadius(float r100) {
        this.f393913b = r100;
        invalidate();
    }

    public final void setShape(Shape r100) {
        Intrinsics.checkNotNullParameter(r100, "shape");
        this.f393912a = r100;
        invalidate();
    }

    public GradientEffectView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f393912a = Shape.RECT;
        this.f393915d = 1.0f;
        this.f393919h = new RectF();
        this.f393920i = new Matrix();
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        this.f393921j = r103;
    }

    public /* synthetic */ GradientEffectView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L10;
        Paint r101 = this.f393921j;
        LinearGradient r113 = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, f393911k, new float[]{0.38f, 0.74f, 1.0f}, Shader.TileMode.CLAMP);
        c();
        r101.setShader(r113);
        return;
    }
}
