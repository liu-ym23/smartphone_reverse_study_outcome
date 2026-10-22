package com.larus.audio;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.ttsV2.TtsClientManager;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bg\u0018\u0000 ^2\u00020\u0001:\u0001^J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J¶\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u000b2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u000bH&J®\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u000bH&J\u0082\u0001\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\"\u001a\u00020\u000bH&J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000bH&J\u0018\u0010)\u001a\u00020\r2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010+H&J\u001a\u0010,\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/H&J\b\u00100\u001a\u000201H&J\u0010\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\u000fH&J\"\u00104\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000fH&J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u001dH&J\b\u00107\u001a\u00020\rH&J\b\u00108\u001a\u00020\rH&J\b\u00109\u001a\u00020:H&J\u0010\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020=H&J\u0010\u0010>\u001a\u00020\r2\u0006\u0010<\u001a\u00020=H&J\u0010\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u000bH&J\u0012\u0010A\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010CH&J\u0010\u0010D\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u000bH\u0016J&\u0010E\u001a\u00020\r2\u001c\u0010F\u001a\u0018\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u00010GH\u0016J+\u0010J\u001a\u00020\r2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\r0KH&J(\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\u000f2\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H&J(\u0010Q\u001a\u00020\r2\u0006\u0010O\u001a\u00020\u000f2\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H&J\u0018\u0010R\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u000fH&J\u0010\u0010T\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH&J\u0010\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u000201H&J\u0010\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020\u000fH&J0\u0010Y\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\u000f2\b\u0010[\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\\\u001a\u0004\u0018\u00010\u000fH&J\b\u0010]\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006_"}, d2 = {"Lcom/larus/audio/IFlowTtsClientService;", "", "commonConfig", "Lcom/larus/audio/audiov3/config/task/sami/CommonConfig;", "getCommonConfig", "()Lcom/larus/audio/audiov3/config/task/sami/CommonConfig;", "setCommonConfig", "(Lcom/larus/audio/audiov3/config/task/sami/CommonConfig;)V", "getTtsManager", "Lcom/larus/audio/audiov3/task/ITtsManager;", "isPlayerPlaying", "", "startTts", "", DBDefinition.TASK_ID, "", "conversationId", RemoteMessageConst.MSGID, "isFirstSpeak", "speakerStyleId", "llModelName", "enableTextReading", "payloadExtParams", "", "extra", "externalTtsListener", "Lcom/larus/audio/audiov3/task/tts/ITtsListener;", "audioMetrics", "targetLufs", "", "loudNormAlgoType", "", "isFromManual", "business", "hasAudioFocus", "text", "startTtsStream", "ttsStreamType", "Lcom/bytedance/flow_audio/api/business/tts/config/FlowAudioTtsStreamType;", "setInterruptStopTts", "interruptStopTts", "setOnStopAudioPlayListener", "listener", "Lkotlin/Function0;", "startAudioPlay", "setAudioPlayStateChangeCallback", "callback", "Lcom/larus/audio/audiov3/tts/AudioPlayStateChangeCallback;", "getTtsAndPlayerState", "Lcom/larus/audio/audiov3/tts/PlayStateEnum;", "cancelAllTtsAndAudioPlay", "reason", "cancelTtsAndAudioPlay", "setVolume", "volumeFactor", "resumeAudioPlay", "pauseAudioPlay", "getAudioPlayerState", "Lcom/larus/audio/audiov3/audio/player/AudioPlayerState;", "addAudioPlayerListener", "audioPlayerListener", "Lcom/larus/audio/audiov3/audio/player/IAudioPlayerListener;", "removeAudioPlayerListener", "ttsAutoTimeoutCancel", "enable", "setTtsTimeoutDuration", "timeoutStrategy", "Lcom/larus/audio/settings/tts/TtsTimeoutStrategy;", "setKmpTtsCancelTaskIdCheckEnabled", "setKmpTtsAudioTrackProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lkotlin/Function2;", "Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfig;", "Landroid/media/AudioTrack;", "setTtsCancelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "reportTtsStepStart", "step", "extraMap", "reportTtsStepSuccess", "doCostMobOnUserStartTTs", "funcChannel", "doCostMobOnRecodeStep", "changeAudioPlayState", "playStateEnum", "deleteTtsCache", "cacheKey", "enableTtsCache", "messageId", "voiceStyleId", "selectedText", "onAccountStatusChange", "Companion", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowTtsClientService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f288300a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f288301a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static volatile IFlowTtsClientService f288302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static volatile n68.a f288303c;

        static {
            f288301a = new a();
        }

        public a() {
        }

        public static IFlowTtsClientService a() {
            IFlowTtsClientService r100 = f288302b;
            if (r100 == null) goto L5;
            return r100;
        L5:
            m58.o r101 = m58.h.f512143n;
            if (r101 == null) goto L10;
            boolean r102 = true;
            if (r101.enableKmpTts() != true) goto L10;
        L11:
            int r103 = c68.b.f22600a;
            c68.b.d("IFlowTtsClientService", "abService: " + r101 + ", kmpTtsEnable: " + r102);
            if (r102 == false) goto L14;
            IFlowTtsClientService r104 = (IFlowTtsClientService) ServiceManager.get().getService(IFlowTtsClientKmpService.class);
        L15:
            if (r101 == null) goto L20;
            n68.a r105 = f288303c;
            if (r105 == null) goto L19;
            r104.C(r105);
        L19:
            f288302b = r104;
        L20:
            Intrinsics.checkNotNull(r104);
            return r104;
        L14:
            r104 = (IFlowTtsClientService) ServiceManager.get().getService(IFlowTtsClientService.class);
        L10:
            r102 = false;
            goto L11
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IFlowTtsClientService r110, String r111, String r210, String r211, String r212, String r213, Map r214, l68.b r215, String r216, float r217, int r218, int r219) {
            if ((r219 & 2) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r219 & 4) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r219 & 32) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r219 & 64) == 0) goto L17;
            Map r112 = null;
        L19:
            if ((r219 & 128) == 0) goto L21;
            l68.b r113 = null;
        L23:
            if ((r219 & 256) == 0) goto L25;
            String r114 = "";
        L27:
            if ((r219 & 512) == 0) goto L29;
            float r115 = 0.0f;
        L31:
            if ((r219 & 1024) == 0) goto L33;
            int r116 = 0;
        L35:
            if ((r219 & 8192) == 0) goto L37;
            boolean r117 = true;
        L38:
            r110.B(r111, r100, r101, r212, null, r102, r112, r113, r114, r115, r116, false, 0, r117);
            return;
        L37:
            r117 = false;
            goto L38
        L33:
            r116 = r218;
            goto L35
        L29:
            r115 = r217;
            goto L31
        L25:
            r114 = r216;
            goto L27
        L21:
            r113 = r215;
            goto L23
        L17:
            r112 = r214;
            goto L19
        L13:
            r102 = r213;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    static {
        f288300a = a.f288301a;
    }

    void A(String r100, Map<String, ? extends Object> r101);

    void B(String r100, String r101, String r102, String r103, String r104, String r105, Map<String, String> r106, l68.b r107, String r108, float r110, int r111, boolean r112, int r113, boolean r114);

    void C(n68.a r100);

    boolean a();

    void b(String r100);

    void c(o r100);

    void d(String r100, String r101);

    void e(String r100);

    void f(String r100);

    void g(String r100, boolean r101, String r102);

    boolean h(String r100, String r101, String r102, String r103);

    void i(String r100, String r101);

    void j(boolean r100);

    void k();

    void l();

    PlayStateEnum m();

    void n(boolean r100);

    void o(com.larus.audio.ttsV2.h r100);

    void p(String r100, Map<String, ? extends Object> r101);

    void q();

    void r();

    void s(boolean r100);

    void setVolume(float r100);

    void t(q58.b r100);

    void u(String r100, String r101, String r102, boolean r103, String r104, String r105, boolean r106, Map r107, String r108, TtsClientManager.e r110, String r111, float r112, int r113, boolean r114, int r115, boolean r116);

    void v(PlayStateEnum r100);

    void w(x58.a r100);

    void x(q58.b r100);

    void y(u78.a r100);

    void z(com.larus.bmhome.chat.trace.c0 r100);
}
