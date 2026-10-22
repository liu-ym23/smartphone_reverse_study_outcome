package com.obric.aiagent.flow.applog.idl;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class FlowAppLogIDLStubWrapper extends IFlowAppLogIDL.Stub {
    boolean log;
    final IFlowAppLogIDL.Stub origin;

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void clearLaunchService() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "clearLaunchService()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "clearLaunchService() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "clearLaunchService", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "clearLaunchService()");     // Catch: Exception -> L11
    L6:
        this.origin.clearLaunchService();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "clearLaunchService = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "clearLaunchService() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "clearLaunchService", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getDid() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "getDid()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "getDid() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "getDid", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "getDid()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getDid();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "getDid = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "getDid() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "getDid", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getIid() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "getIid()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "getIid() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "getIid", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "getIid()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getIid();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "getIid = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "getIid() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "getIid", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getSsid() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "getSsid()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "getSsid() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "getSsid", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "getSsid()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getSsid();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "getSsid = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "getSsid() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "getSsid", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserID() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "getUserID()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "getUserID() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "getUserID", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "getUserID()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getUserID();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "getUserID = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "getUserID() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "getUserID", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserUniqueID() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "getUserUniqueID()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "getUserUniqueID() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "getUserUniqueID", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "getUserUniqueID()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getUserUniqueID();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "getUserUniqueID = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "getUserUniqueID() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "getUserUniqueID", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onPause() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "onPause()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "onPause() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "onPause", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "onPause()");     // Catch: Exception -> L11
    L6:
        this.origin.onPause();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "onPause = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "onPause() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "onPause", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onStop() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "onStop()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "onStop() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "onStop", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "onStop()");     // Catch: Exception -> L11
    L6:
        this.origin.onStop();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "onStop = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "onStop() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "onStop", r113, r112);     // Catch: Exception -> L11
    }

    public FlowAppLogIDLStubWrapper(IFlowAppLogIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addDataObserver(IFlowAppLogDataObserverIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "addDataObserver(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "addDataObserver(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "addDataObserver", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "addDataObserver(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAppLogDataObserverIDL r112 = r210;
    L19:
        r106.addDataObserver(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "addDataObserver = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "addDataObserver(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "addDataObserver", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAppLogDataObserverIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAppLogDataObserverIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAppLogDataObserverIDL.Stub) == false) goto L17;
        r112 = c.a((IFlowAppLogDataObserverIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = c.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addEventObserver(IFlowAppLogEventObserverIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "addEventObserver(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "addEventObserver(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "addEventObserver", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "addEventObserver(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAppLogEventObserverIDL r112 = r210;
    L19:
        r106.addEventObserver(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "addEventObserver = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "addEventObserver(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "addEventObserver", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAppLogEventObserverIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAppLogEventObserverIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAppLogEventObserverIDL.Stub) == false) goto L17;
        r112 = f.a((IFlowAppLogEventObserverIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = f.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addSessionHook(IFlowAppLogSessionObserverIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "addSessionHook(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "addSessionHook(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "addSessionHook", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "addSessionHook(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAppLogSessionObserverIDL r112 = r210;
    L19:
        r106.addSessionHook(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "addSessionHook = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "addSessionHook(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "addSessionHook", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAppLogSessionObserverIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAppLogSessionObserverIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAppLogSessionObserverIDL.Stub) == false) goto L17;
        r112 = l.a((IFlowAppLogSessionObserverIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = l.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "onEventV3(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "onEventV3(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "onEventV3", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "onEventV3(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onEventV3(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "onEventV3 = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "onEventV3(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "onEventV3", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeDataObserver(IFlowAppLogDataObserverIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "removeDataObserver(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "removeDataObserver(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "removeDataObserver", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "removeDataObserver(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAppLogDataObserverIDL r112 = r210;
    L19:
        r106.removeDataObserver(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "removeDataObserver = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "removeDataObserver(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "removeDataObserver", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAppLogDataObserverIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAppLogDataObserverIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAppLogDataObserverIDL.Stub) == false) goto L17;
        r112 = c.a((IFlowAppLogDataObserverIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = c.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeEventObserver(IFlowAppLogEventObserverIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "removeEventObserver(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "removeEventObserver(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "removeEventObserver", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "removeEventObserver(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAppLogEventObserverIDL r112 = r210;
    L19:
        r106.removeEventObserver(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "removeEventObserver = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "removeEventObserver(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "removeEventObserver", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAppLogEventObserverIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAppLogEventObserverIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAppLogEventObserverIDL.Stub) == false) goto L17;
        r112 = f.a((IFlowAppLogEventObserverIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = f.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeSessionHook(IFlowAppLogSessionObserverIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "removeSessionHook(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "removeSessionHook(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "removeSessionHook", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "removeSessionHook(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowAppLogSessionObserverIDL r112 = r210;
    L19:
        r106.removeSessionHook(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "removeSessionHook = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "removeSessionHook(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "removeSessionHook", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowAppLogSessionObserverIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowAppLogSessionObserverIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowAppLogSessionObserverIDL.Stub) == false) goto L17;
        r112 = l.a((IFlowAppLogSessionObserverIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = l.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setHeaderInfo(Map r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "setHeaderInfo(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "setHeaderInfo(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "setHeaderInfo", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "setHeaderInfo(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setHeaderInfo(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "setHeaderInfo = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "setHeaderInfo(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "setHeaderInfo", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setLaunchService(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "setLaunchService(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "setLaunchService(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "setLaunchService", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "setLaunchService(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setLaunchService(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "setLaunchService = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "setLaunchService(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "setLaunchService", r113, r112);     // Catch: Exception -> L11
    }

    public FlowAppLogIDLStubWrapper(IFlowAppLogIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Bundle(String r210, Bundle r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "onEventV3Bundle(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "onEventV3Bundle(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "onEventV3Bundle", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "onEventV3Bundle(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onEventV3Bundle(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "onEventV3Bundle = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "onEventV3Bundle(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "onEventV3Bundle", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Json(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "onEventV3Json(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "onEventV3Json(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "onEventV3Json", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "onEventV3Json(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onEventV3Json(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "onEventV3Json = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "onEventV3Json(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "onEventV3Json", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onResume(String r210, int r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppLogIDLStub", "onResume(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppLogIDLStub", "onResume(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppLogIDLStub", "onResume", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppLogIDLStub", "onResume(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResume(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppLogIDLStub", "onResume = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppLogIDLStub", "onResume(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppLogIDLStub", "onResume", r113, r112);     // Catch: Exception -> L11
    }
}
