package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;

/* JADX INFO: loaded from: classes41.dex */
class AHMCallbackIDLIpcWrapper implements IAHMCallbackIDL {
    boolean log;
    final IAHMCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public AHMCallbackIDLIpcWrapper(IAHMCallbackIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMCallbackIDL
    public void submitBuffer(byte[] r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = h.f384747a;     // Catch: Throwable -> L17
        h.b("IAHMCallbackIDLIPC", "submitBuffer(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = i.f384748a;     // Catch: Throwable -> L17
        i.a("IAHMCallbackIDLIPC", "submitBuffer(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAHMCallbackIDLIPC", "submitBuffer", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IAHMCallbackIDLIPC", "submitBuffer(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IAHMCallbackIDLIPC", "submitBuffer(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.submitBuffer(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IAHMCallbackIDLIPC", "submitBuffer = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IAHMCallbackIDLIPC", "submitBuffer(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAHMCallbackIDLIPC", "submitBuffer", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public AHMCallbackIDLIpcWrapper(IAHMCallbackIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
