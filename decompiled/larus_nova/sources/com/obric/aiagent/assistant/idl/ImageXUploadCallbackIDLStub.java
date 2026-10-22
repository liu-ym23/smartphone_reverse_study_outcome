package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JQ\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f2\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\f2\u000e\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\f0\f2\u000e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/aiagent/assistant/idl/ImageXUploadCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IImageXUploadCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IImageXUploadCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onResult", "", "success", "", "tosKey", "", "kotlin.jvm.PlatformType", "resId", "code", "msg", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ImageXUploadCallbackIDLStub extends IImageXUploadCallbackIDL.Stub {
    private final /* synthetic */ IImageXUploadCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
    public void onResult(boolean r100, String r101, String r102, String r110, String r111) {
        this.$$delegate_0.onResult(r100, r101, r102, r110, r111);
    }

    public ImageXUploadCallbackIDLStub() {
        IImageXUploadCallbackIDL r100 = (IImageXUploadCallbackIDLSPI) ServiceManager.get().getService(IImageXUploadCallbackIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IImageXUploadCallbackIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
