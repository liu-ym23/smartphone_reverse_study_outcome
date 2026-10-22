package com.bytedance.android.shopping.skubuy.platform.data.api;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import r43.c;
import r43.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J>\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0019\b\u0001\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u00060\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/data/api/SkuBuyApi;", "", "Lr43/c;", "params", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "urlParams", "Lcom/bytedance/retrofit2/SsResponse;", "Lr43/d;", "createOrder", "(Lr43/c;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SkuBuyApi {
    @POST("/order/component/createOrder/")
    Object createOrder(@Body c r1, @QueryMap Map<String, Object> r2, Continuation<? super SsResponse<d>> r3);
}
