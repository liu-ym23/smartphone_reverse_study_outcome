package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes6.dex */
class AgentAssistantStateIDLStubWrapper extends IAgentAssistantStateIDL.Stub {
    boolean log;
    final IAgentAssistantStateIDL.Stub origin;

    public AgentAssistantStateIDLStubWrapper(IAgentAssistantStateIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public AgentAssistantStateIDLStubWrapper(IAgentAssistantStateIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
