package com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import eaa.c;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ;\u0010 \u001a\u00020\u001e2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"2#\b\u0002\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$JR\u0010)\u001a\u00020\u001e2%\b\u0002\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$2#\b\u0002\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J+\u0010*\u001a\u00020\u001e2#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J+\u0010+\u001a\u00020\u001e2#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J(\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0014J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0018H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0018H\u0002J\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u001eH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?R\u0018\u0010B\u001a\u00020\u0018*\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "activeEffectTimeoutMs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IJ)V", "getActiveEffectTimeoutMs", "()J", "shader", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectShader;", "paint", "Landroid/graphics/Paint;", "timeAnimator", "Landroid/animation/ValueAnimator;", "fadeAnimator", "shimmerAnimator", "captureAnimator", "currentAlpha", "", "currentCaptureProgress", "currentShimmerProgress", "isPreparedToShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "prepareToShow", "", "cancelShow", "playFadeInAnimation", "onEnd", "Lkotlin/Function0;", "onCancel", "Lkotlin/Function1;", "Landroid/animation/Animator;", "Lkotlin/ParameterName;", "name", "animator", "playFadeOutAnimation", "playShimmerAnimation", "playCaptureAnimation", "isPlayingShimmerAnimation", "", "isPlayingCaptureAnimation", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setShimmerProgress", "progress", "setCaptureProgress", "initializeShader", "startTimeAnimation", "setScreenCornerRadii", "density", "getDensity", "()F", "density$delegate", "Lkotlin/Lazy;", "dp", "getDp", "(F)F", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiScreenEdgeEffectView extends View {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f385047k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f385048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eaa.a f385049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f385050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f385051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f385052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f385053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f385054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f385055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f385056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f385057j;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f385058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f385059b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f385059b.invoke(r100);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f385058a.invoke(r100);
        }

        public b(Function1 r100, Function1 r101) {
            this.f385058a = r100;
            this.f385059b = r101;
        }
    }

    static {
    }

    public AiScreenEdgeEffectView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 0, 14);
    }

    public AiScreenEdgeEffectView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r110, 0, 0, 12);
    }

    public AiScreenEdgeEffectView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r110, r111, 0, 8);
    }

    private final void setCaptureProgress(float r100) {
    }

    private final void setShimmerProgress(float r100) {
    }

    private final float getDensity() {
        return ((Number) this.f385057j.getValue()).floatValue();
    }

    public final void a() {
        ILogDepend.f384986a.i("AiScreenEdgeEffectView", "cancelShow");
        setVisibility(8);
        this.f385056i.set(false);
        ValueAnimator r100 = this.f385051d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f385052e;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        ValueAnimator r102 = this.f385053f;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        ValueAnimator r103 = this.f385054g;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        this.f385051d = null;
        this.f385052e = null;
        this.f385053f = null;
        this.f385054g = null;
    }

    public final long getActiveEffectTimeoutMs() {
        return this.f385048a;
    }

    public final float b(float r100) {
        return r100 * getDensity();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (r100.isHardwareAccelerated() == true) goto L5;
        return;
    L5:
        super.onDraw(r100);
        r100.drawPaint(this.f385050c);
    }

    public final void c(Function1<? super Animator, Unit> r100, Function1<? super Animator, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onEnd");
        Intrinsics.checkNotNullParameter(r101, "onCancel");
        ILogDepend.Companion r102 = ILogDepend.f384986a;
        r102.i("AiScreenEdgeEffectView", "playFadeOutAnimation");
        ValueAnimator r103 = this.f385052e;
        if (r103 == null) goto L6;
        r103.cancel();
    L6:
        if (Math.abs(this.f385055h - 0.0f) >= 1.0E-6f) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r102.i("AiScreenEdgeEffectView", "playFadeOutAnimation: no need to play");
        r100.invoke(null);
        return;
    L12:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{this.f385055h, 0.0f});
        r105.setDuration(100);
        r105.setInterpolator(new LinearInterpolator());
        r105.addUpdateListener(new c(this));
        Intrinsics.checkNotNull(r105);
        r105.addListener(new b(r100, r101));
        r105.start();
        this.f385052e = r105;
        return;
    L8:
        r104 = false;
        goto L9
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        eaa.a r104 = this.f385049b;
        r104.setFloatUniform("uResolution", r100, r101);
        Resources r105 = Resources.getSystem();
        r104.setFloatUniform("uDensity", WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density);
        eaa.a r106 = this.f385049b;
        String r107 = t9a.b.a().d();
        switch(r107.hashCode()) {
            case -2002884280: goto L23;
            case -2002884275: goto L20;
            case -1048984789: goto L16;
            case -807117175: goto L13;
            case 3440915: goto L9;
            case 1328894480: goto L6;
            default: goto L26;
        };
    L26:
        r106.a(b(44.0f), b(44.0f), b(42.0f), b(42.0f));
        return;
    L6:
        if (r107.equals("nerida-lite") == false) goto L26;
    L18:
        r106.a(b(47.0f), b(47.0f), b(47.0f), b(47.0f));
        return;
    L9:
        if (r107.equals("pike") == false) goto L26;
        r106.a(134.0f, 134.0f, 134.0f, 134.0f);
        return;
    L13:
        if (r107.equals("pacific") == false) goto L26;
        r106.a(b(44.0f), b(44.0f), b(42.0f), b(42.0f));
        return;
    L16:
        if (r107.equals("nerida") == true) goto L18;
    L20:
        if (r107.equals("Genesis-R") == false) goto L26;
    L25:
        r106.a(b(57.0f), b(57.0f), b(57.0f), b(57.0f));
        return;
    L23:
        if (r107.equals("Genesis-M") == true) goto L25;
        goto L25
    }

    public AiScreenEdgeEffectView(Context r100, AttributeSet r101, int r102, long r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = 300000;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f385048a = r103;
        eaa.a r105 = new eaa.a();
        this.f385049b = r105;
        Paint r106 = new Paint();
        this.f385050c = r106;
        this.f385056i = new AtomicBoolean(false);
        setLayerType(2, null);
        setBackground(null);
        r106.setShader(r105);
        this.f385057j = LazyKt.lazy(new eaa.b());
    }
}
