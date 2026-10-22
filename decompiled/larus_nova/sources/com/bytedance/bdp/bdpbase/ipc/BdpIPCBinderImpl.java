package com.bytedance.bdp.bdpbase.ipc;

import android.os.Binder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
final class BdpIPCBinderImpl extends ITransfer.Stub implements d {
    private static final String TAG = "IPC_BdpIPCBinder";
    private p mInvoker;

    public BdpIPCBinderImpl() {
        this.mInvoker = new p();
    }

    @Override // com.bytedance.bdp.bdpbase.ipc.ITransfer
    public Response<Object> execute(Request r110) throws RemoteException {
        g94.b.d(TAG, new Object[]{"Receive request: " + r110.b()});
        p r100 = this.mInvoker;
        r100.getClass();
        long r111 = r110.f201122i;
        boolean r101 = r110.f201124k;
        if (r110.f201119f == 0) goto L5;
        boolean r102 = true;
    L7:
        if (r110.f201120g == 0) goto L9;
        boolean r112 = true;
    L10:
        String r113 = r110.a();
        String r103 = r110.f201114a;
        String r104 = r103 + '-' + r110.f201116c;
        MethodInvoker r114 = r100.f201190b.get(r104);
        if (r114 != null) goto L35;
        if (r110.f201121h == 0) goto L15;
        boolean r115 = true;
    L16:
        if (r115 == true) goto L18;
        g94.b.b("IPC_Invoker", new Object[]{"getMethodInvokerCompact error not enableReflection" + r110.f201114a});
    L21:
        r102 = r102;
        MethodInvoker r105 = null;
    L36:
        if (r105 != null) goto L38;
        String r106 = String.format("The method '%s' you call was not exist!", new Object[]{r113});
        g94.b.b("IPC_Invoker", new Object[]{r106});
        return new Response(404, r106, null, r111, false);
    L38:
        Object[] r107 = r110.f201117d.f201112b;
        if (r107 != null) goto L41;
        int r108 = 0;
    L42:
        if (r112 == false) goto L50;
        int r109 = r108 - 1;
        ba4.a r116 = (ba4.a) r107[r109];
        if (r101 == false) goto L47;
        r107[r109] = r116.f18413b;
        goto L50
    L47:
        if (r116.f18414c == false) goto L49;
        g94.b.e("IPC_Invoker", new Object[]{"invoking request " + r110.b() + ", callback obj of index #" + (r109 + 1) + " is null."});
        r107[r109] = null;
        goto L50
    L49:
        r107[r109] = r100.c(r116.f18412a, r111);
    L50:
        if (r102 == true) goto L57;
        new BdpTask.Builder().onCPU().trace("ipc invoke").runnable(new n(r105, r107, r111, r112, r113)).start();
        return new Response(999, null, null, r111, false);
    L57:
        return r105.a(r107, r111, false, r112, r113);
    L41:
        r108 = r107.length;
        goto L42
    L18:
        String r117 = r110.f201115b;
        if ((!TextUtils.isEmpty(r117)) == true) goto L22;
        g94.b.b("IPC_Invoker", new Object[]{"getMethodInvokerCompact error, can not found implement class of: " + r110.f201114a});
        goto L21
    L22:
        ConcurrentHashMap<String, MethodInvoker> r118 = r100.f201190b;
        monitor-enter(r118);
        g94.b.d("IPC_Invoker", new Object[]{"getMethodInvokerCompact by reflection, loadClass: " + r110.f201115b});     // Catch: Throwable -> L31
        Object r119 = t.e(r117);     // Catch: Throwable -> L31
        if (r119 == null) goto L27;
        r100.e(r119, r103, true, t.u(r119).getDeclaredMethods());     // Catch: Throwable -> L31
    L28:
        r114 = r100.f201190b.get(r104);     // Catch: Throwable -> L31
        monitor-exit(r118);     // Catch: Throwable -> L31
        goto L35
    L27:
        g94.b.b("IPC_Invoker", new Object[]{"getMethodInvokerCompact error, can not create implement object: " + r110.f201115b});     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L15:
        r115 = false;
    L35:
        r105 = r114;
        goto L36
    L9:
        r112 = false;
        goto L10
    L5:
        r102 = false;
        goto L7
    }

    @Override // com.bytedance.bdp.bdpbase.ipc.ITransfer
    public void register(ICallback r100) throws RemoteException {
        int r101 = Binder.getCallingPid();
        g94.b.d(TAG, new Object[]{"register callback:" + r100 + " pid:" + r101});
        if (r100 == null) goto L6;
        this.mInvoker.f201191c.register(r100, Integer.valueOf(r101));
        return;
    }

    @Override // com.bytedance.bdp.bdpbase.ipc.d
    public void registerObject(r r100) {
        this.mInvoker.d(r100, true);
    }

    @Override // com.bytedance.bdp.bdpbase.ipc.ITransfer
    public void unRegister(ICallback r100) throws RemoteException {
        g94.b.d(TAG, new Object[]{"unRegister callback:" + r100 + " pid:" + Binder.getCallingPid()});
        if (r100 == null) goto L6;
        this.mInvoker.f201191c.unregister(r100);
        return;
    }

    public void unRegisterObject(r r100) {
        this.mInvoker.d(r100, false);
    }
}
