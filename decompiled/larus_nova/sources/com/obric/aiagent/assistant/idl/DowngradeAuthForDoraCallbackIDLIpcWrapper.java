package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class DowngradeAuthForDoraCallbackIDLIpcWrapper implements IDowngradeAuthForDoraCallbackIDL {
    boolean log;
    final IDowngradeAuthForDoraCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToNoneAuth() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onDowngradeToNoneAuth();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToVoicePrint() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onDowngradeToVoicePrint();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onNotDowngrade() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onNotDowngrade();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public DowngradeAuthForDoraCallbackIDLIpcWrapper(IDowngradeAuthForDoraCallbackIDL r100) throws RemoteException {
        this(r100, true);
    }

    public DowngradeAuthForDoraCallbackIDLIpcWrapper(IDowngradeAuthForDoraCallbackIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
