package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class FlowDeleteMessageCallbackIDLStubWrapper extends IFlowDeleteMessageCallbackIDL.Stub {
    boolean log;
    final IFlowDeleteMessageCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onFail() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowDeleteMessageCallbackIDLStub", "onFail()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowDeleteMessageCallbackIDLStub", "onFail() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowDeleteMessageCallbackIDLStub", "onFail", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowDeleteMessageCallbackIDLStub", "onFail()");     // Catch: Exception -> L11
    L6:
        this.origin.onFail();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowDeleteMessageCallbackIDLStub", "onFail = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowDeleteMessageCallbackIDLStub", "onFail() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowDeleteMessageCallbackIDLStub", "onFail", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onSuccess() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowDeleteMessageCallbackIDLStub", "onSuccess()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowDeleteMessageCallbackIDLStub", "onSuccess() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowDeleteMessageCallbackIDLStub", "onSuccess", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowDeleteMessageCallbackIDLStub", "onSuccess()");     // Catch: Exception -> L11
    L6:
        this.origin.onSuccess();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowDeleteMessageCallbackIDLStub", "onSuccess = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowDeleteMessageCallbackIDLStub", "onSuccess() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowDeleteMessageCallbackIDLStub", "onSuccess", r113, r112);     // Catch: Exception -> L11
    }

    public FlowDeleteMessageCallbackIDLStubWrapper(IFlowDeleteMessageCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public FlowDeleteMessageCallbackIDLStubWrapper(IFlowDeleteMessageCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
