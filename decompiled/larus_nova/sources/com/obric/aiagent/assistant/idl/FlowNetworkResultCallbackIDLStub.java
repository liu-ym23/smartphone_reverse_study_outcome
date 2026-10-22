package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J?\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r \u000f*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000e¨\u0006\u00010\f¨\u0006\u0001H\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowNetworkResultCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowNetworkResultCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowNetworkResultCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onResult", "", "success", "", "params", "", "", "", "kotlin.jvm.PlatformType", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowNetworkResultCallbackIDLStub extends IFlowNetworkResultCallbackIDL.Stub {
    private final /* synthetic */ IFlowNetworkResultCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL
    public void onResult(boolean r100, Map r101) {
        this.$$delegate_0.onResult(r100, r101);
    }

    public FlowNetworkResultCallbackIDLStub() {
        IFlowNetworkResultCallbackIDL r100 = (IFlowNetworkResultCallbackIDLSPI) ServiceManager.get().getService(IFlowNetworkResultCallbackIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowNetworkResultCallbackIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
