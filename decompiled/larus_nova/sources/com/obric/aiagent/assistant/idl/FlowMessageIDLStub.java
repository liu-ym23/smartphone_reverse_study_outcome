package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.network.http.ServiceType;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J9\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001JG\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\r0\r2,\u0010\u0011\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014¨\u0006\u00010\u0012¨\u0006\u0001H\u0096\u0001J)\u0010\u0015\u001a\u00020\b2\u000e\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\u00180\u0018H\u0096\u0001J5\u0010\u0019\u001a\u00020\b2*\u0010\u001a\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0018\u00010\u001c0\u001bH\u0096\u0001J!\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010 0 H\u0096\u0001J)\u0010!\u001a\u00020\b2\u000e\u0010\"\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010 0 H\u0096\u0001J)\u0010#\u001a\u00020\b2\u000e\u0010\"\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010$0$H\u0096\u0001J\u0011\u0010%\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001J)\u0010&\u001a\u00020\b2\u000e\u0010'\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010(0(H\u0096\u0001J!\u0010)\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010*\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J)\u0010+\u001a\u00020\b2\u000e\u0010,\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010-0-H\u0096\u0001J\u0019\u0010.\u001a\u00020/2\u000e\u00100\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001J)\u00101\u001a\u00020\b2\u000e\u0010'\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010202H\u0096\u0001Jg\u00103\u001a\u00020\b2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010'\u001a\n \u000b*\u0004\u0018\u00010\r0\r2,\u0010\u0011\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014¨\u0006\u00010\u0012¨\u0006\u00012\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010404H\u0096\u0001Jw\u00105\u001a\u00020\b2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010'\u001a\n \u000b*\u0004\u0018\u00010\r0\r2,\u0010\u0011\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014¨\u0006\u00010\u0012¨\u0006\u00012\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010404H\u0096\u0001Jw\u00106\u001a\u00020\b2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010,\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010'\u001a\n \u000b*\u0004\u0018\u00010\r0\r2,\u0010\u0011\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014¨\u0006\u00010\u0012¨\u0006\u00012\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010404H\u0096\u0001J!\u00107\u001a\u00020\b2\u000e\u00108\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096\u0001J\u0019\u00109\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010:0:H\u0096\u0001J!\u0010;\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010:0:2\u0006\u0010<\u001a\u00020\u001fH\u0096\u0001J\u0019\u0010=\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010>0>H\u0096\u0001J\u0019\u0010?\u001a\u00020\b2\u000e\u0010@\u001a\n \u000b*\u0004\u0018\u00010A0AH\u0096\u0001J\u0019\u0010B\u001a\u00020\b2\u000e\u0010*\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001JI\u0010C\u001a\u00020\b2\u000e\u00108\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010D\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010E\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001Jw\u0010F\u001a\u00020\b2\u000e\u00108\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010D\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010E\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\r0\r2,\u0010\u0011\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014¨\u0006\u00010\u0012¨\u0006\u0001H\u0096\u0001J\u0019\u0010G\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010:0:H\u0096\u0001J\u0019\u0010H\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010>0>H\u0096\u0001J\u0019\u0010I\u001a\u00020\b2\u000e\u0010@\u001a\n \u000b*\u0004\u0018\u00010A0AH\u0096\u0001JG\u0010J\u001a\u00020\b2\u000e\u0010'\u001a\n \u000b*\u0004\u0018\u00010\r0\r2,\u0010\u0011\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014¨\u0006\u00010\u0012¨\u0006\u0001H\u0096\u0001J)\u0010K\u001a\u00020\b2\u000e\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010D\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001J9\u0010L\u001a\u00020\b2\u000e\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010M\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010N\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001J9\u0010O\u001a\u00020\b2\u000e\u0010,\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010-0-H\u0096\u0001¨\u0006P"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowMessageIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowMessageIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowMessageIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "addMessage", "", "message", "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "kotlin.jvm.PlatformType", "questionConversationId", "", "questionDisplayContent", "appendMessageExt", "scene", "ext", "", "", "", "deleteMessage", "localMessageId", "callback", "Lcom/obric/aiagent/assistant/idl/IFlowDeleteMessageCallbackIDL;", "deleteRemoteResource", LocationMonitorConst.IDENTIFIER, "", "", "fetchLatestMessages", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "Lcom/obric/aiagent/assistant/idl/IFlowFindMessagesCallbackIDL;", "findAnswersbyQueryId", "id", "findMessagebyId", "Lcom/obric/aiagent/assistant/idl/IFlowFindMessageCallbackIDL;", "generateLocalMessageId", "getMainTxtContentForMessage", "messageId", "Lcom/obric/aiagent/assistant/idl/IFlowMessageMainTextBlockCallbackIDL;", "getMainTxtContentFromMessage", ServiceType.IM, "imageXUpload", "uri", "Lcom/obric/aiagent/assistant/idl/IImageXUploadCallbackIDL;", "isConversationTtsEnabled", "", "cvsId", "isMessageLocalInterrupted", "Lcom/obric/aiagent/assistant/idl/IFlowIsMessageInterruptedCallbackIDL;", "notifySemanticUserEditEvent", "Lcom/obric/aiagent/assistant/idl/IFlowSemanticEditCallbackIDL;", "notifySemanticUserEditEventWithIdentifier", "notifySemanticUserEditEventWithUri", "refreshLatestMessages", "conversationId", "registerCallback", "Lcom/obric/aiagent/assistant/idl/IFlowMessageCallbackIDL;", "registerCallbackWithEvents", "eventMask", "registerSendMessageExtCallback", "Lcom/obric/aiagent/assistant/idl/IFlowSendMessageExtCallbackIDL;", "registerStreamObserver", "observer", "Lcom/obric/aiagent/assistant/idl/IFlowStreamObserverIDL;", "retryFetchMessage", "sendMessage", "content", "funcChannel", "sendMessageWithExtra", "unregisterCallback", "unregisterSendMessageExtCallback", "unregisterStreamObserver", "updateMessageExt", "updateMutableMessageContent", "updateMutableWidgetRenderData", WikiFolderPushPlugin.BLOCK_ID, "renderData", "uploadImage", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowMessageIDLStub extends IFlowMessageIDL.Stub {
    private final /* synthetic */ IFlowMessageIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void addMessage(IMMessage r100, String r101, String r102) {
        this.$$delegate_0.addMessage(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void appendMessageExt(String r100, Map r101) {
        this.$$delegate_0.appendMessageExt(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void deleteMessage(String r100, IFlowDeleteMessageCallbackIDL r101) {
        this.$$delegate_0.deleteMessage(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void deleteRemoteResource(List<String> r100) {
        this.$$delegate_0.deleteRemoteResource(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void fetchLatestMessages(int r100, IFlowFindMessagesCallbackIDL r101) {
        this.$$delegate_0.fetchLatestMessages(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void findAnswersbyQueryId(String r100, IFlowFindMessagesCallbackIDL r101) {
        this.$$delegate_0.findAnswersbyQueryId(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void findMessagebyId(String r100, IFlowFindMessageCallbackIDL r101) {
        this.$$delegate_0.findMessagebyId(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public String generateLocalMessageId() {
        return this.$$delegate_0.generateLocalMessageId();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void getMainTxtContentForMessage(String r100, IFlowMessageMainTextBlockCallbackIDL r101) {
        this.$$delegate_0.getMainTxtContentForMessage(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public String getMainTxtContentFromMessage(IMMessage r100) {
        return this.$$delegate_0.getMainTxtContentFromMessage(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void imageXUpload(String r100, IImageXUploadCallbackIDL r101) {
        this.$$delegate_0.imageXUpload(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public boolean isConversationTtsEnabled(String r100) {
        return this.$$delegate_0.isConversationTtsEnabled(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void isMessageLocalInterrupted(String r100, IFlowIsMessageInterruptedCallbackIDL r101) {
        this.$$delegate_0.isMessageLocalInterrupted(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEvent(String r100, String r101, Map r102, IFlowSemanticEditCallbackIDL r103) {
        this.$$delegate_0.notifySemanticUserEditEvent(r100, r101, r102, r103);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEventWithIdentifier(String r100, String r101, String r102, Map r110, IFlowSemanticEditCallbackIDL r111) {
        this.$$delegate_0.notifySemanticUserEditEventWithIdentifier(r100, r101, r102, r110, r111);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEventWithUri(String r100, String r101, String r102, Map r110, IFlowSemanticEditCallbackIDL r111) {
        this.$$delegate_0.notifySemanticUserEditEventWithUri(r100, r101, r102, r110, r111);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void refreshLatestMessages(String r100, int r101) {
        this.$$delegate_0.refreshLatestMessages(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerCallback(IFlowMessageCallbackIDL r100) {
        this.$$delegate_0.registerCallback(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerCallbackWithEvents(IFlowMessageCallbackIDL r100, int r101) {
        this.$$delegate_0.registerCallbackWithEvents(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r100) {
        this.$$delegate_0.registerSendMessageExtCallback(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerStreamObserver(IFlowStreamObserverIDL r100) {
        this.$$delegate_0.registerStreamObserver(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void retryFetchMessage(IMMessage r100) {
        this.$$delegate_0.retryFetchMessage(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void sendMessage(String r100, String r101, String r102, String r103) {
        this.$$delegate_0.sendMessage(r100, r101, r102, r103);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void sendMessageWithExtra(String r100, String r101, String r102, String r110, Map r111) {
        this.$$delegate_0.sendMessageWithExtra(r100, r101, r102, r110, r111);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterCallback(IFlowMessageCallbackIDL r100) {
        this.$$delegate_0.unregisterCallback(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r100) {
        this.$$delegate_0.unregisterSendMessageExtCallback(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterStreamObserver(IFlowStreamObserverIDL r100) {
        this.$$delegate_0.unregisterStreamObserver(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMessageExt(String r100, Map r101) {
        this.$$delegate_0.updateMessageExt(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMutableMessageContent(String r100, String r101) {
        this.$$delegate_0.updateMutableMessageContent(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMutableWidgetRenderData(String r100, String r101, String r102) {
        this.$$delegate_0.updateMutableWidgetRenderData(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void uploadImage(String r100, String r101, IImageXUploadCallbackIDL r102) {
        this.$$delegate_0.uploadImage(r100, r101, r102);
    }

    public FlowMessageIDLStub() {
        IFlowMessageIDL r100 = (IFlowMessageIDLSPI) ServiceManager.get().getService(IFlowMessageIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowMessageIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
