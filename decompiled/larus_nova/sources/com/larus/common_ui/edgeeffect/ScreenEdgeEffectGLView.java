package com.larus.common_ui.edgeeffect;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.continue_talk.f2;
import com.larus.voicecall.impl.continue_talk.g2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import d19.f;
import d19.g;
import d19.h;
import d19.i;
import d19.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016JT\u0010\u0017\u001a\u00020\u00152%\u0010\u0018\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00192#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0011H\u0016JT\u0010#\u001a\u00020\u00152%\u0010\u0018\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00192#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/common_ui/edgeeffect/ScreenEdgeEffectGLView;", "Landroid/opengl/GLSurfaceView;", "Lcom/larus/common_ui/edgeeffect/IScreenEdgeEffectView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "renderer", "Lcom/larus/common_ui/edgeeffect/EdgeRenderer;", "eglManager", "Lcom/larus/common_ui/edgeeffect/EdgeEffectEGLManager;", "showAnimator", "Landroid/animation/ValueAnimator;", "hideAnimator", "isRenderingActive", "", "lastAlpha", "", "init", "", MapMonitorConst.EVENT_DESTROY, "showScreenEdgeEffect", "onEnd", "Lkotlin/Function1;", "Landroid/animation/Animator;", "Lkotlin/ParameterName;", "name", "animator", "onCancel", "setAudioAmplitude", "amplitude", "setDarkMode", "darkMode", "dismissScreenEdgeEffect", "pauseEdgeEffect", "resumeEdgeEffect", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenEdgeEffectGLView extends GLSurfaceView implements g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f327389e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f327390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f327391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f327392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f327393d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Animator, Unit> f327394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animator f327395b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Animator, Unit> r100, Animator r101) {
            this.f327394a = r100;
            this.f327395b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<Animator, Unit> r100 = this.f327394a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.invoke(this.f327395b);     // Catch: Throwable -> L6
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
        public final /* synthetic */ Function1<Animator, Unit> f327396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animator f327397b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Animator, Unit> r100, Animator r101) {
            this.f327396a = r100;
            this.f327397b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<Animator, Unit> r100 = this.f327396a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.invoke(this.f327397b);     // Catch: Throwable -> L6
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
        public final /* synthetic */ ScreenEdgeEffectGLView f327398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f327399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f327400c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            FLogger.f375446a.i("ScreenEdgeEffectGLView", "showScreenEdgeEffect onCancel");
            this.f327398a.post(new c(this.f327400c, r100));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            FLogger.f375446a.i("ScreenEdgeEffectGLView", "showScreenEdgeEffect onEnd");
            this.f327398a.post(new b(this.f327399b, r100));
        }

        public d(ScreenEdgeEffectGLView r100, Function1 r101, Function1 r102) {
            this.f327398a = r100;
            this.f327399b = r101;
            this.f327400c = r102;
        }
    }

    static {
    }

    @Override // d19.g
    public final void c() {
        if (this.f327393d == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ScreenEdgeEffectGLView", "pauseEdgeEffect");
        this.f327393d = false;
        setRenderMode(0);
    }

    @Override // d19.g
    public final void d() {
        if (this.f327393d == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ScreenEdgeEffectGLView", "resumeEdgeEffect");
        this.f327393d = true;
        setRenderMode(1);
    }

    @Override // d19.g
    public final void init() {
        f r100 = this.f327390a;
        r100.getClass();
        r100.f466453b = 0.0f;
        r100.f466455d = 0.0f;
        c();
    }

    @Override // d19.g
    public final void destroy() {
        c();
        ValueAnimator r100 = this.f327391b;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
    L5:
        ValueAnimator r101 = this.f327391b;
        if (r101 == null) goto L8;
        r101.removeAllListeners();
    L8:
        ValueAnimator r102 = this.f327392c;
        if (r102 == null) goto L11;
        r102.removeAllUpdateListeners();
    L11:
        ValueAnimator r103 = this.f327392c;
        if (r103 == null) goto L14;
        r103.removeAllListeners();
    L14:
        this.f327391b = null;
        this.f327392c = null;
        f r104 = this.f327390a;
        r104.f466453b = 0.0f;
        r104.f466455d = 0.0f;
    }

    public ScreenEdgeEffectGLView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // d19.g
    public void setAudioAmplitude(float r100) {
        this.f327390a.f466455d = r100;
    }

    @Override // d19.g
    public void setDarkMode(boolean r100) {
        f r101 = this.f327390a;
        r101.f466456e = r100 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [d19.a] */
    public ScreenEdgeEffectGLView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        f r102 = new f();
        this.f327390a = r102;
        final d19.b r103 = new d19.b(r100, this, r102);
        Object r104 = r103.f466442a.getSystemService("activity");
        ConfigurationInfo r105 = null;
        if ((r104 instanceof ActivityManager) == false) goto L5;
        ActivityManager r106 = (ActivityManager) r104;
    L6:
        if (r106 == null) goto L9;
        r105 = r106.getDeviceConfigurationInfo();
    L9:
        if (r105 != null) goto L11;
    L13:
        boolean r107 = false;
    L14:
        FLogger.f375446a.i("EdgeEffectEGLManager", "[setupEGL] supportsEs3: " + r107);
        if (r107 == false) goto L17;
        int r108 = 3;
    L18:
        r103.f466443b.setEGLContextFactory(new d19.b.c(r108, new d19.a(r103)));
        r103.f466443b.setEGLConfigChooser(new d19.b.C5617b(r108));
        r103.f466443b.getHolder().setFormat(-3);
        r103.f466443b.setZOrderOnTop(true);
        r103.f466443b.setRenderer(r103.f466444c);
        r103.f466443b.setRenderMode(0);
        Resources r109 = getResources();
        r102.f466454c = WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()).density;
        return;
    L17:
        r108 = 2;
        goto L18
    L11:
        if (r105.reqGlEsVersion < 196608) goto L13;
        r107 = true;
        goto L14
    L5:
        r106 = null;
        goto L6
    }

    @Override // d19.g
    public final void a(f2 r100, g2 r101) {
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{this.f327390a.f466453b, 0.0f});
        r102.setDuration(100);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new i(this));
        Intrinsics.checkNotNull(r102);
        r102.addListener(new l(this, r100, r101));
        r102.start();
        this.f327392c = r102;
    }

    @Override // d19.g
    public final void b(Function1<? super Animator, Unit> r100, Function1<? super Animator, Unit> r101) {
        d();
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{this.f327390a.f466453b, 1.0f});
        r102.setDuration(300);
        r102.setInterpolator(new DecelerateInterpolator());
        r102.addUpdateListener(new h(this));
        Intrinsics.checkNotNull(r102);
        r102.addListener(new d(this, r100, r101));
        r102.start();
        this.f327391b = r102;
    }
}
