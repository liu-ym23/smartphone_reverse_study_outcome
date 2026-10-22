package com.bytedance.ee.bear.lark.route;

import ac5.g;
import ac5.i;
import ac5.j;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelFactory;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.lark.ai_notes.PadAINotesFragment;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.ee.bear.lark.e;
import com.bytedance.ee.bear.lark.space.PadHomeDriveFragment;
import com.bytedance.ee.bear.lark.space.PadHomeMainFragment;
import com.bytedance.ee.bear.lark.space.PadOfflineFragment;
import com.bytedance.ee.bear.lark.space.PadWikiFragment;
import com.bytedance.ee.bear.list.ainote.SidebarAINoteFragment;
import com.bytedance.ee.bear.list.create.x0;
import com.bytedance.ee.bear.list.drive.HomeDriveFragment;
import com.bytedance.ee.bear.list.folder.HomePersonalFragment;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.manualoffline.HomeOfflineFragment;
import com.bytedance.ee.bear.list.recent.subordinate.SubordinateHomeFragment;
import com.bytedance.ee.bear.list.share.HomeSharedFragment;
import com.bytedance.ee.bear.list.sidebar.homedrive.SidebarHomeDriveFragment;
import com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.SidebarPinFolderFragment;
import com.bytedance.ee.bear.list.star.HomeFavoriteFragment;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.wikiv2.home2.WikiHomeFragment2;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u001a\u0010#\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/lark/route/SpaceRouteFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mTitleBar", "Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;", "mCreationMenuManager", "Lcom/bytedance/ee/bear/content/creation/ISelectCreationMenuManager;", "mDestination", "", "mModule", "", "mSubModule", "event", "hideSearchSet", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "observeForsetiMode", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initData", "initView", "contentView", "initAINotePadTitle", "initCreateBtn", "getTitleBar", "Lcom/bytedance/ee/bear/list/homepage/title/ITitleBar;", "getCreationMenuManager", "onMenuCreateClick", "observeCreatePopupMenu", "closePopupMenu", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceRouteFragment extends BaseCCMForsetiFragment implements c {
    public static final /* synthetic */ int m = 0;
    public HomeMainTitleBar f;
    public x0 g;
    public int h;
    public String i;
    public String j;
    public String k;
    public final Set<Integer> l;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public SpaceRouteFragment() {
        this.l = SetsKt.setOf(new Integer[]{Integer.valueOf(NavigationEnum.SIDEBAR_DRIVE.id), Integer.valueOf(NavigationEnum.WIKI.id), Integer.valueOf(NavigationEnum.FAVORITE.id), Integer.valueOf(NavigationEnum.MANUAL_OFFLINE.id)});
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m430provideComponent() {
        return provideComponent();
    }

    public final void onMenuCreateClick(View r7) {
        tt5.a.h("SpaceRouteFragment", "onMenuCreateClick()...");
        boolean r8 = ((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().a;
        if (this.h != NavigationEnum.SHARED_SPACE.id) goto L5;
        boolean r2 = true;
    L6:
        boolean r0 = ((k) org.koin.java.a.c(k.class, null, null, 6)).d();
        SelectCreationMenuConfig r1 = new SelectCreationMenuConfig();
        r1.k = true;
        r1.l = t0.s();
        if (r0 == true) goto L9;
    L12:
        boolean r3 = true;
    L13:
        r1.o = r3;
        com.bytedance.ee.bear.appsetting.c r4 = com.bytedance.ee.bear.appsetting.c.a.a;
        r1.q = r4.i("ccm.bitable.ccmspace.hassurvey.enable", false);
        r1.p = r4.f("spacekit.mobile.docx_create_enable");
        r1.n = r8;
        boolean r9 = !r2;
        r1.d = r9;
        r1.f = r9;
        r1.g = r9;
        iw4.h r10 = new iw4.h();
        r10.b = this.i;
        r10.c = this.j;
        r10.d = "home";
        qc5.a.j();
        r10.g = true;
        if (this.g != null) goto L16;
        this.g = new x0();
    L16:
        x0 r5 = this.g;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.content.creation.ISelectCreationMenuManager");
        r5.c(requireActivity(), r10, r1, this);
        return;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.bitable.enable", true) == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r14, Bundle r16) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r16);
        HomeMainTitleBar r3 = null;
        requireActivity().getWindow().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), 2131100548, null)));
        Bundle r17 = getArguments();
        boolean r0 = false;
        if (r17 == null) goto L5;
        int r18 = r17.getInt("extra_destination", NavigationEnum.MY_SPACE.id);
    L6:
        this.h = r18;
        tt5.a.h("SpaceRouteFragment", "initData()...mDestination = " + this.h);
        qc5.a.j();
        tt5.a.h("SpaceRouteFragment", "initView()...singleContainerEnable = true");
        this.f = r14.findViewById(2131374494);
        if (ForsetiHelper.n() == false) goto L16;
        com.ss.android.lark.forsetiutils.b r19 = com.ss.android.lark.forsetiutils.b.a;
        FragmentActivity r2 = requireActivity();
        r19.getClass();
        ForsetiViewMode r110 = com.ss.android.lark.forsetiutils.b.a(r2);
        if (r110 != null) goto L11;
    L13:
        boolean r111 = false;
    L14:
        if (r111 == false) goto L16;
        boolean r112 = true;
    L18:
        if (r112 == false) goto L30;
        int r4 = this.h;
        if (r4 != NavigationEnum.SIDEBAR_DRIVE.id) goto L22;
    L27:
        HomeMainTitleBar r5 = this.f;
        if (r5 == null) goto L30;
        r5.setVisibility(8);
        goto L30
    L22:
        if (r4 == NavigationEnum.MANUAL_OFFLINE.id) goto L27;
        if (r4 == NavigationEnum.HOME_PAGE.id) goto L27;
        if (r4 == NavigationEnum.WIKI.id) goto L27;
    L30:
        Bundle r6 = getArguments();
        if (r6 != null) goto L33;
    L35:
        boolean r7 = false;
    L36:
        if (r7 == false) goto L40;
        HomeMainTitleBar r8 = this.f;
        if (r8 == null) goto L40;
        r8.setVisibility(8);
    L40:
        HomeMainTitleBar r9 = this.f;
        if (r9 != null) goto L43;
    L50:
        int r10 = this.h;
        String r11 = "";
        if (r10 != NavigationEnum.MY_SPACE.id) goto L54;
        String r113 = HomePersonalFragment.class.getName();
        Intrinsics.checkNotNull(r113);
        String r12 = getString(2131887935);
        this.i = "personal";
        this.j = "belongtome";
        this.k = "ccm_space_personal_page_click";
    L123:
        HashMap r13 = new HashMap();
        r13.put("module", this.i);
        r13.put("sub_module", this.j);
        HomeMainTitleBar r20 = this.f;
        if (r20 == null) goto L126;
        BaseTitleBar r21 = r20.getTitleBar();
    L127:
        int r22 = this.h;
        NavigationEnum r23 = NavigationEnum.AI_NOTE;
        if (r22 != r23.id) goto L136;
        Bundle r24 = getArguments();
        if (r24 == null) goto L135;
        String r26 = r24.getString("extra_from", "other");
        if (r26 == null) goto L135;
        r11 = r26;
    L135:
        r13.put("source", r11);
    L136:
        if (r21 == null) goto L138;
        r21.setTag(2131388811, r13);
    L138:
        HomeMainTitleBar r27 = this.f;
        if (r27 == null) goto L141;
        r27.setTitle(r12);
    L141:
        HomeMainTitleBar r28 = this.f;
        if (r28 == null) goto L144;
        r28.setOnSearchBtnClickListener(new ac5.h(this));
    L144:
        HomeMainTitleBar r29 = this.f;
        if (r29 == null) goto L147;
        r29.setOnCreateViewClickListener(new i(this));
    L147:
        Fragment r114 = Fragment.instantiate(requireContext(), r113, getArguments());
        FragmentTransaction r30 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r30, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L151;
        r30 = r30.replace(2131373275, r114);
    L151:
        r30.commitAllowingStateLoss();
        String r115 = this.k;
        CommonCreateButton r116 = r14.findViewById(2131367552);
        qc5.a.k();
        qc5.a.j();
        int r31 = this.h;
        if (r31 != NavigationEnum.SHARED_SPACE.id) goto L154;
    L188:
        r116.setVisibility(8);
        HomeMainTitleBar r117 = this.f;
        if (r117 == null) goto L191;
        View r118 = r117.getCreateView();
    L192:
        if (r118 == null) goto L199;
        HomeMainTitleBar r119 = this.f;
        if (r119 == null) goto L199;
        View r120 = r119.getCreateView();
        if (r120 == null) goto L199;
        r120.setVisibility(8);
    L199:
        if (this.h != NavigationEnum.PIN_FOLDER.id) goto L203;
        HomeMainTitleBar r121 = this.f;
        if (r121 == null) goto L203;
        r121.e.removeAllViews();
    L203:
        HomeMainTitleBar r122 = this.f;
        if ((r122 instanceof HomeMainTitleBar) == false) goto L206;
        r3 = r122;
    L206:
        if (r3 == null) goto L208;
        r3.setLeftExtraClickListener(this);
    L208:
        LiveData<ForsetiViewMode> r123 = ((ForsetiViewModel) new ViewModelProvider(this, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class)).getViewMode();
        if (r123 == null) goto L212;
        r123.observe(getViewLifecycleOwner(), new ac5.k(this));
        return;
    L212:
        return;
    L191:
        r118 = null;
        goto L192
    L154:
        if (r31 == NavigationEnum.PIN_FOLDER.id) goto L188;
        Bundle r32 = getArguments();
        if (r32 != null) goto L159;
    L161:
        if (r0 == false) goto L163;
        r116.setVisibility(8);
    L163:
        int r1 = this.h;
        if (r1 != NavigationEnum.FAVORITE.id) goto L176;
        r116.setVisibility(8);
        HomeMainTitleBar r124 = this.f;
        if (r124 == null) goto L168;
        View r125 = r124.getCreateView();
    L169:
        if (r125 == null) goto L203;
        HomeMainTitleBar r126 = this.f;
        if (r126 == null) goto L203;
        View r127 = r126.getCreateView();
        if (r127 == null) goto L203;
        r127.setVisibility(8);
        goto L203
    L168:
        r125 = null;
        goto L169
    L176:
        if (r1 != NavigationEnum.WIKI.id) goto L178;
    L187:
        r116.setVisibility(8);
        goto L203
    L178:
        if (r1 == NavigationEnum.MY_LIBRARY.id) goto L187;
        if (r1 != NavigationEnum.SUBORDINATE_RECENT.id) goto L184;
        r116.setVisibility(8);
        goto L203
    L184:
        if (r1 != r23.id) goto L186;
        r116.setVisibility(8);
        goto L203
    L186:
        AppCompatImageView r128 = r116.getCreateButton();
        r128.setOnClickListener(new g(this, r115));
        e.b(r128, e.a(), true);
        ((SelectCreationMenuViewModel) ViewModelProviders.of(requireActivity()).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().observe(this, new j(this));
        goto L203
    L159:
        if (r32.getBoolean("key_hide_create_button") != true) goto L161;
        r0 = true;
        goto L161
    L126:
        r21 = null;
        goto L127
    L54:
        if (r10 != NavigationEnum.SHARED_SPACE.id) goto L64;
        r113 = HomeSharedFragment.class.getName();
        Intrinsics.checkNotNull(r113);
        qc5.a.j();
        if (qc5.a.d() == true) goto L59;
        r12 = getString(2131887300);
        Intrinsics.checkNotNull(r12);
    L62:
        this.i = "shared";
        this.j = "sharetome";
        this.k = "ccm_space_shared_page_click";
        goto L123
    L59:
        if (qc5.a.h() == false) goto L61;
        r12 = getString(2131887929);
        Intrinsics.checkNotNull(r12);
        goto L62
    L61:
        r12 = getString(2131887981);
        Intrinsics.checkNotNull(r12);
        goto L62
    L64:
        if (r10 != NavigationEnum.WIKI.id) goto L70;
        if (r112 == false) goto L67;
        r113 = PadWikiFragment.class.getName();
    L68:
        Intrinsics.checkNotNull(r113);
        r12 = getString(2131887849);
        this.i = "wiki_home";
        this.j = "recent";
        this.k = "ccm_space_wiki_page_click";
        goto L123
    L67:
        r113 = WikiHomeFragment2.class.getName();
        goto L68
    L70:
        if (r10 != NavigationEnum.FAVORITE.id) goto L73;
        r113 = HomeFavoriteFragment.class.getName();
        r12 = getString(2131887927);
        this.i = "favorites";
        this.k = "ccm_space_favorites_page_click";
        goto L123
    L73:
        if (r10 != NavigationEnum.MY_DRIVE.id) goto L76;
        r113 = HomeDriveFragment.class.getName();
        r12 = getString(2131888777);
        this.i = "personal";
        this.j = "belongtome";
        this.k = "ccm_space_personal_page_click";
        goto L123
    L76:
        if (r10 != NavigationEnum.MY_LIBRARY.id) goto L81;
        r113 = HomeLibraryFragment.class.getName();
        r12 = getString(2131888790);
        this.i = "my_docs";
        this.k = "ccm_space_wiki_page_click";
        HomeMainTitleBar r33 = this.f;
        if (r33 == null) goto L123;
        r33.setVisibility(8);
        goto L123
    L81:
        if (r10 != NavigationEnum.SIDEBAR_DRIVE.id) goto L87;
        if (r112 == false) goto L84;
        r113 = PadHomeDriveFragment.class.getName();
    L85:
        Intrinsics.checkNotNull(r113);
        r12 = getString(2131888777);
        this.i = "new_drive";
        this.k = "ccm_space_drive_page_click";
        goto L123
    L84:
        r113 = SidebarHomeDriveFragment.class.getName();
        goto L85
    L87:
        if (r10 != NavigationEnum.SUBORDINATE_RECENT.id) goto L90;
        r113 = SubordinateHomeFragment.class.getName();
        r12 = xo5.a.c(requireContext(), 2131888784, "user", getString(2131888047));
        this.i = "offline";
        this.k = "ccm_space_offline_page_click";
        goto L123
    L90:
        if (r10 != NavigationEnum.PIN_FOLDER.id) goto L93;
        r113 = SidebarPinFolderFragment.class.getName();
        r12 = getString(2131887955);
        this.i = "new_drive";
        goto L123
    L93:
        if (r10 != NavigationEnum.HOME_PAGE.id) goto L96;
        r113 = PadHomeMainFragment.class.getName();
        this.i = "";
        this.k = "";
        r12 = "";
        goto L123
    L96:
        if (r10 != NavigationEnum.AI_NOTE.id) goto L119;
        if (r112 == false) goto L117;
        Bundle r129 = getArguments();
        if (r129 != null) goto L102;
        r129 = new Bundle();
    L102:
        if (Intrinsics.areEqual(r129.getString("extra_from"), "vc_tab") == false) goto L116;
        HomeMainTitleBar r130 = this.f;
        if (r130 == null) goto L107;
        SpaceTagTitleView r131 = r130.getTitleView();
    L108:
        if (r131 == null) goto L116;
        ViewGroup.LayoutParams r34 = r131.getLayoutParams();
        if ((r34 instanceof LinearLayout.LayoutParams) == false) goto L113;
        ((LinearLayout.LayoutParams) r34).gravity = 3;
    L115:
        r131.setLayoutParams(r34);
        r131.setTitleSize(24.0f);
        goto L116
    L113:
        if ((r34 instanceof FrameLayout.LayoutParams) == false) goto L115;
        ((FrameLayout.LayoutParams) r34).gravity = 3;
        goto L115
    L107:
        r131 = null;
    L116:
        r113 = PadAINotesFragment.class.getName();
    L118:
        Intrinsics.checkNotNull(r113);
        r12 = getString(2131888699);
        this.i = "ai_notes";
        this.k = "";
        goto L123
    L117:
        r113 = SidebarAINoteFragment.class.getName();
        goto L118
    L119:
        if (r112 == false) goto L121;
        r113 = PadOfflineFragment.class.getName();
    L122:
        Intrinsics.checkNotNull(r113);
        r12 = getString(2131887949);
        this.i = "offline";
        this.k = "ccm_space_offline_page_click";
        goto L123
    L121:
        r113 = HomeOfflineFragment.class.getName();
        goto L122
    L43:
        if (this.h == NavigationEnum.SUBORDINATE_RECENT.id) goto L45;
        boolean r36 = true;
    L46:
        r9.j = HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal();
        r9.c();
        if (r36 == false) goto L49;
        r9.e();
    L49:
        qc5.a.k();
        goto L50
    L45:
        r36 = false;
        goto L46
    L33:
        if (r6.getBoolean("key_hide_title_bar") != true) goto L35;
        r7 = true;
        goto L36
    L11:
        if (r110.isCompact() == true) goto L13;
        r111 = true;
    L16:
        r112 = false;
        goto L18
    L5:
        r18 = 0;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561746, r3, false);
    }
}
