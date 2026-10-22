package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0011\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J!\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001J-\u0010\u000f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u0011 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00120\u0010H\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n \u000b*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentSkillManagerIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentSkillManagerIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentSkillManagerIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getSkillListVersion", "", "getSkillManagerConfig", "Lcom/obric/aiagent/assistant/idl/bean/OSkillManagerConfig;", "kotlin.jvm.PlatformType", "getSkillManagerStatus", "", "key", "listSkills", "", "Lcom/obric/aiagent/assistant/idl/bean/OSkill;", "", "registerSkillObserver", "", "observer", "Lcom/obric/aiagent/assistant/idl/IAgentSkillManagerObserverIDL;", "setSkillManagerConfigValues", "", "values", "Landroid/os/Bundle;", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentSkillManagerIDLStub extends IAgentSkillManagerIDL.Stub {
    private final /* synthetic */ IAgentSkillManagerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public long getSkillListVersion() {
        return this.$$delegate_0.getSkillListVersion();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public OSkillManagerConfig getSkillManagerConfig() {
        return this.$$delegate_0.getSkillManagerConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public String getSkillManagerStatus(String r100) {
        return this.$$delegate_0.getSkillManagerStatus(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public List<OSkill> listSkills() {
        return this.$$delegate_0.listSkills();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public void registerSkillObserver(IAgentSkillManagerObserverIDL r100) {
        this.$$delegate_0.registerSkillObserver(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public boolean setSkillManagerConfigValues(Bundle r100) {
        return this.$$delegate_0.setSkillManagerConfigValues(r100);
    }

    public AgentSkillManagerIDLStub() {
        IAgentSkillManagerIDL r100 = (IAgentSkillManagerIDLSPI) ServiceManager.get().getService(IAgentSkillManagerIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAgentSkillManagerIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
