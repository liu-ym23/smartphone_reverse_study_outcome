package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010\f\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/aiagent/assistant/idl/ScreenshotCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IScreenshotCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IScreenshotCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", LynxVideoManagerLite.EVENT_ON_ERROR, "", "error", "", "kotlin.jvm.PlatformType", "onReceivedScreenshot", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "onReceivedScreenshotUri", "uri", "Landroid/net/Uri;", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ScreenshotCallbackIDLStub extends IScreenshotCallbackIDL.Stub {
    private final /* synthetic */ IScreenshotCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onError(String r100) {
        this.$$delegate_0.onError(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshot(Bitmap r100) {
        this.$$delegate_0.onReceivedScreenshot(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshotUri(Uri r100) {
        this.$$delegate_0.onReceivedScreenshotUri(r100);
    }

    public ScreenshotCallbackIDLStub() {
        IScreenshotCallbackIDL r100 = (IScreenshotCallbackIDLSPI) ServiceManager.get().getService(IScreenshotCallbackIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IScreenshotCallbackIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
