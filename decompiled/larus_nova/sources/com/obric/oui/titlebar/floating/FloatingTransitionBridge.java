package com.obric.oui.titlebar.floating;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.SystemClock;
import android.view.IFloatingTransitionCallback;
import android.view.IFloatingTransitionSession;
import android.view.IFloatingTransitionStateProvider;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class FloatingTransitionBridge {
    public static final Map<IBinder, FloatingTransitionBridge> H = null;
    public boolean A;
    public volatile boolean B;
    public volatile boolean C;
    public final List<OFloatingTitleBarActionHost> D;
    public Runnable E;
    public final IFloatingTransitionCallback.Stub F;
    public final IFloatingTransitionStateProvider.Stub G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OFloatingTitleBar f403538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f403539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IBinder f403540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f403541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Function0<Unit>> f403542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OFloatingTitleBarActionHost f403543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f403544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Method f403545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Method f403546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Class<?> f403547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Method f403548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Method f403549l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Method f403550m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Method f403551n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Method f403552o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f403553p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bundle f403554q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f403555r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f403556s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f403557t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f403558u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f403559v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f403560w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OFloatingTitleBarActionHost f403561x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f403562y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function0<Unit> f403563z;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J&\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$TransitionCallback;", "Landroid/view/IFloatingTransitionCallback$Stub;", "bridge", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;", "(Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;)V", "bridgeRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onHideTitleBar", "", "sourceSurface", "Landroid/view/SurfaceControl;", "sourceState", "Landroid/os/Bundle;", "onTransitionCancelled", "", "onTransitionFinished", "onTransitionStart", "transitionSurface", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TransitionCallback extends IFloatingTransitionCallback.Stub {
        private final WeakReference<FloatingTransitionBridge> bridgeRef;

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionCancelled() {
            final FloatingTransitionBridge r100 = this.bridgeRef.get();
            if (r100 == null) goto L14;
            Map<IBinder, FloatingTransitionBridge> r101 = FloatingTransitionBridge.H;
            if (o.c() == false) goto L15;
            final Function0<Unit> r102 = new FloatingTransitionBridge$onCallbackTransitionCancelled$cleanup$1(r100);
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
            r102.invoke();
            return;
        L11:
            r100.f403538a.post(new com.obric.oui.titlebar.floating.c(r102));
            return;
        L15:
            return;
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionFinished() {
            final FloatingTransitionBridge r100 = this.bridgeRef.get();
            if (r100 == null) goto L14;
            Map<IBinder, FloatingTransitionBridge> r101 = FloatingTransitionBridge.H;
            if (o.c() == false) goto L15;
            final Function0<Unit> r102 = new FloatingTransitionBridge$onCallbackTransitionFinished$finish$1(r100);
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
            r102.invoke();
            return;
        L11:
            r100.f403538a.post(new j(r102));
            return;
        L15:
            return;
        }

        public TransitionCallback(FloatingTransitionBridge r100) {
            Intrinsics.checkNotNullParameter(r100, "bridge");
            this.bridgeRef = new WeakReference(r100);
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onHideTitleBar(final SurfaceControl r100, final Bundle r110) {
            final FloatingTransitionBridge r101 = this.bridgeRef.get();
            boolean r102 = false;
            if (r101 == null) goto L33;
            Map<IBinder, FloatingTransitionBridge> r103 = FloatingTransitionBridge.H;
            if (o.c() == true) goto L9;
            return false;
        L9:
            if (r100 == null) goto L17;
            if (r110 == null) goto L17;
            SystemClock.uptimeMillis();
            final AtomicReference r104 = new AtomicReference();
            if (r101.E("sourceHideDraw", false, new FloatingTransitionBridge$handleSourceHideTitleBarSync$scheduled$1(r110, r101, r100, r104)) == true) goto L14;
        L16:
            SystemClock.uptimeMillis();
            return r102;
        L14:
            if (FloatingTransitionBridge.M((CountDownLatch) r104.get()) == false) goto L16;
            r102 = true;
        L17:
            final Function0<Boolean> r111 = new FloatingTransitionBridge$onCallbackHideTitleBar$result$1(r101);
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L32;
            final CountDownLatch r105 = new CountDownLatch(1);
            final AtomicBoolean r106 = new AtomicBoolean(true);
            Boolean r107 = Boolean.FALSE;
            final AtomicReference r108 = new AtomicReference(r107);
            r101.f403538a.post(new f(r106, r105, r108, r111));
        L27:
            r106.set(false);
            ThreadMethodProxy.currentThread().interrupt();
            Intrinsics.stringPlus("floating source hide wait interrupted reason=", "hideOnly");
            return false;
        L22:
            if (r105.await(240, TimeUnit.MILLISECONDS) == false) goto L24;
            r107 = (Boolean) r108.get();     // Catch: InterruptedException -> L27
        L25:
            return r107.booleanValue();
        L24:
            r106.set(false);     // Catch: InterruptedException -> L27
            Intrinsics.stringPlus("floating source hide wait timeout reason=", "hideOnly");     // Catch: InterruptedException -> L27
            goto L25
        L32:
            return r111.invoke().booleanValue();
        L33:
            return false;
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onTransitionStart(final SurfaceControl r110, final SurfaceControl r111, final Bundle r112) {
            final FloatingTransitionBridge r100 = this.bridgeRef.get();
            boolean r101 = false;
            if (r100 == null) goto L23;
            Map<IBinder, FloatingTransitionBridge> r102 = FloatingTransitionBridge.H;
            if (o.c() == false) goto L23;
            if (r112 == null) goto L12;
            FloatingTransitionBridge.J(r112);
        L12:
            if (r110 == null) goto L23;
            if (r112 == null) goto L23;
            r100.C = true;
            r100.B = true;
            SystemClock.uptimeMillis();
            final AtomicReference r103 = new AtomicReference();
            boolean r113 = r100.E("transitionStart", true, new FloatingTransitionBridge$handleTransitionStartSync$scheduled$1(r100, r110, r111, r112, r103));
            if (r113 == true) goto L18;
            r100.C = false;
            r100.B = false;
        L18:
            if (r113 == true) goto L20;
        L22:
            SystemClock.uptimeMillis();
            goto L23
        L20:
            if (FloatingTransitionBridge.M((CountDownLatch) r103.get()) == false) goto L22;
            r101 = true;
        L23:
            return r101;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$TransitionStateProvider;", "Landroid/view/IFloatingTransitionStateProvider$Stub;", "bridge", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;", "(Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;)V", "bridgeRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "captureFloatingTransitionState", "Landroid/os/Bundle;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TransitionStateProvider extends IFloatingTransitionStateProvider.Stub {
        private final WeakReference<FloatingTransitionBridge> bridgeRef;

        @Override // android.view.IFloatingTransitionStateProvider
        public Bundle captureFloatingTransitionState() {
            final FloatingTransitionBridge r100 = this.bridgeRef.get();
            if (r100 != null) goto L5;
            Bundle r101 = null;
        L26:
            if (r101 == null) goto L28;
            return r101;
        L28:
            return new Bundle();
        L5:
            Map<IBinder, FloatingTransitionBridge> r102 = FloatingTransitionBridge.H;
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
            r101 = r100.h();
            goto L26
        L8:
            SystemClock.uptimeMillis();
            final AtomicReference r103 = new AtomicReference();
            final CountDownLatch r104 = new CountDownLatch(1);
            r100.f403538a.post(new h(r103, r100, r104));
        L22:
            ThreadMethodProxy.currentThread().interrupt();
            r101 = r100.f403554q;
            if (r101 != null) goto L25;
            r101 = new Bundle();
        L25:
            SystemClock.uptimeMillis();
            FloatingTransitionBridge.J(r101);
            goto L26
        L10:
            if (r104.await(240, TimeUnit.MILLISECONDS) == false) goto L17;
            Bundle r105 = (Bundle) r103.get();     // Catch: InterruptedException -> L22
            if (r105 != null) goto L16;
            r105 = r100.f403554q;     // Catch: InterruptedException -> L22
            if (r105 != null) goto L16;
            r105 = new Bundle();     // Catch: InterruptedException -> L22
        L16:
            r101 = r105;
            goto L26
        L17:
            r105 = r100.f403554q;     // Catch: InterruptedException -> L22
            if (r105 != null) goto L20;
            r105 = new Bundle();     // Catch: InterruptedException -> L22
        L20:
            SystemClock.uptimeMillis();     // Catch: InterruptedException -> L22
            FloatingTransitionBridge.J(r105);     // Catch: InterruptedException -> L22
            goto L16
        }

        public TransitionStateProvider(FloatingTransitionBridge r100) {
            Intrinsics.checkNotNullParameter(r100, "bridge");
            this.bridgeRef = new WeakReference(r100);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f403564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OFloatingTitleBarActionHost f403565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f403566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SurfaceControl f403567d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f403564a, r101.f403564a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f403565b, r101.f403565b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f403566c, r101.f403566c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f403567d, r101.f403567d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f403564a.hashCode() * 31) + this.f403565b.hashCode()) * 31) + this.f403566c.hashCode()) * 31) + this.f403567d.hashCode();
        }

        public final String toString() {
            return "ActiveOverlay(decor=" + this.f403564a + ", host=" + this.f403565b + ", renderTarget=" + this.f403566c + ", overlaySurface=" + this.f403567d + ')';
        }

        public a(ViewGroup r100, OFloatingTitleBarActionHost r101, d r102, SurfaceControl r103) {
            Intrinsics.checkNotNullParameter(r100, "decor");
            Intrinsics.checkNotNullParameter(r101, "host");
            Intrinsics.checkNotNullParameter(r102, "renderTarget");
            Intrinsics.checkNotNullParameter(r103, "overlaySurface");
            this.f403564a = r100;
            this.f403565b = r101;
            this.f403566c = r102;
            this.f403567d = r103;
        }
    }

    public static final class b {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("android.view.WindowManagerGlobal");
        }

        @JvmStatic
        public static void b() {
            if (o.c() == true) goto L5;
            return;
        L5:
            IFloatingTransitionSession r100 = c();
            if (r100 != null) goto L14;
            return;
        L14:
            r100.notifyFloatingTransitionLaunch(null);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            Intrinsics.stringPlus("floating cancel launch failed: ", th.getMessage());
        }

        public static IFloatingTransitionSession c() {
            if (o.c() == true) goto L19;
            return null;
        L19:
            Object r100 = a().getMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L16
            Object r101 = r100.getClass().getMethod("getFloatingTransitionService", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L16
            if ((r101 instanceof IBinder) == false) goto L9;
            IBinder r102 = (IBinder) r101;     // Catch: Throwable -> L16
        L12:
            if (r102 != null) goto L14;
            return null;
        L14:
            return IFloatingTransitionSession.Stub.asInterface(r102);
        L9:
            if ((r101 instanceof IInterface) == false) goto L11;
            r102 = ((IInterface) r101).asBinder();     // Catch: Throwable -> L16
            goto L12
        L11:
            r102 = null;
        L16:
            th = move-exception;
            Intrinsics.stringPlus("floating service unavailable: ", th.getMessage());
            return null;
        }
    }

    public interface c {
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SurfaceControl f403568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Surface f403569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f403570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.obric.oui.titlebar.k f403571d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.obric.oui.titlebar.k f403572e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f403573f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f403574g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ FloatingTransitionBridge f403575h;

        public final boolean a() {
            if (this.f403574g == false) goto L5;
        L9:
            return false;
        L5:
            if (this.f403569b.isValid() == false) goto L9;
            if (this.f403568a.isValid() == false) goto L9;
            return true;
        }

        public final void b(boolean r100) {
            if (this.f403574g == false) goto L5;
            return;
        L5:
            this.f403574g = true;
            this.f403569b.release();     // Catch: Throwable -> L8
        L31:
            Method r101 = this.f403575h.f403551n;     // Catch: Throwable -> L15
            if (r101 != null) goto L13;
            r101 = this.f403570c.getClass().getDeclaredMethod(MapMonitorConst.EVENT_DESTROY, new Class[0]);     // Catch: Throwable -> L15
            FloatingTransitionBridge r102 = this.f403575h;     // Catch: Throwable -> L15
            r101.setAccessible(true);     // Catch: Throwable -> L15
            r102.f403551n = r101;     // Catch: Throwable -> L15
        L13:
            r101.invoke(this.f403570c, new Object[0]);     // Catch: Throwable -> L15
        L17:
            if (r100 == false) goto L29;
            SurfaceControl.Transaction r103 = new SurfaceControl.Transaction();     // Catch: Throwable -> L20
            FloatingTransitionBridge r104 = this.f403575h;     // Catch: Throwable -> L20
            SurfaceControl r105 = this.f403568a;     // Catch: Throwable -> L20
            Map<IBinder, FloatingTransitionBridge> r106 = FloatingTransitionBridge.H;     // Catch: Throwable -> L20
            r104.getClass();     // Catch: Throwable -> L20
            FloatingTransitionBridge.A(r103, r105);     // Catch: Throwable -> L20
            r103.apply();     // Catch: Throwable -> L20
            r103.close();     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            Intrinsics.stringPlus("remove render content surface failed: ", th.getMessage());
        L29:
            this.f403568a.release();     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            Intrinsics.stringPlus("release render content surface failed: ", th.getMessage());
            return;
        L15:
            th = move-exception;
            Intrinsics.stringPlus("destroy render bbq failed: ", th.getMessage());
        L8:
            th = move-exception;
            Intrinsics.stringPlus("release render surface failed: ", th.getMessage());
            goto L31
        }

        public final float c(OFloatingTitleBarActionHost r100) {
            Intrinsics.checkNotNullParameter(r100, "host");
            com.obric.oui.titlebar.k r101 = this.f403572e;
            if (r101 == null) goto L5;
            int r102 = this.f403571d.f403622b.f403661e;
            float r103 = r101.f403622b.f403661e;
            float r104 = r100.c();
            float r105 = FloatingTransitionBridge.c(this.f403575h, this.f403571d);
            float r106 = FloatingTransitionBridge.c(this.f403575h, r101);
            float r107 = r105 - r101.f403621a.f403656d;
            float r108 = 0.0f;
            if (this.f403573f == false) goto L14;
            float r109 = r103 - r107;
            if (Math.abs(r109) <= 0.5f) goto L12;
            r108 = RangesKt.coerceIn((r104 - r107) / r109, 0.0f, 1.0f);
            goto L14
        L12:
            r108 = 1.0f;
        L14:
            return (r105 + ((r106 - r105) * r108)) - r104;
        L5:
            return this.f403571d.f403621a.f403656d;
        }

        public d(FloatingTransitionBridge r100, SurfaceControl r101, SurfaceControl r102, Surface r103, Object r104, com.obric.oui.titlebar.k r105, com.obric.oui.titlebar.k r106) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            Intrinsics.checkNotNullParameter(r101, "parentSurface");
            Intrinsics.checkNotNullParameter(r102, "contentSurface");
            Intrinsics.checkNotNullParameter(r103, "surface");
            Intrinsics.checkNotNullParameter(r104, "blastBufferQueue");
            Intrinsics.checkNotNullParameter(r105, "sourceState");
            this.f403575h = r100;
            this.f403568a = r102;
            this.f403569b = r103;
            this.f403570c = r104;
            this.f403571d = r105;
            this.f403572e = r106;
            int r107 = r105.f403621a.f403656d;
        }
    }

    public static final class e implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OFloatingTitleBarActionHost f403576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f403577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FloatingTransitionBridge f403578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f403579d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.obric.oui.titlebar.k f403580e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f403581f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f403582g;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ViewTreeObserver r100 = this.f403576a.getViewTreeObserver();
            if (r100.isAlive() == false) goto L5;
            r100.removeOnPreDrawListener(this);
        L5:
            ViewTreeObserver r101 = this.f403577b;
            if (r101 != r100) goto L8;
        L10:
            Ref.BooleanRef r102 = this.f403581f;
            Function1<Boolean, Unit> r103 = this.f403582g;
            FloatingTransitionBridge r104 = this.f403578c;
            d r105 = this.f403579d;
            OFloatingTitleBarActionHost r106 = this.f403576a;
            com.obric.oui.titlebar.k r107 = this.f403580e;
            a r108 = r104.f403553p;
            boolean r109 = false;
            if (r108 == null) goto L15;
            if (r108.f403566c == r105) goto L15;
        L28:
            if (r102.element == true) goto L31;
            r102.element = true;
            r103.invoke(Boolean.valueOf(r109));
        L31:
            return true;
        L15:
            if (r105.a() == false) goto L28;
            r104.u(r106, r107);
            if (FloatingTransitionBridge.o(r106, 1.0f) != null) goto L28;
            if (r105.f403569b.isValid() == true) goto L23;
        L25:
            if (r109 == true) goto L28;
            r105.f403569b.isValid();
            goto L28
        L23:
            if (r104.m(r105) == false) goto L25;
            r109 = true;
            goto L25
        L8:
            if (r101.isAlive() == false) goto L10;
            this.f403577b.removeOnPreDrawListener(this);
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(OFloatingTitleBarActionHost r100, ViewTreeObserver r101, FloatingTransitionBridge r102, d r103, String r104, com.obric.oui.titlebar.k r105, Ref.BooleanRef r106, Function1<? super Boolean, Unit> r107) {
            this.f403576a = r100;
            this.f403577b = r101;
            this.f403578c = r102;
            this.f403579d = r103;
            this.f403580e = r105;
            this.f403581f = r106;
            this.f403582g = r107;
        }
    }

    static {
        H = new LinkedHashMap();
    }

    public final void D() {
        if (((ArrayList) this.D).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r100 = CollectionsKt.toList(this.D).iterator();
    L7:
        if (r100.hasNext() == false) goto L15;
        OFloatingTitleBarActionHost r101 = (OFloatingTitleBarActionHost) r100.next();
        r101.getClass();
        if (o.c() == false) goto L7;
        if (r101.f403448b == false) goto L7;
        r101.f403448b = false;
        OFloatingTitleBar r102 = r101.f403450d;
        Token$Bounce r103 = OFloatingTitleBar.H0;
        r102.O(true, true);
        r101.getVisibility();
        goto L7
    L15:
        ((ArrayList) this.D).clear();
    }

    public final void g() {
        Runnable r100 = this.E;
        if (r100 == null) goto L6;
        this.f403538a.removeCallbacks(r100);
    L6:
        this.E = null;
    }

    public final Bundle h() {
        OFloatingTitleBarActionHost r100 = this.f403543f;
        if (this.f403555r == false) goto L47;
        if (r100 == null) goto L47;
        boolean r101 = true;
        this.f403558u = true;
        Integer r102 = null;
        this.f403563z = null;
        this.f403562y = true;
        OFloatingTitleBar r103 = r100.f403450d;
        com.obric.oui.titlebar.k r104 = r103.s();
        OButtonGroup.b r110 = r103.getStartButtonGroup().a0();
        OButtonGroup.b r111 = r103.getCenterButtonGroup().a0();
        OButtonGroup.b r112 = r103.getEndSubButtonGroup().a0();
        OButtonGroup.b r113 = r103.getEndButtonGroup().a0();
        float r114 = r103.getEndSubButtonGroup().getTranslationX();
        Integer r115 = r103.E;
        FrameLayout r105 = r103.f403406f;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r105 = null;
    L8:
        com.obric.oui.titlebar.k r106 = com.obric.oui.titlebar.k.a(r104, null, null, null, null, new com.obric.oui.titlebar.k.d(r110, r111, r112, r113, r114, r115, r105.getTranslationX()), 47);
        int r116 = MathKt.roundToInt(r100.c());
        com.obric.oui.titlebar.k.e r107 = r106.f403621a;
        Integer r108 = Integer.valueOf(r100.getWidth());
        if (r108.intValue() <= 0) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == true) goto L15;
        r108 = null;
    L15:
        if (r108 != null) goto L17;
        int r117 = this.f403538a.getWidth();
    L18:
        Integer r118 = Integer.valueOf(r100.getHeight());
        if (r118.intValue() > 0) goto L22;
        r101 = false;
    L22:
        if (r101 == true) goto L25;
        r118 = null;
    L25:
        if (r118 != null) goto L27;
        int r119 = this.f403538a.getHeight();
    L28:
        a r120 = this.f403553p;
        if (r120 == null) goto L35;
        d r121 = r120.f403566c;
        if (r121 == null) goto L35;
        r102 = Integer.valueOf(MathKt.roundToInt(r121.c(r100)));
    L35:
        if (r102 != null) goto L37;
        int r122 = r106.f403621a.f403656d;
    L38:
        com.obric.oui.titlebar.k.e r123 = new com.obric.oui.titlebar.k.e(r117, r119, r107.f403655c, r122);
        com.obric.oui.titlebar.k.g r124 = r106.f403622b;
        Bundle r125 = com.obric.oui.titlebar.k.a(r106, r123, new com.obric.oui.titlebar.k.g(r124.f403657a, r124.f403658b, r124.f403659c, r124.f403660d, r116), null, null, null, 60).c();
        a r126 = this.f403553p;
        if (r126 == null) goto L45;
        SurfaceControl r127 = r126.f403567d;
        if (r127 == null) goto L45;
        r125.putParcelable("interrupted_overlay_surface", r127);
    L45:
        J(r125);
        return r125;
    L37:
        r122 = r102.intValue();
        goto L38
    L27:
        r119 = r118.intValue();
        goto L28
    L17:
        r117 = r108.intValue();
        goto L18
    L11:
        r109 = false;
    L47:
        return this.f403538a.s().c();
    }

    public final void p() {
        a r100 = this.f403553p;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        Intrinsics.stringPlus("interruptedSource cleanup hasOverlay=", Boolean.valueOf(r101));
        this.f403563z = null;
        this.f403562y = true;
        H();
        this.f403559v = false;
        if (r100 != null) goto L27;
    L25:
        i();
        this.f403560w = false;
        return;
    L27:
        r100.f403565b.b();     // Catch: Throwable -> L23
        ViewParent r102 = r100.f403565b.getParent();     // Catch: Throwable -> L23
        ViewGroup r103 = r100.f403564a;     // Catch: Throwable -> L23
        if (r102 != r103) goto L12;
        r103.removeView(r100.f403565b);     // Catch: Throwable -> L23
    L12:
        OFloatingTitleBarActionHost r104 = this.f403543f;     // Catch: Throwable -> L23
        OFloatingTitleBarActionHost r105 = r100.f403565b;     // Catch: Throwable -> L23
        if (r104 != r105) goto L15;
        this.f403543f = null;     // Catch: Throwable -> L23
    L15:
        a r106 = this.f403553p;     // Catch: Throwable -> L23
        if (r106 != null) goto L18;
        OFloatingTitleBarActionHost r107 = null;
    L19:
        if (r107 != r105) goto L21;
        this.f403553p = null;     // Catch: Throwable -> L23
    L21:
        r100.f403566c.b(false);     // Catch: Throwable -> L23
        r100.f403567d.release();     // Catch: Throwable -> L23
        goto L25
    L18:
        r107 = r106.f403565b;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Intrinsics.stringPlus("interruptedSource local overlay remove failed: ", th.getMessage());
        goto L25
    L5:
        r101 = false;
        goto L6
    }

    public final boolean v() {
        IBinder r100 = this.f403540c;
        if (r100 != null) goto L5;
        return false;
    L5:
        IFloatingTransitionSession r101 = b.c();
        if (r101 != null) goto L14;
        return false;
    L14:
        r101.notifyFloatingTransitionFinished(r100);     // Catch: Throwable -> L11
        r100.toString();     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        th.getMessage();
        return false;
    }

    public final void H() {
        Intrinsics.stringPlus("restoreTargetState keepHidden=", Boolean.TRUE);
        OFloatingTitleBar r100 = this.f403538a;
        r100.I();
        r100.O(false, true);
        this.f403559v = true;
    }

    public final void L() {
        if (o.c() == true) goto L6;
        return;
    L6:
        if (this.f403539b == true) goto L8;
        return;
    L8:
        if (this.f403538a.getWidth() != 0) goto L10;
        return;
    L10:
        if (this.f403538a.getHeight() == 0) goto L27;
        IBinder r100 = this.f403540c;
        if (r100 != null) goto L15;
        return;
    L15:
        IFloatingTransitionSession r101 = b.c();
        if (r101 != null) goto L23;
        return;
    L23:
        Bundle r102 = this.f403538a.s().c();     // Catch: Throwable -> L20
        this.f403554q = new Bundle(r102);     // Catch: Throwable -> L20
        r101.updateState(r100, r102);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        Intrinsics.stringPlus("floating update state failed: ", th.getMessage());
        return;
    }

    public final void i() {
        g();
        this.f403555r = false;
        this.f403556s = false;
        this.f403557t = false;
        ((ArrayList) this.f403542e).clear();
        this.f403541d = false;
        this.f403558u = false;
        this.B = false;
    }

    public final void s() {
        g();
        this.f403560w = true;
        this.f403559v = true;
        OFloatingTitleBarActionHost r100 = this.f403561x;
        if (r100 == null) goto L18;
        this.f403561x = null;
        if (r100.getBoundTitleBar() != this.f403538a) goto L18;
        if (((ArrayList) this.D).contains(r100) == true) goto L12;
        ((ArrayList) this.D).add(r100);
    L12:
        if (o.c() == false) goto L18;
        if (r100.f403448b == true) goto L18;
        r100.f403448b = true;
        OFloatingTitleBar r101 = r100.f403450d;
        Token$Bounce r102 = OFloatingTitleBar.H0;
        r101.O(false, false);
    L18:
        this.f403538a.O(false, true);
    }

    public FloatingTransitionBridge(OFloatingTitleBar r100) {
        Intrinsics.checkNotNullParameter(r100, "titleBar");
        this.f403538a = r100;
        this.f403542e = new ArrayList();
        this.f403562y = true;
        this.D = new ArrayList();
        this.F = new TransitionCallback(this);
        this.G = new TransitionStateProvider(this);
    }

    public static String I(com.obric.oui.titlebar.k r100) {
        StringBuilder r101 = new StringBuilder("w=");
        r101.append(r100.f403621a.f403653a);
        r101.append(" h=");
        r101.append(r100.f403621a.f403654b);
        r101.append(" y=");
        r101.append(r100.f403621a.f403656d);
        r101.append(" contentTopInset=");
        r101.append(r100.f403622b.f403661e);
        r101.append(" contentY=");
        r101.append(r100.f403621a.f403656d + r100.f403622b.f403661e);
        r101.append(" start=");
        r101.append(r100.f403623c.f403642a.size());
        r101.append(" center=");
        r101.append(r100.f403623c.f403643b.size());
        r101.append(" sub=");
        r101.append(r100.f403623c.f403644c.size());
        r101.append(" end=");
        r101.append(r100.f403623c.f403645d.size());
        r101.append(" hasAnimationState=");
        boolean r102 = false;
        if (r100.f403625e == null) goto L5;
        boolean r103 = true;
    L6:
        r101.append(r103);
        r101.append(" animCenter=");
        com.obric.oui.titlebar.k.d r104 = r100.f403625e;
        int r105 = -1;
        if (r104 == null) goto L14;
        OButtonGroup.b r106 = r104.f403647b;
        if (r106 == null) goto L14;
        List<OButtonGroup.d> r107 = r106.f399084g;
        if (r107 == null) goto L14;
        int r108 = r107.size();
    L16:
        r101.append(r108);
        r101.append(" animSub=");
        com.obric.oui.titlebar.k.d r109 = r100.f403625e;
        if (r109 == null) goto L26;
        OButtonGroup.b r110 = r109.f403648c;
        if (r110 == null) goto L26;
        List<OButtonGroup.d> r111 = r110.f399084g;
        if (r111 == null) goto L26;
        r105 = r111.size();
    L26:
        r101.append(r105);
        r101.append(" animCenterAlpha=");
        com.obric.oui.titlebar.k.d r112 = r100.f403625e;
        Float r113 = null;
        if (r112 == null) goto L31;
        OButtonGroup.b r114 = r112.f403647b;
        if (r114 == null) goto L31;
        Float r115 = Float.valueOf(r114.f399079b);
    L33:
        r101.append(r115);
        r101.append(" animSubAlpha=");
        com.obric.oui.titlebar.k.d r116 = r100.f403625e;
        if (r116 == null) goto L40;
        OButtonGroup.b r117 = r116.f403648c;
        if (r117 == null) goto L40;
        r113 = Float.valueOf(r117.f399079b);
    L40:
        r101.append(r113);
        r101.append(" hasInterruptedSurface=");
        if (r100.f403626f == null) goto L43;
        r102 = true;
    L43:
        r101.append(r102);
        return r101.toString();
    L31:
        r115 = null;
    L14:
        r108 = -1;
        goto L16
    L5:
        r103 = false;
        goto L6
    }

    public static void J(Bundle r100) {
        int r101 = com.obric.oui.titlebar.k.f403620g;     // Catch: Throwable -> L4
        I(com.obric.oui.titlebar.k.f.b(r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Intrinsics.stringPlus("invalidState error=", th.getMessage());
    }

    public static boolean M(CountDownLatch r100) {
        boolean r101 = true;
        if (r100 == null) goto L17;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L17;
        SystemClock.uptimeMillis();
    L14:
        ThreadMethodProxy.currentThread().interrupt();
        SystemClock.uptimeMillis();
        return false;
    L9:
        if (r100.await(240, TimeUnit.MILLISECONDS) == false) goto L11;
        SystemClock.uptimeMillis();     // Catch: InterruptedException -> L14
    L19:
        return r101;
    L11:
        SystemClock.uptimeMillis();     // Catch: InterruptedException -> L14
        r101 = false;
    L17:
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private final Activity getActivity(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L9:
        return null;
    }

    public static String w(View r100) {
        String r101 = null;
        if ((r100 instanceof TextView) == false) goto L5;
        TextView r102 = (TextView) r100;
    L6:
        if (r102 == null) goto L12;
        CharSequence r103 = r102.getText();
        if (r103 == null) goto L12;
        r101 = r103.toString();
    L12:
        if (r101 != null) goto L15;
        r101 = "";
    L15:
        return r100.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(r100)) + " tag=" + r100.getTag() + " text=" + r101 + " vis=" + r100.getVisibility() + " shown=" + r100.isShown() + " alpha=" + r100.getAlpha() + " size=" + r100.getWidth() + Permission.EXECUTE + r100.getHeight() + " measured=" + r100.getMeasuredWidth() + Permission.EXECUTE + r100.getMeasuredHeight() + " requestLayout=" + r100.isLayoutRequested();
    L5:
        r102 = null;
        goto L6
    }

    public final void C(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (o.c() == true) goto L6;
        return;
    L6:
        if (this.C == false) goto L8;
    L13:
        boolean r101 = true;
    L15:
        if (this.B == false) goto L19;
        F(r100);
        return;
    L19:
        if (this.f403560w == false) goto L24;
        if (r101 == false) goto L24;
        F(r100);
        return;
    L24:
        if (this.f403555r == false) goto L26;
    L36:
        F(r100);
        return;
    L26:
        if (this.f403553p != null) goto L36;
        if (this.f403559v == false) goto L31;
    L34:
        g();
        Intrinsics.stringPlus("restoreHiddenActionsIfIdle reason=", r100);
        this.C = false;
        this.f403538a.O(true, true);
        D();
        this.f403560w = false;
        this.f403559v = false;
        return;
    L31:
        if (this.f403560w == true) goto L34;
        return;
    L8:
        if (this.f403555r == true) goto L13;
        if (this.f403553p != null) goto L13;
        r101 = false;
        goto L15
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.obric.oui.titlebar.floating.k, java.lang.Runnable] */
    public final void F(final String r100) {
        g();
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        ?? r102 = new k(this, r101, r100);
        r101.element = r102;
        this.E = r102;
        this.f403538a.postDelayed((Runnable) r102, AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
    }

    public final boolean m(d r110) {
        OFloatingTitleBarActionHost r100 = this.f403543f;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getWidth() > 0) goto L8;
    L69:
        r100.getWidth();
        r100.getHeight();
        return false;
    L8:
        if (r100.getHeight() <= 0) goto L69;
        float r101 = r110.c(r100);
        r100.getLocationOnScreen(new int[2]);
        SurfaceControl.Transaction r102 = new SurfaceControl.Transaction();
        r102.setPosition(r110.f403568a, 0.0f, r101);
        t(r102, "show", r110.f403568a);
        SurfaceControl r103 = r110.f403568a;
        if (this.f403544g == false) goto L13;
    L28:
        Canvas r104 = null;
        Method r105 = r110.f403575h.f403552o;     // Catch: Throwable -> L37
        if (r105 != null) goto L32;
        r105 = Surface.class.getDeclaredMethod("getNextFrameNumber", new Class[0]);     // Catch: Throwable -> L37
        FloatingTransitionBridge r106 = r110.f403575h;     // Catch: Throwable -> L37
        r105.setAccessible(true);     // Catch: Throwable -> L37
        r106.f403552o = r105;     // Catch: Throwable -> L37
    L32:
        Object r107 = r105.invoke(r110.f403569b, new Object[0]);     // Catch: Throwable -> L37
        if (r107 == null) goto L36;
        Long r108 = Long.valueOf(((Long) r107).longValue());     // Catch: Throwable -> L37
    L39:
        if (r108 != null) goto L42;
        r102.close();
        return false;
    L42:
        long r109 = r108.longValue();
        Intrinsics.checkNotNullParameter(r102, "transaction");
        Method r111 = r110.f403575h.f403550m;     // Catch: Throwable -> L48
        if (r111 != null) goto L46;
        Class<?> r112 = r110.f403570c.getClass();     // Catch: Throwable -> L48
        Class<?> r113 = Long.TYPE;     // Catch: Throwable -> L48
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L48
        r111 = r112.getDeclaredMethod("mergeWithNextTransaction", new Class[]{SurfaceControl.Transaction.class, r113});     // Catch: Throwable -> L48
        FloatingTransitionBridge r114 = r110.f403575h;     // Catch: Throwable -> L48
        r111.setAccessible(true);     // Catch: Throwable -> L48
        r114.f403550m = r111;     // Catch: Throwable -> L48
    L46:
        r111.invoke(r110.f403570c, new Object[]{r102, Long.valueOf(r109)});     // Catch: Throwable -> L48
        boolean r115 = true;
    L50:
        if (r115 == true) goto L71;
        r102.close();
        return false;
    L71:
        r104 = r110.f403569b.lockHardwareCanvas();     // Catch: Throwable -> L55
    L57:
        if (r104 != null) goto L80;
        return false;
    L80:
        r104.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L62
        r100.draw(r104);     // Catch: Throwable -> L62
        r110.f403569b.unlockCanvasAndPost(r104);
        return true;
    L62:
        th = move-exception;
        Intrinsics.stringPlus("floating draw surface failed: ", th.getMessage());     // Catch: Throwable -> L66
        r110.f403569b.unlockCanvasAndPost(r104);
        return false;
    L66:
        th = move-exception;
        r110.f403569b.unlockCanvasAndPost(r104);
        throw th;
    L55:
        th = move-exception;
        Intrinsics.stringPlus("floating lock surface failed: ", th.getMessage());
    L48:
        th = move-exception;
        Intrinsics.stringPlus("mergeWithNextTransaction failed: ", th.getMessage());
        r115 = false;
        goto L50
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Intrinsics.stringPlus("getNextFrameNumber failed: ", th.getMessage());
        r108 = null;
        goto L39
    L13:
        if (r103.isValid() == false) goto L28;
        int[] r116 = new int[2];     // Catch: Throwable -> L26
        r100.getLocationOnScreen(r116);     // Catch: Throwable -> L26
        float[][] r117 = j(r100, new int[]{-r116[0], (-r116[1]) + MathKt.roundToInt(r101)});     // Catch: Throwable -> L26
        if (r117.length != 0) goto L18;
        boolean r118 = true;
    L19:
        if (r118 == true) goto L28;
        Method r119 = this.f403545h;     // Catch: Throwable -> L26
        if (r119 != null) goto L24;
        r119 = SurfaceControl.Transaction.class.getDeclaredMethod("setBlurRegions", new Class[]{SurfaceControl.class, float[][].class});     // Catch: Throwable -> L26
        r119.setAccessible(true);     // Catch: Throwable -> L26
        this.f403545h = r119;     // Catch: Throwable -> L26
    L24:
        r119.invoke(r102, new Object[]{r103, r117});     // Catch: Throwable -> L26
        goto L28
    L18:
        r118 = false;
    L26:
        th = move-exception;
        this.f403544g = true;
        Intrinsics.stringPlus("floating set blur regions disabled: ", th.getMessage());
        goto L28
    }

    public final void r(boolean r110) {
        this.f403563z = null;
        this.f403562y = true;
        this.C = false;
        i();
        if (r110 == false) goto L7;
        this.f403560w = false;
        this.f403559v = false;
        if (this.f403553p != null) goto L8;
        this.f403538a.O(true, true);
        D();
    L8:
        a r100 = this.f403553p;
        if (r100 == null) goto L16;
        if (r110 == false) goto L13;
        q(r100.f403564a, r100.f403565b, r100.f403566c, r100.f403567d, true);
        return;
    L13:
        y(r100.f403564a, r100.f403565b, r100.f403566c, r100.f403567d, true);
        return;
    L16:
        return;
    L7:
        H();
        goto L8
    }

    public final void x(boolean r100) {
        if (o.c() == true) goto L6;
        return;
    L6:
        if (this.f403539b == false) goto L9;
        if (r100 == true) goto L9;
        return;
    L9:
        Activity r101 = getActivity(this.f403538a.getContext());
        if (r101 != null) goto L12;
        return;
    L12:
        IBinder r102 = null;
        Field r103 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L17
        r103.setAccessible(true);     // Catch: Throwable -> L17
        Object r104 = r103.get(r101);     // Catch: Throwable -> L17
        if ((r104 instanceof IBinder) == false) goto L19;
        IBinder r105 = (IBinder) r104;     // Catch: Throwable -> L17
    L20:
        Window r106 = r101.getWindow();
        if (r106 == null) goto L36;
        View r107 = b(r106);
        if (r105 != null) goto L29;
        WindowManager.LayoutParams r108 = r106.getAttributes();
        if (r108 == null) goto L30;
        r102 = r108.token;
    L30:
        if (r102 != null) goto L35;
        IBinder r109 = r107.getApplicationWindowToken();
        if (r109 != null) goto L34;
        r109 = r107.getWindowToken();
    L34:
        r105 = r109;
        goto L36
    L35:
        r105 = r102;
        goto L36
    L29:
        r102 = r105;
    L36:
        if (r105 != null) goto L38;
        return;
    L38:
        IFloatingTransitionSession r110 = b.c();
        if (r110 != null) goto L50;
        return;
    L50:
        boolean r111 = r110.registerTitleBar(r105, this.F, this.G);     // Catch: Throwable -> L45
        this.f403540c = r105;     // Catch: Throwable -> L45
        this.f403539b = true;     // Catch: Throwable -> L45
        H.put(r105, this);     // Catch: Throwable -> L45
        r105.toString();     // Catch: Throwable -> L45
        L();     // Catch: Throwable -> L45
        if (r111 == false) goto L52;
        this.C = true;     // Catch: Throwable -> L45
        this.f403560w = true;     // Catch: Throwable -> L45
        s();     // Catch: Throwable -> L45
        this.f403559v = false;     // Catch: Throwable -> L45
        return;
    L52:
        return;
    L45:
        th = move-exception;
        Intrinsics.stringPlus("floating register failed: ", th.getMessage());
        return;
    L19:
        r105 = null;
    L17:
        th = move-exception;
        Intrinsics.stringPlus("floating get activity token failed: ", th.getMessage());
        goto L19
    }

    public static void A(SurfaceControl.Transaction r100, SurfaceControl r101) {
        t(r100, "remove", r101);
    }

    public static void B(final FloatingTransitionBridge r100, final d r101) {
        a r102 = r100.f403553p;
        if (r102 == null) goto L7;
        if (r102.f403566c == r101) goto L7;
        return;
    L7:
        if (r101.a() == true) goto L10;
        return;
    L10:
        if (r100.f403541d == true) goto L16;
        r100.f403541d = true;
        r100.f403538a.post(new i(r100, r101));
        return;
    }

    public static final int c(FloatingTransitionBridge r100, com.obric.oui.titlebar.k r101) {
        r100.getClass();
        return r101.f403621a.f403656d + r101.f403622b.f403661e;
    }

    public static final /* synthetic */ Activity d(FloatingTransitionBridge r100, Context r101) {
        return r100.getActivity(r101);
    }

    public static String o(View r100, float r101) {
        if (r100.getVisibility() == 0) goto L5;
        return null;
    L5:
        float r102 = r101 * r100.getAlpha();
        int r103 = 0;
        if ((r100 instanceof TextView) == false) goto L31;
        if (r102 < 0.99f) goto L31;
        TextView r104 = (TextView) r100;
        CharSequence r105 = r104.getText();
        if (r105 == null) goto L18;
        boolean r106 = true;
        if (r105.length() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 != true) goto L18;
    L19:
        if (r106 == false) goto L31;
        if (r104.getWidth() <= 0) goto L29;
        if (r104.getHeight() <= 0) goto L29;
        if (r104.isLayoutRequested() == true) goto L29;
        if (r104.getLayout() != null) goto L31;
    L29:
        return w(r100);
    L15:
        r107 = false;
    L18:
        r106 = false;
    L31:
        if (r100.getTag() == null) goto L43;
        if (r102 < 0.99f) goto L43;
        if (r100.getWidth() <= 0) goto L41;
        if (r100.getHeight() <= 0) goto L41;
        if (r100.isLayoutRequested() == false) goto L43;
    L41:
        return w(r100);
    L43:
        if ((r100 instanceof ViewGroup) == false) goto L50;
        ViewGroup r108 = (ViewGroup) r100;
        int r109 = r108.getChildCount();
    L45:
        if (r103 >= r109) goto L50;
        int r110 = r103 + 1;
        String r111 = o(r108.getChildAt(r103), r102);
        if (r111 != null) goto L48;
        r103 = r110;
        goto L45
    L48:
        return r111;
    L50:
        return null;
    }

    public final void K(boolean r100, boolean r101) {
        g();
        getActivity(this.f403538a.getContext());
        if (o.c() == true) goto L6;
        this.f403540c = null;
        this.f403539b = false;
        return;
    L6:
        if (r101 == false) goto L8;
        r(r100);
    L8:
        IBinder r102 = this.f403540c;
        if (r102 != null) goto L12;
        this.f403539b = false;
        return;
    L12:
        IFloatingTransitionSession r103 = b.c();
        if (r103 != null) goto L19;
        Map<IBinder, FloatingTransitionBridge> r104 = H;
        if (((LinkedHashMap) r104).get(r102) != this) goto L17;
        r104.remove(r102);
    L17:
        this.f403540c = null;
        this.f403539b = false;
        return;
    L19:
        Map<IBinder, FloatingTransitionBridge> r105 = H;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        if (r106.get(r102) == this) goto L40;
        Intrinsics.stringPlus("floating unregister skip nonOwner token=", r102);
        this.f403540c = null;
        this.f403539b = false;
        return;
    L40:
        r103.unregisterTitleBar(r102);     // Catch: Throwable -> L27
        if (r106.get(r102) != this) goto L32;
        r105.remove(r102);
    L32:
        this.f403540c = null;
        this.f403539b = false;
        return;
    L27:
        th = move-exception;
        Intrinsics.stringPlus("floating unregister failed: ", th.getMessage());     // Catch: Throwable -> L34
        if (((LinkedHashMap) H).get(r102) != this) goto L32;
        H.remove(r102);
    L34:
        th = move-exception;
        Map<IBinder, FloatingTransitionBridge> r107 = H;
        if (((LinkedHashMap) r107).get(r102) != this) goto L38;
        r107.remove(r102);
    L38:
        this.f403540c = null;
        this.f403539b = false;
        throw th;
    }

    public final float[][] j(OFloatingTitleBarActionHost r100, int[] r101) {
        Class r102 = a("android.view.IExtEffect");
        Method r103 = this.f403546i;
        if (r103 != null) goto L5;
        r103 = r102.getDeclaredMethod("collectMaterials", new Class[]{View.class, int[].class});
        r103.setAccessible(true);
        this.f403546i = r103;
    L5:
        Object r104 = r103.invoke(null, new Object[]{r100, r101});
        if (r104 == null) goto L10;
        return (float[][]) r104;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.FloatArray>");
    }

    public final void u(OFloatingTitleBarActionHost r100, com.obric.oui.titlebar.k r101) {
        Integer r102 = Integer.valueOf(r101.f403621a.f403653a);
        boolean r103 = true;
        if (r102.intValue() <= 0) goto L5;
        boolean r104 = true;
    L6:
        Integer r105 = null;
        if (r104 == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L12;
        int r106 = this.f403538a.getWidth();
    L13:
        Integer r107 = Integer.valueOf(r101.f403621a.f403654b);
        if (r107.intValue() > 0) goto L17;
        r103 = false;
    L17:
        if (r103 == false) goto L19;
        r105 = r107;
    L19:
        if (r105 != null) goto L21;
        int r108 = this.f403538a.getHeight();
    L22:
        if (r106 <= 0) goto L28;
        if (r108 <= 0) goto L28;
        r100.measure(View.MeasureSpec.makeMeasureSpec(r106, 1073741824), View.MeasureSpec.makeMeasureSpec(r108, 1073741824));
        r100.layout(0, 0, r106, r108);
        return;
    L28:
        return;
    L21:
        r108 = r105.intValue();
        goto L22
    L12:
        r106 = r102.intValue();
        goto L13
    L5:
        r104 = false;
        goto L6
    }

    public static void t(SurfaceControl.Transaction r100, String r101, SurfaceControl r102) {
        Method r103 = SurfaceControl.Transaction.class.getDeclaredMethod(r101, new Class[]{SurfaceControl.class});     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        r103.invoke(r100, new Object[]{r102});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.getMessage();
    }

    public final boolean E(final String r110, boolean r111, final Function1 r112) {
        SystemClock.uptimeMillis();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L15;
        final Ref.BooleanRef r100 = new Ref.BooleanRef();
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        r112.invoke(new FloatingTransitionBridge$runOnMainAsyncAndWait$1(r100, r101));
        if (r100.element == true) goto L9;
        Intrinsics.stringPlus("async main action not completed synchronously reason=", r110);
        if (r111 == false) goto L9;
        return true;
    L9:
        SystemClock.uptimeMillis();
        if (r100.element == true) goto L12;
        return false;
    L12:
        if (r101.element == false) goto L27;
        return true;
    L27:
        return false;
    L15:
        final CountDownLatch r113 = new CountDownLatch(1);
        final AtomicBoolean r102 = new AtomicBoolean(true);
        Boolean r103 = Boolean.FALSE;
        final AtomicReference r104 = new AtomicReference(r103);
        this.f403538a.post(new g(r102, r113, r112, r110, r104));
    L22:
        r102.set(false);
        ThreadMethodProxy.currentThread().interrupt();
        SystemClock.uptimeMillis();
        return false;
    L17:
        if (r113.await(240, TimeUnit.MILLISECONDS) == false) goto L19;
        r103 = (Boolean) r104.get();     // Catch: InterruptedException -> L22
        SystemClock.uptimeMillis();     // Catch: InterruptedException -> L22
    L20:
        return r103.booleanValue();
    L19:
        r102.set(false);     // Catch: InterruptedException -> L22
        SystemClock.uptimeMillis();     // Catch: InterruptedException -> L22
        goto L20
    }

    public final void G(SurfaceControl.Transaction r100, String r110, final CountDownLatch r111, final Function0 r112) {
        boolean r101 = true;
        if (r111 != null) goto L31;
        if (r112 != null) goto L31;
    L9:
        boolean r102 = false;
    L30:
        Method r103 = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: Throwable -> L27
        r103.setAccessible(true);     // Catch: Throwable -> L27
        Object r104 = r103.invoke(this.f403538a, new Object[0]);     // Catch: Throwable -> L27
        if (r104 != null) goto L14;
        Intrinsics.stringPlus("applyTransactionOnDraw missing root reason=", r110);     // Catch: Throwable -> L27
        f(r100, r111, r112, r102);     // Catch: Throwable -> L27
        return;
    L14:
        Object r105 = r104.getClass().getMethod("applyTransactionOnDraw", new Class[]{SurfaceControl.Transaction.class}).invoke(r104, new Object[]{r100});     // Catch: Throwable -> L27
        if ((r105 instanceof Boolean) == false) goto L17;
        Boolean r106 = (Boolean) r105;     // Catch: Throwable -> L27
    L18:
        if (r106 == null) goto L21;
        r101 = r106.booleanValue();     // Catch: Throwable -> L27
    L21:
        if (r101 == true) goto L23;
        Intrinsics.stringPlus("applyTransactionOnDraw returned false reason=", r110);     // Catch: Throwable -> L27
        f(r100, r111, r112, r102);     // Catch: Throwable -> L27
        return;
    L23:
        this.f403538a.invalidate();     // Catch: Throwable -> L27
        if (r102 == true) goto L34;
        this.f403538a.postOnAnimation(new com.obric.oui.titlebar.floating.b(r111, r112));     // Catch: Throwable -> L27
        return;
    L34:
        return;
    L17:
        r106 = null;
    L27:
        th = move-exception;
        th.getMessage();
        f(r100, r111, r112, r102);
        return;
    L31:
        r100.addTransactionCommittedListener(new m(), new n(r111, r112, this));     // Catch: Throwable -> L7
        r102 = true;
    L7:
        th = move-exception;
        th.getMessage();
        goto L9
    }

    public final void f(SurfaceControl.Transaction r100, CountDownLatch r101, final Function0 r102, boolean r103) {
        r100.apply();     // Catch: Throwable -> L4
        r100.close();     // Catch: Throwable -> L4
    L6:
        if (r103 == true) goto L16;
        if (r101 == null) goto L10;
        r101.countDown();
    L10:
        if (r102 == null) goto L17;
        this.f403538a.post(new com.obric.oui.titlebar.floating.a(r102));
        return;
    L17:
        return;
    L16:
        return;
    L4:
        th = move-exception;
        th.getMessage();
        goto L6
    }

    public final OFloatingTitleBarActionHost k(Context r110, ViewGroup r111, com.obric.oui.titlebar.k r112, com.obric.oui.titlebar.k r113) {
        Integer r100 = null;
        int r101 = 0;
        OFloatingTitleBarActionHost r102 = new OFloatingTitleBarActionHost(r110, null, 6, 0);
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        r102.a(r112, false, true, null, null);
        r102.setVisibility(4);
        Integer r103 = Integer.valueOf(r112.f403621a.f403653a);
        boolean r104 = true;
        if (r103.intValue() <= 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L9;
        r103 = null;
    L9:
        if (r103 != null) goto L11;
        int r106 = this.f403538a.getWidth();
    L12:
        if (r113 == null) goto L25;
        com.obric.oui.titlebar.k.e r107 = r113.f403621a;
        if (r107 == null) goto L25;
        Integer r108 = Integer.valueOf(r107.f403653a);
        if (r108.intValue() <= 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == true) goto L24;
        r108 = null;
    L24:
        if (r108 == null) goto L25;
        int r114 = r108.intValue();
    L27:
        int r115 = Math.max(r106, r114);
        Integer r116 = Integer.valueOf(r112.f403621a.f403654b);
        if (r116.intValue() <= 0) goto L30;
        boolean r117 = true;
    L31:
        if (r117 == true) goto L34;
        r116 = null;
    L34:
        if (r116 != null) goto L36;
        int r118 = this.f403538a.getHeight();
    L37:
        if (r113 == null) goto L51;
        com.obric.oui.titlebar.k.e r119 = r113.f403621a;
        if (r119 == null) goto L51;
        Integer r120 = Integer.valueOf(r119.f403654b);
        if (r120.intValue() > 0) goto L46;
        r104 = false;
    L46:
        if (r104 == false) goto L48;
        r100 = r120;
    L48:
        if (r100 == null) goto L51;
        r101 = r100.intValue();
    L51:
        int r121 = Math.max(r118, r101);
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(r115, r121);
        r122.topMargin = (-r121) - 1000;
        Unit r123 = Unit.INSTANCE;
        r111.addView(r102, r122);
        r102.f403450d.a(4);
        return r102;
    L36:
        r118 = r116.intValue();
        goto L37
    L30:
        r117 = false;
        goto L31
    L20:
        r109 = false;
    L25:
        r114 = 0;
        goto L27
    L11:
        r106 = r103.intValue();
        goto L12
    L5:
        r105 = false;
        goto L6
    }

    public final d l(SurfaceControl r110, com.obric.oui.titlebar.k r111, String r210, com.obric.oui.titlebar.k r211) {
        Integer r100 = Integer.valueOf(r111.f403621a.f403653a);
        if (r100.intValue() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L11;
        int r102 = this.f403538a.getWidth();
    L12:
        if (r211 == null) goto L25;
        com.obric.oui.titlebar.k.e r103 = r211.f403621a;
        if (r103 == null) goto L25;
        Integer r104 = Integer.valueOf(r103.f403653a);
        if (r104.intValue() <= 0) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L24;
        r104 = null;
    L24:
        if (r104 == null) goto L25;
        int r106 = r104.intValue();
    L27:
        int r107 = Math.max(r102, r106);
        Integer r108 = Integer.valueOf(r111.f403621a.f403654b);
        if (r108.intValue() <= 0) goto L30;
        boolean r109 = true;
    L31:
        if (r109 == true) goto L34;
        r108 = null;
    L34:
        if (r108 != null) goto L36;
        int r112 = this.f403538a.getHeight();
    L37:
        if (r211 == null) goto L50;
        com.obric.oui.titlebar.k.e r113 = r211.f403621a;
        if (r113 == null) goto L50;
        Integer r114 = Integer.valueOf(r113.f403654b);
        if (r114.intValue() <= 0) goto L45;
        boolean r115 = true;
    L46:
        if (r115 == true) goto L49;
        r114 = null;
    L49:
        if (r114 == null) goto L50;
        int r116 = r114.intValue();
    L52:
        int r117 = Math.max(r112, r116);
        Resources r118 = this.f403538a.getResources();
        int r119 = ((int) ((32 * WindowDisplayMetricsOverride.apply(r118, r118.getDisplayMetrics()).density) + 0.5f)) + r117;
        if (r107 <= 0) goto L74;
        if (r117 <= 0) goto L74;
        SurfaceControl r120 = new SurfaceControl.Builder().setName(Intrinsics.stringPlus("FloatingTitleBar", r210)).setParent(r110).setBufferSize(r107, r119).setFormat(-3).build();     // Catch: Throwable -> L70
        Class<?> r121 = this.f403547j;     // Catch: Throwable -> L70
        if (r121 != null) goto L59;
        r121 = a("android.graphics.BLASTBufferQueue");     // Catch: Throwable -> L70
        this.f403547j = r121;     // Catch: Throwable -> L70
    L59:
        Class<?> r122 = Boolean.TYPE;     // Catch: Throwable -> L70
        Intrinsics.checkNotNull(r122);     // Catch: Throwable -> L70
        Object r123 = r121.getDeclaredConstructor(new Class[]{String.class, r122}).newInstance(new Object[]{Intrinsics.stringPlus("FloatingTitleBarBBQ", r210), Boolean.FALSE});     // Catch: Throwable -> L70
        Method r124 = this.f403548k;     // Catch: Throwable -> L70
        if (r124 != null) goto L62;
        Class<?> r125 = Integer.TYPE;     // Catch: Throwable -> L70
        Intrinsics.checkNotNull(r125);     // Catch: Throwable -> L70
        Intrinsics.checkNotNull(r125);     // Catch: Throwable -> L70
        Intrinsics.checkNotNull(r125);     // Catch: Throwable -> L70
        r124 = r121.getDeclaredMethod("update", new Class[]{SurfaceControl.class, r125, r125, r125});     // Catch: Throwable -> L70
        r124.setAccessible(true);     // Catch: Throwable -> L70
        this.f403548k = r124;     // Catch: Throwable -> L70
    L62:
        r124.invoke(r123, new Object[]{r120, Integer.valueOf(r107), Integer.valueOf(r119), -3});     // Catch: Throwable -> L70
        Method r126 = this.f403549l;     // Catch: Throwable -> L70
        if (r126 != null) goto L65;
        r126 = r121.getDeclaredMethod("createSurface", new Class[0]);     // Catch: Throwable -> L70
        r126.setAccessible(true);     // Catch: Throwable -> L70
        this.f403549l = r126;     // Catch: Throwable -> L70
    L65:
        Object r127 = r126.invoke(r123, new Object[0]);     // Catch: Throwable -> L70
        if (r127 == null) goto L69;
        return new d(this, r110, r120, (Surface) r127, r123, r111, r211);
    L69:
        throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        th.getMessage();
        return null;
    L74:
        return null;
    L45:
        r115 = false;
    L50:
        r116 = 0;
        goto L52
    L36:
        r112 = r108.intValue();
        goto L37
    L30:
        r109 = false;
        goto L31
    L20:
        r105 = false;
    L25:
        r106 = 0;
        goto L27
    L11:
        r102 = r100.intValue();
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public final void z(ViewGroup r100, OFloatingTitleBarActionHost r101, d r102, boolean r103) {
        r101.b();     // Catch: Throwable -> L12
        if (r101.getParent() != r100) goto L6;
        r100.removeView(r101);     // Catch: Throwable -> L12
    L6:
        if (this.f403543f != r101) goto L8;
        this.f403543f = null;     // Catch: Throwable -> L12
    L8:
        if (r102 == null) goto L17;
        r102.b(r103);     // Catch: Throwable -> L12
        return;
    L17:
        return;
    L12:
        th = move-exception;
        Intrinsics.stringPlus("floating source hide cleanup failed: ", th.getMessage());
    }

    public final void n(OFloatingTitleBarActionHost r110, com.obric.oui.titlebar.k r111, d r112, String r113, Function1<? super Boolean, Unit> r114) {
        Ref.BooleanRef r100 = new Ref.BooleanRef();
        u(r110, r111);
        ViewTreeObserver r101 = r110.getViewTreeObserver();
        if (r101.isAlive() == false) goto L5;
        r101.addOnPreDrawListener(new e(r110, r101, this, r112, r113, r111, r100, r114));
        r110.requestLayout();
        r110.invalidate();
        return;
    L5:
        if (r100.element == true) goto L11;
        r100.element = true;
        r114.invoke(Boolean.FALSE);
        return;
    }

    public final void q(final ViewGroup r110, final OFloatingTitleBarActionHost r111, final d r112, final SurfaceControl r113, boolean r114) {
        this.C = false;
        this.f403538a.O(true, true);
        D();
        this.f403560w = false;
        this.f403559v = false;
        SurfaceControl.Transaction r100 = new SurfaceControl.Transaction();
        A(r100, r113);
        if (r114 == true) goto L11;
        f(r100, null, null, false);
        boolean r115 = v();
        y(r110, r111, r112, r113, true);
        if (r115 == true) goto L7;
        return;
    L7:
        if (this.A == true) goto L14;
        this.A = true;
        return;
    L14:
        return;
    L11:
        G(r100, "finishOverlay", null, new FloatingTransitionBridge$finishOverlayToRealActions$scheduled$1(this, r110, r111, r112, r113));
    }

    public final void y(ViewGroup r100, OFloatingTitleBarActionHost r101, d r102, SurfaceControl r103, boolean r104) {
        a r105 = this.f403553p;
        if (r105 != null) goto L5;
        OFloatingTitleBarActionHost r106 = null;
    L7:
        if (r106 != r101) goto L9;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L39;
        return;
    L39:
        r101.b();     // Catch: Throwable -> L36
        if (r101.getParent() != r100) goto L21;
        r100.removeView(r101);     // Catch: Throwable -> L36
    L21:
        if (this.f403543f != r101) goto L23;
        this.f403543f = null;     // Catch: Throwable -> L36
    L23:
        a r108 = this.f403553p;     // Catch: Throwable -> L36
        if (r108 != null) goto L26;
        OFloatingTitleBarActionHost r109 = null;
    L27:
        if (r109 != r101) goto L29;
        this.f403553p = null;     // Catch: Throwable -> L36
    L29:
        if (r102 == null) goto L32;
        r102.b(r104);     // Catch: Throwable -> L36
    L32:
        if (r104 == false) goto L34;
        SurfaceControl.Transaction r110 = new SurfaceControl.Transaction();     // Catch: Throwable -> L36
        A(r110, r103);     // Catch: Throwable -> L36
        r110.apply();     // Catch: Throwable -> L36
        r110.close();     // Catch: Throwable -> L36
        r103.release();     // Catch: Throwable -> L36
    L34:
        Intrinsics.stringPlus("removeOverlay done releaseSurface=", Boolean.valueOf(r104));     // Catch: Throwable -> L36
        return;
    L26:
        r109 = r108.f403565b;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        this.f403538a.O(true, true);
        Intrinsics.stringPlus("floating cleanup failed: ", th.getMessage());
        return;
    L9:
        if (this.f403543f == r101) goto L14;
        if (r101.getParent() == r100) goto L14;
        r107 = false;
        goto L15
    L5:
        r106 = r105.f403565b;
        goto L7
    }

    public static final void e(final FloatingTransitionBridge r210, final SurfaceControl r211, final SurfaceControl r212, Bundle r213, final AtomicReference r214, final Function1 r215) {
        r210.getClass();
        int r100 = com.obric.oui.titlebar.k.f403620g;
        final com.obric.oui.titlebar.k r110 = com.obric.oui.titlebar.k.f.b(r213).b(r210.f403538a.getContext());
        com.obric.oui.titlebar.k r111 = r210.f403538a.s();
        com.obric.oui.titlebar.k.h r101 = r111.f403624d;
        if ((!r110.f403623c.f403642a.isEmpty()) == true) goto L5;
    L7:
        int r102 = r111.f403624d.f403662a;
    L9:
        if ((!r110.f403623c.f403643b.isEmpty()) == true) goto L11;
    L13:
        int r103 = r111.f403624d.f403663b;
    L15:
        if ((!r110.f403623c.f403644c.isEmpty()) == true) goto L17;
    L19:
        int r104 = r111.f403624d.f403664c;
    L21:
        if ((!r110.f403623c.f403645d.isEmpty()) == true) goto L23;
    L25:
        int r105 = r111.f403624d.f403665d;
    L26:
        r101.getClass();
        final com.obric.oui.titlebar.k r112 = com.obric.oui.titlebar.k.a(r111, null, null, null, new com.obric.oui.titlebar.k.h(r102, r103, r104, r105), null, 55);
        r210.f403538a.getLocationOnScreen(new int[2]);
        Activity r106 = r210.getActivity(r210.f403538a.getContext());
        if (r106 == null) goto L31;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L31;
        View r108 = b(r107);
    L34:
        if ((r108 instanceof ViewGroup) == false) goto L36;
        ViewGroup r109 = (ViewGroup) r108;
    L38:
        if (r106 == null) goto L48;
        if (r109 == null) goto L48;
        r210.r(false);
        r210.C = true;
        r210.B = true;
        r210.f403562y = false;
        r210.f403563z = null;
        final OFloatingTitleBarActionHost r113 = r210.k(r106, r109, r110, r112);
        final d r114 = r210.l(r211, r110, "Transition", r112);
        if (r114 != null) goto L45;
        r210.f403562y = true;
        r210.f403563z = null;
        r210.C = false;
        r210.B = false;
        r210.y(r109, r113, null, r211, true);
        r215.invoke(Boolean.FALSE);
        return;
    L45:
        if (r110.f403625e == null) goto L47;
        Intrinsics.stringPlus("restore snapshot source=", I(r110));
    L47:
        r210.f403543f = r113;
        r210.f403553p = new a(r109, r113, r114, r211);
        r210.i();
        r210.A = false;
        r210.f403555r = true;
        final ViewGroup r115 = r109;
        r210.n(r113, r110, r114, "targetFirstFrameDraw", new FloatingTransitionBridge$handleTransitionStartOnMain$1(r210, r115, r113, r114, r211, r215, r214, r212, r110, r112));
        return;
    L48:
        r210.C = false;
        r210.B = false;
        r215.invoke(Boolean.FALSE);
        return;
    L36:
        r109 = null;
    L31:
        r108 = null;
        goto L34
    L23:
        if (r111.f403623c.f403645d.isEmpty() == false) goto L25;
        r105 = r110.f403624d.f403665d;
        goto L26
    L17:
        if (r111.f403623c.f403644c.isEmpty() == false) goto L19;
        r104 = r110.f403624d.f403664c;
        goto L21
    L11:
        if (r111.f403623c.f403643b.isEmpty() == false) goto L13;
        r103 = r110.f403624d.f403663b;
        goto L15
    L5:
        if (r111.f403623c.f403642a.isEmpty() == false) goto L7;
        r102 = r110.f403624d.f403662a;
        goto L9
    }
}
