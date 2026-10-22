package com.obric.assistant.voice;

import android.service.voice.VoiceInteractionSession;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 (2\u00020\u0001:\u0001(J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H'J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0013\u001a\u00020\u000bH&J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000bH&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u000bH&J\b\u0010\u0019\u001a\u00020\u0003H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020#H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0010H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0010H&¨\u0006)"}, d2 = {"Lcom/obric/assistant/voice/IObricVoiceService;", "", "wakeupAssistant", "", "requestFrom", "", "getVoiceInteractionSession", "Landroid/service/voice/VoiceInteractionSession;", "initSessionEnvironment", "pullUpAssistOnce", "isCurrentSessionFromBreathWakeup", "", "setEnrollingStatus", "status", "trackEnrollData", "trackerId", "", "metaData", "isAiKeyPressing", "isDoraPressing", "getCurrentWakeupID", "()Ljava/lang/Integer;", "isCurrentSessionFromWakeup", "registerTaskStackListener", "isDefaultAssistant", "onUserSpeaking", "getCurrentListeningPresentation", "Lcom/obric/assistant/voice/ObricListeningPresentation;", "registerListeningPresentationListener", "listener", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningPresentationListener;", "unregisterListeningPresentationListener", "getChildListeningSurfaceSnapshot", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceSnapshot;", "registerChildListeningSurfaceListener", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceListener;", "unregisterChildListeningSurfaceListener", "acknowledgeChildListeningSurfaceLinked", "generation", "releaseChildListeningSurfaceLink", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricVoiceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f394360a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f394361a = null;

        static {
            f394361a = new a();
        }

        public a() {
        }

        public static IObricVoiceService a() {
            return (IObricVoiceService) ServiceManager.get().getService(IObricVoiceService.class, false, false);
        }
    }

    static {
        f394360a = a.f394361a;
    }

    boolean a();

    boolean b();

    void c(int r100);

    boolean d();

    void e(int r100, String r101);

    ObricVoiceServiceImpl.b f();

    void g(com.obric.assistant.view.listening.h r100);

    void h(com.obric.assistant.view.listening.h r100);

    void i(boolean r100);

    boolean isAiKeyPressing();

    void j();

    void k(aba.a r100);

    void l(aba.a r100);

    VoiceInteractionSession m();

    boolean n();

    void o(int r100);

    aba.b p();

    Integer q();
}
