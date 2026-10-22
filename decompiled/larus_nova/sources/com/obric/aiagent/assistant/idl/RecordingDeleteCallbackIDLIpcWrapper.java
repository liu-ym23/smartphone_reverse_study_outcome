package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class RecordingDeleteCallbackIDLIpcWrapper implements IRecordingDeleteCallbackIDL {
    boolean log;
    final IRecordingDeleteCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public RecordingDeleteCallbackIDLIpcWrapper(IRecordingDeleteCallbackIDL r100) throws RemoteException {
        this(r100, true);
    }

    public RecordingDeleteCallbackIDLIpcWrapper(IRecordingDeleteCallbackIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IRecordingDeleteCallbackIDL
    public void onResult(int r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IRecordingDeleteCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IRecordingDeleteCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IRecordingDeleteCallbackIDLIPC", "onResult", r101, r102, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IRecordingDeleteCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IRecordingDeleteCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResult(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IRecordingDeleteCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IRecordingDeleteCallbackIDLIPC", "onResult(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IRecordingDeleteCallbackIDLIPC", "onResult", r113, r112);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
