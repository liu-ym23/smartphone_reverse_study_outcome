package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class FlowVoiceInteractionIDLIpcWrapper implements IFlowVoiceInteractionIDL {
    boolean log;
    final IFlowVoiceInteractionIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean closeContinuousTalk() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.closeContinuousTalk();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean isInRealtimeCalling() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isInRealtimeCalling();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean isInteractionSessionStateListening() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isInteractionSessionStateListening();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public FlowVoiceInteractionIDLIpcWrapper(IFlowVoiceInteractionIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void readContent(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "readContent(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "readContent(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "readContent", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "readContent(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "readContent(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.readContent(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "readContent = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "readContent(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "readContent", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void readContentByMessage(IMMessage r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "readContentByMessage", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.readContentByMessage(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "readContentByMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "readContentByMessage", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void replayMessageTts(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "replayMessageTts", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.replayMessageTts(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "replayMessageTts = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "replayMessageTts", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void requireSyncData(IFlowSyncDataResultIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "requireSyncData(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "requireSyncData(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "requireSyncData", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "requireSyncData(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("requireSyncData(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IFlowSyncDataResultIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof FlowSyncDataResultIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof FlowSyncDataResultIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IFlowSyncDataResultIDL.Stub) == false) goto L19;
        r113 = s3.a((IFlowSyncDataResultIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = s3.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowVoiceInteractionIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IFlowSyncDataResultIDL r114 = r210;
    L35:
        r107.requireSyncData(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "requireSyncData = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "requireSyncData(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "requireSyncData", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r210 instanceof FlowSyncDataResultIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof FlowSyncDataResultIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IFlowSyncDataResultIDL.Stub) == false) goto L33;
        r114 = s3.a((IFlowSyncDataResultIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = s3.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean tryInterruptAssistant(AppEvent r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.tryInterruptAssistant(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void tryOpenClickTalk(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.tryOpenClickTalk(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean tryOpenMicToRecording(AppEvent r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.tryOpenMicToRecording(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void updateIntentExt(Map r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "updateIntentExt", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateIntentExt(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "updateIntentExt = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "updateIntentExt", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void updateScreenshotForAsr(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateScreenshotForAsr(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void wakeupAssistant(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "wakeupAssistant", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.wakeupAssistant(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowVoiceInteractionIDLIPC", "wakeupAssistant = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowVoiceInteractionIDLIPC", "wakeupAssistant", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowVoiceInteractionIDLIpcWrapper(IFlowVoiceInteractionIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
