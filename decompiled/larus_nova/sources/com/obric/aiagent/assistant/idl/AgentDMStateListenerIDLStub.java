package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010\f\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J9\u0010\u0010\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0013\u001a\n \u000b*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentDMStateListenerIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onDMStateChanged", "", "dmState", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "kotlin.jvm.PlatformType", "onTaskAdded", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "onTaskEnd", "onTaskStateChanged", "previousState", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "newState", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentDMStateListenerIDLStub extends IAgentDMStateListenerIDL.Stub {
    private final /* synthetic */ IAgentDMStateListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onDMStateChanged(DMStateInfo r100) {
        this.$$delegate_0.onDMStateChanged(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskAdded(DMTaskInfo r100) {
        this.$$delegate_0.onTaskAdded(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskEnd(DMTaskInfo r100) {
        this.$$delegate_0.onTaskEnd(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskStateChanged(DMTaskInfo r100, DMTaskState r101, DMTaskState r102) {
        this.$$delegate_0.onTaskStateChanged(r100, r101, r102);
    }

    public AgentDMStateListenerIDLStub() {
        IAgentDMStateListenerIDL r100 = (IAgentDMStateListenerIDLSPI) ServiceManager.get().getService(IAgentDMStateListenerIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAgentDMStateListenerIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
