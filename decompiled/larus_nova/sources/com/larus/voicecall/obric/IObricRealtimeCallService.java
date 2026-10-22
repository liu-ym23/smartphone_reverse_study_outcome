package com.larus.voicecall.obric;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b78.h;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.audio.call.arch.c;
import com.larus.audio.call.plugins.c1;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.trace.tracespan.span.b;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001TJ\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J^\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00032\"\b\u0002\u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u001bH&J\u0016\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H¦@¢\u0006\u0002\u0010!J\u0086\u0001\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0*2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0*2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0*2\u0006\u00100\u001a\u00020\u0005H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u000203H&J\u0010\u00104\u001a\u0002052\u0006\u0010\u001f\u001a\u00020\u001cH&J\b\u00106\u001a\u00020\u0003H&J\b\u00107\u001a\u00020\u0003H&J\b\u00108\u001a\u000209H&J\b\u0010:\u001a\u00020\u0003H&J\u0012\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010=H&J\b\u0010>\u001a\u00020\u0005H&J\b\u0010?\u001a\u00020@H&J\b\u0010A\u001a\u00020\u0005H&J\u0010\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020DH&J\u0010\u0010E\u001a\u00020\t2\u0006\u0010C\u001a\u00020DH&J\b\u0010F\u001a\u00020\rH&J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020IH&J\b\u0010J\u001a\u00020\u0003H&J\b\u0010K\u001a\u00020\rH&J\u001c\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0M2\u0006\u0010N\u001a\u00020OH&J\u0012\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010Q\u001a\u00020RH&J\u0010\u0010S\u001a\u00020\t2\u0006\u0010Q\u001a\u00020RH&¨\u0006U"}, d2 = {"Lcom/larus/voicecall/obric/IObricRealtimeCallService;", "", "isRealtimeCallDowngradeByCall", "", "botType", "", "(Ljava/lang/Integer;)Z", "isRtcEnabled", "setIsInCall", "", "isInCall", "bindForegroundService", "reason", "", "unBindAndDismissForegroundService", "generateRealtimeCallService", "Lcom/larus/audio/call/AbsRealtimeCallService;", "sessionCreator", "Lcom/larus/audio/call/utils/IAudioSessionCreator;", "spanWrap", "Lcom/larus/trace/tracespan/span/ITraceSpanWrap;", "spanScene", "lifecycleScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "skipDowngradePluginForClickTalk", "collectBizPlugin", "Lkotlin/Function2;", "Lcom/larus/audio/call/arch/ICommonPluginContext;", "Lcom/larus/audio/call/arch/ILLMPluginRegistry;", "initRealtimeCallParams", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRealtimeDestroy", "botId", "localConversationId", "conversationId", "localCallId", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "imAsrMsgNum", "Ljava/util/concurrent/CopyOnWriteArraySet;", "imTtsMsgNum", "imTtsPreQueryMsgMap", "Ljava/util/concurrent/ConcurrentHashMap;", "vuiAsrMsgIdSet", "vuiChatRespMsgIdSet", "vuiTtsRespMsgNum", "isQuery", "msg", "Lcom/larus/im/bean/message/Message;", "getPlugin", "Lcom/larus/audio/call/plugins/IUIStatePluginProvider;", "isCurrentSessionUsingOneshot", "isAutoInterrupt", "buildConnectionConfig", "Lcom/larus/im/service/IMediaService$PreConnectConfig;", "enableSubtitleAsrSeg", "getRealtimeStyleId", MmEndWindowAvatar.TYPE_SPEAKER, "Lcom/larus/im/bean/bot/SpeakerVoice;", "callSampleRate", "getTargetLoudness", "", "getLoudNormAlgoType", "addRealtimeCallActivityStateCallback", "callback", "Lcom/larus/voicecall/obric/IObricRealtimeCallService$IObricRealtimeCallActivityStateListener;", "removeRealtimeCallActivityStateCallback", "getRealtimeCallActivityName", "isRealtimeCallActivity", TTVideoEngineInterface.PLAY_API_KEY_AC, "Landroid/app/Activity;", "isScreenShareEnable", "getFlagArgumentLandingFeatureScene", "getConversationIdAndBotId", "Lkotlin/Pair;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getRealtimeCallFragment", "activity", "Landroidx/fragment/app/FragmentActivity;", "preCloseCamera", "IObricRealtimeCallActivityStateListener", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricRealtimeCallService {

    public interface a {
        void onEnterRealtimeCall(String r100, String r101);

        void onExitRealtimeCall(String r100, String r101);
    }

    boolean a();

    float b();

    int c();

    boolean d(Integer r100);

    int e();

    com.larus.audio.call.a f(h r100, b r101, Function0 r102, boolean r103, Function2 r104);

    boolean g();

    String h(SpeakerVoice r100);

    boolean i(Message r100);

    Pair<String, String> j(Fragment r100);

    void k(FragmentActivity r100);

    void l(a r100);

    void m();

    boolean n();

    c1 o(c r100);

    Fragment p(FragmentActivity r100);

    String q();

    Object r(Context r100, Continuation<? super Unit> r101);

    boolean s(Activity r100);

    void t(String r100, String r101, String r102, String r103, CopyOnWriteArraySet r104, CopyOnWriteArraySet r105, ConcurrentHashMap r106, CopyOnWriteArraySet r107, CopyOnWriteArraySet r108);

    String u();
}
