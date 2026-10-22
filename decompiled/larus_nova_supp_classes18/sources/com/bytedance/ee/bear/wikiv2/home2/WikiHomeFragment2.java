package com.bytedance.ee.bear.wikiv2.home2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
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
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001`B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010@\u001a\u00020\u001f2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u000203H\u0016J\b\u0010H\u001a\u00020\u001fH\u0016J\b\u0010I\u001a\u00020\u001fH\u0016J&\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020K2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010R\u001a\u00020\u001fH\u0002J\b\u0010S\u001a\u00020\u001fH\u0002J\b\u0010T\u001a\u000201H\u0002J\b\u0010U\u001a\u00020\u001fH\u0002J\b\u0010V\u001a\u000201H\u0002J\b\u0010W\u001a\u00020\u001fH\u0002J\b\u0010X\u001a\u00020\u001fH\u0002J\u0010\u0010Y\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020=H\u0002J\u0010\u0010[\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020=H\u0002J\u0010\u0010\\\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020=H\u0002J\b\u0010]\u001a\u00020\u001fH\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b-\u0010.R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeFragment2;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/contract/route/parcelable/IWikiHomeFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "homeCreateBtnFromXml", "Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "getHomeCreateBtnFromXml", "()Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "setHomeCreateBtnFromXml", "(Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;)V", "homeRecentSpaceViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView;", "getHomeRecentSpaceViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView;", "setHomeRecentSpaceViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView;)V", "homeSubTitleViewFromXml", "Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;", "getHomeSubTitleViewFromXml", "()Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;", "setHomeSubTitleViewFromXml", "(Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;)V", "homeTopSpaceViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView;", "getHomeTopSpaceViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView;", "setHomeTopSpaceViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView;)V", "clearFromXmlViewCache", "", "homeLayout", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeLayout;", "getHomeLayout", "()Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeLayout;", "homeLayout$delegate", "Lkotlin/Lazy;", "filterDialog", "Lcom/bytedance/ee/bear/wikiv2/home2/filter/WikiSpaceFilterDialog;", "getFilterDialog", "()Lcom/bytedance/ee/bear/wikiv2/home2/filter/WikiSpaceFilterDialog;", "filterDialog$delegate", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiHomeViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiHomeViewModel;", "viewModel$delegate", "isNewTab", "", "mileStoneListener", "Lcom/bytedance/ee/bear/list/IMileStoneListener;", "networkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "benefitManagerAPI", "Lcom/bytedance/ee/bear/unbundle/BenefitManagerAPI;", "getBenefitManagerAPI", "()Lcom/bytedance/ee/bear/unbundle/BenefitManagerAPI;", "setBenefitManagerAPI", "(Lcom/bytedance/ee/bear/unbundle/BenefitManagerAPI;)V", "collectedTag", "", "forsetiVM", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModel;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "setNewTab", "setMileStoneListener", "listener", "loadData", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "observeForsetiMode", "initView", "isPadHomeStyle", "initHomeCreateBtn", "hideHomeCreateBtn", "bindView", "bindListener", "starWikiSpace", "spaceId", "unStarWikiSpace", "openWikiSpace", "onDestroyView", "getContext", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiHomeFragment2 extends Hilt_WikiHomeFragment2 implements d0c.c {
    public static final /* synthetic */ int s = 0;
    public CommonCreateButton g;
    public WikiHomeRecentSpaceView h;
    public HomeSubTitleView i;
    public WikiHomeTopSpaceView j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public boolean n;
    public u0 o;
    public ConnectionService.NetworkState p;

    @Inject
    public BenefitManagerAPI q;
    public final String r;

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

    public final CommonCreateButton W90() {
        View r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131374445);
    L8:
        this.g = (CommonCreateButton) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (CommonCreateButton) r0;
    }

    public final WikiHomeRecentSpaceView X90() {
        View r0 = this.h;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131374446);
    L8:
        this.h = (WikiHomeRecentSpaceView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiHomeRecentSpaceView) r0;
    }

    public final WikiHomeTopSpaceView Y90() {
        View r0 = this.j;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131374448);
    L8:
        this.j = (WikiHomeTopSpaceView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiHomeTopSpaceView) r0;
    }

    public final WikiHomeViewModel Z90() {
        return (WikiHomeViewModel) this.m.getValue();
    }

    public WikiHomeFragment2() {
        this.k = LazyKt.lazy(new WikiHomeFragment2$homeLayout$2(this));
        this.l = LazyKt.lazy(WikiHomeFragment2$filterDialog$2.INSTANCE);
        this.m = LazyKt.lazy(new WikiHomeFragment2$viewModel$2(this));
        this.r = "WikiHomeFragment2-" + hashCode();
    }

    public final boolean aa0() {
        qc5.a.k();
        BenefitManagerAPI r0 = this.q;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("benefitManagerAPI");
        r0 = null;
    L7:
        return !r0.n1().hasBenefit("common_wiki_node_management");
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L5;
        d0c.c r0 = getActivity();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");     // Catch: Exception -> L7
        UserSession r1 = r0.e9();     // Catch: Exception -> L7
    L9:
        return r1;
    L5:
        r1 = PassportcConvention.b(this);     // Catch: Exception -> L7
    L12:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.Hilt_WikiHomeFragment2
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        ((yw4.a) org.koin.java.a.c(yw4.a.class, null, null, 6)).a("ccm_wiki_home");
        cq5.a r0 = (cq5.a) this.l.getValue();
        r0.getClass();
        ((com.bytedance.ee.bear.contract.route.parcelable.g) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.g.class, null, null, 6)).a(r0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).c(this.r);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        int r0 = gq5.d.a;
        JSONObject r1 = new JSONObject();
        gq5.e.b(r1, "is_loading_success", "true");
        gq5.e.b(r1, "is_empty", "false");
        gq5.d.a(r1, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_home_view", r1);
        if (ForsetiHelper.x(this) == true) goto L10;
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L11;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L12;
        r3.setSoftInputMode(32);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m669provideComponent() {
        return provideComponent();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).h(this.r);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).j(this.r, "start", Long.valueOf(System.currentTimeMillis()));
        tt5.a.h("WikiHomeFragment2", "onCreate.");
    }

    public static final void V90(WikiHomeFragment2 r3, String r4) {
        SpaceBean r5 = r3.Z90().getWikiSpace(r4);
        if (r5 == null) goto L7;
        WikiTreeActivityContract r0 = new WikiTreeActivityContract();
        r0.setSpaceId(r5.space_id);
        r0.setDocumentToken(r5.root_token);
        r0.setDocumentName(r5.space_name);
        r0.setWikiDocument(zp5.a.c(r5));
        RouteBean r6 = new RouteBean();
        r6.a(r3);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/wikiv2/treehome/activity", r6).o(WikiTreeActivityContract.class.getName(), r0).e();
        gq5.d.k("workspace", "ccm_wiki_tree_view");
        return;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        Context r11 = getContext();
        View r0 = null;
        if (r11 == null) goto L5;
        ((yw4.a) org.koin.java.a.c(yw4.a.class, null, null, 6)).b("ccm_wiki_home", r11, null);
    L5:
        boolean r1 = true;
        if (ForsetiHelper.n() == true) goto L8;
    L12:
        boolean r12 = false;
    L14:
        if (r12 == false) goto L21;
        ForsetiViewModel r13 = new ViewModelProvider(this, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class);
        if (r13 == null) goto L24;
        LiveData r14 = r13.getViewMode();
        if (r14 == null) goto L24;
        r14.observe(getViewLifecycleOwner(), new i(this));
    L24:
        k r15 = (k) this.k.getValue();
        boolean r4 = this.n;
        if (r15.d != null) goto L27;
    L87:
        cq5.a r16 = (cq5.a) this.l.getValue();
        r16.getClass();
        ((com.bytedance.ee.bear.contract.route.parcelable.g) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.g.class, null, null, 6)).c(r16);
        WikiHomeRecentSpaceView r17 = X90();
        View r18 = this.i;
        if (r18 != null) goto L93;
        View r19 = getView();
        if (r19 == null) goto L92;
        r0 = r19.findViewById(2131374462);
    L92:
        this.i = (HomeSubTitleView) r0;
        r18 = r0;
    L93:
        r17.setSubTitleView((HomeSubTitleView) r18);
        y r20 = new y(getViewLifecycleOwner());
        Y90().setItemEnableChecker(r20);
        X90().setItemEnableChecker(r20);
        X90().setUserComponentAbility(new ce5.a(this));
        if (ForsetiHelper.n() == true) goto L96;
    L100:
        r1 = false;
    L101:
        if (r1 == false) goto L105;
        WikiHomeRecentSpaceView r21 = X90();
        MarginDividerItemDecoration r110 = new MarginDividerItemDecoration(requireContext(), 16, 16);
        r21.getClass();
        Intrinsics.checkNotNullParameter(r110, "itemDecoration");
        BaseRecyclerView r22 = r21.getListRecyclerViewFromXml();
        if (r22 == null) goto L105;
        r22.addItemDecoration(r110);
    L105:
        Z90().getTopWikiSpaces().observe(getViewLifecycleOwner(), new f(this));
        Z90().getRecentWikiSpaces().observe(getViewLifecycleOwner(), new g(this));
        com.bytedance.ee.bear.contract.j.a.a.a().observe(getViewLifecycleOwner(), new h(this));
        k r23 = (k) this.k.getValue();
        com.bytedance.ee.bear.wikiv2.home2.a r111 = new com.bytedance.ee.bear.wikiv2.home2.a(this);
        r23.getClass();
        Intrinsics.checkNotNullParameter(r111, "delegate");
        r23.m = r111;
        Y90().setDelegate(new b(this));
        X90().setDelegate(new c(this));
        cq5.a r24 = (cq5.a) this.l.getValue();
        d r112 = new d(this);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r112, "delegate");
        r24.a = r112;
        W90().setOnClickListener(new e(this));
        gq5.b.b(this.r, "init");
        Z90().init(new ce5.a(this));
        return;
    L96:
        if (getParentFragment() == null) goto L100;
        if ((getParentFragment() instanceof wc5.h) == false) goto L100;
    L27:
        if (r15.e == null) goto L87;
        if (r15.f == null) goto L87;
        if (r15.g == null) goto L87;
        if (r15.h == null) goto L87;
        if (r15.i == null) goto L87;
        if (r15.j == null) goto L87;
        if (r15.k == null) goto L87;
        Context r5 = r15.a.getContext();
        if (r5 == null) goto L87;
        tt5.a.h("WikiHomeLayout", "WikiHomeLayout.init");
        if (r4 == false) goto L47;
    L79:
        View r6 = r15.h;
        if ((r6 instanceof View) == false) goto L82;
        View r7 = r6;
    L83:
        if (r7 == null) goto L85;
        r7.setVisibility(0);
    L85:
        r15.i.setVisibility(8);
        r15.e.setMinimumHeight(0);
    L86:
        r15.f.addOnOffsetChangedListener(new l(r15));
        r15.g.setNestScrollListener(new m(r15));
        r15.d.F(new LoadMoreFooter(r5), -2);
        SmartRefreshLayout r3 = r15.d;
        r3.W = new n(r15);
        r3.i(new o(r15));
        com.bytedance.ee.bear.contract.j.a.a.a().observe(r15.a.getViewLifecycleOwner(), new p(r15));
        goto L87
    L82:
        r7 = null;
        goto L83
    L47:
        if (ForsetiHelper.n() == true) goto L49;
    L51:
        boolean r8 = false;
    L52:
        if (r8 == true) goto L79;
        View r25 = r15.h;
        if ((r25 instanceof View) == false) goto L57;
        View r26 = r25;
    L58:
        if (r26 == null) goto L60;
        r26.setVisibility(4);
    L60:
        r15.i.setVisibility(0);
        wa5.a r27 = r15.h;
        if ((r27 instanceof wa5.a) == false) goto L63;
        r27.setAssociatedHeader(r15.i);
    L63:
        ViewGroup.LayoutParams r28 = r15.i.getLayoutParams();
        if ((r28 instanceof ViewGroup.MarginLayoutParams) == false) goto L66;
        ViewGroup.MarginLayoutParams r29 = (ViewGroup.MarginLayoutParams) r28;
    L67:
        if (r29 == null) goto L74;
        com.bytedance.ee.bear.list.homepage.title.b r30 = r15.c;
        if (r30 != null) goto L71;
        int r31 = 0;
    L72:
        if (r31 <= 0) goto L74;
        r29.topMargin = r31;
        r15.i.setLayoutParams(r29);
        goto L74
    L71:
        r31 = r30.getTitleBarHeight() - r29.height;
    L74:
        CollapsingToolbarLayout r32 = r15.e;
        com.bytedance.ee.bear.list.homepage.title.b r33 = r15.c;
        if (r33 == null) goto L77;
        int r34 = r33.getTitleBarHeight();
    L78:
        r32.setMinimumHeight(r34);
        goto L86
    L77:
        r34 = 0;
        goto L78
    L66:
        r29 = null;
        goto L67
    L57:
        r26 = null;
        goto L58
    L49:
        if ((r15.a.getParentFragment() instanceof wc5.h) == false) goto L51;
        r8 = true;
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
        r12 = true;
        goto L14
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568241, r3, false);
    }
}
