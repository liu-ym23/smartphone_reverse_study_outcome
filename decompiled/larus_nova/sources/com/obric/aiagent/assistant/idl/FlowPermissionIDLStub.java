package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016Jk\u0010\u0007\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n¨\u0006\u00010\b¨\u0006\u00012\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r2*\u0010\u000e\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00100\u000fH\u0096\u0001J[\u0010\u0011\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n¨\u0006\u00010\b¨\u0006\u00012*\u0010\u000e\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00100\u000fH\u0096\u0001Jk\u0010\u0012\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n¨\u0006\u00010\b¨\u0006\u00012\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r2*\u0010\u000e\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00100\u000fH\u0096\u0001J)\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001J5\u0010\u0017\u001a\u00020\u00182*\u0010\u000e\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00190\u0019 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00100\u000fH\u0096\u0001J5\u0010\u001a\u001a\u00020\u00182*\u0010\u000e\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00190\u0019 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00100\u000fH\u0096\u0001¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowPermissionIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowPermissionIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowPermissionIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "isAppletPermissionGranted", "", "", "", "kotlin.jvm.PlatformType", IFlowAppIntentIDL.PARAM_APPLET_ID, "", ComplianceResult.JsonKey.PERMISSIONS, "", "", "isPermissionGranted", "isPersonalPermissionGranted", "requestPermission", "", "questionId", "permission", "updateAppletPermissions", "", "Lcom/obric/aiagent/assistant/idl/bean/Permission;", "updatePersonalPermissions", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowPermissionIDLStub extends IFlowPermissionIDL.Stub {
    private final /* synthetic */ IFlowPermissionIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isAppletPermissionGranted(String r100, List<String> r101) {
        return this.$$delegate_0.isAppletPermissionGranted(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPermissionGranted(List<String> r100) {
        return this.$$delegate_0.isPermissionGranted(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPersonalPermissionGranted(String r100, List<String> r101) {
        return this.$$delegate_0.isPersonalPermissionGranted(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public boolean requestPermission(String r100, String r101) {
        return this.$$delegate_0.requestPermission(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updateAppletPermissions(List<Permission> r100) {
        this.$$delegate_0.updateAppletPermissions(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updatePersonalPermissions(List<Permission> r100) {
        this.$$delegate_0.updatePersonalPermissions(r100);
    }

    public FlowPermissionIDLStub() {
        IFlowPermissionIDL r100 = (IFlowPermissionIDLSPI) ServiceManager.get().getService(IFlowPermissionIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowPermissionIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
