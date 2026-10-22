package hb0;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.view.Choreographer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends PthreadThreadV2 {
    public final com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c A;
    public Object B;
    public l C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f484440J;
    public boolean K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public final ArrayList<Runnable> Q;
    public boolean R;
    public boolean S;
    public hb0.a T;
    public final C6120d U;
    public long V;
    public hb0.c W;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f484441v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f484442w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final j f484443x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h f484444y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final i f484445z;

    public static abstract class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f484446a;

        public a(int[] r100) {
            int r101 = this.f484446a;
            if (r101 != 2) goto L5;
        L7:
            int r102 = r100.length;
            int[] r103 = new int[r102 + 2];
            int r104 = r102 - 1;
            System.arraycopy(r100, 0, r103, 0, r104);
            r103[r104] = 12352;
            if (this.f484446a != 2) goto L10;
            r103[r102] = 4;
        L11:
            r103[r102 + 1] = 12344;
        L12:
            this.f484446a = 2;
            return;
        L10:
            r103[r102] = 64;
            goto L11
        L5:
            if (r101 == 3) goto L7;
            goto L7
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f484447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f484448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f484449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c f484450d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f484451e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f484452f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final hb0.a.C6119a f484453g;

        public b() {
            this.f484451e = 0;
            this.f484453g = hb0.a.f484431b;
        }
    }

    public static class c implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f484454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f484455b;

        public c(d r100) {
            this.f484455b = true;
            this.f484454a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            d r101 = this.f484454a;
            if (r101.f484442w != 1) goto L12;
            this.f484455b = true;
            r101.V = r100;
            k r102 = r101.f484441v;
            monitor-enter(r102);
            r101.N = true;     // Catch: Throwable -> L9
            r101.f484441v.notifyAll();     // Catch: Throwable -> L9
            monitor-exit(r102);     // Catch: Throwable -> L9
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: hb0.d$d, reason: collision with other inner class name */
    public static class C6120d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f484456a;

        public C6120d(d r100) {
            this.f484456a = null;
            this.f484456a = new c(r100);
        }
    }

    public static class e extends a {
        public e(int r100) {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, r100, 12326, 0, 12344});
        }
    }

    public static class f implements i {
        public f() {
        }
    }

    public static class g implements j {
        public g() {
        }
    }

    public interface h {
    }

    public interface i {
    }

    public interface j {
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f484457a;

        public k() {
        }

        public final synchronized void a(d r100) {
            monitor-enter(this);
            ALogger.i("GLThread", "exiting tid=" + r100.getId());     // Catch: Throwable -> L10
            r100.E = true;     // Catch: Throwable -> L10
            if (this.f484457a != r100) goto L7;
            this.f484457a = null;     // Catch: Throwable -> L10
        L7:
            notifyAll();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public interface l {
    }

    public static class m extends e {
        public m() {
            super(16);
        }
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadProxyWrapper, java.lang.Thread
    public final synchronized void start() {
        monitor-enter(this);
        super.start();     // Catch: Throwable -> L8
        c r100 = this.U.f484456a;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        Choreographer.getInstance().postFrameCallback(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void guardedRun() throws InterruptedException {
        this.W = new hb0.c(this.f484444y, this.f484445z, this.f484443x);
        int r100 = 0;
        this.I = false;
        this.f484440J = false;
        this.O = false;
        boolean r101 = false;
        boolean r102 = false;
        boolean r103 = false;
        boolean r104 = false;
        boolean r105 = false;
        boolean r106 = false;
        int r107 = 0;
        int r110 = 0;
        Runnable r111 = null;
    L3:
        boolean r112 = false;
    L180:
        k r113 = this.f484441v;     // Catch: Throwable -> L162
        monitor-enter(r113);     // Catch: Throwable -> L162
    L177:
    L159:
        th = move-exception;
        throw th;     // Catch: Throwable -> L162
    L7:
        if (this.D == true) goto L8;
        if (this.Q.isEmpty() == false) goto L20;
    L22:
        if (r101 == false) goto L25;
        ALogger.i("GLThread", "lostEglContext");     // Catch: Throwable -> L159
        stopEglSurfaceLocked();     // Catch: Throwable -> L159
        stopEglContextLocked();     // Catch: Throwable -> L159
        r101 = false;
    L25:
        if (this.F == true) goto L34;
        if (this.H == true) goto L34;
        ALogger.i("GLThread", "noticed surfaceView surface lost tid=" + getId());     // Catch: Throwable -> L159
        if (this.f484440J == false) goto L31;
        stopEglSurfaceLocked();     // Catch: Throwable -> L159
    L31:
        this.H = true;     // Catch: Throwable -> L159
        this.G = false;     // Catch: Throwable -> L159
        this.f484441v.notifyAll();     // Catch: Throwable -> L159
    L34:
        if (this.F == false) goto L39;
        if (this.H == false) goto L39;
        ALogger.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());     // Catch: Throwable -> L159
        this.H = false;     // Catch: Throwable -> L159
        this.f484441v.notifyAll();     // Catch: Throwable -> L159
    L39:
        if (r105 == false) goto L42;
        this.O = false;     // Catch: Throwable -> L159
        this.P = true;     // Catch: Throwable -> L159
        this.f484441v.notifyAll();     // Catch: Throwable -> L159
        r105 = false;
    L42:
        if (this.F == true) goto L44;
    L52:
        boolean r108 = false;
    L53:
        if (r108 == true) goto L55;
        r102 = r102;
        r103 = r103;
    L158:
        this.f484441v.wait();     // Catch: Throwable -> L159
        r101 = r101;
        r100 = 0;
        goto L177
    L55:
        if (this.I == true) goto L70;
        k r109 = this.f484441v;     // Catch: Throwable -> L159
        d r114 = r109.f484457a;     // Catch: Throwable -> L159
        if (r114 == this) goto L59;
        if (r114 == null) goto L59;
    L181:
        hb0.a r115 = this.W.c(this.T);     // Catch: RuntimeException -> L64 Throwable -> L159
        this.T = r115;     // Catch: RuntimeException -> L64 Throwable -> L159
        l r116 = this.C;     // Catch: RuntimeException -> L64 Throwable -> L159
        if (r116 == null) goto L63;
        BaseGLTextureView.a r117 = (BaseGLTextureView.a) r116;     // Catch: RuntimeException -> L64 Throwable -> L159
        r117.f69474a.post(new com.bytedance.android.live.ktv.common.canvasgl.glview.texture.a(r117, r115));     // Catch: RuntimeException -> L64 Throwable -> L159
    L63:
        this.I = true;     // Catch: Throwable -> L159
        this.f484441v.notifyAll();     // Catch: Throwable -> L159
        r102 = true;
    L72:
        if (this.I == true) goto L74;
    L76:
        r103 = r103;
    L78:
        if (this.f484440J == false) goto L158;
        if (this.R == false) goto L84;
        r107 = this.L;     // Catch: Throwable -> L159
        r110 = this.M;     // Catch: Throwable -> L159
        this.O = true;     // Catch: Throwable -> L159
        ALogger.i("GLThread", "noticing that we want render notification tid=" + getId());     // Catch: Throwable -> L159
        this.R = false;     // Catch: Throwable -> L159
        r103 = true;
        r106 = true;
    L84:
        if (this.S == false) goto L86;
        boolean r118 = false;
        this.S = false;     // Catch: Throwable -> L159
        r103 = true;
    L87:
        this.N = r118;     // Catch: Throwable -> L159
        this.f484441v.notifyAll();     // Catch: Throwable -> L159
        r101 = r101;
        r102 = r102;
        if (this.O == false) goto L90;
        r112 = true;
    L90:
        monitor-exit(r113);     // Catch: Throwable -> L159
        if (r111 != null) goto L92;
        if (r103 == false) goto L112;
        ALogger.w("GLThread", "egl createSurface");     // Catch: Throwable -> L162
        if (this.W.a(this.B) == false) goto L104;
        k r119 = this.f484441v;     // Catch: Throwable -> L162
        monitor-enter(r119);     // Catch: Throwable -> L162
        this.K = true;     // Catch: Throwable -> L101
        this.f484441v.notifyAll();     // Catch: Throwable -> L101
        monitor-exit(r119);     // Catch: Throwable -> L101
        r103 = false;
        goto L112
    L101:
        th = move-exception;
        throw th;     // Catch: Throwable -> L162
    L104:
        k r120 = this.f484441v;     // Catch: Throwable -> L162
        monitor-enter(r120);     // Catch: Throwable -> L162
        this.K = true;     // Catch: Throwable -> L109
        this.G = true;     // Catch: Throwable -> L109
        this.f484441v.notifyAll();     // Catch: Throwable -> L109
        monitor-exit(r120);     // Catch: Throwable -> L109
    L155:
        r100 = 0;
    L109:
        th = move-exception;
        throw th;     // Catch: Throwable -> L162
    L112:
        if (r104 == false) goto L114;
        r104 = false;
    L114:
        if (r102 == false) goto L116;
        ALogger.w("GLThread", "onSurfaceCreated");     // Catch: Throwable -> L162
        this.A.a();     // Catch: Throwable -> L162
        r102 = false;
    L116:
        if (r106 == false) goto L118;
        ALogger.w("GLThread", "onSurfaceChanged(" + r107 + ", " + r110 + ")");     // Catch: Throwable -> L162
        this.A.onSurfaceChanged(r107, r110);     // Catch: Throwable -> L162
        r106 = false;
    L118:
        c r121 = this.U.f484456a;     // Catch: Throwable -> L162
        if (r121 != null) goto L121;
    L126:
        boolean r122 = true;
    L127:
        if (r122 == false) goto L153;
        this.A.b();     // Catch: Throwable -> L162
        hb0.c r123 = this.W;     // Catch: Throwable -> L162
        long r124 = this.V;     // Catch: Throwable -> L162
        if (r124 == 0) goto L131;
        EGLExt.eglPresentationTimeANDROID(r123.f484436d, r123.f484439g, r124);     // Catch: Throwable -> L162
    L132:
        hb0.c r125 = this.W;     // Catch: Throwable -> L162
        if (EGL14.eglSwapBuffers(r125.f484436d, r125.f484439g) == true) goto L135;
        int r126 = EGL14.eglGetError();     // Catch: Throwable -> L162
    L136:
        c r127 = this.U.f484456a;     // Catch: Throwable -> L162
        if (r127 == null) goto L140;
        r127.f484455b = false;     // Catch: Throwable -> L162
    L140:
        if (r126 == 12288) goto L153;
        if (r126 == 12302) goto L151;
        hb0.b.a("eglSwapBuffers", r126);     // Catch: Throwable -> L162
        k r128 = this.f484441v;     // Catch: Throwable -> L162
        monitor-enter(r128);     // Catch: Throwable -> L162
        this.G = true;     // Catch: Throwable -> L148
        this.f484441v.notifyAll();     // Catch: Throwable -> L148
        monitor-exit(r128);     // Catch: Throwable -> L148
    L148:
        th = move-exception;
        throw th;     // Catch: Throwable -> L162
    L151:
        ALogger.i("GLThread", "egl context lost tid=" + getId());     // Catch: Throwable -> L162
        r101 = true;
        goto L153
    L135:
        r126 = 12288;
        goto L136
    L131:
        r123.getClass();     // Catch: Throwable -> L162
    L153:
        if (r112 == false) goto L155;
        r100 = 0;
        r105 = true;
        goto L3
    L121:
        if (r121.f484455b == true) goto L126;
        if (r121.f484454a.f484442w == 0) goto L126;
        r122 = false;
        goto L127
    L92:
        r111.run();     // Catch: Throwable -> L162
        r100 = 0;
        r111 = null;
        goto L180
    L86:
        r118 = false;
        goto L87
    L74:
        if (this.f484440J == true) goto L76;
        this.f484440J = true;     // Catch: Throwable -> L159
        r103 = true;
        r104 = true;
        r106 = true;
    L64:
        e = move-exception;
        k r129 = this.f484441v;     // Catch: Throwable -> L159
        if (r129.f484457a != this) goto L68;
        r129.f484457a = null;     // Catch: Throwable -> L159
    L68:
        r129.notifyAll();     // Catch: Throwable -> L159
        throw e;     // Catch: Throwable -> L159
    L59:
        r109.f484457a = this;     // Catch: Throwable -> L159
        r109.notifyAll();     // Catch: Throwable -> L159
        goto L181
    L70:
        r102 = r102;
        goto L72
    L44:
        if (this.G == true) goto L52;
        if (this.L <= 0) goto L52;
        if (this.M <= 0) goto L52;
        if (this.N == false) goto L52;
        r108 = true;
        goto L53
    L20:
        if (this.I == false) goto L22;
        r111 = this.Q.remove(r100);     // Catch: Throwable -> L159
        goto L90
    L8:
        monitor-exit(r113);     // Catch: Throwable -> L159
        k r130 = this.f484441v;
        monitor-enter(r130);
        stopEglSurfaceLocked();     // Catch: Throwable -> L14
        stopEglContextLocked();     // Catch: Throwable -> L14
        monitor-exit(r130);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L162:
        th = move-exception;
        monitor-enter(this.f484441v);
        stopEglSurfaceLocked();     // Catch: Throwable -> L168
        stopEglContextLocked();     // Catch: Throwable -> L168
        throw th;
    L168:
        th = move-exception;
        throw th;
    }

    public final void l() {
        ThreadMethodProxy.setName(this, "GLThread " + getId());
        ALogger.i("GLThread", "starting tid=" + getId());
        guardedRun();     // Catch: Throwable -> L5 InterruptedException -> L7
    L4:
        this.f484441v.a(this);
        return;
    L5:
        th = move-exception;
        this.f484441v.a(this);
        throw th;
    L7:
        e = move-exception;
        ALogger.e("GLThread", "", e);     // Catch: Throwable -> L5
        goto L4
    }

    public final void requestExitAndWait() {
        k r100 = this.f484441v;
        monitor-enter(r100);
        this.D = true;     // Catch: Throwable -> L13
        this.f484441v.notifyAll();     // Catch: Throwable -> L13
    L7:
        if (this.E == true) goto L11;
        this.f484441v.wait();     // Catch: InterruptedException -> L10 Throwable -> L13
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
        if (this.I == false) goto L19;
        hb0.c r100 = this.W;
        EGLContext r101 = r100.f484438f;
        if (r101 == null) goto L11;
        i r102 = r100.f484434b;
        EGLDisplay r103 = r100.f484436d;
        ((f) r102).getClass();
        if (EGL14.eglDestroyContext(r103, r101) == false) goto L9;
        r100.f484438f = null;
        goto L11
    L9:
        ALogger.e("GLThread", "DefaultContextFactory display:" + r103 + " context: " + r101);
        String r104 = hb0.b.a("eglDestroyContext", EGL14.eglGetError());
        ALogger.e("EglHelper", "throwEglException tid=" + ThreadMethodProxy.currentThread().getId() + " " + r104);
        throw new RuntimeException(r104);
    L11:
        EGLDisplay r105 = r100.f484436d;
        if (r105 == null) goto L14;
        EGL14.eglTerminate(r105);
        r100.f484436d = null;
    L14:
        this.I = false;
        k r106 = this.f484441v;
        if (r106.f484457a != this) goto L17;
        r106.f484457a = null;
    L17:
        r106.notifyAll();
        return;
    }

    public final void stopEglSurfaceLocked() {
        if (this.f484440J == false) goto L6;
        this.f484440J = false;
        this.W.b();
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

    public final void onWindowResize(int r100, int r101) {
        k r102 = this.f484441v;
        monitor-enter(r102);
        ALogger.d("GLThread", "width:" + r100 + " height:" + r101);     // Catch: Throwable -> L39
        this.L = r100;     // Catch: Throwable -> L39
        this.M = r101;     // Catch: Throwable -> L39
        this.R = true;     // Catch: Throwable -> L39
        this.N = true;     // Catch: Throwable -> L39
        this.P = false;     // Catch: Throwable -> L39
        if (ThreadMethodProxy.currentThread() != this) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L39
        return;
    L8:
        this.f484441v.notifyAll();     // Catch: Throwable -> L39
    L10:
        if (this.E == true) goto L37;
        if (this.P == true) goto L37;
        if (this.I == true) goto L16;
    L31:
        boolean r103 = false;
    L32:
        if (r103 == false) goto L37;
        ALogger.i("GLThread", "onWindowResize waiting for render complete from tid=" + getId());     // Catch: Throwable -> L39
        this.f484441v.wait();     // Catch: InterruptedException -> L36 Throwable -> L39
    L36:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L39
        goto L10
    L16:
        if (this.f484440J == false) goto L31;
        if (this.F == true) goto L20;
    L28:
        boolean r104 = false;
    L29:
        if (r104 == false) goto L31;
        r103 = true;
        goto L32
    L20:
        if (this.G == true) goto L28;
        if (this.L <= 0) goto L28;
        if (this.M <= 0) goto L28;
        if (this.N == false) goto L28;
        r104 = true;
    L37:
        monitor-exit(r102);     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public d(h r100, i r101, j r102, com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c r103, int r104, Object r105, hb0.a.C6119a r110) {
        super("gles/GLThread");
        this.f484441v = new k();
        this.Q = new ArrayList();
        this.R = true;
        this.S = false;
        this.T = hb0.a.f484431b;
        this.U = new C6120d(this);
        this.L = 0;
        this.M = 0;
        this.N = true;
        this.f484442w = r104;
        this.O = false;
        this.f484444y = r100;
        this.f484445z = r101;
        this.f484443x = r102;
        this.B = r105;
        this.A = r103;
        this.T = r110;
    }
}
