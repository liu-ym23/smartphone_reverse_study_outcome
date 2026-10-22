package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.search.SelectFolderConfig;
import com.bytedance.ee.bear.search.SelectPickerConfig;
import com.bytedance.ee.bear.search.SelectTabConfig;
import com.bytedance.ee.bear.search.SelectTitleConfig;
import com.bytedance.ee.bear.search.SelectWikiConfig;
import com.bytedance.ee.bear.search.picker.filter.folder.SearchFolderFragment;
import com.bytedance.ee.bear.search.picker.filter.wiki.WikiSearchPickerFragment;
import com.bytedance.ee.bear.wikiv2.home.viewall_multitab.WikiSpaceTabFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import iq5.b0;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002J\"\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J\"\u00100\u001a\u00020\u00132\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010.H\u0002J\b\u00101\u001a\u00020\tH\u0016J\b\u00102\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/SelectorFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "selectorConfig", "Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "isShortCut", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initData", "initFragment", "showRootSelectFragment", "showWikiDirect", "openMyLibrary", "openWiki", "data", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiTreeNavigationData;", "openMySpace", "openSharedSpace", "openFolder", "bean", "Lcom/bytedance/ee/bear/list/selector/OpenFolderBean;", "getOwnerType", "", "openAllSearch", "openSpaceSearch", "commitFragment", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "back", "fragmentActivityResult", "onBackPressed", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectorFragment extends Hilt_SelectorFragment implements com.bytedance.ee.bear.wikiv2.searchv2.a, d0c.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SelectorConfig f241123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f241124h;

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

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void DR() {
        tt5.a.h("SelectorFragment", "openAllSearch()...");
        SelectorConfig r100 = this.f241123g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r100 = null;
    L6:
        if (r100.f229374f != SelectorScope.SPACE_ONLY) goto L8;
        vZ();
        return;
    L8:
        String r101 = getString(R.string.Doc_Facade_Search);
        SelectorConfig r102 = this.f241123g;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r102 = null;
    L12:
        if (r102.f229369a == SelectorType.WIKI_MOVE_TO) goto L14;
    L16:
        boolean r103 = true;
    L17:
        SelectTabConfig r110 = new SelectTabConfig(r103, false, false, 6, null);
        SelectTitleConfig r111 = new SelectTitleConfig(true, r101);
        SelectPickerConfig r104 = new SelectPickerConfig(PickerStatistics.Scene.CcmSearchInWikiAndFolder, false, false, false, new SelectWikiConfig(true), r111, r110);
        Bundle r105 = getArguments();
        if (r105 == null) goto L20;
        r105.putSerializable("KEY_PICKER_CONFIG", r104);
    L20:
        WikiSearchPickerFragment r106 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.c(com.bytedance.ee.bear.search.b.class, null, null, 6)).c(requireContext(), r105);
        Intrinsics.checkNotNull(r106);
        V90(r106);
        return;
    L14:
        if (this.f241124h == false) goto L16;
        r103 = false;
        goto L17
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void E5() {
        tt5.a.h("SelectorFragment", "openMySpace()...");
        int r100 = jq5.a.f500067a;
        if (qc5.a.h() == false) goto L5;
        int r101 = R.string.Doc_List_My_Folder;
    L6:
        String r102 = getString(r101);
        int r103 = FolderSource.MY_SPACE.getSource();
        qc5.a.j();
        FolderVersion.Companion.getClass();
        j7(new td5.e(4, "", r102, false, r103, 5, false));
        return;
    L5:
        r101 = R.string.Doc_List_My_Space;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void U5() {
        tt5.a.h("SelectorFragment", "openMyLibrary()...");
        Context r100 = requireContext();
        Bundle r101 = getArguments();
        SelectorConfig r102 = this.f241123g;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r102 = null;
    L5:
        com.bytedance.ee.bear.wikiv2.wikitreev2.j.a(r100, r101, r102.f229375g, new ce5.a(this), this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void V6() {
        tt5.a.h("SelectorFragment", "openWiki()...");
        WikiSpaceTabFragment r100 = new WikiSpaceTabFragment();
        r100.setArguments(getArguments());
        V90(r100);
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void Z3() {
        tt5.a.h("SelectorFragment", "openSharedSpace()...");
        String r100 = getString(jq5.a.a());
        int r101 = FolderSource.SHARED_SPACE.getSource();
        qc5.a.j();
        FolderVersion.Companion.getClass();
        j7(new td5.e(6, "", r100, true, r101, 5, false));
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void vZ() {
        tt5.a.h("SelectorFragment", "openSpaceSearch()...");
        String r100 = getString(R.string.Doc_Facade_SelectFolder);
        SelectFolderConfig r101 = new SelectFolderConfig(PickerStatistics.Scene.CcmSearchFolder, false, r100, false, false, 16, null);
        SearchFolderFragment r102 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.c(com.bytedance.ee.bear.search.b.class, null, null, 6)).b(requireContext(), r101);
        Intrinsics.checkNotNull(r102);
        V90(r102);
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void back() {
        if (onBackPressed() == false) goto L5;
        return;
    L5:
        com.suite.lark.component.navroute.forseti.g r100 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r100 == null) goto L9;
        r100.g(null);
        return;
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        int r100 = getChildFragmentManager().getBackStackEntryCount();
        tt5.a.h("SelectorFragment", "onBackPressed()... count: " + r100);
        if (r100 < 1) goto L7;
        getChildFragmentManager().popBackStack();
        return true;
    L7:
        return super.onBackPressed();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        SelectorConfig.CREATOR.getClass();
        SelectorConfig.f229368k = null;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public SelectorFragment() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void Ct(com.bytedance.ee.bear.wikiv2.searchv2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        SelectorConfig r101 = null;
        com.bytedance.ee.bear.contract.route.parcelable.f r102 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        Context r103 = requireContext();
        Bundle r104 = getArguments();
        SelectorConfig r105 = this.f241123g;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
    L6:
        r102.b(r103, r100, r104, r101.f229375g, this);
        return;
    L5:
        r101 = r105;
        goto L6
    }

    public final void V90(Fragment r100) {
        FragmentTransaction r101 = getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.facade_slide_right_in, R.anim.facade_slide_left_out, R.anim.facade_slide_left_in, R.anim.facade_slide_right_out);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r101, r100, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.selector_container) == true) goto L6;
        r101 = r101.add(R.id.selector_container, r100);
    L6:
        r101.addToBackStack(null).commitAllowingStateLoss();
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void j7(td5.e r110) {
        Intrinsics.checkNotNullParameter(r110, "bean");
        tt5.a.h("SelectorFragment", "openFolder()...folderType = " + r110 + ".folderType, isShareFolder = " + r110 + ".isShareFolder, ownerType = " + r110 + ".ownerType");
        int r100 = FolderSelectFragment.f241083s;
        FragmentManager r101 = getChildFragmentManager();
        Context r102 = requireContext();
        int r103 = r110.f545508a;
        String r104 = r110.f545509b;
        String r105 = r110.f545510c;
        int r106 = r110.f545513f;
        boolean r107 = r110.f545511d;
        boolean r108 = r110.f545514g;
        int r109 = r110.f545512e;
        Bundle r111 = getArguments();
        boolean r112 = false;
        if (r111 == null) goto L5;
        r112 = r111.getBoolean("extra_is_at_vc", false);
    L5:
        V90(FolderSelectFragment.a.a(r101, r102, r103, r104, r105, r106, r107, r108, r109, r112, getArguments(), r110.f545515h));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        if (r102 != null) goto L7;
        tt5.a.h("SelectorFragment", "bundle is null.");
        com.suite.lark.component.navroute.forseti.g r103 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r103 == null) goto L7;
        r103.g(null);
    L7:
        if (r102 == null) goto L10;
        SelectorConfig r104 = (SelectorConfig) r102.getParcelable(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG);
        if (r104 == null) goto L10;
    L11:
        this.f241123g = r104;
        boolean r105 = false;
        if (r102 == null) goto L14;
        boolean r106 = r102.getBoolean("src_is_shortcut");
    L15:
        this.f241124h = r106;
        StringBuilder r107 = new StringBuilder("initFragment()...selectorConfig = ");
        SelectorConfig r108 = this.f241123g;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r108 = null;
    L18:
        r107.append(r108);
        tt5.a.h("SelectorFragment", r107.toString());
        if (qc5.a.c() == false) goto L21;
    L22:
        String r109 = dq5.j.a(new ce5.a(this));
        if (r109 != null) goto L25;
    L28:
        boolean r110 = true;
    L29:
        if (r110 == true) goto L31;
        r105 = true;
    L31:
        SelectorConfig r111 = this.f241123g;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r111 = null;
    L35:
        if (r111.f229374f != SelectorScope.WIKI_ONLY) goto L42;
        if (r105 == true) goto L42;
        tt5.a.h("SelectorFragment", "showWikiDirect()...");
        WikiSpaceTabFragment r112 = new WikiSpaceTabFragment();
        r112.setArguments(getArguments());
        FragmentTransaction r113 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r113, r112, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "WikiSpaceTabFragment", R.id.selector_container) == true) goto L41;
        r113 = r113.replace(R.id.selector_container, r112, "WikiSpaceTabFragment");
    L41:
        r113.commitAllowingStateLoss();
    L47:
        FragmentBackPressedHelperKt.a(this, new b0(this));
        View r114 = getView();
        if (r114 == null) goto L51;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.h.a(r114);
        return;
    L51:
        return;
    L42:
        tt5.a.h("SelectorFragment", "showRootSelectFragment()...");
        FragmentManager r115 = getChildFragmentManager();
        FragmentTransaction r116 = getChildFragmentManager().beginTransaction();
        int r117 = RootSelectFragment.f241114m;
        Fragment r118 = RootSelectFragment.a.a(r115, requireContext(), getArguments());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r116, r118, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.selector_container) == true) goto L46;
        r116 = r116.add(R.id.selector_container, r118);
    L46:
        r116.commitAllowingStateLoss();
        goto L47
    L25:
        if (r109.length() == 0) goto L28;
        r110 = false;
        goto L29
    L21:
        if (qc5.a.h() == false) goto L31;
    L14:
        r106 = false;
    L10:
        r104 = new SelectorConfig();
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        tt5.a.h("SelectorFragment", "onActivityResult()...requestCode = " + r100 + ", resultCode = " + r101);
        Iterator<Fragment> r103 = getChildFragmentManager().getFragments().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r103.next().onActivityResult(r100, r101, r102);
        goto L4
    L7:
        if (r100 != 1024) goto L9;
    L14:
        if (r101 != (-1)) goto L16;
    L52:
        com.suite.lark.component.navroute.forseti.g r104 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r104 == null) goto L66;
        if (r102 == null) goto L57;
        Bundle r105 = r102.getExtras();
        if (r105 == null) goto L57;
    L58:
        r104.c(r101, r105);
        return;
    L57:
        r105 = new Bundle();
        goto L58
    L66:
        return;
    L16:
        if (r101 == 100) goto L52;
    L18:
        if (r101 == 101) goto L52;
        if (r100 != 1025) goto L23;
    L44:
        if (r101 != (-1)) goto L63;
        com.suite.lark.component.navroute.forseti.g r106 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r106 == null) goto L64;
        if (r102 == null) goto L50;
        Bundle r107 = r102.getExtras();
        if (r107 == null) goto L50;
    L51:
        r106.c(r101, r107);
        return;
    L50:
        r107 = new Bundle();
        goto L51
    L64:
        return;
    L63:
        return;
    L23:
        if (r100 == 2025) goto L44;
        if (r100 == 4025) goto L44;
        if (r100 == 1026) goto L44;
        if (r100 == 2026) goto L44;
        if (r100 == 4026) goto L44;
        if (r100 == 3026) goto L44;
        if (r100 != 1033) goto L39;
        if (r101 != 101) goto L39;
    L40:
        com.suite.lark.component.navroute.forseti.g r108 = com.suite.lark.component.navroute.forseti.f.b(this);
        Boolean r109 = null;
        if (r108 == null) goto L43;
        r109 = Boolean.valueOf(r108.g(null));
    L43:
        tt5.a.h("SelectorFragment", "onActivityResult: goBackResult:" + r109);
        return;
    L39:
        if (r101 == 103) goto L40;
        return;
    L9:
        if (r100 == 3025) goto L14;
        if (r100 == 1029) goto L14;
        if (r100 != 1031) goto L18;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.setId(R.id.selector_container);
        r103.setOnClickListener(null);
        return r103;
    }
}
