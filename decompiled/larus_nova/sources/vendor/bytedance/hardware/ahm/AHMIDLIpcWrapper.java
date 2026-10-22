package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;

/* JADX INFO: loaded from: classes41.dex */
class AHMIDLIpcWrapper implements IAHMIDL {
    boolean log;
    final IAHMIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_close() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L17:
        e = e;
        long r110 = 0;
    L19:
        h.b("IAHMIDLIPC", "ipc_ahm_close()", e);     // Catch: Throwable -> L21
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L21
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L21
        i.a("IAHMIDLIPC", "ipc_ahm_close() = fail", r111, r101);     // Catch: Throwable -> L21
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L21
        IPCAnomalyTrace.b("IAHMIDLIPC", "ipc_ahm_close", r111, r101, r112);     // Catch: Throwable -> L21
        return r110;
    L22:
        return r110;
    L4:
        if (this.log == false) goto L7;
        h.a("IAHMIDLIPC", "ipc_ahm_close()");     // Catch: Exception -> L17 Throwable -> L23
    L7:
        if (this.log == false) goto L9;
        h.a("IAHMIDLIPC", "ipc_ahm_close()");     // Catch: Exception -> L17 Throwable -> L23
    L9:
        r110 = this.origin.ipc_ahm_close();     // Catch: Exception -> L17 Throwable -> L23
    L15:
        e = e;
        goto L19
    L11:
        if (this.log == false) goto L13;
        int r113 = h.f384747a;     // Catch: Exception -> L15 Throwable -> L21
        h.d("IAHMIDLIPC", "ipc_ahm_close = " + r110);     // Catch: Exception -> L15 Throwable -> L21
    L13:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L21
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L15 Throwable -> L21
        int r103 = i.f384748a;     // Catch: Exception -> L15 Throwable -> L21
        i.b("IAHMIDLIPC", "ipc_ahm_close() = " + r110, r115);     // Catch: Exception -> L15 Throwable -> L21
        IPCAnomalyTrace.f384709a.c("IAHMIDLIPC", "ipc_ahm_close", r115, r114);     // Catch: Exception -> L15 Throwable -> L21
        return r110;
    L29:
        return 0;
    }

    public AHMIDLIpcWrapper(IAHMIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open(IAHMCallbackIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L43:
        e = e;
        long r110 = 0;
    L45:
        int r101 = h.f384747a;     // Catch: Throwable -> L47
        h.b("IAHMIDLIPC", "ipc_ahm_open(" + r210 + ")", e);     // Catch: Throwable -> L47
        IPCException r102 = new IPCException(e);     // Catch: Throwable -> L47
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L47
        long r103 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L47
        int r104 = i.f384748a;     // Catch: Throwable -> L47
        i.a("IAHMIDLIPC", "ipc_ahm_open(" + r210 + ") = fail", r102, r103);     // Catch: Throwable -> L47
        IPCAnomalyTrace r105 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L47
        IPCAnomalyTrace.b("IAHMIDLIPC", "ipc_ahm_open", r102, r103, r111);     // Catch: Throwable -> L47
        return r110;
    L48:
        return r110;
    L4:
        if (this.log == false) goto L7;
        int r112 = h.f384747a;     // Catch: Exception -> L43 Throwable -> L49
        h.a("IAHMIDLIPC", "ipc_ahm_open(" + r210 + ")");     // Catch: Exception -> L43 Throwable -> L49
    L7:
        if (this.log == false) goto L22;
        int r113 = h.f384747a;     // Catch: Exception -> L43 Throwable -> L49
        StringBuilder r114 = new StringBuilder("ipc_ahm_open(");     // Catch: Exception -> L43 Throwable -> L49
        if (r210 != null) goto L12;
    L20:
        IAHMCallbackIDL r115 = r210;
    L21:
        r114.append(r115);     // Catch: Exception -> L43 Throwable -> L49
        r114.append(")");     // Catch: Exception -> L43 Throwable -> L49
        h.a("IAHMIDLIPC", r114.toString());     // Catch: Exception -> L43 Throwable -> L49
        goto L22
    L12:
        if ((r210 instanceof AHMCallbackIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof AHMCallbackIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IAHMCallbackIDL.Stub) == false) goto L19;
        r115 = c.a((IAHMCallbackIDL.Stub) r210);     // Catch: Exception -> L43 Throwable -> L49
        goto L21
    L19:
        r115 = c.b(r210);     // Catch: Exception -> L43 Throwable -> L49
    L22:
        IAHMIDL r116 = this.origin;     // Catch: Exception -> L43 Throwable -> L49
        if (r210 != null) goto L26;
    L34:
        IAHMCallbackIDL r117 = r210;
    L35:
        r110 = r116.ipc_ahm_open(r117);     // Catch: Exception -> L43 Throwable -> L49
    L41:
        e = e;
        goto L45
    L37:
        if (this.log == false) goto L39;
        int r118 = h.f384747a;     // Catch: Exception -> L41 Throwable -> L47
        h.d("IAHMIDLIPC", "ipc_ahm_open = " + r110);     // Catch: Exception -> L41 Throwable -> L47
    L39:
        long r119 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L41 Throwable -> L47
        long r120 = Math.max(0, r119 - r100) / 1000;     // Catch: Exception -> L41 Throwable -> L47
        int r106 = i.f384748a;     // Catch: Exception -> L41 Throwable -> L47
        i.b("IAHMIDLIPC", "ipc_ahm_open(" + r210 + ") = " + r110, r120);     // Catch: Exception -> L41 Throwable -> L47
        IPCAnomalyTrace.f384709a.c("IAHMIDLIPC", "ipc_ahm_open", r120, r119);     // Catch: Exception -> L41 Throwable -> L47
        return r110;
        goto L55
    L26:
        if ((r210 instanceof AHMCallbackIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof AHMCallbackIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IAHMCallbackIDL.Stub) == false) goto L33;
        r117 = c.a((IAHMCallbackIDL.Stub) r210);     // Catch: Exception -> L43 Throwable -> L49
        goto L35
    L33:
        r117 = c.b(r210);     // Catch: Exception -> L43 Throwable -> L49
    L55:
        return 0;
    }

    public AHMIDLIpcWrapper(IAHMIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0147: MOVE (r12 I:??[long, double]) = (r14 I:??[long, double]) (LINE:33554759), block:B:53:0x0147 */
    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open_v2(IAHMCallbackIDL r210, int r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L49:
        e = e;
        long r110 = 0;
    L51:
        int r111 = h.f384747a;     // Catch: Throwable -> L53
        h.b("IAHMIDLIPC", "ipc_ahm_open_v2(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L53
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L53
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L53
        long r102 = Math.max(0, r212 - r100) / 1000;     // Catch: Throwable -> L53
        int r103 = i.f384748a;     // Catch: Throwable -> L53
        i.a("IAHMIDLIPC", "ipc_ahm_open_v2(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L53
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L53
        IPCAnomalyTrace.b("IAHMIDLIPC", "ipc_ahm_open_v2", r101, r102, r212);     // Catch: Throwable -> L53
        return r110;
    L48:
        return 0;
    L4:
        if (this.log == false) goto L10;
        int r112 = h.f384747a;     // Catch: Exception -> L7 Throwable -> L55
        h.a("IAHMIDLIPC", "ipc_ahm_open_v2(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L7 Throwable -> L55
    L7:
        e = e;
        r110 = 0;
        goto L51
    L62:
        return 0;
    L10:
        if (this.log == false) goto L25;
        int r113 = h.f384747a;     // Catch: Exception -> L7 Throwable -> L55
        StringBuilder r114 = new StringBuilder("ipc_ahm_open_v2(");     // Catch: Exception -> L7 Throwable -> L55
        if (r210 != null) goto L15;
    L23:
        IAHMCallbackIDL r115 = r210;
    L24:
        r114.append(r115);     // Catch: Exception -> L7 Throwable -> L55
        r114.append(", ");     // Catch: Exception -> L7 Throwable -> L55
        r114.append(r211);     // Catch: Exception -> L7 Throwable -> L55
        r114.append(")");     // Catch: Exception -> L7 Throwable -> L55
        h.a("IAHMIDLIPC", r114.toString());     // Catch: Exception -> L7 Throwable -> L55
        goto L25
    L15:
        if ((r210 instanceof AHMCallbackIDLIpcWrapper) == true) goto L23;
        if ((r210 instanceof AHMCallbackIDLStubWrapper) == true) goto L23;
        if ((r210 instanceof IAHMCallbackIDL.Stub) == false) goto L22;
        r115 = c.a((IAHMCallbackIDL.Stub) r210);     // Catch: Exception -> L7 Throwable -> L55
        goto L24
    L22:
        r115 = c.b(r210);     // Catch: Exception -> L7 Throwable -> L55
    L25:
        IAHMIDL r116 = this.origin;     // Catch: Throwable -> L48 Exception -> L49
        if (r210 != null) goto L29;
    L39:
        IAHMCallbackIDL r117 = r210;
    L40:
        r110 = r116.ipc_ahm_open_v2(r117, r211);     // Catch: Throwable -> L48 Exception -> L49
    L46:
        e = e;
        goto L51
    L42:
        if (this.log == false) goto L44;
        int r118 = h.f384747a;     // Catch: Exception -> L46 Throwable -> L53
        h.d("IAHMIDLIPC", "ipc_ahm_open_v2 = " + r110);     // Catch: Exception -> L46 Throwable -> L53
    L44:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L46 Throwable -> L53
        long r119 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L46 Throwable -> L53
        int r105 = i.f384748a;     // Catch: Exception -> L46 Throwable -> L53
        i.b("IAHMIDLIPC", "ipc_ahm_open_v2(" + r210 + ", " + r211 + ") = " + r110, r119);     // Catch: Exception -> L46 Throwable -> L53
        IPCAnomalyTrace.f384709a.c("IAHMIDLIPC", "ipc_ahm_open_v2", r119, r213);     // Catch: Exception -> L46 Throwable -> L53
        return r110;
    L29:
        if ((r210 instanceof AHMCallbackIDLIpcWrapper) == true) goto L39;
        if ((r210 instanceof AHMCallbackIDLStubWrapper) == true) goto L39;
        if ((r210 instanceof IAHMCallbackIDL.Stub) == false) goto L36;
        r117 = c.a((IAHMCallbackIDL.Stub) r210);     // Catch: Exception -> L7 Throwable -> L55
        goto L40
    L36:
        r117 = c.b(r210);     // Catch: Exception -> L7 Throwable -> L55
        goto L40
    L54:
        return r14;
    }
}
