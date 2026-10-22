package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowOnAppStateChangedListenerIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowOnAppStateChangedListenerIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowOnAppStateChangedListenerIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onAllActivityDestroyed", "", "onAppBackground", "onAppForeground", "onMainBotChatPageResume", "resume", "", "isChatWindow", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowOnAppStateChangedListenerIDLStub extends IFlowOnAppStateChangedListenerIDL.Stub {
    private final /* synthetic */ IFlowOnAppStateChangedListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAllActivityDestroyed() {
        this.$$delegate_0.onAllActivityDestroyed();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppBackground() {
        this.$$delegate_0.onAppBackground();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppForeground() {
        this.$$delegate_0.onAppForeground();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onMainBotChatPageResume(boolean r100, boolean r101) {
        this.$$delegate_0.onMainBotChatPageResume(r100, r101);
    }

    public FlowOnAppStateChangedListenerIDLStub() {
        IFlowOnAppStateChangedListenerIDL r100 = (IFlowOnAppStateChangedListenerIDLSPI) ServiceManager.get().getService(IFlowOnAppStateChangedListenerIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowOnAppStateChangedListenerIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
