package com.larus.voicecall.impl.continue_talk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.larus.voicecall.impl.databinding.LarusLayoutContinuousBottomContainerBinding;
import com.larus.voicecall.impl.ui.RealtimeCallFragment;
import com.larus.voicecall.impl.ui.RealtimeCallHelperKt;
import com.larus.voicecall.impl.ui.VoiceCallVideoView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002hk\u0018\u0000 ²\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002²\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010f\u001a\u00020]H\u0016J\u0010\u0010m\u001a\u00020[2\u0006\u0010n\u001a\u00020oH\u0016J\b\u0010p\u001a\u00020[H\u0016J\b\u0010q\u001a\u00020[H\u0016J\u0010\u0010r\u001a\u00020[2\u0006\u0010s\u001a\u00020tH\u0016J\b\u0010u\u001a\u00020[H\u0016J\b\u0010v\u001a\u00020[H\u0016J\u001c\u0010w\u001a\u00020[2\b\u0010x\u001a\u0004\u0018\u00010\u000f2\b\u0010y\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010w\u001a\u00020[2\u0006\u0010n\u001a\u00020oH\u0016J\u0010\u0010z\u001a\u0004\u0018\u00010{H\u0082@¢\u0006\u0002\u0010|J\u0010\u0010}\u001a\u0004\u0018\u00010~H\u0082@¢\u0006\u0002\u0010|J@\u0010\u007f\u001a\u0003H\u0080\u0001\"\u0005\b\u0000\u0010\u0080\u00012\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u001b\u0010\u0083\u0001\u001a\u0016\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u0080\u00010\u0084\u0001\u0012\u0004\u0012\u00020[0YH\u0082@¢\u0006\u0003\u0010\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020[H\u0002J\t\u0010\u0087\u0001\u001a\u00020[H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020[2\u0007\u0010\u0089\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020[2\u0007\u0010\u0089\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u008b\u0001\u001a\u00020[2\u0007\u0010\u0089\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u008c\u0001\u001a\u00020[H\u0002J\t\u0010\u008d\u0001\u001a\u00020[H\u0002J\t\u0010\u008e\u0001\u001a\u00020[H\u0002J\t\u0010\u008f\u0001\u001a\u00020[H\u0002J\t\u0010\u0090\u0001\u001a\u00020[H\u0002J\t\u0010\u0091\u0001\u001a\u00020[H\u0002J\t\u0010\u0092\u0001\u001a\u00020[H\u0016J\t\u0010\u0093\u0001\u001a\u00020[H\u0016J\u0011\u0010\u0094\u0001\u001a\u00020[2\u0006\u0010n\u001a\u00020oH\u0002J\u0011\u0010\u0095\u0001\u001a\u00020[2\u0006\u0010n\u001a\u00020oH\u0002J\u0011\u0010\u0096\u0001\u001a\u00020[2\u0006\u0010n\u001a\u00020oH\u0002J\t\u0010\u0097\u0001\u001a\u00020[H\u0002J\u0012\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0006\u0010n\u001a\u00020oH\u0002J#\u0010\u009a\u0001\u001a\u00020[*\u00030\u0099\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u000f2\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0002J\u001b\u0010\u009e\u0001\u001a\u00020\u000f2\u0007\u0010\u009f\u0001\u001a\u00020\u000f2\u0007\u0010 \u0001\u001a\u00020]H\u0002J\u0011\u0010¡\u0001\u001a\u00020[2\u0006\u0010n\u001a\u00020oH\u0002J\t\u0010¢\u0001\u001a\u00020[H\u0002J\t\u0010£\u0001\u001a\u00020[H\u0002J\t\u0010¤\u0001\u001a\u00020[H\u0002J\t\u0010¥\u0001\u001a\u00020[H\u0002J\u0012\u0010¨\u0001\u001a\u00020[2\u0007\u0010©\u0001\u001a\u00020ZH\u0016J\t\u0010ª\u0001\u001a\u00020[H\u0002J\t\u0010«\u0001\u001a\u00020[H\u0002J\t\u0010¬\u0001\u001a\u00020[H\u0002J\t\u0010\u00ad\u0001\u001a\u00020[H\u0016J\t\u0010®\u0001\u001a\u00020[H\u0016J\t\u0010¯\u0001\u001a\u00020[H\u0002J\f\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001b\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u001b\u001a\u0004\b<\u0010=R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001b\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u001b\u001a\u0004\bK\u0010LR\u001d\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u001b\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u001b\u001a\u0004\bU\u0010VR\u001a\u0010X\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020[0YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0004\n\u0002\u0010iR\u0010\u0010j\u001a\u00020kX\u0082\u0004¢\u0006\u0004\n\u0002\u0010lR\u0012\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, d2 = {"Lcom/larus/voicecall/impl/continue_talk/ChatContinuousTalkComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/audio/IChatContinuousTalkAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "binding", "Lcom/larus/voicecall/impl/databinding/LarusLayoutContinuousBottomContainerBinding;", "keepScreenOnOwner", "", "viewModel", "Lcom/larus/voicecall/impl/continue_talk/ChatContinuousTalkComponentViewModel;", "getViewModel", "()Lcom/larus/voicecall/impl/continue_talk/ChatContinuousTalkComponentViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "refMessageAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getRefMessageAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "refMessageAbility$delegate", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionAbility$delegate", "attachmentAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentAbility$delegate", "floatingButtonAbility", "Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "getFloatingButtonAbility", "()Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "floatingButtonAbility$delegate", "immerseComponent", "Lcom/larus/bmhome/audio/IImmerseComponentApiAbility;", "getImmerseComponent", "()Lcom/larus/bmhome/audio/IImmerseComponentApiAbility;", "immerseComponent$delegate", "chatTitleAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getChatTitleAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "chatTitleAbility$delegate", "chatTopAbility", "Lcom/larus/component/ability/IChatTitleOutAbility;", "getChatTopAbility", "()Lcom/larus/component/ability/IChatTitleOutAbility;", "chatTopAbility$delegate", "screenEdgeEffectManager", "Lcom/larus/voicecall/impl/continue_talk/ScreenEdgeEffectManager;", "getScreenEdgeEffectManager", "()Lcom/larus/voicecall/impl/continue_talk/ScreenEdgeEffectManager;", "screenEdgeEffectManager$delegate", "updateControllerMargin", "Lkotlin/Function1;", "Landroid/view/View;", "", "messageListClipToPadding", "", "inputMinHeight", "addRootToParent", "closeOnTabChangedJob", "Lkotlinx/coroutines/Job;", "isInitStartedContinueTalk", "adaptedChatPage", "currentRealtimeFragment", "Lcom/larus/voicecall/impl/ui/RealtimeCallFragment;", "isContinuousTalking", "fragmentRemoveObserver", "com/larus/voicecall/impl/continue_talk/ChatContinuousTalkComponent$fragmentRemoveObserver$1", "Lcom/larus/voicecall/impl/continue_talk/ChatContinuousTalkComponent$fragmentRemoveObserver$1;", "appBackGroundListener", "com/larus/voicecall/impl/continue_talk/ChatContinuousTalkComponent$appBackGroundListener$1", "Lcom/larus/voicecall/impl/continue_talk/ChatContinuousTalkComponent$appBackGroundListener$1;", "openContinuousTalk", "param", "Lcom/larus/bmhome/audio/OpenContinuousTalkParams;", "closeContinuousTalk", "onFragmentInvisible", "setRecordData", "data", "", "visibleScreenEdgeEffect", "goneScreenEdgeEffect", "prepareAndOpenContinuousTalk", "enterMethod", "callID", "observeBotModel", "Lcom/larus/im/bean/bot/BotModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeConversation", "Lcom/larus/im/bean/conversation/Conversation;", "suspendCoroutine", ExifInterface.GPS_DIRECTION_TRUE, "timeMillis", "", "callback", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverInputArea", "adaptChatPage", "adjustChatUI", "realtimeCallTop", "adaptChatMessageListPadding", "showRealtimeCallTopMask", "recoverChatPage", "observeOnStateChanged", "observeCloseEvent", "observeQueryBeginEvent", "observeQueryEndEvent", "observeOnUIStateChanged", "onResume", "onPause", "checkAudioPermission", "onPermissionGranted", "realStartV2", "tryShowToast", "buildRealtimeFragmentArguments", "Landroid/os/Bundle;", "putIfAbsent", "key", "value", "", "lastCallType", "originalOpenVlm", "isFromAsrSlide", "realStart", "addBindingRoot", "removeBindingRoot", "onPermissionDenied", "onControllerClickListener", "continuousViewStub", "Landroid/view/ViewStub;", "onViewCreated", "view", "registerConv", "tryStartContinueTalkAtStart", "inflateView", LiveCommonConstants.REASON_ON_DEDTROY, "onAttach", "unbindContinuousTalkAbility", "safeActivity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatContinuousTalkComponent extends BaseContentWidget implements xa8.b {
    public static final int M = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public boolean D;
    public boolean E;
    public Job F;
    public boolean G;
    public boolean H;
    public RealtimeCallFragment I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ChatContinuousTalkComponent$fragmentRemoveObserver$1 f378065J;
    public final b K;
    public ViewStub L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f378066m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LarusLayoutContinuousBottomContainerBinding f378067n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f378068o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.ui.arch.vm.internal.l f378069p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f378070q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f378071r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f378072s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f378073t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f378074u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f378075v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f378076w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f378077x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f378078y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f378079z;

    public static final class a {
    }

    public static final class b implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatContinuousTalkComponent f378080a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            this.f378080a.AF();
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            this.f378080a.PS();
        }

        public b(ChatContinuousTalkComponent r100) {
            this.f378080a = r100;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class c implements com.larus.common_ui.dialog.p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatContinuousTalkComponent f378081a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            com.bytedance.router.i r100 = SmartRouter.buildRoute(this.f378081a.getContext(), "//flow/single_tts_speaker_setting");
            Pair[] r101 = new Pair[6];
            ChatContinuousTalkComponent r102 = this.f378081a;
            int r103 = ChatContinuousTalkComponent.M;
            com.larus.bmhome.chat.component.cvs.y r104 = r102.u0();
            String r105 = null;
            if (r104 == null) goto L5;
            BotModel r106 = r104.j0();
        L6:
            r101[0] = TuplesKt.to("select_speaker_argument", r106);
            r101[1] = TuplesKt.to("enter_from", "chat_realtime_call");
            r101[2] = TuplesKt.to("argSearchMobParam", ((de8.c) this.f378081a.f378070q.getValue()).f468089e);
            com.larus.bmhome.chat.component.cvs.y r107 = this.f378081a.u0();
            if (r107 == null) goto L14;
            BotModel r108 = r107.j0();
            if (r108 == null) goto L14;
            String r109 = r108.getName();
            if (r109 == null) goto L14;
            String r110 = r109;
        L15:
            com.larus.bmhome.chat.component.cvs.y r111 = this.f378081a.u0();
            if (r111 == null) goto L23;
            BotModel r112 = r111.j0();
            if (r112 == null) goto L23;
            String r113 = r112.getDescriptionForHuman();
            if (r113 == null) goto L23;
            String r114 = r113;
        L24:
            com.larus.bmhome.chat.component.cvs.y r115 = this.f378081a.u0();
            if (r115 == null) goto L34;
            BotModel r116 = r115.j0();
            if (r116 == null) goto L34;
            SpeakerVoice r117 = r116.getVoiceType();
            if (r117 == null) goto L34;
            String r118 = r117.getId();
            if (r118 == null) goto L34;
            String r119 = r118;
        L35:
            com.larus.bmhome.chat.component.cvs.y r120 = this.f378081a.u0();
            if (r120 == null) goto L43;
            BotModel r121 = r120.j0();
            if (r121 == null) goto L43;
            String r122 = r121.getBotId();
            if (r122 == null) goto L43;
            String r123 = r122;
        L44:
            com.larus.bmhome.chat.component.cvs.y r124 = this.f378081a.u0();
            if (r124 == null) goto L51;
            BotModel r125 = r124.j0();
            if (r125 == null) goto L51;
            ModelItem r126 = r125.getModel();
            if (r126 == null) goto L51;
            long r127 = r126.getModelType();
        L52:
            com.larus.bmhome.chat.component.cvs.y r128 = this.f378081a.u0();
            if (r128 == null) goto L62;
            BotModel r129 = r128.j0();
            if (r129 == null) goto L62;
            SpeakerVoice r130 = r129.getVoiceType();
            if (r130 == null) goto L62;
            String r131 = r130.getLanguageCode();
            if (r131 == null) goto L62;
            String r132 = r131;
        L63:
            r101[3] = TuplesKt.to("key_voice_recommend_param", new GetMatchVoiceRequest(r110, r114, r119, r123, r127, r132, null, 64));
            com.larus.bmhome.chat.component.cvs.y r133 = this.f378081a.u0();
            if (r133 == null) goto L68;
            wc9.e r134 = r133.h();
            if (r134 == null) goto L68;
            r105 = r134.f559198a;
        L68:
            r101[4] = TuplesKt.to("conversation_id", r105);
            r101[5] = TuplesKt.to("key_enter_method", "tts_disabled");
            r100.f267554c.putExtras(BundleKt.bundleOf(r101));
            r100.f267555d = R.anim.larus_router_slide_in_right;
            r100.f267556e = R.anim.larus_router_no_anim;
            r100.e(100);
            return;
        L62:
            r132 = "";
        L51:
            r127 = 0;
        L43:
            r123 = "";
        L34:
            r119 = "";
        L23:
            r114 = "";
        L14:
            r110 = "";
            goto L15
        L5:
            r106 = null;
            goto L6
        }

        public c(ChatContinuousTalkComponent r100) {
            this.f378081a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$closeContinuousTalk$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$closeContinuousTalk$1", f = "ChatContinuousTalkComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r100);
            IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r101 == null) goto L10;
            com.larus.home.impl.sdk.s r102 = r101.s0();
            if (r102 == null) goto L10;
            r102.j();
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class d implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatContinuousTalkComponent f378082a;

        public d(ChatContinuousTalkComponent r100) {
            this.f378082a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(wc9.e r100) {
            Intrinsics.checkNotNullParameter(r100, "new");
            ChatContinuousTalkComponent r101 = this.f378082a;
            int r102 = ChatContinuousTalkComponent.M;
            r101.D3();
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class e implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatContinuousTalkComponent f378083a;

        public e(ChatContinuousTalkComponent r100) {
            this.f378083a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(BotModel r100) {
            Intrinsics.checkNotNullParameter(r100, "new");
            ChatContinuousTalkComponent r101 = this.f378083a;
            int r102 = ChatContinuousTalkComponent.M;
            r101.D3();
        }
    }

    public static final class f implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f378084a;

        public f(ComponentFeature r100) {
            this.f378084a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f378084a;
        }
    }

    public static final class g implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f378086a;

        public g(ComponentFeature r100) {
            this.f378086a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return this.f378086a;
        }
    }

    public static final class h implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f378087a = null;

        static {
            f378087a = new h();
        }

        public h() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onPause$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onPause$1", f = "ChatContinuousTalkComponent.kt", i = {}, l = {601}, m = "invokeSuspend", n = {}, s = {})
    public static final class C115791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatContinuousTalkComponent this$0;

        public C115791(ChatContinuousTalkComponent r100, Continuation<? super C115791> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115791(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115791) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            if (AppHost.f326268a.a().isAppBackground() == true) goto L15;
            this.this$0.closeContinuousTalk();
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            this.label = 1;
            if (DelayKt.delay(500, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1", f = "ChatContinuousTalkComponent.kt", i = {}, l = {1032}, m = "invokeSuspend", n = {}, s = {})
    public static final class C115801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatContinuousTalkComponent this$0;

        /* JADX INFO: renamed from: com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C45291<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ChatContinuousTalkComponent f378088a;

            /* JADX INFO: renamed from: com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1$1$1", f = "ChatContinuousTalkComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C45301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ double $maxAmplitude;
                int label;
                final /* synthetic */ ChatContinuousTalkComponent this$0;

                public C45301(ChatContinuousTalkComponent r100, double r101, Continuation<? super C45301> r102) {
                    this.this$0 = r100;
                    this.$maxAmplitude = r101;
                    super(2, r102);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C45301(this.this$0, this.$maxAmplitude, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C45301) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L10;
                    ResultKt.throwOnFailure(r100);
                    ChatContinuousTalkComponent r101 = this.this$0;
                    int r102 = ChatContinuousTalkComponent.M;
                    h2 r103 = r101.h3();
                    float r104 = (float) this.$maxAmplitude;
                    d19.g r105 = r103.f378156d;
                    if (r105 == null) goto L8;
                    r105.setAudioAmplitude(r104);
                L8:
                    return Unit.INSTANCE;
                L10:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            public C45291(ChatContinuousTalkComponent r100) {
                this.f378088a = r100;
            }

            public final Object a(byte[] r100, Continuation<? super Unit> r110) {
                if ((r110 instanceof ChatContinuousTalkComponent$onViewCreated$1$1$emit$1) == false) goto L7;
                ChatContinuousTalkComponent$onViewCreated$1$1$emit$1 r101 = (ChatContinuousTalkComponent$onViewCreated$1$1$emit$1) r110;
                int r102 = r101.label;
                if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
                r101.label = r102 - Integer.MIN_VALUE;
            L8:
                Object r111 = r101.result;
                Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r104 = r101.label;
                if (r104 == 0) goto L16;
                if (r104 == 1) goto L15;
                if (r104 != 2) goto L14;
                ResultKt.throwOnFailure(r111);
            L34:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                ResultKt.throwOnFailure(r111);
            L19:
                Iterator<T> r105 = ((ArrayList) r111).iterator();
                if (r105.hasNext() == true) goto L22;
                Double r106 = null;
            L27:
                if (r106 == null) goto L29;
                double r107 = r106.doubleValue();
            L30:
                MainCoroutineDispatcher r108 = Dispatchers.getMain();
                C45301 r109 = new C45301(this.f378088a, r107, null);
                r101.label = 2;
                if (BuildersKt.withContext(r108, r109, r101) != r103) goto L34;
                return r103;
            L29:
                r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
                goto L30
            L22:
                double r112 = Math.abs(((Number) r105.next()).doubleValue());
            L24:
                if (r105.hasNext() == false) goto L26;
                r112 = Math.max(r112, Math.abs(((Number) r105.next()).doubleValue()));
                goto L24
            L26:
                r106 = Boxing.boxDouble(r112);
                goto L27
            L16:
                ResultKt.throwOnFailure(r111);
                int r113 = com.larus.common_ui.widget.input.a.f328681a;
                r101.label = 1;
                r111 = com.larus.common_ui.widget.input.a.a(r100, 45, r101);
                if (r111 != r103) goto L19;
                return r103;
            L7:
                r101 = new ChatContinuousTalkComponent$onViewCreated$1$1$emit$1(this, r110);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
                return a((byte[]) r100, r101);
            }
        }

        public C115801(ChatContinuousTalkComponent r100, Continuation<? super C115801> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115801(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115801) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ChatContinuousTalkComponent r103 = this.this$0;
            int r104 = ChatContinuousTalkComponent.M;
            kotlinx.coroutines.flow.d1<byte[]> r105 = r103.m3().getRecordData();
            C45291 r106 = new C45291(this.this$0);
            this.label = 1;
            if (r105.collect(r106, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$5, reason: invalid class name */
    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isContinuousTalk", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$5", f = "ChatContinuousTalkComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ ChatContinuousTalkComponent this$0;

        public AnonymousClass5(ChatContinuousTalkComponent r100, Continuation<? super AnonymousClass5> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass5 r102 = new AnonymousClass5(this.this$0, r101);
            r102.Z$0 = ((Boolean) r100).booleanValue();
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Unit> r101) {
            return invoke(r100.booleanValue(), r101);
        }

        public final Object invoke(boolean r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass5) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L53;
            ResultKt.throwOnFailure(r110);
            boolean r111 = this.Z$0;
            ChatContinuousTalkComponent r100 = this.this$0;
            int r101 = ChatContinuousTalkComponent.M;
            u7 r102 = r100.u3();
            ArrayList r103 = null;
            int r104 = 0;
            if (r102 == null) goto L25;
            List<Message> r105 = r102.zj();
            if (r105 == null) goto L25;
            ArrayList r106 = new ArrayList();
            Iterator<T> r107 = r105.iterator();
        L10:
            if (r107.hasNext() == false) goto L23;
            Object r108 = r107.next();
            Message r109 = (Message) r108;
            if (com.larus.bmhome.chat.bean.d.G0(r109) == true) goto L20;
            Map<String, String> r112 = r109.getBusinessExt();
            if (r112 == null) goto L16;
            String r113 = r112.get("common_button_v2_scene_audio");
        L18:
            if (Intrinsics.areEqual(r113, "true") == false) goto L20;
            boolean r114 = true;
        L21:
            if (r114 == false) goto L10;
            r106.add(r108);
            goto L10
        L16:
            r113 = null;
        L20:
            r114 = false;
            goto L21
        L23:
            r103 = r106;
        L25:
            if (r111 == false) goto L38;
            if (r103 == null) goto L34;
            Iterator r115 = r103.iterator();
        L29:
            if (r115.hasNext() == false) goto L34;
            Message r116 = (Message) r115.next();
            IChatRepoService r117 = zh8.a.f572196a;
            IChatRepoService r118 = zh8.a.f572196a;
            String r119 = r116.getLocalMessageId();
            if (r119 != null) goto L33;
            r119 = "";
        L33:
            r118.r1(r119, new q0());
        L34:
            FLogger r120 = FLogger.f375446a;
            StringBuilder r121 = new StringBuilder("[onViewCreated]_");
            r121.append(this.this$0.hashCode());
            r121.append(" set button hidden to true for ");
            if (r103 == null) goto L37;
            r104 = r103.size();
        L37:
            r121.append(r104);
            r121.append(" messages");
            r120.i("ChatContinuousComponent", r121.toString());
        L51:
            return Unit.INSTANCE;
        L38:
            if (r103 == null) goto L46;
            Iterator r122 = r103.iterator();
        L41:
            if (r122.hasNext() == false) goto L46;
            Message r123 = (Message) r122.next();
            IChatRepoService r124 = zh8.a.f572196a;
            IChatRepoService r125 = zh8.a.f572196a;
            String r126 = r123.getLocalMessageId();
            if (r126 != null) goto L45;
            r126 = "";
        L45:
            r125.r1(r126, new r0());
        L46:
            FLogger r127 = FLogger.f375446a;
            StringBuilder r128 = new StringBuilder("[onViewCreated]_");
            r128.append(this.this$0.hashCode());
            r128.append(" set button hidden to false for ");
            if (r103 == null) goto L49;
            r104 = r103.size();
        L49:
            r128.append(r104);
            r128.append(" messages");
            r127.i("ChatContinuousComponent", r128.toString());
            goto L51
        L53:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        M = i5.W();
    }

    public final FragmentActivity C3() {
        return (FragmentActivity) com.larus.utils.l0.a(null, new x(this));
    }

    public final void D3() {
        if (this.G == false) goto L5;
        return;
    L5:
        fk(new xa8.e("continuous_chat_intercept", ILegacyChatUiServiceDelegate.f297164b.u8(s1a.d.a(this)), null, ((de8.c) this.f378070q.getValue()).f468086b, false, 20));
    }

    public final ry8.b Y2() {
        return (ry8.b) this.A.getValue();
    }

    @Override // xa8.b
    public final void closeContinuousTalk() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[closeContinuousTalk]_");
        r101.append(hashCode());
        r101.append(" isChangingConfigurations=");
        FragmentActivity r102 = C3();
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.isChangingConfigurations());
    L6:
        r101.append(r103);
        r100.i("ChatContinuousComponent", r101.toString());
        FragmentActivity r104 = C3();
        boolean r105 = false;
        if (r104 != null) goto L9;
    L11:
        if (r105 == false) goto L14;
        boolean r106 = k1.f378169a;
        k1.f378169a = m3().isContinuousTalk();
    L14:
        if (AudioServiceDelegate.f288288a.F().a() == false) goto L16;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    L16:
        com.larus.utils.t0.f375468a.post(new com.larus.voicecall.impl.continue_talk.e(this));
        return;
    L9:
        if (r104.isChangingConfigurations() != true) goto L11;
        r105 = true;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public final h2 h3() {
        return (h2) this.C.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ChatContinuousTalkComponentViewModel m3() {
        return (ChatContinuousTalkComponentViewModel) this.f378069p.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        t1a.b r101 = s1a.a.h(s1a.a.getActivity(this));     // Catch: Throwable -> L7
        if (r101.o(Reflection.getOrCreateKotlinClass(xa8.b.class)) != this) goto L5;
        r101.l(Reflection.getOrCreateKotlinClass(xa8.b.class));     // Catch: Throwable -> L7
    L5:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        if (this.E == true) goto L13;
    L27:
        closeContinuousTalk();
        h2 r102 = h3();
        if (r102.f378158f == false) goto L34;
        r102.f378158f = false;
        d19.g r103 = r102.f378156d;
        if (r103 == null) goto L33;
        r103.destroy();
    L33:
        r102.a();
    L34:
        LarusLayoutContinuousBottomContainerBinding r104 = this.f378067n;
        if (r104 == null) goto L39;
        VoiceCallVideoView r105 = r104.f378257b;
        if (r105 == null) goto L39;
        r105.g();
    L39:
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager().unregisterFragmentLifecycleCallbacks(this.f378065J);
        AppHost.f326268a.a().c(this.K);
        return;
    L13:
        if (z2.f365865a.enableChatWithTab() == true) goto L27;
        LarusLayoutContinuousBottomContainerBinding r106 = this.f378067n;
        if (r106 == null) goto L27;
        final FrameLayout r107 = r106.f378256a;
        if (r107 == null) goto L27;
        ViewParent r108 = r107.getParent();
        if ((r108 instanceof ViewGroup) == false) goto L23;
        final ViewGroup r109 = (ViewGroup) r108;
    L24:
        if (r109 == null) goto L27;
        com.larus.utils.l0.b(new com.larus.voicecall.impl.continue_talk.f(r109, r107));
        goto L27
    L23:
        r109 = null;
    L7:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        if (z2.f365865a.enableChatWithTab() == false) goto L9;
        Job r100 = this.F;
        if (r100 == null) goto L7;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L7:
        this.F = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C115791(this, null), 3, null);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        Job r100 = this.F;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.F = null;
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.f378071r.getValue();
    }

    public final u7 u3() {
        return (u7) this.f378074u.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v33, types: [com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$fragmentRemoveObserver$1] */
    public ChatContinuousTalkComponent() {
        this.f378066m = R.id.continuous_talk_container;
        this.f378068o = "ChatContinuousTalkComponent-" + hashCode();
        this.f378069p = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(ChatContinuousTalkComponentViewModel.class), Reflection.getOrCreateKotlinClass(ChatContinuousTalkComponentViewState.class), new f(this), new g(this), h.f378087a);
        this.f378070q = LazyKt.lazy(new com.larus.voicecall.impl.continue_talk.a(this));
        this.f378071r = LazyKt.lazy(new g0(this));
        this.f378072s = LazyKt.lazy(new h0(this));
        this.f378073t = LazyKt.lazy(new i0(this));
        this.f378074u = LazyKt.lazy(new j0(this));
        this.f378075v = LazyKt.lazy(new k0(this));
        this.f378076w = LazyKt.lazy(new l0(this));
        this.f378077x = LazyKt.lazy(new com.larus.voicecall.impl.continue_talk.b(this));
        this.f378078y = LazyKt.lazy(new com.larus.voicecall.impl.continue_talk.c(this));
        this.f378079z = LazyKt.lazy(new com.larus.voicecall.impl.continue_talk.d(this));
        this.A = LazyKt.lazy(new l(this));
        this.B = LazyKt.lazy(new w(this));
        this.C = LazyKt.lazy(new f0());
        this.D = true;
        this.f378065J = new ChatContinuousTalkComponent$fragmentRemoveObserver$1(this);
        this.K = new b(this);
    }

    @Override // xa8.b
    public final void AF() {
        h2 r100 = h3();
        r100.getClass();
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("[goneScreenEdgeEffect]: gone screen edge effect, screenEdgeEffectView is null(");
        if (r100.f378156d != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r102.append(')');
        r101.i("ScreenEdgeEffectManager", r102.toString());
        d19.g r104 = r100.f378156d;
        if (r104 == null) goto L9;
        r104.c();
    L9:
        Object r105 = r100.f378156d;
        if ((r105 instanceof View) == false) goto L12;
        View r106 = (View) r105;
    L13:
        if (r106 == null) goto L16;
        com.larus.utils.e1.o(r106);
        return;
    L16:
        return;
    L12:
        r106 = null;
        goto L13
    L5:
        r103 = false;
        goto L6
    }

    public final void B3() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 == null) goto L5;
        r100.rh(new p(), new d(this));
    L5:
        com.larus.bmhome.chat.component.cvs.y r101 = u0();
        if (r101 == null) goto L9;
        com.larus.bmhome.chat.component.cvs.y.b.a(r101, new e(this));
        return;
    }

    @Override // xa8.b
    public final void PS() {
        h3().b();
    }

    @Override // xa8.b
    public final boolean fe() {
        return m3().isContinuousTalk();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        s1a.a.b(s1a.a.getActivity(this), this, xa8.b.class);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f378066m;
    }

    @Override // xa8.b
    public final void hd() {
        closeContinuousTalk();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f378066m = r100;
    }

    @Override // xa8.b
    public final void ai(final xa8.e r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        com.larus.utils.l0.b(new s(this, r100));
    }

    @Override // xa8.b
    public final void fk(xa8.e r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        if (m3().isContinuousTalk() == false) goto L6;
        FLogger.f375446a.w("ChatContinuousComponent", "openContinuousTalk, isContinuousTalk is true");
        return;
    L6:
        List r101 = CollectionsKt.listOf("android.permission.RECORD_AUDIO");
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") == 0) goto L9;
        i2 r102 = i2.f365748b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r103 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        m0 r104 = new m0(this, r100);
        JSONObject r105 = new JSONObject();
        r105.put("enter_method", "asr");
        Unit r106 = Unit.INSTANCE;
        com.larus.platform.api.g1.a.a(r103, r101, r104, null, r105, 8);
        return;
    L9:
        p3(r100);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if ((r110 instanceof ViewStub) == false) goto L5;
        this.L = (ViewStub) r110;
    L5:
        h2 r111 = h3();
        FragmentActivity r100 = C3();
        boolean r101 = true;
        if (r111.f378158f == true) goto L9;
        r111.f378158f = true;
        r111.f378155c = r100;
    L9:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getDefault(), null, new C115801(this, null), 2, null);
        Bundle r102 = ((de8.c) this.f378070q.getValue()).f468086b;
        if (r102 != null) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == false) goto L17;
        B3();
    L17:
        ry8.b r103 = Y2();
        if (r103 == null) goto L22;
        com.larus.platform.api.g0 r104 = r103.C5();
        if (r104 == null) goto L22;
        r104.setOnTtsContinuousTalkCheckedListener(new com.larus.voicecall.impl.continue_talk.g(this));
    L22:
        ry8.b r105 = Y2();
        if (r105 == null) goto L28;
        com.larus.platform.api.g0 r106 = r105.C5();
        if (r106 == null) goto L28;
        r106.setOnTtsContinuousTalkLongClickListener(new com.larus.voicecall.impl.continue_talk.h(this));
    L28:
        if (k1.f378169a == false) goto L30;
        com.larus.utils.t0.f375468a.postDelayed(new i(this), 200);
    L30:
        AppHost.f326268a.a().j(this.K);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(ce8.c.f23471a, new AnonymousClass5(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        return;
    L12:
        if (r102.getBoolean("need_start_continue_talk", false) != true) goto L14;
        goto L14
    }

    public final void p3(final xa8.e r110) {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        Integer r101 = null;
        if (r100 == null) goto L5;
        wc9.e r102 = r100.h();
    L7:
        if (r102 == null) goto L93;
        com.larus.bmhome.chat.component.cvs.y r103 = u0();
        if (r103 == null) goto L11;
        BotModel r104 = r103.j0();
    L12:
        if (r104 == null) goto L93;
        com.larus.bmhome.chat.component.cvs.y r105 = u0();
        if (r105 == null) goto L19;
        BotModel r106 = r105.j0();
        if (r106 == null) goto L19;
        Integer r107 = r106.getBotType();
    L21:
        if (RealtimeCallHelperKt.b(r107) == false) goto L29;
        t19.s.f544207a.g(getContext(), R.string.larus_continuous_chat_downgrade_error, false);
        FLogger r111 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("type:");
        com.larus.bmhome.chat.component.cvs.y r109 = u0();
        if (r109 == null) goto L27;
        BotModel r112 = r109.j0();
        if (r112 == null) goto L27;
        r101 = r112.getBotType();
    L27:
        r108.append(r101);
        r108.append("【Downgrade】");
        r111.e("ChatContinuousComponent", r108.toString());
        return;
    L29:
        AudioServiceDelegate r113 = AudioServiceDelegate.f288288a;
        if (r113.P().isRecording() == false) goto L33;
        com.larus.utils.t0.f375468a.post(new k(this));
        return;
    L33:
        com.larus.bmhome.chat.component.cvs.y r114 = u0();
        if (r114 == null) goto L40;
        BotModel r115 = r114.j0();
        if (r115 == null) goto L40;
        SpeakerVoice r116 = r115.getVoiceType();
        if (r116 == null) goto L40;
        String r117 = r116.getStyleId();
    L42:
        if (r117 != null) goto L44;
    L47:
        boolean r118 = true;
    L49:
        if (r118 == true) goto L87;
        com.larus.bmhome.chat.component.cvs.y r119 = u0();
        if (r119 == null) goto L57;
        BotModel r120 = r119.j0();
        if (r120 == null) goto L57;
        if (r120.getMuted() != true) goto L57;
        boolean r121 = true;
    L58:
        if (r121 == true) goto L87;
        if (r113.F().a() == false) goto L63;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ChatContinuousTalkComponent$onPermissionGranted$3(null), 3, null);
    L63:
        FLogger.f375446a.i("ChatContinuousComponent", "[realStartContinuousTalk]_" + hashCode() + " params.enterMethod=" + r110.f563092a + " params.callID=" + r110.f563093b + " params.isOpenVlm=" + r110.f563094c);
        this.G = true;
        Handler r122 = com.larus.utils.t0.f375468a;
        r122.post(new t(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == true) goto L67;
        return;
    L67:
        if (com.larus.voicecall.impl.b.a() == true) goto L81;
        int r123 = c4a.g.f22433a;
        com.larus.bmhome.chat.component.cvs.y r124 = u0();
        if (r124 == null) goto L71;
        BotModel r125 = r124.j0();
    L73:
        if (c4a.g.a(r125) == true) goto L81;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r126 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r126 == null) goto L80;
        FragmentManager r127 = r126.getSupportFragmentManager();
        if (r127 == null) goto L80;
        r127.registerFragmentLifecycleCallbacks(this.f378065J, true);
    L80:
        r122.post(new u(this, r110));
        return;
    L71:
        r125 = null;
    L81:
        ry8.b r128 = Y2();
        if (r128 == null) goto L99;
        b3a.c r129 = r128.wP(null);
        if (r129 == null) goto L100;
        VoiceCallServiceDelegate r130 = VoiceCallServiceDelegate.f377087a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r130.J(r129, com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager(), "chat_asr_entrance");
        return;
    L100:
        return;
    L99:
        return;
    L57:
        r121 = false;
    L87:
        CommonDialog.a r131 = new CommonDialog.a();
        r131.g(getContext().getString(R.string.larus_continuous_chat_unvoice));
        CommonDialog.a.f(r131, new c(this), getContext().getString(R.string.larus_Realtime_call_go_setting), false, 12);
        CommonDialog r132 = r131.b(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r133 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();
        LandscapeRestrictionOperation r134 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r132, null, r134);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r133, r132, r134) == true) goto L102;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L95
    L91:
        r132.show(r133, null);
        return;
    L102:
        return;
    L44:
        if (r117.length() == 0) goto L47;
        r118 = false;
    L40:
        r117 = null;
    L19:
        r107 = null;
        goto L21
    L11:
        r104 = null;
    L93:
        FLogger.f375446a.e("ChatContinuousComponent", "onPermissionGranted error, conversation or bot is null");
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // xa8.b
    public final void ym(int r100) {
        FLogger r101 = FLogger.f375446a;
        r101.d("ChatContinuousComponent", "[adjustChatUI]: realtimeCallRoot.paddingTop is " + r100);
        u7 r102 = u3();
        if (r102 == null) goto L5;
        int[] r103 = r102.dZ();
    L6:
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103[1];
    L10:
        u7 r106 = u3();
        if (r106 == null) goto L13;
        r104 = r106.k70();
    L13:
        int r107 = r105 + r104;
        if (r107 <= r100) goto L24;
        int r108 = r107 - r100;
        r101.i("ChatContinuousComponent", "[adaptChatMessageListPadding]: update paddingBottom = " + r108 + ", realtimeCallTop = " + r100);
        u7 r109 = u3();
        if (r109 == null) goto L18;
        r109.tU(r108);
    L18:
        xa8.a r110 = (xa8.a) this.f378078y.getValue();
        if (r110 == null) goto L21;
        r110.mD();
    L21:
        xa8.a r111 = (xa8.a) this.f378078y.getValue();
        if (r111 == null) goto L24;
        r111.e2((-r108) - M);
    L24:
        LarusLayoutContinuousBottomContainerBinding r112 = this.f378067n;
        if (r112 == null) goto L33;
        View r113 = r112.f378261f;
        if (r113 == null) goto L34;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L32;
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114;
        r115.topMargin = r100 - M;
        r113.setLayoutParams(r115);
        com.larus.utils.e1.x(r113);
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L34:
        return;
    L33:
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // xa8.b
    public final void iU(final String r100, final String r101) {
        com.larus.utils.l0.b(new j(r100, r101, this));
    }

    public static void z3(Bundle r100, String r101, Object r102) {
        if (r100.containsKey(r101) == false) goto L6;
        return;
    L6:
        if ((r102 instanceof Boolean) == false) goto L9;
        r100.putBoolean(r101, ((Boolean) r102).booleanValue());
        return;
    L9:
        if ((r102 instanceof String) == false) goto L12;
        r100.putString(r101, (String) r102);
        return;
    L12:
        if ((r102 instanceof Integer) == false) goto L15;
        r100.putInt(r101, ((Number) r102).intValue());
        return;
    L15:
        if ((r102 instanceof Long) == false) goto L18;
        r100.putLong(r101, ((Number) r102).longValue());
        return;
    L18:
        if ((r102 instanceof Float) == false) goto L21;
        r100.putFloat(r101, ((Number) r102).floatValue());
        return;
    L21:
        if ((r102 instanceof Double) == false) goto L24;
        r100.putDouble(r101, ((Number) r102).doubleValue());
        return;
    L24:
        if ((r102 instanceof Parcelable) == false) goto L27;
        r100.putParcelable(r101, (Parcelable) r102);
        return;
    L27:
        if ((r102 instanceof Serializable) == false) goto L30;
        r100.putSerializable(r101, (Serializable) r102);
        return;
    L30:
        if ((r102 instanceof CharSequence) == false) goto L32;
        r100.putCharSequence(r101, (CharSequence) r102);
        return;
    L32:
        FLogger.f375446a.i("ChatContinuousComponent", "[putIfAbsent] can not put key = " + r101 + ", value = " + r102);
    }
}
