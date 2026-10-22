package com.larus.bmhome.taskskill.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.ColorUtils;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 G2\u00020\u0001:\u0001GB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u00105\u001a\u0002042\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000204\u0018\u000103J\u0006\u00107\u001a\u000204J\u0006\u00108\u001a\u000204J(\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0014J\b\u0010>\u001a\u000204H\u0014J\b\u0010?\u001a\u000204H\u0014J\u0010\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020\u0007H\u0002J\b\u0010B\u001a\u000204H\u0002J\u0010\u0010C\u001a\u0002042\u0006\u0010D\u001a\u000201H\u0002J\u0010\u0010E\u001a\u0002012\u0006\u0010F\u001a\u000201H\u0002R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010%\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000204\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/bmhome/taskskill/view/ShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "shimmerIncludeIcon", "getShimmerIncludeIcon$impl_mainlandRelease", "()Z", "setShimmerIncludeIcon$impl_mainlandRelease", "(Z)V", "", "shimmerDurationMillis", "getShimmerDurationMillis$impl_mainlandRelease", "()J", "setShimmerDurationMillis$impl_mainlandRelease", "(J)V", "shimmerRepeatCount", "getShimmerRepeatCount$impl_mainlandRelease", "()I", "setShimmerRepeatCount$impl_mainlandRelease", "(I)V", "shimmerBaseColor", "getShimmerBaseColor$impl_mainlandRelease", "()Ljava/lang/Integer;", "setShimmerBaseColor$impl_mainlandRelease", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "shimmerDimAlpha", "getShimmerDimAlpha$impl_mainlandRelease", "setShimmerDimAlpha$impl_mainlandRelease", "shimmerBrightAlpha", "getShimmerBrightAlpha$impl_mainlandRelease", "setShimmerBrightAlpha$impl_mainlandRelease", "animator", "Landroid/animation/ValueAnimator;", "shaderMatrix", "Landroid/graphics/Matrix;", KFFeatureEffect.GRADIENT_JSON_FIELD, "Landroid/graphics/LinearGradient;", "isAnimating", "pendingStart", "shimmerProgress", "", "iconShimmerProgressListener", "Lkotlin/Function1;", "", "setIconShimmerProgressListener", "listener", "startShimmer", "stopShimmer", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "buildGradient", "viewWidth", "rebuildGradientIfNeeded", "dispatchIconShimmerProgress", "progress", "calculatePulseProgress", "fraction", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShimmerTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f314610n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f314611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f314612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f314613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f314614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f314615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f314616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f314617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f314618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearGradient f314619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f314620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f314621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f314622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function1<? super Float, Unit> f314623m;

    public static final class a {
    }

    static {
    }

    public ShimmerTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShimmerTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void A() {
        if (this.f314620j == false) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L8;
    L12:
        this.f314621k = true;
        return;
    L8:
        if (getWidth() <= 0) goto L12;
        this.f314621k = false;
        this.f314620j = true;
        x(getWidth());
        float r100 = getWidth() / 2.0f;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{-r100, getWidth() + r100});
        r101.setDuration(this.f314612b);
        r101.setRepeatCount(this.f314613c);
        r101.setInterpolator(new LinearInterpolator());
        r101.addUpdateListener(new w(this));
        r101.start();
        this.f314617g = r101;
    }

    public final void B() {
        ValueAnimator r100 = this.f314617g;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f314617g = null;
        this.f314620j = false;
        this.f314621k = false;
        this.f314622l = 1.0f;
        getPaint().setShader(null);
        this.f314619i = null;
        y(1.0f);
        invalidate();
    }

    public final void z() {
        if (this.f314620j == true) goto L5;
        return;
    L5:
        if (getWidth() <= 0) goto L9;
        x(getWidth());
        invalidate();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f314621k == false) goto L6;
        A();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        B();
        super.onDetachedFromWindow();
    }

    public final Integer getShimmerBaseColor$impl_mainlandRelease() {
        return this.f314614d;
    }

    public final int getShimmerBrightAlpha$impl_mainlandRelease() {
        return this.f314616f;
    }

    public final int getShimmerDimAlpha$impl_mainlandRelease() {
        return this.f314615e;
    }

    public final long getShimmerDurationMillis$impl_mainlandRelease() {
        return this.f314612b;
    }

    public final boolean getShimmerIncludeIcon$impl_mainlandRelease() {
        return this.f314611a;
    }

    public final int getShimmerRepeatCount$impl_mainlandRelease() {
        return this.f314613c;
    }

    public final void setIconShimmerProgressListener(Function1<? super Float, Unit> r100) {
        this.f314623m = r100;
        if (this.f314611a == true) goto L5;
    L7:
        float r101 = 1.0f;
    L8:
        y(r101);
        return;
    L5:
        if (this.f314620j == false) goto L7;
        r101 = this.f314622l;
        goto L8
    }

    public final void setShimmerBaseColor$impl_mainlandRelease(Integer r100) {
        this.f314614d = r100;
        z();
    }

    public final void setShimmerBrightAlpha$impl_mainlandRelease(int r100) {
        this.f314616f = RangesKt.coerceIn(r100, 0, 255);
        z();
    }

    public final void setShimmerDimAlpha$impl_mainlandRelease(int r100) {
        this.f314615e = RangesKt.coerceIn(r100, 0, 255);
        z();
    }

    public final void setShimmerDurationMillis$impl_mainlandRelease(long r100) {
        long r101 = RangesKt.coerceAtLeast(r100, 1);
        this.f314612b = r101;
        ValueAnimator r102 = this.f314617g;
        if (r102 == null) goto L6;
        r102.setDuration(r101);
        return;
    }

    public final void setShimmerIncludeIcon$impl_mainlandRelease(boolean r100) {
        this.f314611a = r100;
        if (r100 == false) goto L5;
        float r101 = this.f314622l;
    L6:
        y(r101);
        return;
    L5:
        r101 = 1.0f;
        goto L6
    }

    public final void setShimmerRepeatCount$impl_mainlandRelease(int r100) {
        int r101 = RangesKt.coerceAtLeast(r100, -1);
        this.f314613c = r101;
        ValueAnimator r102 = this.f314617g;
        if (r102 == null) goto L6;
        r102.setRepeatCount(r101);
        return;
    }

    public final void x(int r110) {
        Integer r100 = this.f314614d;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        int r102 = ColorUtils.setAlphaComponent(r101, this.f314615e);
        LinearGradient r111 = new LinearGradient(0.0f, 0.0f, RangesKt.coerceAtLeast(r110 / 2.0f, 1.0f), 0.0f, new int[]{r102, ColorUtils.setAlphaComponent(r101, this.f314616f), r102}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        getPaint().setShader(r111);
        this.f314619i = r111;
        return;
    L5:
        r101 = getCurrentTextColor();
        goto L6
    }

    public final void y(float r100) {
        Function1<? super Float, Unit> r101 = this.f314623m;
        if (r101 == null) goto L6;
        r101.invoke(Float.valueOf(RangesKt.coerceIn(r100, 0.0f, 1.0f)));
        return;
    }

    public ShimmerTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f314611a = true;
        this.f314612b = 1000;
        this.f314613c = -1;
        this.f314615e = 128;
        this.f314616f = 255;
        this.f314618h = new Matrix();
        this.f314622l = 1.0f;
    }

    public /* synthetic */ ShimmerTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f314620j == false) goto L9;
        if (r100 <= 0) goto L9;
        x(r100);
        float r104 = r100;
        float r105 = r104 / 2.0f;
        ValueAnimator r106 = this.f314617g;
        if (r106 == null) goto L14;
        r106.setFloatValues(new float[]{-r105, r104 + r105});
        return;
    L14:
        return;
    L9:
        if (this.f314621k == false) goto L16;
        if (r100 <= 0) goto L17;
        if (r101 <= 0) goto L18;
        A();
        return;
    L18:
        return;
    L17:
        return;
    }
}
