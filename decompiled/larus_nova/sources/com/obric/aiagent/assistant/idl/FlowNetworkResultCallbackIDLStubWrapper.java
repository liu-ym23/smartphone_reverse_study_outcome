package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class FlowNetworkResultCallbackIDLStubWrapper extends IFlowNetworkResultCallbackIDL.Stub {
    boolean log;
    final IFlowNetworkResultCallbackIDL.Stub origin;

    public FlowNetworkResultCallbackIDLStubWrapper(IFlowNetworkResultCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public FlowNetworkResultCallbackIDLStubWrapper(IFlowNetworkResultCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL
    public void onResult(boolean r210, Map r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkResultCallbackIDLStub", "onResult(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkResultCallbackIDLStub", "onResult(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkResultCallbackIDLStub", "onResult", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkResultCallbackIDLStub", "onResult(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkResultCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkResultCallbackIDLStub", "onResult(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowNetworkResultCallbackIDLStub", "onResult", r113, r112);     // Catch: Exception -> L11
    }
}
