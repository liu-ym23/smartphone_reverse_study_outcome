package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J?\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r \u000f*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000e¨\u0006\u00010\f¨\u0006\u0001H\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \u000f*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentNetworkIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentNetworkIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentNetworkIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "notifyRequestStatus", "", "success", "", "params", "", "", "", "kotlin.jvm.PlatformType", "updateExcludeRules", com.heytap.mcssdk.constant.b.f276366p, "Lcom/obric/aiagent/assistant/idl/bean/RequestRestrictRule;", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentNetworkIDLStub extends IAgentNetworkIDL.Stub {
    private final /* synthetic */ IAgentNetworkIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void notifyRequestStatus(boolean r100, Map r101) {
        this.$$delegate_0.notifyRequestStatus(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void updateExcludeRules(RequestRestrictRule r100) {
        this.$$delegate_0.updateExcludeRules(r100);
    }

    public AgentNetworkIDLStub() {
        IAgentNetworkIDL r100 = (IAgentNetworkIDLSPI) ServiceManager.get().getService(IAgentNetworkIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAgentNetworkIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
