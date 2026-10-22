package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u001bJ\b\u0010\u001f\u001a\u00020\u001bH\u0002J(\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\b\u0010%\u001a\u00020\u001bH\u0014J\b\u0010&\u001a\u00020\u001bH\u0014J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ShimmerLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "shaderMatrix", "Landroid/graphics/Matrix;", "shimmerPaint", "Landroid/graphics/Paint;", SVGRenderEngine.LINEAR_GRADIENT, "Landroid/graphics/LinearGradient;", "shimmerColor", "shimmerAlpha", "", "shimmerDuration", "", "needStartAnimation", "", "isAnimating", "startShimmerAnimation", "", "setShimmerColor", "color", "cancelShimmerAnimation", "createShimmerGradient", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShimmerLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f304874j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f304875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f304876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f304877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearGradient f304878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f304879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f304880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f304881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f304882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f304883i;

    public ShimmerLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShimmerLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        ValueAnimator r100 = this.f304875a;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f304875a = null;
        this.f304883i = false;
        this.f304882h = false;
        invalidate();
    }

    public final void b() {
        if (this.f304883i == false) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L8;
    L12:
        this.f304882h = true;
        return;
    L8:
        if (getWidth() == 0) goto L12;
        this.f304883i = true;
        LinearGradient r110 = new LinearGradient(0.0f, 0.0f, getWidth() / 2.0f, 0.0f, new int[]{0, Color.argb((int) (255 * this.f304880f), Color.red(this.f304879e), Color.green(this.f304879e), Color.blue(this.f304879e)), 0}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f304878d = r110;
        this.f304877c.setShader(r110);
        float r100 = getWidth() / 2.0f;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{-r100, getWidth() + r100});
        r101.setDuration(this.f304881g);
        r101.setRepeatCount(-1);
        r101.setInterpolator(new LinearInterpolator());
        r101.addUpdateListener(new d1(this));
        r101.start();
        this.f304875a = r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f304882h == false) goto L6;
        b();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (this.f304883i == true) goto L5;
        return;
    L5:
        if (this.f304878d == null) goto L9;
        r100.drawRect(getPaddingStart(), getPaddingTop(), getWidth() - getPaddingEnd(), getHeight() - getPaddingBottom(), this.f304877c);
        return;
    }

    public final void setShimmerColor(int r100) {
        this.f304879e = r100;
    }

    public ShimmerLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f304876b = new Matrix();
        this.f304877c = new Paint();
        this.f304879e = ContextCompat.getColor(r100, R.color.base_2_overlay);
        this.f304880f = 1.0f;
        this.f304881g = 1000;
        setWillNotDraw(false);
    }

    public /* synthetic */ ShimmerLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f304883i == false) goto L12;
        ValueAnimator r104 = this.f304875a;
        if (r104 == null) goto L7;
        long r105 = r104.getCurrentPlayTime();
    L8:
        a();
        b();
        ValueAnimator r106 = this.f304875a;
        if (r106 == null) goto L17;
        r106.setCurrentPlayTime(r105);
        return;
    L17:
        return;
    L7:
        r105 = 0;
        goto L8
    L12:
        if (this.f304882h == false) goto L19;
        if (r100 <= 0) goto L20;
        if (r101 <= 0) goto L21;
        b();
        return;
    L21:
        return;
    L20:
        return;
    }
}
