package com.volcengine.zeus.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class BaseProxyService extends Service {
    private static final long WAIT_TIMEOUT_MS = 10000;
    private final Object connectionLock;
    private final Map<Intent.FilterComparison, f> connectionMap;
    private final ArrayDeque<Intent> pendingStarts;
    private final Object startLock;
    private final AtomicReference<com.volcengine.zeus.d> startWaitHandle;

    public class b implements ServiceConnection {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            ZeusLogger.w(ZeusLogger.TAG_SERVICE, "BaseProxyService onServiceDisconnected, name=" + r3);
            this.a.b.set(null);
            this.a.d.b(null);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService onServiceConnected, name=" + r3);
            this.a.b.set(r4);
            this.a.d.b(r4);
            this.a.c.countDown();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ f b;
        public final /* synthetic */ Intent.FilterComparison c;
        public final /* synthetic */ BaseProxyService d;

        public class a implements Runnable {
            public final /* synthetic */ c a;

            public final void a() {
                c r0 = this.a;
                BaseProxyService r1 = r0.d;
                boolean r2 = ZeusTransformUtils.bindService(r1, r0.a, r0.b.a, 1, r1.getPluginName());
                ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService bindService result=" + r2 + ", plugin=" + this.a.d.getPluginName());
                if (r2 == true) goto L12;
                Object r3 = BaseProxyService.access$500(this.a.d);
                monitor-enter(r3);
                BaseProxyService.access$600(this.a.d).remove(this.a.c);     // Catch: Throwable -> L9
                monitor-exit(r3);     // Catch: Throwable -> L9
                this.a.b.d.b(null);
                this.a.b.c.countDown();
                return;
            L9:
                th = move-exception;
                throw th;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(c r1) {
                this.a = r1;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = new a(this);     // Catch: Throwable -> L7
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            r0.run();     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            new Handler(Looper.getMainLooper()).post(r0);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public c(BaseProxyService r1, Intent r2, f r3, Intent.FilterComparison r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ Intent.FilterComparison b;
        public final /* synthetic */ f c;
        public final /* synthetic */ BaseProxyService d;

        @Override // java.lang.Runnable
        public final void run() {
            dqc.e.b(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(BaseProxyService r1, Runnable r2, Intent.FilterComparison r3, f r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static class e extends Binder {
        public static final AtomicInteger f = null;
        public volatile IBinder a;
        public volatile CountDownLatch b;
        public Runnable c;
        public Runnable d;
        public final AtomicBoolean e;

        static {
            f = new AtomicInteger(0);
        }

        @Override // android.os.Binder, android.os.IBinder
        public final String getInterfaceDescriptor() {
            if (this.a == null) goto L7;
            return this.a.getInterfaceDescriptor();
        L7:
            return super.getInterfaceDescriptor();
        }

        @Override // android.os.Binder, android.os.IBinder
        public final boolean isBinderAlive() {
            if (this.a == null) goto L7;
            return this.a.isBinderAlive();
        L7:
            return super.isBinderAlive();
        }

        public e() {
            this.b = new CountDownLatch(1);
            this.e = new AtomicBoolean(false);
        }

        public final void b(IBinder r2) {
            this.a = r2;
            this.e.set(false);
            this.b.countDown();
        }

        @Override // android.os.Binder, android.os.IBinder
        public final IInterface queryLocalInterface(String r2) {
            if (this.a == null) goto L7;
            return this.a.queryLocalInterface(r2);
        L7:
            return super.queryLocalInterface(r2);
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r7, Parcel r8, Parcel r9, int r10) throws RemoteException {
            if (this.a != null) goto L37;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L15;
            Runnable r0 = this.d;
            if (r0 == null) goto L10;
            r0.run();
        L10:
            if (this.a != null) goto L12;
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "Local bind failed in main thread, abort to prevent deadlock.");
            throw new RemoteException("Plugin service bind failed synchronously on main thread.");
        L12:
            return a(this.a, r7, r8, r9, r10);
        L15:
            AtomicInteger r1 = f;
            if (r1.incrementAndGet() <= 8) goto L43;
            r1.decrementAndGet();
            throw new RemoteException("Binder thread pool busy, plugin not ready yet");
        L43:
        L30:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L28
            throw new RemoteException("Interrupted while waiting for plugin binder");     // Catch: Throwable -> L28
        L18:
            if (this.e.compareAndSet(false, true) == false) goto L24;
            if (this.c == null) goto L22;
            this.b = new CountDownLatch(1);     // Catch: Throwable -> L28 InterruptedException -> L30
            this.c.run();     // Catch: Throwable -> L28 InterruptedException -> L30
            goto L24
        L22:
            this.e.set(false);     // Catch: Throwable -> L28 InterruptedException -> L30
        L24:
            if (this.b.await(BaseProxyService.WAIT_TIMEOUT_MS, TimeUnit.MILLISECONDS) == false) goto L26;
            r1.decrementAndGet();
            goto L37
        L26:
            ZeusLogger.w(ZeusLogger.TAG_SERVICE, "onTransact:Plugin service load timeout");     // Catch: Throwable -> L28 InterruptedException -> L30
            throw new RemoteException("Plugin service load timeout (10000ms)");     // Catch: Throwable -> L28 InterruptedException -> L30
        L28:
            th = move-exception;
            f.decrementAndGet();
            throw th;
        L37:
            if (this.a == null) goto L41;
            return a(this.a, r7, r8, r9, r10);
        L41:
            throw new RemoteException("Plugin service load or bind failed");
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean a(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            long r2 = SystemClock.uptimeMillis();
            boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
            long r8 = SystemClock.uptimeMillis() - r2;
            if (r8 < 100) goto L11;
            BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
        L11:
            return r0;
        L12:
            th = move-exception;
            long r9 = SystemClock.uptimeMillis() - r2;
            if (r9 < 100) goto L22;
            if (r15 != null) goto L17;
            String r1 = XmlPullParser.NO_NAMESPACE;
        L18:
            BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
            throw th;
        L17:
            r1 = r15.getClass().getName();
            goto L18
        L22:
            throw th;
        L5:
            return r15.transact(r16, r17, r18, r19);
        }
    }

    public static class f {
        public b a;
        public final AtomicReference<IBinder> b;
        public final CountDownLatch c;
        public final e d;

        public f() {
            this.b = new AtomicReference();
            this.c = new CountDownLatch(1);
            this.d = new e();
        }
    }

    public abstract String getPluginName();

    private void clearHandle() {
        this.startWaitHandle.set(null);
    }

    private void clearPendingStarts() {
        Object r0 = this.startLock;
        monitor-enter(r0);
        this.pendingStarts.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private f createProxyConnection() {
        f r0 = new f();
        r0.a = new b(r0);
        return r0;
    }

    private void flushPendingStarts() {
        Object r0 = this.startLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.pendingStarts.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        ArrayDeque r1 = new ArrayDeque(this.pendingStarts);     // Catch: Throwable -> L15
        this.pendingStarts.clear();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        ZeusTransformUtils.startService(this, buildPluginIntent((Intent) r2.next()), getPluginName());
        goto L12
    }

    private void handleDestroyPluginService() {
        if (Zeus.isPluginLoaded(getPluginName()) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_SERVICE, "BaseProxyService enter stopService");     // Catch: Exception -> L6
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService stopService in onDestroy, ok=" + ZeusTransformUtils.stopService(this, buildPluginIntent(null), getPluginName()) + ", plugin=" + getPluginName());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_SERVICE, "BaseProxyService stopService in onDestroy failed, plugin=" + getPluginName(), e);
        return;
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.volcengine.zeus.d r0 = this.startWaitHandle.getAndSet(null);
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        clearPendingStarts();
        handleDestroyPluginService();
        super.onDestroy();
    }

    public BaseProxyService() {
        this.connectionLock = new Object();
        this.connectionMap = new HashMap();
        this.startLock = new Object();
        this.pendingStarts = new ArrayDeque();
        this.startWaitHandle = new AtomicReference(null);
    }

    public String getServiceClassName() {
        return getClass().getName();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    public static /* synthetic */ void access$100(BaseProxyService r0) {
        r0.clearHandle();
    }

    public static /* synthetic */ void access$200(BaseProxyService r0) {
        r0.flushPendingStarts();
    }

    public static /* synthetic */ void access$300(BaseProxyService r0) {
        r0.clearPendingStarts();
    }

    public static /* synthetic */ Object access$500(BaseProxyService r0) {
        return r0.connectionLock;
    }

    public static /* synthetic */ Map access$600(BaseProxyService r0) {
        return r0.connectionMap;
    }

    private Intent buildPluginIntent(Intent r3) {
        if (r3 == null) goto L4;
        Intent r0 = new Intent(r3);
    L5:
        r0.setComponent(new ComponentName(this, getServiceClassName()));
        return r0;
    L4:
        r0 = new Intent();
        goto L5
    }

    private void enqueueStart(Intent r4) {
        Object r0 = this.startLock;
        monitor-enter(r0);
        ArrayDeque<Intent> r1 = this.pendingStarts;     // Catch: Throwable -> L11
        if (r4 == null) goto L7;
        Intent r2 = new Intent(r4);     // Catch: Throwable -> L11
    L8:
        r1.add(r2);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r2 = new Intent();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r6) {
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService onBind, intent=" + r6);
        if (r6 == null) goto L5;
        Intent r1 = r6;
    L6:
        Intent.FilterComparison r0 = new Intent.FilterComparison(r1);
        Object r2 = this.connectionLock;
        monitor-enter(r2);
        f r3 = this.connectionMap.get(r0);     // Catch: Throwable -> L24
        if (r3 != null) goto L11;
        r3 = createProxyConnection();     // Catch: Throwable -> L24
        this.connectionMap.put(r0, r3);     // Catch: Throwable -> L24
        boolean r4 = true;
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L24
        if (r4 == false) goto L18;
        Runnable r5 = createBindTask(buildPluginIntent(r6), r3, r0);
        Runnable r7 = createStartTask(r5, r3, r0);
        e r8 = r3.d;
        r8.c = r7;
        r8.d = r5;
        r8.e.set(true);
        if (Zeus.isPluginLoaded(getPluginName()) == false) goto L17;
        r5.run();
        goto L18
    L17:
        r7.run();
    L18:
        IBinder r9 = r3.b.get();
        if (r9 == null) goto L22;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService return realBinder, intent=" + r6);
        return r9;
    L22:
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService return ProxyBinder immediately, intent=" + r6);
        return r3.d;
    L11:
        r4 = false;
    L24:
        th = move-exception;
        throw th;
    L5:
        r1 = new Intent();
        goto L6
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r4) {
        ZeusLogger.d(ZeusLogger.TAG_SERVICE, "BaseProxyService enter onUnbind");
        if (Zeus.isPluginLoaded(getPluginName()) == true) goto L7;
        return super.onUnbind(r4);
    L7:
        if (r4 == null) goto L9;
        Intent r1 = r4;
    L10:
        Intent.FilterComparison r0 = new Intent.FilterComparison(r1);
        Object r2 = this.connectionLock;
        monitor-enter(r2);
        f r3 = this.connectionMap.remove(r0);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        if (r3 == null) goto L17;
        ZeusLogger.d(ZeusLogger.TAG_SERVICE, "BaseProxyService unbindService");     // Catch: IllegalArgumentException -> L21
        ZeusTransformUtils.unbindService(this, r3.a, getPluginName());     // Catch: IllegalArgumentException -> L21
    L17:
        return super.onUnbind(r4);
    L18:
        th = move-exception;
        throw th;
    L9:
        r1 = new Intent();
        goto L10
    }

    private Runnable createBindTask(Intent r2, f r3, Intent.FilterComparison r4) {
        return new c(this, r2, r3, r4);
    }

    private Runnable createStartTask(Runnable r2, f r3, Intent.FilterComparison r4) {
        return new d(this, r2, r4, r3);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r5, int r6, int r7) {
        if (Zeus.isPluginLoaded(getPluginName()) == true) goto L17;
        enqueueStart(r5);
        if (this.startWaitHandle.get() != null) goto L16;
        com.volcengine.zeus.d r0 = Zeus.runAfterLoad(getPluginName(), new a(this), WAIT_TIMEOUT_MS);
        AtomicReference<com.volcengine.zeus.d> r1 = this.startWaitHandle;
    L8:
        if (r1.compareAndSet(null, r0) == true) goto L9;
        if (r1.get() == null) goto L8;
        boolean r2 = false;
    L13:
        if (r2 == true) goto L16;
        r0.cancel();
        goto L16
    L9:
        r2 = true;
    L16:
        return super.onStartCommand(r5, r6, r7);
    L17:
        ZeusTransformUtils.startService(this, buildPluginIntent(r5), getPluginName());
        return super.onStartCommand(r5, r6, r7);
    }
}
