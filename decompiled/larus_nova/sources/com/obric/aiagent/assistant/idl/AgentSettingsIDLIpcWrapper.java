package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class AgentSettingsIDLIpcWrapper implements IAgentSettingsIDL {
    boolean log;
    final IAgentSettingsIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isAutoGuiInstall() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentSettingsIDLIPC", "isAutoGuiInstall()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentSettingsIDLIPC", "isAutoGuiInstall() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentSettingsIDLIPC", "isAutoGuiInstall", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentSettingsIDLIPC", "isAutoGuiInstall()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentSettingsIDLIPC", "isAutoGuiInstall()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isAutoGuiInstall();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentSettingsIDLIPC", "isAutoGuiInstall = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentSettingsIDLIPC", "isAutoGuiInstall() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentSettingsIDLIPC", "isAutoGuiInstall", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isMemoryRecommendActivityEnabled() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isMemoryRecommendActivityEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public AgentSettingsIDLIpcWrapper(IAgentSettingsIDL r100) throws RemoteException {
        this(r100, true);
    }

    public AgentSettingsIDLIpcWrapper(IAgentSettingsIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public void setSystemProperty(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentSettingsIDLIPC", "setSystemProperty(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentSettingsIDLIPC", "setSystemProperty(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentSettingsIDLIPC", "setSystemProperty", r101, r102, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentSettingsIDLIPC", "setSystemProperty(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentSettingsIDLIPC", "setSystemProperty(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setSystemProperty(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentSettingsIDLIPC", "setSystemProperty = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentSettingsIDLIPC", "setSystemProperty(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentSettingsIDLIPC", "setSystemProperty", r113, r112);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
