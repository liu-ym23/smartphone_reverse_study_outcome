package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/DowngradeAuthForDoraCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IDowngradeAuthForDoraCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IDowngradeAuthForDoraCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onDowngradeToNoneAuth", "", "onDowngradeToVoicePrint", "onNotDowngrade", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DowngradeAuthForDoraCallbackIDLStub extends IDowngradeAuthForDoraCallbackIDL.Stub {
    private final /* synthetic */ IDowngradeAuthForDoraCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToNoneAuth() {
        this.$$delegate_0.onDowngradeToNoneAuth();
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToVoicePrint() {
        this.$$delegate_0.onDowngradeToVoicePrint();
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onNotDowngrade() {
        this.$$delegate_0.onNotDowngrade();
    }

    public DowngradeAuthForDoraCallbackIDLStub() {
        IDowngradeAuthForDoraCallbackIDL r100 = (IDowngradeAuthForDoraCallbackIDLSPI) ServiceManager.get().getService(IDowngradeAuthForDoraCallbackIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IDowngradeAuthForDoraCallbackIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
