package com.bytedance.fwatchdog;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.Choreographer;
import com.byted.cast.common.TeaEventTrack;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import iy5.f;
import iy5.g;
import iy5.h;
import iy5.j;
import iy5.k;
import iy5.l;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class FWatchDogV2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile FWatchDogV2 f244921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicInteger f244922o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f244923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MessageQueue f244924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f244925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f244926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f244927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f244928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f244929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f244930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f244931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f244932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f244933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f244934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f244935m;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FWatchDogV2 f244936a;

        @Override // java.lang.Runnable
        public final void run() {
            FWatchDogV2 r100 = this.f244936a;     // Catch: Throwable -> L6
            if (r100.e(r100.f244930h) == false) goto L9;
            this.f244936a.f244930h = -1;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(FWatchDogV2 r100) {
            this.f244936a = r100;
        }
    }

    public class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FWatchDogV2 f244937a;

        public b(FWatchDogV2 r100) {
            this.f244937a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            if (this.f244937a.f244931i.d() == false) goto L6;
            this.f244937a.f244931i.c("do frame " + r100);
        L6:
            if (this.f244937a.f244929g == false) goto L9;
            Choreographer.getInstance().postFrameCallback(this.f244937a.f244935m);
            return;
        }
    }

    public class c implements j {
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

        public c() {
        }
    }

    private native boolean startVsyncHookNative();

    private native boolean stopVsyncHookNative();

    static {
        Intrinsics.checkNotNullParameter("fwatchdog", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> fwatchdog");
        com.bytedance.librarian.a.c("fwatchdog");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> fwatchdog");
        f244922o = new AtomicInteger(0);
    }

    public static FWatchDogV2 c() {
        if (f244921n != null) goto L15;
        monitor-enter(FWatchDogV2.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f244921n != null) goto L9;
        f244921n = new FWatchDogV2();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FWatchDogV2.class);     // Catch: Throwable -> L11
    L15:
        return f244921n;
    }

    private void onVsync() {
        this.f244931i.c("onVsync: do action");
        int r100 = this.f244932j.f496548e;
        boolean r101 = false;
        if (r100 != 1) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
        if (r100 != 0) goto L27;
        r101 = true;
    L27:
        if (r101 == false) goto L52;
        Object r103 = b();
        if (r103 == null) goto L55;
        Field r104 = this.f244923a.a(r103.getClass(), "mTimestampNanos", Long.class);
        if (r104 == null) goto L56;
        long r105 = 0;
        long r106 = r104.getLong(r103);     // Catch: Exception -> L40
        if (r106 <= 0) goto L57;
        r105 = r106;
    L41:
        Message r107 = Message.obtain(this.f244933k, new g(this, r103, r105));
        if (Build.VERSION.SDK_INT < 22) goto L44;
        r107.setAsynchronous(true);
    L44:
        this.f244933k.sendMessageAtFrontOfQueue(r107);
        return;
    L57:
        return;
    L40:
        this.f244931i.b("FWatchDogV2", "insertDoFrameMessage get timestampNanos error!");
        goto L41
    L56:
        return;
    L55:
        return;
    L52:
        return;
    L9:
        if (this.f244929g == true) goto L12;
        return;
    L12:
        if (this.f244930h < 0) goto L48;
        this.f244931i.b("FWatchDogV2", "already insert a barrier!");
        return;
    L48:
        MessageQueue r108 = d();     // Catch: Exception -> L24
        if (r108 == null) goto L22;
        this.f244930h = a(r108);     // Catch: Exception -> L24
        if (this.f244930h < 0) goto L22;
        Message r109 = Message.obtain(this.f244933k, this.f244934l);     // Catch: Exception -> L24
        if (Build.VERSION.SDK_INT < 22) goto L21;
        r109.setAsynchronous(true);     // Catch: Exception -> L24
    L21:
        this.f244933k.sendMessage(r109);     // Catch: Exception -> L24
    L22:
        this.f244931i.c("post a barrier, token : " + this.f244930h);     // Catch: Exception -> L24
        return;
    L24:
        this.f244931i.b("FWatchDogV2", "post barrier error!");
        return;
    L5:
        r102 = false;
        goto L7
    }

    public final Object b() {
        if (this.f244925c != null) goto L9;
        this.f244925c = new k(Choreographer.getInstance()).c("mDisplayEventReceiver", new Class[0]).f496561a;     // Catch: Exception -> L6
    L6:
        e = move-exception;
        this.f244931i.b("FWatchDogV2", e.getMessage());
    L9:
        return this.f244925c;
    }

    public final MessageQueue d() {
        if (this.f244924b != null) goto L9;
        this.f244924b = (MessageQueue) new k(Looper.getMainLooper()).c("mQueue", new Class[0]).f496561a;     // Catch: Exception -> L6
    L6:
        e = move-exception;
        this.f244931i.b("FWatchDogV2", e.getMessage());
    L9:
        return this.f244924b;
    }

    public final int f() {
        h r100 = this.f244932j;
        if (r100 != null) goto L7;
        this.f244931i.b("FWatchDogV2", "FWatchDogV2 config is null!");
        return -5;
    L7:
        if (this.f244928f == false) goto L10;
        this.f244931i.b("FWatchDogV2", "FWatchDogV2 has hook vsync error!");
        return -4;
    L10:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= r100.f496546c) goto L13;
    L78:
        this.f244931i.b("FWatchDogV2", "API " + r101 + " not support!, minSdkApi = " + this.f244932j.f496546c + " , maxSdkApi = " + this.f244932j.f496547d);
        return -1;
    L13:
        if (r101 > r100.f496547d) goto L78;
        boolean r102 = false;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L77;
        if (this.f244926d == null) goto L80;
    L25:
        Boolean r104 = this.f244926d;
        if (r104 != null) goto L28;
    L30:
        boolean r105 = false;
    L31:
        if (r105 == true) goto L35;
        this.f244931i.b("FWatchDogV2", "not use vsync!");
        return -2;
    L35:
        if (this.f244929g == false) goto L39;
        this.f244931i.b("FWatchDogV2", "FWatchDogV2 has started!");
        return -3;
    L39:
        if (b() != null) goto L42;
    L67:
        if (r102 == true) goto L71;
        this.f244931i.b("FWatchDogV2", "reflect failed!");
        return -6;
    L71:
        if (startVsyncHookNative() == true) goto L74;
        this.f244928f = true;
        this.f244931i.b("FWatchDogV2", "startVsyncHookNative failed!");
        return -4;
    L74:
        this.f244929g = true;
        this.f244927e = f244922o.addAndGet(1);
        this.f244931i.a("FWatchDogV2", "startWatchDog success");
        this.f244932j.getClass();
        return this.f244927e;
    L42:
        if (d() == null) goto L67;
        int r106 = this.f244932j.f496548e;
        if (r106 != 0) goto L47;
        boolean r107 = true;
    L48:
        if (r107 == true) goto L50;
        if (r106 != 1) goto L54;
        boolean r108 = true;
    L55:
        if (r108 == true) goto L57;
    L66:
        r102 = true;
        goto L67
    L57:
        if (this.f244923a.b(this.f244924b.getClass(), "removeSyncBarrier", new Class[]{Integer.class}) != null) goto L60;
        this.f244931i.e("FWatchDogV2", "removeSyncBarrier method not found!");
        goto L67
    L60:
        if (Build.VERSION.SDK_INT >= 23) goto L62;
        String r109 = "enqueueSyncBarrier";
    L64:
        if (this.f244923a.b(this.f244924b.getClass(), r109, new Class[]{Long.class}) != null) goto L66;
        this.f244931i.e("FWatchDogV2", "postSyncBarrier method not found!");
        goto L67
    L62:
        r109 = "postSyncBarrier";
        goto L64
    L54:
        r108 = false;
        goto L55
    L50:
        if (this.f244923a.a(this.f244925c.getClass(), "mTimestampNanos", Long.TYPE) != null) goto L66;
        this.f244931i.e("FWatchDogV2", "mTimestampNanos field not found!");
        goto L67
    L47:
        r107 = false;
        goto L48
    L28:
        if (r104.booleanValue() == false) goto L30;
        r105 = true;
        goto L31
    L80:
        this.f244926d = (Boolean) new k(Choreographer.getInstance()).c("USE_VSYNC", new Class[0]).f496561a;     // Catch: Exception -> L24
    L24:
        this.f244931i.b("FWatchDogV2", "read vsync field error v1!");
        goto L25
    L77:
        throw new IllegalThreadStateException("FWatchDogV2 must start from mainThread!");
    L18:
        r103 = false;
        goto L19
    }

    public FWatchDogV2() {
        this.f244928f = false;
        this.f244929g = false;
        this.f244930h = -1;
        f r100 = new f();
        this.f244931i = r100;
        this.f244933k = new Handler(Looper.getMainLooper());
        this.f244934l = new a(this);
        this.f244935m = new b(this);
        r100.f496539b = new c();
    }

    public final int a(Object r100) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String r101 = "enqueueSyncBarrier";
    L6:
        Method r102 = this.f244923a.b(r100.getClass(), r101, new Class[]{Long.class});
        if (r102 != null) goto L9;
        return -1;
    L9:
        return ((Integer) r102.invoke(r100, new Object[]{0L})).intValue();
    L5:
        r101 = "postSyncBarrier";
        goto L6
    }

    public final boolean e(int r100) {
        if (r100 >= 0) goto L13;
    L12:
        return false;
    L13:
        MessageQueue r101 = d();     // Catch: Exception -> L11
        if (r101 == null) goto L9;
        Method r102 = this.f244923a.b(r101.getClass(), "removeSyncBarrier", new Class[]{Integer.class});     // Catch: Exception -> L11
        if (r102 == null) goto L9;
        r102.invoke(r101, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L11
    L9:
        this.f244931i.c("remove a barrier, token : " + r100);     // Catch: Exception -> L11
        return true;
    L11:
        this.f244931i.b("FWatchDogV2", "remove barrier error!");
        goto L12
    }

    public final void g(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L45;
        if (this.f244927e == r100) goto L13;
        return;
    L13:
        if (this.f244929g == true) goto L15;
        return;
    L15:
        this.f244929g = false;
        this.f244931i.a("FWatchDogV2", "stopWatchDog");
        this.f244932j.getClass();
        this.f244933k.removeCallbacks(this.f244934l);
        e(this.f244930h);
        this.f244931i.a("FWatchDogV2", "check and remove invalidate barrier!");     // Catch: Exception -> L40
        MessageQueue r102 = d();     // Catch: Exception -> L40
        if (r102 == null) goto L42;
        l r103 = this.f244923a;     // Catch: Exception -> L40
        r103.getClass();     // Catch: Exception -> L40
        Field r104 = r103.a(r102.getClass(), "mMessages", Message.class);     // Catch: Exception -> L40
        if (r104 != null) goto L46;
    L24:
        Object r105 = null;
    L25:
        Message r106 = (Message) r105;     // Catch: Exception -> L40
        if (r106 == null) goto L42;
        Field r107 = this.f244923a.a(r106.getClass(), TeaEventTrack.ACTION_DRAMA_NEXT, Message.class);     // Catch: Exception -> L40
        if (r107 == null) goto L42;
    L31:
        if (r106 == null) goto L42;
        if (r106.getWhen() > 1) goto L42;
        if (r106.getTarget() != null) goto L38;
        e(r106.arg1);     // Catch: Exception -> L40
    L38:
        r106 = (Message) r107.get(r106);     // Catch: Exception -> L40
        goto L31
    L46:
        r105 = r104.get(r102);     // Catch: IllegalAccessException -> L23 Exception -> L40
    L23:
        r102.toString();     // Catch: Exception -> L40
    L42:
        stopVsyncHookNative();
        this.f244930h = -1;
        return;
    L40:
        e = move-exception;
        this.f244931i.b("FWatchDogV2", "check invalidate barrier error! " + e.getMessage());
        goto L42
    L45:
        throw new IllegalThreadStateException("FWatchDogV2 must stop from mainThread!");
    L7:
        r101 = false;
        goto L8
    }
}
