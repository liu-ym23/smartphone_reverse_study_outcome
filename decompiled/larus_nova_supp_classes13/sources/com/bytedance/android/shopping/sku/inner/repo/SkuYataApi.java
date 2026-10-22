package com.bytedance.android.shopping.sku.inner.repo;

import com.bytedance.android.shopping.sku.inner.repo.model.SkuYataAutoApplyCouponResponse;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0017J1\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nJk\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/repo/SkuYataApi;", "", "", "requestScene", "Lph3/b;", "request", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "", "getQuery", "(Ljava/lang/Integer;Lph3/b;)Lio/reactivex/Observable;", "productId", "shopId", "", "price", "marketChannel", "authorId", "secAuthorId", "channelId", "channelType", "Lcom/bytedance/android/shopping/sku/inner/repo/model/SkuYataAutoApplyCouponResponse;", "applyCouponAuto", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SkuYataApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    @FormUrlEncoded
    @POST("/aweme/v2/shop/coupon/apply/auto/")
    Observable<SkuYataAutoApplyCouponResponse> applyCouponAuto(@Field(PdpOpenThirdParam.KEY_PRODUCT_ID) String r1, @Field("shop_id") String r2, @Field("price") long r3, @Field("marketing_channel") String r5, @Field("author_id") String r6, @Field(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID) String r7, @Field("channel_id") String r8, @Field("channel_type") Integer r9);

    @POST("aweme/v2/sku/yata/query")
    Observable<SsResponse<String>> getQuery(@Query("request_scene") Integer r1, @Body ph3.b r2);
}
