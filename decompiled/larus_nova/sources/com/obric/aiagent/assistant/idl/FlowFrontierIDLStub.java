package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JO\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f2,\u0010\u000e\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010 \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0011¨\u0006\u00010\u000f¨\u0006\u0001H\u0096\u0001J_\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u0013\u001a\n \r*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0015\u001a\n \r*\u0004\u0018\u00010\u00160\u00162,\u0010\u0017\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010 \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0011¨\u0006\u00010\u000f¨\u0006\u0001H\u0096\u0001J\t\u0010\u0018\u001a\u00020\nH\u0096\u0001J!\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\u001b0\u001bH\u0096\u0001J!\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001JO\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u001f\u001a\n \r*\u0004\u0018\u00010 0 2,\u0010\u000e\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010 \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0011¨\u0006\u00010\u000f¨\u0006\u0001H\u0096\u0001J!\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\u001b0\u001bH\u0096\u0001J!\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001¨\u0006#"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowFrontierIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowFrontierIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowFrontierIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "cacheScreenshot", "", "serviceId", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "headers", "", "", "", "cacheScreenshotFd", "fdKey", "", "fd", "Landroid/os/ParcelFileDescriptor;", "extras", "getState", "registerDataListener", "listener", "Lcom/obric/aiagent/assistant/idl/IFlowFrontierDataListenerIDL;", "registerStateListener", "Lcom/obric/aiagent/assistant/idl/IFlowFrontierStateListenerIDL;", "sendData", "data", "", "unregisterDataListener", "unregisterStateListener", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowFrontierIDLStub extends IFlowFrontierIDL.Stub {
    private final /* synthetic */ IFlowFrontierIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshot(int r100, Bitmap r101, Map r102) {
        this.$$delegate_0.cacheScreenshot(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshotFd(int r100, String r101, ParcelFileDescriptor r102, Map r103) {
        this.$$delegate_0.cacheScreenshotFd(r100, r101, r102, r103);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public int getState() {
        return this.$$delegate_0.getState();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerDataListener(int r100, IFlowFrontierDataListenerIDL r101) {
        this.$$delegate_0.registerDataListener(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerStateListener(int r100, IFlowFrontierStateListenerIDL r101) {
        this.$$delegate_0.registerStateListener(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void sendData(int r100, byte[] r101, Map r102) {
        this.$$delegate_0.sendData(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterDataListener(int r100, IFlowFrontierDataListenerIDL r101) {
        this.$$delegate_0.unregisterDataListener(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterStateListener(int r100, IFlowFrontierStateListenerIDL r101) {
        this.$$delegate_0.unregisterStateListener(r100, r101);
    }

    public FlowFrontierIDLStub() {
        IFlowFrontierIDL r100 = (IFlowFrontierIDLSPI) ServiceManager.get().getService(IFlowFrontierIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowFrontierIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
