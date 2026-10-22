package com.bytedance.android.shopping.store.repository.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.store.repository.dto.StoreV3SearchResponseExpDTO;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWordResponse;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\u009b\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u000b\u001a\u00020\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u0018\u001a\u00020\u00172\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0005\u001a\u00020\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/api/StoreSearchV3Api;", "", "", "cursor", "", UploadTypeInf.COUNT, "", "query", "searchId", "secShopId", "sortParams", "enterFrom", "searchSource", "requestType", "searchChannel", "passThroughApi", "bcmChain", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/store/repository/dto/StoreV3SearchResponseExpDTO;", "getSearchV3ProductList", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "businessId", "params", "Lcom/bytedance/android/shopping/store/repository/vo/SearchSuggestWordResponse;", "getSuggestWords", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface StoreSearchV3Api {
    public static final a a = null;

    public static final class a {
        public static final StoreSearchV3Api a = null;
        public static final StoreSearchV3Api b = null;
        public static final /* synthetic */ a c = null;

        public a() {
        }

        static {
            c = new a();
            n r0 = n.a;
            a = (StoreSearchV3Api) r0.create(gn.a.a(), StoreSearchV3Api.class);
            b = (StoreSearchV3Api) r0.create("https://tsearch.snssdk.com", StoreSearchV3Api.class);
        }
    }

    static {
        a = a.c;
    }

    @FormUrlEncoded
    @POST("/aweme/v2/shop/search/aggregate/shopping/")
    Observable<StoreV3SearchResponseExpDTO> getSearchV3ProductList(@Field("cursor") long r1, @Field(UploadTypeInf.COUNT) int r3, @Field("query") String r4, @Field("search_id") String r5, @Field("sec_shop_id") String r6, @Field("sort_params") String r7, @Field("enter_from") String r8, @Field("search_source") String r9, @Field("request_type") Integer r10, @Field("search_channel") String r11, @Field("pass_through_api") String r12, @Field("bcm_chain") String r13);

    @GET("/api/suggest_words/")
    Object getSuggestWords(@Query("business_id") String r1, @Query("penetrate_params") String r2, @Query(UploadTypeInf.COUNT) int r3, Continuation<? super SearchSuggestWordResponse> r4);
}
