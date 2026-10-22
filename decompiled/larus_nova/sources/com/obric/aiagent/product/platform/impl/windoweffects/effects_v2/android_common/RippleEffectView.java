package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import com.ss.android.lark.utils.statistics.PerfLog;
import fja.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 :2\u00020\u0001:\u0003:;<B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0014\u0010#\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0006\u0010$\u001a\u00020 J\u0006\u0010%\u001a\u00020\u0014J\b\u0010&\u001a\u00020 H\u0014J(\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0014J\u001a\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u00101\u001a\u00020 2\u0006\u00100\u001a\u00020\u0012H\u0002J\u0018\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\u0010\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020 H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001d\u0010\u001e¨\u0006="}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rippleShader", "Landroid/graphics/RuntimeShader;", "shaderPaint", "Landroid/graphics/Paint;", "animationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "playGeneration", "activeSpec", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView$RippleSpec;", "shouldRender", "", "originX", "", "originY", "travelDistance", "pulseWidth", "viewIntensity", "value", "progress", "setProgress", "(F)V", "playWakeUpEffect", "", "onEnd", "Ljava/lang/Runnable;", "playCaptureEffect", "stop", "isPlaying", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "playRipple", "spec", "updateGeometry", "compensateClippedOrigin", "rawOriginY", "resolutionY", "cancelRunningAnimation", "nextGeneration", "cleanupAnimation", "generation", "hideWhenIdle", "Companion", "RippleSpec", "DeviceProfile", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RippleEffectView extends View {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f385060m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f385061n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Token$Easing f385062o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List<b> f385063p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RuntimeShader f385064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f385065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f385066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f385067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f385068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f385069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f385070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f385071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f385072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f385073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f385074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f385075l;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f385076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f385077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f385078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f385079d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f385076a, r101.f385076a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f385077b, r101.f385077b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f385078c, r101.f385078c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f385079d, r101.f385079d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f385076a.hashCode() * 31) + this.f385077b.hashCode()) * 31) + this.f385078c.hashCode()) * 31) + this.f385079d.hashCode();
        }

        public final String toString() {
            return "DeviceProfile(manufacturer=" + this.f385076a + ", brand=" + this.f385077b + ", model=" + this.f385078c + ", device=" + this.f385079d + ')';
        }

        public b() {
            Intrinsics.checkNotNullParameter("shenqijiyuan", "manufacturer");
            Intrinsics.checkNotNullParameter("nubia", "brand");
            Intrinsics.checkNotNullParameter("p0210", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter("nerida", "device");
            this.f385076a = "shenqijiyuan";
            this.f385077b = "nubia";
            this.f385078c = "p0210";
            this.f385079d = "nerida";
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f385080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f385081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f385082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f385083d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f385084e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f385085f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f385086g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f385087h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f385088i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f385089j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f385090k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final float f385091l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final float f385092m;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Float.compare(this.f385080a, r101.f385080a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f385081b, r101.f385081b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f385082c, r101.f385082c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f385083d, r101.f385083d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f385084e, r101.f385084e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f385085f, r101.f385085f) == 0) goto L27;
            return false;
        L27:
            if (this.f385086g == r101.f385086g) goto L30;
            return false;
        L30:
            if (Float.compare(this.f385087h, r101.f385087h) == 0) goto L33;
            return false;
        L33:
            if (Float.compare(this.f385088i, r101.f385088i) == 0) goto L36;
            return false;
        L36:
            if (Float.compare(this.f385089j, r101.f385089j) == 0) goto L39;
            return false;
        L39:
            if (Float.compare(this.f385090k, r101.f385090k) == 0) goto L42;
            return false;
        L42:
            if (Float.compare(this.f385091l, r101.f385091l) == 0) goto L45;
            return false;
        L45:
            if (Float.compare(this.f385092m, r101.f385092m) == 0) goto L47;
            return false;
        L47:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((Float.floatToIntBits(this.f385080a) * 31) + Float.floatToIntBits(this.f385081b)) * 31) + Float.floatToIntBits(this.f385082c)) * 31) + Float.floatToIntBits(this.f385083d)) * 31) + Float.floatToIntBits(this.f385084e)) * 31) + Float.floatToIntBits(this.f385085f)) * 31;
            long r101 = this.f385086g;
            return ((((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + Float.floatToIntBits(this.f385087h)) * 31) + Float.floatToIntBits(this.f385088i)) * 31) + Float.floatToIntBits(this.f385089j)) * 31) + Float.floatToIntBits(this.f385090k)) * 31) + Float.floatToIntBits(this.f385091l)) * 31) + Float.floatToIntBits(this.f385092m);
        }

        public final String toString() {
            return "RippleSpec(originFractionX=" + this.f385080a + ", originFractionY=" + this.f385081b + ", amplitudeDp=" + this.f385082c + ", amplitudeRamp=" + this.f385083d + ", pulseWidthDp=" + this.f385084e + ", travelDistanceMultiplier=" + this.f385085f + ", durationMs=" + this.f385086g + ", screenDimIntensity=" + this.f385087h + ", waveGlowIntensity=" + this.f385088i + ", trailDecayLength=" + this.f385089j + ", edgeGlowRadiusDp=" + this.f385090k + ", edgeGlowColorIntensity=" + this.f385091l + ", edgeGlowIntensity=" + this.f385092m + ')';
        }

        public c(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r110) {
            this.f385080a = 0.5f;
            this.f385081b = r100;
            this.f385082c = r101;
            this.f385083d = r102;
            this.f385084e = 70.0f;
            this.f385085f = r103;
            this.f385086g = 1500;
            this.f385087h = r104;
            this.f385088i = r105;
            this.f385089j = r106;
            this.f385090k = 1.0f;
            this.f385091l = r107;
            this.f385092m = r110;
        }
    }

    public RippleEffectView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RippleEffectView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f385060m = new c(1.2f, 70.0f, 0.5f, 2.2f, 0.0f, 1.0f, 2.0f, 1.0f, 0.0f);
        f385061n = new c(0.5f, 10.0f, 0.2f, 1.0f, 0.16f, 0.3f, 1.5f, 0.5f, 1.0f);
        f385062o = Token$Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD;
        f385063p = CollectionsKt.listOf(new b());
    }

    public final void d() {
        d r100 = this.f385066c;
        this.f385066c = null;
        this.f385067d++;
        if (r100 == null) goto L5;
        r100.a(false);
    L5:
        setProgress(0.0f);
        if (this.f385069f == false) goto L8;
        int r101 = 4;
    L9:
        setVisibility(r101);
        return;
    L8:
        r101 = 8;
        goto L9
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    private final void setProgress(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (this.f385075l != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        this.f385075l = r101;
        invalidate();
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void e(c r100) {
        float r101 = getWidth();
        float r102 = getHeight();
        float r103 = haa.b.a(r100.f385084e) * 1.65f;
        this.f385073j = r103;
        this.f385070g = r100.f385080a * r101;
        float r104 = r100.f385081b * r102;
        float r105 = r103 * 0.95f;
        if (r104 <= r102) goto L6;
        r104 = RangesKt.coerceAtMost(r104 - r102, r105) + r102;
    L8:
        this.f385071h = r104;
        this.f385072i = ((float) Math.hypot(r101, r102)) * r100.f385085f;
        this.f385074k = RangesKt.coerceAtLeast(r100.f385088i * 1.65f, 0.9f);
        return;
    L6:
        if (r104 >= 0.0f) goto L8;
        r104 = -RangesKt.coerceAtMost(0.0f - r104, r105);
        goto L8
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L13;
        this.f385064a.setFloatUniform("uResolution", getWidth(), getHeight());
        this.f385064a.setFloatUniform("uOrigin", this.f385070g, this.f385071h);
        this.f385064a.setFloatUniform("uProgress", this.f385075l);
        this.f385064a.setFloatUniform("uTravelDistance", this.f385072i);
        this.f385064a.setFloatUniform("uPulseWidth", this.f385073j);
        this.f385064a.setFloatUniform("uWaveGlowIntensity", this.f385074k);
        this.f385064a.setFloatUniform("uTrailDecayLength", this.f385068e.f385089j);
        r100.drawPaint(this.f385065b);
        return;
    }

    public final void c(c r100, final Runnable r110) {
        if (this.f385069f == true) goto L6;
        r110.run();
        return;
    L6:
        final int r101 = this.f385067d + 1;
        this.f385067d = r101;
        d r102 = this.f385066c;
        if (r102 == null) goto L9;
        r102.a(true);
    L9:
        this.f385066c = null;
        this.f385068e = r100;
        e(r100);
        setProgress(0.0f);
        setVisibility(0);
        com.obric.common.oea.foundation.animation.builder.d.a r103 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r103.f396379a = 1.0f;
        int r104 = (int) r100.f385086g;
        Token$Easing r105 = f385062o;
        Intrinsics.checkNotNullParameter(r105, "easing");
        r103.b(0.0f, 1.0f, new hja.a(r104, 0, r105), null);
        Function3<? super String, Object, Object, Unit> r106 = new faa.a(r101, this);
        Intrinsics.checkNotNullParameter(r106, "callback");
        r103.f396382d = r106;
        Function2<? super Boolean, ? super Throwable, Unit> r107 = new faa.b(r110, r101, this);
        Intrinsics.checkNotNullParameter(r107, "callback");
        r103.f396383e = r107;
        this.f385066c = r103.a().a();
    }

    public RippleEffectView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        RuntimeShader r103 = new RuntimeShader("\n            uniform vec2 uResolution;\n            uniform vec2 uOrigin;\n            uniform float uProgress;\n            uniform float uTravelDistance;\n            uniform float uPulseWidth;\n            uniform float uWaveGlowIntensity;\n            uniform float uTrailDecayLength;\n\n            const vec3 RIPPLE_BLUE = vec3(0.051, 0.447, 1.0);\n            const vec3 RIPPLE_CYAN = vec3(0.608, 0.863, 1.0);\n            const float FREQUENCY = 4.0;\n            const float TRAIL_DISPLACEMENT = 0.32;\n            const float CREST_ALPHA = 0.44;\n            const float SHOULDER_ALPHA = 0.16;\n            const float HALO_ALPHA = 0.09;\n            const float RIPPLE_LINE_ALPHA = 0.18;\n            const float TRAIL_ALPHA = 0.12;\n            const float WASH_ALPHA = 0.04;\n            const float DISPLACEMENT_ALPHA = 0.08;\n\n            // 锚定谐波：扣掉 t=0 的初始值，避免开场跳变。\n            float harmonic(float t, float ratio, float phase, float weight) {\n                return (sin(t * ratio + phase) - sin(phase)) * weight;\n            }\n\n            vec4 main(vec2 fragCoord) {\n                vec2 position = fragCoord;\n                vec2 delta = position - uOrigin;\n                float dist = length(delta);\n\n                // 波形包络：前沿高斯环 + 已经过区域的指数拖尾。\n                float waveFront = uProgress * uTravelDistance;\n                float ringOffset = (dist - waveFront) / uPulseWidth;\n                float crest = exp(-ringOffset * ringOffset * 5.5);\n                float shoulder = exp(-ringOffset * ringOffset * 1.25);\n                float haloOffset = (dist - waveFront) / (uPulseWidth * 1.8);\n                float halo = exp(-haloOffset * haloOffset);\n                float frontActivation = smoothstep(0.0, uPulseWidth * 0.9, waveFront);\n                float passedFront = smoothstep(-uPulseWidth * 0.5, uPulseWidth * 1.5, waveFront - dist);\n                float trailDecayDistance = uPulseWidth * max(uTrailDecayLength, 0.001);\n                float trail = passedFront * exp(-max(waveFront - dist, 0.0) / trailDecayDistance);\n                float behindFront = max(waveFront - dist, 0.0) / max(uPulseWidth, 1.0);\n                float washDecayDistance = uPulseWidth * max(uTrailDecayLength * 1.7, 0.001);\n                float wash = passedFront * exp(-max(waveFront - dist, 0.0) / washDecayDistance);\n\n                // 按半径延迟波相位，让波纹从 origin 向外传播。\n                float waveTime = max(0.0, uProgress - dist / max(uTravelDistance, 1.0));\n                float w = waveTime * FREQUENCY;\n                float totalWave = sin(w)\n                                + harmonic(w, 0.82, -1.45, 0.52)\n                                + harmonic(w, 1.27,  0.72, 0.28);\n                float rippleLineWave = pow(0.5 + 0.5 * sin(behindFront * 13.0 + totalWave * 0.65), 3.0);\n                float rippleLines = trail * rippleLineWave * exp(-behindFront / max(uTrailDecayLength * 1.2, 0.001));\n\n                float displacementMask = max(shoulder, trail * TRAIL_DISPLACEMENT) * frontActivation;\n                float crestShape = clamp(crest * frontActivation, 0.0, 1.0);\n                float shoulderShape = clamp(shoulder * frontActivation, 0.0, 1.0);\n                float haloShape = clamp(halo * frontActivation, 0.0, 1.0);\n                float trailShape = clamp(trail * frontActivation, 0.0, 1.0);\n                float rippleLineShape = clamp(rippleLines * frontActivation, 0.0, 1.0);\n                float washShape = clamp(\n                    wash\n                        * frontActivation\n                        * smoothstep(0.02, 0.18, uProgress)\n                        * (1.0 - smoothstep(0.78, 1.0, uProgress)),\n                    0.0,\n                    1.0);\n\n                // 颜色层：使用豆包光晕主蓝色。清晰 crest + 细纹拖尾负责涟漪感，\n                // 低 alpha halo / wash 只补偿 View 没有 ±depth 形变时的视觉裁薄。\n                float waveBoost = smoothstep(-0.2, 1.0, totalWave);\n                vec3 waveColor = mix(RIPPLE_BLUE, RIPPLE_CYAN, 0.28 + 0.38 * waveBoost);\n                vec3 haloColor = mix(RIPPLE_BLUE, RIPPLE_CYAN, 0.18);\n                float waveAlpha = (\n                    crestShape * CREST_ALPHA\n                    + shoulderShape * SHOULDER_ALPHA\n                    + haloShape * HALO_ALPHA\n                    + rippleLineShape * RIPPLE_LINE_ALPHA\n                    + trailShape * TRAIL_ALPHA\n                    + washShape * WASH_ALPHA\n                    + displacementMask * DISPLACEMENT_ALPHA\n                ) * uWaveGlowIntensity;\n                float alpha = clamp(waveAlpha, 0.0, 0.54);\n\n                vec3 color = mix(\n                    haloColor,\n                    waveColor,\n                    clamp(crestShape + rippleLineShape * 0.75 + shoulderShape * 0.35, 0.0, 1.0));\n                return vec4(color * alpha, alpha);\n            }\n        ");
        this.f385064a = r103;
        boolean r104 = true;
        Paint r105 = new Paint(1);
        r105.setShader(r103);
        this.f385065b = r105;
        this.f385068e = f385060m;
        List<b> r106 = f385063p;
        if ((r106 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r107 = r106.iterator();
    L9:
        if (r107.hasNext() == false) goto L22;
        b r108 = (b) r107.next();
        r108.getClass();
        if (Intrinsics.areEqual(faa.c.a(Build.MANUFACTURER), r108.f385076a) == true) goto L13;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == false) goto L9;
        r104 = false;
        goto L22
    L13:
        if (Intrinsics.areEqual(faa.c.a(Build.BRAND), r108.f385077b) == false) goto L19;
        if (Intrinsics.areEqual(faa.c.a(Build.MODEL), r108.f385078c) == false) goto L19;
        if (Intrinsics.areEqual(faa.c.a(Build.DEVICE), r108.f385079d) == false) goto L19;
        r109 = true;
    L22:
        this.f385069f = r104;
        this.f385074k = 1.0f;
        if (r104 == false) goto L25;
        int r110 = 4;
    L26:
        setVisibility(r110);
        setLayerType(2, null);
        return;
    L25:
        r110 = 8;
        goto L26
    L5:
        if (r106.isEmpty() == false) goto L7;
        goto L7
    }

    public static Unit b(Runnable r100, int r101, RippleEffectView r102) {
        if (r100 == null) goto L4;
        r100.run();
    L4:
        int r103 = r102.f385067d;
        if (r101 != r103) goto L16;
        if (r101 != r103) goto L15;
        r102.f385066c = null;
        r102.setProgress(0.0f);
        if (r102.f385069f == false) goto L12;
        int r104 = 4;
    L13:
        r102.setVisibility(r104);
        goto L15
    L12:
        r104 = 8;
    L15:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    }

    public /* synthetic */ RippleEffectView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f385066c == null) goto L6;
        e(this.f385068e);
        return;
    }

    public static Unit a(int r100, RippleEffectView r101, String r102, Object r103, Object r104) {
        Intrinsics.checkNotNullParameter(r102, "<unused var>");
        Intrinsics.checkNotNullParameter(r103, "value");
        Intrinsics.checkNotNullParameter(r104, "<unused var>");
        if (r100 != r101.f385067d) goto L7;
        r101.setProgress(RangesKt.coerceIn(((Float) r103).floatValue(), 0.0f, 1.0f));
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }
}
