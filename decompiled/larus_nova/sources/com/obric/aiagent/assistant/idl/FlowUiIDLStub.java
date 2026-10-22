package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JA\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010\u0012\u001a\u00020\bH\u0096\u0001J\t\u0010\u0013\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0011\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J9\u0010\u0018\u001a\u00020\b2\u000e\u0010\u0019\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u001e2\u000e\u0010 \u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010!\u001a\u00020\u001eH\u0096\u0001J\u0019\u0010\"\u001a\u00020\u001e2\u000e\u0010 \u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J!\u0010#\u001a\n \u000b*\u0004\u0018\u00010$0$2\u000e\u0010 \u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010%\u001a\u00020\u001eH\u0096\u0001J\t\u0010&\u001a\u00020\u001eH\u0096\u0001J1\u0010'\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010(\u001a\u00020\u001e2\u000e\u0010)\u001a\n \u000b*\u0004\u0018\u00010*0*H\u0096\u0001J\u0019\u0010+\u001a\u00020\b2\u000e\u0010,\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010-\u001a\u00020\bH\u0096\u0001J1\u0010.\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010)\u001a\n \u000b*\u0004\u0018\u00010*0*2\u0006\u0010/\u001a\u00020\u001eH\u0096\u0001J\u0011\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0017H\u0096\u0001J!\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010404H\u0096\u0001J\t\u00105\u001a\u00020\bH\u0096\u0001J\t\u00106\u001a\u00020\bH\u0096\u0001J1\u00107\u001a\u00020\b2\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u000108082\u0006\u00109\u001a\u00020\u001e2\u000e\u0010:\u001a\n \u000b*\u0004\u0018\u00010;0;H\u0096\u0001J)\u0010<\u001a\u00020\b2\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u000108082\u000e\u0010:\u001a\n \u000b*\u0004\u0018\u00010;0;H\u0096\u0001J)\u0010=\u001a\u00020\b2\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u000108082\u000e\u0010:\u001a\n \u000b*\u0004\u0018\u00010;0;H\u0096\u0001J)\u0010>\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010?\u001a\n \u000b*\u0004\u0018\u00010@0@H\u0096\u0001J\u0011\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u001eH\u0096\u0001J!\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010E0EH\u0096\u0001J\u0019\u0010F\u001a\u00020\b2\u000e\u0010G\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010H\u001a\u00020\bH\u0096\u0001Jt\u0010I\u001a\u00020\b2\u000e\u0010J\u001a\n \u000b*\u0004\u0018\u00010\n0\n2,\u0010K\u001a(\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0014\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010L0L2\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010M0M2\u0006\u0010N\u001a\u00020\u001e2\u000e\u0010:\u001a\n \u000b*\u0004\u0018\u00010;0;H\u0096\u0001¢\u0006\u0002\u0010O¨\u0006P"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowUiIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowUiIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowUiIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "addCustomBarAction", "", "key", "", "kotlin.jvm.PlatformType", "uri", "errorMsg", "fileSize", "", "closeAssistantInputPanel", "packageName", "dismissKeyguard", "finishChatPage", "getCurrentDisplayModel", "getTaskSkillModelJson", "getWindowState", "", "handleObricAction", "url", "expectKey", "callback", "Lcom/obric/aiagent/assistant/idl/IObricActionResultCallbackIDL;", "isAssistantRequestFromAIKey", "", "isAudioMessage", "messageId", "isAuthenticationPass", "isAuthenticationPassV2", "isAuthenticationPassV3", "Lcom/obric/aiagent/assistant/idl/bean/Authentication;", "isWindowMode", "isWindowShowing", "notifyAssistantState", "enter", "stateInfo", "Lcom/obric/aiagent/assistant/idl/bean/StateInfo;", "notifyMessageInAutoGui", "questionId", "notifyOAutoDied", "openAssistantInputPanel", "force", "openChatActivity", "windowMode", "openRealtimeCall", "callType", "Lcom/obric/aiagent/assistant/idl/IOpenRealTimeCallCallbackIDL;", "popWindow", "processRequiresAuthentication", "requestBiometricAuthentication", "Lcom/obric/aiagent/assistant/idl/IRequestAuthenticationCallbackIDL;", "playTts", "reportParams", "Landroid/os/Bundle;", "requestDeviceCredentialAuthentication", "requestVoicePrintAuthentication", "setAssistantInteractionListener", "listener", "Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL;", "setAutoIncreaseWindow", "increase", "shouldDowngradeAuthForDora", "authenticationType", "Lcom/obric/aiagent/assistant/idl/IDowngradeAuthForDoraCallbackIDL;", "showToast", "content", "showWindow", "suspendDismissKeyguard", "intent", "noTTSIntents", "", "Lcom/obric/aiagent/assistant/idl/IDismissKeyguardCallbackIDL;", "allowBiometricUnlock", "(Ljava/lang/String;[Ljava/lang/String;Lcom/obric/aiagent/assistant/idl/IDismissKeyguardCallbackIDL;ZLandroid/os/Bundle;)V", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowUiIDLStub extends IFlowUiIDL.Stub {
    private final /* synthetic */ IFlowUiIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void addCustomBarAction(String r100, String r101, String r102, long r110) {
        this.$$delegate_0.addCustomBarAction(r100, r101, r102, r110);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void closeAssistantInputPanel(String r100) {
        this.$$delegate_0.closeAssistantInputPanel(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void dismissKeyguard() {
        this.$$delegate_0.dismissKeyguard();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void finishChatPage() {
        this.$$delegate_0.finishChatPage();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getCurrentDisplayModel() {
        return this.$$delegate_0.getCurrentDisplayModel();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getTaskSkillModelJson() {
        return this.$$delegate_0.getTaskSkillModelJson();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public int getWindowState() {
        return this.$$delegate_0.getWindowState();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void handleObricAction(String r100, String r101, IObricActionResultCallbackIDL r102) {
        this.$$delegate_0.handleObricAction(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAssistantRequestFromAIKey() {
        return this.$$delegate_0.isAssistantRequestFromAIKey();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAudioMessage(String r100) {
        return this.$$delegate_0.isAudioMessage(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPass() {
        return this.$$delegate_0.isAuthenticationPass();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPassV2(String r100) {
        return this.$$delegate_0.isAuthenticationPassV2(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public Authentication isAuthenticationPassV3(String r100) {
        return this.$$delegate_0.isAuthenticationPassV3(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowMode() {
        return this.$$delegate_0.isWindowMode();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowShowing() {
        return this.$$delegate_0.isWindowShowing();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyAssistantState(String r100, boolean r101, StateInfo r102) {
        this.$$delegate_0.notifyAssistantState(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyMessageInAutoGui(String r100) {
        this.$$delegate_0.notifyMessageInAutoGui(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyOAutoDied() {
        this.$$delegate_0.notifyOAutoDied();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openAssistantInputPanel(String r100, StateInfo r101, boolean r102) {
        this.$$delegate_0.openAssistantInputPanel(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openChatActivity(int r100) {
        this.$$delegate_0.openChatActivity(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openRealtimeCall(int r100, IOpenRealTimeCallCallbackIDL r101) {
        this.$$delegate_0.openRealtimeCall(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void popWindow() {
        this.$$delegate_0.popWindow();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void processRequiresAuthentication() {
        this.$$delegate_0.processRequiresAuthentication();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r100, boolean r101, Bundle r102) {
        this.$$delegate_0.requestBiometricAuthentication(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r100, Bundle r101) {
        this.$$delegate_0.requestDeviceCredentialAuthentication(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r100, Bundle r101) {
        this.$$delegate_0.requestVoicePrintAuthentication(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAssistantInteractionListener(String r100, IAssistantInteractionListenerIDL r101) {
        this.$$delegate_0.setAssistantInteractionListener(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAutoIncreaseWindow(boolean r100) {
        this.$$delegate_0.setAutoIncreaseWindow(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void shouldDowngradeAuthForDora(int r100, IDowngradeAuthForDoraCallbackIDL r101) {
        this.$$delegate_0.shouldDowngradeAuthForDora(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showToast(String r100) {
        this.$$delegate_0.showToast(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showWindow() {
        this.$$delegate_0.showWindow();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void suspendDismissKeyguard(String r100, String[] r101, IDismissKeyguardCallbackIDL r102, boolean r110, Bundle r111) {
        this.$$delegate_0.suspendDismissKeyguard(r100, r101, r102, r110, r111);
    }

    public FlowUiIDLStub() {
        IFlowUiIDL r100 = (IFlowUiIDLSPI) ServiceManager.get().getService(IFlowUiIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowUiIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
