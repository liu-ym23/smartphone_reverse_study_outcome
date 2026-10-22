package com.bytedance.android.shopping.commentfeed.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.commentfeed.model.CommentListResponse;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ@\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\bH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/api/CommentFeedListApi;", "", "", "productId", "", "count", "cursor", "entrance", "", "needAdaptAddr", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/commentfeed/model/CommentListResponse;", "getCommentList", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CommentFeedListApi {
    public static final a a = null;

    public static final class a {
        public static final CommentFeedListApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (CommentFeedListApi) n.a.create("https://aweme.snssdk.com", CommentFeedListApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET("https://aweme.snssdk.com/aweme/v2/shop/promotion/comments/selected_list")
    Observable<CommentListResponse> getCommentList(@Query(PdpOpenThirdParam.KEY_PRODUCT_ID) String r1, @Query("count") long r2, @Query("cursor") long r4, @Query("entrance") String r6, @Query("need_adapt_addr") int r7);
}
