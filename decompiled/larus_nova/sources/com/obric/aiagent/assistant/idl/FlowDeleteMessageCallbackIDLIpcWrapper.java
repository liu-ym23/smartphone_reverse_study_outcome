package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class FlowDeleteMessageCallbackIDLIpcWrapper implements IFlowDeleteMessageCallbackIDL {
    boolean log;
    final IFlowDeleteMessageCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onFail() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowDeleteMessageCallbackIDLIPC", "onFail()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowDeleteMessageCallbackIDLIPC", "onFail() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowDeleteMessageCallbackIDLIPC", "onFail", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowDeleteMessageCallbackIDLIPC", "onFail()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowDeleteMessageCallbackIDLIPC", "onFail()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onFail();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowDeleteMessageCallbackIDLIPC", "onFail = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowDeleteMessageCallbackIDLIPC", "onFail() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowDeleteMessageCallbackIDLIPC", "onFail", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onSuccess() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowDeleteMessageCallbackIDLIPC", "onSuccess()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowDeleteMessageCallbackIDLIPC", "onSuccess() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowDeleteMessageCallbackIDLIPC", "onSuccess", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowDeleteMessageCallbackIDLIPC", "onSuccess()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowDeleteMessageCallbackIDLIPC", "onSuccess()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSuccess();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowDeleteMessageCallbackIDLIPC", "onSuccess = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowDeleteMessageCallbackIDLIPC", "onSuccess() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowDeleteMessageCallbackIDLIPC", "onSuccess", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowDeleteMessageCallbackIDLIpcWrapper(IFlowDeleteMessageCallbackIDL r100) throws RemoteException {
        this(r100, true);
    }

    public FlowDeleteMessageCallbackIDLIpcWrapper(IFlowDeleteMessageCallbackIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
