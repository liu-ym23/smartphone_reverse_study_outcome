package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0081\u0001\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001JY\u0010\u0018\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0019\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowCocreationReviewIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowCocreationReviewIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowCocreationReviewIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "logOmniStep", "", "recordId", "", "kotlin.jvm.PlatformType", "createdAt", "", "userQuery", "stepIndex", "", "stepDescription", "modelReply", "isLastStep", "", "isSuccess", "finishTimeMillis", "taskTriggerType", "logOmniUserStop", "reason", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowCocreationReviewIDLStub extends IFlowCocreationReviewIDL.Stub {
    private final /* synthetic */ IFlowCocreationReviewIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniStep(String r110, long r111, String r112, int r113, String r210, String r211, boolean r212, boolean r213, long r214, String r215) {
        this.$$delegate_0.logOmniStep(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniUserStop(String r110, long r111, String r112, long r113, String r114, String r115) {
        this.$$delegate_0.logOmniUserStop(r110, r111, r112, r113, r114, r115);
    }

    public FlowCocreationReviewIDLStub() {
        IFlowCocreationReviewIDL r100 = (IFlowCocreationReviewIDLSPI) ServiceManager.get().getService(IFlowCocreationReviewIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowCocreationReviewIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
