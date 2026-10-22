package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0019\u0010\t\u001a\u00020\b2\u000e\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0096\u0001J!\u0010\r\u001a\u00020\b2\u000e\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lvendor/bytedance/hardware/ahm/AHMIDLStub;", "Lvendor/bytedance/hardware/ahm/IAHMIDL$Stub;", "Lvendor/bytedance/hardware/ahm/IAHMIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "ipc_ahm_close", "", "ipc_ahm_open", "cb", "Lvendor/bytedance/hardware/ahm/IAHMCallbackIDL;", "kotlin.jvm.PlatformType", "ipc_ahm_open_v2", "clientType", "", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AHMIDLStub extends IAHMIDL.Stub {
    private final /* synthetic */ IAHMIDL $$delegate_0;

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_close() {
        return this.$$delegate_0.ipc_ahm_close();
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open(IAHMCallbackIDL r100) {
        return this.$$delegate_0.ipc_ahm_open(r100);
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open_v2(IAHMCallbackIDL r100, int r101) {
        return this.$$delegate_0.ipc_ahm_open_v2(r100, r101);
    }

    public AHMIDLStub() {
        IAHMIDL r100 = (IAHMIDLSPI) ServiceManager.get().getService(IAHMIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAHMIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
