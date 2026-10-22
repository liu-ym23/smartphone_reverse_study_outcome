package com.larus.common.venue.api;

import android.app.Activity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import q97.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0016J%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/common/venue/api/FlowCommonVenueServiceNoop;", "Lcom/larus/common/venue/api/IFlowCommonVenueService;", "<init>", "()V", "onApplyPocket", "", "ownerActivity", "Landroid/app/Activity;", "data", "", "", "", "extra", "getPocketPageData", "bizScene", "", "(Ljava/lang/Integer;)Ljava/util/Map;", "preloadPocketData", "(Ljava/lang/Integer;)V", "getCommonVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCommonVenueServiceNoop implements IFlowCommonVenueService {
    public FlowCommonVenueServiceNoop() {
    }

    @Override // com.larus.common.venue.api.IFlowCommonVenueService
    public final void b(Activity r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "extra");
    }

    @Override // com.larus.common.venue.api.IFlowCommonVenueService
    public final a c() {
        return null;
    }

    @Override // com.larus.common.venue.api.IFlowCommonVenueService
    public final void e(Integer r100) {
    }

    @Override // com.larus.common.venue.api.IFlowCommonVenueService
    public final Map<String, Object> d(Integer r100) {
        return MapsKt.emptyMap();
    }
}
