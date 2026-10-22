package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010\f\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowStreamObserverIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowStreamObserverIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowStreamObserverIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onStreamBegin", "", "message", "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "kotlin.jvm.PlatformType", "onStreamEnd", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowStreamObserverIDLStub extends IFlowStreamObserverIDL.Stub {
    private final /* synthetic */ IFlowStreamObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
    public void onStreamBegin(IMMessage r100) {
        this.$$delegate_0.onStreamBegin(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
    public void onStreamEnd(IMMessage r100) {
        this.$$delegate_0.onStreamEnd(r100);
    }

    public FlowStreamObserverIDLStub() {
        IFlowStreamObserverIDL r100 = (IFlowStreamObserverIDLSPI) ServiceManager.get().getService(IFlowStreamObserverIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowStreamObserverIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
