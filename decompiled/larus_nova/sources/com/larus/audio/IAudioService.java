package com.larus.audio;

import androidx.lifecycle.LiveData;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarNormalHolder$handleLottieJob$1$1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShowTagInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002´\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\u001c\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005H&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J$\u0010\u0016\u001a\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aH&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000eH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001cH&J-\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u000f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"H&¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H&J\b\u0010'\u001a\u00020\u000fH&J\b\u0010(\u001a\u00020\u000fH&J\b\u0010)\u001a\u00020\u000fH&J\u001c\u0010*\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030,H¦@¢\u0006\u0002\u0010-J$\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0,2\f\u00101\u001a\b\u0012\u0004\u0012\u00020/0,H&J\u0010\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u000fH&J\b\u00104\u001a\u000205H&J\b\u00106\u001a\u00020/H&J\b\u00107\u001a\u00020\u0003H&J\b\u00108\u001a\u00020\u000fH&J3\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010/2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u0007H&¢\u0006\u0002\u0010>J$\u00109\u001a\u0004\u0018\u00010:2\b\u0010?\u001a\u0004\u0018\u00010@2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u0007H&J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\b\u0010B\u001a\u00020\u000fH&J\b\u0010C\u001a\u00020/H&J \u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u0005H&J\b\u0010I\u001a\u00020\u0003H&J\b\u0010J\u001a\u00020\u000fH&J\b\u0010K\u001a\u00020LH&J\b\u0010M\u001a\u00020NH&J\u0010\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u0005H&J4\u0010Q\u001a\u00020\u000f2\b\u0010R\u001a\u0004\u0018\u00010\u00052\b\u0010S\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0005H&J\b\u0010V\u001a\u00020\u000fH&J\b\u0010W\u001a\u00020\u000fH&J\b\u0010X\u001a\u00020YH&J\u0012\u0010Z\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010@H&J\b\u0010[\u001a\u00020\u000fH&J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\b\u0010]\u001a\u00020\u000fH&J\u0010\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u000fH&J\b\u0010`\u001a\u00020\u000fH&J\b\u0010a\u001a\u00020\u000fH&J\b\u0010b\u001a\u00020\u000fH&J\b\u0010c\u001a\u00020\u000fH&J\u0010\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u000fH&J\b\u0010f\u001a\u00020\u0003H&J\u0010\u0010g\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u0005H&J\u0010\u0010i\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u0005H&J\u0012\u0010j\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0012\u0010k\u001a\u0004\u0018\u00010\u00052\u0006\u0010l\u001a\u00020\u0005H&J\n\u0010m\u001a\u0004\u0018\u00010\u0005H&J\b\u0010n\u001a\u00020\u000fH&J\u0010\u0010o\u001a\u00020\u00032\u0006\u0010p\u001a\u00020qH&J\u0016\u0010r\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010sJ\u0012\u0010t\u001a\u00020\u000f2\b\b\u0002\u0010u\u001a\u00020\u000fH&J\b\u0010v\u001a\u00020\u000fH&J\u001c\u0010w\u001a\u00020\u00032\f\u0010x\u001a\b\u0012\u0004\u0012\u00020z0yH¦@¢\u0006\u0002\u0010{J\u0012\u0010|\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010}\u001a\u00020\u00032\u0006\u0010~\u001a\u00020\u0005H&J\t\u0010\u007f\u001a\u00030\u0080\u0001H&J\n\u0010\u0081\u0001\u001a\u00030\u0082\u0001H&J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H&J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H&J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H&J\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H&J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H&J\n\u0010\u008d\u0001\u001a\u00030\u008e\u0001H&J\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H&J\n\u0010\u0091\u0001\u001a\u00030\u0092\u0001H&J\n\u0010\u0093\u0001\u001a\u00030\u0094\u0001H&J\n\u0010\u0095\u0001\u001a\u00030\u0096\u0001H&J\n\u0010\u0097\u0001\u001a\u00030\u0098\u0001H&J\n\u0010\u0099\u0001\u001a\u00030\u009a\u0001H&J\n\u0010\u009b\u0001\u001a\u00030\u009c\u0001H&J\n\u0010\u009d\u0001\u001a\u00030\u009e\u0001H&J\n\u0010\u009f\u0001\u001a\u00030 \u0001H&J\n\u0010¡\u0001\u001a\u00030¢\u0001H&J\u0015\u0010£\u0001\u001a\u00020\u00032\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H&J\u0015\u0010¦\u0001\u001a\u00020\u00032\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H&J\t\u0010©\u0001\u001a\u00020\u0005H&J\u0012\u0010ª\u0001\u001a\u00020\u00032\u0007\u0010«\u0001\u001a\u00020\u000fH&J\u0012\u0010¬\u0001\u001a\u00020\u00032\u0007\u0010\u00ad\u0001\u001a\u00020\u0005H&J\u0012\u0010®\u0001\u001a\u00020\u00032\u0007\u0010\u00ad\u0001\u001a\u00020\u0005H&J\u0013\u0010¯\u0001\u001a\u00020\u00032\b\u0010°\u0001\u001a\u00030±\u0001H&J\u0014\u0010²\u0001\u001a\u00020\u00052\t\u0010³\u0001\u001a\u0004\u0018\u00010\u0005H&¨\u0006µ\u0001"}, d2 = {"Lcom/larus/audio/IAudioService;", "", "initAll", "", "samiUrl", "", "removeQueryKeyList", "", "initSami", "initRTC", "init", com.heytap.mcssdk.constant.b.f276376z, "appToken", "hasInit", "Landroidx/lifecycle/LiveData;", "", "updateInitState", "loadAudioUserSetting", "addAudioPlayStateChangeCallback", "callback", "Lcom/larus/audio/audiov3/tts/AudioPlayStateChangeCallback;", "removeAudioPlayStateCallback", "preLoadAudio", "audioList", "Ljava/util/ArrayList;", "Lcom/larus/audio/bean/DownloadBean;", "Lkotlin/collections/ArrayList;", "getAudioConfigLiveData", "Lcom/larus/audio/bean/AudioUserConfig;", "updateAudioConfigFromLaunch", "config", "updateRtcLaunchInfoFromLaunch", "useTestDomain", "streamAppDetails", "", "(Ljava/lang/Boolean;Ljava/util/Map;)V", "requestAudioConfig", "requestPGCVoiceList", "caller", "isAutoPlayHardDowngrade", "isAutoPlaySoftDowngrade", "isManualPlayHardDowngrade", "collectAudioDowngradeStateChanged", "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDowngradeAudioIconId", "", "downgradeIconIdAction", "normalIconIdAction", "setSoftDowngradeUserUpdated", "isUserUpdated", "getTargetLoudness", "", "getLoudNormAlgoType", "disconnectSamiConnection", "isNotRecording", "findRealtimeCallBotTagInfo", "Lcom/larus/im/bean/bot/ShowTagInfo;", "botId", "botType", "tagInfoList", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/larus/im/bean/bot/ShowTagInfo;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "getTranslucentPages", "isInRealtimeCall", "getDebugStopIndex", "saveStreamPcm", "data", "", "isDora", ST.UUID_DEVICE, "deleteScreamOs", "isTopRealtimeCallActivity", "connectionOperator", "Lcom/larus/audio/IRealtimeConnectionOperator;", "getMySoundsMobHelper", "Lcom/larus/audio/ISoundsMob;", "deleteSharkMessageTtsCache", "cacheKey", "enableTtsCache", "messageId", "voiceStyleId", "extra", "selectedText", "isDoraWakeUp", "isDoraConnected", "getDoraAppeaseMinPlayingTime", "", "realtimeCallBotEnabled", "showRealTimeCallNotice", "getRunningAsrTaskIds", "isSamiFrontierInit", "setUserRealtimeCalled", "called", "hasUserRealtimeCalled", "hasEnableUserCalledLibra", "isAiNoteRecording", "isWaitingStart", "setWaitingStart", "value", "stopAiNoteRecording", "getSamiUrl", "hostAppKey", "getDoubaoQuicUrl", "getSamiConnectedPool", "getRtcAppIdByStreamApp", "streamApp", "getDoubaoRtcAppId", "useRTCTestDomain", "soundMobHelperOnExitPage", "source", "Lcom/larus/audio/SoundsSource;", "ensureRTCInitialized", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasUserCalled", "defaultValue", "canShowCallRedDot", "registerRecordStatusFlowObserve", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/audio/bean/RECORD_STATUS;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConnectedPool", "saveAsrMainBotLanguage", "language", "getAudioConfig", "Lcom/larus/audio/IAudioConfig;", "getDoraManager", "Lcom/larus/audio/IDoraManager;", "getAudioTraceManager", "Lcom/larus/audio/IAudioTraceManager;", "getAudioTraceBusinessManager", "Lcom/larus/audio/IAudioTraceBusinessManager;", "getAudioPlayerManager", "Lcom/larus/audio/IAudioPlayerManager;", "getTtsQualityTrace", "Lcom/larus/audio/ITtsQualityTrace;", "getAsrCoroutine", "Lcom/larus/audio/IAsrCoroutine;", "getAudioDowngradeManager", "Lcom/larus/audio/IAudioDowngradeManager;", "getAiNoteManager", "Lcom/larus/audio/IAiNote;", "getLoudnessHelper", "Lcom/larus/audio/ILoudnessHelper;", "getAudioLoadManager", "Lcom/larus/audio/IAudioLoadManager;", "getTtsClientManager", "Lcom/larus/audio/ITtsClientManager;", "getAsrGlobal", "Lcom/larus/audio/IAsrGlobal;", "getAsrClientManager", "Lcom/larus/audio/IAsrClientManager;", "getTtsInterrupter", "Lcom/larus/audio/ITtsInterrupter;", "getSamiReportInitiator", "Lcom/larus/audio/ISamiReportInitiator;", "getConnectPoolManager", "Lcom/larus/audio/IAudioConnectionPoolManager;", "getVoiceQualityChecker", "Lcom/larus/audio/IVoiceQualityChecker;", "setAudioDebugService", "debugService", "Lcom/larus/audio/audiov3/IAudioDebugService;", "setAudioAutoTestService", "autoTestService", "Lcom/larus/audio/audiov3/AudioSdkAutotestDepend;", "getQuicWSSHost", "shouldCloseAudioOnBackground", "shouldDisconnect", "disconnectAudioConnection", "reason", "reconnectAudioConnection", "addStatusInterceptor", "interceptor", "Lcom/larus/audio/IAudioService$StatusInterceptor;", "getAppKeyByBizKey", "bizKey", "StatusInterceptor", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAudioService {

    public interface a {
        boolean a(String r100);

        void name();
    }

    int A();

    ShowTagInfo B(String r100, Integer r101, List<ShowTagInfo> r102);

    boolean C();

    boolean D();

    void E(Boolean r100, Map<String, String> r101);

    x0 F();

    void G(m58.q r100);

    void H(com.obric.assistant.audio.m r100);

    List<String> I();

    void J(String r100);

    Object K(String r100, Continuation<? super Unit> r101);

    e1 L();

    String M(String r100);

    v0 N();

    a1 O();

    j0 P();

    Object Q(CustomActionBarNormalHolder$handleLottieJob$1$1.a r100, Continuation r101);

    void R(String r100, List<String> r101);

    void S(com.larus.init.task.firstframe.q r100);

    l0 T();

    boolean U();

    r0 V();

    void W();

    g1 X();

    void Y(AudioUserConfig r100);

    String Z(String r100);

    List<String> a();

    y0 a0();

    float b();

    void b0();

    int c();

    void c0(byte[] r100, String r101);

    String d(String r100);

    void d0(String r100);

    boolean e();

    boolean e0();

    ShowTagInfo f(BotModel r100, List<ShowTagInfo> r101);

    void f0(SoundsSource r100);

    boolean g();

    void g0(String r100);

    p0 getAudioConfig();

    boolean h(String r100, String r101, String r102, String r103);

    o0 h0();

    LiveData<Boolean> hasInit();

    boolean i();

    d1 i0();

    void init(String r100, String r101);

    boolean isDoraConnected();

    void j(ArrayList<p68.b> r100);

    void j0();

    void k(n68.a r100);

    boolean k0();

    boolean l();

    u0 l0();

    boolean m();

    String m0();

    boolean n(BotModel r100);

    z0 n0();

    String o(String r100);

    s0 o0();

    LiveData<AudioUserConfig> p();

    void p0(boolean r100);

    Object q(com.larus.bmhome.chat.component.title.o1 r100, Continuation r101);

    boolean q0();

    String r();

    t0 r0();

    f1 s();

    void s0(com.larus.bot.impl.feature.edit.feature.firstmet.g r100);

    void t(boolean r100);

    void t0();

    boolean u();

    String u0();

    void v(String r100);

    void v0();

    void w();

    long w0();

    k0 x();

    String x0(String r100);

    void y(String r100);

    boolean y0();

    q0 z();
}
