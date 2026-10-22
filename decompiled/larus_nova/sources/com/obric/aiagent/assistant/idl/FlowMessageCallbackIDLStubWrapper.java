package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class FlowMessageCallbackIDLStubWrapper extends IFlowMessageCallbackIDL.Stub {
    boolean log;
    final IFlowMessageCallbackIDL.Stub origin;

    public FlowMessageCallbackIDLStubWrapper(IFlowMessageCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onInsertMessageList(List<IMMessage> r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowMessageCallbackIDLStub", "onInsertMessageList(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowMessageCallbackIDLStub", "onInsertMessageList(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowMessageCallbackIDLStub", "onInsertMessageList", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowMessageCallbackIDLStub", "onInsertMessageList(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onInsertMessageList(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowMessageCallbackIDLStub", "onInsertMessageList = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowMessageCallbackIDLStub", "onInsertMessageList(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowMessageCallbackIDLStub", "onInsertMessageList", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onReceiveMessage(IMMessage r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowMessageCallbackIDLStub", "onReceiveMessage(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowMessageCallbackIDLStub", "onReceiveMessage(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowMessageCallbackIDLStub", "onReceiveMessage", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowMessageCallbackIDLStub", "onReceiveMessage(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onReceiveMessage(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowMessageCallbackIDLStub", "onReceiveMessage = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowMessageCallbackIDLStub", "onReceiveMessage(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowMessageCallbackIDLStub", "onReceiveMessage", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onRegenMessage(IMMessage r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowMessageCallbackIDLStub", "onRegenMessage(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowMessageCallbackIDLStub", "onRegenMessage(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowMessageCallbackIDLStub", "onRegenMessage", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowMessageCallbackIDLStub", "onRegenMessage(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onRegenMessage(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowMessageCallbackIDLStub", "onRegenMessage = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowMessageCallbackIDLStub", "onRegenMessage(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowMessageCallbackIDLStub", "onRegenMessage", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onSendMessage(IMMessage r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowMessageCallbackIDLStub", "onSendMessage(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowMessageCallbackIDLStub", "onSendMessage(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowMessageCallbackIDLStub", "onSendMessage", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowMessageCallbackIDLStub", "onSendMessage(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSendMessage(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowMessageCallbackIDLStub", "onSendMessage = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowMessageCallbackIDLStub", "onSendMessage(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowMessageCallbackIDLStub", "onSendMessage", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onUpdateMessage(IMMessage r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowMessageCallbackIDLStub", "onUpdateMessage(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowMessageCallbackIDLStub", "onUpdateMessage(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowMessageCallbackIDLStub", "onUpdateMessage", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowMessageCallbackIDLStub", "onUpdateMessage(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onUpdateMessage(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowMessageCallbackIDLStub", "onUpdateMessage = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowMessageCallbackIDLStub", "onUpdateMessage(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowMessageCallbackIDLStub", "onUpdateMessage", r113, r112);     // Catch: Exception -> L11
    }

    public FlowMessageCallbackIDLStubWrapper(IFlowMessageCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
