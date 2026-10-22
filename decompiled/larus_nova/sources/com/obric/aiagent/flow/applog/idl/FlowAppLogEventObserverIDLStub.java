package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/flow/applog/idl/FlowAppLogEventObserverIDLStub;", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogEventObserverIDL$Stub;", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogEventObserverIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onEventV3", "", "category", "", "kotlin.jvm.PlatformType", "params", "flow-applog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowAppLogEventObserverIDLStub extends IFlowAppLogEventObserverIDL.Stub {
    private final /* synthetic */ IFlowAppLogEventObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL
    public void onEventV3(String r100, String r101) {
        this.$$delegate_0.onEventV3(r100, r101);
    }

    public FlowAppLogEventObserverIDLStub() {
        IFlowAppLogEventObserverIDL r100 = (IFlowAppLogEventObserverIDLSPI) ServiceManager.get().getService(IFlowAppLogEventObserverIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowAppLogEventObserverIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
