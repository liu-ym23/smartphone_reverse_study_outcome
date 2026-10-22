package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0011\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowAppStateIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowAppStateIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowAppStateIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getCurrentActivity", "", "kotlin.jvm.PlatformType", "isAppBackground", "", "isAppPaused", "registerAppStateListener", "", "listener", "Lcom/obric/aiagent/assistant/idl/IFlowOnAppStateChangedListenerIDL;", "unregisterAppStateListener", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowAppStateIDLStub extends IFlowAppStateIDL.Stub {
    private final /* synthetic */ IFlowAppStateIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public String getCurrentActivity() {
        return this.$$delegate_0.getCurrentActivity();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppBackground() {
        return this.$$delegate_0.isAppBackground();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppPaused() {
        return this.$$delegate_0.isAppPaused();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r100) {
        this.$$delegate_0.registerAppStateListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r100) {
        this.$$delegate_0.unregisterAppStateListener(r100);
    }

    public FlowAppStateIDLStub() {
        IFlowAppStateIDL r100 = (IFlowAppStateIDLSPI) ServiceManager.get().getService(IFlowAppStateIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowAppStateIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
