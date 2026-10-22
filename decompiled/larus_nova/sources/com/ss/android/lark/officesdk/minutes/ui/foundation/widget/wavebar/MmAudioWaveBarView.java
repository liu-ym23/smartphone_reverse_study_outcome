package com.ss.android.lark.officesdk.minutes.ui.foundation.widget.wavebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b7\u0018\u0000 \u0080\u00012\u00020\u0001:\u0004\u0080\u0001\u0081\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010=\u001a\u00020>H\u0002J(\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0010\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0016H\u0016J\u0006\u0010G\u001a\u00020@J\u0006\u0010H\u001a\u00020@J\u0010\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020KH\u0014J\b\u0010L\u001a\u00020@H\u0014J\u0016\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010R\u001a\u00020@2\u0006\u0010S\u001a\u00020\u000bJ\u000e\u0010T\u001a\u00020@2\u0006\u0010U\u001a\u00020\u000bJ\u0016\u0010V\u001a\u00020@2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bJ\u0010\u0010Y\u001a\u00020@2\b\b\u0001\u0010Z\u001a\u00020\u0007J\u0006\u0010[\u001a\u00020@J\u0006\u0010\\\u001a\u00020@J\u000e\u0010]\u001a\u00020@2\u0006\u0010^\u001a\u00020\u0007J\b\u0010_\u001a\u00020@H\u0002J\b\u0010`\u001a\u00020@H\u0002J\u000e\u0010a\u001a\b\u0012\u0004\u0012\u00020\u000b0.H\u0002J\b\u0010b\u001a\u00020@H\u0002J\b\u0010c\u001a\u00020@H\u0002J\b\u0010d\u001a\u00020\u000bH\u0002J\u0010\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000bH\u0002J\u0016\u0010g\u001a\u00020@2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J\u001e\u0010i\u001a\u00020@2\u0006\u0010j\u001a\u00020\u000b2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J\u0016\u0010l\u001a\u00020@2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J\u0010\u0010n\u001a\u00020@2\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010o\u001a\u00020@H\u0002J\u0010\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u0007H\u0002J$\u0010r\u001a\u00020@2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u000b0.H\u0002J\u0016\u0010t\u001a\u00020@2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J$\u0010u\u001a\u00020@2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u000b0.2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J\b\u0010x\u001a\u00020@H\u0002J\u0010\u0010y\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u0007H\u0002J\u0010\u0010z\u001a\u00020@2\u0006\u0010{\u001a\u00020\u001dH\u0002J\b\u0010|\u001a\u00020@H\u0002J\u0016\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000b0.2\u0006\u0010{\u001a\u00020\u001dH\u0002J\u0014\u0010~\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u007f\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010*\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010+\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010\u000b0\u000b -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010.0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/wavebar/MmAudioWaveBarView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barWidth", "", "gapWidth", "sideMargin", "minBarHeight", "maxBarHeight", "visualizerWidth", "waveGroupNumber", "barCount", "startAlphaSize", "endAlphaSize", "isActive", "", "isPaused", "aggregatedIsVisible", "frameIndex", "isLowDevice", "targetFramesPerSecond", "defaultFrameIntervalMs", "", "animationIntervalMs", "effectiveFramesPerSecond", "framesPerSample", "peakGroupIndex", "targetAmplitude", "currentAmplitude", "rawVolume", "displayMode", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/wavebar/MmAudioWaveBarView$WaveDisplayMode;", "usingIdleWave", "lowVolumeStartTimeMs", "Ljava/lang/Long;", "idleWaveStartTimeMs", "amplitudeSamples", "", "kotlin.jvm.PlatformType", "", "groupHeights", "activeGroupHeights", "prevMeters", "currMeters", "renderMeters", "generatedMeters", "tempMeterGroup", "alphaCache", "", "frameRunnable", "Ljava/lang/Runnable;", "paint", "Landroid/graphics/Paint;", "basePaintAlpha", "perfInfoLog", "", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onVisibilityAggregated", "isVisible", "startAnimation", "stopAnimation", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "setGradient", "startSize", "endSize", "setSlideMargin", GXTemplateKey.FLEXBOX_MARGIN, "setBarWidth", "widthPx", "setBarGap", "gapPx", "setBarHeightRange", "minHeightPx", "maxHeightPx", "setPaintColor", "color", "pause", "resume", "updateVolume", ITTVideoEngineEventSource.KEY_VOLUME, "rebuildMeterBuffers", "resetAllBarsToMinHeight", "generateGroups", "updatePeakGroupIndex", "updateAmplitudeFromSamples", "samplePendingAmplitude", "mapAmplitude", "rawAmplitude", "generateMeters", PickerReporterConstants.KEY.TARGET, "generateMetersForGroup", "groupHeight", "meterGroup", "shuffleInPlace", "array", "drawMeters", "rebuildAlphaCache", "paintAlpha", "index", "fillMeters", "source", "resetMeters", "copyMeters", "from", RemoteMessageConst.TO, "ensureMeterGroupSize", "mapVolumeToAmplitude", "maybeUpdateDisplayMode", "nowMs", "resetDisplayMode", "buildIdleMeters", "floorMod", "divisor", "Companion", "WaveDisplayMode", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmAudioWaveBarView extends View {
    public final List<Float> A;
    public final List<Float> B;
    public final List<Float> C;
    public int[] D;
    public final b E;
    public final Paint F;
    public int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f435780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f435781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f435782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f435783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f435784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f435785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f435786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f435787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f435788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f435789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f435790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f435791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f435792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f435793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f435794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f435795p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f435796q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WaveDisplayMode f435797r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f435798s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Long f435799t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f435800u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<Float> f435801v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<Float> f435802w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<Float> f435803x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<Float> f435804y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<Float> f435805z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/wavebar/MmAudioWaveBarView$WaveDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "IDLE", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WaveDisplayMode extends Enum<WaveDisplayMode> {
        public static final WaveDisplayMode ACTIVE = null;
        public static final WaveDisplayMode IDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WaveDisplayMode[] f435806a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f435807b = null;

        public static EnumEntries<WaveDisplayMode> getEntries() {
            return f435807b;
        }

        static {
            WaveDisplayMode r100 = new WaveDisplayMode("ACTIVE", 0);
            ACTIVE = r100;
            WaveDisplayMode r101 = new WaveDisplayMode("IDLE", 1);
            IDLE = r101;
            WaveDisplayMode[] r102 = {r100, r101};
            f435806a = r102;
            f435807b = EnumEntriesKt.enumEntries(r102);
        }

        public static WaveDisplayMode[] values() {
            return (WaveDisplayMode[]) f435806a.clone();
        }

        public static WaveDisplayMode valueOf(String r100) {
            return (WaveDisplayMode) r27.a.a(WaveDisplayMode.class, r100);
        }

        public WaveDisplayMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAudioWaveBarView f435808a;

        public b(MmAudioWaveBarView r100) {
            this.f435808a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f435808a.invalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public MmAudioWaveBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmAudioWaveBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b() {
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "pause", "aggregatedIsVisible=" + this.f435790k + " isActive=" + this.f435788i + " width=" + getWidth() + " height=" + getHeight() + ' ' + c(), null, 8);
        this.f435789j = true;
        this.f435801v.clear();
        this.f435795p = 0.0f;
        this.f435797r = WaveDisplayMode.ACTIVE;
        this.f435798s = false;
        this.f435799t = null;
        this.f435800u = 0;
        f(this.f435804y);
        f(this.f435805z);
        f(this.A);
        f(this.B);
        this.f435791l = 0;
        invalidate();
    }

    public final String c() {
        return "interval=" + this.f435792m + " lowDevice=false";
    }

    public final void d() {
        int r100 = this.D.length;
        int r101 = this.f435787h;
        if (r100 == r101) goto L5;
        this.D = new int[r101];
    L5:
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        this.D[r102] = RangesKt.coerceIn((int) (this.G * (RangesKt.coerceIn((int) (255 * 1.0f), 0, 255) / 255.0f)), 0, 255);
        r102 = r102 + 1;
        goto L6
    }

    public final void e() {
        ((ArrayList) this.f435802w).clear();
        List<Float> r100 = this.f435802w;
        int r101 = this.f435786g;
        if (r101 > 0) goto L5;
        List r102 = CollectionsKt.emptyList();
    L25:
        ((ArrayList) r100).addAll(r102);
        f(this.f435804y);
        f(this.f435805z);
        f(this.A);
        f(this.B);
    L27:
        if (((ArrayList) this.C).size() >= 5) goto L29;
        ((ArrayList) this.C).add(Float.valueOf(this.f435783d));
        goto L27
    L29:
        d();
        return;
    L5:
        ArrayList r103 = new ArrayList(r101);
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L8;
        r103.add(Float.valueOf(this.f435784e));
        r104 = r104 + 1;
        goto L6
    L8:
        int r105 = this.f435786g;
        if (r105 <= 2) goto L24;
        int r106 = 1;
        if (r105 != 3) goto L14;
        float r107 = this.f435783d;
        float r108 = r107 + ((this.f435784e - r107) * 0.5f);
        r102 = CollectionsKt.listOf(new Float[]{Float.valueOf(r108), Float.valueOf(this.f435784e), Float.valueOf(r108)});
        goto L25
    L14:
        float r109 = (this.f435784e - this.f435783d) / RangesKt.coerceAtLeast((r105 - 1) / 2, 1);
        int r110 = this.f435786g;
        int r111 = (r110 - 1) / 2;
        if ((r110 % 2) != 1) goto L17;
        int r112 = r111;
    L18:
        if (1 > r111) goto L24;
    L19:
        int r113 = r111 - r106;
        ListProtector.set(r103, r113, Float.valueOf(RangesKt.coerceAtLeast(((Number) ListProtector.get(r103, r113 + 1)).floatValue() - r109, this.f435783d)));
        int r114 = r112 + r106;
        if (r114 >= this.f435786g) goto L22;
        ListProtector.set(r103, r114, Float.valueOf(RangesKt.coerceAtLeast(((Number) ListProtector.get(r103, r114 - 1)).floatValue() - r109, this.f435783d)));
    L22:
        if (r106 == r111) goto L24;
        r106 = r106 + 1;
        goto L19
    L17:
        r112 = r111 + 1;
    L24:
        r102 = r103;
        goto L25
    }

    public final void g() {
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "resume", "aggregatedIsVisible=" + this.f435790k + " isActive=" + this.f435788i + " width=" + getWidth() + " height=" + getHeight() + ' ' + c(), null, 8);
        this.f435789j = false;
        this.f435788i = true;
        this.f435797r = WaveDisplayMode.ACTIVE;
        this.f435798s = false;
        this.f435799t = null;
        this.f435800u = 0;
        h();
    }

    public final void h() {
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "startAnimation", "visibility=" + getVisibility() + " isShown=" + isShown() + " aggregatedIsVisible=" + this.f435790k + " isPaused=" + this.f435789j + " isActive=" + this.f435788i + " width=" + getWidth() + " height=" + getHeight() + ' ' + c(), null, 8);
        removeCallbacks(this.E);
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        if (isShown() == true) goto L7;
        return;
    L7:
        if (this.f435789j == true) goto L12;
        this.f435790k = true;
        invalidate();
        return;
    }

    public final void i() {
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "stopAnimation", "aggregatedIsVisible=" + this.f435790k + " isPaused=" + this.f435789j + " isActive=" + this.f435788i + " width=" + getWidth() + " height=" + getHeight() + ' ' + c(), null, 8);
        removeCallbacks(this.E);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        i();
        this.f435788i = false;
        this.f435801v.clear();
        super.onDetachedFromWindow();
    }

    public final void a(long r100) {
        if (this.f435789j == false) goto L6;
        return;
    L6:
        if (this.f435796q <= 25) goto L11;
        this.f435799t = null;
        WaveDisplayMode r101 = this.f435797r;
        WaveDisplayMode r102 = WaveDisplayMode.ACTIVE;
        if (r101 == r102) goto L23;
        this.f435797r = r102;
        this.f435798s = false;
        return;
    L23:
        return;
    L11:
        WaveDisplayMode r103 = this.f435797r;
        WaveDisplayMode r104 = WaveDisplayMode.IDLE;
        if (r103 != r104) goto L15;
        this.f435799t = null;
        return;
    L15:
        Long r105 = this.f435799t;
        if (r105 != null) goto L20;
        this.f435799t = Long.valueOf(r100);
        return;
    L20:
        if ((r100 - r105.longValue()) < 2000) goto L24;
        this.f435799t = null;
        this.f435797r = r104;
        return;
    }

    public final void f(List<Float> r100) {
        r100.clear();
        int r101 = this.f435787h;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100.add(Float.valueOf(this.f435783d));
        r102 = r102 + 1;
        goto L3
    }

    public final void j(int r100) {
        if (this.f435789j == false) goto L5;
        return;
    L5:
        this.f435796q = r100;
        a(SystemClock.uptimeMillis());
        List<Float> r101 = this.f435801v;
        if (r100 > 0) goto L8;
        float r102 = 0.0f;
    L12:
        r101.add(Float.valueOf(r102));
        if (this.f435801v.size() <= 10) goto L16;
        ListProtector.remove(this.f435801v, 0);
        return;
    L16:
        return;
    L8:
        float r103 = r100;
        if (r103 > 80.0f) goto L11;
        r102 = r103 / 80.0f;
        goto L12
    L11:
        r102 = 1.0f;
        goto L12
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        if (this.f435788i == true) goto L5;
        return;
    L5:
        if (this.f435790k == true) goto L8;
        return;
    L8:
        if (this.f435787h > 0) goto L11;
        return;
    L11:
        if (((ArrayList) this.A).size() == this.f435787h) goto L16;
        e();
        if (((ArrayList) this.A).size() == this.f435787h) goto L16;
        return;
    L16:
        if (this.f435791l != 0) goto L148;
        List<Float> r100 = this.f435805z;
        ArrayList r101 = (ArrayList) this.f435804y;
        r101.clear();
        r101.addAll(r100);
        a(SystemClock.uptimeMillis());
        WaveDisplayMode r102 = this.f435797r;
        WaveDisplayMode r103 = WaveDisplayMode.IDLE;
        if (r102 != r103) goto L20;
        this.f435795p = 0.0f;
    L38:
        List<Float> r104 = this.B;
        if (this.f435797r == r103) goto L41;
        this.f435798s = false;
        int r105 = this.f435794o;
        int r106 = this.f435786g;
        if (r106 <= 1) goto L91;
        int r107 = r106 / 2;
        if (r106 > 3) goto L83;
        this.f435794o = r107;
        goto L91
    L83:
        if (r105 == r107) goto L86;
    L90:
        this.f435794o = r107;
        goto L91
    L86:
        if (ThreadLocalRandom.current().nextBoolean() == false) goto L88;
        int r108 = 1;
    L89:
        r107 = RangesKt.coerceIn(r107 + r108, 0, this.f435786g - 1);
        goto L90
    L88:
        r108 = -1;
    L91:
        float r109 = Math.min(this.f435795p * 1.7f, 1.0f);
        List<Float> r110 = this.f435802w;
        ArrayList r111 = (ArrayList) this.f435803x;
        r111.clear();
        r111.addAll(r110);
        if (r105 == this.f435794o) goto L106;
        if (r105 >= 0) goto L95;
    L97:
        boolean r112 = false;
    L98:
        if (r112 == false) goto L106;
        int r113 = ((ArrayList) this.f435803x).size();
        int r114 = this.f435794o;
        if (r114 < 0) goto L103;
        if (r114 >= r113) goto L103;
        boolean r115 = true;
    L104:
        if (r115 == false) goto L106;
        float r116 = ((Number) ListProtector.get(this.f435803x, r105)).floatValue();
        List<Float> r117 = this.f435803x;
        ListProtector.set(r117, r105, ListProtector.get(r117, this.f435794o));
        ListProtector.set(this.f435803x, this.f435794o, Float.valueOf(r116));
    L103:
        r115 = false;
        goto L104
    L95:
        if (r105 >= ((ArrayList) this.f435803x).size()) goto L97;
        r112 = true;
    L106:
        Iterator r118 = ((ArrayList) this.f435803x).iterator();
        int r119 = 0;
    L108:
        if (r118.hasNext() == false) goto L140;
        float r120 = RangesKt.coerceAtLeast(((Number) r118.next()).floatValue() * r109, this.f435783d);
        List<Float> r121 = this.C;
    L111:
        if (((ArrayList) this.C).size() >= 5) goto L113;
        ((ArrayList) this.C).add(Float.valueOf(this.f435783d));
        goto L111
    L113:
        int r122 = 0;
    L114:
        if (r122 >= 5) goto L116;
        ListProtector.set(r121, r122, Float.valueOf(r120));
        r122 = r122 + 1;
        goto L114
    L116:
        float r123 = (ThreadLocalRandom.current().nextFloat() * 0.3f) + 0.6f;
        int r124 = 1;
    L117:
        int r125 = 2 - r124;
        int r126 = r124 + 2;
        ListProtector.set(r121, r125, Float.valueOf(RangesKt.coerceAtLeast(((Number) ListProtector.get(r121, r125 + 1)).floatValue() * r123, this.f435783d)));
        if (r126 >= 5) goto L121;
        ListProtector.set(r121, r126, Float.valueOf(RangesKt.coerceAtLeast(((Number) ListProtector.get(r121, r126 - 1)).floatValue() * r123, this.f435783d)));
    L121:
        if (r124 == 2) goto L123;
        r124 = r124 + 1;
        goto L117
    L123:
        ArrayList r127 = (ArrayList) this.C;
        if (r127.size() <= 1) goto L132;
        int r128 = CollectionsKt.getLastIndex(r127);
    L127:
        if (r128 <= 0) goto L132;
        int r129 = ThreadLocalRandom.current().nextInt(r128 + 1);
        if (r128 == r129) goto L131;
        float r130 = ((Number) ListProtector.get(r127, r128)).floatValue();
        ListProtector.set(r127, r128, ListProtector.get(r127, r129));
        ListProtector.set(r127, r129, Float.valueOf(r130));
    L131:
        r128 = r128 - 1;
    L132:
        Iterator r131 = ((ArrayList) this.C).iterator();
    L134:
        if (r131.hasNext() == false) goto L108;
        float r132 = ((Number) r131.next()).floatValue();
        ArrayList r133 = (ArrayList) r104;
        if (r119 >= r133.size()) goto L138;
        ListProtector.set(r133, r119, Float.valueOf(r132));
    L139:
        r119 = r119 + 1;
        goto L134
    L138:
        r133.add(Float.valueOf(r132));
    L140:
        ArrayList r134 = (ArrayList) r104;
        if (r134.size() <= r119) goto L143;
        ListProtector.remove(r134, CollectionsKt.getLastIndex(r134));
    L143:
        List<Float> r135 = this.f435805z;
        List<Float> r136 = this.B;
        ArrayList r137 = (ArrayList) r135;
        r137.clear();
        ArrayList r138 = (ArrayList) r136;
        if (r138.isEmpty() == true) goto L148;
        r137.addAll(r138);
        goto L148
    L41:
        if (this.f435798s == true) goto L43;
        this.f435798s = true;
        this.f435800u = SystemClock.uptimeMillis();
    L43:
        long r139 = SystemClock.uptimeMillis();
        int r140 = this.f435787h;
        if (r140 > 0) goto L46;
        List r141 = CollectionsKt.emptyList();
    L71:
        ArrayList r142 = (ArrayList) r104;
        r142.clear();
        if (r141.isEmpty() == true) goto L143;
        r142.addAll(r141);
        goto L143
    L46:
        long r143 = (r139 - this.f435800u) % 3500;
        if (r143 >= 0) goto L51;
        r143 = r143 + 3500;
    L51:
        if (r143 <= 3500) goto L56;
        ArrayList r144 = new ArrayList(r140);
        int r145 = 0;
    L53:
        if (r145 >= r140) goto L55;
        r144.add(Float.valueOf(this.f435783d));
        r145 = r145 + 1;
        goto L53
    L55:
        r141 = r144;
        goto L71
    L56:
        double r146 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r143 > 500) goto L59;
        Pair r147 = TuplesKt.to(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), Double.valueOf(Math.sin(((r143 / 500) * 3.141592653589793d) * 0.5d)));
    L60:
        double r148 = ((Number) r147.component1()).doubleValue();
        double r149 = ((Number) r147.component2()).doubleValue();
        double r150 = ((double) (this.f435787h - 1)) * 0.5d;
        float r151 = RangesKt.coerceAtLeast(getHeight() * 0.7f, this.f435783d) - this.f435783d;
        int r152 = this.f435787h;
        ArrayList r153 = new ArrayList(r152);
        int r154 = 0;
    L61:
        if (r154 >= r152) goto L70;
        if (r150 != r146) goto L65;
        boolean r211 = true;
    L66:
        if (r211 == true) goto L69;
        r146 = (((double) r154) - r150) / r150;
    L69:
        r153.add(Float.valueOf(this.f435783d + ((((float) Math.exp(Math.pow(Math.abs(r146) - r148, 2.0d) * (-12.0d))) * r151) * ((float) r149))));
        r154 = r154 + 1;
        r146 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L61
    L65:
        r211 = false;
        goto L66
    L70:
        r141 = r153;
        goto L71
    L59:
        double r155 = ((r143 - 500) / 3000) * 3.141592653589793d;
        r147 = TuplesKt.to(Double.valueOf(Math.sin(r155 * 0.5d) * 1.6d), Double.valueOf(((Math.cos(r155) - 1.0d) * 0.5d) + 1.0d));
        goto L60
    L20:
        Float r156 = CollectionsKt.m9877maxOrNull(this.f435801v);
        if (r156 == null) goto L23;
        float r157 = r156.floatValue();
    L24:
        this.f435801v.clear();
        float r158 = Math.max(0.0f, r157);
        if (r158 > 0.001f) goto L28;
        float r159 = 0.0f;
    L31:
        float r160 = this.f435795p;
        float r161 = r159 - r160;
        if (r159 <= r160) goto L34;
        float r162 = 0.2f;
    L35:
        float r163 = r160 + (r161 * r162);
        this.f435795p = r163;
        if (r163 >= 5.0E-4f) goto L38;
        this.f435795p = 0.0f;
        goto L38
    L34:
        r162 = 0.08f;
        goto L35
    L28:
        if (r158 > 1.0f) goto L30;
        r159 = RangesKt.coerceIn(r158, 0.0f, 1.0f);
        goto L31
    L30:
        r159 = (float) (1.0d - Math.exp(-r158));
        goto L31
    L23:
        r157 = 0.0f;
    L148:
        int r164 = this.f435793n;
        if (r164 > 0) goto L151;
        return;
    L151:
        float r165 = this.f435791l / r164;
        float r166 = 2;
        float r167 = RangesKt.coerceIn((r165 * r165) * (3 - (r165 * r166)), 0.0f, 1.0f);
        int r168 = this.f435787h;
        int r169 = 0;
    L152:
        if (r169 >= r168) goto L154;
        ListProtector.set(this.A, r169, Float.valueOf(((Number) ListProtector.get(this.f435804y, r169)).floatValue() + ((((Number) ListProtector.get(this.f435805z, r169)).floatValue() - ((Number) ListProtector.get(this.f435804y, r169)).floatValue()) * r167)));
        r169 = r169 + 1;
        goto L152
    L154:
        float r170 = ((getWidth() - this.f435785f) / r166) + (this.f435780a / r166);
        int r171 = this.f435787h;
        int r172 = -1;
        int r173 = 0;
    L155:
        if (r173 >= r171) goto L173;
        Float r174 = (Float) CollectionsKt.getOrNull(this.A, r173);
        if (r174 == null) goto L159;
        float r175 = RangesKt.coerceAtLeast(r174.floatValue(), this.f435783d);
    L160:
        int[] r176 = this.D;
        if (r173 >= 0) goto L163;
    L165:
        boolean r177 = false;
    L166:
        if (r177 == false) goto L168;
        int r178 = r176[r173];
    L169:
        if (r178 == r172) goto L171;
        this.F.setAlpha(r178);
        int r179 = r178;
    L172:
        float r180 = (getHeight() - r175) / r166;
        r210.drawLine(r170, r180, r170, r180 + r175, this.F);
        r170 = r170 + (this.f435780a + this.f435781b);
        r173 = r173 + 1;
        r172 = r179;
        goto L155
    L171:
        r179 = r172;
        goto L172
    L168:
        r178 = this.G;
        goto L169
    L163:
        if (r173 >= r176.length) goto L165;
        r177 = true;
        goto L166
    L159:
        r175 = this.f435783d;
        goto L160
    L173:
        this.F.setAlpha(this.G);
        this.f435791l = (this.f435791l + 1) % this.f435793n;
        if (this.f435789j == true) goto L197;
        postDelayed(this.E, this.f435792m);
        return;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        if (this.f435790k != r100) goto L5;
        return;
    L5:
        this.f435790k = r100;
        int r101 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onVisibilityAggregated", "isVisible=" + r100, null, 8);
        if (r100 == false) goto L8;
        h();
        return;
    L8:
        i();
    }

    public final void setBarGap(float r100) {
        float r101 = RangesKt.coerceAtLeast(r100, 0.0f);
        if (this.f435781b != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f435781b = r101;
        requestLayout();
        invalidate();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setBarWidth(float r100) {
        float r101 = RangesKt.coerceAtLeast(r100, 1.0f);
        if (this.f435780a != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f435780a = r101;
        this.F.setStrokeWidth(r101);
        requestLayout();
        invalidate();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setPaintColor(int r100) {
        this.F.setColor(r100);
        this.G = Color.alpha(r100);
        d();
    }

    public final void setSlideMargin(int r100) {
        this.f435782c = r100;
        requestLayout();
    }

    public MmAudioWaveBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f435780a = UIUtils.dp2px(r100, 3.0f);
        this.f435781b = UIUtils.dp2px(r100, 3.0f);
        this.f435782c = UIUtils.dp2px(r100, 1.0f);
        this.f435783d = UIUtils.dp2px(r100, 3.0f);
        this.f435784e = UIUtils.dp2px(r100, 48.0f);
        this.f435788i = true;
        long r103 = RangesKt.coerceAtLeast(1000 / ((long) 30), 16);
        this.f435792m = r103;
        this.f435793n = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast((int) (1000 / r103), 1) / 10, 1);
        this.f435797r = WaveDisplayMode.ACTIVE;
        this.f435801v = Collections.synchronizedList(new ArrayList());
        this.f435802w = new ArrayList();
        this.f435803x = new ArrayList();
        this.f435804y = new ArrayList();
        this.f435805z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        ArrayList r104 = new ArrayList(5);
        int r105 = 0;
    L3:
        if (r105 >= 5) goto L5;
        r104.add(Float.valueOf(this.f435783d));
        r105 = r105 + 1;
        goto L3
    L5:
        this.C = r104;
        this.D = new int[0];
        this.E = new b(this);
        Paint r106 = new Paint();
        r106.setAntiAlias(true);
        r106.setFilterBitmap(true);
        r106.setStrokeCap(Paint.Cap.ROUND);
        r106.setStrokeWidth(this.f435780a);
        r106.setColor(UIUtils.getColor(r100, R.color.ud_N900_50));
        this.F = r106;
        this.G = Color.alpha(r106.getColor());
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.mmWaveBarGap, R.attr.mmWaveBarWidth, R.attr.mmWaveMaxBarHeight, R.attr.mmWaveMinBarHeight, R.attr.mmWavePaintColor});
        this.f435780a = r107.getDimension(1, this.f435780a);     // Catch: Throwable -> L9
        this.f435781b = r107.getDimension(0, this.f435781b);     // Catch: Throwable -> L9
        float r108 = r107.getDimension(3, this.f435783d);     // Catch: Throwable -> L9
        this.f435783d = r108;     // Catch: Throwable -> L9
        this.f435784e = RangesKt.coerceAtLeast(r107.getDimension(2, this.f435784e), r108);     // Catch: Throwable -> L9
        r106.setStrokeWidth(this.f435780a);     // Catch: Throwable -> L9
        r106.setColor(r107.getColor(4, r106.getColor()));     // Catch: Throwable -> L9
        this.G = Color.alpha(r106.getColor());     // Catch: Throwable -> L9
        r107.recycle();
        return;
    L9:
        th = move-exception;
        r107.recycle();
        throw th;
    }

    public /* synthetic */ MmAudioWaveBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = (int) ((getWidth() - (this.f435782c * 2)) / ((this.f435780a * 5) + (this.f435781b * 4)));
        this.f435786g = r104;
        if ((r104 % 2) != 0) goto L5;
        this.f435786g = r104 - 1;
    L5:
        int r105 = RangesKt.coerceAtLeast(this.f435786g, 3);
        this.f435786g = r105;
        this.f435794o = r105 / 2;
        int r106 = r105 * 5;
        this.f435787h = r106;
        if (r106 <= 0) goto L8;
        float r107 = (r106 * this.f435780a) + ((r106 - 1) * this.f435781b);
    L9:
        this.f435785f = r107;
        e();
        int r108 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onSizeChanged", "w=" + r100 + " h=" + r101 + " waveGroupNumber=" + this.f435786g + " barCount=" + this.f435787h + " interval=" + this.f435792m + " lowDevice=false", null, 8);
        return;
    L8:
        r107 = 0.0f;
        goto L9
    }
}
