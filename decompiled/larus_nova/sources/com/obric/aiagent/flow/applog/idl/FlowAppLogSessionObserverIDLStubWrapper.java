package com.obric.aiagent.flow.applog.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class FlowAppLogSessionObserverIDLStubWrapper extends IFlowAppLogSessionObserverIDL.Stub {
    boolean log;
    final IFlowAppLogSessionObserverIDL.Stub origin;

    public FlowAppLogSessionObserverIDLStubWrapper(IFlowAppLogSessionObserverIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public FlowAppLogSessionObserverIDLStubWrapper(IFlowAppLogSessionObserverIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionBatchEvent(long r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r212 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r212 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent", r101, r102, r212);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionBatchEvent(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent = void");     // Catch: Exception -> L11
    L9:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r210 + ", " + r211 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent", r111, r213);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionStart(long r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r212 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r212 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogSessionObserverIDLStub", "onSessionStart", r101, r102, r212);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionStart(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogSessionObserverIDLStub", "onSessionStart = void");     // Catch: Exception -> L11
    L9:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r210 + ", " + r211 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogSessionObserverIDLStub", "onSessionStart", r111, r213);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionTerminate(long r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r212 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r212 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogSessionObserverIDLStub", "onSessionTerminate", r101, r102, r212);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionTerminate(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogSessionObserverIDLStub", "onSessionTerminate = void");     // Catch: Exception -> L11
    L9:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r210 + ", " + r211 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogSessionObserverIDLStub", "onSessionTerminate", r111, r213);     // Catch: Exception -> L11
    }
}
