package hxc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import exc.e;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements ServiceConnection {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f487571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicInteger f487572j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ExecutorService f487573k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.hihonor.cloudservice.framework.aidl.b f487574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f487575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<c> f487576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f487577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownLatch f487578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f487579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f487580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HandlerC6211a f487581h;

    /* JADX INFO: renamed from: hxc.a$a, reason: collision with other inner class name */
    public class HandlerC6211a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f487582a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            e.c("AIDLClientInvokeManager", "msg.what: " + r100.what);
            int r101 = r100.what;
            if (r101 != 3001) goto L11;
            if (this.f487582a.f487577d.get() != 2) goto L8;
            a.b(this.f487582a);
            return;
        L8:
            if (this.f487582a.f487577d.get() != 0) goto L41;
            this.f487582a.e();
            return;
        L41:
            return;
        L11:
            if (r101 != 3002) goto L14;
            this.f487582a.f487577d.set(2);
            a.b(this.f487582a);
            return;
        L14:
            if (r101 != 3003) goto L17;
            this.f487582a.f487577d.set(0);
            this.f487582a.c();
            return;
        L17:
            if (r101 != 3004) goto L24;
            e.c("AIDLClientInvokeManager", "MSG_FINISH_TASK, unbind");
            a r102 = this.f487582a;
            r102.getClass();
            e.c("AIDLClientInvokeManager", "unbind Service");
            r102.f487579f.unbindService(r102);     // Catch: Exception -> L21
        L22:
            r102.c();
            this.f487582a.f487577d.set(0);
            return;
        L21:
            e.c("AIDLClientInvokeManager", "unbind service error");
            goto L22
        L24:
            if (r101 != 3005) goto L46;
            e.c("AIDLClientInvokeManager", "MSG_START_SERVICE_FAILED all login return failed");
            this.f487582a.f487577d.set(0);
            a r103 = this.f487582a;
            r103.getClass();
            e.c("AIDLClientInvokeManager", "onBindServiceFailed");
            Queue<c> r104 = r103.f487576c;
            monitor-enter(r104);
        L36:
            c r105 = (c) ((LinkedBlockingQueue) r103.f487576c).poll();     // Catch: Throwable -> L32
            if (r105 == null) goto L30;
            a.f487572j.decrementAndGet();     // Catch: Throwable -> L32
            r105.b(new ErrorStatus(40, "start APK service ERROR"));     // Catch: Throwable -> L32
            goto L36
        L30:
            monitor-exit(r104);     // Catch: Throwable -> L32
            return;
        L32:
            th = move-exception;
            throw th;
        }

        public HandlerC6211a(a r100, Looper r101) {
            this.f487582a = r100;
            super(r101);
        }
    }

    static {
        f487572j = new AtomicInteger();
        f487573k = PThreadExecutorsUtils.newFixedThreadPool(3, new DefaultThreadFactory("q/q/q/w/q/a"));
    }

    public final void c() {
        Queue<c> r100 = this.f487576c;
        monitor-enter(r100);
        this.f487574a = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void e() {
        e.c("AIDLClientInvokeManager", "startService");
        this.f487577d.set(1);
        this.f487575b.set(false);
        this.f487578e = new CountDownLatch(1);
        ThreadMethodProxy.start(new PthreadThreadV2(new b(this), "q/q/q/w/q/a"));
        e.c("AIDLClientInvokeManager", "begin to bindService");
        Intent r100 = new Intent();
        cxc.c.a(this.f487579f).getClass();
        r100.setAction("com.hihonor.id.HonorInvokeService");
        r100.setPackage("com.hihonor.id");
    L7:
        e.b("AIDLClientInvokeManager", "bind service exception");
        return;
    L4:
        if (this.f487579f.bindService(r100, this, 1) == true) goto L11;
        e.b("AIDLClientInvokeManager", "bind service failed");     // Catch: Exception -> L7
        return;
    }

    public a(Context r100) {
        this.f487575b = new AtomicBoolean(false);
        this.f487576c = new LinkedBlockingQueue();
        this.f487577d = new AtomicInteger(0);
        this.f487578e = null;
        this.f487580g = 0;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("AIDLClientInvokeManager");
        this.f487579f = r100.getApplicationContext();
        ThreadMethodProxy.start(r101);
        this.f487581h = new HandlerC6211a(this, r101.getLooper());
    }

    public static a a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (f487571i != null) goto L10;
        e.c("AIDLClientInvokeManager", "AIDLClientInvokeManager init");     // Catch: Throwable -> L13
        f487571i = new a(r100);     // Catch: Throwable -> L13
    L10:
        a r101 = f487571i;     // Catch: Throwable -> L13
        monitor-exit(a.class);     // Catch: Throwable -> L13
        return r101;
    }

    public static void b(a r100) {
        r100.getClass();
        e.c("AIDLClientInvokeManager", "doTask");
        Queue<c> r101 = r100.f487576c;
        monitor-enter(r101);
    L16:
        c r102 = (c) ((LinkedBlockingQueue) r100.f487576c).poll();     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        f487573k.submit(r102);     // Catch: Exception -> L8 NullPointerException -> L9 RejectedExecutionException -> L10 Throwable -> L13
    L9:
        e.b("AIDLClientInvokeManager", "Execute submit NullPointerException!");     // Catch: Throwable -> L13
    L10:
        e.b("AIDLClientInvokeManager", "Execute submit RejectedExecutionException!");     // Catch: Throwable -> L13
    L8:
        e.b("AIDLClientInvokeManager", "Execute submit Exception!");     // Catch: Throwable -> L13
        goto L16
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void d(a r100) {
        r100.getClass();
        e.c("AIDLClientInvokeManager", "onServiceConnectedTimeout");
        if (r100.f487575b.get() == true) goto L15;
        e.c("AIDLClientInvokeManager", "unbind Service");
        r100.f487579f.unbindService(r100);     // Catch: Exception -> L7
    L8:
        r100.c();
        int r101 = r100.f487580g;
        if (r101 >= 3) goto L11;
        r100.f487580g = r101 + 1;
        r100.e();
        return;
    L11:
        r100.f487575b.set(true);
        r100.f487581h.sendEmptyMessage(3005);
        return;
    L7:
        e.c("AIDLClientInvokeManager", "unbind service error");
        goto L8
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        e.c("AIDLClientInvokeManager", "onServiceDisconnected");
        this.f487580g = 0;
        this.f487581h.sendEmptyMessage(3003);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        e.c("AIDLClientInvokeManager", "onServiceConnected");
        this.f487580g = 0;     // Catch: Exception -> L5 RuntimeException -> L6
        this.f487574a = com.hihonor.cloudservice.framework.aidl.b.a.a(r101);     // Catch: Exception -> L5 RuntimeException -> L6
        this.f487575b.set(true);     // Catch: Exception -> L5 RuntimeException -> L6
        this.f487581h.sendEmptyMessage(3002);     // Catch: Exception -> L5 RuntimeException -> L6
        this.f487578e.countDown();     // Catch: Exception -> L5 RuntimeException -> L6
    L11:
        return;
    L6:
        e.b("AIDLClientInvokeManager", "onServiceConnected RuntimeException!");
        return;
    L5:
        e.b("AIDLClientInvokeManager", "onServiceConnected Exception!");
    }
}
