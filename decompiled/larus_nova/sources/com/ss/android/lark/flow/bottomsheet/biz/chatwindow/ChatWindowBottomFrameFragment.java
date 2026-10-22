package com.ss.android.lark.flow.bottomsheet.biz.chatwindow;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.flow.chat.page.flow.FlowChatFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import fsb.f;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u001a\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010\"2\u0006\u0010(\u001a\u00020\bH\u0002J\f\u0010)\u001a\u00020**\u00020\"H\u0002J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020 H\u0002J\"\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010*H\u0016J\u0012\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\bH\u0016J\u0012\u00106\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u00010*H\u0016J\u0012\u00108\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020<H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006>"}, d2 = {"Lcom/ss/android/lark/flow/bottomsheet/biz/chatwindow/ChatWindowBottomFrameFragment;", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFrameFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mChatId", "", "mIsFromNotification", "", "chatWindowFragment", "Lcom/ss/android/lark/flow/chat/page/flow/FlowChatFragment;", "getChatWindowFragment", "()Lcom/ss/android/lark/flow/chat/page/flow/FlowChatFragment;", "setChatWindowFragment", "(Lcom/ss/android/lark/flow/chat/page/flow/FlowChatFragment;)V", "userService", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "getUserService", "()Lcom/ss/android/lark/passportc/api/IPassportUserService;", "setUserService", "(Lcom/ss/android/lark/passportc/api/IPassportUserService;)V", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "activityHookManager", "Lcom/ss/android/lark/chat/core/extension/ActivityHookManager;", "radiusTopContainer", "", "getRadiusTopContainer", "()F", "setRadiusTopContainer", "(F)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "initContentContainer", "contentContainer", "configActivityHook", "resolveArguments", "arguments", "fromNewIntent", "pack", "Landroid/content/Intent;", "showChatFragment", "statisticsPrefIfNeed", "onActivityResult", "requestCode", "", "resultCode", "data", "onProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "handleBack", "onNewIntent", "intent", "notifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowBottomFrameFragment extends Hilt_ChatWindowBottomFrameFragment implements c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f421964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f421965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Inject
    public FlowChatFragment f421966n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Inject
    public m f421967o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FrameLayout f421968p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.ss.android.lark.chat.core.extension.a f421969q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f421970r;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public ChatWindowBottomFrameFragment() {
        this.f421970r = 24.0f;
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.d
    public final boolean l1() {
        FragmentManager r100 = getChildFragmentManager();
        FrameLayout r101 = this.f421968p;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
        r101 = null;
    L5:
        Fragment r102 = r100.findFragmentById(r101.getId());
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L13;
    L18:
        com.ss.android.lark.chat.core.extension.a r104 = this.f421969q;
        if (r104 != null) goto L21;
    L23:
        boolean r105 = false;
    L24:
        if (r105 == false) goto L26;
        return true;
    L26:
        return false;
    L21:
        if (r104.b() != true) goto L23;
        r105 = true;
        goto L24
    L13:
        if (r102.isAdded() == false) goto L18;
        if ((r102 instanceof FrameFragment) == false) goto L18;
        return ((FrameFragment) r102).l1();
    L8:
        if (r102.isVisible() != true) goto L10;
        r103 = true;
        goto L11
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment
    public final float S90() {
        return this.f421970r;
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.d
    public final void A0(Intent r100) {
        if (r100 == null) goto L4;
        Bundle r101 = r100.getExtras();
    L5:
        V90(r101, true);
        if (r100 == null) goto L11;
        com.ss.android.lark.chat.core.extension.a r102 = this.f421969q;
        if (r102 == null) goto L12;
        r102.e(r100);
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment, com.ss.android.lark.bottomsheet.fragment.d
    public final void aP(AssistContent r100) {
        FragmentManager r101 = getChildFragmentManager();
        FrameLayout r102 = this.f421968p;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
        r102 = null;
    L5:
        Fragment r103 = r101.findFragmentById(r102.getId());
        boolean r104 = false;
        if (r103 != null) goto L8;
    L10:
        if (r104 == true) goto L12;
    L16:
        com.ss.android.lark.chat.core.extension.a r105 = this.f421969q;
        if (r105 == null) goto L20;
        r105.g(r100);
        return;
    L20:
        return;
    L12:
        if (r103.isAdded() == false) goto L16;
        if ((r103 instanceof FrameFragment) == false) goto L16;
        ((FrameFragment) r103).aP(r100);
        goto L16
    L8:
        if (r103.isVisible() != true) goto L10;
        r104 = true;
        goto L10
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        ChatCoreModule.a().getPerfEnterChatMonitor().l(false);
        f.c("ChatWindowBottomFrameFragment").j();
        f.b().i(WidgetCostModule.TYPE_ON_CREATE);
        super.onCreate(r100);
        if (ChatCoreModule.a().getLoginDependency().isLogin() == true) goto L6;
        finish();
        return;
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.d
    public final boolean y30(Notice r100) {
        String r101 = this.f421964l;
        if (r101 != null) goto L7;
        return true;
    L7:
        return t0.a(r100, r101);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment
    public final void T90(FrameLayout r100, final Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "contentContainer");
        this.f421968p = r100;
        V90(getArguments(), false);
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L5;
        this.f421969q = new com.ss.android.lark.chat.core.extension.a(r102);
    L5:
        getViewLifecycleOwner().getLifecycle().addObserver(new ChatWindowBottomFrameFragment$configActivityHook$2(this, r101));
        com.ss.android.lark.chat.core.extension.a r103 = this.f421969q;
        if (r103 == null) goto L8;
        r103.c(r101);
    L8:
        f.b().h(WidgetCostModule.TYPE_ON_CREATE);
    }

    public final void V90(Bundle r100, boolean r101) {
        Bundle r102 = getArguments();
        FlowChatFragment r103 = null;
        if (r102 == null) goto L5;
        fxa.b r104 = fxa.a.a(r102);
    L7:
        if (r104 == null) goto L10;
        String r105 = r104.q();
        if (r105 == null) goto L10;
    L11:
        boolean r106 = true;
        if (StringsKt.equals("notification", r105, true) == false) goto L14;
        ChatCoreModule.a().getPerfEnterChatMonitor().a(SourceType.PUSH.value);
    L15:
        this.f421965m = r106;
        Log.i("chatwindow", "statisticsPrefIfNeed:" + r105 + ", isFromNotification:" + this.f421965m);
        if (r100 != null) goto L19;
        finish();
        return;
    L19:
        this.f421964l = r100.getString("chatID");
        Log.i("chatwindow", "Enter chat:" + this.f421964l);
        FragmentManager r107 = getChildFragmentManager();
        FrameLayout r108 = this.f421968p;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
        r108 = null;
    L22:
        Fragment r109 = r107.findFragmentById(r108.getId());
        if (r109 == null) goto L28;
        if (r101 == false) goto L28;
        if ((r109 instanceof FlowChatFragment) == false) goto L45;
        Intent r110 = new Intent();
        r110.putExtras(r100);
        ((FlowChatFragment) r109).A0(r110);
        return;
    L45:
        return;
    L28:
        PerfLog.start("showChatFragment", "");
        FlowChatFragment r111 = this.f421966n;
        if (r111 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("chatWindowFragment");
        r111 = null;
    L32:
        r111.setArguments(getArguments());
        FragmentTransaction r112 = getChildFragmentManager().beginTransaction();
        FrameLayout r113 = this.f421968p;
        if (r113 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
        r113 = null;
    L35:
        int r114 = r113.getId();
        FlowChatFragment r115 = this.f421966n;
        if (r115 == null) goto L38;
        r103 = r115;
    L39:
        String r116 = FlowChatFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r112, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r116, r114) == true) goto L43;
        r112.add(r114, r103, r116);
    L43:
        r112.commitAllowingStateLoss();
        return;
    L38:
        Intrinsics.throwUninitializedPropertyAccessException("chatWindowFragment");
        goto L39
    L14:
        r106 = false;
    L10:
        r105 = "";
        goto L11
    L5:
        r104 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        FragmentManager r103 = getChildFragmentManager();
        FrameLayout r104 = this.f421968p;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
        r104 = null;
    L5:
        Fragment r105 = r103.findFragmentById(r104.getId());
        if (r105 == null) goto L8;
        r105.onActivityResult(r100, r101, r102);
    L8:
        com.ss.android.lark.chat.core.extension.a r106 = this.f421969q;
        if (r106 == null) goto L12;
        r106.a(r100, r101, r102);
        return;
    }
}
