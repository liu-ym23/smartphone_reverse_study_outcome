package com.bytedance.android.shopping.order.api;

import cg3.d;
import cg3.h;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.order.dto.CommentInfoStruct;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001fJu\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u000e\u0010\u000fJ½\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0017H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001cH'¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/order/api/OrderApi;", "", "", "orderId", "productId", "", "content", "rankShop", "rankLogistic", "rankGood", "customChoiceTitle", "customChoiceOption", "Lio/reactivex/Observable;", "Lcg3/h;", "getShareInfo", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "userId", "appId", "userType", "isAnonymous", "contentCount", "photos", "videos", "", "fromReasonSelect", "Lcg3/d;", "publishComment", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/order/dto/CommentInfoStruct;", "commentInfoStruct", "publishCommentV2", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OrderApi {
    public static final a a = null;

    public static final class a {
        public static final OrderApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (OrderApi) n.a.create("https://aweme.snssdk.com", OrderApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET("/aweme/v2/shop/promotion/comment/getShareInfo/")
    Observable<h> getShareInfo(@Query("order_id") Long r1, @Query(PdpOpenThirdParam.KEY_PRODUCT_ID) Long r2, @Query("content") String r3, @Query("rank_shop") Long r4, @Query("rank_logistic") Long r5, @Query("rank_good") Long r6, @Query("custom_choice_title") String r7, @Query("custom_choice_option") String r8);

    @FormUrlEncoded
    @POST("/aweme/v2/shop/promotion/comment/post/")
    Observable<d> publishComment(@Field("user_id") Long r1, @Field("app_id") Long r2, @Field("user_type") Long r3, @Field("anonymous") Long r4, @Field("content") String r5, @Field("content_count") Long r6, @Field("order_id") Long r7, @Field(PdpOpenThirdParam.KEY_PRODUCT_ID) Long r8, @Field("rank_good") Long r9, @Field("rank_logistic") Long r10, @Field("rank_shop") Long r11, @Field("photos") String r12, @Field("videos") String r13, @Field("from_reason_select") Boolean r14);

    @POST("https://ec.snssdk.com/comment/v2/post")
    Observable<d> publishCommentV2(@Body CommentInfoStruct r1);
}
