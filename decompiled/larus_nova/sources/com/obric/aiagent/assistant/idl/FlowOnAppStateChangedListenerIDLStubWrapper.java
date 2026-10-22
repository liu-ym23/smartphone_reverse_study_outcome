package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class FlowOnAppStateChangedListenerIDLStubWrapper extends IFlowOnAppStateChangedListenerIDL.Stub {
    boolean log;
    final IFlowOnAppStateChangedListenerIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAllActivityDestroyed() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed()");     // Catch: Exception -> L11
    L6:
        this.origin.onAllActivityDestroyed();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppBackground() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowOnAppStateChangedListenerIDLStub", "onAppBackground()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowOnAppStateChangedListenerIDLStub", "onAppBackground() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowOnAppStateChangedListenerIDLStub", "onAppBackground", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowOnAppStateChangedListenerIDLStub", "onAppBackground()");     // Catch: Exception -> L11
    L6:
        this.origin.onAppBackground();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowOnAppStateChangedListenerIDLStub", "onAppBackground = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowOnAppStateChangedListenerIDLStub", "onAppBackground() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowOnAppStateChangedListenerIDLStub", "onAppBackground", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppForeground() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowOnAppStateChangedListenerIDLStub", "onAppForeground()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowOnAppStateChangedListenerIDLStub", "onAppForeground() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowOnAppStateChangedListenerIDLStub", "onAppForeground", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowOnAppStateChangedListenerIDLStub", "onAppForeground()");     // Catch: Exception -> L11
    L6:
        this.origin.onAppForeground();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowOnAppStateChangedListenerIDLStub", "onAppForeground = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowOnAppStateChangedListenerIDLStub", "onAppForeground() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowOnAppStateChangedListenerIDLStub", "onAppForeground", r113, r112);     // Catch: Exception -> L11
    }

    public FlowOnAppStateChangedListenerIDLStubWrapper(IFlowOnAppStateChangedListenerIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public FlowOnAppStateChangedListenerIDLStubWrapper(IFlowOnAppStateChangedListenerIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onMainBotChatPageResume(boolean r210, boolean r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onMainBotChatPageResume(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume", r113, r112);     // Catch: Exception -> L11
    }
}
