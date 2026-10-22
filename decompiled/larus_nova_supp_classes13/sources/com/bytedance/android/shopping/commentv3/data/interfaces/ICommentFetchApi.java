package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u0011JJ\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0016\b\u0003\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00022\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H'J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0016\b\u0003\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H'J2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0018\b\u0003\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H'J2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0018\b\u0003\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H'¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/ICommentFetchApi;", "", "", "", "requestMap", "", "skuSpecName", "topCommentIds", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentResponse;", "fetchProductComment", "fetchShopComment", "url", "params", "fetchGet", "queryParams", "fetchPost", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICommentFetchApi {
    public static final a a = null;

    public static final class a {
        public static final ICommentFetchApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (ICommentFetchApi) n.a.create("https://ec.snssdk.com", ICommentFetchApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET
    Observable<String> fetchGet(@Url String r1, @QueryMap Map<String, Object> r2);

    @POST
    Observable<String> fetchPost(@Url String r1, @QueryMap Map<String, Object> r2);

    @GET("/comment/v2/shop/promotion/comments/v2")
    Observable<CommentResponse> fetchProductComment(@QueryMap Map<String, Object> r1, @Query("sku_spec_name") List<String> r2, @Query("top_comment_ids") List<String> r3);

    @GET("/comment/v2/shop/promotion/shop_comments/v2")
    Observable<CommentResponse> fetchShopComment(@QueryMap Map<String, Object> r1);
}
