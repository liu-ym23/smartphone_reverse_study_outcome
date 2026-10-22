package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class AssistantInteractionListenerIDLStubWrapper extends IAssistantInteractionListenerIDL.Stub {
    boolean log;
    final IAssistantInteractionListenerIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantDied() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AssistantInteractionListenerIDLStub", "onAssistantDied()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AssistantInteractionListenerIDLStub", "onAssistantDied() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AssistantInteractionListenerIDLStub", "onAssistantDied", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AssistantInteractionListenerIDLStub", "onAssistantDied()");     // Catch: Exception -> L11
    L6:
        this.origin.onAssistantDied();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AssistantInteractionListenerIDLStub", "onAssistantDied = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AssistantInteractionListenerIDLStub", "onAssistantDied() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AssistantInteractionListenerIDLStub", "onAssistantDied", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantTakeOver() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AssistantInteractionListenerIDLStub", "onAssistantTakeOver()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AssistantInteractionListenerIDLStub", "onAssistantTakeOver() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AssistantInteractionListenerIDLStub", "onAssistantTakeOver", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AssistantInteractionListenerIDLStub", "onAssistantTakeOver()");     // Catch: Exception -> L11
    L6:
        this.origin.onAssistantTakeOver();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AssistantInteractionListenerIDLStub", "onAssistantTakeOver = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AssistantInteractionListenerIDLStub", "onAssistantTakeOver() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AssistantInteractionListenerIDLStub", "onAssistantTakeOver", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelCancel() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AssistantInteractionListenerIDLStub", "onPanelCancel()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AssistantInteractionListenerIDLStub", "onPanelCancel() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AssistantInteractionListenerIDLStub", "onPanelCancel", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AssistantInteractionListenerIDLStub", "onPanelCancel()");     // Catch: Exception -> L11
    L6:
        this.origin.onPanelCancel();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AssistantInteractionListenerIDLStub", "onPanelCancel = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AssistantInteractionListenerIDLStub", "onPanelCancel() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AssistantInteractionListenerIDLStub", "onPanelCancel", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanel() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanel()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AssistantInteractionListenerIDLStub", "requestToShowInputPanel() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AssistantInteractionListenerIDLStub", "requestToShowInputPanel", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AssistantInteractionListenerIDLStub", "requestToShowInputPanel()");     // Catch: Exception -> L11
    L6:
        this.origin.requestToShowInputPanel();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AssistantInteractionListenerIDLStub", "requestToShowInputPanel = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AssistantInteractionListenerIDLStub", "requestToShowInputPanel() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AssistantInteractionListenerIDLStub", "requestToShowInputPanel", r113, r112);     // Catch: Exception -> L11
    }

    public AssistantInteractionListenerIDLStubWrapper(IAssistantInteractionListenerIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelHeightChanged(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AssistantInteractionListenerIDLStub", "onPanelHeightChanged(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AssistantInteractionListenerIDLStub", "onPanelHeightChanged(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AssistantInteractionListenerIDLStub", "onPanelHeightChanged", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AssistantInteractionListenerIDLStub", "onPanelHeightChanged(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onPanelHeightChanged(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AssistantInteractionListenerIDLStub", "onPanelHeightChanged = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AssistantInteractionListenerIDLStub", "onPanelHeightChanged(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AssistantInteractionListenerIDLStub", "onPanelHeightChanged", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelShow(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AssistantInteractionListenerIDLStub", "onPanelShow(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AssistantInteractionListenerIDLStub", "onPanelShow(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AssistantInteractionListenerIDLStub", "onPanelShow", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AssistantInteractionListenerIDLStub", "onPanelShow(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onPanelShow(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AssistantInteractionListenerIDLStub", "onPanelShow = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AssistantInteractionListenerIDLStub", "onPanelShow(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AssistantInteractionListenerIDLStub", "onPanelShow", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onReply(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AssistantInteractionListenerIDLStub", "onReply(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AssistantInteractionListenerIDLStub", "onReply(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AssistantInteractionListenerIDLStub", "onReply", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AssistantInteractionListenerIDLStub", "onReply(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onReply(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AssistantInteractionListenerIDLStub", "onReply = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AssistantInteractionListenerIDLStub", "onReply(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AssistantInteractionListenerIDLStub", "onReply", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanelWithMeta(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.requestToShowInputPanelWithMeta(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta", r113, r112);     // Catch: Exception -> L11
    }

    public AssistantInteractionListenerIDLStubWrapper(IAssistantInteractionListenerIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
