package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class ObricActionResultCallbackIDLStubWrapper extends IObricActionResultCallbackIDL.Stub {
    boolean log;
    final IObricActionResultCallbackIDL.Stub origin;

    public ObricActionResultCallbackIDLStubWrapper(IObricActionResultCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public ObricActionResultCallbackIDLStubWrapper(IObricActionResultCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IObricActionResultCallbackIDL
    public void onResult(boolean r210, String r211, String r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("ObricActionResultCallbackIDLStub", "onResult(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("ObricActionResultCallbackIDLStub", "onResult(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("ObricActionResultCallbackIDLStub", "onResult", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("ObricActionResultCallbackIDLStub", "onResult(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("ObricActionResultCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("ObricActionResultCallbackIDLStub", "onResult(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("ObricActionResultCallbackIDLStub", "onResult", r111, r214);     // Catch: Exception -> L11
    }
}
