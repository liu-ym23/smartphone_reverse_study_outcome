package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class FlowAssistantStateIDLStubWrapper extends IFlowAssistantStateIDL.Stub {
    boolean log;
    final IFlowAssistantStateIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public int getCurrentNightMode() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "getCurrentNightMode()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "getCurrentNightMode() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "getCurrentNightMode", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "getCurrentNightMode()");     // Catch: Exception -> L11
    L6:
        int r112 = this.origin.getCurrentNightMode();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "getCurrentNightMode = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "getCurrentNightMode() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "getCurrentNightMode", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isActive() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "isActive()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "isActive() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "isActive", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "isActive()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isActive();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "isActive = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "isActive() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "isActive", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isBackgroundIntercepting() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "isBackgroundIntercepting()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "isBackgroundIntercepting() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "isBackgroundIntercepting", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "isBackgroundIntercepting()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isBackgroundIntercepting();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "isBackgroundIntercepting = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "isBackgroundIntercepting() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "isBackgroundIntercepting", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public FlowAssistantStateIDLStubWrapper(IFlowAssistantStateIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "registerActiveStateListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "registerActiveStateListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "registerActiveStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "registerActiveStateListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAssistantActiveStateListenerIDL r112 = r210;
    L19:
        r106.registerActiveStateListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "registerActiveStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "registerActiveStateListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "registerActiveStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAssistantActiveStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAssistantActiveStateListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAssistantActiveStateListenerIDL.Stub) == false) goto L17;
        r112 = p0.a((IFlowAssistantActiveStateListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = p0.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowBackgroundInterceptStateListenerIDL r112 = r210;
    L19:
        r106.registerBackgroundInterceptingListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowBackgroundInterceptStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowBackgroundInterceptStateListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowBackgroundInterceptStateListenerIDL.Stub) == false) goto L17;
        r112 = y0.a((IFlowBackgroundInterceptStateListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = y0.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerNightModeListener(IFlowNightModeChangeListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "registerNightModeListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "registerNightModeListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "registerNightModeListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "registerNightModeListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowNightModeChangeListenerIDL r112 = r210;
    L19:
        r106.registerNightModeListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "registerNightModeListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "registerNightModeListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "registerNightModeListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowNightModeChangeListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowNightModeChangeListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowNightModeChangeListenerIDL.Stub) == false) goto L17;
        r112 = x2.a((IFlowNightModeChangeListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = x2.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "registerTTSStateListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "registerTTSStateListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "registerTTSStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "registerTTSStateListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAssistantTTSStateListenerIDL r112 = r210;
    L19:
        r106.registerTTSStateListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "registerTTSStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "registerTTSStateListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "registerTTSStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAssistantTTSStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAssistantTTSStateListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAssistantTTSStateListenerIDL.Stub) == false) goto L17;
        r112 = v0.a((IFlowAssistantTTSStateListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = v0.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "unregisterActiveStateListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "unregisterActiveStateListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "unregisterActiveStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "unregisterActiveStateListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAssistantActiveStateListenerIDL r112 = r210;
    L19:
        r106.unregisterActiveStateListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "unregisterActiveStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "unregisterActiveStateListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "unregisterActiveStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAssistantActiveStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAssistantActiveStateListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAssistantActiveStateListenerIDL.Stub) == false) goto L17;
        r112 = p0.a((IFlowAssistantActiveStateListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = p0.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowBackgroundInterceptStateListenerIDL r112 = r210;
    L19:
        r106.unregisterBackgroundInterceptingListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowBackgroundInterceptStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowBackgroundInterceptStateListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowBackgroundInterceptStateListenerIDL.Stub) == false) goto L17;
        r112 = y0.a((IFlowBackgroundInterceptStateListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = y0.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "unregisterNightModeListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "unregisterNightModeListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "unregisterNightModeListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "unregisterNightModeListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowNightModeChangeListenerIDL r112 = r210;
    L19:
        r106.unregisterNightModeListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "unregisterNightModeListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "unregisterNightModeListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "unregisterNightModeListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowNightModeChangeListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowNightModeChangeListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowNightModeChangeListenerIDL.Stub) == false) goto L17;
        r112 = x2.a((IFlowNightModeChangeListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = x2.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAssistantStateIDLStub", "unregisterTTSStateListener(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAssistantStateIDLStub", "unregisterTTSStateListener(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAssistantStateIDLStub", "unregisterTTSStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAssistantStateIDLStub", "unregisterTTSStateListener(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAssistantTTSStateListenerIDL r112 = r210;
    L19:
        r106.unregisterTTSStateListener(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAssistantStateIDLStub", "unregisterTTSStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAssistantStateIDLStub", "unregisterTTSStateListener(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAssistantStateIDLStub", "unregisterTTSStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAssistantTTSStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAssistantTTSStateListenerIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAssistantTTSStateListenerIDL.Stub) == false) goto L17;
        r112 = v0.a((IFlowAssistantTTSStateListenerIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = v0.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    public FlowAssistantStateIDLStubWrapper(IFlowAssistantStateIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
