package com.larus.common_ui.widget.input;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0002YZB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0014J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0014J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0010H\u0002J\u0016\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bJ\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u000bJ\u0018\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bH\u0002J\u0016\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u0016\u0010>\u001a\u00020$2\u0006\u0010:\u001a\u00020;2\u0006\u0010?\u001a\u00020\u0010J\u0010\u0010@\u001a\u00020$2\b\b\u0001\u0010A\u001a\u00020\u000bJ\u0010\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020\u0010H\u0002J\b\u0010G\u001a\u00020\u0010H\u0002J\u000e\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020\u000bJ\u0016\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020=H\u0096@¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020$H\u0016J\b\u0010N\u001a\u00020$H\u0016J\b\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020SH\u0016J\u0012\u0010T\u001a\u00020$2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0006\u0010W\u001a\u00020\"J\u0006\u0010X\u001a\u00020\u0010R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/larus/common_ui/widget/input/AudioVisualizerOpt;", "Landroid/view/View;", "Lcom/larus/common_ui/widget/input/audiowave/IAudioWaveView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customWaveGroupCount", "density", "barWidth", "", "gapWidth", "sideMargin", "minBarHeight", "maxBarHeight", "visualizerWidth", "waveGroupNumber", "amplitude", "Ljava/util/LinkedList;", "lastTime", "", "barParams", "", "Lcom/larus/common_ui/widget/input/AudioVisualizerOpt$BarParam;", "barCount", "startAlphaSize", "endAlphaSize", "paint", "Landroid/graphics/Paint;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "ensureCapacity", "capacity", "onDraw", "canvas", "Landroid/graphics/Canvas;", "genBarData", "currAmp", "setGradient", "startSize", "endSize", "setSlideMargin", GXTemplateKey.FLEXBOX_MARGIN, "drawBars", "stage", "paintAlpha", "index", "setAudioData", "scope", "Lkotlinx/coroutines/CoroutineScope;", "data", "", "setAudioVolume", ITTVideoEngineEventSource.KEY_VOLUME, "setPaintColor", "color", "optAmplitude", "before", "", "setAmplitude", "value", "getAmplitude", "setCustomWaveGroupCount", "count", "updateAudioData", "audioData", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWaveAnim", "stopWaveAnim", "isAnimating", "", "setWaveTintList", "tint", "Landroid/content/res/ColorStateList;", "setWaveTintMode", "mode", "Landroid/graphics/PorterDuff$Mode;", "getPaint", "getVisualizerWidth", "BarParam", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioVisualizerOpt extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f328662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f328663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f328664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f328665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f328666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f328667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f328668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedList<Float> f328669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f328670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<Integer, a> f328671l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f328672m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f328673n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f328674o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f328675p;

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f328676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f328677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f328678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f328679d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f328680e;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f328676a == r101.f328676a) goto L12;
            return false;
        L12:
            if (this.f328677b == r101.f328677b) goto L15;
            return false;
        L15:
            if (Float.compare(this.f328678c, r101.f328678c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f328679d, r101.f328679d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f328680e, r101.f328680e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f328676a * 31) + this.f328677b) * 31) + Float.floatToIntBits(this.f328678c)) * 31) + Float.floatToIntBits(this.f328679d)) * 31) + Float.floatToIntBits(this.f328680e);
        }

        public final String toString() {
            return "BarParam(barType=" + this.f328676a + ", groupType=" + this.f328677b + ", barHeight=" + this.f328678c + ", curBarHeight=" + this.f328679d + ", change=" + this.f328680e + ')';
        }

        public a(int r100) {
            this.f328676a = 2;
            this.f328677b = 2;
            this.f328678c = 0.0f;
            this.f328679d = 0.0f;
            this.f328680e = 0.0f;
        }
    }

    public static final class b {
    }

    static {
    }

    public void setWaveTintMode(PorterDuff.Mode r100) {
    }

    private final float getAmplitude() {
        Float r100 = CollectionsKt.m9877maxOrNull(this.f328669j);
        if (r100 == null) goto L5;
        float r101 = r100.floatValue();
    L6:
        this.f328669j.clear();
        return r101;
    L5:
        r101 = 0.0f;
        goto L6
    }

    public final Paint getPaint() {
        return this.f328675p;
    }

    public final float getVisualizerWidth() {
        return this.f328667h;
    }

    public AudioVisualizerOpt(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f328661b = 45;
        float r101 = i5.N();
        this.f328662c = r101;
        this.f328663d = i5.z();
        this.f328664e = i5.l0();
        this.f328665f = i5.N();
        this.f328666g = i5.d0();
        this.f328669j = new LinkedList();
        this.f328671l = new LinkedHashMap();
        Paint r102 = new Paint();
        r102.setAntiAlias(true);
        r102.setFilterBitmap(true);
        r102.setStrokeCap(Paint.Cap.ROUND);
        r102.setStrokeWidth(r101);
        r102.setColor(-1);
        this.f328675p = r102;
    }

    private final void setAmplitude(float r100) {
        this.f328669j.offer(Float.valueOf(r100));
        if (this.f328669j.size() <= 10) goto L6;
        this.f328669j.poll();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        long r100 = SystemClock.elapsedRealtime();
        long r101 = r100 - this.f328670k;
        int r110 = 2;
        if (r101 < 400) goto L66;
        this.f328670k = r100;
        float r102 = getAmplitude();
        if (r101 < 800) goto L7;
        r102 = 0.0f;
        r101 = 0;
    L8:
        int r103 = this.f328668i / 2;
        int r104 = r103 + 3;
        int r105 = Random.Default.nextInt(r103, r104);
        int r106 = this.f328668i;
        if (1 > r106) goto L66;
        int r107 = 1;
    L11:
        if (r107 != r105) goto L13;
        float r111 = 1.0f;
    L22:
        if (r107 != r105) goto L24;
        int r112 = 0;
    L31:
        int r113 = Random.Default.nextInt(r110, 5);
        float r114 = RangesKt.coerceAtLeast((this.f328666g * r102) * r111, this.f328665f);
        float r211 = r114 * 0.7f;
        float r212 = r102;
        float r108 = RangesKt.coerceAtLeast(r211 * r111, this.f328665f);
        float r115 = RangesKt.coerceAtLeast(r111 * (r211 * 0.7f), this.f328665f);
        int r116 = 1;
    L33:
        if (r116 >= 6) goto L63;
        int r117 = ((r107 - 1) * 5) + r116;
        int r213 = r103;
        long r214 = r101;
        a r109 = (a) ((LinkedHashMap) this.f328671l).get(Integer.valueOf(r117));
        if (r109 == null) goto L37;
        r109.f328677b = r112;
    L37:
        if (r116 != r113) goto L44;
        a r118 = (a) ((LinkedHashMap) this.f328671l).get(Integer.valueOf(r117));
        if (r118 == null) goto L41;
        r118.f328676a = 0;
    L41:
        a r119 = (a) ((LinkedHashMap) this.f328671l).get(Integer.valueOf(r117));
        if (r119 == null) goto L62;
        r119.f328678c = r114;
    L62:
        r116 = r116 + 1;
        r103 = r213;
        r101 = r214;
        goto L33
    L44:
        int r120 = r113 - 1;
        if (r116 > (r113 + 1)) goto L48;
        if (r120 > r116) goto L48;
        boolean r121 = true;
    L49:
        if (r121 == false) goto L56;
        a r122 = (a) ((LinkedHashMap) this.f328671l).get(Integer.valueOf(r117));
        if (r122 == null) goto L53;
        r122.f328676a = 1;
    L53:
        a r123 = (a) ((LinkedHashMap) this.f328671l).get(Integer.valueOf(r117));
        if (r123 == null) goto L62;
        r123.f328678c = r108;
        goto L62
    L56:
        a r124 = (a) ((LinkedHashMap) this.f328671l).get(Integer.valueOf(r117));
        if (r124 == null) goto L59;
        r124.f328676a = 2;
    L59:
        a r125 = (a) ((LinkedHashMap) this.f328671l).get(Integer.valueOf(r117));
        if (r125 == null) goto L62;
        r125.f328678c = r115;
    L48:
        r121 = false;
        goto L49
    L63:
        int r215 = r103;
        long r216 = r101;
        if (r107 == r106) goto L67;
        r107 = r107 + 1;
        r103 = r215;
        r102 = r212;
        r101 = r216;
        r110 = 2;
    L67:
        float r126 = 2;
        float r127 = (getWidth() - this.f328667h) / r126;
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L70;
        r127 = r127 + (this.f328662c / r126);
    L70:
        int r128 = this.f328672m;
        if (1 > r128) goto L228;
        int r129 = 1;
    L73:
        a r130 = (a) ((LinkedHashMap) this.f328671l).get(Integer.valueOf(r129));
        if (r130 == null) goto L226;
        int r131 = r130.f328677b;
        if (r131 == 0) goto L79;
    L81:
        boolean r132 = false;
    L82:
        if (r131 != 0) goto L86;
        int r133 = 1;
        if (r130.f328676a != 1) goto L87;
    L90:
        boolean r134 = true;
    L92:
        if (r131 == 0) goto L94;
    L97:
        int r135 = 1;
        if (r131 == 1) goto L100;
    L102:
        boolean r136 = false;
    L103:
        if (r131 != r135) goto L107;
        int r137 = 2;
        if (r130.f328676a != 2) goto L108;
    L109:
        boolean r138 = true;
    L112:
        if (0 <= r216) goto L114;
    L116:
        boolean r139 = false;
    L118:
        if (r139 == false) goto L127;
        if (r132 == false) goto L201;
        float r140 = r130.f328679d;
        if (r140 > 0.0f) goto L124;
        r140 = this.f328665f;
    L124:
        r130.f328680e = (r130.f328678c - r140) / 20;
    L201:
        float r141 = RangesKt.coerceAtLeast(r130.f328679d + r130.f328680e, this.f328665f);
        r130.f328679d = r141;
        float r142 = (getHeight() - r141) / r126;
        if (ObricFeatureServiceDelegate.f387839b.a() == true) goto L204;
    L205:
        r127 = r127 + (this.f328662c + this.f328663d);
    L206:
        Paint r143 = this.f328675p;
        int r144 = this.f328673n;
        int r145 = this.f328674o;
        int r146 = this.f328672m;
        if (r144 != 0) goto L209;
    L215:
        float r147 = 1.0f;
    L216:
        if (r145 == 0) goto L225;
        if (((r146 - r145) + 1) > r129) goto L221;
        if (r129 > r146) goto L221;
        boolean r148 = true;
    L222:
        if (r148 == false) goto L225;
        r147 = (r146 - r129) / r145;
    L221:
        r148 = false;
    L225:
        r143.setAlpha(RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (r147 * 255), 0), 255));
        r210.drawLine(r127, r142, r127, r142 + r141, this.f328675p);
        goto L226
    L209:
        if (1 > r129) goto L212;
        if (r129 > r144) goto L212;
        boolean r149 = true;
    L213:
        if (r149 == false) goto L215;
        r147 = r129 / r144;
    L212:
        r149 = false;
        goto L213
    L204:
        if (r129 <= 1) goto L206;
    L127:
        if (50 <= r216) goto L129;
    L131:
        boolean r150 = false;
    L132:
        if (r150 == false) goto L140;
        if (r134 == false) goto L201;
        float r151 = r130.f328679d;
        if (r151 > 0.0f) goto L138;
        r151 = this.f328665f;
    L138:
        r130.f328680e = (r130.f328678c - r151) / 20;
        goto L201
    L140:
        if (100 <= r216) goto L142;
    L144:
        boolean r152 = false;
    L145:
        if (r152 == false) goto L153;
        if (r136 == false) goto L201;
        float r153 = r130.f328679d;
        if (r153 > 0.0f) goto L151;
        r153 = this.f328665f;
    L151:
        r130.f328680e = (r130.f328678c - r153) / 20;
        goto L201
    L153:
        if (150 <= r216) goto L155;
    L157:
        boolean r154 = false;
    L158:
        if (r154 == false) goto L166;
        if (r138 == false) goto L201;
        float r155 = r130.f328679d;
        if (r155 > 0.0f) goto L164;
        r155 = this.f328665f;
    L164:
        r130.f328680e = (r130.f328678c - r155) / 20;
        goto L201
    L166:
        if (200 <= r216) goto L168;
    L170:
        boolean r156 = false;
    L171:
        if (r156 == false) goto L175;
        if (r132 == false) goto L201;
        r130.f328680e = (this.f328665f - r130.f328678c) / 20;
        goto L201
    L175:
        if (250 <= r216) goto L177;
    L179:
        boolean r157 = false;
    L180:
        if (r157 == false) goto L184;
        if (r134 == false) goto L201;
        r130.f328680e = (this.f328665f - r130.f328678c) / 20;
        goto L201
    L184:
        if (300 <= r216) goto L186;
    L188:
        boolean r158 = false;
    L189:
        if (r158 == false) goto L193;
        if (r136 == false) goto L201;
        r130.f328680e = (this.f328665f - r130.f328678c) / 20;
        goto L201
    L193:
        if (350 <= r216) goto L195;
    L197:
        boolean r159 = false;
    L198:
        if (r159 == false) goto L201;
        if (r138 == false) goto L201;
        r130.f328680e = (this.f328665f - r130.f328678c) / 20;
        goto L201
    L195:
        if (r216 >= 400) goto L197;
        r159 = true;
        goto L198
    L186:
        if (r216 >= 350) goto L188;
        r158 = true;
        goto L189
    L177:
        if (r216 >= 300) goto L179;
        r157 = true;
        goto L180
    L168:
        if (r216 >= 250) goto L170;
        r156 = true;
        goto L171
    L155:
        if (r216 >= 200) goto L157;
        r154 = true;
        goto L158
    L142:
        if (r216 >= 150) goto L144;
        r152 = true;
        goto L145
    L129:
        if (r216 >= 100) goto L131;
        r150 = true;
        goto L132
    L114:
        if (r216 >= 50) goto L116;
        r139 = true;
    L108:
        if (r131 == r137) goto L109;
        r138 = false;
        goto L112
    L107:
        r137 = 2;
        goto L108
    L100:
        if (r130.f328676a != 1) goto L102;
    L101:
        r136 = true;
        goto L103
    L94:
        if (r130.f328676a != 2) goto L97;
        r135 = 1;
    L87:
        if (r131 == r133) goto L89;
    L91:
        r134 = false;
        goto L92
    L89:
        if (r130.f328676a != 0) goto L91;
    L86:
        r133 = 1;
        goto L87
    L79:
        if (r130.f328676a != 0) goto L81;
        r132 = true;
    L226:
        if (r129 == r128) goto L228;
        r129 = r129 + 1;
    L228:
        postInvalidateDelayed(10);
        return;
    L24:
        if (r103 > r107) goto L27;
        if (r107 > r104) goto L27;
        boolean r160 = true;
    L28:
        if (r160 == false) goto L30;
        r112 = 1;
        goto L31
    L30:
        r112 = 2;
    L27:
        r160 = false;
        goto L28
    L13:
        int r161 = r105 - 1;
        if (r107 > (r105 + 1)) goto L17;
        if (r161 > r107) goto L17;
        boolean r162 = true;
    L18:
        if (r162 == false) goto L20;
        float r163 = Random.Default.nextFloat() * 0.2f;
        float r164 = 0.6f;
    L21:
        r111 = r163 + r164;
        goto L22
    L20:
        r163 = Random.Default.nextFloat() * 0.1f;
        r164 = 0.4f;
    L17:
        r162 = false;
        goto L18
    L7:
        r101 = r101 - ((long) 400);
    L66:
        r216 = r101;
        goto L67
    }

    public final void setCustomWaveGroupCount(int r100) {
        this.f328660a = r100;
    }

    public final void setPaintColor(int r100) {
        this.f328675p.setColor(r100);
    }

    public final void setSlideMargin(int r100) {
        this.f328664e = r100;
    }

    public void setWaveTintList(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "tint");
        setPaintColor(r100.getDefaultColor());
    }

    public AudioVisualizerOpt(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f328661b = 45;
        float r102 = i5.N();
        this.f328662c = r102;
        this.f328663d = i5.z();
        this.f328664e = i5.l0();
        this.f328665f = i5.N();
        this.f328666g = i5.d0();
        this.f328669j = new LinkedList();
        this.f328671l = new LinkedHashMap();
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setFilterBitmap(true);
        r103.setStrokeCap(Paint.Cap.ROUND);
        r103.setStrokeWidth(r102);
        r103.setColor(-1);
        this.f328675p = r103;
    }

    public static final float a(AudioVisualizerOpt r100, double r101) {
        r100.getClass();
        if (r101 <= 0.5d) goto L5;
        double r102 = 1.0d;
    L7:
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L9;
        float r103 = 10.0f;
    L11:
        return RangesKt.coerceAtMost(((float) r102) * r103, 1.0f);
    L9:
        r103 = 2.5f;
        goto L11
    L5:
        r102 = Math.sin(r101 * 3.141592653589793d);
        goto L7
    }

    public static final /* synthetic */ void b(AudioVisualizerOpt r100, float r101) {
        r100.setAmplitude(r101);
    }

    public final void c(CoroutineScope r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "data");
        BuildersKt.launch$default(r100, Dispatchers.getMain(), null, new AudioVisualizerOpt$setAudioData$1(r101, this, null), 2, null);
    }

    public final void d(LifecycleCoroutineScope r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        BuildersKt.launch$default(r100, Dispatchers.getMain(), null, new AudioVisualizerOpt$setAudioVolume$1(this, r101, null), 2, null);
    }

    public AudioVisualizerOpt(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328661b = 45;
        float r103 = i5.N();
        this.f328662c = r103;
        this.f328663d = i5.z();
        this.f328664e = i5.l0();
        this.f328665f = i5.N();
        this.f328666g = i5.d0();
        this.f328669j = new LinkedList();
        this.f328671l = new LinkedHashMap();
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setFilterBitmap(true);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStrokeWidth(r103);
        r104.setColor(-1);
        this.f328675p = r104;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = getWidth() - (this.f328664e * 2);
        float r105 = (this.f328662c + this.f328663d) * 5;
        int r106 = (int) (r104 / r105);
        this.f328668i = r106;
        int r107 = 1;
        if ((r106 % 2) != 0) goto L5;
        this.f328668i = r106 - 1;
    L5:
        int r108 = this.f328660a;
        if (r108 <= 0) goto L8;
        this.f328668i = r108;
    L8:
        int r109 = RangesKt.coerceAtLeast(this.f328668i, 3);
        this.f328668i = r109;
        this.f328667h = r109 * r105;
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L11;
        this.f328667h -= this.f328663d;
    L11:
        int r110 = this.f328668i * 5;
        this.f328672m = r110;
        if (((LinkedHashMap) this.f328671l).get(Integer.valueOf(r110)) != null) goto L21;
        ((LinkedHashMap) this.f328671l).clear();
        if (1 > r110) goto L19;
    L16:
        this.f328671l.put(Integer.valueOf(r107), new a(0));
        if (r107 == r110) goto L22;
        r107 = r107 + 1;
        goto L16
    L22:
        return;
    L19:
        return;
    }
}
