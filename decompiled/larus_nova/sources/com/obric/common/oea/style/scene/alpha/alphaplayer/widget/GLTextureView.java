package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
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

/* JADX INFO: loaded from: classes33.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j f396614k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<GLTextureView> f396615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f396616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f396617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f396618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f396619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f396620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f396621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f396622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f396623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f396624j;

    public abstract class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f396625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f396626b;

        public a(GLTextureView r100, int[] r101) {
            this.f396626b = r100;
            if (r100.f396623i != 2) goto L6;
            int r102 = r101.length;
            int[] r103 = new int[r102 + 2];
            int r104 = r102 - 1;
            System.arraycopy(r101, 0, r103, 0, r104);
            r103[r104] = 12352;
            r103[r102] = 4;
            r103[r102 + 1] = 12344;
            r101 = r103;
        L6:
            this.f396625a = r101;
        }
    }

    public class b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f396627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f396628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f396629e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f396630f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f396631g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f396632h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f396633i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f396634j;

        public b(GLTextureView r100, int r101, int r102) {
            this.f396634j = r100;
            super(r100, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, r101, 12325, r102, 12326, 0, 12344});
            this.f396627c = new int[1];
            this.f396628d = 8;
            this.f396629e = 8;
            this.f396630f = 8;
            this.f396631g = r101;
            this.f396632h = r102;
            this.f396633i = 0;
        }

        public final int a(EGL10 r100, EGLDisplay r101, EGLConfig r102, int r103) {
            if (r100.eglGetConfigAttrib(r101, r102, r103, this.f396627c) == true) goto L5;
            return 0;
        L5:
            return this.f396627c[0];
        }
    }

    public class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f396635a;

        public c(GLTextureView r100) {
            this.f396635a = r100;
        }
    }

    public static class d implements g {
        public d() {
        }
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<GLTextureView> f396636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EGL10 f396637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public EGLDisplay f396638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EGLSurface f396639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public EGLConfig f396640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EGLContext f396641f;

        public final boolean a() {
            ThreadMethodProxy.currentThread().getId();
            if (this.f396637b == null) goto L32;
            if (this.f396638c == null) goto L30;
            if (this.f396640e == null) goto L28;
            b();
            GLTextureView r100 = this.f396636a.get();
            EGLSurface r101 = null;
            if (r100 == null) goto L13;
            g r102 = r100.f396621g;
            EGL10 r103 = this.f396637b;
            EGLDisplay r104 = this.f396638c;
            EGLConfig r105 = this.f396640e;
            SurfaceTexture r106 = r100.getSurfaceTexture();
            ((d) r102).getClass();
            r101 = r103.eglCreateWindowSurface(r104, r105, r106, null);     // Catch: IllegalArgumentException -> L33
        L12:
            this.f396639d = r101;
        L14:
            EGLSurface r107 = this.f396639d;
            if (r107 != null) goto L17;
        L25:
            this.f396637b.eglGetError();
            return false;
        L17:
            if (r107 == EGL10.EGL_NO_SURFACE) goto L25;
            if (this.f396637b.eglMakeCurrent(this.f396638c, r107, r107, this.f396641f) == true) goto L23;
            this.f396637b.eglGetError();
            return false;
        L23:
            return true;
        L13:
            this.f396639d = null;
            goto L14
        L28:
            throw new RuntimeException("mEglConfig not initialized");
        L30:
            throw new RuntimeException("eglDisplay not initialized");
        L32:
            throw new RuntimeException("egl not initialized");
        }

        public final void b() {
            EGLSurface r100 = this.f396639d;
            if (r100 == null) goto L11;
            EGLSurface r101 = EGL10.EGL_NO_SURFACE;
            if (r100 == r101) goto L12;
            this.f396637b.eglMakeCurrent(this.f396638c, r101, r101, EGL10.EGL_NO_CONTEXT);
            GLTextureView r102 = this.f396636a.get();
            if (r102 == null) goto L9;
            g r103 = r102.f396621g;
            EGL10 r104 = this.f396637b;
            EGLDisplay r105 = this.f396638c;
            EGLSurface r106 = this.f396639d;
            ((d) r103).getClass();
            r104.eglDestroySurface(r105, r106);
        L9:
            this.f396639d = null;
            return;
        L12:
            return;
        }

        public final void c() {
            ThreadMethodProxy.currentThread().getId();
            if (this.f396641f == null) goto L10;
            GLTextureView r100 = this.f396636a.get();
            if (r100 == null) goto L9;
            f r101 = r100.f396620f;
            EGL10 r102 = this.f396637b;
            EGLDisplay r103 = this.f396638c;
            EGLContext r104 = this.f396641f;
            ((c) r101).getClass();
            if (r102.eglDestroyContext(r103, r104) == true) goto L9;
            Objects.toString(r103);
            Objects.toString(r104);
            ThreadMethodProxy.currentThread().getId();
            r102.eglGetError();
            ThreadMethodProxy.currentThread().getId();
        L9:
            this.f396641f = null;
        L10:
            EGLDisplay r105 = this.f396638c;
            if (r105 == null) goto L14;
            this.f396637b.eglTerminate(r105);
            this.f396638c = null;
            return;
        }

        public final void d() {
            ThreadMethodProxy.currentThread().getId();
            EGL10 r100 = (EGL10) EGLContext.getEGL();
            this.f396637b = r100;
            EGLDisplay r101 = r100.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f396638c = r101;
            if (r101 == EGL10.EGL_NO_DISPLAY) goto L56;
            if (this.f396637b.eglInitialize(r101, new int[2]) == false) goto L54;
            GLTextureView r102 = this.f396636a.get();
            if (r102 != null) goto L9;
            this.f396640e = null;
            this.f396641f = null;
        L38:
            EGLContext r103 = this.f396641f;
            if (r103 != null) goto L41;
        L42:
            this.f396641f = null;
            this.f396637b.eglGetError();
            ThreadMethodProxy.currentThread().getId();
        L43:
            Objects.toString(this.f396641f);
            ThreadMethodProxy.currentThread().getId();
            this.f396639d = null;
            return;
        L41:
            if (r103 != EGL10.EGL_NO_CONTEXT) goto L43;
        L9:
            e r104 = r102.f396619e;
            EGL10 r110 = this.f396637b;
            EGLDisplay r111 = this.f396638c;
            a r105 = (a) r104;
            int[] r112 = new int[1];
            if (r110.eglChooseConfig(r111, r105.f396625a, null, 0, r112) == false) goto L51;
            int r113 = r112[0];
            if (r113 <= 0) goto L50;
            EGLConfig[] r106 = new EGLConfig[r113];
            if (r110.eglChooseConfig(r111, r105.f396625a, r106, r113, r112) == false) goto L48;
            b r107 = (b) r105;
            int r108 = 0;
        L16:
            if (r108 >= r113) goto L31;
            EGLConfig r109 = r106[r108];
            int r114 = r107.a(r110, r111, r109, 12325);
            int r115 = r107.a(r110, r111, r109, 12326);
            if (r114 < r107.f396632h) goto L30;
            if (r115 < r107.f396633i) goto L30;
            int r116 = r107.a(r110, r111, r109, 12324);
            int r117 = r107.a(r110, r111, r109, 12323);
            int r118 = r107.a(r110, r111, r109, 12322);
            int r119 = r107.a(r110, r111, r109, 12321);
            if (r116 != r107.f396628d) goto L30;
            if (r117 != r107.f396629e) goto L30;
            if (r118 != r107.f396630f) goto L30;
            if (r119 != r107.f396631g) goto L30;
        L32:
            if (r109 == null) goto L46;
            this.f396640e = r109;
            f r120 = r102.f396620f;
            EGL10 r121 = this.f396637b;
            EGLDisplay r122 = this.f396638c;
            c r123 = (c) r120;
            r123.getClass();
            int r124 = r123.f396635a.f396623i;
            int[] r125 = {12440, r124, 12344};
            EGLContext r126 = EGL10.EGL_NO_CONTEXT;
            if (r124 != 0) goto L37;
            r125 = null;
        L37:
            this.f396641f = r121.eglCreateContext(r122, r109, r126, r125);
            goto L38
        L46:
            throw new IllegalArgumentException("No config chosen");
        L30:
            r108 = r108 + 1;
            goto L16
        L31:
            r109 = null;
            goto L32
        L48:
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        L50:
            throw new IllegalArgumentException("No configs match configSpec");
        L51:
            GLTextureView r127 = r105.f396626b;
            Log.getStackTraceString(new IllegalArgumentException("eglChooseConfig failed"));
            j r128 = GLTextureView.f396614k;
            r127.getClass();
            throw new IllegalArgumentException("eglChooseConfig failed");
        L54:
            throw new RuntimeException("eglInitialize failed");
        L56:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public h(WeakReference<GLTextureView> r100) {
            this.f396636a = r100;
        }
    }

    public static class i extends PthreadThreadV2 {
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
        public boolean f396642J;
        public final ArrayList<Runnable> K;
        public boolean L;
        public h M;
        public final WeakReference<GLTextureView> N;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f396643v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f396644w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f396645x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f396646y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f396647z;

        public final void guardedRun() throws InterruptedException {
            this.M = new h(this.N);
            this.C = false;
            this.D = false;
            GL10 r100 = null;
            boolean r101 = false;
            boolean r102 = false;
            boolean r103 = false;
            boolean r104 = false;
            boolean r105 = false;
            boolean r106 = false;
            boolean r110 = false;
            int r111 = 0;
            int r112 = 0;
            boolean r113 = false;
        L3:
            Runnable r114 = null;
        L198:
            j r115 = GLTextureView.f396614k;     // Catch: Throwable -> L180
            monitor-enter(r115);     // Catch: Throwable -> L180
        L197:
        L177:
            th = move-exception;
            throw th;     // Catch: Throwable -> L180
        L7:
            if (this.f396643v == true) goto L8;
            if (this.K.isEmpty() == false) goto L19;
            boolean r107 = this.f396646y;     // Catch: Throwable -> L177
            boolean r108 = this.f396645x;     // Catch: Throwable -> L177
            if (r107 == r108) goto L23;
            this.f396646y = r108;     // Catch: Throwable -> L177
            GLTextureView.f396614k.notifyAll();     // Catch: Throwable -> L177
            getId();     // Catch: Throwable -> L177
        L25:
            if (this.E == false) goto L27;
            getId();     // Catch: Throwable -> L177
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
            stopEglContextLocked();     // Catch: Throwable -> L177
            this.E = false;     // Catch: Throwable -> L177
            r103 = true;
        L27:
            if (r101 == false) goto L29;
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
            stopEglContextLocked();     // Catch: Throwable -> L177
            r101 = false;
        L29:
            if (r108 == true) goto L31;
        L33:
            if (r108 == true) goto L35;
        L44:
            if (r108 == false) goto L49;
            if (GLTextureView.f396614k.c() == false) goto L49;
            this.M.c();     // Catch: Throwable -> L177
            getId();     // Catch: Throwable -> L177
        L49:
            if (this.f396647z == true) goto L57;
            if (this.B == true) goto L57;
            getId();     // Catch: Throwable -> L177
            if (this.D == false) goto L55;
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
        L55:
            this.B = true;     // Catch: Throwable -> L177
            this.A = false;     // Catch: Throwable -> L177
            GLTextureView.f396614k.notifyAll();     // Catch: Throwable -> L177
        L57:
            if (this.f396647z == true) goto L59;
        L61:
            if (r102 == false) goto L64;
            getId();     // Catch: Throwable -> L177
            this.f396642J = true;     // Catch: Throwable -> L177
            GLTextureView.f396614k.notifyAll();     // Catch: Throwable -> L177
            r102 = false;
            r113 = false;
        L64:
            if (readyToDraw() == true) goto L66;
            GL10 r116 = r100;
        L176:
            getId();     // Catch: Throwable -> L177
            GLTextureView.f396614k.wait();     // Catch: Throwable -> L177
            r100 = r116;
            goto L197
        L66:
            if (this.C == true) goto L94;
            if (r103 == false) goto L69;
            r116 = r100;
            l r109 = null;
            r103 = false;
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
            getId();     // Catch: Throwable -> L177
            this.L = false;     // Catch: Throwable -> L177
            boolean r117 = false;
            r105 = true;
            r110 = true;
            r113 = true;
        L107:
            this.I = r117;     // Catch: Throwable -> L177
            GLTextureView.f396614k.notifyAll();     // Catch: Throwable -> L177
        L108:
            monitor-exit(r115);     // Catch: Throwable -> L177
            if (r114 != null) goto L110;
            if (r105 == false) goto L124;
            if (this.M.a() == false) goto L114;
            r105 = false;
            goto L124
        L114:
            j r118 = GLTextureView.f396614k;     // Catch: Throwable -> L180
            monitor-enter(r118);     // Catch: Throwable -> L180
            this.A = true;     // Catch: Throwable -> L120
            r118.notifyAll();     // Catch: Throwable -> L120
            monitor-exit(r118);     // Catch: Throwable -> L120
            r100 = r116;
            goto L198
        L120:
            th = move-exception;
            throw th;     // Catch: Throwable -> L180
        L124:
            if (r106 == false) goto L139;
            h r119 = this.M;     // Catch: Throwable -> L180
            GL r120 = r119.f396641f.getGL();     // Catch: Throwable -> L180
            GLTextureView r121 = r119.f396636a.get();     // Catch: Throwable -> L180
            if (r121 == null) goto L138;
            j r122 = GLTextureView.f396614k;     // Catch: Throwable -> L180
            int r123 = r121.f396622h;     // Catch: Throwable -> L180
            if ((r123 & 3) == 0) goto L138;
            if ((r123 & 1) == 0) goto L132;
            int r124 = 1;
        L134:
            if ((r123 & 2) == 0) goto L136;
            l r125 = new l();     // Catch: Throwable -> L180
        L137:
            r120 = GLDebugHelper.wrap(r120, r124, r125);     // Catch: Throwable -> L180
            goto L138
        L136:
            r125 = r109;
            goto L137
        L132:
            r124 = 0;
        L138:
            GL10 r126 = (GL10) r120;     // Catch: Throwable -> L180
            GLTextureView.f396614k.a(r126);     // Catch: Throwable -> L180
            boolean r127 = false;
        L140:
            if (r104 == false) goto L145;
            GLTextureView r128 = this.N.get();     // Catch: Throwable -> L180
            if (r128 == null) goto L144;
            r128.f396617c.onSurfaceCreated(r126, this.M.f396640e);     // Catch: Throwable -> L180
        L144:
            r104 = false;
        L145:
            if (r110 == false) goto L150;
            GLTextureView r129 = this.N.get();     // Catch: Throwable -> L180
            if (r129 == null) goto L149;
            r129.f396617c.onSurfaceChanged(r126, r111, r112);     // Catch: Throwable -> L180
        L149:
            r110 = false;
        L150:
            getId();     // Catch: Throwable -> L180
            GLTextureView r130 = this.N.get();     // Catch: Throwable -> L180
            if (r130 == null) goto L153;
            r130.f396617c.onDrawFrame(r126);     // Catch: Throwable -> L180
        L153:
            h r131 = this.M;     // Catch: Throwable -> L180
            boolean r132 = r127;
            if (r131.f396637b.eglSwapBuffers(r131.f396638c, r131.f396639d) == true) goto L156;
            int r133 = r131.f396637b.eglGetError();     // Catch: Throwable -> L180
        L157:
            if (r133 == 12288) goto L172;
            if (r133 == 12302) goto L169;
            j r134 = GLTextureView.f396614k;     // Catch: Throwable -> L180
            monitor-enter(r134);     // Catch: Throwable -> L180
            this.A = true;     // Catch: Throwable -> L166
            r134.notifyAll();     // Catch: Throwable -> L166
            monitor-exit(r134);     // Catch: Throwable -> L166
        L166:
            th = move-exception;
            throw th;     // Catch: Throwable -> L180
        L169:
            getId();     // Catch: Throwable -> L180
            r101 = true;
        L172:
            if (r113 == false) goto L174;
            r102 = true;
        L174:
            r100 = r126;
            r106 = r132;
            goto L198
        L156:
            r133 = 12288;
            goto L157
        L139:
            r127 = r106;
            r126 = r116;
            goto L140
        L110:
            r114.run();     // Catch: Throwable -> L180
            r100 = r116;
            goto L3
        L106:
            r117 = false;
            goto L107
        L69:
            j r135 = GLTextureView.f396614k;     // Catch: Throwable -> L177
            i r136 = r135.f396652e;     // Catch: Throwable -> L177
            if (r136 == this) goto L82;
            if (r136 == null) goto L82;
            r116 = r100;
            if (r135.f396648a == true) goto L77;
            r135.f396648a = true;     // Catch: Throwable -> L177
        L77:
            if (r135.f396650c == true) goto L83;
            if (r136 == null) goto L81;
            r136.E = true;     // Catch: Throwable -> L177
            r135.notifyAll();     // Catch: Throwable -> L177
        L81:
            boolean r137 = false;
        L84:
            if (r137 == true) goto L193;
        L95:
            r109 = null;
            goto L97
        L193:
            this.M.d();     // Catch: RuntimeException -> L88 Throwable -> L177
        L87:
            this.C = true;     // Catch: Throwable -> L177
            r135.notifyAll();     // Catch: Throwable -> L177
            r109 = null;
            r104 = true;
        L88:
            e = move-exception;
            j r138 = GLTextureView.f396614k;     // Catch: Throwable -> L177
            if (r138.f396652e != this) goto L92;
            r138.f396652e = null;     // Catch: Throwable -> L177
        L92:
            r138.notifyAll();     // Catch: Throwable -> L177
            throw e;     // Catch: Throwable -> L177
        L83:
            r137 = true;
        L82:
            r116 = r100;
            r135.f396652e = this;     // Catch: Throwable -> L177
            r135.notifyAll();     // Catch: Throwable -> L177
            goto L83
        L94:
            r116 = r100;
            goto L95
        L59:
            if (this.B == false) goto L61;
            getId();     // Catch: Throwable -> L177
            this.B = false;     // Catch: Throwable -> L177
            GLTextureView.f396614k.notifyAll();     // Catch: Throwable -> L177
            goto L61
        L35:
            if (this.C == false) goto L44;
            GLTextureView r139 = this.N.get();     // Catch: Throwable -> L177
            if (r139 != null) goto L39;
            boolean r140 = false;
        L40:
            if (r140 == true) goto L42;
        L43:
            stopEglContextLocked();     // Catch: Throwable -> L177
            getId();     // Catch: Throwable -> L177
            goto L44
        L42:
            if (GLTextureView.f396614k.b() == false) goto L44;
        L39:
            r140 = r139.f396624j;     // Catch: Throwable -> L177
            goto L40
        L31:
            if (this.D == false) goto L33;
            getId();     // Catch: Throwable -> L177
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
            j r141 = GLTextureView.f396614k;
            monitor-enter(r141);
            stopEglSurfaceLocked();     // Catch: Throwable -> L14
            stopEglContextLocked();     // Catch: Throwable -> L14
            monitor-exit(r141);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L180:
            th = move-exception;
            monitor-enter(GLTextureView.f396614k);
            stopEglSurfaceLocked();     // Catch: Throwable -> L186
            stopEglContextLocked();     // Catch: Throwable -> L186
            throw th;
        L186:
            th = move-exception;
            throw th;
        }

        public final void l() {
            ThreadMethodProxy.setName(this, "GLThread " + getId());
            getId();
            guardedRun();     // Catch: Throwable -> L5 InterruptedException -> L8
        L4:
            GLTextureView.f396614k.d(this);
            return;
        L8:
            j r100 = GLTextureView.f396614k;
        L5:
            th = move-exception;
            j r101 = GLTextureView.f396614k;
            GLTextureView.f396614k.d(this);
            throw th;
        }

        public final boolean readyToDraw() {
            if (this.f396646y == false) goto L5;
        L17:
            return false;
        L5:
            if (this.f396647z == false) goto L17;
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
            j r100 = GLTextureView.f396614k;
            monitor-enter(r100);
            this.f396643v = true;     // Catch: Throwable -> L13
            r100.notifyAll();     // Catch: Throwable -> L13
        L7:
            if (this.f396644w == true) goto L11;
            GLTextureView.f396614k.wait();     // Catch: InterruptedException -> L10 Throwable -> L13
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

        public final void stopEglContextLocked() {
            if (this.C == false) goto L9;
            this.M.c();
            this.C = false;
            j r100 = GLTextureView.f396614k;
            if (r100.f396652e != this) goto L7;
            r100.f396652e = null;
        L7:
            r100.notifyAll();
            return;
        }

        public final void stopEglSurfaceLocked() {
            if (this.D == false) goto L6;
            this.D = false;
            h r100 = this.M;
            r100.getClass();
            ThreadMethodProxy.currentThread().getId();
            r100.b();
            return;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(WeakReference<GLTextureView> r100) {
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
            j r101 = GLTextureView.f396614k;
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

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f396648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f396649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f396650c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f396651d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public i f396652e;

        public final synchronized boolean b() {
            monitor-enter(this);
            boolean r100 = this.f396651d;     // Catch: Throwable -> L6
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
            if (this.f396648a == true) goto L6;
            this.f396648a = true;     // Catch: Throwable -> L10
        L6:
            boolean r100 = !this.f396650c;
            monitor-exit(this);
            return r100;
        }

        public j() {
        }

        public final synchronized void a(GL10 r100) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (this.f396649b == false) goto L6;
        L13:
            monitor-exit(this);
            return;
        L6:
            if (this.f396648a == true) goto L9;
            this.f396648a = true;     // Catch: Throwable -> L15
        L9:
            if (r100.glGetString(7937).startsWith("Q3Dimension MSM7500 ") == true) goto L11;
            boolean r101 = true;
        L12:
            this.f396650c = r101;     // Catch: Throwable -> L15
            notifyAll();     // Catch: Throwable -> L15
            this.f396651d = !this.f396650c;     // Catch: Throwable -> L15
            this.f396649b = true;     // Catch: Throwable -> L15
            goto L13
        L11:
            r101 = false;
            goto L12
        }

        public final synchronized void d(i r100) {
            monitor-enter(this);
            r100.getId();     // Catch: Throwable -> L9
            r100.f396644w = true;     // Catch: Throwable -> L9
            if (this.f396652e != r100) goto L6;
            this.f396652e = null;     // Catch: Throwable -> L9
        L6:
            notifyAll();     // Catch: Throwable -> L9
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public interface k {
    }

    public static class l extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StringBuilder f396653a;

        public final void a() {
            if (this.f396653a.length() <= 0) goto L6;
            this.f396653a.toString();
            StringBuilder r100 = this.f396653a;
            r100.delete(0, r100.length());
            return;
        }

        public l() {
            this.f396653a = new StringBuilder();
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
            this.f396653a.append(r104);
            goto L8
        }
    }

    public interface m {
        void onDrawFrame(GL10 r100);

        void onSurfaceChanged(GL10 r100, int r101, int r102);

        void onSurfaceCreated(GL10 r100, EGLConfig r101);
    }

    public class n extends b {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f396654k;

        public n(GLTextureView r100, boolean r101) {
            this.f396654k = r100;
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

    public void setGLWrapper(k r100) {
    }

    public void setMonitor(nja.a r100) {
    }

    static {
        f396614k = new j();
    }

    public final void e() {
        if (this.f396616b != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public final void finalize() throws Throwable {
        i r100 = this.f396616b;     // Catch: Throwable -> L7
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
        i r100 = this.f396616b;
        r100.getClass();
        j r101 = f396614k;
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
        i r100 = this.f396616b;
        if (r100 == null) goto L5;
        r100.requestExitAndWait();
    L5:
        this.f396618d = true;
        super.onDetachedFromWindow();
    }

    public final void onPause() {
        i r100 = this.f396616b;
        r100.getClass();
        j r101 = f396614k;
        monitor-enter(r101);
        r100.getId();     // Catch: Throwable -> L14
        r100.f396645x = true;     // Catch: Throwable -> L14
        r101.notifyAll();     // Catch: Throwable -> L14
    L6:
        if (r100.f396644w == true) goto L12;
        if (r100.f396646y == true) goto L12;
        f396614k.wait();     // Catch: InterruptedException -> L11 Throwable -> L14
    L11:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void requestRender() {
        i r100 = this.f396616b;
        r100.getClass();
        j r101 = f396614k;
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
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f396618d == true) goto L5;
    L21:
        this.f396618d = false;
        return;
    L5:
        if (this.f396617c == null) goto L21;
        i r100 = this.f396616b;
        if (r100 == null) goto L16;
        j r101 = f396614k;
        monitor-enter(r101);
        int r102 = r100.H;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    L17:
        i r103 = new i(this.f396615a);
        this.f396616b = r103;
        if (r102 == 1) goto L20;
        r103.setRenderMode(r102);
    L20:
        ThreadMethodProxy.start(this.f396616b);
    L13:
        th = move-exception;
        throw th;
    L16:
        r102 = 1;
        goto L17
    }

    public int getDebugFlags() {
        return this.f396622h;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f396624j;
    }

    public GLTextureView(Context r100) {
        super(r100);
        this.f396615a = new WeakReference(this);
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        i r101 = this.f396616b;
        r101.getClass();
        j r102 = f396614k;
        monitor-enter(r102);
        r101.getId();     // Catch: Throwable -> L15
        r101.f396647z = false;     // Catch: Throwable -> L15
        r102.notifyAll();     // Catch: Throwable -> L15
    L6:
        if (r101.B == true) goto L12;
        if (r101.f396644w == true) goto L12;
        f396614k.wait();     // Catch: InterruptedException -> L11 Throwable -> L15
    L11:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L15
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    public void setDebugFlags(int r100) {
        this.f396622h = r100;
    }

    public void setEGLConfigChooser(boolean r100) {
        setEGLConfigChooser(new n(this, r100));
    }

    public void setEGLContextClientVersion(int r100) {
        e();
        this.f396623i = r100;
    }

    public void setEGLContextFactory(f r100) {
        e();
        this.f396620f = r100;
    }

    public void setEGLWindowSurfaceFactory(g r100) {
        e();
        this.f396621g = r100;
    }

    public void setPreserveEGLContextOnPause(boolean r100) {
        this.f396624j = r100;
    }

    public void setRenderMode(int r100) {
        i r101 = this.f396616b;
        r101.getClass();
        if (r100 < 0) goto L15;
        if (r100 > 1) goto L15;
        j r102 = f396614k;
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

    public void setRenderer(m r100) {
        e();
        if (this.f396619e != null) goto L6;
        this.f396619e = new n(this, true);
    L6:
        if (this.f396620f != null) goto L9;
        this.f396620f = new c(this);
    L9:
        if (this.f396621g != null) goto L11;
        this.f396621g = new d();
    L11:
        this.f396617c = r100;
        i r101 = new i(this.f396615a);
        this.f396616b = r101;
        ThreadMethodProxy.start(r101);
    }

    public void setEGLConfigChooser(e r100) {
        e();
        this.f396619e = r100;
    }

    public GLTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f396615a = new WeakReference(this);
        setSurfaceTextureListener(this);
    }

    public final void f(int r100, int r101) {
        i r102 = this.f396616b;
        r102.getClass();
        j r103 = f396614k;
        monitor-enter(r103);
        r102.F = r100;     // Catch: Throwable -> L26
        r102.G = r101;     // Catch: Throwable -> L26
        r102.L = true;     // Catch: Throwable -> L26
        r102.I = true;     // Catch: Throwable -> L26
        r102.f396642J = false;     // Catch: Throwable -> L26
        r103.notifyAll();     // Catch: Throwable -> L26
    L6:
        if (r102.f396644w == true) goto L24;
        if (r102.f396646y == true) goto L24;
        if (r102.f396642J == true) goto L24;
        if (r102.C == true) goto L14;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L24;
        r102.getId();     // Catch: Throwable -> L26
        f396614k.wait();     // Catch: InterruptedException -> L23 Throwable -> L26
    L23:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L26
        goto L6
    L14:
        if (r102.D == false) goto L18;
        if (r102.readyToDraw() == false) goto L18;
        r104 = true;
    L24:
        monitor-exit(r103);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        i r103 = this.f396616b;
        r103.getClass();
        j r104 = f396614k;
        monitor-enter(r104);
        r103.getId();     // Catch: Throwable -> L15
        r103.f396647z = true;     // Catch: Throwable -> L15
        r104.notifyAll();     // Catch: Throwable -> L15
    L6:
        if (r103.B == false) goto L12;
        if (r103.f396644w == true) goto L12;
        f396614k.wait();     // Catch: InterruptedException -> L11 Throwable -> L15
    L11:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L15
    L12:
        monitor-exit(r104);     // Catch: Throwable -> L15
        f(r101, r102);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        f(r101, r102);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        getSurfaceTexture();
        f(r103 - r101, r104 - r102);
    }
}
