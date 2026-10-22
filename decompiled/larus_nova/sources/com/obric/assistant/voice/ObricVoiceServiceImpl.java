package com.obric.assistant.voice;

import android.os.Build;
import android.service.voice.VoiceInteractionSession;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.utils.DefaultAssistantStatus;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.f0;
import com.obric.assistant.activation.presentation.runtime.manager.g0;
import com.obric.assistant.activation.presentation.runtime.manager.h0;
import com.obric.assistant.activation.presentation.runtime.manager.m0;
import com.obric.assistant.activation.presentation.runtime.manager.n0;
import com.obric.assistant.activation.presentation.runtime.manager.p0;
import com.obric.assistant.activation.presentation.runtime.manager.q0;
import com.obric.assistant.ipc.HostStateSyncManager;
import com.obric.assistant.ipc.IpcMessenger;
import com.obric.assistant.session.AiIslandVoiceInteractionSession;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.model.IVoiceWakeupOperation;
import com.obric.assistant.system.ITaskStackService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0017J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\"\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0015H\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/assistant/voice/ObricVoiceServiceImpl;", "Lcom/obric/assistant/voice/IObricVoiceService;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "AI_KEY_FINGER_PRINT_ENROLLING_CLASS", "wakeupAssistant", "", "requestFrom", "getVoiceInteractionSession", "Landroid/service/voice/VoiceInteractionSession;", "initSessionEnvironment", "pullUpAssistOnce", "isCurrentSessionFromBreathWakeup", "", "setEnrollingStatus", "status", "trackEnrollData", "trackerId", "", "metaData", "isAiKeyPressing", "isDoraPressing", "getCurrentWakeupID", "()Ljava/lang/Integer;", "isCurrentSessionFromWakeup", "registerTaskStackListener", "isDefaultAssistant", "onUserSpeaking", "getCurrentListeningPresentation", "Lcom/obric/assistant/voice/ObricListeningPresentation;", "registerListeningPresentationListener", "listener", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningPresentationListener;", "unregisterListeningPresentationListener", "getChildListeningSurfaceSnapshot", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceSnapshot;", "registerChildListeningSurfaceListener", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceListener;", "unregisterChildListeningSurfaceListener", "acknowledgeChildListeningSurfaceLinked", "generation", "releaseChildListeningSurfaceLink", "ListeningPresentation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVoiceServiceImpl implements IObricVoiceService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile VoiceInteractionSession f394365d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f394366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f394367c;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f394368a = null;

        static {
            f394368a = new b();
        }

        public b() {
        }

        @Override // com.obric.assistant.voice.d
        public final boolean b() {
            int r100 = sha.b.f542084a;
            ObricListeningMainProcessManager.f385330a.getClass();
            ObricListeningMainProcessManager.c r101 = ObricListeningMainProcessManager.f385349t.get();
            if (r101 == null) goto L11;
            if (r101.f385361b == true) goto L8;
            return false;
        L8:
            if (r101.f385362c.isValid() == false) goto L11;
            return true;
        L11:
            return ObricListeningMainProcessManager.f385335f;
        }

        @Override // com.obric.assistant.voice.d
        public final void confirmListeningStarted() {
            int r100 = sha.b.f542084a;
            ObricListeningMainProcessManager.f385330a.getClass();
            ObricListeningMainProcessManager.k(new p0());
        }

        @Override // com.obric.assistant.voice.d
        public final void finish() {
            int r100 = sha.b.f542084a;
            ObricListeningMainProcessManager r101 = ObricListeningMainProcessManager.f385330a;
            ObricListeningViewState r102 = ObricListeningViewState.f385269d;
            r101.getClass();
            ObricListeningMainProcessManager.p(r102);
        }

        @Override // com.obric.assistant.voice.d
        public final boolean isActive() {
            return sha.b.b();
        }

        @Override // com.obric.assistant.voice.d
        public final void a(ObricListeningViewState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            int r101 = sha.b.f542084a;
            Intrinsics.checkNotNullParameter(r100, "data");
            ObricListeningMainProcessManager.f385330a.getClass();
            ObricListeningMainProcessManager.p(r100);
        }
    }

    static {
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean a() {
        int r100 = com.obric.aiagent.assistant.utils.a.f384611a;
        if (com.obric.aiagent.assistant.utils.a.a(AppHost.f326268a.getApplication()) != DefaultAssistantStatus.IsDefaultAssistant) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean d() {
        VoiceInteractionSession r100 = f394365d;
        String r101 = null;
        if ((r100 instanceof AiIslandVoiceInteractionSession) == false) goto L5;
        AiIslandVoiceInteractionSession r102 = (AiIslandVoiceInteractionSession) r100;
    L6:
        boolean r103 = false;
        if (Build.VERSION.SDK_INT < 33) goto L22;
        if (r102 == null) goto L22;
        ISessionMaintaining r104 = bga.j.b();
        if (r104 == null) goto L12;
        String r105 = r104.w();
    L14:
        if (Intrinsics.areEqual(r105, "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L21;
        ISessionMaintaining r106 = bga.j.b();
        if (r106 == null) goto L19;
        r101 = r106.o();
    L19:
        if (Intrinsics.areEqual(r101, "BREATH") == false) goto L21;
        r103 = true;
    L21:
        FLogger.f375446a.i("AiIsland-SessionUtils", "isCurrentSessionFromBreathWakeup ? " + r103);
        goto L22
    L12:
        r105 = null;
    L22:
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final b f() {
        b r100 = b.f394368a;
        if (sha.b.a() == true) goto L7;
        return null;
    L7:
        return r100;
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void j() {
        IpcMessenger.f389953a.getClass();
        IpcMessenger.d();
        xna.a.c(new e(), new f(), new g(), new h(), new i());
        ITaskStackService r100 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r100 == null) goto L5;
        r100.d(new j(this));
    L5:
        HostStateSyncManager.f389943a.getClass();
        HostStateSyncManager.c("session_environment_ready");
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final VoiceInteractionSession m() {
        VoiceInteractionSession r100 = f394365d;
        if (r100 != null) goto L6;
        FLogger.f375446a.i(this.f394366b, "getVoiceInteractionSession session = null");
        return null;
    L6:
        return r100;
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean n() {
        VoiceInteractionSession r100 = f394365d;
        String r101 = null;
        if ((r100 instanceof AiIslandVoiceInteractionSession) == false) goto L5;
        AiIslandVoiceInteractionSession r102 = (AiIslandVoiceInteractionSession) r100;
    L7:
        if (Build.VERSION.SDK_INT < 33) goto L14;
        if (r102 == null) goto L15;
        ISessionMaintaining r103 = bga.j.b();
        if (r103 == null) goto L12;
        r101 = r103.w();
    L12:
        boolean r104 = Intrinsics.areEqual(r101, "WAKEUP_SOURCE_VOICE_ASSIST");
        FLogger.f375446a.i("AiIsland-SessionUtils", "isCurrentSessionFromAnyWakeup ? " + r104);
        return r104;
    L15:
        return false;
    L14:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final aba.b p() {
        int r100 = sha.b.f542084a;
        ObricListeningMainProcessManager.f385330a.getClass();
        return ObricListeningMainProcessManager.d();
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final Integer q() {
        IVoiceWakeupOperation r100 = (IVoiceWakeupOperation) ServiceManager.get().getService(IVoiceWakeupOperation.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.b());
    }

    public ObricVoiceServiceImpl() {
        this.f394366b = "ObricVoiceServiceImpl";
        this.f394367c = "com.android.settings.fingerprint.AIPoweredFingerprintEnrollingActivity";
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean b() {
        IDoraOperation r100 = bga.f.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.b();
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean isAiKeyPressing() {
        IAiKeyOperation r100 = bga.b.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isAiKeyPressing();
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void c(final int r100) {
        int r101 = sha.b.f542084a;
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.k(new m0(r100));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void g(final com.obric.assistant.view.listening.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        int r101 = sha.b.f542084a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ObricListeningMainProcessManager.f385330a.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ObricListeningMainProcessManager.k(new q0(r100));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void h(final com.obric.assistant.view.listening.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        int r101 = sha.b.f542084a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ObricListeningMainProcessManager.f385330a.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ObricListeningMainProcessManager.k(new h0(r100));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void i(boolean r100) {
        IpcMessenger.f389953a.getClass();
        n.f394383a = r100;
        IpcMessenger.f389956d.setValue(Boolean.valueOf(r100));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void k(final aba.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        int r101 = sha.b.f542084a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ObricListeningMainProcessManager.f385330a.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ObricListeningMainProcessManager.k(new g0(r100));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void l(final aba.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        int r101 = sha.b.f542084a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ObricListeningMainProcessManager.f385330a.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ObricListeningMainProcessManager.k(new f0(r100));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void o(final int r100) {
        int r101 = sha.b.f542084a;
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.k(new n0(r100));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void e(int r100, String r101) {
        IpcMessenger.f389953a.getClass();
        IpcMessenger.c(r100, r101);
    }
}
