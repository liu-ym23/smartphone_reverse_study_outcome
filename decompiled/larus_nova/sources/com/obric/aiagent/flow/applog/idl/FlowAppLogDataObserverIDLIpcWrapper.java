package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class FlowAppLogDataObserverIDLIpcWrapper implements IFlowAppLogDataObserverIDL {
    boolean log;
    final IFlowAppLogDataObserverIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FlowAppLogDataObserverIDLIpcWrapper(IFlowAppLogDataObserverIDL r100) throws RemoteException {
        this(r100, true);
    }

    public FlowAppLogDataObserverIDLIpcWrapper(IFlowAppLogDataObserverIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onIdLoaded(String r210, String r211, String r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r213 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogDataObserverIDLIPC", "onIdLoaded", r101, r102, r213);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onIdLoaded(r210, r211, r212);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowAppLogDataObserverIDLIPC", "onIdLoaded = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppLogDataObserverIDLIPC", "onIdLoaded", r111, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onRemoteIdGet(boolean r210, String r211, String r212, String r213, String r214, String r310, String r311) throws RemoteException {
        String r110 = r214;
        long r111 = SystemClock.elapsedRealtimeNanos();
    L41:
        e = e;
        String r100 = "onRemoteIdGet(";
        String r215 = "IFlowAppLogDataObserverIDLIPC";
        String r216 = ")";
        r310 = r310;
        String r112 = ", ";
    L43:
        int r101 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L45
        StringBuilder r102 = new StringBuilder(r100);     // Catch: Throwable -> L45
        r102.append(r210);     // Catch: Throwable -> L45
        r102.append(r112);     // Catch: Throwable -> L45
        r102.append(r211);     // Catch: Throwable -> L45
        r102.append(r112);     // Catch: Throwable -> L45
        r102.append(r212);     // Catch: Throwable -> L45
        r102.append(r112);     // Catch: Throwable -> L45
        r102.append(r213);     // Catch: Throwable -> L45
        r102.append(r112);     // Catch: Throwable -> L45
        r102.append(r110);     // Catch: Throwable -> L45
        r102.append(r112);     // Catch: Throwable -> L45
        r102.append(r310);     // Catch: Throwable -> L45
        r102.append(r112);     // Catch: Throwable -> L45
        String r103 = r112;
        r102.append(r311);     // Catch: Throwable -> L45
        r102.append(r216);     // Catch: Throwable -> L45
        String r104 = r215;
        com.obric.aiagent.ipc.utils.h.b(r104, r102.toString(), e);     // Catch: Throwable -> L45
        IPCException r105 = new IPCException(e);     // Catch: Throwable -> L45
        long r106 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L45
        long r107 = Math.max(0, r106 - r111) / 1000;     // Catch: Throwable -> L45
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L45
        com.obric.aiagent.ipc.utils.i.a(r104, r100 + r210 + r103 + r211 + r103 + r212 + r103 + r213 + r103 + r110 + r103 + r310 + r103 + r311 + ") = fail", r105, r107);     // Catch: Throwable -> L45
        IPCAnomalyTrace r109 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L45
        IPCAnomalyTrace.b("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet", r105, r107, r106);     // Catch: Throwable -> L45
        return;
    L4:
        if (this.log == false) goto L7;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L41 Throwable -> L45
        com.obric.aiagent.ipc.utils.h.a("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ", " + r110 + ", " + r310 + ", " + r311 + ")");     // Catch: Exception -> L41 Throwable -> L45
    L7:
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L41 Throwable -> L45
        com.obric.aiagent.ipc.utils.h.a("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ", " + r110 + ", " + r310 + ", " + r311 + ")");     // Catch: Exception -> L41 Throwable -> L45
    L9:
        r215 = "IFlowAppLogDataObserverIDLIPC";
        r216 = ")";
        this.origin.onRemoteIdGet(r210, r211, r212, r213, r214, r310, r311);     // Catch: Exception -> L39 Throwable -> L45
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.h.d(r215, "onRemoteIdGet = void");     // Catch: Exception -> L39 Throwable -> L45
    L14:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L39 Throwable -> L45
        long r116 = Math.max(0, r115 - r111) / 1000;     // Catch: Exception -> L39 Throwable -> L45
        int r117 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L39 Throwable -> L45
        r100 = "onRemoteIdGet(";
        StringBuilder r118 = new StringBuilder(r100);     // Catch: Exception -> L37 Throwable -> L45
        r118.append(r210);     // Catch: Exception -> L37 Throwable -> L45
        r118.append(", ");     // Catch: Exception -> L33 Throwable -> L45
        r118.append(r211);     // Catch: Exception -> L33 Throwable -> L45
        r118.append(", ");     // Catch: Exception -> L33 Throwable -> L45
        r118.append(r212);     // Catch: Exception -> L33 Throwable -> L45
        r118.append(", ");     // Catch: Exception -> L33 Throwable -> L45
        r118.append(r213);     // Catch: Exception -> L33 Throwable -> L45
        r118.append(", ");     // Catch: Exception -> L33 Throwable -> L45
        r118.append(r214);     // Catch: Exception -> L31 Throwable -> L45
        r118.append(", ");     // Catch: Exception -> L31 Throwable -> L45
        r118.append(r310);     // Catch: Exception -> L28 Throwable -> L45
        r118.append(", ");     // Catch: Exception -> L28 Throwable -> L45
        r118.append(r311);     // Catch: Exception -> L28 Throwable -> L45
        r118.append(") = void");     // Catch: Exception -> L28 Throwable -> L45
        com.obric.aiagent.ipc.utils.i.b(r215, r118.toString(), r116);     // Catch: Exception -> L28 Throwable -> L45
        r310 = r310;
        r112 = ", ";
        r215 = r215;
        r110 = r214;
        IPCAnomalyTrace.f384709a.c("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet", r116, r115);     // Catch: Exception -> L26 Throwable -> L45
        return;
    L26:
        e = e;
    L28:
        e = e;
        r310 = r310;
    L30:
        r112 = ", ";
        r215 = r215;
        r110 = r214;
    L31:
        e = e;
        r310 = r310;
    L33:
        e = e;
        r112 = ", ";
    L36:
        r110 = r214;
    L37:
        e = e;
        r310 = r310;
        r112 = ", ";
    L39:
        e = e;
        r100 = "onRemoteIdGet(";
        r112 = ", ";
    }
}
