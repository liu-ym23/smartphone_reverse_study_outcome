package com.bytedance.bdp.bdpbase.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.ipc.BdpIpcServiceImpl;
import com.bytedance.bdp.bdpbase.ipc.extention.MainDefaultIpcService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.DevicesUtil;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.bytedance.minigame.merge.appbase.ipc.MiniGameMainIpcService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements com.bytedance.bdp.bdpbase.ipc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Method, w> f201136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f201137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f201138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f201139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f201140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f201141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f201142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BdpIPCImpl$5 f201143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f201144i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile ITransfer f201145j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f201146k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f201147l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f201148m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.bdp.bdpbase.ipc.c.a f201149n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f201150o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f201151p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f201152q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f f201153r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f201154s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f201155t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Handler f201156u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f201157v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<v> f201158w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f201159x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f201160y;

    public class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f201161a;

        public a(e r100) {
            this.f201161a = r100;
        }

        public final void a(v r100) {
            ITransfer r101 = this.f201161a.f201145j;
            if (r101 != null) goto L5;
        L7:
            e r102 = this.f201161a;
            ITransfer r103 = r102.f201145j;
            boolean r104 = true;
            if (r103 != null) goto L10;
        L12:
            com.bytedance.bdp.bdpbase.ipc.c.a r105 = r102.f201149n;
            if (r105 != null) goto L15;
        L19:
            r102.d();
            boolean r106 = t.f201195a;
            if (Looper.getMainLooper() != Looper.myLooper()) goto L22;
            boolean r107 = true;
        L23:
            if (r107 == false) goto L25;
            g94.b.b("IPC_BdpIPC", new Object[]{"#asyncGetITransfer (warn: in main thread) target=" + r102.f201157v});
            r100.c("get_binder_in_main_thread", "Please do not use IPC in the main thread, it is dangerous and may lead to ANR", r102.f201157v);
            return;
        L25:
            Object r108 = r102.f201159x;
            monitor-enter(r108);
            ITransfer r109 = r102.f201145j;     // Catch: Throwable -> L37
            if (r109 != null) goto L30;
        L32:
            r102.f201158w.add(r100);     // Catch: Throwable -> L37
            g94.b.d("IPC_BdpIPC", new Object[]{"#taskEnqueue (mWaitingList add) target=" + r102.f201157v + " remoteCall=" + r100.g()});     // Catch: Throwable -> L37
            BdpPool.postLogic(10000, new g(r102, r100));     // Catch: Throwable -> L37
            r104 = false;
        L33:
            monitor-exit(r108);     // Catch: Throwable -> L37
            if (r104 == false) goto L46;
            r100.b(r102.f201145j);
            return;
        L46:
            return;
        L30:
            if (r109.asBinder().isBinderAlive() == false) goto L32;
        L37:
            th = move-exception;
            throw th;
        L22:
            r107 = false;
            goto L23
        L15:
            if (((BdpIpcServiceImpl.b) r105).a() == true) goto L19;
            if (r102.f201152q == true) goto L19;
            r100.c("unable_to_bind", "unable to bind, process of " + r102.f201157v + " maybe died", r102.f201157v);
            return;
        L10:
            if (r103.asBinder().isBinderAlive() == false) goto L12;
            g94.b.d("IPC_BdpIPC", new Object[]{"#asyncGetITransfer (return: by cache) target=" + r102.f201157v});
            r100.b(r102.f201145j);
            return;
        L5:
            if (r101.asBinder().isBinderAlive() == false) goto L7;
            r100.b(r101);
        }
    }

    public class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f201162a;

        public b(e r100) {
            this.f201162a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r110, Method r111, Object[] r112) throws Throwable {
            if (r111.getDeclaringClass() == Object.class) goto L5;
            long r100 = System.nanoTime();
            e r113 = this.f201162a;
            w r101 = (w) ((ConcurrentHashMap) r113.f201136a).get(r111);
            if (r101 == null) goto L9;
            w r114 = r101;
        L17:
            if (r114.f201252j == false) goto L23;
            int r115 = r114.f201251i;
            if (r112 == null) goto L23;
            Object r116 = r112[r115];
            if ((r116 instanceof q) == false) goto L23;
            q r102 = (q) r116;
        L24:
            e r103 = this.f201162a;
            v r117 = new v(r114, r112, r103.f201142g, r103.f201160y, r103.f201155t, r103.f201137b, r102, r100, r103.f201157v);
            if (r114.f201254l == false) goto L38;
            Response<?> r118 = r117.a();
            if (r118.f201125a != 200) goto L29;
            boolean r119 = true;
        L30:
            if (r119 == true) goto L37;
            if (t.f201195a == false) goto L37;
            throw new IpcException(r118.f201126b);
        L37:
            return r118.f201129e;
        L29:
            r119 = false;
            goto L30
        L38:
            r117.f201228k = w.a(r117.f201219b, r117.f201221d, r117.f201224g);
            long r104 = System.nanoTime();
            r117.f201236s = r104;
            r117.f201237t = r104 - r117.f201235r;
            if (r117.f201226i == false) goto L41;
            ((a) r117.f201218a).a(r117);
        L42:
            return null;
        L41:
            r117.f201222e.a(new u(r117));
        L23:
            r102 = null;
            goto L24
        L9:
            Map<Method, w> r105 = r113.f201136a;
            monitor-enter(r105);
            w r106 = (w) ((ConcurrentHashMap) r113.f201136a).get(r111);     // Catch: Throwable -> L43
            if (r106 != null) goto L14;
            t.b(r111);     // Catch: Throwable -> L43
            r106 = new w.a(r111).a();     // Catch: Throwable -> L43
            ((ConcurrentHashMap) r113.f201136a).put(r111, r106);     // Catch: Throwable -> L43
        L14:
            monitor-exit(r105);     // Catch: Throwable -> L43
            r114 = r106;
        L43:
            th = move-exception;
            throw th;
        L5:
            return r111.invoke(this, r112);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f201163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f201164b;

        public final void a() {
            if (this.f201163a == this.f201164b.f201148m.get()) goto L5;
            return;
        L5:
            if (this.f201164b.f201145j == null) goto L7;
            boolean r100 = true;
        L8:
            if (r100 == true) goto L24;
            g94.b.b("IPC_BdpIPC", new Object[]{"#bind (4. still not bind success after bindOverTime) bindId=" + this.f201163a + " target=" + this.f201164b.f201157v});
            Object r101 = this.f201164b.f201144i;
            monitor-enter(r101);
            this.f201164b.f201152q = false;     // Catch: Throwable -> L18
            monitor-exit(r101);     // Catch: Throwable -> L18
            e r102 = this.f201164b;
            r102.getClass();
            long r103 = System.currentTimeMillis();
            boolean r110 = r102.e();
            long r104 = r103 - r102.f201146k;
            g94.b.b("IPC_BdpIPC", new Object[]{"#monitorBindFailResult target=" + r102.f201157v + " targetProcessAlive=" + r110 + " dur=" + r104});
            String r105 = r102.f201157v;
            if (r102.f201148m.get() != 1) goto L16;
            boolean r111 = true;
        L17:
            t.n(r105, "fail", "bind_overtime_check", r104, false, r111, r110, r102.f201147l);
            return;
        L16:
            r111 = false;
        L18:
            th = move-exception;
            throw th;
        L24:
            return;
        L7:
            r100 = false;
            goto L8
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

        public c(e r100, int r101) {
            this.f201164b = r100;
            this.f201163a = r101;
        }
    }

    public class d implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f201165a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            Object r100 = this.f201165a.f201144i;
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.f201165a.g() == false) goto L9;
            g94.b.b("IPC_BdpIPC", new Object[]{"#binderDied (checking alive) mTransfer is alive, not handleOnBinderDied, target=" + this.f201165a.f201157v});     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L12
            return;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L12
            e.c(this.f201165a);
        }

        public d(e r100) {
            this.f201165a = r100;
        }
    }

    public final void d() {
        g94.b.d("IPC_BdpIPC", new Object[]{"#bind (1. connection start) target=" + this.f201157v});
        Object r100 = this.f201144i;
        monitor-enter(r100);
    L38:
        th = move-exception;
        throw th;
    L5:
        if (g() == false) goto L10;
        g94.b.d("IPC_BdpIPC", new Object[]{"#bind (2. return: alive binder)"});     // Catch: Throwable -> L38
        monitor-exit(r100);     // Catch: Throwable -> L38
        return;
    L10:
        if (this.f201152q == false) goto L14;
        g94.b.d("IPC_BdpIPC", new Object[]{"#bind (2. return: binding)"});     // Catch: Throwable -> L38
        monitor-exit(r100);     // Catch: Throwable -> L38
        return;
    L14:
        this.f201152q = true;     // Catch: Throwable -> L38
        monitor-exit(r100);     // Catch: Throwable -> L38
        int r101 = this.f201148m.incrementAndGet();
        Intent r102 = new Intent();
        if (t.k(this.f201140e) == true) goto L20;
        r102.setAction(this.f201140e);
    L22:
        r102.setPackage(this.f201139d);
        this.f201153r.f201194a.compareAndSet(false, true);
        g94.b.d("IPC_BdpIPC", new Object[]{"#bind (2. real call) bindId=" + r101});
        long r103 = System.currentTimeMillis();
        this.f201146k = r103;
        this.f201147l = r103 - ((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).getHostInfo().getHostStartUpElapsedRealtime();
        Context r104 = this.f201138c;
        f r105 = this.f201153r;
        if (DevicesUtil.f201324a != null) goto L33;
        DevicesUtil.f201324a = DevicesUtil.c();     // Catch: Exception -> L26
    L28:
        String r106 = DevicesUtil.f201324a;
        if (r106 != null) goto L31;
        r106 = "";
    L31:
        DevicesUtil.f201324a = r106;
    L26:
        e = move-exception;
        e.printStackTrace();
    L33:
        if ("V12".equalsIgnoreCase(DevicesUtil.f201324a) == true) goto L47;
    L45:
        r104.bindService(r102, r105, 1);     // Catch: Exception -> L42
    L36:
        BdpPool.postLogic(10000, new c(this, r101));
        g94.b.d("IPC_BdpIPC", new Object[]{"#bind (3. connection finish)"});
        return;
    L47:
        r104.startService(r102);     // Catch: Exception -> L41
        goto L45
    L20:
        if (t.k(this.f201141f) == true) goto L22;
        r102.setClassName(this.f201139d, this.f201141f);
        goto L22
    }

    public final boolean e() {
        if (this.f201154s == true) goto L5;
        Context r100 = this.f201138c;
        return com.bytedance.bdp.bdpbase.util.i.b(r100, r100.getPackageName());
    L5:
        if (this.f201155t == false) goto L10;
        return true;
    L10:
        return com.bytedance.bdp.bdpbase.util.i.b(this.f201138c, this.f201138c.getPackageName() + ":miniappX");
    }

    public final boolean g() {
        if (this.f201145j != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f201145j.asBinder().isBinderAlive() == false) goto L7;
        return true;
    }

    public static void c(e r100) {
        Object r101 = r100.f201144i;
        monitor-enter(r101);
        g94.b.b("IPC_BdpIPC", new Object[]{"#handleOnBinderDied (onDeathRecipient) target=" + r100.f201157v});     // Catch: Throwable -> L13
        r100.h(r100.f201145j);     // Catch: Throwable -> L13
        r100.f201145j = null;     // Catch: Throwable -> L13
        r100.f201146k = -1;     // Catch: Throwable -> L13
        r100.f201147l = -1;     // Catch: Throwable -> L13
        r100.f201152q = false;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        r100.f201137b.b();
        com.bytedance.bdp.bdpbase.ipc.c.a r102 = r100.f201149n;
        if (r102 == null) goto L18;
        BdpIpcServiceImpl.b r103 = (BdpIpcServiceImpl.b) r102;
        if (r103.a() == false) goto L11;
        g94.b.e("IPC_BdpIPC", new Object[]{"MainBdpIpc.binderDied, main process exist, try to rebind"});
        r103.f200564a.getMainBdpIPC().d();
        return;
    L11:
        g94.b.b("IPC_BdpIPC", new Object[]{"MainBdpIpc.binderDied, main process not exist, not rebind"});
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final <T extends r> T f(Class<T> r110) {
        t.t(r110);
        if (this.f201155t == false) goto L34;
        Pair<String, String> r100 = t.r(r110, false);
        aa4.a r101 = aa4.a.C0037a.f2343a;
        T r102 = (T) ((ConcurrentHashMap) r101.f2341a).get((String) r100.first);
        if (r102 == null) goto L7;
    L23:
        if (r102 != null) goto L25;
        t.o("method_interface_reflect_fail", r110.getSimpleName(), "", null);
        if (t.j() == false) goto L34;
        throw new IllegalArgumentException("local IPC cannot find implement object of class " + r110.getName() + "! please check the annotation.");
    L25:
        if (q94.a.f532096b == false) goto L27;
        g94.b.a("IPC_BdpIPC", new Object[]{"local ipc, find implementObj of", r110.getName()});
    L27:
        return r102;
    L7:
        if (TextUtils.isEmpty((CharSequence) r100.second) == true) goto L23;
        Object r103 = t.e((String) r100.second);
        if (r103 == null) goto L23;
        if (q94.a.f532096b == false) goto L13;
        g94.b.a("IPC_BdpIPC", new Object[]{"local ipc, get implement object of", r110.getName()});
    L13:
        r102 = (T) r103;
        String r104 = (String) r100.first;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (((ConcurrentHashMap) r101.f2341a).containsKey(r104) == true) goto L18;
        ((ConcurrentHashMap) r101.f2341a).put(r104, r102);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r101);
    L34:
        return (T) Proxy.newProxyInstance(com.bytedance.bdp.bdpbase.util.b.a(), new Class[]{r110}, new b(this));
    }

    public final void h(ITransfer r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f201150o != null) goto L16;
        return;
    L16:
        r100.asBinder().unlinkToDeath(this.f201150o, 0);     // Catch: NoSuchElementException -> L9
    L12:
        this.f201150o = null;
        g94.b.d("IPC_BdpIPC", new Object[]{"#unlinkToDeathMonitor target=" + this.f201157v});
        return;
    L9:
        e = move-exception;
        boolean r101 = t.f201195a;
        g94.b.b("IPC_BdpIPC", new Object[]{e.getMessage()});
        if (t.j() == false) goto L12;
        throw new NoSuchElementException(e.getMessage());
    }

    public static void a(e r100, ITransfer r101) {
        r100.h(r101);
        if (r100.f201150o != null) goto L11;
        r100.f201150o = new d(r100);
        r101.asBinder().linkToDeath(r100.f201150o, 0);     // Catch: RemoteException -> L7
        g94.b.d("IPC_BdpIPC", new Object[]{"#linkToDeathMonitor target=" + r100.f201157v});     // Catch: RemoteException -> L7
        return;
    L7:
        r100.f201150o = null;
        return;
    }

    public static void b(e r100, boolean r101) {
        r100.getClass();
        g94.b.d("IPC_BdpIPC", new Object[]{"#flushRemoteCall (1. start) success=" + r101 + " target=" + r100.f201157v});
        Object r102 = r100.f201159x;
        monitor-enter(r102);
        g94.b.d("IPC_BdpIPC", new Object[]{"#flushRemoteCall (2. get lock) WaitingList.size=" + r100.f201158w.size()});     // Catch: Throwable -> L16
        ArrayList r103 = new ArrayList(r100.f201158w);     // Catch: Throwable -> L16
        r100.f201158w.clear();     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        if (r101 == false) goto L11;
        Iterator r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L15;
        r100.f201142g.a(new h(r100, (v) r104.next()));
        goto L9
    L15:
        return;
    L11:
        Iterator r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L23;
        r100.f201142g.a(new i(r100, (v) r105.next()));
        goto L13
    L23:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [com.bytedance.bdp.bdpbase.ipc.BdpIPCImpl$5] */
    public e(Context r100, String r101, String r102, l r103) {
        this.f201136a = new ConcurrentHashMap();
        this.f201144i = new Object();
        this.f201146k = -1;
        this.f201147l = -1;
        boolean r104 = false;
        this.f201148m = new AtomicInteger(0);
        this.f201151p = false;
        this.f201152q = false;
        this.f201153r = new f(this);
        this.f201158w = new ArrayList();
        this.f201159x = new Object();
        this.f201160y = new a(this);
        this.f201138c = r100;
        this.f201156u = new Handler(Looper.getMainLooper());
        this.f201139d = r101;
        String r105 = null;
        this.f201140e = null;
        this.f201141f = r102;
        this.f201142g = r103;
        this.f201143h = new BdpIPCImpl$5(this);
        if (t.k(r102) == true) goto L6;
        r105 = r102;
    L6:
        this.f201157v = r105;
        boolean r106 = com.bytedance.bdp.bdpbase.util.i.d(r100);
        this.f201154s = r106;
        if (r102 != null) goto L9;
    L14:
        this.f201155t = r104;
        ConcurrentHashMap<String, k> r107 = j.f201178a;
        k r108 = r107.get(r105);
        if (r108 != null) goto L18;
        r108 = new k();
        r107.put(r105, r108);
    L18:
        this.f201137b = r108;
        return;
    L9:
        if (r102.equals(MainDefaultIpcService.class.getName()) == false) goto L11;
    L12:
        if (r106 == false) goto L14;
        r104 = true;
        goto L14
    L11:
        if (r102.equals(MiniGameMainIpcService.class.getName()) == false) goto L14;
        goto L12
    }
}
