package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class OpenRealTimeCallCallbackIDLIpcWrapper implements IOpenRealTimeCallCallbackIDL {
    boolean log;
    final IOpenRealTimeCallCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public OpenRealTimeCallCallbackIDLIpcWrapper(IOpenRealTimeCallCallbackIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResult(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IOpenRealTimeCallCallbackIDLIPC", "onResult", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResult(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IOpenRealTimeCallCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IOpenRealTimeCallCallbackIDLIPC", "onResult", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public OpenRealTimeCallCallbackIDLIpcWrapper(IOpenRealTimeCallCallbackIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResultWithMsg(int r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg", r101, r102, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResultWithMsg(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg", r113, r112);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
