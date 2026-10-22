package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class AssistantInteractionListenerIDLIpcWrapper implements IAssistantInteractionListenerIDL {
    boolean log;
    final IAssistantInteractionListenerIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantDied() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAssistantInteractionListenerIDLIPC", "onAssistantDied()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAssistantInteractionListenerIDLIPC", "onAssistantDied() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAssistantInteractionListenerIDLIPC", "onAssistantDied", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onAssistantDied()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onAssistantDied()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAssistantDied();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAssistantInteractionListenerIDLIPC", "onAssistantDied = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAssistantInteractionListenerIDLIPC", "onAssistantDied() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAssistantInteractionListenerIDLIPC", "onAssistantDied", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantTakeOver() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAssistantInteractionListenerIDLIPC", "onAssistantTakeOver()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAssistantInteractionListenerIDLIPC", "onAssistantTakeOver() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAssistantInteractionListenerIDLIPC", "onAssistantTakeOver", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onAssistantTakeOver()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onAssistantTakeOver()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAssistantTakeOver();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAssistantInteractionListenerIDLIPC", "onAssistantTakeOver = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAssistantInteractionListenerIDLIPC", "onAssistantTakeOver() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAssistantInteractionListenerIDLIPC", "onAssistantTakeOver", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelCancel() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAssistantInteractionListenerIDLIPC", "onPanelCancel()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAssistantInteractionListenerIDLIPC", "onPanelCancel() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAssistantInteractionListenerIDLIPC", "onPanelCancel", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onPanelCancel()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onPanelCancel()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onPanelCancel();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAssistantInteractionListenerIDLIPC", "onPanelCancel = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAssistantInteractionListenerIDLIPC", "onPanelCancel() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAssistantInteractionListenerIDLIPC", "onPanelCancel", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanel() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanel()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanel() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanel", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanel()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanel()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.requestToShowInputPanel();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanel = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanel() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanel", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public AssistantInteractionListenerIDLIpcWrapper(IAssistantInteractionListenerIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelHeightChanged(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAssistantInteractionListenerIDLIPC", "onPanelHeightChanged(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAssistantInteractionListenerIDLIPC", "onPanelHeightChanged(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAssistantInteractionListenerIDLIPC", "onPanelHeightChanged", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onPanelHeightChanged(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onPanelHeightChanged(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onPanelHeightChanged(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAssistantInteractionListenerIDLIPC", "onPanelHeightChanged = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAssistantInteractionListenerIDLIPC", "onPanelHeightChanged(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAssistantInteractionListenerIDLIPC", "onPanelHeightChanged", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelShow(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAssistantInteractionListenerIDLIPC", "onPanelShow(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAssistantInteractionListenerIDLIPC", "onPanelShow(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAssistantInteractionListenerIDLIPC", "onPanelShow", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onPanelShow(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onPanelShow(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onPanelShow(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAssistantInteractionListenerIDLIPC", "onPanelShow = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAssistantInteractionListenerIDLIPC", "onPanelShow(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAssistantInteractionListenerIDLIPC", "onPanelShow", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onReply(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAssistantInteractionListenerIDLIPC", "onReply(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAssistantInteractionListenerIDLIPC", "onReply(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAssistantInteractionListenerIDLIPC", "onReply", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onReply(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "onReply(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onReply(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAssistantInteractionListenerIDLIPC", "onReply = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAssistantInteractionListenerIDLIPC", "onReply(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAssistantInteractionListenerIDLIPC", "onReply", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanelWithMeta(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanelWithMeta(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanelWithMeta(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanelWithMeta", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanelWithMeta(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanelWithMeta(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.requestToShowInputPanelWithMeta(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanelWithMeta = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanelWithMeta(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAssistantInteractionListenerIDLIPC", "requestToShowInputPanelWithMeta", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public AssistantInteractionListenerIDLIpcWrapper(IAssistantInteractionListenerIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
