package iy5;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.Choreographer;
import androidx.camera.video.AudioStats;
import com.byted.cast.common.TeaEventTrack;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    public static volatile e L;
    public static final AtomicInteger M = null;
    public Method A;
    public Handler B;
    public long C;
    public long D;
    public boolean E;
    public final a F;
    public final iy5.b G;
    public final iy5.c H;
    public final iy5.d I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final b f496501J;
    public final c K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iy5.a f496502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MessageQueue f496503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f496504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f496505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f496506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f496507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HandlerThreadC6369e f496508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f496509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Handler f496510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f496511j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f496512k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f496513l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f496514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f496515n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f496516o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double f496517p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f496518q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f496519r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f496520s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f496521t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile int f496522u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile long f496523v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile long f496524w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f496525x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final iy5.f f496526y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Method f496527z;

    public class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f496528a;

        public a(e r100) {
            this.f496528a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r110) {
            e r100 = this.f496528a;
            if (r100.f496526y.d() == false) goto L10;
            iy5.f r101 = r100.f496526y;
            String r102 = "do frame " + r110;
            if (r101.d() == false) goto L10;
            if (r101.f496540c > 0) goto L10;
            r101.f496539b.v(r102);
        L10:
            if (r100.f496514m > 0) goto L13;
        L25:
            r100.f496511j = r110;
            if (r100.g(r100.f496522u) == false) goto L29;
            r100.f496522u = -1;
        L29:
            if (this.f496528a.f496506e == false) goto L32;
            Choreographer.getInstance().postFrameCallback(this.f496528a.F);
            return;
        L32:
            return;
        L13:
            if (r100.f496511j <= 0) goto L15;
            long r103 = r110 - r100.f496511j;
        L17:
            if (r103 <= 0) goto L25;
            int r104 = r100.f496515n;
            if (r104 >= r100.f496514m) goto L22;
            r100.f496515n = r104 + 1;
        L22:
            long r105 = r100.f496516o;
            int r106 = r100.f496515n;
            r100.f496516o = ((r105 * ((long) (r106 - 1))) + r103) / ((long) r106);
            r100.f496512k = r100.f496513l + r100.f496516o;
            if (r100.f496526y.d() == false) goto L25;
            r100.f496526y.a("FWatchDog", "Dynamic Interval update : " + r100.f496516o + "; new frame duration : " + r103);
            goto L25
        L15:
            r103 = 0;
            goto L17
        }
    }

    public class b implements j {
        @Override // iy5.j
        public final void d(String r100, String r101) {
        }

        @Override // iy5.j
        public final void e(String r100, String r101) {
        }

        @Override // iy5.j
        public final void i(String r100) {
        }

        @Override // iy5.j
        public final void v(String r100) {
        }

        @Override // iy5.j
        public final void w(String r100, String r101) {
        }

        public b() {
        }
    }

    public class c extends f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f496529d;

        public final void b() {
            super.run();     // Catch: Exception -> L8
            if (this.f496529d.f496509h == false) goto L13;
            Handler r100 = this.f496529d.f496510i;     // Catch: Exception -> L8
            if (r100 == null) goto L14;
            r100.postDelayed(this.f496529d.K, this.f496535a);     // Catch: Exception -> L8
            return;
        L14:
            return;
        L13:
            return;
        L8:
            e = move-exception;
            this.f496529d.f496526y.b("FWatchDog", "timerMonitorRunnable error " + e.getMessage());
        }

        @Override // iy5.e.f, java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(e r100, double r101, float r102) {
            this.f496529d = r100;
            super(r100, r101, r102);
        }
    }

    public class d extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final double f496530v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public double f496531w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public long f496532x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public volatile boolean f496533y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final /* synthetic */ e f496534z;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
        L17:
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        L3:
            if (this.f496533y == true) goto L8;
            Thread.sleep(this.f496532x);     // Catch: Exception -> L6 Throwable -> L10
            m();     // Catch: Exception -> L6 Throwable -> L10
            l();     // Catch: Exception -> L6 Throwable -> L10
        L7:
            this.f496533y = true;     // Catch: Throwable -> L10
            goto L17
        L8:
            this.f496534z.f496526y.a("FWatchDog", "work thread stop success!");     // Catch: Throwable -> L10
        }

        public final void l() {
            long r100 = System.nanoTime();
            if (this.f496534z.f496511j >= 0) goto L5;
            return;
        L5:
            if ((r100 - this.f496534z.f496511j) <= this.f496534z.f496512k) goto L11;
            this.f496534z.f496526y.b("FWatchDog", "1: drop frame， current " + r100);
            if (this.f496534z.f496511j == this.f496534z.f496523v) goto L12;
            e r101 = this.f496534z;
            r101.f496523v = r101.f496511j;
            this.f496534z.e().postAtFrontOfQueue(this.f496534z.G);
            return;
        L12:
            return;
        }

        public final void m() {
            long r100 = System.nanoTime();
            if (this.f496534z.f496524w <= 0) goto L12;
            e r101 = this.f496534z;
            if (r101.f496519r <= 0) goto L13;
            long r102 = r100 - r101.f496524w;
            e r103 = this.f496534z;
            if (r102 > r103.f496519r) goto L9;
            return;
        L9:
            if (r103.f496525x == true) goto L15;
            this.f496534z.f496525x = true;
            Message r104 = Message.obtain(this.f496534z.e(), this.f496534z.I);
            this.f496534z.e().sendMessageAtFrontOfQueue(r104);
            this.f496534z.f496526y.b("FWatchDog", "ooooooo! discover a ANR!");
            return;
        L15:
            return;
        L13:
            return;
        }

        public d(e r100, double r101, float r102) {
            this.f496534z = r100;
            super("FWatchDogWorkThread");
            this.f496532x = 0;
            this.f496533y = false;
            this.f496530v = r101;
            double r103 = r102;
            this.f496531w = r103;
            this.f496532x = Math.max((long) ((r100.D * r101) * r103), 1);
            r100.f496526y.a("FWatchDog", "current device frame time nano : " + r100.f496513l + "; check interval : " + this.f496532x + "; check interval time : " + this.f496531w);
        }
    }

    /* JADX INFO: renamed from: iy5.e$e, reason: collision with other inner class name */
    public static class HandlerThreadC6369e extends PthreadHandlerThreadV2 {
        public HandlerThreadC6369e() {
            super("FWatchDogWorkHandlerThread");
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f496535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f496536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f496537c;

        public final void a() {
            long r100 = System.nanoTime();
            if (this.f496537c.f496524w <= 0) goto L11;
            e r101 = this.f496537c;
            if (r101.f496519r <= 0) goto L11;
            long r102 = r100 - r101.f496524w;
            e r103 = this.f496537c;
            if (r102 <= r103.f496519r) goto L11;
            if (r103.f496525x == true) goto L11;
            this.f496537c.f496525x = true;
            this.f496537c.e().sendMessageAtFrontOfQueue(Message.obtain(this.f496537c.e(), this.f496537c.I));
            this.f496537c.f496526y.b("FWatchDog", "ooooooo! discover a ANR!");
        L11:
            long r104 = System.nanoTime();
            if (this.f496537c.f496511j >= 0) goto L14;
            return;
        L14:
            if ((r104 - this.f496537c.f496511j) <= this.f496537c.f496512k) goto L21;
            this.f496537c.f496526y.b("FWatchDog", "1: drop frame， current " + r104);
            if (this.f496537c.f496511j == this.f496537c.f496523v) goto L18;
            e r105 = this.f496537c;
            r105.f496523v = r105.f496511j;
            this.f496537c.e().postAtFrontOfQueue(this.f496537c.G);
            return;
        L18:
            this.f496537c.f496526y.b("FWatchDog", "1: drop frame， remove");
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(e r100, double r101, float r102) {
            this.f496537c = r100;
            this.f496535a = 0;
            this.f496536b = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.f496536b = r101;
            this.f496535a = Math.max((long) ((r100.D * r101) * ((double) r102)), 1);
        }
    }

    public final void h() {
        this.f496509h = false;     // Catch: Exception -> L10
        HandlerThreadC6369e r100 = this.f496508g;     // Catch: Exception -> L10
        if (r100 == null) goto L7;
        r100.quitSafely();     // Catch: Exception -> L10
        this.f496508g = null;     // Catch: Exception -> L10
    L7:
        if (this.f496510i == null) goto L15;
        this.f496510i.removeCallbacks(this.K);     // Catch: Exception -> L10
        this.f496510i = null;     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        this.f496526y.b("FWatchDog", e.getMessage());
    }

    static {
        M = new AtomicInteger(0);
    }

    public static e d() {
        if (L != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (L != null) goto L9;
        L = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return L;
    }

    public final void a() {
        this.f496526y.a("FWatchDog", "check and remove invalidate barrier!");     // Catch: Exception -> L15
        MessageQueue r100 = f();     // Catch: Exception -> L15
        if (r100 == null) goto L24;
        Message r101 = (Message) new k(r100).c("mMessages", new Class[0]).f496561a;     // Catch: Exception -> L15
    L6:
        if (r101 == null) goto L26;
        if (r101.getWhen() > 1) goto L25;
        if (r101.getTarget() != null) goto L13;
        g(r101.arg1);     // Catch: Exception -> L15
    L13:
        r101 = (Message) new k(r101).c(TeaEventTrack.ACTION_DRAMA_NEXT, new Class[0]).f496561a;     // Catch: Exception -> L15
        goto L6
    L25:
        return;
    L26:
        return;
    L24:
        return;
    L15:
        e = move-exception;
        this.f496526y.b("FWatchDog", "check invalidate barrier error! " + e.getMessage());
    }

    public final Handler e() {
        if (this.B != null) goto L6;
        this.B = new Handler(Looper.getMainLooper());
    L6:
        return this.B;
    }

    public final MessageQueue f() {
        if (this.f496503b != null) goto L9;
        this.f496503b = (MessageQueue) new k(Looper.getMainLooper()).c("mQueue", new Class[0]).f496561a;     // Catch: Exception -> L6
    L6:
        e = move-exception;
        this.f496526y.b("FWatchDog", e.getMessage());
    L9:
        return this.f496503b;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [iy5.b] */
    /* JADX WARN: Type inference failed for: r0v4, types: [iy5.c] */
    /* JADX WARN: Type inference failed for: r0v5, types: [iy5.d] */
    public e() {
        this.f496502a = new iy5.a();
        this.f496506e = false;
        this.f496509h = false;
        this.f496511j = -1;
        this.f496512k = 0;
        this.f496513l = 0;
        this.f496514m = 10;
        this.f496515n = 0;
        this.f496516o = 0;
        this.f496517p = 1.0d;
        this.f496518q = 1.0f;
        this.f496519r = 2000000000;
        this.f496520s = false;
        this.f496521t = true;
        this.f496522u = -1;
        this.f496523v = -1;
        this.f496524w = -1;
        this.f496525x = false;
        this.f496526y = new iy5.f();
        this.B = null;
        this.E = false;
        this.F = new a(this);
        this.G = new iy5.b(this);
        this.H = new iy5.c(this);
        this.I = new iy5.d(this);
        this.f496501J = new b();
        this.K = new c(this, this.f496517p, this.f496518q);
    }

    public final int b(Object r100) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String r101 = "enqueueSyncBarrier";
    L7:
        if (this.f496521t == false) goto L22;
        if (this.f496527z == null) goto L23;
    L15:
        Method r102 = this.f496527z;
        if (r102 != null) goto L18;
        return -1;
    L18:
        return ((Integer) r102.invoke(r100, new Object[]{1L})).intValue();
    L23:
        Method r103 = new k(r100).f(r101, new Class[]{Long.class});     // Catch: Exception -> L14
        this.f496527z = r103;     // Catch: Exception -> L14
        if (r103 == null) goto L15;
        r103.setAccessible(true);     // Catch: Exception -> L14
    L14:
        this.f496526y.b("FWatchDog", "getPostSyncBarrierMethod error!");
        goto L15
    L22:
        return ((Integer) new k(r100).call(r101, new Class[]{Long.class}, new Object[]{1L}).f496561a).intValue();
    L5:
        r101 = "postSyncBarrier";
        goto L7
    }

    public final boolean g(int r110) {
        if (r110 >= 0) goto L26;
    L20:
        return false;
    L26:
        MessageQueue r100 = f();     // Catch: Exception -> L10
        if (r100 != null) goto L24;
    L8:
        this.f496526y.b("FWatchDog", "remove a barrier, token : " + r110);     // Catch: Exception -> L21
        return true;
    L22:
        iy5.a r101 = this.f496502a;     // Catch: Exception -> L19
        if (r101.f496495f != null) goto L14;
        r101.f496495f = r101.c(MessageQueue.class, "removeSyncBarrier", new Class[]{Integer.class});     // Catch: Exception -> L19
    L14:
        Method r102 = r101.f496495f;     // Catch: Exception -> L19
        if (r102 == null) goto L20;
        if (r100 == null) goto L20;
        r102.invoke(r100, new Object[]{Integer.valueOf(r110)});     // Catch: Exception -> L19
        this.f496526y.b("FWatchDog", "remove a barrier, token : " + r110);     // Catch: Exception -> L19
        return true;
    L19:
        this.f496526y.b("FWatchDog", "remove barrier error!");
        goto L20
    L24:
        c(r100, r110);     // Catch: Exception -> L21
    L10:
        r100 = null;
        goto L22
    }

    public final void c(Object r100, int r101) throws InvocationTargetException, IllegalAccessException {
        if (this.f496521t == true) goto L5;
        new k(r100).call("removeSyncBarrier", new Class[]{Integer.class}, new Object[]{Integer.valueOf(r101)});
        return;
    L5:
        if (this.A == null) goto L16;
    L11:
        Method r102 = this.A;
        if (r102 == null) goto L18;
        r102.invoke(r100, new Object[]{Integer.valueOf(r101)});
        return;
    L18:
        return;
    L16:
        Method r103 = new k(r100).f("removeSyncBarrier", new Class[]{Integer.class});     // Catch: Exception -> L10
        this.A = r103;     // Catch: Exception -> L10
        if (r103 == null) goto L11;
        r103.setAccessible(true);     // Catch: Exception -> L10
    L10:
        this.f496526y.b("FWatchDog", "getRemoveSyncBarrierMethod error!");
        goto L11
    }
}
