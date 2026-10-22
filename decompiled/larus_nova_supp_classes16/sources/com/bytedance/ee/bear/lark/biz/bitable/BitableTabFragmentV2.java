package com.bytedance.ee.bear.lark.biz.bitable;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import bd5.q;
import bd5.s;
import com.airbnb.lottie.LottieAnimationView;
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
import com.larksuite.component.ui.loading.LKUILoadingView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001UB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J$\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u000207H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u000201H\u0002J\u0010\u0010<\u001a\u00020-2\u0006\u0010;\u001a\u000201H\u0002J\u0010\u0010=\u001a\u00020-2\u0006\u0010;\u001a\u000201H\u0002J\u0018\u0010>\u001a\u00020-2\u0006\u0010)\u001a\u00020\f2\u0006\u0010?\u001a\u00020@H\u0016J \u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\fH\u0016J\u0010\u0010F\u001a\u00020-2\u0006\u0010B\u001a\u00020\fH\u0016J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020\fH\u0016J\b\u0010I\u001a\u00020-H\u0016J\b\u0010J\u001a\u000207H\u0016J\u0016\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u0018J\u0006\u0010N\u001a\u00020-J\b\u0010O\u001a\u00020-H\u0002J\b\u0010P\u001a\u00020'H\u0002J\b\u0010Q\u001a\u00020'H\u0002J\b\u0010R\u001a\u00020'H\u0002J\b\u0010S\u001a\u00020'H\u0002J\b\u0010T\u001a\u00020'H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/lark/biz/bitable/BitableTabFragmentV2;", "Lcom/bytedance/ee/bear/lark/tab/SpaceBaseTabFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/BitableIndicatorAdapter$TabSelectedListener;", "Lcom/bytedance/ee/bear/bitable/homepage/BitableIndicatorAdapterV2$TabSelectedListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "<init>", "()V", "mTitleInfo", "Lcom/bytedance/ee/bear/list/homepage/title/TitleInfo;", "mTitleConfig", "Lcom/bytedance/ee/bear/list/homepage/title/TabTitleConfigWrapper;", "mCurrentItem", "", "mHomePageCreateTime", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/HomePageCreateTimeData;", "mScrollViewPager", "Lcom/bytedance/ee/bear/bitable/homepage/widget/ScrollHomeViewPager;", "mHomeViewPager", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeViewPager;", "mHomeAdapter", "Lcom/bytedance/ee/bear/lark/biz/bitable/BitableTabAdapter;", "mTitleController", "Lcom/ss/android/lark/maintab/export/ITitleController;", "mSearchDelegate", "Landroid/view/View$OnClickListener;", "showLoadingLayout", "Landroid/widget/LinearLayout;", "lkuiLoadingView", "Lcom/larksuite/component/ui/loading/LKUILoadingView;", "showViewPagerLayout", "homeLoadingTextView", "Landroid/widget/TextView;", "defaultTabViewModel", "Lcom/bytedance/ee/bear/bitable/homepage/BitableDefaultTabViewModel;", "getDefaultTabViewModel", "()Lcom/bytedance/ee/bear/bitable/homepage/BitableDefaultTabViewModel;", "defaultTabViewModel$delegate", "Lkotlin/Lazy;", "getSubModule", "", "getTabType", "index", "getTabTitleConfig", "Lcom/ss/android/lark/maintab/export/ITabTitleConfig;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "hasBaseBenefit", "", "isXYZEnable", "isSlideHorizontalEnable", "observe", "rootView", "hideLoadingAndShowViewPager", "showViewPager", "onTabSelected", "tabInfo", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", "state", "onTabDoubleClickedListener", "onBackPressed", "setTitleController", "controller", "searchDelegate", "recordHomePageCrateTime", "initTitleBar", "getContainerEnv", "getHomePageFrom", "getModule", "getHomePageViewEvent", "getHomePageClickEvent", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTabFragmentV2 extends SpaceBaseTabFragment implements w.a, x.a, ViewPager.OnPageChangeListener {
    public static final /* synthetic */ int t = 0;
    public final s g;
    public int h;
    public final z i;
    public ScrollHomeViewPager j;
    public HomeViewPager k;
    public BitableTabAdapter l;
    public com.ss.android.lark.maintab.export.d m;
    public j n;
    public LinearLayout o;
    public LKUILoadingView p;
    public LinearLayout q;
    public TextView r;
    public final Lazy s;

    public static final class a {
    }

    static {
    }

    public final void onPageScrollStateChanged(int r1) {
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
    }

    public static boolean S90() {
        return ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("base_create_base");
    }

    public final boolean T90() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.homepage.new.xyz.enable") == true) goto L5;
    L7:
        return false;
    L5:
        if (S90() == false) goto L7;
        return true;
    }

    public final String m6() {
        if (this.h != BitableTabType.RECOMMEND.getValue()) goto L5;
        return "recommend";
    L5:
        return "my";
    }

    @Override // com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment, sa5.d
    public final boolean onBackPressed() {
        BitableTabAdapter r0 = this.l;
        if (r0 != null) goto L6;
        tt5.a.h("BitableTabFragmentV2", "mHomeAdapter not initialized, back press not consumed ");
        return false;
    L6:
        sa5.d r1 = r0.d;
        ((y) LarkContext.spiByDwarf(y.class)).b();
        if ((r1 instanceof sa5.d) == true) goto L9;
    L12:
        return false;
    L9:
        if (r1.onBackPressed() == false) goto L12;
        tt5.a.h("BitableTabFragmentV2", "Back press consumed by :" + r1);
        return true;
    }

    public BitableTabFragmentV2() {
        s r0 = new s();
        this.g = r0;
        this.h = BitableTabType.RECOMMEND.getValue();
        this.i = new z();
        this.s = LazyKt.lazy(new BitableTabFragmentV2$defaultTabViewModel$2(this));
        new q(r0);
        this.f = new c(this);
    }

    public final void U90(View r11) {
        ad5.e[] r0 = new ad5.e[2];
        int r2 = BitableTabType.RECOMMEND.getValue();
        BitableBannerConfig r3 = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        com.ss.android.lark.maintab.export.d r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getHomePageLeftTabTitle();
    L6:
        r0[0] = new ad5.e(r2, 2131886597, r5, 0);
        BitableTabType r6 = BitableTabType.MINE;
        int r7 = r6.getValue();
        BitableBannerConfig r8 = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        if (r8 == null) goto L9;
        String r9 = r8.getHomePageRightTabTitle();
    L10:
        r0[1] = new ad5.e(r7, 2131886595, r9, 0);
        List r1 = CollectionsKt.mutableListOf(r0);
        if (T90() == false) goto L13;
    L15:
        MagicIndicator r10 = r11.findViewById(2131379416);
        if (S90() == true) goto L18;
        View r12 = r11.findViewById(2131379417);
        r10.setVisibility(8);
        r12.setVisibility(8);
        this.h = r6.getValue();
    L18:
        this.j = r11.findViewById(2131385245);
        this.k = r11.findViewById(2131374495);
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.homepage.new.slide.horizontal.enable") == true) goto L21;
    L23:
        boolean r13 = false;
    L25:
        if (r13 == false) goto L45;
        tt5.a.h("BitableTabFragmentV2", "[HomePage]Horizontal enable");
        ViewGroup r14 = this.j;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r14 = null;
    L29:
        r14.setVisibility(0);
        ViewGroup r16 = this.k;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeViewPager");
        r16 = null;
    L32:
        r16.setVisibility(8);
        wuc.a r17 = new wuc.a(getContext());
        r17.setAdjustMode(true);
        r17.setAdapter(new x(requireContext(), r17, r1, this));
        r17.onPageSelected(this.h);
        r10.setNavigator(r17);
        ViewPager r18 = this.j;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r18 = null;
    L35:
        r18.addOnPageChangeListener(new tuc.c(r10));
        BitableTabAdapter r19 = new BitableTabAdapter(getChildFragmentManager(), requireContext(), r1, this.i);
        this.l = r19;
        com.bytedance.ee.bear.list.list.d.c r20 = this.j;
        if (r20 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r20 = null;
    L38:
        r19.e = r20;
        ViewPager r110 = this.j;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r110 = null;
    L41:
        PagerAdapter r21 = this.l;
        if (r21 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeAdapter");
        r21 = null;
    L44:
        r110.setAdapter(r21);
        r110.setCurrentItem(this.h);
        r110.setOffscreenPageLimit(0);
        r110.addOnPageChangeListener(this);
        r110.setOnApplyWindowInsetsListener(null);
    L59:
        if (this.m != null) goto L61;
        tt5.a.h("BitableTabFragmentV2", "mTitleController not initialized, do not init title bar");
        return;
    L61:
        Context r111 = getContext();
        com.ss.android.lark.maintab.export.d r22 = this.m;
        if (r22 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleController");
        r22 = null;
    L64:
        s r23 = this.g;
        j r24 = this.n;
        if (r24 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchDelegate");
        r24 = null;
    L67:
        r22.getTitleBarHeight();
        bd5.b r26 = new bd5.b(r111);
        com.ss.android.lark.maintab.export.d r112 = this.m;
        if (r112 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleController");
    L71:
        r4.a();
        if (this.n != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchDelegate");
    L74:
        bd5.a r113 = r26.d();
        r113.b = r24;
        r113.a.setOnClickListener(r24);
        bd5.a r114 = r26.d();
        r26.b();
        r26.c();
        ArrayList r27 = new ArrayList();
        r27.add(r114);
        ((ArrayList) r23.a).clear();
        ((ArrayList) r23.a).addAll(r27);
        ITitleInfo.IconStyle r115 = ITitleInfo.IconStyle.Hide;
        r22.b();
        getString(2131886906);
        r22.b();
        return;
    L70:
        r4 = r112;
        goto L71
    L45:
        tt5.a.h("BitableTabFragmentV2", "[HomePage]Horizontal disable");
        ViewGroup r116 = this.j;
        if (r116 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
        r116 = null;
    L48:
        r116.setVisibility(8);
        ViewGroup r117 = this.k;
        if (r117 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeViewPager");
        r117 = null;
    L51:
        r117.setVisibility(0);
        wuc.a r118 = new wuc.a(getContext());
        r118.setAdjustMode(true);
        r118.setAdapter(new w(requireContext(), r118, r1, this));
        r118.onPageSelected(this.h);
        r10.setNavigator(r118);
        this.l = new BitableTabAdapter(getChildFragmentManager(), requireContext(), r1, this.i);
        ViewPager r119 = this.k;
        if (r119 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeViewPager");
        r119 = null;
    L54:
        PagerAdapter r28 = this.l;
        if (r28 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeAdapter");
        r28 = null;
    L57:
        r119.setAdapter(r28);
        r119.setCurrentItem(this.h);
        r119.setOffscreenPageLimit(0);
        r119.addOnPageChangeListener(this);
        r119.setOnApplyWindowInsetsListener(null);
        goto L59
    L21:
        if (S90() == false) goto L23;
        r13 = true;
        goto L25
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.hp.first.show.myspace.enable") == false) goto L15;
        this.h = r6.getValue();
        goto L15
    L9:
        r9 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (T90() == false) goto L6;
        tt5.a.h("BitableTabFragmentV2", "[HomePage]xyz enable, loadxyz data");
        ((BitableDefaultTabViewModel) this.s.getValue()).loadXYZData();
        return;
    }

    public final void onPageSelected(int r3) {
        tt5.a.h("BitableTabFragmentV2", "onPageSelected()...position = " + r3);
        if (r3 < 0) goto L13;
        BitableTabAdapter r0 = this.l;
        if (r0 == null) goto L13;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeAdapter");
        r0 = null;
    L9:
        if (r3 >= r0.getCount()) goto L13;
        this.h = r3;
        return;
    L13:
        tt5.a.h("BitableTabFragmentV2", "illegal position");
    }

    public final void V0(int r11, ad5.e r12) {
        Intrinsics.checkNotNullParameter(r12, "tabInfo");
        tt5.a.h("BitableTabFragmentV2", "onTabSelected()...index = " + r11);
        if (this.h != r11) goto L5;
        return;
    L5:
        lc5.f.a r0 = lc5.f.a;
        String r3 = m6();
        if (r11 != BitableTabType.RECOMMEND.getValue()) goto L8;
        String r1 = "recommend";
    L9:
        p r13 = new p("lark_workspace_bitable_landing", r3, r1, "none", m6(), "ccm_base_homepage_landing_click", "larktab_bitable", "lark_tab");
        Intrinsics.checkNotNullParameter(r13, "param");
        r0.I(r13);
        r0.N("none", "lark_workspace_bitable_landing", m6(), m6(), "larktab_bitable", "lark_tab");
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.homepage.new.slide.horizontal.enable") == true) goto L12;
    L14:
        boolean r14 = false;
    L15:
        ViewPager r2 = null;
        if (r14 == false) goto L22;
        ViewPager r16 = this.j;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mScrollViewPager");
    L21:
        r2.setCurrentItem(r11);
        return;
    L20:
        r2 = r16;
        goto L21
    L22:
        ViewPager r17 = this.k;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mHomeViewPager");
    L26:
        r2.setCurrentItem(r11);
        return;
    L25:
        r2 = r17;
        goto L26
    L12:
        if (S90() == false) goto L14;
        r14 = true;
        goto L15
    L8:
        r1 = "my";
        goto L9
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131561171, r4, false);
        if (T90() == false) goto L18;
        Intrinsics.checkNotNull(r6);
        this.o = (LinearLayout) r6.findViewById(2131386395);
        this.p = r6.findViewById(2131388039);
        this.q = (LinearLayout) r6.findViewById(2131386402);
        this.r = (TextView) r6.findViewById(2131374452);
        LinearLayout r7 = this.q;
        LottieAnimationView r8 = null;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("showViewPagerLayout");
        r7 = null;
    L7:
        r7.setVisibility(8);
        LinearLayout r9 = this.o;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("showLoadingLayout");
        r9 = null;
    L10:
        r9.setVisibility(0);
        LottieAnimationView r10 = this.p;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lkuiLoadingView");
        r10 = null;
    L13:
        r10.addAnimatorListener(new h(this));
        LottieAnimationView r11 = this.p;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("lkuiLoadingView");
    L17:
        r8.playAnimation();
        ((BitableDefaultTabViewModel) this.s.getValue()).getBitableTabChooseResponse().observe(getViewLifecycleOwner(), new i(this, r6));
    L19:
        return r6;
    L16:
        r8 = r11;
        goto L17
    L18:
        Intrinsics.checkNotNull(r6);
        U90(r6);
        goto L19
    }
}
