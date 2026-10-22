package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.byted.cast.common.CastMonitor;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J0\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0014J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0007H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ShimmerProgressBar;", "Landroid/widget/ProgressBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", KFFeatureEffect.GRADIENT_JSON_FIELD, "Landroid/graphics/LinearGradient;", "gradientMatrix", "Landroid/graphics/Matrix;", "translateXY", "", "progressColor", "progressColorAlpha", "shimmerColors", "", "shimmerPositions", "", "animator", "Landroid/animation/ValueAnimator;", "onAttachedToWindow", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startShimmer", "stopShimmer", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "setProgress", "progress", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShimmerProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f304892h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f304893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearGradient f304894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f304895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f304896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f304897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f304898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f304899g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShimmerProgressBar f304900a;

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator r100 = this.f304900a.f304899g;     // Catch: Throwable -> L9
            if (r100 == null) goto L5;
            r100.start();     // Catch: Throwable -> L9
        L5:
            ShimmerProgressBar r101 = this.f304900a;     // Catch: Throwable -> L9
            if (r101.f304899g == null) goto L12;
            r101.postDelayed(this, 1000);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(ShimmerProgressBar r100) {
            this.f304900a = r100;
        }
    }

    public ShimmerProgressBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShimmerProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        ValueAnimator r100 = this.f304899g;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, (getWidth() * (getProgress() / getMax())) * 2.0f});
        r102.setDuration(800);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new g1(this));
        this.f304899g = r102;
        post(new a(this));
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f304899g;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f304899g = null;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f304894b != null) goto L5;
        LinearGradient r100 = new LinearGradient((getProgress() / getMax()) * (-getWidth()), 0.0f, 0.0f, 0.0f, this.f304897e, this.f304898f, Shader.TileMode.CLAMP);
        this.f304894b = r100;
        this.f304893a.setShader(r100);
    L5:
        Matrix r101 = this.f304895c;
        float r102 = this.f304896d;
        r101.setTranslate(r102, r102);
        LinearGradient r103 = this.f304894b;
        if (r103 == null) goto L8;
        r103.setLocalMatrix(this.f304895c);
    L8:
        r110.drawRect(0.0f, 0.0f, getWidth() * (getProgress() / getMax()), getHeight(), this.f304893a);
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r100) {
        super.setProgress(r100);
        this.f304894b = null;
        ValueAnimator r101 = this.f304899g;
        if (r101 == null) goto L5;
        r101.setFloatValues(new float[]{0.0f, (getWidth() * (r100 / getMax())) * 2.0f});
    L5:
        invalidate();
    }

    public ShimmerProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        com.larus.utils.w0.e(this, i5.c());
        this.f304893a = new Paint(1);
        this.f304895c = new Matrix();
        int r103 = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_50, r100, R.color.larus_neutral_50));
        this.f304897e = new int[]{r103, ftc.a.a(r103, 128), r103};
        this.f304898f = new float[]{0.0f, 0.5f, 1.0f};
        setLayerType(2, null);
    }

    public /* synthetic */ ShimmerProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L9;
        ValueAnimator r105 = this.f304899g;
        if (r105 == null) goto L7;
        r105.cancel();
    L7:
        a();
        return;
    }
}
