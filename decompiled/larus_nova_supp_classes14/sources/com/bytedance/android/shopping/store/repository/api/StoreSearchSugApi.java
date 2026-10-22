package com.bytedance.android.shopping.store.repository.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.store.repository.dto.StoreSearchSugResponseDTO;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\u008f\u0001\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00022\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/api/StoreSearchSugApi;", "", "", "keyword", "source", "enterFrom", "sugServerExtra", "", "cursorPos", "sugAfterSearch", "", "Lorg/json/JSONObject;", "lastPrefix", "sugSessionId", "lastSearchQuery", "", "sugGapTime", "sugEnterType", "Lcom/bytedance/android/shopping/store/repository/dto/StoreSearchSugResponseDTO;", "getStoreSearchSugList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/lang/String;Ljava/util/List;DILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface StoreSearchSugApi {
    public static final a a = null;

    public static final class a {
        public static final StoreSearchSugApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (StoreSearchSugApi) n.a.create("https://tsearch.amemv.com", StoreSearchSugApi.class);
        }
    }

    static {
        a = a.b;
    }

    @FormUrlEncoded
    @POST("/aweme/v1/search/sug/")
    Object getStoreSearchSugList(@Query("keyword") String r1, @Query("source") String r2, @Query("enter_from") String r3, @Query("sug_server_extra") String r4, @Field("cursor_pos") int r5, @Field("sug_after_search") int r6, @Field("last_prefix") List<JSONObject> r7, @Field("sug_session_id") String r8, @Field("last_search_query") List<JSONObject> r9, @Field("sug_gap_time") double r10, @Field("sug_enter_type") int r12, Continuation<? super StoreSearchSugResponseDTO> r13);
}
