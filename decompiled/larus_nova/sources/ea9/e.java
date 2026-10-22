package ea9;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.flow.capture.model.PixelFormat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttm.player.C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final float[] f471673b0 = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final float[] f471674c0 = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final float[] f471675d0 = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final float[] f471676e0 = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final float[] f471677f0 = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final float[] f471678g0 = null;
    public final List<c> A;
    public int B;
    public final long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f471679J;
    public long K;
    public long L;
    public long M;
    public boolean N;
    public final b O;
    public final b P;
    public volatile long Q;
    public final AtomicBoolean R;
    public final AtomicBoolean S;
    public final FloatBuffer T;
    public final FloatBuffer U;
    public final FloatBuffer V;
    public final FloatBuffer W;
    public final FloatBuffer X;
    public final g Y;
    public final f Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f471680a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final h f471681a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaProjection f471683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f471684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f471685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<da9.b, Unit> f471686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Throwable, Unit> f471687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EGLDisplay f471688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EGLContext f471689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public EGLSurface f471690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f471691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SurfaceTexture f471692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Surface f471693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public VirtualDisplay f471694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f471695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f471696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f471697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f471698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f471699s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f471700t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f471701u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f471702v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f471703w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f471704x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Handler f471705y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float[] f471706z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f471707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f471708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f471709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f471710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f471711e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f471712f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f471713g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f471714h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f471715i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f471716j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f471717k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f471718l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f471719m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f471720n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f471721o;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f471707a == r101.f471707a) goto L12;
            return false;
        L12:
            if (this.f471708b == r101.f471708b) goto L15;
            return false;
        L15:
            if (this.f471709c == r101.f471709c) goto L18;
            return false;
        L18:
            if (this.f471710d == r101.f471710d) goto L21;
            return false;
        L21:
            if (this.f471711e == r101.f471711e) goto L24;
            return false;
        L24:
            if (this.f471712f == r101.f471712f) goto L27;
            return false;
        L27:
            if (this.f471713g == r101.f471713g) goto L30;
            return false;
        L30:
            if (this.f471714h == r101.f471714h) goto L33;
            return false;
        L33:
            if (this.f471715i == r101.f471715i) goto L36;
            return false;
        L36:
            if (this.f471716j == r101.f471716j) goto L39;
            return false;
        L39:
            if (this.f471717k == r101.f471717k) goto L42;
            return false;
        L42:
            if (this.f471718l == r101.f471718l) goto L45;
            return false;
        L45:
            if (this.f471719m == r101.f471719m) goto L48;
            return false;
        L48:
            if (this.f471720n == r101.f471720n) goto L51;
            return false;
        L51:
            if (this.f471721o == r101.f471721o) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f471707a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f471708b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f471709c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f471710d;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            long r108 = this.f471711e;
            int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
            long r110 = this.f471712f;
            int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
            long r112 = this.f471713g;
            int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            long r114 = this.f471714h;
            int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
            long r116 = this.f471715i;
            int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
            long r118 = this.f471716j;
            int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
            long r120 = this.f471717k;
            int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
            long r122 = this.f471718l;
            int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
            long r124 = this.f471719m;
            int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
            long r126 = this.f471720n;
            int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
            long r128 = this.f471721o;
            return r127 + ((int) (r128 ^ (r128 >>> 32)));
        }

        public final String toString() {
            return "DiagnosticsStats(systemCallbacks=" + this.f471707a + ", coalescedCallbacks=" + this.f471708b + ", drains=" + this.f471709c + ", throttleDrops=" + this.f471710d + ", poolDrops=" + this.f471711e + ", staleDrops=" + this.f471712f + ", updatedFrames=" + this.f471713g + ", blittedFrames=" + this.f471714h + ", producedFrames=" + this.f471715i + ", updateDurationUs=" + this.f471716j + ", maxUpdateDurationUs=" + this.f471717k + ", blitDurationUs=" + this.f471718l + ", maxBlitDurationUs=" + this.f471719m + ", deliveryDurationUs=" + this.f471720n + ", maxDeliveryDurationUs=" + this.f471721o + ')';
        }

        public final void a() {
            this.f471707a = 0;
            this.f471708b = 0;
            this.f471709c = 0;
            this.f471710d = 0;
            this.f471711e = 0;
            this.f471712f = 0;
            this.f471713g = 0;
            this.f471714h = 0;
            this.f471715i = 0;
            this.f471716j = 0;
            this.f471717k = 0;
            this.f471718l = 0;
            this.f471719m = 0;
            this.f471720n = 0;
            this.f471721o = 0;
        }

        public b(int r100) {
            this.f471707a = 0;
            this.f471708b = 0;
            this.f471709c = 0;
            this.f471710d = 0;
            this.f471711e = 0;
            this.f471712f = 0;
            this.f471713g = 0;
            this.f471714h = 0;
            this.f471715i = 0;
            this.f471716j = 0;
            this.f471717k = 0;
            this.f471718l = 0;
            this.f471719m = 0;
            this.f471720n = 0;
            this.f471721o = 0;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f471722a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f471722a == ((c) r100).f471722a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f471722a;
        }

        public final String toString() {
            return "TextureSlot(textureId=" + this.f471722a + ')';
        }

        public c(int r100) {
            this.f471722a = r100;
        }
    }

    public final void e() {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        int r101 = r100[0];
        this.f471691k = r101;
        GLES20.glBindTexture(36197, r101);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
    }

    public final void g() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        SurfaceTexture r101 = this.f471692l;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.setOnFrameAvailableListener(null);     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
    L11:
        this.R.set(false);
        VirtualDisplay r103 = this.f471694n;     // Catch: Throwable -> L18
        if (r103 == null) goto L15;
        r103.setSurface(null);     // Catch: Throwable -> L18
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L45:
        Surface r105 = this.f471693m;     // Catch: Throwable -> L26
        if (r105 == null) goto L23;
        r105.release();     // Catch: Throwable -> L26
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L26
    L28:
        this.f471693m = null;
        SurfaceTexture r107 = this.f471692l;     // Catch: Throwable -> L35
        if (r107 == null) goto L32;
        r107.release();     // Catch: Throwable -> L35
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L33:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L35
    L37:
        this.f471692l = null;
        return;
    L32:
        r108 = null;
    L35:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    L23:
        r106 = null;
    L26:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L15:
        r104 = null;
    L18:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L45
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void j() {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        this.f471688h = r100;
        int[] r101 = new int[2];
        EGL14.eglInitialize(r100, r101, 0, r101, 1);
        EGLConfig[] r102 = new EGLConfig[1];
        EGL14.eglChooseConfig(this.f471688h, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, 0, r102, 0, 1, new int[1], 0);
        this.f471689i = EGL14.eglCreateContext(this.f471688h, r102[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        EGLSurface r103 = EGL14.eglCreatePbufferSurface(this.f471688h, r102[0], new int[]{12375, this.f471696p, 12374, this.f471697q, 12344}, 0);
        this.f471690j = r103;
        EGL14.eglMakeCurrent(this.f471688h, r103, r103, this.f471689i);
        ca9.c r104 = ca9.b.f22972a;
        ca9.b.f22972a.a("ScreenShareGLSessionEGLReady", "GlScreenCaptureSession.initEGL", CollectionsKt.listOf(this.f471682b), MapsKt.mapOf(new Pair[]{TuplesKt.to("pbufferWidth", Integer.valueOf(this.f471696p)), TuplesKt.to("pbufferHeight", Integer.valueOf(this.f471697q))}));
    }

    static {
        f471673b0 = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f471674c0 = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f471675d0 = new float[]{1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        f471676e0 = new float[]{1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
        f471677f0 = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        f471678g0 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public final void f() {
        int r100 = 0;
    L4:
        if (r100 >= 4) goto L6;
        List<c> r101 = this.A;
        int[] r102 = new int[1];
        GLES20.glGenTextures(1, r102, 0);
        int r103 = r102[0];
        GLES20.glBindTexture(3553, r103);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, Math.min(this.f471696p, this.f471697q), Math.max(this.f471696p, this.f471697q), 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        ArrayList r104 = (ArrayList) r101;
        r104.add(new c(r103));
        r100 = r100 + 1;
        goto L4
    }

    public final void n() {
        if (Intrinsics.areEqual(this.f471688h, EGL14.EGL_NO_DISPLAY) == true) goto L21;
        int r100 = this.f471698r;
        if (r100 == 0) goto L7;
        GLES20.glDeleteFramebuffers(1, new int[]{r100}, 0);
        this.f471698r = 0;
    L7:
        int r101 = this.f471699s;
        if (r101 == 0) goto L11;
        GLES20.glDeleteProgram(r101);
        this.f471699s = 0;
    L11:
        if ((!((ArrayList) this.A).isEmpty()) == false) goto L17;
        int r102 = ((ArrayList) this.A).size();
        List<c> r103 = this.A;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = ((ArrayList) r103).iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r104.add(Integer.valueOf(((c) r105.next()).f471722a));
        goto L14
    L16:
        GLES20.glDeleteTextures(r102, CollectionsKt.toIntArray(r104), 0);
        ((ArrayList) this.A).clear();
    L17:
        int r106 = this.f471691k;
        if (r106 == 0) goto L20;
        GLES20.glDeleteTextures(1, new int[]{r106}, 0);
        this.f471691k = 0;
    L20:
        EGLDisplay r107 = this.f471688h;
        EGLSurface r108 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r107, r108, r108, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(this.f471688h, this.f471690j);
        EGL14.eglDestroyContext(this.f471688h, this.f471689i);
        EGL14.eglTerminate(this.f471688h);
    L21:
        this.f471688h = EGL14.EGL_NO_DISPLAY;
        this.f471689i = EGL14.EGL_NO_CONTEXT;
        this.f471690j = EGL14.EGL_NO_SURFACE;
        this.R.set(false);
        this.S.set(false);
        this.D = 0;
        ca9.c r109 = ca9.b.f22972a;
        ca9.c.a.a(ca9.b.f22972a, "ScreenShareGLSessionEGLReleased", "GlScreenCaptureSession.releaseEGL", CollectionsKt.listOf(this.f471682b), null, 8);
    }

    public final void q() {
        if (this.f471695o == false) goto L5;
    L7:
        this.f471695o = false;
        this.Q++;
        this.R.set(false);
        ca9.c r100 = ca9.b.f22972a;
        ca9.c.a.a(ca9.b.f22972a, "ScreenShareStop", "GlScreenCaptureSession.stop", CollectionsKt.listOf(this.f471682b), null, 8);
        final CountDownLatch r101 = new CountDownLatch(1);
        if (ThreadMethodProxy.isAlive(this.f471704x) == true) goto L11;
        k("render_thread_not_alive");
        r101.countDown();
    L14:
        if (r101.await(3, TimeUnit.SECONDS) == true) goto L17;
        ca9.c.a.b(ca9.b.f22972a, "ScreenShareStopWaitTimeout", "GlScreenCaptureSession.stop", CollectionsKt.listOf(this.f471682b));
        return;
    L17:
        return;
    L11:
        if (this.f471705y.post(new ea9.b(this, r101)) == true) goto L14;
        k("render_handler_rejected");
        r101.countDown();
        goto L14
    L5:
        if (ThreadMethodProxy.isAlive(this.f471704x) == true) goto L7;
    }

    public final void i() {
        int r100 = c(35633, "\n            attribute vec4 aPosition;\n            attribute vec4 aTextureCoord;\n            uniform mat4 uTexMatrix;\n            varying vec2 vTextureCoord;\n\n            void main() {\n                gl_Position = aPosition;\n                vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n            }\n        ");
        int r101 = c(35632, "\n            #extension GL_OES_EGL_image_external : require\n            precision mediump float;\n            varying vec2 vTextureCoord;\n            uniform samplerExternalOES uTexture;\n\n            void main() {\n                gl_FragColor = texture2D(uTexture, vTextureCoord);\n            }\n        ");
        int r102 = GLES20.glCreateProgram();
        GLES20.glAttachShader(r102, r100);
        GLES20.glAttachShader(r102, r101);
        GLES20.glLinkProgram(r102);
        int[] r103 = new int[1];
        GLES20.glGetProgramiv(r102, 35714, r103, 0);
        GLES20.glDeleteShader(r100);
        GLES20.glDeleteShader(r101);
        if (r103[0] != 1) goto L6;
        this.f471699s = r102;
        this.f471700t = GLES20.glGetAttribLocation(r102, "aPosition");
        this.f471701u = GLES20.glGetAttribLocation(this.f471699s, "aTextureCoord");
        this.f471702v = GLES20.glGetUniformLocation(this.f471699s, "uTexMatrix");
        this.f471703w = GLES20.glGetUniformLocation(this.f471699s, "uTexture");
        int[] r104 = new int[1];
        GLES20.glGenFramebuffers(1, r104, 0);
        this.f471698r = r104[0];
        return;
    L6:
        String r105 = GLES20.glGetProgramInfoLog(r102);
        GLES20.glDeleteProgram(r102);
        throw new IllegalStateException("Failed to link screen capture program: " + r105);
    }

    public final void o() {
        g();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        VirtualDisplay r101 = this.f471694n;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.release();     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
    L11:
        this.f471694n = null;
        ca9.c r103 = ca9.b.f22972a;
        ca9.c.a.a(ca9.b.f22972a, "ScreenShareGLSessionVirtualDisplayReleased", "GlScreenCaptureSession.releaseVirtualDisplay", CollectionsKt.listOf(this.f471682b), null, 8);
        return;
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static FloatBuffer d(float[] r100) {
        FloatBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r101.put(r100);
        r101.position(0);
        return r101;
    }

    public final void k(String r100) {
        ca9.c r101 = ca9.b.f22972a;
        ca9.b.f22972a.a("ScreenShareCaptureDiagnosticsFinal", "GlScreenCaptureSession.stop", CollectionsKt.listOf(this.f471682b), MapsKt.mapOf(new Pair[]{TuplesKt.to("degraded", Boolean.TRUE), TuplesKt.to("reason", r100)}));
    }

    public final void l(boolean r210) {
        if (this.E == 0) goto L29;
        if (r210 == true) goto L6;
    L8:
        long r100 = SystemClock.elapsedRealtime();
        if (r210 == false) goto L11;
        long r101 = this.E;
    L12:
        long r102 = RangesKt.coerceAtLeast(r100 - r101, 1);
        if (r210 == false) goto L15;
        b r103 = this.O;
    L16:
        long r110 = RangesKt.coerceAtLeast(r103.f471713g, 1);
        long r111 = RangesKt.coerceAtLeast(r103.f471714h, 1);
        long r104 = RangesKt.coerceAtLeast(r103.f471715i, 1);
        ca9.c r112 = ca9.b.f22972a;
        ca9.c r113 = ca9.b.f22972a;
        if (r210 == false) goto L19;
        String r114 = "ScreenShareCaptureDiagnosticsFinal";
    L20:
        List<String> r105 = CollectionsKt.listOf(this.f471682b);
        Pair[] r106 = new Pair[22];
        r106[0] = TuplesKt.to("durationMs", Long.valueOf(r102));
        r106[1] = TuplesKt.to("targetFps", Integer.valueOf(this.f471685e));
        String r107 = r114;
        r106[2] = TuplesKt.to("systemCallbackCount", Long.valueOf(r103.f471707a));
        double r108 = r102;
        r106[3] = TuplesKt.to("systemCallbackFps", Double.valueOf((r103.f471707a * 1000.0d) / r108));
        r106[4] = TuplesKt.to("coalescedCallbackCount", Long.valueOf(r103.f471708b));
        r106[5] = TuplesKt.to("drainCount", Long.valueOf(r103.f471709c));
        r106[6] = TuplesKt.to("throttleDropCount", Long.valueOf(r103.f471710d));
        r106[7] = TuplesKt.to("poolDropCount", Long.valueOf(r103.f471711e));
        r106[8] = TuplesKt.to("staleDropCount", Long.valueOf(r103.f471712f));
        r106[9] = TuplesKt.to("updatedFrameCount", Long.valueOf(r103.f471713g));
        r106[10] = TuplesKt.to("blittedFrameCount", Long.valueOf(r103.f471714h));
        r106[11] = TuplesKt.to("producedFrameCount", Long.valueOf(r103.f471715i));
        r106[12] = TuplesKt.to("producedFps", Double.valueOf((r103.f471715i * 1000.0d) / r108));
        r106[13] = TuplesKt.to("avgUpdateTexImageUs", Double.valueOf(r103.f471716j / r110));
        r106[14] = TuplesKt.to("maxUpdateTexImageUs", Long.valueOf(r103.f471717k));
        r106[15] = TuplesKt.to("avgBlitUs", Double.valueOf(r103.f471718l / r111));
        r106[16] = TuplesKt.to("maxBlitUs", Long.valueOf(r103.f471719m));
        r106[17] = TuplesKt.to("avgDeliveryUs", Double.valueOf(r103.f471720n / r104));
        r106[18] = TuplesKt.to("maxDeliveryUs", Long.valueOf(r103.f471721o));
        long r109 = this.G;
        if (r109 != 0) goto L23;
        long r115 = -1;
    L24:
        r106[19] = TuplesKt.to("lastCallbackAgoMs", Long.valueOf(r115));
        r106[20] = TuplesKt.to("pendingFrame", Boolean.valueOf(this.R.get()));
        r106[21] = TuplesKt.to("drainPosted", Boolean.valueOf(this.S.get()));
        r113.a(r107, "GlScreenCaptureSession.logDiagnosticsSummary", r105, MapsKt.mapOf(r106));
        if (r210 == false) goto L27;
        this.N = true;
        return;
    L27:
        this.F = r100;
        this.P.a();
        return;
    L23:
        r115 = r100 - r109;
        goto L24
    L19:
        r114 = "ScreenShareCaptureDiagnostics";
        goto L20
    L15:
        r103 = this.P;
        goto L16
    L11:
        r101 = this.F;
        goto L12
    L6:
        if (this.N == false) goto L8;
        return;
    }

    public final void m(long r100) {
        long r101 = SystemClock.elapsedRealtime();
        long r102 = this.M;
        if (r102 != 0) goto L5;
    L7:
        this.M = r101;
        ca9.c r103 = ca9.b.f22972a;
        ca9.b.f22972a.c("ScreenShareCaptureDiagnosticsAnomaly", "GlScreenCaptureSession", CollectionsKt.listOf(this.f471682b), MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("expectedGeneration", Long.valueOf(r100)), TuplesKt.to("activeGeneration", Long.valueOf(this.Q)), TuplesKt.to("captureWidth", Integer.valueOf(this.f471696p)), TuplesKt.to("captureHeight", Integer.valueOf(this.f471697q)), TuplesKt.to("captureRotation", Integer.valueOf(this.f471684d))}), MapsKt.mapOf(TuplesKt.to("type", "stale_generation_drop"))));
        return;
    L5:
        if ((r101 - r102) >= 30000) goto L7;
    }

    public final void p(boolean r210) {
        final long r100 = this.Q;
        SurfaceTexture r101 = new SurfaceTexture(this.f471691k);
        r101.setDefaultBufferSize(this.f471696p, this.f471697q);
        r101.setOnFrameAvailableListener(new d(this, r100), this.f471705y);
        Surface r102 = new Surface(r101);
        Resources r103 = this.f471680a.getResources();     // Catch: Exception -> L20
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).densityDpi;     // Catch: Exception -> L20
        VirtualDisplay r105 = this.f471694n;     // Catch: Exception -> L20
        if (r105 != null) goto L9;
        if (r210 == false) goto L8;
        this.f471694n = this.f471683c.createVirtualDisplay("ScreenCapture", this.f471696p, this.f471697q, r104, 16, r102, null, null);     // Catch: Exception -> L20
    L14:
        this.f471692l = r101;     // Catch: Exception -> L20
        this.f471693m = r102;     // Catch: Exception -> L20
        ca9.c r106 = ca9.b.f22972a;     // Catch: Exception -> L20
        ca9.c r107 = ca9.b.f22972a;     // Catch: Exception -> L20
        List<String> r108 = CollectionsKt.listOf(this.f471682b);     // Catch: Exception -> L20
        Pair[] r109 = new Pair[4];     // Catch: Exception -> L20
        r109[0] = TuplesKt.to("width", Integer.valueOf(this.f471696p));     // Catch: Exception -> L20
        r109[1] = TuplesKt.to("height", Integer.valueOf(this.f471697q));     // Catch: Exception -> L20
        r109[2] = TuplesKt.to("density", Integer.valueOf(r104));     // Catch: Exception -> L20
        if (this.f471694n != null) goto L17;
        boolean r110 = true;
    L18:
        r109[3] = TuplesKt.to("virtualDisplayNull", Boolean.valueOf(r110));     // Catch: Exception -> L20
        r107.a("ScreenShareGLSessionVirtualDisplayReady", "GlScreenCaptureSession.setupVirtualDisplay", r108, MapsKt.mapOf(r109));     // Catch: Exception -> L20
        return;
    L17:
        r110 = false;
        goto L18
    L8:
        throw new IllegalStateException("VirtualDisplay is null before resize/update");     // Catch: Exception -> L20
    L9:
        if (r105 == null) goto L11;
        r105.resize(this.f471696p, this.f471697q, r104);     // Catch: Exception -> L20
    L11:
        VirtualDisplay r111 = this.f471694n;     // Catch: Exception -> L20
        if (r111 == null) goto L14;
        r111.setSurface(r102);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L24
        r101.setOnFrameAvailableListener(null);     // Catch: Throwable -> L24
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L41:
        r102.release();     // Catch: Throwable -> L28
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L43:
        r101.release();     // Catch: Throwable -> L32
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        ca9.c r113 = ca9.b.f22972a;
        ca9.c r114 = ca9.b.f22972a;
        List<String> r115 = CollectionsKt.listOf(this.f471682b);
        Pair[] r116 = new Pair[6];
        r116[0] = TuplesKt.to("error", e.getClass().getSimpleName());
        String r117 = e.getMessage();
        if (r117 != null) goto L37;
        r117 = "";
    L37:
        r116[1] = TuplesKt.to("error_msg", r117);
        r116[2] = TuplesKt.to("createIfAbsent", Boolean.valueOf(r210));
        r116[3] = TuplesKt.to("captureWidth", Integer.valueOf(this.f471696p));
        r116[4] = TuplesKt.to("captureHeight", Integer.valueOf(this.f471697q));
        r116[5] = TuplesKt.to("captureRotation", Integer.valueOf(this.f471684d));
        r114.b("ScreenShareCaptureException", "GlScreenCaptureSession.setupVirtualDisplay", r115, MapsKt.mapOf(r116));
        throw e;
    L32:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    }

    public static final void a(e r210, long r211) {
        if (r210.f471695o == false) goto L74;
        r210.O.f471709c++;
        r210.P.f471709c++;
        if (r211 == r210.Q) goto L8;
        r210.O.f471712f++;
        r210.P.f471712f++;
        r210.m(r211);
        return;
    L8:
        SurfaceTexture r100 = r210.f471692l;
        if (r100 != null) goto L67;
        return;
    L67:
        long r101 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L64
        r100.updateTexImage();     // Catch: Exception -> L64
        long r102 = (SystemClock.elapsedRealtimeNanos() - r101) / 1000;     // Catch: Exception -> L64
        b r103 = r210.O;     // Catch: Exception -> L64
        r103.f471713g++;     // Catch: Exception -> L64
        r210.P.f471713g++;     // Catch: Exception -> L64
        r103.f471716j += r102;     // Catch: Exception -> L64
        r103.f471717k = Math.max(r103.f471717k, r102);     // Catch: Exception -> L64
        b r104 = r210.P;     // Catch: Exception -> L64
        r104.f471716j += r102;     // Catch: Exception -> L64
        r104.f471717k = Math.max(r104.f471717k, r102);     // Catch: Exception -> L64
        r100.getTransformMatrix(r210.f471706z);     // Catch: Exception -> L64
        Long r105 = Long.valueOf(r100.getTimestamp());     // Catch: Exception -> L64
        if (r105.longValue() <= 0) goto L15;
        boolean r110 = true;
    L16:
        if (r110 == true) goto L19;
        r105 = null;
    L19:
        if (r105 == null) goto L21;
        long r111 = r105.longValue();     // Catch: Exception -> L64
    L22:
        long r106 = r210.D;     // Catch: Exception -> L64
        if (r106 != 0) goto L25;
    L27:
        r210.D = r111;     // Catch: Exception -> L64
        if (((ArrayList) r210.A).isEmpty() == false) goto L30;
        c r112 = null;
    L32:
        if (r112 != null) goto L39;
        r210.O.f471711e++;     // Catch: Exception -> L64
        r210.P.f471711e++;     // Catch: Exception -> L64
        long r107 = SystemClock.elapsedRealtime();     // Catch: Exception -> L64
        long r108 = r210.L;     // Catch: Exception -> L64
        if (r108 != 0) goto L36;
    L38:
        r210.L = r107;     // Catch: Exception -> L64
        ca9.c r109 = ca9.b.f22972a;     // Catch: Exception -> L64
        ca9.b.f22972a.c("ScreenShareCaptureDiagnosticsAnomaly", "GlScreenCaptureSession", CollectionsKt.listOf(r210.f471682b), MapsKt.plus(MapsKt.mapOf(TuplesKt.to("poolSize", Integer.valueOf(((ArrayList) r210.A).size()))), MapsKt.mapOf(TuplesKt.to("type", "texture_pool_exhausted"))));     // Catch: Exception -> L64
        return;
    L36:
        if ((r107 - r108) >= 30000) goto L38;
        return;
    L39:
        int r113 = r210.f471684d;     // Catch: Exception -> L64
        int r114 = ((r113 % 360) + 360) % 360;     // Catch: Exception -> L64
        int r115 = ((r113 % 360) + 360) % 360;     // Catch: Exception -> L64
        if (r115 == 90) goto L44;
        if (r115 == 270) goto L43;
        int r212 = r115;
    L45:
        long r116 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L64
        r210.b(r112.f471722a, r210.f471706z, r114);     // Catch: Exception -> L64
        long r117 = (SystemClock.elapsedRealtimeNanos() - r116) / 1000;     // Catch: Exception -> L64
        b r118 = r210.O;     // Catch: Exception -> L64
        r118.f471714h++;     // Catch: Exception -> L64
        r210.P.f471714h++;     // Catch: Exception -> L64
        r118.f471718l += r117;     // Catch: Exception -> L64
        r118.f471719m = Math.max(r118.f471719m, r117);     // Catch: Exception -> L64
        b r119 = r210.P;     // Catch: Exception -> L64
        r119.f471718l += r117;     // Catch: Exception -> L64
        r119.f471719m = Math.max(r119.f471719m, r117);     // Catch: Exception -> L64
        da9.b r120 = new da9.b(r210.f471682b, r111 / 1000000, Math.min(r210.f471696p, r210.f471697q), Math.max(r210.f471696p, r210.f471697q), r212, PixelFormat.TEXTURE_2D, new da9.a(r112.f471722a, (float[]) f471678g0.clone(), r210.f471689i));     // Catch: Exception -> L64
        if (r102 < 100000) goto L48;
    L49:
        long r121 = SystemClock.elapsedRealtime();     // Catch: Exception -> L64
        long r122 = r210.f471679J;     // Catch: Exception -> L64
        if (r122 != 0) goto L52;
    L54:
        r210.f471679J = r121;     // Catch: Exception -> L64
        ca9.c r123 = ca9.b.f22972a;     // Catch: Exception -> L64
        ca9.b.f22972a.c("ScreenShareCaptureDiagnosticsAnomaly", "GlScreenCaptureSession", CollectionsKt.listOf(r210.f471682b), MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("updateTexImageDurationUs", Long.valueOf(r102)), TuplesKt.to("blitDurationUs", Long.valueOf(r117))}), MapsKt.mapOf(TuplesKt.to("type", "slow_gl_processing"))));     // Catch: Exception -> L64
    L55:
        long r124 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L64
        r210.f471686f.invoke(r120);     // Catch: Exception -> L64
        long r125 = (SystemClock.elapsedRealtimeNanos() - r124) / 1000;     // Catch: Exception -> L64
        b r126 = r210.O;     // Catch: Exception -> L64
        r126.f471720n += r125;     // Catch: Exception -> L64
        r126.f471721o = Math.max(r126.f471721o, r125);     // Catch: Exception -> L64
        b r127 = r210.P;     // Catch: Exception -> L64
        r127.f471720n += r125;     // Catch: Exception -> L64
        r127.f471721o = Math.max(r127.f471721o, r125);     // Catch: Exception -> L64
        r210.O.f471715i++;     // Catch: Exception -> L64
        r210.P.f471715i++;     // Catch: Exception -> L64
        if (r125 < 100000) goto L72;
        long r128 = SystemClock.elapsedRealtime();     // Catch: Exception -> L64
        long r129 = r210.K;     // Catch: Exception -> L64
        if (r129 != 0) goto L60;
    L62:
        r210.K = r128;     // Catch: Exception -> L64
        ca9.c r130 = ca9.b.f22972a;     // Catch: Exception -> L64
        ca9.b.f22972a.c("ScreenShareCaptureDiagnosticsAnomaly", "GlScreenCaptureSession", CollectionsKt.listOf(r210.f471682b), MapsKt.plus(MapsKt.mapOf(TuplesKt.to("deliveryDurationUs", Long.valueOf(r125))), MapsKt.mapOf(TuplesKt.to("type", "slow_frame_delivery"))));     // Catch: Exception -> L64
        return;
    L60:
        if ((r128 - r129) >= 30000) goto L62;
        return;
    L72:
        return;
    L52:
        if ((r121 - r122) >= 30000) goto L54;
    L48:
        if (r117 < 100000) goto L55;
    L43:
        r212 = 90;
        goto L45
    L44:
        r212 = 270;
        goto L45
    L30:
        r112 = (c) ListProtector.get(r210.A, r210.B);     // Catch: Exception -> L64
        r210.B = (r210.B + 1) % ((ArrayList) r210.A).size();     // Catch: Exception -> L64
        goto L32
    L25:
        if ((r111 - r106) >= r210.C) goto L27;
        r210.O.f471710d++;     // Catch: Exception -> L64
        r210.P.f471710d++;     // Catch: Exception -> L64
        return;
    L21:
        r111 = System.nanoTime();     // Catch: Exception -> L64
        goto L22
    L15:
        r110 = false;
    L64:
        e = move-exception;
        r210.h("drainFrame", e, true);
        return;
    }

    public static int c(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 1) goto L5;
        return r102;
    L5:
        String r104 = GLES20.glGetShaderInfoLog(r102);
        GLES20.glDeleteShader(r102);
        throw new IllegalStateException("Failed to compile shader: " + r104);
    }

    public final void b(int r110, float[] r111, int r112) {
        GLES20.glBindFramebuffer(36160, this.f471698r);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r110, 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) goto L17;
        GLES20.glViewport(0, 0, Math.min(this.f471696p, this.f471697q), Math.max(this.f471696p, this.f471697q));
        GLES20.glUseProgram(this.f471699s);
        GLES20.glEnableVertexAttribArray(this.f471700t);
        GLES20.glVertexAttribPointer(this.f471700t, 2, 5126, false, 0, this.T);
        GLES20.glEnableVertexAttribArray(this.f471701u);
        int r100 = this.f471701u;
        int r113 = ((r112 % 360) + 360) % 360;
        if (r113 != 90) goto L7;
        FloatBuffer r114 = this.V;
    L14:
        GLES20.glVertexAttribPointer(r100, 2, 5126, false, 0, r114);
        GLES20.glUniformMatrix4fv(this.f471702v, 1, false, r111, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f471691k);
        GLES20.glUniform1i(this.f471703w, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        GLES20.glBindTexture(36197, 0);
        GLES20.glDisableVertexAttribArray(this.f471700t);
        GLES20.glDisableVertexAttribArray(this.f471701u);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return;
    L7:
        if (r113 != 180) goto L9;
        r114 = this.W;
        goto L14
    L9:
        if (r113 == 270) goto L11;
        r114 = this.U;
        goto L14
    L11:
        r114 = this.X;
        goto L14
    L17:
        throw new IllegalStateException("Framebuffer is incomplete when blitting screen frame");
    }

    public final void h(String r100, Throwable r101, boolean r110) {
        ca9.c r102 = ca9.b.f22972a;
        ca9.c r103 = ca9.b.f22972a;
        String r104 = "GlScreenCaptureSession.".concat(r100);
        List<String> r105 = CollectionsKt.listOf(this.f471682b);
        Pair[] r106 = new Pair[6];
        r106[0] = TuplesKt.to("error", r101.getClass().getSimpleName());
        String r107 = r101.getMessage();
        if (r107 != null) goto L5;
        r107 = "";
    L5:
        r106[1] = TuplesKt.to("error_msg", r107);
        r106[2] = TuplesKt.to("isRunning", Boolean.valueOf(this.f471695o));
        r106[3] = TuplesKt.to("captureWidth", Integer.valueOf(this.f471696p));
        r106[4] = TuplesKt.to("captureHeight", Integer.valueOf(this.f471697q));
        r106[5] = TuplesKt.to("captureRotation", Integer.valueOf(this.f471684d));
        r103.b("ScreenShareCaptureException", r104, r105, MapsKt.mapOf(r106));
        this.f471705y.removeCallbacks(this.Y);
        this.f471705y.removeCallbacks(this.Z);
        l(true);
        this.f471695o = false;
        this.Q++;
        this.R.set(false);
        this.S.set(false);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L8
        o();     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L23:
        n();     // Catch: Throwable -> L12
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L25:
        Result.m9449constructorimpl(Boolean.valueOf(this.f471704x.quitSafely()));     // Catch: Throwable -> L16
    L18:
        if (r110 == false) goto L29;
        Function1<Throwable, Unit> r109 = this.f471687g;
        if (r109 == null) goto L30;
        r109.invoke(r101);
        return;
    L30:
        return;
    L29:
        return;
    L16:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public e(Context r100, String r101, MediaProjection r102, int r103, int r104, int r105, int r106, j r107, k r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "projection");
        Intrinsics.checkNotNullParameter(r107, "onFrameAvailable");
        this.f471680a = r100;
        this.f471682b = r101;
        this.f471683c = r102;
        this.f471684d = r105;
        this.f471685e = r106;
        this.f471686f = r107;
        this.f471687g = r110;
        this.f471688h = EGL14.EGL_NO_DISPLAY;
        this.f471689i = EGL14.EGL_NO_CONTEXT;
        this.f471690j = EGL14.EGL_NO_SURFACE;
        this.f471696p = r103;
        this.f471697q = r104;
        this.f471700t = -1;
        this.f471701u = -1;
        this.f471702v = -1;
        this.f471703w = -1;
        PthreadHandlerThreadV2 r108 = new PthreadHandlerThreadV2("GLCaptureThread");
        ThreadMethodProxy.start(r108);
        this.f471704x = r108;
        this.f471705y = new Handler(r108.getLooper());
        this.f471706z = new float[16];
        this.A = new ArrayList();
        this.C = C.NANOS_PER_SECOND / ((long) RangesKt.coerceAtLeast(r106, 1));
        this.O = new b(0);
        this.P = new b(0);
        this.R = new AtomicBoolean(false);
        this.S = new AtomicBoolean(false);
        this.T = d(f471673b0);
        this.U = d(f471674c0);
        this.V = d(f471675d0);
        this.W = d(f471676e0);
        this.X = d(f471677f0);
        this.Y = new g(this);
        this.Z = new f(this);
        this.f471681a0 = new h(this);
    }
}
