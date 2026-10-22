package com.lynx.animax;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.ability.Event;
import com.lynx.animax.base.AnimaXError;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.loader.AnimaXResourceLoaderHolder;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.AnimaXKeyPathListCallback;
import com.lynx.animax.property.AnimaXPropertyCallback;
import com.lynx.animax.property.AnimaXValueCallback;
import com.lynx.animax.property.AnimaXValueParam;
import com.lynx.animax.property.LayerPropertyType;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.ui.AnimaXContext;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.AnimaXMetricsCallback;
import com.lynx.lottieadapter.LottieAdapterAnimaX;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXPlayer implements x4a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f380203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseAbility f380204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnimaXContext f380205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimaXResourceLoaderHolder f380206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f380208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f380211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f380212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AnimaXComposition f380213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f380214l;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f380215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f380216b;

        public final void a() {
            if (this.f380215a != 0) goto L5;
            return;
        L5:
            if (this.f380216b == true) goto L10;
            AnimaXLog.b("AnimaXPlayer", "Call nativeDestroy.");
            AnimaXPlayer.n(this.f380215a);
            this.f380216b = true;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f380215a != 0) goto L6;
            return;
        L6:
            if (this.f380216b == true) goto L8;
            a();     // Catch: Throwable -> L10
        L8:
            AnimaXPlayer.m(this.f380215a);     // Catch: Throwable -> L10
            this.f380215a = 0;     // Catch: Throwable -> L10
        }

        public a(long r100) {
            this.f380216b = false;
            this.f380215a = r100;
        }
    }

    private native void nativeAddLayerPropertyCallback(long r100, int r101, AnimaXKeyPath r102, AnimaXValueCallback r103, AnimaXPropertyCallback r104);

    private native void nativeCancel(long r100);

    private native long nativeCreate(long r100, AnimaXContext r101);

    private native void nativeCreateAnimaXSurface(long r100, AnimaXSurfaceDrawable r101);

    private static native void nativeDeletePtr(long r100);

    private static native void nativeDestroy(long r100);

    private native double nativeGetCurrentFrame(long r100);

    private native double nativeGetDurationMs(long r100);

    private native ReadableMap nativeGetEventTrackingMap(long r100);

    private native void nativeGetKeysForKeyPath(long r100, AnimaXKeyPath r101, AnimaXKeyPathListCallback r102);

    private native long nativeGetMemoryUsageBytes(long r100);

    private native void nativeGetMetricsAsync(long r100, AnimaXMetricsCallback r101);

    private native boolean nativeIsAnimating(long r100);

    private native void nativeOnHide(long r100, long r101);

    private native void nativeOnShow(long r100, long r101);

    private native void nativeOnTap(long r100, float r101, float r102);

    private native void nativePause(long r100);

    private native void nativePlay(long r100);

    private native void nativePlaySegment(long r100, int r101, int r102);

    private native void nativeReload(long r100);

    private native void nativeResume(long r100);

    private native void nativeSeek(long r100, int r101);

    private native void nativeSetAutoPlay(long r100, boolean r101);

    private native void nativeSetAutoReverse(long r100, boolean r101);

    private native void nativeSetComposition(long r100, long r101);

    private native void nativeSetDynamicResource(long r100, boolean r101);

    private native void nativeSetEnableAudio(long r100, boolean r101);

    private native void nativeSetEndFrame(long r100, int r101);

    private native void nativeSetFpsEventInterval(long r100, long r101);

    private native void nativeSetImageFolder(long r100, String r101);

    private native void nativeSetJson(long r100, String r101);

    private native void nativeSetKeepLastFrame(long r100, boolean r101);

    private native void nativeSetLoop(long r100, boolean r101);

    private native void nativeSetLoopCount(long r100, int r101);

    private native void nativeSetMaxFrameRate(long r100, double r101);

    private native void nativeSetMuted(long r100, boolean r101);

    private native void nativeSetObjectFit(long r100, int r101);

    private native void nativeSetObjectPosition(long r100, int r101);

    private native void nativeSetProgress(long r100, float r101);

    private native void nativeSetResourceProperty(long r100, int r101, String r102, AnimaXValueParam r103, AnimaXPropertyCallback r104);

    private native void nativeSetSpeed(long r100, float r101);

    private native void nativeSetSrc(long r100, String r101);

    private native void nativeSetSrcPolyfill(long r100, JavaOnlyMap r101);

    private native void nativeSetStartFrame(long r100, int r101);

    private native void nativeStop(long r100);

    private native void nativeSubscribeUpdateEvent(long r100, int r101);

    private native void nativeSubscribeUpdateEvents(long r100, int[] r101, boolean r102);

    private native void nativeUnsubscribeUpdateEvent(long r100, int r101);

    private native void nativeUpdateAnimaXSurface(long r100, AnimaXSurfaceDrawable r101);

    private native void nativeUpdateLayerProperty(long r100, int r101, AnimaXKeyPath r102, AnimaXValueParam r103, AnimaXPropertyCallback r104);

    public final boolean o() {
        boolean r100 = false;
        if (this.f380208f == false) goto L6;
        return false;
    L6:
        if (this.f380203a == 0) goto L8;
        r100 = true;
    L8:
        if (r100 == true) goto L10;
        AnimaXLog.a("AnimaXPlayer", "checkNativeReady failed, ptr is 0");
    L10:
        return r100;
    }

    @Override // x4a.d
    public final void cancel() {
        if (o() == true) goto L5;
        return;
    L5:
        nativeCancel(this.f380203a);
    }

    @Override // x4a.d
    public final double getCurrentFrame() {
        if (o() == true) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return nativeGetCurrentFrame(this.f380203a);
    }

    @Override // x4a.d
    public final double getDurationMs() {
        if (o() == true) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return nativeGetDurationMs(this.f380203a);
    }

    @Override // x4a.d
    public final boolean isAnimating() {
        if (o() == true) goto L7;
        return false;
    L7:
        return nativeIsAnimating(this.f380203a);
    }

    @Override // x4a.d
    public final void pause() {
        if (o() == true) goto L5;
        return;
    L5:
        nativePause(this.f380203a);
    }

    @Override // x4a.d
    public final void play() {
        if (o() == true) goto L5;
        return;
    L5:
        this.f380204b.f380241e.f(true);
        nativePlay(this.f380203a);
    }

    public final long q() {
        if (o() == true) goto L7;
        return 0;
    L7:
        return nativeGetMemoryUsageBytes(this.f380203a);
    }

    @Override // x4a.d
    public final void resume() {
        if (o() == true) goto L5;
        return;
    L5:
        this.f380204b.f380241e.f(true);
        nativeResume(this.f380203a);
    }

    public final void s() {
        if (o() == true) goto L5;
        return;
    L5:
        BaseAbility r100 = this.f380204b;
        v4a.d r101 = r100.f380241e;
        Map<String, Object> r102 = r101.f553157d;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put("stay_duration", Long.valueOf(System.currentTimeMillis() - r101.f553161h));
        r101.h("onRelease");
        ((ConcurrentHashMap) r100.f380239c.f558279a).clear();
        ((CopyOnWriteArrayList) r100.f380237a).clear();
        a r104 = this.f380212j;
        if (r104 == null) goto L8;
        r104.a();
        this.f380212j = null;
    L8:
        AnimaXResourceLoaderHolder r105 = this.f380206d;
        if (r105 == null) goto L15;
        ((ArrayList) r105.f380313b).clear();
        q4a.a r106 = r105.f380314c;
        if (r106.f531715a == true) goto L13;
        r106.b(q4a.a.f531713f);
    L14:
        r105.f380312a = 0;
        this.f380206d = null;
        goto L15
    L13:
        r106.a(2);
    L15:
        this.f380208f = true;
        this.f380203a = 0;
        AnimaXLog.b("AnimaXPlayer", "AnimaXPlayer destroyed");
    }

    public final void t() {
        if (o() == true) goto L5;
        return;
    L5:
        nativeReload(this.f380203a);
    }

    public final void v() {
        if (o() == true) goto L5;
        return;
    L5:
        nativeStop(this.f380203a);
    }

    @Override // x4a.d
    public final AnimaXComposition getComposition() {
        return this.f380213k;
    }

    public AnimaXPlayer(AnimaXContext r110) {
        boolean r100 = false;
        this.f380207e = false;
        this.f380208f = false;
        this.f380209g = false;
        this.f380210h = false;
        this.f380211i = false;
        this.f380212j = null;
        this.f380214l = 0;
        AnimaXLog.b("AnimaXPlayer", "create AnimaXPlayer: " + this);
        this.f380205c = r110;
        BaseAbility r101 = r110.getAbility();
        this.f380204b = r101;
        v4a.d r102 = r101.f380241e;
        r102.getClass();
        r102.f553155b = new WeakReference(this);
        ((CopyOnWriteArrayList) r101.f380237a).add(r101.f380241e);
        if ((!y4a.a.d("ANIMAX_MODEL_BLOCK_LIST_ANDROID", r101)) == true) goto L10;
        o4a.a r103 = new o4a.a(r101, Event.ERROR.ordinal(), AnimaXError.createBlockErrorParam());
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L7;
        r100 = true;
    L7:
        if (r100 == false) goto L9;
        r103.run();
        return;
    L9:
        y4a.d.a().post(r103);
        return;
    L10:
        Context r104 = r110.getContext();
        if (r104 != null) goto L14;
        AnimaXLog.a("AnimaXPlayer", "init fail, context is null");
        return;
    L14:
        if (AnimaX.e().f380464a == true) goto L17;
        AnimaX r105 = AnimaX.e();
        r105.g(null);
        r105.d(null);
    L17:
        if (AnimaX.e().f380464a == true) goto L24;
        AnimaXLog.a("AnimaXPlayer", "AnimaX.inst().init() fail again.");
        o4a.a r106 = new o4a.a(r101, Event.ERROR.ordinal(), AnimaXError.createLibraryInitErrorParam());
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L21;
        r100 = true;
    L21:
        if (r100 == false) goto L23;
        r106.run();
        return;
    L23:
        y4a.d.a().post(r106);
        return;
    L24:
        AnimaX.e().g(r104.getApplicationContext());
        AnimaXResourceLoaderHolder r107 = new AnimaXResourceLoaderHolder((w4a.b) r101.f380239c.a(w4a.b.class));
        this.f380206d = r107;
        this.f380203a = nativeCreate(r107.f380312a, r110);
        this.f380212j = new a(this.f380203a);
        new q4a.a(this, this.f380212j);
        if (this.f380203a == 0) goto L27;
        boolean r108 = true;
    L28:
        if (r108 == true) goto L30;
        AnimaXLog.a("AnimaXPlayer", "init fail");
        return;
    L30:
        Context r111 = r110.getContext();
        if (r111 != null) goto L34;
        return;
    L34:
        if (Build.VERSION.SDK_INT >= 26) goto L36;
    L39:
        boolean r109 = true;
    L40:
        if (r109 == false) goto L43;
        AnimaXLog.b("AnimaXPlayer", "Limit frame rate to 30.");
        setMaxFrameRate(30.0d);
    L43:
        if (y4a.a.f566161b >= 0) goto L49;
        y4a.a.f566161b = ((ActivityManager) r111.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        AnimaXLog.a("DeviceUtil", "isES3Supported fail, message" + th.getMessage());
    L49:
        if (y4a.a.f566161b < 196608) goto L51;
        boolean r112 = true;
    L52:
        if (r112 == true) goto L54;
    L55:
        r100 = true;
    L56:
        if (r100 == false) goto L67;
        AnimaXLog.b("AnimaXPlayer", "useSoftwareRender");
        this.f380210h = true;
        return;
    L67:
        return;
    L54:
        if (y4a.a.d("ANIMAX_MODEL_SOFTWARE_LIST_ANDROID", r101) == false) goto L56;
    L51:
        r112 = false;
        goto L52
    L36:
        if (y4a.a.c() == true) goto L39;
        r109 = false;
        goto L40
    L27:
        r108 = false;
        goto L28
    }

    public static /* synthetic */ void m(long r100) {
        nativeDeletePtr(r100);
    }

    public static /* synthetic */ void n(long r100) {
        nativeDestroy(r100);
    }

    @Override // x4a.d
    public final void a(int r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSeek(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void c(LottieAdapterAnimaX.w r100) {
        ((CopyOnWriteArrayList) this.f380204b.f380237a).add(r100);
    }

    @Override // x4a.d
    public final void d(ObjectPosition r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetObjectPosition(this.f380203a, r100.ordinal());
    }

    @Override // x4a.d
    public final void e(boolean r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetKeepLastFrame(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void f(AnimaXMetricsCallback r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeGetMetricsAsync(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void j(long r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetFpsEventInterval(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void k(boolean r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetDynamicResource(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void l(boolean r100) {
        this.f380209g = r100;
    }

    public final void p(AnimaXSurfaceDrawable r100) {
        if (o() == true) goto L5;
        return;
    L5:
        r100.f380267g = this.f380209g;
        r100.f380268h = this.f380210h;
        String r101 = y4a.a.f566160a;
        r100.f380270j = false;
        r100.f380269i = this.f380211i;
        nativeCreateAnimaXSurface(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setAutoPlay(boolean r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetAutoPlay(this.f380203a, r100);
        this.f380207e = r100;
    }

    @Override // x4a.d
    public final void setAutoReverse(boolean r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetAutoReverse(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setComposition(AnimaXComposition r100) {
        this.f380213k = r100;
        if (o() == true) goto L5;
        return;
    L5:
        long r101 = this.f380203a;
        long r102 = 0;
        if (r100.f380258a != 0) goto L8;
        AnimaXLog.a("AnimaXComposition", "checkNativeReady failed, nativePtr is 0");
        boolean r103 = false;
    L9:
        if (r103 == false) goto L12;
        r102 = r100.f380258a;
    L12:
        nativeSetComposition(r101, r102);
        return;
    L8:
        r103 = true;
        goto L9
    }

    @Override // x4a.d
    public final void setEnableAudio(boolean r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetEnableAudio(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setEndFrame(int r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetEndFrame(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setImageFolder(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return;
    L7:
        if (o() == true) goto L9;
        return;
    L9:
        nativeSetImageFolder(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setJson(String r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetJson(this.f380203a, r100);
        IAnimaXMonitorService r101 = (IAnimaXMonitorService) this.f380204b.f380241e.f553154a.a(IAnimaXMonitorService.class);
        if (r101 == null) goto L9;
        r101.setCurrentUrl("json");
        return;
    }

    @Override // x4a.d
    public final void setLoop(boolean r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetLoop(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setLoopCount(int r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetLoopCount(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setMaxFrameRate(double r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetMaxFrameRate(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setMuted(boolean r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetMuted(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setObjectFit(ObjectFit r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetObjectFit(this.f380203a, r100.ordinal());
    }

    @Override // x4a.d
    public final void setProgress(float r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetProgress(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setSpeed(float r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetSpeed(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void setSrc(String r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetSrc(this.f380203a, r100);
        IAnimaXMonitorService r101 = (IAnimaXMonitorService) this.f380204b.f380241e.f553154a.a(IAnimaXMonitorService.class);
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        r101.setCurrentUrl(r100);
        return;
    L11:
        return;
    }

    @Override // x4a.d
    public final void setStartFrame(int r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetStartFrame(this.f380203a, r100);
    }

    public final void u(JavaOnlyMap r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetSrcPolyfill(this.f380203a, r100);
    }

    public final void w(int r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSubscribeUpdateEvent(this.f380203a, r100);
    }

    public final void x(int r100) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeUnsubscribeUpdateEvent(this.f380203a, r100);
    }

    public final void y(AnimaXSurfaceDrawable r100) {
        if (o() == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        r100.f380267g = this.f380209g;
        r100.f380268h = this.f380210h;
        String r101 = y4a.a.f566160a;
        r100.f380270j = false;
        r100.f380269i = this.f380211i;
    L7:
        nativeUpdateAnimaXSurface(this.f380203a, r100);
    }

    @Override // x4a.d
    public final void b(int[] r100, boolean r101) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSubscribeUpdateEvents(this.f380203a, r100, r101);
    }

    @Override // x4a.d
    public final void g(AnimaXKeyPath r100, LottieAdapterAnimaX.a r101) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeGetKeysForKeyPath(this.f380203a, r100, r101);
    }

    @Override // x4a.d
    public final void h(float r100, float r101) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeOnTap(this.f380203a, r100, r101);
    }

    public final void r(int r100, int r101) {
        if (o() == true) goto L5;
        return;
    L5:
        this.f380204b.f380241e.f(true);
        nativePlaySegment(this.f380203a, r100, r101);
    }

    public final void z(boolean r100, VisibilityState r101) {
        boolean r102 = false;
        if ((this.f380214l & r101.getValue()) != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r100 == r103) goto L9;
        this.f380214l ^= r101.getValue();
        r102 = true;
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        if (r100 == false) goto L17;
        if (o() == false) goto L22;
        nativeOnShow(this.f380203a, r101.getValue());
        return;
    L22:
        return;
    L17:
        if (o() == false) goto L23;
        nativeOnHide(this.f380203a, r101.getValue());
        return;
    L23:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // x4a.d
    public final void i(LayerPropertyType r100, AnimaXKeyPath r110, LottieAdapterAnimaX.b.a r111, LottieAdapterAnimaX.b.C4559b r112) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeAddLayerPropertyCallback(this.f380203a, r100.getValue(), r110, r111, r112);
    }
}
