package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.MessageFullScreenPluginAdapter$observer$2;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.MessageFullScreenRichTextSetup;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = MessageFullScreenActivity.class)
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u001c2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00104\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u000106J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020%H\u0002J\u0010\u00109\u001a\u00020+2\u0006\u00108\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020+H\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020+H\u0002J\b\u0010F\u001a\u00020+H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010?\u001a\u0014\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020+0@X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010C\u001a\u001c\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0004\u0012\u00020+0DX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "offlineCacheClean", "Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheClean;", "getOfflineCacheClean", "()Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheClean;", "setOfflineCacheClean", "(Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheClean;)V", "exitAction", "Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheCleanAction;", "viewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel;", "getViewModel", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "messageDetailWrapper", "Landroid/view/ViewGroup;", "contentTV", "Lcom/ss/android/lark/widget/light/LKUILightTextView;", "translateTV", "contentZone", "Landroidx/constraintlayout/widget/ConstraintLayout;", "attachmentList", "Landroid/widget/LinearLayout;", "dividerView", "Landroid/view/View;", LynxTemplateRender.RENDER_PHASE_SETUP, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/view/MessageFullScreenRichTextSetup;", "pluginContainers", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/plugin/MessageFullScreenPluginAdapter;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "onViewCreated", "view", "onNewIntent", "intent", "Landroid/content/Intent;", "fitWindow", "rootView", "initView", "initViewModel", "bindAttachments", "initData", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel$InitData;", "initPlugins", "replyMessageHandler", "Lkotlin/Function2;", "", "Lcom/ss/android/lark/biz/im/extension/PageType;", "replyPartialMessageHandler", "Lkotlin/Function3;", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageFullScreenFragment extends Hilt_MessageFullScreenFragment implements d0c.c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f413942t = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Inject
    public v f413943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.chat.export.offlineCacheClean.a f413944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f413945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f413946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f413947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LKUILightTextView f413948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LKUILightTextView f413949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f413950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f413951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f413952o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MessageFullScreenRichTextSetup f413953p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.b f413954q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function2<String, PageType, Unit> f413955r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function3<String, PageType, PartialReplyInfo, Unit> f413956s;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.chat.export.offlineCacheClean.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageFullScreenFragment f413957a;

        @Override // com.ss.android.lark.chat.export.offlineCacheClean.b
        public final void a() {
            Context r100 = this.f413957a.getContext();
            if (r100 == null) goto L7;
            boolean r101 = true;
            if (ForsetiConfig.a(r100) != true) goto L7;
        L8:
            if (r101 == false) goto L10;
            zab.a.a(this.f413957a);
            return;
        L10:
            this.f413957a.finish();
            return;
        L7:
            r101 = false;
            goto L8
        }

        public b(MessageFullScreenFragment r100) {
            this.f413957a = r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final MessageFullScreenViewModel T90() {
        return (MessageFullScreenViewModel) this.f413946i.getValue();
    }

    public MessageFullScreenFragment() {
        this.f413945h = new b(this);
        final Function0<Fragment> r100 = new MessageFullScreenFragment$special$$inlined$viewModels$default$1(this);
        this.f413946i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MessageFullScreenViewModel.class), new MessageFullScreenFragment$special$$inlined$viewModels$default$2(r100), new MessageFullScreenFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f413955r = new MessageFullScreenFragment$replyMessageHandler$1(this);
        this.f413956s = new MessageFullScreenFragment$replyPartialMessageHandler$1(this);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        MessageFullScreenRichTextSetup r100 = this.f413953p;
        if (r100 == null) goto L8;
        Iterator r101 = ((HashMap) r100.f414014g).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.a) ((Map.Entry) r101.next()).getValue()).clear();
    L8:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.b r102 = this.f413954q;
        if (r102 == null) goto L11;
        r102.f413999a.getLifecycle().removeObserver((MessageFullScreenPluginAdapter$observer$2.AnonymousClass1) r102.f414002d.getValue());
    L11:
        com.ss.android.lark.chat.export.offlineCacheClean.a r103 = this.f413944g;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("offlineCacheClean");
        r103 = null;
    L15:
        r103.Ib(this.f413945h);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        com.ss.android.lark.chat.export.offlineCacheClean.a r101 = this.f413944g;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("offlineCacheClean");
        r101 = null;
    L6:
        r101.Wa(this.f413945h);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ViewCompat.setOnApplyWindowInsetsListener(r100, new h(this));
        this.f413948k = (LKUILightTextView) r100.findViewById(R.id.tv_content);
        this.f413949l = (LKUILightTextView) r100.findViewById(R.id.tv_translate_content);
        this.f413950m = (ConstraintLayout) r100.findViewById(R.id.inner_content);
        this.f413951n = (LinearLayout) r100.findViewById(R.id.attachment_list);
        this.f413952o = r100.findViewById(R.id.divider);
        this.f413947j = (ViewGroup) r100.findViewById(R.id.message_detail_wrapper);
        int r102 = MessageFullScreenRichTextSetup.f414007k;
        Context r103 = requireContext();
        Function1<MessageFullScreenRichTextSetup, Unit> r104 = new MessageFullScreenFragment$initView$1(this);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, LynxTemplateRender.RENDER_PHASE_SETUP);
        MessageFullScreenRichTextSetup r105 = new MessageFullScreenRichTextSetup(r103);
        r104.invoke(r105);
        this.f413953p = r105;
        T90().getError().observe(this, new i(this));
        T90().getInitLiveData().observe(this, new j(this));
        T90().getLaunch().observe(this, new k(this));
        T90().getChatLiveData().observe(this, new l(this));
        T90().parseArguments(getArguments());
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_message_full_screen, r101, false);
    }
}
