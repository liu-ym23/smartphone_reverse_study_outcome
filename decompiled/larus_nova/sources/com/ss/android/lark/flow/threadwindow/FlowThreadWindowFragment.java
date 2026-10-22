package com.ss.android.lark.flow.threadwindow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.MessageListFeatureSpecCompatKt;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.MessageListDataFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.flow.chat.databinding.FragmentFlowThreadWindowBinding;
import com.ss.android.lark.flow.chat.page.flow.FlowChatViewModel;
import com.ss.android.lark.keyboard.component.FlowKeyboardComponent;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0014J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0014\u00101\u001a\u00020\u001e2\n\u00102\u001a\u0006\u0012\u0002\b\u000303H\u0002J\f\u00104\u001a\u00020\u001e*\u00020\u001fH\u0014J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0014J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020906H\u0014J\b\u0010:\u001a\u00020\u001eH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowFragment;", "Lcom/ss/android/lark/im/base/page/BasePageFragment;", "<init>", "()V", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/ChatBundle;", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/ChatBundle;", "chatBundle$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "viewModel$delegate", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FragmentFlowThreadWindowBinding;", "listCommands", "Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowListCommands;", "flowKeyboardComponent", "Lcom/ss/android/lark/keyboard/component/FlowKeyboardComponent;", "coreMessageListComponent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/CoreMessageListComponent;", "initComponents", "", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupCreateTopicCta", "showKeyboardInput", "revealKeyboardArea", "buildMessageListSpec", "Lcom/ss/android/lark/chat/spec/messagelist/MessageListSpec;", "activity", "Landroidx/fragment/app/FragmentActivity;", "handleTopicContentClick", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "initViewModels", "configuratorTypes", "", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "pluginTypes", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "onDestroyView", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowThreadWindowFragment extends Hilt_FlowThreadWindowFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f424112r = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Inject
    public v f424113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f424114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f424115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FragmentFlowThreadWindowBinding f424116n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f424117o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FlowKeyboardComponent f424118p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CoreMessageListComponent f424119q;

    public static final class a {
    }

    public static final class b implements MessageListDataFeature.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowThreadWindowFragment f424120a;

        public b(FlowThreadWindowFragment r100) {
            this.f424120a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.MessageListDataFeature.a
        public final void b(IMessageListViewModel r100) {
            Intrinsics.checkNotNullParameter(r100, "viewModel");
            FlowThreadWindowFragment r101 = this.f424120a;
            if ((r100 instanceof j) == false) goto L5;
            j r102 = (j) r100;
        L6:
            r101.f424117o = r102;
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.MessageListDataFeature.a
        public final FlowThreadWindowListViewModelFactory a(i7b.a r100, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.b r101) {
            Intrinsics.checkNotNullParameter(r100, "initData");
            Intrinsics.checkNotNullParameter(r101, "dependency");
            FlowThreadWindowFragment r102 = this.f424120a;
            int r103 = FlowThreadWindowFragment.f424112r;
            return new FlowThreadWindowListViewModelFactory((ChatBundle) r102.f424114l.getValue(), this.f424120a.Y90(), r100, r101.o());
        }
    }

    static {
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<ConfiguratorType> T90() {
        return CollectionsKt.listOf(new ConfiguratorType[]{ConfiguratorType.KEYBOARD_WRAPPER, ConfiguratorType.MESSAGE_LIST, ConfiguratorType.ACTIVITY_RESULT});
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f424117o = null;
        this.f424118p = null;
        super.onDestroyView();
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<PluginType> X90() {
        return CollectionsKt.listOf(PluginType.FLOW_THREAD_WINDOW_PLUGIN_FACTORY);
    }

    public final v Y90() {
        v r100 = this.f424113k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chatAppContainer");
        return null;
    }

    public final FlowChatViewModel Z90() {
        return (FlowChatViewModel) this.f424115m.getValue();
    }

    @Inject
    public FlowThreadWindowFragment() {
        this.f424114l = LazyKt.lazy(new FlowThreadWindowFragment$chatBundle$2(this));
        Function0<ViewModelProvider.Factory> r100 = new FlowThreadWindowFragment$viewModel$2(this);
        final Function0<Fragment> r101 = new FlowThreadWindowFragment$special$$inlined$viewModels$default$1(this);
        this.f424115m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowChatViewModel.class), new FlowThreadWindowFragment$special$$inlined$viewModels$default$2(r101), r100);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void V90(l3c.j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final FragmentActivity r101 = requireActivity();
        r100.b(new FlowThreadWindowFragment$initComponents$1(this));
        r100.b(FlowThreadWindowFragment$initComponents$2.INSTANCE);
        r100.b(new FlowThreadWindowFragment$initComponents$3(this));
        r100.b(new FlowThreadWindowFragment$initComponents$4(this));
        r100.c(R.id.flow_thread_window_titlebar_container, new FlowThreadWindowFragment$initComponents$5(this));
        x0.a r102 = new x0.a();
        Intrinsics.checkNotNullParameter(r101, "hostActivity");
        r102.f410467a = r101;
        Intrinsics.checkNotNullParameter(this, "hostFragment");
        r102.f410468b = this;
        fxa.b r103 = Z90().getChatBundle();
        Intrinsics.checkNotNullParameter(r103, "chatBundle");
        r102.f410469c = r103;
        r102.f410472f = true;
        r102.f410473g = -8193;
        r102.f410474h = -1132462081;
        FirstMessagePaddingType r104 = FirstMessagePaddingType.TITLE_AND_TAB;
        Intrinsics.checkNotNullParameter(r104, "value");
        r102.f410476j = r104;
        c r105 = new c();
        Intrinsics.checkNotNullParameter(r105, "value");
        r102.f410477k = r105;
        r102.f410479m = d.f424232a;
        r102.f410480n = e.f424233a;
        f r106 = f.f424234b;
        Intrinsics.checkNotNullParameter(r106, ShortVideoSegments.KEY_PROP_PROVIDER);
        r102.f410481o = r106;
        r102.f410486t = false;
        Intrinsics.checkNotNullParameter(FlowThreadWindowListViewModel.class, "viewModelClass");
        r102.f410487u = FlowThreadWindowListViewModel.class;
        t6b.o r107 = MessageListFeatureSpecCompatKt.a(new x0(r102));
        r107.c(FlowThreadWindowFragment$buildMessageListSpec$1$1.INSTANCE);
        r107.e(new FlowThreadWindowFragment$buildMessageListSpec$1$2(this, r101));
        r107.d(FlowThreadWindowFragment$buildMessageListSpec$1$3.INSTANCE);
        this.f424119q = new CoreMessageListComponent(r101, r107, Y90(), new com.ss.android.lark.flow.chat.page.flow.c(this, new FlowThreadWindowFragment$initComponents$6(this)), new b(this));
        r100.c(R.id.flow_thread_window_list_container, new FlowThreadWindowFragment$initComponents$8(this));
        r100.c(R.id.chat_keyboard_container, new FlowThreadWindowFragment$initComponents$9(this));
        r100.b(FlowThreadWindowFragment$initComponents$10.INSTANCE);
        r100.a(FlowThreadWindowFragment$initComponents$11.INSTANCE);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void W90(l3c.j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.g(ChatWindowOpenViewModel.class, new FlowThreadWindowFragment$initViewModels$1(this));
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FragmentFlowThreadWindowBinding r102 = this.f424116n;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        r102.f422167b.setVisibility(8);
        FragmentFlowThreadWindowBinding r103 = this.f424116n;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L8:
        LinearLayout r104 = r103.f422169d;
        r104.setOnClickListener(new g(r104, this));
        Z90().loadChatInitData(null);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.fragment_flow_thread_window, r110, false);
        int r112 = R.id.chat_keyboard_container;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.chat_keyboard_container);
        if (r102 == null) goto L21;
        r112 = R.id.flow_chat_message_list_view_observer;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.flow_chat_message_list_view_observer);
        if (r103 == null) goto L21;
        r112 = R.id.flow_thread_window_create_topic_cta;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.flow_thread_window_create_topic_cta);
        if (r104 == null) goto L21;
        r112 = R.id.flow_thread_window_keyboard_area;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.flow_thread_window_keyboard_area);
        if (r105 == null) goto L21;
        r112 = R.id.flow_thread_window_list_container;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.flow_thread_window_list_container);
        if (r106 == null) goto L21;
        ConstraintLayout r113 = (ConstraintLayout) r101;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.flow_thread_window_titlebar_container);
        if (r107 != null) goto L15;
        r112 = R.id.flow_thread_window_titlebar_container;
        goto L21
    L15:
        if (((MessageListAnimationContainer) ViewBindings.findChildViewById(r101, R.id.msg_lis_anim_container)) == null) goto L18;
        this.f424116n = new FragmentFlowThreadWindowBinding(r113, r102, r103, r104, r105, r106, r107);
        return r113;
    L18:
        r112 = R.id.msg_lis_anim_container;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
