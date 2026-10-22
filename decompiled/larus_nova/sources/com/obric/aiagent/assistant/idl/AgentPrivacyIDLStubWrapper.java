package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class AgentPrivacyIDLStubWrapper extends IAgentPrivacyIDL.Stub {
    boolean log;
    final IAgentPrivacyIDL.Stub origin;

    public AgentPrivacyIDLStubWrapper(IAgentPrivacyIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public AgentPrivacyIDLStubWrapper(IAgentPrivacyIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentPrivacyIDL
    public String getPemCertChain(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentPrivacyIDLStub", "getPemCertChain(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentPrivacyIDLStub", "getPemCertChain(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentPrivacyIDLStub", "getPemCertChain", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentPrivacyIDLStub", "getPemCertChain(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        String r113 = this.origin.getPemCertChain(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentPrivacyIDLStub", "getPemCertChain = " + r113);     // Catch: Exception -> L11
    L9:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r212 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentPrivacyIDLStub", "getPemCertChain(" + r210 + ", " + r211 + ") = " + r113, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentPrivacyIDLStub", "getPemCertChain", r115, r212);     // Catch: Exception -> L11
        return r113;
    }
}
