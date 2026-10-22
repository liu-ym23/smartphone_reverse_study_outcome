package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class RequestAuthenticationCallbackIDLStubWrapper extends IRequestAuthenticationCallbackIDL.Stub {
    boolean log;
    final IRequestAuthenticationCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationCancelled() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationCancelled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationFailed() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationFailed();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationNotAvailable() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationNotAvailable();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationPass() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationPass();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationTimeout() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationTimeout();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout", r113, r112);     // Catch: Exception -> L11
    }

    public RequestAuthenticationCallbackIDLStubWrapper(IRequestAuthenticationCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public RequestAuthenticationCallbackIDLStubWrapper(IRequestAuthenticationCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
