package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.amap.api.col.s.ce;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.ies.dmt.ui.widget.tablayout.DmtTabLayout;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.commodity.helper.ECSearchResourceHelper;
import com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.adapter.GuideSearchViewPagerAdapter;
import com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.customview.NoneScrollViewPager;
import com.ss.android.ugc.aweme.discover.commodity.view.BezierView;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.utils.ViewExtKt;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.ECSearchBizScene;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.DimensUtilKt;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002R#\u0010!\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010-\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchHeadViewV4;", "Landroid/widget/FrameLayout;", "", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "", "setAttachFragment", "", "isPreChunk", "setIsPreChunkData", "(Ljava/lang/Boolean;)V", "Lcom/ss/android/ugc/aweme/search/model/SearchResultParam;", "param", "setSearchResultParam", "Lcom/ss/android/ugc/aweme/search/common/bean/ECSearchParam;", "searchParam", "setECSearchParams", "", "visibleState", "setViewVisibility", "getViewVisibility", "setViewPagerVisibility", "getViewHeight", "Landroid/view/ViewGroup;", "getParentView", "getTabNum", "getWordsNum", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GSBottomBackGroundView;", "kotlin.jvm.PlatformType", ce.f26391f, "Lkotlin/Lazy;", "getGsBottomBackground", "()Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GSBottomBackGroundView;", "gsBottomBackground", "l", "Z", "getCanPullUp", "()Z", "canPullUp", "m", "I", "getUiMode", "()I", "setUiMode", "(I)V", "uiMode", "Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/ECSearchBizScene;", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/ECSearchBizScene;", "getSearchBizScene", "()Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/ECSearchBizScene;", "searchBizScene", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityGuideSearchHeadViewV4 extends FrameLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f450156o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f450157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NoneScrollViewPager f450158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f450159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f450160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GuideSearchViewPagerAdapter f450161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Fragment f450162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f450163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f450164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f450165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f450166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f450167k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f450168l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f450169m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ECSearchBizScene f450170n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchHeadViewV4$Companion;", "", "()V", "BEZIER_TAB_GAP", "", "LINE_MASK_VIEW_HEIGHT", "PREFIX_HEIGHT_DEFAULT", "PREFIX_WIDTH_DEFAULT", "SELECTED_STROKE", "TAB_MASK_WIDTH", "TAB_MAX_COUNT", "UNSELECTED_CORNER_RADIUS", "UNSELECTED_STROKE", "VIEW_PAGER_NO_TAB_HEIGHT_COMPRESSED", "VIEW_PAGER_NO_TAB_HEIGHT_NORMAL_NO_ATTACH", "VIEW_PAGER_NO_TAB_HEIGHT_NORMAL_WITH_ATTACH", "VIEW_PAGER_TAB_HEIGHT", "VIEW_PAGER_WITH_TAB_HEIGHT_COMPRESSED", "VIEW_PAGER_WITH_TAB_HEIGHT_NORMAL", "VIEW_PAGER_WITH_TAB_HEIGHT_NORMAL_NO_ATTACH", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public CommodityGuideSearchHeadViewV4(Context r100) {
        this(r100, null, 0, 126);
    }

    public CommodityGuideSearchHeadViewV4(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 124);
    }

    public CommodityGuideSearchHeadViewV4(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 120);
    }

    private final GSBottomBackGroundView getGsBottomBackground() {
        return (GSBottomBackGroundView) this.f450163g.getValue();
    }

    private final int getTabNum() {
        return 0;
    }

    private final int getWordsNum() {
        return 0;
    }

    public final void setECSearchParams(ECSearchParam r100) {
    }

    public void setIsPreChunkData(Boolean r100) {
    }

    public void setSearchResultParam(SearchResultParam r100) {
    }

    public ViewGroup getParentView() {
        ViewParent r100 = getParent();
        if (r100 == null) goto L7;
        return (ViewGroup) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public int getViewHeight() {
        return getHeight();
    }

    public int getViewVisibility() {
        return getVisibility();
    }

    public final boolean getCanPullUp() {
        return this.f450168l;
    }

    public final ECSearchBizScene getSearchBizScene() {
        return this.f450170n;
    }

    public final int getUiMode() {
        return this.f450169m;
    }

    public static final /* synthetic */ void a(CommodityGuideSearchHeadViewV4 r100) {
        r100.getTabNum();
    }

    public void setAttachFragment(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f450162f = r100;
        GuideSearchViewPagerAdapter r101 = this.f450161e;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        r101.f450201b = r100;
        return;
    }

    public final void setUiMode(int r100) {
        this.f450169m = r100;
    }

    public void setViewPagerVisibility(int r100) {
        if (r100 != 0) goto L5;
        String r101 = "VISIBLE";
    L6:
        Logger.a("GuideSearchOpt", "setViewPagerVisibility: ".concat(r101));
        View r102 = this.f450160d;
        if (r102 == null) goto L9;
        r102.setVisibility(r100);
    L9:
        GuideSearchDataViewModel.Companion r103 = GuideSearchDataViewModel.Companion;
        Fragment r104 = this.f450162f;
        r103.getClass();
        GuideSearchDataViewModel r105 = GuideSearchDataViewModel.Companion.a(r104);
        if (r105 == null) goto L18;
        if (r100 != 0) goto L13;
        boolean r106 = true;
    L14:
        r105.setGsVisible(r106);
        Logger.a("GuideSearchOpt", "viewModel isGsVisible = " + r105.isGsVisible());
        if (r105.isGsVisible() == false) goto L19;
        r105.realSendMobShow();
        return;
    L19:
        return;
    L13:
        r106 = false;
        goto L14
    L18:
        return;
    L5:
        r101 = "GONE";
        goto L6
    }

    public void setViewVisibility(int r100) {
        if (r100 != 0) goto L5;
        String r101 = "VISIBLE";
    L6:
        Logger.a("GuideSearchOpt", "CommodityGuideSearchHeadViewV2 setViewVisibility: ".concat(r101));
        setVisibility(r100);
        return;
    L5:
        r101 = "GONE";
        goto L6
    }

    public CommodityGuideSearchHeadViewV4(Context r100, AttributeSet r101, int r102, int r103) {
        ViewGroup.LayoutParams r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r103 & 16) == 0) goto L11;
        int r105 = 16;
    L13:
        if ((r103 & 64) == 0) goto L15;
        ECSearchBizScene r106 = ECSearchBizScene.HYBRID_SEARCH;
    L16:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r106, "searchBizScene");
        super(r100, r101, r102);
        this.f450168l = false;
        this.f450169m = r105;
        this.f450170n = r106;
        ITradeSearchHostService r107 = TradeSearch.c(TradeSearch.f453393a);
        if (r107 == null) goto L23;
        ITradeSearchHostAppInfo r108 = r107.getITradeSearchHostAppInfo();
        if (r108 == null) goto L23;
        Float r109 = r108.getCurrentFontScale();
        if (r109 == null) goto L23;
        r109.floatValue();
    L23:
        this.f450163g = LazyKt.lazy(new CommodityGuideSearchHeadViewV4$gsBottomBackground$2(this));
        ECSearchResourceHelper r110 = ECSearchResourceHelper.f450039b;
        DimenExtensionsKt.b(Float.valueOf(r110.a()));
        this.f450167k = DimensUtilKt.a(Float.valueOf(ECSearchResourceHelper.b(r110, ECSearchResourceHelper.ECSearchTokenKey.ECSearchCardRadius200Token)));
        LayoutInflater.from(r100).inflate(R.layout.search_ecommerce_gs_view_v4, this, true);
        this.f450157a = (FrameLayout) findViewById(R.id.gsContainerLayout);
        this.f450160d = findViewById(R.id.containerLayout);
        View r111 = findViewById(R.id.lineMaskView);
        this.f450164h = r111;
        this.f450165i = findViewById(R.id.leftTabMaskView);
        this.f450166j = findViewById(R.id.rightTabMaskView);
        BezierView r112 = (BezierView) findViewById(R.id.bezierView);
        DmtTextView r113 = (DmtTextView) findViewById(R.id.jumpLinkView);
        this.f450159c = findViewById(R.id.tabMaskView);
        GuideSearchViewPagerAdapter r114 = new GuideSearchViewPagerAdapter(r100, false, this.f450169m);
        this.f450161e = r114;
        final NoneScrollViewPager r115 = (NoneScrollViewPager) findViewById(R.id.gsViewPager);
        r115.setScroll(false);
        r115.setAdapter(r114);
        r115.setOffscreenPageLimit(2);
        r115.addOnPageChangeListener(new CommodityGuideSearchHeadViewV4$$special$$inlined$apply$lambda$1(r115, this));
        Unit r116 = Unit.INSTANCE;
        this.f450158b = r115;
        DmtTabLayout r117 = (DmtTabLayout) findViewById(R.id.gsTabLayout);
        if (r117 == null) goto L40;
        r117.setPadding(DimenExtensionsKt.b(0), DimenExtensionsKt.b(3), DimenExtensionsKt.b(0), DimenExtensionsKt.b(0));
        ViewExtKt.f(r117, DimenExtensionsKt.b(30));
        getGsBottomBackground().setTopBias(DimenExtensionsKt.b(3));
        if (r111 == null) goto L28;
        ViewGroup.LayoutParams r118 = r111.getLayoutParams();
    L30:
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        r104 = r118;
    L33:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r104;
        if (r119 == null) goto L38;
        r119.topMargin = DimenExtensionsKt.b(18);
        r119.height = DimenExtensionsKt.b(24);
        if (r111 == null) goto L38;
        r111.setLayoutParams(r119);
    L38:
        r117.setupWithViewPager(this.f450158b);
        r117.setTabMode(0);
        r117.setTabMinWidth(0);
        r117.setAutoFillWhenScrollable(false);
        r117.setOnTabClickListener(new CommodityGuideSearchHeadViewV4$initTabLayout$$inlined$apply$lambda$1(this));
        r117.b(new CommodityGuideSearchHeadViewV4$initTabLayout$$inlined$apply$lambda$2(this));
        return;
    L28:
        r118 = null;
        goto L30
    L40:
        return;
    L15:
        r106 = null;
        goto L16
    L11:
        r105 = 0;
        goto L13
    }
}
