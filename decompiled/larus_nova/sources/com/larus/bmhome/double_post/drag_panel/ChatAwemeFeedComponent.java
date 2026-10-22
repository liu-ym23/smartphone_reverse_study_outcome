package com.larus.bmhome.double_post.drag_panel;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.bean.OnboardingSug;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonAction;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.databinding.LarusFragmentAwemeDoublePostBinding;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.SearchRichMediaBlock;
import com.larus.im.bean.message.block.UgcItem;
import com.larus.nova.R;
import com.larus.platform.model.chat.ChatAwemeFeedConfig;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0007*\u0002¤\u0001\u0018\u0000 ¨\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004¨\u0001©\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007fH\u0016J\t\u0010\u0080\u0001\u001a\u00020}H\u0002J\t\u0010\u0081\u0001\u001a\u00020}H\u0002J\t\u0010\u0082\u0001\u001a\u00020}H\u0002J\t\u0010\u0083\u0001\u001a\u00020}H\u0002J\t\u0010\u0084\u0001\u001a\u00020}H\u0016J\t\u0010\u0085\u0001\u001a\u00020aH\u0016J\b\u0010e\u001a\u00020aH\u0016J\t\u0010\u0086\u0001\u001a\u00020aH\u0016J\u0012\u0010\u0087\u0001\u001a\u00020}2\u0007\u0010\u0088\u0001\u001a\u00020aH\u0016J\b\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u0004\u0018\u00010aH\u0016¢\u0006\u0003\u0010\u0089\u0001J\t\u0010\u008a\u0001\u001a\u00020}H\u0016J\t\u0010\u008b\u0001\u001a\u00020}H\u0002J\u001d\u0010\u008c\u0001\u001a\u00020}2\u0007\u0010\u008d\u0001\u001a\u00020l2\t\b\u0002\u0010\u008e\u0001\u001a\u00020aH\u0002J\t\u0010\u008f\u0001\u001a\u00020aH\u0002J\t\u0010\u0090\u0001\u001a\u00020}H\u0002J+\u0010\u0091\u0001\u001a\u00020}2\u0007\u0010\u0092\u0001\u001a\u00020a2\t\b\u0002\u0010\u0093\u0001\u001a\u00020a2\f\b\u0002\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\u0012\u0010\u0096\u0001\u001a\u00020}2\u0007\u0010\u0097\u0001\u001a\u00020aH\u0002J\u001d\u0010\u0098\u0001\u001a\u00020}2\u0007\u0010\u0099\u0001\u001a\u00020a2\t\b\u0002\u0010\u009a\u0001\u001a\u00020aH\u0002J\u0012\u0010\u009b\u0001\u001a\u00020}2\u0007\u0010\u009c\u0001\u001a\u00020aH\u0002J\u0012\u0010\u009d\u0001\u001a\u00020}2\u0007\u0010\u009a\u0001\u001a\u00020aH\u0002J\u0010\u0010\u009e\u0001\u001a\u00020aH\u0082@¢\u0006\u0003\u0010\u009f\u0001J\t\u0010 \u0001\u001a\u00020aH\u0002J\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010l*\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010¢\u0001\u001a\u00020aH\u0082@¢\u0006\u0003\u0010\u009f\u0001J\t\u0010¦\u0001\u001a\u00020}H\u0002J\t\u0010§\u0001\u001a\u00020\u0007H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0011\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0011\u001a\u0004\bH\u0010IR\u001d\u0010K\u001a\u0004\u0018\u00010L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0011\u001a\u0004\bM\u0010NR\u0016\u0010P\u001a\u0004\u0018\u00010Q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u001d\u0010T\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0011\u001a\u0004\bV\u0010WR\u001d\u0010Y\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u0011\u001a\u0004\b[\u0010\\R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010b\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u000e\u0010d\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010p\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u000e\u0010q\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020sX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010z\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010\tR\u0013\u0010£\u0001\u001a\u00030¤\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¥\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeFeedComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/double_post/drag_panel/IChatAwemeFeedAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "chatFragmentAbility", "Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "binding$delegate", "chatAwemeFeedConfig", "Lcom/larus/platform/model/chat/ChatAwemeFeedConfig;", "getChatAwemeFeedConfig", "()Lcom/larus/platform/model/chat/ChatAwemeFeedConfig;", "chatAwemeFeedConfig$delegate", AppConstants.APP_FG, "Lcom/larus/bmhome/double_post/fragment/AwemeDoublePostFragment;", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "chatCollectMessageAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getChatCollectMessageAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "chatCollectMessageAbility$delegate", "chatCaseMessageAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getChatCaseMessageAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "chatCaseMessageAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatMessageShareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getChatMessageShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "chatMessageShareAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "chatTitleAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getChatTitleAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "chatTitleAbility$delegate", "floatingButtonAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getFloatingButtonAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "floatingButtonAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "referenceAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceAbility$delegate", "chatFragmentCoreAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentCoreAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentCoreAbility$delegate", "releatedVideoTwoRowFlowDataCmdProcessor", "Lcom/larus/bmhome/double_post/ReleatedVideoTwoRowFlowDataCmdProcessor;", "isImmerseMode", "", "immerseModeActionBarState", "Ljava/lang/Boolean;", "isFullScreen", "isUnlimitedFlowFullScreen", "lastRecommendMsgId", "", "autoEnterImmerseJob", "Lkotlinx/coroutines/Job;", "backToChatWithOffset", "pendingMessage", "Lcom/larus/im/bean/message/Message;", "isShowKeyboard", "isShowBottomMenu", "isForceHideChatAwemeFeed", "relatedVideoEnabled", "enterWithInstruction", "leaveTime", "", "pageEnterTimeStamp", "leaveMethod", "immerseBarViewManager", "Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeFeedComponent$ImmerseBarViewManager;", "settingRepo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "mBottomOffsetFourCard", "getMBottomOffsetFourCard", "onViewCreated", "", "view", "Landroid/view/View;", "initAwemeContainer", "initChatView", "addAwemeFeedFragment", "addFragment", LiveCommonConstants.REASON_ON_DEDTROY, "canEntryAwemeFeed", "disableFastScrollButton", "setKeyboardStatus", "isShow", "()Ljava/lang/Boolean;", "abortNestedContainerAnimation", "observeFirstMessage", "dealRelatedFlowMessage", "message", "isPendingMsg", "checkFragmentValid", "addListener", "hideChatAwemeFeed", "withAnim", "forceScrollToLatest", "callback", "Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeNestedContainer$IBackToChatCallback;", "setFastBackChat", "awemeFeedFullScreen", "setImmerseMode", "isImmerse", "autoEnterImmerse", "updateActionBarVisibility", "state", "autoEnterImmerseMode", "preCheck", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollCheck", "latestMessageIgnoringUserActiveDeleteTip", "isMainBotConv", "appBackGroundListener", "com/larus/bmhome/double_post/drag_panel/ChatAwemeFeedComponent$appBackGroundListener$1", "Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeFeedComponent$appBackGroundListener$1;", "logLeavePage", "getFourCardHeight", "Companion", "ImmerseBarViewManager", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatAwemeFeedComponent extends BaseContentWidget implements l0 {
    public static final /* synthetic */ int V = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public com.larus.bmhome.double_post.e D;
    public boolean E;
    public Boolean F;
    public boolean G;
    public boolean H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Job f311441J;
    public Message K;
    public boolean L;
    public boolean M;
    public boolean N;
    public Boolean O;
    public boolean P;
    public long Q;
    public String R;
    public b S;
    public final ISettingRepoService T;
    public final c U;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f311442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f311443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f311444o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f311445p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AwemeDoublePostFragment f311446q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f311447r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f311448s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f311449t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f311450u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f311451v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f311452w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f311453x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f311454y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f311455z;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f311458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<Context, View> f311459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Lazy f311460c;

        public final void a() {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
            this.f311458a.post(new a0(this));
            return;
        L7:
            if (this.f311458a.findViewById(((View) this.f311460c.getValue()).getId()) != null) goto L10;
            return;
        L10:
            if (((View) this.f311460c.getValue()).getVisibility() == 8) goto L13;
            ((View) this.f311460c.getValue()).setVisibility(8);
            return;
        }

        public final void b() {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
            this.f311458a.post(new z(this));
            return;
        L6:
            View r100 = (View) this.f311460c.getValue();
            if (r100.getVisibility() == 0) goto L10;
            r100.setVisibility(0);
            return;
        }

        public b(ChatConstraintLayout r100, i r101) {
            Intrinsics.checkNotNullParameter(r100, "parentLayout");
            Intrinsics.checkNotNullParameter(r101, "createViewLambda");
            this.f311458a = r100;
            this.f311459b = r101;
            this.f311460c = LazyKt.lazy(new b0(this));
        }
    }

    public static final class c implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatAwemeFeedComponent f311461a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            ChatAwemeFeedComponent r100 = this.f311461a;
            System.currentTimeMillis();
            int r101 = ChatAwemeFeedComponent.V;
            r100.getClass();
            ChatAwemeFeedComponent r102 = this.f311461a;
            if (r102.G == false) goto L6;
            r102.E3();
            return;
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            ChatAwemeFeedComponent r100 = this.f311461a;
            if (r100.G == false) goto L6;
            r100.Q = System.currentTimeMillis();
            return;
        }

        public c(ChatAwemeFeedComponent r100) {
            this.f311461a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.double_post.drag_panel.ChatAwemeFeedComponent$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes26.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.double_post.drag_panel.ChatAwemeFeedComponent$onViewCreated$1", f = "ChatAwemeFeedComponent.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatAwemeFeedComponent this$0;

        public AnonymousClass1(ChatAwemeFeedComponent r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.bmhome.double_post.drag_panel.i] */
        /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.bmhome.double_post.drag_panel.m] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L12:
            if (((Boolean) r110).booleanValue() == false) goto L50;
            final ChatAwemeFeedComponent r111 = this.this$0;
            int r102 = ChatAwemeFeedComponent.V;
            LarusPageChatBinding r103 = r111.p3();
            if (r103 == null) goto L52;
            r103.f311086b.setEnable(true);
            r103.f311086b.setScrollListener(new d0(r111, r103));
            LarusPageChatBinding r104 = r111.p3();
            if (r104 == null) goto L21;
            ChatConstraintLayout r105 = r104.f311085a;
            if (r105 == null) goto L21;
            r105.postDelayed(new j(r111), 300);
        L21:
            u7 r106 = r111.B3();
            if (r106 == null) goto L24;
            MessageAdapter r107 = r106.MF();
        L26:
            if ((r107 instanceof MessageAdapter) == true) goto L29;
            r107 = null;
        L29:
            if (r107 == null) goto L31;
            r107.p1(new p(r111));
        L31:
            LarusPageChatBinding r108 = r111.p3();
            if (r108 == null) goto L45;
            IChatMessageShareAbility r109 = (IChatMessageShareAbility) r111.f311451v.getValue();
            if (r109 == null) goto L36;
            r109.A60(new c0(r108, r111));
        L36:
            ld8.n r112 = (ld8.n) r111.f311455z.getValue();
            if (r112 == null) goto L39;
            r112.AE(BottomFloatingButtonType.BACK_CHAT_BUTTON, new k(r111));
        L39:
            f1 r113 = (f1) s1a.d.a(r111).getAbility(f1.class);
            if (r113 == 0) goto L43;
            r113.Yj(new m(r111));
        L43:
            if (r111.z3().getShouldFullyDisplay() == false) goto L45;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r111), null, null, new ChatAwemeFeedComponent$addListener$1$4(r111, null), 3, null);
        L45:
            AppHost.f326268a.a().j(r111.U);
            Intrinsics.checkNotNullParameter(r111, "<this>");
            s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(r111, r111), r111, l0.class);
            if (r111.z3().getSupportFullScreen() == false) goto L52;
            if (r111.z3().getSupportFullScreenNavi() == false) goto L52;
            r111.S = new b(r103.f311091g, new i(r111));
            goto L52
        L24:
            r107 = null;
        L52:
            return Unit.INSTANCE;
        L50:
            FLogger.f375446a.i("ChatAwemeFeedComponent", "preCheck failed");
            goto L52
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            ChatAwemeFeedComponent r114 = this.this$0;
            this.label = 1;
            r110 = ChatAwemeFeedComponent.Y2(r114, this);
            if (r110 != r100) goto L12;
            return r100;
        }
    }

    static {
    }

    public final u7 B3() {
        return (u7) this.f311447r.getValue();
    }

    public final void E3() {
        if (this.Q <= 0) goto L5;
        long r100 = System.currentTimeMillis() - this.Q;
    L6:
        this.Q = 0;
        AwemeDoublePostFragment r101 = this.f311446q;
        String r102 = this.R;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "leaveMethod");
        LarusFragmentAwemeDoublePostBinding r103 = r101.f311545e;
        boolean r104 = false;
        if (r103 == null) goto L16;
        TextView r105 = r103.f310892c;
        if (r105 == null) goto L16;
        if (r105.getVisibility() != 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 != true) goto L16;
        r104 = true;
        goto L16
    L13:
        r106 = false;
    L16:
        if (r104 == false) goto L18;
        return;
    L18:
        if (r100 == 0) goto L52;
        com.larus.platform.service.o r107 = com.larus.platform.service.o.f365780a;
        JSONObject r108 = new JSONObject();
        Content r109 = r101.iy();
        Message r110 = r101.f311560t;
        String r111 = null;
        if (r110 == null) goto L27;
        String r112 = r110.getMessageId();
        if (r112 == null) goto L27;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L27;
        String r114 = r113.toString();
    L28:
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r114);
        Message r115 = r101.f311560t;
        if (r115 == null) goto L31;
        String r116 = r115.getReplyId();
    L32:
        r108.put(NoticeInfo.KEY_REPLY_ID, r116);
        r108.put("enter_method", r102);
        r108.put("stay_duration", r100);
        if (r109 == null) goto L36;
        Integer r117 = r109.getImprIndex();
        if (r117 == null) goto L36;
    L40:
        r108.put("impr_index", r117);
        if (r109 == null) goto L46;
        String r118 = r109.getRequestId();
        if (r118 == null) goto L46;
        r111 = r118;
    L49:
        r108.put("last_req_id", r111);
        Unit r119 = Unit.INSTANCE;
        r107.reportEvent("leave_feed_page", r108);
        return;
    L46:
        Content r120 = r101.f311558r;
        if (r120 == null) goto L49;
        r111 = r120.getRequestId();
    L36:
        Content r121 = r101.f311558r;
        if (r121 == null) goto L39;
        r117 = r121.getImprIndex();
        goto L40
    L39:
        r117 = null;
        goto L40
    L31:
        r116 = null;
    L27:
        r114 = null;
        goto L28
    L52:
        return;
    L5:
        r100 = 0;
        goto L6
    }

    public final LarusPageChatBinding p3() {
        return (LarusPageChatBinding) this.f311444o.getValue();
    }

    public final ChatAwemeFeedConfig z3() {
        return (ChatAwemeFeedConfig) this.f311445p.getValue();
    }

    public ChatAwemeFeedComponent() {
        this.f311442m = R.id.chat_root;
        this.f311443n = LazyKt.lazy(new l(this));
        this.f311444o = LazyKt.lazy(new w(this));
        this.f311445p = LazyKt.lazy(new x());
        this.f311446q = new AwemeDoublePostFragment();
        this.f311447r = LazyKt.lazy(new y(this));
        this.f311448s = LazyKt.lazy(new com.larus.bmhome.double_post.drag_panel.b(this));
        this.f311449t = LazyKt.lazy(new com.larus.bmhome.double_post.drag_panel.c(this));
        this.f311450u = LazyKt.lazy(new d(this));
        this.f311451v = LazyKt.lazy(new e(this));
        this.f311452w = LazyKt.lazy(new f(this));
        this.f311453x = LazyKt.lazy(new g(this));
        this.f311454y = LazyKt.lazy(new r(this));
        this.f311455z = LazyKt.lazy(new s(this));
        this.A = LazyKt.lazy(new t(this));
        this.B = LazyKt.lazy(new u(this));
        this.C = LazyKt.lazy(new v(this));
        this.R = "slide_back_to_chat";
        this.T = RepoDispatcherDelegate.f307737b.c();
        this.U = new c(this);
    }

    @Override // com.larus.bmhome.double_post.drag_panel.l0
    public final boolean WB() {
        LarusPageChatBinding r100 = p3();
        if (r100 == null) goto L9;
        ChatAwemeNestedContainer r101 = r100.f311086b;
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.getEnable() != true) goto L9;
    L10:
        if (r102 == true) goto L13;
        return false;
    L13:
        return this.H;
    L9:
        r102 = false;
        goto L10
    }

    @Override // com.larus.bmhome.double_post.drag_panel.l0
    public final boolean fl() {
        LarusPageChatBinding r100 = p3();
        if (r100 == null) goto L9;
        ChatAwemeNestedContainer r101 = r100.f311086b;
        if (r101 == null) goto L9;
        if (r101.getEnable() != true) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        return false;
    L12:
        LarusPageChatBinding r103 = p3();
        Integer r104 = null;
        if (r103 == null) goto L22;
        ChatAwemeNestedContainer r105 = r103.f311086b;
        if (r105 == null) goto L22;
        Integer r106 = Integer.valueOf(r105.getScrollY());
        if (r106.intValue() <= 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        r104 = r106;
        goto L22
    L19:
        r107 = false;
    L22:
        if (r104 != null) goto L26;
        return false;
    L26:
        return true;
    L9:
        r102 = false;
        goto L10
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        E3();
        RecommendVideoApi.f315186j.clear();
        AppHost.f326268a.a().c(this.U);
        com.larus.bmhome.double_post.e r100 = this.D;
        if (r100 == null) goto L6;
        com.larus.im.d.b().removeProcessor(r100);
        return;
    }

    @Override // com.larus.bmhome.double_post.drag_panel.l0
    public final void t5() {
        if (z3().canEntryAwemeFeed() == true) goto L5;
        return;
    L5:
        LarusPageChatBinding r100 = p3();
        if (r100 == null) goto L11;
        ChatAwemeNestedContainer r101 = r100.f311086b;
        if (r101 == null) goto L12;
        r101.f311475a.abortAnimation();
        return;
    L12:
        return;
    }

    @Override // com.larus.bmhome.double_post.drag_panel.l0
    public final boolean wQ() {
        return z3().canEntryAwemeFeed();
    }

    @Override // com.larus.bmhome.double_post.drag_panel.l0
    public final boolean zc() {
        if (z3().getSupportFullScreen() == true) goto L9;
        if (z3().getFullScreenHideActionBar() == true) goto L9;
        return false;
    L9:
        return this.G;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f311442m;
    }

    @Override // com.larus.bmhome.double_post.drag_panel.l0
    public final Boolean YN() {
        return this.F;
    }

    public static Message D3(u7 r100) {
        Object r101 = null;
        if (r100 == null) goto L25;
        List<Message> r102 = r100.zj();
        if (r102 == null) goto L26;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        Integer r105 = com.larus.bmhome.social.userchat.model.b0.c((Message) r104);
        if (r105 != null) goto L13;
    L14:
        boolean r106 = true;
    L16:
        if (r106 == false) goto L8;
        r101 = r104;
        goto L19
    L13:
        if (r105.intValue() != 14) goto L14;
        r106 = false;
    L19:
        return (Message) r101;
    L26:
        return null;
    L25:
        return null;
    }

    public final void G3(boolean r100) {
        ld8.n r101 = (ld8.n) this.f311455z.getValue();
        if (r101 == null) goto L17;
        if (r100 == true) goto L6;
    L10:
        if (r100 == false) goto L12;
        return;
    L12:
        if (r101.uo(BottomFloatingButtonType.BACK_CHAT_BUTTON) == false) goto L14;
    L15:
        r101.m60(BottomFloatingButtonAction.HIDE_BACK_CHAT);
        return;
    L14:
        if (r101.uo(BottomFloatingButtonType.VIEW_NEW_NEWS_BUTTON) == true) goto L15;
        return;
    L6:
        if (r101.uo(BottomFloatingButtonType.BACK_CHAT_BUTTON) == true) goto L10;
        if (r101.uo(BottomFloatingButtonType.VIEW_NEW_NEWS_BUTTON) == true) goto L10;
        r101.Ib(BottomFloatingButtonAction.BACK_CHAT, false);
        return;
    }

    @Override // com.larus.bmhome.double_post.drag_panel.l0
    public final void Tj(boolean r100) {
        this.L = r100;
        if (r100 == false) goto L5;
        H3(false, false);
        return;
    L5:
        h3(true);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f311442m = r100;
    }

    public final void h3(boolean r100) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (this.G == false) goto L9;
        this.f311441J = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatAwemeFeedComponent$autoEnterImmerseMode$1(this, null), 3, null);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final Object Y2(ChatAwemeFeedComponent r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof ChatAwemeFeedComponent$preCheck$1) == false) goto L7;
        ChatAwemeFeedComponent$preCheck$1 r102 = (ChatAwemeFeedComponent$preCheck$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L45:
        if (((Boolean) r104).booleanValue() == true) goto L48;
        return Boxing.boxBoolean(false);
    L48:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100.z3().canEntryAwemeFeed() == true) goto L18;
        return Boxing.boxBoolean(false);
    L18:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L50;
        com.larus.bmhome.chat.component.collection.o r107 = (com.larus.bmhome.chat.component.collection.o) r100.f311448s.getValue();
        if (r107 != null) goto L23;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == true) goto L51;
        com.larus.bmhome.chat.component.showcase.x r109 = (com.larus.bmhome.chat.component.showcase.x) r100.f311449t.getValue();
        if (r109 != null) goto L31;
    L33:
        boolean r110 = false;
    L34:
        if (r110 == true) goto L52;
        r102.label = 1;
        kotlinx.coroutines.j r111 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r111.C();
        e0 r112 = new e0(r111);
        com.larus.bmhome.chat.component.cvs.y r113 = (com.larus.bmhome.chat.component.cvs.y) r100.f311450u.getValue();
        if (r113 == null) goto L39;
        com.larus.bmhome.chat.component.cvs.y.b.b(r113, r112);
    L39:
        r104 = r111.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L42:
        if (r104 != r105) goto L45;
        return r105;
    L52:
        return Boxing.boxBoolean(false);
    L31:
        if (r109.e6() != true) goto L33;
        r110 = true;
        goto L34
    L51:
        return Boxing.boxBoolean(false);
    L23:
        if (r107.i0() != true) goto L25;
        r108 = true;
        goto L26
    L50:
        return Boxing.boxBoolean(false);
    L7:
        r102 = new ChatAwemeFeedComponent$preCheck$1(r100, r101);
        goto L8
    }

    public final void H3(boolean r100, boolean r101) {
        if (z3().getSupportFullScreen() == false) goto L5;
    L7:
        Job r102 = this.f311441J;
        final ViewGroup r103 = null;
        if (r102 == null) goto L10;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L10:
        if (r100 == true) goto L12;
    L16:
        if (r100 == true) goto L19;
        h3(r101);
    L19:
        if (this.E != r100) goto L21;
        return;
    L21:
        this.E = r100;
        ry8.b r104 = (ry8.b) this.f311454y.getValue();
        if (r104 == null) goto L25;
        r103 = r104.getTitleContainer();
    L25:
        if (r100 == true) goto L27;
    L44:
        if (r100 == false) goto L46;
        return;
    L46:
        if (z3().getSupportFullScreenNavi() == false) goto L59;
        b r105 = this.S;
        if (r105 == null) goto L50;
        r105.a();
    L50:
        if (r103 == null) goto L59;
        r103.setAlpha(0.0f);
        r103.setVisibility(0);
        ViewPropertyAnimator r106 = r103.animate();
        if (r106 == null) goto L59;
        ViewPropertyAnimator r107 = r106.alpha(1.0f);
        if (r107 == null) goto L59;
        ViewPropertyAnimator r108 = r107.setDuration(200);
        if (r108 == null) goto L59;
        r108.start();
    L59:
        if (z3().getFullScreenHideActionBar() == true) goto L61;
    L62:
        this.F = Boolean.TRUE;
        com.larus.bmhome.instruction.g r109 = (com.larus.bmhome.instruction.g) this.f311452w.getValue();
        if (r109 == null) goto L71;
        r109.T40(true);
        return;
    L71:
        return;
    L61:
        if (this.G == false) goto L62;
        return;
    L27:
        if (this.f311446q.f311555o == true) goto L44;
        if (z3().getSupportFullScreenNavi() == false) goto L41;
        b r110 = this.S;
        if (r110 == null) goto L33;
        r110.b();
    L33:
        if (r103 == null) goto L41;
        ViewPropertyAnimator r111 = r103.animate();
        if (r111 == null) goto L41;
        ViewPropertyAnimator r112 = r111.alpha(0.0f);
        if (r112 == null) goto L41;
        ViewPropertyAnimator r113 = r112.setDuration(200);
        if (r113 == null) goto L41;
        r113.withEndAction(new com.larus.bmhome.double_post.drag_panel.a(r103));
    L41:
        this.F = Boolean.FALSE;
        com.larus.bmhome.instruction.g r114 = (com.larus.bmhome.instruction.g) this.f311452w.getValue();
        if (r114 == null) goto L67;
        r114.T40(false);
        return;
    L67:
        return;
    L12:
        if (this.L == false) goto L14;
        return;
    L14:
        if (this.M == false) goto L16;
        return;
    L5:
        if (z3().getFullScreenHideActionBar() == true) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.bmhome.double_post.drag_panel.n] */
    public final void m3(final Message r110, final boolean r111) {
        if (Intrinsics.areEqual(r110.getMessageId(), this.I) == true) goto L88;
        this.I = r110.getMessageId();
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        List r102 = null;
        if (com.larus.bmhome.chat.bean.d.E0(r110) == false) goto L34;
        List<Block> r103 = r110.getContentBlock();
        if (r103 == null) goto L15;
        Block r104 = (Block) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L15;
        BlockContent r105 = r104.getContent();
        if (r105 == null) goto L15;
        SearchRichMediaBlock r106 = r105.getRichMediaBlock();
        if (r106 == null) goto L15;
        List<RichMediaItem> r107 = r106.creations;
    L16:
        if (r107 != null) goto L18;
        r107 = CollectionsKt.emptyList();
    L18:
        RichMediaItem r108 = (RichMediaItem) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L23;
        UgcItem r109 = r108.ugcItem;
        if (r109 == null) goto L23;
        T r112 = r109.getRequestId();
    L24:
        r101.element = r112;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r107.iterator();
    L26:
        if (r114.hasNext() == false) goto L51;
        UgcItem r115 = ((RichMediaItem) r114.next()).ugcItem;
        if (r115 == null) goto L30;
        String r116 = r115.getItemId();
    L31:
        if (r116 == null) goto L26;
        r113.add(r116);
        goto L26
    L30:
        r116 = null;
    L51:
        final List r117 = r113;
    L53:
        Map<String, String> r118 = r110.getExt();
        if (r118 == null) goto L58;
        String r119 = r118.get("text_area_ugc_gid_list");
        if (r119 == null) goto L58;
        List r120 = StringsKt.split$default(r119, new String[]{","}, false, 0, 6, null);
    L59:
        final ArrayList r121 = new ArrayList();
        if (r117 == null) goto L62;
        Lazy r122 = com.larus.bmhome.video.b.f315193a;
        r102 = CollectionsKt.take(r117, ((Number) com.larus.bmhome.video.b.a().getFirst()).intValue());
    L62:
        if (r102 != null) goto L64;
        r102 = CollectionsKt.emptyList();
    L64:
        r121.addAll(r102);
        if (r120 != null) goto L67;
        r120 = CollectionsKt.emptyList();
    L67:
        r121.addAll(r120);
        FLogger.f375446a.d("ChatAwemeFeedComponent", "dealRelatedFlowMessage");
        final ?? r123 = new n(this, r110, r101, r117, r121, r100, r111);
        if (this.f311446q.isAdded() == false) goto L70;
        r123.invoke();
    L71:
        this.f311446q.f311550j = false;
        return;
    L70:
        AwemeDoublePostFragment r124 = this.f311446q;
        Function0<Unit> r125 = new o(r123);
        r124.getClass();
        Intrinsics.checkNotNullParameter(r125, "callBack");
        r124.f311564x = r125;
    L58:
        r120 = null;
    L23:
        r112 = 0;
    L15:
        r107 = null;
        goto L16
    L34:
        if (com.larus.bmhome.chat.bean.d.W(r110) == false) goto L52;
        List<OnboardingSug> r126 = com.larus.bmhome.chat.bean.d.h1(r110);
        ?? r127 = new ArrayList();
        Iterator<T> r128 = r126.iterator();
    L37:
        if (r128.hasNext() == false) goto L41;
        Content r129 = ((OnboardingSug) r128.next()).getRichMediaDisplayContent();
        if (r129 == null) goto L37;
        r127.add(r129);
        goto L37
    L41:
        r100.element = r127;
        Content r130 = (Content) CollectionsKt.firstOrNull(r127);
        if (r130 == null) goto L44;
        T r131 = r130.getRequestId();
    L45:
        r101.element = r131;
        Iterable r132 = (Iterable) r100.element;
        r113 = new ArrayList();
        Iterator r133 = r132.iterator();
    L47:
        if (r133.hasNext() == false) goto L51;
        String r134 = ((Content) r133.next()).getItemId();
        if (r134 == null) goto L47;
        r113.add(r134);
        goto L47
    L44:
        r131 = 0;
        goto L45
    L52:
        r117 = CollectionsKt.emptyList();
        goto L53
    }

    public static void C3(final ChatAwemeFeedComponent r100, final boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        r100.H3(false, false);
        r100.G3(false);
        if (r100.P == false) goto L8;
    L15:
        LarusPageChatBinding r103 = r100.p3();
        if (r103 == null) goto L20;
        ChatAwemeNestedContainer r104 = r103.f311086b;
        if (r104 == null) goto L20;
        r104.f311475a.abortAnimation();
    L20:
        LarusPageChatBinding r105 = r100.p3();
        if (r105 == null) goto L25;
        ChatAwemeNestedContainer r106 = r105.f311086b;
        if (r106 == null) goto L25;
        r106.a();
    L25:
        LarusPageChatBinding r107 = r100.p3();
        if (r107 == null) goto L34;
        ChatAwemeNestedContainer r108 = r107.f311086b;
        if (r108 == null) goto L35;
        r108.post(new h(r101, r100));
        return;
    L35:
        return;
    L34:
        return;
    L8:
        if (r100.z3().getRevertAlignTopView() == false) goto L15;
        LarusPageChatBinding r109 = r100.p3();
        if (r109 == null) goto L31;
        ChatAwemeNestedContainer r110 = r109.f311086b;
        if (r110 == null) goto L32;
        r110.h(false);
        return;
    L32:
        return;
    }
}
