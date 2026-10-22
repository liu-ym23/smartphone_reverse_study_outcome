package com.ss.android.lark.flow.mergeforward.page;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.biz.im.api.extension.chat_window.k;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.MessageListFeatureSpecCompatKt;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEventDispatchFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import fsb.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import l3c.j;
import t6b.o;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020#H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001fH\u0016J\u001a\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020'2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u00101\u001a\u00020!H\u0002J\"\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u00052\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030605H\u0002J\u001c\u00107\u001a\u00020!2\u0006\u00103\u001a\u00020\u00052\n\u00108\u001a\u0006\u0012\u0002\b\u000306H\u0002J\b\u00109\u001a\u00020!H\u0016J\f\u0010:\u001a\u00020!*\u00020;H\u0014J\f\u0010<\u001a\u00020!*\u00020;H\u0014J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020>05H\u0014J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020@05H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardFragment;", "Lcom/ss/android/lark/im/base/page/BasePageFragment;", "<init>", "()V", "messageListComponent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/CoreMessageListComponent;", "TAG", "", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "componentAdaptService", "Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "getComponentAdaptService", "()Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "componentAdaptService$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardViewModel;", "viewModel$delegate", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FragmentFlowMergeForwardBinding;", "titleBarComponent", "Lcom/ss/android/lark/flow/chat/titlebar/FlowTitleBarComponent;", "closePageObserver", "Landroidx/lifecycle/Observer;", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onActivityCreated", "onWindowFocusChanged", "hasFocus", "onViewCreated", "view", "setupAudioVisiblePreloadIfNeeded", "preloadAllAudios", "component", "list", "", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "maybePreloadAudio", "message", LiveCommonConstants.REASON_ON_DEDTROY, "initComponents", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "initViewModels", "configuratorTypes", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "pluginTypes", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowMergeForwardFragment extends Hilt_FlowMergeForwardFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f423727r = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CoreMessageListComponent f423728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f423729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Inject
    public v f423730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f423731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f423732o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FlowTitleBarComponent f423733p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f423734q;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMergeForwardFragment f423735a;

        public a(FlowMergeForwardFragment r100) {
            this.f423735a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
            FlowToast.c(this.f423735a.requireContext(), R.string.Lark_Legacy_LaunchErrorChatWindow);
            zab.a.a(this.f423735a);
            return;
        }
    }

    public static final class b implements i4b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMergeForwardFragment f423736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f423737b;

        @Override // i4b.a
        public final Function1 a(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            return null;
        }

        @Override // i4b.a
        public final /* synthetic */ boolean b() {
            return false;
        }

        @Override // i4b.a
        public final CharSequence d(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            return null;
        }

        @Override // i4b.a
        public final Function1<View, Unit> e(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            return null;
        }

        @Override // i4b.a
        public final CharSequence c(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            FlowMergeForwardFragment r101 = this.f423736a;
            int r102 = FlowMergeForwardFragment.f423727r;
            MergeForwardContent r103 = r101.Z90().getMessageContent();
            boolean r104 = false;
            if (r103 == null) goto L9;
            String r105 = r103.getTitle();
            if (r105 == null) goto L9;
            if ((!StringsKt.isBlank(r105)) != true) goto L9;
            boolean r106 = true;
        L10:
            String r107 = null;
            if (r106 == false) goto L16;
            MergeForwardContent r108 = this.f423736a.Z90().getMessageContent();
            if (r108 == null) goto L30;
            r107 = r108.getTitle();
        L30:
            return String.valueOf(r107);
        L16:
            MergeForwardContent r109 = this.f423736a.Z90().getMessageContent();
            if (r109 == null) goto L23;
            String r110 = r109.getQuasiTitle();
            if (r110 == null) goto L23;
            if ((!StringsKt.isBlank(r110)) != true) goto L23;
            r104 = true;
        L23:
            if (r104 == false) goto L28;
            MergeForwardContent r111 = this.f423736a.Z90().getMessageContent();
            if (r111 == null) goto L31;
            r107 = r111.getQuasiTitle();
        L31:
            return String.valueOf(r107);
        L28:
            String r112 = UIUtils.getString(this.f423737b, R.string.Lark_Legacy_MessagePoMergeforward);
            Intrinsics.checkNotNull(r112);
            return r112;
        L9:
            r106 = false;
            goto L10
        }

        public b(FlowMergeForwardFragment r100, FragmentActivity r101) {
            this.f423736a = r100;
            this.f423737b = r101;
        }
    }

    public static final class c implements w0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f423738b = null;

        static {
            f423738b = new c();
        }

        public c() {
        }

        @Override // com.ss.android.lark.biz.im.api.w0
        public final int a() {
            return -3;
        }
    }

    public static final class d implements com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> {
        public d() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.a
        public final boolean a(TitleBarActionKey r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            if (r100 == TitleBarActionKey.FORWARD) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class e implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMergeForwardFragment f423739a;

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.j
        public final void d() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.j
        public final void onHide() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.j
        public final void onShow() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.j
        public final TitleBarActionKey getKey() {
            return TitleBarActionKey.FORWARD;
        }

        public e(FlowMergeForwardFragment r100) {
            this.f423739a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.j
        public final void f(View r100) {
            Intrinsics.checkNotNullParameter(r100, "actionView");
            Intrinsics.checkNotNullParameter(r100, "actionView");
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.k
        public final Drawable g(TitleTheme.ThemeType r100) {
            Intrinsics.checkNotNullParameter(r100, "theme");
            return UDIconUtils.getIconDrawable(this.f423739a.requireActivity(), R.drawable.flow_ud_ic_forward);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.j
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            FlowMergeForwardFragment r101 = this.f423739a;
            int r102 = FlowMergeForwardFragment.f423727r;
            if (r101.Z90().getFromType() != 4) goto L18;
            int r103 = FlowChatModule.f422022d;
            egb.e r104 = FlowChatModule.a.a().a().getForwardDependency();
            FragmentActivity r105 = this.f423739a.requireActivity();
            Chat r106 = this.f423739a.Z90().getChat().getValue();
            if (r106 != null) goto L7;
            r106 = new Chat();
        L7:
            Chat r107 = r106;
            MergeForwardContent r108 = this.f423739a.Z90().getMessageContent();
            if (r108 == null) goto L15;
            List<Message> r109 = r108.getMessages();
            if (r109 == null) goto L15;
            List<Message> r110 = r109;
            ?? r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
            Iterator r112 = r110.iterator();
        L13:
            if (r112.hasNext() == false) goto L16;
            r111.add(((Message) r112.next()).getId());
        L16:
            r104.a(r105, r107, new ArrayList((Collection) r111), -1, null);
            return;
        L15:
            r111 = CollectionsKt.emptyList();
            goto L16
        L18:
            Message r113 = this.f423739a.Z90().getOriginMessage();
            if (r113 != null) goto L21;
            return;
        L21:
            int r114 = FlowChatModule.f422022d;
            egb.e r115 = FlowChatModule.a.a().a().getForwardDependency();
            FragmentActivity r116 = this.f423739a.requireActivity();
            String r117 = r113.getSourceId();
            if (r117 != null) goto L24;
            r117 = "";
        L24:
            egb.d.a(r115, r116, 1, r113, r117, false, this.f423739a, 80);
        }
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<ConfiguratorType> T90() {
        return CollectionsKt.listOf(ConfiguratorType.MESSAGE_LIST);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<PluginType> X90() {
        return CollectionsKt.listOf(PluginType.MERGE_FORWARD_PLUGIN_FACTORY);
    }

    public final v Y90() {
        v r100 = this.f423730m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chatAppContainer");
        return null;
    }

    public final FlowMergeForwardViewModel Z90() {
        return (FlowMergeForwardViewModel) this.f423732o.getValue();
    }

    @Inject
    public FlowMergeForwardFragment() {
        this.f423729l = "FlowMergeForwardFragment";
        this.f423731n = LazyKt.lazy(FlowMergeForwardFragment$componentAdaptService$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r100 = new FlowMergeForwardFragment$viewModel$2(this);
        final Function0<Fragment> r101 = new FlowMergeForwardFragment$special$$inlined$viewModels$default$1(this);
        this.f423732o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowMergeForwardViewModel.class), new FlowMergeForwardFragment$special$$inlined$viewModels$default$2(r101), r100);
        this.f423734q = new a(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        eza.a r100 = (eza.a) this.f423731n.getValue();
        if (r100 == null) goto L5;
        r100.p(this);
    L5:
        Z90().getClosePageInfo().removeObserver(this.f423734q);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void V90(j r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        final FragmentActivity r100 = requireActivity();
        if (Z90().getMessageContent() != null) goto L6;
        Log.e(this.f423729l, "mergeForwardContent is null, failed to initComponents.");
        return;
    L6:
        r110.b(new FlowMergeForwardFragment$initComponents$1(this, this));
        r110.b(FlowMergeForwardFragment$initComponents$2.INSTANCE);
        final FlowTitleBarComponent r101 = new FlowTitleBarComponent(Y90());
        r101.H = Integer.valueOf(R.color.flow_ud_bg_base_1);
        r101.F = new b(this, r100);
        this.f423733p = r101;
        r110.c(R.id.merge_forward_titlebar_container, new FlowMergeForwardFragment$initComponents$4$1(r101));
        x0.a r102 = new x0.a();
        FragmentActivity r103 = requireActivity();
        Intrinsics.checkNotNullParameter(r103, "hostActivity");
        r102.f410467a = r103;
        Intrinsics.checkNotNullParameter(this, "hostFragment");
        r102.f410468b = this;
        fxa.b r104 = Z90().getChatBundle();
        Intrinsics.checkNotNullParameter(r104, "chatBundle");
        r102.f410469c = r104;
        r102.f410472f = false;
        r102.f410473g = 65;
        r102.f410474h = -1132462081;
        com.ss.android.lark.chat.mergeforward.b r105 = new com.ss.android.lark.chat.mergeforward.b(requireActivity(), Z90().getMessageContent(), Z90().getFromType(), this);
        Intrinsics.checkNotNullParameter(r105, "chatContext");
        r102.f410470d = r105;
        FirstMessagePaddingType r106 = FirstMessagePaddingType.TITLE_AND_TAB;
        Intrinsics.checkNotNullParameter(r106, "value");
        r102.f410476j = r106;
        Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, ? extends com.ss.android.lark.biz.im.api.message.params.l> r107 = MapsKt.mutableMapOf(new Pair[]{new Pair(g3b.v.class, new g3b.v(new g3b.v.a()))});
        Intrinsics.checkNotNullParameter(r107, "params");
        r102.f410475i = r107;
        nhb.b r108 = new nhb.b(Z90(), Y90());
        Intrinsics.checkNotNullParameter(r108, "value");
        r102.f410471e = r108;
        r102.f410482p = false;
        r102.f410486t = false;
        c r109 = c.f423738b;
        Intrinsics.checkNotNullParameter(r109, ShortVideoSegments.KEY_PROP_PROVIDER);
        r102.f410481o = r109;
        v4b.c.a r111 = new v4b.c.a();
        r111.f553205f = true;
        r111.f553204e = true;
        r102.f410483q = new v4b.c(r111);
        List<Integer> r112 = exa.a.f474731a;
        Intrinsics.checkNotNullParameter(r112, "list");
        r102.f410485s = r112;
        final o r113 = MessageListFeatureSpecCompatKt.a(new x0(r102));
        r113.c(FlowMergeForwardFragment$initComponents$params$2$1.INSTANCE);
        r113.e(new FlowMergeForwardFragment$initComponents$params$2$2(this));
        r113.d(FlowMergeForwardFragment$initComponents$params$2$3.INSTANCE);
        r110.c(R.id.merge_forward_message_list_container, new FlowMergeForwardFragment$initComponents$5(r100, r113, this));
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void W90(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.g(ChatWindowOpenViewModel.class, new FlowMergeForwardFragment$initViewModels$1(this));
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Z90().getClosePageInfo().observe(getViewLifecycleOwner(), this.f423734q);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment, com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        f.c("FlowMergeForwardFragment").j();
        f.b().i(WidgetCostModule.TYPE_ON_CREATE);
        super.onCreate(r100);
        eza.a r101 = (eza.a) this.f423731n.getValue();
        if (r101 == null) goto L5;
        r101.o(this);
    L5:
        Z90().loadChatInitData(null);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        com.ss.android.lark.mergeforward.b.a r101 = com.ss.android.lark.mergeforward.b.f431882a;
        com.ss.android.lark.mergeforward.b.f431882a = new com.ss.android.lark.mergeforward.b.a(Z90().getMessageContent(), Z90().getTranslatedMessageContent(), Z90().getOriginMessage());
        super.onSaveInstanceState(r100);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        f.b().g();
    }

    public static void aa0(CoreMessageListComponent r100, List r101) {
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L35;
        y6b.c r103 = (y6b.c) r102.next();
        if (r103.j() == true) goto L4;
        T r104 = r103.f566500o;
        if ((r104 instanceof AudioContentVO) == false) goto L4;
        AudioContentVO r105 = (AudioContentVO) r104;
        String r106 = r105.f411850t;
        boolean r107 = false;
        if (r106 != null) goto L14;
    L17:
        boolean r108 = true;
    L18:
        if (r108 == false) goto L4;
        byte[] r109 = r105.f411852v;
        if (r109 != null) goto L23;
    L29:
        if (r107 == true) goto L4;
        if (r105.f411849s == AudioContent.AudioState.DOWNLOADING) goto L4;
        r100.mB(r103.f566482c, AudioContent.AudioState.DONE);
        goto L4
    L23:
        if (r109.length != 0) goto L25;
        boolean r110 = true;
    L27:
        if ((!r110) != true) goto L29;
        r107 = true;
        goto L29
    L25:
        r110 = false;
        goto L27
    L14:
        if (r106.length() == 0) goto L17;
        r108 = false;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.ss.android.lark.biz.im.api.extension.chat_window.e, com.ss.android.lark.flow.mergeforward.page.FlowMergeForwardFragment$setupAudioVisiblePreloadIfNeeded$callback$1, java.lang.Object] */
    @Override // com.ss.android.lark.im.base.page.BasePageFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FlowTitleBarComponent r102 = this.f423733p;
        if (r102 == null) goto L5;
        r102.f423051r.b(new d());
        r102.f423051r.a(new e(this));
    L5:
        com.ss.android.lark.insets.f r103 = WindowInsetsUtils.b(this);
        r103.k(true);
        r103.r(true);
        final CoreMessageListComponent r104 = this.f423728k;
        if (r104 == null) goto L17;
        List r105 = CollectionsKt.toList(r104.Tc().getData());
        if ((!r105.isEmpty()) == false) goto L11;
        aa0(r104, r105);
        goto L17
    L11:
        final Ref.BooleanRef r106 = new Ref.BooleanRef();
        final ?? r107 = new FlowMergeForwardFragment$setupAudioVisiblePreloadIfNeeded$callback$1(r104, r106, this);
        Intrinsics.checkNotNullParameter(r107, "callback");
        ((MessageListEventDispatchFeature) r104.F0()).m(r107);
        List r108 = CollectionsKt.toList(r104.Tc().getData());
        Function0<Unit> r109 = new FlowMergeForwardFragment$setupAudioVisiblePreloadIfNeeded$1(r104, r107);
        if (r108.isEmpty() == true) goto L17;
        if (r106.element == true) goto L17;
        r106.element = true;
        r109.invoke();
        aa0(r104, r108);
    L17:
        f.b().h(WidgetCostModule.TYPE_ON_CREATE);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_flow_merge_forward, r101, false);
        FrameLayout r104 = (FrameLayout) r103;
        int r105 = R.id.merge_forward_message_list_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.merge_forward_message_list_container)) == null) goto L11;
        r105 = R.id.merge_forward_titlebar_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r103, R.id.merge_forward_titlebar_container)) == null) goto L11;
        r105 = R.id.msg_lis_anim_container;
        if (((MessageListAnimationContainer) ViewBindings.findChildViewById(r103, R.id.msg_lis_anim_container)) == null) goto L11;
        return r104;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r105)));
    }
}
