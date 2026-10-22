package vendor.bytedance.hardware.ahm;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;

/* JADX INFO: loaded from: classes41.dex */
class AHMIDLStubWrapper extends IAHMIDL.Stub {
    boolean log;
    final IAHMIDL.Stub origin;

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_close() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AHMIDLStub", "ipc_ahm_close()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        i.c("AHMIDLStub", "ipc_ahm_close() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AHMIDLStub", "ipc_ahm_close", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        h.c("AHMIDLStub", "ipc_ahm_close()");     // Catch: Exception -> L11
    L6:
        long r112 = this.origin.ipc_ahm_close();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = h.f384747a;     // Catch: Exception -> L11
        h.d("AHMIDLStub", "ipc_ahm_close = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = i.f384748a;     // Catch: Exception -> L11
        i.d("AHMIDLStub", "ipc_ahm_close() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AHMIDLStub", "ipc_ahm_close", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public AHMIDLStubWrapper(IAHMIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open(IAHMCallbackIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r101 = h.f384747a;
        h.b("AHMIDLStub", "ipc_ahm_open(" + r210 + ")", e);
        IPCException r102 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r103 = Math.max(0, r110 - r100) / 1000;
        int r104 = i.f384748a;
        i.c("AHMIDLStub", "ipc_ahm_open(" + r210 + ") = fail", r102, r103);
        IPCAnomalyTrace r105 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AHMIDLStub", "ipc_ahm_open", r102, r103, r110);
        throw r102;
    L4:
        if (this.log == false) goto L6;
        int r111 = h.f384747a;     // Catch: Exception -> L24
        h.c("AHMIDLStub", "ipc_ahm_open(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IAHMIDL.Stub r112 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IAHMCallbackIDL r113 = r210;
    L19:
        long r114 = r112.ipc_ahm_open(r113);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        int r115 = h.f384747a;     // Catch: Exception -> L24
        h.d("AHMIDLStub", "ipc_ahm_open = " + r114);     // Catch: Exception -> L24
    L22:
        long r116 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r117 = Math.max(0, r116 - r100) / 1000;     // Catch: Exception -> L24
        int r106 = i.f384748a;     // Catch: Exception -> L24
        i.d("AHMIDLStub", "ipc_ahm_open(" + r210 + ") = " + r114, r117);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("AHMIDLStub", "ipc_ahm_open", r117, r116);     // Catch: Exception -> L24
        return r114;
    L10:
        if ((r210 instanceof AHMCallbackIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof AHMCallbackIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IAHMCallbackIDL.Stub) == false) goto L17;
        r113 = c.a((IAHMCallbackIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r113 = c.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    public AHMIDLStubWrapper(IAHMIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open_v2(IAHMCallbackIDL r210, int r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = h.f384747a;
        h.b("AHMIDLStub", "ipc_ahm_open_v2(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r212 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r212 - r100) / 1000;
        int r103 = i.f384748a;
        i.c("AHMIDLStub", "ipc_ahm_open_v2(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AHMIDLStub", "ipc_ahm_open_v2", r101, r102, r212);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r111 = h.f384747a;     // Catch: Exception -> L24
        h.c("AHMIDLStub", "ipc_ahm_open_v2(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IAHMIDL.Stub r112 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IAHMCallbackIDL r113 = r210;
    L19:
        long r114 = r112.ipc_ahm_open_v2(r113, r211);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        int r115 = h.f384747a;     // Catch: Exception -> L24
        h.d("AHMIDLStub", "ipc_ahm_open_v2 = " + r114);     // Catch: Exception -> L24
    L22:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r116 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L24
        int r105 = i.f384748a;     // Catch: Exception -> L24
        i.d("AHMIDLStub", "ipc_ahm_open_v2(" + r210 + ", " + r211 + ") = " + r114, r116);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("AHMIDLStub", "ipc_ahm_open_v2", r116, r213);     // Catch: Exception -> L24
        return r114;
    L10:
        if ((r210 instanceof AHMCallbackIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof AHMCallbackIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IAHMCallbackIDL.Stub) == false) goto L17;
        r113 = c.a((IAHMCallbackIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r113 = c.b(r210);     // Catch: Exception -> L24
        goto L19
    }
}
