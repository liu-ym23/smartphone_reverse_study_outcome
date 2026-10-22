package com.bytedance.ee.bear.bitable.homepage.list;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.homepage.recommend.widget.BitableRecommendHeaderView;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.homepage.tab.HomeSubMenuView;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.recommend.NewRecommendTemplateViewModel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import dd5.p1;
import dd5.s1;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\b\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020FH\u0002J$\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020FH\u0016J\u000e\u0010Q\u001a\u00020F2\u0006\u0010R\u001a\u00020MJ\u0010\u0010S\u001a\u00020F2\u0006\u0010T\u001a\u00020\u0012H\u0016J\u0010\u0010U\u001a\u00020F2\u0006\u0010R\u001a\u00020IH\u0002J\n\u0010V\u001a\u0004\u0018\u00010OH\u0014J\b\u0010W\u001a\u00020FH\u0016J\u0010\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u0012H\u0016J\b\u0010Z\u001a\u00020FH\u0016J\b\u0010[\u001a\u00020FH\u0002J\b\u0010\\\u001a\u00020FH\u0016J\b\u0010]\u001a\u00020FH\u0002J\b\u0010^\u001a\u00020FH\u0002J\b\u0010_\u001a\u00020FH\u0002J\u0010\u0010`\u001a\u00020F2\u0006\u0010a\u001a\u00020IH\u0002J\b\u0010b\u001a\u00020\fH\u0016J\b\u0010c\u001a\u00020\fH\u0016J\b\u0010d\u001a\u00020FH\u0002J\b\u0010e\u001a\u00020FH\u0016J\u0018\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020(H\u0016J\b\u0010i\u001a\u00020 H\u0016J\u0010\u0010j\u001a\u00020F2\u0006\u0010k\u001a\u00020\u0012H\u0016J\b\u0010l\u001a\u00020FH\u0016J\b\u0010m\u001a\u00020FH\u0002J\b\u0010n\u001a\u00020\u0012H\u0002J\u0010\u0010o\u001a\u00020F2\u0006\u0010p\u001a\u00020\u0012H\u0016J\b\u0010q\u001a\u00020FH\u0016J\b\u0010r\u001a\u00020FH\u0016J\b\u0010s\u001a\u00020FH\u0016J\u0010\u0010t\u001a\u00020\f2\u0006\u0010u\u001a\u00020(H\u0004J\b\u0010v\u001a\u00020FH\u0002J\b\u0010{\u001a\u00020\fH\u0014J\b\u0010|\u001a\u00020\fH\u0014J\b\u0010}\u001a\u00020\fH\u0014J\b\u0010~\u001a\u00020FH\u0016J\u0011\u0010\u007f\u001a\u00020F2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0016J\t\u0010\u0081\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0082\u0001\u001a\u00020\fH\u0016J\t\u0010\u0083\u0001\u001a\u00020\fH\u0016J\t\u0010\u0084\u0001\u001a\u00020FH\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0012H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020F2\u0007\u0010\u0087\u0001\u001a\u00020>H\u0016J\u000b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\fH\u0016J\f\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u000200X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010\u0015R\u000e\u0010<\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bA\u0010BR\u0011\u0010w\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bx\u0010\u000eR\u0011\u0010y\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bz\u0010\u000e¨\u0006\u008f\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/list/BitableHomeListFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/list/homepage/IHomeFragment;", "Lcom/bytedance/ee/bear/list/list/SpaceNotificationService$OnSwitchGridListener;", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView$ViewDelegate;", "Lcom/bytedance/ee/bear/list/homepage/IDocTabFragment;", "Lcom/bytedance/ee/bear/list/preload/FirstContentDrawDispatcher$OnFirstContentDrawListener;", "Lcom/bytedance/ee/bear/bitable/homepage/IListContainer;", "Lcom/bytedance/ee/bear/bitable/homepage/list/HomeListView;", "<init>", "()V", "hpFrom", "", "getHpFrom", "()Ljava/lang/String;", "setHpFrom", "(Ljava/lang/String;)V", "isFromWorkbench", "", "()Z", "setFromWorkbench", "(Z)V", "titleBar", "Lcom/bytedance/ee/bear/list/homepage/title/ITitleBar;", "hasInit", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "homeTabAdapter", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabAdapter;", "homeMenuView", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeSubMenuView;", "refreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "selectCreationMenuViewModel", "Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuViewModel;", "newRecommendTemplateViewModel", "Lcom/bytedance/ee/bear/templates/recommend/NewRecommendTemplateViewModel;", "sortStrategy", "Lcom/bytedance/ee/bear/list/cache/FolderSortStrategy;", "currentItem", "", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "networkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "homeViewContainer", "Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;", "getHomeViewContainer", "()Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;", "setHomeViewContainer", "(Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;)V", "fullScreen", "getFullScreen", "setFullScreen", "isUserVisibleHint", "refreshListener", "Lcom/bytedance/ee/bear/bitable/homepage/IRefreshListener;", "creationMenuManager", "Lcom/bytedance/ee/bear/content/creation/ISelectCreationMenuManager;", "getCreationMenuManager", "()Lcom/bytedance/ee/bear/content/creation/ISelectCreationMenuManager;", "creationMenuManager$delegate", "Lkotlin/Lazy;", "preloadAsyncJob", "", "closePopupMenu", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "initView", "rootView", "notifyVisibleHintChange", "visible", "initViewPager", "getArgumentsWithUserSession", "onDestroyView", "setUserVisibleHint", "isVisibleToUser", LiveCommonConstants.REASON_ON_DEDTROY, "onReleaseResource", "onPause", "observeNetwork", "observeCreatePopupMenu", "observeNewTemplateSelect", "initRefreshLayout", RootDescription.ROOT_ELEMENT, "getModule", "getSubModule", "pullUser", "refreshHeader", "onViewScrollBy", "dx", "dy", "getRefreshLayout", "onSwitchGrid", GXViewKey.VIEW_TYPE_CONTAINER_GRID, "onClickFilterMenu", "observeTabIndex", "canShowMagicPanel", "onClickSwitchMenu", "showGrid", "scrollToTop", "onClickSortMenu", "onFirstContentDraw", "getTabType", "position", "reportHomePageView", "containerEnv", "getContainerEnv", "homePageFrom", "getHomePageFrom", "getHomePageViewEvent", "getHomePageClickEvent", "getHomePageSwitchClickEvent", "refreshData", "onMenuCreateClick", "clickFrom", "isWorkBench", "getContainerScene", "getFrom", "onCoverViewClick", "isFullScreen", "setOnRefreshListener", "listener", "getTraceId", "getHomePageDelegate", "Lcom/bytedance/ee/bear/bitable/homepage/IBitableHomeV4Delegate;", "PageChangeListener", "TabSelectListener", "Companion", "BitableHomeTabConfig", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableHomeListFragment extends BaseFragment implements wc5.d, p1, wc5.f.a, wc5.c, pd5.a.InterfaceC7184a, com.bytedance.ee.bear.bitable.homepage.l0, z0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f212742u = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f212743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f212744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f212745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewPager f212746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HomeTabAdapter f212747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HomeSubMenuView f212748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SmartRefreshLayout f212749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SelectCreationMenuViewModel f212750l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public NewRecommendTemplateViewModel f212751m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f212752n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CompositeDisposable f212753o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.homepage.k0 f212754p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f212755q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f212756r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.homepage.n0 f212757s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f212758t;

    public static final class a implements ad5.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f212759a;

        public a() {
            this.f212759a = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.homepage.fav.disable");
        }

        @Override // ad5.f
        public final List<ad5.e> a(boolean r110) {
            ArrayList r111 = new ArrayList();
            r111.add(new ad5.e(HomeTabEnum.RECENT.f228344id, R.string.Bitable_Workspace_Recent_Tab, R.drawable.ud_icon_time_outlined, R.color.icon_n2, BitableRecentFragmentV4.class.getName()));
            r111.add(new ad5.e(HomeTabEnum.PIN.f228344id, R.string.Bitable_Workspace_QuickAccess_Tab, R.drawable.ud_icon_start_outlined, R.color.icon_n2, BitablePinFragmentV4.class.getName()));
            if (this.f212759a == true) goto L5;
            r111.add(new ad5.e(HomeTabEnum.FAVORITE.f228344id, R.string.Bitable_Workspace_Favorites_Tab, R.drawable.ud_icon_collect_filled, R.color.colorful_yellow, BitableFavoriteFragmentV4.class.getName()));
        L5:
            return r111;
        }
    }

    public static final class b {
    }

    public final class c implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HomeTabAdapter f212760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableHomeListFragment f212761b;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            tt5.a.h("BitableHomeListFragment", "onPageSelected()...position = " + r100);
            if (r100 >= 0) goto L5;
        L9:
            tt5.a.h("BitableHomeListFragment", "illegal position");
            return;
        L5:
            if (r100 >= this.f212760a.getCount()) goto L9;
            this.f212761b.f212752n = r100;
        }

        public c(BitableHomeListFragment r100, HomeTabAdapter r101) {
            Intrinsics.checkNotNullParameter(r101, "homeTabAdapter");
            this.f212761b = r100;
            this.f212760a = r101;
        }
    }

    public final class d implements w0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableHomeListFragment f212762a;

        public d(BitableHomeListFragment r100) {
            this.f212762a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.w0.a
        public final void V0(int r110, ad5.e r111) {
            Intrinsics.checkNotNullParameter(r111, "tabInfo");
            tt5.a.h("BitableHomeListFragment", "onTabSelected()...index = " + r110);
            BitableHomeListFragment r112 = this.f212762a;
            if (r112.f212752n != r110) goto L5;
            return;
        L5:
            lc5.f.a r100 = lc5.f.f508440a;
            String r101 = r112.m6();
            this.f212762a.getClass();
            if (r110 != 1) goto L8;
            String r113 = "quick_access";
        L12:
            String r102 = r113;
            String r103 = this.f212762a.m6();
            BitableHomeListFragment r114 = this.f212762a;
            if (r114.f212744f == false) goto L15;
            String r104 = "workbench";
        L16:
            r100.J(new lc5.p("home", r101, r102, "", r103, "ccm_base_homepage_landing_click", r104, r114.V90()));
            ViewPager r115 = this.f212762a.f212746h;
            if (r115 == null) goto L19;
            r115.setCurrentItem(r110);
        L19:
            this.f212762a.W90();
            ((BitableHomeListTabViewModel) ViewModelProviders.of(this.f212762a.requireActivity()).get(BitableHomeListTabViewModel.class)).setTabIndexState(r110);
            return;
        L15:
            r104 = "larktab_bitable";
            goto L16
        L8:
            if (r110 == 2) goto L10;
            r113 = "recent";
            goto L12
        L10:
            r113 = "favorites";
            goto L12
        }
    }

    public static final class e implements yw4.a.InterfaceC8394a {
        public e() {
        }
    }

    static {
    }

    @Override // wc5.d
    public final void Cu() {
    }

    @Override // wc5.f.a
    public final void Qi() {
    }

    @Override // wc5.d
    public final void t(int r100, int r101) {
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final com.bytedance.ee.bear.bitable.homepage.j0 F2() {
        com.bytedance.ee.bear.bitable.homepage.k0 r100 = this.f212754p;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.F2();
    }

    @Override // pd5.a.InterfaceC7184a
    public final void L2() {
        com.bytedance.ee.bear.contract.j r100 = com.bytedance.ee.bear.contract.j.a.f217090a;
        if (r100 == null) goto L8;
        LiveData<ConnectionService.NetworkState> r101 = r100.a();
        if (r101 == null) goto L8;
        r101.observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.homepage.list.b(this));
    L8:
        if (getActivity() != null) goto L11;
        tt5.a.d("BitableHomeListFragment", "observeCreatePopupMenu()...activity is null");
    L19:
        if (getActivity() != null) goto L22;
        tt5.a.d("BitableHomeListFragment", "observeNewTemplateSelect()...activity is null");
    L29:
        tt5.a.h("BitableHomeListFragment", "pullUser()...");
        Disposable r102 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).filter(g.f212789a).flatMap(h.f212791a).subscribe(i.f212793a, j.f212795a);
        this.f212753o.add(r102);
        return;
    L22:
        if (this.f212751m != null) goto L29;
        NewRecommendTemplateViewModel r103 = (NewRecommendTemplateViewModel) ViewModelProviders.of(requireActivity()).get(NewRecommendTemplateViewModel.class);
        this.f212751m = r103;
        if (r103 == null) goto L29;
        LiveData<TemplateV4> r104 = r103.m8333getSelectedTemplate();
        if (r104 == null) goto L29;
        r104.observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.homepage.list.c(this));
        goto L29
    L11:
        if (this.f212750l != null) goto L19;
        SelectCreationMenuViewModel r105 = (SelectCreationMenuViewModel) ViewModelProviders.of(requireActivity()).get(SelectCreationMenuViewModel.class);
        this.f212750l = r105;
        if (r105 == null) goto L19;
        LiveData<Integer> r106 = r105.getSelectedCreationTypeLiveData();
        if (r106 == null) goto L19;
        r106.observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.homepage.list.a(this));
        goto L19
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final String Sv() {
        if (this.f212744f == false) goto L5;
        return "workbench";
    L5:
        return "larktab_bitable";
    }

    public final void U90() {
        tt5.a.h("BitableHomeListFragment", "closePopupMenu()...");
        ((iw4.g) this.f212758t.getValue()).a(getActivity());
    }

    public final String V90() {
        if (this.f212744f == false) goto L7;
        String r100 = this.f212743e;
        if (r100 != null) goto L9;
        return "";
    L9:
        return r100;
    L7:
        return "lark_tab";
    }

    public final void W90() {
        if (this.f212756r == false) goto L10;
        tt5.a.h("BitableHomeListFragment", "reportHomePageView:" + this.f212755q);
        lc5.f.a r100 = lc5.f.f508440a;
        String r101 = m6();
        if (this.f212744f == false) goto L7;
        String r102 = "workbench";
    L8:
        lc5.f.a.F(r101, r102, V90(), Boolean.valueOf(this.f212755q));
        return;
    L7:
        r102 = "larktab_bitable";
        goto L8
    }

    @Override // wc5.f.a
    public final void eF() {
        boolean r100 = true;
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L6;
        r100 = false;
    L6:
        if (r100 == false) goto L8;
        Bundle r101 = new Bundle();
        r101.putString("key_module", "home");
        r101.putString("key_sub_module", m6());
        r101.putString("key_token", "recent");
        r101.putBoolean("key_sort_asc_enable", false);
        r101.putInt("key_sort_title_res", R.string.Doc_List_Filter_Recent_Activity);
        r101.putParcelable("key_sort_strategy", null);
        r101.putInt("key_default_sort_pos", 2);
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r101);
    L9:
        lc5.f.f508440a.J(new lc5.p("home", m6(), "filter", "ccm_space_header_filter_view", m6(), "ccm_base_homepage_landing_click"));
        return;
    L8:
        Toast.showFailureText(getContext(), getString(R.string.Doc_Facade_Offline), 0);
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final String getTraceId() {
        com.bytedance.ee.bear.bitable.homepage.k0 r100 = this.f212754p;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTraceId();
    }

    @Override // wc5.c
    public final String m6() {
        int r100 = this.f212752n;
        if (r100 != 0) goto L5;
        return "recent";
    L5:
        if (r100 == 1) goto L7;
        return "favorites";
    L7:
        return "quick_access";
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final void o00() {
        com.bytedance.ee.bear.bitable.homepage.k0 r100 = this.f212754p;
        if (r100 == null) goto L6;
        r100.AJ();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        tt5.a.h("BitableHomeListFragment", "onDestroyView()...");
        this.f212745g = false;
        super.onDestroyView();
        ((yw4.a) org.koin.java.a.c(yw4.a.class, null, null, 6)).a("ccm_space_home");
        pd5.a.c(this);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.z0
    public final void refreshData() {
        com.bytedance.ee.bear.bitable.homepage.n0 r100 = this.f212757s;
        if (r100 == null) goto L6;
        r100.onRefresh();
        return;
    }

    @Override // wc5.c
    public final SmartRefreshLayout xZ() {
        SmartRefreshLayout r100 = this.f212749k;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        return null;
    L6:
        return r100;
    }

    public BitableHomeListFragment() {
        CompositeDisposable r100 = new CompositeDisposable();
        this.f212753o = r100;
        this.f212755q = true;
        this.f212758t = LazyKt.lazy(BitableHomeListFragment$creationMenuManager$2.INSTANCE);
        tt5.a.h("BitableHomeListFragment", "BitableHomeListFragment()...");
        tt5.a.h("BitableHomeListFragment", "preloadAsyncJob()...");
        r100.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(com.bytedance.ee.bear.bitable.homepage.list.e.f212786a, f.f212788a));
        Bundle r101 = getArguments();
        if (r101 != null) goto L5;
        r101 = new Bundle();
    L5:
        PassportcConvention.h(r101, com.bytedance.ee.bear.bitable.core.usercomponent.b.a().z4());
        setArguments(r101);
        ((com.bytedance.ee.bear.lark.dependency.b0) ApiUtils.getApi(com.bytedance.ee.bear.lark.dependency.b0.class)).preloadDocSdk(0);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final String getFrom() {
        return V90();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        s1 r100 = s1.a.f468004a;
        r100.h(this);
        if (this.f212753o.isDisposed() == true) goto L5;
        this.f212753o.clear();
    L5:
        r100.b();
        pd5.e.b(getContext()).a();
        tt5.a.h("BitableHomeListFragment", "onReleaseResource()...");
        tt5.a.h("BitableHomeListFragment", "onDestroy()...");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        tt5.a.h("BitableHomeListFragment", "onPause()...");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).p(ThumbGlideUrl.SOURCE_SPACE_LIST, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("BitableHomeListFragment", th, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        W90();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).k(ThumbGlideUrl.SOURCE_SPACE_LIST);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("BitableHomeListFragment", th, false);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.a1
    public final void t0() {
        Iterator<T> r100 = getChildFragmentManager().getFragments().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        ActivityResultCaller r101 = (Fragment) r100.next();
        if ((r101 instanceof a1) == false) goto L8;
        a1 r102 = (a1) r101;
    L9:
        if (r102 == null) goto L4;
        r102.t0();
        goto L4
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final boolean isFullScreen() {
        return this.f212755q;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final boolean rl() {
        return this.f212744f;
    }

    @Override // dd5.p1
    public final void Mj(boolean r100) {
        HomeSubMenuView r101 = this.f212748j;
        if (r101 == null) goto L5;
        r101.b(r100);
    L5:
        t3.f229771a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final void Sz(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        com.bytedance.ee.bear.bitable.homepage.k0 r101 = this.f212754p;
        if (r101 == null) goto L6;
        r101.WD(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.z0
    public final void UG(boolean r100) {
        this.f212756r = r100;
        tt5.a.h("BitableHomeListFragment", "notifyVisibleHintChange:" + r100);
        if (this.f212756r == false) goto L6;
        W90();
        return;
    }

    @Override // wc5.f.a
    public final void WU(boolean r110) {
        tt5.a.h("BitableHomeListFragment", "onClickGrid()...showGrid = " + r110);
        Mj(r110);
        s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), r110, m6());
        lc5.f.a r100 = lc5.f.f508440a;
        String r101 = m6();
        String r102 = m6();
        if (this.f212744f == false) goto L5;
        String r111 = "workbench";
    L6:
        r100.G("home", r101, r102, "ccm_space_home_page_click", r111, V90());
        return;
    L5:
        r111 = "larktab_bitable";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final void pB(com.bytedance.ee.bear.bitable.homepage.n0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f212757s = r100;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        tt5.a.h("BitableHomeListFragment", "  setUserVisibleHint  isVisibleToUser: " + r100);
        if (this.f212745g == true) goto L6;
        tt5.a.h("BitableHomeListFragment", "setUserVisibleHint: have not init so skip");
        return;
    L6:
        this.f212756r = r100;
        HomeTabAdapter r101 = this.f212747i;
        if (r101 == null) goto L11;
        Fragment r102 = r101.f228341c;
        if (r102 == null) goto L11;
        r102.setUserVisibleHint(r100);
    L11:
        if (r100 == true) goto L14;
        U90();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        AttributeSet r100 = null;
        int r101 = 6;
        ((yw4.a) org.koin.java.a.c(yw4.a.class, null, null, 6)).b("ccm_space_home", requireContext(), new e());
        int r102 = 0;
        View r113 = r110.inflate(R.layout.fragment_bitable_home_list, r111, false);
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r114 = (ViewGroup) r113;
        Intrinsics.checkNotNullParameter(r114, "rootView");
        tt5.a.h("BitableHomeListFragment", "initView()...rootView = " + r114);
        tt5.a.h("BitableHomeListFragment", "initRefreshLayout()...");
        SmartRefreshLayout r115 = (SmartRefreshLayout) r114.findViewById(R.id.list_refresh_layout);
        this.f212749k = r115;
        if (r115 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r115 = null;
    L5:
        r115.G(new BitableRecommendHeaderView(requireContext(), r100, r101, r102), -2);
        SmartRefreshLayout r116 = this.f212749k;
        if (r116 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r116 = null;
    L8:
        r116.g(false);
        SmartRefreshLayout r117 = this.f212749k;
        if (r117 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r117 = null;
    L11:
        r117.I = false;
        SmartRefreshLayout r118 = this.f212749k;
        if (r118 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r118 = null;
    L14:
        r118.f405859J = false;
        SmartRefreshLayout r119 = this.f212749k;
        if (r119 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r119 = null;
    L17:
        r119.A = true;
        this.f212746h = (ViewPager) r114.findViewById(R.id.list_home_viewpager);
        List<ad5.e> r120 = new a().a(false);
        FragmentManager r103 = getChildFragmentManager();
        Context r104 = getContext();
        Bundle r105 = getArguments();
        if (r105 != null) goto L20;
        r105 = new Bundle();
    L20:
        PassportcConvention.h(r105, com.bytedance.ee.bear.bitable.core.usercomponent.b.a().z4());
        HomeTabAdapter r106 = new HomeTabAdapter(r103, r104, r120, r105);
        this.f212747i = r106;
        ViewPager r107 = this.f212746h;
        if (r107 == null) goto L23;
        r107.setAdapter(r106);
    L23:
        ViewPager r108 = this.f212746h;
        if (r108 == null) goto L26;
        r108.setCurrentItem(this.f212752n);
    L26:
        ViewPager r109 = this.f212746h;
        if (r109 == null) goto L29;
        r109.setOffscreenPageLimit(2);
    L29:
        ViewPager r121 = this.f212746h;
        if (r121 == null) goto L32;
        r121.addOnPageChangeListener(new c(this, r106));
    L32:
        HomeSubMenuView r122 = (HomeSubMenuView) r114.findViewById(R.id.home_sub_title_view);
        this.f212748j = r122;
        if (r122 == null) goto L35;
        r122.setViewDelegate(this);
    L35:
        HomeSubMenuView r123 = this.f212748j;
        if (r123 == null) goto L38;
        r123.setBackgroundColor(0);
    L38:
        HomeSubMenuView r124 = this.f212748j;
        if (r124 == null) goto L41;
        MagicIndicator r125 = r124.getMagicIndicator();
    L42:
        wuc.a r126 = new wuc.a(getContext());
        r126.setAdapter(new w0(requireContext(), r126, r120, new d(this)));
        if (r125 == null) goto L45;
        r125.setNavigator(r126);
    L45:
        View r127 = r114.findViewById(R.id.indicator_container);
        if (r127 == null) goto L48;
        r127.setVisibility(8);
    L48:
        Mj(LarkKVStorage.h(new com.ss.android.lark.storage.a(Biz.DOCS.getValue()), true).getBoolean("is_grid", false));
        s1.a.f468004a.a(this);
        HomeSubMenuView r128 = this.f212748j;
        if (r128 == null) goto L53;
        View r129 = r128.findViewById(R.id.iv_filter);
        if (r129 == null) goto L53;
        r129.setVisibility(8);
    L53:
        HomeSubMenuView r130 = this.f212748j;
        if (r130 == null) goto L58;
        View r131 = r130.findViewById(R.id.iv_switch);
        if (r131 == null) goto L58;
        r131.setVisibility(8);
    L58:
        ViewGroup r132 = (ViewGroup) r114.findViewById(R.id.title_container);
        if (r132 == null) goto L80;
        Sequence<View> r133 = ViewGroupKt.getChildren(r132);
        if (r133 == null) goto L80;
        Iterator<View> r134 = r133.iterator();
        int r135 = 0;
    L64:
        if (r134.hasNext() == false) goto L80;
        View r136 = r134.next();
        int r137 = r135 + 1;
        if (r135 >= 0) goto L68;
        CollectionsKt.throwIndexOverflow();
    L68:
        View r138 = r136;
        if ((r138 instanceof LinearLayout) == false) goto L78;
        if ((r138 instanceof xuc.b) == false) goto L78;
        ViewGroup.LayoutParams r139 = r138.getLayoutParams();
        if ((r139 instanceof LinearLayout.LayoutParams) == false) goto L75;
        LinearLayout.LayoutParams r140 = (LinearLayout.LayoutParams) r139;
    L76:
        if (r140 == null) goto L78;
        r140.setMargins(0, 0, UIHelper.getDimens(R.dimen.dp_12), 0);
        goto L78
    L75:
        r140 = null;
    L78:
        r135 = r137;
    L80:
        if (getActivity() != null) goto L82;
        tt5.a.d("BitableHomeListFragment", "observeTabIndex()...activity is null");
    L83:
        pd5.a.a(this);
        this.f212745g = true;
        sa5.t.a();
        return r113;
    L82:
        ((BitableHomeListTabViewModel) ViewModelProviders.of(requireActivity()).get(BitableHomeListTabViewModel.class)).getTabIndexStateLiveData().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.homepage.list.d(this));
        goto L83
    L41:
        r125 = null;
        goto L42
    }
}
