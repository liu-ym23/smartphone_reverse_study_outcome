package com.bytedance.android.shopping.searchsimilar.api;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.searchsimilar.model.QuerySimilarProductGuideResponse;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0013Jf\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0002H'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH'J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\fH'¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/api/SimilarProductApi;", "", "", "awemeId", "productFrameId", "", "cursor", "count", "penetrateData", "sortType", "feedBack", "filters", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/searchsimilar/model/SimilarProductResponse;", "fetchSimilarProductData", "Lcom/bytedance/android/shopping/searchsimilar/model/QuerySimilarProductGuideResponse;", "queryShowSimilarProductGuide", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "updateShowSimilarProductGuide", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SimilarProductApi {
    public static final a a = null;

    public static final class a {
        public static final SimilarProductApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (SimilarProductApi) n.a.create("https://ecom.snssdk.com", SimilarProductApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET("https://ecom.snssdk.com/ecom/video/similar_product/feed")
    Observable<SimilarProductResponse> fetchSimilarProductData(@Query(SimilarProductParam.AWEME_ID) String r1, @Query("product_frame_id") String r2, @Query("cursor") int r3, @Query("count") int r4, @Query("penetrate_data") String r5, @Query("sort_rule") String r6, @Query("feedback") String r7, @Query("filters") String r8);

    @GET("https://ecom.snssdk.com/ecom/video/similar_product/query_toast")
    Observable<QuerySimilarProductGuideResponse> queryShowSimilarProductGuide();

    @POST("https://ecom.snssdk.com/ecom/video/similar_product/update_toast")
    Observable<CommerceBaseResponse> updateShowSimilarProductGuide();
}
