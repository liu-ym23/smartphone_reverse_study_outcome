package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class AgentSkillManagerIDLStubWrapper extends IAgentSkillManagerIDL.Stub {
    boolean log;
    final IAgentSkillManagerIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public long getSkillListVersion() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AgentSkillManagerIDLStub", "getSkillListVersion()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "getSkillListVersion() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "getSkillListVersion", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AgentSkillManagerIDLStub", "getSkillListVersion()");     // Catch: Exception -> L11
    L6:
        long r112 = this.origin.getSkillListVersion();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentSkillManagerIDLStub", "getSkillListVersion = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "getSkillListVersion() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentSkillManagerIDLStub", "getSkillListVersion", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public OSkillManagerConfig getSkillManagerConfig() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AgentSkillManagerIDLStub", "getSkillManagerConfig()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "getSkillManagerConfig() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "getSkillManagerConfig", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AgentSkillManagerIDLStub", "getSkillManagerConfig()");     // Catch: Exception -> L11
    L6:
        OSkillManagerConfig r112 = this.origin.getSkillManagerConfig();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentSkillManagerIDLStub", "getSkillManagerConfig = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "getSkillManagerConfig() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentSkillManagerIDLStub", "getSkillManagerConfig", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public List<OSkill> listSkills() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AgentSkillManagerIDLStub", "listSkills()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "listSkills() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "listSkills", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AgentSkillManagerIDLStub", "listSkills()");     // Catch: Exception -> L11
    L6:
        List<OSkill> r112 = this.origin.listSkills();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentSkillManagerIDLStub", "listSkills = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "listSkills() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentSkillManagerIDLStub", "listSkills", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public AgentSkillManagerIDLStubWrapper(IAgentSkillManagerIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public String getSkillManagerStatus(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "getSkillManagerStatus", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        String r113 = this.origin.getSkillManagerStatus(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentSkillManagerIDLStub", "getSkillManagerStatus = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentSkillManagerIDLStub", "getSkillManagerStatus", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public void registerSkillObserver(IAgentSkillManagerObserverIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentSkillManagerIDLStub", "registerSkillObserver(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "registerSkillObserver(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "registerSkillObserver", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("AgentSkillManagerIDLStub", "registerSkillObserver(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IAgentSkillManagerIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IAgentSkillManagerObserverIDL r112 = r210;
    L19:
        r106.registerSkillObserver(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("AgentSkillManagerIDLStub", "registerSkillObserver = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "registerSkillObserver(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("AgentSkillManagerIDLStub", "registerSkillObserver", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof AgentSkillManagerObserverIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof AgentSkillManagerObserverIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IAgentSkillManagerObserverIDL.Stub) == false) goto L17;
        r112 = q.a((IAgentSkillManagerObserverIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = q.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public boolean setSkillManagerConfigValues(Bundle r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "setSkillManagerConfigValues", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.setSkillManagerConfigValues(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentSkillManagerIDLStub", "setSkillManagerConfigValues = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentSkillManagerIDLStub", "setSkillManagerConfigValues", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    public AgentSkillManagerIDLStubWrapper(IAgentSkillManagerIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
