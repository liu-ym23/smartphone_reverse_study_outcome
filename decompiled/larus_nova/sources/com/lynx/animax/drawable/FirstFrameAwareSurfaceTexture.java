package com.lynx.animax.drawable;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import y4a.d;

/* JADX INFO: loaded from: classes32.dex */
public class FirstFrameAwareSurfaceTexture extends SurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f380281h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<a> f380282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f380283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f380284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<TextureView> f380285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f380287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<Surface> f380288g;

    public interface a {
        void onFirstFrameAvailable();
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<FirstFrameAwareSurfaceTexture> f380289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<SurfaceTexture.OnFrameAvailableListener> f380290b;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            FirstFrameAwareSurfaceTexture r101 = this.f380289a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            SurfaceTexture.OnFrameAvailableListener r102 = this.f380290b.get();
            if (r102 == null) goto L9;
            r102.onFrameAvailable(r101);
            return;
        }

        public b(Looper r100, FirstFrameAwareSurfaceTexture r101, SurfaceTexture.OnFrameAvailableListener r102) {
            super(r100);
            this.f380289a = new WeakReference(r101);
            this.f380290b = new WeakReference(r102);
        }
    }

    public FirstFrameAwareSurfaceTexture() {
        super(0);
        new Handler(Looper.getMainLooper());
        this.f380286e = false;
        this.f380287f = false;
        super.setOnFrameAvailableListener(this, d.a());
    }

    public final synchronized Surface c() {
        monitor-enter(this);
        WeakReference<Surface> r100 = this.f380288g;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        Surface r101 = r100.get();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Field r100 = SurfaceTexture.class.getDeclaredField("mOnSetFrameRateHandler");     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        if (r100.get(this) != null) goto L12;
        return true;
    L12:
        return false;
    L7:
        th = move-exception;
        AnimaXLog.a("AnimaXFirstFrameAwareSurfaceTexture", "isOnSetFrameRateHandlerNull fail: " + th.getMessage());
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.graphics.SurfaceTexture$OnSetFrameRateListener");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.graphics.SurfaceTexture$OnSetFrameRateListener");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.graphics.SurfaceTexture$OnSetFrameRateListener");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.graphics.SurfaceTexture$OnSetFrameRateListener");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.graphics.SurfaceTexture$OnSetFrameRateListener");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.graphics.SurfaceTexture$OnSetFrameRateListener");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.graphics.SurfaceTexture$OnSetFrameRateListener");
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void finalize() throws Throwable {
        monitor-enter(this);
        this.f380286e = true;     // Catch: Throwable -> L13
        Surface r100 = c();     // Catch: Throwable -> L13
        if (r100 != null) goto L8;
    L10:
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "FirstFrameAwareSurfaceTexture finalize: " + this);     // Catch: Throwable -> L13
        super.finalize();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L8:
        if (r100.isValid() == false) goto L10;
        r100.release();     // Catch: Throwable -> L13
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "release Surface in finalize: " + r100);     // Catch: Throwable -> L13
        g(null);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.graphics.SurfaceTexture
    public synchronized void release() {
        monitor-enter(this);
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "release with " + this);     // Catch: Throwable -> L39
        if (this.f380286e == false) goto L10;
        AnimaXLog.d("AnimaXFirstFrameAwareSurfaceTexture", "release() called after finalize(). Skip releasing SurfaceTexture. " + this);     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L10:
        if (this.f380287f == false) goto L15;
        AnimaXLog.d("AnimaXFirstFrameAwareSurfaceTexture", "release() called multiple times. " + this);     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L15:
        this.f380287f = true;     // Catch: Throwable -> L39
        Surface r100 = c();     // Catch: Throwable -> L39
        if (r100 == null) goto L21;
        if (r100.isValid() == false) goto L21;
        r100.release();     // Catch: Throwable -> L39
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "release Surface: " + r100);     // Catch: Throwable -> L39
        g(null);     // Catch: Throwable -> L39
    L21:
        if (Build.VERSION.SDK_INT >= 26) goto L23;
    L42:
        Field r101 = SurfaceTexture.class.getDeclaredField("mSurfaceTexture");     // Catch: Throwable -> L29
        r101.setAccessible(true);     // Catch: Throwable -> L29
        long r102 = r101.getLong(this);     // Catch: Throwable -> L29
    L32:
        if (r102 != 0) goto L36;
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "surfaceTextureField is 0, skip release");     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L36:
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "release SurfaceTexture: " + this);     // Catch: Throwable -> L39
        super.release();     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        AnimaXLog.a("AnimaXFirstFrameAwareSurfaceTexture", "fail to getSurfaceTextureField: " + th.getMessage());     // Catch: Throwable -> L39
        r102 = -1;
        goto L32
    L23:
        if (isReleased() == false) goto L42;
        AnimaXLog.d("AnimaXFirstFrameAwareSurfaceTexture", "already released: " + this);     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static void b(Object r110) throws Exception {
        if (r110 != null) goto L6;
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "clearMiuiStubCallbackIfNeeded: Skipped, stub is null.");
        return;
    L6:
        Field r100 = r110.getClass().getDeclaredField("mOnFrameAvailableHandler");
        r100.setAccessible(true);
        Object r101 = r100.get(r110);
        Field r102 = r110.getClass().getDeclaredField("mUpdateListener");
        r102.setAccessible(true);
        Object r103 = r102.get(r110);
        Method r104 = r110.getClass().getMethod("setOnFrameAvailableHandler", new Class[]{Handler.class});
        r104.setAccessible(true);
        r104.invoke(r110, new Object[]{null});
        r102.set(r110, null);
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "clearMiuiStubCallbackIfNeeded: Finished cleanup, origin handler: " + r101 + ", origin update listener: " + r103 + ", current handler: " + r100.get(r110) + ", current update listener: " + r102.get(r110));
    }

    public final synchronized void g(Surface r100) {
        monitor-enter(this);
        this.f380288g = new WeakReference(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r100) {
        b r101 = this.f380283b;
        if (r101 == null) goto L9;
        Message r102 = r101.obtainMessage(0);
        if (Build.VERSION.SDK_INT < 22) goto L7;
        r102.setAsynchronous(true);
    L7:
        this.f380283b.sendMessage(r102);
    L9:
        if (this.f380284c == true) goto L18;
        this.f380284c = true;
        WeakReference<a> r103 = this.f380282a;
        if (r103 == null) goto L13;
        a r104 = r103.get();
    L14:
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "trigger first frame callback with " + r104);
        if (r104 == null) goto L19;
        r104.onFirstFrameAvailable();
        return;
    L19:
        return;
    L13:
        r104 = null;
        goto L14
    }

    @Override // android.graphics.SurfaceTexture
    public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r100) {
        e(r100, null);
    }

    public final void e(SurfaceTexture.OnFrameAvailableListener r100, Handler r101) {
        if (Build.VERSION.SDK_INT < 25) goto L22;
        if (r100 == null) goto L22;
        if (this.f380283b == null) goto L22;
        WeakReference<TextureView> r102 = this.f380285d;
        if (r102 == null) goto L12;
        final TextureView r103 = r102.get();
    L13:
        if (r103 == null) goto L22;
        Runnable r104 = new s4a.a(r103);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        r104.run();
        goto L22
    L21:
        d.a().post(r104);
        goto L22
    L18:
        r105 = false;
        goto L19
    L12:
        r103 = null;
    L22:
        if (r100 == null) goto L27;
        if (r101 == null) goto L25;
        Looper r106 = r101.getLooper();
    L26:
        this.f380283b = new b(r106, this, r100);
        return;
    L25:
        r106 = Looper.getMainLooper();
        goto L26
    L27:
        this.f380283b = null;
    }

    @Override // android.graphics.SurfaceTexture
    public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r100, Handler r101) {
        e(r100, r101);
        if (Build.VERSION.SDK_INT < 35) goto L7;
        final WeakReference r102 = new WeakReference(this);
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "clearInternalFrameRateListenerAsync: Posting cleanup action");
        Runnable r103 = new s4a.b(r102);
        d.a().post(r103);
        return;
    }
}
