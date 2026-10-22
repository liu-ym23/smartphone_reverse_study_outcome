package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016Jm\u0010\u0007\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n¨\u0006\u00010\b¨\u0006\u00012,\u0010\f\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n¨\u0006\u00010\b¨\u0006\u00012\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0011\u0010\u000f\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowSendMessageExtCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowSendMessageExtCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowSendMessageExtCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getExt", "", "", "", "kotlin.jvm.PlatformType", "originExt", "content", "", "getScene", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowSendMessageExtCallbackIDLStub extends IFlowSendMessageExtCallbackIDL.Stub {
    private final /* synthetic */ IFlowSendMessageExtCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public Map getExt(Map r100, String r101) {
        return this.$$delegate_0.getExt(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public String getScene() {
        return this.$$delegate_0.getScene();
    }

    public FlowSendMessageExtCallbackIDLStub() {
        IFlowSendMessageExtCallbackIDL r100 = (IFlowSendMessageExtCallbackIDLSPI) ServiceManager.get().getService(IFlowSendMessageExtCallbackIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowSendMessageExtCallbackIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
