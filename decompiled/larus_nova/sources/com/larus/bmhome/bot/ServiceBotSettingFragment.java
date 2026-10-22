package com.larus.bmhome.bot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.databinding.LarusPageServiceBotSettingBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020%H\u0016J\b\u00103\u001a\u00020%H\u0016J\b\u00104\u001a\u00020%H\u0016J\u000f\u00105\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00106J\u000f\u0010\t\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00106J\b\u00107\u001a\u00020%H\u0002J\b\u00108\u001a\u00020%H\u0002J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020%H\u0002J\u0018\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020%2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002J\u0018\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020%2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010M\u001a\u00020)2\u0006\u0010J\u001a\u00020NH\u0002J,\u0010O\u001a\u00020%2\u0006\u0010J\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00072\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020%0SH\u0002J\u0018\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/larus/bmhome/bot/ServiceBotSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusPageServiceBotSettingBinding;", "isSubPage", "", "()Z", "showMoreMenu", "getShowMoreMenu", "pageTitle", "", "getPageTitle", "()Ljava/lang/String;", "conversationId", "getConversationId", "botId", "getBotId", "supplierId", "getSupplierId", "botSettingViewModel", "Lcom/larus/bmhome/bot/BotSettingViewModel;", "getBotSettingViewModel", "()Lcom/larus/bmhome/bot/BotSettingViewModel;", "botSettingViewModel$delegate", "Lkotlin/Lazy;", "settingViewModel", "Lcom/larus/bmhome/bot/ServiceBotSettingViewModel;", "getSettingViewModel", "()Lcom/larus/bmhome/bot/ServiceBotSettingViewModel;", "settingViewModel$delegate", "trace", "Lcom/larus/bmhome/bot/BotSettingTrace;", "autoLogEnterPage", "getCurrentPageName", "fillTrackParams", "", "params", "Lcom/ixigua/lib/track/TrackParams;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", "setupTitleBar", "()Lkotlin/Unit;", "clearHistory", "performBack", "initObserver", "initSettingObserver", "findConversationInfo", "Lcom/larus/im/bean/conversation/Conversation;", "cvsId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderBlocks", "blocks", "", "Lcom/larus/bmhome/bot/ServiceBotSettingBlock;", "createCategoryTitle", "text", "isFirst", "createSpacer", "height", "", "createSupplierItem", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/bot/ServiceBotSettingItem$SupplierItem;", "openSupplierPage", "createToggleItem", "Lcom/larus/bmhome/bot/ServiceBotSettingItem$ToggleItem;", "bindToggle", "Lcom/larus/bmhome/bot/view/ServiceBotSettingFrescoToggleView;", "checked", "onChanged", "Lkotlin/Function1;", "revertToggle", "itemId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServiceBotSettingFragment extends TraceFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f296490i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusPageServiceBotSettingBinding f296491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f296492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f296493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.bmhome.bot.b f296494h;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f296495a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f296495a = r100;
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
            return this.f296495a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f296495a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "bot_setting";
    }

    public final ServiceBotSettingViewModel W90() {
        return (ServiceBotSettingViewModel) this.f296493g.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        FLogger.f375446a.i("ServiceBotSettingFragment", "onPause isSubPage=" + Y90() + " botId=" + getBotId() + " supplierId=" + X90());
        if (Y90() == false) goto L5;
        W90().flushDetailToFullCache$impl_mainlandRelease();
    L5:
        super.onPause();
    }

    public ServiceBotSettingFragment() {
        this.f296492f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotSettingViewModel.class), new ServiceBotSettingFragment$special$$inlined$activityViewModels$default$1(this), new ServiceBotSettingFragment$special$$inlined$activityViewModels$default$2(this));
        final Function0<Fragment> r100 = new ServiceBotSettingFragment$special$$inlined$viewModels$default$1(this);
        this.f296493g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServiceBotSettingViewModel.class), new ServiceBotSettingFragment$special$$inlined$viewModels$default$2(r100), new ServiceBotSettingFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f296494h = new com.larus.bmhome.bot.b();
    }

    public final String V90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("arg_service_bot_setting_title");
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String X90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("arg_service_bot_supplier_id");
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean Y90() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getBoolean("arg_service_bot_setting_is_sub_page", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final String getBotId() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("arg_service_bot_id");
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getConversationId() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("arg_service_bot_conversation_id");
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f296491e = null;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        FLogger.f375446a.i("ServiceBotSettingFragment", "onResume isSubPage=" + Y90() + " botId=" + getBotId() + " supplierId=" + X90());
        if (Y90() == true) goto L6;
        W90().refreshFromFullCache$impl_mainlandRelease();
        return;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.trace.tracknode.a.C4500a.a(this, r100);
        int r101 = e6.f296594a;
        String r102 = getBotId();
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "botId");
        if (r102.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r100.put("bot_id", r102);
    L8:
        r100.put("bot_type", 4);
        r100.put("chat_type", "notice");
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        LarusPageServiceBotSettingBinding r112 = this.f296491e;
        if (r112 == null) goto L14;
        NovaTitleBarEx.Y5(r112.f311246d, V90(), null, null, 6);
        NovaTitleBarEx.b6(r112.f311246d, v19.c.b(R.attr.larus_ic_left_back, requireContext(), R.drawable.larus_ic_left_back), false, null, getString(R.string.larus_accessibility_icon_back), new v5(this), 6);
        Bundle r113 = getArguments();
        boolean r100 = true;
        if (r113 == null) goto L8;
        r100 = r113.getBoolean("arg_service_bot_setting_show_menu", true ^ Y90());
    L11:
        if (r100 == false) goto L13;
        NovaTitleBarEx.i6(r112.f311246d, v19.c.b(R.attr.larus_ic_bot_setting, requireContext(), R.drawable.larus_ic_bot_setting), null, getString(R.string.larus_accessibility_icon_settings), new w5(this), 6);
    L13:
        Unit r114 = Unit.INSTANCE;
        goto L14
    L8:
        if (Y90() == false) goto L11;
        r100 = false;
    L14:
        ((BotSettingViewModel) this.f296492f.getValue()).getChatHistoryClearSuccess().observe(getViewLifecycleOwner(), new b(new u5(this)));
        W90().getUiState().observe(getViewLifecycleOwner(), new b(new s5(this)));
        W90().getEvent().observe(getViewLifecycleOwner(), new b(new t5(this)));
        W90().loadSettings(getBotId(), getConversationId(), X90(), V90(), Y90());
    }

    public static final Object U90(ServiceBotSettingFragment r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ServiceBotSettingFragment$findConversationInfo$1) == false) goto L7;
        ServiceBotSettingFragment$findConversationInfo$1 r103 = (ServiceBotSettingFragment$findConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        ServiceBotSettingFragment$findConversationInfo$1 r105 = r103;
        Object r106 = r105.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L17:
        wc9.e r109 = (wc9.e) r106;
        if (r109 == null) goto L20;
        FLogger.f375446a.d("ServiceBotSettingFragment", "Found conversation info: " + r109);
    L22:
        return r109;
    L20:
        r109 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r110 = RepoDispatcher.f307734f;
        r105.label = 1;
        r106 = IConversationRepoService.a.c(r110, r101, false, null, r105, 6);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r103 = new ServiceBotSettingFragment$findConversationInfo$1(r100, r102);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_page_service_bot_setting, r101, false);
        int r104 = R.id.container_layout;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.container_layout);
        if (r105 == null) goto L14;
        r104 = R.id.scroll_view;
        NestedScrollView r106 = (NestedScrollView) ViewBindings.findChildViewById(r103, R.id.scroll_view);
        if (r106 == null) goto L14;
        r104 = R.id.title;
        NovaTitleBarEx r107 = (NovaTitleBarEx) ViewBindings.findChildViewById(r103, R.id.title);
        if (r107 == null) goto L14;
        LinearLayout r108 = (LinearLayout) r103;
        this.f296491e = new LarusPageServiceBotSettingBinding(r108, r105, r106, r107);
        if (r108 == null) goto L12;
        return r108;
    L12:
        return new View(requireContext());
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
