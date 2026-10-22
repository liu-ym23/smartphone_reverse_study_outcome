package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$WaveformState;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u00014B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0014J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0014J\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u000fJ\u001a\u0010+\u001a\u00020!2\b\b\u0001\u0010,\u001a\u00020\u000f2\b\b\u0001\u0010-\u001a\u00020\u000fJ\u0006\u0010.\u001a\u00020!J\u0006\u0010/\u001a\u00020!J\u0006\u00100\u001a\u00020!J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveform;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "singleWidth", "", "minHeight", "radius", "gapWidth", "mHorizonLine", "mCountInScreen", "", "mWaveHeightList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mScaledHeightList", "", "mLastVolume", "mPaintWave", "Landroid/graphics/Paint;", "mPathWave", "Landroid/graphics/Path;", "mPaintFade", "mPathFade", "mTimer", "Ljava/util/Timer;", "mState", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$WaveformState;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setVolume", ITTVideoEngineEventSource.KEY_VOLUME, "setColor", "colorWave", "colorFade", "startRecord", "stopRecord", BasicTestActionHandler.TEST_ACTION_RESET, "updateShowCount", "addNewHeight", "scaleAndDraw", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioWaveform extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f430037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f430038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f430039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f430040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f430041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f430042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<Float> f430043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Float> f430044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f430045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f430046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f430047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Path f430048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PthreadTimer f430049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AudioPluginEnums$WaveformState f430050n;

    public static final class a {
    }

    static {
    }

    public final void setVolume(int r100) {
    }

    public final void a() {
        if (this.f430042f > 0) goto L5;
        return;
    L5:
        int r100 = this.f430043g.size();
        ArrayList r101 = new ArrayList(this.f430042f);
        int r102 = this.f430042f;
        float r103 = r100 / r102;
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L18;
        int r105 = (int) Math.floor(r104 * r103);
        r104 = r104 + 1;
        float r106 = r104 * r103;
        float r107 = 0.0f;
        int r108 = 0;
    L9:
        if (r105 >= r106) goto L12;
        if (r105 >= r100) goto L12;
        r107 = r107 + ((Number) ListProtector.get(this.f430043g, r105)).floatValue();     // Catch: Throwable -> L16
        r105 = r105 + 1;     // Catch: Throwable -> L16
        r108 = r108 + 1;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Log.e("AudioWaveform", th.getClass().getSimpleName() + " / " + th.getMessage() + ", heightList size: " + this.f430043g.size() + ", indexStart: " + r105);
        Unit r109 = Unit.INSTANCE;
    L12:
        if (r108 > 0) goto L14;
        Log.w("AudioWaveform", "scaleAndDraw / itemCount error");     // Catch: Throwable -> L16
        r108 = 1;
    L14:
        r101.add(Float.valueOf(Math.max(r107 / r108, this.f430038b)));     // Catch: Throwable -> L16
        goto L6
    L18:
        this.f430044h = r101;
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f430041e = getMeasuredHeight() / 2.0f;
        this.f430046j.reset();
        this.f430048l.reset();
        int r100 = this.f430043g.size();
        float r101 = getMeasuredWidth() - this.f430040d;
        int r102 = this.f430042f;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L18;
        Path r104 = this.f430046j;
        AudioPluginEnums$WaveformState r105 = this.f430050n;
        if (r105 != AudioPluginEnums$WaveformState.RECORDING) goto L9;
        if (r100 <= r103) goto L9;
        float r106 = Math.max(((Number) ListProtector.get(this.f430043g, (r100 - 1) - r103)).floatValue(), this.f430038b);
    L17:
        float r107 = r101 - this.f430037a;
        float r108 = this.f430041e;
        float r109 = r106 / 2;
        float r111 = this.f430039c;
        r104.addRoundRect(r107, r108 - r109, r101, r108 + r109, r111, r111, Path.Direction.CW);
        r101 = r101 - (this.f430037a + this.f430040d);
        r103 = r103 + 1;
    L9:
        if (r105 != AudioPluginEnums$WaveformState.DISPLAY) goto L16;
        List<Float> r112 = this.f430044h;
        if (r112 == null) goto L15;
        Float r113 = (Float) CollectionsKt.getOrNull(r112, (this.f430042f - 1) - r103);
        if (r113 == null) goto L15;
        r106 = r113.floatValue();
    L15:
        r106 = this.f430038b;
        goto L17
    L16:
        r104 = this.f430048l;
        r106 = this.f430038b;
        goto L17
    L18:
        r110.drawPath(this.f430046j, this.f430045i);
        r110.drawPath(this.f430048l, this.f430047k);
    }

    public AudioWaveform(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        int r102 = c.f430003a;
        float r103 = c.n(this, 2);
        this.f430037a = r103;
        this.f430038b = c.n(this, 2);
        this.f430039c = r103 / 2.0f;
        this.f430040d = c.n(this, 2);
        this.f430043g = new ArrayList(1024);
        this.f430045i = new Paint(1);
        this.f430046j = new Path();
        this.f430047k = new Paint(1);
        this.f430048l = new Path();
        this.f430050n = AudioPluginEnums$WaveformState.INIT;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        this.f430042f = 0;
        float r104 = getMeasuredWidth();
    L3:
        float r105 = this.f430037a;
        if (r104 <= r105) goto L6;
        r104 = r104 - (r105 + this.f430040d);
        this.f430042f++;
        goto L3
    L6:
        a();
    }
}
