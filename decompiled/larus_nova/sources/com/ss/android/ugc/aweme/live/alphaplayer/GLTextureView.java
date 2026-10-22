package com.ss.android.ugc.aweme.live.alphaplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes40.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final GLThreadManager f451015l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMonitor f451016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<GLTextureView> f451017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GLThread f451018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Renderer f451019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f451020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EGLConfigChooser f451021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EGLContextFactory f451022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EGLWindowSurfaceFactory f451023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f451024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f451025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f451026k;

    public abstract class BaseConfigChooser implements EGLConfigChooser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f451027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f451028b;

        public BaseConfigChooser(GLTextureView r100, int[] r101) {
            this.f451028b = r100;
            if (r100.f451025j != 2) goto L6;
            int r102 = r101.length;
            int[] r103 = new int[r102 + 2];
            int r104 = r102 - 1;
            System.arraycopy(r101, 0, r103, 0, r104);
            r103[r104] = 12352;
            r103[r102] = 4;
            r103[r102 + 1] = 12344;
            r101 = r103;
        L6:
            this.f451027a = r101;
        }
    }

    public class ComponentSizeChooser extends BaseConfigChooser {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f451029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f451030d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f451031e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f451032f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f451033g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f451034h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f451035i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f451036j;

        public ComponentSizeChooser(GLTextureView r100, int r101, int r102) {
            this.f451036j = r100;
            super(r100, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, r101, 12325, r102, 12326, 0, 12344});
            this.f451029c = new int[1];
            this.f451030d = 8;
            this.f451031e = 8;
            this.f451032f = 8;
            this.f451033g = r101;
            this.f451034h = r102;
            this.f451035i = 0;
        }

        public final int a(EGL10 r100, EGLDisplay r101, EGLConfig r102, int r103) {
            if (r100.eglGetConfigAttrib(r101, r102, r103, this.f451029c) == true) goto L5;
            return 0;
        L5:
            return this.f451029c[0];
        }
    }

    public class DefaultContextFactory implements EGLContextFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f451037a;

        public DefaultContextFactory(GLTextureView r100) {
            this.f451037a = r100;
        }
    }

    public static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public /* synthetic */ DefaultWindowSurfaceFactory(int r100) {
            this();
        }
    }

    public interface EGLConfigChooser {
    }

    public interface EGLContextFactory {
    }

    public interface EGLWindowSurfaceFactory {
    }

    public static class EglHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<GLTextureView> f451038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EGL10 f451039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public EGLDisplay f451040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EGLSurface f451041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public EGLConfig f451042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EGLContext f451043f;

        public final boolean a() {
        L34:
            e = move-exception;
            e.getStackTrace().toString();
            return false;
        L4:
            if (this.f451039b == null) goto L33;
            if (this.f451040c == null) goto L31;
            if (this.f451042e == null) goto L29;
            b();     // Catch: Exception -> L34
            GLTextureView r100 = this.f451038a.get();     // Catch: Exception -> L34
            EGLSurface r101 = null;
            if (r100 == null) goto L14;
            EGLWindowSurfaceFactory r102 = r100.f451023h;     // Catch: Exception -> L34
            EGL10 r103 = this.f451039b;     // Catch: Exception -> L34
            EGLDisplay r104 = this.f451040c;     // Catch: Exception -> L34
            EGLConfig r105 = this.f451042e;     // Catch: Exception -> L34
            SurfaceTexture r106 = r100.getSurfaceTexture();     // Catch: Exception -> L34
            ((DefaultWindowSurfaceFactory) r102).getClass();     // Catch: Exception -> L34
            r101 = r103.eglCreateWindowSurface(r104, r105, r106, null);     // Catch: IllegalArgumentException -> L37 Exception -> L34
        L13:
            this.f451041d = r101;     // Catch: Exception -> L34
        L15:
            EGLSurface r107 = this.f451041d;     // Catch: Exception -> L34
            if (r107 != null) goto L18;
        L26:
            this.f451039b.eglGetError();     // Catch: Exception -> L34
            return false;
        L18:
            if (r107 == EGL10.EGL_NO_SURFACE) goto L26;
            if (this.f451039b.eglMakeCurrent(this.f451040c, r107, r107, this.f451043f) == true) goto L24;
            this.f451039b.eglGetError();     // Catch: Exception -> L34
            return false;
        L24:
            return true;
        L14:
            this.f451041d = null;     // Catch: Exception -> L34
            goto L15
        L29:
            throw new RuntimeException("mEglConfig not initialized");     // Catch: Exception -> L34
        L31:
            throw new RuntimeException("eglDisplay not initialized");     // Catch: Exception -> L34
        L33:
            throw new RuntimeException("egl not initialized");     // Catch: Exception -> L34
        }

        public final void b() {
            EGLSurface r100 = this.f451041d;
            if (r100 == null) goto L11;
            EGLSurface r101 = EGL10.EGL_NO_SURFACE;
            if (r100 == r101) goto L12;
            this.f451039b.eglMakeCurrent(this.f451040c, r101, r101, EGL10.EGL_NO_CONTEXT);
            GLTextureView r102 = this.f451038a.get();
            if (r102 == null) goto L9;
            EGLWindowSurfaceFactory r103 = r102.f451023h;
            EGL10 r104 = this.f451039b;
            EGLDisplay r105 = this.f451040c;
            EGLSurface r106 = this.f451041d;
            ((DefaultWindowSurfaceFactory) r103).getClass();
            r104.eglDestroySurface(r105, r106);
        L9:
            this.f451041d = null;
            return;
        L12:
            return;
        }

        public final void c() {
            if (this.f451043f == null) goto L10;
            GLTextureView r100 = this.f451038a.get();
            if (r100 == null) goto L9;
            EGLContextFactory r101 = r100.f451022g;
            EGL10 r102 = this.f451039b;
            EGLDisplay r103 = this.f451040c;
            EGLContext r104 = this.f451043f;
            ((DefaultContextFactory) r101).getClass();
            if (r102.eglDestroyContext(r103, r104) == true) goto L9;
            Objects.toString(r103);
            Objects.toString(r104);
            r102.eglGetError();
        L9:
            this.f451043f = null;
        L10:
            EGLDisplay r105 = this.f451040c;
            if (r105 == null) goto L14;
            this.f451039b.eglTerminate(r105);
            this.f451040c = null;
            return;
        }

        public final void d() {
            EGL10 r100 = (EGL10) EGLContext.getEGL();
            this.f451039b = r100;
            EGLDisplay r101 = r100.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f451040c = r101;
            if (r101 == EGL10.EGL_NO_DISPLAY) goto L61;
            if (this.f451039b.eglInitialize(r101, new int[2]) == false) goto L59;
            GLTextureView r102 = this.f451038a.get();
            if (r102 != null) goto L9;
            this.f451042e = null;
            this.f451043f = null;
        L43:
            EGLContext r103 = this.f451043f;
            if (r103 != null) goto L46;
        L49:
            EGLSurface r104 = null;
            this.f451043f = null;
            this.f451039b.eglGetError();
        L50:
            this.f451041d = r104;
            return;
        L46:
            if (r103 == EGL10.EGL_NO_CONTEXT) goto L49;
            r104 = null;
            goto L50
        L9:
            EGLConfigChooser r105 = r102.f451021f;
            EGL10 r110 = this.f451039b;
            EGLDisplay r111 = this.f451040c;
            BaseConfigChooser r106 = (BaseConfigChooser) r105;
            int[] r112 = new int[1];
            if (r110.eglChooseConfig(r111, r106.f451027a, null, 0, r112) == true) goto L16;
            GLTextureView r107 = r106.f451028b;
            String r108 = Log.getStackTraceString(new IllegalArgumentException("eglChooseConfig failed"));
            IMonitor r109 = r107.f451016a;
            if (r109 == null) goto L15;
            r109.monitor(false, "unknown", 0, 0, r108);
        L15:
            throw new IllegalArgumentException("eglChooseConfig failed");
        L16:
            int r113 = r112[0];
            if (r113 <= 0) goto L57;
            EGLConfig[] r114 = new EGLConfig[r113];
            if (r110.eglChooseConfig(r111, r106.f451027a, r114, r113, r112) == false) goto L55;
            ComponentSizeChooser r115 = (ComponentSizeChooser) r106;
            int r116 = 0;
        L21:
            if (r116 >= r113) goto L36;
            EGLConfig r117 = r114[r116];
            int r118 = r115.a(r110, r111, r117, 12325);
            int r119 = r115.a(r110, r111, r117, 12326);
            if (r118 < r115.f451034h) goto L35;
            if (r119 < r115.f451035i) goto L35;
            int r120 = r115.a(r110, r111, r117, 12324);
            int r121 = r115.a(r110, r111, r117, 12323);
            int r122 = r115.a(r110, r111, r117, 12322);
            int r123 = r115.a(r110, r111, r117, 12321);
            if (r120 != r115.f451030d) goto L35;
            if (r121 != r115.f451031e) goto L35;
            if (r122 != r115.f451032f) goto L35;
            if (r123 != r115.f451033g) goto L35;
        L37:
            if (r117 == null) goto L53;
            this.f451042e = r117;
            EGLContextFactory r124 = r102.f451022g;
            EGL10 r125 = this.f451039b;
            EGLDisplay r126 = this.f451040c;
            DefaultContextFactory r127 = (DefaultContextFactory) r124;
            r127.getClass();
            int r128 = r127.f451037a.f451025j;
            int[] r129 = {12440, r128, 12344};
            EGLContext r130 = EGL10.EGL_NO_CONTEXT;
            if (r128 != 0) goto L42;
            r129 = null;
        L42:
            this.f451043f = r125.eglCreateContext(r126, r117, r130, r129);
            goto L43
        L53:
            throw new IllegalArgumentException("No config chosen");
        L35:
            r116 = r116 + 1;
            goto L21
        L36:
            r117 = null;
            goto L37
        L55:
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        L57:
            throw new IllegalArgumentException("No configs match configSpec");
        L59:
            throw new RuntimeException("eglInitialize failed");
        L61:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public EglHelper(WeakReference<GLTextureView> r100) {
            this.f451038a = r100;
        }
    }

    public static class GLThread extends PthreadThreadV2 {
        public boolean A;
        public boolean B;
        public boolean C;
        public boolean D;
        public boolean E;
        public int F;
        public int G;
        public int H;
        public boolean I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public boolean f451044J;
        public final ArrayList<Runnable> K;
        public boolean L;
        public EglHelper M;
        public final WeakReference<GLTextureView> N;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f451045v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f451046w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f451047x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f451048y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f451049z;

        public final void guardedRun() throws InterruptedException {
            this.M = new EglHelper(this.N);
            this.C = false;
            this.D = false;
            boolean r100 = false;
            boolean r101 = false;
            boolean r102 = false;
            GL10 r103 = null;
            boolean r104 = false;
            boolean r105 = false;
            boolean r106 = false;
            boolean r110 = false;
            int r111 = 0;
            int r112 = 0;
            boolean r113 = false;
        L3:
            Runnable r114 = null;
        L195:
            GLThreadManager r115 = GLTextureView.f451015l;     // Catch: Throwable -> L168
            monitor-enter(r115);     // Catch: Throwable -> L168
        L190:
        L177:
            th = move-exception;
            throw th;     // Catch: Throwable -> L168
        L7:
            if (this.f451045v == true) goto L8;
            if (this.K.isEmpty() == false) goto L19;
            boolean r107 = this.f451048y;     // Catch: Throwable -> L177
            boolean r108 = this.f451047x;     // Catch: Throwable -> L177
            if (r107 == r108) goto L23;
            this.f451048y = r108;     // Catch: Throwable -> L177
            GLTextureView.f451015l.notifyAll();     // Catch: Throwable -> L177
        L25:
            if (this.E == false) goto L27;
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
            stopEglContextLocked();     // Catch: Throwable -> L177
            this.E = false;     // Catch: Throwable -> L177
            r102 = true;
        L27:
            if (r100 == false) goto L29;
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
            stopEglContextLocked();     // Catch: Throwable -> L177
            r100 = false;
        L29:
            if (r108 == true) goto L31;
        L33:
            if (r108 == true) goto L35;
        L44:
            if (r108 == false) goto L49;
            if (GLTextureView.f451015l.c() == false) goto L49;
            this.M.c();     // Catch: Throwable -> L177
        L49:
            if (this.f451049z == true) goto L57;
            if (this.B == true) goto L57;
            if (this.D == false) goto L55;
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
        L55:
            this.B = true;     // Catch: Throwable -> L177
            this.A = false;     // Catch: Throwable -> L177
            GLTextureView.f451015l.notifyAll();     // Catch: Throwable -> L177
        L57:
            if (this.f451049z == true) goto L59;
        L61:
            if (r101 == false) goto L64;
            this.f451044J = true;     // Catch: Throwable -> L177
            GLTextureView.f451015l.notifyAll();     // Catch: Throwable -> L177
            r101 = false;
            r113 = false;
        L64:
            if (readyToDraw() == true) goto L66;
            boolean r116 = r100;
        L176:
            GLTextureView.f451015l.wait();     // Catch: Throwable -> L177
            r100 = r116;
            goto L190
        L66:
            if (this.C == true) goto L94;
            if (r102 == false) goto L69;
            r116 = r100;
            LogWriter r109 = null;
            r102 = false;
        L97:
            if (this.C == false) goto L102;
            if (this.D == true) goto L102;
            this.D = true;     // Catch: Throwable -> L177
            r105 = true;
            r106 = true;
            r110 = true;
        L102:
            if (this.D == false) goto L176;
            if (this.L == false) goto L106;
            r111 = this.F;     // Catch: Throwable -> L177
            r112 = this.G;     // Catch: Throwable -> L177
            boolean r117 = false;
            this.L = false;     // Catch: Throwable -> L177
            r105 = true;
            r110 = true;
            r113 = true;
        L107:
            this.I = r117;     // Catch: Throwable -> L177
            GLTextureView.f451015l.notifyAll();     // Catch: Throwable -> L177
        L108:
            monitor-exit(r115);     // Catch: Throwable -> L177
            if (r114 != null) goto L110;
            if (r105 == true) goto L113;
        L124:
            if (r106 == false) goto L139;
            EglHelper r118 = this.M;     // Catch: Throwable -> L168
            GL r119 = r118.f451043f.getGL();     // Catch: Throwable -> L168
            GLTextureView r120 = r118.f451038a.get();     // Catch: Throwable -> L168
            if (r120 == null) goto L138;
            GLThreadManager r121 = GLTextureView.f451015l;     // Catch: Throwable -> L168
            int r122 = r120.f451024i;     // Catch: Throwable -> L168
            if ((r122 & 3) == 0) goto L138;
            if ((r122 & 1) == 0) goto L132;
            int r123 = 1;
        L134:
            if ((r122 & 2) == 0) goto L136;
            LogWriter r124 = new LogWriter();     // Catch: Throwable -> L168
        L137:
            r119 = GLDebugHelper.wrap(r119, r123, r124);     // Catch: Throwable -> L168
            goto L138
        L136:
            r124 = r109;
            goto L137
        L132:
            r123 = 0;
        L138:
            r103 = (GL10) r119;     // Catch: Throwable -> L168
            GLTextureView.f451015l.a(r103);     // Catch: Throwable -> L168
            r106 = false;
        L139:
            if (r104 == false) goto L144;
            GLTextureView r125 = this.N.get();     // Catch: Throwable -> L168
            if (r125 == null) goto L143;
            r125.f451019d.onSurfaceCreated(r103, this.M.f451042e);     // Catch: Throwable -> L168
        L143:
            r104 = false;
        L144:
            if (r110 == false) goto L149;
            GLTextureView r126 = this.N.get();     // Catch: Throwable -> L168
            if (r126 == null) goto L148;
            r126.f451019d.onSurfaceChanged(r103, r111, r112);     // Catch: Throwable -> L168
        L148:
            r110 = false;
        L149:
            GLTextureView r127 = this.N.get();     // Catch: Throwable -> L168
            if (r127 == null) goto L152;
            r127.f451019d.onDrawFrame(r103);     // Catch: Throwable -> L168
        L152:
            EglHelper r128 = this.M;     // Catch: Throwable -> L168
            if (r128.f451039b.eglSwapBuffers(r128.f451040c, r128.f451041d) == true) goto L155;
            int r129 = r128.f451039b.eglGetError();     // Catch: Throwable -> L168
        L156:
            if (r129 == 12288) goto L172;
            if (r129 == 12302) goto L170;
            GLThreadManager r130 = GLTextureView.f451015l;     // Catch: Throwable -> L168
            monitor-enter(r130);     // Catch: Throwable -> L168
            this.A = true;     // Catch: Throwable -> L165
            r130.notifyAll();     // Catch: Throwable -> L165
            monitor-exit(r130);     // Catch: Throwable -> L165
        L165:
            th = move-exception;
            throw th;     // Catch: Throwable -> L168
        L170:
            r116 = true;
        L172:
            if (r113 == true) goto L173;
        L119:
            r100 = r116;
            goto L195
        L173:
            r100 = r116;
            r101 = true;
            goto L195
        L155:
            r129 = 12288;
            goto L156
        L113:
            if (this.M.a() == true) goto L123;
            GLThreadManager r131 = GLTextureView.f451015l;     // Catch: Throwable -> L168
            monitor-enter(r131);     // Catch: Throwable -> L168
            this.A = true;     // Catch: Throwable -> L120
            r131.notifyAll();     // Catch: Throwable -> L120
            monitor-exit(r131);     // Catch: Throwable -> L120
        L120:
            th = move-exception;
            throw th;     // Catch: Throwable -> L168
        L123:
            r105 = false;
            goto L124
        L110:
            r114.run();     // Catch: Throwable -> L168
            r100 = r116;
            goto L3
        L106:
            r117 = false;
            goto L107
        L69:
            GLThreadManager r132 = GLTextureView.f451015l;     // Catch: Throwable -> L177
            GLThread r133 = r132.f451054e;     // Catch: Throwable -> L177
            if (r133 == this) goto L82;
            if (r133 == null) goto L82;
            r116 = r100;
            if (r132.f451050a == true) goto L77;
            r132.f451050a = true;     // Catch: Throwable -> L177
        L77:
            if (r132.f451052c == true) goto L83;
            if (r133 == null) goto L81;
            r133.E = true;     // Catch: Throwable -> L177
            r132.notifyAll();     // Catch: Throwable -> L177
        L81:
            boolean r134 = false;
        L84:
            if (r134 == true) goto L196;
        L95:
            r109 = null;
            goto L97
        L196:
            this.M.d();     // Catch: RuntimeException -> L88 Throwable -> L177
        L87:
            this.C = true;     // Catch: Throwable -> L177
            r132.notifyAll();     // Catch: Throwable -> L177
            r109 = null;
            r104 = true;
        L88:
            e = move-exception;
            GLThreadManager r135 = GLTextureView.f451015l;     // Catch: Throwable -> L177
            if (r135.f451054e != this) goto L92;
            r135.f451054e = null;     // Catch: Throwable -> L177
        L92:
            r135.notifyAll();     // Catch: Throwable -> L177
            throw e;     // Catch: Throwable -> L177
        L83:
            r134 = true;
        L82:
            r116 = r100;
            r132.f451054e = this;     // Catch: Throwable -> L177
            r132.notifyAll();     // Catch: Throwable -> L177
            goto L83
        L94:
            r116 = r100;
            goto L95
        L59:
            if (this.B == false) goto L61;
            this.B = false;     // Catch: Throwable -> L177
            GLTextureView.f451015l.notifyAll();     // Catch: Throwable -> L177
            goto L61
        L35:
            if (this.C == false) goto L44;
            GLTextureView r136 = this.N.get();     // Catch: Throwable -> L177
            if (r136 != null) goto L39;
            boolean r137 = false;
        L40:
            if (r137 == true) goto L42;
        L43:
            stopEglContextLocked();     // Catch: Throwable -> L177
            goto L44
        L42:
            if (GLTextureView.f451015l.b() == false) goto L44;
        L39:
            r137 = r136.f451026k;     // Catch: Throwable -> L177
            goto L40
        L31:
            if (this.D == false) goto L33;
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
            goto L33
        L23:
            r108 = false;
            goto L25
        L19:
            r114 = this.K.remove(0);     // Catch: Throwable -> L177
            r116 = r100;
            r109 = null;
            goto L108
        L8:
            monitor-exit(r115);     // Catch: Throwable -> L177
            GLThreadManager r138 = GLTextureView.f451015l;
            monitor-enter(r138);
            stopEglSurfaceLocked();     // Catch: Throwable -> L14
            stopEglContextLocked();     // Catch: Throwable -> L14
            monitor-exit(r138);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L168:
            th = move-exception;
            monitor-enter(GLTextureView.f451015l);
            stopEglSurfaceLocked();     // Catch: Throwable -> L185
            stopEglContextLocked();     // Catch: Throwable -> L185
            throw th;
        L185:
            th = move-exception;
            throw th;
        }

        public final boolean readyToDraw() {
            if (this.f451048y == false) goto L5;
        L17:
            return false;
        L5:
            if (this.f451049z == false) goto L17;
            if (this.A == true) goto L17;
            if (this.F <= 0) goto L17;
            if (this.G <= 0) goto L17;
            if (this.I == false) goto L15;
            return true;
        L15:
            if (this.H != 1) goto L17;
            return true;
        }

        public final void requestExitAndWait() {
            GLThreadManager r100 = GLTextureView.f451015l;
            monitor-enter(r100);
            this.f451045v = true;     // Catch: Throwable -> L13
            r100.notifyAll();     // Catch: Throwable -> L13
        L7:
            if (this.f451046w == true) goto L11;
            GLTextureView.f451015l.wait();     // Catch: InterruptedException -> L10 Throwable -> L13
        L10:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r100);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            ThreadMethodProxy.setName(this, "GLThread " + getId());     // Catch: Throwable -> L20
            guardedRun();     // Catch: Throwable -> L5 InterruptedException -> L25
        L5:
            th = move-exception;
            GLTextureView.f451015l.d(this);     // Catch: Throwable -> L20
            throw th;     // Catch: Throwable -> L20
        L8:
            GLThreadManager r100 = GLTextureView.f451015l;     // Catch: Throwable -> L20
            monitor-enter(r100);     // Catch: Throwable -> L20
            this.f451046w = true;     // Catch: Throwable -> L17
            if (r100.f451054e != this) goto L14;
            r100.f451054e = null;     // Catch: Throwable -> L17
        L14:
            r100.notifyAll();     // Catch: Throwable -> L17
            monitor-exit(r100);     // Catch: Throwable -> L20
            return;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L31;
            throw th;
        }

        public final void stopEglContextLocked() {
            if (this.C == false) goto L9;
            this.M.c();
            this.C = false;
            GLThreadManager r100 = GLTextureView.f451015l;
            if (r100.f451054e != this) goto L7;
            r100.f451054e = null;
        L7:
            r100.notifyAll();
            return;
        }

        public final void stopEglSurfaceLocked() {
            if (this.D == false) goto L6;
            this.D = false;
            this.M.b();
            return;
        }

        public GLThread(WeakReference<GLTextureView> r100) {
            super("GLTextureView$GLThread");
            this.K = new ArrayList();
            this.L = true;
            this.F = 0;
            this.G = 0;
            this.I = true;
            this.H = 1;
            this.N = r100;
        }

        public final void setRenderMode(int r100) {
            if (r100 < 0) goto L14;
            if (r100 > 1) goto L14;
            GLThreadManager r101 = GLTextureView.f451015l;
            monitor-enter(r101);
            this.H = r100;     // Catch: Throwable -> L10
            r101.notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalArgumentException("renderMode");
        }
    }

    public static class GLThreadManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f451050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f451051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f451052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f451053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public GLThread f451054e;

        private GLThreadManager() {
        }

        public final synchronized boolean b() {
            monitor-enter(this);
            boolean r100 = this.f451053d;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized boolean c() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.f451050a == true) goto L6;
            this.f451050a = true;     // Catch: Throwable -> L10
        L6:
            boolean r100 = !this.f451052c;
            monitor-exit(this);
            return r100;
        }

        public /* synthetic */ GLThreadManager(int r100) {
            this();
        }

        public final synchronized void a(GL10 r100) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (this.f451051b == false) goto L6;
        L13:
            monitor-exit(this);
            return;
        L6:
            if (this.f451050a == true) goto L9;
            this.f451050a = true;     // Catch: Throwable -> L15
        L9:
            if (r100.glGetString(7937).startsWith("Q3Dimension MSM7500 ") == true) goto L11;
            boolean r101 = true;
        L12:
            this.f451052c = r101;     // Catch: Throwable -> L15
            notifyAll();     // Catch: Throwable -> L15
            this.f451053d = !this.f451052c;     // Catch: Throwable -> L15
            this.f451051b = true;     // Catch: Throwable -> L15
            goto L13
        L11:
            r101 = false;
            goto L12
        }

        public final synchronized void d(GLThread r100) {
            monitor-enter(this);
            r100.f451046w = true;     // Catch: Throwable -> L10
            if (this.f451054e != r100) goto L7;
            this.f451054e = null;     // Catch: Throwable -> L10
        L7:
            notifyAll();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public interface GLWrapper {
    }

    public static class LogWriter extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StringBuilder f451055a;

        public final void a() {
            if (this.f451055a.length() <= 0) goto L6;
            this.f451055a.toString();
            StringBuilder r100 = this.f451055a;
            r100.delete(0, r100.length());
            return;
        }

        public LogWriter() {
            this.f451055a = new StringBuilder();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            a();
        }

        @Override // java.io.Writer
        public final void write(char[] r100, int r101, int r102) {
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            char r104 = r100[r101 + r103];
            if (r104 != '\n') goto L7;
            a();
        L8:
            r103 = r103 + 1;
            goto L3
        L7:
            this.f451055a.append(r104);
            goto L8
        }
    }

    public interface Renderer {
        void onDrawFrame(GL10 r100);

        void onSurfaceChanged(GL10 r100, int r101, int r102);

        void onSurfaceCreated(GL10 r100, EGLConfig r101);
    }

    public class SimpleEGLConfigChooser extends ComponentSizeChooser {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f451056k;

        public SimpleEGLConfigChooser(GLTextureView r100, boolean r101) {
            this.f451056k = r100;
            if (r101 == false) goto L5;
            int r102 = 16;
        L6:
            super(r100, 0, r102);
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable r100) {
    }

    public void setGLWrapper(GLWrapper r100) {
    }

    static {
        f451015l = new GLThreadManager(0);
    }

    public final void f() {
        if (this.f451018c != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public final void finalize() throws Throwable {
        GLThread r100 = this.f451018c;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.requestExitAndWait();     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getRenderMode() {
        GLThread r100 = this.f451018c;
        r100.getClass();
        GLThreadManager r101 = f451015l;
        monitor-enter(r101);
        int r102 = r100.H;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        GLThread r100 = this.f451018c;
        if (r100 == null) goto L5;
        r100.requestExitAndWait();
    L5:
        this.f451020e = true;
        super.onDetachedFromWindow();
    }

    public final void onPause() {
        GLThread r100 = this.f451018c;
        r100.getClass();
        GLThreadManager r101 = f451015l;
        monitor-enter(r101);
        r100.f451047x = true;     // Catch: Throwable -> L15
        r101.notifyAll();     // Catch: Throwable -> L15
    L7:
        if (r100.f451046w == true) goto L13;
        if (r100.f451048y == true) goto L13;
        f451015l.wait();     // Catch: InterruptedException -> L12 Throwable -> L15
    L12:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void requestRender() {
        GLThread r100 = this.f451018c;
        r100.getClass();
        GLThreadManager r101 = f451015l;
        monitor-enter(r101);
        r100.I = true;     // Catch: Throwable -> L8
        r101.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f451020e == true) goto L5;
    L21:
        this.f451020e = false;
        return;
    L5:
        if (this.f451019d == null) goto L21;
        GLThread r100 = this.f451018c;
        if (r100 == null) goto L16;
        GLThreadManager r101 = f451015l;
        monitor-enter(r101);
        int r102 = r100.H;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    L17:
        GLThread r103 = new GLThread(this.f451017b);
        this.f451018c = r103;
        if (r102 == 1) goto L20;
        r103.setRenderMode(r102);
    L20:
        ThreadMethodProxy.start(this.f451018c);
    L13:
        th = move-exception;
        throw th;
    L16:
        r102 = 1;
        goto L17
    }

    public int getDebugFlags() {
        return this.f451024i;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f451026k;
    }

    public GLTextureView(Context r100) {
        super(r100);
        this.f451017b = new WeakReference(this);
        setSurfaceTextureListener(this);
    }

    public final void g(Runnable r100) {
        GLThread r101 = this.f451018c;
        r101.getClass();
        GLThreadManager r102 = f451015l;
        monitor-enter(r102);
        r101.K.add(r100);     // Catch: Throwable -> L7
        r102.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        GLThread r101 = this.f451018c;
        r101.getClass();
        GLThreadManager r102 = f451015l;
        monitor-enter(r102);
        r101.f451049z = false;     // Catch: Throwable -> L16
        r102.notifyAll();     // Catch: Throwable -> L16
    L7:
        if (r101.B == true) goto L13;
        if (r101.f451046w == true) goto L13;
        f451015l.wait();     // Catch: InterruptedException -> L12 Throwable -> L16
    L12:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L16
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    public void setDebugFlags(int r100) {
        this.f451024i = r100;
    }

    public void setEGLConfigChooser(boolean r100) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(this, r100));
    }

    public void setEGLContextClientVersion(int r100) {
        f();
        this.f451025j = r100;
    }

    public void setEGLContextFactory(EGLContextFactory r100) {
        f();
        this.f451022g = r100;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory r100) {
        f();
        this.f451023h = r100;
    }

    public void setMonitor(IMonitor r100) {
        this.f451016a = r100;
    }

    public void setPreserveEGLContextOnPause(boolean r100) {
        this.f451026k = r100;
    }

    public void setRenderMode(int r100) {
        GLThread r101 = this.f451018c;
        r101.getClass();
        if (r100 < 0) goto L15;
        if (r100 > 1) goto L15;
        GLThreadManager r102 = f451015l;
        monitor-enter(r102);
        r101.H = r100;     // Catch: Throwable -> L11
        r102.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalArgumentException("renderMode");
    }

    public void setRenderer(Renderer r100) {
        f();
        if (this.f451021f != null) goto L6;
        this.f451021f = new SimpleEGLConfigChooser(this, true);
    L6:
        if (this.f451022g != null) goto L9;
        this.f451022g = new DefaultContextFactory(this);
    L9:
        if (this.f451023h != null) goto L11;
        this.f451023h = new DefaultWindowSurfaceFactory(0);
    L11:
        this.f451019d = r100;
        GLThread r101 = new GLThread(this.f451017b);
        this.f451018c = r101;
        ThreadMethodProxy.start(r101);
    }

    public void setEGLConfigChooser(EGLConfigChooser r100) {
        f();
        this.f451021f = r100;
    }

    public GLTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f451017b = new WeakReference(this);
        setSurfaceTextureListener(this);
    }

    public final void h(int r100, int r101) {
        GLThread r102 = this.f451018c;
        r102.getClass();
        GLThreadManager r103 = f451015l;
        monitor-enter(r103);
        r102.F = r100;     // Catch: Throwable -> L25
        r102.G = r101;     // Catch: Throwable -> L25
        r102.L = true;     // Catch: Throwable -> L25
        r102.I = true;     // Catch: Throwable -> L25
        r102.f451044J = false;     // Catch: Throwable -> L25
        r103.notifyAll();     // Catch: Throwable -> L25
    L6:
        if (r102.f451046w == true) goto L23;
        if (r102.f451048y == true) goto L23;
        if (r102.f451044J == true) goto L23;
        if (r102.C == true) goto L14;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L23;
        f451015l.wait();     // Catch: InterruptedException -> L22 Throwable -> L25
    L22:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L25
        goto L6
    L14:
        if (r102.D == false) goto L18;
        if (r102.readyToDraw() == false) goto L18;
        r104 = true;
    L23:
        monitor-exit(r103);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        GLThread r103 = this.f451018c;
        r103.getClass();
        GLThreadManager r104 = f451015l;
        monitor-enter(r104);
        r103.f451049z = true;     // Catch: Throwable -> L16
        r104.notifyAll();     // Catch: Throwable -> L16
    L7:
        if (r103.B == false) goto L13;
        if (r103.f451046w == true) goto L13;
        f451015l.wait();     // Catch: InterruptedException -> L12 Throwable -> L16
    L12:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L16
    L13:
        monitor-exit(r104);     // Catch: Throwable -> L16
        h(r101, r102);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        h(r101, r102);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        getSurfaceTexture();
        h(r103 - r101, r104 - r102);
    }
}
