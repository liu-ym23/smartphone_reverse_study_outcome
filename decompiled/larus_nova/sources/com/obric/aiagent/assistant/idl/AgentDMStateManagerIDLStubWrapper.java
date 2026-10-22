package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class AgentDMStateManagerIDLStubWrapper extends IAgentDMStateManagerIDL.Stub {
    boolean log;
    final IAgentDMStateManagerIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public DMStateInfo getCurrentDMSteate() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AgentDMStateManagerIDLStub", "getCurrentDMSteate()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateManagerIDLStub", "getCurrentDMSteate() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentDMStateManagerIDLStub", "getCurrentDMSteate", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AgentDMStateManagerIDLStub", "getCurrentDMSteate()");     // Catch: Exception -> L11
    L6:
        DMStateInfo r112 = this.origin.getCurrentDMSteate();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentDMStateManagerIDLStub", "getCurrentDMSteate = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateManagerIDLStub", "getCurrentDMSteate() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentDMStateManagerIDLStub", "getCurrentDMSteate", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public AgentDMStateManagerIDLStubWrapper(IAgentDMStateManagerIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void registerDMStateListener(IAgentDMStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentDMStateManagerIDLStub", "registerDMStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IAgentDMStateManagerIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IAgentDMStateListenerIDL r112 = r210;
    L19:
        r106.registerDMStateListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("AgentDMStateManagerIDLStub", "registerDMStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("AgentDMStateManagerIDLStub", "registerDMStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof AgentDMStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof AgentDMStateListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IAgentDMStateListenerIDL.Stub) == false) goto L17;
        r112 = e.a((IAgentDMStateListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = e.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void unRegisterDMStateListener(IAgentDMStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentDMStateManagerIDLStub", "unRegisterDMStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IAgentDMStateManagerIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IAgentDMStateListenerIDL r112 = r210;
    L19:
        r106.unRegisterDMStateListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("AgentDMStateManagerIDLStub", "unRegisterDMStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("AgentDMStateManagerIDLStub", "unRegisterDMStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof AgentDMStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof AgentDMStateListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IAgentDMStateListenerIDL.Stub) == false) goto L17;
        r112 = e.a((IAgentDMStateListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = e.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    public AgentDMStateManagerIDLStubWrapper(IAgentDMStateManagerIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
