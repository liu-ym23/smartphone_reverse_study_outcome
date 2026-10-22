package com.bytedance.android.shopping.feed.repository.api;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.android.shopping.feed.repository.dto.GroupInfoResponse;
import com.bytedance.android.shopping.feed.repository.dto.PreviewLikeListResponse;
import com.bytedance.android.shopping.feed.repository.dto.PreviewWillListResponse;
import com.bytedance.android.shopping.feed.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.android.shopping.feed.repository.dto.SearchSuggestWordResponse;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ud3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001HJ\u008b\u0003\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0016\b\u0003\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b&\u0010'J\u008f\u0001\u0010.\u001a\b\u0012\u0004\u0012\u00020-0$2\b\b\u0001\u0010(\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010)\u001a\u00020\u000e2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b.\u0010/JB\u00104\u001a\b\u0012\u0004\u0012\u0002030$2\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u00100\u001a\u00020\u000e2\b\b\u0001\u00101\u001a\u00020\u000e2\b\b\u0001\u0010*\u001a\u00020\u000e2\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u0002H'Jf\u00108\u001a\b\u0012\u0004\u0012\u0002070$2\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010(\u001a\u00020\u00022\b\b\u0001\u00105\u001a\u00020\u00022\n\b\u0001\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010)\u001a\u00020\u000e2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0002H'JL\u0010=\u001a\b\u0012\u0004\u0012\u00020<0$2\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u00109\u001a\u00020\u00022\b\b\u0001\u0010;\u001a\u00020:2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0002H'J@\u0010?\u001a\b\u0012\u0004\u0012\u00020>0$2\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002H'J0\u0010A\u001a\b\u0012\u0004\u0012\u0002070$2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010@\u001a\u00020\u000eH'JJ\u0010G\u001a\b\u0012\u0004\u0012\u00020F0$2\n\b\u0003\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010D\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010E\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0002H'¨\u0006I"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/api/AnchorV3Api;", "", "", "userId", "userOpenId", "secUsrId", "", "promotionIds", "itemId", "secAuthorId", "enterFrom", "metaParam", "authorId", "authorOpenId", "", "width", "height", "rankId", "internalFeedAB", "sourceType", "qianChuanAb", "useNewPrice", "cpsTrack", "addressId", "marketChannel", "gpsOn", "productId", "creativeId", "promotionId", "inflowMetaParam", "", "fieldMap", "videoPageSource", "sameProductScene", "isPreload", "aggParams", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPackResponse;", "getShopPromotionInner", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "awemeId", "type", "itemType", "pageSource", "extraInfo", "Lcom/bytedance/android/shopping/feed/repository/dto/PreviewWillListResponse;", "shopWillList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "scene", "action", "commissionInfo", "Lcom/bytedance/android/shopping/feed/repository/dto/PreviewLikeListResponse;", "shopLikeList", "kolId", "secKolId", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "appointPromotion", "shopId", "", "price", "Lcom/bytedance/android/shopping/feed/repository/dto/PromotionAutoApplyCouponResponse;", "applyCouponAuto", "Lcom/bytedance/android/shopping/feed/repository/dto/GroupInfoResponse;", "getGroupInfo", "reportType", "reportTrackParams", "businessId", "pd", "categoryName", "wordSource", "Lcom/bytedance/android/shopping/feed/repository/dto/SearchSuggestWordResponse;", "getSearchSuggestWords", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AnchorV3Api {
    public static final a a = null;

    public static final class a {
        public static final AnchorV3Api a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (AnchorV3Api) n.a.create(e.a(), AnchorV3Api.class);
        }

        public static Observable a(String r12, String r13, String r14, int r15, String r16, Integer r17, String r18, String r19) {
            Intrinsics.checkNotNullParameter(r12, "awemeId");
            Intrinsics.checkNotNullParameter("", "promotionId");
            Intrinsics.checkNotNullParameter(r13, "authorId");
            Intrinsics.checkNotNullParameter(r14, "secAuthorId");
            String r3 = "";
            if (r15 != 1) goto L10;
            JSONObject r0 = new JSONObject();
            com.bytedance.android.btm.api.model.e r8 = BtmSDK.INSTANCE.getBtmPageInfo(null);
            if (r8 == null) goto L8;
            String r9 = r8.a;
            if (r9 == null) goto L8;
        L9:
            r0.put("btm_show_id", r9);
        L11:
            AnchorV3Api r10 = a;
            if (r10 == null) goto L22;
            if (r19 == null) goto L16;
            r3 = r19;
        L16:
            if (r0 == null) goto L18;
            String r11 = r0.toString();
        L19:
            Observable<PreviewWillListResponse> r1 = r10.shopWillList(r12, "", r3, r13, r14, r15, r16, r17, r18, " product_flow_page", r11);
            if (r1 == null) goto L22;
            return r1;
        L18:
            r11 = null;
        L22:
            return Observable.error(new Throwable());
        L8:
            r9 = "";
            goto L9
        L10:
            r0 = null;
            goto L11
        }
    }

    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable a(AnchorV3Api r34, String r35, String r36, String r37, List r38, String r39, String r40, String r41, String r42, String r43, String r44, Integer r45, Integer r46, String r47, Integer r48, String r49, String r50, Integer r51, String r52, String r53, String r54, Integer r55, String r56, String r57, String r58, String r59, Map r60, String r61, Integer r62, Integer r63, String r64, int r65) {
            if ((r65 & 4) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r65 & 8) == 0) goto L9;
            List r7 = null;
        L11:
            if ((r65 & 16) == 0) goto L13;
            String r8 = null;
        L15:
            if ((r65 & 128) == 0) goto L17;
            String r11 = null;
        L19:
            if ((r65 & 256) == 0) goto L21;
            String r12 = null;
        L23:
            if ((r65 & 512) == 0) goto L25;
            String r13 = null;
        L27:
            if ((r65 & 1024) == 0) goto L29;
            Integer r14 = null;
        L31:
            if ((r65 & 2048) == 0) goto L33;
            Integer r15 = null;
        L35:
            if ((r65 & 4096) == 0) goto L37;
            String r16 = null;
        L39:
            if ((r65 & 8192) == 0) goto L41;
            Integer r17 = null;
        L43:
            if ((r65 & 16384) == 0) goto L45;
            String r18 = null;
        L47:
            if ((32768 & r65) == 0) goto L49;
            String r19 = null;
        L51:
            if ((65536 & r65) == 0) goto L53;
            Integer r20 = null;
        L55:
            if ((131072 & r65) == 0) goto L57;
            String r21 = null;
        L59:
            if ((262144 & r65) == 0) goto L61;
            String r22 = null;
        L63:
            if ((524288 & r65) == 0) goto L65;
            String r23 = null;
        L67:
            if ((1048576 & r65) == 0) goto L69;
            Integer r24 = null;
        L71:
            if ((2097152 & r65) == 0) goto L73;
            String r25 = null;
        L75:
            if ((4194304 & r65) == 0) goto L77;
            String r26 = null;
        L79:
            if ((8388608 & r65) == 0) goto L81;
            String r27 = null;
        L83:
            if ((16777216 & r65) == 0) goto L85;
            String r28 = null;
        L87:
            if ((33554432 & r65) == 0) goto L89;
            Map r29 = null;
        L91:
            if ((67108864 & r65) == 0) goto L93;
            String r30 = null;
        L95:
            if ((134217728 & r65) == 0) goto L97;
            Integer r31 = 0;
        L99:
            if ((268435456 & r65) == 0) goto L101;
            Integer r32 = 0;
        L103:
            if ((r65 & 536870912) == 0) goto L105;
            String r33 = null;
        L107:
            return r34.getShopPromotionInner(r35, r36, r6, r7, r8, r40, r41, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);
        L105:
            r33 = r64;
            goto L107
        L101:
            r32 = r63;
            goto L103
        L97:
            r31 = r62;
            goto L99
        L93:
            r30 = r61;
            goto L95
        L89:
            r29 = r60;
            goto L91
        L85:
            r28 = r59;
            goto L87
        L81:
            r27 = r58;
            goto L83
        L77:
            r26 = r57;
            goto L79
        L73:
            r25 = r56;
            goto L75
        L69:
            r24 = r55;
            goto L71
        L65:
            r23 = r54;
            goto L67
        L61:
            r22 = r53;
            goto L63
        L57:
            r21 = r52;
            goto L59
        L53:
            r20 = r51;
            goto L55
        L49:
            r19 = r50;
            goto L51
        L45:
            r18 = r49;
            goto L47
        L41:
            r17 = r48;
            goto L43
        L37:
            r16 = r47;
            goto L39
        L33:
            r15 = r46;
            goto L35
        L29:
            r14 = r45;
            goto L31
        L25:
            r13 = r44;
            goto L27
        L21:
            r12 = r43;
            goto L23
        L17:
            r11 = r42;
            goto L19
        L13:
            r8 = r39;
            goto L15
        L9:
            r7 = r38;
            goto L11
        L5:
            r6 = r37;
            goto L7
        }
    }

    static {
        a = a.b;
    }

    @FormUrlEncoded
    @POST("/aweme/v2/shop/coupon/apply/auto/")
    Observable<PromotionAutoApplyCouponResponse> applyCouponAuto(@Field(PdpOpenThirdParam.KEY_PRODUCT_ID) String r1, @Field("shop_id") String r2, @Field("price") long r3, @Field("marketing_channel") String r5, @Field("author_id") String r6, @Field(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID) String r7);

    @GET("/aweme/v1/promotion/appoint/")
    Observable<CommerceBaseResponse> appointPromotion(@Query(PdpOpenThirdParam.KEY_PROMOTION_ID) String r1, @Query(SimilarProductParam.AWEME_ID) String r2, @Query("kol_id") String r3, @Query("sec_kol_id") String r4, @Query("author_open_id") String r5, @Query("user_open_id") String r6, @Query("op_type") int r7, @Query("meta_param") String r8);

    @GET("/aweme/v2/shop/promotion/group/")
    Observable<GroupInfoResponse> getGroupInfo(@Query(PdpOpenThirdParam.KEY_ITEM_ID) String r1, @Query(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID) String r2, @Query(PdpOpenThirdParam.KEY_PROMOTION_ID) String r3, @Query("meta_param") String r4, @Query(SimilarProductParam.ENTER_FROM) String r5);

    @GET("https://tsearch.snssdk.com/api/suggest_words/")
    Observable<SearchSuggestWordResponse> getSearchSuggestWords(@Query("business_id") String r1, @Query("pd") String r2, @Query("category_name") String r3, @Query("words_source") String r4, @Query("from_group_id") String r5);

    @FormUrlEncoded
    @POST("/aweme/v2/shop/promotion/pack/inner/")
    Observable<PromotionPackResponse> getShopPromotionInner(@Field("user_id") String r1, @Field("user_open_id") String r2, @Field("sec_user_id") String r3, @Field("promotion_ids") List<String> r4, @Field(PdpOpenThirdParam.KEY_ITEM_ID) String r5, @Field(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID) String r6, @Field(SimilarProductParam.ENTER_FROM) String r7, @Field("meta_param") String r8, @Field("author_id") String r9, @Field("author_open_id") String r10, @Field("width") Integer r11, @Field("height") Integer r12, @Field("rank_id") String r13, @Field("internal_feed_ab") Integer r14, @Field("source_type") String r15, @Field("qianchuan_ab") String r16, @Field("use_new_price") Integer r17, @Field("cps_track") String r18, @Field("user_addr_id") String r19, @Field("marketing_channel") String r20, @Field("gps_on") Integer r21, @Field(PdpOpenThirdParam.KEY_PRODUCT_ID) String r22, @Field("creative_id") String r23, @Field(PdpOpenThirdParam.KEY_PROMOTION_ID) String r24, @Field("inflow_meta_param") String r25, @FieldMap Map<String, String> r26, @Field("video_page_source") String r27, @Field("same_product_scene") Integer r28, @Field("is_preload") Integer r29, @Field("agg_params") String r30);

    @GET("https://report.snssdk.com/aweme/track/report")
    Observable<CommerceBaseResponse> reportTrackParams(@Query(PdpOpenThirdParam.KEY_PRODUCT_ID) String r1, @Query("cps_track") String r2, @Query("report_type") int r3);

    @FormUrlEncoded
    @POST("https://ecom.snssdk.com/aweme/v2/shop/like")
    Observable<PreviewLikeListResponse> shopLikeList(@Field("target_id") String r1, @Field("scene") int r2, @Field("action") int r3, @Field("item_type") int r4, @Field("commission_info") String r5);

    @POST("https://ecom.snssdk.com/aweme/v2/shop/want")
    Observable<PreviewWillListResponse> shopWillList(@Query(SimilarProductParam.AWEME_ID) String r1, @Query(PdpOpenThirdParam.KEY_PROMOTION_ID) String r2, @Query(PdpOpenThirdParam.KEY_PRODUCT_ID) String r3, @Query("author_id") String r4, @Query(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID) String r5, @Query("type") int r6, @Query("meta_param") String r7, @Query("item_type") Integer r8, @Query(PdpOpenThirdParam.KEY_ITEM_ID) String r9, @Query("page_source") String r10, @Query("extra_info") String r11);
}
