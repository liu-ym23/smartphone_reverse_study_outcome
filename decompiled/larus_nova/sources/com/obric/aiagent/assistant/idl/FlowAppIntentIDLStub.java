package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0011\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\u0011\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010\u0017\u001a\u00020\bH\u0096\u0001J\t\u0010\u0018\u001a\u00020\bH\u0096\u0001J\t\u0010\u0019\u001a\u00020\bH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0011H\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\b2\u000e\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\bH\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u00112\u000e\u0010 \u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010!\u001a\u00020\b2\u000e\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001¨\u0006\""}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowAppIntentIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowAppIntentIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowAppIntentIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "checkPermission", "", "permission", "", "kotlin.jvm.PlatformType", "tryRequest", "timeOut", "", "currentTimeMillis", "getLocation", "", "callback", "Lcom/obric/aiagent/assistant/idl/IFlowGetLocationCallbackIDL;", "getObricTaskTimeoutConfig", "Lcom/obric/aiagent/assistant/idl/bean/OTaskTimeoutConfig;", "getUserId", "isDoraConnected", "isEnterpriseAccount", Keys.API_RETURN_KEY_IS_LOGIN, "jumpDoraPage", "openMiniApp", IFlowAppIntentIDL.PARAM_APPLET_ID, "setAppIntentActive", "AppIntentActive", "stopComplexTask", "messageId", "syncAppletData", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowAppIntentIDLStub extends IFlowAppIntentIDL.Stub {
    private final /* synthetic */ IFlowAppIntentIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean checkPermission(String r100, boolean r101, long r102) {
        return this.$$delegate_0.checkPermission(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public long currentTimeMillis() {
        return this.$$delegate_0.currentTimeMillis();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void getLocation(IFlowGetLocationCallbackIDL r100) {
        this.$$delegate_0.getLocation(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public OTaskTimeoutConfig getObricTaskTimeoutConfig() {
        return this.$$delegate_0.getObricTaskTimeoutConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public String getUserId() {
        return this.$$delegate_0.getUserId();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isDoraConnected() {
        return this.$$delegate_0.isDoraConnected();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isEnterpriseAccount() {
        return this.$$delegate_0.isEnterpriseAccount();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isLogin() {
        return this.$$delegate_0.isLogin();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void jumpDoraPage() {
        this.$$delegate_0.jumpDoraPage();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean openMiniApp(String r100) {
        return this.$$delegate_0.openMiniApp(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void setAppIntentActive(boolean r100) {
        this.$$delegate_0.setAppIntentActive(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void stopComplexTask(String r100) {
        this.$$delegate_0.stopComplexTask(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean syncAppletData(String r100) {
        return this.$$delegate_0.syncAppletData(r100);
    }

    public FlowAppIntentIDLStub() {
        IFlowAppIntentIDL r100 = (IFlowAppIntentIDLSPI) ServiceManager.get().getService(IFlowAppIntentIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowAppIntentIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
