package com.bytedance.flow.search.kmp.impl.component;

import com.bytedance.flow.search.kmp.impl.core.FlowSearchStore;
import com.bytedance.flow.search.kmp.impl.middleware.SearchHistoryMiddleware;
import com.bytedance.flow.search.kmp.impl.middleware.k;
import com.bytedance.flow.search.kmp.impl.middleware.o;
import com.bytedance.flow.search.kmp.impl.middleware.p;
import com.bytedance.flow.search.kmp.impl.middleware.q;
import com.bytedance.flow.search.kmp.impl.middleware.r;
import com.bytedance.flow.search.kmp.impl.middleware.s;
import com.bytedance.flow.search.kmp.impl.provider.DefaultSearchRecentConvDataSourceProvider;
import com.bytedance.flow.search.kmp.impl.provider.LocalMessageDataSourceProvider;
import com.bytedance.flow.search.kmp.impl.provider.RecentBotDataSourceProvider;
import com.bytedance.flow.search.kmp.impl.provider.RecentDriveDataSourceProvider;
import com.bytedance.flow.search.kmp.impl.provider.ser.RemoteFilterDataSourceProvider;
import com.bytedance.flow.search.kmp.impl.provider.ser.RemoteQueryDataSourceProvider;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import zv5.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/flow/search/kmp/impl/component/AggregateSearchComponentFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/bytedance/flow/search/kmp/api/IAggregateSearchAbility;", "config", "Lcom/bytedance/flow/search/kmp/api/spi/SearchComponentBuildConfig;", "<init>", "(Lcom/bytedance/flow/search/kmp/api/spi/SearchComponentBuildConfig;)V", "historyMiddleware", "Lcom/bytedance/flow/search/kmp/impl/middleware/SearchHistoryMiddleware;", "queryProvider", "Lcom/bytedance/flow/search/kmp/api/datasource/FlowSearchDataSourceProvider;", "filterProvider", "recentConvProvider", "localMessageProvider", "Lcom/bytedance/flow/search/kmp/impl/provider/LocalMessageDataSourceProvider;", "recentDriveProvider", "Lcom/bytedance/flow/search/kmp/impl/provider/RecentDriveDataSourceProvider;", "recentBotProvider", "Lcom/bytedance/flow/search/kmp/impl/provider/RecentBotDataSourceProvider;", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Lcom/bytedance/flow/search/kmp/impl/core/FlowSearchStore;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/bytedance/flow/search/kmp/api/store/FlowSearchState;", "dispatch", "", "action", "Lcom/bytedance/flow/search/kmp/api/store/FlowSearchAction;", "dispatchToActionHandlers", "data", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "aggregate_search_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AggregateSearchComponentFeature extends ComponentFeature implements uv5.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vv5.a f243558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vv5.a f243559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vv5.a f243560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FlowSearchStore f243561k;

    public AggregateSearchComponentFeature() {
        this(null);
    }

    @Override // uv5.a
    public final StateFlowImpl state() {
        return this.f243561k.f243566c;
    }

    public AggregateSearchComponentFeature(f r110) {
        SearchHistoryMiddleware r100 = new SearchHistoryMiddleware(0);
        Map<String, Function0<vv5.a>> r101 = e.f243563a;
        String r102 = null;
        if (r110 == null) goto L5;
        String r103 = r110.f573697a;
    L6:
        vv5.a r104 = e.a(r103, new RemoteQueryDataSourceProvider());
        this.f243558h = r104;
        if (r110 == null) goto L10;
        String r105 = r110.f573699c;
        if (r105 == null) goto L10;
    L13:
        vv5.a r106 = e.a(r105, new RemoteFilterDataSourceProvider());
        this.f243559i = r106;
        if (r110 == null) goto L19;
        String r107 = r110.f573700d;
        if (r107 == null) goto L19;
        r102 = r107;
    L21:
        vv5.a r111 = e.a(r102, new DefaultSearchRecentConvDataSourceProvider());
        this.f243560j = r111;
        LocalMessageDataSourceProvider r108 = new LocalMessageDataSourceProvider();
        RecentDriveDataSourceProvider r109 = new RecentDriveDataSourceProvider();
        RecentBotDataSourceProvider r112 = new RecentBotDataSourceProvider();
        this.f243561k = new FlowSearchStore(CollectionsKt.listOf(new aw5.b[]{r100, new com.bytedance.flow.search.kmp.impl.middleware.d(), new com.bytedance.flow.search.kmp.impl.middleware.a(new AggregateSearchComponentFeature$store$1(this)), new s(), new r(CollectionsKt.listOf(r108), CollectionsKt.listOf(r104), aw5.e.f16575a), new q(CollectionsKt.listOf(r104)), new k(CollectionsKt.emptyList(), CollectionsKt.listOf(r106)), new o(CollectionsKt.listOf(new vv5.a[]{r111, r109, r112}), CollectionsKt.emptyList()), new p(MapsKt.mapOf(new Pair[]{TuplesKt.to("message", r111), TuplesKt.to("contact", r111), TuplesKt.to("drive", r109), TuplesKt.to("bot", r112)})), new com.bytedance.flow.search.kmp.impl.middleware.c()}));
        return;
    L19:
        if (r110 == null) goto L21;
        r102 = r110.f573698b;
    L10:
        if (r110 == null) goto L12;
        r105 = r110.f573698b;
        goto L13
    L12:
        r105 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // uv5.a
    public final void xj(aw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f243561k.b(r100);
    }
}
