package com.bytedance.android.shopping.feed.repository.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.feed.model.CartNumResponse;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import rd3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u00012J·\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00042\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00042\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u001d\u001a\u00020\u001c2\b\b\u0003\u0010\u001e\u001a\u00020\u001c2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\"\u0010#Jè\u0001\u0010*\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u00022\b\b\u0003\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00042\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010$\u001a\u00020\u00042\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010'\u001a\u00020\u00042\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u0002H'J,\u0010/\u001a\b\u0012\u0004\u0012\u00020.0 2\b\b\u0003\u0010+\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\u00042\b\b\u0001\u0010-\u001a\u00020\u0004H'J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002000 H'¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/api/InnerGuessULikeApi;", "", "", "productId", "", "count", "pageNum", "pageName", "cursor", "feedbacks", "filters", "enterFrom", "internalFeedAB", "metaParam", "authorId", "authorOpenId", "shopId", "itemId", "preTopics", "videoPageSource", "showInternalListStyle", "sameProductScene", "", "frontCid", "frontCName", "firstCid", "firstCName", "aggParams", "", "isStar", "isAds", "goodPriceParam", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/feed/model/InflowGuessFeedResponse;", "fetchRecommendData", "(Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)Lio/reactivex/Observable;", "resource", "preRecommend", "videoSourcePage", "recommendScene", "searchFilterQueryIds", "searchFilterPIds", "fetchResourceCard", "requestScene", "sessionTime", "category", "Lrd3/k;", "fetchNewerChannelCardFeed", "Lcom/bytedance/android/shopping/feed/model/CartNumResponse;", "getCartNum", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface InnerGuessULikeApi {
    public static final a a = null;

    public static final class a {
        public static final InnerGuessULikeApi a = null;
        public static final InnerGuessULikeApi b = null;
        public static final /* synthetic */ a c = null;

        public a() {
        }

        static {
            c = new a();
            n r0 = n.a;
            a = (InnerGuessULikeApi) r0.create("https://aweme.snssdk.com", InnerGuessULikeApi.class);
            b = (InnerGuessULikeApi) r0.create("https://ecom.snssdk.com", InnerGuessULikeApi.class);
        }
    }

    public static final class b {
        public static /* synthetic */ Observable b(InnerGuessULikeApi r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, int r34, String r35, String r36, int r37) {
            if ((r37 & 2) == 0) goto L5;
            int r5 = 6;
        L7:
            if ((r37 & 4) == 0) goto L9;
            int r6 = 1;
        L11:
            if ((r37 & 8) == 0) goto L13;
            String r7 = "product_flow_page";
        L15:
            if ((r37 & 64) == 0) goto L17;
            String r10 = "";
        L19:
            if ((r37 & 128) == 0) goto L21;
            String r11 = "from_internal_feed";
        L23:
            if ((r37 & 256) == 0) goto L25;
            int r12 = 7;
        L27:
            if ((r37 & 512) == 0) goto L29;
            String r13 = null;
        L31:
            if ((r37 & 1024) == 0) goto L33;
            String r14 = null;
        L35:
            if ((r37 & 2048) == 0) goto L37;
            String r15 = null;
        L39:
            if ((r37 & 4096) == 0) goto L41;
            String r16 = null;
        L43:
            if ((r37 & 8192) == 0) goto L45;
            String r17 = null;
        L47:
            if ((r37 & 16384) == 0) goto L49;
            int r18 = 1;
        L51:
            if ((32768 & r37) == 0) goto L53;
            String r19 = null;
        L55:
            if ((65536 & r37) == 0) goto L57;
            String r20 = null;
        L59:
            if ((131072 & r37) == 0) goto L61;
            int r21 = 0;
        L63:
            if ((262144 & r37) == 0) goto L65;
            String r22 = null;
        L67:
            if ((r37 & 524288) == 0) goto L69;
            String r23 = null;
        L71:
            return r24.fetchResourceCard(r25, r5, r6, r7, 0, r26, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        L69:
            r23 = r36;
            goto L71
        L65:
            r22 = r35;
            goto L67
        L61:
            r21 = r34;
            goto L63
        L57:
            r20 = r33;
            goto L59
        L53:
            r19 = r32;
            goto L55
        L49:
            r18 = 0;
            goto L51
        L45:
            r17 = r31;
            goto L47
        L41:
            r16 = r30;
            goto L43
        L37:
            r15 = r29;
            goto L39
        L33:
            r14 = r28;
            goto L35
        L29:
            r13 = r27;
            goto L31
        L25:
            r12 = 0;
            goto L27
        L21:
            r11 = null;
            goto L23
        L17:
            r10 = null;
            goto L19
        L13:
            r7 = null;
            goto L15
        L9:
            r6 = 0;
            goto L11
        L5:
            r5 = 0;
            goto L7
        }

        public static /* synthetic */ Observable a(InnerGuessULikeApi r29, String r30, int r31, int r32, String r33, int r34, String r35, String r36, String r37, int r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, Integer r46, Integer r47, Long r48, String r49, Long r50, String r51, String r52, boolean r53, boolean r54, String r55, int r56) {
            if ((r56 & 2) == 0) goto L5;
            int r4 = 6;
        L7:
            if ((r56 & 8) == 0) goto L9;
            String r6 = "product_flow_page";
        L11:
            if ((r56 & 32) == 0) goto L13;
            String r8 = "";
        L15:
            if ((r56 & 64) == 0) goto L17;
            String r9 = "";
        L19:
            if ((r56 & 128) == 0) goto L21;
            String r10 = "from_internal_feed";
        L23:
            if ((r56 & 256) == 0) goto L25;
            int r11 = 7;
        L27:
            if ((r56 & 512) == 0) goto L29;
            String r12 = null;
        L31:
            if ((r56 & 1024) == 0) goto L33;
            String r13 = null;
        L35:
            if ((r56 & 2048) == 0) goto L37;
            String r14 = null;
        L39:
            if ((r56 & 4096) == 0) goto L41;
            String r15 = null;
        L43:
            if ((r56 & 8192) == 0) goto L45;
            String r16 = null;
        L47:
            if ((r56 & 16384) == 0) goto L49;
            String r17 = null;
        L51:
            if ((32768 & r56) == 0) goto L53;
            String r18 = null;
        L55:
            if ((65536 & r56) == 0) goto L57;
            Integer r19 = null;
        L59:
            if ((131072 & r56) == 0) goto L61;
            Integer r20 = 0;
        L63:
            if ((262144 & r56) == 0) goto L65;
            Long r21 = null;
        L67:
            if ((524288 & r56) == 0) goto L69;
            String r22 = null;
        L71:
            if ((1048576 & r56) == 0) goto L73;
            Long r23 = null;
        L75:
            if ((2097152 & r56) == 0) goto L77;
            String r24 = null;
        L79:
            if ((4194304 & r56) == 0) goto L81;
            String r25 = null;
        L83:
            if ((8388608 & r56) == 0) goto L85;
            boolean r26 = false;
        L87:
            if ((16777216 & r56) == 0) goto L89;
            boolean r27 = false;
        L91:
            if ((r56 & 33554432) == 0) goto L93;
            String r28 = null;
        L95:
            return r29.fetchRecommendData(r30, r4, r32, r6, r34, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        L93:
            r28 = r55;
            goto L95
        L89:
            r27 = r54;
            goto L91
        L85:
            r26 = r53;
            goto L87
        L81:
            r25 = r52;
            goto L83
        L77:
            r24 = r51;
            goto L79
        L73:
            r23 = r50;
            goto L75
        L69:
            r22 = r49;
            goto L71
        L65:
            r21 = r48;
            goto L67
        L61:
            r20 = r47;
            goto L63
        L57:
            r19 = r46;
            goto L59
        L53:
            r18 = r45;
            goto L55
        L49:
            r17 = r44;
            goto L51
        L45:
            r16 = r43;
            goto L47
        L41:
            r15 = r42;
            goto L43
        L37:
            r14 = r41;
            goto L39
        L33:
            r13 = r40;
            goto L35
        L29:
            r12 = r39;
            goto L31
        L25:
            r11 = r38;
            goto L27
        L21:
            r10 = r37;
            goto L23
        L17:
            r9 = r36;
            goto L19
        L13:
            r8 = r35;
            goto L15
        L9:
            r6 = r33;
            goto L11
        L5:
            r4 = r31;
            goto L7
        }
    }

    static {
        a = a.c;
    }

    @GET("https://growth.ecombdapi.com/growth/user_lifecycle/newer_channel_card/product")
    Observable<k> fetchNewerChannelCardFeed(@Query("request_scene") String r1, @Query("session_time") int r2, @Query("first_category") int r3);

    @GET("https://aweme.snssdk.com/aweme/v2/commerce/favorite/feed")
    Observable<InflowGuessFeedResponse> fetchRecommendData(@Query(PdpOpenThirdParam.KEY_PRODUCT_ID) String r1, @Query("count") int r2, @Query("page_num") int r3, @Query(PdpOpenThirdParam.KEY_PAGE_NAME) String r4, @Query("cursor") int r5, @Query("feedbacks") String r6, @Query("filters") String r7, @Query(SimilarProductParam.ENTER_FROM) String r8, @Query("internal_feed_ab") int r9, @Query("meta_param") String r10, @Query("author_id") String r11, @Query("author_open_id") String r12, @Query("shop_id") String r13, @Query(PdpOpenThirdParam.KEY_ITEM_ID) String r14, @Query("pre_topics") String r15, @Query("video_page_source") String r16, @Query("show_internal_list_style") Integer r17, @Query("same_product_scene") Integer r18, @Query("front_category_id") Long r19, @Query("front_category_name") String r20, @Query("first_category_id") Long r21, @Query("first_category_name") String r22, @Query("agg_params") String r23, @Query("is_star") boolean r24, @Query("is_ads") boolean r25, @Query("good_price_param") String r26);

    @GET("https://aweme.snssdk.com/aweme/v2/commerce/favorite/feed")
    Observable<InflowGuessFeedResponse> fetchResourceCard(@Query(PdpOpenThirdParam.KEY_PRODUCT_ID) String r1, @Query("count") int r2, @Query("page_num") int r3, @Query(PdpOpenThirdParam.KEY_PAGE_NAME) String r4, @Query("cursor") int r5, @Query("feedbacks") String r6, @Query("filters") String r7, @Query(SimilarProductParam.ENTER_FROM) String r8, @Query("internal_feed_ab") int r9, @Query("meta_param") String r10, @Query("author_id") String r11, @Query("author_open_id") String r12, @Query("shop_id") String r13, @Query(PdpOpenThirdParam.KEY_ITEM_ID) String r14, @Query("resource") int r15, @Query("pre_recommend") String r16, @Query("video_source_page") String r17, @Query("resource_scene") int r18, @Query("search_filter_query_ids") String r19, @Query("search_filter_pids") String r20);

    @GET("https://ec.ecombdapi.com/cart/cartNum_new")
    Observable<CartNumResponse> getCartNum();
}
