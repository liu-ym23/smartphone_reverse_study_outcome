package com.ss.android.lark.flow.threadwindow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0014\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "chatId", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupFragment", "args", "onNewIntent", "intent", "Landroid/content/Intent;", "onActivityResult", "requestCode", "", "resultCode", "data", "handleBack", "", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getChatId", "bundle", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowThreadWindowContainerFragment extends Hilt_FlowThreadWindowContainerFragment implements d0c.c, zsb.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f424110f;

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

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Inject
    public FlowThreadWindowContainerFragment() {
    }

    public final void A0(Intent r100) {
        if (r100 == null) goto L25;
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L26;
        String r102 = r101.getString("chatID");
        if (r102 != null) goto L9;
        r102 = r101.getString("chatID");
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        return;
    L17:
        Fragment r104 = getChildFragmentManager().findFragmentByTag(FlowThreadWindowFragment.class.getName());
        if ((r104 instanceof FlowThreadWindowFragment) == true) goto L20;
    L23:
        T90(r101);
        return;
    L20:
        if (Intrinsics.areEqual(r102, this.f424110f) == false) goto L23;
        ((FlowThreadWindowFragment) r104).A0(r100);
        return;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L26:
        return;
    }

    @Override // zsb.d
    public final boolean Cy(Notice r100) {
        String r101 = this.f424110f;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return t0.c(r100, r101);
    }

    public final void T90(Bundle r100) {
        if (r100 == null) goto L6;
        String r101 = r100.getString("chatID");
        if (r101 == null) goto L6;
    L10:
        if ((getChildFragmentManager().findFragmentByTag(FlowThreadWindowFragment.class.getName()) instanceof FlowThreadWindowFragment) == true) goto L12;
    L14:
        this.f424110f = r101;
        FlowThreadWindowFragment r102 = new FlowThreadWindowFragment();
        r102.setArguments(r100);
        FragmentTransaction r103 = getChildFragmentManager().beginTransaction();
        String r104 = FlowThreadWindowFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r104, R.id.fragment_container) == true) goto L18;
        r103 = r103.replace(R.id.fragment_container, r102, r104);
    L18:
        r103.commitAllowingStateLoss();
        return;
    L12:
        if (Intrinsics.areEqual(r101, this.f424110f) == false) goto L14;
        return;
    L6:
        if (r100 == null) goto L8;
        r101 = r100.getString("chatID");
        goto L10
    L8:
        r101 = null;
        goto L10
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        if (r100 == null) goto L4;
        r100.remove("android:support:fragments");
    L4:
        super.onCreate(r100);
        v4b.a.a(requireContext());
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        T90(getArguments());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Fragment r103 = getChildFragmentManager().findFragmentById(R.id.fragment_container);
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.setId(R.id.fragment_container);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r103;
    }
}
