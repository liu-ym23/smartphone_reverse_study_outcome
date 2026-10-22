package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\f2\u000e\u0010\u0011\u001a\n \u000f*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\f2\u000e\u0010\u0016\u001a\n \u000f*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\b2\u000e\u0010\u0019\u001a\n \u000f*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\b2\u000e\u0010\u0019\u001a\n \u000f*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001J7\u0010\u001f\u001a\u00020\f2,\u0010 \u001a(\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\" \u000f*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010#¨\u0006\u00010!¨\u0006\u0001H\u0096\u0001J\u0019\u0010$\u001a\u00020\f2\u000e\u0010%\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010&\u001a\u00020\f2\u000e\u0010'\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001¨\u0006("}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowVoiceInteractionIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowVoiceInteractionIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowVoiceInteractionIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "closeContinuousTalk", "", "isInRealtimeCalling", "isInteractionSessionStateListening", "readContent", "", "content", "", "kotlin.jvm.PlatformType", "readContentByMessage", "message", "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "replayMessageTts", "messageId", "requireSyncData", "callback", "Lcom/obric/aiagent/assistant/idl/IFlowSyncDataResultIDL;", "tryInterruptAssistant", "event", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "tryOpenClickTalk", "type", "", "tryOpenMicToRecording", "updateIntentExt", "ext", "", "", "", "updateScreenshotForAsr", "tosKey", "wakeupAssistant", "requestFrom", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowVoiceInteractionIDLStub extends IFlowVoiceInteractionIDL.Stub {
    private final /* synthetic */ IFlowVoiceInteractionIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean closeContinuousTalk() {
        return this.$$delegate_0.closeContinuousTalk();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean isInRealtimeCalling() {
        return this.$$delegate_0.isInRealtimeCalling();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean isInteractionSessionStateListening() {
        return this.$$delegate_0.isInteractionSessionStateListening();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void readContent(String r100) {
        this.$$delegate_0.readContent(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void readContentByMessage(IMMessage r100) {
        this.$$delegate_0.readContentByMessage(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void replayMessageTts(String r100) {
        this.$$delegate_0.replayMessageTts(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void requireSyncData(IFlowSyncDataResultIDL r100) {
        this.$$delegate_0.requireSyncData(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean tryInterruptAssistant(AppEvent r100) {
        return this.$$delegate_0.tryInterruptAssistant(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void tryOpenClickTalk(int r100) {
        this.$$delegate_0.tryOpenClickTalk(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean tryOpenMicToRecording(AppEvent r100) {
        return this.$$delegate_0.tryOpenMicToRecording(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void updateIntentExt(Map r100) {
        this.$$delegate_0.updateIntentExt(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void updateScreenshotForAsr(String r100) {
        this.$$delegate_0.updateScreenshotForAsr(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void wakeupAssistant(String r100) {
        this.$$delegate_0.wakeupAssistant(r100);
    }

    public FlowVoiceInteractionIDLStub() {
        IFlowVoiceInteractionIDL r100 = (IFlowVoiceInteractionIDLSPI) ServiceManager.get().getService(IFlowVoiceInteractionIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowVoiceInteractionIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
