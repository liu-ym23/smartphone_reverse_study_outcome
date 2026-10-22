package com.larus.bmhome.chat.api;

import android.content.Context;
import android.text.InputFilter;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.v2;
import com.larus.bmhome.chat.component.bottom.core.x2;
import com.larus.bmhome.chat.component.bottom.core.y2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.EditPos;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jæ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u00182\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00132\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0&H\u0096\u0001¢\u0006\u0002\u0010(J\u000b\u0010)\u001a\u0004\u0018\u00010*H\u0096\u0001J\u000b\u0010+\u001a\u0004\u0018\u00010,H\u0096\u0001J\u000b\u0010-\u001a\u0004\u0018\u00010.H\u0096\u0001J\u000b\u0010/\u001a\u0004\u0018\u000100H\u0096\u0001J9\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u0001022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00112\u0018\u00106\u001a\u0014\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u000507H\u0096\u0001Jn\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2$\u0010@\u001a \u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050A2\b\u0010C\u001a\u0004\u0018\u00010\u00112\f\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u001c2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0096\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u0004\u0018\u00010L2\u0006\u00103\u001a\u000204H\u0096\u0001J\u0019\u0010M\u001a\u00020\u00162\u0006\u00103\u001a\u0002042\u0006\u0010N\u001a\u00020OH\u0096\u0001J\u0017\u0010P\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0096\u0001J\u0013\u0010Q\u001a\u00020\u00112\b\u0010R\u001a\u0004\u0018\u00010'H\u0096\u0001J\u000b\u0010S\u001a\u0004\u0018\u00010TH\u0096\u0001J5\u0010U\u001a\u00020\u00052\b\u0010V\u001a\u0004\u0018\u00010E2\b\u0010W\u001a\u0004\u0018\u00010O2\u0006\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020'2\u0006\u0010Z\u001a\u00020'H\u0096\u0001J\t\u0010[\u001a\u00020\u0013H\u0096\u0001JA\u0010\\\u001a\u00020\u00132\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0^2\b\u0010_\u001a\u0004\u0018\u00010B2\u0006\u0010`\u001a\u00020\u00112\b\u0010a\u001a\u0004\u0018\u00010'2\u0006\u0010b\u001a\u00020\u0013H\u0096\u0001J9\u0010c\u001a\u00020\u00132\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0^2\b\u0010_\u001a\u0004\u0018\u00010B2\u0006\u0010`\u001a\u00020\u00112\b\u0010a\u001a\u0004\u0018\u00010'H\u0096\u0001J\u000b\u0010d\u001a\u0004\u0018\u00010eH\u0096\u0001J\t\u0010f\u001a\u00020\u0005H\u0096\u0001J\t\u0010g\u001a\u00020\u0013H\u0096\u0001J\t\u0010h\u001a\u00020\u0013H\u0096\u0001J\u0013\u0010h\u001a\u00020\u00132\b\u0010i\u001a\u0004\u0018\u00010jH\u0096\u0001J\u0013\u0010k\u001a\u00020\u00132\b\u0010l\u001a\u0004\u0018\u00010'H\u0096\u0001J\u000b\u0010m\u001a\u0004\u0018\u00010nH\u0096\u0001J\u000b\u0010o\u001a\u0004\u0018\u00010pH\u0096\u0001J\u000b\u0010q\u001a\u0004\u0018\u00010rH\u0096\u0001JF\u0010s\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0&2*\u0010t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0u0#\"\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0uH\u0096\u0001¢\u0006\u0002\u0010vJC\u0010w\u001a\u00020\u00052\b\u0010x\u001a\u0004\u0018\u00010'2\b\u0010y\u001a\u0004\u0018\u00010'2\b\u0010z\u001a\u0004\u0018\u00010'2\b\u0010l\u001a\u0004\u0018\u00010'2\b\u0010{\u001a\u0004\u0018\u00010'2\u0006\u0010|\u001a\u00020'H\u0096\u0001J\u0011\u0010}\u001a\u00020\u00052\u0006\u0010~\u001a\u00020\u0013H\u0096\u0001J\f\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0096\u0001J\r\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0096\u0001J,\u0010\u0083\u0001\u001a\u00020\u00132\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010l\u001a\u00020'H\u0096A¢\u0006\u0003\u0010\u0086\u0001J.\u0010\u0083\u0001\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010l\u001a\u00020'2\u0007\u0010\u0087\u0001\u001a\u00020\u00132\u0007\u0010\u0088\u0001\u001a\u00020\u0013H\u0096\u0001J\u0014\u0010\u0089\u0001\u001a\u00020\u00132\b\u0010l\u001a\u0004\u0018\u00010'H\u0096\u0001J\u0014\u0010\u008a\u0001\u001a\u00020\u00052\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0096\u0001J\n\u0010\u008d\u0001\u001a\u00020\u0005H\u0096\u0001J\u001d\u0010\u008e\u0001\u001a\u00020\u00052\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u0011H\u0096\u0001J\u001d\u0010\u0092\u0001\u001a\u00020\u00052\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u0011H\u0096\u0001J\u0012\u0010\u0093\u0001\u001a\u00020'2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001¨\u0006\u0094\u0001"}, d2 = {"Lcom/larus/bmhome/chat/api/ILegacyChatUiServiceDelegate;", "Lcom/larus/bmhome/chat/api/ILegacyChatUiService;", "<init>", "()V", "buildFullScreenEditTextView", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "imeHeight", "", "isImmerse", "", "bgImgColor", "voiceInputContent", "", "onClickSend", "Lkotlin/Function1;", "onUpdateInputText", "Lkotlin/Function3;", "onFold", "Lkotlin/Function0;", "inModify", "forceDarkMode", "targetContainer", "Landroid/view/ViewGroup;", "enableSetFullEditBackground", "inputFilters", "", "Landroid/text/InputFilter;", "fullInputBoxMobParams", "", "", "(Landroidx/fragment/app/FragmentActivity;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;Lcom/larus/ui/arch/context/external/VContext;Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;IZLjava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;ZZLandroid/view/ViewGroup;Z[Landroid/text/InputFilter;Ljava/util/Map;)V", "chatSendTrace", "Lcom/larus/bmhome/chat/api/IChatSendTrace;", "containerAppreciableTrace", "Lcom/larus/bmhome/chat/api/IContainerAppreciableTrace;", "conversationFragmentAbility", "Lcom/larus/bmhome/chat/api/IConversationFragmentAbility;", "conversationListModel", "Lcom/larus/bmhome/chat/api/IConversationListModel;", "createAwemeRecommendAdapterForWidget", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "coverWidth", "mobCardShow", "Lkotlin/Function2;", "Lcom/larus/bmhome/video/Content;", "Landroid/view/View;", "createMessageAdapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "msgActionCallback", "Lkotlin/Function4;", "Lcom/larus/im/bean/message/Message;", "immerseBgColor", "hostFragment", "Landroidx/fragment/app/Fragment;", "componentFeature", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "(Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;Lcom/larus/bmhome/chat/ChatParam;Lkotlin/jvm/functions/Function4;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;)Lcom/larus/bmhome/chat/api/MessageAdapter;", "createSearchBoxView", "Lcom/larus/bmhome/chat/api/ISearchListBox;", "getConversationBrief", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "getImgAttachInstructExt", "getSelectIndex", "parentMessageId", "getWidgetCardClickHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/api/WidgetCardClickHelper;", "handleConversationClick", WidgetService.PARAM_FRAGMENT, "data", "enterFrom", "currentPageName", "argPosition", "hasSubBenefitsFromStore", "insertMultiQuestionReference", "extra", "", "message", "searchIndex", "scene", "isReferenceAction", "insertMultiQuestionReferenceFromInstruction", "instructionSwitchHelper", "Lcom/larus/bmhome/instruction/IInstructionSwitch;", "invokeAppletSaveClick", "isContinuousTalk", "isRecording", "adapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "isShowGpt4InputHintAndAnsweringText", "conversationId", "markdownSelectHelper", "Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "messageCellTrace", "Lcom/larus/bmhome/chat/api/IMessageCellTrace;", "messageCopyHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/IMessageCopyHelper;", "messageSendExt", "param", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "mobDeepSearchButtonShoww", "currentPage", "previousPage", "messageId", "botId", "enterMethod", "musicPlayerPausing", "pausing", "observerManager", "Lcom/larus/bmhome/chat/api/ILegacyMessageObserver;", "pluginManagerDelegate", "Lcom/larus/bmhome/chat/auth/api/IPluginManager;", "realtimeCallEnabled", "editPos", "Lcom/larus/platform/model/EditPos;", "(Lcom/larus/platform/model/EditPos;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enableSilence", "isEditable", "shouldCloseInstruction", "startRealtimeCallD", "bean", "Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "stopRecording", "stubMessageList", "viewStub", "Landroid/view/ViewStub;", "id", "stubNestedScrollList", "trackOnClickCallSpeakIcon", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ILegacyChatUiServiceDelegate implements ILegacyChatUiService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ILegacyChatUiServiceDelegate f297164b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILegacyChatUiService f297165a;

    static {
        f297164b = new ILegacyChatUiServiceDelegate();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void A8(b3a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        this.f297165a.A8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Map<String, String> B8() {
        return this.f297165a.B8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean C8(wq8.b r100) {
        return this.f297165a.C8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean D8(String r100) {
        return this.f297165a.D8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final hc8.b E8() {
        return this.f297165a.E8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final z F8() {
        return this.f297165a.F8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void G8() {
        this.f297165a.G8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final cf8.c H8() {
        return this.f297165a.H8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.instruction.i I8() {
        return this.f297165a.I8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final CharSequence J8(Context r100, wh8.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationData");
        return this.f297165a.J8(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final v K8() {
        return this.f297165a.K8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void L8(FragmentActivity r210, BotModel r211, de8.c r212, t1a.b r213, com.larus.bmhome.chat.component.cvs.y r214, int r215, boolean r216, Integer r217, CharSequence r218, v2 r310, x2 r311, y2 r312, boolean r313, boolean r314, ViewGroup r315, boolean r316, InputFilter[] r317, Map r318) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r213, "vContext");
        Intrinsics.checkNotNullParameter(r218, "voiceInputContent");
        Intrinsics.checkNotNullParameter(r310, "onClickSend");
        Intrinsics.checkNotNullParameter(r311, "onUpdateInputText");
        Intrinsics.checkNotNullParameter(r312, "onFold");
        Intrinsics.checkNotNullParameter(r318, "fullInputBoxMobParams");
        this.f297165a.L8(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean M8(Map r100, Message r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        return this.f297165a.M8(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final y N8() {
        return this.f297165a.N8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean O8(Map r100, Message r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        return this.f297165a.O8(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final q0 P8(com.larus.bmhome.chat.deepsearch.component.f r100, ChatParam r110, com.larus.bmhome.chat.deepsearch.component.d r111, com.larus.bmhome.chat.deepsearch.component.e r112, ComponentFeature r113, com.larus.bmhome.chat.deepsearch.component.g r114) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        Intrinsics.checkNotNullParameter(r110, "chatParam");
        Intrinsics.checkNotNullParameter(r111, "msgActionCallback");
        Intrinsics.checkNotNullParameter(r112, "hostFragment");
        Intrinsics.checkNotNullParameter(r113, "componentFeature");
        Intrinsics.checkNotNullParameter(r114, ShortVideoSegments.KEY_PROP_PROVIDER);
        return this.f297165a.P8(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void Q8(ViewStub r100) {
        Intrinsics.checkNotNullParameter(r100, "viewStub");
        this.f297165a.Q8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void R8(Fragment r100, wh8.a r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter("chat_list", "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "currentPageName");
        Intrinsics.checkNotNullParameter(r103, "argPosition");
        this.f297165a.R8(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Map<String, String> S8(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return this.f297165a.S8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void T8(boolean r100) {
        this.f297165a.T8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean U8(String r100) {
        return this.f297165a.U8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final t V8() {
        return this.f297165a.V8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final RecyclerView.Adapter W8(Context r100, int r101, com.larus.bmhome.chat.markdown.ugc.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "mobCardShow");
        return this.f297165a.W8(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.layout.holder.helper.s0 X8() {
        return this.f297165a.X8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final int d(String r100) {
        return this.f297165a.d(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean isRecording() {
        return this.f297165a.isRecording();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean p8() {
        return this.f297165a.p8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean q8() {
        return this.f297165a.q8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final a0 r8() {
        return this.f297165a.r8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final c0 s8(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f297165a.s8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void stopRecording() {
        this.f297165a.stopRecording();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final s t8() {
        return this.f297165a.t8();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final String u8(t1a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        return this.f297165a.u8(r100);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Object v8(EditPos r100, BotModel r101, String r102, Continuation<? super Boolean> r103) {
        return this.f297165a.v8(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void w8(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter("feedback", "enterMethod");
        this.f297165a.w8(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void x8(ViewStub r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewStub");
        this.f297165a.x8(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean y8(BotModel r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        return this.f297165a.y8(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final w z8() {
        return this.f297165a.z8();
    }

    private ILegacyChatUiServiceDelegate() {
        ILegacyChatUiService r100 = (ILegacyChatUiService) ServiceManager.get().getService(ILegacyChatUiService.class);
        if (r100 != null) goto L5;
        r100 = ILegacyChatUiServiceEmpty.f297166a;
    L5:
        this.f297165a = r100;
    }
}
