package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\bH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\b2\u000e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AssistantInteractionListenerIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onAssistantDied", "", "onAssistantTakeOver", "onPanelCancel", "onPanelHeightChanged", "height", "", "onPanelShow", "onReply", "content", "", "kotlin.jvm.PlatformType", "requestToShowInputPanel", "requestToShowInputPanelWithMeta", "meta", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AssistantInteractionListenerIDLStub extends IAssistantInteractionListenerIDL.Stub {
    private final /* synthetic */ IAssistantInteractionListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantDied() {
        this.$$delegate_0.onAssistantDied();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantTakeOver() {
        this.$$delegate_0.onAssistantTakeOver();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelCancel() {
        this.$$delegate_0.onPanelCancel();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelHeightChanged(int r100) {
        this.$$delegate_0.onPanelHeightChanged(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelShow(int r100) {
        this.$$delegate_0.onPanelShow(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onReply(String r100) {
        this.$$delegate_0.onReply(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanel() {
        this.$$delegate_0.requestToShowInputPanel();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanelWithMeta(String r100) {
        this.$$delegate_0.requestToShowInputPanelWithMeta(r100);
    }

    public AssistantInteractionListenerIDLStub() {
        IAssistantInteractionListenerIDL r100 = (IAssistantInteractionListenerIDLSPI) ServiceManager.get().getService(IAssistantInteractionListenerIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAssistantInteractionListenerIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
