package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class FlowNetworkIDLStubWrapper extends IFlowNetworkIDL.Stub {
    boolean log;
    final IFlowNetworkIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public int getCurrentNetworkStatus() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "getCurrentNetworkStatus()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "getCurrentNetworkStatus() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "getCurrentNetworkStatus", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "getCurrentNetworkStatus()");     // Catch: Exception -> L11
    L6:
        int r112 = this.origin.getCurrentNetworkStatus();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "getCurrentNetworkStatus = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "getCurrentNetworkStatus() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "getCurrentNetworkStatus", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public FlowNetworkIDLStubWrapper(IFlowNetworkIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttp(long r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyStopComplexTaskByHttp(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp", r113, r112);     // Catch: Exception -> L11
    }

    public FlowNetworkIDLStubWrapper(IFlowNetworkIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void clearOmniTasks(Map r210, IFlowNetworkResultCallbackIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "clearOmniTasks(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "clearOmniTasks(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "clearOmniTasks", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "clearOmniTasks(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r112 = r211;
    L19:
        r106.clearOmniTasks(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "clearOmniTasks = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "clearOmniTasks(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "clearOmniTasks", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r112 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = u2.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttpWithScene(long r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r212 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r212 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene", r101, r102, r212);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyStopComplexTaskByHttpWithScene(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene = void");     // Catch: Exception -> L11
    L9:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene(" + r210 + ", " + r211 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene", r111, r213);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyUserOperateQueue(String r210, IFlowNetworkResultCallbackIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "notifyUserOperateQueue(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "notifyUserOperateQueue(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "notifyUserOperateQueue", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "notifyUserOperateQueue(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r112 = r211;
    L19:
        r106.notifyUserOperateQueue(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "notifyUserOperateQueue = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "notifyUserOperateQueue(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "notifyUserOperateQueue", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r112 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = u2.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sweepConditionalTask(ObricConditionalTaskSweepRequest r210, IFlowNetworkResultCallbackIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "sweepConditionalTask(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "sweepConditionalTask(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "sweepConditionalTask", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "sweepConditionalTask(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r112 = r211;
    L19:
        r106.sweepConditionalTask(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "sweepConditionalTask = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "sweepConditionalTask(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "sweepConditionalTask", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r112 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = u2.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void deleteConditionalTask(String r210, Map r211, IFlowNetworkResultCallbackIDL r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "deleteConditionalTask(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "deleteConditionalTask(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "deleteConditionalTask", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "deleteConditionalTask(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r212 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r111 = r212;
    L19:
        r106.deleteConditionalTask(r210, r211, r111);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "deleteConditionalTask = void");     // Catch: Exception -> L24
    L22:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r112 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "deleteConditionalTask(" + r210 + ", " + r211 + ", " + r212 + ") = void", r112);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "deleteConditionalTask", r112, r214);     // Catch: Exception -> L24
        return;
    L10:
        if ((r212 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r212 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r212 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r111 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r212);     // Catch: Exception -> L24
        goto L19
    L17:
        r111 = u2.b(r212);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopOmniTaskByHttp(String r210, Map r211, IFlowNetworkResultCallbackIDL r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r212 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r111 = r212;
    L19:
        r106.notifyStopOmniTaskByHttp(r210, r211, r111);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp = void");     // Catch: Exception -> L24
    L22:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r112 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp(" + r210 + ", " + r211 + ", " + r212 + ") = void", r112);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp", r112, r214);     // Catch: Exception -> L24
        return;
    L10:
        if ((r212 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r212 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r212 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r111 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r212);     // Catch: Exception -> L24
        goto L19
    L17:
        r111 = u2.b(r212);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r210, boolean r211, IFlowNetworkResultCallbackIDL r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r212 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r111 = r212;
    L19:
        r106.sendIntentResultForAsyncNotifyByHttp(r210, r211, r111);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp = void");     // Catch: Exception -> L24
    L22:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r112 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp(" + r210 + ", " + r211 + ", " + r212 + ") = void", r112);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp", r112, r214);     // Catch: Exception -> L24
        return;
    L10:
        if ((r212 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r212 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r212 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r111 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r212);     // Catch: Exception -> L24
        goto L19
    L17:
        r111 = u2.b(r212);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForCompensationByHttp(List<OPushEvent> r210, boolean r211, IFlowNetworkResultCallbackIDL r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r212 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r111 = r212;
    L19:
        r106.sendIntentResultForCompensationByHttp(r210, r211, r111);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp = void");     // Catch: Exception -> L24
    L22:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r112 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp(" + r210 + ", " + r211 + ", " + r212 + ") = void", r112);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp", r112, r214);     // Catch: Exception -> L24
        return;
    L10:
        if ((r212 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r212 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r212 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r111 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r212);     // Catch: Exception -> L24
        goto L19
    L17:
        r111 = u2.b(r212);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendNormalRouterByHttp(String r210, String r211, IFlowNetworkResultCallbackIDL r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", "sendNormalRouterByHttp(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", "sendNormalRouterByHttp(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "sendNormalRouterByHttp", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "sendNormalRouterByHttp(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r212 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r111 = r212;
    L19:
        r106.sendNormalRouterByHttp(r210, r211, r111);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "sendNormalRouterByHttp = void");     // Catch: Exception -> L24
    L22:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r112 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", "sendNormalRouterByHttp(" + r210 + ", " + r211 + ", " + r212 + ") = void", r112);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "sendNormalRouterByHttp", r112, r214);     // Catch: Exception -> L24
        return;
    L10:
        if ((r212 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r212 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r212 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r111 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r212);     // Catch: Exception -> L24
        goto L19
    L17:
        r111 = u2.b(r212);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendReplyAskUserByHttp(String r310, String r311, String r312, Map r313, IFlowNetworkResultCallbackIDL r314) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L36:
        e = e;
        String r100 = "sendReplyAskUserByHttp(";
        String r210 = ")";
        long r101 = 0;
        IFlowNetworkResultCallbackIDL r102 = r314;
    L38:
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowNetworkIDLStub", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + r210, e);
        IPCException r104 = new IPCException(e);
        long r211 = SystemClock.elapsedRealtimeNanos();
        long r105 = Math.max(r101, r211 - r110) / 1000;
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowNetworkIDLStub", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + ") = fail", r104, r105);
        IPCAnomalyTrace r107 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "sendReplyAskUserByHttp", r104, r105, r211);
        throw r104;
    L4:
        if (this.log == false) goto L6;
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L36
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "sendReplyAskUserByHttp(" + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r314 + ")");     // Catch: Exception -> L36
    L6:
        IFlowNetworkIDL.Stub r109 = this.origin;     // Catch: Exception -> L36
        if (r314 != null) goto L10;
    L19:
        IFlowNetworkResultCallbackIDL r111 = r314;
    L20:
        r210 = ")";
        r109.sendReplyAskUserByHttp(r310, r311, r312, r313, r111);     // Catch: Exception -> L34
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.h.d("FlowNetworkIDLStub", "sendReplyAskUserByHttp = void");     // Catch: Exception -> L34
    L24:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L34
        long r112 = Math.max(0, r212 - r110) / 1000;     // Catch: Exception -> L34
        int r113 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L34
        r100 = "sendReplyAskUserByHttp(";
        StringBuilder r114 = new StringBuilder(r100);     // Catch: Exception -> L32
        r114.append(r310);     // Catch: Exception -> L32
        r114.append(", ");     // Catch: Exception -> L32
        r114.append(r311);     // Catch: Exception -> L32
        r114.append(", ");     // Catch: Exception -> L32
        r114.append(r312);     // Catch: Exception -> L32
        r114.append(", ");     // Catch: Exception -> L32
        r114.append(r313);     // Catch: Exception -> L32
        r114.append(", ");     // Catch: Exception -> L32
        r102 = r314;
        r101 = 0;
        r114.append(r102);     // Catch: Exception -> L30
        r114.append(") = void");     // Catch: Exception -> L30
        com.obric.aiagent.ipc.utils.i.d("FlowNetworkIDLStub", r114.toString(), r112);     // Catch: Exception -> L30
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "sendReplyAskUserByHttp", r112, r212);     // Catch: Exception -> L30
        return;
    L30:
        e = e;
    L32:
        e = e;
        r102 = r314;
        r101 = 0;
    L34:
        e = e;
        r102 = r314;
        r101 = 0;
        r100 = "sendReplyAskUserByHttp(";
        goto L38
    L10:
        if ((r314 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L19;
        if ((r314 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L19;
        if ((r314 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r111 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r314);     // Catch: Exception -> L36
        goto L20
    L17:
        r111 = u2.b(r314);     // Catch: Exception -> L36
        goto L20
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadUserTakeOverByHttp(String r210, String r211, String r212, long r213, Map r310, IFlowNetworkResultCallbackIDL r311) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = e;
        String r111 = "FlowNetworkIDLStub";
        String r112 = ", ";
        String r214 = ")";
        IFlowNetworkResultCallbackIDL r100 = r311;
        String r101 = "uploadUserTakeOverByHttp(";
    L42:
        int r102 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b(r111, r101 + r210 + r112 + r211 + r112 + r212 + r112 + r213 + r112 + r310 + r112 + r100 + r214, e);
        IPCException r103 = new IPCException(e);
        long r104 = SystemClock.elapsedRealtimeNanos();
        long r105 = Math.max(0, r104 - r110) / 1000;
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r111, r101 + r210 + r112 + r211 + r112 + r212 + r112 + r213 + r112 + r310 + r112 + r100 + ") = fail", r103, r105);
        IPCAnomalyTrace r107 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "uploadUserTakeOverByHttp", r103, r105, r104);
        throw r103;
    L4:
        if (this.log == false) goto L6;
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40
        com.obric.aiagent.ipc.utils.h.c("FlowNetworkIDLStub", "uploadUserTakeOverByHttp(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ", " + r310 + ", " + r311 + ")");     // Catch: Exception -> L40
    L6:
        IFlowNetworkIDL.Stub r109 = this.origin;     // Catch: Exception -> L40
        if (r311 != null) goto L10;
    L19:
        IFlowNetworkResultCallbackIDL r113 = r311;
    L20:
        r111 = "FlowNetworkIDLStub";
        r112 = ", ";
        r214 = ")";
        r109.uploadUserTakeOverByHttp(r210, r211, r212, r213, r310, r113);     // Catch: Exception -> L38
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.h.d(r111, "uploadUserTakeOverByHttp = void");     // Catch: Exception -> L38
    L24:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L38
        long r115 = Math.max(0, r114 - r110) / 1000;     // Catch: Exception -> L38
        int r116 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L38
        r101 = "uploadUserTakeOverByHttp(";
        StringBuilder r117 = new StringBuilder(r101);     // Catch: Exception -> L36
        r117.append(r210);     // Catch: Exception -> L36
        r117.append(r112);     // Catch: Exception -> L36
        r117.append(r211);     // Catch: Exception -> L36
        r117.append(r112);     // Catch: Exception -> L36
        r117.append(r212);     // Catch: Exception -> L36
        r117.append(r112);     // Catch: Exception -> L36
        r117.append(r213);     // Catch: Exception -> L36
        r117.append(r112);     // Catch: Exception -> L36
        r117.append(r310);     // Catch: Exception -> L36
        r117.append(r112);     // Catch: Exception -> L36
        r117.append(r311);     // Catch: Exception -> L34
        r117.append(") = void");     // Catch: Exception -> L34
        com.obric.aiagent.ipc.utils.i.d(r111, r117.toString(), r115);     // Catch: Exception -> L34
        r100 = r311;
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "uploadUserTakeOverByHttp", r115, r114);     // Catch: Exception -> L32
        return;
    L32:
        e = e;
    L34:
        e = e;
        r100 = r311;
    L36:
        e = e;
        r100 = r311;
    L38:
        e = e;
        r100 = r311;
        r101 = "uploadUserTakeOverByHttp(";
        goto L42
    L10:
        if ((r311 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L19;
        if ((r311 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L19;
        if ((r311 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L17;
        r113 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r311);     // Catch: Exception -> L40
        goto L20
    L17:
        r113 = u2.b(r311);     // Catch: Exception -> L40
        goto L20
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttp(String r210, String r211, int r310, String r311, String r312, String r313, String r314, List<String> r315, String r316, String r317, IFlowNetworkResultCallbackIDL r318) throws RemoteException {
        String r110 = r211;
        String r111 = "FlowNetworkIDLStub";
        long r112 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L92;
        IFlowNetworkResultCallbackIDL r100 = r318;
        String r113 = r111;
        String r101 = ")";
    L20:
        IFlowNetworkIDL.Stub r102 = this.origin;     // Catch: Exception -> L72
        if (r100 != null) goto L24;
    L33:
        IFlowNetworkResultCallbackIDL r114 = r100;
    L34:
        r111 = r113;
        String r212 = r101;
        r102.uploadOmniScreenshotByHttp(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r114);     // Catch: Exception -> L70
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d(r111, "uploadOmniScreenshotByHttp = void");     // Catch: Exception -> L70
    L38:
        long r103 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L70
        long r104 = Math.max(0, r103 - r112) / 1000;     // Catch: Exception -> L70
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L70
        String r115 = "uploadOmniScreenshotByHttp(";
        StringBuilder r106 = new StringBuilder(r115);     // Catch: Exception -> L68
        String r116 = r210;
        r106.append(r116);     // Catch: Exception -> L66
        String r117 = ", ";
        r106.append(r117);     // Catch: Exception -> L64
        r110 = r211;
        r106.append(r110);     // Catch: Exception -> L62
        r106.append(r117);     // Catch: Exception -> L62
        r106.append(r310);     // Catch: Exception -> L58
        r106.append(r117);     // Catch: Exception -> L58
        r106.append(r311);     // Catch: Exception -> L56
        r106.append(r117);     // Catch: Exception -> L56
        r106.append(r312);     // Catch: Exception -> L56
        r106.append(r117);     // Catch: Exception -> L56
        r106.append(r313);     // Catch: Exception -> L56
        r106.append(r117);     // Catch: Exception -> L56
        r106.append(r314);     // Catch: Exception -> L56
        r106.append(r117);     // Catch: Exception -> L56
        r106.append(r315);     // Catch: Exception -> L56
        r106.append(r117);     // Catch: Exception -> L56
        r106.append(r316);     // Catch: Exception -> L56
        r106.append(r117);     // Catch: Exception -> L56
        r106.append(r317);     // Catch: Exception -> L56
        r106.append(r117);     // Catch: Exception -> L56
        r106.append(r318);     // Catch: Exception -> L56
        r106.append(") = void");     // Catch: Exception -> L56
        com.obric.aiagent.ipc.utils.i.d(r111, r106.toString(), r104);     // Catch: Exception -> L56
        r111 = r111;
        String r118 = r311;
        int r107 = r310;
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "uploadOmniScreenshotByHttp", r104, r103);     // Catch: Exception -> L54
        return;
    L54:
        e = e;
    L76:
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b(r111, r115 + r116 + r117 + r110 + r117 + r107 + r117 + r118 + r117 + r312 + r117 + r313 + r117 + r314 + r117 + r315 + r117 + r316 + r117 + r317 + r117 + r318 + r212, e);
        IPCException r109 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r119 = Math.max(0, r213 - r112) / 1000;
        int r120 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r111, r115 + r116 + r117 + r110 + r117 + r107 + r117 + r118 + r117 + r312 + r117 + r313 + r117 + r314 + r117 + r315 + r117 + r316 + r117 + r317 + r117 + r318 + ") = fail", r109, r119);
        IPCAnomalyTrace r121 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "uploadOmniScreenshotByHttp", r109, r119, r213);
        throw r109;
    L56:
        e = e;
        r107 = r310;
        r111 = r111;
        r118 = r311;
    L58:
        e = e;
        r107 = r310;
    L61:
        r118 = r311;
    L62:
        e = e;
    L63:
        r107 = r310;
    L64:
        e = e;
        r110 = r211;
    L66:
        e = e;
    L67:
        r110 = r211;
        r107 = r310;
        r117 = ", ";
    L68:
        e = e;
        r116 = r210;
    L70:
        e = e;
        r116 = r210;
        r110 = r211;
        r107 = r310;
        r117 = ", ";
        r115 = "uploadOmniScreenshotByHttp(";
        goto L61
    L24:
        if ((r100 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L33;
        if ((r100 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L33;
        if ((r100 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L31;
        r114 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r100);     // Catch: Exception -> L72
        goto L34
    L31:
        r114 = u2.b(r318);     // Catch: Exception -> L72
        goto L34
    L92:
        int r122 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L16
        StringBuilder r123 = new StringBuilder("uploadOmniScreenshotByHttp(");     // Catch: Exception -> L16
        r123.append(r210);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r110);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r310);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r311);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r312);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r313);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r314);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r315);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r316);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r123.append(r317);     // Catch: Exception -> L16
        r123.append(", ");     // Catch: Exception -> L16
        r100 = r318;
        r123.append(r100);     // Catch: Exception -> L14
        r101 = ")";
        r123.append(r101);     // Catch: Exception -> L12
        r113 = r111;
        com.obric.aiagent.ipc.utils.h.c(r113, r123.toString());     // Catch: Exception -> L72
    L72:
        e = e;
    L18:
        r110 = r211;
        r115 = "uploadOmniScreenshotByHttp(";
        r212 = r101;
        r107 = r310;
        r111 = r113;
        r117 = ", ";
        r118 = r311;
        r116 = r210;
    L12:
        e = e;
        r113 = r111;
    L14:
        e = e;
    L15:
        r113 = r111;
        r101 = ")";
    L16:
        e = e;
    L74:
        e = e;
        r115 = "uploadOmniScreenshotByHttp(";
        r107 = r310;
        r212 = ")";
        r117 = ", ";
        r118 = r311;
        r116 = r210;
        goto L76
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttpV2(String r210, String r211, int r310, String r311, String r312, String r313, String r314, List<String> r315, String r316, String r317, boolean r318, IFlowNetworkResultCallbackIDL r319) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L125;
        IFlowNetworkResultCallbackIDL r100 = r319;
        String r212 = "uploadOmniScreenshotByHttpV2(";
        String r101 = ")";
        String r111 = ", ";
        String r102 = "FlowNetworkIDLStub";
    L24:
        IFlowNetworkIDL.Stub r103 = this.origin;     // Catch: Exception -> L93
        if (r100 != null) goto L27;
        String r112 = r102;
    L38:
        IFlowNetworkResultCallbackIDL r213 = r100;
    L39:
        String r113 = r112;
        String r114 = r111;
        String r214 = r101;
        String r215 = r212;
        r103.uploadOmniScreenshotByHttpV2(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r213);     // Catch: Exception -> L89
        if (this.log == false) goto L43;
        com.obric.aiagent.ipc.utils.h.d(r113, "uploadOmniScreenshotByHttpV2 = void");     // Catch: Exception -> L89
    L43:
        long r104 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L89
        long r105 = Math.max(0, r104 - r110) / 1000;     // Catch: Exception -> L89
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L89
        String r115 = r215;
        StringBuilder r107 = new StringBuilder(r115);     // Catch: Exception -> L86
        r210 = r210;
        r113 = r113;
        r107.append(r210);     // Catch: Exception -> L84
        r114 = r114;
        r107.append(r114);     // Catch: Exception -> L82
        String r116 = r211;
        r107.append(r116);     // Catch: Exception -> L80
        r107.append(r114);     // Catch: Exception -> L80
        r107.append(r310);     // Catch: Exception -> L78
        r107.append(r114);     // Catch: Exception -> L78
        r107.append(r311);     // Catch: Exception -> L76
        r107.append(r114);     // Catch: Exception -> L76
        r107.append(r312);     // Catch: Exception -> L73
        r107.append(r114);     // Catch: Exception -> L73
        r313 = r313;
        r107.append(r313);     // Catch: Exception -> L71
        r107.append(r114);     // Catch: Exception -> L71
        r107.append(r314);     // Catch: Exception -> L71
        r107.append(r114);     // Catch: Exception -> L71
        r107.append(r315);     // Catch: Exception -> L71
        r107.append(r114);     // Catch: Exception -> L71
        r107.append(r316);     // Catch: Exception -> L71
        r107.append(r114);     // Catch: Exception -> L71
        r107.append(r317);     // Catch: Exception -> L71
        r107.append(r114);     // Catch: Exception -> L71
        r107.append(r318);     // Catch: Exception -> L71
        r107.append(r114);     // Catch: Exception -> L71
        r107.append(r319);     // Catch: Exception -> L71
        r107.append(") = void");     // Catch: Exception -> L66
        com.obric.aiagent.ipc.utils.i.d(r113, r107.toString(), r105);     // Catch: Exception -> L66
        r113 = r113;
        r312 = r312;
        r311 = r311;
        r310 = r310;
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "uploadOmniScreenshotByHttpV2", r105, r104);     // Catch: Exception -> L64
        return;
    L64:
        e = e;
    L97:
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;
        StringBuilder r109 = new StringBuilder(r115);
        r109.append(r210);
        r109.append(r114);
        r109.append(r116);
        r109.append(r114);
        r109.append(r310);
        r109.append(r114);
        r109.append(r311);
        r109.append(r114);
        r109.append(r312);
        r109.append(r114);
        r109.append(r313);
        r109.append(r114);
        int r117 = r310;
        r109.append(r314);
        r109.append(r114);
        r109.append(r315);
        r109.append(r114);
        r109.append(r316);
        r109.append(r114);
        r109.append(r317);
        r109.append(r114);
        r109.append(r318);
        r109.append(r114);
        r109.append(r319);
        r109.append(r214);
        String r118 = r113;
        com.obric.aiagent.ipc.utils.h.b(r118, r109.toString(), e);
        IPCException r119 = new IPCException(e);
        long r120 = SystemClock.elapsedRealtimeNanos();
        long r121 = Math.max(0, r120 - r110) / 1000;
        int r122 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r118, r115 + r210 + r114 + r116 + r114 + r117 + r114 + r311 + r114 + r312 + r114 + r313 + r114 + r314 + r114 + r315 + r114 + r316 + r114 + r317 + r114 + r318 + r114 + r319 + ") = fail", r119, r121);
        IPCAnomalyTrace r123 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "uploadOmniScreenshotByHttpV2", r119, r121, r120);
        throw r119;
    L66:
        e = e;
    L67:
        r311 = r311;
    L68:
        r310 = r310;
    L70:
        r312 = r312;
    L71:
        e = e;
    L75:
        r311 = r311;
        r310 = r310;
        r113 = r113;
        r312 = r312;
    L73:
        e = e;
        r313 = r313;
    L76:
        e = e;
        r313 = r313;
    L78:
        e = e;
        r311 = r311;
        r313 = r313;
    L80:
        e = e;
    L81:
        r310 = r310;
        r311 = r311;
        r313 = r313;
    L82:
        e = e;
        r116 = r211;
    L84:
        e = e;
        r116 = r211;
        r310 = r310;
        r311 = r311;
        r313 = r313;
        r114 = r114;
    L86:
        e = e;
    L88:
        r116 = r211;
    L89:
        e = e;
        r115 = r215;
        goto L88
    L27:
        r112 = r102;
    L91:
        e = e;
        r214 = r101;
        r313 = r313;
        r311 = r311;
        r310 = r310;
        r210 = r210;
        r312 = r312;
        r116 = r211;
        r114 = r111;
        r115 = r212;
        r113 = r112;
        goto L97
    L29:
        if ((r100 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L38;
        if ((r100 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L38;
        if ((r100 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L36;
        IFlowNetworkResultCallbackIDL r124 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r100);     // Catch: Exception -> L91
    L37:
        r213 = r124;
        goto L39
    L36:
        r124 = u2.b(r319);     // Catch: Exception -> L91
    L93:
        e = e;
    L94:
        r214 = r101;
        r313 = r313;
        r311 = r311;
        r310 = r310;
        r210 = r210;
        r312 = r312;
        r116 = r211;
        r114 = r111;
        r115 = r212;
        r113 = r102;
        goto L97
    L125:
        int r125 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L20
        StringBuilder r126 = new StringBuilder("uploadOmniScreenshotByHttpV2(");     // Catch: Exception -> L20
        r126.append(r210);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r211);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r310);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r311);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r312);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r313);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r314);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r315);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r316);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r317);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r126.append(r318);     // Catch: Exception -> L18
        r126.append(", ");     // Catch: Exception -> L18
        r100 = r319;
        r126.append(r100);     // Catch: Exception -> L16
        r212 = "uploadOmniScreenshotByHttpV2(";
        r101 = ")";
        r126.append(r101);     // Catch: Exception -> L14
        r111 = ", ";
        r102 = "FlowNetworkIDLStub";
        com.obric.aiagent.ipc.utils.h.c(r102, r126.toString());     // Catch: Exception -> L93
    L14:
        e = e;
    L15:
        r111 = ", ";
        r102 = "FlowNetworkIDLStub";
    L16:
        e = e;
    L17:
        r212 = "uploadOmniScreenshotByHttpV2(";
        r101 = ")";
    L18:
        e = e;
    L20:
        e = e;
    L95:
        e = e;
        r313 = r313;
        r311 = r311;
        r310 = r310;
        r210 = r210;
        r214 = ")";
        r312 = r312;
        r116 = r211;
        r113 = "FlowNetworkIDLStub";
        r114 = ", ";
        r115 = "uploadOmniScreenshotByHttpV2(";
        goto L97
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttp(String r210, String r211, int r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, List<String> r319, String r410, String r411, IFlowNetworkResultCallbackIDL r412) throws RemoteException {
        r310 = r310;
        r311 = r311;
        String r110 = r312;
        r313 = r313;
        long r111 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L111;
        IFlowNetworkResultCallbackIDL r112 = r412;
        String r212 = "uploadOmniDataFeedbackByHttp(";
        String r113 = ")";
        String r114 = ", ";
        String r100 = "FlowNetworkIDLStub";
    L33:
        IFlowNetworkIDL.Stub r101 = this.origin;     // Catch: Exception -> L102
        if (r112 != null) goto L36;
        String r115 = r100;
    L47:
        IFlowNetworkResultCallbackIDL r213 = r112;
    L48:
        String r214 = r114;
        String r215 = r115;
        String r216 = r113;
        r101.uploadOmniDataFeedbackByHttp(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r213);     // Catch: Exception -> L98
        if (this.log == true) goto L52;
        r215 = r215;
    L55:
        long r102 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L96
        long r103 = Math.max(0, r102 - r111) / 1000;     // Catch: Exception -> L96
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L96
        String r116 = r212;
        StringBuilder r105 = new StringBuilder(r116);     // Catch: Exception -> L94
        String r117 = r210;
        r105.append(r117);     // Catch: Exception -> L91
        String r118 = r214;
        r105.append(r118);     // Catch: Exception -> L89
        r211 = r211;
        r105.append(r211);     // Catch: Exception -> L87
        r105.append(r118);     // Catch: Exception -> L87
        r105.append(r310);     // Catch: Exception -> L85
        r105.append(r118);     // Catch: Exception -> L85
        r105.append(r311);     // Catch: Exception -> L81
        r105.append(r118);     // Catch: Exception -> L81
        r105.append(r312);     // Catch: Exception -> L79
        r105.append(r118);     // Catch: Exception -> L79
        r313 = r313;
        r105.append(r313);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r314);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r315);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r316);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r317);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r318);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r319);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r410);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r411);     // Catch: Exception -> L77
        r105.append(r118);     // Catch: Exception -> L77
        r105.append(r412);     // Catch: Exception -> L77
        r105.append(") = void");     // Catch: Exception -> L77
        com.obric.aiagent.ipc.utils.i.d(r215, r105.toString(), r103);     // Catch: Exception -> L77
        r215 = r215;
        r110 = r312;
        r311 = r311;
        r310 = r310;
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "uploadOmniDataFeedbackByHttp", r103, r102);     // Catch: Exception -> L75
        return;
    L75:
        e = e;
    L107:
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;
        StringBuilder r107 = new StringBuilder(r116);
        r107.append(r117);
        r107.append(r118);
        r107.append(r211);
        r107.append(r118);
        r107.append(r310);
        r107.append(r118);
        r107.append(r311);
        r107.append(r118);
        r107.append(r110);
        r107.append(r118);
        r107.append(r313);
        r107.append(r118);
        String r108 = r311;
        r107.append(r314);
        r107.append(r118);
        r107.append(r315);
        r107.append(r118);
        r107.append(r316);
        r107.append(r118);
        r107.append(r317);
        r107.append(r118);
        r107.append(r318);
        r107.append(r118);
        r107.append(r319);
        r107.append(r118);
        r107.append(r410);
        r107.append(r118);
        r107.append(r411);
        r107.append(r118);
        r107.append(r412);
        r107.append(r216);
        String r119 = r215;
        com.obric.aiagent.ipc.utils.h.b(r119, r107.toString(), e);
        IPCException r109 = new IPCException(e);
        long r120 = SystemClock.elapsedRealtimeNanos();
        long r121 = Math.max(0, r120 - r111) / 1000;
        int r122 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r119, r116 + r117 + r118 + r211 + r118 + r310 + r118 + r108 + r118 + r110 + r118 + r313 + r118 + r314 + r118 + r315 + r118 + r316 + r118 + r317 + r118 + r318 + r118 + r319 + r118 + r410 + r118 + r411 + r118 + r412 + ") = fail", r109, r121);
        IPCAnomalyTrace r123 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "uploadOmniDataFeedbackByHttp", r109, r121, r120);
        throw r109;
    L77:
        e = e;
    L78:
        r215 = r215;
        r110 = r312;
        r311 = r311;
        r310 = r310;
    L79:
        e = e;
        r313 = r313;
    L81:
        e = e;
        r311 = r311;
    L83:
        r310 = r310;
    L84:
        r110 = r312;
    L85:
        e = e;
        r311 = r311;
    L87:
        e = e;
    L88:
        r310 = r310;
        r311 = r311;
        r313 = r313;
        r215 = r215;
    L89:
        e = e;
        r211 = r211;
    L91:
        e = e;
    L92:
        r215 = r215;
    L93:
        r118 = r214;
    L94:
        e = e;
        r117 = r210;
    L96:
        e = e;
        r117 = r210;
        r215 = r215;
        r116 = r212;
        goto L93
    L52:
        r215 = r215;
        com.obric.aiagent.ipc.utils.h.d(r215, "uploadOmniDataFeedbackByHttp = void");     // Catch: Exception -> L96
    L98:
        e = e;
        r117 = r210;
        r211 = r211;
        r310 = r310;
        r311 = r311;
        r110 = r312;
        r313 = r313;
        r116 = r212;
        r118 = r214;
        goto L107
    L36:
        r115 = r100;
    L100:
        e = e;
    L101:
        r216 = r113;
        r118 = r114;
        r215 = r115;
    L104:
        r116 = r212;
        r117 = r210;
        r211 = r211;
        goto L107
    L38:
        if ((r112 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L47;
        if ((r112 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L47;
        if ((r112 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L45;
        IFlowNetworkResultCallbackIDL r124 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r112);     // Catch: Exception -> L100
    L46:
        r213 = r124;
        goto L48
    L45:
        r124 = u2.b(r412);     // Catch: Exception -> L100
    L102:
        e = e;
        r215 = r100;
        r216 = r113;
        r118 = r114;
        goto L104
    L111:
        int r125 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L28
        StringBuilder r126 = new StringBuilder("uploadOmniDataFeedbackByHttp(");     // Catch: Exception -> L28
        r126.append(r210);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r211);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r310);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r311);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r110);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r313);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r314);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r315);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r316);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r317);     // Catch: Exception -> L28
        r126.append(", ");     // Catch: Exception -> L28
        r126.append(r318);     // Catch: Exception -> L26
        r126.append(", ");     // Catch: Exception -> L26
        r126.append(r319);     // Catch: Exception -> L24
        r126.append(", ");     // Catch: Exception -> L24
        r212 = "uploadOmniDataFeedbackByHttp(";
        r126.append(r410);     // Catch: Exception -> L22
        r126.append(", ");     // Catch: Exception -> L22
        r113 = ")";
        r126.append(r411);     // Catch: Exception -> L20
        r126.append(", ");     // Catch: Exception -> L20
        r112 = r412;
        r126.append(r112);     // Catch: Exception -> L18
        r126.append(r113);     // Catch: Exception -> L18
        r114 = ", ";
        r100 = "FlowNetworkIDLStub";
        com.obric.aiagent.ipc.utils.h.c(r100, r126.toString());     // Catch: Exception -> L102
    L18:
        e = e;
    L19:
        r114 = ", ";
        r115 = "FlowNetworkIDLStub";
    L20:
        e = e;
    L22:
        e = e;
        r113 = ")";
    L24:
        e = e;
    L25:
        r212 = "uploadOmniDataFeedbackByHttp(";
        r113 = ")";
    L26:
        e = e;
    L28:
        e = e;
    L105:
        e = e;
        r310 = r310;
        r117 = r210;
        r216 = ")";
        r215 = "FlowNetworkIDLStub";
        r211 = r211;
        r118 = ", ";
        r110 = r110;
        r311 = r311;
        r116 = "uploadOmniDataFeedbackByHttp(";
        goto L107
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void createConditionalTask(String r210, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, Map r413, IFlowNetworkResultCallbackIDL r414) throws RemoteException {
        r311 = r311;
        r312 = r312;
        String r110 = r313;
        r314 = r314;
        long r111 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L120;
        IFlowNetworkResultCallbackIDL r112 = r414;
        String r211 = "createConditionalTask(";
        String r113 = ")";
        String r114 = ", ";
        String r100 = "FlowNetworkIDLStub";
    L33:
        IFlowNetworkIDL.Stub r101 = this.origin;     // Catch: Exception -> L106
        if (r112 != null) goto L36;
        String r115 = r100;
    L47:
        IFlowNetworkResultCallbackIDL r116 = r112;
    L48:
        String r212 = r114;
        String r213 = r115;
        String r214 = r113;
        r101.createConditionalTask(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r116);     // Catch: Exception -> L102
        if (this.log == true) goto L52;
        r213 = r213;
    L55:
        long r102 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L100
        long r103 = Math.max(0, r102 - r111) / 1000;     // Catch: Exception -> L100
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L100
        String r117 = r211;
        StringBuilder r105 = new StringBuilder(r117);     // Catch: Exception -> L98
        String r118 = r210;
        r105.append(r118);     // Catch: Exception -> L95
        String r119 = r212;
        r105.append(r119);     // Catch: Exception -> L93
        r310 = r310;
        r105.append(r310);     // Catch: Exception -> L91
        r105.append(r119);     // Catch: Exception -> L91
        r105.append(r311);     // Catch: Exception -> L89
        r105.append(r119);     // Catch: Exception -> L89
        r105.append(r312);     // Catch: Exception -> L87
        r105.append(r119);     // Catch: Exception -> L87
        r105.append(r313);     // Catch: Exception -> L84
        r105.append(r119);     // Catch: Exception -> L84
        r314 = r314;
        r105.append(r314);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r315);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r316);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r317);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r318);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r319);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r410);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r411);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r412);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r413);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r414);     // Catch: Exception -> L82
        r105.append(") = void");     // Catch: Exception -> L78
        com.obric.aiagent.ipc.utils.i.d(r213, r105.toString(), r103);     // Catch: Exception -> L78
        r213 = r213;
        r110 = r313;
        r312 = r312;
        r311 = r311;
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "createConditionalTask", r103, r102);     // Catch: Exception -> L76
        return;
    L76:
        e = e;
    L111:
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;
        StringBuilder r107 = new StringBuilder(r117);
        r107.append(r118);
        r107.append(r119);
        r107.append(r310);
        r107.append(r119);
        r107.append(r311);
        r107.append(r119);
        r107.append(r312);
        r107.append(r119);
        r107.append(r110);
        r107.append(r119);
        r107.append(r314);
        r107.append(r119);
        String r108 = r311;
        r107.append(r315);
        r107.append(r119);
        r107.append(r316);
        r107.append(r119);
        r107.append(r317);
        r107.append(r119);
        r107.append(r318);
        r107.append(r119);
        r107.append(r319);
        r107.append(r119);
        r107.append(r410);
        r107.append(r119);
        r107.append(r411);
        r107.append(r119);
        r107.append(r412);
        r107.append(r119);
        r107.append(r413);
        r107.append(r119);
        r107.append(r414);
        r107.append(r214);
        String r120 = r213;
        com.obric.aiagent.ipc.utils.h.b(r120, r107.toString(), e);
        IPCException r109 = new IPCException(e);
        long r121 = SystemClock.elapsedRealtimeNanos();
        long r122 = Math.max(0, r121 - r111) / 1000;
        int r123 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r120, r117 + r118 + r119 + r310 + r119 + r108 + r119 + r312 + r119 + r110 + r119 + r314 + r119 + r315 + r119 + r316 + r119 + r317 + r119 + r318 + r119 + r319 + r119 + r410 + r119 + r411 + r119 + r412 + r119 + r413 + r119 + r414 + ") = fail", r109, r122);
        IPCAnomalyTrace r124 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "createConditionalTask", r109, r122, r121);
        throw r109;
    L78:
        e = e;
    L79:
        r312 = r312;
    L80:
        r311 = r311;
    L81:
        r110 = r313;
    L82:
        e = e;
    L86:
        r213 = r213;
        r110 = r313;
        r312 = r312;
        r311 = r311;
    L84:
        e = e;
        r314 = r314;
    L87:
        e = e;
        r314 = r314;
    L89:
        e = e;
        r312 = r312;
        r314 = r314;
    L91:
        e = e;
    L92:
        r311 = r311;
        r312 = r312;
        r314 = r314;
        r213 = r213;
    L93:
        e = e;
        r310 = r310;
    L95:
        e = e;
    L96:
        r213 = r213;
    L97:
        r119 = r212;
    L98:
        e = e;
        r118 = r210;
    L100:
        e = e;
        r118 = r210;
        r213 = r213;
        r117 = r211;
        goto L97
    L52:
        r213 = r213;
        com.obric.aiagent.ipc.utils.h.d(r213, "createConditionalTask = void");     // Catch: Exception -> L100
    L102:
        e = e;
        r118 = r210;
        r310 = r310;
        r311 = r311;
        r312 = r312;
        r110 = r313;
        r314 = r314;
        r117 = r211;
        r119 = r212;
        goto L111
    L36:
        r115 = r100;
    L104:
        e = e;
    L105:
        r214 = r113;
        r119 = r114;
        r213 = r115;
    L108:
        r117 = r211;
        r118 = r210;
        r310 = r310;
        goto L111
    L38:
        if ((r112 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L47;
        if ((r112 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L47;
        if ((r112 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L45;
        IFlowNetworkResultCallbackIDL r125 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r112);     // Catch: Exception -> L104
    L46:
        r116 = r125;
        goto L48
    L45:
        r125 = u2.b(r414);     // Catch: Exception -> L104
    L106:
        e = e;
        r213 = r100;
        r214 = r113;
        r119 = r114;
        goto L108
    L120:
        int r126 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L28
        StringBuilder r127 = new StringBuilder("createConditionalTask(");     // Catch: Exception -> L28
        r127.append(r210);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r310);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r311);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r312);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r110);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r314);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r315);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r316);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r317);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r318);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r319);     // Catch: Exception -> L26
        r127.append(", ");     // Catch: Exception -> L26
        r127.append(r410);     // Catch: Exception -> L24
        r127.append(", ");     // Catch: Exception -> L24
        r211 = "createConditionalTask(";
        r127.append(r411);     // Catch: Exception -> L22
        r127.append(", ");     // Catch: Exception -> L22
        r113 = ")";
        r127.append(r412);     // Catch: Exception -> L20
        r127.append(", ");     // Catch: Exception -> L20
        r127.append(r413);     // Catch: Exception -> L20
        r127.append(", ");     // Catch: Exception -> L20
        r112 = r414;
        r127.append(r112);     // Catch: Exception -> L18
        r127.append(r113);     // Catch: Exception -> L18
        r114 = ", ";
        r100 = "FlowNetworkIDLStub";
        com.obric.aiagent.ipc.utils.h.c(r100, r127.toString());     // Catch: Exception -> L106
    L18:
        e = e;
    L19:
        r114 = ", ";
        r115 = "FlowNetworkIDLStub";
    L20:
        e = e;
    L22:
        e = e;
        r113 = ")";
    L24:
        e = e;
    L25:
        r211 = "createConditionalTask(";
        r113 = ")";
    L26:
        e = e;
    L28:
        e = e;
    L109:
        e = e;
        r312 = r312;
        r214 = ")";
        r213 = "FlowNetworkIDLStub";
        r117 = "createConditionalTask(";
        r119 = ", ";
        r110 = r110;
        r311 = r311;
        r118 = r210;
        r310 = r310;
        goto L111
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttpV2(String r210, String r310, int r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, List<String> r410, String r411, String r412, boolean r413, IFlowNetworkResultCallbackIDL r414) throws RemoteException {
        r311 = r311;
        r312 = r312;
        String r110 = r313;
        r314 = r314;
        long r111 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L124;
        IFlowNetworkResultCallbackIDL r112 = r414;
        String r211 = "uploadOmniDataFeedbackByHttpV2(";
        String r113 = ")";
        String r114 = ", ";
        String r100 = "FlowNetworkIDLStub";
    L33:
        IFlowNetworkIDL.Stub r101 = this.origin;     // Catch: Exception -> L106
        if (r112 != null) goto L36;
        String r115 = r100;
    L47:
        IFlowNetworkResultCallbackIDL r116 = r112;
    L48:
        String r212 = r114;
        String r213 = r115;
        String r214 = r113;
        r101.uploadOmniDataFeedbackByHttpV2(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r116);     // Catch: Exception -> L102
        if (this.log == true) goto L52;
        r213 = r213;
    L55:
        long r102 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L100
        long r103 = Math.max(0, r102 - r111) / 1000;     // Catch: Exception -> L100
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L100
        String r117 = r211;
        StringBuilder r105 = new StringBuilder(r117);     // Catch: Exception -> L98
        String r118 = r210;
        r105.append(r118);     // Catch: Exception -> L95
        String r119 = r212;
        r105.append(r119);     // Catch: Exception -> L93
        r310 = r310;
        r105.append(r310);     // Catch: Exception -> L91
        r105.append(r119);     // Catch: Exception -> L91
        r105.append(r311);     // Catch: Exception -> L89
        r105.append(r119);     // Catch: Exception -> L89
        r105.append(r312);     // Catch: Exception -> L87
        r105.append(r119);     // Catch: Exception -> L87
        r105.append(r313);     // Catch: Exception -> L84
        r105.append(r119);     // Catch: Exception -> L84
        r314 = r314;
        r105.append(r314);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r315);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r316);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r317);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r318);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r319);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r410);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r411);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r412);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r413);     // Catch: Exception -> L82
        r105.append(r119);     // Catch: Exception -> L82
        r105.append(r414);     // Catch: Exception -> L82
        r105.append(") = void");     // Catch: Exception -> L78
        com.obric.aiagent.ipc.utils.i.d(r213, r105.toString(), r103);     // Catch: Exception -> L78
        r213 = r213;
        r110 = r313;
        r312 = r312;
        r311 = r311;
        IPCAnomalyTrace.f384709a.e("FlowNetworkIDLStub", "uploadOmniDataFeedbackByHttpV2", r103, r102);     // Catch: Exception -> L76
        return;
    L76:
        e = e;
    L111:
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;
        StringBuilder r107 = new StringBuilder(r117);
        r107.append(r118);
        r107.append(r119);
        r107.append(r310);
        r107.append(r119);
        r107.append(r311);
        r107.append(r119);
        r107.append(r312);
        r107.append(r119);
        r107.append(r110);
        r107.append(r119);
        r107.append(r314);
        r107.append(r119);
        int r108 = r311;
        r107.append(r315);
        r107.append(r119);
        r107.append(r316);
        r107.append(r119);
        r107.append(r317);
        r107.append(r119);
        r107.append(r318);
        r107.append(r119);
        r107.append(r319);
        r107.append(r119);
        r107.append(r410);
        r107.append(r119);
        r107.append(r411);
        r107.append(r119);
        r107.append(r412);
        r107.append(r119);
        r107.append(r413);
        r107.append(r119);
        r107.append(r414);
        r107.append(r214);
        String r120 = r213;
        com.obric.aiagent.ipc.utils.h.b(r120, r107.toString(), e);
        IPCException r109 = new IPCException(e);
        long r121 = SystemClock.elapsedRealtimeNanos();
        long r122 = Math.max(0, r121 - r111) / 1000;
        int r123 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r120, r117 + r118 + r119 + r310 + r119 + r108 + r119 + r312 + r119 + r110 + r119 + r314 + r119 + r315 + r119 + r316 + r119 + r317 + r119 + r318 + r119 + r319 + r119 + r410 + r119 + r411 + r119 + r412 + r119 + r413 + r119 + r414 + ") = fail", r109, r122);
        IPCAnomalyTrace r124 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowNetworkIDLStub", "uploadOmniDataFeedbackByHttpV2", r109, r122, r121);
        throw r109;
    L78:
        e = e;
    L79:
        r312 = r312;
    L80:
        r311 = r311;
    L81:
        r110 = r313;
    L82:
        e = e;
    L86:
        r213 = r213;
        r110 = r313;
        r312 = r312;
        r311 = r311;
    L84:
        e = e;
        r314 = r314;
    L87:
        e = e;
        r314 = r314;
    L89:
        e = e;
        r312 = r312;
        r314 = r314;
    L91:
        e = e;
    L92:
        r311 = r311;
        r312 = r312;
        r314 = r314;
        r213 = r213;
    L93:
        e = e;
        r310 = r310;
    L95:
        e = e;
    L96:
        r213 = r213;
    L97:
        r119 = r212;
    L98:
        e = e;
        r118 = r210;
    L100:
        e = e;
        r118 = r210;
        r213 = r213;
        r117 = r211;
        goto L97
    L52:
        r213 = r213;
        com.obric.aiagent.ipc.utils.h.d(r213, "uploadOmniDataFeedbackByHttpV2 = void");     // Catch: Exception -> L100
    L102:
        e = e;
        r118 = r210;
        r310 = r310;
        r311 = r311;
        r312 = r312;
        r110 = r313;
        r314 = r314;
        r117 = r211;
        r119 = r212;
        goto L111
    L36:
        r115 = r100;
    L104:
        e = e;
    L105:
        r214 = r113;
        r119 = r114;
        r213 = r115;
    L108:
        r117 = r211;
        r118 = r210;
        r310 = r310;
        goto L111
    L38:
        if ((r112 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L47;
        if ((r112 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L47;
        if ((r112 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L45;
        IFlowNetworkResultCallbackIDL r125 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r112);     // Catch: Exception -> L104
    L46:
        r116 = r125;
        goto L48
    L45:
        r125 = u2.b(r414);     // Catch: Exception -> L104
    L106:
        e = e;
        r213 = r100;
        r214 = r113;
        r119 = r114;
        goto L108
    L124:
        int r126 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L28
        StringBuilder r127 = new StringBuilder("uploadOmniDataFeedbackByHttpV2(");     // Catch: Exception -> L28
        r127.append(r210);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r310);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r311);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r312);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r110);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r314);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r315);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r316);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r317);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r318);     // Catch: Exception -> L28
        r127.append(", ");     // Catch: Exception -> L28
        r127.append(r319);     // Catch: Exception -> L26
        r127.append(", ");     // Catch: Exception -> L26
        r127.append(r410);     // Catch: Exception -> L24
        r127.append(", ");     // Catch: Exception -> L24
        r211 = "uploadOmniDataFeedbackByHttpV2(";
        r127.append(r411);     // Catch: Exception -> L22
        r127.append(", ");     // Catch: Exception -> L22
        r113 = ")";
        r127.append(r412);     // Catch: Exception -> L20
        r127.append(", ");     // Catch: Exception -> L20
        r127.append(r413);     // Catch: Exception -> L20
        r127.append(", ");     // Catch: Exception -> L20
        r112 = r414;
        r127.append(r112);     // Catch: Exception -> L18
        r127.append(r113);     // Catch: Exception -> L18
        r114 = ", ";
        r100 = "FlowNetworkIDLStub";
        com.obric.aiagent.ipc.utils.h.c(r100, r127.toString());     // Catch: Exception -> L106
    L18:
        e = e;
    L19:
        r114 = ", ";
        r115 = "FlowNetworkIDLStub";
    L20:
        e = e;
    L22:
        e = e;
        r113 = ")";
    L24:
        e = e;
    L25:
        r211 = "uploadOmniDataFeedbackByHttpV2(";
        r113 = ")";
    L26:
        e = e;
    L28:
        e = e;
    L109:
        e = e;
        r312 = r312;
        r214 = ")";
        r213 = "FlowNetworkIDLStub";
        r117 = "uploadOmniDataFeedbackByHttpV2(";
        r119 = ", ";
        r110 = r110;
        r311 = r311;
        r118 = r210;
        r310 = r310;
        goto L111
    }
}
