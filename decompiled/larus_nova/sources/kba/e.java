package kba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.os.SystemClock;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RuntimeShader f502302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f502303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f502304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f502305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f502306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f502307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f502308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f502309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f502310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f502311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f502312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f502313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f502314m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f502315n;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f502306e = false;
        this.f502307f = 0.0f;
        this.f502308g = 0.0f;
        this.f502309h = 0.0f;
        this.f502310i = 0.0f;
        this.f502311j = 0.0f;
        this.f502312k = 0;
        this.f502313l = 0;
        this.f502314m = 0;
        this.f502315n = 0;
        invalidate();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f502306e == false) goto L6;
        postInvalidateOnAnimation();
        return;
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        RuntimeShader r101 = new RuntimeShader("\n            uniform float2 uResolution;\n            uniform float  uDensity;\n            uniform float  uTime;\n            uniform float  uCenterY;\n            uniform float  uVolume;\n\n            layout(color) uniform half4 uBaseColor;\n            layout(color) uniform half4 uCoverColor;\n            layout(color) uniform half4 uParticleColor;\n            layout(color) uniform half4 uNoiseColor;\n\n            uniform float  uRadiusRatio;\n            uniform float  uScale;\n            uniform float  uBlurRadius;\n\n            const float TAU              = 6.28318;\n            const float VOLUME_GAIN      = 0.15;\n            const float PARTICLE_DENSITY = 32.0;\n\n            float erfApprox(float x) {\n                float ax = abs(x);\n                float t = 1.0 / (1.0 + 0.3275911 * ax);\n                float y = 1.0 - (((((1.061405429 * t - 1.453152027) * t)\n                    + 1.421413741) * t - 0.284496736) * t + 0.254829592)\n                    * t * exp(-ax * ax);\n                return x >= 0.0 ? y : -y;\n            }\n\n            float gaussianEdge(float dist, float sigma) {\n                return 0.5 - 0.5 * erfApprox(dist / (sigma * 1.4142135));\n            }\n\n            float sdCircle(float2 p, float radius) {\n                return length(p) - radius;\n            }\n\n            float interleavedNoise(float2 p) {\n                float2 pixel = floor(p);\n                return fract(52.9829189 * fract(\n                    0.06711056 * pixel.x + 0.00583715 * pixel.y));\n            }\n\n            float2 hash2(float2 p) {\n                p = float2(dot(p, float2(127.1, 311.7)),\n                           dot(p, float2(269.5, 183.3)));\n                return fract(sin(p) * 43758.5453);\n            }\n\n            int imod(int a, int b) {\n                return a - b * (a / b);\n            }\n\n            int3 imod3(int3 a, int b) {\n                return int3(imod(a.x, b), imod(a.y, b), imod(a.z, b));\n            }\n\n            float3 hash3d(float3 p) {\n                int3 value = int3(p);\n                value = value * 1671731 + 10139267;\n                value.x += value.y * value.z;\n                value.y += value.z * value.x;\n                value.z += value.x * value.y;\n                int3 value2 = value / 65536;\n                value = imod3(10 - imod3(value + value2, 10), 10);\n                value.x += value.y * value.z;\n                value.y += value.z * value.x;\n                value.z += value.x * value.y;\n                return float3(sin(float(value.x)), cos(float(value.y)), sin(float(value.z)));\n            }\n\n            const float SKEW   = 0.3333333;\n            const float UNSKEW = 0.1666667;\n\n            float simplex3d(float3 p) {\n                float3 s = floor(p + (p.x + p.y + p.z) * SKEW);\n                float3 u = s - (s.x + s.y + s.z) * UNSKEW;\n                float3 c0 = p - u;\n                float3 en = c0 - float3(c0.y, c0.z, c0.x);\n                en = step(float3(0.0), en);\n                float3 offset1 = en * (1.0 - float3(en.z, en.x, en.y));\n                float3 offset2 = 1.0 - float3(en.z, en.x, en.y) * (1.0 - en);\n                float3 c1 = c0 - offset1 + UNSKEW;\n                float3 c2 = c0 - offset2 + UNSKEW * 2.0;\n                float3 c3 = c0 - float3(1.0) + UNSKEW * 3.0;\n                float4 w;\n                w.x = dot(c0, c0);\n                w.y = dot(c1, c1);\n                w.z = dot(c2, c2);\n                w.w = dot(c3, c3);\n                w = max(0.6 - w, 0.0);\n                float4 noiseCorner;\n                noiseCorner.x = dot(hash3d(s), c0);\n                noiseCorner.y = dot(hash3d(s + offset1), c1);\n                noiseCorner.z = dot(hash3d(s + offset2), c2);\n                noiseCorner.w = dot(hash3d(s + float3(1.0)), c3);\n                noiseCorner *= w * w * w * w;\n                return dot(float4(32.0), noiseCorner);\n            }\n\n            const float JITTER_SPEED   = 2.0;\n            const float JITTER_AMOUNT  = 0.15;\n            const float TWINKLE_SPEED  = 2.0;\n            const float TWINKLE_AMOUNT = 1.0;\n\n            float particle(float2 grid, float sqrtRadius, float sizePx, float radius) {\n                float2 id = floor(grid);\n                float2 local = fract(grid) - 0.5;\n                float2 jitter = (hash2(id) - 0.5) * 0.6\n                    + sin(uTime * (hash2(id + 0.5) - 0.5) * JITTER_SPEED)\n                      * JITTER_AMOUNT;\n                float distancePx = length((local - jitter) * float2(\n                    sqrtRadius * sqrtRadius * TAU / PARTICLE_DENSITY,\n                    2.0 * sqrtRadius / PARTICLE_DENSITY)) * radius;\n                float alpha = step(distancePx, max(sizePx, 0.5) * 0.6);\n                float phase = hash2(id).x;\n                alpha *= mix(1.0,\n                    sin(uTime * TWINKLE_SPEED + phase * TAU) * 0.5 + 0.5,\n                    TWINKLE_AMOUNT);\n                return alpha;\n            }\n\n            const float DITHER_MIN_INTENSITY = 0.35;\n            const float DITHER_BLUR_RATIO    = 0.015;\n\n            float glowShape(float2 p) {\n                float glowScale = uScale + uVolume * VOLUME_GAIN;\n                float radius = uResolution.x * uRadiusRatio;\n                float scaledRadius = radius * glowScale;\n                float blurSigma = uBlurRadius * glowScale;\n                float glowDistance = sdCircle(p, scaledRadius);\n                float ditherIntensity = max(\n                    DITHER_MIN_INTENSITY,\n                    blurSigma * DITHER_BLUR_RATIO);\n                float ditherOffset = (interleavedNoise(p) - 0.5) * ditherIntensity;\n                return gaussianEdge(glowDistance + ditherOffset, blurSigma);\n            }\n\n            const float NOISE_SCALE    = 0.1;\n            const float NOISE_CONTRAST = 0.0;\n            const float NOISE_SPEED    = 0.5;\n            const float NOISE_BALANCE  = 0.5;\n\n            float noiseMask(float2 p) {\n                float2 noiseUv = p / uResolution.y;\n                float noiseValue = simplex3d(float3(\n                    noiseUv * exp(NOISE_SCALE),\n                    uTime * NOISE_SPEED));\n                return clamp(\n                    (noiseValue * (NOISE_CONTRAST + 1.0) + NOISE_BALANCE) * 0.5 + 0.5,\n                    0.0,\n                    1.0);\n            }\n\n            float4 colorLayer(half4 color) {\n                float alpha = float(color.a);\n                return float4(\n                    float(color.r) * alpha,\n                    float(color.g) * alpha,\n                    float(color.b) * alpha,\n                    alpha);\n            }\n\n            float4 bodyColor(float noiseMaskValue) {\n                return mix(colorLayer(uNoiseColor), colorLayer(uBaseColor), noiseMaskValue);\n            }\n\n            const float GOLDEN_ANGLE           = 0.618034;\n            const float EMIT_SPEED             = 0.012;\n            const float PARTICLE_INNER_SIZE_DP = 1.2;\n            const float PARTICLE_OUTER_SIZE_DP = 0.6;\n\n            float particleMask(float2 p) {\n                float radius = uResolution.x * uRadiusRatio;\n                float2 offset = p / radius;\n                float angle = atan(offset.y, offset.x) / TAU + 0.5;\n                float radial = length(offset);\n                float sqrtRadius = sqrt(radial);\n                float2 polarGrid = float2(angle, sqrtRadius) * PARTICLE_DENSITY;\n                float radialProgress = clamp(radial, 0.0, 1.0);\n                float currentSizePx = mix(\n                    PARTICLE_INNER_SIZE_DP,\n                    PARTICLE_OUTER_SIZE_DP,\n                    radialProgress) * uDensity;\n\n                float total = 0.0;\n                float layerAlpha = 1.0;\n                for (int index = 0; index < 4; index++) {\n                    float layer = float(index);\n                    float2 scroll = float2(\n                        layer * GOLDEN_ANGLE,\n                        -EMIT_SPEED * uTime * (1.0 + layer * 0.3));\n                    float2 randomOffset = hash2(float2(layer, layer * 7.919)) * 10.0;\n                    total += particle(\n                        polarGrid * (1.0 + layer * 0.05)\n                            + scroll * PARTICLE_DENSITY + randomOffset,\n                        sqrtRadius,\n                        currentSizePx,\n                        radius) * layerAlpha;\n                    layerAlpha *= 0.9;\n                }\n                return min(total, 1.0);\n            }\n\n            float4 particleColor(float noiseMaskValue) {\n                return mix(colorLayer(uNoiseColor), colorLayer(uParticleColor), noiseMaskValue);\n            }\n\n            const float2 COVER_SCALE = float2(1.0, 0.5);\n\n            float4 coverLayer(float2 p) {\n                float radius = uResolution.x * uRadiusRatio;\n                float horizontal = p.x / (radius * COVER_SCALE.x);\n                float horizontalFalloff = exp(-horizontal * horizontal * 1.5);\n                float domeHeight = radius * COVER_SCALE.y * horizontalFalloff;\n                float vertical = p.y / max(domeHeight, 1.0);\n                float highlight = horizontalFalloff * exp(-vertical * vertical);\n                float gain = 1.0 + uVolume * VOLUME_GAIN * 8.0;\n                return colorLayer(uCoverColor) * highlight * gain;\n            }\n\n            half4 main(float2 fragCoord) {\n                float2 origin = float2(uResolution.x * 0.5, uCenterY);\n                float2 position = fragCoord - origin;\n                float shape = glowShape(position);\n                float noiseMaskValue = noiseMask(position);\n                float particles = particleMask(position);\n                float4 color = mix(\n                    bodyColor(noiseMaskValue),\n                    particleColor(noiseMaskValue),\n                    particles)\n                    + coverLayer(position);\n                float alpha = clamp(color.a, 0.0, 1.0);\n                return half4(color.rgb * shape, alpha * shape);\n            }\n        ");
        this.f502302a = r101;
        Paint r102 = new Paint();
        r102.setShader(r101);
        this.f502303b = r102;
        Resources r103 = getResources();
        this.f502304c = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        int r104 = -16087809;
    L6:
        this.f502305d = r104;
        setImportantForAccessibility(2);
        setLayerType(2, null);
        return;
    L5:
        r104 = -16750849;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() > 0) goto L8;
        return;
    L8:
        if (this.f502306e == false) goto L26;
        long r100 = SystemClock.elapsedRealtimeNanos();
        if (this.f502312k != 0) goto L12;
        this.f502312k = r100;
        this.f502313l = r100;
    L12:
        long r101 = this.f502315n;
        if (r101 != 0) goto L15;
    L16:
        this.f502308g = this.f502307f;
        this.f502307f = 0.0f;
        this.f502315n = r100;
    L17:
        long r102 = this.f502314m;
        if (r102 != 0) goto L20;
        float r103 = 16.0f;
    L21:
        this.f502314m = r100;
        if (this.f502308g <= this.f502309h) goto L24;
        float r104 = 80.0f;
    L25:
        float r105 = 1.0f - ((float) Math.exp((-r103) / r104));
        float r106 = this.f502309h;
        this.f502309h = r106 + ((this.f502308g - r106) * r105);
        this.f502310i = this.f502309h * ((RangesKt.coerceIn((float) Math.sin(((double) (((r100 - this.f502313l) % 400000000) / 4.0E8f)) * 3.141592653589793d), 0.0f, 1.0f) * 0.9f) + 0.1f);
        this.f502311j = (r100 - this.f502312k) / 1.0E9f;
        goto L26
    L24:
        r104 = 160.0f;
        goto L25
    L20:
        r103 = RangesKt.coerceAtLeast((r100 - r102) / 1000000.0f, 1.0f);
        goto L21
    L15:
        if ((r100 - r101) < 80000000) goto L17;
    L26:
        this.f502302a.setFloatUniform("uResolution", getWidth(), getHeight());
        this.f502302a.setFloatUniform("uDensity", this.f502304c);
        this.f502302a.setFloatUniform("uTime", this.f502311j);
        this.f502302a.setFloatUniform("uCenterY", (getHeight() - (160.0f * this.f502304c)) + (getWidth() * 0.8f));
        this.f502302a.setFloatUniform("uVolume", this.f502310i);
        this.f502302a.setFloatUniform("uRadiusRatio", 0.8f);
        this.f502302a.setFloatUniform("uScale", 1.0f);
        this.f502302a.setFloatUniform("uBlurRadius", 30.0f * this.f502304c);
        this.f502302a.setColorUniform("uBaseColor", this.f502305d);
        this.f502302a.setColorUniform("uCoverColor", -6562561);
        this.f502302a.setColorUniform("uParticleColor", -1);
        this.f502302a.setColorUniform("uNoiseColor", -10076701);
        r110.drawPaint(this.f502303b);
        if (this.f502306e == false) goto L31;
        postInvalidateOnAnimation();
        return;
    }

    public final void setAmplitude(float r100) {
        this.f502307f = Math.max(this.f502307f, RangesKt.coerceIn(r100, 0.0f, 1.0f));
        if (this.f502306e == false) goto L6;
        postInvalidateOnAnimation();
        return;
    }
}
