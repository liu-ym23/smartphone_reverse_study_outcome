package com.ss.android.ugc.aweme.search.common.result.sug;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.common.util.concurrent.ListenableFuture;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchSugResponse;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes40.dex */
public class ECSearchSugApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final API f451899a = null;

    public interface API {
        @POST("/aweme/v1/search/ecom_sug/")
        ListenableFuture<ECSearchSugResponse> getSearchSugListNew(@com.bytedance.retrofit2.http.Query("keyword") String r100, @com.bytedance.retrofit2.http.Query("source") String r101, @com.bytedance.retrofit2.http.Query(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID) String r102, @com.bytedance.retrofit2.http.Query("no_trace_search_switch") String r103, @com.bytedance.retrofit2.http.Query("enter_from") String r104, @com.bytedance.retrofit2.http.Query(ECFindSimilarConfig.ENTER_FROM_SECOND) String r105, @com.bytedance.retrofit2.http.Query("sug_enter_type") int r106, @com.bytedance.retrofit2.http.Query("sug_gap_time") long r107, @com.bytedance.retrofit2.http.Query("sug_active_search_query") String r110, @com.bytedance.retrofit2.http.Query("sug_server_extra") String r111, @com.bytedance.retrofit2.http.Query("presearch") String r112, @com.bytedance.retrofit2.http.Query("pitaya_upload_info") String r113, @Body RequestBody r114);
    }

    static {
        TradeSearch.f453393a.getClass();
        f451899a = (API) TradeSearch.b(0).getITradeSearchHostNetService().create(CJPayConstant.TT_CJ_PAY_FOLLOW_HOST, API.class);
    }
}
