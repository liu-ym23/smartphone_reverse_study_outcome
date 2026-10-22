package com.bytedance.android.shopping.mall.preload;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u001b\b\u0001\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\u00040\u0002H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/mall/preload/DistributionApi;", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "map", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/mall/preload/DistributionResp;", "fetch", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface DistributionApi {
    @GET("/api/distribution/abtest")
    Observable<DistributionResp> fetch(@QueryMap Map<String, Object> r1);
}
