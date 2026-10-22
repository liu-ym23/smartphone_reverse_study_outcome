package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class FlowFrontierIDLStubWrapper extends IFlowFrontierIDL.Stub {
    boolean log;
    final IFlowFrontierIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public int getState() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowFrontierIDLStub", "getState()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowFrontierIDLStub", "getState() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowFrontierIDLStub", "getState", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowFrontierIDLStub", "getState()");     // Catch: Exception -> L11
    L6:
        int r112 = this.origin.getState();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowFrontierIDLStub", "getState = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowFrontierIDLStub", "getState() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowFrontierIDLStub", "getState", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public FlowFrontierIDLStubWrapper(IFlowFrontierIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public FlowFrontierIDLStubWrapper(IFlowFrontierIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerDataListener(int r210, IFlowFrontierDataListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowFrontierIDLStub", "registerDataListener(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowFrontierIDLStub", "registerDataListener(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowFrontierIDLStub", "registerDataListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowFrontierIDLStub", "registerDataListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowFrontierIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IFlowFrontierDataListenerIDL r112 = r211;
    L19:
        r106.registerDataListener(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowFrontierIDLStub", "registerDataListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowFrontierIDLStub", "registerDataListener(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowFrontierIDLStub", "registerDataListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L17;
        r112 = q1.a((IFlowFrontierDataListenerIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = q1.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerStateListener(int r210, IFlowFrontierStateListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowFrontierIDLStub", "registerStateListener(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowFrontierIDLStub", "registerStateListener(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowFrontierIDLStub", "registerStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowFrontierIDLStub", "registerStateListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowFrontierIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IFlowFrontierStateListenerIDL r112 = r211;
    L19:
        r106.registerStateListener(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowFrontierIDLStub", "registerStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowFrontierIDLStub", "registerStateListener(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowFrontierIDLStub", "registerStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L17;
        r112 = w1.a((IFlowFrontierStateListenerIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = w1.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterDataListener(int r210, IFlowFrontierDataListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowFrontierIDLStub", "unregisterDataListener(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowFrontierIDLStub", "unregisterDataListener(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowFrontierIDLStub", "unregisterDataListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowFrontierIDLStub", "unregisterDataListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowFrontierIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IFlowFrontierDataListenerIDL r112 = r211;
    L19:
        r106.unregisterDataListener(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowFrontierIDLStub", "unregisterDataListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowFrontierIDLStub", "unregisterDataListener(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowFrontierIDLStub", "unregisterDataListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L17;
        r112 = q1.a((IFlowFrontierDataListenerIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = q1.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterStateListener(int r210, IFlowFrontierStateListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowFrontierIDLStub", "unregisterStateListener(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowFrontierIDLStub", "unregisterStateListener(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowFrontierIDLStub", "unregisterStateListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowFrontierIDLStub", "unregisterStateListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowFrontierIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IFlowFrontierStateListenerIDL r112 = r211;
    L19:
        r106.unregisterStateListener(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowFrontierIDLStub", "unregisterStateListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowFrontierIDLStub", "unregisterStateListener(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowFrontierIDLStub", "unregisterStateListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L17;
        r112 = w1.a((IFlowFrontierStateListenerIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = w1.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshot(int r210, Bitmap r211, Map r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowFrontierIDLStub", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowFrontierIDLStub", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowFrontierIDLStub", "cacheScreenshot", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowFrontierIDLStub", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.cacheScreenshot(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowFrontierIDLStub", "cacheScreenshot = void");     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowFrontierIDLStub", "cacheScreenshot(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowFrontierIDLStub", "cacheScreenshot", r111, r214);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void sendData(int r210, byte[] r211, Map r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowFrontierIDLStub", "sendData(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowFrontierIDLStub", "sendData(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowFrontierIDLStub", "sendData", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowFrontierIDLStub", "sendData(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.sendData(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowFrontierIDLStub", "sendData = void");     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowFrontierIDLStub", "sendData(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowFrontierIDLStub", "sendData", r111, r214);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshotFd(int r210, String r211, ParcelFileDescriptor r212, Map r213) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowFrontierIDLStub", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")", e);
        IPCException r100 = new IPCException(e);
        long r112 = SystemClock.elapsedRealtimeNanos();
        long r113 = Math.max(0, r112 - r110) / 1000;
        int r101 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowFrontierIDLStub", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = fail", r100, r113);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowFrontierIDLStub", "cacheScreenshotFd", r100, r113, r112);
        throw r100;
    L4:
        if (this.log == false) goto L6;
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowFrontierIDLStub", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.cacheScreenshotFd(r210, r211, r212, r213);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowFrontierIDLStub", "cacheScreenshotFd = void");     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r114 = Math.max(0, r214 - r110) / 1000;     // Catch: Exception -> L11
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowFrontierIDLStub", "cacheScreenshotFd(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = void", r114);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowFrontierIDLStub", "cacheScreenshotFd", r114, r214);     // Catch: Exception -> L11
    }
}
