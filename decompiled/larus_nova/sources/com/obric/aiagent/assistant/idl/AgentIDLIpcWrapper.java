package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class AgentIDLIpcWrapper implements IAgentIDL {
    boolean log;
    final IAgentIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentDMStateManagerIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getAgentDMStateManagerIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getAgentDMStateManagerIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getAgentDMStateManagerIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getAgentDMStateManagerIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getAgentDMStateManagerIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getAgentDMStateManagerIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getAgentDMStateManagerIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getAgentDMStateManagerIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getAgentDMStateManagerIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentNetworkIDL getAgentNetworkIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentNetworkIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getAgentNetworkIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getAgentNetworkIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getAgentNetworkIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getAgentNetworkIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getAgentNetworkIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getAgentNetworkIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getAgentNetworkIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getAgentNetworkIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getAgentNetworkIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAppIntentIDL getAppIntentIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentAppIntentIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getAppIntentIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getAppIntentIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getAppIntentIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getAppIntentIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getAppIntentIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getAppIntentIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getAppIntentIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getAppIntentIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getAppIntentIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAssistantStateIDL getAssistantStateIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentAssistantStateIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getAssistantStateIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getAssistantStateIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getAssistantStateIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getAssistantStateIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getAssistantStateIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getAssistantStateIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getAssistantStateIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getAssistantStateIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getAssistantStateIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IFileIDL getFileIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IFileIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getFileIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getFileIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getFileIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getFileIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getFileIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getFileIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getFileIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getFileIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getFileIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentMessageIDL getMessageIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentMessageIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getMessageIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getMessageIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getMessageIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getMessageIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getMessageIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getMessageIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getMessageIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getMessageIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getMessageIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IPlatformApiIDL getPlatformApiIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IPlatformApiIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getPlatformApiIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getPlatformApiIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getPlatformApiIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getPlatformApiIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getPlatformApiIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getPlatformApiIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getPlatformApiIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getPlatformApiIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getPlatformApiIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentPrivacyIDL getPrivacyIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentPrivacyIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getPrivacyIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getPrivacyIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getPrivacyIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getPrivacyIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getPrivacyIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getPrivacyIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getPrivacyIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getPrivacyIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getPrivacyIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSettingsIDL getSettingsIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentSettingsIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getSettingsIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getSettingsIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getSettingsIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getSettingsIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getSettingsIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getSettingsIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getSettingsIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getSettingsIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getSettingsIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSkillManagerIDL getSkillManagerIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentSkillManagerIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getSkillManagerIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getSkillManagerIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getSkillManagerIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getSkillManagerIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getSkillManagerIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getSkillManagerIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getSkillManagerIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getSkillManagerIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getSkillManagerIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentTaskAppIDL getTaskAppIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentTaskAppIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getTaskAppIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getTaskAppIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getTaskAppIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getTaskAppIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getTaskAppIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getTaskAppIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getTaskAppIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getTaskAppIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getTaskAppIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IAgentVoiceInteractionIDL r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "getVoiceInteractionIDL()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "getVoiceInteractionIDL() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentIDLIPC", "getVoiceInteractionIDL", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getVoiceInteractionIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "getVoiceInteractionIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getVoiceInteractionIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "getVoiceInteractionIDL = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "getVoiceInteractionIDL() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "getVoiceInteractionIDL", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public AgentIDLIpcWrapper(IAgentIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public void registerFlowIDL(IFlowIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentIDLIPC", "registerFlowIDL(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentIDLIPC", "registerFlowIDL(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentIDLIPC", "registerFlowIDL", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", "registerFlowIDL(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("registerFlowIDL(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IFlowIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof FlowIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof FlowIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IFlowIDL.Stub) == false) goto L19;
        r113 = c2.b((IFlowIDL.Stub) r210, true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = c2.c(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IFlowIDL r114 = r210;
    L35:
        r107.registerFlowIDL(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentIDLIPC", "registerFlowIDL = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentIDLIPC", "registerFlowIDL(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentIDLIPC", "registerFlowIDL", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r210 instanceof FlowIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof FlowIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IFlowIDL.Stub) == false) goto L33;
        r114 = c2.b((IFlowIDL.Stub) r210, true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = c2.c(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    public AgentIDLIpcWrapper(IAgentIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
