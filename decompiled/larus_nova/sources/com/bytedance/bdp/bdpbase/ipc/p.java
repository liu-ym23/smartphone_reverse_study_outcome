package com.bytedance.bdp.bdpbase.ipc;

import android.os.Binder;
import android.os.RemoteCallbackList;
import android.util.Pair;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class p extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, MethodInvoker> f201190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RemoteCallbackList<ICallback> f201191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f201192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Method, Pair<String, String>> f201193e;

    public p() {
        this.f201192d = new Object();
        this.f201190b = new ConcurrentHashMap();
        this.f201191c = new RemoteCallbackList();
        this.f201193e = new ConcurrentHashMap();
    }

    static {
    }

    public final Object c(String r110, long r111) {
        int r100 = Binder.getCallingPid();
        Class<?> r101 = this.f201132a.get(r110);
        int r102 = 0;
        if (r101 == null) goto L28;
        t.t(r101);
        Object r103 = Proxy.newProxyInstance(com.bytedance.bdp.bdpbase.util.b.a(), new Class[]{r101}, new o(this, r100, r101, r111));
        if (r103 == null) goto L26;
        Object r104 = this.f201192d;
        monitor-enter(r104);
        ICallback r112 = null;
        int r105 = this.f201191c.beginBroadcast();     // Catch: Throwable -> L14 IllegalStateException -> L19
        RemoteCallbackList<ICallback> r106 = this.f201191c;     // Catch: Throwable -> L14 IllegalStateException -> L19
    L10:
        if (r102 >= r105) goto L17;
        if (((Integer) r106.getBroadcastCookie(r102)).intValue() == r100) goto L13;
        r102 = r102 + 1;     // Catch: Throwable -> L14 IllegalStateException -> L19
        goto L10
    L13:
        r112 = (ICallback) r106.getBroadcastItem(r102);     // Catch: Throwable -> L14 IllegalStateException -> L19
    L17:
        this.f201191c.finishBroadcast();     // Catch: Throwable -> L14 IllegalStateException -> L19
    L20:
        if (r112 == null) goto L22;
        b.a.f201135a.a(r112, r103, r111);     // Catch: Throwable -> L14
    L22:
        monitor-exit(r104);     // Catch: Throwable -> L14
    L27:
        return r103;
    L19:
        this.f201191c.finishBroadcast();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L26:
        g94.b.b("IPC_Invoker", new Object[]{"getCallbackProxy error class =" + r110});
        goto L27
    L28:
        g94.b.b("IPC_Invoker", new Object[]{"Can't find callback class: " + r110 + " map = " + this.f201132a});
        throw new IllegalStateException("Can't find callback class: " + r110);
    }

    public final void d(Object r100, boolean r101) {
        Class<?> r102 = t.u(r100);
        String r103 = r102.getSimpleName();
        g94.b.d("IPC_Invoker", new Object[]{"handle implement object of: " + r103 + ", register: " + r101});
        e(r100, r103, r101, r102.getDeclaredMethods());
    }

    public final void e(Object r110, String r111, boolean r112, Method[] r113) {
        int r100 = r113.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L35;
        Method r102 = r113[r101];
        if (r102.isBridge() == true) goto L31;
        String r103 = t.s(r102);
        String r104 = r111 + '-' + r103;
        if (r112 == true) goto L10;
        ConcurrentHashMap<String, MethodInvoker> r105 = this.f201190b;
        monitor-enter(r105);
        a(r102, false);     // Catch: Throwable -> L32
        this.f201190b.remove(r104);     // Catch: Throwable -> L32
        monitor-exit(r105);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L10:
        if ((!this.f201190b.containsKey(r104)) == false) goto L31;
        ConcurrentHashMap<String, MethodInvoker> r106 = this.f201190b;
        monitor-enter(r106);
    L24:
        th = move-exception;
        throw th;
    L14:
        if (this.f201190b.containsKey(r104) == true) goto L22;
        MethodInvoker r107 = new MethodInvoker(r110, r102, false);     // Catch: Throwable -> L24
        a(r102, true);     // Catch: Throwable -> L24
        if (this.f201190b.putIfAbsent(r104, r107) == null) goto L22;
        String r108 = "Key conflict with class:" + r111 + " method:" + r103 + ". Please try another class/method name.";     // Catch: Throwable -> L24
        g94.b.b("IPC_Invoker", new Object[]{r108});     // Catch: Throwable -> L24
        if (t.j() == false) goto L22;
        throw new IllegalStateException(r108);     // Catch: Throwable -> L24
    L22:
        monitor-exit(r106);     // Catch: Throwable -> L24
    L31:
        r101 = r101 + 1;     // Catch: Throwable -> L32
        goto L3
    }

    public static void b(p r210, CallbackRequest r211, Response r212, long r310, String r311, String r312, long r313, long r314) {
        Response r100 = r212;
        r210.getClass();
        if (r100 == null) goto L21;
        long r110 = r100.f201131g;
        long r111 = r100.f201130f;
        int r112 = r100.f201125a;
        if (r112 != 999) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        g94.b.d("IPC_Invoker", new Object[]{"Remote callback dispatched, callback response: " + r100.f201126b + ", request: " + r211.toString()});
    L20:
        long r213 = r110;
        long r214 = r111;
    L22:
        String r113 = r211.a();
        int r102 = r100.f201125a;
        if (r102 != 200) goto L25;
        boolean r103 = true;
    L26:
        if (r103 == false) goto L28;
    L31:
        boolean r114 = true;
    L32:
        t.p(r113, r114, r313, r314, r214, r213);
        if (r100.f201125a != 200) goto L35;
        boolean r104 = true;
    L36:
        if (r104 == true) goto L44;
        g94.b.b("IPC_Invoker", new Object[]{"Execute remote callback fail: " + r100 + ", callback request" + r211.b()});
        String r105 = r211.f201098a;
        String r106 = r211.f201099b;
        int r107 = r100.f201125a;
        if (r107 != 400) goto L40;
        return;
    L40:
        if (r107 == 401) goto L46;
        t.o(m.a(r107, true), r105, r106, null);
        return;
    L46:
        return;
    L44:
        return;
    L35:
        r104 = false;
        goto L36
    L28:
        if (r102 == 401) goto L31;
        r114 = false;
        goto L32
    L25:
        r103 = false;
        goto L26
    L10:
        if (r112 != 200) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == true) goto L20;
        g94.b.b("IPC_Invoker", new Object[]{"Execute remote callback fail: " + r100 + ", callback request" + r211.b()});
        String r109 = r211.f201098a;
        String r115 = r211.f201099b;
        int r116 = r100.f201125a;
        boolean r117 = t.f201195a;
        if (r116 == 400) goto L20;
        if (r116 == 401) goto L20;
        t.o(m.a(r116, true), r109, r115, null);
        goto L20
    L12:
        r108 = false;
        goto L13
    L7:
        r101 = false;
        goto L8
    L21:
        g94.b.b("IPC_Invoker", new Object[]{"Execute remote callback error, return null response, request: " + r211.toString()});
        r100 = new Response(505, "unknown callback error", null, r310, true);
        t.o("client_response_callback_null", r311, r312, null);
        r214 = -1;
        r213 = -1;
        goto L22
    }
}
