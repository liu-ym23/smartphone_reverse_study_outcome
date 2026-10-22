package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class FlowPermissionIDLIpcWrapper implements IFlowPermissionIDL {
    boolean log;
    final IFlowPermissionIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FlowPermissionIDLIpcWrapper(IFlowPermissionIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPermissionGranted(List<String> r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        Map r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowPermissionIDLIPC", "isPermissionGranted(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "isPermissionGranted", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isPermissionGranted(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowPermissionIDLIPC", "isPermissionGranted = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "isPermissionGranted(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowPermissionIDLIPC", "isPermissionGranted", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updateAppletPermissions(List<Permission> r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "updateAppletPermissions", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateAppletPermissions(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowPermissionIDLIPC", "updateAppletPermissions = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowPermissionIDLIPC", "updateAppletPermissions", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updatePersonalPermissions(List<Permission> r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "updatePersonalPermissions", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updatePersonalPermissions(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowPermissionIDLIPC", "updatePersonalPermissions = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowPermissionIDLIPC", "updatePersonalPermissions", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowPermissionIDLIpcWrapper(IFlowPermissionIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isAppletPermissionGranted(String r210, List<String> r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        Map r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r212 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "isAppletPermissionGranted", r101, r102, r212);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isAppletPermissionGranted(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowPermissionIDLIPC", "isAppletPermissionGranted = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r210 + ", " + r211 + ") = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowPermissionIDLIPC", "isAppletPermissionGranted", r115, r213);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPersonalPermissionGranted(String r210, List<String> r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        Map r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r212 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "isPersonalPermissionGranted", r101, r102, r212);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isPersonalPermissionGranted(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowPermissionIDLIPC", "isPersonalPermissionGranted = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r210 + ", " + r211 + ") = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowPermissionIDLIPC", "isPersonalPermissionGranted", r115, r213);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public boolean requestPermission(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowPermissionIDLIPC", "requestPermission(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r212 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "requestPermission(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "requestPermission", r101, r102, r212);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "requestPermission(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowPermissionIDLIPC", "requestPermission(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.requestPermission(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowPermissionIDLIPC", "requestPermission = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "requestPermission(" + r210 + ", " + r211 + ") = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowPermissionIDLIPC", "requestPermission", r115, r213);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }
}
