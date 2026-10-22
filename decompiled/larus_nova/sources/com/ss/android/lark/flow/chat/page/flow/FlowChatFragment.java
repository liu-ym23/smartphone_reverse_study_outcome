package com.ss.android.lark.flow.chat.page.flow;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.MessageListSpecPresets;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.MessageSenderComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$markTracePageInvisible$1;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$1;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$2;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$3;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import l3c.j;
import t6b.e;
import t6b.o;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\f\u0010)\u001a\u00020\u0018*\u00020*H\u0014J\f\u0010+\u001a\u00020\u0018*\u00020*H\u0014J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0014J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u0002000-H\u0014J\n\u00101\u001a\u0004\u0018\u000102H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/flow/FlowChatFragment;", "Lcom/ss/android/lark/im/base/page/BasePageFragment;", "<init>", "()V", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "componentAdaptService", "Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "getComponentAdaptService", "()Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "componentAdaptService$delegate", "Lkotlin/Lazy;", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FragmentFlowChatBinding;", "viewModel", "Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "viewModel$delegate", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "initComponents", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "initViewModels", "pluginTypes", "", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "configuratorTypes", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "getContext", "Landroid/content/Context;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowChatFragment extends Hilt_FlowChatFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f422714n = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Inject
    public v f422715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f422716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f422717m;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<ConfiguratorType> T90() {
        return CollectionsKt.listOf(new ConfiguratorType[]{ConfiguratorType.KEYBOARD_WRAPPER, ConfiguratorType.MESSAGE_LIST, ConfiguratorType.ACTIVITY_RESULT});
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<PluginType> X90() {
        return CollectionsKt.listOf(PluginType.FLOW_CHAT_PLUGIN_FACTORY);
    }

    public final v Y90() {
        v r100 = this.f422715k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chatAppContainer");
        return null;
    }

    public final FlowChatViewModel Z90() {
        return (FlowChatViewModel) this.f422717m.getValue();
    }

    @Inject
    public FlowChatFragment() {
        this.f422716l = LazyKt.lazy(FlowChatFragment$componentAdaptService$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r100 = new FlowChatFragment$viewModel$2(this);
        final Function0<Fragment> r101 = new FlowChatFragment$special$$inlined$viewModels$default$1(this);
        this.f422717m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowChatViewModel.class), new FlowChatFragment$special$$inlined$viewModels$default$2(r101), r100);
    }

    @Override // com.ss.android.lark.flow.chat.page.flow.Hilt_FlowChatFragment, com.ss.android.lark.im.base.page.Hilt_BasePageFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ContextsKt.preferActivity(r100);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        eza.a r100 = (eza.a) this.f422716l.getValue();
        if (r100 == null) goto L5;
        r100.p(this);
    L5:
        final String r101 = Z90().getChatBundle().getChatId();
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        com.ss.android.lark.flow.chat.statistics.perf.a r102 = com.ss.android.lark.flow.chat.statistics.perf.a.f423021a;
        Intrinsics.checkNotNullParameter(r101, "chatId");
        if (r101.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L16;
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.f423024d.values(), new DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$1(r101));
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.f423025e.values(), new DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$2(r101));
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.f423026f.values(), new DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$3(r101));
        return;
    L16:
        return;
    L11:
        r103 = false;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Z90().initChatParamUtils();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        String r100 = Z90().getChatBundle().getChatId();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        com.ss.android.lark.flow.chat.statistics.perf.a r101 = com.ss.android.lark.flow.chat.statistics.perf.a.f423021a;
        Intrinsics.checkNotNullParameter(r100, "chatId");
        if (r100.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L28;
        Iterator<T> r103 = com.ss.android.lark.flow.chat.statistics.perf.a.f423023c.values().iterator();
    L13:
        if (r103.hasNext() == false) goto L17;
        com.ss.android.lark.flow.chat.statistics.perf.a.C4990a r104 = (com.ss.android.lark.flow.chat.statistics.perf.a.C4990a) r103.next();
        if (Intrinsics.areEqual(r104.f423029b, r100) == false) goto L13;
        r104.f423032e = true;
        goto L13
    L17:
        Iterator r105 = SequencesKt.sequence(new DoubaoReplyLatencyTracker$markTracePageInvisible$1(null)).iterator();
    L19:
        if (r105.hasNext() == false) goto L39;
        com.ss.android.lark.flow.chat.statistics.perf.a.b r106 = (com.ss.android.lark.flow.chat.statistics.perf.a.b) r105.next();
        Intrinsics.checkNotNull(r106);
        if (Intrinsics.areEqual(r106.f423033a, r100) == true) goto L23;
    L25:
        boolean r107 = false;
    L26:
        if (r107 == false) goto L19;
        r106.f423043k = true;
        goto L19
    L23:
        if (r106.f423035c != null) goto L25;
        r107 = true;
        goto L26
    L39:
        return;
    L28:
        return;
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment, com.ss.android.lark.base.frame.FrameFragment
    public final void A0(Intent r100) {
        super.A0(r100);
        Map<Integer, WeakReference<Dialog>> r101 = l7b.a.f507901a;
        Iterator r102 = ((HashMap) l7b.a.f507901a).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L26;
        Dialog r103 = (Dialog) ((WeakReference) ((Map.Entry) r102.next()).getValue()).get();
        if (r103 == null) goto L4;
        if (r103.isShowing() == false) goto L4;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 == null) goto L14;
        if (Looper.myLooper() == r104.getLooper()) goto L14;
        r104.post(DialogLancet.createDismissRunnable(r103));
    L14:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r103);
        goto L4
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L19:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r105 == null) goto L23;
        d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L26:
        ((HashMap) l7b.a.f507901a).clear();
        Iterator r106 = ((HashMap) l7b.a.f507902b).entrySet().iterator();
    L28:
        if (r106.hasNext() == false) goto L34;
        PopupWindow r107 = (PopupWindow) ((WeakReference) ((Map.Entry) r106.next()).getValue()).get();
        if (r107 == null) goto L28;
        if (r107.isShowing() == false) goto L28;
        PopupWindowLancet.handleDismissBeforeOrigin(r107);
        r107.dismiss();
        goto L28
    L34:
        ((HashMap) l7b.a.f507902b).clear();
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent] */
    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void V90(j r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        final FragmentActivity r100 = requireActivity();
        final Context r101 = getContext();
        if (r101 != null) goto L6;
        Log.e("FlowChatFragment", "context is null, failed to initComponents.");
        return;
    L6:
        r110.b(new FlowChatFragment$initComponents$1(this, this));
        r110.b(FlowChatFragment$initComponents$2.INSTANCE);
        r110.b(new FlowChatFragment$initComponents$3(this));
        final MessageSenderComponent r102 = new MessageSenderComponent(Y90());
        r102.getMessageSender();
        r110.b(new FlowChatFragment$initComponents$4(r102));
        r110.c(R.id.chat_titlebar_container, new FlowChatFragment$initComponents$5(this));
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        FragmentActivity r104 = requireActivity();
        Lazy r105 = MessageListSpecPresets.f413738a;
        o r106 = MessageListSpecPresets.a(requireActivity(), this, Z90().getChatBundle(), null);
        r106.c(FlowChatFragment$initComponents$6$1.INSTANCE);
        r106.e(new FlowChatFragment$initComponents$6$2(r101, this, r100, r103));
        r106.d(FlowChatFragment$initComponents$6$3.INSTANCE);
        FlowChatFragment$initComponents$6$4 r107 = FlowChatFragment$initComponents$6$4.INSTANCE;
        Intrinsics.checkNotNullParameter(r107, "patch");
        Object r108 = ((LinkedHashMap) r106.f540879a).get(e.class);
        if ((r108 instanceof e) == true) goto L9;
        r108 = null;
    L9:
        s6b.b<?, ?> r109 = (e) r108;
        if (r109 == null) goto L20;
    L15:
        if (r109 == null) goto L18;
        Map<Class<s6b.b<?, ?>>, s6b.b<?, ?>> r111 = r106.f540879a;
        s6b.b r112 = r109.a();
        r107.invoke(r112);
        r111.put(e.class, r109.b(r112));
    L18:
        Unit r113 = Unit.INSTANCE;
        r103.element = new CoreMessageListComponent(r104, r106, Y90(), new c(this, null));
        r110.c(R.id.chat_message_list_container, new FlowChatFragment$initComponents$7(r103));
        r110.c(R.id.chat_keyboard_container, new FlowChatFragment$initComponents$8(this, r101, r100));
        r110.b(FlowChatFragment$initComponents$9.INSTANCE);
        r110.c(R.id.flow_bottom_banner_container, FlowChatFragment$initComponents$10.INSTANCE);
        return;
    L20:
        r109 = (s6b.b) e.class.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L13
        r106.f540879a.put(e.class, r109);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("create base error", e);
        goto L18
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void W90(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.g(ChatWindowOpenViewModel.class, new FlowChatFragment$initViewModels$1(this));
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment, com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        eza.a r101 = (eza.a) this.f422716l.getValue();
        if (r101 == null) goto L5;
        r101.o(this);
    L5:
        com.ss.android.lark.flow.chat.statistics.perf.a.g();
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Z90().loadChatInitData(null);
        f r102 = WindowInsetsUtils.b(this);
        r102.k(true);
        r102.r(true);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_flow_chat, r101, false);
        int r104 = R.id.chat_banner_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_banner_container)) == null) goto L30;
        r104 = R.id.chat_footer_hint_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_footer_hint_container)) == null) goto L30;
        r104 = R.id.chat_func_keyboard_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_func_keyboard_container)) == null) goto L30;
        r104 = R.id.chat_keyboard_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_keyboard_container)) == null) goto L30;
        r104 = R.id.chat_keyboard_extend_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_keyboard_extend_container)) == null) goto L30;
        r104 = R.id.chat_message_list_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_message_list_container)) == null) goto L30;
        r104 = R.id.chat_titlebar_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_titlebar_container)) == null) goto L30;
        r104 = R.id.chat_titlebar_float_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.chat_titlebar_float_container)) == null) goto L30;
        r104 = R.id.flow_bottom_banner_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.flow_bottom_banner_container)) == null) goto L30;
        r104 = R.id.flow_chat_keyboard_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.flow_chat_keyboard_container)) == null) goto L30;
        r104 = R.id.flow_chat_message_list_view_observer;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.flow_chat_message_list_view_observer)) == null) goto L30;
        ConstraintLayout r105 = (ConstraintLayout) r103;
        if (((MessageListAnimationContainer) ViewBindings.findChildViewById(r103, R.id.msg_lis_anim_container)) != null) goto L27;
        r104 = R.id.msg_lis_anim_container;
        goto L30
    L27:
        return r105;
    L30:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
