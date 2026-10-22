package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.tencent.qqmusic.third.api.contract.Keys;

/* JADX INFO: loaded from: classes4.dex */
class FlowAppIntentIDLStubWrapper extends IFlowAppIntentIDL.Stub {
    boolean log;
    final IFlowAppIntentIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public long currentTimeMillis() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "currentTimeMillis()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "currentTimeMillis() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "currentTimeMillis", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "currentTimeMillis()");     // Catch: Exception -> L11
    L6:
        long r112 = this.origin.currentTimeMillis();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "currentTimeMillis = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "currentTimeMillis() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "currentTimeMillis", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public OTaskTimeoutConfig getObricTaskTimeoutConfig() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "getObricTaskTimeoutConfig()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "getObricTaskTimeoutConfig() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "getObricTaskTimeoutConfig", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "getObricTaskTimeoutConfig()");     // Catch: Exception -> L11
    L6:
        OTaskTimeoutConfig r112 = this.origin.getObricTaskTimeoutConfig();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "getObricTaskTimeoutConfig = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "getObricTaskTimeoutConfig() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "getObricTaskTimeoutConfig", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public String getUserId() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "getUserId()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "getUserId() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "getUserId", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "getUserId()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getUserId();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "getUserId = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "getUserId() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "getUserId", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isDoraConnected() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "isDoraConnected()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "isDoraConnected() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "isDoraConnected", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "isDoraConnected()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isDoraConnected();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "isDoraConnected = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "isDoraConnected() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "isDoraConnected", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isEnterpriseAccount() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "isEnterpriseAccount()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "isEnterpriseAccount() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "isEnterpriseAccount", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "isEnterpriseAccount()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isEnterpriseAccount();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "isEnterpriseAccount = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "isEnterpriseAccount() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "isEnterpriseAccount", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isLogin() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "isLogin()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "isLogin() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", Keys.API_RETURN_KEY_IS_LOGIN, r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "isLogin()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isLogin();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "isLogin = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "isLogin() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", Keys.API_RETURN_KEY_IS_LOGIN, r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void jumpDoraPage() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "jumpDoraPage()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "jumpDoraPage() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "jumpDoraPage", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "jumpDoraPage()");     // Catch: Exception -> L11
    L6:
        this.origin.jumpDoraPage();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "jumpDoraPage = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "jumpDoraPage() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "jumpDoraPage", r113, r112);     // Catch: Exception -> L11
    }

    public FlowAppIntentIDLStubWrapper(IFlowAppIntentIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void getLocation(IFlowGetLocationCallbackIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "getLocation(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "getLocation(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "getLocation", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "getLocation(" + r210 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppIntentIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IFlowGetLocationCallbackIDL r112 = r210;
    L19:
        r106.getLocation(r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "getLocation = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "getLocation(" + r210 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "getLocation", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof FlowGetLocationCallbackIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof FlowGetLocationCallbackIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IFlowGetLocationCallbackIDL.Stub) == false) goto L17;
        r112 = z1.a((IFlowGetLocationCallbackIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = z1.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean openMiniApp(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "openMiniApp(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "openMiniApp(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "openMiniApp", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "openMiniApp(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.openMiniApp(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "openMiniApp = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "openMiniApp(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "openMiniApp", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void setAppIntentActive(boolean r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "setAppIntentActive(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "setAppIntentActive(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "setAppIntentActive", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "setAppIntentActive(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setAppIntentActive(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "setAppIntentActive = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "setAppIntentActive(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "setAppIntentActive", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void stopComplexTask(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "stopComplexTask(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "stopComplexTask(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "stopComplexTask", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "stopComplexTask(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.stopComplexTask(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "stopComplexTask = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "stopComplexTask(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "stopComplexTask", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean syncAppletData(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "syncAppletData(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "syncAppletData(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "syncAppletData", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "syncAppletData(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.syncAppletData(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "syncAppletData = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "syncAppletData(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "syncAppletData", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    public FlowAppIntentIDLStubWrapper(IFlowAppIntentIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean checkPermission(String r210, boolean r211, long r212) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r100 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowAppIntentIDLStub", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r213 - r110) / 1000;
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowAppIntentIDLStub", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r111);
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowAppIntentIDLStub", "checkPermission", r101, r111, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowAppIntentIDLStub", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.checkPermission(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowAppIntentIDLStub", "checkPermission = " + r113);     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r104 = Math.max(0, r214 - r110) / 1000;     // Catch: Exception -> L11
        int r115 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowAppIntentIDLStub", "checkPermission(" + r210 + ", " + r211 + ", " + r212 + ") = " + r113, r104);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowAppIntentIDLStub", "checkPermission", r104, r214);     // Catch: Exception -> L11
        return r113;
    }
}
