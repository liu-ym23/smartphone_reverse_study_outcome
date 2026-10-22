package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001J!\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001J!\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/flow/applog/idl/FlowAppLogSessionObserverIDLStub;", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogSessionObserverIDL$Stub;", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogSessionObserverIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onSessionBatchEvent", "", "id", "", "sessionId", "", "kotlin.jvm.PlatformType", "onSessionStart", "onSessionTerminate", "flow-applog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowAppLogSessionObserverIDLStub extends IFlowAppLogSessionObserverIDL.Stub {
    private final /* synthetic */ IFlowAppLogSessionObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionBatchEvent(long r100, String r101) {
        this.$$delegate_0.onSessionBatchEvent(r100, r101);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionStart(long r100, String r101) {
        this.$$delegate_0.onSessionStart(r100, r101);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionTerminate(long r100, String r101) {
        this.$$delegate_0.onSessionTerminate(r100, r101);
    }

    public FlowAppLogSessionObserverIDLStub() {
        IFlowAppLogSessionObserverIDL r100 = (IFlowAppLogSessionObserverIDLSPI) ServiceManager.get().getService(IFlowAppLogSessionObserverIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowAppLogSessionObserverIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
