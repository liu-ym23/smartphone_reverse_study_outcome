package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class FlowUiIDLStubWrapper extends IFlowUiIDL.Stub {
    boolean log;
    final IFlowUiIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void dismissKeyguard() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "dismissKeyguard()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "dismissKeyguard() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "dismissKeyguard", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "dismissKeyguard()");     // Catch: Exception -> L11
    L6:
        this.origin.dismissKeyguard();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "dismissKeyguard = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "dismissKeyguard() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "dismissKeyguard", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void finishChatPage() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "finishChatPage()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "finishChatPage() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "finishChatPage", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "finishChatPage()");     // Catch: Exception -> L11
    L6:
        this.origin.finishChatPage();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "finishChatPage = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "finishChatPage() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "finishChatPage", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getCurrentDisplayModel() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "getCurrentDisplayModel()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "getCurrentDisplayModel() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "getCurrentDisplayModel", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "getCurrentDisplayModel()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getCurrentDisplayModel();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "getCurrentDisplayModel = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "getCurrentDisplayModel() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "getCurrentDisplayModel", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getTaskSkillModelJson() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "getTaskSkillModelJson()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "getTaskSkillModelJson() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "getTaskSkillModelJson", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "getTaskSkillModelJson()");     // Catch: Exception -> L11
    L6:
        String r112 = this.origin.getTaskSkillModelJson();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "getTaskSkillModelJson = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "getTaskSkillModelJson() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "getTaskSkillModelJson", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public int getWindowState() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "getWindowState()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "getWindowState() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "getWindowState", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "getWindowState()");     // Catch: Exception -> L11
    L6:
        int r112 = this.origin.getWindowState();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "getWindowState = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "getWindowState() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "getWindowState", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAssistantRequestFromAIKey() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "isAssistantRequestFromAIKey()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "isAssistantRequestFromAIKey() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "isAssistantRequestFromAIKey", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "isAssistantRequestFromAIKey()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isAssistantRequestFromAIKey();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "isAssistantRequestFromAIKey = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "isAssistantRequestFromAIKey() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "isAssistantRequestFromAIKey", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPass() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "isAuthenticationPass()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "isAuthenticationPass() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "isAuthenticationPass", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "isAuthenticationPass()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isAuthenticationPass();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "isAuthenticationPass = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "isAuthenticationPass() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "isAuthenticationPass", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowMode() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "isWindowMode()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "isWindowMode() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "isWindowMode", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "isWindowMode()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isWindowMode();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "isWindowMode = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "isWindowMode() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "isWindowMode", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowShowing() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "isWindowShowing()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "isWindowShowing() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "isWindowShowing", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "isWindowShowing()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.isWindowShowing();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "isWindowShowing = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "isWindowShowing() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "isWindowShowing", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyOAutoDied() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "notifyOAutoDied()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "notifyOAutoDied() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "notifyOAutoDied", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "notifyOAutoDied()");     // Catch: Exception -> L11
    L6:
        this.origin.notifyOAutoDied();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "notifyOAutoDied = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "notifyOAutoDied() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "notifyOAutoDied", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void popWindow() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "popWindow()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "popWindow() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "popWindow", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "popWindow()");     // Catch: Exception -> L11
    L6:
        this.origin.popWindow();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "popWindow = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "popWindow() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "popWindow", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void processRequiresAuthentication() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "processRequiresAuthentication()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "processRequiresAuthentication() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "processRequiresAuthentication", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "processRequiresAuthentication()");     // Catch: Exception -> L11
    L6:
        this.origin.processRequiresAuthentication();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "processRequiresAuthentication = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "processRequiresAuthentication() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "processRequiresAuthentication", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showWindow() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "showWindow()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "showWindow() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "showWindow", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "showWindow()");     // Catch: Exception -> L11
    L6:
        this.origin.showWindow();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "showWindow = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "showWindow() = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "showWindow", r113, r112);     // Catch: Exception -> L11
    }

    public FlowUiIDLStubWrapper(IFlowUiIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void closeAssistantInputPanel(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "closeAssistantInputPanel(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "closeAssistantInputPanel(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "closeAssistantInputPanel", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "closeAssistantInputPanel(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.closeAssistantInputPanel(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "closeAssistantInputPanel = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "closeAssistantInputPanel(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "closeAssistantInputPanel", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAudioMessage(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "isAudioMessage(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "isAudioMessage(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "isAudioMessage", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "isAudioMessage(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.isAudioMessage(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "isAudioMessage = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "isAudioMessage(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "isAudioMessage", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPassV2(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "isAuthenticationPassV2(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "isAuthenticationPassV2(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "isAuthenticationPassV2", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "isAuthenticationPassV2(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.isAuthenticationPassV2(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "isAuthenticationPassV2 = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "isAuthenticationPassV2(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "isAuthenticationPassV2", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public Authentication isAuthenticationPassV3(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "isAuthenticationPassV3(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "isAuthenticationPassV3(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "isAuthenticationPassV3", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "isAuthenticationPassV3(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        Authentication r113 = this.origin.isAuthenticationPassV3(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "isAuthenticationPassV3 = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "isAuthenticationPassV3(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "isAuthenticationPassV3", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyMessageInAutoGui(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "notifyMessageInAutoGui(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "notifyMessageInAutoGui(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "notifyMessageInAutoGui", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "notifyMessageInAutoGui(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyMessageInAutoGui(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "notifyMessageInAutoGui = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "notifyMessageInAutoGui(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "notifyMessageInAutoGui", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openChatActivity(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "openChatActivity(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "openChatActivity(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "openChatActivity", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "openChatActivity(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.openChatActivity(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "openChatActivity = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "openChatActivity(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "openChatActivity", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAutoIncreaseWindow(boolean r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "setAutoIncreaseWindow(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "setAutoIncreaseWindow(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "setAutoIncreaseWindow", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "setAutoIncreaseWindow(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setAutoIncreaseWindow(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "setAutoIncreaseWindow = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "setAutoIncreaseWindow(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "setAutoIncreaseWindow", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showToast(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "showToast(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "showToast(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "showToast", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "showToast(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showToast(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "showToast = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "showToast(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "showToast", r113, r112);     // Catch: Exception -> L11
    }

    public FlowUiIDLStubWrapper(IFlowUiIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openRealtimeCall(int r210, IOpenRealTimeCallCallbackIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "openRealtimeCall(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "openRealtimeCall(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "openRealtimeCall", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "openRealtimeCall(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IOpenRealTimeCallCallbackIDL r112 = r211;
    L19:
        r106.openRealtimeCall(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "openRealtimeCall = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "openRealtimeCall(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "openRealtimeCall", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof OpenRealTimeCallCallbackIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof OpenRealTimeCallCallbackIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IOpenRealTimeCallCallbackIDL.Stub) == false) goto L17;
        r112 = k4.a((IOpenRealTimeCallCallbackIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = k4.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r210, Bundle r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "requestDeviceCredentialAuthentication(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "requestDeviceCredentialAuthentication(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "requestDeviceCredentialAuthentication", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "requestDeviceCredentialAuthentication(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IRequestAuthenticationCallbackIDL r112 = r210;
    L19:
        r106.requestDeviceCredentialAuthentication(r112, r211);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "requestDeviceCredentialAuthentication = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "requestDeviceCredentialAuthentication(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "requestDeviceCredentialAuthentication", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L17;
        r112 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = r4.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r210, Bundle r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "requestVoicePrintAuthentication(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "requestVoicePrintAuthentication(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "requestVoicePrintAuthentication", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "requestVoicePrintAuthentication(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IRequestAuthenticationCallbackIDL r112 = r210;
    L19:
        r106.requestVoicePrintAuthentication(r112, r211);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "requestVoicePrintAuthentication = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "requestVoicePrintAuthentication(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "requestVoicePrintAuthentication", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L17;
        r112 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = r4.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAssistantInteractionListener(String r210, IAssistantInteractionListenerIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "setAssistantInteractionListener(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "setAssistantInteractionListener(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "setAssistantInteractionListener", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "setAssistantInteractionListener(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IAssistantInteractionListenerIDL r112 = r211;
    L19:
        r106.setAssistantInteractionListener(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "setAssistantInteractionListener = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "setAssistantInteractionListener(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "setAssistantInteractionListener", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof AssistantInteractionListenerIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof AssistantInteractionListenerIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IAssistantInteractionListenerIDL.Stub) == false) goto L17;
        r112 = x.a((IAssistantInteractionListenerIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = x.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void shouldDowngradeAuthForDora(int r210, IDowngradeAuthForDoraCallbackIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "shouldDowngradeAuthForDora(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "shouldDowngradeAuthForDora(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "shouldDowngradeAuthForDora", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "shouldDowngradeAuthForDora(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r211 != null) goto L10;
    L18:
        IDowngradeAuthForDoraCallbackIDL r112 = r211;
    L19:
        r106.shouldDowngradeAuthForDora(r210, r112);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "shouldDowngradeAuthForDora = void");     // Catch: Exception -> L24
    L22:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "shouldDowngradeAuthForDora(" + r210 + ", " + r211 + ") = void", r114);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "shouldDowngradeAuthForDora", r114, r113);     // Catch: Exception -> L24
        return;
    L10:
        if ((r211 instanceof DowngradeAuthForDoraCallbackIDLIpcWrapper) == true) goto L18;
        if ((r211 instanceof DowngradeAuthForDoraCallbackIDLStubWrapper) == true) goto L18;
        if ((r211 instanceof IDowngradeAuthForDoraCallbackIDL.Stub) == false) goto L17;
        r112 = d0.a((IDowngradeAuthForDoraCallbackIDL.Stub) r211);     // Catch: Exception -> L24
        goto L19
    L17:
        r112 = d0.b(r211);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void handleObricAction(String r210, String r211, IObricActionResultCallbackIDL r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "handleObricAction(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "handleObricAction(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "handleObricAction", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "handleObricAction(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r212 != null) goto L10;
    L18:
        IObricActionResultCallbackIDL r111 = r212;
    L19:
        r106.handleObricAction(r210, r211, r111);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "handleObricAction = void");     // Catch: Exception -> L24
    L22:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r112 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "handleObricAction(" + r210 + ", " + r211 + ", " + r212 + ") = void", r112);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "handleObricAction", r112, r214);     // Catch: Exception -> L24
        return;
    L10:
        if ((r212 instanceof ObricActionResultCallbackIDLIpcWrapper) == true) goto L18;
        if ((r212 instanceof ObricActionResultCallbackIDLStubWrapper) == true) goto L18;
        if ((r212 instanceof IObricActionResultCallbackIDL.Stub) == false) goto L17;
        r111 = h4.a((IObricActionResultCallbackIDL.Stub) r212);     // Catch: Exception -> L24
        goto L19
    L17:
        r111 = h4.b(r212);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyAssistantState(String r210, boolean r211, StateInfo r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "notifyAssistantState(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "notifyAssistantState(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "notifyAssistantState", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "notifyAssistantState(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyAssistantState(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "notifyAssistantState = void");     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "notifyAssistantState(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "notifyAssistantState", r111, r214);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openAssistantInputPanel(String r210, StateInfo r211, boolean r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "openAssistantInputPanel(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "openAssistantInputPanel(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "openAssistantInputPanel", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "openAssistantInputPanel(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.openAssistantInputPanel(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "openAssistantInputPanel = void");     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r111 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "openAssistantInputPanel(" + r210 + ", " + r211 + ", " + r212 + ") = void", r111);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "openAssistantInputPanel", r111, r214);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r210, boolean r211, Bundle r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", "requestBiometricAuthentication(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", "requestBiometricAuthentication(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "requestBiometricAuthentication", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "requestBiometricAuthentication(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r106 = this.origin;     // Catch: Exception -> L24
        if (r210 != null) goto L10;
    L18:
        IRequestAuthenticationCallbackIDL r111 = r210;
    L19:
        r106.requestBiometricAuthentication(r111, r211, r212);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "requestBiometricAuthentication = void");     // Catch: Exception -> L24
    L22:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r112 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L24
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", "requestBiometricAuthentication(" + r210 + ", " + r211 + ", " + r212 + ") = void", r112);     // Catch: Exception -> L24
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "requestBiometricAuthentication", r112, r214);     // Catch: Exception -> L24
        return;
    L10:
        if ((r210 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L18;
        if ((r210 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L18;
        if ((r210 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L17;
        r111 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r210);     // Catch: Exception -> L24
        goto L19
    L17:
        r111 = r4.b(r210);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void addCustomBarAction(String r310, String r311, String r312, long r313) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L23:
        e = e;
        String r100 = "addCustomBarAction(";
        long r101 = r313;
        long r111 = 0;
    L25:
        int r102 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r101 + ")", e);
        IPCException r103 = new IPCException(e);
        long r210 = SystemClock.elapsedRealtimeNanos();
        long r104 = Math.max(r111, r210 - r110) / 1000;
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r101 + ") = fail", r103, r104);
        IPCAnomalyTrace r106 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "addCustomBarAction", r103, r104, r210);
        throw r103;
    L4:
        if (this.log == false) goto L6;
        int r107 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L23
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "addCustomBarAction(" + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ")");     // Catch: Exception -> L23
    L6:
        r111 = 0;
        this.origin.addCustomBarAction(r310, r311, r312, r313);     // Catch: Exception -> L21
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "addCustomBarAction = void");     // Catch: Exception -> L21
    L11:
        long r211 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L21
        long r108 = Math.max(0, r211 - r110) / 1000;     // Catch: Exception -> L21
        int r109 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L21
        r100 = "addCustomBarAction(";
        StringBuilder r112 = new StringBuilder(r100);     // Catch: Exception -> L19
        r112.append(r310);     // Catch: Exception -> L19
        r112.append(", ");     // Catch: Exception -> L19
        r112.append(r311);     // Catch: Exception -> L19
        r112.append(", ");     // Catch: Exception -> L19
        r112.append(r312);     // Catch: Exception -> L19
        r112.append(", ");     // Catch: Exception -> L19
        r101 = r313;
        r112.append(r101);     // Catch: Exception -> L17
        r112.append(") = void");     // Catch: Exception -> L17
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", r112.toString(), r108);     // Catch: Exception -> L17
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "addCustomBarAction", r108, r211);     // Catch: Exception -> L17
        return;
    L17:
        e = e;
    L19:
        e = e;
        r101 = r313;
    L21:
        e = e;
        r101 = r313;
        r100 = "addCustomBarAction(";
        goto L25
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void suspendDismissKeyguard(String r310, String[] r311, IDismissKeyguardCallbackIDL r312, boolean r313, Bundle r314) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L36:
        e = e;
        String r100 = "suspendDismissKeyguard(";
        String r210 = ")";
        long r101 = 0;
        Bundle r102 = r314;
    L38:
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("FlowUiIDLStub", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + r210, e);
        IPCException r104 = new IPCException(e);
        long r211 = SystemClock.elapsedRealtimeNanos();
        long r105 = Math.max(r101, r211 - r110) / 1000;
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("FlowUiIDLStub", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + ") = fail", r104, r105);
        IPCAnomalyTrace r107 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowUiIDLStub", "suspendDismissKeyguard", r104, r105, r211);
        throw r104;
    L4:
        if (this.log == false) goto L6;
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L36
        com.obric.aiagent.ipc.utils.h.c("FlowUiIDLStub", "suspendDismissKeyguard(" + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r314 + ")");     // Catch: Exception -> L36
    L6:
        IFlowUiIDL.Stub r109 = this.origin;     // Catch: Exception -> L36
        if (r312 != null) goto L10;
    L19:
        IDismissKeyguardCallbackIDL r111 = r312;
    L20:
        r210 = ")";
        r109.suspendDismissKeyguard(r310, r311, r111, r313, r314);     // Catch: Exception -> L34
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.h.d("FlowUiIDLStub", "suspendDismissKeyguard = void");     // Catch: Exception -> L34
    L24:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L34
        long r112 = Math.max(0, r212 - r110) / 1000;     // Catch: Exception -> L34
        int r113 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L34
        r100 = "suspendDismissKeyguard(";
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
        com.obric.aiagent.ipc.utils.i.d("FlowUiIDLStub", r114.toString(), r112);     // Catch: Exception -> L30
        IPCAnomalyTrace.f384709a.e("FlowUiIDLStub", "suspendDismissKeyguard", r112, r212);     // Catch: Exception -> L30
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
        r100 = "suspendDismissKeyguard(";
        goto L38
    L10:
        if ((r312 instanceof DismissKeyguardCallbackIDLIpcWrapper) == true) goto L19;
        if ((r312 instanceof DismissKeyguardCallbackIDLStubWrapper) == true) goto L19;
        if ((r312 instanceof IDismissKeyguardCallbackIDL.Stub) == false) goto L17;
        r111 = a0.a((IDismissKeyguardCallbackIDL.Stub) r312);     // Catch: Exception -> L36
        goto L20
    L17:
        r111 = a0.b(r312);     // Catch: Exception -> L36
        goto L20
    }
}
