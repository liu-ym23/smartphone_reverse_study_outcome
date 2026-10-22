package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentSkillManagerObserverIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentSkillManagerObserverIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentSkillManagerObserverIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onSkillListChanged", "", "version", "", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentSkillManagerObserverIDLStub extends IAgentSkillManagerObserverIDL.Stub {
    private final /* synthetic */ IAgentSkillManagerObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL
    public void onSkillListChanged(long r100) {
        this.$$delegate_0.onSkillListChanged(r100);
    }

    public AgentSkillManagerObserverIDLStub() {
        IAgentSkillManagerObserverIDL r100 = (IAgentSkillManagerObserverIDLSPI) ServiceManager.get().getService(IAgentSkillManagerObserverIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAgentSkillManagerObserverIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
