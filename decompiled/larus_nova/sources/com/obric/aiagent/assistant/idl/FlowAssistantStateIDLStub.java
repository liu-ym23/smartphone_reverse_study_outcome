package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0019\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowAssistantStateIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantStateIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantStateIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getCurrentNightMode", "", "isActive", "", "isBackgroundIntercepting", "registerActiveStateListener", "", "listener", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantActiveStateListenerIDL;", "kotlin.jvm.PlatformType", "registerBackgroundInterceptingListener", "Lcom/obric/aiagent/assistant/idl/IFlowBackgroundInterceptStateListenerIDL;", "registerNightModeListener", "Lcom/obric/aiagent/assistant/idl/IFlowNightModeChangeListenerIDL;", "registerTTSStateListener", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantTTSStateListenerIDL;", "unregisterActiveStateListener", "unregisterBackgroundInterceptingListener", "unregisterNightModeListener", "unregisterTTSStateListener", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowAssistantStateIDLStub extends IFlowAssistantStateIDL.Stub {
    private final /* synthetic */ IFlowAssistantStateIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public int getCurrentNightMode() {
        return this.$$delegate_0.getCurrentNightMode();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isActive() {
        return this.$$delegate_0.isActive();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isBackgroundIntercepting() {
        return this.$$delegate_0.isBackgroundIntercepting();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r100) {
        this.$$delegate_0.registerActiveStateListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r100) {
        this.$$delegate_0.registerBackgroundInterceptingListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerNightModeListener(IFlowNightModeChangeListenerIDL r100) {
        this.$$delegate_0.registerNightModeListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r100) {
        this.$$delegate_0.registerTTSStateListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r100) {
        this.$$delegate_0.unregisterActiveStateListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r100) {
        this.$$delegate_0.unregisterBackgroundInterceptingListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r100) {
        this.$$delegate_0.unregisterNightModeListener(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r100) {
        this.$$delegate_0.unregisterTTSStateListener(r100);
    }

    public FlowAssistantStateIDLStub() {
        IFlowAssistantStateIDL r100 = (IFlowAssistantStateIDLSPI) ServiceManager.get().getService(IFlowAssistantStateIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowAssistantStateIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
