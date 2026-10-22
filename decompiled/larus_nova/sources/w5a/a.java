package w5a;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Choreographer;
import android.view.Display;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.FlutterJNI;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[] f558364d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f558365e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f558366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static b f558367g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d f558368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlutterJNI f558369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C8072a f558370c;

    /* JADX INFO: renamed from: w5a.a$a, reason: collision with other inner class name */
    public class C8072a implements FlutterJNI.AsyncWaitForVsyncDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f558371a;

        public C8072a(a r100) {
            this.f558371a = r100;
        }

        @Override // com.lynx.clay.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
        public final void asyncWaitForVsync(long r100) {
            Choreographer.getInstance().postFrameCallback(new c(this.f558371a, r100));
        }
    }

    public class b implements DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayManager f558372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PthreadHandlerThreadV2 f558373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f558374c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f558375d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RunnableC8073a f558376e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f558377f;

        /* JADX INFO: renamed from: w5a.a$b$a, reason: collision with other inner class name */
        public class RunnableC8073a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f558378a;

            @Override // java.lang.Runnable
            public final void run() {
                b r100 = this.f558378a;     // Catch: Throwable -> L29
                r100.getClass();     // Catch: Throwable -> L29
                int r101 = 0;
                Display r102 = r100.f558372a.getDisplay(0);     // Catch: Throwable -> L34
                if (r102 == null) goto L32;
                float r103 = r102.getRefreshRate();     // Catch: Throwable -> L34
                a r104 = r100.f558377f;     // Catch: Throwable -> L34
                r104.getClass();     // Catch: Throwable -> L34
                if (r103 > 0.0f) goto L9;
            L20:
                r103 = -1.0f;
            L22:
                if (r103 > 0.0f) goto L25;
                return;
            L25:
                if (Math.abs(r104.f558368a.f558381a - r103) < 0.5f) goto L42;
                r104.f558368a = new d(r103, (long) (1.0E9d / ((double) r103)));     // Catch: Throwable -> L34
                r104.f558369b.setRefreshRateFPS(r103);     // Catch: Throwable -> L34
                return;
            L42:
                return;
            L9:
                if (Float.isNaN(r103) == true) goto L20;
                if (Float.isInfinite(r103) == true) goto L20;
                float[] r105 = a.f558364d;     // Catch: Throwable -> L34
            L15:
                if (r101 >= 12) goto L22;
                float r106 = r105[r101];     // Catch: Throwable -> L34
                if (Math.abs(r103 - r106) < 0.5f) goto L18;
                r101 = r101 + 1;     // Catch: Throwable -> L34
                goto L15
            L18:
                r103 = r106;
                goto L22
            L32:
                return;
            L45:
                return;
            L29:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L43;
                throw th;
            }

            public RunnableC8073a(b r100) {
                this.f558378a = r100;
            }
        }

        public final synchronized void a() {
            monitor-enter(this);
            if (this.f558375d == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            if (this.f558373b != null) goto L10;
        L12:
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("ClayVsyncDisplayListener");     // Catch: Throwable -> L15
            this.f558373b = r100;     // Catch: Throwable -> L15
            ThreadMethodProxy.start(r100);     // Catch: Throwable -> L15
            this.f558374c = new Handler(this.f558373b.getLooper());     // Catch: Throwable -> L15
        L13:
            this.f558372a.registerDisplayListener(this, this.f558374c);     // Catch: Throwable -> L15
            this.f558375d = true;     // Catch: Throwable -> L15
        L23:
            monitor-exit(this);
            return;
        L10:
            if (this.f558374c == null) goto L12;
        L30:
            this.f558375d = false;     // Catch: Throwable -> L25
            if (this.f558373b == null) goto L23;
            Handler r101 = this.f558374c;     // Catch: Throwable -> L25
            if (r101 == null) goto L22;
            r101.removeCallbacksAndMessages(null);     // Catch: Throwable -> L25
        L22:
            this.f558373b.quit();     // Catch: Throwable -> L25
            this.f558373b = null;     // Catch: Throwable -> L25
            this.f558374c = null;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int r100) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int r100) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int r100) {
            if (r100 == 0) goto L4;
            return;
        L4:
            monitor-enter(this);
            Handler r101 = this.f558374c;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            if (r101 == null) goto L16;
            r101.removeCallbacks(this.f558376e);
            r101.postDelayed(this.f558376e, 32);
            return;
        L16:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public b(a r100, DisplayManager r101) {
            this.f558377f = r100;
            this.f558375d = false;
            this.f558376e = new RunnableC8073a(this);
            this.f558372a = r101;
        }
    }

    public class c implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f558379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f558380b;

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r110) {
            long r100 = System.nanoTime() - r110;
            if (r100 >= 0) goto L5;
            long r101 = 0;
        L6:
            this.f558380b.f558369b.onVsync(r101, this.f558380b.f558368a.f558382b, this.f558379a);
            return;
        L5:
            r101 = r100;
            goto L6
        }

        public c(a r100, long r101) {
            this.f558380b = r100;
            this.f558379a = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f558381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f558382b;

        public d(float r100, long r101) {
            this.f558381a = r100;
            this.f558382b = r101;
        }
    }

    static {
        f558364d = new float[]{24.0f, 30.0f, 48.0f, 50.0f, 60.0f, 72.0f, 90.0f, 96.0f, 120.0f, 144.0f, 165.0f, 240.0f};
        f558365e = new d(60.0f, (long) (1.0E9d / ((double) 60.0f)));
    }

    public a(FlutterJNI r100) {
        this.f558368a = f558365e;
        this.f558370c = new C8072a(this);
        this.f558369b = r100;
    }

    public static a a(DisplayManager r100, FlutterJNI r101) {
        if (f558366f != null) goto L6;
        f558366f = new a(r101);
    L6:
        if (f558367g != null) goto L8;
        a r102 = f558366f;
        r102.getClass();
        b r103 = new b(r102, r100);
        f558367g = r103;
        r103.a();
    L8:
        b r104 = f558367g;
        monitor-enter(r104);
        Handler r105 = r104.f558374c;     // Catch: Throwable -> L17
        monitor-exit(r104);     // Catch: Throwable -> L17
        if (r105 == null) goto L16;
        r105.removeCallbacks(r104.f558376e);
        r105.postAtFrontOfQueue(r104.f558376e);
    L16:
        return f558366f;
    L17:
        th = move-exception;
        throw th;
    }
}
