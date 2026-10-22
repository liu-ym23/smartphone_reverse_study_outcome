package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class FlowPermissionIDLStubWrapper extends IFlowPermissionIDL.Stub {
    boolean log;
    final IFlowPermissionIDL.Stub origin;

    public FlowPermissionIDLStubWrapper(IFlowPermissionIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPermissionGranted(List<String> r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowPermissionIDLStub", "isPermissionGranted(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowPermissionIDLStub", "isPermissionGranted(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowPermissionIDLStub", "isPermissionGranted", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowPermissionIDLStub", "isPermissionGranted(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        Map r113 = this.origin.isPermissionGranted(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowPermissionIDLStub", "isPermissionGranted = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowPermissionIDLStub", "isPermissionGranted(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowPermissionIDLStub", "isPermissionGranted", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updateAppletPermissions(List<Permission> r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowPermissionIDLStub", "updateAppletPermissions(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowPermissionIDLStub", "updateAppletPermissions(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowPermissionIDLStub", "updateAppletPermissions", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowPermissionIDLStub", "updateAppletPermissions(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updateAppletPermissions(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowPermissionIDLStub", "updateAppletPermissions = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowPermissionIDLStub", "updateAppletPermissions(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowPermissionIDLStub", "updateAppletPermissions", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updatePersonalPermissions(List<Permission> r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowPermissionIDLStub", "updatePersonalPermissions(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowPermissionIDLStub", "updatePersonalPermissions(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowPermissionIDLStub", "updatePersonalPermissions", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowPermissionIDLStub", "updatePersonalPermissions(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updatePersonalPermissions(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowPermissionIDLStub", "updatePersonalPermissions = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowPermissionIDLStub", "updatePersonalPermissions(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowPermissionIDLStub", "updatePersonalPermissions", r113, r112);     // Catch: Exception -> L11
    }

    public FlowPermissionIDLStubWrapper(IFlowPermissionIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isAppletPermissionGranted(String r210, List<String> r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowPermissionIDLStub", "isAppletPermissionGranted(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowPermissionIDLStub", "isAppletPermissionGranted(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowPermissionIDLStub", "isAppletPermissionGranted", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowPermissionIDLStub", "isAppletPermissionGranted(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        Map r113 = this.origin.isAppletPermissionGranted(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowPermissionIDLStub", "isAppletPermissionGranted = " + r113);     // Catch: Exception -> L11
    L9:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r212 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowPermissionIDLStub", "isAppletPermissionGranted(" + r210 + ", " + r211 + ") = " + r113, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowPermissionIDLStub", "isAppletPermissionGranted", r115, r212);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPersonalPermissionGranted(String r210, List<String> r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowPermissionIDLStub", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowPermissionIDLStub", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowPermissionIDLStub", "isPersonalPermissionGranted", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowPermissionIDLStub", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        Map r113 = this.origin.isPersonalPermissionGranted(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowPermissionIDLStub", "isPersonalPermissionGranted = " + r113);     // Catch: Exception -> L11
    L9:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r212 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowPermissionIDLStub", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ") = " + r113, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowPermissionIDLStub", "isPersonalPermissionGranted", r115, r212);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public boolean requestPermission(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowPermissionIDLStub", "requestPermission(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowPermissionIDLStub", "requestPermission(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowPermissionIDLStub", "requestPermission", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowPermissionIDLStub", "requestPermission(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.requestPermission(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowPermissionIDLStub", "requestPermission = " + r113);     // Catch: Exception -> L11
    L9:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r212 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowPermissionIDLStub", "requestPermission(" + r210 + ", " + r211 + ") = " + r113, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowPermissionIDLStub", "requestPermission", r115, r212);     // Catch: Exception -> L11
        return r113;
    }
}
