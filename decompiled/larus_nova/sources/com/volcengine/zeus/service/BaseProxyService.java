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

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProxyService extends Service {
    private static final long WAIT_TIMEOUT_MS = 10000;
    private final Object connectionLock;
    private final Map<Intent.FilterComparison, f> connectionMap;
    private final ArrayDeque<Intent> pendingStarts;
    private final Object startLock;
    private final AtomicReference<com.volcengine.zeus.d> startWaitHandle;

    /* JADX INFO: loaded from: classes41.dex */
    public class a implements com.volcengine.zeus.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseProxyService f462844a;

        @Override // com.volcengine.zeus.c
        public final void onLoadSuccess() {
            BaseProxyService.access$100(this.f462844a);
            BaseProxyService.access$200(this.f462844a);
        }

        public a(BaseProxyService r100) {
            this.f462844a = r100;
        }

        @Override // com.volcengine.zeus.c
        public final void a(String r100, long r101) {
            BaseProxyService.access$100(this.f462844a);
            BaseProxyService.access$300(this.f462844a);
            ZeusLogger.w(ZeusLogger.TAG_SERVICE, "BaseProxyService load timeout, pkg=" + r100 + ", timeout=" + r101);
        }

        @Override // com.volcengine.zeus.c
        public final void b(String r100, String r101) {
            BaseProxyService.access$100(this.f462844a);
            BaseProxyService.access$300(this.f462844a);
            ZeusLogger.w(ZeusLogger.TAG_SERVICE, "BaseProxyService load failed, pkg=" + r100 + ", error=" + r101);
        }
    }

    public class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f462845a;

        public b(f r100) {
            this.f462845a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            ZeusLogger.w(ZeusLogger.TAG_SERVICE, "BaseProxyService onServiceDisconnected, name=" + r100);
            this.f462845a.f462863b.set(null);
            this.f462845a.f462865d.b(null);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService onServiceConnected, name=" + r100);
            this.f462845a.f462863b.set(r101);
            this.f462845a.f462865d.b(r101);
            this.f462845a.f462864c.countDown();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f462846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f462847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent.FilterComparison f462848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseProxyService f462849d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f462850a;

            public final void a() {
                c r100 = this.f462850a;
                BaseProxyService r101 = r100.f462849d;
                boolean r102 = ZeusTransformUtils.bindService(r101, r100.f462846a, r100.f462847b.f462862a, 1, r101.getPluginName());
                ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService bindService result=" + r102 + ", plugin=" + this.f462850a.f462849d.getPluginName());
                if (r102 == true) goto L12;
                Object r103 = BaseProxyService.access$500(this.f462850a.f462849d);
                monitor-enter(r103);
                BaseProxyService.access$600(this.f462850a.f462849d).remove(this.f462850a.f462848c);     // Catch: Throwable -> L9
                monitor-exit(r103);     // Catch: Throwable -> L9
                this.f462850a.f462847b.f462865d.b(null);
                this.f462850a.f462847b.f462864c.countDown();
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

            public a(c r100) {
                this.f462850a = r100;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = new a(this);     // Catch: Throwable -> L7
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            r100.run();     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            new Handler(Looper.getMainLooper()).post(r100);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public c(BaseProxyService r100, Intent r101, f r102, Intent.FilterComparison r103) {
            this.f462849d = r100;
            this.f462846a = r101;
            this.f462847b = r102;
            this.f462848c = r103;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f462851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent.FilterComparison f462852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f462853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseProxyService f462854d;

        /* JADX INFO: loaded from: classes41.dex */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f462855a;

            public final void a() {
            L8:
                e = move-exception;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "BaseProxyService async load plugin failed", e);
                monitor-enter(BaseProxyService.access$500(this.f462855a.f462854d));
                BaseProxyService.access$600(this.f462855a.f462854d).remove(this.f462855a.f462852b);     // Catch: Throwable -> L15
                this.f462855a.f462853c.f462865d.b(null);
                this.f462855a.f462853c.f462864c.countDown();
                return;
            L15:
                th = move-exception;
                throw th;
            L4:
                if (Zeus.isPluginLoaded(this.f462855a.f462854d.getPluginName()) == true) goto L6;
                ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService not loaded, awaitLoad start, plugin=" + this.f462855a.f462854d.getPluginName());     // Catch: Exception -> L8
                Zeus.awaitLoad(this.f462855a.f462854d.getPluginName(), 10000);     // Catch: Exception -> L8
            L6:
                this.f462855a.f462851a.run();     // Catch: Exception -> L8
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

            public a(d r100) {
                this.f462855a = r100;
            }
        }

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

        public d(BaseProxyService r100, Runnable r101, Intent.FilterComparison r102, f r103) {
            this.f462854d = r100;
            this.f462851a = r101;
            this.f462852b = r102;
            this.f462853c = r103;
        }
    }

    public static class e extends Binder {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final AtomicInteger f462856f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile IBinder f462857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile CountDownLatch f462858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Runnable f462859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f462860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f462861e;

        static {
            f462856f = new AtomicInteger(0);
        }

        @Override // android.os.Binder, android.os.IBinder
        public final String getInterfaceDescriptor() {
            if (this.f462857a == null) goto L7;
            return this.f462857a.getInterfaceDescriptor();
        L7:
            return super.getInterfaceDescriptor();
        }

        @Override // android.os.Binder, android.os.IBinder
        public final boolean isBinderAlive() {
            if (this.f462857a == null) goto L7;
            return this.f462857a.isBinderAlive();
        L7:
            return super.isBinderAlive();
        }

        public e() {
            this.f462858b = new CountDownLatch(1);
            this.f462861e = new AtomicBoolean(false);
        }

        public final void b(IBinder r100) {
            this.f462857a = r100;
            this.f462861e.set(false);
            this.f462858b.countDown();
        }

        @Override // android.os.Binder, android.os.IBinder
        public final IInterface queryLocalInterface(String r100) {
            if (this.f462857a == null) goto L7;
            return this.f462857a.queryLocalInterface(r100);
        L7:
            return super.queryLocalInterface(r100);
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r110) throws RemoteException {
            if (this.f462857a != null) goto L37;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L15;
            Runnable r103 = this.f462860d;
            if (r103 == null) goto L10;
            r103.run();
        L10:
            if (this.f462857a != null) goto L12;
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "Local bind failed in main thread, abort to prevent deadlock.");
            throw new RemoteException("Plugin service bind failed synchronously on main thread.");
        L12:
            return a(this.f462857a, r100, r101, r102, r110);
        L15:
            AtomicInteger r104 = f462856f;
            if (r104.incrementAndGet() <= 8) goto L43;
            r104.decrementAndGet();
            throw new RemoteException("Binder thread pool busy, plugin not ready yet");
        L43:
        L30:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L28
            throw new RemoteException("Interrupted while waiting for plugin binder");     // Catch: Throwable -> L28
        L18:
            if (this.f462861e.compareAndSet(false, true) == false) goto L24;
            if (this.f462859c == null) goto L22;
            this.f462858b = new CountDownLatch(1);     // Catch: Throwable -> L28 InterruptedException -> L30
            this.f462859c.run();     // Catch: Throwable -> L28 InterruptedException -> L30
            goto L24
        L22:
            this.f462861e.set(false);     // Catch: Throwable -> L28 InterruptedException -> L30
        L24:
            if (this.f462858b.await(10000, TimeUnit.MILLISECONDS) == false) goto L26;
            r104.decrementAndGet();
            goto L37
        L26:
            ZeusLogger.w(ZeusLogger.TAG_SERVICE, "onTransact:Plugin service load timeout");     // Catch: Throwable -> L28 InterruptedException -> L30
            throw new RemoteException("Plugin service load timeout (10000ms)");     // Catch: Throwable -> L28 InterruptedException -> L30
        L28:
            th = move-exception;
            f462856f.decrementAndGet();
            throw th;
        L37:
            if (this.f462857a == null) goto L41;
            return a(this.f462857a, r100, r101, r102, r110);
        L41:
            throw new RemoteException("Plugin service load or bind failed");
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean a(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            long r100 = SystemClock.uptimeMillis();
            boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
            long r102 = SystemClock.uptimeMillis() - r100;
            if (r102 < 100) goto L11;
            BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
        L11:
            return r101;
        L12:
            th = move-exception;
            long r103 = SystemClock.uptimeMillis() - r100;
            if (r103 < 100) goto L22;
            if (r110 != null) goto L17;
            String r104 = "";
        L18:
            BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
            throw th;
        L17:
            r104 = r110.getClass().getName();
            goto L18
        L22:
            throw th;
        L5:
            return r110.transact(r111, r112, r113, r114);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f462862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<IBinder> f462863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CountDownLatch f462864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f462865d;

        public f() {
            this.f462863b = new AtomicReference();
            this.f462864c = new CountDownLatch(1);
            this.f462865d = new e();
        }
    }

    public abstract String getPluginName();

    private void clearHandle() {
        this.startWaitHandle.set(null);
    }

    private void clearPendingStarts() {
        Object r100 = this.startLock;
        monitor-enter(r100);
        this.pendingStarts.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private f createProxyConnection() {
        f r100 = new f();
        r100.f462862a = new b(r100);
        return r100;
    }

    private void flushPendingStarts() {
        Object r100 = this.startLock;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.pendingStarts.isEmpty() == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L8:
        ArrayDeque r101 = new ArrayDeque(this.pendingStarts);     // Catch: Throwable -> L15
        this.pendingStarts.clear();     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        Iterator r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ZeusTransformUtils.startService(this, buildPluginIntent((Intent) r102.next()), getPluginName());
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
        com.volcengine.zeus.d r100 = this.startWaitHandle.getAndSet(null);
        if (r100 == null) goto L5;
        r100.cancel();
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

    public static /* synthetic */ void access$100(BaseProxyService r100) {
        r100.clearHandle();
    }

    public static /* synthetic */ void access$200(BaseProxyService r100) {
        r100.flushPendingStarts();
    }

    public static /* synthetic */ void access$300(BaseProxyService r100) {
        r100.clearPendingStarts();
    }

    public static /* synthetic */ Object access$500(BaseProxyService r100) {
        return r100.connectionLock;
    }

    public static /* synthetic */ Map access$600(BaseProxyService r100) {
        return r100.connectionMap;
    }

    private Intent buildPluginIntent(Intent r100) {
        if (r100 == null) goto L4;
        Intent r101 = new Intent(r100);
    L5:
        r101.setComponent(new ComponentName(this, getServiceClassName()));
        return r101;
    L4:
        r101 = new Intent();
        goto L5
    }

    private void enqueueStart(Intent r100) {
        Object r101 = this.startLock;
        monitor-enter(r101);
        ArrayDeque<Intent> r102 = this.pendingStarts;     // Catch: Throwable -> L11
        if (r100 == null) goto L7;
        Intent r103 = new Intent(r100);     // Catch: Throwable -> L11
    L8:
        r102.add(r103);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L7:
        r103 = new Intent();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService onBind, intent=" + r100);
        if (r100 == null) goto L5;
        Intent r101 = r100;
    L6:
        Intent.FilterComparison r102 = new Intent.FilterComparison(r101);
        Object r103 = this.connectionLock;
        monitor-enter(r103);
        f r104 = this.connectionMap.get(r102);     // Catch: Throwable -> L24
        if (r104 != null) goto L11;
        r104 = createProxyConnection();     // Catch: Throwable -> L24
        this.connectionMap.put(r102, r104);     // Catch: Throwable -> L24
        boolean r105 = true;
    L12:
        monitor-exit(r103);     // Catch: Throwable -> L24
        if (r105 == false) goto L18;
        Runnable r106 = createBindTask(buildPluginIntent(r100), r104, r102);
        Runnable r107 = createStartTask(r106, r104, r102);
        e r108 = r104.f462865d;
        r108.f462859c = r107;
        r108.f462860d = r106;
        r108.f462861e.set(true);
        if (Zeus.isPluginLoaded(getPluginName()) == false) goto L17;
        r106.run();
        goto L18
    L17:
        r107.run();
    L18:
        IBinder r109 = r104.f462863b.get();
        if (r109 == null) goto L22;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService return realBinder, intent=" + r100);
        return r109;
    L22:
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "BaseProxyService return ProxyBinder immediately, intent=" + r100);
        return r104.f462865d;
    L11:
        r105 = false;
    L24:
        th = move-exception;
        throw th;
    L5:
        r101 = new Intent();
        goto L6
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r100) {
        ZeusLogger.d(ZeusLogger.TAG_SERVICE, "BaseProxyService enter onUnbind");
        if (Zeus.isPluginLoaded(getPluginName()) == true) goto L7;
        return super.onUnbind(r100);
    L7:
        if (r100 == null) goto L9;
        Intent r101 = r100;
    L10:
        Intent.FilterComparison r102 = new Intent.FilterComparison(r101);
        Object r103 = this.connectionLock;
        monitor-enter(r103);
        f r104 = this.connectionMap.remove(r102);     // Catch: Throwable -> L18
        monitor-exit(r103);     // Catch: Throwable -> L18
        if (r104 == null) goto L17;
        ZeusLogger.d(ZeusLogger.TAG_SERVICE, "BaseProxyService unbindService");     // Catch: IllegalArgumentException -> L21
        ZeusTransformUtils.unbindService(this, r104.f462862a, getPluginName());     // Catch: IllegalArgumentException -> L21
    L17:
        return super.onUnbind(r100);
    L18:
        th = move-exception;
        throw th;
    L9:
        r101 = new Intent();
        goto L10
    }

    private Runnable createBindTask(Intent r100, f r101, Intent.FilterComparison r102) {
        return new c(this, r100, r101, r102);
    }

    private Runnable createStartTask(Runnable r100, f r101, Intent.FilterComparison r102) {
        return new d(this, r100, r102, r101);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        if (Zeus.isPluginLoaded(getPluginName()) == true) goto L17;
        enqueueStart(r100);
        if (this.startWaitHandle.get() != null) goto L16;
        com.volcengine.zeus.d r103 = Zeus.runAfterLoad(getPluginName(), new a(this), 10000);
        AtomicReference<com.volcengine.zeus.d> r104 = this.startWaitHandle;
    L8:
        if (r104.compareAndSet(null, r103) == true) goto L9;
        if (r104.get() == null) goto L8;
        boolean r105 = false;
    L13:
        if (r105 == true) goto L16;
        r103.cancel();
        goto L16
    L9:
        r105 = true;
    L16:
        return super.onStartCommand(r100, r101, r102);
    L17:
        ZeusTransformUtils.startService(this, buildPluginIntent(r100), getPluginName());
        return super.onStartCommand(r100, r101, r102);
    }
}
