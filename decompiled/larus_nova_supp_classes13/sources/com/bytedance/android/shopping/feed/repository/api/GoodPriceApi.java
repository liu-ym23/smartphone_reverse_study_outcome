package com.bytedance.android.shopping.feed.repository.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;
import ud3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ^\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/api/GoodPriceApi;", "", "", "baseProducts", "", "isStar", "isAds", "enterFrom", "sceneList", "itemId", "currentScene", "authorId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/feed/model/InflowGuessFeedResponse;", "getGoodPriceProducts", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface GoodPriceApi {
    public static final a a = null;

    public static final class a {
        public static final GoodPriceApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (GoodPriceApi) n.a.create(e.a(), GoodPriceApi.class);
        }
    }

    static {
        a = a.b;
    }

    @FormUrlEncoded
    @POST("/ecom/video/get_good_products/")
    Observable<InflowGuessFeedResponse> getGoodPriceProducts(@Field("base_products") String r1, @Field("is_star") boolean r2, @Field("is_ads") boolean r3, @Field(SimilarProductParam.ENTER_FROM) String r4, @Field("scene_list") String r5, @Field(PdpOpenThirdParam.KEY_ITEM_ID) String r6, @Field("current_scene") String r7, @Field("author_id") String r8);
}
