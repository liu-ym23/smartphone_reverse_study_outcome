package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u001fJ\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020\u001fH\u0014J\u0006\u0010)\u001a\u00020\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ShimmerView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radius", "", SVGRenderEngine.LINEAR_GRADIENT, "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "shaderMatrix", "Landroid/graphics/Matrix;", "startColor", "middleColorAlpha", "endColor", "rectF", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "setUpSwipColor", "", "middleColor", "runnable", "Ljava/lang/Runnable;", "setRadius", "startShimmerAnimation", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "cancelAnimation", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShimmerView extends View {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f304909l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f304910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearGradient f304911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f304912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f304913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f304914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f304915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f304916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f304917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f304918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f304919j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j1 f304920k;

    public static final class a {
    }

    static {
    }

    public ShimmerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShimmerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Paint getPaint() {
        return (Paint) this.f304919j.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f304912c;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f304912c = null;
        com.larus.utils.t0.f375468a.removeCallbacks(this.f304920k);
    }

    public static void a(final ShimmerView r110) {
        if (r110.getWidth() == 0) goto L7;
        FLogger.f375446a.d("ShimmerView", "onDraw animation ing========start===animation===width:" + r110.getWidth());
        r110.f304911b = new LinearGradient(0.0f, 0.0f, (float) r110.getWidth(), 0.0f, new int[]{r110.f304915f, r110.f304916g, r110.f304917h}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        r110.getPaint().setShader(r110.f304911b);
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{-r110.getWidth(), r110.getWidth()});
        r100.setDuration(800);
        r100.setRepeatCount(-1);
        r100.setInterpolator(new LinearInterpolator());
        r100.addUpdateListener(new k1(r110));
        r100.start();
        r110.f304912c = r100;
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (getPaint().getShader() != null) goto L5;
        return;
    L5:
        RectF r101 = this.f304918i;
        r101.left = 0.0f;
        r101.top = 0.0f;
        r101.right = getWidth();
        r101.bottom = getHeight();
        RectF r102 = this.f304918i;
        float r103 = this.f304910a;
        r100.drawRoundRect(r102, r103, r103, getPaint());
    }

    public final void setRadius(float r100) {
        this.f304910a = r100;
    }

    public static void b(ShimmerView r100, ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        Object r102 = r101.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        r100.f304913d = ((Float) r102).floatValue();
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("onDraw animation ing==========");
        r104.append(r100.f304913d);
        r104.append("===");
        r104.append(-r100.getWidth());
        r104.append("===");
        r104.append(r100.getWidth());
        r103.d("ShimmerView", r104.toString());
        r100.f304914e.setTranslate(r100.f304913d, 0.0f);
        Shader r105 = r100.getPaint().getShader();
        if (r105 == null) goto L5;
        r105.setLocalMatrix(r100.f304914e);
    L5:
        r100.invalidate();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.bmhome.chat.layout.widget.j1] */
    public ShimmerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f304914e = new Matrix();
        this.f304915f = ftc.a.a(ContextCompat.getColor(r100, v19.c.b(R.attr.larus_base_1, r100, R.color.larus_base_1)), 68);
        this.f304916g = ftc.a.a(ContextCompat.getColor(r100, v19.c.b(R.attr.larus_base_1, r100, R.color.larus_base_1)), 255);
        this.f304917h = ftc.a.a(ContextCompat.getColor(r100, v19.c.b(R.attr.larus_base_1, r100, R.color.larus_base_1)), 71);
        this.f304918i = new RectF();
        this.f304919j = LazyKt.lazy(new i1());
        this.f304920k = new j1(this);
    }

    public /* synthetic */ ShimmerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
