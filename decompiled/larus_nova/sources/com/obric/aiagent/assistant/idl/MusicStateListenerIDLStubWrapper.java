package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class MusicStateListenerIDLStubWrapper extends IMusicStateListenerIDL.Stub {
    boolean log;
    final IMusicStateListenerIDL.Stub origin;

    public MusicStateListenerIDLStubWrapper(IMusicStateListenerIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IMusicStateListenerIDL
    public void onMusicStateChanged(Bundle r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("MusicStateListenerIDLStub", "onMusicStateChanged(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("MusicStateListenerIDLStub", "onMusicStateChanged(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("MusicStateListenerIDLStub", "onMusicStateChanged", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("MusicStateListenerIDLStub", "onMusicStateChanged(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onMusicStateChanged(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("MusicStateListenerIDLStub", "onMusicStateChanged = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("MusicStateListenerIDLStub", "onMusicStateChanged(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("MusicStateListenerIDLStub", "onMusicStateChanged", r113, r112);     // Catch: Exception -> L11
    }

    public MusicStateListenerIDLStubWrapper(IMusicStateListenerIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
