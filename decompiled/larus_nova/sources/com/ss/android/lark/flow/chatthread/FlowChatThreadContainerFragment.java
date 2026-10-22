package com.ss.android.lark.flow.chatthread;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.flow.chatthread.page.FlowChatThreadFragment;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/flow/chatthread/FlowChatThreadContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mFragment", "Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadFragment;", "getMFragment", "()Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadFragment;", "setMFragment", "(Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadFragment;)V", "onCreateView", "Landroid/widget/FrameLayout;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_CREATE, "", "initData", "setupFragment", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowChatThreadContainerFragment extends Hilt_FlowChatThreadContainerFragment implements d0c.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Inject
    public FlowChatThreadFragment f423160f;

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
        return d0c.b.a(this);
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
        return d0c.b.b(this);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Inject
    public FlowChatThreadContainerFragment() {
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);     // Catch: Exception -> L4
    L10:
        if (getArguments() != null) goto L12;
        Log.e("ChatThread bundle param is null");
        zab.a.a(this);
    L12:
        FlowChatThreadFragment r101 = this.f423160f;
        FlowChatThreadFragment r102 = null;
        if (r101 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r101 = null;
    L16:
        r101.setArguments(getArguments());
        FragmentTransaction r103 = getChildFragmentManager().beginTransaction();
        FlowChatThreadFragment r104 = this.f423160f;
        if (r104 == null) goto L19;
        r102 = r104;
    L20:
        String r105 = FlowChatThreadFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r105, R.id.fragment_container) == true) goto L24;
        r103.add(R.id.fragment_container, r102, r105);
    L24:
        r103.commitNowAllowingStateLoss();
        return;
    L19:
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
    L4:
        e = move-exception;
        ImSdk r106 = ImSdk.f425890a;
        boolean r107 = ImSdk.f425892c;
        boolean r108 = OfficeSDKManager.isAvailable();
        if (r108 == false) goto L26;
        if (r107 == true) goto L10;
    L26:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r108 + ", im sdk ready: " + r107 + ", onCreateFail. fallback. " + e.getMessage());
        int r109 = gza.a.f483430a;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.setId(R.id.chat_container);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r103;
    }
}
