package com.larus.common_ui.edgeeffect;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.utils.b0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.continue_talk.f2;
import com.larus.voicecall.impl.continue_talk.g2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import d19.g;
import d19.m;
import d19.n;
import d19.o;
import d19.p;
import d19.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016JT\u0010\u001a\u001a\u00020\u00182%\u0010\u001b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001c2#\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cH\u0016JT\u0010\"\u001a\u00020\u00182%\u0010\u001b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001c2#\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cH\u0016J(\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0014J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0014J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0018H\u0002J\b\u00102\u001a\u00020\u0018H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/common_ui/edgeeffect/ScreenEdgeEffectView;", "Landroid/view/View;", "Lcom/larus/common_ui/edgeeffect/IScreenEdgeEffectView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shader", "Lcom/larus/common_ui/edgeeffect/ScreenEdgeEffectShader;", "paint", "Landroid/graphics/Paint;", "timeAnimator", "Landroid/animation/ValueAnimator;", "showAnimator", "hideAnimator", "currentAlpha", "", "isAnimationActive", "", "init", "", MapMonitorConst.EVENT_DESTROY, "showScreenEdgeEffect", "onEnd", "Lkotlin/Function1;", "Landroid/animation/Animator;", "Lkotlin/ParameterName;", "name", "animator", "onCancel", "dismissScreenEdgeEffect", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setAudioAmplitude", "amplitude", "setDarkMode", "darkMode", "pauseEdgeEffect", "resumeEdgeEffect", "initializeShader", "startTimeAnimation", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenEdgeEffectView extends View implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f327401h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f327402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f327403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f327404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f327405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f327406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f327407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f327408g;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Animator, Unit> f327409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animator f327410b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Animator, Unit> r100, Animator r101) {
            this.f327409a = r100;
            this.f327410b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<Animator, Unit> r100 = this.f327409a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.invoke(this.f327410b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Animator, Unit> f327411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animator f327412b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Animator, Unit> r100, Animator r101) {
            this.f327411a = r100;
            this.f327412b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<Animator, Unit> r100 = this.f327411a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.invoke(this.f327412b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenEdgeEffectView f327413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f327414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f327415c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            FLogger.f375446a.i("ScreenEdgeEffectView", "showScreenEdgeEffect onCancel");
            this.f327413a.post(new c(this.f327415c, r100));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            FLogger.f375446a.i("ScreenEdgeEffectView", "showScreenEdgeEffect onEnd");
            this.f327413a.post(new b(this.f327414b, r100));
        }

        public d(ScreenEdgeEffectView r100, Function1 r101, Function1 r102) {
            this.f327413a = r100;
            this.f327414b = r101;
            this.f327415c = r102;
        }
    }

    static {
    }

    public ScreenEdgeEffectView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScreenEdgeEffectView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // d19.g
    public final void init() {
        this.f327407f = 0.0f;
        m r100 = this.f327402a;
        boolean r101 = true;
        if (r100.f466470a != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        r100.setFloatUniform("uTime", 0.0f);
        r100.f466470a = 0.0f;
    L8:
        r100.a(this.f327407f);
        Resources r103 = getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        if (r100.f466472c == r104) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L15;
        r100.setFloatUniform("uDensity", r104);
        r100.f466472c = r104;
        return;
    L15:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // d19.g
    public final void c() {
        if (this.f327408g == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ScreenEdgeEffectView", "pauseEdgeEffect");
        this.f327408g = false;
        ValueAnimator r100 = this.f327404c;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isRunning() == false) goto L12;
        r100.pause();
        return;
    }

    @Override // d19.g
    public final void d() {
        if (this.f327408g == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ScreenEdgeEffectView", "resumeEdgeEffect");
        this.f327408g = true;
        ValueAnimator r100 = this.f327404c;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isPaused() == false) goto L12;
        r100.resume();
        return;
    }

    @Override // d19.g
    public final void destroy() {
        ValueAnimator r100 = this.f327404c;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f327404c;
        if (r101 == null) goto L8;
        r101.removeAllUpdateListeners();
    L8:
        ValueAnimator r102 = this.f327405d;
        if (r102 == null) goto L11;
        r102.removeAllUpdateListeners();
    L11:
        ValueAnimator r103 = this.f327405d;
        if (r103 == null) goto L14;
        r103.removeAllListeners();
    L14:
        ValueAnimator r104 = this.f327406e;
        if (r104 == null) goto L17;
        r104.removeAllUpdateListeners();
    L17:
        ValueAnimator r105 = this.f327406e;
        if (r105 == null) goto L20;
        r105.removeAllListeners();
    L20:
        this.f327404c = null;
        this.f327405d = null;
        this.f327406e = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f327407f >= 0.001f) goto L5;
        return;
    L5:
        r100.drawPaint(this.f327403b);
    }

    @Override // d19.g
    public void setAudioAmplitude(float r100) {
        m r101 = this.f327402a;
        if (r101.f466473d != r100) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101.setFloatUniform("uAudioAmplitude", r100);
        r101.f466473d = r100;
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // d19.g
    public void setDarkMode(boolean r100) {
        m r101 = this.f327402a;
        if (r101.f466474e == r100) goto L6;
        r101.setIntUniform("uDarkMode", r100 ? 1 : 0);
        r101.f466474e = r100 ? 1 : 0;
        return;
    }

    @Override // d19.g
    public final void a(f2 r100, g2 r101) {
        if (b0.a(this.f327407f, 0.0f) == false) goto L6;
        r100.invoke(null);
        return;
    L6:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{this.f327407f, 0.0f});
        r102.setDuration(100);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new o(this));
        Intrinsics.checkNotNull(r102);
        r102.addListener(new s(this, r100, r101));
        r102.start();
        this.f327406e = r102;
    }

    @Override // d19.g
    public final void b(Function1<? super Animator, Unit> r100, Function1<? super Animator, Unit> r101) {
        if (b0.a(this.f327407f, 1.0f) == false) goto L7;
        if (r100 == null) goto L19;
        r100.invoke(null);
        return;
    L19:
        return;
    L7:
        ValueAnimator r102 = this.f327404c;
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L17;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, Float.MAX_VALUE});
        r104.setDuration(Long.MAX_VALUE);
        r104.setInterpolator(new LinearInterpolator());
        r104.setRepeatCount(-1);
        r104.addUpdateListener(new p(this));
        r104.start();
        this.f327404c = r104;
    L17:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{this.f327407f, 1.0f});
        r105.setDuration(300);
        r105.setInterpolator(new DecelerateInterpolator());
        r105.addUpdateListener(new n(this));
        Intrinsics.checkNotNull(r105);
        r105.addListener(new d(this, r100, r101));
        r105.start();
        this.f327405d = r105;
        return;
    L10:
        if (r102.isRunning() != true) goto L12;
        r103 = true;
        goto L14
    }

    public ScreenEdgeEffectView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        m r103 = new m();
        this.f327402a = r103;
        Paint r104 = new Paint();
        this.f327403b = r104;
        setLayerType(2, null);
        setBackground(null);
        r104.setShader(r103);
    }

    public /* synthetic */ ScreenEdgeEffectView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        m r104 = this.f327402a;
        float r105 = r100;
        float r106 = r101;
        boolean r107 = true;
        if (r104.f466475f != r105) goto L5;
        boolean r108 = true;
    L6:
        if (r108 == true) goto L8;
    L12:
        r104.setFloatUniform("uResolution", r105, r106);
        r104.f466475f = r105;
        r104.f466476g = r106;
    L13:
        Resources r109 = Resources.getSystem();
        float r110 = WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()).density;
        if (r104.f466472c == r110) goto L17;
        r107 = false;
    L17:
        if (r107 == true) goto L20;
        r104.setFloatUniform("uDensity", r110);
        r104.f466472c = r110;
        return;
    L20:
        return;
    L8:
        if (r104.f466476g != r106) goto L10;
        boolean r111 = true;
    L11:
        if (r111 == true) goto L13;
    L10:
        r111 = false;
        goto L11
    L5:
        r108 = false;
        goto L6
    }
}
