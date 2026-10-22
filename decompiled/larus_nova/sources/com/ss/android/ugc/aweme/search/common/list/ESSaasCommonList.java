package com.ss.android.ugc.aweme.search.common.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.FeedSection;
import com.ss.android.ugc.aweme.discover.dynamic.optimize.IECSaaSOptimize;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import com.ss.android.ugc.aweme.helper.SearchCommodityAdapterHelper;
import com.ss.android.ugc.aweme.search.common.ILoadMoreFunction;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchMobParam;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.bean.ECViewHolderParam;
import com.ss.android.ugc.aweme.search.common.event.ECSearchSafeEventBusWrapper;
import com.ss.android.ugc.aweme.search.common.event.ECSearchUpdateListAdapterHelper;
import com.ss.android.ugc.aweme.search.common.event.IECSearchSafeEventBusWrapper$EventListener;
import com.ss.android.ugc.aweme.search.common.list.base.LoadMoreRecyclerViewAdapter;
import com.ss.android.ugc.aweme.search.common.list.config.ESSaasCommonListConfig;
import com.ss.android.ugc.aweme.search.common.list.config.PreLoadMoreConfig;
import com.ss.android.ugc.aweme.search.common.list.config.TopSectionConfig;
import com.ss.android.ugc.aweme.search.common.list.inner.ECSaasSearchRecyclerView;
import com.ss.android.ugc.aweme.search.common.list.protocol.IVHLifecycleListener;
import com.ss.android.ugc.aweme.search.common.list.viewmodel.ESCommonListViewModel;
import com.ss.android.ugc.aweme.search.common.result.optimize.vhpreload.ECSearchVHPreloadTask$VHProducer;
import com.ss.android.ugc.aweme.search.common.result.request.loadmore.ECSearchLoadMoreTrigger;
import com.ss.android.ugc.aweme.search.common.saas.autoplay.AutoPlayConfig;
import com.ss.android.ugc.aweme.search.common.saas.autoplay.RecyclerViewScrollStateManager;
import com.ss.android.ugc.aweme.search.common.topsection.ITopSectionManager;
import com.ss.android.ugc.aweme.search.common.topsection.MarketBannerApiKt;
import com.ss.android.ugc.aweme.search.common.topsection.TopSectionManager;
import com.ss.android.ugc.aweme.search.common.utils.ThreadUtils;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterViewModel;
import com.ss.android.ugc.aweme.search.mob.ItemMobParam;
import com.ss.ttvideoengine.model.SubInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010A\u001a\u00020\u0003¢\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010!\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001d\u00107\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u00108\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b8\u0010:\"\u0004\b;\u0010<¨\u0006D"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonList;", "Landroid/widget/FrameLayout;", "", "", "getLayoutId", "Lcom/ss/android/ugc/aweme/search/common/bean/ECViewHolderParam;", "vhParam", "", "setUpViewHolderParam", "", "Lcom/ss/android/ugc/aweme/discover/model/SearchAggregateCommodity;", "getItemList", "getItemListOfTopSection", "getItemCount", "getDeleteItemList", "getFirstVisibleItemPositions", "getLastVisibleItemPositions", "Lcom/ss/android/ugc/aweme/search/common/topsection/ITopSectionManager;", "getTopSectionManager", "Lcom/ss/android/ugc/aweme/search/common/ILoadMoreFunction;", "listener", "setLoadMoreListener", "Landroidx/recyclerview/widget/RecyclerView;", "getInnerView", "", "isShow", "setShowFooter", "Lcom/ss/android/ugc/aweme/search/common/result/optimize/vhpreload/ECSearchVHPreloadTask$VHProducer;", "getVHProducer", "Lcom/ss/android/ugc/aweme/helper/SearchCommodityAdapterHelper;", "getLynxViewTypeManager", "getViewHolderParam", "Lcom/ss/android/ugc/aweme/search/common/list/protocol/IVHLifecycleListener;", "setVHLifecycleListener", "Lcom/ss/android/ugc/aweme/search/common/list/inner/ECSaasSearchRecyclerView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/search/common/list/inner/ECSaasSearchRecyclerView;", "getInnerRecyclerView", "()Lcom/ss/android/ugc/aweme/search/common/list/inner/ECSaasSearchRecyclerView;", "setInnerRecyclerView", "(Lcom/ss/android/ugc/aweme/search/common/list/inner/ECSaasSearchRecyclerView;)V", "innerRecyclerView", "Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonListAdapter;", "b", "Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonListAdapter;", "getInnerAdapter", "()Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonListAdapter;", "setInnerAdapter", "(Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonListAdapter;)V", "innerAdapter", "Lcom/ss/android/ugc/aweme/search/common/event/ECSearchUpdateListAdapterHelper;", ce.f26391f, "Lkotlin/Lazy;", "getUpdateListAdapterHelper", "()Lcom/ss/android/ugc/aweme/search/common/event/ECSearchUpdateListAdapterHelper;", "updateListAdapterHelper", "isECSearchSaaS", "Z", "()Z", "setECSearchSaaS", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ESSaasCommonList extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECSaasSearchRecyclerView f451638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ESSaasCommonListAdapter f451639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<SearchAggregateCommodity> f451640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, JsEventSubscriber> f451641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Fragment f451642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ILoadMoreFunction f451643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f451644g;

    public ESSaasCommonList(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ESSaasCommonList(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ECSearchUpdateListAdapterHelper getUpdateListAdapterHelper() {
        return (ECSearchUpdateListAdapterHelper) this.f451644g.getValue();
    }

    public final int getFirstVisibleItemPositions() {
        int[] r100 = new int[2];
        ECSaasSearchRecyclerView r101 = this.f451638a;
        RecyclerView.LayoutManager r102 = null;
        if (r101 == null) goto L5;
        RecyclerView.LayoutManager r103 = r101.getLayoutManager();
    L7:
        if ((r103 instanceof StaggeredGridLayoutManager) == false) goto L10;
        r102 = r103;
    L10:
        StaggeredGridLayoutManager r104 = (StaggeredGridLayoutManager) r102;
        if (r104 == null) goto L13;
        r104.findFirstVisibleItemPositions(r100);
    L13:
        Integer r105 = ArraysKt.minOrNull(r100);
        if (r105 != null) goto L18;
        return 0;
    L18:
        return r105.intValue();
    L5:
        r103 = null;
        goto L7
    }

    public final int getLastVisibleItemPositions() {
        int[] r100 = new int[2];
        ECSaasSearchRecyclerView r101 = this.f451638a;
        RecyclerView.LayoutManager r102 = null;
        if (r101 == null) goto L5;
        RecyclerView.LayoutManager r103 = r101.getLayoutManager();
    L7:
        if ((r103 instanceof StaggeredGridLayoutManager) == false) goto L10;
        r102 = r103;
    L10:
        StaggeredGridLayoutManager r104 = (StaggeredGridLayoutManager) r102;
        if (r104 == null) goto L13;
        r104.findLastVisibleItemPositions(r100);
    L13:
        Integer r105 = ArraysKt.maxOrNull(r100);
        if (r105 != null) goto L18;
        return 0;
    L18:
        return r105.intValue();
    L5:
        r103 = null;
        goto L7
    }

    public int getLayoutId() {
        return R.layout.ec_saas_search_common_list_layout;
    }

    public final void setECSearchSaaS(boolean r100) {
    }

    public final void d() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 == null) goto L12;
        r100.f451654u = true;
        AutoPlayConfig r101 = r100.f451658y;
        if (r101 == null) goto L9;
        RecyclerViewScrollStateManager r102 = r101.f452008a;
        if (r102 == null) goto L9;
        r102.f452010b.clear();
    L9:
        IECSaaSOptimize r103 = r100.f451659z;
        if (r103 == null) goto L12;
        r103.onDestroy();
    L12:
        ECSearchUpdateListAdapterHelper r104 = getUpdateListAdapterHelper();
        if (r104 == null) goto L22;
        ECSearchSafeEventBusWrapper.f451591b.getClass();
        Intrinsics.checkNotNullParameter(r104, "eventListener");
        Iterator r105 = ((List) ECSearchSafeEventBusWrapper.f451590a.getValue()).iterator();
    L16:
        if (r105.hasNext() == false) goto L22;
        WeakReference r106 = (WeakReference) r105.next();
        if (r104 == ((IECSearchSafeEventBusWrapper$EventListener) r106.get())) goto L21;
        if (r106.get() != null) goto L16;
    L21:
        r105.remove();
    L22:
        Iterator r107 = ((LinkedHashMap) this.f451641d).entrySet().iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        Map.Entry r108 = (Map.Entry) r107.next();
        EventCenter.unregisterJsEventSubscriber((String) r108.getKey(), (JsEventSubscriber) r108.getValue());
        goto L24
    }

    public final void e() {
        final ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 == null) goto L6;
        ThreadUtils r101 = ThreadUtils.f452277a;
        Runnable r102 = new ESSaasCommonListAdapter$onPause$1(r100);
        r101.getClass();
        ThreadUtils.b(r102);
        return;
    }

    public final void f() {
        final ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 == null) goto L5;
        ThreadUtils r101 = ThreadUtils.f452277a;
        Runnable r102 = new ESSaasCommonListAdapter$onResume$1(r100);
        r101.getClass();
        ThreadUtils.b(r102);
    L5:
        ECSearchUpdateListAdapterHelper r103 = getUpdateListAdapterHelper();
        if (r103 == null) goto L8;
        ECSearchSafeEventBusWrapper.f451591b.getClass();
        ECSearchSafeEventBusWrapper.a(r103);
    L8:
        Iterator r104 = ((LinkedHashMap) this.f451641d).entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        Map.Entry r105 = (Map.Entry) r104.next();
        EventCenter.unregisterJsEventSubscriber((String) r105.getKey(), (JsEventSubscriber) r105.getValue());
        EventCenter.registerJsEventSubscriber((String) r105.getKey(), (JsEventSubscriber) r105.getValue());
        goto L10
    }

    public final List<SearchAggregateCommodity> getItemList() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f451667k;
    }

    public final List<SearchAggregateCommodity> getItemListOfTopSection() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 == null) goto L8;
        TopSectionManager r101 = r100.f451657x;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getCommodityList();
    L8:
        return null;
    }

    public final SearchCommodityAdapterHelper getLynxViewTypeManager() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f451656w;
    }

    public final ITopSectionManager getTopSectionManager() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f451657x;
    }

    public final ECViewHolderParam getViewHolderParam() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.A;
    }

    public final void h() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 == null) goto L9;
        LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r101 = r100.f451675f;
        if (r101 == null) goto L7;
        int r102 = LoadMoreRecyclerViewAdapter.LoadMoreViewHolder.f451681c;
        DmtStatusView r103 = (DmtStatusView) r101.itemView;
        r103.c();
        r103.d();
    L7:
        r100.f451671b = -1;
        r100.f451674e = -1;
        return;
    }

    public final void k() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 == null) goto L9;
        LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r101 = r100.f451675f;
        if (r101 == null) goto L7;
        int r102 = LoadMoreRecyclerViewAdapter.LoadMoreViewHolder.f451681c;
        ((DmtStatusView) r101.itemView).e();
    L7:
        r100.f451671b = 1;
        return;
    }

    public final void l() {
        ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 == null) goto L11;
        LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r101 = r100.f451675f;
        if (r101 == null) goto L7;
        int r102 = LoadMoreRecyclerViewAdapter.LoadMoreViewHolder.f451681c;
        ((DmtStatusView) r101.itemView).g();
    L7:
        r100.f451671b = 0;
        if (r100.f451674e != (-1)) goto L12;
        r100.f451674e = System.currentTimeMillis();
        return;
    L12:
        return;
    }

    public final int getItemCount() {
        List<SearchAggregateCommodity> r100 = getItemList();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final List<SearchAggregateCommodity> getDeleteItemList() {
        return this.f451640c;
    }

    public final ESSaasCommonListAdapter getInnerAdapter() {
        return this.f451639b;
    }

    public final ECSaasSearchRecyclerView getInnerRecyclerView() {
        return this.f451638a;
    }

    public final RecyclerView getInnerView() {
        return this.f451638a;
    }

    public final ECSearchVHPreloadTask$VHProducer getVHProducer() {
        return this.f451639b;
    }

    public final void c(ESSaasCommonListConfig r110) {
        final ESSaasCommonListAdapter r100 = this.f451639b;
        if (r100 == null) goto L8;
        PreLoadMoreConfig r101 = r110.f451689b;
        if (r101 == null) goto L8;
        r100.f451655v = r101;
        r100.f451653t = new ECSearchLoadMoreTrigger(r101.f451691a, r100);
    L8:
        if (r100 == null) goto L21;
        TopSectionConfig r102 = r110.f451690c;
        if (r102 == null) goto L12;
        AppBarLayout r103 = r102.f451694b;
    L13:
        if (r103 == null) goto L21;
        if (r102 == null) goto L21;
        if (r102.f451693a != true) goto L21;
        TopSectionManager.Companion r104 = TopSectionManager.Companion;
        Fragment r105 = r100.G;
        r104.getClass();
        TopSectionManager r106 = TopSectionManager.Companion.a(r105);
        r100.f451657x = r106;
        if (r106 == null) goto L21;
        r106.initManager(r100.G, r100.H, true, r102.f451694b, new ESSaasCommonListAdapter$configTopSection$1(r100), new ESSaasCommonListAdapter$configTopSection$2(r100));
        goto L21
    L12:
        r103 = null;
    L21:
        ESSaasCommonListAdapter r107 = this.f451639b;
        if (r107 == null) goto L25;
        r107.f451658y = r110.f451688a;
        return;
    }

    public final void setInnerAdapter(ESSaasCommonListAdapter r100) {
        this.f451639b = r100;
    }

    public final void setInnerRecyclerView(ECSaasSearchRecyclerView r100) {
        this.f451638a = r100;
    }

    public final void setLoadMoreListener(final ILoadMoreFunction r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f451643f = r100;
        ESSaasCommonListAdapter r101 = this.f451639b;
        if (r101 == null) goto L6;
        r101.f451676g = new AnonymousClass1(r100);
        return;
    }

    public final void setShowFooter(boolean r100) {
        ESSaasCommonListAdapter r101 = this.f451639b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == r101.f451687a) goto L9;
        r101.f451687a = r100;
        r101.z2(r100);
        return;
    }

    public final void setUpViewHolderParam(ECViewHolderParam r100) {
        final ESSaasCommonListAdapter r101 = this.f451639b;
        if (r101 == null) goto L17;
        RecyclerViewScrollStateManager r102 = null;
        if (r100 == null) goto L14;
        r100.f451576a = r101.G;
        ECSearchParam r103 = r101.H;
        if (r103 == null) goto L9;
        String r104 = r103.getEnterFrom();
    L10:
        r100.f451581f = r104;
        AutoPlayConfig r105 = r101.f451658y;
        if (r105 == null) goto L13;
        r102 = r105.f452008a;
    L13:
        r100.f451579d = r102;
        r100.f451583h = new ESSaasCommonListAdapter$setUpViewHolderParam$$inlined$also$lambda$1(r101);
        Unit r106 = Unit.INSTANCE;
    L15:
        r101.A = r100;
        return;
    L9:
        r104 = null;
        goto L10
    L14:
        r100 = null;
        goto L15
    }

    public final void setVHLifecycleListener(IVHLifecycleListener r100) {
        ESSaasCommonListAdapter r101 = this.f451639b;
        if (r101 == null) goto L6;
        r101.f451652s = r100;
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static void b(ESSaasCommonList r100, List r101) {
        if (r101 == null) goto L43;
        ESSaasCommonListAdapter r102 = r100.f451639b;
        if (r102 == null) goto L39;
        List r103 = r101;
        if (CollectionUtils.isEmpty(r103) == true) goto L44;
        Collection r104 = r102.f451667k;
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        Logger.b("ESCommonList", "addLoadMoreItemList error: items null or empty");
        return;
    L19:
        List<T> r106 = r102.f451667k;
        String r107 = null;
        if (r106 == 0) goto L24;
        SearchAggregateCommodity r108 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r106, 0);
        if (r108 == null) goto L24;
        String r109 = r108.getCurrentSearchId();
    L25:
        SearchAggregateCommodity r110 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r101, 0);
        if (r110 == null) goto L29;
        r107 = r110.getCurrentSearchId();
    L29:
        if ((!Intrinsics.areEqual(r109, r107)) == false) goto L31;
        Logger.b("ESCommonList", "addLoadMoreItemList error: refresh searchId != loadMore searchId");
        return;
    L31:
        List<T> r111 = r102.f451667k;
        Intrinsics.checkNotNull(r101);
        r111.addAll(r103);
        int r112 = r101.size();
        if (r102.f451687a == false) goto L34;
        r102.notifyItemRangeInserted(r102.f451668l - 1, r112);
        r102.notifyItemChanged(r102.getItemCount() - 1);
    L35:
        IECSaaSOptimize r113 = r102.f451659z;
        if (r113 == null) goto L42;
        r113.i();
        return;
    L42:
        return;
    L34:
        r102.notifyItemRangeInserted(r102.f451668l, r112);
    L24:
        r109 = null;
        goto L25
    L12:
        if (r104.isEmpty() == true) goto L15;
        r105 = false;
        goto L17
    L44:
        return;
    L39:
        return;
    }

    public final void a(final int r100, SearchAggregateCommodity r101) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        final ESSaasCommonListAdapter r102 = this.f451639b;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getItemCount() <= r100) goto L14;
        if (r100 < 0) goto L15;
        List<T> r103 = r102.f451667k;
        if (r103 == 0) goto L11;
        ListProtector.add(r103, r100, r101);
    L11:
        post(new ESSaasCommonList$addCardByIndex$$inlined$let$lambda$1(r102, r100));
        return;
    L15:
        return;
    }

    public final void g(boolean r100, List r101) {
        ESSaasCommonListAdapter r102 = this.f451639b;
        if (r102 == null) goto L81;
        StringBuilder r103 = new StringBuilder("preBindData viewType = 22, useCachePosition = ");
        r103.append(r100);
        r103.append(" cacheViewPosition = ");
        Integer r104 = (Integer) ((LinkedHashMap) r102.E).get(22);
        int r105 = -1;
        if (r104 == null) goto L7;
        int r106 = r104.intValue();
    L8:
        r103.append(r106);
        Logger.a("ESCommonList", r103.toString());
        int r107 = 0;
        RecyclerView.ViewHolder r108 = null;
        Integer r109 = null;
        r108 = null;
        r108 = null;
        if (r100 == false) goto L39;
        Integer r110 = (Integer) ((LinkedHashMap) r102.E).get(22);
        if (r110 == null) goto L13;
        r105 = r110.intValue();
    L13:
        SearchAggregateCommodity r111 = r102.D2(r105);
        if (r105 < 0) goto L35;
        if (r111 == null) goto L17;
        Integer r112 = r111.getResultType();
    L18:
        if (r112 == null) goto L35;
        if (r112.intValue() != 22) goto L35;
        if (r101 == null) goto L27;
        SearchAggregateCommodity r113 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r101, 0);
        if (r113 == null) goto L27;
        Boolean r114 = r113.isPreBindData();
    L28:
        r111.setPreBindData(r114);
        if (r101 == null) goto L33;
        SearchAggregateCommodity r115 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r101, 0);
        if (r115 == null) goto L33;
        SelectInfo r116 = r115.getSelectInfo();
    L34:
        r111.setSelectInfo(r116);
        r107 = r105;
    L40:
        WeakReference r117 = (WeakReference) ((LinkedHashMap) r102.C).get(22);
        if (r117 == null) goto L43;
        RecyclerView.ViewHolder r118 = (RecyclerView.ViewHolder) r117.get();
    L44:
        if (r118 != null) goto L69;
        r102.B = true;
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) r102.F).get(22), Boolean.TRUE) == false) goto L54;
        WeakReference r119 = (WeakReference) ((LinkedHashMap) r102.C).get(22);
        if (r119 == null) goto L50;
        RecyclerView.ViewHolder r120 = (RecyclerView.ViewHolder) r119.get();
    L51:
        if (r120 == null) goto L54;
        Logger.b("ESCommonList", "produce type = 22, banPreCreateViewHolderMap = true, cacheViewHolder != null, just return null");
    L62:
        if (r108 == null) goto L68;
        Logger.a("ESCommonList", "put viewHolder(" + r108 + ") to recyclerview view pool");
        RecyclerView r121 = r102.I.getInnerView();
        if (r121 == null) goto L68;
        RecyclerView.RecycledViewPool r122 = r121.getRecycledViewPool();
        if (r122 == null) goto L68;
        r122.putRecycledView(r108);
    L68:
        r118 = r108;
        goto L69
    L50:
        r120 = null;
    L54:
        if (((ArrayList) r102.D).contains(22) == false) goto L57;
        r102.B = true;
    L57:
        if (r102.f451654u == true) goto L62;
        RecyclerView r123 = r102.I.getInnerView();
        if (r123 == null) goto L62;
        r108 = r102.createViewHolder(r123, 22);
    L69:
        r102.F.put(22, Boolean.TRUE);
        if (r118 == null) goto L83;
        if (r111 == null) goto L79;
        ESCommonListViewModel r124 = r102.E2();
        if (r124 == null) goto L79;
        Function3<ESCommonListViewModel, SearchAggregateCommodity, Integer, ItemMobParam> r125 = r124.getItemMobParamGetter();
        if (r125 == null) goto L79;
        ItemMobParam r126 = r125.invoke(r102.E2(), r111, Integer.valueOf(r107));
        if (r126 == null) goto L79;
        Logger.a("FilterMobShow", "preBindData businessParams itemMobParam = " + r126 + ", searchId = " + r126.f453302e + ", searchKeyword = " + r126.f453299b);
        ECSearchFilterViewModel.Companion r127 = ECSearchFilterViewModel.Companion;
        Fragment r128 = r102.G;
        r127.getClass();
        ECSearchFilterViewModel.Companion.a(r128).getBusinessParams().put(ItemMobParam.class, r126);
    L79:
        Logger.a("ESCommonList", "bindViewHolder position: " + r107 + " viewHolder = " + r118);
        r102.bindViewHolder(r118, r107);
        return;
    L83:
        return;
    L43:
        r118 = null;
    L33:
        r116 = null;
    L27:
        r114 = null;
        goto L28
    L17:
        r112 = null;
    L35:
        StringBuilder r129 = new StringBuilder("forceBindData return position: ");
        r129.append(r105);
        r129.append("， resultType: ");
        if (r111 == null) goto L38;
        r109 = r111.getResultType();
    L38:
        r129.append(r109);
        Logger.b("ESCommonList", r129.toString());
        return;
    L39:
        r111 = null;
        goto L40
    L7:
        r106 = -1;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(List<SearchAggregateCommodity> r110, boolean r111) {
        if (r110 != 0) goto L4;
        return;
    L4:
        if (r111 == false) goto L99;
        ((CopyOnWriteArrayList) this.f451640c).clear();
        ESSaasCommonListAdapter r112 = this.f451639b;
        if (r112 == null) goto L109;
        ECSearchLoadMoreTrigger r100 = r112.f451653t;
        if (r100 == null) goto L10;
        r100.f451880c = Integer.MIN_VALUE;
    L10:
        ESCommonListViewModel r101 = r112.E2();
        int r102 = 0;
        if (r101 == null) goto L13;
        r101.setExposureItemCount(0);
    L13:
        SearchAggregateCommodity r103 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r110, 0);
        if (r103 == null) goto L16;
        int r104 = r103.getResultFrom();
    L17:
        SearchAggregateCommodity r105 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r110, 0);
        if (r105 == null) goto L20;
        boolean r106 = r105.getHasSideBar();
    L21:
        Iterator r107 = r110.iterator();
        int r108 = 0;
    L23:
        if (r107.hasNext() == false) goto L34;
        Integer r109 = ((SearchAggregateCommodity) r107.next()).getResultType();
        if (r109 != null) goto L28;
    L30:
        boolean r113 = false;
    L31:
        if (r113 == true) goto L35;
        r108 = r108 + 1;
    L35:
        if (r108 < 0) goto L45;
        int r114 = r108 - 1;
        if (r114 < 0) goto L45;
        int r115 = 0;
    L39:
        SearchAggregateCommodity r116 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r110, r115);
        if (r116 == null) goto L42;
        r116.setSectionId(FeedSection.SECTION_TOP);
    L42:
        if (r115 == r114) goto L45;
        r115 = r115 + 1;
    L45:
        if (r112.f451657x != null) goto L47;
        r112.f451667k = r110;
        r112.notifyDataSetChanged();
        return;
    L47:
        if (r108 < 0) goto L80;
        long r117 = System.currentTimeMillis();
        ArrayList r118 = new ArrayList();
        ArrayList r119 = new ArrayList();
        Iterator r120 = r110.iterator();
    L50:
        if (r120.hasNext() == false) goto L62;
        Object r121 = r120.next();
        int r122 = r102 + 1;
        if (r102 >= 0) goto L54;
        CollectionsKt.throwIndexOverflow();
    L54:
        SearchAggregateCommodity r123 = (SearchAggregateCommodity) r121;
        if (r102 > r108) goto L57;
    L60:
        r119.add(r123);
    L61:
        r102 = r122;
        goto L50
    L57:
        if (MarketBannerApiKt.b(r123) == true) goto L60;
        r118.add(r123);
        goto L61
    L62:
        SearchAggregateCommodity r124 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r110, r108);
        if (r124 == null) goto L71;
        ESCommonListViewModel r125 = r112.E2();
        if (r125 == null) goto L71;
        Function3<ESCommonListViewModel, SearchAggregateCommodity, Integer, ItemMobParam> r126 = r125.getItemMobParamGetter();
        if (r126 == null) goto L71;
        ItemMobParam r127 = r126.invoke(r112.E2(), r124, Integer.valueOf(r108));
        if (r127 == null) goto L71;
        Logger.a("FilterMobShow", "setData businessParams itemMobParam = " + r127 + ", searchId = " + r127.f453302e + ", searchKeyword = " + r127.f453299b);
        ECSearchFilterViewModel.Companion r128 = ECSearchFilterViewModel.Companion;
        Fragment r129 = r112.G;
        r128.getClass();
        ECSearchFilterViewModel.Companion.a(r129).getBusinessParams().put(ItemMobParam.class, r127);
    L71:
        TopSectionManager r130 = r112.f451657x;
        if (r130 == null) goto L78;
        ESCommonListViewModel r131 = r112.E2();
        if (r131 == null) goto L76;
        Function3<ESCommonListViewModel, SearchAggregateCommodity, Integer, ECSearchMobParam> r132 = r131.getEcSearchMobParamGetter();
    L77:
        r130.setTopSectionData(r119, null, r132, r112.A);
        goto L78
    L76:
        r132 = null;
    L78:
        Logger.a("TopSectionManager", "start list adapter setData, top section cost = " + (System.currentTimeMillis() - r117));
        r112.f451667k = r118;
        r112.notifyDataSetChanged();
        return;
    L80:
        if (r112.f451649p == false) goto L84;
        Logger.a("AIChatDebug", "isECSearchSaaS just clearTopSectionView");
        TopSectionManager r133 = r112.f451657x;
        if (r133 == null) goto L97;
        r133.clearTopSectionView();
    L97:
        r112.f451667k = r110;
        r112.notifyDataSetChanged();
        return;
    L84:
        if (r104 != 1) goto L94;
        Logger.a("TopSectionManager", "refresh response has no filter data, clear head view, result FROM_COMMODITY_SELECTS " + r106);
        TopSectionManager r134 = r112.f451657x;
        if (r134 == null) goto L88;
        r134.clearHeadCardView();
    L88:
        TopSectionManager r135 = r112.f451657x;
        if (r135 == null) goto L91;
        r135.clearBannerView();
    L91:
        TopSectionManager r136 = r112.f451657x;
        if (r136 == null) goto L97;
        r136.updateGoodFilterBoardView(r106);
        goto L97
    L94:
        Logger.a("TopSectionManager", "refresh response has no filter data, clear top section, result FROM_NORMAL");
        TopSectionManager r137 = r112.f451657x;
        if (r137 == null) goto L97;
        r137.clearTopSectionView();
        goto L97
    L28:
        if (r109.intValue() != 22) goto L30;
        r113 = true;
        goto L31
    L34:
        r108 = -1;
        goto L35
    L20:
        r106 = false;
        goto L21
    L16:
        r104 = 0;
        goto L17
    L109:
        return;
    L99:
        ESSaasCommonListAdapter r138 = this.f451639b;
        if (r138 == null) goto L113;
        r138.f451667k = r110;
        return;
    }

    public final void j(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        ESSaasCommonListAdapter r102 = this.f451639b;
        if (r102 == null) goto L20;
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        if ((!Intrinsics.areEqual(r102.f451651r, r100)) == false) goto L9;
        r102.f451651r = r100;
        if (r101 == false) goto L9;
        r102.notifyDataSetChanged();
    L9:
        PreLoadMoreConfig r103 = r102.f451655v;
        if (r103 == null) goto L21;
        Function1<String, Integer> r104 = r103.f451692b;
        if (r104 == null) goto L22;
        ECSearchLoadMoreTrigger r105 = r102.f451653t;
        if (r105 == null) goto L23;
        int r106 = r104.invoke(r100).intValue();
        Logger.a("LoadMoreDebug", "updateRemainCountTriggerLoadMore currentSpanCount = " + r105.f451879b + ", spanCount = " + r106);
        if (r105.f451879b == r106) goto L24;
        r105.f451879b = r106;
        r105.f451878a = r106 * 2;
        Logger.a("LoadMoreDebug", "updateRemainCountTriggerLoadMore ifRemainsReal = " + r105.f451878a + ", spanCount = " + r106 + ", ifRemains = 2");
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public ESSaasCommonList(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f451640c = new CopyOnWriteArrayList();
        this.f451641d = new LinkedHashMap();
        this.f451644g = LazyKt.lazy(new ESSaasCommonList$updateListAdapterHelper$2(this));
        LayoutInflater.from(r100).inflate(getLayoutId(), this, true);
        this.f451638a = (ECSaasSearchRecyclerView) findViewById(R.id.common_search_inner_recyclerview);
    }

    public /* synthetic */ ESSaasCommonList(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
