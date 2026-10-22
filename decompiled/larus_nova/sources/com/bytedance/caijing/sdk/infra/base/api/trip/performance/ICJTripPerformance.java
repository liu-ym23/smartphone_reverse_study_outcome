package com.bytedance.caijing.sdk.infra.base.api.trip.performance;

import android.content.Context;
import cd4.p;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import id4.c;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableSharedFlow;
import re4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&¨\u0006\f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/trip/performance/ICJTripPerformance;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Lcd4/p;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lre4/a;", "prefetchModel", "", "prefetchTrip", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lid4/c;", "getAmapPreRenderFlow", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface ICJTripPerformance extends ICJService, p {
    MutableSharedFlow<c> getAmapPreRenderFlow();

    void prefetchTrip(Context r100, a r101);

    @Override // cd4.p, com.android.ttcjpaysdk.base.framework.container.abs.IRelease
    /* synthetic */ void release();
}
