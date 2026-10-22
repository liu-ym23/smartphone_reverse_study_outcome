package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u000bH\u0016J\u0010\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020\u000bH\u0016J\u0010\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020\u000bH\u0016J\u0010\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020-H\u0016J\u000e\u0010D\u001a\u00020;2\u0006\u0010)\u001a\u00020*J\u0018\u0010E\u001a\u00020;2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-H\u0016J(\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000bH\u0014J\u0010\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020MH\u0014J\b\u0010N\u001a\u00020;H\u0002J0\u0010O\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`02\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0H\u0002J\u0010\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020*H\u0002J\u0010\u0010S\u001a\u00020;2\u0006\u0010T\u001a\u00020UH\u0016J \u0010V\u001a\u0012\u0012\u0004\u0012\u00020W0/j\b\u0012\u0004\u0012\u00020W`02\u0006\u0010X\u001a\u00020UH\u0002J0\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`02\u0016\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020W0/j\b\u0012\u0004\u0012\u00020W`0H\u0002R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001a\u0010!\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u000e\u0010$\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/larus/common_ui/view/CustomBarCountAudioVisualizer;", "Landroid/view/View;", "Lcom/larus/common_ui/view/IAudioVisualizer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "duration", "density", "visualizerWidth", "", "visualizerHeight", "getVisualizerHeight", "()F", "setVisualizerHeight", "(F)V", "_visualizerWidth", "_visualizerHeight", "barWidth", "getBarWidth", "setBarWidth", "gapWidth", "getGapWidth", "setGapWidth", "minBarHeight", "getMinBarHeight", "setMinBarHeight", "maxBarHeight", "getMaxBarHeight", "setMaxBarHeight", "_minBarHeight", "_maxBarHeight", "barColor", "paint", "Landroid/graphics/Paint;", "maxSampleData", "", "multipleFactor", "needOpt", "", "prepareData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastData", "currentData", "nextData", "times", "frameTime", "", "maxTimes", "drawDelayMS", "enablePostInvalidateDelayed", "init", "", "changeVisibility", RemoteMessageConst.Notification.VISIBILITY, "setColor", "color", "setFps", "fps", "switchPostInvalidateDelayed", "enable", "setMaxSampleData", "setMultipleFactor", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "handleData", "copy", PickerReporterConstants.KEY.TARGET, "optSample", "sample", "setAudioData", "data", "", "handle16bit", "Ljava/math/BigDecimal;", HTTP.CONTENT_RANGE_BYTES, "calcPrepareData", "sampleData", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomBarCountAudioVisualizer extends View implements u {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f328190x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f328192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f328193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f328194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f328195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f328196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f328197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f328198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f328199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f328200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f328201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f328202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f328203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f328204n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f328205o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<Double> f328206p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<Double> f328207q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<Double> f328208r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<Double> f328209s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f328210t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f328211u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f328212v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f328213w;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.view.u
    public final void b() {
        this.f328204n = 20;
        this.f328205o = false;
    }

    public final void e() {
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        r100.setFilterBitmap(true);
        r100.setStrokeCap(Paint.Cap.ROUND);
        r100.setColor(this.f328201k);
        this.f328202l = r100;
        int r101 = this.f328191a;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        this.f328206p.add(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        r102 = r102 + 1;
        goto L3
    L5:
        this.f328207q = d(this.f328206p);
        this.f328209s = d(this.f328206p);
        this.f328208r = d(this.f328206p);
        postInvalidate();
    }

    public final float getBarWidth() {
        return this.f328195e;
    }

    public final float getGapWidth() {
        return this.f328196f;
    }

    public final float getMaxBarHeight() {
        return this.f328198h;
    }

    public final float getMinBarHeight() {
        return this.f328197g;
    }

    public final float getVisualizerHeight() {
        return this.f328192b;
    }

    public CustomBarCountAudioVisualizer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f328191a = 3;
        float r101 = i5.Q();
        this.f328192b = r101;
        this.f328193c = 0.0f;
        this.f328194d = r101;
        this.f328195e = i5.h();
        this.f328196f = i5.Y();
        float r102 = i5.v();
        this.f328198h = r102;
        this.f328199i = this.f328197g;
        this.f328200j = r102;
        this.f328201k = -1;
        this.f328203m = 0.2d;
        this.f328204n = 5;
        this.f328205o = true;
        this.f328206p = new ArrayList(3);
        this.f328207q = new ArrayList(3);
        this.f328208r = new ArrayList(3);
        this.f328209s = new ArrayList(3);
        this.f328211u = (int) (((long) 40) / 10);
        this.f328212v = 10;
        this.f328213w = true;
        e();
    }

    public static ArrayList d(ArrayList r100) {
        ArrayList r101 = new ArrayList();
        r101.addAll(r100);
        return r101;
    }

    @Override // com.larus.common_ui.view.u
    public final void a(int r100) {
        setVisibility(r100);
    }

    @Override // com.larus.common_ui.view.u
    public final void c(boolean r100) {
        this.f328213w = r100;
        FLogger.f375446a.i("CustomBarCountAudioVisualizer", "enablePostInvalidateDelayed: " + r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f328210t != this.f328211u) goto L5;
        this.f328208r = d(this.f328209s);
        this.f328207q = d(this.f328209s);
        this.f328209s = d(this.f328206p);
        this.f328210t = 0;
    L18:
        if ((!this.f328208r.isEmpty()) == false) goto L34;
        Paint r100 = this.f328202l;
        if (r100 == null) goto L22;
        r100.setStrokeWidth(this.f328195e);
    L22:
        Paint r101 = this.f328202l;
        if (r101 == null) goto L25;
        r101.setAntiAlias(true);
    L25:
        float r102 = 2;
        float r103 = (getWidth() - this.f328193c) / r102;
        float r111 = (getHeight() - this.f328194d) / r102;
        int r112 = this.f328208r.size();
        int r113 = 0;
    L26:
        if (r113 >= r112) goto L34;
        float r104 = this.f328195e;
        float r105 = (r113 * (this.f328196f + r104)) + (r104 / r102);
        double r106 = ((Number) ListProtector.get(this.f328208r, r113)).doubleValue();
        float r107 = this.f328199i;
        float r108 = (float) (((double) r107) + ((r106 * ((double) (this.f328200j - r107))) / this.f328203m));
        float r109 = this.f328194d / r102;
        float r114 = r108 / r102;
        float r115 = r109 + r114;
        float r116 = r109 - r114;
        Paint r117 = this.f328202l;
        if (r117 == null) goto L32;
        r117.setColor(this.f328201k);
        if (r110 == null) goto L32;
        float r118 = r105 + r103;
        r110.drawLine(r118, r115 + r111, r118, r116 + r111, r117);
    L32:
        r113 = r113 + 1;
    L34:
        if (this.f328213w == false) goto L44;
        postInvalidateDelayed(this.f328212v);
        return;
    L44:
        return;
    L5:
        int r119 = this.f328191a;
        int r120 = 0;
    L6:
        if (r120 >= r119) goto L16;
        if (this.f328207q.size() <= r120) goto L10;
        Double r121 = (Double) ListProtector.get(this.f328207q, r120);
    L11:
        Intrinsics.checkNotNull(r121);
        double r122 = r121.doubleValue();
        if (this.f328209s.size() <= r120) goto L14;
        Double r123 = (Double) ListProtector.get(this.f328209s, r120);
    L15:
        Intrinsics.checkNotNull(r123);
        ListProtector.set(this.f328208r, r120, Double.valueOf(r122 + ((((double) this.f328210t) * (r123.doubleValue() - r122)) / ((double) this.f328211u))));
        r120 = r120 + 1;
        goto L6
    L14:
        r123 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        goto L15
    L10:
        r121 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        goto L11
    L16:
        this.f328210t++;
        goto L18
    }

    @Override // com.larus.common_ui.view.u
    public void setAudioData(final byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        t0.a(new n(this, r100));
    }

    public final void setBarWidth(float r100) {
        this.f328195e = r100;
    }

    @Override // com.larus.common_ui.view.u
    public void setColor(int r100) {
        FLogger.f375446a.i("CustomBarCountAudioVisualizer", "setColor");
        this.f328201k = r100;
        postInvalidate();
    }

    @Override // com.larus.common_ui.view.u
    public void setFps(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f328212v = 1000 / r100;
        FLogger.f375446a.i("CustomBarCountAudioVisualizer", "drawDelayMS: " + this.f328212v);
    }

    public final void setGapWidth(float r100) {
        this.f328196f = r100;
    }

    public final void setMaxBarHeight(float r100) {
        this.f328198h = r100;
    }

    public final void setMaxSampleData(double r100) {
        this.f328203m = r100;
    }

    public final void setMinBarHeight(float r100) {
        this.f328197g = r100;
    }

    public final void setVisualizerHeight(float r100) {
        this.f328192b = r100;
    }

    public CustomBarCountAudioVisualizer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f328191a = 3;
        float r102 = i5.Q();
        this.f328192b = r102;
        this.f328193c = 0.0f;
        this.f328194d = r102;
        this.f328195e = i5.h();
        this.f328196f = i5.Y();
        float r103 = i5.v();
        this.f328198h = r103;
        this.f328199i = this.f328197g;
        this.f328200j = r103;
        this.f328201k = -1;
        this.f328203m = 0.2d;
        this.f328204n = 5;
        this.f328205o = true;
        this.f328206p = new ArrayList(3);
        this.f328207q = new ArrayList(3);
        this.f328208r = new ArrayList(3);
        this.f328209s = new ArrayList(3);
        this.f328211u = (int) (((long) 40) / 10);
        this.f328212v = 10;
        this.f328213w = true;
        e();
    }

    public CustomBarCountAudioVisualizer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328191a = 3;
        float r103 = i5.Q();
        this.f328192b = r103;
        this.f328193c = 0.0f;
        this.f328194d = r103;
        this.f328195e = i5.h();
        this.f328196f = i5.Y();
        float r104 = i5.v();
        this.f328198h = r104;
        this.f328199i = this.f328197g;
        this.f328200j = r104;
        this.f328201k = -1;
        this.f328203m = 0.2d;
        this.f328204n = 5;
        this.f328205o = true;
        this.f328206p = new ArrayList(3);
        this.f328207q = new ArrayList(3);
        this.f328208r = new ArrayList(3);
        this.f328209s = new ArrayList(3);
        this.f328211u = (int) (((long) 40) / 10);
        this.f328212v = 10;
        this.f328213w = true;
        e();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = this.f328195e;
        int r105 = this.f328191a;
        float r106 = (r104 * r105) + (this.f328196f * (r105 - 1));
        if (getWidth() >= r106) goto L6;
        r106 = getWidth();
    L6:
        this.f328193c = r106;
        float r107 = getHeight();
        float r108 = this.f328192b;
        if (r107 >= r108) goto L10;
        r108 = getHeight();
    L10:
        this.f328194d = r108;
        float r109 = this.f328193c;
        int r110 = this.f328191a;
        float r111 = (1.0f * r109) / r110;
        float r112 = this.f328195e;
        if (r112 > r111) goto L14;
        r111 = r112;
    L14:
        this.f328195e = r111;
        this.f328196f = (r109 - (r111 * r110)) / (r110 - 1);
        float r113 = this.f328198h;
        if (r108 <= r113) goto L17;
        float r114 = r113;
    L18:
        this.f328200j = r114;
        float r115 = this.f328197g;
        if (r108 <= r115) goto L24;
        if (r113 <= r115) goto L26;
        r108 = r115;
    L27:
        this.f328199i = r108;
        return;
    L26:
        r108 = r113;
        goto L27
    L24:
        if (r113 <= r108) goto L26;
    L17:
        r114 = r108;
        goto L18
    }
}
