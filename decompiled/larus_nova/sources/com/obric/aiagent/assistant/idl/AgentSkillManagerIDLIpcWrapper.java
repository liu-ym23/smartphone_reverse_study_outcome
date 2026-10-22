package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class AgentSkillManagerIDLIpcWrapper implements IAgentSkillManagerIDL {
    boolean log;
    final IAgentSkillManagerIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public long getSkillListVersion() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L17:
        e = e;
        long r110 = 0;
    L19:
        com.obric.aiagent.ipc.utils.h.b("IAgentSkillManagerIDLIPC", "getSkillListVersion()", e);     // Catch: Throwable -> L21
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L21
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.i.a("IAgentSkillManagerIDLIPC", "getSkillListVersion() = fail", r111, r101);     // Catch: Throwable -> L21
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L21
        IPCAnomalyTrace.b("IAgentSkillManagerIDLIPC", "getSkillListVersion", r111, r101, r112);     // Catch: Throwable -> L21
        return r110;
    L22:
        return r110;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "getSkillListVersion()");     // Catch: Exception -> L17 Throwable -> L23
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "getSkillListVersion()");     // Catch: Exception -> L17 Throwable -> L23
    L9:
        r110 = this.origin.getSkillListVersion();     // Catch: Exception -> L17 Throwable -> L23
    L15:
        e = e;
        goto L19
    L11:
        if (this.log == false) goto L13;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.h.d("IAgentSkillManagerIDLIPC", "getSkillListVersion = " + r110);     // Catch: Exception -> L15 Throwable -> L21
    L13:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L21
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L15 Throwable -> L21
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.i.b("IAgentSkillManagerIDLIPC", "getSkillListVersion() = " + r110, r115);     // Catch: Exception -> L15 Throwable -> L21
        IPCAnomalyTrace.f384709a.c("IAgentSkillManagerIDLIPC", "getSkillListVersion", r115, r114);     // Catch: Exception -> L15 Throwable -> L21
        return r110;
    L29:
        return 0;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public OSkillManagerConfig getSkillManagerConfig() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        OSkillManagerConfig r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentSkillManagerIDLIPC", "getSkillManagerConfig()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentSkillManagerIDLIPC", "getSkillManagerConfig", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getSkillManagerConfig();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentSkillManagerIDLIPC", "getSkillManagerConfig = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentSkillManagerIDLIPC", "getSkillManagerConfig() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentSkillManagerIDLIPC", "getSkillManagerConfig", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public List<OSkill> listSkills() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        List<OSkill> r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentSkillManagerIDLIPC", "listSkills()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentSkillManagerIDLIPC", "listSkills() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentSkillManagerIDLIPC", "listSkills", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "listSkills()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "listSkills()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.listSkills();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentSkillManagerIDLIPC", "listSkills = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentSkillManagerIDLIPC", "listSkills() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentSkillManagerIDLIPC", "listSkills", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public AgentSkillManagerIDLIpcWrapper(IAgentSkillManagerIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public String getSkillManagerStatus(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        String r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentSkillManagerIDLIPC", "getSkillManagerStatus", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getSkillManagerStatus(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentSkillManagerIDLIPC", "getSkillManagerStatus = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentSkillManagerIDLIPC", "getSkillManagerStatus", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public void registerSkillObserver(IAgentSkillManagerObserverIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentSkillManagerIDLIPC", "registerSkillObserver(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentSkillManagerIDLIPC", "registerSkillObserver(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentSkillManagerIDLIPC", "registerSkillObserver", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "registerSkillObserver(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("registerSkillObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IAgentSkillManagerObserverIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof AgentSkillManagerObserverIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof AgentSkillManagerObserverIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IAgentSkillManagerObserverIDL.Stub) == false) goto L19;
        r113 = q.a((IAgentSkillManagerObserverIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = q.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentSkillManagerIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IAgentSkillManagerObserverIDL r114 = r210;
    L35:
        r107.registerSkillObserver(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentSkillManagerIDLIPC", "registerSkillObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentSkillManagerIDLIPC", "registerSkillObserver(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentSkillManagerIDLIPC", "registerSkillObserver", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r210 instanceof AgentSkillManagerObserverIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof AgentSkillManagerObserverIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IAgentSkillManagerObserverIDL.Stub) == false) goto L33;
        r114 = q.a((IAgentSkillManagerObserverIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = q.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public boolean setSkillManagerConfigValues(Bundle r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.setSkillManagerConfigValues(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public AgentSkillManagerIDLIpcWrapper(IAgentSkillManagerIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
