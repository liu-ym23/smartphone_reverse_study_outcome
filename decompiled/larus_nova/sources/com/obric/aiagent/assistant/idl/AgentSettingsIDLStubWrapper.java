package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class AgentSettingsIDLStubWrapper extends IAgentSettingsIDL.Stub {
    boolean log;
    final IAgentSettingsIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isAutoGuiInstall() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AgentSettingsIDLStub", "isAutoGuiInstall()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSettingsIDLStub", "isAutoGuiInstall() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSettingsIDLStub", "isAutoGuiInstall", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AgentSettingsIDLStub", "isAutoGuiInstall()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isAutoGuiInstall();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentSettingsIDLStub", "isAutoGuiInstall = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSettingsIDLStub", "isAutoGuiInstall() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentSettingsIDLStub", "isAutoGuiInstall", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isMemoryRecommendActivityEnabled() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isMemoryRecommendActivityEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public AgentSettingsIDLStubWrapper(IAgentSettingsIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public AgentSettingsIDLStubWrapper(IAgentSettingsIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public void setSystemProperty(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentSettingsIDLStub", "setSystemProperty(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentSettingsIDLStub", "setSystemProperty(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSettingsIDLStub", "setSystemProperty", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentSettingsIDLStub", "setSystemProperty(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setSystemProperty(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentSettingsIDLStub", "setSystemProperty = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSettingsIDLStub", "setSystemProperty(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentSettingsIDLStub", "setSystemProperty", r113, r112);     // Catch: Exception -> L11
    }
}
