package com.bytedance.ee.bear.lark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.lark.sidebar.SidebarDocTabFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000202H\u0016J\b\u00105\u001a\u00020.H\u0002J\b\u00106\u001a\u000207H\u0016J \u00108\u001a\u0002022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0006H\u0016J\b\u0010?\u001a\u000202H\u0016J\u0010\u0010@\u001a\u0002022\u0006\u0010A\u001a\u000200H\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u000202H\u0016J\b\u0010E\u001a\u00020:H\u0016J\b\u0010F\u001a\u000202H\u0016J\u0010\u0010G\u001a\u0002022\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u0002022\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010K\u001a\u000202H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&¨\u0006M"}, d2 = {"Lcom/bytedance/ee/bear/lark/NewDocMainTabFragment;", "Lcom/ss/android/lark/maintab/export/BaseTabFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "containerId", "", "targetFragment", "Lcom/bytedance/ee/bear/lark/DocTabFragment;", "tabAppInfo", "Lcom/ss/android/lark/maintab/export/TabAppInfo;", "getTabAppInfo", "()Lcom/ss/android/lark/maintab/export/TabAppInfo;", "setTabAppInfo", "(Lcom/ss/android/lark/maintab/export/TabAppInfo;)V", "titleController", "Lcom/ss/android/lark/maintab/export/ITitleController;", "getTitleController", "()Lcom/ss/android/lark/maintab/export/ITitleController;", "setTitleController", "(Lcom/ss/android/lark/maintab/export/ITitleController;)V", "menuController", "Lcom/ss/android/lark/maintab/export/IMenuController;", "getMenuController", "()Lcom/ss/android/lark/maintab/export/IMenuController;", "setMenuController", "(Lcom/ss/android/lark/maintab/export/IMenuController;)V", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "setFgService", "(Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "forsetiProvider", "Lcom/ss/android/lark/maintab/export/IForsetiProvider;", "spacePlaceHolderFragment", "Lcom/bytedance/ee/bear/lark/CCMPlaceHolderFragment;", "getSpacePlaceHolderFragment", "()Lcom/bytedance/ee/bear/lark/CCMPlaceHolderFragment;", "spacePlaceHolderFragment$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "getRootView", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onBind", "needHandleBackPress", "", "onPageSelect", "tabSite", "Lcom/ss/android/lark/maintab/export/TabSite;", "tabIndex", "onPageUnSelect", "execCommand", "bundle", "getTabTitleConfig", "Lcom/ss/android/lark/maintab/export/ITabTitleConfig;", "onSingleClick", "onLongClick", "onTabDoubleClickedListener", "onUpdateTabInfo", "forsetiPlaceHolderFragment", "Lcom/ss/android/lark/api/ui/ForsetiPlaceHolderFragment;", "onBindForsetiProvider", "clearTopPageIfNeed", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewDocMainTabFragment extends Hilt_NewDocMainTabFragment implements d0c.c {
    public static final /* synthetic */ int l = 0;
    public final int f;
    public DocTabFragment g;
    public TabAppInfo h;
    public com.ss.android.lark.maintab.export.d i;

    @Inject
    public jdb.g j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public NewDocMainTabFragment() {
        this.f = View.generateViewId();
        this.k = LazyKt.lazy(NewDocMainTabFragment$spacePlaceHolderFragment$2.INSTANCE);
        this.g = new SidebarDocTabFragment();
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    L4:
        qbb.c r0 = new qbb.c(null);
        Intrinsics.checkNotNullParameter(r0, "userScopeView");
        r0.provideComponent();
        return r0.e9();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onresume");
        jdb.g r1 = ((dn4.a) e0c.k.b(d0c.b.b(this), dn4.a.class)).a();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.j = r1;
        Boolean r2 = ex4.a.a;
        com.ss.android.lark.maintab.export.d r3 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fgService");
        r1 = null;
    L6:
        Intrinsics.checkNotNullParameter(r1, "fgService");
        ex4.a.a = Boolean.valueOf(r1.isCurrentEnable("ccm.mobile.newspace"));
        Log.i("NewDocIsEnable", "reloadFgState()...enable = " + ex4.a.a);
        jdb.g r4 = this.j;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("fgService");
        r4 = null;
    L10:
        boolean r5 = ex4.a.a(r4);
        tt5.a.h("NewDocMainTabFragment", "onResume()... isNewDoc: " + r5);
        if (r5 == true) goto L13;
    L27:
        if (r5 == false) goto L29;
        return;
    L29:
        if ((this.g instanceof SidebarDocTabFragment) == false) goto L45;
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onstart isOldDoc");
        this.g = new DocTabFragment();
        TabAppInfo r0 = this.h;
        if (r0 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("tabAppInfo");
        r0 = null;
    L34:
        com.ss.android.lark.maintab.export.d r6 = this.i;
        if (r6 == null) goto L37;
        r3 = r6;
    L38:
        Intrinsics.throwUninitializedPropertyAccessException("menuController");
        t40(r0, r3);
        FragmentTransaction r7 = getChildFragmentManager().beginTransaction();
        r7.setReorderingAllowed(true);
        int r8 = this.f;
        DocTabFragment r9 = this.g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "childFragment", r8) == true) goto L42;
        r7.replace(r8, r9, "childFragment");
    L42:
        r7.commitNow();
        return;
    L37:
        Intrinsics.throwUninitializedPropertyAccessException("titleController");
        goto L38
    L45:
        return;
    L13:
        if ((this.g instanceof SidebarDocTabFragment) == true) goto L27;
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onstart isNewDoc");
        this.g = new SidebarDocTabFragment();
        TabAppInfo r10 = this.h;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("tabAppInfo");
        r10 = null;
    L18:
        com.ss.android.lark.maintab.export.d r11 = this.i;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("titleController");
        r11 = null;
    L22:
        Intrinsics.throwUninitializedPropertyAccessException("menuController");
        t40(r10, r11);
        FragmentTransaction r12 = getChildFragmentManager().beginTransaction();
        r12.setReorderingAllowed(true);
        int r13 = this.f;
        DocTabFragment r14 = this.g;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.bytedance.ee.bear.lark.sidebar.SidebarDocTabFragment");
        SidebarDocTabFragment r16 = (SidebarDocTabFragment) r14;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "childFragment", r13) == true) goto L26;
        r12.replace(r13, r16, "childFragment");
    L26:
        r12.commitNow();
        goto L27
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m420provideComponent() {
        return provideComponent();
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onViewCreated(r4, r5);
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onviewcreated");
        FragmentTransaction r6 = getChildFragmentManager().beginTransaction();
        r6.setReorderingAllowed(true);
        int r7 = this.f;
        DocTabFragment r0 = this.g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "childFragment", r7) == true) goto L6;
        r6.replace(r7, r0, "childFragment");
    L6:
        r6.commitNow();
        by4.d r8 = null;
        if (ForsetiHelper.n() == false) goto L16;
        DocTabFragment r9 = this.g;
        boolean r1 = r9 instanceof SidebarDocTabFragment;
        if (r1 == false) goto L16;
        if (r1 == false) goto L12;
        SidebarDocTabFragment r10 = (SidebarDocTabFragment) r9;
    L13:
        if (r10 == null) goto L16;
        r10.T = new AnonymousClass2(this);
        goto L16
    L12:
        r10 = null;
    L16:
        if (((Boolean) ForsetiHelper.p.getValue()).booleanValue() == true) goto L18;
        return;
    L18:
        if ((this.g instanceof SidebarDocTabFragment) == false) goto L26;
        CCMPlaceHolderFragment r11 = (CCMPlaceHolderFragment) this.k.getValue();
        DocTabFragment r2 = this.g;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.lark.sidebar.SidebarDocTabFragment");
        by4.d r3 = ((SidebarDocTabFragment) r2).O;
        if (r3 == null) goto L22;
        r8 = r3;
    L23:
        r11.n = r8;
        return;
    L22:
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        goto L23
    }

    public final void t40(TabAppInfo r4, com.ss.android.lark.maintab.export.d r5) {
        Intrinsics.checkNotNullParameter(r4, "tabAppInfo");
        Intrinsics.checkNotNullParameter(r5, "titleController");
        Intrinsics.checkNotNullParameter(null, "menuController");
        super.t40(r4, r5);
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onbind");
        DocTabFragment r0 = this.g;
        if (r0 == null) goto L5;
        r0.t40(r4, r5);
    L5:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.h = r4;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.i = r5;
        Intrinsics.checkNotNullParameter(null, "<set-?>");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment oncreateview");
        LinearLayout r5 = new LinearLayout(requireContext());
        r5.setOrientation(1);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r6 = new FrameLayout(requireContext());
        r6.setId(this.f);
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r5.addView(r6);
        return r5;
    }
}
