package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J)\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentSettingsIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentSettingsIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentSettingsIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "isAutoGuiInstall", "", "isMemoryRecommendActivityEnabled", "setSystemProperty", "", "tosKey", "", "kotlin.jvm.PlatformType", "resId", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentSettingsIDLStub extends IAgentSettingsIDL.Stub {
    private final /* synthetic */ IAgentSettingsIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isAutoGuiInstall() {
        return this.$$delegate_0.isAutoGuiInstall();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isMemoryRecommendActivityEnabled() {
        return this.$$delegate_0.isMemoryRecommendActivityEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public void setSystemProperty(String r100, String r101) {
        this.$$delegate_0.setSystemProperty(r100, r101);
    }

    public AgentSettingsIDLStub() {
        IAgentSettingsIDL r100 = (IAgentSettingsIDLSPI) ServiceManager.get().getService(IAgentSettingsIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAgentSettingsIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
