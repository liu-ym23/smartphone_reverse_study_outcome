package com.larus.voicecall.impl.component.core;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.google.gson.reflect.TypeToken;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IAudioService;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.a1;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.bmhome.utils.a4;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.y0;
import com.larus.im.service.audio.z0;
import com.larus.nova.R;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.CommandType;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.component.vlm.m1;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeNoticeDialogHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 À\u00012\u00020\u00012\u00020\u0002:\u0002À\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010q\u001a\u00020jH\u0016J\b\u0010r\u001a\u00020jH\u0016J\b\u0010s\u001a\u00020jH\u0016J\u0010\u0010t\u001a\u00020j2\u0006\u0010u\u001a\u00020vH\u0016J\b\u0010w\u001a\u00020jH\u0002J\b\u0010x\u001a\u00020jH\u0002J\b\u0010y\u001a\u00020jH\u0016J.\u0010z\u001a\u00020j2\u0006\u0010{\u001a\u00020i2\u0006\u0010|\u001a\u00020%2\u0014\u0010}\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020j\u0018\u00010hH\u0016J\b\u0010~\u001a\u00020jH\u0002J\u0011\u0010\u007f\u001a\u00020j2\u0007\u0010\u0080\u0001\u001a\u00020iH\u0002J\t\u0010\u0081\u0001\u001a\u00020jH\u0002J\t\u0010\u0082\u0001\u001a\u00020jH\u0016J\t\u0010\u0083\u0001\u001a\u00020jH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020j2\u0007\u0010\u0085\u0001\u001a\u00020%H\u0002J\t\u0010\u0086\u0001\u001a\u00020jH\u0002J\u0010\u0010\u0087\u0001\u001a\u00020jH\u0082@¢\u0006\u0003\u0010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020jH\u0002J\t\u0010\u008a\u0001\u001a\u00020jH\u0002J\t\u0010\u008b\u0001\u001a\u00020jH\u0002J\t\u0010\u008c\u0001\u001a\u00020jH\u0002J\t\u0010\u008d\u0001\u001a\u00020jH\u0016J\t\u0010\u008e\u0001\u001a\u00020jH\u0016J\t\u0010\u008f\u0001\u001a\u00020jH\u0002J\t\u0010\u0090\u0001\u001a\u00020jH\u0002J\u0012\u0010\u0091\u0001\u001a\u00020j2\u0007\u0010\u0092\u0001\u001a\u00020iH\u0002J\t\u0010\u0093\u0001\u001a\u00020jH\u0002J\t\u0010\u0094\u0001\u001a\u00020jH\u0002J/\u0010\u0095\u0001\u001a\u00020j2\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0098\u0001\u001a\u00020f2\b\u0010\u0099\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u009a\u0001\u001a\u00020fH\u0016J\t\u0010\u009b\u0001\u001a\u00020jH\u0016J\u0013\u0010\u009c\u0001\u001a\u00020j2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J\u0015\u0010\u009f\u0001\u001a\u00020j2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0002J\t\u0010¢\u0001\u001a\u00020jH\u0016J\t\u0010£\u0001\u001a\u00020jH\u0016J\t\u0010¤\u0001\u001a\u00020jH\u0016J\t\u0010¥\u0001\u001a\u00020jH\u0016J\u0012\u0010¦\u0001\u001a\u00020j2\u0007\u0010§\u0001\u001a\u00020iH\u0016J\u0012\u0010¨\u0001\u001a\u00020j2\u0007\u0010§\u0001\u001a\u00020iH\u0016J\u001f\u0010©\u0001\u001a\u00020j2\t\u0010ª\u0001\u001a\u0004\u0018\u00010i2\t\u0010«\u0001\u001a\u0004\u0018\u00010iH\u0016J\u001f\u0010¬\u0001\u001a\u00020j2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010i2\t\u0010ª\u0001\u001a\u0004\u0018\u00010iH\u0016J\u0012\u0010®\u0001\u001a\u00020j2\u0007\u0010§\u0001\u001a\u00020iH\u0016J\u0012\u0010¯\u0001\u001a\u00020j2\u0007\u0010°\u0001\u001a\u00020iH\u0016J0\u0010±\u0001\u001a\u00020j2%\u0010g\u001a!\u0012\u0015\u0012\u00130i¢\u0006\u000e\b²\u0001\u0012\t\b³\u0001\u0012\u0004\b\b({\u0012\u0004\u0012\u00020j\u0018\u00010hH\u0016J\t\u0010´\u0001\u001a\u00020jH\u0016J\t\u0010µ\u0001\u001a\u00020jH\u0016J\u0013\u0010¶\u0001\u001a\u00020j2\b\u0010·\u0001\u001a\u00030¸\u0001H\u0016J\u001e\u0010¹\u0001\u001a\u00020j2\u0007\u0010\u009d\u0001\u001a\u00020i2\n\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001H\u0016J\u0015\u0010¼\u0001\u001a\u00020j2\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020jH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\n\u001a\u0004\b<\u0010=R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\n\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\n\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bK\u0010LR\u001d\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\n\u001a\u0004\bP\u0010QR\u001d\u0010S\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\n\u001a\u0004\bU\u0010VR\u001b\u0010X\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\n\u001a\u0004\bZ\u0010[R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010g\u001a\u0010\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020j\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010l\u001a\u0004\u0018\u00010m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\n\u001a\u0004\bn\u0010o¨\u0006Á\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/core/RealtimeCoreComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "<init>", "()V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "osDestroyed", "", "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "traceAbility", "Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "getTraceAbility", "()Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "traceAbility$delegate", "videoAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVideoAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "videoAbility$delegate", "interviewAbility", "Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "getInterviewAbility", "()Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "interviewAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "imAbility", "Lcom/larus/voicecall/impl/component/im/IRealtimeIMAbility;", "getImAbility", "()Lcom/larus/voicecall/impl/component/im/IRealtimeIMAbility;", "imAbility$delegate", "feedbackAbility", "Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "getFeedbackAbility", "()Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "feedbackAbility$delegate", "stateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "stateManager$delegate", "interceptorManager", "Lcom/larus/voicecall/impl/RealtimeCallCheckManager;", "isGoSettingsDialogShown", "startRealtimeCallConnection", "networkUnavailableTipsTimeMs", "", "networkUnavailableTipsInterval", "isQueryBegin", "currentUIState", "", "onMicGranted", "Lkotlin/Function1;", "", "", "isViewCrated", "disclaimerConfig", "Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "getDisclaimerConfig", "()Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "disclaimerConfig$delegate", "onAttach", "onVContextReady", WidgetCostModule.TYPE_ON_CREATE, "onViewCreated", "view", "Landroid/view/View;", "checkArgumentParam", "setDisclaimer", "tryCheckBluetoothPermission", "requestMicAccess", "caller", "forceRequest", "callback", "setCallServiceListener", "doPerformBack", "endMethod", "checkPermission", "onResume", "connectWhenMicAccess", "onUpdatePermission", "haPermission", "startConnection", "startConnectInnerEnsureViewCreated", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnectInner", "tryPreloadVideoCapture", "toastNetworkUnavailable", "networkUnavailableOnRTC", "hotAreaClick", "retryConnect", "listenOnRetryCommands", "retryDuplexCommand", "retryConnectOrResume", "clickMethod", "interruptAsrForSend", "tryInterrupt", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "adjustTheVolumeWhenCallStarted", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "handleCommandReplyItem", "commandType", "Lcom/larus/voicecall/api/bean/CommandType;", ITTVideoEngineEventSource.KEY_MUTE, "unMute", "playerMute", "playerUnMute", "sendLocationAuthSucceedTrigger", "extra", "sendLocationAuthFailTrigger", "sendAuthSuccessTrigger", "questionId", "answerId", "sendAuthDenyTrigger", "refuseText", "sendSubtitleImageTrigger", "updateLocationContext", "source", "registerMicGrantListener", "Lkotlin/ParameterName;", "name", "onFragmentViewDestroyed", LiveCommonConstants.REASON_ON_DEDTROY, "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "otherEvent", "content", "", "modifyCallIdBy", "connectInfo", "Lkotlinx/serialization/json/JsonObject;", "releaseListeners", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCoreComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.core.a {
    public static final /* synthetic */ int P = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public com.larus.voicecall.impl.l F;
    public boolean G;
    public boolean H;
    public volatile long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final long f377286J;
    public boolean K;
    public int L;
    public Function1<? super String, Unit> M;
    public boolean N;
    public final Lazy O;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f377287n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f377288o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f377289p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f377290q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f377291r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f377292s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f377293t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f377294u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f377295v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f377296w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f377297x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f377298y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f377299z;

    public static final class a {
    }

    public static final class b implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f377300a = null;

        static {
            f377300a = new b();
        }

        public b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Object invoke() {
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<ChatParam> {
        public c() {
        }
    }

    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f377302a;

        public d(l0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f377302a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f377302a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f377302a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        this.f377293t = false;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.F = new com.larus.voicecall.impl.l(com.larus.ui.arch.component.internal.attach.a.b(this, this), X3(), E3().f484242k, W3().f484260a, E3().f484235d, E3().f484237f);
        X3().E();
        if (com.larus.voicecall.impl.l.a.a(getActivity()) == false) goto L5;
        X3().E();
        d4();
    L5:
        RealtimeCallUtil r100 = RealtimeCallUtil.f379424a;
        String r101 = E3().f484235d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        RealtimeCallUtil.f379458w = r101;
        RealtimeCallUtil.f379459x = E3().f484237f;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f377293t = true;
        RealtimeCallUtil.f379424a.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        RealtimeCallUtil.f379458w = "";
        RealtimeCallUtil.f379459x = "";
        RealtimeCallUtil.f379460y = "";
        com.larus.voicecall.impl.component.feedback.e r100 = (com.larus.voicecall.impl.component.feedback.e) this.D.getValue();
        if (r100 == null) goto L6;
        r100.j60();
    L6:
        if (Q3().q().y0() == false) goto L8;
        RealtimeCallUtil.c(E3().f484237f);
    L8:
        RealtimeCallParam r101 = H3();
        RealtimeCallParam.k r102 = r101.f288756p;
        r102.f288862j = W3().f484274o;
        Q3().e(r101);
        Q3().b();
        Q3().f288929e = null;
        Q3().f288940p = null;
        Q3().f288941q = null;
        Q3().f288926b = null;
        Q3().f288932h = null;
        Q3().f288930f = null;
        Q3().f288933i = null;
        Q3().f288925a = null;
        Q3().f288931g = null;
        RealtimeCallService r103 = Q3();
        b r104 = b.f377300a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f377097s = r104;
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.f377287n.getValue();
    }

    public final e3a.a E3() {
        return (e3a.a) this.f377288o.getValue();
    }

    public final com.larus.voicecall.impl.component.bottom.b G3() {
        return (com.larus.voicecall.impl.component.bottom.b) this.f377297x.getValue();
    }

    public final RealtimeCallParam H3() {
        return (RealtimeCallParam) this.f377290q.getValue();
    }

    public final RealtimeCallService Q3() {
        return (RealtimeCallService) this.f377291r.getValue();
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void UQ() {
        if (Build.VERSION.SDK_INT < 31) goto L13;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.y() == true) goto L13;
        if (i2.f365748b.d("android.permission.BLUETOOTH_CONNECT") == false) goto L11;
        FLogger.f375446a.i("RealtimeCoreComponent", "user has BLUETOOTH_CONNECT permission");
        return;
    L11:
        Intrinsics.checkNotNullParameter(this, "<this>");
        i2.q(com.larus.ui.arch.component.internal.attach.a.b(this, this), CollectionsKt.listOf("android.permission.BLUETOOTH_CONNECT"), new c0());
        return;
    L13:
        FLogger.f375446a.i("RealtimeCoreComponent", "NO NEED BLUETOOTH_CONNECT permission");
    }

    public final g3a.a V3() {
        return (g3a.a) this.f377296w.getValue();
    }

    public final e3a.b W3() {
        return (e3a.b) this.f377289p.getValue();
    }

    public final IRealtimeCallTracer X3() {
        return (IRealtimeCallTracer) this.f377292s.getValue();
    }

    public final void d4() {
        if (this.H == false) goto L5;
        return;
    L5:
        this.H = true;
        FLogger r100 = FLogger.f375446a;
        r100.i("RealtimeCoreComponent", "[startConnection] success");
        RealtimeCallUtil.f379424a.getClass();
        if (((Boolean) RealtimeCallUtil.f379441i0.getValue()).booleanValue() == true) goto L8;
    L13:
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), Dispatchers.getMain().getImmediate(), null, new RealtimeCoreComponent$startConnection$1(this, null), 2, null);
        return;
    L8:
        if (RealtimeCallUtil.L(W3().f484264e) == true) goto L13;
        r100.i("jyt_test", "tryPreloadVideoCapture start");
        RealtimeCallService r101 = Q3();
        RealtimeCallParam r102 = H3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r102, "param");
        RealtimeCallService.s(r102);
        com.larus.voicecall.impl.x r103 = r101.f377099u;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "param");
        r103.C(r102, false, "preloadMediaSession", Long.valueOf(r103.f289044t.c()));
        r103.f289032h = true;
        com.larus.voicecall.impl.component.vlm.b r104 = (com.larus.voicecall.impl.component.vlm.b) this.f377299z.getValue();
        if (r104 == null) goto L12;
        r104.my();
    L12:
        r100.i("jyt_test", "tryPreloadVideoCapture end");
        goto L13
    }

    public final void h4() {
        j3a.a r100 = (j3a.a) this.A.getValue();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        FLogger.f375446a.i("RealtimeCoreComponent", "hasPendingHangUpEvent, ignore interrupt");
        return;
    L12:
        int r103 = W3().f484270k;
        if (r103 != 5) goto L15;
    L20:
        com.larus.voicecall.impl.component.bottom.b r104 = G3();
        if (r104 == null) goto L33;
        VoiceCallBottomLayout r105 = r104.BT();
        if (r105 == null) goto L33;
        Job r106 = r105.f290584b;
        if (r106 != null) goto L27;
    L29:
        boolean r107 = false;
    L31:
        if ((!r107) != true) goto L33;
    L34:
        if (r101 == false) goto L36;
        a4.f314971a.getClass();
        a4.a(a4.f314972b);
        RealtimeCallService r108 = Q3();
        RealtimeCallParam r109 = H3();
        int r110 = com.larus.audio.call.a.f288924r;
        r108.t(r109, false);
        return;
    L36:
        FLogger.f375446a.i("RealtimeCoreComponent", "tryInterrupt failed");
        return;
    L27:
        if (r106.isActive() != true) goto L29;
        r107 = true;
    L33:
        r101 = false;
        goto L34
    L15:
        if (r103 == 4) goto L20;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.f379446l == null) goto L36;
        if (r103 != 9) goto L36;
    L5:
        if (r100.YR() != true) goto L7;
        r102 = true;
        goto L9
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void i40() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        AudioManager r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getSystemService("audio");
    L7:
        if ((r102 instanceof AudioManager) == false) goto L9;
        r101 = (AudioManager) r102;
    L9:
        if (r101 == null) goto L22;
        int r103 = r101.getStreamMaxVolume(3);
        int r104 = r101.getStreamVolume(3);
        float r105 = (r104 * 1.0f) / r103;
        int r106 = z2.f365865a.v3().a();
        if (r106 < 0) goto L13;
        r101.setStreamVolume(0, r106 * r103, 0);
    L13:
        int r107 = r101.getStreamMaxVolume(0);
        int r108 = r101.getStreamVolume(0);
        int r109 = (int) (r107 * r105);
        if (r109 == r108) goto L17;
        r101.setStreamVolume(0, r109, 0);
    L17:
        if (r109 == r108) goto L20;
        FLogger.f375446a.i("RealtimeCoreComponent", "cur media volume is ok，do not modify cur call volume=" + r108 + " maxCallVolume=" + r107 + " curMediaVolume=" + r104 + " maxMediaVolume=" + r103 + "  targetMediaVolume=" + r109);
        return;
    L20:
        FLogger.f375446a.i("RealtimeCoreComponent", "cur media volume is bad，modify volume cur call volume=" + r108 + " maxCallVolume=" + r107 + " curMediaVolume=" + r104 + " maxMediaVolume=" + r103 + "  targetMediaVolume=" + r109);
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void lN() {
        c4("automatic_click");
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        com.larus.voicecall.impl.l r100 = this.F;
        if (r100 == null) goto L18;
        boolean r101 = E3().f484245m;
        Pair<Boolean, Boolean> r102 = com.larus.voicecall.impl.l.f378359i;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L12;
    L16:
        r100.f378367h = false;
        goto L18
    L12:
        if (r100.f378367h == true) goto L16;
        com.larus.voicecall.impl.l.f378359i = TuplesKt.to(Boolean.FALSE, Boolean.valueOf(r101));
        CompletableDeferred<Integer> r104 = r100.f378366g;
        if (r104 == null) goto L16;
        r104.complete(1);
        goto L16
    L7:
        if (r102.getFirst().booleanValue() != true) goto L9;
        r103 = true;
    L18:
        if (this.G == false) goto L32;
        this.G = false;
        Pair<Boolean, Boolean> r105 = com.larus.voicecall.impl.l.f378359i;
        if (com.larus.voicecall.impl.l.a.b(getActivity()) == false) goto L33;
        m3a.a r106 = (m3a.a) this.f377295v.getValue();
        if (r106 == null) goto L24;
        r106.O1(true);
    L24:
        g3a.a r107 = V3();
        if (r107 == null) goto L27;
        r107.O1(true);
    L27:
        com.larus.voicecall.impl.component.bottom.b r108 = G3();
        if (r108 == null) goto L30;
        r108.O1(true);
    L30:
        X3().g();
        d4();
        return;
    L33:
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void oo() {
        Intrinsics.checkNotNullParameter("RealtimeFirstPartComponent", "source");
        Q3().y("RealtimeFirstPartComponent");
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.core.a.class);
    }

    public RealtimeCoreComponent() {
        this.f377287n = LazyKt.lazy(new m0(this));
        this.f377288o = LazyKt.lazy(new g(this));
        this.f377289p = LazyKt.lazy(new h(this));
        this.f377290q = LazyKt.lazy(new i(this));
        this.f377291r = LazyKt.lazy(new j(this));
        this.f377292s = LazyKt.lazy(new k(this));
        this.f377294u = LazyKt.lazy(new l(this));
        this.f377295v = LazyKt.lazy(new n(this));
        this.f377296w = LazyKt.lazy(new o(this));
        this.f377297x = LazyKt.lazy(new p(this));
        this.f377298y = LazyKt.lazy(new n0(this));
        this.f377299z = LazyKt.lazy(new o0(this));
        this.A = LazyKt.lazy(new p0(this));
        this.B = LazyKt.lazy(new q0(this));
        this.C = LazyKt.lazy(new com.larus.voicecall.impl.component.core.c(this));
        this.D = LazyKt.lazy(new com.larus.voicecall.impl.component.core.d(this));
        this.E = LazyKt.lazy(new e(this));
        this.I = -1;
        this.f377286J = TimeUnit.SECONDS.toMillis(3);
        this.L = -1;
        this.O = LazyKt.lazy(new f());
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void A0() {
        getActivity();
        E3();
        W3();
        Q3();
        com.larus.voicecall.impl.component.window.b r100 = (com.larus.voicecall.impl.component.window.b) this.f377294u.getValue();
        m3a.a r101 = (m3a.a) this.f377295v.getValue();
        V3();
        G3();
        n3a.a r102 = (n3a.a) this.f377298y.getValue();
        com.larus.voicecall.impl.component.feedback.e r103 = (com.larus.voicecall.impl.component.feedback.e) this.D.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        Q3().f288933i = null;
        Q3().f288932h = null;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void Ix() {
        if (W3().f484270k != 6) goto L5;
    L15:
        c4("user_click");
        return;
    L5:
        if (W3().f484273n == true) goto L15;
        if (W3().f484270k == 3) goto L10;
        ((w3a.k) this.E.getValue()).d(w3a.n.f558208a);
        h4();
        return;
    L10:
        if (W3().f484270k == 3) goto L12;
        return;
    L12:
        if (this.K == false) goto L18;
        a4.f314971a.getClass();
        a4.a(a4.f314972b);
        Q3().a(H3());
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void R1() {
        RealtimeCallService r100 = Q3();
        RealtimeCallParam r101 = H3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r101, "param");
        FLogger.f375446a.i("RealtimeCallService", "unMute");
        r100.f377099u.U(r101);
    }

    public final void a4() {
    L8:
        th = move-exception;
        FLogger.f375446a.e("RealtimeCoreComponent", th.getMessage(), th);
        return;
    L3:
        if (y0.e(W3().f484264e) == true) goto L5;
        return;
    L5:
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L14;
        e4();     // Catch: Throwable -> L8
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void cJ() {
        W3().f484281v = false;
        RealtimeCallService r100 = Q3();
        RealtimeCallParam r101 = H3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "param");
        FLogger.f375446a.i("RealtimeCallService", "playerUnMute");
        r100.k().e0().c(false);
    }

    public final void e4() {
        if (y0.e(W3().f484264e) == true) goto L5;
    L9:
        this.I = System.currentTimeMillis();
        getActivity().runOnUiThread(new a0(this));
        return;
    L5:
        if (this.I <= 0) goto L9;
        if ((System.currentTimeMillis() - this.I) >= this.f377286J) goto L9;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void mute() {
        IRealtimeCallTracer r100 = X3();
        RealtimeCallParam r101 = H3();
        InstanceCallState.a r102 = InstanceCallState.Companion;
        int r103 = W3().f484270k;
        r102.getClass();
        r100.l0(r101, InstanceCallState.a.a(r103));
        RealtimeCallService r104 = Q3();
        RealtimeCallParam r105 = H3();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "param");
        Intrinsics.checkNotNullParameter(r105, "param");
        FLogger.f375446a.i("RealtimeCallService", ITTVideoEngineEventSource.KEY_MUTE);
        r104.f377099u.G(r105);
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void nr() {
        W3().f484281v = true;
        RealtimeCallService r100 = Q3();
        RealtimeCallParam r101 = H3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "param");
        FLogger.f375446a.i("RealtimeCallService", "playerMute");
        r100.k().e0().c(true);
    }

    public static Unit B3(RealtimeCoreComponent r100) {
        if (y0.e(r100.W3().f484264e) == false) goto L5;
        AudioServiceDelegate.f288288a.getAudioConfig().r("rtc_reconnected");
    L5:
        r100.getActivity().runOnUiThread(new g0());
        return Unit.INSTANCE;
    }

    public final void D3(String r100) {
        if (com.larus.utils.o0.d(r100) == false) goto L6;
        RealtimeCallParam r101 = W3().a();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.H = r100;
        W3().f484274o = r100;
    L6:
        if (z2.f365865a.realtimeCallUseUplinkHangUp() == false) goto L23;
        j3a.a r102 = (j3a.a) this.A.getValue();
        boolean r103 = false;
        if (r102 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L20;
        com.larus.voicecall.impl.component.scene.a r105 = (com.larus.voicecall.impl.component.scene.a) this.B.getValue();
        if (r105 != null) goto L17;
    L19:
        if (r103 == false) goto L23;
    L17:
        if (r105.wm() != true) goto L19;
        r103 = true;
    L20:
        com.larus.voicecall.impl.component.scene.a r106 = (com.larus.voicecall.impl.component.scene.a) this.B.getValue();
        if (r106 == null) goto L23;
        r106.bQ();
        goto L23
    L10:
        if (r102.su() != true) goto L12;
        r104 = true;
    L23:
        com.larus.voicecall.impl.component.window.b r107 = (com.larus.voicecall.impl.component.window.b) this.f377294u.getValue();
        if (r107 == null) goto L27;
        r107.zg();
        return;
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void D9(z0.a r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if ((r110 instanceof pf9.o) == false) goto L11;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.z() == false) goto L9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r100 == null) goto L9;
        r100.postDelayed(new k0(this), 500);
    L9:
        Lazy r101 = RealtimeNoticeDialogHelper.f379515a;
        String r111 = ((pf9.o) r110).f528956e;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        RealtimeNoticeDialogHelper.f379517c = r111;
        return;
    L11:
        if ((r110 instanceof pf9.g0) == false) goto L16;
        h4();
        FLogger.f375446a.i("RealtimeCoreComponent", "on received FlowLLMRetryNewRoundEvent");
        if (this.L == 3) goto L70;
        t19.s.f544207a.g(getContext(), R.string.larus_call_networkError_speakAgain, false);
        return;
    L70:
        return;
    L16:
        if ((r110 instanceof pf9.z) == false) goto L19;
        this.K = true;
        return;
    L19:
        if ((r110 instanceof pf9.a0) == false) goto L22;
        this.K = false;
        return;
    L22:
        if ((r110 instanceof pf9.q) == false) goto L74;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L58
        Iterator<T> r112 = ((pf9.q) r110).f528966a.iterator();     // Catch: Throwable -> L58
    L25:
        if (r112.hasNext() == false) goto L56;
        pf9.p r103 = (pf9.p) r112.next();     // Catch: Throwable -> L58
        CommandType r104 = new CommandType();     // Catch: Throwable -> L58
        Long r105 = r103.f528964a;     // Catch: Throwable -> L58
        if (r105 == null) goto L29;
        int r106 = (int) r105.longValue();     // Catch: Throwable -> L58
    L30:
        r104.setCommandType(r106);     // Catch: Throwable -> L58
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L58
        Map<String, String> r108 = r103.f528965b;     // Catch: Throwable -> L58
        if (r108 == null) goto L36;
        Iterator<Map.Entry<String, String>> r109 = r108.entrySet().iterator();     // Catch: Throwable -> L58
    L34:
        if (r109.hasNext() == false) goto L36;
        Map.Entry<String, String> r113 = r109.next();     // Catch: Throwable -> L58
        r107.putOpt(r113.getKey(), r113.getValue());     // Catch: Throwable -> L58
    L36:
        zd9.h r114 = zd9.h.f571481a;     // Catch: Throwable -> L58
        String r115 = r107.toString();     // Catch: Throwable -> L58
        if (r115 != null) goto L39;
    L42:
        boolean r116 = true;
    L43:
        if (r116 == false) goto L63;
    L54:
        Object r117 = null;
    L55:
        r104.setParam((ChatParam) r117);     // Catch: Throwable -> L58
        Z3(r104);     // Catch: Throwable -> L58
        goto L25
    L63:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L47
        r114.getClass();     // Catch: Throwable -> L47
        r117 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r115, new c().getType()));     // Catch: Throwable -> L47
    L49:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L58
        if (r119 == null) goto L53;
        com.larus.im.internal.delegate.c0 r120 = com.larus.im.internal.delegate.c0.f348199b;     // Catch: Throwable -> L58
        StringBuilder r121 = new StringBuilder();     // Catch: Throwable -> L58
        r121.append("fromJson failed, stack: ");     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r119, "<this>");     // Catch: Throwable -> L58
        r121.append(ExceptionsKt.stackTraceToString(r119));     // Catch: Throwable -> L58
        r120.e("GsonHolder", r121.toString());     // Catch: Throwable -> L58
    L53:
        if (Result.m9455isFailureimpl(r117) == false) goto L55;
    L47:
        th = move-exception;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L58
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L49
    L39:
        if (StringsKt.isBlank(r115) == true) goto L42;
        r116 = false;
        goto L43
    L29:
        r106 = -1;
        goto L30
    L56:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L58
        return;
    L58:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void I6(jd9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        X3().h(r100);
        ouc.d0 r101 = r100.f498753b;
        if (r101 == null) goto L26;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        String r103 = sf9.a.c(r101, "roomId", "");     // Catch: Throwable -> L16
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L25;
        e3a.b r105 = W3();     // Catch: Throwable -> L16
        r105.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r103, "<set-?>");     // Catch: Throwable -> L16
        r105.f484262c = r103;     // Catch: Throwable -> L16
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L27;
        FLogger.f375446a.e("RealtimeCoreComponent", "get roomId failed", r107);
        return;
    L27:
        return;
    L25:
        return;
    L8:
        if (StringsKt.isBlank(r103) == true) goto L11;
        r104 = false;
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final void Z3(CommandType r100) {
        if (r100.getCommandType() != 30) goto L8;
        RealtimeCallParam r101 = W3().a();
        r101.getClass();
        Intrinsics.checkNotNullParameter("mute_overtime", "<set-?>");
        r101.H = "mute_overtime";
        FLogger.f375446a.i("RealtimeCoreComponent", "stop realtime call for command!");
        t19.s r102 = t19.s.f544207a;
        Application r103 = AppHost.f326268a.getApplication();
        Intrinsics.checkNotNullParameter(this, "<this>");
        t19.s.j(r102, r103, com.larus.ui.arch.component.internal.attach.a.b(this, this).getResources().getString(R.string.larus_call_video_ended_toast), null, false, 28);
        Function1<? super String, Unit> r104 = Q3().f288931g;
        if (r104 == null) goto L9;
        r104.invoke("");
        return;
    L9:
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void ZQ(String r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        RealtimeCallService r101 = Q3();
        RealtimeCallParam r102 = H3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r100, "extra");
        ((a1) LLMCallController.w(r101.f377099u, Reflection.getOrCreateKotlinClass(a1.class))).j2(r102, r100);
    }

    public final void c4(String r100) {
        e3a.b r101 = W3();
        int r102 = r101.f484270k;
        if (r102 != 6) goto L5;
    L11:
        X3().i0();
        n3a.a r103 = (n3a.a) this.f377298y.getValue();
        if (r103 == null) goto L14;
        r103.u00(r100);
    L14:
        RealtimeCallParam.d r104 = r101.a().f288752l;
        String r105 = UUID.randomUUID().toString();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f288785a = r105;
        if (r101.f484273n == false) goto L26;
        r101.f484273n = false;
        g3a.a r106 = V3();
        if (r106 == null) goto L26;
        VoiceCallContentLayout r107 = r106.dg();
        if (r107 == null) goto L26;
        if (r107.f379318a.f378295w.getVisibility() != 0) goto L23;
        boolean r108 = true;
    L24:
        if (r108 == false) goto L26;
        com.larus.voicecall.impl.utils.c.d(r107.f379318a.f378295w, false);
        goto L26
    L23:
        r108 = false;
    L26:
        Q3().v(r101.a());
        return;
    L5:
        if (r102 == 16) goto L11;
        if (r101.f484273n == false) goto L28;
        a4.f314971a.getClass();
        a4.a(a4.f314972b);
        Q3().u(r101.a());
        r101.f484273n = false;
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void fG(String r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        RealtimeCallService r101 = Q3();
        RealtimeCallParam r102 = H3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r100, "extra");
        r101.l().o2(r102, r100);
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void ft(String r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        RealtimeCallService r101 = Q3();
        RealtimeCallParam r102 = H3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r100, "extra");
        r101.l().x1(r102, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.voicecall.impl.component.core.b0] */
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
    @Override // com.larus.av_call.component.RealtimeComponent, com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r101 = null;
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new RealtimeCoreComponent$checkArgumentParam$1(this, null), 3, null);
    L6:
        this.N = true;
        Q3().f288929e = new q(this);
        Q3().f288940p = new r(this);
        Q3().f288941q = new s(this);
        Q3().f288926b = new t();
        Q3().f288932h = new u(this);
        Q3().f288930f = new v(this);
        Q3().f288933i = new w(this);
        Q3().f288925a = new y(this);
        Q3().f288931g = new z(this);
        if (com.larus.audio.call.f.f() == false) goto L9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), Dispatchers.getMain(), null, new RealtimeCoreComponent$listenOnRetryCommands$1(this, null), 2, null);
    L9:
        com.larus.platform.model.chat.q r102 = (com.larus.platform.model.chat.q) this.O.getValue();
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L21;
        com.larus.voicecall.impl.component.bottom.b r104 = G3();
        if (r104 == null) goto L21;
        VoiceCallBottomLayout r105 = r104.BT();
        if (r105 == null) goto L21;
        r105.p9(true);
    L21:
        g3a.a r106 = V3();
        if (r106 == null) goto L24;
        VoiceCallContentLayout r107 = r106.dg();
    L25:
        if (r107 == null) goto L29;
        LinearLayout r108 = r107.getMicAccessButton();
        if (r108 == null) goto L29;
        r108.setOnClickListener(new com.larus.voicecall.impl.component.core.b(this));
    L29:
        if (r107 == null) goto L33;
        LinearLayout r109 = r107.getDoubleLineMicAccessButton();
        if (r109 == null) goto L33;
        r109.setOnClickListener(new m(this));
    L33:
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.k() == true) goto L38;
        if (r107 == null) goto L37;
        r101 = r107.getHotArea();
    L37:
        e1.d(r101, new x(this));
    L45:
        Pair<Boolean, Boolean> r110 = com.larus.voicecall.impl.l.f378359i;
        boolean r111 = com.larus.voicecall.impl.l.a.b(getActivity());
        m3a.a r112 = (m3a.a) this.f377295v.getValue();
        if (r112 == null) goto L48;
        r112.O1(r111);
    L48:
        g3a.a r113 = V3();
        if (r113 == null) goto L51;
        r113.O1(r111);
    L51:
        com.larus.voicecall.impl.component.bottom.b r114 = G3();
        if (r114 == null) goto L55;
        r114.O1(r111);
    L55:
        if (com.larus.voicecall.impl.l.a.a(getActivity()) == true) goto L61;
        com.larus.voicecall.impl.l r115 = this.F;
        if (r115 == 0) goto L61;
        r115.a(E3().f484245m, new b0(this));
    L61:
        if (RealtimeCallUtil.z() == false) goto L64;
        UQ();
        return;
    L64:
        return;
    L38:
        g3a.a r116 = V3();
        if (r116 == null) goto L41;
        r101 = r116.iB();
    L41:
        if (r101 == null) goto L43;
        e1.x(r101);
    L43:
        if (r101 == null) goto L45;
        e1.d(r101, new i0(this));
        goto L45
    L24:
        r107 = null;
        goto L25
    L12:
        if (r102.b() != true) goto L14;
        r103 = true;
        goto L15
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void yK(m1 r100) {
        this.M = r100;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.voicecall.impl.component.core.l0] */
    public static final Object C3(final RealtimeCoreComponent r100, Continuation r101) {
        if (r100.N == false) goto L15;
        boolean r102 = z2.f365865a.S();
        FLogger r103 = FLogger.f375446a;
        r103.i("RealtimeCoreComponent", "startConnectInner,realtimeDelayStartConnect:" + r102);
        if (r102 == false) goto L11;
        final long r104 = SystemClock.elapsedRealtime();
        IAudioService r105 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r105 == null) goto L20;
        LiveData<Boolean> r106 = r105.hasInit();
        if (r106 == null) goto L20;
        r106.observe(r100.getActivity(), new d(new l0(r100, r104)));
    L20:
        return Unit.INSTANCE;
    L11:
        r100.a4();
        r103.i("jyt_test", "before start call 1");
        r100.Q3().d(r100.H3());
        r103.i("jyt_test", "after start call 1");
        IAudioService r107 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r107 == null) goto L20;
        r107.b0();
        goto L20
    L15:
        Object r108 = BuildersKt.withContext(Dispatchers.getIO(), new RealtimeCoreComponent$startConnectInnerEnsureViewCreated$2(r100, null), r101);
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r108;
    L19:
        return Unit.INSTANCE;
    }

    public static Unit h3(RealtimeCoreComponent r100, long r101) {
        DecimalFormat r102 = new DecimalFormat(CustomAlbumViewModel.DEFAULT_TAB_ID);
        long r103 = 60;
        String r104 = r100.getActivity().getString(R.string.larus_Realtime_call_reminder_timeout) + ' ' + r102.format((r101 / r103) % r103) + ':' + r102.format(r101 % r103);
        com.larus.voicecall.impl.component.bottom.b r105 = r100.G3();
        if (r105 == null) goto L15;
        VoiceCallBottomLayout r106 = r105.BT();
        if (r106 == null) goto L15;
        Intrinsics.checkNotNullParameter(r104, "showText");
        com.larus.av_call.view.c r107 = r106.f290583a;
        com.larus.av_call.view.c r108 = null;
        if (r107 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r107 = null;
    L9:
        e1.x(r107.o());
        com.larus.av_call.view.c r109 = r106.f290583a;
        if (r109 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L13:
        r108.o().setText(r104);
        goto L15
    L12:
        r108 = r109;
    L15:
        if (r101 != 0) goto L20;
        t19.s.f544207a.g(AppHost.f326268a.getApplication(), R.string.larus_Realtime_call_timeout, false);
        com.larus.voicecall.impl.component.window.b r110 = (com.larus.voicecall.impl.component.window.b) r100.f377294u.getValue();
        if (r110 == null) goto L20;
        r110.zg();
    L20:
        return Unit.INSTANCE;
    }

    public static Unit p3(final RealtimeCoreComponent r100, final byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        r100.getActivity().runOnUiThread(new e0(r100, r101));
        return Unit.INSTANCE;
    }

    public static Unit z3(final RealtimeCoreComponent r100, final r58.d r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        r100.getActivity().runOnUiThread(new f0(r100, r101));
        return Unit.INSTANCE;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void RS(String r100, String r101) {
        RealtimeCallService r102 = Q3();
        RealtimeCallParam r103 = H3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "params");
        r102.l().Y1(r103, r100, r101);
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void xG(String r100, String r101) {
        RealtimeCallService r102 = Q3();
        RealtimeCallParam r103 = H3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "params");
        r102.l().V0(r103, r100, r101);
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void z2(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100, "OTHER_EVENT_RTC_ROOM_ID_GET") == false) goto L18;
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof String) == false) goto L8;
        String r102 = (String) r101;
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L20;
        e3a.b r104 = W3();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r104.f484262c = r102;
        return;
    L20:
        return;
    L11:
        if (StringsKt.isBlank(r102) == true) goto L14;
        r103 = false;
        goto L15
    L8:
        r102 = null;
        goto L9
    }

    public static Unit m3(RealtimeCoreComponent r100, long r101, Boolean r102) {
        FLogger r103 = FLogger.f375446a;
        r103.e("RealtimeCoreComponent", "IAudioService init states. hasInit=" + r102 + " appStart=" + AppHost.f326268a.getAppStartTime() + " osDestroyed=" + r100.f377293t);
        if (r102.booleanValue() == false) goto L18;
        if (r100.f377293t == true) goto L18;
        IAudioService r104 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r104 == null) goto L11;
        LiveData<Boolean> r105 = r104.hasInit();
        if (r105 == null) goto L11;
        r105.removeObservers(r100.getActivity());
    L11:
        long r106 = SystemClock.elapsedRealtime() - r101;
        String r107 = "wait audio init cost:" + r106 + ",hasInit:" + r102;
        r103.i("RealtimeCoreComponent", r107);
        if (r106 <= 10) goto L14;
        yp9.d.f568725b.a("RealtimeCoreComponent", r107);
    L14:
        Lazy r108 = c4a.i.f22434a;
        c4a.i.b(r100.H3().f288751k, r100.E3(), r100.W3().f484264e);
        r100.a4();
        r103.i("jyt_test", "before start call 2");
        r100.Q3().d(r100.H3());
        r103.i("jyt_test", "after start call 2");
        IAudioService r109 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r109 == null) goto L18;
        r109.b0();
    L18:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.voicecall.impl.component.core.d0, java.lang.Object] */
    @Override // com.larus.voicecall.impl.component.core.a
    public final void tF(final String r100, boolean r101, final Function1<? super Boolean, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        if (r101 == true) goto L12;
        Pair<Boolean, Boolean> r102 = com.larus.voicecall.impl.l.f378359i;
        if (com.larus.voicecall.impl.l.a.a(getActivity()) == false) goto L12;
        if (r110 == null) goto L8;
        r110.invoke(Boolean.TRUE);
    L8:
        Function1<? super String, Unit> r103 = this.M;
        if (r103 == null) goto L18;
        r103.invoke(r100);
        return;
    L18:
        return;
    L12:
        com.larus.voicecall.impl.l r104 = this.F;
        if (r104 == null) goto L19;
        ?? r105 = new d0(this, r110, r100);
        Intrinsics.checkNotNullParameter(r105, "callback");
        i2 r106 = i2.f365748b;
        Fragment r107 = r104.f378360a;
        ArrayList r108 = CollectionsKt.arrayListOf(new String[]{"android.permission.RECORD_AUDIO"});
        com.larus.voicecall.impl.n r109 = new com.larus.voicecall.impl.n(r105);
        JSONObject r111 = new JSONObject();
        r111.put("enter_method", NotificationCompat.CATEGORY_CALL);
        Unit r112 = Unit.INSTANCE;
        g1.a.a(r107, r108, r109, null, r111, 8);
        IRealtimeCallTracer r113 = r104.f378361b;
        if (r113 == null) goto L20;
        r113.z(r104.f378362c, r104.f378363d, r104.f378364e, r104.f378365f);
        return;
    L20:
        return;
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void o1(MajorState r100, int r101, MajorState r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "currentMajorState");
        Intrinsics.checkNotNullParameter(r102, "newMajorState");
        if (r103 != 2) goto L5;
    L22:
        RealtimeCallService r104 = Q3();
        RealtimeCallParam r105 = H3();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "params");
    L24:
        if (r103 != 14) goto L26;
        return;
    L26:
        if (r101 == 15) goto L30;
        this.L = r103;
        return;
    L30:
        return;
    L5:
        if (r103 == 3) goto L22;
        if (r103 != 6) goto L24;
        MajorState r106 = Q3().h();
        if ((r106 instanceof MajorState.f) == true) goto L12;
    L14:
        com.larus.voicecall.impl.component.bottom.b r107 = G3();
        if (r107 == null) goto L24;
        VoiceCallBottomLayout r108 = r107.BT();
        if (r108 == null) goto L24;
        r108.p9(r108.f290604v);
        com.larus.av_call.view.c r109 = r108.f290583a;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r109 = null;
    L21:
        r109.o().setText(R.string.larus_ai_content_disclaimer_cn);
        goto L24
    L12:
        if (((MajorState.f) r106).f289186d != 10) goto L14;
        t19.s.f544207a.g(AppHost.f326268a.getApplication(), R.string.larus_tts_speaker_used_error, false);
        goto L14
    }
}
