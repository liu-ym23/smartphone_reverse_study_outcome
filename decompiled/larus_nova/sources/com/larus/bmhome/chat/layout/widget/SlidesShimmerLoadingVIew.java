package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001aJ\u001c\u0010!\u001a\u00020\u00112\b\b\u0001\u0010\"\u001a\u00020\u00112\b\b\u0001\u0010#\u001a\u00020\u0011H\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/SlidesShimmerLoadingVIew;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", KFFeatureEffect.GRADIENT_JSON_FIELD, "Landroid/graphics/LinearGradient;", "gradientMatrix", "Landroid/graphics/Matrix;", "translateXY", "", "textColor", "", "textColorAlpha", "shimmerColors", "", "shimmerPositions", "", "animator", "Landroid/animation/ValueAnimator;", "onAttachedToWindow", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startShimmer", "stopShimmer", "applyAlpha", "color", "alpha", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesShimmerLoadingVIew extends View {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f304921h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f304922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearGradient f304923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f304924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f304925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f304926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f304927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f304928g;

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.larus.utils.t0.c(new l1(this));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f304928g;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f304928g = null;
    }

    public SlidesShimmerLoadingVIew(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f304923b != null) goto L5;
        float r100 = 2;
        LinearGradient r101 = new LinearGradient(-getWidth(), getHeight() / r100, 0.0f, getHeight() / r100, this.f304926e, this.f304927f, Shader.TileMode.CLAMP);
        this.f304923b = r101;
        this.f304922a.setShader(r101);
    L5:
        Matrix r102 = this.f304924c;
        float r103 = this.f304925d;
        r102.setTranslate(r103, r103);
        LinearGradient r104 = this.f304923b;
        if (r104 == null) goto L8;
        r104.setLocalMatrix(this.f304924c);
    L8:
        r110.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), 20.0f, 20.0f, this.f304922a);
    }

    public SlidesShimmerLoadingVIew(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f304922a = new Paint(1);
        this.f304924c = new Matrix();
        int r102 = r100.getResources().getColor(v19.c.b(R.attr.larus_base_2_overlay, r100, R.color.larus_base_2_overlay));
        this.f304926e = new int[]{r102, (16777215 & r102) | 167772160, r102};
        this.f304927f = new float[]{0.0f, 0.5f, 1.0f};
        setLayerType(2, null);
    }
}
