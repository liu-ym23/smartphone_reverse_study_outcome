package com.bytedance.bdp.bdpbase.ipc;

import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.bdp.appbase.base.ipc.BdpIpcServiceImpl;
import com.bytedance.bdp.bdpbase.ipc.annotation.ResponseCallback;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes11.dex */
public final class v {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final AtomicLong f201217z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f201218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f201219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f201220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object[] f201221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f201222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f201223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f201224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f201225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f201226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f201227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Request f201228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final q<Object> f201229l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f201230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f201231n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f201232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f201233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f201234q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f201235r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f201236s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f201237t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f201238u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f201239v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f201240w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f201241x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f201242y;

    static {
        f201217z = new AtomicLong();
    }

    public final Response<?> a() {
        this.f201228k = w.a(this.f201219b, this.f201221d, this.f201224g);
        long r100 = System.nanoTime();
        this.f201236s = r100;
        this.f201237t = r100 - this.f201235r;
        e.a r101 = (e.a) this.f201218a;
        ITransfer r102 = r101.f201161a.f201145j;
        if (r102 != null) goto L5;
    L7:
        e r103 = r101.f201161a;
        Object r104 = r103.f201144i;
        monitor-enter(r104);
    L79:
        th = move-exception;
        throw th;
    L10:
        if (r103.g() == false) goto L14;
        g94.b.d("IPC_BdpIPC", new Object[]{"#blockGetITransfer (from cache)"});     // Catch: Throwable -> L79
        monitor-exit(r104);     // Catch: Throwable -> L79
    L43:
        r102 = r101.f201161a.f201145j;
    L44:
        this.f201228k.f201124k = f(r102);
        this.f201238u = System.nanoTime() - this.f201236s;
        Response<?> r105 = e(r102, this.f201228k);
        if (r105.f201129e != 0) goto L76;
        Class<?> r106 = this.f201219b.f201255m;
        if (r106 == null) goto L76;
        if (r106.isPrimitive() == false) goto L76;
        boolean r107 = t.f201195a;
        if (r106 != Boolean.TYPE) goto L54;
        Object r108 = Boolean.FALSE;
    L75:
        r105.setResult(r108);
        goto L76
    L54:
        if (r106 != Byte.TYPE) goto L57;
        r108 = (byte) -1;
        goto L75
    L57:
        if (r106 != Character.TYPE) goto L60;
        r108 = Character.valueOf(CharCompanionObject.MAX_VALUE);
        goto L75
    L60:
        if (r106 != Short.TYPE) goto L63;
        r108 = (short) -1;
        goto L75
    L63:
        if (r106 != Integer.TYPE) goto L66;
        r108 = -1;
        goto L75
    L66:
        if (r106 != Long.TYPE) goto L69;
        r108 = -1L;
        goto L75
    L69:
        if (r106 != Float.TYPE) goto L72;
        r108 = Float.valueOf(-1.0f);
        goto L75
    L72:
        if (r106 != Double.TYPE) goto L74;
        r108 = Double.valueOf(-1.0d);
        goto L75
    L74:
        r108 = null;
    L76:
        return r105;
    L14:
        c.a r109 = r103.f201149n;     // Catch: Throwable -> L79
        if (r109 != null) goto L17;
    L23:
        monitor-exit(r104);     // Catch: Throwable -> L79
        long r110 = System.currentTimeMillis();
        r103.d();
        if (Looper.getMainLooper() != Looper.myLooper()) goto L27;
        this.f201234q = "get_binder_in_main_thread";
        goto L43
    L27:
        Object r111 = r103.f201144i;
        monitor-enter(r111);
    L37:
        th = move-exception;
        throw th;
    L39:
        e = move-exception;
        g94.b.b("IPC_BdpIPC", new Object[]{"#blockGetITransfer (catch error)", e});     // Catch: Throwable -> L37
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L37
    L41:
        monitor-exit(r111);     // Catch: Throwable -> L37
        g94.b.d("IPC_BdpIPC", new Object[]{"#blockGetITransfer (finish) remoteCall=" + g() + " dur=" + (System.currentTimeMillis() - r110)});
        goto L43
    L30:
        if (r103.f201145j != null) goto L41;
        if (r103.f201152q == false) goto L41;
        long r112 = System.currentTimeMillis();     // Catch: Throwable -> L37 InterruptedException -> L39
        r103.f201144i.wait(10000);     // Catch: Throwable -> L37 InterruptedException -> L39
        long r113 = System.currentTimeMillis() - r112;     // Catch: Throwable -> L37 InterruptedException -> L39
        if (r113 < 10000) goto L41;
        r103.f201152q = false;     // Catch: Throwable -> L37 InterruptedException -> L39
        t.l(r103.f201138c, "blockGetITransfer Timeout waitTime:" + r113 + ", method:" + this.f201232o + ", state of main thread=" + ThreadMethodProxy.getLooperThread(r103.f201156u.getLooper()).getState().toString());     // Catch: Throwable -> L37 InterruptedException -> L39
        this.f201234q = "block_getITransfer_overtime";     // Catch: Throwable -> L37 InterruptedException -> L39
    L17:
        if (((BdpIpcServiceImpl.b) r109).a() == true) goto L23;
        if (r103.f201152q == true) goto L23;
        this.f201234q = "unable_to_bind";     // Catch: Throwable -> L79
        monitor-exit(r104);     // Catch: Throwable -> L79
        goto L43
    L5:
        if (r102.asBinder().isBinderAlive() == false) goto L7;
        goto L7
    }

    public final String g() {
        return "RemoteCall {id=" + this.f201224g + ", methodName=" + this.f201232o + com.alipay.sdk.m.u.i.f25855d;
    }

    public final void b(ITransfer r100) {
        this.f201228k.f201124k = f(r100);
        this.f201238u = System.nanoTime() - this.f201236s;
        e(r100, this.f201228k);
    }

    public final void d(boolean r110) {
        t.q(this.f201232o, r110, false, this.f201237t, this.f201238u, this.f201240w, this.f201241x, this.f201242y, this.f201239v);
    }

    public final boolean f(ITransfer r110) {
        if (this.f201225h == false) goto L5;
        return true;
    L5:
        if (r110 != null) goto L7;
        return true;
    L7:
        if ((r110 instanceof BdpIPCBinderImpl) == true) goto L54;
        w r100 = this.f201219b;
        if (r100 != null) goto L12;
    L45:
        return false;
    L12:
        if (r100.f201252j == false) goto L45;
        k r101 = this.f201227j;
        if (r101 == null) goto L45;
        q<Object> r102 = this.f201229l;
        if (r102 == null) goto L44;
        long r103 = this.f201224g;
        boolean r104 = t.f201195a;
        Class<?>[] r105 = r102.getClass().getInterfaces();
        if (r105.length != 1) goto L43;
        Class<?> r106 = r105[0];
        if (r106.getName().equals(q.class.getName()) == false) goto L40;
        String r107 = r106.getSimpleName();
        Method[] r108 = r106.getDeclaredMethods();
        int r109 = r108.length;
        int r111 = 0;
    L22:
        if (r111 >= r109) goto L45;
        Method r112 = r108[r111];
        if (r112.isBridge() == true) goto L49;
        String r113 = t.s(r112);
        String r114 = r107 + '-' + r103 + '-' + r113;
        HashMap<Long, Set<String>> r115 = r101.f201180c;
        monitor-enter(r115);
        MethodInvoker r116 = new MethodInvoker(r102, r112, r112.isAnnotationPresent(ResponseCallback.class));     // Catch: Throwable -> L37
        Set<String> r117 = r101.f201180c.get(Long.valueOf(r103));     // Catch: Throwable -> L37
        if (r117 != null) goto L31;
        r117 = new HashSet();     // Catch: Throwable -> L37
    L31:
        r117.add(r114);     // Catch: Throwable -> L37
        r101.f201180c.put(Long.valueOf(r103), r117);     // Catch: Throwable -> L37
        r101.a(r112, true);     // Catch: Throwable -> L37
        if (r101.f201179b.putIfAbsent(r114, r116) != null) goto L36;
        monitor-exit(r115);     // Catch: Throwable -> L37
        goto L49
    L36:
        throw new IllegalStateException("Key conflict with class:" + r107 + " method:" + r113 + ". Please try another class/method name.");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L49:
        r111 = r111 + 1;     // Catch: Throwable -> L37
        r102 = r102;
        goto L22
    L40:
        String r118 = "error when validateCallbackObject(), Interface '" + r106.getSimpleName() + "' isn't 'IPCBaseCallback'";
        g94.b.b("IPC_Utils", new Object[]{r118});
        throw new IllegalArgumentException(r118);
    L43:
        throw new IllegalArgumentException("Remote object must extend just one interface.");
    L44:
        g94.b.e("IPC_RemoteCall", new Object[]{"RemoteCall registerCallback, callback object of index " + (this.f201221d.length - 1) + " is null, may cause not find callback method, request{ id=" + this.f201224g + ", method=" + this.f201232o + com.alipay.sdk.m.u.i.f25855d});
        return false;
    L54:
        return true;
    }

    public final Response<Object> e(ITransfer r110, Request r111) {
        this.f201223f.set(true);
        if (r110 != null) goto L7;
        String r100 = "RemoteCall of request " + r111.b() + " fail, reason is " + this.f201234q;
        g94.b.b("IPC_RemoteCall", new Object[]{r100});
        c(this.f201234q, r100, this.f201233p);
        return new Response(500, r100, null, this.f201224g, false);
    L7:
        if (r110.asBinder().isBinderAlive() == true) goto L61;
        String r112 = "RemoteCall of request " + r111.b() + " fail, target process died";
        g94.b.b("IPC_RemoteCall", new Object[]{r112});
        c("target_binder_process_died", r112, "target_process_died_when_execute");
        return new Response(500, "target process died", null, this.f201224g, false);
    L61:
        long r101 = System.nanoTime();     // Catch: Throwable -> L18 RemoteException -> L21
        Response<Object> r113 = r110.execute(r111);     // Catch: Throwable -> L18 RemoteException -> L21
        this.f201240w = System.nanoTime() - r101;     // Catch: Throwable -> L14 RemoteException -> L16
        String r102 = "iTransfer_uncaught_exception";
        RemoteException r103 = null;
    L26:
        if (r113 == null) goto L47;
        if (this.f201225h == true) goto L30;
        this.f201241x = r113.f201130f;
        this.f201242y = r113.f201131g;
    L30:
        int r104 = r113.f201125a;
        if (r104 != 200) goto L33;
        boolean r105 = true;
    L34:
        if (r105 == false) goto L37;
        g94.b.d("IPC_RemoteCall", new Object[]{"request " + r111.b() + " execute success"});
        d(true);
        return r113;
    L37:
        if (r104 != 999) goto L39;
        boolean r106 = true;
    L40:
        if (r106 == false) goto L42;
        g94.b.a("IPC_RemoteCall", new Object[]{"remote execute has dispatched, request: " + r111.b()});
        d(true);
        return r113;
    L42:
        String r107 = "remote execute response unsuccessful: {" + r113.f201126b + com.alipay.sdk.m.u.i.f25855d;
        if (r103 == null) goto L45;
        r107 = r107 + t.c(r103);
    L45:
        g94.b.b("IPC_RemoteCall", new Object[]{r107 + ", request=" + r111.b()});
        c(m.a(r113.f201125a, false), r107, null);
        return r113;
    L39:
        r106 = false;
        goto L40
    L33:
        r105 = false;
        goto L34
    L47:
        if (r111.f201118e == true) goto L57;
        StringBuilder r114 = new StringBuilder("ITransfer execute request fail, " + r111);
        if (r103 == null) goto L51;
        String r115 = ", catch exception: {" + t.c(r103) + com.alipay.sdk.m.u.i.f25855d;
    L52:
        r114.append(r115);
        g94.b.b("IPC_RemoteCall", new Object[]{r114.toString()});
        String r116 = r114.toString();
        if (r103 != null) goto L55;
        String r108 = "unknown error.";
    L56:
        c(r102, r116, r108);
        return new Response(508, "execute method " + this.f201232o + " fail" + r115, null, this.f201224g, false);
    L55:
        r108 = r103.getClass().getName();
        goto L56
    L51:
        r115 = ", but not catch exception";
        goto L52
    L57:
        g94.b.d("IPC_RemoteCall", new Object[]{"oneway request " + r111 + " execute finish"});
        d(true);
        return new Response(200, "oneway IPC success", null, this.f201224g, false);
    L16:
        RemoteException e100 = e;
    L23:
        String r109 = "iTransfer_transact_error";
    L24:
        String r117 = r109;
        r103 = e100;
        r102 = r117;
    L14:
        e100 = th;
    L20:
        r109 = "iTransfer_catch_other_error";
        goto L24
    L21:
        e = move-exception;
        e100 = e;
        r113 = null;
    L18:
        th = move-exception;
        e100 = th;
        r113 = null;
        goto L20
    }

    public final void c(String r100, String r101, String r102) {
        this.f201223f.set(true);
        if (this.f201229l == null) goto L6;
        m.b(r100);
        this.f201229l.a();
    L6:
        if (this.f201220c == false) goto L8;
    L12:
        d(false);
        return;
    L8:
        if (r100.equals("method_illegal_access") == true) goto L12;
        if (r100.equals("method_invocation_fail") == true) goto L12;
        t.o(r100, this.f201230m, this.f201231n, r102);
        goto L12
    }

    public v(w r100, Object[] r101, l r102, e.a r103, boolean r104, k r110, q r111, long r112, String r113) {
        boolean r105 = false;
        this.f201223f = new AtomicBoolean(false);
        this.f201234q = "target_binder_process_died";
        this.f201238u = -1;
        this.f201239v = -1;
        this.f201240w = -1;
        this.f201241x = -1;
        this.f201242y = -1;
        this.f201224g = f201217z.incrementAndGet();
        this.f201218a = r103;
        this.f201219b = r100;
        if (r100.f201248f == (-1)) goto L5;
        r105 = true;
    L5:
        this.f201220c = r105;
        this.f201221d = r101;
        this.f201222e = r102;
        this.f201225h = r104;
        this.f201226i = r100.f201247e;
        this.f201227j = r110;
        this.f201229l = r111;
        String r106 = r100.f201243a;
        this.f201230m = r106;
        String r107 = r100.f201245c;
        this.f201231n = r107;
        this.f201232o = r106 + "-" + r107;
        this.f201235r = r112;
        this.f201233p = r113;
    }
}
