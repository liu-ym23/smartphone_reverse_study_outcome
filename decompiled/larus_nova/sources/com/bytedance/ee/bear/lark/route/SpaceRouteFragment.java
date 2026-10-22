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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
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
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.wikiv2.home2.WikiHomeFragment2;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.EventConstant;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u001a\u0010#\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/lark/route/SpaceRouteFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mTitleBar", "Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;", "mCreationMenuManager", "Lcom/bytedance/ee/bear/content/creation/ISelectCreationMenuManager;", "mDestination", "", "mModule", "", "mSubModule", "event", "hideSearchSet", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "observeForsetiMode", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initData", "initView", "contentView", "initAINotePadTitle", "initCreateBtn", "getTitleBar", "Lcom/bytedance/ee/bear/list/homepage/title/ITitleBar;", "getCreationMenuManager", "onMenuCreateClick", "observeCreatePopupMenu", "closePopupMenu", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceRouteFragment extends BaseCCMForsetiFragment implements c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f227443m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HomeMainTitleBar f227444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public x0 f227445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f227446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f227447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f227448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f227449k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<Integer> f227450l;

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

    public SpaceRouteFragment() {
        this.f227450l = SetsKt.setOf(new Integer[]{Integer.valueOf(NavigationEnum.SIDEBAR_DRIVE.f228307id), Integer.valueOf(NavigationEnum.WIKI.f228307id), Integer.valueOf(NavigationEnum.FAVORITE.f228307id), Integer.valueOf(NavigationEnum.MANUAL_OFFLINE.f228307id)});
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public final void onMenuCreateClick(View r100) {
        tt5.a.h("SpaceRouteFragment", "onMenuCreateClick()...");
        boolean r101 = ((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().f217118a;
        if (this.f227446h != NavigationEnum.SHARED_SPACE.f228307id) goto L5;
        boolean r102 = true;
    L6:
        boolean r103 = ((k) org.koin.java.a.c(k.class, null, null, 6)).d();
        SelectCreationMenuConfig r104 = new SelectCreationMenuConfig();
        r104.f216815k = true;
        r104.f216816l = t0.s();
        if (r103 == true) goto L9;
    L12:
        boolean r105 = true;
    L13:
        r104.f216819o = r105;
        com.bytedance.ee.bear.appsetting.c r106 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        r104.f216821q = r106.i("ccm.bitable.ccmspace.hassurvey.enable", false);
        r104.f216820p = r106.f("spacekit.mobile.docx_create_enable");
        r104.f216818n = r101;
        boolean r107 = !r102;
        r104.f216808d = r107;
        r104.f216810f = r107;
        r104.f216811g = r107;
        iw4.h r108 = new iw4.h();
        r108.f496209b = this.f227447i;
        r108.f496210c = this.f227448j;
        r108.f496211d = "home";
        qc5.a.j();
        r108.f496214g = true;
        if (this.f227445g != null) goto L16;
        this.f227445g = new x0();
    L16:
        x0 r109 = this.f227445g;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.bytedance.ee.bear.content.creation.ISelectCreationMenuManager");
        r109.c(requireActivity(), r108, r104, this);
        return;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.spacekit.bitable.enable", true) == true) goto L12;
        r105 = false;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        HomeMainTitleBar r100 = null;
        requireActivity().getWindow().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), R.color.bg_body, null)));
        Bundle r112 = getArguments();
        boolean r101 = false;
        if (r112 == null) goto L5;
        int r113 = r112.getInt("extra_destination", NavigationEnum.MY_SPACE.f228307id);
    L6:
        this.f227446h = r113;
        tt5.a.h("SpaceRouteFragment", "initData()...mDestination = " + this.f227446h);
        qc5.a.j();
        tt5.a.h("SpaceRouteFragment", "initView()...singleContainerEnable = true");
        this.f227444f = (HomeMainTitleBar) r110.findViewById(R.id.home_title_bar);
        if (ForsetiHelper.n() == false) goto L16;
        com.ss.android.lark.forsetiutils.b r114 = com.ss.android.lark.forsetiutils.b.f424768a;
        FragmentActivity r102 = requireActivity();
        r114.getClass();
        ForsetiViewMode r115 = com.ss.android.lark.forsetiutils.b.a(r102);
        if (r115 != null) goto L11;
    L13:
        boolean r116 = false;
    L14:
        if (r116 == false) goto L16;
        boolean r117 = true;
    L18:
        if (r117 == false) goto L30;
        int r103 = this.f227446h;
        if (r103 != NavigationEnum.SIDEBAR_DRIVE.f228307id) goto L22;
    L27:
        HomeMainTitleBar r104 = this.f227444f;
        if (r104 == null) goto L30;
        r104.setVisibility(8);
        goto L30
    L22:
        if (r103 == NavigationEnum.MANUAL_OFFLINE.f228307id) goto L27;
        if (r103 == NavigationEnum.HOME_PAGE.f228307id) goto L27;
        if (r103 == NavigationEnum.WIKI.f228307id) goto L27;
    L30:
        Bundle r105 = getArguments();
        if (r105 != null) goto L33;
    L35:
        boolean r106 = false;
    L36:
        if (r106 == false) goto L40;
        HomeMainTitleBar r107 = this.f227444f;
        if (r107 == null) goto L40;
        r107.setVisibility(8);
    L40:
        HomeMainTitleBar r108 = this.f227444f;
        if (r108 != null) goto L43;
    L50:
        int r109 = this.f227446h;
        String r118 = "";
        if (r109 != NavigationEnum.MY_SPACE.f228307id) goto L54;
        String r119 = HomePersonalFragment.class.getName();
        Intrinsics.checkNotNull(r119);
        String r120 = getString(R.string.Doc_List_My_Space);
        this.f227447i = WikiSpaceType.PERSONAL;
        this.f227448j = "belongtome";
        this.f227449k = "ccm_space_personal_page_click";
    L123:
        HashMap r121 = new HashMap();
        r121.put(EventConstant.Key.MODULE, this.f227447i);
        r121.put("sub_module", this.f227448j);
        HomeMainTitleBar r122 = this.f227444f;
        if (r122 == null) goto L126;
        BaseTitleBar r123 = r122.getTitleBar();
    L127:
        int r124 = this.f227446h;
        NavigationEnum r125 = NavigationEnum.AI_NOTE;
        if (r124 != r125.f228307id) goto L136;
        Bundle r126 = getArguments();
        if (r126 == null) goto L135;
        String r127 = r126.getString("extra_from", "other");
        if (r127 == null) goto L135;
        r118 = r127;
    L135:
        r121.put("source", r118);
    L136:
        if (r123 == null) goto L138;
        r123.setTag(R.id.title_bar_common_params, r121);
    L138:
        HomeMainTitleBar r128 = this.f227444f;
        if (r128 == null) goto L141;
        r128.setTitle(r120);
    L141:
        HomeMainTitleBar r129 = this.f227444f;
        if (r129 == null) goto L144;
        r129.setOnSearchBtnClickListener(new ac5.h(this));
    L144:
        HomeMainTitleBar r130 = this.f227444f;
        if (r130 == null) goto L147;
        r130.setOnCreateViewClickListener(new i(this));
    L147:
        Fragment r131 = Fragment.instantiate(requireContext(), r119, getArguments());
        FragmentTransaction r132 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r132, r131, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.fragment_container) == true) goto L151;
        r132 = r132.replace(R.id.fragment_container, r131);
    L151:
        r132.commitAllowingStateLoss();
        String r133 = this.f227449k;
        CommonCreateButton r134 = (CommonCreateButton) r110.findViewById(R.id.common_create_button);
        qc5.a.k();
        qc5.a.j();
        int r135 = this.f227446h;
        if (r135 != NavigationEnum.SHARED_SPACE.f228307id) goto L154;
    L188:
        r134.setVisibility(8);
        HomeMainTitleBar r136 = this.f227444f;
        if (r136 == null) goto L191;
        View r137 = r136.getCreateView();
    L192:
        if (r137 == null) goto L199;
        HomeMainTitleBar r138 = this.f227444f;
        if (r138 == null) goto L199;
        View r139 = r138.getCreateView();
        if (r139 == null) goto L199;
        r139.setVisibility(8);
    L199:
        if (this.f227446h != NavigationEnum.PIN_FOLDER.f228307id) goto L203;
        HomeMainTitleBar r140 = this.f227444f;
        if (r140 == null) goto L203;
        r140.f228353e.removeAllViews();
    L203:
        HomeMainTitleBar r141 = this.f227444f;
        if ((r141 instanceof HomeMainTitleBar) == false) goto L206;
        r100 = r141;
    L206:
        if (r100 == null) goto L208;
        r100.setLeftExtraClickListener(this);
    L208:
        LiveData<ForsetiViewMode> r142 = ((ForsetiViewModel) new ViewModelProvider(this, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class)).getViewMode();
        if (r142 == null) goto L212;
        r142.observe(getViewLifecycleOwner(), new ac5.k(this));
        return;
    L212:
        return;
    L191:
        r137 = null;
        goto L192
    L154:
        if (r135 == NavigationEnum.PIN_FOLDER.f228307id) goto L188;
        Bundle r143 = getArguments();
        if (r143 != null) goto L159;
    L161:
        if (r101 == false) goto L163;
        r134.setVisibility(8);
    L163:
        int r144 = this.f227446h;
        if (r144 != NavigationEnum.FAVORITE.f228307id) goto L176;
        r134.setVisibility(8);
        HomeMainTitleBar r145 = this.f227444f;
        if (r145 == null) goto L168;
        View r146 = r145.getCreateView();
    L169:
        if (r146 == null) goto L203;
        HomeMainTitleBar r147 = this.f227444f;
        if (r147 == null) goto L203;
        View r148 = r147.getCreateView();
        if (r148 == null) goto L203;
        r148.setVisibility(8);
        goto L203
    L168:
        r146 = null;
        goto L169
    L176:
        if (r144 != NavigationEnum.WIKI.f228307id) goto L178;
    L187:
        r134.setVisibility(8);
        goto L203
    L178:
        if (r144 == NavigationEnum.MY_LIBRARY.f228307id) goto L187;
        if (r144 != NavigationEnum.SUBORDINATE_RECENT.f228307id) goto L184;
        r134.setVisibility(8);
        goto L203
    L184:
        if (r144 != r125.f228307id) goto L186;
        r134.setVisibility(8);
        goto L203
    L186:
        AppCompatImageView r149 = r134.getCreateButton();
        r149.setOnClickListener(new g(this, r133));
        e.b(r149, e.a(), true);
        ((SelectCreationMenuViewModel) ViewModelProviders.of(requireActivity()).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().observe(this, new j(this));
        goto L203
    L159:
        if (r143.getBoolean("key_hide_create_button") != true) goto L161;
        r101 = true;
        goto L161
    L126:
        r123 = null;
        goto L127
    L54:
        if (r109 != NavigationEnum.SHARED_SPACE.f228307id) goto L64;
        r119 = HomeSharedFragment.class.getName();
        Intrinsics.checkNotNull(r119);
        qc5.a.j();
        if (qc5.a.d() == true) goto L59;
        r120 = getString(R.string.CreationMobile_ECM_ShareWithMe_Tab);
        Intrinsics.checkNotNull(r120);
    L62:
        this.f227447i = "shared";
        this.f227448j = "sharetome";
        this.f227449k = "ccm_space_shared_page_click";
        goto L123
    L59:
        if (qc5.a.h() == false) goto L61;
        r120 = getString(R.string.Doc_List_MainTabHomeShareWithMe);
        Intrinsics.checkNotNull(r120);
        goto L62
    L61:
        r120 = getString(R.string.Doc_List_Shared_Space);
        Intrinsics.checkNotNull(r120);
        goto L62
    L64:
        if (r109 != NavigationEnum.WIKI.f228307id) goto L70;
        if (r117 == false) goto L67;
        r119 = PadWikiFragment.class.getName();
    L68:
        Intrinsics.checkNotNull(r119);
        r120 = getString(R.string.Doc_Facade_Wiki);
        this.f227447i = "wiki_home";
        this.f227448j = "recent";
        this.f227449k = "ccm_space_wiki_page_click";
        goto L123
    L67:
        r119 = WikiHomeFragment2.class.getName();
        goto L68
    L70:
        if (r109 != NavigationEnum.FAVORITE.f228307id) goto L73;
        r119 = HomeFavoriteFragment.class.getName();
        r120 = getString(R.string.Doc_List_MainTabHomeFavorite);
        this.f227447i = "favorites";
        this.f227449k = "ccm_space_favorites_page_click";
        goto L123
    L73:
        if (r109 != NavigationEnum.MY_DRIVE.f228307id) goto L76;
        r119 = HomeDriveFragment.class.getName();
        r120 = getString(R.string.LarkCCM_CM_Drive_Header);
        this.f227447i = WikiSpaceType.PERSONAL;
        this.f227448j = "belongtome";
        this.f227449k = "ccm_space_personal_page_click";
        goto L123
    L76:
        if (r109 != NavigationEnum.MY_LIBRARY.f228307id) goto L81;
        r119 = HomeLibraryFragment.class.getName();
        r120 = getString(R.string.LarkCCM_CM_MyLib_Menu);
        this.f227447i = "my_docs";
        this.f227449k = "ccm_space_wiki_page_click";
        HomeMainTitleBar r150 = this.f227444f;
        if (r150 == null) goto L123;
        r150.setVisibility(8);
        goto L123
    L81:
        if (r109 != NavigationEnum.SIDEBAR_DRIVE.f228307id) goto L87;
        if (r117 == false) goto L84;
        r119 = PadHomeDriveFragment.class.getName();
    L85:
        Intrinsics.checkNotNull(r119);
        r120 = getString(R.string.LarkCCM_CM_Drive_Header);
        this.f227447i = "new_drive";
        this.f227449k = "ccm_space_drive_page_click";
        goto L123
    L84:
        r119 = SidebarHomeDriveFragment.class.getName();
        goto L85
    L87:
        if (r109 != NavigationEnum.SUBORDINATE_RECENT.f228307id) goto L90;
        r119 = SubordinateHomeFragment.class.getName();
        r120 = xo5.a.c(requireContext(), R.string.LarkCCM_CM_LeaderAccess_RecentDocs_Title, "user", getString(R.string.Doc_Permission_AddUserSubDep));
        this.f227447i = OperationName.OPERATION_OFFLINE_AVAILABLE;
        this.f227449k = "ccm_space_offline_page_click";
        goto L123
    L90:
        if (r109 != NavigationEnum.PIN_FOLDER.f228307id) goto L93;
        r119 = SidebarPinFolderFragment.class.getName();
        r120 = getString(R.string.Doc_List_Quick_Access);
        this.f227447i = "new_drive";
        goto L123
    L93:
        if (r109 != NavigationEnum.HOME_PAGE.f228307id) goto L96;
        r119 = PadHomeMainFragment.class.getName();
        this.f227447i = "";
        this.f227449k = "";
        r120 = "";
        goto L123
    L96:
        if (r109 != NavigationEnum.AI_NOTE.f228307id) goto L119;
        if (r117 == false) goto L117;
        Bundle r151 = getArguments();
        if (r151 != null) goto L102;
        r151 = new Bundle();
    L102:
        if (Intrinsics.areEqual(r151.getString("extra_from"), "vc_tab") == false) goto L116;
        HomeMainTitleBar r152 = this.f227444f;
        if (r152 == null) goto L107;
        SpaceTagTitleView r153 = r152.getTitleView();
    L108:
        if (r153 == null) goto L116;
        ViewGroup.LayoutParams r154 = r153.getLayoutParams();
        if ((r154 instanceof LinearLayout.LayoutParams) == false) goto L113;
        ((LinearLayout.LayoutParams) r154).gravity = 3;
    L115:
        r153.setLayoutParams(r154);
        r153.setTitleSize(24.0f);
        goto L116
    L113:
        if ((r154 instanceof FrameLayout.LayoutParams) == false) goto L115;
        ((FrameLayout.LayoutParams) r154).gravity = 3;
        goto L115
    L107:
        r153 = null;
    L116:
        r119 = PadAINotesFragment.class.getName();
    L118:
        Intrinsics.checkNotNull(r119);
        r120 = getString(R.string.LarkCCM_AINotes_AINotes_Tab);
        this.f227447i = "ai_notes";
        this.f227449k = "";
        goto L123
    L117:
        r119 = SidebarAINoteFragment.class.getName();
        goto L118
    L119:
        if (r117 == false) goto L121;
        r119 = PadOfflineFragment.class.getName();
    L122:
        Intrinsics.checkNotNull(r119);
        r120 = getString(R.string.Doc_List_OfflineTitle);
        this.f227447i = OperationName.OPERATION_OFFLINE_AVAILABLE;
        this.f227449k = "ccm_space_offline_page_click";
        goto L123
    L121:
        r119 = HomeOfflineFragment.class.getName();
        goto L122
    L43:
        if (this.f227446h == NavigationEnum.SUBORDINATE_RECENT.f228307id) goto L45;
        boolean r155 = true;
    L46:
        r108.f228358j = HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal();
        r108.c();
        if (r155 == false) goto L49;
        r108.e();
    L49:
        qc5.a.k();
        goto L50
    L45:
        r155 = false;
        goto L46
    L33:
        if (r105.getBoolean("key_hide_title_bar") != true) goto L35;
        r106 = true;
        goto L36
    L11:
        if (r115.isCompact() == true) goto L13;
        r116 = true;
    L16:
        r117 = false;
        goto L18
    L5:
        r113 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.lark_activity_space_route, r101, false);
    }
}
