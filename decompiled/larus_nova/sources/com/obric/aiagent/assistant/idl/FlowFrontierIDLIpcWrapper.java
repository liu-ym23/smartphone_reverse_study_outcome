package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class FlowFrontierIDLIpcWrapper implements IFlowFrontierIDL {
    boolean log;
    final IFlowFrontierIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public int getState() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        int r110 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowFrontierIDLIPC", "getState()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "getState() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "getState", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "getState()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "getState()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getState();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowFrontierIDLIPC", "getState = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "getState() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowFrontierIDLIPC", "getState", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public FlowFrontierIDLIpcWrapper(IFlowFrontierIDL r100) throws RemoteException {
        this(r100, true);
    }

    public FlowFrontierIDLIpcWrapper(IFlowFrontierIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerDataListener(int r210, IFlowFrontierDataListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IFlowFrontierIDLIPC", "registerDataListener(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L43
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L43
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L43
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "registerDataListener(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L43
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "registerDataListener", r101, r102, r111);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "registerDataListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r107 = new StringBuilder("registerDataListener(");     // Catch: Exception -> L40 Throwable -> L43
        r107.append(r210);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L12;
    L20:
        IFlowFrontierDataListenerIDL r112 = r211;
    L21:
        r107.append(r112);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", r107.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r211 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L20;
        if ((r211 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L20;
        if ((r211 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L19;
        r112 = q1.a((IFlowFrontierDataListenerIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r112 = q1.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r108 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L26;
    L34:
        IFlowFrontierDataListenerIDL r113 = r211;
    L35:
        r108.registerDataListener(r210, r113);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IFlowFrontierIDLIPC", "registerDataListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r109 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "registerDataListener(" + r210 + ", " + r211 + ") = void", r115);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IFlowFrontierIDLIPC", "registerDataListener", r115, r114);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r211 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L34;
        if ((r211 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L34;
        if ((r211 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L33;
        r113 = q1.a((IFlowFrontierDataListenerIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r113 = q1.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerStateListener(int r210, IFlowFrontierStateListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IFlowFrontierIDLIPC", "registerStateListener(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L43
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L43
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L43
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "registerStateListener(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L43
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "registerStateListener", r101, r102, r111);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "registerStateListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r107 = new StringBuilder("registerStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        r107.append(r210);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L12;
    L20:
        IFlowFrontierStateListenerIDL r112 = r211;
    L21:
        r107.append(r112);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", r107.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r211 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r211 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L20;
        if ((r211 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L19;
        r112 = w1.a((IFlowFrontierStateListenerIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r112 = w1.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r108 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L26;
    L34:
        IFlowFrontierStateListenerIDL r113 = r211;
    L35:
        r108.registerStateListener(r210, r113);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IFlowFrontierIDLIPC", "registerStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r109 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "registerStateListener(" + r210 + ", " + r211 + ") = void", r115);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IFlowFrontierIDLIPC", "registerStateListener", r115, r114);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r211 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r211 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L34;
        if ((r211 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L33;
        r113 = w1.a((IFlowFrontierStateListenerIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r113 = w1.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterDataListener(int r210, IFlowFrontierDataListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IFlowFrontierIDLIPC", "unregisterDataListener(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L43
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L43
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L43
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "unregisterDataListener(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L43
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "unregisterDataListener", r101, r102, r111);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "unregisterDataListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r107 = new StringBuilder("unregisterDataListener(");     // Catch: Exception -> L40 Throwable -> L43
        r107.append(r210);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L12;
    L20:
        IFlowFrontierDataListenerIDL r112 = r211;
    L21:
        r107.append(r112);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", r107.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r211 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L20;
        if ((r211 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L20;
        if ((r211 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L19;
        r112 = q1.a((IFlowFrontierDataListenerIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r112 = q1.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r108 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L26;
    L34:
        IFlowFrontierDataListenerIDL r113 = r211;
    L35:
        r108.unregisterDataListener(r210, r113);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IFlowFrontierIDLIPC", "unregisterDataListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r109 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "unregisterDataListener(" + r210 + ", " + r211 + ") = void", r115);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IFlowFrontierIDLIPC", "unregisterDataListener", r115, r114);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r211 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L34;
        if ((r211 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L34;
        if ((r211 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L33;
        r113 = q1.a((IFlowFrontierDataListenerIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r113 = q1.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterStateListener(int r210, IFlowFrontierStateListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IFlowFrontierIDLIPC", "unregisterStateListener(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L43
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L43
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L43
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "unregisterStateListener(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L43
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "unregisterStateListener", r101, r102, r111);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "unregisterStateListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r107 = new StringBuilder("unregisterStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        r107.append(r210);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L12;
    L20:
        IFlowFrontierStateListenerIDL r112 = r211;
    L21:
        r107.append(r112);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", r107.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r211 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r211 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L20;
        if ((r211 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L19;
        r112 = w1.a((IFlowFrontierStateListenerIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r112 = w1.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r108 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L26;
    L34:
        IFlowFrontierStateListenerIDL r113 = r211;
    L35:
        r108.unregisterStateListener(r210, r113);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IFlowFrontierIDLIPC", "unregisterStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r109 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "unregisterStateListener(" + r210 + ", " + r211 + ") = void", r115);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IFlowFrontierIDLIPC", "unregisterStateListener", r115, r114);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r211 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r211 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L34;
        if ((r211 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L33;
        r113 = w1.a((IFlowFrontierStateListenerIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r113 = w1.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshot(int r210, Bitmap r211, Map r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowFrontierIDLIPC", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r213 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "cacheScreenshot", r101, r102, r213);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.cacheScreenshot(r210, r211, r212);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowFrontierIDLIPC", "cacheScreenshot = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowFrontierIDLIPC", "cacheScreenshot", r111, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void sendData(int r210, byte[] r211, Map r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowFrontierIDLIPC", "sendData(" + r210 + ", " + r211 + ", " + r212 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r213 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "sendData(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "sendData", r101, r102, r213);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "sendData(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "sendData(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.sendData(r210, r211, r212);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowFrontierIDLIPC", "sendData = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "sendData(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowFrontierIDLIPC", "sendData", r111, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshotFd(int r210, String r211, ParcelFileDescriptor r212, Map r213) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r114 = Math.max(0, r113 - r110) / 1000;     // Catch: Throwable -> L17
        int r100 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = fail", r112, r114);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "cacheScreenshotFd", r112, r114, r113);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r102 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.cacheScreenshotFd(r210, r211, r212, r213);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowFrontierIDLIPC", "cacheScreenshotFd = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r214 - r110) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = void", r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowFrontierIDLIPC", "cacheScreenshotFd", r115, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
