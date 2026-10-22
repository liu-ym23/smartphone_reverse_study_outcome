package com.larus.extension.aggregate_search_ui.impl.component.kmp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryItem;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryList;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryPayload;
import com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchEventTrackerAbility;
import com.larus.extension.aggregate_search_ui.impl.component.list.kmp.KmpSearchResultFlowListAdapter;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.y6;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0016J\b\u00107\u001a\u000203H\u0002J\u0012\u00108\u001a\b\u0012\u0004\u0012\u0002090+*\u00020:H\u0002J,\u0010;\u001a\u0002032\f\u0010<\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002090+2\u0006\u0010>\u001a\u00020)H\u0002J\u0016\u0010?\u001a\u00020)2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002090+H\u0002J\u0016\u0010A\u001a\u00020)2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002090+H\u0002J$\u0010B\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002090+2\u0006\u0010D\u001a\u00020EH\u0002J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u0002090+2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002090+H\u0002J\u0018\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u0002092\u0006\u0010I\u001a\u000209H\u0002J\u0010\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020\u0005H\u0002J\u0010\u0010L\u001a\u00020)2\u0006\u0010K\u001a\u00020\u0005H\u0002J \u0010M\u001a\u00020)2\b\u0010N\u001a\u0004\u0018\u0001062\f\u0010C\u001a\b\u0012\u0004\u0012\u0002090+H\u0002J \u0010O\u001a\u0002032\f\u0010C\u001a\b\u0012\u0004\u0012\u0002090+2\b\u0010P\u001a\u0004\u0018\u000106H\u0002J\u0018\u0010Q\u001a\u0002032\u0006\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020EH\u0002J\u0010\u0010T\u001a\u00020E2\u0006\u0010N\u001a\u000206H\u0002J\u0010\u0010U\u001a\u0002032\u0006\u0010V\u001a\u00020EH\u0002J\u0012\u0010W\u001a\u0004\u0018\u00010E2\u0006\u0010X\u001a\u00020YH\u0002J\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0+H\u0002J\b\u0010\\\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b!\u0010\"R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/kmp/KmpAggregateSearchResultListFeature;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "searchAbility", "Lcom/bytedance/flow/search/kmp/api/IAggregateSearchAbility;", "getSearchAbility", "()Lcom/bytedance/flow/search/kmp/api/IAggregateSearchAbility;", "searchAbility$delegate", "Lkotlin/Lazy;", "searchImeAbility", "Lcom/larus/extension/aggregate_search_ui/impl/component/ISearchImeAbility;", "getSearchImeAbility", "()Lcom/larus/extension/aggregate_search_ui/impl/component/ISearchImeAbility;", "searchImeAbility$delegate", "searchFilterPanelAbility", "Lcom/larus/extension/aggregate_search_ui/impl/component/kmp/KmpISearchFilterPanelAbility;", "getSearchFilterPanelAbility", "()Lcom/larus/extension/aggregate_search_ui/impl/component/kmp/KmpISearchFilterPanelAbility;", "searchFilterPanelAbility$delegate", "searchDisplayConfigAbility", "Lcom/larus/extension/aggregate_search_ui/impl/component/ISearchDisplayConfigAbility;", "getSearchDisplayConfigAbility", "()Lcom/larus/extension/aggregate_search_ui/impl/component/ISearchDisplayConfigAbility;", "searchDisplayConfigAbility$delegate", "trackerAbility", "Lcom/larus/extension/aggregate_search_ui/api/kmp/KmpISearchEventTrackerAbility;", "getTrackerAbility", "()Lcom/larus/extension/aggregate_search_ui/api/kmp/KmpISearchEventTrackerAbility;", "trackerAbility$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "resultBackgroundView", "Landroid/view/View;", "lastHadContent", "", "pendingCellStates", "", "Lcom/larus/list/arch/IFlowListCellState;", "pendingScrollToTop", "debounceJob", "Lkotlinx/coroutines/Job;", "resultAdapter", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/kmp/KmpSearchResultFlowListAdapter;", "onViewCreated", "", "view", "lastQuery", "Lcom/bytedance/flow/search/kmp/api/model/FlowQuery;", "observeSearchState", "flattenResultModulesInOrder", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "Lcom/bytedance/flow/search/kmp/api/store/FlowSearchState;", "handleCellStatesUpdate", "cellStates", "flatItems", "queryChanged", "isNoRealContent", "items", "isOnlySkeletonPayload", "buildCellStates", "resultItems", "keyword", "", "decorateItemDividers", "shouldInsertItemDivider", "prev", "curr", "isRecentConversationPayload", "type", "isContentPayload", "hasAggregateContent", "query", "syncFilterPanel", "currentQuery", "openDetailByText", "title", "detail", "buildQueryDetail", "handleFooterClick", "domain", "resolveShowReason", WsConstants.KEY_PAYLOAD, "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "resolveHistoryItems", "Lcom/bytedance/flow/search/kmp/api/model/payload/SearchHistoryItem;", "resolveHistoryCount", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpAggregateSearchResultListFeature extends BaseContentWidget {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f342511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f342512n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f342513o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f342514p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f342515q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f342516r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f342517s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f342518t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f342519u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<? extends ei9.f> f342520v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f342521w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Job f342522x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final KmpSearchResultFlowListAdapter f342523y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FlowQuery f342524z;

    public static final class a {
    }

    public static final class b implements Function0<uv5.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f342525a;

        public b(AttachReceiver r100) {
            this.f342525a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, uv5.a] */
        @Override // kotlin.jvm.functions.Function0
        public final uv5.a invoke() {
            AttachReceiver r100 = this.f342525a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(uv5.a.class));
        }
    }

    public static final class c implements Function0<f99.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f342526a;

        public c(AttachReceiver r100) {
            this.f342526a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [f99.b, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final f99.b invoke() {
            AttachReceiver r100 = this.f342526a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(f99.b.class));
        }
    }

    public static final class d implements Function0<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f342527a;

        public d(AttachReceiver r100) {
            this.f342527a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.extension.aggregate_search_ui.impl.component.kmp.m, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final m invoke() {
            AttachReceiver r100 = this.f342527a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(m.class));
        }
    }

    public static final class e implements Function0<f99.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f342528a;

        public e(AttachReceiver r100) {
            this.f342528a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [f99.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final f99.a invoke() {
            AttachReceiver r100 = this.f342528a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(f99.a.class));
        }
    }

    public static final class f implements Function0<KmpISearchEventTrackerAbility> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f342529a;

        public f(AttachReceiver r100) {
            this.f342529a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchEventTrackerAbility, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final KmpISearchEventTrackerAbility invoke() {
            AttachReceiver r100 = this.f342529a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(KmpISearchEventTrackerAbility.class));
        }
    }

    static {
    }

    public static boolean p3(int r100) {
        if (r100 != 104) goto L5;
    L27:
        return false;
    L5:
        if (r100 == 113) goto L27;
        if (r100 == 108) goto L27;
        if (r100 == 109) goto L27;
        if (r100 == 110) goto L27;
        if (r100 == 111) goto L27;
        if (r100 == 112) goto L27;
        if (r100 == 100) goto L27;
        if (r100 == 101) goto L27;
        if (r100 == 106) goto L27;
        if (r100 == 105) goto L27;
        if (r100 == 107) goto L27;
        return true;
    }

    public static boolean z3(int r100) {
        if (r100 != 103) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 119) goto L8;
        return false;
    }

    public final uv5.a h3() {
        return (uv5.a) this.f342512n.getValue();
    }

    public final KmpISearchEventTrackerAbility m3() {
        return (KmpISearchEventTrackerAbility) this.f342516r.getValue();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.extension.aggregate_search_ui.impl.component.kmp.KmpAggregateSearchResultListFeature$resultAdapter$1] */
    public KmpAggregateSearchResultListFeature() {
        this.f342511m = R.id.search_result_list;
        this.f342512n = LazyKt.lazy(new b(this));
        this.f342513o = LazyKt.lazy(new c(this));
        this.f342514p = LazyKt.lazy(new d(this));
        this.f342515q = LazyKt.lazy(new e(this));
        this.f342516r = LazyKt.lazy(new f(this));
        this.f342523y = new KmpSearchResultFlowListAdapter(new KmpAggregateSearchResultListFeature$resultAdapter$1(this));
    }

    public final List<SearchHistoryItem> B3() {
        uv5.a r100 = h3();
        List<SearchHistoryItem> r101 = null;
        if (r100 == null) goto L27;
        StateFlowImpl r102 = r100.state();
        if (r102 == null) goto L27;
        aw5.c r103 = (aw5.c) r102.getValue();
        if (r103 == null) goto L27;
        Map<String, List<FlowSearchData>> r104 = r103.f16542b;
        if (r104 == null) goto L27;
        Collection<List<FlowSearchData>> r105 = r104.values();
        if (r105 == null) goto L27;
        List r106 = CollectionsKt.flatten(r105);
        if (r106 == null) goto L27;
        Iterator r107 = r106.iterator();
    L16:
        if (r107.hasNext() == false) goto L23;
        Object r108 = r107.next();
        if (((FlowSearchData) r108).f243280b != 101) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L16;
    L24:
        FlowSearchData r110 = (FlowSearchData) r108;
        if (r110 == null) goto L27;
        ISearchDataPayload r111 = r110.f243281c;
    L29:
        if ((r111 instanceof SearchHistoryPayload) == false) goto L31;
        SearchHistoryPayload r112 = (SearchHistoryPayload) r111;
    L32:
        if (r112 == null) goto L36;
        SearchHistoryList r113 = r112.f243495i;
        if (r113 == null) goto L36;
        r101 = r113.f243492a;
    L36:
        if (r101 == null) goto L38;
        return r101;
    L38:
        return CollectionsKt.emptyList();
    L31:
        r112 = null;
        goto L32
    L20:
        r109 = false;
        goto L21
    L23:
        r108 = null;
    L27:
        r111 = null;
        goto L29
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f342511m;
    }

    public static final int Y2(KmpAggregateSearchResultListFeature r100) {
        return r100.B3().size();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f342511m = r100;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 != null) goto L8;
    L12:
        if (r101 == null) goto L14;
        r100 = r101;
    L14:
        View r102 = r100;
    L15:
        this.f342517s = (RecyclerView) r102.findViewById(R.id.search_result_recycler);
        this.f342518t = r102.findViewById(R.id.search_result_background);
        RecyclerView r103 = this.f342517s;
        if (r103 == null) goto L18;
        r103.setLayoutManager(new LinearLayoutManager(r102.getContext()));
    L18:
        RecyclerView r104 = this.f342517s;
        if (r104 == null) goto L21;
        r104.setAdapter(this.f342523y);
    L21:
        RecyclerView r105 = this.f342517s;
        if (r105 == null) goto L24;
        y6.f(r105, new g(this), null, 0.0f, new h(this), 29);
    L24:
        RecyclerView r106 = this.f342517s;
        if (r106 == null) goto L27;
        r106.addOnScrollListener(new AnonymousClass3(this));
    L27:
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new KmpAggregateSearchResultListFeature$observeSearchState$1(this, null), 3, null);
        return;
    L8:
        if (r101.getChildCount() <= 0) goto L10;
        r102 = r101.getChildAt(0);
    L11:
        if (r102 != null) goto L15;
    L10:
        r102 = LayoutInflater.from(r101.getContext()).inflate(R.layout.layout_search_result_list, r101, true);
        goto L11
    L5:
        r101 = null;
        goto L6
    }
}
