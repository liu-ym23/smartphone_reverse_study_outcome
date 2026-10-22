package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.tencent.qqmusic.third.api.contract.Keys;

/* JADX INFO: loaded from: classes6.dex */
class FlowAppIntentIDLIpcWrapper implements IFlowAppIntentIDL {
    boolean log;
    final IFlowAppIntentIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public long currentTimeMillis() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L17:
        e = e;
        long r110 = 0;
    L19:
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "currentTimeMillis()", e);     // Catch: Throwable -> L21
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L21
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "currentTimeMillis() = fail", r111, r101);     // Catch: Throwable -> L21
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L21
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "currentTimeMillis", r111, r101, r112);     // Catch: Throwable -> L21
        return r110;
    L22:
        return r110;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "currentTimeMillis()");     // Catch: Exception -> L17 Throwable -> L23
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "currentTimeMillis()");     // Catch: Exception -> L17 Throwable -> L23
    L9:
        r110 = this.origin.currentTimeMillis();     // Catch: Exception -> L17 Throwable -> L23
    L15:
        e = e;
        goto L19
    L11:
        if (this.log == false) goto L13;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "currentTimeMillis = " + r110);     // Catch: Exception -> L15 Throwable -> L21
    L13:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L21
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L15 Throwable -> L21
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "currentTimeMillis() = " + r110, r115);     // Catch: Exception -> L15 Throwable -> L21
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "currentTimeMillis", r115, r114);     // Catch: Exception -> L15 Throwable -> L21
        return r110;
    L29:
        return 0;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public OTaskTimeoutConfig getObricTaskTimeoutConfig() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        OTaskTimeoutConfig r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getObricTaskTimeoutConfig();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public String getUserId() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        String r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "getUserId()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "getUserId() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "getUserId", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "getUserId()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "getUserId()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getUserId();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "getUserId = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "getUserId() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "getUserId", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isDoraConnected() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "isDoraConnected()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "isDoraConnected() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "isDoraConnected", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "isDoraConnected()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "isDoraConnected()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isDoraConnected();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "isDoraConnected = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "isDoraConnected() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "isDoraConnected", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isEnterpriseAccount() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "isEnterpriseAccount()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "isEnterpriseAccount", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isEnterpriseAccount();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "isEnterpriseAccount = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "isEnterpriseAccount() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "isEnterpriseAccount", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isLogin() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "isLogin()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "isLogin() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", Keys.API_RETURN_KEY_IS_LOGIN, r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "isLogin()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "isLogin()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isLogin();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "isLogin = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "isLogin() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", Keys.API_RETURN_KEY_IS_LOGIN, r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void jumpDoraPage() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "jumpDoraPage()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "jumpDoraPage() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "jumpDoraPage", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "jumpDoraPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "jumpDoraPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.jumpDoraPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "jumpDoraPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "jumpDoraPage() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "jumpDoraPage", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowAppIntentIDLIpcWrapper(IFlowAppIntentIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void getLocation(IFlowGetLocationCallbackIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "getLocation(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "getLocation(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "getLocation", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "getLocation(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("getLocation(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IFlowGetLocationCallbackIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof FlowGetLocationCallbackIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof FlowGetLocationCallbackIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IFlowGetLocationCallbackIDL.Stub) == false) goto L19;
        r113 = z1.a((IFlowGetLocationCallbackIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = z1.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppIntentIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IFlowGetLocationCallbackIDL r114 = r210;
    L35:
        r107.getLocation(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "getLocation = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "getLocation(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "getLocation", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r210 instanceof FlowGetLocationCallbackIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof FlowGetLocationCallbackIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IFlowGetLocationCallbackIDL.Stub) == false) goto L33;
        r114 = z1.a((IFlowGetLocationCallbackIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = z1.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean openMiniApp(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "openMiniApp(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "openMiniApp", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.openMiniApp(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "openMiniApp = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "openMiniApp(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "openMiniApp", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void setAppIntentActive(boolean r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "setAppIntentActive", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setAppIntentActive(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "setAppIntentActive = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "setAppIntentActive", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void stopComplexTask(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "stopComplexTask(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "stopComplexTask", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.stopComplexTask(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "stopComplexTask = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "stopComplexTask(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "stopComplexTask", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean syncAppletData(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "syncAppletData(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "syncAppletData", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.syncAppletData(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "syncAppletData = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "syncAppletData(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "syncAppletData", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public FlowAppIntentIDLIpcWrapper(IFlowAppIntentIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean checkPermission(String r210, boolean r211, long r212) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
        boolean r111 = false;
    L19:
        e = e;
    L20:
        int r100 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.b("IFlowAppIntentIDLIPC", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ")", e);     // Catch: Throwable -> L22
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L22
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L22
        long r112 = Math.max(0, r213 - r110) / 1000;     // Catch: Throwable -> L22
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r112);     // Catch: Throwable -> L22
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L22
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "checkPermission", r101, r112, r213);     // Catch: Throwable -> L22
        return r111;
    L4:
        if (this.log == false) goto L7;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L19 Throwable -> L22
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L19 Throwable -> L22
    L7:
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L19 Throwable -> L22
        com.obric.aiagent.ipc.utils.h.a("IFlowAppIntentIDLIPC", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L19 Throwable -> L22
    L9:
        boolean r115 = this.origin.checkPermission(r210, r211, r212);     // Catch: Exception -> L19 Throwable -> L22
    L15:
        e = e;
        r111 = r115;
        goto L20
    L11:
        if (this.log == false) goto L13;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L15 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IFlowAppIntentIDLIPC", "checkPermission = " + r115);     // Catch: Exception -> L15 Throwable -> L17
    L13:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L17
        long r104 = Math.max(0, r214 - r110) / 1000;     // Catch: Exception -> L15 Throwable -> L17
        int r117 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L15 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ") = " + r115, r104);     // Catch: Exception -> L15 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFlowAppIntentIDLIPC", "checkPermission", r104, r214);     // Catch: Exception -> L15 Throwable -> L17
        return r115;
    L27:
        return r115;
    L28:
        return false;
    }
}
