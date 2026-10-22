package com.ss.android.ugc.aweme.search.dynamic.core;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.dynamic.core.ability.SearchAbilityDispatcher;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicDataSharedManager;
import com.ss.android.ugc.aweme.search.dynamic.core.data.RenderEngineOption;
import com.ss.android.ugc.aweme.search.dynamic.core.monitor.DefaultPerformanceMonitor;
import com.ss.android.ugc.aweme.search.dynamic.core.supplier.IDynamicCardFactory;
import com.ss.android.ugc.aweme.search.dynamic.core.supplier.IDynamicDataProvider;
import com.ss.android.ugc.aweme.search.dynamic.core.ui.DynamicViewHierarchy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m16.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/DynamicCardContext;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/DynamicContext;", "Companion", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class DynamicCardContext extends DynamicContext {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DynamicDocument f452594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f452595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IDynamicCardFactory f452596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DefaultPerformanceMonitor f452597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LayoutInfo f452598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f452599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RenderEngineOption f452600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IDynamicDataProvider f452601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DynamicDataSharedManager f452602k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SearchAbilityDispatcher f452603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DynamicViewHierarchy f452604m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/DynamicCardContext$Companion;", "", "()V", "TAG", "", "TAG_SEARCH_CARD_CONTEXT", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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

    public final b b() {
        return (b) this.f452599h.getValue();
    }

    public DynamicCardContext(DynamicDocument r100, Context r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "document");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "businessName");
        super(r101);
        this.f452594c = r100;
        this.f452595d = r102;
        this.f452596e = r100.f452642i;
        this.f452597f = new DefaultPerformanceMonitor(this);
        this.f452598g = new LayoutInfo(0);
        this.f452599h = LazyKt.lazy(DynamicCardContext$contextProviderFactory$2.INSTANCE);
        this.f452600i = RenderEngineOption.a(r100.f452638e);
        this.f452601j = r100.f452636c.f452660c;
        this.f452602k = new DynamicDataSharedManager();
        this.f452603l = new SearchAbilityDispatcher();
        this.f452604m = r100.f452640g.a(this);
    }
}
