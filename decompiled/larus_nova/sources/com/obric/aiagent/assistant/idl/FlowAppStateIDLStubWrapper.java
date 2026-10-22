package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class FlowAppStateIDLStubWrapper extends IFlowAppStateIDL.Stub {
    boolean log;
    final IFlowAppStateIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public String getCurrentActivity() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppStateIDLStub", "getCurrentActivity()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppStateIDLStub", "getCurrentActivity() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppStateIDLStub", "getCurrentActivity", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppStateIDLStub", "getCurrentActivity()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getCurrentActivity();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppStateIDLStub", "getCurrentActivity = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppStateIDLStub", "getCurrentActivity() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppStateIDLStub", "getCurrentActivity", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppBackground() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppStateIDLStub", "isAppBackground()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppStateIDLStub", "isAppBackground() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppStateIDLStub", "isAppBackground", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppStateIDLStub", "isAppBackground()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isAppBackground();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppStateIDLStub", "isAppBackground = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppStateIDLStub", "isAppBackground() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppStateIDLStub", "isAppBackground", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppPaused() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppStateIDLStub", "isAppPaused()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppStateIDLStub", "isAppPaused() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppStateIDLStub", "isAppPaused", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppStateIDLStub", "isAppPaused()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isAppPaused();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppStateIDLStub", "isAppPaused = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppStateIDLStub", "isAppPaused() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppStateIDLStub", "isAppPaused", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public FlowAppStateIDLStubWrapper(IFlowAppStateIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppStateIDLStub", "registerAppStateListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppStateIDLStub", "registerAppStateListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppStateIDLStub", "registerAppStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppStateIDLStub", "registerAppStateListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowOnAppStateChangedListenerIDL r112 = r210;
    L19:
        r106.registerAppStateListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppStateIDLStub", "registerAppStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppStateIDLStub", "registerAppStateListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppStateIDLStub", "registerAppStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowOnAppStateChangedListenerIDL.Stub) == false) goto L17;
        r112 = a3.a((IFlowOnAppStateChangedListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = a3.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppStateIDLStub", "unregisterAppStateListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppStateIDLStub", "unregisterAppStateListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppStateIDLStub", "unregisterAppStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppStateIDLStub", "unregisterAppStateListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowOnAppStateChangedListenerIDL r112 = r210;
    L19:
        r106.unregisterAppStateListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppStateIDLStub", "unregisterAppStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppStateIDLStub", "unregisterAppStateListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppStateIDLStub", "unregisterAppStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowOnAppStateChangedListenerIDL.Stub) == false) goto L17;
        r112 = a3.a((IFlowOnAppStateChangedListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = a3.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    public FlowAppStateIDLStubWrapper(IFlowAppStateIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
