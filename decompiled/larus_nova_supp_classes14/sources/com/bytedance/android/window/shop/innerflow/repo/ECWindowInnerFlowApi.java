package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowCartInfoDTO;
import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowDTO;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0019J\u0087\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012H§@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00042\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0002H'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowApi;", "", "", "secAuthorId", "", "innerFlowType", "customIds", "promotionId", "filterPromotionIds", "", "pageNum", "pageSize", "passThroughApi", "sortType", "sort", "Lcom/bytedance/android/window/shop/innerflow/entity/dto/ECShopInnerFlowDTO;", "getInnerFlowData", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/bytedance/android/window/shop/innerflow/entity/dto/ECShopInnerFlowCartInfoDTO;", "getInnerFlowCartInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "componentType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowComponentDTO;", "getInnerFlowComponent", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ECWindowInnerFlowApi {
    public static final a a = null;

    public static final class a {
        public static final ECWindowInnerFlowApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (ECWindowInnerFlowApi) n.a.create(kp.a.a(), ECWindowInnerFlowApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET("/window/innerflow/header/")
    Object getInnerFlowCartInfo(Continuation<? super ECShopInnerFlowCartInfoDTO> r1);

    @GET("/window/innerflow/component/")
    Observable<ECWindowInnerFlowComponentDTO> getInnerFlowComponent(@Query("sec_author_id") String r1, @Query("component_type") int r2, @Query("pass_through_api") String r3);

    @GET("/window/innerflow/")
    Object getInnerFlowData(@Query("sec_author_id") String r1, @Query("inner_flow_type") int r2, @Query("custom_ids") String r3, @Query("promotion_id") String r4, @Query("filter_promotion_ids") String r5, @Query("cursor") long r6, @Query("size") Integer r8, @Query("pass_through_api") String r9, @Query("sort_type") Long r10, @Query("sort") Integer r11, Continuation<? super ECShopInnerFlowDTO> r12);
}
