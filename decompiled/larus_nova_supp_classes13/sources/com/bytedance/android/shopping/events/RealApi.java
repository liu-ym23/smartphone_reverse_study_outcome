package com.bytedance.android.shopping.events;

import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/events/RealApi;", "", "", "data", "Lio/reactivex/Observable;", "post", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RealApi {
    @FormUrlEncoded
    @POST("/aweme/v2/shop/user/behavior/")
    Observable<Object> post(@Field("data") String r1);
}
