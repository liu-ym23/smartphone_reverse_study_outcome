package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class AgentAppIntentIDLIpcWrapper implements IAgentAppIntentIDL {
    boolean log;
    final IAgentAppIntentIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isAppIntentActive() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "isAppIntentActive()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "isAppIntentActive() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "isAppIntentActive", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "isAppIntentActive()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "isAppIntentActive()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isAppIntentActive();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "isAppIntentActive = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "isAppIntentActive() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "isAppIntentActive", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isWifiEnabled() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "isWifiEnabled()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "isWifiEnabled() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "isWifiEnabled", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "isWifiEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "isWifiEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.isWifiEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "isWifiEnabled = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "isWifiEnabled() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "isWifiEnabled", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void jumpToSystemOtaPage() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.jumpToSystemOtaPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyCloseAutoGUISwitch() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyCloseAutoGUISwitch();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyUserAgreePrivacy() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyUserAgreePrivacy();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int pauseMusic() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        int r110 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "pauseMusic()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "pauseMusic() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "pauseMusic", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "pauseMusic()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "pauseMusic()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.pauseMusic();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "pauseMusic = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "pauseMusic() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "pauseMusic", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMusicPage() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showMusicPage()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showMusicPage() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showMusicPage", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showMusicPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showMusicPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showMusicPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showMusicPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showMusicPage() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showMusicPage", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void terminateService() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "terminateService()", e);     // Catch: Throwable -> L17
        IPCException r110 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r112 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "terminateService() = fail", r110, r112);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "terminateService", r110, r112, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "terminateService()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "terminateService()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.terminateService();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "terminateService = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "terminateService() = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "terminateService", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public AgentAppIntentIDLIpcWrapper(IAgentAppIntentIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callShortLink(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "callShortLink(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "callShortLink(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "callShortLink", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "callShortLink(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "callShortLink(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.callShortLink(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "callShortLink = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "callShortLink(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "callShortLink", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void clearAllOmniTask(Map r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "clearAllOmniTask", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.clearAllOmniTask(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "clearAllOmniTask = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "clearAllOmniTask", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedback(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.drainOmniUploadImagesForFeedback(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<AppEntity> getAppEntityList(Map r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        List<AppEntity> r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "getAppEntityList(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "getAppEntityList(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "getAppEntityList", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getAppEntityList(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getAppEntityList(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getAppEntityList(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "getAppEntityList = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "getAppEntityList(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "getAppEntityList", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getComplexTaskPanelInfoFromPC(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        List<String> r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getComplexTaskPanelInfoFromPC(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public IntentDebugReport getIntentExecution(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        IntentDebugReport r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "getIntentExecution(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "getIntentExecution(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "getIntentExecution", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getIntentExecution(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getIntentExecution(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getIntentExecution(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "getIntentExecution = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "getIntentExecution(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "getIntentExecution", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public Map getOmniExtraLog(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        Map r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "getOmniExtraLog", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getOmniExtraLog(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "getOmniExtraLog = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "getOmniExtraLog", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getOmniJournalPath(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        List<String> r110 = null;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "getOmniJournalPath", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getOmniJournalPath(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "getOmniJournalPath = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "getOmniJournalPath", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopComplexTask(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "notifyStopComplexTask", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyStopComplexTask(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "notifyStopComplexTask = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "notifyStopComplexTask", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void onLoginStateChange(boolean r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "onLoginStateChange", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onLoginStateChange(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "onLoginStateChange = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "onLoginStateChange", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void registerMusicStateListener(IMusicStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "registerMusicStateListener(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "registerMusicStateListener(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "registerMusicStateListener", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "registerMusicStateListener(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("registerMusicStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IMusicStateListenerIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof MusicStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof MusicStateListenerIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IMusicStateListenerIDL.Stub) == false) goto L19;
        r113 = e4.a((IMusicStateListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = e4.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IMusicStateListenerIDL r114 = r210;
    L35:
        r107.registerMusicStateListener(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "registerMusicStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "registerMusicStateListener(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "registerMusicStateListener", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r210 instanceof MusicStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof MusicStateListenerIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IMusicStateListenerIDL.Stub) == false) goto L33;
        r114 = e4.a((IMusicStateListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = e4.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void screenShot(IScreenshotCallbackIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "screenShot(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "screenShot(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "screenShot", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "screenShot(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("screenShot(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IScreenshotCallbackIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof ScreenshotCallbackIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof ScreenshotCallbackIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IScreenshotCallbackIDL.Stub) == false) goto L19;
        r113 = u4.a((IScreenshotCallbackIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = u4.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IScreenshotCallbackIDL r114 = r210;
    L35:
        r107.screenShot(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "screenShot = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "screenShot(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "screenShot", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r210 instanceof ScreenshotCallbackIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof ScreenshotCallbackIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IScreenshotCallbackIDL.Stub) == false) goto L33;
        r114 = u4.a((IScreenshotCallbackIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = u4.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void setDebugReferImg(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "setDebugReferImg", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setDebugReferImg(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "setDebugReferImg = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "setDebugReferImg", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean setWifiEnabled(boolean r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "setWifiEnabled", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.setWifiEnabled(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "setWifiEnabled = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "setWifiEnabled", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlarm(AlarmEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showAlarm(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showAlarm(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showAlarm", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showAlarm(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showAlarm(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showAlarm(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showAlarm = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showAlarm(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showAlarm", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlbum(AlbumEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showAlbum(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showAlbum(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showAlbum", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showAlbum(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showAlbum(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showAlbum(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showAlbum = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showAlbum(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showAlbum", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAuditoryRecording(AuditoryRecordingEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showAuditoryRecording", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showAuditoryRecording(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showAuditoryRecording = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showAuditoryRecording", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCallHistory(CallHistoryEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showCallHistory(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showCallHistory(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showCallHistory", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showCallHistory(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showCallHistory(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showCallHistory(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showCallHistory = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showCallHistory(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showCallHistory", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showContact(ContactEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showContact(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showContact(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showContact", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showContact(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showContact(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showContact(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showContact = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showContact(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showContact", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCountdown(CountdownEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showCountdown(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showCountdown(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showCountdown", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showCountdown(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showCountdown(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showCountdown(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showCountdown = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showCountdown(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showCountdown", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showFile(FileEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showFile(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showFile(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showFile", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showFile(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showFile(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showFile(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showFile = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showFile(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showFile", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showLarkUrl(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showLarkUrl(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showLarkUrl(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showLarkUrl", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showLarkUrl(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showLarkUrl(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showLarkUrl(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showLarkUrl = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showLarkUrl(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showLarkUrl", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMemory(MemoryEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showMemory(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showMemory(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showMemory", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showMemory(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showMemory(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showMemory(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showMemory = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showMemory(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showMemory", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMessage(MessageEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showMessage(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showMessage(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showMessage", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showMessage(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showMessage(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showMessage(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showMessage(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showMessage", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showNote(NoteEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showNote(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showNote(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showNote", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showNote(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showNote(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showNote(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showNote = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showNote(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showNote", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProactiveMemory(ProactiveMemoryEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showProactiveMemory", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showProactiveMemory(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showProactiveMemory = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showProactiveMemory", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProxyCallHistory(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showProxyCallHistory", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showProxyCallHistory(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showProxyCallHistory = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showProxyCallHistory", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showRecording(RecordingEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showRecording(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showRecording(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showRecording", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showRecording(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showRecording(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showRecording(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showRecording = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showRecording(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showRecording", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showSchedule(ScheduleEntity r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showSchedule(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showSchedule(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showSchedule", r111, r101, r112);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showSchedule(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showSchedule(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showSchedule(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showSchedule = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r114 = Math.max(0, r113 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showSchedule(" + r210 + ") = void", r114);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showSchedule", r114, r113);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void takeScreenshot(IScreenshotCallbackIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "takeScreenshot(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "takeScreenshot(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "takeScreenshot", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "takeScreenshot(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("takeScreenshot(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IScreenshotCallbackIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof ScreenshotCallbackIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof ScreenshotCallbackIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IScreenshotCallbackIDL.Stub) == false) goto L19;
        r113 = u4.a((IScreenshotCallbackIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = u4.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IScreenshotCallbackIDL r114 = r210;
    L35:
        r107.takeScreenshot(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "takeScreenshot = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "takeScreenshot(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "takeScreenshot", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r210 instanceof ScreenshotCallbackIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof ScreenshotCallbackIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IScreenshotCallbackIDL.Stub) == false) goto L33;
        r114 = u4.a((IScreenshotCallbackIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = u4.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void unregisterMusicStateListener(IMusicStateListenerIDL r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "unregisterMusicStateListener(" + r210 + ")", e);     // Catch: Throwable -> L43
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L43
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L43
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "unregisterMusicStateListener(" + r210 + ") = fail", r111, r101);     // Catch: Throwable -> L43
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "unregisterMusicStateListener", r111, r101, r112);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r104 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "unregisterMusicStateListener(" + r210 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r106 = new StringBuilder("unregisterMusicStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L12;
    L20:
        IMusicStateListenerIDL r113 = r210;
    L21:
        r106.append(r113);     // Catch: Exception -> L40 Throwable -> L43
        r106.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", r106.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r210 instanceof MusicStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r210 instanceof MusicStateListenerIDLStubWrapper) == true) goto L20;
        if ((r210 instanceof IMusicStateListenerIDL.Stub) == false) goto L19;
        r113 = e4.a((IMusicStateListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r113 = e4.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r107 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r210 != null) goto L26;
    L34:
        IMusicStateListenerIDL r114 = r210;
    L35:
        r107.unregisterMusicStateListener(r114);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "unregisterMusicStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r108 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "unregisterMusicStateListener(" + r210 + ") = void", r116);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "unregisterMusicStateListener", r116, r115);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r210 instanceof MusicStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r210 instanceof MusicStateListenerIDLStubWrapper) == true) goto L34;
        if ((r210 instanceof IMusicStateListenerIDL.Stub) == false) goto L33;
        r114 = e4.a((IMusicStateListenerIDL.Stub) r210);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r114 = e4.b(r210);     // Catch: Exception -> L40 Throwable -> L43
    }

    public AgentAppIntentIDLIpcWrapper(IAgentAppIntentIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteEntities(AppEntity[] r210, IEntityDeleteCallbackIDL r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "deleteEntities(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L43
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L43
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L43
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "deleteEntities(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L43
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "deleteEntities", r101, r102, r111);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "deleteEntities(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r107 = new StringBuilder("deleteEntities(");     // Catch: Exception -> L40 Throwable -> L43
        r107.append(r210);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L12;
    L20:
        IEntityDeleteCallbackIDL r112 = r211;
    L21:
        r107.append(r112);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", r107.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r211 instanceof EntityDeleteCallbackIDLIpcWrapper) == true) goto L20;
        if ((r211 instanceof EntityDeleteCallbackIDLStubWrapper) == true) goto L20;
        if ((r211 instanceof IEntityDeleteCallbackIDL.Stub) == false) goto L19;
        r112 = g0.a((IEntityDeleteCallbackIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r112 = g0.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r108 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r211 != null) goto L26;
    L34:
        IEntityDeleteCallbackIDL r113 = r211;
    L35:
        r108.deleteEntities(r210, r113);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "deleteEntities = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r109 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "deleteEntities(" + r210 + ", " + r211 + ") = void", r115);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "deleteEntities", r115, r114);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r211 instanceof EntityDeleteCallbackIDLIpcWrapper) == true) goto L34;
        if ((r211 instanceof EntityDeleteCallbackIDLStubWrapper) == true) goto L34;
        if ((r211 instanceof IEntityDeleteCallbackIDL.Stub) == false) goto L33;
        r113 = g0.a((IEntityDeleteCallbackIDL.Stub) r211);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r113 = g0.b(r211);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyLarkSendStausChanged(String r210, int r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged", r101, r102, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyLarkSendStausChanged(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged", r113, r112);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopAutoAction(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "notifyStopAutoAction", r101, r102, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyStopAutoAction(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "notifyStopAutoAction = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "notifyStopAutoAction", r113, r112);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showPhoto(PhotoEntity[] r210, int r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showPhoto(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showPhoto(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showPhoto", r101, r102, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showPhoto(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showPhoto(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showPhoto(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showPhoto = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showPhoto(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showPhoto", r113, r112);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showWeather(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "showWeather(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "showWeather(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "showWeather", r101, r102, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showWeather(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "showWeather(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showWeather(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "showWeather = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "showWeather(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "showWeather", r113, r112);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void turnOnOffAlarm(AlarmEntity r210, boolean r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r111 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "turnOnOffAlarm", r101, r102, r111);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.turnOnOffAlarm(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "turnOnOffAlarm = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "turnOnOffAlarm", r113, r112);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteRecordings(RecordingEntity[] r210, boolean r211, IRecordingDeleteCallbackIDL r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "deleteRecordings(" + r210 + ", " + r211 + ", " + r212 + ")", e);     // Catch: Throwable -> L43
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L43
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r102 = Math.max(0, r213 - r100) / 1000;     // Catch: Throwable -> L43
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "deleteRecordings(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);     // Catch: Throwable -> L43
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "deleteRecordings", r101, r102, r213);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "deleteRecordings(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r107 = new StringBuilder("deleteRecordings(");     // Catch: Exception -> L40 Throwable -> L43
        r107.append(r210);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r107.append(r211);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r212 != null) goto L12;
    L20:
        IRecordingDeleteCallbackIDL r111 = r212;
    L21:
        r107.append(r111);     // Catch: Exception -> L40 Throwable -> L43
        r107.append(")");     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", r107.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r212 instanceof RecordingDeleteCallbackIDLIpcWrapper) == true) goto L20;
        if ((r212 instanceof RecordingDeleteCallbackIDLStubWrapper) == true) goto L20;
        if ((r212 instanceof IRecordingDeleteCallbackIDL.Stub) == false) goto L19;
        r111 = o4.a((IRecordingDeleteCallbackIDL.Stub) r212);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r111 = o4.b(r212);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r108 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r212 != null) goto L26;
    L34:
        IRecordingDeleteCallbackIDL r112 = r212;
    L35:
        r108.deleteRecordings(r210, r211, r112);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "deleteRecordings = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r113 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r109 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "deleteRecordings(" + r210 + ", " + r211 + ", " + r212 + ") = void", r113);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "deleteRecordings", r113, r214);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r212 instanceof RecordingDeleteCallbackIDLIpcWrapper) == true) goto L34;
        if ((r212 instanceof RecordingDeleteCallbackIDLStubWrapper) == true) goto L34;
        if ((r212 instanceof IRecordingDeleteCallbackIDL.Stub) == false) goto L33;
        r112 = o4.a((IRecordingDeleteCallbackIDL.Stub) r212);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r112 = o4.b(r212);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int playMusic(String r210, MusicEntity[] r211, MusicEntity r212) throws RemoteException {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aiagent.assistant.idl.AgentAppIntentIDLIpcWrapper.playMusic(java.lang.String, com.obric.capabilitykit.entity.app.MusicEntity[], com.obric.capabilitykit.entity.app.MusicEntity):int");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callPhone(String r210, ContactEntity r211, String r212, String r213) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "callPhone(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r114 = Math.max(0, r113 - r110) / 1000;     // Catch: Throwable -> L17
        int r100 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "callPhone(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = fail", r112, r114);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "callPhone", r112, r114, r113);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r102 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "callPhone(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "callPhone(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.callPhone(r210, r211, r212, r213);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "callPhone = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r214 - r110) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "callPhone(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = void", r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "callPhone", r115, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithType(String r210, String r211, List<String> r212, String r213) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r114 = Math.max(0, r113 - r110) / 1000;     // Catch: Throwable -> L17
        int r100 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = fail", r112, r114);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType", r112, r114, r113);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r102 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.drainOmniUploadImagesForFeedbackWithType(r210, r211, r212, r213);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r214 - r110) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = void", r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType", r115, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void replyAskUser(String r210, String r211, String r212, Map r213) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "replyAskUser(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r114 = Math.max(0, r113 - r110) / 1000;     // Catch: Throwable -> L17
        int r100 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "replyAskUser(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = fail", r112, r114);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "replyAskUser", r112, r114, r113);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r102 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "replyAskUser(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "replyAskUser(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.replyAskUser(r210, r211, r212, r213);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "replyAskUser = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r214 - r110) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "replyAskUser(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = void", r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "replyAskUser", r115, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void sendSms(String r210, ContactEntity r211, String r212, String r213) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", "sendSms(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r114 = Math.max(0, r113 - r110) / 1000;     // Catch: Throwable -> L17
        int r100 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", "sendSms(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = fail", r112, r114);     // Catch: Throwable -> L17
        IPCAnomalyTrace r101 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "sendSms", r112, r114, r113);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r102 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "sendSms(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "sendSms(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.sendSms(r210, r211, r212, r213);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "sendSms = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r214 - r110) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", "sendSms(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = void", r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "sendSms", r115, r214);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithInfo(String r310, String r311, List<String> r312, String r313, boolean r314) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L26:
        e = e;
        String r100 = "drainOmniUploadImagesForFeedbackWithInfo(";
        String r210 = ")";
        long r101 = 0;
        boolean r102 = r314;
    L28:
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L30
        com.obric.aiagent.ipc.utils.h.b("IAgentAppIntentIDLIPC", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + r210, e);     // Catch: Throwable -> L30
        IPCException r104 = new IPCException(e);     // Catch: Throwable -> L30
        long r211 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L30
        long r105 = Math.max(r101, r211 - r110) / 1000;     // Catch: Throwable -> L30
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L30
        com.obric.aiagent.ipc.utils.i.a("IAgentAppIntentIDLIPC", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + ") = fail", r104, r105);     // Catch: Throwable -> L30
        IPCAnomalyTrace r107 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L30
        IPCAnomalyTrace.b("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo", r104, r105, r211);     // Catch: Throwable -> L30
        return;
    L4:
        if (this.log == false) goto L7;
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L26 Throwable -> L30
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo(" + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r314 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L7:
        if (this.log == false) goto L9;
        int r109 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L26 Throwable -> L30
        com.obric.aiagent.ipc.utils.h.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo(" + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r314 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L9:
        r210 = ")";
        this.origin.drainOmniUploadImagesForFeedbackWithInfo(r310, r311, r312, r313, r314);     // Catch: Exception -> L24 Throwable -> L30
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.h.d("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo = void");     // Catch: Exception -> L24 Throwable -> L30
    L14:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24 Throwable -> L30
        long r111 = Math.max(0, r212 - r110) / 1000;     // Catch: Exception -> L24 Throwable -> L30
        int r112 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24 Throwable -> L30
        r100 = "drainOmniUploadImagesForFeedbackWithInfo(";
        StringBuilder r113 = new StringBuilder(r100);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(r310);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r113.append(r311);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r113.append(r312);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r113.append(r313);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r102 = r314;
        r101 = 0;
        r113.append(r102);     // Catch: Exception -> L20 Throwable -> L30
        r113.append(") = void");     // Catch: Exception -> L20 Throwable -> L30
        com.obric.aiagent.ipc.utils.i.b("IAgentAppIntentIDLIPC", r113.toString(), r111);     // Catch: Exception -> L20 Throwable -> L30
        IPCAnomalyTrace.f384709a.c("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo", r111, r212);     // Catch: Exception -> L20 Throwable -> L30
        return;
    L20:
        e = e;
    L22:
        e = e;
        r102 = r314;
        r101 = 0;
    L24:
        e = e;
        r102 = r314;
        r101 = 0;
        r100 = "drainOmniUploadImagesForFeedbackWithInfo(";
        goto L28
    }
}
