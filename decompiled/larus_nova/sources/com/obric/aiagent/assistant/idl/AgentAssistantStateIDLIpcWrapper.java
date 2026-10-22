package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
class AgentAssistantStateIDLIpcWrapper implements IAgentAssistantStateIDL {
    boolean log;
    final IAgentAssistantStateIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public AgentAssistantStateIDLIpcWrapper(IAgentAssistantStateIDL r100) throws RemoteException {
        this(r100, true);
    }

    public AgentAssistantStateIDLIpcWrapper(IAgentAssistantStateIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
