package com.obric.assistant.spi.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;
import ot8.a;
import wc9.e;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J#\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0001JH\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\u001b\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0005H\u0096\u0001J\u001b\u0010$\u001a\u00020 2\b\b\u0001\u0010%\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0005H\u0096\u0001J\t\u0010&\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u000fH\u0096\u0001J!\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u001dH\u0096\u0001J\u001b\u00101\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u00103\u001a\u00020\u000fH\u0096\u0001J\u000b\u00104\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u0011\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0096\u0001J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u000109H\u0096\u0001J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000109H\u0096\u0001J\u0011\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020=H\u0096\u0001J\u0019\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\fH\u0096\u0001J3\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010\u001d2\u0006\u0010C\u001a\u000207H\u0096\u0001J\u0013\u0010D\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010E\u001a\u00020\u0005H\u0096\u0001J\u0018\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\"H\u0096\u0001¢\u0006\u0002\u0010GJ\t\u0010H\u001a\u00020\u0005H\u0096\u0001J\t\u0010I\u001a\u00020\u0005H\u0096\u0001J\t\u0010J\u001a\u00020\u0005H\u0096\u0001J\t\u0010K\u001a\u00020\u0005H\u0096\u0001J9\u0010L\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010Q2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\u0018\u0010R\u001a\u0004\u0018\u00010\u000f2\u0006\u0010S\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0002\u0010TJ\u0011\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010W\u001a\u00020 2\u0006\u0010V\u001a\u00020\u0005H\u0096\u0001J\u0086\u0001\u0010X\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u001d2\u0014\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 \u0018\u00010]2\u0006\u0010^\u001a\u00020\u000f2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020 0`2\u0006\u0010a\u001a\u00020\u00052\b\u0010b\u001a\u0004\u0018\u00010\u000f2\u001e\u0010c\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0dH\u0096\u0001¢\u0006\u0002\u0010eJ\t\u0010f\u001a\u00020 H\u0096\u0001J\u0013\u0010g\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020j0i2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020j0iH\u0096\u0001J#\u0010l\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010m\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010n\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010o\u001a\u00020\u000fH\u0096\u0001J)\u0010p\u001a\u00020 2\u0006\u00100\u001a\u00020\u001d2\u0006\u0010q\u001a\u0002072\u0006\u0010r\u001a\u00020\u000f2\u0006\u0010s\u001a\u00020\u0005H\u0096\u0001J\t\u0010t\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010u\u001a\u00020\u00052\u0006\u0010v\u001a\u00020\"2\u0006\u0010w\u001a\u00020\u000fH\u0096\u0001J\t\u0010x\u001a\u00020\u0005H\u0096\u0001J\t\u0010y\u001a\u00020\u0005H\u0096\u0001J!\u0010z\u001a\u00020\u00052\u0006\u0010{\u001a\u00020|2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010}\u001a\u00020~H\u0096\u0001J*\u0010\u007f\u001a\u00020\u00052\u0006\u0010{\u001a\u00020|2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\t0iH\u0096\u0001J \u0010\u0083\u0001\u001a\u00020 2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\"2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\"H\u0096\u0001J#\u0010\u0086\u0001\u001a\u00020 2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u000f2\u0007\u0010\u0087\u0001\u001a\u00020\u001dH\u0096\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/obric/assistant/spi/chat/ObricChatUIDelegate;", "Lcom/obric/assistant/spi/chat/IObricChatUIService;", "<init>", "()V", "addUserAsrFeedbackItem", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "message", "Lcom/larus/im/bean/message/Message;", "menuItems", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "cacheBottomLeftInputAction", "calculateNavigationPadding", "", "navBarShow", "rootInsets", "Landroidx/core/view/WindowInsetsCompat;", "checkIsShowActionBar", "chatCanShow", "isImeShow", "show", "canShow", "isCurrentListNotEmptyOrIsRemote", "isContinuousTalk", "inVoiceMixInput", "(ZLjava/lang/Boolean;ZZZZZ)Z", "clipObricInputText", "", "text", "ensureDocBottomPadding", "", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "ignoreThreeButtonNavigationInset", "ensureToolbarBottomSafeInset", "toolbarLayoutId", "getAllMessagesHeightInLocked", "getFinalBottomPadding", "chatRoot", "bottomPadding", "getImeActualPadding", "view", "originPadding", "getImeNewBottom", "newBottom", "getMessageHeight", "messageId", "getObricActionBarWhiteItems", "", "getObricInputMaxLength", "getObricPasteExceedLimitToastText", "getTitleBarDoraSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getTitleBarIconStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getTtsEnabledStateFlow", "handleFastScrollButtonInit", "button", "Landroid/widget/FrameLayout;", "handleMenuItemClick", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", MapController.ITEM_LAYER_TAG, "callAsrId", "chatKey", "isActionBarFilterEnable", "isBuiltInMode", "isInputViewMeetScreenBottom", "(Landroid/view/View;)Ljava/lang/Boolean;", "isObricInputLengthFilterEnable", "isPreventScrollToLatest", "isPromptCellShowEnable", "isShowRealtimeCallNotification", "modifyMenuItem", "data", "chatBot", "Lcom/larus/im/bean/bot/BotModel;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "obricBluetoothIcon", "type", "(I)Ljava/lang/Integer;", "onBluetoothTtsEnable", "enable", "onBuildInTtsEnable", "onFullScreenEditTextClick", "Landroid/view/ViewGroup;", "isModifying", "inputTextContent", "onClickSend", "Lkotlin/Function1;", "imeHeight", "onFold", "Lkotlin/Function0;", "forceDarkMode", "backgroundColor", "onUpdateInputText", "Lkotlin/Function3;", "(Landroid/view/ViewGroup;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function0;ZLjava/lang/Integer;Lkotlin/jvm/functions/Function3;)V", "preventScrollToLatestAWhile", "providerObricAudioVisualizer", "reorderObricActionBarItems", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "items", "resolveGestureSafeBottom", "navigationPadding", "setChatRootBottomPadding", "navigationBarHeight", "setMessageHeight", "time", "height", "isKeyguardTipsMessage", "shouldAttachToInputOnlyContainer", "shouldKeepAnchorTopForOffscreenReply", "anchorView", "listHeight", "shouldRestrictAiGenActionToMusicInstruction", "shouldSafeBottom", "showDislikeDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "extraBundle", "Landroid/os/Bundle;", "showTipOffDialog", "tipOffDialogParams", "", "msgList", "tryAdjustVoiceInputViewLocation", "inputView1", "inputView2", "updateWindowInputBottomMargin", "source", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatUIDelegate implements IObricChatUIService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricChatUIDelegate f392858b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricChatUIService f392859a;

    static {
        f392858b = new ObricChatUIDelegate();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final String A(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        return this.f392859a.A(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean B() {
        return this.f392859a.B();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void C(String r100, long r101, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        this.f392859a.C(r100, r101, r110, r111);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final z0<Boolean> D() {
        return this.f392859a.D();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final int E(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return this.f392859a.E(r100, r101);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean F() {
        return this.f392859a.F();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final Integer G(int r100) {
        return this.f392859a.G(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final int H(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return this.f392859a.H(r100, r101);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean I(Context r100, Message r101, List<a> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "menuItems");
        return this.f392859a.I(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final int J() {
        return this.f392859a.J();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void K(boolean r100) {
        this.f392859a.K(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void L(ChatConstraintLayout r100) {
        this.f392859a.L(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void M(Context r100, Message r101, BotModel r110, e r111, List<a> r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r110, "chatBot");
        Intrinsics.checkNotNullParameter(r112, "menuItems");
        this.f392859a.M(r100, r101, r110, r111, r112);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean N(FragmentManager r100, Message r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "extraBundle");
        return this.f392859a.N(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final MutableSharedFlow<Long> O() {
        return this.f392859a.O();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final Set P(FragmentActivity r100) {
        return this.f392859a.P(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean a(FragmentManager r100, TipOffDialogParams r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "tipOffDialogParams");
        Intrinsics.checkNotNullParameter(r102, "msgList");
        return this.f392859a.a(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final int b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "chatRoot");
        return this.f392859a.b(r100, r101);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void c(View r100, View r101) {
        this.f392859a.c(r100, r101);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean d() {
        return this.f392859a.d();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final z0<Integer> e() {
        return this.f392859a.e();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final Boolean f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return this.f392859a.f(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void g() {
        this.f392859a.g();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final int h() {
        return this.f392859a.h();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final int i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        return this.f392859a.i(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final int j(Context r100, WindowInsetsCompat r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f392859a.j(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean k(Fragment r100, a r110, Message r111, String r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r111, "message");
        return this.f392859a.k(r100, r110, r111, r112, r113);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final List<com.larus.bmhome.actionbar.model.z0> l(List<com.larus.bmhome.actionbar.model.z0> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        return this.f392859a.l(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean m() {
        return this.f392859a.m();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean n() {
        return this.f392859a.n();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final int o(Context r100, boolean r101, WindowInsetsCompat r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f392859a.o(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean p() {
        return this.f392859a.p();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean q(boolean r100, Boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115) {
        return this.f392859a.q(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean r() {
        return this.f392859a.r();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean s(FragmentActivity r100) {
        return this.f392859a.s(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final String t() {
        return this.f392859a.t();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void u(boolean r100) {
        this.f392859a.u(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final View v(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f392859a.v(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean w() {
        return this.f392859a.w();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final boolean x(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        return this.f392859a.x(r100, r101);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void y() {
        this.f392859a.y();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatUIService
    public final void z(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        this.f392859a.z(r100);
    }

    private ObricChatUIDelegate() {
        IObricChatUIService r100 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricChatUIServiceImpl();
    L5:
        this.f392859a = r100;
    }
}
