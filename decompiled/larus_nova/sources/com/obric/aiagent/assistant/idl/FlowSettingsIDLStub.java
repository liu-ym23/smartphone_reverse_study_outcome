package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J/\u0010\f\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f¨\u0006\u00010\r¨\u0006\u0001H\u0096\u0001J\t\u0010\u0010\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010\u0018\u001a\u00020\bH\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0013H\u0096\u0001J!\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0011\u0010\u001d\u001a\n \u000b*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J!\u0010\u001f\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0011\u0010 \u001a\n \u000b*\u0004\u0018\u00010!0!H\u0096\u0001J\u0011\u0010\"\u001a\n \u000b*\u0004\u0018\u00010#0#H\u0096\u0001J\t\u0010$\u001a\u00020\bH\u0096\u0001J\t\u0010%\u001a\u00020\u0013H\u0096\u0001J\t\u0010&\u001a\u00020\u0013H\u0096\u0001J\t\u0010'\u001a\u00020\u0013H\u0096\u0001J\t\u0010(\u001a\u00020\u0013H\u0096\u0001J\t\u0010)\u001a\u00020\u0013H\u0096\u0001J\t\u0010*\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J\u0011\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010/\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0013H\u0096\u0001J\u0011\u00100\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0013H\u0096\u0001J\u0011\u00101\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0013H\u0096\u0001J\u0011\u00102\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0013H\u0096\u0001¨\u00063"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowSettingsIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowSettingsIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowSettingsIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getAuthenticationTypeOnLockScreen", "", "scene", "", "kotlin.jvm.PlatformType", "getAutoExecuteAuthorizationStatusMap", "", "", "", "getAutoGuiEnabledScene", "getAutoGuiFastModeUseSettings", "getAutoImageUploadEnabled", "", "getFeatureConfigMap", "Lcom/obric/aiagent/assistant/idl/bean/FeatureConfigMap;", "getIntentAuthStatus", "settingKey", "getIntentUploadStrategyForDebug", "getOAutoUseClipboardEnabled", "getOUseMemoryEnabled", "getObricCloudConfig", "key", "getObricComplexTaskConfig", "Lcom/obric/aiagent/assistant/idl/bean/OComplexTaskConfig;", "getObricFlowSettingsJson", "getObricMemoryDataCollectConfig", "Lcom/obric/aiagent/assistant/idl/bean/ObricMemoryDataCollectConfig;", "getObricModelConfig", "Lcom/obric/aiagent/assistant/idl/bean/OModelConfig;", "getObricPowerLockTimeoutInSeconds", "getPersonalContextEnabled", "getSemanticeScreenShotEnabled", "isLarkKnowledgeAuthorizationEnable", "isLarkSendConfirmEnabled", "isTtsPlayBackgroundEnabled", "isVoicePrintAuthenticateAutoGuiEnabled", "setAutoGuiEnabledScene", "", "setAutoImageUploadEnabled", "enable", "setLarkKnowledgeAuthorizationEnabled", "setOUseMemoryEnabled", "setSemanticScreenShotEnabled", "setVoicePrintAuthenticateAutoGuiEnabled", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowSettingsIDLStub extends IFlowSettingsIDL.Stub {
    private final /* synthetic */ IFlowSettingsIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getAuthenticationTypeOnLockScreen(String r100) {
        return this.$$delegate_0.getAuthenticationTypeOnLockScreen(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public Map getAutoExecuteAuthorizationStatusMap() {
        return this.$$delegate_0.getAutoExecuteAuthorizationStatusMap();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getAutoGuiEnabledScene() {
        return this.$$delegate_0.getAutoGuiEnabledScene();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getAutoGuiFastModeUseSettings() {
        return this.$$delegate_0.getAutoGuiFastModeUseSettings();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getAutoImageUploadEnabled() {
        return this.$$delegate_0.getAutoImageUploadEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public FeatureConfigMap getFeatureConfigMap() {
        return this.$$delegate_0.getFeatureConfigMap();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getIntentAuthStatus(String r100) {
        return this.$$delegate_0.getIntentAuthStatus(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getIntentUploadStrategyForDebug() {
        return this.$$delegate_0.getIntentUploadStrategyForDebug();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getOAutoUseClipboardEnabled() {
        return this.$$delegate_0.getOAutoUseClipboardEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getOUseMemoryEnabled() {
        return this.$$delegate_0.getOUseMemoryEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getObricCloudConfig(String r100) {
        return this.$$delegate_0.getObricCloudConfig(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public OComplexTaskConfig getObricComplexTaskConfig() {
        return this.$$delegate_0.getObricComplexTaskConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getObricFlowSettingsJson(String r100) {
        return this.$$delegate_0.getObricFlowSettingsJson(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() {
        return this.$$delegate_0.getObricMemoryDataCollectConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public OModelConfig getObricModelConfig() {
        return this.$$delegate_0.getObricModelConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getObricPowerLockTimeoutInSeconds() {
        return this.$$delegate_0.getObricPowerLockTimeoutInSeconds();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getPersonalContextEnabled() {
        return this.$$delegate_0.getPersonalContextEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getSemanticeScreenShotEnabled() {
        return this.$$delegate_0.getSemanticeScreenShotEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isLarkKnowledgeAuthorizationEnable() {
        return this.$$delegate_0.isLarkKnowledgeAuthorizationEnable();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isLarkSendConfirmEnabled() {
        return this.$$delegate_0.isLarkSendConfirmEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isTtsPlayBackgroundEnabled() {
        return this.$$delegate_0.isTtsPlayBackgroundEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isVoicePrintAuthenticateAutoGuiEnabled() {
        return this.$$delegate_0.isVoicePrintAuthenticateAutoGuiEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setAutoGuiEnabledScene(int r100) {
        this.$$delegate_0.setAutoGuiEnabledScene(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setAutoImageUploadEnabled(boolean r100) {
        this.$$delegate_0.setAutoImageUploadEnabled(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setLarkKnowledgeAuthorizationEnabled(boolean r100) {
        this.$$delegate_0.setLarkKnowledgeAuthorizationEnabled(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setOUseMemoryEnabled(boolean r100) {
        this.$$delegate_0.setOUseMemoryEnabled(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setSemanticScreenShotEnabled(boolean r100) {
        this.$$delegate_0.setSemanticScreenShotEnabled(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r100) {
        this.$$delegate_0.setVoicePrintAuthenticateAutoGuiEnabled(r100);
    }

    public FlowSettingsIDLStub() {
        IFlowSettingsIDL r100 = (IFlowSettingsIDLSPI) ServiceManager.get().getService(IFlowSettingsIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowSettingsIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
