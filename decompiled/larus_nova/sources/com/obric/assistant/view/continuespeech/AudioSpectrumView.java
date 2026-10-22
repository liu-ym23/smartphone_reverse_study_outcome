package com.obric.assistant.view.continuespeech;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 h2\u00020\u0001:\u0001hB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\rJ\u000e\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\rJ\u000e\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\rJ\u000e\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020\u0007J\b\u0010@\u001a\u000207H\u0014J\b\u0010A\u001a\u000207H\u0014J\u0018\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0010\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0014J\u0010\u0010H\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010I\u001a\u000207H\u0002JC\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\r2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\rH\u0002¢\u0006\u0002\u0010PJ(\u0010Q\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\rH\u0002JP\u0010T\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\rH\u0002J(\u0010Y\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\r2\u0006\u0010[\u001a\u00020\rH\u0002J \u0010\\\u001a\u00020\r2\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\r2\u0006\u0010_\u001a\u00020\rH\u0002J \u0010`\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\r2\u0006\u0010b\u001a\u00020\rH\u0002J\u0010\u0010c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J \u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\r2\u0006\u0010f\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR$\u0010$\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR$\u0010'\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR$\u0010*\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR$\u0010-\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR$\u00101\u001a\u0002002\u0006\u0010\u0018\u001a\u000200@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006i"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioSpectrumView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barPaint", "Landroid/graphics/Paint;", "spectrumTimeSeconds", "", "lastFrameUptimeMs", "", "barPhases", "", "", "[[F", "barCount", "barWidthDp", "barGapDp", "minBarHeightDp", "value", "speakIntensity", "getSpeakIntensity", "()F", "setSpeakIntensity", "(F)V", "pauseIntensity", "getPauseIntensity", "setPauseIntensity", "pauseProgress", "getPauseProgress", "setPauseProgress", "pauseSlope", "getPauseSlope", "setPauseSlope", "waveIntensity", "getWaveIntensity", "setWaveIntensity", "wavePlayProgress", "getWavePlayProgress", "setWavePlayProgress", "spectrumAlpha", "getSpectrumAlpha", "setSpectrumAlpha", "", "animateSpectrum", "getAnimateSpectrum", "()Z", "setAnimateSpectrum", "(Z)V", "resetUi", "", "setMinBarHeightDp", "heightDp", "setBarGapDp", "gapDp", "setBarWidthDp", "widthDp", "setBarCount", "count", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawFrame", "ensureBarPhases", "effectAHeightPx", "index1", "timeSeconds", "phases", "minH", "maxH", "(IIF[[FFF)F", "effectBFactor", "progress", "slope", "effectCHeightPx", "barW", "step", "totalW", "waveWidth", "spatialEnvelope", "centerVal", "edgeVal", "clamp", BaseSwitches.V, "lo", "hi", "calculateTotalWidth", "barWidth", "gapWidth", "calculateTotalWidthDp", "lerp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "t", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSpectrumView extends View {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float[] f394098q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float[] f394099r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f394100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f394101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f394102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[][] f394103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f394104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f394105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f394106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f394107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f394108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f394109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f394110k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f394111l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f394112m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f394113n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f394114o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f394115p;

    public static final class a {
    }

    public AudioSpectrumView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AudioSpectrumView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f394098q = new float[]{5.5f, 9.8f, 14.2f, 3.7f, 19.5f};
        f394099r = new float[]{1.0f, 0.8f, 0.6f, 0.7f, 0.4f};
    }

    public final void b() {
        float[][] r100 = this.f394103d;
        if (r100.length != 5) goto L16;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        boolean r103 = true;
        if (r102 >= r101) goto L14;
        if (r100[r102].length == this.f394104e) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L12;
        r102 = r102 + 1;
        goto L5
    L12:
        r103 = false;
    L14:
        if (r103 == false) goto L16;
        return;
    L16:
        float[][] r104 = new float[5][];
        int r105 = 0;
    L17:
        if (r105 >= 5) goto L19;
        r104[r105] = new float[this.f394104e];
        r105 = r105 + 1;
        goto L17
    L19:
        this.f394103d = r104;
        int r106 = 0;
    L20:
        if (r106 >= 5) goto L25;
        int r107 = this.f394104e;
        int r108 = 0;
    L22:
        if (r108 >= r107) goto L24;
        this.f394103d[r106][r108] = Random.Default.nextFloat() * 6.2831855f;
        r108 = r108 + 1;
        goto L22
    L24:
        r106 = r106 + 1;
        goto L20
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f394102c = 0;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        this.f394102c = 0;
        if (this.f394115p == false) goto L6;
        postInvalidate();
        return;
    }

    public final boolean getAnimateSpectrum() {
        return this.f394115p;
    }

    public final float getPauseIntensity() {
        return this.f394109j;
    }

    public final float getPauseProgress() {
        return this.f394110k;
    }

    public final float getPauseSlope() {
        return this.f394111l;
    }

    public final float getSpeakIntensity() {
        return this.f394108i;
    }

    public final float getSpectrumAlpha() {
        return this.f394114o;
    }

    public final float getWaveIntensity() {
        return this.f394112m;
    }

    public final float getWavePlayProgress() {
        return this.f394113n;
    }

    public final void a(Canvas r310) {
        float r100 = getWidth();
        float r101 = getHeight();
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (r101 <= 0.0f) goto L63;
        float r102 = (r100 - getPaddingLeft()) - getPaddingRight();
        float r103 = (r101 - getPaddingTop()) - getPaddingBottom();
        if (r102 > 0.0f) goto L10;
        return;
    L10:
        if (r103 > 0.0f) goto L13;
        return;
    L13:
        if (this.f394115p == false) goto L18;
        long r104 = SystemClock.uptimeMillis();
        long r105 = this.f394102c;
        if (r105 == 0) goto L17;
        this.f394101b += RangesKt.coerceAtLeast(r104 - r105, 0) / 1000.0f;
    L17:
        this.f394102c = r104;
    L18:
        b();
        Resources r106 = getResources();
        float r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density;
        float r108 = this.f394105f * r107;
        float r109 = this.f394106g * r107;
        float r110 = this.f394107h * r107;
        float r111 = 24.0f * r107;
        float r112 = r107 * 1.0f;
        float r113 = 60.0f * r107;
        float r114 = r107 * 6.0f;
        int r115 = this.f394104e;
        int r116 = 0;
        float r117 = (r115 * r108) + (RangesKt.coerceAtLeast(r115 - 1, 0) * r109);
        if (r117 > r102) goto L21;
    L23:
        float r118 = Math.min(1.0f, r103 / Math.max(1.0E-4f, r111));
        float r119 = r110 * r118;
        float r120 = r111 * r118;
        float r121 = r114 * r118;
        float r122 = r112 * r118;
        float r123 = r108 + r109;
        int r124 = this.f394104e;
        float r125 = (r124 * r108) + (RangesKt.coerceAtLeast(r124 - 1, 0) * r109);
        float r126 = ((r102 - r125) * 0.5f) + getPaddingLeft();
        float r127 = (r103 * 0.5f) + getPaddingTop();
        this.f394100a.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(this.f394114o * 255.0f), 0, 255));
        float r128 = 0.0f;
        float r129 = RangesKt.coerceIn(this.f394108i, 0.0f, 1.0f);
        float r210 = RangesKt.coerceIn(this.f394109j, 0.0f, 1.0f);
        float r211 = RangesKt.coerceIn(this.f394110k, 0.0f, 1.0f);
        float r212 = RangesKt.coerceIn(this.f394111l, 0.0f, 1.0f);
        float r213 = RangesKt.coerceIn(this.f394112m, 0.0f, 1.0f);
        float r214 = RangesKt.coerceIn(this.f394113n, 0.0f, 1.0f);
        int r130 = this.f394104e;
    L24:
        if (r116 >= r130) goto L65;
        int r215 = r116 + 1;
        if (r129 <= r128) goto L36;
        int r131 = this.f394104e;
        float r132 = this.f394101b;
        float[][] r133 = this.f394103d;
        int r134 = r215 - 1;
        int r135 = 0;
        float r136 = 0.0f;
        float r216 = 0.0f;
    L29:
        if (r135 >= 5) goto L31;
        float r137 = f394098q[r135];
        float r217 = f394099r[r135];
        r216 = r216 + (((float) Math.sin((r137 * r132) + r133[r135][r134])) * r217);
        r136 = r136 + r217;
        r135 = r135 + 1;
        r116 = r116;
        r133 = r133;
        goto L29
    L31:
        int r218 = r116;
        float r138 = (float) Math.pow(((Math.max(-r136, Math.min(r136, 1.7f * r216)) / r136) * 0.5f) + 0.5f, 1.6f);
        if (r131 > 1) goto L34;
        float r139 = 0.5f;
    L35:
        float r140 = (((((r120 - r119) * (r138 * (((-0.5f) * (Math.abs(r139 - 0.5f) * 2.0f)) + 1.0f))) + r119) - r119) * r129) + r119;
    L38:
        if (r210 <= 0.0f) goto L45;
        int r141 = this.f394104e;
        if (r141 > 1) goto L42;
        float r142 = 0.5f;
    L43:
        float r143 = Math.abs(r142 - 0.5f) * 2.0f;
        float r144 = Math.max(r212 * 0.5f, 0.001f);
        float r145 = Math.max(0.0f, Math.min(1.0f, (((((r144 + 1.0f) * r211) - r143) / r144) + 1.0f) * 0.5f));
        r140 = r140 + ((r121 - r140) * (((r145 * r145) * (3.0f - (r145 * 2.0f))) * r210));
        goto L45
    L42:
        r142 = (r215 - 1) / (r141 - 1);
    L45:
        if (r213 <= 0.0f) goto L56;
        int r146 = this.f394104e;
        float r147 = ((r215 - 1) * r123) + (r108 / 2.0f);
        float r148 = r125 / 2.0f;
        float r149 = r113 / 2.0f;
        float r150 = (r148 + r149) * r214;
        float r151 = Math.min(Math.abs(r147 - (r148 - r150)), Math.abs(r147 - (r148 + r150)));
        if (r151 < r149) goto L49;
        float r152 = r119;
    L54:
        r140 = r140 + ((Math.max(r140, r152) - r140) * r213);
        goto L56
    L49:
        float r153 = (((float) Math.cos((r151 / r149) * 3.1415927f)) + 1.0f) / 2.0f;
        if (r146 > 1) goto L52;
        float r154 = 0.5f;
    L53:
        r152 = ((r120 - r119) * (r153 * (((-1.0f) * (Math.abs(r154 - 0.5f) * 2.0f)) + 1.0f))) + r119;
        goto L54
    L52:
        r154 = (r215 - 1) / (r146 - 1);
    L56:
        float r155 = r126 + (r218 * r123);
        float r156 = Math.max(r119, Math.min(r120, r140)) * 0.5f;
        r310.drawRoundRect(r155, r127 - r156, r155 + r108, r127 + r156, r122, r122, this.f394100a);
        r130 = r130;
        r116 = r215;
        r122 = r122;
        r127 = r127;
        r126 = r126;
        r128 = 0.0f;
        goto L24
    L34:
        r139 = (r215 - 1) / (r131 - 1);
        goto L35
    L36:
        r218 = r116;
        r140 = r119;
        goto L38
    L65:
        return;
    L21:
        if (r117 <= 0.0f) goto L23;
        float r157 = r102 / r117;
        r108 = r108 * r157;
        r109 = r109 * r157;
        r112 = r112 * r157;
        r113 = r113 * r157;
        goto L23
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        a(r100);     // Catch: Throwable -> L8
        if (this.f394115p == false) goto L15;
        postInvalidate();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (this.f394115p == false) goto L12;
        postInvalidate();
    L12:
        throw th;
    }

    public final void setAnimateSpectrum(boolean r100) {
        if (this.f394115p != r100) goto L5;
        return;
    L5:
        FLogger.f375446a.i("AudioSpectrumView", "animateSpectrum changed: " + this.f394115p + " -> " + r100);
        this.f394115p = r100;
        this.f394102c = 0;
        postInvalidate();
    }

    public final void setBarCount(int r100) {
        int r101 = RangesKt.coerceAtLeast(r100, 1);
        if (this.f394104e != r101) goto L5;
        return;
    L5:
        this.f394104e = r101;
        this.f394103d = new float[0][];
        requestLayout();
        invalidate();
    }

    public final void setBarGapDp(float r100) {
        float r101 = RangesKt.coerceAtLeast(r100, 0.0f);
        if (this.f394106g != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f394106g = r101;
        requestLayout();
        invalidate();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setBarWidthDp(float r100) {
        float r101 = RangesKt.coerceAtLeast(r100, 0.0f);
        if (this.f394105f != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f394105f = r101;
        requestLayout();
        invalidate();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setMinBarHeightDp(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, 24.0f);
        if (this.f394107h != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f394107h = r101;
        invalidate();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setPauseIntensity(float r100) {
        this.f394109j = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
    }

    public final void setPauseProgress(float r100) {
        this.f394110k = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
    }

    public final void setPauseSlope(float r100) {
        this.f394111l = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
    }

    public final void setSpeakIntensity(float r100) {
        this.f394108i = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
    }

    public final void setSpectrumAlpha(float r100) {
        this.f394114o = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
    }

    public final void setWaveIntensity(float r100) {
        this.f394112m = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
    }

    public final void setWavePlayProgress(float r100) {
        this.f394113n = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        Resources r102 = getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        int r104 = this.f394104e;
        setMeasuredDimension(View.resolveSize((int) ((((((r104 * this.f394105f) + (RangesKt.coerceAtLeast(r104 - 1, 0) * this.f394106g)) * r103) + getPaddingLeft()) + getPaddingRight()) + 0.5f), r100), View.resolveSize((int) ((((r103 * 24.0f) + getPaddingTop()) + getPaddingBottom()) + 0.5f), r101));
    }

    public AudioSpectrumView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setColor(-1);
        this.f394100a = r103;
        this.f394103d = new float[0][];
        this.f394104e = 24;
        this.f394105f = 2.0f;
        this.f394106g = 3.0f;
        this.f394107h = 4.0f;
        this.f394111l = 0.15f;
        this.f394114o = 1.0f;
        this.f394115p = true;
        Paint r104 = new Paint();
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Unit r105 = Unit.INSTANCE;
        setLayerType(2, r104);
    }

    public /* synthetic */ AudioSpectrumView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
