package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class FlowSendMessageExtCallbackIDLStubWrapper extends IFlowSendMessageExtCallbackIDL.Stub {
    boolean log;
    final IFlowSendMessageExtCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public String getScene() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowSendMessageExtCallbackIDLStub", "getScene()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowSendMessageExtCallbackIDLStub", "getScene() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowSendMessageExtCallbackIDLStub", "getScene", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowSendMessageExtCallbackIDLStub", "getScene()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getScene();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowSendMessageExtCallbackIDLStub", "getScene = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowSendMessageExtCallbackIDLStub", "getScene() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowSendMessageExtCallbackIDLStub", "getScene", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public FlowSendMessageExtCallbackIDLStubWrapper(IFlowSendMessageExtCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public FlowSendMessageExtCallbackIDLStubWrapper(IFlowSendMessageExtCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public Map getExt(Map r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowSendMessageExtCallbackIDLStub", "getExt(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowSendMessageExtCallbackIDLStub", "getExt(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowSendMessageExtCallbackIDLStub", "getExt", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowSendMessageExtCallbackIDLStub", "getExt(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        Map r113 = this.origin.getExt(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowSendMessageExtCallbackIDLStub", "getExt = " + r113);     // Catch: Exception -> L11
    L9:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r212 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowSendMessageExtCallbackIDLStub", "getExt(" + r210 + ", " + r211 + ") = " + r113, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowSendMessageExtCallbackIDLStub", "getExt", r115, r212);     // Catch: Exception -> L11
        return r113;
    }
}
