package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class AgentDMStateListenerIDLStubWrapper extends IAgentDMStateListenerIDL.Stub {
    boolean log;
    final IAgentDMStateListenerIDL.Stub origin;

    public AgentDMStateListenerIDLStubWrapper(IAgentDMStateListenerIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onDMStateChanged(DMStateInfo r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentDMStateListenerIDLStub", "onDMStateChanged(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateListenerIDLStub", "onDMStateChanged(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentDMStateListenerIDLStub", "onDMStateChanged", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentDMStateListenerIDLStub", "onDMStateChanged(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onDMStateChanged(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentDMStateListenerIDLStub", "onDMStateChanged = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateListenerIDLStub", "onDMStateChanged(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentDMStateListenerIDLStub", "onDMStateChanged", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskAdded(DMTaskInfo r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentDMStateListenerIDLStub", "onTaskAdded(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateListenerIDLStub", "onTaskAdded(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentDMStateListenerIDLStub", "onTaskAdded", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentDMStateListenerIDLStub", "onTaskAdded(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onTaskAdded(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentDMStateListenerIDLStub", "onTaskAdded = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateListenerIDLStub", "onTaskAdded(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentDMStateListenerIDLStub", "onTaskAdded", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskEnd(DMTaskInfo r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentDMStateListenerIDLStub", "onTaskEnd(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateListenerIDLStub", "onTaskEnd(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentDMStateListenerIDLStub", "onTaskEnd", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentDMStateListenerIDLStub", "onTaskEnd(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onTaskEnd(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentDMStateListenerIDLStub", "onTaskEnd = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateListenerIDLStub", "onTaskEnd(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentDMStateListenerIDLStub", "onTaskEnd", r113, r112);     // Catch: Exception -> L11
    }

    public AgentDMStateListenerIDLStubWrapper(IAgentDMStateListenerIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskStateChanged(DMTaskInfo r210, DMTaskState r211, DMTaskState r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentDMStateListenerIDLStub", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateListenerIDLStub", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentDMStateListenerIDLStub", "onTaskStateChanged", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentDMStateListenerIDLStub", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onTaskStateChanged(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentDMStateListenerIDLStub", "onTaskStateChanged = void");     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateListenerIDLStub", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentDMStateListenerIDLStub", "onTaskStateChanged", r111, r214);     // Catch: Exception -> L11
    }
}
