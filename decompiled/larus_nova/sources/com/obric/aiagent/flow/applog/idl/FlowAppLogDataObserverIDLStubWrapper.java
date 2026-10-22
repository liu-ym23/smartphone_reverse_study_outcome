package com.obric.aiagent.flow.applog.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class FlowAppLogDataObserverIDLStubWrapper extends IFlowAppLogDataObserverIDL.Stub {
    boolean log;
    final IFlowAppLogDataObserverIDL.Stub origin;

    public FlowAppLogDataObserverIDLStubWrapper(IFlowAppLogDataObserverIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public FlowAppLogDataObserverIDLStubWrapper(IFlowAppLogDataObserverIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onIdLoaded(String r210, String r211, String r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogDataObserverIDLStub", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogDataObserverIDLStub", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogDataObserverIDLStub", "onIdLoaded", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogDataObserverIDLStub", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onIdLoaded(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogDataObserverIDLStub", "onIdLoaded = void");     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogDataObserverIDLStub", "onIdLoaded(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogDataObserverIDLStub", "onIdLoaded", r111, r214);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onRemoteIdGet(boolean r210, String r211, String r212, String r213, String r214, String r310, String r311) throws RemoteException {
        String r110 = r214;
        long r111 = SystemClock.elapsedRealtimeNanos();
    L38:
        e = e;
        String r100 = "onRemoteIdGet(";
        String r215 = "FlowAppLogDataObserverIDLStub";
        String r216 = ")";
        r310 = r310;
        String r112 = ", ";
    L40:
        int r101 = com.obric.aiagent.ipc.utils.h.f384747a;
        StringBuilder r102 = new StringBuilder(r100);
        r102.append(r210);
        r102.append(r112);
        r102.append(r211);
        r102.append(r112);
        r102.append(r212);
        r102.append(r112);
        r102.append(r213);
        r102.append(r112);
        r102.append(r110);
        r102.append(r112);
        r102.append(r310);
        r102.append(r112);
        String r103 = r112;
        r102.append(r311);
        r102.append(r216);
        String r104 = r215;
        com.obric.aiagent.ipc.utils.h.b(r104, r102.toString(), e);
        IPCException r105 = new IPCException(e);
        long r106 = SystemClock.elapsedRealtimeNanos();
        long r107 = Math.max(0, r106 - r111) / 1000;
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r104, r100 + r210 + r103 + r211 + r103 + r212 + r103 + r213 + r103 + r110 + r103 + r310 + r103 + r311 + ") = fail", r105, r107);
        IPCAnomalyTrace r109 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogDataObserverIDLStub", "onRemoteIdGet", r105, r107, r106);
        throw r105;
    L4:
        if (this.log == false) goto L6;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L38
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogDataObserverIDLStub", "onRemoteIdGet(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ", " + r110 + ", " + r310 + ", " + r311 + ")");     // Catch: Exception -> L38
    L6:
        r215 = "FlowAppLogDataObserverIDLStub";
        r216 = ")";
        this.origin.onRemoteIdGet(r210, r211, r212, r213, r214, r310, r311);     // Catch: Exception -> L36
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.h.d(r215, "onRemoteIdGet = void");     // Catch: Exception -> L36
    L11:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L36
        long r115 = Math.max(0, r114 - r111) / 1000;     // Catch: Exception -> L36
        int r116 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L36
        r100 = "onRemoteIdGet(";
        StringBuilder r117 = new StringBuilder(r100);     // Catch: Exception -> L34
        r117.append(r210);     // Catch: Exception -> L34
        r117.append(", ");     // Catch: Exception -> L30
        r117.append(r211);     // Catch: Exception -> L30
        r117.append(", ");     // Catch: Exception -> L30
        r117.append(r212);     // Catch: Exception -> L30
        r117.append(", ");     // Catch: Exception -> L30
        r117.append(r213);     // Catch: Exception -> L30
        r117.append(", ");     // Catch: Exception -> L30
        r117.append(r214);     // Catch: Exception -> L28
        r117.append(", ");     // Catch: Exception -> L28
        r117.append(r310);     // Catch: Exception -> L25
        r117.append(", ");     // Catch: Exception -> L25
        r117.append(r311);     // Catch: Exception -> L25
        r117.append(") = void");     // Catch: Exception -> L25
        com.obric.aiagent.ipc.utils.i.d(r215, r117.toString(), r115);     // Catch: Exception -> L25
        r310 = r310;
        r112 = ", ";
        r215 = r215;
        r110 = r214;
        IPCAnomalyTrace.f384709a.e("FlowAppLogDataObserverIDLStub", "onRemoteIdGet", r115, r114);     // Catch: Exception -> L23
        return;
    L23:
        e = e;
    L25:
        e = e;
        r310 = r310;
    L27:
        r112 = ", ";
        r215 = r215;
        r110 = r214;
    L28:
        e = e;
        r310 = r310;
    L30:
        e = e;
        r112 = ", ";
    L33:
        r110 = r214;
    L34:
        e = e;
        r310 = r310;
        r112 = ", ";
    L36:
        e = e;
        r100 = "onRemoteIdGet(";
        r112 = ", ";
        goto L33
    }
}
