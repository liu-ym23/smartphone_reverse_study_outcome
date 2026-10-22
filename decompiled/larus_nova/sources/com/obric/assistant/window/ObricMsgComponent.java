package com.obric.assistant.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.view.WindowFadingLayout;
import com.obric.assistant.window.materials.MaterialSceneType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\b\u008d\u0001\u0099\u0001\u009c\u0001\u009f\u0001\u0018\u0000 Î\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002Î\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0095\u0001\u001a\u00030\u0091\u0001H\u0002J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\n\u0010¡\u0001\u001a\u00030\u0097\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030\u0097\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010¤\u0001\u001a\u00030\u0097\u00012\u0007\u0010¥\u0001\u001a\u00020mH\u0002J\u0017\u0010¦\u0001\u001a\u00030\u0097\u00012\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u00010mH\u0002J\u0014\u0010§\u0001\u001a\u00030\u0097\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010«\u0001\u001a\u00030\u0097\u00012\u0007\u0010¬\u0001\u001a\u00020RH\u0016J\n\u0010\u00ad\u0001\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010®\u0001\u001a\u00030\u0097\u00012\u0007\u0010¬\u0001\u001a\u00020RH\u0002J\u0013\u0010¯\u0001\u001a\u00030\u0097\u00012\u0007\u0010¬\u0001\u001a\u00020RH\u0002J\u0015\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\u0007\u0010¬\u0001\u001a\u00020RH\u0002J\n\u0010²\u0001\u001a\u00030\u0097\u0001H\u0016J&\u0010³\u0001\u001a\u00030\u0097\u00012\u0007\u0010´\u0001\u001a\u00020C2\u0007\u0010¬\u0001\u001a\u00020R2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0016J\t\u0010·\u0001\u001a\u00020\u000bH\u0002J\t\u0010¸\u0001\u001a\u00020\u000bH\u0002J\t\u0010¹\u0001\u001a\u00020\u000bH\u0002J\t\u0010º\u0001\u001a\u00020\u000bH\u0002J\u0015\u0010»\u0001\u001a\u00030\u0097\u00012\t\b\u0002\u0010¼\u0001\u001a\u00020qH\u0002J\n\u0010½\u0001\u001a\u00030\u0097\u0001H\u0016J\n\u0010¾\u0001\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010¿\u0001\u001a\u00030\u0097\u00012\u0007\u0010À\u0001\u001a\u00020\u0003H\u0016J\u0015\u0010Á\u0001\u001a\u00030\u0097\u00012\t\u0010Â\u0001\u001a\u0004\u0018\u00010mH\u0002J\n\u0010Ã\u0001\u001a\u00030\u0097\u0001H\u0002J\n\u0010Ä\u0001\u001a\u00030\u0097\u0001H\u0016J\n\u0010Å\u0001\u001a\u00030\u0097\u0001H\u0016J\u0016\u0010Æ\u0001\u001a\u00030\u0097\u00012\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\u0013\u0010Ç\u0001\u001a\u00030\u0097\u00012\u0007\u0010È\u0001\u001a\u00020qH\u0016J\u0014\u0010É\u0001\u001a\u00030\u0097\u00012\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0016J\n\u0010Ì\u0001\u001a\u00030Í\u0001H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0015\u001a\u0004\b;\u0010<R\u0016\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u001d\u0010B\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0015\u001a\u0004\bD\u0010ER\u001d\u0010G\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u0015\u001a\u0004\bI\u0010JR\u001d\u0010L\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0015\u001a\u0004\bN\u0010OR\u001d\u0010Q\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0015\u001a\u0004\bS\u0010TR\u0016\u0010V\u001a\u0004\u0018\u00010M8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010OR\u001d\u0010X\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0015\u001a\u0004\bY\u0010OR\u0016\u0010[\u001a\u0004\u0018\u00010\\8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0016\u0010_\u001a\u0004\u0018\u00010`8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0016\u0010c\u001a\u0004\u0018\u00010C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010ER\u0016\u0010e\u001a\u0004\u0018\u00010C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010ER\u001d\u0010g\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u0015\u001a\u0004\bh\u0010TR\u0016\u0010j\u001a\u0004\u0018\u00010R8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010TR\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020qX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020qX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\b\u0012\u0002\b\u0003\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020vX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010w\u001a\u00020x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u0015\u001a\u0004\by\u0010zR\u001c\u0010|\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\r\n\u0005\b\u0080\u0001\u0010\u0015\u001a\u0004\b~\u0010\u007fR\u0018\u0010\u0081\u0001\u001a\u00030\u0082\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0087\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008b\u0001\u0010\u0015\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0013\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008e\u0001R\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0013\u0010\u0098\u0001\u001a\u00030\u0099\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009a\u0001R\u0013\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001R\u0013\u0010\u009e\u0001\u001a\u00030\u009f\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010 \u0001¨\u0006Ï\u0001"}, d2 = {"Lcom/obric/assistant/window/ObricMsgComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lcom/obric/assistant/window/ability/IObricMsgAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "Lcom/obric/assistant/ability/chat/messagelist/IObricMessageListAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "Lkotlin/Lazy;", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "topFloatingButtonAbility", "Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "getTopFloatingButtonAbility", "()Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "topFloatingButtonAbility$delegate", "bottomFloatingButtonAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getBottomFloatingButtonAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "bottomFloatingButtonAbility$delegate", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "shareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "shareAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "splitter", "Landroid/view/View;", "getSplitter", "()Landroid/view/View;", "splitter$delegate", "bottomLayout", "getBottomLayout", "messageListParent", "getMessageListParent", "messageListParent$delegate", "fastButtonIcon", "Landroid/widget/ImageView;", "getFastButtonIcon", "()Landroid/widget/ImageView;", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "actionBarContainer", "getActionBarContainer", "inputAreaContainer", "getInputAreaContainer", "inputAreaContainerBg", "getInputAreaContainerBg", "inputAreaContainerBg$delegate", "shareLayout", "getShareLayout", "messageObserverConversationId", "", "messageListBottomMargin", "lastMessageListWidth", "isVisibleMessageBoxWidthUpdatePending", "", "pendingRefreshVisibleCardsOnAdapterChanged", "observedMessageListAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "latestKnownServerIndex", "", "portraitMessageListStrategy", "Lcom/obric/assistant/window/strategies/PortraitMessageListStrategy;", "getPortraitMessageListStrategy", "()Lcom/obric/assistant/window/strategies/PortraitMessageListStrategy;", "portraitMessageListStrategy$delegate", "landscapeMessageListStrategy", "Lcom/obric/assistant/window/strategies/LandscapeMessageListStrategy;", "getLandscapeMessageListStrategy", "()Lcom/obric/assistant/window/strategies/LandscapeMessageListStrategy;", "landscapeMessageListStrategy$delegate", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/obric/assistant/window/strategies/api/BaseMessageListStrategy;", "getStrategy", "()Lcom/obric/assistant/window/strategies/api/BaseMessageListStrategy;", "maxRadius", "", "messageListTopFading", "Lcom/obric/assistant/view/WindowFadingLayout;", "getMessageListTopFading", "()Lcom/obric/assistant/view/WindowFadingLayout;", "messageListTopFading$delegate", "messageChildAttachListener", "com/obric/assistant/window/ObricMsgComponent$messageChildAttachListener$1", "Lcom/obric/assistant/window/ObricMsgComponent$messageChildAttachListener$1;", "autoIncreaseHelperBinding", "autoIncreaseHelperDelegate", "Lcom/obric/assistant/window/animation/ObricPageAutoIncreaseHelper;", "autoIncreaseHelper", "getAutoIncreaseHelper", "()Lcom/obric/assistant/window/animation/ObricPageAutoIncreaseHelper;", "createAutoIncreaseHelper", "recreateAutoIncreaseHelperIfNeeded", "", "messageListAdapterObserver", "com/obric/assistant/window/ObricMsgComponent$messageListAdapterObserver$1", "Lcom/obric/assistant/window/ObricMsgComponent$messageListAdapterObserver$1;", "selectModeCallback", "com/obric/assistant/window/ObricMsgComponent$selectModeCallback$1", "Lcom/obric/assistant/window/ObricMsgComponent$selectModeCallback$1;", "changeListener", "com/obric/assistant/window/ObricMsgComponent$changeListener$1", "Lcom/obric/assistant/window/ObricMsgComponent$changeListener$1;", "hideBackToLastViewedButton", "ensureMessageListAdapterObserver", "unregisterMessageListAdapterObserver", "consumePendingRefreshVisibleCards", "enterMethod", "updateItemOnDisplay", "checkCloseClickTalk", "msg", "Lcom/larus/im/bean/message/Message;", WidgetCostModule.TYPE_ON_CREATE, "onViewCreated", "view", "scheduleUpdateVisibleMessageBoxWidth", "scheduleUpdateMessageBoxWidth", "updateMessageBoxWidth", "findMessageBox", "Lcom/larus/bmhome/chat/layout/item/BaseMessageBox;", "initMessageList", "setLatestMessageBottomInset", "parent", "outRect", "Landroid/graphics/Rect;", "getInputAreaContainerVerticalPadding", "getActionBarContainerHeight", "getInputAreaContainerBgHeight", "getShareLayoutOccupiedHeight", "updateShareLayoutBottomMargin", "isSelectMode", "invalidateLatestMessageBottomInset", LiveCommonConstants.REASON_ON_DEDTROY, "onChange", "new", "initLatestKnownServerIndex", "conversationId", "unregisterMessageObserver", "addItemDecoration", "interruptMoveAction", "onSendMessage", "onChatStyleChanged", "isChatWindow", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "getAutoDismissDelegate", "Lcom/obric/assistant/util/IAutoDismissDelegate;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMsgComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e>, IObserveToken, xha.b, hca.b, saa.a {
    public static final /* synthetic */ int T = 0;
    public final Lazy A;
    public final Lazy B;
    public String C;
    public final int D;
    public int E;
    public boolean F;
    public boolean G;
    public RecyclerView.Adapter<?> H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f394504J;
    public final Lazy K;
    public final float L;
    public final Lazy M;
    public final ObricMsgComponent$messageChildAttachListener$1 N;
    public va8.l O;
    public yha.t P;
    public final ObricMsgComponent$messageListAdapterObserver$1 Q;
    public final b R;
    public final ObricMsgComponent$changeListener$1 S;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f394505m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f394506n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f394507o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f394508p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f394509q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f394510r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f394511s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f394512t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f394513u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f394514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f394515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f394516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f394517y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f394518z;

    public static final class a {
    }

    public static final class b implements hca.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricMsgComponent f394519a;

        public b(ObricMsgComponent r100) {
            this.f394519a = r100;
        }

        @Override // hca.e
        public final void onSelectModeChanged(boolean r100) {
            ObricMsgComponent r101 = this.f394519a;
            int r102 = ObricMsgComponent.T;
            r101.H3(r100);
            this.f394519a.P00();
            com.obric.assistant.util.p r103 = this.f394519a.h3().f567653c;
            r103.getClass();
            FLogger.f375446a.i("AutoDismissDelegate", "onMessageSelectModeChanged active:" + r100);
            com.obric.assistant.util.p.u(r103, ObricInteractionStateType.MESSAGE_SELECT_MODE_ACTIVE, r100);
        }
    }

    public static final class c implements Function0<com.larus.bmhome.chat.component.cvs.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394520a;

        public c(AttachReceiver r100) {
            this.f394520a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.cvs.y invoke() {
            AttachReceiver r100 = this.f394520a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class d implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394523a;

        public d(AttachReceiver r100) {
            this.f394523a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f394523a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class e implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394524a;

        public e(AttachReceiver r100) {
            this.f394524a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f394524a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class f implements Function0<maa.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394525a;

        public f(AttachReceiver r100) {
            this.f394525a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [maa.e, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final maa.e invoke() {
            AttachReceiver r100 = this.f394525a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class g implements Function0<laa.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394526a;

        public g(AttachReceiver r100) {
            this.f394526a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.j, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.j invoke() {
            AttachReceiver r100 = this.f394526a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class h implements Function0<va8.w> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394527a;

        public h(AttachReceiver r100) {
            this.f394527a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.w] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.w invoke() {
            AttachReceiver r100 = this.f394527a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.w.class));
        }
    }

    public static final class i implements Function0<ld8.n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394528a;

        public i(AttachReceiver r100) {
            this.f394528a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ld8.n, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ld8.n invoke() {
            AttachReceiver r100 = this.f394528a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ld8.n.class));
        }
    }

    public static final class j implements Function0<va8.o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394530a;

        public j(AttachReceiver r100) {
            this.f394530a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.o] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.o invoke() {
            AttachReceiver r100 = this.f394530a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class k implements Function0<IChatMessageShareAbility> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394531a;

        public k(AttachReceiver r100) {
            this.f394531a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.share.IChatMessageShareAbility, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final IChatMessageShareAbility invoke() {
            AttachReceiver r100 = this.f394531a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(IChatMessageShareAbility.class));
        }
    }

    static {
    }

    @Override // hca.b
    public final void r2(boolean r100) {
    }

    public final WindowFadingLayout B3() {
        return (WindowFadingLayout) this.M.getValue();
    }

    public final void D3() {
        this.I = Long.MIN_VALUE;
        String r100 = this.C;
        if (r100 != null) goto L5;
        return;
    L5:
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r100, this.S);
        this.C = null;
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [com.obric.assistant.window.m] */
    @Override // xha.b
    public final void Gi() {
        FLogger.f375446a.i("ObricMsgComponent", "init message list");
        FrameLayout r100 = (FrameLayout) this.A.getValue();
        if (r100 == null) goto L12;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L11;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        r102.topToBottom = R.id.obric_top_view;
        r102.bottomToBottom = 0;
        r102.bottomToTop = -1;
        FrameLayout r103 = (FrameLayout) this.A.getValue();
        if (r103 == null) goto L9;
        r103.setLayoutParams(r102);
    L9:
        r100.setLayoutParams(r102);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L12:
        View r104 = (View) this.f394518z.getValue();
        if (r104 == null) goto L19;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L18;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        r106.topToTop = 0;
        r106.topToBottom = -1;
        r106.bottomToTop = R.id.input;
        r106.verticalChainStyle = 2;
        r106.verticalBias = 1.0f;
        r104.setLayoutParams(r106);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L19:
        final RecyclerView r107 = z3();
        if (r107 != null) goto L22;
        return;
    L22:
        ViewParent r108 = r107.getParent();
        ImageView r109 = null;
        if ((r108 instanceof ViewGroup) == false) goto L25;
        ViewGroup r110 = (ViewGroup) r108;
    L26:
        if (r110 != null) goto L29;
        return;
    L29:
        if (Intrinsics.areEqual(r110, B3()) == true) goto L31;
        int r111 = r110.indexOfChild(r107);
        ViewGroup.LayoutParams r112 = r107.getLayoutParams();
        r110.removeView(r107);
        B3().removeAllViews();
        B3().addView(r107, new FrameLayout.LayoutParams(-1, -1));
        r110.addView(B3(), r111, r112);
    L31:
        WindowFadingLayout r113 = B3();
        int r114 = aia.f.f3866a;
        r113.setBottomFadeHeight(c7.b(132));
        ViewParent r115 = B3().getParent();
        if ((r115 instanceof ViewGroup) == false) goto L34;
        ViewGroup r116 = (ViewGroup) r115;
    L36:
        if (r116 == null) goto L38;
        r116.setPadding(r116.getPaddingLeft(), r116.getPaddingTop(), r116.getPaddingRight(), c7.b(16));
    L38:
        WindowFadingLayout r117 = B3();
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L50;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        r119.topMargin = c7.b(16);
        r117.setLayoutParams(r119);
        final ?? r120 = new m(this, r107);
        r107.addOnScrollListener(new ObricMsgComponent$initMessageList$5(r120));
        r107.addOnLayoutChangeListener(new n(r120));
        r107.post(new p(this, r107));
        ld8.n r121 = (ld8.n) this.f394512t.getValue();
        if (r121 == null) goto L43;
        r109 = r121.G50();
    L43:
        if (r109 == null) goto L45;
        Lazy r122 = bia.g.f19194a;
        bia.g.a(r109, true, MaterialSceneType.FLOATING_BG);
    L45:
        RecyclerView r123 = z3();
        if (r123 == null) goto L51;
        r123.setVerticalScrollBarEnabled(false);
        return;
    L51:
        return;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        r116 = null;
        goto L36
    L25:
        r110 = null;
        goto L26
    }

    public final yha.t h3() {
        yha.t r100 = this.P;
        if (r100 != null) goto L6;
        va8.l r101 = m3();
        this.O = r101;
        yha.t r102 = new yha.t(r101, (laa.d) this.f394507o.getValue(), new com.obric.assistant.window.d(this), new o(this));
        this.P = r102;
        return r102;
    L6:
        return r100;
    }

    public final va8.l m3() {
        va8.m r100 = (va8.m) this.f394508p.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.iX();
    }

    public final va8.c p3() {
        va8.o r100 = (va8.o) this.f394513u.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Uv();
    }

    public final RecyclerView z3() {
        return (RecyclerView) this.f394516x.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v41, types: [com.obric.assistant.window.ObricMsgComponent$messageChildAttachListener$1] */
    /* JADX WARN: Type inference failed for: r0v42, types: [com.obric.assistant.window.ObricMsgComponent$messageListAdapterObserver$1] */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.obric.assistant.window.ObricMsgComponent$changeListener$1] */
    public ObricMsgComponent() {
        this.f394505m = R.id.message_list_parent;
        this.f394506n = LazyKt.lazy(new c(this));
        this.f394507o = LazyKt.lazy(new d(this));
        this.f394508p = LazyKt.lazy(new e(this));
        this.f394509q = LazyKt.lazy(new f(this));
        this.f394510r = LazyKt.lazy(new g(this));
        this.f394511s = LazyKt.lazy(new h(this));
        this.f394512t = LazyKt.lazy(new i(this));
        this.f394513u = LazyKt.lazy(new j(this));
        this.f394514v = LazyKt.lazy(new k(this));
        this.f394515w = LazyKt.lazy(new u(this));
        this.f394516x = LazyKt.lazy(new v(this));
        this.f394517y = LazyKt.lazy(new w(this));
        this.f394518z = LazyKt.lazy(new x(this));
        this.A = LazyKt.lazy(new com.obric.assistant.window.e(this));
        this.B = LazyKt.lazy(new com.obric.assistant.window.f(this));
        this.D = i5.J();
        this.I = Long.MIN_VALUE;
        this.f394504J = LazyKt.lazy(new com.obric.assistant.window.g(this));
        this.K = LazyKt.lazy(new com.obric.assistant.window.h(this));
        this.L = i5.Q();
        this.M = LazyKt.lazy(new com.obric.assistant.window.i(this));
        this.N = new ObricMsgComponent$messageChildAttachListener$1(this);
        this.Q = new ObricMsgComponent$messageListAdapterObserver$1(this);
        this.R = new b(this);
        this.S = new ObricMsgComponent$changeListener$1(this);
    }

    public final void E3() {
        RecyclerView r100 = z3();
        if (r100 == null) goto L44;
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L48;
        RecyclerView r102 = z3();
        LinearLayoutManager r103 = null;
        if (r102 == null) goto L10;
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
    L12:
        if ((r104 instanceof LinearLayoutManager) == false) goto L14;
        r103 = (LinearLayoutManager) r104;
    L14:
        if (r103 != null) goto L16;
        return;
    L16:
        int r105 = r103.findFirstVisibleItemPosition();
        int r106 = r103.findLastVisibleItemPosition();
        if (r105 == (-1)) goto L45;
        if (r106 == (-1)) goto L49;
        boolean r107 = false;
        IntRange r108 = RangesKt.until(0, r101.getItemCount());
        if (r105 > r106) goto L46;
        int r109 = r108.getFirst();
        if (r105 > r108.getLast()) goto L26;
        if (r109 > r105) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L47;
        int r111 = r108.getFirst();
        if (r106 > r108.getLast()) goto L32;
        if (r111 > r106) goto L32;
        boolean r112 = true;
    L33:
        if (r112 == false) goto L50;
        RecyclerView r113 = z3();
        if (r113 != null) goto L38;
    L40:
        if (r107 == false) goto L42;
        return;
    L42:
        r101.notifyItemRangeChanged(r105 + 1, r106 - r105);
        return;
    L38:
        if (r113.isComputingLayout() != true) goto L40;
        r107 = true;
        goto L40
    L50:
        return;
    L32:
        r112 = false;
        goto L33
    L47:
        return;
    L26:
        r110 = false;
        goto L27
    L46:
        return;
    L49:
        return;
    L45:
        return;
    L10:
        r104 = null;
        goto L12
    L48:
        return;
    }

    @Override // xha.b
    public final void P00() {
        RecyclerView r100 = z3();
        if (r100 == null) goto L6;
        r100.post(new com.obric.assistant.window.j(this));
        return;
    }

    public final void Y2() {
        RecyclerView r100 = z3();
        if (r100 == null) goto L14;
        RecyclerView.Adapter<?> r101 = r100.getAdapter();
        if (r101 == null) goto L15;
        RecyclerView.Adapter<?> r102 = this.H;
        if (r102 != r101) goto L10;
        return;
    L10:
        if (r102 == null) goto L12;
        r102.unregisterAdapterDataObserver(this.Q);
    L12:
        this.H = r101;
        r101.registerAdapterDataObserver(this.Q);
        return;
    L15:
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        super.onCreate();
        com.larus.bmhome.chat.component.cvs.y r100 = (com.larus.bmhome.chat.component.cvs.y) this.f394506n.getValue();
        if (r100 == null) goto L5;
        String r101 = r100.Y1();
    L6:
        C3(r101);
        com.larus.bmhome.chat.component.cvs.y r102 = (com.larus.bmhome.chat.component.cvs.y) this.f394506n.getValue();
        if (r102 == null) goto L9;
        com.larus.bmhome.chat.component.cvs.y.b.b(r102, this);
    L9:
        IAssistantInteractionServiceKt.getInteractionStateService().setAutoIncreaseWindowObserver(this, new q(this));
        laa.d r103 = (laa.d) this.f394507o.getValue();
        if (r103 == null) goto L12;
        r103.HU(this);
    L12:
        IChatMessageShareAbility r104 = (IChatMessageShareAbility) this.f394514v.getValue();
        if (r104 == null) goto L16;
        r104.kN(this.R);
        return;
    L16:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        D3();
        com.larus.bmhome.chat.component.cvs.y r100 = (com.larus.bmhome.chat.component.cvs.y) this.f394506n.getValue();
        if (r100 == null) goto L5;
        r100.lQ(this);
    L5:
        IAssistantInteractionServiceKt.getInteractionStateService().removeAutoIncreaseWindowObserver(this);
        laa.d r101 = (laa.d) this.f394507o.getValue();
        if (r101 == null) goto L8;
        r101.AN(this);
    L8:
        IChatMessageShareAbility r102 = (IChatMessageShareAbility) this.f394514v.getValue();
        if (r102 == null) goto L11;
        r102.cG(this.R);
    L11:
        RecyclerView r103 = z3();
        if (r103 == null) goto L14;
        r103.removeOnChildAttachStateChangeListener(this.N);
    L14:
        RecyclerView.Adapter<?> r104 = this.H;
        if (r104 == null) goto L17;
        r104.unregisterAdapterDataObserver(this.Q);
    L17:
        this.H = null;
        yha.t r105 = this.P;
        if (r105 == null) goto L20;
        r105.j();
    L20:
        this.O = null;
        this.P = null;
    }

    @Override // xha.b
    public final void ti() {
        h3();
        FLogger.f375446a.i("ObricPageAutoIncreaseHelper", "interruptMoveAction");
    }

    @Override // xha.b
    public final yha.t u30() {
        return h3();
    }

    @Override // xha.b
    public final void yg() {
        yha.t r100 = h3();
        if (r100.f567654d != Long.MAX_VALUE) goto L5;
        r100.f567654d = xg9.b.a().getLong("last_msg_create_time", Long.MAX_VALUE);
    L5:
        r100.w();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f394505m;
    }

    public final void C3(String r100) {
        this.I = Long.MIN_VALUE;
        MessageApiImpl r101 = MessageApiImpl.f386895a;
        Message r102 = MessageApiImpl.c();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
    L9:
        Long r103 = Long.valueOf(r102.getServerIndex());
        if (r103.longValue() == (-1)) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L19;
        this.I = r103.longValue();
        return;
    L19:
        return;
    L12:
        r104 = false;
        goto L13
    L7:
        if (Intrinsics.areEqual(r102.getConversationId(), r100) == true) goto L9;
    }

    @Override // xha.b
    public final void F1(Message r100) {
        h3().q(null);
    }

    public final void G3(View r100) {
        com.larus.bmhome.chat.layout.item.i r101 = null;
        if ((r100 instanceof AbstractMessageBoxContainerView) == false) goto L5;
        AbstractMessageBoxContainerView r102 = (AbstractMessageBoxContainerView) r100;
    L6:
        if (r102 == null) goto L13;
        View r103 = r102.getBoxView();
        if (r103 == null) goto L13;
        if ((r103 instanceof com.larus.bmhome.chat.layout.item.i) == false) goto L15;
        r101 = (com.larus.bmhome.chat.layout.item.i) r103;
    L15:
        if (r101 != null) goto L18;
        return;
    L18:
        if (s1a.a.d(this) == false) goto L20;
        eia.o r104 = (dia.c) this.K.getValue();
    L21:
        r104.c(r101);
        return;
    L20:
        r104 = (dia.g) this.f394504J.getValue();
    L13:
        if ((r100 instanceof com.larus.bmhome.chat.layout.item.i) == false) goto L15;
        r101 = (com.larus.bmhome.chat.layout.item.i) r100;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public final void H3(boolean r100) {
        if (s1a.a.e(this) == true) goto L5;
        return;
    L5:
        ViewGroup r101 = (ViewGroup) this.f394515w.getValue();
        ViewGroup.MarginLayoutParams r102 = null;
        if (r101 == null) goto L12;
        View r103 = r101.findViewById(R.id.share_layout);
        if (r103 == null) goto L12;
        if ((r103 instanceof ViewStub) == true) goto L12;
    L13:
        if (r103 != null) goto L15;
        return;
    L15:
        boolean r104 = false;
        if (r100 == false) goto L22;
        int r105 = aia.d.f3864a;
        ViewGroup r106 = (ViewGroup) this.f394515w.getValue();
        va8.l r107 = m3();
        if (r107 == null) goto L20;
        FrameLayout r108 = r107.z8();
    L21:
        int r109 = RangesKt.coerceAtLeast(aia.d.a(r106, r108), 56);
    L23:
        ViewGroup.LayoutParams r110 = r103.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
    L27:
        if (r111 != null) goto L29;
    L31:
        if (r104 == false) goto L33;
        return;
    L33:
        ViewGroup.LayoutParams r112 = r103.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L36;
        r102 = (ViewGroup.MarginLayoutParams) r112;
    L36:
        if (r102 != null) goto L38;
        return;
    L38:
        r102.bottomMargin = r109;
        r103.setLayoutParams(r102);
        return;
    L29:
        if (r111.bottomMargin != r109) goto L31;
        r104 = true;
        goto L31
    L26:
        r111 = null;
        goto L27
    L20:
        r108 = null;
        goto L21
    L22:
        r109 = 0;
    L12:
        r103 = null;
        goto L13
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f394505m = r100;
    }

    @Override // com.larus.bmhome.chat.component.cvs.y.a
    public final void c(wc9.e r100) {
        wc9.e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "new");
        if (ic8.n.v(r101) == true) goto L5;
        D3();
        return;
    L5:
        if (Intrinsics.areEqual(this.C, r101.f559198a) == true) goto L11;
        D3();
        C3(r101.f559198a);
        com.larus.im.d.e().registerOnMessageChangedObserver(r101.f559198a, this.S);
        this.C = r101.f559198a;
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricMsgComponent", "onViewCreated, " + hashCode());
        yha.t r102 = this.P;
        if (r102 != null) goto L5;
    L7:
        va8.l r103 = this.O;
        if (r102 == null) goto L10;
        r102.j();
    L10:
        va8.l r104 = m3();
        this.O = r104;
        this.P = new yha.t(r104, (laa.d) this.f394507o.getValue(), new com.obric.assistant.window.d(this), new o(this));
        StringBuilder r105 = new StringBuilder("recreateAutoIncreaseHelperIfNeeded, previousBinding=");
        r105.append(r103);
        r105.append(", currentBinding=");
        r105.append(this.O);
        r105.append(", messageList=");
        va8.l r106 = this.O;
        if (r106 == null) goto L13;
        RecyclerView r107 = r106.getMessageList();
    L14:
        r105.append(r107);
        r101.i("ObricMsgComponent", r105.toString());
    L15:
        Y2();
        RecyclerView r108 = z3();
        if (r108 == null) goto L18;
        r108.addOnChildAttachStateChangeListener(this.N);
    L18:
        RecyclerView r109 = z3();
        if (r109 == null) goto L21;
        r109.addOnLayoutChangeListener(new t(this));
    L21:
        RecyclerView r110 = z3();
        if (r110 != null) goto L25;
        return;
    L25:
        if (this.F == true) goto L30;
        this.F = true;
        r110.post(new l(this));
        return;
    L30:
        return;
    L13:
        r107 = null;
        goto L14
    L5:
        if (this.O == null) goto L7;
        goto L7
    }

    @Override // hca.b
    public final void x1(ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
        Intrinsics.checkNotNullParameter(r100, "pageState");
        yha.t r101 = h3();
        Intrinsics.checkNotNullParameter(r100, "pageState");
        r101.f567653c.o(r100);
        ObricFloatChatPageData.Companion.getClass();
        if ((r100 instanceof vda.a) == false) goto L5;
    L12:
        h3().v("");
        return;
    L5:
        if ((r100 instanceof vda.b) == false) goto L9;
        if (ObricFloatChatPageData.a.e(r100) == true) goto L12;
    L9:
        if ((r100 instanceof vda.d) == true) goto L12;
        if ((r100 instanceof vda.f) == true) goto L12;
    }

    @Override // saa.a
    public final void wM(ViewGroup r100, View r101, Rect r110) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r110, "outRect");
        if ((r100 instanceof RecyclerView) == true) goto L6;
        return;
    L6:
        if (((RecyclerView) r100).getChildAdapterPosition(r101) == 0) goto L8;
        return;
    L8:
        if (s1a.a.d(this) == true) goto L10;
        int r102 = this.D;
    L11:
        IChatMessageShareAbility r103 = (IChatMessageShareAbility) this.f394514v.getValue();
        boolean r104 = true;
        if (r103 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        ConstraintLayout r106 = null;
        ViewGroup.MarginLayoutParams r107 = null;
        if (r105 == false) goto L62;
        ViewGroup r108 = (ViewGroup) this.f394515w.getValue();
        if (r108 == null) goto L26;
        View r109 = r108.findViewById(R.id.share_layout);
        if (r109 == null) goto L26;
        if ((r109 instanceof ViewStub) == true) goto L26;
    L27:
        if (r109 != null) goto L30;
    L34:
        int r111 = 0;
    L130:
        if (r105 == true) goto L133;
        int r112 = aia.f.f3866a;
        r111 = RangesKt.coerceAtLeast(((r102 + r111) + 56) - c7.b(16), 0);
    L133:
        r110.bottom = r111;
        return;
    L30:
        if (r109.getVisibility() != 0) goto L32;
        boolean r113 = true;
    L33:
        if (r113 == false) goto L34;
        Integer r114 = Integer.valueOf(r109.getHeight());
        if (r114.intValue() <= 0) goto L38;
        boolean r115 = true;
    L39:
        if (r115 == true) goto L42;
        r114 = null;
    L42:
        if (r114 != null) goto L52;
        r114 = Integer.valueOf(r109.getMeasuredHeight());
        if (r114.intValue() > 0) goto L48;
        r104 = false;
    L48:
        if (r104 == true) goto L51;
        r114 = null;
    L51:
        if (r114 != null) goto L52;
        int r116 = 0;
    L54:
        ViewGroup.LayoutParams r117 = r109.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L57;
        r107 = (ViewGroup.MarginLayoutParams) r117;
    L57:
        if (r107 == null) goto L59;
        int r118 = r107.bottomMargin;
    L60:
        r111 = r116 + r118;
        goto L130
    L59:
        r118 = 0;
    L52:
        r116 = r114.intValue();
        goto L54
    L38:
        r115 = false;
        goto L39
    L32:
        r113 = false;
    L26:
        r109 = null;
        goto L27
    L62:
        if (s1a.a.d(this) == true) goto L94;
        va8.c r119 = p3();
        if (r119 == null) goto L67;
        GradientMaskView r120 = ((com.larus.bmhome.chat.component.bottom.core.a) r119).a();
    L68:
        if (r120 == null) goto L94;
        if (r120.getVisibility() != 0) goto L73;
        boolean r121 = true;
    L74:
        if (r121 == false) goto L94;
        Integer r122 = Integer.valueOf(r120.getHeight());
        if (r122.intValue() <= 0) goto L79;
        boolean r123 = true;
    L80:
        if (r123 == true) goto L83;
        r122 = null;
    L83:
        if (r122 == null) goto L85;
        int r124 = r122.intValue();
    L95:
        View r125 = (View) this.B.getValue();
        if (r125 != null) goto L99;
    L122:
        int r126 = 0;
    L123:
        int r127 = r124 + r126;
        va8.c r128 = p3();
        if (r128 == null) goto L126;
        r106 = ((com.larus.bmhome.chat.component.bottom.core.a) r128).h();
    L126:
        if (r106 != null) goto L128;
        int r129 = 0;
    L129:
        r111 = r129 + r127;
        goto L130
    L128:
        r129 = r106.getPaddingTop() + r106.getPaddingBottom();
        goto L129
    L99:
        if (r125.getVisibility() != 0) goto L101;
        boolean r130 = true;
    L102:
        if (r130 == false) goto L122;
        Integer r131 = Integer.valueOf(r125.getHeight());
        if (r131.intValue() <= 0) goto L107;
        boolean r132 = true;
    L108:
        if (r132 == true) goto L111;
        r131 = null;
    L111:
        if (r131 == null) goto L113;
        r126 = r131.intValue();
        goto L123
    L113:
        Integer r133 = Integer.valueOf(r125.getMeasuredHeight());
        if (r133.intValue() > 0) goto L117;
        r104 = false;
    L117:
        if (r104 == true) goto L120;
        r133 = null;
    L120:
        if (r133 == null) goto L122;
        r126 = r133.intValue();
        goto L123
    L107:
        r132 = false;
        goto L108
    L101:
        r130 = false;
        goto L102
    L85:
        Integer r134 = Integer.valueOf(r120.getMeasuredHeight());
        if (r134.intValue() <= 0) goto L88;
        boolean r135 = true;
    L89:
        if (r135 == true) goto L92;
        r134 = null;
    L92:
        if (r134 == null) goto L94;
        r124 = r134.intValue();
        goto L95
    L88:
        r135 = false;
        goto L89
    L79:
        r123 = false;
        goto L80
    L73:
        r121 = false;
        goto L74
    L67:
        r120 = null;
    L94:
        r124 = 0;
        goto L95
    L14:
        if (r103.H1() != true) goto L16;
        r105 = true;
        goto L17
    L10:
        int r136 = aia.f.f3866a;
        r102 = c7.b(4);
        goto L11
    }
}
