package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class ObricActionResultCallbackIDLIpcWrapper implements IObricActionResultCallbackIDL {
    boolean log;
    final IObricActionResultCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public ObricActionResultCallbackIDLIpcWrapper(IObricActionResultCallbackIDL r100) throws RemoteException {
        this(r100, true);
    }

    public ObricActionResultCallbackIDLIpcWrapper(IObricActionResultCallbackIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IObricActionResultCallbackIDL
    public void onResult(boolean r210, String r211, String r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IObricActionResultCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ", " + r212 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r213 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IObricActionResultCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IObricActionResultCallbackIDLIPC", "onResult", r101, r102, r213);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IObricActionResultCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IObricActionResultCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResult(r210, r211, r212);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IObricActionResultCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IObricActionResultCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IObricActionResultCallbackIDLIPC", "onResult", r111, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
