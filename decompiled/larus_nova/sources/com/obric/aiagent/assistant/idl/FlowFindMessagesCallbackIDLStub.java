package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J5\u0010\t\u001a\u00020\b2*\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000e0\u000bH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowFindMessagesCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowFindMessagesCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowFindMessagesCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onFail", "", "onSuccess", "message", "", "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "kotlin.jvm.PlatformType", "", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowFindMessagesCallbackIDLStub extends IFlowFindMessagesCallbackIDL.Stub {
    private final /* synthetic */ IFlowFindMessagesCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL
    public void onFail() {
        this.$$delegate_0.onFail();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL
    public void onSuccess(List<IMMessage> r100) {
        this.$$delegate_0.onSuccess(r100);
    }

    public FlowFindMessagesCallbackIDLStub() {
        IFlowFindMessagesCallbackIDL r100 = (IFlowFindMessagesCallbackIDLSPI) ServiceManager.get().getService(IFlowFindMessagesCallbackIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowFindMessagesCallbackIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
