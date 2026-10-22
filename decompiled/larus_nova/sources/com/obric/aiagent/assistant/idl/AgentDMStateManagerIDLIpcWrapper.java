package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class AgentDMStateManagerIDLIpcWrapper implements IAgentDMStateManagerIDL {
    boolean log;
    final IAgentDMStateManagerIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public DMStateInfo getCurrentDMSteate() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        DMStateInfo r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getCurrentDMSteate();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public AgentDMStateManagerIDLIpcWrapper(IAgentDMStateManagerIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void registerDMStateListener(IAgentDMStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentDMStateManagerIDLIPC", "registerDMStateListener(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentDMStateManagerIDLIPC", "registerDMStateListener(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentDMStateManagerIDLIPC", "registerDMStateListener", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateManagerIDLIPC", "registerDMStateListener(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("registerDMStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IAgentDMStateListenerIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateManagerIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof AgentDMStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof AgentDMStateListenerIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IAgentDMStateListenerIDL.Stub) == false) goto L19;
        r113 = e.a((IAgentDMStateListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = e.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentDMStateManagerIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IAgentDMStateListenerIDL r114 = r210;
    L35:
        r107.registerDMStateListener(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentDMStateManagerIDLIPC", "registerDMStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentDMStateManagerIDLIPC", "registerDMStateListener(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentDMStateManagerIDLIPC", "registerDMStateListener", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r210 instanceof AgentDMStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof AgentDMStateListenerIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IAgentDMStateListenerIDL.Stub) == false) goto L33;
        r114 = e.a((IAgentDMStateListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = e.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void unRegisterDMStateListener(IAgentDMStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("unRegisterDMStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IAgentDMStateListenerIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentDMStateManagerIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof AgentDMStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof AgentDMStateListenerIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IAgentDMStateListenerIDL.Stub) == false) goto L19;
        r113 = e.a((IAgentDMStateListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = e.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentDMStateManagerIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IAgentDMStateListenerIDL r114 = r210;
    L35:
        r107.unRegisterDMStateListener(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r210 instanceof AgentDMStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof AgentDMStateListenerIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IAgentDMStateListenerIDL.Stub) == false) goto L33;
        r114 = e.a((IAgentDMStateListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = e.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    public AgentDMStateManagerIDLIpcWrapper(IAgentDMStateManagerIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
