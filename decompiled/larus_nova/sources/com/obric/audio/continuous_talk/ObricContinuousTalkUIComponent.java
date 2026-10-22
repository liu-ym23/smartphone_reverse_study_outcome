package com.obric.audio.continuous_talk;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.AVKitCoreStates$Finished;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantAudioVisualizerState;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.audio.continuous_talk.session.impl.ObricContTalkMgrImpl;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ¢\u00012\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0002¢\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u000109H\u0016J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020@H\u0016J\u0010\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020@H\u0016J\b\u0010I\u001a\u00020@H\u0016J\u00ad\u0001\u0010O\u001a\u0004\u0018\u0001092\u0006\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u0002092\b\u0010R\u001a\u0004\u0018\u00010\b2\b\u0010S\u001a\u0004\u0018\u00010\b2\b\u0010T\u001a\u0004\u0018\u00010\b2\u0006\u0010U\u001a\u0002092\u0006\u00108\u001a\u0002092\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u0001092\b\u0010]\u001a\u0004\u0018\u0001092\b\u0010^\u001a\u0004\u0018\u0001092\u0006\u0010_\u001a\u0002012\u0006\u0010`\u001a\u00020a2\u0014\u0010b\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020@\u0018\u00010cH\u0016¢\u0006\u0002\u0010dJ \u0010e\u001a\u00020@2\u0006\u0010f\u001a\u00020\u000e2\u0006\u0010g\u001a\u0002092\u0006\u0010h\u001a\u000209H\u0002J\u001a\u0010i\u001a\u00020@2\b\u0010j\u001a\u0004\u0018\u00010<2\u0006\u0010k\u001a\u00020\bH\u0002J\u0010\u0010l\u001a\u00020@2\u0006\u0010m\u001a\u000201H\u0016J8\u0010n\u001a\u00020@2\b\u0010j\u001a\u0004\u0018\u00010<2\u0006\u0010o\u001a\u0002092\u0006\u0010p\u001a\u0002092\u0014\b\u0002\u0010q\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u0002090rH\u0002J\"\u0010s\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002010t2\u0006\u0010u\u001a\u000209H\u0014J\u0018\u0010v\u001a\u00020@2\u0006\u0010w\u001a\u00020.2\u0006\u0010x\u001a\u000209H\u0002J\b\u0010y\u001a\u00020@H\u0002J\b\u0010z\u001a\u00020@H\u0002J\u001a\u0010z\u001a\u00020@2\b\u0010g\u001a\u0004\u0018\u0001092\u0006\u0010h\u001a\u000209H\u0002J\u001a\u0010{\u001a\u00020@2\b\u0010g\u001a\u0004\u0018\u0001092\u0006\u0010h\u001a\u000209H\u0002J\u0010\u0010|\u001a\u00020@2\u0006\u0010w\u001a\u00020.H\u0002J\u0010\u0010}\u001a\u00020@2\u0006\u0010~\u001a\u000201H\u0016J\b\u0010\u007f\u001a\u000201H\u0016J\t\u0010\u0080\u0001\u001a\u00020@H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020@2\u0007\u0010\u0082\u0001\u001a\u000209H\u0002J\t\u0010\u0083\u0001\u001a\u00020@H\u0002J \u0010\u0084\u0001\u001a\u00020@2\u0015\u0010\u0085\u0001\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u000209\u0018\u00010rH\u0016J\u0014\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0006\u0010w\u001a\u00020.H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020@2\u0007\u0010\u0089\u0001\u001a\u000201H\u0002J\u0013\u0010\u008e\u0001\u001a\u00020@2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0002J\u0013\u0010\u0091\u0001\u001a\u00020@2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002J\t\u0010\u0094\u0001\u001a\u000201H\u0002J\t\u0010\u0095\u0001\u001a\u00020@H\u0002J\u0016\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002J\t\u0010\u0096\u0001\u001a\u00020@H\u0002J\u0012\u0010\u0097\u0001\u001a\u00020@2\u0007\u0010\u0098\u0001\u001a\u000201H\u0002J\t\u0010\u0099\u0001\u001a\u000201H\u0016J\t\u0010\u009a\u0001\u001a\u00020>H\u0016J\u0012\u0010\u009b\u0001\u001a\u00020@2\u0007\u0010\u009c\u0001\u001a\u000201H\u0016J\u0013\u0010\u009d\u0001\u001a\u0002012\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0014\u0010 \u0001\u001a\u00020@2\t\u0010¡\u0001\u001a\u0004\u0018\u000109H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0018\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008b\u0001\u001a\u0002012\u0007\u0010\u008a\u0001\u001a\u000201@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006£\u0001"}, d2 = {"Lcom/obric/audio/continuous_talk/ObricContinuousTalkUIComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "flowAsrSession", "Lcom/obric/audio/continuous_talk/session/api/IObricContTalkMgr;", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "llmContextProvider", "Lcom/obric/audio/continuous_talk/ObricContinuousLLMContextProvider;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "latestPhotoShortcutAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ILatestPhotoShortcutAbility;", "getLatestPhotoShortcutAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ILatestPhotoShortcutAbility;", "latestPhotoShortcutAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "talkState", "Lcom/larus/audio/call/mgr/AVKitDuplexState;", "rejectCnt", "pendingFirstRejectTimeout", "", "pendingCloseAfterRejectAnimation", "stateCollectJob", "Lkotlinx/coroutines/Job;", "recordDataCollectJob", "talkEventCollectJob", "ttsObserveJob", "botId", "", "nextStartupAttemptId", "currentStartupSession", "Lcom/obric/assistant/spi/startup/AssistantStartupAudioSession;", "businessStatus", "Lcom/obric/audio/continuous_talk/ContinuousTalkStatus;", "bindStartupAttempt", "", "attemptId", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onAttach", "onViewCreated", "view", "Landroid/view/View;", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, "runningSpeakTaskId", "clickTalkSessionId", "clickTalkConversationId", "clickTalkSourceType", "isClickTalkListening", "invokeOnSpeak", FailedBinderCallBack.CALLER_ID, DBDefinition.TASK_ID, "vuiId", InteractConst.WAKEUP_WAKEUP_ID, "sourceType", "convId", "voiceType", "Lcom/larus/im/bean/bot/SpeakerVoice;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "traceNode", "Lcom/ixigua/lib/track/ITrackNode;", "enterMethod", "botModelName", "personalCtx", "personalCtxIsFinish", "oneshotParams", "Lcom/larus/audio/call/RealtimeCallParam$OneshotParams;", "onFinishCall", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/SpeakerVoice;Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;Lcom/ixigua/lib/track/ITrackNode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/larus/audio/call/RealtimeCallParam$OneshotParams;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "cleanupFailedSessionStart", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "conversationId", "speakTaskId", "markStartupRecordReady", "startupSession", "readSize", "stop", "immediately", "finishStartupSession", "result", "reason", "attributes", "", "createAsrSession", "Lkotlin/Triple;", "asrTaskId", "updateTalkStateUI", "state", "expectedSessionId", "dispatchClickTalkQueryBegin", "dispatchClickTalkQueryEnd", "dispatchClickTalkEnd", "checkQueryEndEvent", "setTtsMute", ITTVideoEngineEventSource.KEY_MUTE, "isAudioPlaying", "observeTtsSwitchState", "syncTtsMuteWithTitleBar", "scene", "stopObserveTtsSwitchState", "updateIntentExt", "ext", "convertToRealtimeCallLifeState", "Lcom/obric/assistant/audio/service/ObricAssistantAudioVisualizerState;", "notifyContinuousTtsPlayState", "isPlaying", "value", "isRecognizing", "setRecognizing", "(Z)V", "processRecordedAudio", "audioData", "Lcom/larus/audio/audiov3/audio/record/RecordedAudioData;", "handleTalkEvent", "event", "Lcom/obric/audio/continuous_talk/session/api/ObricContTalkEvent;", "shouldStartFirstRejectTimeout", "startFirstRejectTimeout", "cancelFlowCollectJobs", "updateContinuesUIParam", BasicTestActionHandler.TEST_ACTION_RESET, "isSpeaking", "getTalkStatus", "onChatStyleChanged", "isChatWindow", "requestChat", "params", "Lorg/json/JSONObject;", "updateScreenshotForAsr", "tosKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricContinuousTalkUIComponent extends BaseContentWidget implements com.obric.audio.continuous_talk.b, hca.b {
    public static final /* synthetic */ int M = 0;
    public Job A;
    public Job B;
    public Job C;
    public volatile String D;
    public volatile uga.b E;
    public ContinuousTalkStatus F;
    public String G;
    public String H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f395119J;
    public boolean K;
    public boolean L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f395120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public hia.a f395121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f2a.d f395122o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final i f395123p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f395124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f395125r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f395126s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f395127t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f395128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AVKitDuplexState f395129v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f395130w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f395131x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f395132y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Job f395133z;

    public static final class a {
    }

    public static final class b implements Function0<laa.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f395134a;

        public b(AttachReceiver r100) {
            this.f395134a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.f, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.f invoke() {
            AttachReceiver r100 = this.f395134a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    public static final class c implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f395135a;

        public c(AttachReceiver r100) {
            this.f395135a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f395135a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class d implements Function0<com.obric.audio.continuous_talk.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f395136a;

        public d(AttachReceiver r100) {
            this.f395136a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.audio.continuous_talk.c, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.obric.audio.continuous_talk.c invoke() {
            AttachReceiver r100 = this.f395136a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.c.class));
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        stop(true);
        laa.d r100 = (laa.d) this.f395127t.getValue();
        if (r100 == null) goto L6;
        r100.AN(this);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
    }

    public final boolean E3() {
        if (this.f395131x == true) goto L5;
    L15:
        return false;
    L5:
        if (m0() == false) goto L15;
        if (this.L == true) goto L15;
        AVKitDuplexState r100 = this.f395129v;
        if (r100 == null) goto L11;
        AVKitDuplexState.UpState r101 = r100.getUpState();
    L13:
        if ((r101 instanceof AVKitCoreStates$Finished) == true) goto L15;
        return true;
    L11:
        r101 = null;
        goto L13
    }

    public final void Y2() {
        Job r100 = this.f395133z;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f395133z = null;
        Job r101 = this.A;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.A = null;
        Job r102 = this.B;
        if (r102 == null) goto L11;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L11:
        this.B = null;
    }

    @Override // com.obric.audio.continuous_talk.b
    public final boolean a0() {
        hia.a r100 = this.f395121n;
        if (r100 != null) goto L5;
        r100 = hia.c.f485388a.get();
    L5:
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.a0();
    }

    @Override // com.obric.audio.continuous_talk.b
    public final boolean m0() {
        ContinuousTalkStatus r100 = this.F;
        if (r100 != ContinuousTalkStatus.RUNNING) goto L5;
    L8:
        return true;
    L5:
        if (r100 == ContinuousTalkStatus.STOPPING) goto L8;
        return false;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "[onCreate]");
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStart() {
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "onStart " + hashCode());
    }

    public final com.obric.audio.continuous_talk.c p3() {
        return (com.obric.audio.continuous_talk.c) this.f395128u.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "[onAttach]");
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.obric.audio.continuous_talk.b.class);
    }

    public final laa.f z3() {
        return (laa.f) this.f395126s.getValue();
    }

    public ObricContinuousTalkUIComponent() {
        this.f395120m = R.id.speaker;
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "init ChatBottomSpeakerComponent");
        this.f395122o = new f2a.d("VoiceInput", "ObricContinuousTalkUIComponent");
        this.f395123p = new i();
        this.f395124q = LazyKt.lazy(new i0(this));
        this.f395125r = LazyKt.lazy(new j0(this));
        this.f395126s = LazyKt.lazy(new b(this));
        this.f395127t = LazyKt.lazy(new c(this));
        this.f395128u = LazyKt.lazy(new d(this));
        this.F = ContinuousTalkStatus.STOPPED;
        this.f395119J = -1;
    }

    public final void G3() {
        if (E3() == true) goto L5;
        return;
    L5:
        this.f395131x = false;
        ObricAssistantForAudioDelegate r100 = ObricAssistantForAudioDelegate.f385669b;
        laa.f r101 = z3();
        if (r101 == null) goto L8;
        iga.a r102 = r101.Zs();
    L9:
        r100.f5(r102, ObricAssistantAudioVisualizerState.TtsEnd, null);
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f395120m;
    }

    @Override // com.obric.audio.continuous_talk.b
    public final ContinuousTalkStatus u10() {
        return this.F;
    }

    public static void B3(boolean r100) {
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "notifyContinuousTtsPlayState: " + r100);
        if (r100 == false) goto L5;
        PlayStateEnum r101 = PlayStateEnum.PLAY_STATE_PLAYING;
    L6:
        if (r100 == false) goto L12;
        String r102 = zh8.a.f572196a.x1().c().o6();
        if (r102 == null) goto L12;
        IObricChatService.f386556a.getClass();
        IObricChatService r103 = IObricChatService.a.a();
        if (r103 == null) goto L12;
        r103.f(r102);
    L12:
        AudioServiceDelegate.f288288a.r0().n(r101);
        return;
    L5:
        r101 = PlayStateEnum.PLAY_STATE_STOPPED;
        goto L6
    }

    @Override // com.obric.audio.continuous_talk.b
    public final void B6(String r100) {
        this.D = r100;
    }

    public final void C3(boolean r100) {
        boolean r101 = this.L;
        this.L = r100;
        if (r101 == r100) goto L10;
        ObricAssistantForAudioDelegate r102 = ObricAssistantForAudioDelegate.f385669b;
        laa.f r103 = z3();
        if (r103 == null) goto L7;
        iga.a r104 = r103.Zs();
    L8:
        r102.Q4(r104, r100);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void D3(boolean r100) {
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "setTtsMute: " + r100);
        hia.a r101 = this.f395121n;
        if (r101 != null) goto L5;
        r101 = hia.c.f485388a.get();
    L5:
        if (r101 == null) goto L8;
        r101.j(r100);
        return;
    }

    public final void H3(String r100) {
        IObricChatService.f386556a.getClass();
        IObricChatService r101 = IObricChatService.a.a();
        if (r101 == null) goto L5;
        boolean r102 = r101.k();
    L6:
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "syncTtsMuteWithTitleBar: scene=" + r100 + ", isTtsOn=" + r102);
        D3(r102 ^ true);
        return;
    L5:
        r102 = true;
        goto L6
    }

    @Override // com.obric.audio.continuous_talk.b
    public final boolean I0(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "requestChat called, params=" + r100);
        hia.a r101 = this.f395121n;
        if (r101 == null) goto L5;
        hia.a.d r102 = r101.I0(r100);
    L7:
        return Intrinsics.areEqual(r102, hia.a.d.b.f485367a);
    L5:
        r102 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void Q3(boolean r100) {
        ObricAssistantForAudioDelegate r101 = ObricAssistantForAudioDelegate.f385669b;
        laa.f r102 = z3();
        l0 r103 = 0;
        if (r102 == null) goto L5;
        iga.a r104 = r102.Zs();
    L6:
        boolean r105 = !r100;
        if (r100 == true) goto L9;
        r103 = new l0(this);
    L9:
        r101.T4(r104, r105, r103);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f395120m = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.audio.continuous_talk.h0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ObricAssistantForAudioDelegate r101 = ObricAssistantForAudioDelegate.f385669b;
        laa.f r102 = z3();
        if (r102 == null) goto L5;
        iga.a r103 = r102.Zs();
    L6:
        r101.W4(r103, new h0(this));
        laa.d r104 = (laa.d) this.f395127t.getValue();
        if (r104 == null) goto L10;
        r104.HU(this);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // hca.b
    public final void r2(boolean r100) {
        laa.d r101 = (laa.d) this.f395127t.getValue();
        iga.a r102 = null;
        if (r101 == null) goto L5;
        ObricFloatChatPageState r103 = r101.getPageState();
    L6:
        if (r100 == false) goto L28;
        boolean r104 = false;
        if (r103 == null) goto L14;
        ObricFloatChatPageState r105 = r103.getPreviousState();
        if (r105 == null) goto L14;
        ObricFloatChatPageData.Companion.getClass();
        if ((r105 instanceof vda.b) != true) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L23;
        if (r103 == null) goto L22;
        ObricFloatChatPageState r107 = r103.getPreviousState();
        if (r107 == null) goto L22;
        ObricFloatChatPageData.Companion.getClass();
        Intrinsics.checkNotNullParameter(r107, "<this>");
        if ((r107 instanceof com.obric.assistant.data.a) != true) goto L22;
        r104 = true;
    L22:
        if (r104 == true) goto L23;
        return;
    L23:
        ObricAssistantForAudioDelegate r108 = ObricAssistantForAudioDelegate.f385669b;
        laa.f r109 = z3();
        if (r109 == null) goto L26;
        r102 = r109.Zs();
    L26:
        r108.S4(r102);
        return;
    L14:
        r106 = false;
        goto L15
    L28:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.obric.audio.continuous_talk.b
    public final void stop(boolean r100) {
        ContinuousTalkStatus r101 = this.F;
        ContinuousTalkStatus r102 = ContinuousTalkStatus.STOPPED;
        if (r101 != r102) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
    L9:
        if (r100 == true) goto L12;
        r102 = ContinuousTalkStatus.STOPPING;
    L12:
        this.F = r102;
        if (r101 != ContinuousTalkStatus.RUNNING) goto L18;
        uga.b r103 = this.E;
        if (r103 == null) goto L17;
        m3(r103, "cancelled", "continuous_talk_stopped_before_pcm", MapsKt.emptyMap());
    L17:
        Y2();
        this.f395131x = false;
        this.f395132y = false;
        this.f395130w = 0;
        this.f395129v = null;
        C3(false);
        Q3(true);
    L18:
        hia.a r104 = this.f395121n;
        String r105 = this.H;
        if (r105 == null) goto L21;
        h3(this.I, r105);
    L21:
        this.G = null;
        this.H = null;
        this.I = null;
        this.f395119J = -1;
        if (r100 == false) goto L29;
        if (r104 == null) goto L25;
        r104.c();
    L25:
        hia.c.a(r104);
        this.f395121n = null;
        Job r106 = this.C;
        if (r106 == null) goto L28;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L28:
        this.C = null;
        zh8.a.f572196a.x1().c().r6(null);
        B3(false);
        return;
    L29:
        if (r104 == null) goto L33;
        r104.e(new k0(r104, this));
        return;
    L33:
        return;
    L7:
        if (r101 != ContinuousTalkStatus.STOPPING) goto L9;
    }

    @Override // com.obric.audio.continuous_talk.b
    public final void updateIntentExt(Map<String, String> r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricContinuousTalkUIComponent", "updateIntentExt: " + r100);
        i r102 = this.f395123p;
        r102.getClass();
        r101.i("ObricContinuousLLMContextProvider", "updateIntentExt called : isAgentExtCompleted=" + r102.f395176c.get() + ", ext=" + r100);
        if (r102.f395176c.get() == true) goto L9;
        r102.f395176c.set(false);
        Function1<? super Map<String, String>, Unit> r103 = r102.f395174a;
        if (r103 == null) goto L7;
        r103.invoke(r100);
    L7:
        r102.f395174a = null;
        return;
    }

    @Override // com.obric.audio.continuous_talk.b
    public final void updateScreenshotForAsr(String r100) {
        if (ObricAsrDelegate.f392831b.q() == true) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (r100 != null) goto L8;
    L13:
        if (r101 == false) goto L15;
        return;
    L15:
        JSONObject r102 = new JSONObject();
        r102.put("image_url", r100);
        r102.put("update_nonstream_context_finish", true);
        hia.a r103 = this.f395121n;
        if (r103 == null) goto L19;
        r103.d(r102);
        return;
    L19:
        return;
    L8:
        if (r100.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 != true) goto L13;
        r101 = true;
        goto L13
    L10:
        r104 = false;
        goto L11
    }

    @Override // hca.b
    public final void x1(ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
    }

    public final void h3(String r100, String r101) {
        VoiceCaptureStateProducerDelegate.f392947b.d(r100, VoiceCaptureScene.CONTINUOUS_TALK, r101, Integer.valueOf(this.f395119J));
        if (Intrinsics.areEqual(this.H, r101) == false) goto L5;
        this.H = null;
        this.I = null;
        this.f395119J = -1;
    L5:
        this.K = false;
    }

    public final void m3(uga.b r100, String r101, String r110, Map<String, String> r111) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.c() == false) goto L8;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.f392915a, r100.f550066a, r101, r110, r111, 8);
    L8:
        if (this.E != r100) goto L11;
        this.E = null;
        return;
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [com.obric.audio.continuous_talk.n0, java.lang.Object] */
    @Override // com.obric.audio.continuous_talk.b
    public final String hr(String r310, String r311, Integer r312, Integer r313, String r314, String r315, SpeakerVoice r316, de8.c r317, by7.e r318, String r410, String r411, String r412, boolean r413, RealtimeCallParam.l r414) {
        Intrinsics.checkNotNullParameter(r310, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r311, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r314, "convId");
        Intrinsics.checkNotNullParameter(r315, "botId");
        Intrinsics.checkNotNullParameter(r317, "chatArgumentData");
        Intrinsics.checkNotNullParameter(r414, "oneshotParams");
        String r100 = this.D;
        if (r100 == null) goto L5;
        uga.b r101 = new uga.b(r100);
    L6:
        this.D = null;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).getFragmentManager() == null) goto L60;
        String r102 = UUID.randomUUID().toString();
        this.G = r102;
        this.H = r102;
        this.I = r314;
        if (r313 == null) goto L11;
        int r103 = r313.intValue();
    L12:
        this.f395119J = r103;
        this.K = false;
        f2a.c r104 = this.f395122o.b("param");
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put(new f2a.f(FailedBinderCallBack.CALLER_ID), r310);
        r105.put(new f2a.f(DBDefinition.TASK_ID), r311);
        r105.put(new f2a.f("vuiId"), String.valueOf(r312));
        r105.put(f2a.f.f475238h, r314);
        r105.put(f2a.f.f475235e, r315);
        r105.put(new f2a.f("voiceType"), String.valueOf(r316));
        r105.put(new f2a.f("chatArgumentData"), r317.toString());
        r104.d(r105);
        r104.f475230c.f475256d = "invokeOnSpeak";
        f2a.c.c(r104, null, 15);
        com.larus.bmhome.chat.component.bottom.multimodal.latest.a r106 = (com.larus.bmhome.chat.component.bottom.multimodal.latest.a) this.f395125r.getValue();
        if (r106 == null) goto L15;
        r106.g0("ChatBottomSpeakerComponent#invokeOnSpeak");
    L15:
        Q3(false);
        Intrinsics.checkNotNullParameter(r102, "asrTaskId");
        Intrinsics.checkNotNullParameter(this, "<this>");
        final Fragment r107 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        hia.a.C6151a r108 = hia.a.f485361a;
        ?? r109 = new n0(r107);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "lifecycleScope");
        ObricContTalkMgrImpl r110 = new ObricContTalkMgrImpl(r109);
        i r111 = this.f395123p;
        com.larus.bmhome.chat.component.cvs.y r112 = (com.larus.bmhome.chat.component.cvs.y) this.f395124q.getValue();
        if (r112 == null) goto L18;
        wc9.e r113 = r112.h();
    L19:
        r111.getClass();
        FLogger r114 = FLogger.f375446a;
        r114.i("ObricContinuousLLMContextProvider", "updateConversation called : cov=" + r113);
        r111.f395175b = r113;
        ((com.obric.audio.continuous_talk.session.impl.plugin.b) LLMCallController.w(r110, Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.session.impl.plugin.b.class))).B0(this.f395123p);
        Triple r115 = new Triple(r110, Boolean.TRUE, Boolean.FALSE);
        boolean r116 = ((Boolean) r115.getSecond()).booleanValue();
        boolean r210 = ((Boolean) r115.getThird()).booleanValue();
        hia.a r117 = (hia.a) r115.getFirst();
        f2a.c r118 = this.f395122o.b("createAsrSession");
        LinkedHashMap r119 = new LinkedHashMap();
        f2a.f r120 = new f2a.f("session_type");
        String r121 = Reflection.getOrCreateKotlinClass(r117.getClass()).getSimpleName();
        if (r121 != null) goto L22;
        r121 = "";
    L22:
        r119.put(r120, r121);
        r119.put(new f2a.f("is_speak"), String.valueOf(r116));
        r119.put(new f2a.f("reset_task_id"), String.valueOf(r210));
        r118.d(r119);
        r118.f475230c.f475256d = "invokeOnSpeak";
        f2a.c.c(r118, null, 15);
        IFlowTtsClientService.f288300a.getClass();
        if (IFlowTtsClientService.a.a().a() == false) goto L25;
        IFlowTtsClientService.a.a().f("");
    L25:
        uga.b r122 = this.E;
        if (r122 == null) goto L28;
        m3(r122, "cancelled", "continuous_talk_replaced_before_pcm", MapsKt.emptyMap());
    L28:
        this.E = r101;
        Y2();
        AtomicReference<hia.a> r123 = hia.c.f485388a;
        Intrinsics.checkNotNullParameter("ObricContinuousTalkUIComponent#invokeOnSpeak", "reason");
        hia.a r124 = hia.c.f485388a.getAndSet(r117);
        if (r124 == null) goto L32;
        if (r124 == r117) goto L32;
        r114.i("ObricContTalkSessionStore", "replace: stopPreviousImmediately, reason=ObricContinuousTalkUIComponent#invokeOnSpeak");
        r124.c();
    L32:
        this.f395121n = r117;
        H3("invokeOnSpeakBeforeStart");
        uga.b r125 = r101;
        this.f395133z = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkUIComponent$invokeOnSpeak$1$4(r117, this, r101, r412, r413, r102, null), 3, null);
        this.A = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkUIComponent$invokeOnSpeak$1$5(r117, this, r125, null), 3, null);
        this.B = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkUIComponent$invokeOnSpeak$1$6(r117, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ObricContinuousTalkUIComponent$invokeOnSpeak$1$7(r314, null), 2, null);
        IVoiceCaptureStateProducerService.a.a(VoiceCaptureStateProducerDelegate.f392947b, r314, VoiceCaptureScene.CONTINUOUS_TALK, r102, Integer.valueOf(this.f395119J));
        hia.a.d r126 = r117.f(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r414);
        if (r210 == false) goto L36;
        this.G = null;
    L36:
        if ((r126 instanceof hia.a.d.C6152a) == false) goto L47;
        m3(r125, "dropped", "continuous_talk_start_failed", MapsKt.mapOf(TuplesKt.to("error_code", String.valueOf(((hia.a.d.C6152a) r126).f485365a))));
        Y2();
        this.f395131x = false;
        this.f395132y = false;
        this.f395130w = 0;
        this.f395129v = null;
        C3(false);
        Q3(true);
        h3(r314, r102);
        this.G = null;
        r117.c();
        hia.c.a(r117);
        if (this.f395121n != r117) goto L40;
        this.f395121n = null;
    L40:
        this.F = ContinuousTalkStatus.STOPPED;
        Job r127 = this.C;
        if (r127 == null) goto L43;
        Job.DefaultImpls.cancel$default(r127, null, 1, null);
    L43:
        this.C = null;
        zh8.a.f572196a.x1().c().r6(null);
        B3(false);
        com.obric.audio.continuous_talk.c r128 = p3();
        if (r128 == null) goto L47;
        com.obric.audio.continuous_talk.c.a.a(r128, null, null, false, true, 7);
    L47:
        if (this.G == null) goto L61;
        this.F = ContinuousTalkStatus.RUNNING;
        H3("invokeOnSpeakAfterStart");
        Job r129 = this.C;
        if (r129 == null) goto L51;
        Job.DefaultImpls.cancel$default(r129, null, 1, null);
    L51:
        IObricChatUIService r130 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r130 == null) goto L54;
        z0<Boolean> r131 = r130.D();
    L55:
        if (r131 != null) goto L57;
        r114.w("ObricContinuousTalkUIComponent", "observeTtsSwitchState: ttsEnabledStateFlow is null, skip");
        goto L61
    L57:
        this.C = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkUIComponent$observeTtsSwitchState$1(r131, this, null), 3, null);
        goto L61
    L54:
        r131 = null;
    L61:
        return this.G;
    L18:
        r113 = null;
        goto L19
    L11:
        r103 = -1;
        goto L12
    L60:
        return null;
    L5:
        r101 = null;
        goto L6
    }
}
