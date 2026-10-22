package com.bytedance.ee.bear.bitable.homepage.chart.add;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.homepage.chart.ChartConfig;
import com.bytedance.ee.bear.bitable.homepage.chart.ChartType;
import com.bytedance.ee.bear.bitable.homepage.chart.container.JSContextTag;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView;
import com.bytedance.ee.bear.bitable.utils.AdapterOpsObserver;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 W2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0006WXYZ[\\B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cH\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020)H\u0016J\u0018\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020)H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u000eH\u0016J\u0016\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020&J\u0014\u00105\u001a\u00020&2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001106J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020\u000eH\u0016J\u0010\u00109\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0018\u0010=\u001a\u00020<2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000eH\u0016J\u0018\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000eH\u0016J \u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0016J0\u0010C\u001a\u00020&2\b\u0010D\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0010H\u0016J\u0018\u0010G\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000eH\u0016J\u0018\u0010H\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000eH\u0002J\u0018\u0010I\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000eH\u0002J\u0018\u0010J\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000eH\u0016J(\u0010K\u001a\u00020&2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0016J,\u0010L\u001a\u00020&2\n\u0010D\u001a\u00060MR\u00020\u00002\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0002J\u0010\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020PH\u0002J\u001c\u0010Q\u001a\u00020&2\n\u0010D\u001a\u00060MR\u00020\u00002\u0006\u0010R\u001a\u00020.H\u0002J6\u0010K\u001a\u00020&2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0010H\u0016J2\u0010S\u001a\u00020)2\b\u0010D\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020)H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u0019j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001f\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0!0 j\u0002`\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006]"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter;", "Lcom/h6ah4i/android/widget/advrecyclerview/utils/AbstractExpandableItemAdapter;", "Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter$DashboardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartEntityProvider;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "expandableManager", "Lcom/h6ah4i/android/widget/advrecyclerview/expandable/RecyclerViewExpandableItemManager;", "selectChartViewModel", "Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartViewModel;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/h6ah4i/android/widget/advrecyclerview/expandable/RecyclerViewExpandableItemManager;Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartViewModel;)V", "maxAddedChartCountLimit", "", "dashboards", "", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageAddDashboard;", "stableIdStorage", "Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter$StableIdStorage;", "chartIndexInfoCache", "", "", "Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter$ChartIndexInfo;", "groupFlatPositionCache", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "boundRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "previousToast", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "headerPositionProvider", "Lkotlin/Function0;", "", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/stickyheader/HeaderPositionProvider;", "getHeaderPositionProvider", "()Lkotlin/jvm/functions/Function0;", "onAttachedToRecyclerView", "", "recyclerView", "onHookGroupCollapse", "", "groupPosition", "fromUser", "onHookGroupExpand", "getChartEntity", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/ChartEntity;", "position", "updateChartData", "chartToken", "chartData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageChartData;", "onSelectedChartChanged", "updateDashboards", "", "rebuildIndexCache", "getGroupCount", "isDashboardEmpty", "getChildCount", "getGroupId", "", "getChildId", "childPosition", "onCreateGroupViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindGroupViewHolder", "holder", "payloads", "", "onCreateChildViewHolder", "createEmptyChildViewHolder", "createChartViewHolder", "getChildItemViewType", "onBindChildViewHolder", "bindChartViewHolder", "Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter$ChartViewHolder;", "showAddCountLimitToast", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindChartSelectState", "chart", "onCheckCanExpandOrCollapseGroup", "x", "y", BitableAnalytic.LinkSceneClickType.EXPAND, "Companion", "ChartIndexInfo", "StableIdStorage", "DashboardViewHolder", "EmptyChildViewHolder", "ChartViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectChartAdapter extends AbstractExpandableItemAdapter<DashboardViewHolder, RecyclerView.ViewHolder> implements com.bytedance.ee.bear.bitable.homepage.chart.k {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f212356l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f212357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerViewExpandableItemManager f212358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SelectChartViewModel f212359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f212360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<rs4.b> f212361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f212362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, a> f212363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap<String, Integer> f212364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f212365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larksuite.component.universe_design.toast.c f212366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f212367k;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter$ChartViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTitle", "()Landroid/widget/TextView;", "checkStatus", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckStatus", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "chartItem", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "getChartItem", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ChartViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f212368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UDCheckBox f212369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ChartItemView f212370c;

        public ChartViewHolder(SelectChartAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            super(r101);
            this.f212368a = (TextView) r101.findViewById(R.id.hp_chart_title);
            this.f212369b = (UDCheckBox) r101.findViewById(R.id.hp_chart_check_status);
            ChartItemView r102 = (ChartItemView) r101.findViewById(R.id.hp_chart_item);
            this.f212370c = r102;
            r102.getHpChartLynxContainerFromXml().setEnableDispatchTouchEvent(false);
            ChartItemView.MeasureHeightStrategy r103 = ChartItemView.MeasureHeightStrategy.BY_CHART_TYPE;
            Intrinsics.checkNotNullParameter(r103, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            if (r102.f212659i == r103) goto L6;
            r102.f212659i = r103;
            r102.requestLayout();
        L6:
            r102.f(r100.f212357a);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter$DashboardViewHolder;", "Lcom/h6ah4i/android/widget/advrecyclerview/utils/AbstractExpandableItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTitle", "()Landroid/widget/TextView;", "expandedStatus", "getExpandedStatus", "()Landroid/view/View;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DashboardViewHolder extends AbstractExpandableItemViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f212371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f212372c;

        public DashboardViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f212371b = (TextView) r100.findViewById(R.id.hp_dashboard_title);
            this.f212372c = r100.findViewById(R.id.hp_dashboard_expand_status);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectChartAdapter$EmptyChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EmptyChildViewHolder extends RecyclerView.ViewHolder {
        public EmptyChildViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rs4.b f212373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f212374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ChartEntity f212375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f212376d;

        public a(rs4.b r100, int r101, ChartEntity r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "dashboard");
            Intrinsics.checkNotNullParameter(r102, "chart");
            this.f212373a = r100;
            this.f212374b = r101;
            this.f212375c = r102;
            this.f212376d = r103;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Long> f212377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f212378b;

        public c() {
            this.f212377a = new LinkedHashMap();
        }

        public final long a(String r100) {
            Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
            LinkedHashMap r101 = (LinkedHashMap) this.f212377a;
            Object r102 = r101.get(r100);
            if (r102 != null) goto L6;
            long r103 = this.f212378b;
            this.f212378b = 1 + r103;
            r102 = Long.valueOf(r103);
            r101.put(r100, r102);
        L6:
            return ((Number) r102).longValue();
        }
    }

    public static final class d implements Function0<Collection<? extends Integer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectChartAdapter f212379a;

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends Integer> invoke() {
            return this.f212379a.f212364h.values();
        }

        public d(SelectChartAdapter r100) {
            this.f212379a = r100;
        }
    }

    static {
    }

    public final void B2() {
        ((LinkedHashMap) this.f212363g).clear();
        Iterator r100 = ((ArrayList) this.f212361e).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L19;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        rs4.b r104 = (rs4.b) r102;
        Iterator<T> r105 = r104.a().iterator();
        int r106 = 0;
    L10:
        if (r105.hasNext() == false) goto L18;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        ChartEntity r109 = (ChartEntity) r107;
        Map<String, a> r110 = this.f212363g;
        String r111 = r109.getChartToken();
        if (r111 != null) goto L17;
        r111 = "";
    L17:
        r110.put(r111, new a(r104, r101, r109, r106));
        r106 = r108;
        goto L10
    L18:
        r101 = r103;
        goto L4
    L19:
        this.f212364h.clear();
        Iterator r112 = ((ArrayList) this.f212361e).iterator();
        int r113 = 0;
        int r114 = 0;
    L21:
        if (r112.hasNext() == false) goto L34;
        Object r115 = r112.next();
        int r116 = r113 + 1;
        if (r113 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        rs4.b r117 = (rs4.b) r115;
        int r118 = r113 + r114;
        aw7.f r119 = this.f212358b.f276038c;
        if (r119 != null) goto L28;
    L30:
        boolean r120 = false;
    L31:
        if (r120 == false) goto L33;
        r114 = r114 + this.f212358b.f276038c.f16584c.i1(r113);
    L33:
        Integer r121 = Integer.valueOf(r118);
        this.f212364h.put(r117.c(), r121);
        r113 = r116;
        goto L21
    L28:
        if (r119.f16586e.f(r113) == false) goto L30;
        r120 = true;
        goto L31
    }

    @Override // aw7.c
    public final int getGroupCount() {
        return ((ArrayList) this.f212361e).size();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter
    public final void y2() {
        RecyclerView r100 = this.f212365i;
        if (r100 == null) goto L6;
        r100.requestLayout();
        return;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter
    public final void z2() {
        RecyclerView r100 = this.f212365i;
        if (r100 == null) goto L6;
        r100.requestLayout();
        return;
    }

    @Override // aw7.c
    public final RecyclerView.ViewHolder B(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_homepage_dashboard_item, r100, false);
        Intrinsics.checkNotNull(r101);
        return new DashboardViewHolder(r101);
    }

    @Override // aw7.c
    public final long getGroupId(int r100) {
        return this.f212362f.a(((rs4.b) ListProtector.get(this.f212361e, r100)).c());
    }

    @Override // aw7.c
    public final int i1(int r100) {
        int r101 = ((rs4.b) ListProtector.get(this.f212361e, r100)).a().size();
        if (r101 != 0) goto L6;
        return 1;
    L6:
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f212365i = r100;
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L7;
        AdapterOpsObserver.Op.Companion.getClass();
        r101.registerAdapterDataObserver(new AdapterOpsObserver(AdapterOpsObserver.Op.access$getIndexChangedOps$cp(), new AnonymousClass1(this)));
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // aw7.c
    public final /* bridge */ /* synthetic */ void v2(RecyclerView.ViewHolder r100) {
        DashboardViewHolder r101 = (DashboardViewHolder) r100;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.k
    public final ChartEntity x2(int r100) {
        aw7.f r101 = this.f212358b.f276038c;
        if (r101 != null) goto L5;
        long r102 = -1;
    L6:
        int r103 = aw7.b.b(r102);
        int r104 = (int) (r102 >>> 32);
        rs4.b r105 = (rs4.b) CollectionsKt.getOrNull(this.f212361e, r103);
        if (r105 == null) goto L11;
        List<ChartEntity> r106 = r105.a();
        if (r106 == null) goto L11;
        return (ChartEntity) CollectionsKt.getOrNull(r106, r104);
    L11:
        return null;
    L5:
        r102 = r101.f16586e.d(r100);
        goto L6
    }

    public final void A2(ChartViewHolder r100, ChartEntity r101) {
        SelectChartViewModel r102 = this.f212359c;
        boolean r103 = true;
        r100.itemView.setEnabled(!r102.isChartSelectedInInitial(r101));
        if (r102.isChartSelectedInInitial(r101) == false) goto L6;
    L10:
        boolean r104 = false;
    L12:
        r100.f212369b.setEnabled(r104);
        UDCheckBox r105 = r100.f212369b;
        if (r102.isChartSelectedInInitial(r101) == false) goto L15;
    L18:
        r105.setChecked(r103);
        return;
    L15:
        if (r102.isChartSelectedInAdditional(r101) == true) goto L18;
        r103 = false;
        goto L18
    L6:
        if (r102.canSelectMore() == false) goto L8;
    L11:
        r104 = true;
        goto L12
    L8:
        if (r102.isChartSelectedInAdditional(r101) == false) goto L10;
        goto L10
    }

    @Override // aw7.c
    public final RecyclerView.ViewHolder N(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 1) goto L5;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_homepage_add_chart_dashboard_empty, r100, false);
        Intrinsics.checkNotNull(r102);
        return new EmptyChildViewHolder(r102);
    L5:
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_homepage_add_chart_item, r100, false);
        Intrinsics.checkNotNull(r103);
        return new ChartViewHolder(this, r103);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter, aw7.c
    public final int P(int r100, int r101) {
        if (((rs4.b) ListProtector.get(this.f212361e, r100)).a().isEmpty() == false) goto L7;
        return 1;
    L7:
        if (((ChartEntity) ListProtector.get(((rs4.b) ListProtector.get(this.f212361e, r100)).a(), r101)).getChartTypeEnum() != ChartType.STATISTICS) goto L9;
        return 2;
    L9:
        return 3;
    }

    @Override // aw7.c
    public final long getChildId(int r100, int r101) {
        if (((rs4.b) ListProtector.get(this.f212361e, r100)).a().isEmpty() == false) goto L5;
        String r102 = String.valueOf(((rs4.b) ListProtector.get(this.f212361e, r100)).hashCode());
    L10:
        return this.f212362f.a(r102);
    L5:
        ChartEntity r103 = (ChartEntity) ListProtector.get(((rs4.b) ListProtector.get(this.f212361e, r100)).a(), r101);
        String r104 = r103.getChartToken();
        if (r104 != null) goto L8;
        r102 = String.valueOf(r103.hashCode());
        goto L10
    L8:
        r102 = r104;
        goto L10
    }

    @Override // aw7.c
    public final void p0(RecyclerView.ViewHolder r100, int r101) {
        DashboardViewHolder r102 = (DashboardViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        aw7.f r103 = this.f212358b.f276038c;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        r102.f212372c.setSelected(r104);
        r102.f212371b.setText(((rs4.b) ListProtector.get(this.f212361e, r101)).b());
        return;
    L5:
        if (r103.f16586e.f(r101) == false) goto L7;
        r104 = true;
        goto L8
    }

    public SelectChartAdapter(LifecycleOwner r100, RecyclerViewExpandableItemManager r101, SelectChartViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "expandableManager");
        Intrinsics.checkNotNullParameter(r102, "selectChartViewModel");
        this.f212357a = r100;
        this.f212358b = r101;
        this.f212359c = r102;
        ChartConfig r103 = (ChartConfig) SettingManager.getInstance().get(ChartConfig.class);
        if (r103 != null) goto L5;
        r103 = new ChartConfig();
    L5:
        this.f212360d = r103.b();
        this.f212361e = new ArrayList();
        this.f212362f = new c();
        this.f212363g = new LinkedHashMap();
        this.f212364h = new LinkedHashMap();
        this.f212367k = new d(this);
        setHasStableIds(true);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter, aw7.c
    public final void a1(RecyclerView.ViewHolder r100, int r101, int r102, List r103) {
        DashboardViewHolder r104 = (DashboardViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "payloads");
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(r106, 2) == true) goto L16;
        if (Intrinsics.areEqual(r106, 1) == false) goto L4;
        return;
    L16:
        return;
    L10:
        p0(r104, r101);
    }

    @Override // aw7.c
    public final void d1(RecyclerView.ViewHolder r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (r103 == 1) goto L8;
        ChartViewHolder r104 = (ChartViewHolder) r100;
        final ChartEntity r105 = (ChartEntity) ListProtector.get(((rs4.b) ListProtector.get(this.f212361e, r101)).a(), r102);
        r104.f212368a.setText(r105.getChartName());
        h r106 = new h(this, r105, r104);
        r104.itemView.setOnClickListener(r106);
        r104.f212369b.setOnClickListener(r106);
        A2(r104, r105);
        r104.f212370c.h(r105, r105.getChartData(), "add");
        r104.f212370c.setTagForJsContext(JSContextTag.TAG_FOR_JS_CONTEXT_ADD);
        r104.f212370c.j(r105.getChartTypeEnum());
        ChartItemView r107 = r104.f212370c;
        Function1<View, Boolean> r108 = new SelectChartAdapter$bindChartViewHolder$1(r105, this);
        UDButton r109 = r107.f212662l;
        if (r109 == null) goto L9;
        r109.setOnClickListener(new com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.a(r108, r107));
        return;
    L9:
        return;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter, aw7.c
    public final void f1(RecyclerView.ViewHolder r100, int r101, int r102, int r103, List<Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r104, "payloads");
        if (r104.isEmpty() == false) goto L6;
        d1(r100, r101, r102, r103);
        return;
    L6:
        ChartEntity r105 = (ChartEntity) CollectionsKt.getOrNull(((rs4.b) ListProtector.get(this.f212361e, r101)).a(), r102);
        if (r105 != null) goto L11;
        tt5.a.d("SelectChartAdapter", "chart not found: groupPosition=" + r101 + ", childPosition=" + r102 + ", chartSize=" + ((rs4.b) ListProtector.get(this.f212361e, r101)).a().size());
        return;
    L11:
        if ((r100 instanceof ChartViewHolder) == false) goto L13;
        ChartViewHolder r106 = (ChartViewHolder) r100;
    L14:
        if (r106 != null) goto L17;
        tt5.a.d("SelectChartAdapter", "holder should be ChartViewHolder, but is " + r100.getClass());
        return;
    L17:
        Iterator<T> r107 = r104.iterator();
    L19:
        if (r107.hasNext() == false) goto L27;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(r108, 2) == true) goto L22;
        if (Intrinsics.areEqual(r108, 1) == true) goto L25;
        tt5.a.k("SelectChartAdapter", "unknown payload: " + r108);
        goto L19
    L25:
        ((ChartViewHolder) r100).f212370c.h(r105, r105.getChartData(), "add");
        goto L19
    L22:
        A2((ChartViewHolder) r100, r105);
        goto L19
    L27:
        return;
    L13:
        r106 = null;
        goto L14
    }
}
