package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0011\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\rH\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\rH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentDMStateManagerIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateManagerIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateManagerIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getCurrentDMSteate", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "kotlin.jvm.PlatformType", "registerDMStateListener", "", "listener", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL;", "unRegisterDMStateListener", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentDMStateManagerIDLStub extends IAgentDMStateManagerIDL.Stub {
    private final /* synthetic */ IAgentDMStateManagerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public DMStateInfo getCurrentDMSteate() {
        return this.$$delegate_0.getCurrentDMSteate();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void registerDMStateListener(IAgentDMStateListenerIDL r100) {
        this.$$delegate_0.registerDMStateListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void unRegisterDMStateListener(IAgentDMStateListenerIDL r100) {
        this.$$delegate_0.unRegisterDMStateListener(r100);
    }

    public AgentDMStateManagerIDLStub() {
        IAgentDMStateManagerIDL r100 = (IAgentDMStateManagerIDLSPI) ServiceManager.get().getService(IAgentDMStateManagerIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAgentDMStateManagerIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
