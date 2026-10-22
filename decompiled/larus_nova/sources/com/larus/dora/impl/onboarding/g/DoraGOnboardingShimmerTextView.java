package com.larus.dora.impl.onboarding.g;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import c69.b;
import c69.d;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.i;
import com.larus.utils.j0;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007J\u0014\u0010\u001e\u001a\u00020\u001b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0006\u0010\u001f\u001a\u00020\u001bJ\b\u0010 \u001a\u00020\u001bH\u0014J\b\u0010!\u001a\u00020\u001bH\u0014J\u0006\u0010\"\u001a\u00020\u001bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/DoraGOnboardingShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", SVGRenderEngine.LINEAR_GRADIENT, "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "", "shaderMatrix", "Landroid/graphics/Matrix;", "textColor", "textColorAlpha", "needStartAnimation", "", "path", "Landroid/view/animation/PathInterpolator;", "animRepeatCount", "onAnimationFinished", "Lkotlin/Function0;", "", "setAnimRepeatCount", "count", "setOnAnimationFinished", "startShimmerAnimation", "onDetachedFromWindow", "onAttachedToWindow", "cancelAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingShimmerTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f336633j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearGradient f336634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f336635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f336636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f336637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f336638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f336639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PathInterpolator f336640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f336641h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f336642i;

    public static final class a {
    }

    static {
    }

    public DoraGOnboardingShimmerTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoraGOnboardingShimmerTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void x() {
        this.f336642i = new b();
        ValueAnimator r100 = this.f336635b;
        if (r100 == null) goto L7;
        if (r100 == null) goto L6;
        r100.cancel();
    L6:
        this.f336635b = null;
        getPaint().setShader(null);
        invalidate();
    L7:
        this.f336639f = false;
    }

    public final void y() {
        if (this.f336635b == null) goto L6;
        Function0<Unit> r100 = this.f336642i;
        x();
        this.f336642i = r100;
    L6:
        if (isAttachedToWindow() == true) goto L9;
        this.f336639f = true;
        return;
    L9:
        int r101 = j0.f375426a;
        float r102 = Math.min(j0.b(c.b(R.attr.larus_dp_420, null, R.dimen.larus_dp_420)), i.d(AppHost.f326268a.getApplication()) - (i5.Q() * 2));
        int r103 = this.f336637d;
        this.f336634a = new LinearGradient(0.0f, 0.0f, r102, 0.0f, new int[]{r103, r103, this.f336638e, r103, r103}, new float[]{0.0f, 0.3f, 0.5f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
        getPaint().setShader(this.f336634a);
        float r104 = r102 - (0.3f * r102);
        ValueAnimator r105 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(MapBundleKey.MapObjKey.OBJ_TEXT, new Keyframe[]{Keyframe.ofFloat(0.0f, -r104), Keyframe.ofFloat(1.0f, r104)})});
        r105.setDuration(2000);
        r105.setRepeatCount(this.f336641h);
        r105.setInterpolator(this.f336640g);
        r105.addUpdateListener(new c69.c(this));
        r105.addListener(new d(this));
        r105.start();
        this.f336635b = r105;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f336639f == false) goto L6;
        y();
        this.f336639f = false;
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x();
    }

    public final void setAnimRepeatCount(int r100) {
        this.f336641h = r100;
    }

    public final void setOnAnimationFinished(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onAnimationFinished");
        this.f336642i = r100;
    }

    public DoraGOnboardingShimmerTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f336636c = new Matrix();
        this.f336637d = ContextCompat.getColor(r100, R.color.larus_neutral_30);
        this.f336638e = ContextCompat.getColor(r100, R.color.larus_neutral_100);
        this.f336640g = new PathInterpolator(0.4f, 0.0f, 0.1f, 1.0f);
        this.f336641h = 1;
        this.f336642i = new c69.a();
    }

    public /* synthetic */ DoraGOnboardingShimmerTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
