package com.bytedance.android.shopping.mall.homepage.card.live;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/AdDislikeApi;", "", "postAdDislike", "Lio/reactivex/Observable;", "", "headerMap", "", "body", "Lcom/google/gson/JsonObject;", "feedbackType", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AdDislikeApi {
    @POST("/api/ad/v1/dislike/")
    Observable<String> postAdDislike(@HeaderMap Map<String, String> r1, @Body JsonObject r2, @Query("feedback_type") int r3);
}
