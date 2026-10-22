package vendor.bytedance.hardware.ahm;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;

/* JADX INFO: loaded from: classes41.dex */
class AHMCallbackIDLStubWrapper extends IAHMCallbackIDL.Stub {
    boolean log;
    final IAHMCallbackIDL.Stub origin;

    public AHMCallbackIDLStubWrapper(IAHMCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMCallbackIDL
    public void submitBuffer(byte[] r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = h.f384747a;
        h.b("AHMCallbackIDLStub", "submitBuffer(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = i.f384748a;
        i.c("AHMCallbackIDLStub", "submitBuffer(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AHMCallbackIDLStub", "submitBuffer", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = h.f384747a;     // Catch: Exception -> L11
        h.c("AHMCallbackIDLStub", "submitBuffer(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.submitBuffer(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AHMCallbackIDLStub", "submitBuffer = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = i.f384748a;     // Catch: Exception -> L11
        i.d("AHMCallbackIDLStub", "submitBuffer(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AHMCallbackIDLStub", "submitBuffer", r113, r112);     // Catch: Exception -> L11
    }

    public AHMCallbackIDLStubWrapper(IAHMCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
