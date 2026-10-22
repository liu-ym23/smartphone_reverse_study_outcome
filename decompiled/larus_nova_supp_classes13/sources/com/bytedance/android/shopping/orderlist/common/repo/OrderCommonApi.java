package com.bytedance.android.shopping.orderlist.common.repo;

import com.bytedance.android.chunkstreamprediction.network.b;
import com.bytedance.android.ec.model.OrderListGetSchemaResponse;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bH'¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/repo/OrderCommonApi;", "", "Lcom/bytedance/android/shopping/orderlist/common/repo/OrderCommonYataRequest;", "data", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "", "getQuery", "Lcom/bytedance/android/chunkstreamprediction/network/b;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "getQueryForChunk", "", "schemeBusinessParams", "Lcom/bytedance/android/ec/model/OrderListGetSchemaResponse;", "getOrderListSchema", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OrderCommonApi {
    public static final String API_HOST = "https://ec.ecombdapi.com/";
    public static final String CHUNK_QUERY_PATH = "/order/yata/orderListQueryStream";
    public static final a Companion = null;
    public static final String ORDER_LIST_SCHEMA_PATH = "order/getOrderListSchema";
    public static final String QUERY_PATH = "order/yata/orderListQuery";
    public static final String UPDATE_PATH = "order/yata/orderListUpdate";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    @GET(ORDER_LIST_SCHEMA_PATH)
    Observable<OrderListGetSchemaResponse> getOrderListSchema(@QueryMap Map<String, String> r1);

    @POST(QUERY_PATH)
    Observable<SsResponse<String>> getQuery(@Body OrderCommonYataRequest r1);

    @POST(CHUNK_QUERY_PATH)
    @Streaming
    Observable<b<e>> getQueryForChunk(@Body OrderCommonYataRequest r1);
}
