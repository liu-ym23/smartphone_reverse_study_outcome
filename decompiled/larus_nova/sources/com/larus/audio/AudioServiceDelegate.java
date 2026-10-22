package com.larus.audio;

import androidx.lifecycle.LiveData;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarNormalHolder$handleLottieJob$1$1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShowTagInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016J \u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001b\u001a\u00020\b2\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0013H\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020!H\u0016J-\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u00142\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020\u0014H\u0016J\b\u0010.\u001a\u00020\u0014H\u0016J\u001c\u0010/\u001a\u00020\b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\b01H\u0096@¢\u0006\u0002\u00102J$\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u000204012\f\u00106\u001a\b\u0012\u0004\u0012\u00020401H\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0014H\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000204H\u0016J\b\u0010<\u001a\u00020\bH\u0016J\b\u0010=\u001a\u00020\u0014H\u0016J3\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010A\u001a\u0004\u0018\u0001042\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\fH\u0016¢\u0006\u0002\u0010CJ$\u0010>\u001a\u0004\u0018\u00010?2\b\u0010D\u001a\u0004\u0018\u00010E2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\fH\u0016J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016J\b\u0010G\u001a\u00020\u0014H\u0016J\b\u0010H\u001a\u000204H\u0016J \u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\nH\u0016J\b\u0010N\u001a\u00020\bH\u0016J\b\u0010O\u001a\u00020\u0014H\u0016J\b\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\nH\u0016J0\u0010V\u001a\u00020\u00142\b\u0010W\u001a\u0004\u0018\u00010\n2\b\u0010X\u001a\u0004\u0018\u00010\n2\b\u0010Y\u001a\u0004\u0018\u00010\n2\b\u0010Z\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010[\u001a\u00020\u0014H\u0016J\b\u0010\\\u001a\u00020\u0014H\u0016J\b\u0010]\u001a\u00020^H\u0016J\u0012\u0010_\u001a\u00020\u00142\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010`\u001a\u00020\u0014H\u0016J\u000e\u0010a\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016J\b\u0010b\u001a\u00020\u0014H\u0016J\u0010\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020\u0014H\u0016J\b\u0010e\u001a\u00020\u0014H\u0016J\b\u0010f\u001a\u00020\u0014H\u0016J\b\u0010g\u001a\u00020\u0014H\u0016J\b\u0010h\u001a\u00020\u0014H\u0016J\u0010\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\u0014H\u0016J\b\u0010k\u001a\u00020\bH\u0016J\u0010\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0016J\u0012\u0010o\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0012\u0010p\u001a\u0004\u0018\u00010\n2\u0006\u0010q\u001a\u00020\nH\u0016J\n\u0010r\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010s\u001a\u00020\u0014H\u0016J\u0010\u0010t\u001a\u00020\b2\u0006\u0010u\u001a\u00020vH\u0016J\u0016\u0010w\u001a\u00020\b2\u0006\u0010+\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010xJ\u0010\u0010y\u001a\u00020\u00142\u0006\u0010z\u001a\u00020\u0014H\u0016J\b\u0010{\u001a\u00020\u0014H\u0016J\u001d\u0010|\u001a\u00020\b2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u007f0~H\u0096@¢\u0006\u0003\u0010\u0080\u0001J\u0013\u0010\u0081\u0001\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\b2\u0007\u0010\u0083\u0001\u001a\u00020\nH\u0016J\n\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\n\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0016J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\n\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0016J\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\n\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0016J\n\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\n\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\n\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016J\n\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\n\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\n\u0010¢\u0001\u001a\u00030£\u0001H\u0016J\n\u0010¤\u0001\u001a\u00030¥\u0001H\u0016J\n\u0010¦\u0001\u001a\u00030§\u0001H\u0016J\u0015\u0010¨\u0001\u001a\u00020\b2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0016J\u0015\u0010«\u0001\u001a\u00020\b2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0016J\t\u0010®\u0001\u001a\u00020\nH\u0016J\u0012\u0010¯\u0001\u001a\u00020\b2\u0007\u0010°\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010±\u0001\u001a\u00020\b2\u0007\u0010²\u0001\u001a\u00020\nH\u0016J\u0012\u0010³\u0001\u001a\u00020\b2\u0007\u0010²\u0001\u001a\u00020\nH\u0016J\u0013\u0010´\u0001\u001a\u00020\b2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0016J\u0014\u0010·\u0001\u001a\u00020\n2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006¹\u0001"}, d2 = {"Lcom/larus/audio/AudioServiceDelegate;", "Lcom/larus/audio/IAudioService;", "<init>", "()V", "_delegate", "get_delegate", "()Lcom/larus/audio/IAudioService;", "initAll", "", "samiUrl", "", "removeQueryKeyList", "", "initSami", "initRTC", "init", com.heytap.mcssdk.constant.b.f276376z, "appToken", "hasInit", "Landroidx/lifecycle/LiveData;", "", "updateInitState", "loadAudioUserSetting", "addAudioPlayStateChangeCallback", "callback", "Lcom/larus/audio/audiov3/tts/AudioPlayStateChangeCallback;", "removeAudioPlayStateCallback", "preLoadAudio", "audioList", "Ljava/util/ArrayList;", "Lcom/larus/audio/bean/DownloadBean;", "Lkotlin/collections/ArrayList;", "getAudioConfigLiveData", "Lcom/larus/audio/bean/AudioUserConfig;", "updateAudioConfigFromLaunch", "config", "updateRtcLaunchInfoFromLaunch", "useTestDomain", "streamAppDetails", "", "(Ljava/lang/Boolean;Ljava/util/Map;)V", "requestAudioConfig", "requestPGCVoiceList", "caller", "isAutoPlayHardDowngrade", "isAutoPlaySoftDowngrade", "isManualPlayHardDowngrade", "collectAudioDowngradeStateChanged", "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDowngradeAudioIconId", "", "downgradeIconIdAction", "normalIconIdAction", "setSoftDowngradeUserUpdated", "isUserUpdated", "getTargetLoudness", "", "getLoudNormAlgoType", "disconnectSamiConnection", "isNotRecording", "findRealtimeCallBotTagInfo", "Lcom/larus/im/bean/bot/ShowTagInfo;", "botId", "botType", "tagInfoList", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/larus/im/bean/bot/ShowTagInfo;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "getTranslucentPages", "isInRealtimeCall", "getDebugStopIndex", "saveStreamPcm", "data", "", "isDora", ST.UUID_DEVICE, "deleteScreamOs", "isTopRealtimeCallActivity", "connectionOperator", "Lcom/larus/audio/IRealtimeConnectionOperator;", "getMySoundsMobHelper", "Lcom/larus/audio/ISoundsMob;", "deleteSharkMessageTtsCache", "cacheKey", "enableTtsCache", "messageId", "voiceStyleId", "extra", "selectedText", "isDoraWakeUp", "isDoraConnected", "getDoraAppeaseMinPlayingTime", "", "realtimeCallBotEnabled", "showRealTimeCallNotice", "getRunningAsrTaskIds", "isSamiFrontierInit", "setUserRealtimeCalled", "called", "hasUserRealtimeCalled", "hasEnableUserCalledLibra", "isAiNoteRecording", "isWaitingStart", "setWaitingStart", "value", "stopAiNoteRecording", "getSamiUrl", "hostAppKey", "getDoubaoQuicUrl", "getSamiConnectedPool", "getRtcAppIdByStreamApp", "streamApp", "getDoubaoRtcAppId", "useRTCTestDomain", "soundMobHelperOnExitPage", "source", "Lcom/larus/audio/SoundsSource;", "ensureRTCInitialized", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasUserCalled", "defaultValue", "canShowCallRedDot", "registerRecordStatusFlowObserve", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/audio/bean/RECORD_STATUS;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConnectedPool", "saveAsrMainBotLanguage", "language", "getAudioConfig", "Lcom/larus/audio/IAudioConfig;", "getDoraManager", "Lcom/larus/audio/IDoraManager;", "getAudioTraceManager", "Lcom/larus/audio/IAudioTraceManager;", "getAudioTraceBusinessManager", "Lcom/larus/audio/IAudioTraceBusinessManager;", "getAudioPlayerManager", "Lcom/larus/audio/IAudioPlayerManager;", "getTtsQualityTrace", "Lcom/larus/audio/ITtsQualityTrace;", "getAsrCoroutine", "Lcom/larus/audio/IAsrCoroutine;", "getAudioDowngradeManager", "Lcom/larus/audio/IAudioDowngradeManager;", "getAiNoteManager", "Lcom/larus/audio/IAiNote;", "getLoudnessHelper", "Lcom/larus/audio/ILoudnessHelper;", "getAudioLoadManager", "Lcom/larus/audio/IAudioLoadManager;", "getTtsClientManager", "Lcom/larus/audio/ITtsClientManager;", "getAsrGlobal", "Lcom/larus/audio/IAsrGlobal;", "getAsrClientManager", "Lcom/larus/audio/IAsrClientManager;", "getTtsInterrupter", "Lcom/larus/audio/ITtsInterrupter;", "getSamiReportInitiator", "Lcom/larus/audio/ISamiReportInitiator;", "getConnectPoolManager", "Lcom/larus/audio/IAudioConnectionPoolManager;", "getVoiceQualityChecker", "Lcom/larus/audio/IVoiceQualityChecker;", "setAudioDebugService", "debugService", "Lcom/larus/audio/audiov3/IAudioDebugService;", "setAudioAutoTestService", "autoTestService", "Lcom/larus/audio/audiov3/AudioSdkAutotestDepend;", "getQuicWSSHost", "shouldCloseAudioOnBackground", "shouldDisconnect", "disconnectAudioConnection", "reason", "reconnectAudioConnection", "addStatusInterceptor", "interceptor", "Lcom/larus/audio/IAudioService$StatusInterceptor;", "getAppKeyByBizKey", "bizKey", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioServiceDelegate implements IAudioService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AudioServiceDelegate f288288a = null;

    static {
        f288288a = new AudioServiceDelegate();
    }

    private AudioServiceDelegate() {
    }

    public static IAudioService z0() {
        IAudioService r100 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new AudioServiceNoop();
    }

    @Override // com.larus.audio.IAudioService
    public final int A() {
        return z0().A();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean C() {
        return z0().C();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean D() {
        return z0().D();
    }

    @Override // com.larus.audio.IAudioService
    public final x0 F() {
        return z0().F();
    }

    @Override // com.larus.audio.IAudioService
    public final List<String> I() {
        return z0().I();
    }

    @Override // com.larus.audio.IAudioService
    public final e1 L() {
        return z0().L();
    }

    @Override // com.larus.audio.IAudioService
    public final v0 N() {
        return z0().N();
    }

    @Override // com.larus.audio.IAudioService
    public final a1 O() {
        return z0().O();
    }

    @Override // com.larus.audio.IAudioService
    public final j0 P() {
        return z0().P();
    }

    @Override // com.larus.audio.IAudioService
    public final l0 T() {
        return z0().T();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean U() {
        return z0().U();
    }

    @Override // com.larus.audio.IAudioService
    public final r0 V() {
        return z0().V();
    }

    @Override // com.larus.audio.IAudioService
    public final void W() {
        z0().W();
    }

    @Override // com.larus.audio.IAudioService
    public final g1 X() {
        return z0().X();
    }

    @Override // com.larus.audio.IAudioService
    public final List<String> a() {
        return z0().a();
    }

    @Override // com.larus.audio.IAudioService
    public final y0 a0() {
        return z0().a0();
    }

    @Override // com.larus.audio.IAudioService
    public final float b() {
        return z0().b();
    }

    @Override // com.larus.audio.IAudioService
    public final void b0() {
        z0().b0();
    }

    @Override // com.larus.audio.IAudioService
    public final int c() {
        return z0().c();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean e() {
        return z0().e();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean e0() {
        return z0().e0();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean g() {
        return z0().g();
    }

    @Override // com.larus.audio.IAudioService
    public final p0 getAudioConfig() {
        return z0().getAudioConfig();
    }

    @Override // com.larus.audio.IAudioService
    public final o0 h0() {
        return z0().h0();
    }

    @Override // com.larus.audio.IAudioService
    public final LiveData<Boolean> hasInit() {
        return z0().hasInit();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean i() {
        return z0().i();
    }

    @Override // com.larus.audio.IAudioService
    public final d1 i0() {
        return z0().i0();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean isDoraConnected() {
        return z0().isDoraConnected();
    }

    @Override // com.larus.audio.IAudioService
    public final void j0() {
        z0().j0();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean k0() {
        return z0().k0();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean l() {
        return z0().l();
    }

    @Override // com.larus.audio.IAudioService
    public final u0 l0() {
        return z0().l0();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean m() {
        return z0().m();
    }

    @Override // com.larus.audio.IAudioService
    public final String m0() {
        return z0().m0();
    }

    @Override // com.larus.audio.IAudioService
    public final z0 n0() {
        return z0().n0();
    }

    @Override // com.larus.audio.IAudioService
    public final s0 o0() {
        return z0().o0();
    }

    @Override // com.larus.audio.IAudioService
    public final LiveData<AudioUserConfig> p() {
        return z0().p();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean q0() {
        return z0().q0();
    }

    @Override // com.larus.audio.IAudioService
    public final String r() {
        return z0().r();
    }

    @Override // com.larus.audio.IAudioService
    public final t0 r0() {
        return z0().r0();
    }

    @Override // com.larus.audio.IAudioService
    public final f1 s() {
        return z0().s();
    }

    @Override // com.larus.audio.IAudioService
    public final void t0() {
        z0().t0();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean u() {
        return z0().u();
    }

    @Override // com.larus.audio.IAudioService
    public final String u0() {
        return z0().u0();
    }

    @Override // com.larus.audio.IAudioService
    public final void v0() {
        z0().v0();
    }

    @Override // com.larus.audio.IAudioService
    public final void w() {
        z0().w();
    }

    @Override // com.larus.audio.IAudioService
    public final long w0() {
        return z0().w0();
    }

    @Override // com.larus.audio.IAudioService
    public final k0 x() {
        return z0().x();
    }

    @Override // com.larus.audio.IAudioService
    public final boolean y0() {
        return z0().y0();
    }

    @Override // com.larus.audio.IAudioService
    public final q0 z() {
        return z0().z();
    }

    @Override // com.larus.audio.IAudioService
    public final void G(m58.q r100) {
        z0().G(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void H(com.obric.assistant.audio.m r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        z0().H(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void J(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        z0().J(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final String M(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostAppKey");
        return z0().M(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void S(com.larus.init.task.firstframe.q r100) {
        z0().S(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void Y(AudioUserConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        z0().Y(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final String Z(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        return z0().Z(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostAppKey");
        return z0().d(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void d0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        z0().d0(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void f0(SoundsSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        z0().f0(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void g0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "language");
        z0().g0(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void j(ArrayList<p68.b> r100) {
        z0().j(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void k(n68.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        z0().k(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final boolean n(BotModel r100) {
        return z0().n(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final String o(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        return z0().o(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void p0(boolean r100) {
        z0().p0(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void s0(com.larus.bot.impl.feature.edit.feature.firstmet.g r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        z0().s0(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void t(boolean r100) {
        z0().t(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void v(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        z0().v(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final String x0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "streamApp");
        return z0().x0(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void y(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        z0().y(r100);
    }

    @Override // com.larus.audio.IAudioService
    public final void E(Boolean r100, Map<String, String> r101) {
        z0().E(r100, r101);
    }

    @Override // com.larus.audio.IAudioService
    public final Object K(String r100, Continuation<? super Unit> r101) {
        Object r102 = z0().K(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.audio.IAudioService
    public final Object Q(CustomActionBarNormalHolder$handleLottieJob$1$1.a r100, Continuation r101) {
        Object r102 = z0().Q(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.audio.IAudioService
    public final void R(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "samiUrl");
        z0().R(r100, r101);
    }

    @Override // com.larus.audio.IAudioService
    public final void c0(byte[] r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
        z0().c0(r100, r101);
    }

    @Override // com.larus.audio.IAudioService
    public final ShowTagInfo f(BotModel r100, List<ShowTagInfo> r101) {
        return z0().f(r100, r101);
    }

    @Override // com.larus.audio.IAudioService
    public final void init(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r101, "appToken");
        z0().init(r100, r101);
    }

    @Override // com.larus.audio.IAudioService
    public final Object q(com.larus.bmhome.chat.component.title.o1 r100, Continuation r101) {
        Object r102 = z0().q(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.audio.IAudioService
    public final ShowTagInfo B(String r100, Integer r101, List<ShowTagInfo> r102) {
        return z0().B(r100, r101, r102);
    }

    @Override // com.larus.audio.IAudioService
    public final boolean h(String r100, String r101, String r102, String r103) {
        return z0().h(r100, r101, r102, r103);
    }
}
