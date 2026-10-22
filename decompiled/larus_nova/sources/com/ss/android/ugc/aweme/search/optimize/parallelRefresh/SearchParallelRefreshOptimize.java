package com.ss.android.ugc.aweme.search.optimize.parallelRefresh;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.config.ParallelRefreshConfig;
import com.ss.android.ugc.aweme.search.optimize.BaseOptimize;
import com.ss.android.ugc.aweme.search.optimize.IOptimizeCore;
import com.ss.android.ugc.aweme.search.optimize.SearchOptimizeRequestContext;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ugc.android.cachalot.api.Trigger;
import com.ss.ugc.android.cachalot.common.async.controller.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/parallelRefresh/SearchParallelRefreshOptimize;", "Lcom/ss/android/ugc/aweme/search/optimize/BaseOptimize;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SearchParallelRefreshOptimize extends BaseOptimize<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParallelRefreshConfig f453367b;

    public SearchParallelRefreshOptimize(ParallelRefreshConfig r100, IOptimizeCore<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "core");
        super(r101);
        this.f453367b = r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.ugc.aweme.search.optimize.BaseOptimize, com.ss.android.ugc.aweme.search.optimize.IEventDispatcher
    public final void a(Object r100, SearchOptimizeRequestContext r110) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        a r101 = new a(false, null, null, this.f453350a.d(), Long.valueOf(this.f453367b.getTimeout()), MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TOTAL_CACHED_LEN);
        int r102 = Math.min(this.f453350a.g(r100), this.f453367b.getMaxParallelCount());
        this.f453350a.i();
        String r103 = null;
        if (r110 == null) goto L5;
        this.f453367b.getStartPosition();
        SearchParallelRefreshMonitor r104 = new SearchParallelRefreshMonitor();
    L6:
        SearchParallelRefreshMonitorProvider r105 = SearchParallelRefreshMonitorProvider.f453365a;
        if (r110 == null) goto L9;
        r103 = r110.f453362c;
    L9:
        r105.getClass();
        if (r103 == null) goto L13;
        SearchParallelRefreshMonitorProvider.f453366b.put(r103, r104);
    L13:
        int r111 = this.f453367b.getStartPosition();
    L14:
        if (r111 >= r102) goto L20;
        if (this.f453350a.j(r111, r101, Trigger.PARALLEL_REFRESH).f453351a == true) goto L19;
    L19:
        r111 = r111 + 1;
        goto L14
    L20:
        this.f453367b.getStartPosition();
        return;
    L5:
        r104 = null;
        goto L6
    }
}
