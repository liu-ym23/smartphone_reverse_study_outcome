package com.ss.android.ugc.aweme.search.common.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.ugc.aweme.discover.commodity.holder.CommodityViewHolder;
import com.ss.android.ugc.aweme.discover.commodity.holder.ECCommodityDynamicCard;
import com.ss.android.ugc.aweme.discover.dynamic.optimize.IECSaaSOptimize;
import com.ss.android.ugc.aweme.discover.model.CardProtocolType;
import com.ss.android.ugc.aweme.discover.model.Commodity;
import com.ss.android.ugc.aweme.discover.model.FeedBoxBanner;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.model.SearchCommodityDynamicPatch;
import com.ss.android.ugc.aweme.discover.model.SearchShopWindowControlInfo;
import com.ss.android.ugc.aweme.discover.model.VideoPlayInfo;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.helper.SearchCommodityAdapterHelper;
import com.ss.android.ugc.aweme.search.common.ICommonSearchViewHolder;
import com.ss.android.ugc.aweme.search.common.ICommonSearchViewHolderFactory;
import com.ss.android.ugc.aweme.search.common.IViewHolderAttach;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchMobParam;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.bean.ECViewHolderParam;
import com.ss.android.ugc.aweme.search.common.helper.ECSearchAdapterHelper;
import com.ss.android.ugc.aweme.search.common.list.base.LoadMoreRecyclerViewAdapter;
import com.ss.android.ugc.aweme.search.common.list.base.RecyclerHeaderViewAdapter;
import com.ss.android.ugc.aweme.search.common.list.config.PreLoadMoreConfig;
import com.ss.android.ugc.aweme.search.common.list.protocol.IVHLifecycleListener;
import com.ss.android.ugc.aweme.search.common.list.viewmodel.ESCommonListViewModel;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchCardUnKnownEvent;
import com.ss.android.ugc.aweme.search.common.result.optimize.ECSearchParamHelper;
import com.ss.android.ugc.aweme.search.common.result.optimize.vhpreload.ECSearchVHPreloadTask$VHProducer;
import com.ss.android.ugc.aweme.search.common.result.request.loadmore.ECSearchLoadMoreTrigger;
import com.ss.android.ugc.aweme.search.common.saas.autoplay.AutoPlayConfig;
import com.ss.android.ugc.aweme.search.common.saas.autoplay.RecyclerViewScrollStateManager;
import com.ss.android.ugc.aweme.search.common.saas.autoplay.SearchVideoAutoPlayScrollStateObserver;
import com.ss.android.ugc.aweme.search.common.topsection.ITopSectionManager;
import com.ss.android.ugc.aweme.search.common.topsection.ITopSectionProvider;
import com.ss.android.ugc.aweme.search.common.topsection.TopSectionManager;
import com.ss.android.ugc.aweme.search.common.utils.SearchIDManager;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.ECSearchBizScene;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.android.ugc.aweme.search.optimize.preload.monitor.TradeSearchPreloadCacheHitMonitor;
import com.ss.android.ugc.aweme.search.optimize.preload.monitor.TradeSearchPreloadCacheHitMonitorProvider;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.SubInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonListAdapter;", "Lcom/ss/android/ugc/aweme/search/common/list/base/RecyclerHeaderViewAdapter;", "Lcom/ss/android/ugc/aweme/discover/model/SearchAggregateCommodity;", "Lcom/ss/android/ugc/aweme/search/common/result/optimize/vhpreload/ECSearchVHPreloadTask$VHProducer;", "Lcom/ss/android/ugc/aweme/search/common/topsection/ITopSectionProvider;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ESSaasCommonListAdapter extends RecyclerHeaderViewAdapter<SearchAggregateCommodity> implements ECSearchVHPreloadTask$VHProducer, ITopSectionProvider {
    public ECViewHolderParam A;
    public boolean B;
    public final Map<Integer, WeakReference<RecyclerView.ViewHolder>> C;
    public final List<Integer> D;
    public final Map<Integer, Integer> E;
    public final Map<Integer, Boolean> F;
    public final Fragment G;
    public final ECSearchParam H;
    public final ESSaasCommonList I;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f451649p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f451650q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f451651r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IVHLifecycleListener f451652s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ECSearchLoadMoreTrigger f451653t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f451654u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PreLoadMoreConfig f451655v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SearchCommodityAdapterHelper f451656w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TopSectionManager f451657x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AutoPlayConfig f451658y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public IECSaaSOptimize f451659z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonListAdapter$Companion;", "", "()V", "LOAD_MORE_HEIGHT_DIP", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final ESCommonListViewModel E2() {
        return (ESCommonListViewModel) this.f451650q.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // com.ss.android.ugc.aweme.search.common.topsection.ITopSectionProvider
    public final ITopSectionManager A0() {
        return this.f451657x;
    }

    public final boolean A2(int r100) {
        List<T> r101 = this.f451667k;
        if (r101 == 0) goto L18;
        int r102 = r101.size();
        if (this.G.getActivity() != null) goto L7;
        return false;
    L7:
        if (this.G.isDetached() == true) goto L20;
        FragmentActivity r103 = this.G.getActivity();
        if (r103 != null) goto L11;
    L13:
        if (r100 < 0) goto L23;
        if (r102 <= r100) goto L21;
        return true;
    L21:
        return false;
    L23:
        return false;
    L11:
        if (r103.isFinishing() != true) goto L13;
        return false;
    L20:
        return false;
    L18:
        return false;
    }

    public final int C2(SearchAggregateCommodity r100) {
        if (r100 != null) goto L5;
        return -2147483647;
    L5:
        Integer r101 = r100.getResultType();
        if (r101 != null) goto L9;
    L10:
        Integer r102 = r100.getResultType();
        if (r102 != null) goto L14;
    L15:
        Integer r103 = r100.getResultType();
        if (r103 == null) goto L22;
        if (r103.intValue() != 11) goto L22;
    L135:
        Integer r104 = r100.getResultType();
        if (r104 != null) goto L138;
        return -2147483647;
    L138:
        return r104.intValue();
    L22:
        if (Intrinsics.areEqual(this.f451651r, "single_column") == false) goto L27;
        List<String> r105 = r100.getSupporTypes();
        if (r105 == null) goto L26;
        boolean r106 = r105.contains("single_column");
    L31:
        if (r106 == true) goto L33;
        return -2147483647;
    L33:
        Integer r107 = r100.getResultType();
        if (r107 != null) goto L37;
    L40:
        Integer r108 = r100.getResultType();
        if (r108 == null) goto L134;
        int r109 = r108.intValue();
        Aweme r110 = r100.getAweme();
        if (r110 != null) goto L45;
    L80:
        Integer r111 = null;
        if (r109 != 6) goto L93;
        SearchShopWindowControlInfo r112 = r100.getControlInfo();
        if (r112 == null) goto L85;
        String r113 = r112.getOutPlayType();
    L87:
        if (Intrinsics.areEqual(r113, "replay") == false) goto L93;
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L91;
        return 1001;
    L91:
        return -1001;
    L85:
        r113 = null;
    L93:
        if (r109 != 1) goto L107;
        Commodity r114 = r100.getCommodity();
        if (r114 == null) goto L97;
        VideoPlayInfo r115 = r114.getVideoPlayInfo();
    L98:
        if (r115 != null) goto L102;
        if (r100.getAweme() == null) goto L107;
    L102:
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L104;
        return 1002;
    L104:
        return -1002;
    L97:
        r115 = null;
    L107:
        if (r109 != 34) goto L130;
        FeedBoxBanner r116 = r100.getFeedBanner();
        if (r116 == null) goto L111;
        r111 = r116.getBannerContentType();
    L111:
        if (r111 != null) goto L114;
    L120:
        if (r111 == null) goto L130;
        if (r111.intValue() != 1) goto L130;
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == true) goto L127;
        return 970;
    L127:
        return TTVideoEngineInterface.PLAYER_OPTION_GSKEY_CPU_REFRESH_FIX;
    L114:
        if (r111.intValue() != 2) goto L120;
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == true) goto L118;
        return TTVideoEngineInterface.PLAYER_OPTION_GSKEY_BURY_DATA_OPTIMIZE;
    L118:
        return TTVideoEngineInterface.PLAYER_OPTION_GSKEY_ENGINE_CROSSTALK_CHECK;
    L130:
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L133;
        return r109;
    L133:
        return r109 * (-1);
    L45:
        if (r110.getAd() != true) goto L80;
        if (r109 == 2) goto L76;
        if (r109 == 6) goto L71;
        if (r109 == 24) goto L66;
        if (r109 == 30) goto L61;
        if (r109 == 33) goto L56;
        return -2147483647;
    L56:
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == true) goto L139;
        return -33;
    L139:
        return 33;
    L61:
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == true) goto L140;
        return -30;
    L140:
        return 30;
    L66:
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == true) goto L141;
        return -24;
    L141:
        return 24;
    L71:
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L73;
        return 991;
    L73:
        return -991;
    L76:
        if (Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L78;
        return 990;
    L78:
        return -990;
    L134:
        return -2147483647;
    L37:
        if (r107.intValue() != 99) goto L40;
        return this.f451656w.a(r100, Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE));
    L26:
        r106 = false;
        goto L31
    L27:
        List<String> r117 = r100.getSupporTypes();
        if (r117 == null) goto L30;
        r106 = r117.contains(ItemStyle.ITEM_STYLE_DOUBLE);
        goto L31
    L30:
        r106 = true;
        goto L31
    L14:
        if (r102.intValue() == 48) goto L135;
    L9:
        if (r101.intValue() == 22) goto L135;
        goto L10
    }

    public final SearchAggregateCommodity D2(int r100) {
        if (A2(r100) == true) goto L6;
        return null;
    L6:
        return (SearchAggregateCommodity) CollectionsKt.getOrNull(this.f451667k, r100);
    }

    public final RecyclerView.ViewHolder G2(int r110) {
        RecyclerView r100 = this.I.getInnerView();
        Intrinsics.checkNotNull(r100);
        ECSearchCardUnKnownEvent r101 = new ECSearchCardUnKnownEvent();
        IVHLifecycleListener r102 = this.f451652s;     // Catch: Throwable -> L45 Exception -> L47
        if (r102 == null) goto L6;
        r102.a();     // Catch: Throwable -> L45 Exception -> L47
    L6:
        this.f451656w.getClass();     // Catch: Throwable -> L45 Exception -> L47
        boolean r111 = false;
        if (16777217 > r110) goto L11;
        if (33554432 <= r110) goto L11;
    L12:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L24;
        if (r110 > 33554432) goto L20;
        if (r110 == 972) goto L20;
        boolean r104 = false;
    L21:
        if (r104 == true) goto L24;
        boolean r105 = false;
    L26:
        if (r105 == false) goto L50;
        ECSearchAdapterHelper r106 = ECSearchAdapterHelper.f451621b;     // Catch: Throwable -> L45 Exception -> L47
        this.f451656w.getClass();     // Catch: Throwable -> L45 Exception -> L47
        if (r110 > 33554432) goto L30;
        if (r110 == 972) goto L30;
    L31:
        if (r111 == false) goto L33;
        int r107 = 1101;
    L34:
        r106.getClass();     // Catch: Throwable -> L45 Exception -> L47
        ICommonSearchViewHolderFactory r108 = ECSearchAdapterHelper.a(r107);     // Catch: Throwable -> L45 Exception -> L47
        if (r108 != null) goto L37;
        Logger.d("ECSearchRequest", "lynx card viewType = " + r110 + ", find lynxFactory null");     // Catch: Throwable -> L45 Exception -> L47
        r101.e(1001);     // Catch: Throwable -> L45 Exception -> L47
    L67:
        IVHLifecycleListener r109 = this.f451652s;
        if (r109 == null) goto L99;
    L74:
        r109.e();
    L99:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L90
        r101.c(a.KEY_CARD_TYPE, String.valueOf(Integer.valueOf(r110)));     // Catch: Throwable -> L90
        ESCommonListViewModel r113 = E2();     // Catch: Throwable -> L90
        String r114 = null;
        if (r113 == null) goto L80;
        ECSearchBizScene r115 = r113.getSearchBizScene();     // Catch: Throwable -> L90
        if (r115 == null) goto L80;
        String r116 = r115.toString();     // Catch: Throwable -> L90
    L81:
        r101.c("search_biz_scene", String.valueOf(r116));     // Catch: Throwable -> L90
        ECSearchParam r117 = this.H;     // Catch: Throwable -> L90
        if (r117 == null) goto L84;
        String r118 = r117.getEnterFrom();     // Catch: Throwable -> L90
    L85:
        r101.c("enter_from", r118);     // Catch: Throwable -> L90
        ECSearchParam r119 = this.H;     // Catch: Throwable -> L90
        if (r119 == null) goto L88;
        r114 = r119.getKeyword();     // Catch: Throwable -> L90
    L88:
        r101.c("search_keyword", r114);     // Catch: Throwable -> L90
        ECSearchParamHelper r120 = ECSearchParamHelper.f451865a;     // Catch: Throwable -> L90
        ECSearchParam r121 = this.H;     // Catch: Throwable -> L90
        r120.getClass();     // Catch: Throwable -> L90
        r101.c("enter_method", ECSearchParamHelper.b(r121));     // Catch: Throwable -> L90
        r101.c("search_id", SearchIDManager.c(SearchIDManager.f452276g));     // Catch: Throwable -> L90
        r101.d();     // Catch: Throwable -> L90
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L90
    L92:
        final View r122 = new View(r100.getContext());
        return new ESSaasCommonListAdapter$realCreateViewHolderSaas$2(r122);
    L84:
        r118 = null;
    L80:
        r116 = null;
    L90:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L92
    L37:
        Object r124 = r108.a(r100, this.f451651r, this.A);     // Catch: Throwable -> L45 Exception -> L47
        if ((r124 instanceof RecyclerView.ViewHolder) == false) goto L44;
        Logger.a("SaaSDebug", "createViewHolder holder = " + r124);     // Catch: Throwable -> L45 Exception -> L47
        RecyclerView.ViewHolder r125 = (RecyclerView.ViewHolder) r124;     // Catch: Throwable -> L45 Exception -> L47
        IVHLifecycleListener r126 = this.f451652s;
        if (r126 == null) goto L43;
        r126.e();
    L43:
        return r125;
    L44:
        Logger.d("ECSearchRequest", "lynx holder Error = " + r124);     // Catch: Throwable -> L45 Exception -> L47
        r101.e(1002);     // Catch: Throwable -> L45 Exception -> L47
        r101.c("error", r124.toString());     // Catch: Throwable -> L45 Exception -> L47
        goto L67
    L33:
        r107 = 1102;
    L30:
        r111 = true;
        goto L31
    L50:
        if ((!Intrinsics.areEqual(this.f451651r, ItemStyle.ITEM_STYLE_DOUBLE)) == true) goto L52;
    L55:
        int r127 = r110;
    L56:
        ECSearchAdapterHelper.f451621b.getClass();     // Catch: Throwable -> L45 Exception -> L47
        ICommonSearchViewHolderFactory r128 = ECSearchAdapterHelper.a(r127);     // Catch: Throwable -> L45 Exception -> L47
        if (r128 != null) goto L59;
        Logger.d("ECSearchRequest", "na card viewType = " + r110 + ", find naFactory null");     // Catch: Throwable -> L45 Exception -> L47
        r101.e(2001);     // Catch: Throwable -> L45 Exception -> L47
        goto L67
    L59:
        Object r129 = r128.a(r100, this.f451651r, this.A);     // Catch: Throwable -> L45 Exception -> L47
        if ((r129 instanceof RecyclerView.ViewHolder) == false) goto L66;
        RecyclerView.ViewHolder r130 = (RecyclerView.ViewHolder) r129;     // Catch: Throwable -> L45 Exception -> L47
        IVHLifecycleListener r131 = this.f451652s;
        if (r131 == null) goto L65;
        r131.e();
    L65:
        return r130;
    L66:
        Logger.d("ECSearchRequest", "na holder Error = " + r129);     // Catch: Throwable -> L45 Exception -> L47
        r101.e(2002);     // Catch: Throwable -> L45 Exception -> L47
        r101.c("error", r129.toString());     // Catch: Throwable -> L45 Exception -> L47
        goto L67
    L52:
        if ((-2147483647) >= r110) goto L55;
        if (r110 >= 0) goto L55;
        r127 = r110 * (-1);     // Catch: Throwable -> L45 Exception -> L47
    L20:
        r104 = true;
    L24:
        r105 = true;
    L11:
        if (r110 == 973) goto L12;
        r103 = false;
    L45:
        th = move-exception;
        IVHLifecycleListener r132 = this.f451652s;
        if (r132 == null) goto L97;
        r132.e();
    L97:
        throw th;
    L47:
        e = move-exception;
        r101.e(4001);     // Catch: Throwable -> L45
        r101.c("error", e.getMessage());     // Catch: Throwable -> L45
        r109 = this.f451652s;
        if (r109 == null) goto L99;
        goto L74
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerHeaderViewAdapter, com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public final int getBasicItemViewType(int r100) {
        List<T> r101 = this.f451667k;
        if (r101 == 0) goto L5;
        SearchAggregateCommodity r102 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r101, r100);
    L7:
        return C2(r102);
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.LoadMoreRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.ugc.aweme.search.common.list.base.LoadMoreRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        ViewGroup.LayoutParams r101 = r100.itemView.getLayoutParams();
        if ((r101 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L5;
        r101 = null;
    L5:
        StaggeredGridLayoutManager.LayoutParams r102 = (StaggeredGridLayoutManager.LayoutParams) r101;
        if (r102 == null) goto L16;
        r100.getLayoutPosition();
        if ((r100 instanceof ICommonSearchViewHolder) == false) goto L11;
        boolean r103 = ((ICommonSearchViewHolder) r100).k2();
    L14:
        r102.setFullSpan(r103);
        goto L16
    L11:
        if ((r100 instanceof LoadMoreRecyclerViewAdapter.LoadMoreViewHolder) == false) goto L13;
        r103 = true;
        goto L14
    L13:
        r103 = false;
    L16:
        if ((r100 instanceof IViewHolderAttach) == false) goto L19;
        ((IViewHolderAttach) r100).onViewAttachedToWindow();
    L19:
        if ((r100 instanceof ECCommodityDynamicCard) == false) goto L29;
        ECCommodityDynamicCard r104 = (ECCommodityDynamicCard) r100;
        if (r104.W3() == false) goto L29;
        AutoPlayConfig r105 = this.f451658y;
        if (r105 == null) goto L29;
        RecyclerViewScrollStateManager r106 = r105.f452008a;
        if (r106 == null) goto L29;
        SearchVideoAutoPlayScrollStateObserver r107 = r104.f450043j;
        if (r107 == null) goto L29;
        r107.f452016a = 0;
        r106.f452010b.add(r107);
    L29:
        IVHLifecycleListener r108 = this.f451652s;
        if (r108 == null) goto L33;
        r108.b(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.ugc.aweme.search.common.list.base.LoadMoreRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewDetachedFromWindow(r100);
        if ((r100 instanceof IViewHolderAttach) == false) goto L6;
        ((IViewHolderAttach) r100).onViewDetachedFromWindow();
    L6:
        if ((r100 instanceof ECCommodityDynamicCard) == false) goto L16;
        ECCommodityDynamicCard r101 = (ECCommodityDynamicCard) r100;
        if (r101.W3() == false) goto L16;
        AutoPlayConfig r102 = this.f451658y;
        if (r102 == null) goto L16;
        RecyclerViewScrollStateManager r103 = r102.f452008a;
        if (r103 == null) goto L16;
        SearchVideoAutoPlayScrollStateObserver r104 = r101.f450043j;
        if (r104 == null) goto L16;
        r104.f452016a = 0;
        r103.f452010b.remove(r104);
    L16:
        IVHLifecycleListener r105 = this.f451652s;
        if (r105 == null) goto L20;
        r105.c(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewRecycled(r100);
        if ((r100 instanceof ICommonSearchViewHolder) == false) goto L6;
        ((ICommonSearchViewHolder) r100).D2();
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.LoadMoreRecyclerViewAdapter
    public final int y2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return DimenExtensionsKt.b(Float.valueOf(45.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F2(RecyclerView.ViewHolder r100, int r101) {
        if ((r100 instanceof ICommonSearchViewHolder) == true) goto L52;
        StringBuilder r102 = new StringBuilder("realBindViewHolder error: ");
        if (r100 == 0) goto L7;
        String r103 = r100.getClass().getCanonicalName();
    L8:
        r102.append(r103);
        r102.append(" is not ICommonSearchViewHolder");
        Logger.b("ESCommonList", r102.toString());
        return;
    L7:
        r103 = null;
        goto L8
    L52:
        IVHLifecycleListener r104 = this.f451652s;     // Catch: Throwable -> L40 Exception -> L42
        if (r104 == null) goto L13;
        r104.d(r100);     // Catch: Throwable -> L40 Exception -> L42
    L13:
        ESCommonListViewModel r105 = E2();     // Catch: Throwable -> L40 Exception -> L42
        if (r105 == null) goto L16;
        r105.updateExposureItemCount(r101 + 1);     // Catch: Throwable -> L40 Exception -> L42
    L16:
        SearchAggregateCommodity r106 = D2(r101);     // Catch: Throwable -> L40 Exception -> L42
        if (r106 != null) goto L19;
    L37:
        IVHLifecycleListener r107 = this.f451652s;
        if (r107 == null) goto L55;
    L46:
        r107.f(r100);
        return;
    L55:
        return;
    L19:
        if (r106.isRealTimePushDoc() == false) goto L21;
        Logger.a("ECRealtimePush", "onBindViewHolder realtimePushDoc, set INVISIBLE");     // Catch: Throwable -> L40 Exception -> L42
        r100.itemView.setVisibility(4);     // Catch: Throwable -> L40 Exception -> L42
    L22:
        ESCommonListViewModel r108 = E2();     // Catch: Throwable -> L40 Exception -> L42
        if (r108 == null) goto L30;
        Function3<ESCommonListViewModel, SearchAggregateCommodity, Integer, ECSearchMobParam> r109 = r108.getEcSearchMobParamGetter();     // Catch: Throwable -> L40 Exception -> L42
        if (r109 == null) goto L30;
        ECSearchMobParam r110 = r109.invoke(E2(), r106, Integer.valueOf(r101));     // Catch: Throwable -> L40 Exception -> L42
        if (r110 == null) goto L30;
        ((ICommonSearchViewHolder) r100).O3(r110, this.H);     // Catch: Throwable -> L40 Exception -> L42
    L30:
        if ((r100 instanceof CommodityViewHolder) == false) goto L36;
        ECSearchParam r111 = this.H;     // Catch: Throwable -> L40 Exception -> L42
        if (r111 == null) goto L36;
        SearchResultParam r112 = r111.getSearchResultParam();     // Catch: Throwable -> L40 Exception -> L42
        if (r112 == null) goto L36;
        ((CommodityViewHolder) r100).w0(r112);     // Catch: Throwable -> L40 Exception -> L42
    L36:
        Intrinsics.checkNotNullParameter(r106, CardProtocolType.COMMODITY);     // Catch: Throwable -> L40 Exception -> L42
        Logger.a("SaaSDebug", "bindViewHolder viewHolder = " + r100);     // Catch: Throwable -> L40 Exception -> L42
        ((ICommonSearchViewHolder) r100).c1(r101, r106, this.f451651r);     // Catch: Throwable -> L40 Exception -> L42
        B2(r101, r100, r106);     // Catch: Throwable -> L40 Exception -> L42
    L21:
        r100.itemView.setVisibility(0);     // Catch: Throwable -> L40 Exception -> L42
    L42:
        e = move-exception;
        Logger.b("ESCommonList", "realBindViewHolder error: " + e.getMessage());     // Catch: Throwable -> L40
        r107 = this.f451652s;
        if (r107 != null) goto L46;
        return;
    L40:
        th = move-exception;
        IVHLifecycleListener r113 = this.f451652s;
        if (r113 == null) goto L51;
        r113.f(r100);
    L51:
        throw th;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerHeaderViewAdapter, com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        ECSearchLoadMoreTrigger r103 = this.f451653t;     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r103.a(r101, getBasicItemCount());     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        IECSaaSOptimize r105 = this.f451659z;
        boolean r106 = false;
        if (r105 != null) goto L14;
    L16:
        boolean r107 = false;
    L17:
        if (r107 == false) goto L21;
        Intrinsics.checkNotNullParameter(r100, "holder");
        IECSaaSOptimize r108 = this.f451659z;
        if (r108 == null) goto L23;
        r108.d(r100, r101);
    L23:
        if (((ArrayList) this.D).contains(Integer.valueOf(r100.getItemViewType())) == false) goto L25;
        this.E.put(Integer.valueOf(r100.getItemViewType()), Integer.valueOf(r101));
    L25:
        TradeSearchPreloadCacheHitMonitorProvider.f453391a.getClass();
        TradeSearchPreloadCacheHitMonitor r109 = TradeSearchPreloadCacheHitMonitorProvider.f453392b.get("saas_search");
        if (r109 == null) goto L69;
        String r110 = String.valueOf(r100.hashCode());
        String r111 = this.f451651r;
        ECSearchParam r112 = this.H;
        if (r112 == null) goto L30;
        String r113 = r112.getEnterFrom();
    L31:
        SearchAggregateCommodity r114 = D2(r101);
        if (r114 == null) goto L36;
        SearchCommodityDynamicPatch r115 = r114.getDynamicPatch();
        if (r115 == null) goto L36;
        String r116 = r115.schema;
    L37:
        Intrinsics.checkNotNullParameter(r111, SubInfo.KEY_FORMAT);
        if (r116 != null) goto L40;
    L43:
        boolean r117 = true;
    L44:
        if (r117 == false) goto L47;
        return;
    L47:
        if (CollectionsKt.contains(r109.f453380b, r110) == false) goto L49;
        r109.f453384f++;
    L49:
        r109.f453389k++;
        String r118 = r109.f453382d;
        if (r118 != null) goto L52;
    L54:
        if (r106 == false) goto L56;
        r109.f453390l++;
    L62:
        r109.f453387i = r111;
        if (r113 != null) goto L65;
        r113 = "";
    L65:
        r109.f453388j = r113;
        return;
    L56:
        StringBuilder r119 = r109.f453383e;
        if (r119 == null) goto L59;
        r119.append(r116);
    L59:
        StringBuilder r120 = r109.f453383e;
        if (r120 == null) goto L62;
        r120.append(" ");
        goto L62
    L52:
        if (StringsKt.contains$default(r118, r116, false, 2, null) != true) goto L54;
        r106 = true;
        goto L54
    L40:
        if (r116.length() == 0) goto L43;
        r117 = false;
    L36:
        r116 = null;
        goto L37
    L30:
        r113 = null;
        goto L31
    L69:
        return;
    L21:
        F2(r100, r101);
        goto L23
    L14:
        if (r105.j() != true) goto L16;
        r107 = true;
        goto L17
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerHeaderViewAdapter, com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(final ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (this.I.getInnerView() != null) goto L6;
        final View r102 = new View(r100.getContext());
        return new AnonymousClass1(r100, r102);
    L6:
        IECSaaSOptimize r103 = this.f451659z;
        if (r103 == null) goto L11;
        boolean r104 = true;
        if (r103.j() != true) goto L11;
    L12:
        if (r104 == false) goto L19;
        IECSaaSOptimize r105 = this.f451659z;
        if (r105 == null) goto L16;
        RecyclerView.ViewHolder r106 = r105.f(r101);
    L17:
        if (r106 != null) goto L21;
        final View r107 = new View(r100.getContext());
        r106 = new ESSaasCommonListAdapter$onCreateBasicViewHolder$viewHolder$1(r100, r107);
    L21:
        if (r106.itemView.getParent() == null) goto L25;
        Logger.b("ECSearchRequest", "vh create error: viewHolder = " + r106 + ", parent = " + r106.itemView.getParent());
        final View r108 = new View(r100.getContext());
        return new AnonymousClass2(r100, r108);
    L25:
        if (((ArrayList) this.D).contains(Integer.valueOf(r101)) == true) goto L27;
    L29:
        return r106;
    L27:
        if (this.B == false) goto L29;
        this.B = false;
        this.C.put(Integer.valueOf(r101), new WeakReference(r106));
        goto L29
    L16:
        r106 = null;
        goto L17
    L19:
        r106 = G2(r101);
    L11:
        r104 = false;
        goto L12
    }

    public ESSaasCommonListAdapter(Fragment r100, ECSearchParam r101, ESSaasCommonList r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "esCommonList");
        this.G = r100;
        this.H = r101;
        this.I = r102;
        this.f451650q = LazyKt.lazy(new ESSaasCommonListAdapter$listViewModel$2(this));
        this.f451651r = ItemStyle.ITEM_STYLE_DOUBLE;
        this.f451656w = new SearchCommodityAdapterHelper();
        this.C = new LinkedHashMap();
        this.D = new ArrayList();
        this.E = new LinkedHashMap();
        this.F = new LinkedHashMap();
    }

    public static void B2(int r100, RecyclerView.ViewHolder r101, SearchAggregateCommodity r102) {
        Intrinsics.checkNotNullParameter(r102, CardProtocolType.COMMODITY);
        if (r100 != 0) goto L20;
        SearchShopWindowControlInfo r103 = r102.getControlInfo();
        String r104 = null;
        if (r103 == null) goto L7;
        String r105 = r103.getCardSlotType();
    L9:
        if (Intrinsics.areEqual(r105, "ecom_search_marketing_banner") == true) goto L15;
        SearchCommodityDynamicPatch r106 = r102.getDynamicPatch();
        if (r106 == null) goto L14;
        r104 = r106.cardTypeName;
    L14:
        if (Intrinsics.areEqual(r104, "ecom_search_marketing_banner") == true) goto L15;
        return;
    L15:
        if (r101 == null) goto L22;
        View r107 = r101.itemView;
        if (r107 == null) goto L23;
        r107.setMinimumHeight(1);
        return;
    L23:
        return;
    L22:
        return;
    L7:
        r105 = null;
        goto L9
    }
}
