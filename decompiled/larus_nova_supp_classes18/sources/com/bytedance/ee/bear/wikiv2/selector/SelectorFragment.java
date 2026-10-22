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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.home.viewall_multitab.WikiSpaceTabFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import iq5.b0;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002J\"\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J\"\u00100\u001a\u00020\u00132\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010.H\u0002J\b\u00101\u001a\u00020\tH\u0016J\b\u00102\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/SelectorFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "selectorConfig", "Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "isShortCut", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initData", "initFragment", "showRootSelectFragment", "showWikiDirect", "openMyLibrary", "openWiki", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiTreeNavigationData;", "openMySpace", "openSharedSpace", "openFolder", "bean", "Lcom/bytedance/ee/bear/list/selector/OpenFolderBean;", "getOwnerType", "", "openAllSearch", "openSpaceSearch", "commitFragment", "fragment", "Landroidx/fragment/app/Fragment;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "back", "fragmentActivityResult", "onBackPressed", "onDestroy", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectorFragment extends Hilt_SelectorFragment implements com.bytedance.ee.bear.wikiv2.searchv2.a, d0c.c {
    public SelectorConfig g;
    public boolean h;

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

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void DR() {
        tt5.a.h("SelectorFragment", "openAllSearch()...");
        SelectorConfig r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r0 = null;
    L6:
        if (r0.f != SelectorScope.SPACE_ONLY) goto L8;
        vZ();
        return;
    L8:
        String r1 = getString(2131887821);
        SelectorConfig r3 = this.g;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r3 = null;
    L12:
        if (r3.a == SelectorType.WIKI_MOVE_TO) goto L14;
    L16:
        boolean r6 = true;
    L17:
        SelectTabConfig r14 = new SelectTabConfig(r6, false, false, 6, null);
        SelectTitleConfig r13 = new SelectTitleConfig(true, r1);
        SelectPickerConfig r2 = new SelectPickerConfig(PickerStatistics.Scene.CcmSearchInWikiAndFolder, false, false, false, new SelectWikiConfig(true), r13, r14);
        Bundle r4 = getArguments();
        if (r4 == null) goto L20;
        r4.putSerializable("KEY_PICKER_CONFIG", r2);
    L20:
        WikiSearchPickerFragment r5 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.c(com.bytedance.ee.bear.search.b.class, null, null, 6)).c(requireContext(), r4);
        Intrinsics.checkNotNull(r5);
        V90(r5);
        return;
    L14:
        if (this.h == false) goto L16;
        r6 = false;
        goto L17
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void E5() {
        tt5.a.h("SelectorFragment", "openMySpace()...");
        int r1 = jq5.a.a;
        if (qc5.a.h() == false) goto L5;
        int r2 = 2131887934;
    L6:
        String r5 = getString(r2);
        int r7 = FolderSource.MY_SPACE.getSource();
        qc5.a.j();
        FolderVersion.Companion.getClass();
        j7(new td5.e(4, "", r5, false, r7, 5, false));
        return;
    L5:
        r2 = 2131887935;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void U5() {
        tt5.a.h("SelectorFragment", "openMyLibrary()...");
        Context r0 = requireContext();
        Bundle r1 = getArguments();
        SelectorConfig r2 = this.g;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r2 = null;
    L5:
        com.bytedance.ee.bear.wikiv2.wikitreev2.j.a(r0, r1, r2.g, new ce5.a(this), this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void V6() {
        tt5.a.h("SelectorFragment", "openWiki()...");
        WikiSpaceTabFragment r0 = new WikiSpaceTabFragment();
        r0.setArguments(getArguments());
        V90(r0);
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void Z3() {
        tt5.a.h("SelectorFragment", "openSharedSpace()...");
        String r5 = getString(jq5.a.a());
        int r7 = FolderSource.SHARED_SPACE.getSource();
        qc5.a.j();
        FolderVersion.Companion.getClass();
        j7(new td5.e(6, "", r5, true, r7, 5, false));
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void vZ() {
        tt5.a.h("SelectorFragment", "openSpaceSearch()...");
        String r4 = getString(2131887826);
        SelectFolderConfig r0 = new SelectFolderConfig(PickerStatistics.Scene.CcmSearchFolder, false, r4, false, false, 16, null);
        SearchFolderFragment r1 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.c(com.bytedance.ee.bear.search.b.class, null, null, 6)).b(requireContext(), r0);
        Intrinsics.checkNotNull(r1);
        V90(r1);
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void back() {
        if (onBackPressed() == false) goto L5;
        return;
    L5:
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L9;
        r0.g(null);
        return;
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return new ce5.a().b;
    }

    public final boolean onBackPressed() {
        int r0 = getChildFragmentManager().getBackStackEntryCount();
        tt5.a.h("SelectorFragment", "onBackPressed()... count: " + r0);
        if (r0 < 1) goto L7;
        getChildFragmentManager().popBackStack();
        return true;
    L7:
        return super.onBackPressed();
    }

    public final void onDestroy() {
        super.onDestroy();
        SelectorConfig.CREATOR.getClass();
        SelectorConfig.k = null;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m685provideComponent() {
        return provideComponent();
    }

    public SelectorFragment() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void Ct(com.bytedance.ee.bear.wikiv2.searchv2.c r9) {
        Intrinsics.checkNotNullParameter(r9, WikiFolderPushPlugin.DATA);
        SelectorConfig r1 = null;
        com.bytedance.ee.bear.contract.route.parcelable.f r2 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        Context r3 = requireContext();
        Bundle r5 = getArguments();
        SelectorConfig r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
    L6:
        r2.b(r3, r9, r5, r1.g, this);
        return;
    L5:
        r1 = r0;
        goto L6
    }

    public final void V90(Fragment r6) {
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131385861) == true) goto L6;
        r0 = r0.add(2131385861, r6);
    L6:
        r0.addToBackStack(null).commitAllowingStateLoss();
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void j7(td5.e r14) {
        Intrinsics.checkNotNullParameter(r14, "bean");
        tt5.a.h("SelectorFragment", "openFolder()...folderType = " + r14 + ".folderType, isShareFolder = " + r14 + ".isShareFolder, ownerType = " + r14 + ".ownerType");
        int r0 = FolderSelectFragment.s;
        FragmentManager r1 = getChildFragmentManager();
        Context r2 = requireContext();
        int r3 = r14.a;
        String r4 = r14.b;
        String r5 = r14.c;
        int r6 = r14.f;
        boolean r7 = r14.d;
        boolean r8 = r14.g;
        int r9 = r14.e;
        Bundle r10 = getArguments();
        boolean r11 = false;
        if (r10 == null) goto L5;
        r11 = r10.getBoolean("extra_is_at_vc", false);
    L5:
        V90(FolderSelectFragment.a.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, getArguments(), r14.h));
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        Bundle r7 = getArguments();
        if (r7 != null) goto L7;
        tt5.a.h("SelectorFragment", "bundle is null.");
        com.suite.lark.component.navroute.forseti.g r1 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r1 == null) goto L7;
        r1.g(null);
    L7:
        if (r7 == null) goto L10;
        SelectorConfig r2 = (SelectorConfig) r7.getParcelable("extra_config");
        if (r2 == null) goto L10;
    L11:
        this.g = r2;
        boolean r3 = false;
        if (r7 == null) goto L14;
        boolean r8 = r7.getBoolean("src_is_shortcut");
    L15:
        this.h = r8;
        StringBuilder r9 = new StringBuilder("initFragment()...selectorConfig = ");
        SelectorConfig r4 = this.g;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r4 = null;
    L18:
        r9.append(r4);
        tt5.a.h("SelectorFragment", r9.toString());
        if (qc5.a.c() == false) goto L21;
    L22:
        String r10 = dq5.j.a(new ce5.a(this));
        if (r10 != null) goto L25;
    L28:
        boolean r11 = true;
    L29:
        if (r11 == true) goto L31;
        r3 = true;
    L31:
        SelectorConfig r12 = this.g;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r12 = null;
    L35:
        if (r12.f != SelectorScope.WIKI_ONLY) goto L42;
        if (r3 == true) goto L42;
        tt5.a.h("SelectorFragment", "showWikiDirect()...");
        WikiSpaceTabFragment r13 = new WikiSpaceTabFragment();
        r13.setArguments(getArguments());
        FragmentTransaction r14 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "WikiSpaceTabFragment", 2131385861) == true) goto L41;
        r14 = r14.replace(2131385861, r13, "WikiSpaceTabFragment");
    L41:
        r14.commitAllowingStateLoss();
    L47:
        FragmentBackPressedHelperKt.a(this, new b0(this));
        View r15 = getView();
        if (r15 == null) goto L51;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.h.a(r15);
        return;
    L51:
        return;
    L42:
        tt5.a.h("SelectorFragment", "showRootSelectFragment()...");
        FragmentManager r16 = getChildFragmentManager();
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        int r17 = RootSelectFragment.m;
        Fragment r18 = RootSelectFragment.a.a(r16, requireContext(), getArguments());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131385861) == true) goto L46;
        r0 = r0.add(2131385861, r18);
    L46:
        r0.commitAllowingStateLoss();
        goto L47
    L25:
        if (r10.length() == 0) goto L28;
        r11 = false;
        goto L29
    L21:
        if (qc5.a.h() == false) goto L31;
    L14:
        r8 = false;
    L10:
        r2 = new SelectorConfig();
        goto L11
    }

    public final void onActivityResult(int r5, int r6, Intent r7) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r5, r6, r7);
        tt5.a.h("SelectorFragment", "onActivityResult()...requestCode = " + r5 + ", resultCode = " + r6);
        Iterator r0 = getChildFragmentManager().getFragments().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((Fragment) r0.next()).onActivityResult(r5, r6, r7);
        goto L4
    L7:
        if (r5 != 1024) goto L9;
    L14:
        if (r6 != (-1)) goto L16;
    L52:
        com.suite.lark.component.navroute.forseti.g r8 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r8 == null) goto L66;
        if (r7 == null) goto L57;
        Bundle r9 = r7.getExtras();
        if (r9 == null) goto L57;
    L58:
        r8.c(r6, r9);
        return;
    L57:
        r9 = new Bundle();
        goto L58
    L66:
        return;
    L16:
        if (r6 == 100) goto L52;
    L18:
        if (r6 == 101) goto L52;
        if (r5 != 1025) goto L23;
    L44:
        if (r6 != (-1)) goto L63;
        com.suite.lark.component.navroute.forseti.g r10 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r10 == null) goto L64;
        if (r7 == null) goto L50;
        Bundle r11 = r7.getExtras();
        if (r11 == null) goto L50;
    L51:
        r10.c(r6, r11);
        return;
    L50:
        r11 = new Bundle();
        goto L51
    L64:
        return;
    L63:
        return;
    L23:
        if (r5 == 2025) goto L44;
        if (r5 == 4025) goto L44;
        if (r5 == 1026) goto L44;
        if (r5 == 2026) goto L44;
        if (r5 == 4026) goto L44;
        if (r5 == 3026) goto L44;
        if (r5 != 1033) goto L39;
        if (r6 != 101) goto L39;
    L40:
        com.suite.lark.component.navroute.forseti.g r12 = com.suite.lark.component.navroute.forseti.f.b(this);
        Boolean r13 = null;
        if (r12 == null) goto L43;
        r13 = Boolean.valueOf(r12.g(null));
    L43:
        tt5.a.h("SelectorFragment", "onActivityResult: goBackResult:" + r13);
        return;
    L39:
        if (r6 == 103) goto L40;
        return;
    L9:
        if (r5 == 3025) goto L14;
        if (r5 == 1029) goto L14;
        if (r5 != 1031) goto L18;
        goto L14
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r4.setId(2131385861);
        r4.setOnClickListener(null);
        return r4;
    }
}
