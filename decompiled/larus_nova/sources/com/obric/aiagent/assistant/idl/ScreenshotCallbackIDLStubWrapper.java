package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class ScreenshotCallbackIDLStubWrapper extends IScreenshotCallbackIDL.Stub {
    boolean log;
    final IScreenshotCallbackIDL.Stub origin;

    public ScreenshotCallbackIDLStubWrapper(IScreenshotCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onError(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("ScreenshotCallbackIDLStub", "onError(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("ScreenshotCallbackIDLStub", "onError(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("ScreenshotCallbackIDLStub", LynxVideoManagerLite.EVENT_ON_ERROR, r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("ScreenshotCallbackIDLStub", "onError(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onError(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("ScreenshotCallbackIDLStub", "onError = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("ScreenshotCallbackIDLStub", "onError(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("ScreenshotCallbackIDLStub", LynxVideoManagerLite.EVENT_ON_ERROR, r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshot(Bitmap r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("ScreenshotCallbackIDLStub", "onReceivedScreenshot(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("ScreenshotCallbackIDLStub", "onReceivedScreenshot(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("ScreenshotCallbackIDLStub", "onReceivedScreenshot", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("ScreenshotCallbackIDLStub", "onReceivedScreenshot(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onReceivedScreenshot(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("ScreenshotCallbackIDLStub", "onReceivedScreenshot = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("ScreenshotCallbackIDLStub", "onReceivedScreenshot(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("ScreenshotCallbackIDLStub", "onReceivedScreenshot", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshotUri(Uri r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onReceivedScreenshotUri(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri", r113, r112);     // Catch: Exception -> L11
    }

    public ScreenshotCallbackIDLStubWrapper(IScreenshotCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
