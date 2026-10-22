package com.bytedance.ee.bear.lark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
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

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000202H\u0016J\b\u00105\u001a\u00020.H\u0002J\b\u00106\u001a\u000207H\u0016J \u00108\u001a\u0002022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0006H\u0016J\b\u0010?\u001a\u000202H\u0016J\u0010\u0010@\u001a\u0002022\u0006\u0010A\u001a\u000200H\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u000202H\u0016J\b\u0010E\u001a\u00020:H\u0016J\b\u0010F\u001a\u000202H\u0016J\u0010\u0010G\u001a\u0002022\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u0002022\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010K\u001a\u000202H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&¨\u0006M"}, d2 = {"Lcom/bytedance/ee/bear/lark/NewDocMainTabFragment;", "Lcom/ss/android/lark/maintab/export/BaseTabFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "containerId", "", "targetFragment", "Lcom/bytedance/ee/bear/lark/DocTabFragment;", "tabAppInfo", "Lcom/ss/android/lark/maintab/export/TabAppInfo;", "getTabAppInfo", "()Lcom/ss/android/lark/maintab/export/TabAppInfo;", "setTabAppInfo", "(Lcom/ss/android/lark/maintab/export/TabAppInfo;)V", "titleController", "Lcom/ss/android/lark/maintab/export/ITitleController;", "getTitleController", "()Lcom/ss/android/lark/maintab/export/ITitleController;", "setTitleController", "(Lcom/ss/android/lark/maintab/export/ITitleController;)V", "menuController", "Lcom/ss/android/lark/maintab/export/IMenuController;", "getMenuController", "()Lcom/ss/android/lark/maintab/export/IMenuController;", "setMenuController", "(Lcom/ss/android/lark/maintab/export/IMenuController;)V", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "setFgService", "(Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "forsetiProvider", "Lcom/ss/android/lark/maintab/export/IForsetiProvider;", "spacePlaceHolderFragment", "Lcom/bytedance/ee/bear/lark/CCMPlaceHolderFragment;", "getSpacePlaceHolderFragment", "()Lcom/bytedance/ee/bear/lark/CCMPlaceHolderFragment;", "spacePlaceHolderFragment$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "getRootView", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onBind", "needHandleBackPress", "", "onPageSelect", "tabSite", "Lcom/ss/android/lark/maintab/export/TabSite;", "tabIndex", "onPageUnSelect", "execCommand", "bundle", "getTabTitleConfig", "Lcom/ss/android/lark/maintab/export/ITabTitleConfig;", "onSingleClick", "onLongClick", "onTabDoubleClickedListener", "onUpdateTabInfo", "forsetiPlaceHolderFragment", "Lcom/ss/android/lark/api/ui/ForsetiPlaceHolderFragment;", "onBindForsetiProvider", "clearTopPageIfNeed", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewDocMainTabFragment extends Hilt_NewDocMainTabFragment implements d0c.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f227200l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f227201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DocTabFragment f227202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TabAppInfo f227203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.android.lark.maintab.export.d f227204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Inject
    public jdb.g f227205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f227206k;

    public static final class a {
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

    public NewDocMainTabFragment() {
        this.f227201f = View.generateViewId();
        this.f227206k = LazyKt.lazy(NewDocMainTabFragment$spacePlaceHolderFragment$2.INSTANCE);
        this.f227202g = new SidebarDocTabFragment();
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    L4:
        qbb.c r100 = new qbb.c(null);
        Intrinsics.checkNotNullParameter(r100, "userScopeView");
        r100.provideComponent();
        return r100.e9();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onresume");
        jdb.g r100 = ((dn4.a) e0c.k.b(d0c.b.b(this), dn4.a.class)).a();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f227205j = r100;
        Boolean r101 = ex4.a.f474715a;
        com.ss.android.lark.maintab.export.d r102 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fgService");
        r100 = null;
    L6:
        Intrinsics.checkNotNullParameter(r100, "fgService");
        ex4.a.f474715a = Boolean.valueOf(r100.isCurrentEnable("ccm.mobile.newspace"));
        Log.i("NewDocIsEnable", "reloadFgState()...enable = " + ex4.a.f474715a);
        jdb.g r103 = this.f227205j;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("fgService");
        r103 = null;
    L10:
        boolean r104 = ex4.a.a(r103);
        tt5.a.h("NewDocMainTabFragment", "onResume()... isNewDoc: " + r104);
        if (r104 == true) goto L13;
    L27:
        if (r104 == false) goto L29;
        return;
    L29:
        if ((this.f227202g instanceof SidebarDocTabFragment) == false) goto L45;
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onstart isOldDoc");
        this.f227202g = new DocTabFragment();
        TabAppInfo r105 = this.f227203h;
        if (r105 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("tabAppInfo");
        r105 = null;
    L34:
        com.ss.android.lark.maintab.export.d r106 = this.f227204i;
        if (r106 == null) goto L37;
        r102 = r106;
    L38:
        Intrinsics.throwUninitializedPropertyAccessException("menuController");
        t40(r105, r102);
        FragmentTransaction r107 = getChildFragmentManager().beginTransaction();
        r107.setReorderingAllowed(true);
        int r108 = this.f227201f;
        DocTabFragment r109 = this.f227202g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r109, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "childFragment", r108) == true) goto L42;
        r107.replace(r108, r109, "childFragment");
    L42:
        r107.commitNow();
        return;
    L37:
        Intrinsics.throwUninitializedPropertyAccessException("titleController");
        goto L38
    L45:
        return;
    L13:
        if ((this.f227202g instanceof SidebarDocTabFragment) == true) goto L27;
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onstart isNewDoc");
        this.f227202g = new SidebarDocTabFragment();
        TabAppInfo r110 = this.f227203h;
        if (r110 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("tabAppInfo");
        r110 = null;
    L18:
        com.ss.android.lark.maintab.export.d r111 = this.f227204i;
        if (r111 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("titleController");
        r111 = null;
    L22:
        Intrinsics.throwUninitializedPropertyAccessException("menuController");
        t40(r110, r111);
        FragmentTransaction r112 = getChildFragmentManager().beginTransaction();
        r112.setReorderingAllowed(true);
        int r113 = this.f227201f;
        DocTabFragment r114 = this.f227202g;
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type com.bytedance.ee.bear.lark.sidebar.SidebarDocTabFragment");
        SidebarDocTabFragment r115 = (SidebarDocTabFragment) r114;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r112, r115, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "childFragment", r113) == true) goto L26;
        r112.replace(r113, r115, "childFragment");
    L26:
        r112.commitNow();
        goto L27
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onviewcreated");
        FragmentTransaction r102 = getChildFragmentManager().beginTransaction();
        r102.setReorderingAllowed(true);
        int r103 = this.f227201f;
        DocTabFragment r104 = this.f227202g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r104, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "childFragment", r103) == true) goto L6;
        r102.replace(r103, r104, "childFragment");
    L6:
        r102.commitNow();
        by4.d r105 = null;
        if (ForsetiHelper.n() == false) goto L16;
        DocTabFragment r106 = this.f227202g;
        boolean r107 = r106 instanceof SidebarDocTabFragment;
        if (r107 == false) goto L16;
        if (r107 == false) goto L12;
        SidebarDocTabFragment r108 = (SidebarDocTabFragment) r106;
    L13:
        if (r108 == null) goto L16;
        r108.T = new AnonymousClass2(this);
        goto L16
    L12:
        r108 = null;
    L16:
        if (((Boolean) ForsetiHelper.f216454p.getValue()).booleanValue() == true) goto L18;
        return;
    L18:
        if ((this.f227202g instanceof SidebarDocTabFragment) == false) goto L26;
        CCMPlaceHolderFragment r109 = (CCMPlaceHolderFragment) this.f227206k.getValue();
        DocTabFragment r110 = this.f227202g;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ee.bear.lark.sidebar.SidebarDocTabFragment");
        by4.d r111 = ((SidebarDocTabFragment) r110).O;
        if (r111 == null) goto L22;
        r105 = r111;
    L23:
        r109.f227172n = r105;
        return;
    L22:
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        goto L23
    }

    @Override // com.ss.android.lark.maintab.export.BaseTabFragment, com.ss.android.lark.maintab.export.b
    public final void t40(TabAppInfo r100, com.ss.android.lark.maintab.export.d r101) {
        Intrinsics.checkNotNullParameter(r100, "tabAppInfo");
        Intrinsics.checkNotNullParameter(r101, "titleController");
        Intrinsics.checkNotNullParameter(null, "menuController");
        super.t40(r100, r101);
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment onbind");
        DocTabFragment r102 = this.f227202g;
        if (r102 == null) goto L5;
        r102.t40(r100, r101);
    L5:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f227203h = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f227204i = r101;
        Intrinsics.checkNotNullParameter(null, "<set-?>");
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        tt5.a.h("NewDocMainTabFragment", "NewDocMainTabFragment oncreateview");
        LinearLayout r103 = new LinearLayout(requireContext());
        r103.setOrientation(1);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r104 = new FrameLayout(requireContext());
        r104.setId(this.f227201f);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.addView(r104);
        return r103;
    }
}
