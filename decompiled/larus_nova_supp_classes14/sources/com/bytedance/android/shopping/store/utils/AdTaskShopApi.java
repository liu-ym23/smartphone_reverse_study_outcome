package com.bytedance.android.shopping.store.utils;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/AdTaskShopApi;", "", "", "eventType", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "body", "Lio/reactivex/Observable;", "finishProductScan", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AdTaskShopApi {
    @POST("/ad/mission/openapi/report_event")
    Observable<Object> finishProductScan(@Query("event_type") int r1, @Body TypedOutput r2);
}
