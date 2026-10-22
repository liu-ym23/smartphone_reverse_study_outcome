package com.bytedance.bdp.bdpbase.ipc;

import android.app.ActivityManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Pair;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class o implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f201186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f201187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f201188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f201189d;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r210, Method r211, Object[] r310) throws Throwable {
        if (r211.getDeclaringClass() == Object.class) goto L5;
        Object r100 = this.f201189d.f201192d;
        monitor-enter(r100);
        int r101 = this.f201189d.f201191c.beginBroadcast();     // Catch: Throwable -> L15 IllegalStateException -> L23
        p r102 = this.f201189d;     // Catch: Throwable -> L15 IllegalStateException -> L23
        int r110 = this.f201186a;     // Catch: Throwable -> L15 IllegalStateException -> L23
        RemoteCallbackList<ICallback> r103 = r102.f201191c;     // Catch: Throwable -> L15 IllegalStateException -> L23
        int r111 = 0;
    L10:
        if (r111 >= r101) goto L18;
        if (((Integer) r103.getBroadcastCookie(r111)).intValue() == r110) goto L13;
        r111 = r111 + 1;
        goto L10
    L13:
        ICallback r104 = (ICallback) r103.getBroadcastItem(r111);     // Catch: Throwable -> L15 IllegalStateException -> L23
    L76:
        this.f201189d.f201191c.finishBroadcast();     // Catch: Throwable -> L15 IllegalStateException -> L21
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L15
        if (r104 == null) goto L53;
        long r112 = System.nanoTime();
        p r105 = this.f201189d;
        Class r106 = this.f201187b;
        long r113 = this.f201188c;
        Pair<String, String> r114 = r105.f201193e.get(r211);
        if (r114 != null) goto L31;
        boolean r115 = t.f201195a;
        Pair<String, String> r116 = new Pair(r106.getSimpleName(), t.s(r211));
        r105.f201193e.put(r211, r116);
        r114 = r116;
    L31:
        if (r310 == null) goto L33;
        int r107 = r310.length;
    L34:
        byte[] r108 = new byte[r107];
        int r117 = 0;
    L35:
        if (r117 >= r107) goto L41;
        Object r118 = r310[r117];
        if (r118 != null) goto L39;
        Class<?> r119 = null;
    L40:
        r108[r117] = t.h(r119);
        r117 = r117 + 1;
        goto L35
    L39:
        r119 = r118.getClass();
        goto L40
    L41:
        CallbackRequest r109 = new CallbackRequest((String) r114.first, (String) r114.second, new ParameterList(r107, r108, r310), r113);
        long r120 = System.nanoTime() - r112;
        if (r104.asBinder().isBinderAlive() == true) goto L79;
        g94.b.b("IPC_Invoker", new Object[]{"Client process died when callback, callback request is: " + r109.b()});
        t.o("target_binder_process_died", this.f201187b.getName(), r211.getName(), "target_process_died_when_callback");
        t.p(r109.a(), false, r120, -1, -1, -1);
        return null;
    L79:
        long r121 = System.nanoTime();     // Catch: RemoteException -> L50
        p.b(this.f201189d, r109, r104.callback(r109), this.f201188c, this.f201187b.getName(), r211.getName(), r120, System.nanoTime() - r121);     // Catch: RemoteException -> L48
    L71:
        return null;
    L48:
        e = e;
    L52:
        long r122 = System.nanoTime() - r121;
        g94.b.b("IPC_Invoker", new Object[]{"ICallback.callback catch exception", "error occur in " + m.b("ICallback_callback_fail") + ", error message: " + t.c(e)});
        t.o("ICallback_callback_fail", r109.f201098a, r109.f201099b, e.getClass().getName());
        t.p(r109.a(), false, r120, r122, -1, -1);
    L50:
        e = e;
        r121 = 0;
        goto L52
    L33:
        r107 = 0;
        goto L34
    L53:
        int r123 = this.f201186a;
        boolean r124 = t.f201195a;
        List<ActivityManager.RunningAppProcessInfo> r125 = ((ActivityManager) z84.a.a().getSystemService("activity")).getRunningAppProcesses();
        if (r125 == null) goto L61;
        Iterator<ActivityManager.RunningAppProcessInfo> r126 = r125.iterator();
    L57:
        if (r126.hasNext() == false) goto L61;
        if (r123 != r126.next().pid) goto L57;
        boolean r127 = true;
    L66:
        g94.b.b("IPC_Invoker", new Object[]{"cannot find ICallback, callback requestId=" + this.f201188c + ", method={" + this.f201187b.getName() + "-" + r211.getName() + "}, client pid=" + this.f201186a + ", client process alive=" + r127});
        String r128 = this.f201187b.getName();
        String r129 = r211.getName();
        if (r127 == false) goto L69;
        String r130 = "client_process_alive_but_not_found";
    L70:
        t.o("server_not_find_ICallback", r128, r129, r130);
        goto L71
    L69:
        r130 = "client_process_not_alive";
    L61:
        Object[] r131 = new Object[1];
        StringBuilder r132 = new StringBuilder("cannot find processID of '");
        r132.append(r123);
        r132.append("', currentProcessInfo size=");
        if (r125 != null) goto L64;
        int r133 = 0;
    L65:
        r132.append(r133);
        r131[0] = r132.toString();
        g94.b.b("IPC_Utils", r131);
        r127 = false;
        goto L66
    L64:
        r133 = r125.size();
    L21:
        e = e;
    L25:
        g94.b.b("IPC_Invoker", new Object[]{"Execute remote callback beginBroadcast: ", e});     // Catch: Throwable -> L15
        this.f201189d.f201191c.finishBroadcast();     // Catch: Throwable -> L15
        goto L26
    L18:
        r104 = null;
    L15:
        th = move-exception;
        throw th;
    L23:
        e = e;
        r104 = null;
        goto L25
    L5:
        return r211.invoke(this, r310);
    }

    public o(p r100, int r101, Class r102, long r103) {
        this.f201189d = r100;
        this.f201186a = r101;
        this.f201187b = r102;
        this.f201188c = r103;
    }
}
