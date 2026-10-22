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
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.commodity.helper.ECSearchResourceHelper;
import com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.adapter.CommodityGuideSearchV2Adapter;
import com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.customview.NoneScrollViewPager;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.utils.ViewExtKt;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.ECSearchBizScene;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u0017\u0010\u001f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchHeadViewV2;", "Landroid/widget/FrameLayout;", "", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "", "setAttachFragment", "", "isPreChunk", "setIsPreChunkData", "(Ljava/lang/Boolean;)V", "Lcom/ss/android/ugc/aweme/search/model/SearchResultParam;", "param", "setSearchResultParam", "Lcom/ss/android/ugc/aweme/search/common/bean/ECSearchParam;", "searchParam", "setECSearchParams", "", "visibleState", "setViewVisibility", "getViewVisibility", "setViewPagerVisibility", "getViewHeight", "Landroid/view/ViewGroup;", "getParentView", "getTabNum", "getWordsNum", ce.f26391f, "Z", "getCanPullUp", "()Z", "canPullUp", "h", "I", "getUiMode", "()I", "uiMode", "Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/ECSearchBizScene;", RXScreenCaptureService.KEY_INDEX, "Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/ECSearchBizScene;", "getSearchBizScene", "()Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/ECSearchBizScene;", "searchBizScene", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CommodityGuideSearchHeadViewV2 extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f450126j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f450127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NoneScrollViewPager f450128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f450129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f450130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CommodityGuideSearchV2Adapter f450131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Fragment f450132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f450133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f450134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ECSearchBizScene f450135i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchHeadViewV2$Companion;", "", "()V", "ATTACH_TEXT_HEIGHT_DP", "", "EXPAND_HEIGHT_ATTACHED_TEXT", "", "EXPAND_HEIGHT_LABEL", "PADDING_BOTTOM", "PADDING_SAAS_BOTTOM", "PADDING_TOP", "STYLE_NEW", "STYLE_OLD", "TAB_MAX_COUNT", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public CommodityGuideSearchHeadViewV2(Context r100) {
        this(r100, null, 0, 126);
    }

    public CommodityGuideSearchHeadViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 124);
    }

    public CommodityGuideSearchHeadViewV2(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 120);
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
        return this.f450133g;
    }

    public final ECSearchBizScene getSearchBizScene() {
        return this.f450135i;
    }

    public final int getUiMode() {
        return this.f450134h;
    }

    public static final /* synthetic */ void a(CommodityGuideSearchHeadViewV2 r100) {
        r100.getTabNum();
    }

    public void setAttachFragment(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f450132f = r100;
        CommodityGuideSearchV2Adapter r101 = this.f450131e;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        r101.f450195b = r100;
        return;
    }

    public void setViewPagerVisibility(int r100) {
        if (r100 != 0) goto L5;
        String r101 = "VISIBLE";
    L6:
        Logger.a("GuideSearchOpt", "setViewPagerVisibility: ".concat(r101));
        View r102 = this.f450130d;
        if (r102 == null) goto L9;
        r102.setVisibility(r100);
    L9:
        GuideSearchDataViewModel.Companion r103 = GuideSearchDataViewModel.Companion;
        Fragment r104 = this.f450132f;
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

    public CommodityGuideSearchHeadViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        ECSearchBizScene r104 = null;
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
        r104 = ECSearchBizScene.HYBRID_SEARCH;
    L15:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "searchBizScene");
        super(r100, r101, r102);
        this.f450133g = false;
        this.f450134h = r105;
        this.f450135i = r104;
        ITradeSearchHostService r106 = TradeSearch.c(TradeSearch.f453393a);
        float r107 = 1.0f;
        if (r106 == null) goto L22;
        ITradeSearchHostAppInfo r108 = r106.getITradeSearchHostAppInfo();
        if (r108 == null) goto L22;
        Float r109 = r108.getCurrentFontScale();
        if (r109 == null) goto L22;
        float r110 = r109.floatValue();
    L23:
        DimenExtensionsKt.b(Float.valueOf(ECSearchResourceHelper.f450039b.a()));
        LayoutInflater.from(r100).inflate(R.layout.search_ecommerce_gs_view_v2, this, true);
        this.f450127a = (FrameLayout) findViewById(R.id.gsContainerLayout);
        this.f450130d = findViewById(R.id.containerLayout);
        DmtTextView r111 = (DmtTextView) findViewById(R.id.jumpLinkView);
        this.f450129c = findViewById(R.id.tabMaskView);
        CommodityGuideSearchV2Adapter r112 = new CommodityGuideSearchV2Adapter(r100, false, r105);
        this.f450131e = r112;
        final NoneScrollViewPager r113 = (NoneScrollViewPager) findViewById(R.id.gsViewPager);
        r113.setScroll(false);
        r113.setAdapter(r112);
        r113.setOffscreenPageLimit(2);
        r113.addOnPageChangeListener(new CommodityGuideSearchHeadViewV2$$special$$inlined$apply$lambda$1(r113, this));
        Unit r114 = Unit.INSTANCE;
        this.f450128b = r113;
        DmtTabLayout r115 = (DmtTabLayout) findViewById(R.id.gsTabLayout);
        if (r115 != null) goto L26;
    L29:
        Logger.a("SrpProxyDebug", "guide search V2 isFromSaaS = false searchBizScene = " + r104 + ", uiMode = " + r105);
        return;
    L26:
        if (r110 < 1.0f) goto L28;
        r107 = r110;
    L28:
        ViewExtKt.f(r115, DimenExtensionsKt.b(Float.valueOf(20 * r107)));
        r115.setupWithViewPager(this.f450128b);
        r115.setTabMode(0);
        r115.setTabMinWidth(0);
        r115.setAutoFillWhenScrollable(false);
        r115.setOnTabClickListener(new CommodityGuideSearchHeadViewV2$initTabLayout$$inlined$apply$lambda$1(this));
        r115.b(new CommodityGuideSearchHeadViewV2$initTabLayout$$inlined$apply$lambda$2(this));
    L22:
        r110 = 1.0f;
        goto L23
    L11:
        r105 = 0;
        goto L13
    }
}
