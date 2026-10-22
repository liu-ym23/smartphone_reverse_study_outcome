package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class AgentDMStateListenerIDLIpcWrapper implements IAgentDMStateListenerIDL {
    boolean log;
    final IAgentDMStateListenerIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public AgentDMStateListenerIDLIpcWrapper(IAgentDMStateListenerIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onDMStateChanged(DMStateInfo r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentDMStateListenerIDLIPC", "onDMStateChanged(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentDMStateListenerIDLIPC", "onDMStateChanged(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentDMStateListenerIDLIPC", "onDMStateChanged", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateListenerIDLIPC", "onDMStateChanged(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateListenerIDLIPC", "onDMStateChanged(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onDMStateChanged(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentDMStateListenerIDLIPC", "onDMStateChanged = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentDMStateListenerIDLIPC", "onDMStateChanged(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentDMStateListenerIDLIPC", "onDMStateChanged", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskAdded(DMTaskInfo r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentDMStateListenerIDLIPC", "onTaskAdded(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentDMStateListenerIDLIPC", "onTaskAdded(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentDMStateListenerIDLIPC", "onTaskAdded", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateListenerIDLIPC", "onTaskAdded(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateListenerIDLIPC", "onTaskAdded(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onTaskAdded(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentDMStateListenerIDLIPC", "onTaskAdded = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentDMStateListenerIDLIPC", "onTaskAdded(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentDMStateListenerIDLIPC", "onTaskAdded", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskEnd(DMTaskInfo r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentDMStateListenerIDLIPC", "onTaskEnd(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentDMStateListenerIDLIPC", "onTaskEnd(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentDMStateListenerIDLIPC", "onTaskEnd", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateListenerIDLIPC", "onTaskEnd(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateListenerIDLIPC", "onTaskEnd(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onTaskEnd(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentDMStateListenerIDLIPC", "onTaskEnd = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentDMStateListenerIDLIPC", "onTaskEnd(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentDMStateListenerIDLIPC", "onTaskEnd", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public AgentDMStateListenerIDLIpcWrapper(IAgentDMStateListenerIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskStateChanged(DMTaskInfo r210, DMTaskState r211, DMTaskState r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentDMStateListenerIDLIPC", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r213 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentDMStateListenerIDLIPC", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentDMStateListenerIDLIPC", "onTaskStateChanged", r101, r102, r213);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateListenerIDLIPC", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateListenerIDLIPC", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onTaskStateChanged(r210, r211, r212);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentDMStateListenerIDLIPC", "onTaskStateChanged = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentDMStateListenerIDLIPC", "onTaskStateChanged(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentDMStateListenerIDLIPC", "onTaskStateChanged", r111, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
