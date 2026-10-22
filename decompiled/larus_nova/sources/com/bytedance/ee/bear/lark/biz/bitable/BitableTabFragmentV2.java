package com.bytedance.ee.bear.lark.biz.bitable;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import bd5.q;
import bd5.s;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.homepage.BitableDefaultTabViewModel;
import com.bytedance.ee.bear.bitable.homepage.BitableTabType;
import com.bytedance.ee.bear.bitable.homepage.w;
import com.bytedance.ee.bear.bitable.homepage.widget.ScrollHomeViewPager;
import com.bytedance.ee.bear.bitable.homepage.x;
import com.bytedance.ee.bear.lark.dependency.y;
import com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment;
import com.bytedance.ee.bear.list.homepage.banner.BitableBannerConfig;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.ui.loading.LKUILoadingView;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.maincore.ITitleInfo;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;
import net.lucode.hackware.magicindicator.MagicIndicator;
import vs4.z;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001UB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J$\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u000207H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u000201H\u0002J\u0010\u0010<\u001a\u00020-2\u0006\u0010;\u001a\u000201H\u0002J\u0010\u0010=\u001a\u00020-2\u0006\u0010;\u001a\u000201H\u0002J\u0018\u0010>\u001a\u00020-2\u0006\u0010)\u001a\u00020\f2\u0006\u0010?\u001a\u00020@H\u0016J \u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\fH\u0016J\u0010\u0010F\u001a\u00020-2\u0006\u0010B\u001a\u00020\fH\u0016J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020\fH\u0016J\b\u0010I\u001a\u00020-H\u0016J\b\u0010J\u001a\u000207H\u0016J\u0016\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u0018J\u0006\u0010N\u001a\u00020-J\b\u0010O\u001a\u00020-H\u0002J\b\u0010P\u001a\u00020'H\u0002J\b\u0010Q\u001a\u00020'H\u0002J\b\u0010R\u001a\u00020'H\u0002J\b\u0010S\u001a\u00020'H\u0002J\b\u0010T\u001a\u00020'H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/lark/biz/bitable/BitableTabFragmentV2;", "Lcom/bytedance/ee/bear/lark/tab/SpaceBaseTabFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/BitableIndicatorAdapter$TabSelectedListener;", "Lcom/bytedance/ee/bear/bitable/homepage/BitableIndicatorAdapterV2$TabSelectedListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "<init>", "()V", "mTitleInfo", "Lcom/bytedance/ee/bear/list/homepage/title/TitleInfo;", "mTitleConfig", "Lcom/bytedance/ee/bear/list/homepage/title/TabTitleConfigWrapper;", "mCurrentItem", "", "mHomePageCreateTime", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/HomePageCreateTimeData;", "mScrollViewPager", "Lcom/bytedance/ee/bear/bitable/homepage/widget/ScrollHomeViewPager;", "mHomeViewPager", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeViewPager;", "mHomeAdapter", "Lcom/bytedance/ee/bear/lark/biz/bitable/BitableTabAdapter;", "mTitleController", "Lcom/ss/android/lark/maintab/export/ITitleController;", "mSearchDelegate", "Landroid/view/View$OnClickListener;", "showLoadingLayout", "Landroid/widget/LinearLayout;", "lkuiLoadingView", "Lcom/larksuite/component/ui/loading/LKUILoadingView;", "showViewPagerLayout", "homeLoadingTextView", "Landroid/widget/TextView;", "defaultTabViewModel", "Lcom/bytedance/ee/bear/bitable/homepage/BitableDefaultTabViewModel;", "getDefaultTabViewModel", "()Lcom/bytedance/ee/bear/bitable/homepage/BitableDefaultTabViewModel;", "defaultTabViewModel$delegate", "Lkotlin/Lazy;", "getSubModule", "", "getTabType", "index", "getTabTitleConfig", "Lcom/ss/android/lark/maintab/export/ITabTitleConfig;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "hasBaseBenefit", "", "isXYZEnable", "isSlideHorizontalEnable", "observe", "rootView", "hideLoadingAndShowViewPager", "showViewPager", "onTabSelected", "tabInfo", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", "state", "onTabDoubleClickedListener", "onBackPressed", "setTitleController", "controller", "searchDelegate", "recordHomePageCrateTime", "initTitleBar", "getContainerEnv", "getHomePageFrom", "getModule", "getHomePageViewEvent", "getHomePageClickEvent", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTabFragmentV2 extends SpaceBaseTabFragment implements w.a, x.a, ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f227299t = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s f227300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f227301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z f227302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ScrollHomeViewPager f227303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HomeViewPager f227304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BitableTabAdapter f227305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.ss.android.lark.maintab.export.d f227306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j f227307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f227308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LKUILoadingView f227309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayout f227310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f227311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f227312s;

    public static final class a {
    }

    static {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
    }

    public static boolean S90() {
        return ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("base_create_base");
    }

    public final boolean T90() {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.homepage.new.xyz.enable") == true) goto L5;
    L7:
        return false;
    L5:
        if (S90() == false) goto L7;
        return true;
    }

    public final String m6() {
        if (this.f227301h != BitableTabType.RECOMMEND.getValue()) goto L5;
        return "recommend";
    L5:
        return "my";
    }

    @Override // com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment, sa5.d
    public final boolean onBackPressed() {
        BitableTabAdapter r100 = this.f227305l;
        if (r100 != null) goto L6;
        tt5.a.h("BitableTabFragmentV2", "mHomeAdapter not initialized, back press not consumed ");
        return false;
    L6:
        Object r101 = r100.f227288d;
        ((y) LarkContext.spiByDwarf(y.class)).b();
        if ((r101 instanceof sa5.d) == true) goto L9;
    L12:
        return false;
    L9:
        if (((sa5.d) r101).onBackPressed() == false) goto L12;
        tt5.a.h("BitableTabFragmentV2", "Back press consumed by :" + r101);
        return true;
    }

    public BitableTabFragmentV2() {
        s r100 = new s();
        this.f227300g = r100;
        this.f227301h = BitableTabType.RECOMMEND.getValue();
        this.f227302i = new z();
        this.f227312s = LazyKt.lazy(new BitableTabFragmentV2$defaultTabViewModel$2(this));
        new q(r100);
        this.f227582f = new c(this);
    }

    public final void U90(View r110) {
        ad5.e[] r100 = new ad5.e[2];
        int r101 = BitableTabType.RECOMMEND.getValue();
        BitableBannerConfig r102 = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        com.ss.android.lark.maintab.export.d r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getHomePageLeftTabTitle();
    L6:
        r100[0] = new ad5.e(r101, R.string.Bitable_Homepage_Mobile_Recommended_Header, r104, 0);
        BitableTabType r105 = BitableTabType.MINE;
        int r106 = r105.getValue();
        BitableBannerConfig r107 = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        if (r107 == null) goto L9;
        String r108 = r107.getHomePageRightTabTitle();
    L10:
        r100[1] = new ad5.e(r106, R.string.Bitable_Homepage_Mobile_Home_Header, r108, 0);
        List r109 = CollectionsKt.mutableListOf(r100);
        if (T90() == false) goto L13;
    L15:
        MagicIndicator r111 = (MagicIndicator) r110.findViewById(R.id.magic_indicator);
        if (S90() == true) goto L18;
        View r112 = r110.findViewById(R.id.magic_indicator_divider);
        r111.setVisibility(8);
        r112.setVisibility(8);
        this.f227301h = r105.getValue();
    L18:
        this.f227303j = (ScrollHomeViewPager) r110.findViewById(R.id.scroll_view_pager);
        this.f227304k = (HomeViewPager) r110.findViewById(R.id.home_view_pager);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.homepage.new.slide.horizontal.enable") == true) goto L21;
    L23:
        boolean r113 = false;
    L25:
        if (r113 == false) goto L45;
        tt5.a.h("BitableTabFragmentV2", "[HomePage]Horizontal enable");
        ScrollHomeViewPager r114 = this.f227303j;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r114 = null;
    L29:
        r114.setVisibility(0);
        HomeViewPager r115 = this.f227304k;
        if (r115 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeViewPager");
        r115 = null;
    L32:
        r115.setVisibility(8);
        wuc.a r116 = new wuc.a(getContext());
        r116.setAdjustMode(true);
        r116.setAdapter(new x(requireContext(), r116, r109, this));
        r116.onPageSelected(this.f227301h);
        r111.setNavigator(r116);
        ScrollHomeViewPager r117 = this.f227303j;
        if (r117 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r117 = null;
    L35:
        r117.addOnPageChangeListener(new tuc.c(r111));
        BitableTabAdapter r118 = new BitableTabAdapter(getChildFragmentManager(), requireContext(), r109, this.f227302i);
        this.f227305l = r118;
        ScrollHomeViewPager r119 = this.f227303j;
        if (r119 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r119 = null;
    L38:
        r118.f227289e = r119;
        ScrollHomeViewPager r120 = this.f227303j;
        if (r120 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r120 = null;
    L41:
        BitableTabAdapter r121 = this.f227305l;
        if (r121 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeAdapter");
        r121 = null;
    L44:
        r120.setAdapter(r121);
        r120.setCurrentItem(this.f227301h);
        r120.setOffscreenPageLimit(0);
        r120.addOnPageChangeListener(this);
        r120.setOnApplyWindowInsetsListener(null);
    L59:
        if (this.f227306m != null) goto L61;
        tt5.a.h("BitableTabFragmentV2", "mTitleController not initialized, do not init title bar");
        return;
    L61:
        Context r122 = getContext();
        com.ss.android.lark.maintab.export.d r123 = this.f227306m;
        if (r123 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleController");
        r123 = null;
    L64:
        s r124 = this.f227300g;
        j r125 = this.f227307n;
        if (r125 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchDelegate");
        r125 = null;
    L67:
        r123.getTitleBarHeight();
        bd5.b r126 = new bd5.b(r122);
        com.ss.android.lark.maintab.export.d r127 = this.f227306m;
        if (r127 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleController");
    L71:
        r103.a();
        if (this.f227307n != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchDelegate");
    L74:
        bd5.a r128 = r126.d();
        r128.f18657b = r125;
        r128.f18656a.setOnClickListener(r125);
        bd5.a r129 = r126.d();
        r126.b();
        r126.c();
        ArrayList r130 = new ArrayList();
        r130.add(r129);
        ((ArrayList) r124.f18679a).clear();
        ((ArrayList) r124.f18679a).addAll(r130);
        ITitleInfo.IconStyle r131 = ITitleInfo.IconStyle.Hide;
        r123.b();
        getString(R.string.Bitable_Workspace_Base_Title);
        r123.b();
        return;
    L70:
        r103 = r127;
        goto L71
    L45:
        tt5.a.h("BitableTabFragmentV2", "[HomePage]Horizontal disable");
        ScrollHomeViewPager r132 = this.f227303j;
        if (r132 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r132 = null;
    L48:
        r132.setVisibility(8);
        HomeViewPager r133 = this.f227304k;
        if (r133 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeViewPager");
        r133 = null;
    L51:
        r133.setVisibility(0);
        wuc.a r134 = new wuc.a(getContext());
        r134.setAdjustMode(true);
        r134.setAdapter(new w(requireContext(), r134, r109, this));
        r134.onPageSelected(this.f227301h);
        r111.setNavigator(r134);
        this.f227305l = new BitableTabAdapter(getChildFragmentManager(), requireContext(), r109, this.f227302i);
        HomeViewPager r135 = this.f227304k;
        if (r135 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeViewPager");
        r135 = null;
    L54:
        BitableTabAdapter r136 = this.f227305l;
        if (r136 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeAdapter");
        r136 = null;
    L57:
        r135.setAdapter(r136);
        r135.setCurrentItem(this.f227301h);
        r135.setOffscreenPageLimit(0);
        r135.addOnPageChangeListener(this);
        r135.setOnApplyWindowInsetsListener(null);
        goto L59
    L21:
        if (S90() == false) goto L23;
        r113 = true;
        goto L25
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.hp.first.show.myspace.enable") == false) goto L15;
        this.f227301h = r105.getValue();
        goto L15
    L9:
        r108 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment, com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (T90() == false) goto L6;
        tt5.a.h("BitableTabFragmentV2", "[HomePage]xyz enable, loadxyz data");
        ((BitableDefaultTabViewModel) this.f227312s.getValue()).loadXYZData();
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        tt5.a.h("BitableTabFragmentV2", "onPageSelected()...position = " + r100);
        if (r100 < 0) goto L13;
        BitableTabAdapter r101 = this.f227305l;
        if (r101 == null) goto L13;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeAdapter");
        r101 = null;
    L9:
        if (r100 >= r101.getCount()) goto L13;
        this.f227301h = r100;
        return;
    L13:
        tt5.a.h("BitableTabFragmentV2", "illegal position");
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.w.a, com.bytedance.ee.bear.bitable.homepage.x.a
    public final void V0(int r110, ad5.e r111) {
        Intrinsics.checkNotNullParameter(r111, "tabInfo");
        tt5.a.h("BitableTabFragmentV2", "onTabSelected()...index = " + r110);
        if (this.f227301h != r110) goto L5;
        return;
    L5:
        lc5.f.a r100 = lc5.f.f508440a;
        String r101 = m6();
        if (r110 != BitableTabType.RECOMMEND.getValue()) goto L8;
        String r102 = "recommend";
    L9:
        p r112 = new p("lark_workspace_bitable_landing", r101, r102, "none", m6(), "ccm_base_homepage_landing_click", "larktab_bitable", "lark_tab");
        Intrinsics.checkNotNullParameter(r112, "param");
        r100.I(r112);
        r100.N("none", "lark_workspace_bitable_landing", m6(), m6(), "larktab_bitable", "lark_tab");
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.homepage.new.slide.horizontal.enable") == true) goto L12;
    L14:
        boolean r113 = false;
    L15:
        ViewPager r103 = null;
        if (r113 == false) goto L22;
        ScrollHomeViewPager r114 = this.f227303j;
        if (r114 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
    L21:
        r103.setCurrentItem(r110);
        return;
    L20:
        r103 = r114;
        goto L21
    L22:
        HomeViewPager r115 = this.f227304k;
        if (r115 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeViewPager");
    L26:
        r103.setCurrentItem(r110);
        return;
    L25:
        r103 = r115;
        goto L26
    L12:
        if (S90() == false) goto L14;
        r113 = true;
        goto L15
    L8:
        r102 = "my";
        goto L9
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_bitable_v2, r101, false);
        if (T90() == false) goto L18;
        Intrinsics.checkNotNull(r103);
        this.f227308o = (LinearLayout) r103.findViewById(R.id.show_loading_view);
        this.f227309p = (LKUILoadingView) r103.findViewById(R.id.tab_loading_view);
        this.f227310q = (LinearLayout) r103.findViewById(R.id.show_view_pager);
        this.f227311r = (TextView) r103.findViewById(R.id.home_loading_text_view);
        LinearLayout r104 = this.f227310q;
        LKUILoadingView r105 = null;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("showViewPagerLayout");
        r104 = null;
    L7:
        r104.setVisibility(8);
        LinearLayout r106 = this.f227308o;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("showLoadingLayout");
        r106 = null;
    L10:
        r106.setVisibility(0);
        LKUILoadingView r107 = this.f227309p;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lkuiLoadingView");
        r107 = null;
    L13:
        r107.addAnimatorListener(new h(this));
        LKUILoadingView r108 = this.f227309p;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("lkuiLoadingView");
    L17:
        r105.playAnimation();
        ((BitableDefaultTabViewModel) this.f227312s.getValue()).getBitableTabChooseResponse().observe(getViewLifecycleOwner(), new i(this, r103));
    L19:
        return r103;
    L16:
        r105 = r108;
        goto L17
    L18:
        Intrinsics.checkNotNull(r103);
        U90(r103);
        goto L19
    }
}
