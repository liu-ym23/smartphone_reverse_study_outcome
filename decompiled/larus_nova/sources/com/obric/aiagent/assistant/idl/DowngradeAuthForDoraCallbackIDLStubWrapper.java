package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class DowngradeAuthForDoraCallbackIDLStubWrapper extends IDowngradeAuthForDoraCallbackIDL.Stub {
    boolean log;
    final IDowngradeAuthForDoraCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToNoneAuth() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth()");     // Catch: Exception -> L11
    L6:
        this.origin.onDowngradeToNoneAuth();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToVoicePrint() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint()");     // Catch: Exception -> L11
    L6:
        this.origin.onDowngradeToVoicePrint();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onNotDowngrade() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade()");     // Catch: Exception -> L11
    L6:
        this.origin.onNotDowngrade();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade", r113, r112);     // Catch: Exception -> L11
    }

    public DowngradeAuthForDoraCallbackIDLStubWrapper(IDowngradeAuthForDoraCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public DowngradeAuthForDoraCallbackIDLStubWrapper(IDowngradeAuthForDoraCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
