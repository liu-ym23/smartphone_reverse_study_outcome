package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentAssistantStateIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentAssistantStateIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentAssistantStateIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentAssistantStateIDLStub extends IAgentAssistantStateIDL.Stub {
    private final /* synthetic */ IAgentAssistantStateIDL $$delegate_0;

    public AgentAssistantStateIDLStub() {
        IAgentAssistantStateIDL r100 = (IAgentAssistantStateIDLSPI) ServiceManager.get().getService(IAgentAssistantStateIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAgentAssistantStateIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAssistantStateIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
