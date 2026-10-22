package com.lynx.clay.embedding.android;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.android.webview.chromium.DrawFunctor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class FunctorView extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Method f380546m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Method f380547n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Method f380548o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Method f380549p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Method f380550q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f380551r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f380552s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f380553t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f380554u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f380555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f380556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f380557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f380558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f380559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f380560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f380563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f380564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f380565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f380566l;

    public class a implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctorView f380567a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public a(FunctorView r100) {
            this.f380567a = r100;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
            FunctorView r101 = this.f380567a;
            if (r101.f380559e != (-1)) goto L6;
            return;
        L6:
            if (r100 < 40) goto L9;
            r101.k();
            return;
        }
    }

    private native long[] nativeCreateGLFunctor(long r100, boolean r101);

    private native void nativeDestroyDrawFunctor(long r100);

    private native void nativeUpdateSharedImage(long r100);

    public native void nativeSetSharedImageSink(long r100, long r101);

    public void notifyFunctorPresent(long r100) {
    }

    public static synchronized boolean f() {
        monitor-enter(FunctorView.class);
    L56:
        th = move-exception;
        throw th;
    L6:
        if (f380549p == null) goto L65;
        monitor-exit(FunctorView.class);
        return true;
    L65:
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L16
        if (r100 >= 29) goto L59;
        Class r101 = c("android.view.ViewRootImpl");     // Catch: Throwable -> L16
        Class<?> r110 = Long.TYPE;     // Catch: Throwable -> L16
        Method r102 = r101.getDeclaredMethod("invokeFunctor", new Class[]{r110, Boolean.TYPE});     // Catch: Throwable -> L16
        f380546m = r102;     // Catch: Throwable -> L16
        r102.setAccessible(true);     // Catch: Throwable -> L16
        Method r103 = r101.getDeclaredMethod("detachFunctor", new Class[]{r110});     // Catch: Throwable -> L16
        f380547n = r103;     // Catch: Throwable -> L16
        r103.setAccessible(true);     // Catch: Throwable -> L16
        if (r100 > 23) goto L59;
        Method r104 = c(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: Throwable -> L16
        f380548o = r104;     // Catch: Throwable -> L16
        r104.setAccessible(true);     // Catch: Throwable -> L16
    L59:
        int r105 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L50
        if (r105 < 29) goto L36;
        c5a.b.a().f22526a.getFlutterJNI().loadLibrary(null);     // Catch: Throwable -> L30
        if (SystemLoaderFaker.loadLibrary("webviewchromium_plat_support", "_ZN7android19RegisterDrawFunctorEP7_JNIEnv") == true) goto L34;
        Class r106 = d(WebView.getWebViewClassLoader());     // Catch: Throwable -> L30
        f380550q = r106.getDeclaredMethod("getDrawFnFunctionTable", new Class[0]);     // Catch: Throwable -> L27
    L28:
        f380550q.setAccessible(true);     // Catch: Throwable -> L30
    L27:
        f380550q = r106.getDeclaredMethod("nativeGetFunctionTable", new Class[0]);     // Catch: Throwable -> L30
    L34:
        f380549p = c("android.graphics.RecordingCanvas").getMethod("drawWebViewFunctor", new Class[]{Integer.TYPE});     // Catch: Throwable -> L50
    L47:
        f380549p.setAccessible(true);     // Catch: Throwable -> L50
        monitor-exit(FunctorView.class);
        return true;
    L30:
        th = move-exception;
        if (f380552s == true) goto L34;
        f380552s = true;     // Catch: Throwable -> L50
        c5a.c.f("FunctorView", "Failed to load WebView draw functor support; falling back to platform canvas API. sdk=" + Build.VERSION.SDK_INT, th);     // Catch: Throwable -> L50
        goto L34
    L36:
        if (r105 <= 28) goto L39;
        f380549p = c("android.graphics.RecordingCanvas").getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});     // Catch: Throwable -> L50
        goto L47
    L39:
        if (r105 <= 22) goto L42;
        f380549p = c("android.view.DisplayListCanvas").getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});     // Catch: Throwable -> L50
        goto L47
    L42:
        if (r105 != 21) goto L44;
        f380549p = c("android.view.HardwareCanvas").getMethod("callDrawGLFunction", new Class[]{Long.TYPE});     // Catch: Throwable -> L50
        goto L47
    L44:
        if (r105 != 22) goto L46;
        f380549p = c("android.view.HardwareCanvas").getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});     // Catch: Throwable -> L50
        goto L47
    L46:
        f380549p = c("android.view.HardwareCanvas").getMethod("callDrawGLFunction", new Class[]{Integer.TYPE});     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (f380553t == true) goto L55;
        f380553t = true;     // Catch: Throwable -> L56
        c5a.c.f("FunctorView", "Failed to resolve draw GL function. sdk=" + Build.VERSION.SDK_INT, th);     // Catch: Throwable -> L56
    L55:
        return false;
    L16:
        th = move-exception;
        if (f380551r == true) goto L59;
        f380551r = true;     // Catch: Throwable -> L56
        c5a.c.f("FunctorView", "Failed to initialize pre-Q functor reflection methods. sdk=" + Build.VERSION.SDK_INT, th);     // Catch: Throwable -> L56
        goto L59
    }

    public final void e() {
        if (this.f380559e != (-1)) goto L6;
        return;
    L6:
        if (this.f380555a != (-1)) goto L8;
        return;
    L8:
        long r100 = System.currentTimeMillis() - this.f380555a;
        if (r100 < 10000) goto L11;
        k();
        return;
    L11:
        if (this.f380556b == false) goto L13;
        return;
    L13:
        this.f380556b = true;
        final WeakReference r101 = new WeakReference(this);
        Runnable r102 = new h(r101);
        long r103 = 10000 - r100;
        com.lynx.clay.util.a.a().postDelayed(r102, r103);
    }

    public void g() {
        if (this.f380558d == (-1)) goto L6;
        k();
        nativeDestroyDrawFunctor(this.f380558d);
        this.f380558d = -1;
        this.f380559e = -1;
    L6:
        if (this.f380560f == (-1)) goto L9;
        this.f380560f = -1;
        return;
    }

    public final void h() {
        if (this.f380558d != (-1)) goto L5;
    L6:
        boolean r100 = this.f380566l;
        if (f() == true) goto L9;
        long[] r101 = {-1, -1};
    L23:
        this.f380558d = r101[0];
        this.f380559e = r101[1];
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 29) goto L25;
        r101 = nativeCreateGLFunctor(0, r100);
        goto L23
    L25:
        Method r102 = f380550q;     // Catch: Throwable -> L16
        if (r102 != null) goto L13;
        long r103 = DrawFunctor.a();     // Catch: Throwable -> L16
    L14:
        r101 = nativeCreateGLFunctor(r103, r100);     // Catch: Throwable -> L16
        goto L23
    L13:
        r103 = ((Long) r102.invoke(null, new Object[0])).longValue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (f380554u == true) goto L20;
        f380554u = true;
        c5a.c.f("FunctorView", "Failed to create WebView functor, returning unavailable sentinel. sdk=" + Build.VERSION.SDK_INT + ", syncMode=" + r100, th);
    L20:
        r101 = new long[]{-1, -1};
        goto L23
    L5:
        if (this.f380559e == (-1)) goto L6;
    }

    public final void k() {
        if (Build.VERSION.SDK_INT < 29) goto L44;
    L14:
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 29) goto L37;
        if (r100 <= 23) goto L19;
        Method r101 = f380546m;
        if (r101 == null) goto L37;
        long r102 = this.f380559e;
        if (r102 == (-1)) goto L37;
        r101.invoke(null, new Object[]{Long.valueOf(r102), Boolean.TRUE});     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        i(th);
        goto L37
    L19:
        if (f380546m == null) goto L37;
        Method r103 = f380548o;
        if (r103 == null) goto L37;
        if (this.f380559e == (-1)) goto L37;
        Object r104 = r103.invoke(this, new Object[0]);     // Catch: Throwable -> L26
        f380546m.invoke(r104, new Object[]{Long.valueOf(this.f380559e), Boolean.TRUE});     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        i(th);
    L37:
        if (Build.VERSION.SDK_INT >= 29) goto L46;
        postInvalidateOnAnimation();
        return;
    L46:
        return;
    L44:
    L12:
        th = move-exception;
        c5a.c.f("FunctorView", "Failed to detach functor via reflection.", th);
        goto L14
    L5:
        if (f380547n == null) goto L14;
        Method r105 = f380548o;     // Catch: Throwable -> L12
        if (r105 == null) goto L14;
        if (this.f380559e == (-1)) goto L14;
        Object r106 = r105.invoke(this, new Object[0]);     // Catch: Throwable -> L12
        f380547n.invoke(r106, new Object[]{Long.valueOf(this.f380559e)});     // Catch: Throwable -> L12
        goto L14
    }

    public final void l() {
        if (this.f380560f == (-1)) goto L9;
        long r100 = this.f380558d;
        if (r100 == (-1)) goto L10;
        nativeUpdateSharedImage(r100);
        return;
    L10:
        return;
    }

    public void notifyResourcesDestroyed() {
        if (this.f380561g == true) goto L6;
        this.f380561g = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f380557c != null) goto L6;
        this.f380557c = new a(this);
        getContext().registerComponentCallbacks(this.f380557c);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f380557c == null) goto L6;
        getContext().unregisterComponentCallbacks(this.f380557c);
        this.f380557c = null;
        return;
    }

    public FunctorView(Context r100) {
        this(r100, null);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c(String r100) throws ClassNotFoundException {
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

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class d(ClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = r100.loadClass("com.android.webview.chromium.DrawFunctor");     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.android.webview.chromium.DrawFunctor");     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.android.webview.chromium.DrawFunctor");
    L12:
        throw th;
    L34:
        Class<?> r104 = r100.loadClass("com.android.webview.chromium.DrawFunctor");     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.android.webview.chromium.DrawFunctor");     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.android.webview.chromium.DrawFunctor");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass("com.android.webview.chromium.DrawFunctor");
    }

    private void setWindowVisibilityInternal(boolean r100) {
        boolean r101 = this.f380564j;
        if (Build.VERSION.SDK_INT > 21) goto L8;
        if (r100 == false) goto L8;
        if (this.f380565k == true) goto L8;
        boolean r102 = true;
    L9:
        this.f380564j = r101 | r102;
        this.f380565k = r100;
        if (r100 == false) goto L12;
        long r103 = -1;
    L13:
        this.f380555a = r103;
        if (r100 == true) goto L17;
        e();
        return;
    L17:
        return;
    L12:
        r103 = System.currentTimeMillis();
    L8:
        r102 = false;
        goto L9
    }

    public final void i(Throwable r100) {
        if (this.f380563i == false) goto L5;
        return;
    L5:
        this.f380563i = true;
        c5a.c.f("FunctorView", "Failed to invoke GL functor for reclaim. sdk=" + Build.VERSION.SDK_INT + ", handle=" + this.f380559e, r100);
    }

    public final boolean j(Canvas r100) {
        h();
        long r101 = this.f380559e;
        if (r101 != (-1)) goto L16;
        return false;
    L16:
    L11:
        th = move-exception;
        if (this.f380562h == true) goto L15;
        this.f380562h = true;
        c5a.c.f("FunctorView", "Failed to request GL functor draw. sdk=" + Build.VERSION.SDK_INT + ", handle=" + this.f380559e + ", syncMode=" + this.f380566l, th);
    L15:
        return false;
    L7:
        if (Build.VERSION.SDK_INT >= 29) goto L9;
        f380549p.invoke(r100, new Object[]{Long.valueOf(r101)});     // Catch: Throwable -> L11
    L10:
        return true;
    L9:
        f380549p.invoke(r100, new Object[]{Integer.valueOf((int) r101)});     // Catch: Throwable -> L11
        goto L10
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (r100.isHardwareAccelerated() == false) goto L8;
        if (j(r100) == true) goto L8;
        return;
    L8:
        if (this.f380564j == false) goto L11;
        getRootView().invalidate();
        this.f380564j = false;
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        if (r100 != 0) goto L4;
        boolean r101 = true;
    L6:
        if (this.f380565k != r101) goto L8;
        return;
    L8:
        setWindowVisibilityInternal(r101);
        return;
    L4:
        r101 = false;
        goto L6
    }

    public void setSharedImageSink(long r100) {
        h();
        long r101 = this.f380558d;
        if (r101 != (-1)) goto L5;
        return;
    L5:
        nativeSetSharedImageSink(r101, r100);
        this.f380560f = r100;
    }

    public FunctorView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FunctorView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, false);
    }

    public FunctorView(Context r100, AttributeSet r101, int r102, boolean r103) {
        super(r100, r101, r102);
        this.f380555a = -1;
        this.f380556b = false;
        this.f380557c = null;
        this.f380558d = -1;
        this.f380559e = -1;
        this.f380560f = -1;
        this.f380561g = false;
        this.f380562h = false;
        this.f380563i = false;
        this.f380564j = true;
        this.f380566l = false;
        this.f380566l = r103;
        setWillNotDraw(false);
        h();
    }
}
