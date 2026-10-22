package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class FlowAppStateIDLIpcWrapper implements IFlowAppStateIDL {
    boolean log;
    final IFlowAppStateIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public String getCurrentActivity() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        String r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppStateIDLIPC", "getCurrentActivity()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppStateIDLIPC", "getCurrentActivity() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppStateIDLIPC", "getCurrentActivity", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", "getCurrentActivity()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", "getCurrentActivity()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getCurrentActivity();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppStateIDLIPC", "getCurrentActivity = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppStateIDLIPC", "getCurrentActivity() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppStateIDLIPC", "getCurrentActivity", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppBackground() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppStateIDLIPC", "isAppBackground()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppStateIDLIPC", "isAppBackground() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppStateIDLIPC", "isAppBackground", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", "isAppBackground()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", "isAppBackground()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isAppBackground();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppStateIDLIPC", "isAppBackground = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppStateIDLIPC", "isAppBackground() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppStateIDLIPC", "isAppBackground", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppPaused() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppStateIDLIPC", "isAppPaused()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppStateIDLIPC", "isAppPaused() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppStateIDLIPC", "isAppPaused", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", "isAppPaused()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", "isAppPaused()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isAppPaused();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppStateIDLIPC", "isAppPaused = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppStateIDLIPC", "isAppPaused() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppStateIDLIPC", "isAppPaused", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public FlowAppStateIDLIpcWrapper(IFlowAppStateIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IFlowAppStateIDLIPC", "registerAppStateListener(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAppStateIDLIPC", "registerAppStateListener(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppStateIDLIPC", "registerAppStateListener", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", "registerAppStateListener(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("registerAppStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IFlowOnAppStateChangedListenerIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IFlowOnAppStateChangedListenerIDL.Stub) == false) goto L19;
        r113 = a3.a((IFlowOnAppStateChangedListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = a3.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppStateIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IFlowOnAppStateChangedListenerIDL r114 = r210;
    L35:
        r107.registerAppStateListener(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IFlowAppStateIDLIPC", "registerAppStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAppStateIDLIPC", "registerAppStateListener(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IFlowAppStateIDLIPC", "registerAppStateListener", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IFlowOnAppStateChangedListenerIDL.Stub) == false) goto L33;
        r114 = a3.a((IFlowOnAppStateChangedListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = a3.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IFlowAppStateIDLIPC", "unregisterAppStateListener(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAppStateIDLIPC", "unregisterAppStateListener(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppStateIDLIPC", "unregisterAppStateListener", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", "unregisterAppStateListener(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("unregisterAppStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IFlowOnAppStateChangedListenerIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowAppStateIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IFlowOnAppStateChangedListenerIDL.Stub) == false) goto L19;
        r113 = a3.a((IFlowOnAppStateChangedListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = a3.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppStateIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IFlowOnAppStateChangedListenerIDL r114 = r210;
    L35:
        r107.unregisterAppStateListener(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IFlowAppStateIDLIPC", "unregisterAppStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAppStateIDLIPC", "unregisterAppStateListener(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IFlowAppStateIDLIPC", "unregisterAppStateListener", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof FlowOnAppStateChangedListenerIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IFlowOnAppStateChangedListenerIDL.Stub) == false) goto L33;
        r114 = a3.a((IFlowOnAppStateChangedListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = a3.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    public FlowAppStateIDLIpcWrapper(IFlowAppStateIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
