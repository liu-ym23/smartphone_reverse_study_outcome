package com.bytedance.ee.bear.wikiv2.home2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelFactory;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.list.homepage.title.HomeSubTitleView;
import com.bytedance.ee.bear.list.list.MarginDividerItemDecoration;
import com.bytedance.ee.bear.list.u0;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiHomeViewModel;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001`B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010@\u001a\u00020\u001f2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u000203H\u0016J\b\u0010H\u001a\u00020\u001fH\u0016J\b\u0010I\u001a\u00020\u001fH\u0016J&\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020K2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010R\u001a\u00020\u001fH\u0002J\b\u0010S\u001a\u00020\u001fH\u0002J\b\u0010T\u001a\u000201H\u0002J\b\u0010U\u001a\u00020\u001fH\u0002J\b\u0010V\u001a\u000201H\u0002J\b\u0010W\u001a\u00020\u001fH\u0002J\b\u0010X\u001a\u00020\u001fH\u0002J\u0010\u0010Y\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020=H\u0002J\u0010\u0010[\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020=H\u0002J\u0010\u0010\\\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020=H\u0002J\b\u0010]\u001a\u00020\u001fH\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b-\u0010.R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeFragment2;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/contract/route/parcelable/IWikiHomeFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "homeCreateBtnFromXml", "Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "getHomeCreateBtnFromXml", "()Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "setHomeCreateBtnFromXml", "(Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;)V", "homeRecentSpaceViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView;", "getHomeRecentSpaceViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView;", "setHomeRecentSpaceViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView;)V", "homeSubTitleViewFromXml", "Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;", "getHomeSubTitleViewFromXml", "()Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;", "setHomeSubTitleViewFromXml", "(Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;)V", "homeTopSpaceViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView;", "getHomeTopSpaceViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView;", "setHomeTopSpaceViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView;)V", "clearFromXmlViewCache", "", "homeLayout", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeLayout;", "getHomeLayout", "()Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeLayout;", "homeLayout$delegate", "Lkotlin/Lazy;", "filterDialog", "Lcom/bytedance/ee/bear/wikiv2/home2/filter/WikiSpaceFilterDialog;", "getFilterDialog", "()Lcom/bytedance/ee/bear/wikiv2/home2/filter/WikiSpaceFilterDialog;", "filterDialog$delegate", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiHomeViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiHomeViewModel;", "viewModel$delegate", "isNewTab", "", "mileStoneListener", "Lcom/bytedance/ee/bear/list/IMileStoneListener;", "networkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "benefitManagerAPI", "Lcom/bytedance/ee/bear/unbundle/BenefitManagerAPI;", "getBenefitManagerAPI", "()Lcom/bytedance/ee/bear/unbundle/BenefitManagerAPI;", "setBenefitManagerAPI", "(Lcom/bytedance/ee/bear/unbundle/BenefitManagerAPI;)V", "collectedTag", "", "forsetiVM", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModel;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "setNewTab", "setMileStoneListener", "listener", "loadData", WidgetCostModule.TYPE_ON_START, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "observeForsetiMode", "initView", "isPadHomeStyle", "initHomeCreateBtn", "hideHomeCreateBtn", "bindView", "bindListener", "starWikiSpace", "spaceId", "unStarWikiSpace", "openWikiSpace", "onDestroyView", "getContext", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiHomeFragment2 extends Hilt_WikiHomeFragment2 implements d0c.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f240796s = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommonCreateButton f240797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WikiHomeRecentSpaceView f240798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HomeSubTitleView f240799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WikiHomeTopSpaceView f240800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f240801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f240802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f240803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f240804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public u0 f240805o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ConnectionService.NetworkState f240806p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Inject
    public BenefitManagerAPI f240807q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f240808r;

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

    public final CommonCreateButton W90() {
        View r100 = this.f240797g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.homeCreateBtn);
    L8:
        this.f240797g = (CommonCreateButton) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonCreateButton) r100;
    }

    public final WikiHomeRecentSpaceView X90() {
        View r100 = this.f240798h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.homeRecentSpaceView);
    L8:
        this.f240798h = (WikiHomeRecentSpaceView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiHomeRecentSpaceView) r100;
    }

    public final WikiHomeTopSpaceView Y90() {
        View r100 = this.f240800j;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.homeTopSpaceView);
    L8:
        this.f240800j = (WikiHomeTopSpaceView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiHomeTopSpaceView) r100;
    }

    public final WikiHomeViewModel Z90() {
        return (WikiHomeViewModel) this.f240803m.getValue();
    }

    public WikiHomeFragment2() {
        this.f240801k = LazyKt.lazy(new WikiHomeFragment2$homeLayout$2(this));
        this.f240802l = LazyKt.lazy(WikiHomeFragment2$filterDialog$2.INSTANCE);
        this.f240803m = LazyKt.lazy(new WikiHomeFragment2$viewModel$2(this));
        this.f240808r = "WikiHomeFragment2-" + hashCode();
    }

    public final boolean aa0() {
        qc5.a.k();
        BenefitManagerAPI r100 = this.f240807q;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("benefitManagerAPI");
        r100 = null;
    L7:
        return !r100.n1().hasBenefit("common_wiki_node_management");
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L5;
        KeyEventDispatcher.Component r100 = getActivity();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");     // Catch: Exception -> L7
        UserSession r101 = ((d0c.c) r100).e9();     // Catch: Exception -> L7
    L9:
        return r101;
    L5:
        r101 = PassportcConvention.b(this);     // Catch: Exception -> L7
    L12:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.Hilt_WikiHomeFragment2, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((yw4.a) org.koin.java.a.c(yw4.a.class, null, null, 6)).a("ccm_wiki_home");
        cq5.a r100 = (cq5.a) this.f240802l.getValue();
        r100.getClass();
        ((com.bytedance.ee.bear.contract.route.parcelable.g) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.g.class, null, null, 6)).a(r100);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).c(this.f240808r);
        this.f240797g = null;
        this.f240798h = null;
        this.f240799i = null;
        this.f240800j = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        int r100 = gq5.d.f482186a;
        JSONObject r101 = new JSONObject();
        gq5.e.b(r101, "is_loading_success", "true");
        gq5.e.b(r101, "is_empty", "false");
        gq5.d.a(r101, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_home_view", r101);
        if (ForsetiHelper.x(this) == true) goto L10;
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L11;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L12;
        r103.setSoftInputMode(32);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).h(this.f240808r);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).j(this.f240808r, "start", Long.valueOf(System.currentTimeMillis()));
        tt5.a.h("WikiHomeFragment2", "onCreate.");
    }

    public static final void V90(WikiHomeFragment2 r100, String r101) {
        SpaceBean r102 = r100.Z90().getWikiSpace(r101);
        if (r102 == null) goto L7;
        WikiTreeActivityContract r103 = new WikiTreeActivityContract();
        r103.setSpaceId(r102.space_id);
        r103.setDocumentToken(r102.root_token);
        r103.setDocumentName(r102.space_name);
        r103.setWikiDocument(zp5.a.c(r102));
        RouteBean r104 = new RouteBean();
        r104.a(r100);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/wikiv2/treehome/activity", r104).o(WikiTreeActivityContract.class.getName(), r103).e();
        gq5.d.k("workspace", "ccm_wiki_tree_view");
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        Context r101 = getContext();
        View r102 = null;
        if (r101 == null) goto L5;
        ((yw4.a) org.koin.java.a.c(yw4.a.class, null, null, 6)).b("ccm_wiki_home", r101, null);
    L5:
        boolean r103 = true;
        if (ForsetiHelper.n() == true) goto L8;
    L12:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L21;
        ForsetiViewModel r105 = (ForsetiViewModel) new ViewModelProvider(this, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class);
        if (r105 == null) goto L24;
        LiveData<ForsetiViewMode> r106 = r105.getViewMode();
        if (r106 == null) goto L24;
        r106.observe(getViewLifecycleOwner(), new i(this));
    L24:
        k r107 = (k) this.f240801k.getValue();
        boolean r108 = this.f240804n;
        if (r107.f240844d != null) goto L27;
    L87:
        cq5.a r109 = (cq5.a) this.f240802l.getValue();
        r109.getClass();
        ((com.bytedance.ee.bear.contract.route.parcelable.g) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.g.class, null, null, 6)).c(r109);
        WikiHomeRecentSpaceView r111 = X90();
        View r112 = this.f240799i;
        if (r112 != null) goto L93;
        View r113 = getView();
        if (r113 == null) goto L92;
        r102 = r113.findViewById(R.id.home_sub_title_view);
    L92:
        this.f240799i = (HomeSubTitleView) r102;
        r112 = r102;
    L93:
        r111.setSubTitleView((HomeSubTitleView) r112);
        y r114 = new y(getViewLifecycleOwner());
        Y90().setItemEnableChecker(r114);
        X90().setItemEnableChecker(r114);
        X90().setUserComponentAbility(new ce5.a(this));
        if (ForsetiHelper.n() == true) goto L96;
    L100:
        r103 = false;
    L101:
        if (r103 == false) goto L105;
        WikiHomeRecentSpaceView r115 = X90();
        MarginDividerItemDecoration r116 = new MarginDividerItemDecoration(requireContext(), 16, 16);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "itemDecoration");
        BaseRecyclerView r117 = r115.getListRecyclerViewFromXml();
        if (r117 == null) goto L105;
        r117.addItemDecoration(r116);
    L105:
        Z90().getTopWikiSpaces().observe(getViewLifecycleOwner(), new f(this));
        Z90().getRecentWikiSpaces().observe(getViewLifecycleOwner(), new g(this));
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(getViewLifecycleOwner(), new h(this));
        k r118 = (k) this.f240801k.getValue();
        com.bytedance.ee.bear.wikiv2.home2.a r119 = new com.bytedance.ee.bear.wikiv2.home2.a(this);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "delegate");
        r118.f240853m = r119;
        Y90().setDelegate(new b(this));
        X90().setDelegate(new c(this));
        cq5.a r120 = (cq5.a) this.f240802l.getValue();
        d r121 = new d(this);
        r120.getClass();
        Intrinsics.checkNotNullParameter(r121, "delegate");
        r120.f464789a = r121;
        W90().setOnClickListener(new e(this));
        gq5.b.b(this.f240808r, "init");
        Z90().init(new ce5.a(this));
        return;
    L96:
        if (getParentFragment() == null) goto L100;
        if ((getParentFragment() instanceof wc5.h) == false) goto L100;
    L27:
        if (r107.f240845e == null) goto L87;
        if (r107.f240846f == null) goto L87;
        if (r107.f240847g == null) goto L87;
        if (r107.f240848h == null) goto L87;
        if (r107.f240849i == null) goto L87;
        if (r107.f240850j == null) goto L87;
        if (r107.f240851k == null) goto L87;
        Context r122 = r107.f240841a.getContext();
        if (r122 == null) goto L87;
        tt5.a.h("WikiHomeLayout", "WikiHomeLayout.init");
        if (r108 == false) goto L47;
    L79:
        Object r123 = r107.f240848h;
        if ((r123 instanceof View) == false) goto L82;
        View r124 = (View) r123;
    L83:
        if (r124 == null) goto L85;
        r124.setVisibility(0);
    L85:
        r107.f240849i.setVisibility(8);
        r107.f240845e.setMinimumHeight(0);
    L86:
        r107.f240846f.addOnOffsetChangedListener(new l(r107));
        r107.f240847g.setNestScrollListener(new m(r107));
        r107.f240844d.F(new LoadMoreFooter(r122), -2);
        SmartRefreshLayout r125 = r107.f240844d;
        r125.W = new n(r107);
        r125.i(new o(r107));
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(r107.f240841a.getViewLifecycleOwner(), new p(r107));
        goto L87
    L82:
        r124 = null;
        goto L83
    L47:
        if (ForsetiHelper.n() == true) goto L49;
    L51:
        boolean r126 = false;
    L52:
        if (r126 == true) goto L79;
        Object r127 = r107.f240848h;
        if ((r127 instanceof View) == false) goto L57;
        View r128 = (View) r127;
    L58:
        if (r128 == null) goto L60;
        r128.setVisibility(4);
    L60:
        r107.f240849i.setVisibility(0);
        cqa.e r129 = r107.f240848h;
        if ((r129 instanceof wa5.a) == false) goto L63;
        ((wa5.a) r129).setAssociatedHeader(r107.f240849i);
    L63:
        ViewGroup.LayoutParams r130 = r107.f240849i.getLayoutParams();
        if ((r130 instanceof ViewGroup.MarginLayoutParams) == false) goto L66;
        ViewGroup.MarginLayoutParams r131 = (ViewGroup.MarginLayoutParams) r130;
    L67:
        if (r131 == null) goto L74;
        com.bytedance.ee.bear.list.homepage.title.b r132 = r107.f240843c;
        if (r132 != null) goto L71;
        int r133 = 0;
    L72:
        if (r133 <= 0) goto L74;
        r131.topMargin = r133;
        r107.f240849i.setLayoutParams(r131);
        goto L74
    L71:
        r133 = r132.getTitleBarHeight() - r131.height;
    L74:
        CollapsingToolbarLayout r134 = r107.f240845e;
        com.bytedance.ee.bear.list.homepage.title.b r135 = r107.f240843c;
        if (r135 == null) goto L77;
        int r136 = r135.getTitleBarHeight();
    L78:
        r134.setMinimumHeight(r136);
        goto L86
    L77:
        r136 = 0;
        goto L78
    L66:
        r131 = null;
        goto L67
    L57:
        r128 = null;
        goto L58
    L49:
        if ((r107.f240841a.getParentFragment() instanceof wc5.h) == false) goto L51;
        r126 = true;
        goto L52
    L21:
        if (aa0() == false) goto L23;
        tt5.a.h("WikiHomeFragment2", "homeCreateBtn.visibility = View.GONE");
        W90().setVisibility(8);
        goto L24
    L23:
        tt5.a.h("WikiHomeFragment2", "homeCreateBtn.visibility = View.VISIBLE");
        W90().setVisibility(0);
        goto L24
    L8:
        if (getParentFragment() == null) goto L12;
        if ((getParentFragment() instanceof wc5.h) == false) goto L12;
        r104 = true;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.wiki_home_fragment_new2, r101, false);
    }
}
