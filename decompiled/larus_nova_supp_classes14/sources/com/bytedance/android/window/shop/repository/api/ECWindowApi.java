package com.bytedance.android.window.shop.repository.api;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.window.base.shop.ECWindowFansClubResponse;
import com.bytedance.android.window.shop.repository.dto.WindowAuthorInfoResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowComponentResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowExtensionDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowFollowCommitDTO;
import com.bytedance.android.window.shop.repository.dto.WindowFollowDeleteDTO;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowProductExtDataDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001IJg\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\r\u0010\u000eJÛ\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u001f\u0010 Jó\u0001\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000b2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b#\u0010$Jñ\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0\u000b2\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b&\u0010'JP\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010(\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040)H'J\\\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010(\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040)H'J\"\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010-\u001a\u00020\u0004H'Jg\u00104\u001a\b\u0012\u0004\u0012\u0002030\u000b2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u00101\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b4\u00105J<\u00109\u001a\b\u0012\u0004\u0012\u0002080\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u00106\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u00107\u001a\u0004\u0018\u00010\u0004H'J$\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0004H'J.\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0004H'J.\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010>\u001a\u00020\u0004H'J©\u0001\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\bA\u0010BJ9\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u000b2\n\b\u0001\u0010C\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010D\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\u0017H'¢\u0006\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/ECWindowApi;", "", "", "isPrefetch", "", "secAuthorId", "sourceType", "passThroughApi", "upgradeVersion", "sceneType", "ecExtra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/window/shop/repository/dto/WindowHeaderResponseDTO;", "getShopHeader", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "tabType", "pageNum", "pageSize", "", "sortType", "sort", "targetFilterType", "commonPassThrough", "", "firstEnter", "clickProducts", "targetCategory", "forceInsertInfo", "targetSubCategory", "targetChildCategory", "Lcom/bytedance/android/window/shop/repository/dto/WindowTabDataListResponseDTODeprecated;", "getShopTabDataList", "(Ljava/lang/Integer;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "localCardVersions", "Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO;", "getWindowTabBffDataList", "(Ljava/lang/Integer;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "path", "getWindowTabExtBffDataList", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "excludedIds", "", "requestParams", "getShopTabInsertData", "getShopTabInsertDataBff", "extensionCardParam", "Lcom/bytedance/android/window/shop/repository/dto/WindowExtensionDataListResponseDTO;", "getWindowExtensionData", "extraSchema", "sceneName", "sceneParams", "Lcom/bytedance/android/window/shop/repository/dto/WindowComponentResponseDTO;", "getComponentData", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "followEntrance", "couopnId", "Lcom/bytedance/android/window/shop/repository/dto/WindowFollowCommitDTO;", "followShop", "Lcom/bytedance/android/window/shop/repository/dto/WindowFollowDeleteDTO;", "unfollowShop", "Lcom/bytedance/android/window/shop/repository/dto/WindowAuthorInfoResponseDTO;", "getAuthorInfo", "params", "Lcom/bytedance/android/window/shop/repository/dto/WindowProductExtDataDTO;", "getCardExtData", "getGuessLike", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "AuthorID", "Scene", "NeedFansClubSwitch", "Lcom/bytedance/android/ec/window/base/shop/ECWindowFansClubResponse;", "getFansClubInfo", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ECWindowApi {
    public static final a a = null;

    public static final class a {
        public static final ECWindowApi a = null;
        public static final ECWindowApi b = null;
        public static final /* synthetic */ a c = null;

        public a() {
        }

        static {
            c = new a();
            n r0 = n.a;
            a = (ECWindowApi) r0.create(kp.a.a(), ECWindowApi.class);
            Lazy r1 = ECAppInfoService.a;
            if (we.a.a == false) goto L5;
            String r2 = "isaas.ecombdapi.com";
        L6:
            b = (ECWindowApi) r0.create("https://".concat(r2), ECWindowApi.class);
            return;
        L5:
            r2 = "ecom.snssdk.com";
            goto L6
        }
    }

    static {
        a = a.c;
    }

    @GET("/window/follow/commit/")
    Observable<WindowFollowCommitDTO> followShop(@Query("sec_author_id") String r1, @Query("pass_through_api") String r2, @Query("follow_entrance") String r3, @Query("coupon_id") String r4);

    @GET("/window/author_info/")
    Observable<WindowAuthorInfoResponseDTO> getAuthorInfo(@Query("sec_author_id") String r1, @Query("tab_type") int r2, @Query("pass_through_api") String r3);

    @GET("/window/product/refresh/")
    Observable<WindowProductExtDataDTO> getCardExtData(@Query("sec_author_id") String r1, @Query("pass_through_api") String r2, @Query("refresh_param") String r3);

    @GET("/window/component/")
    Observable<WindowComponentResponseDTO> getComponentData(@Header("Ec-Native-Prefetch") Integer r1, @Query("sec_author_id") String r2, @Query("pass_through_api") String r3, @Query("source_type") Integer r4, @Query("extra_schema") String r5, @Query("scene_name") String r6, @Query("scene_params") String r7);

    @GET("/ecom/fansclub/entrance/")
    Observable<ECWindowFansClubResponse> getFansClubInfo(@Query("author_id") String r1, @Query("scene") Integer r2, @Query("need_switch") Boolean r3);

    @GET("{path}")
    Observable<WindowTabDataListResponseDTODeprecated> getGuessLike(@Path(encode = false, value = "path") String r1, @Query("sec_author_id") String r2, @Query("target_tab_type") int r3, @Query("cursor") int r4, @Query("size") Integer r5, @Query("pass_through_api") String r6, @Query("sort_type") Long r7, @Query("sort") Integer r8, @Query("common_pass_through") String r9, @Query("is_first_enter") Boolean r10, @Query("click_products") String r11, @Query("target_category") String r12, @Query("force_insert_info") String r13);

    @GET("/window/header/bff/")
    Observable<WindowHeaderResponseDTO> getShopHeader(@Header("Ec-Native-Prefetch") Integer r1, @Query("sec_author_id") String r2, @Query("source_type") Integer r3, @Query("pass_through_api") String r4, @Query("upgrade_version") Integer r5, @Query("scene_type") Integer r6, @Query("ec_extra") String r7);

    @GET("/window/tab/")
    Observable<WindowTabDataListResponseDTODeprecated> getShopTabDataList(@Header("Ec-Native-Prefetch") Integer r1, @Query("sec_author_id") String r2, @Query("target_tab_type") int r3, @Query("cursor") int r4, @Query("size") Integer r5, @Query("pass_through_api") String r6, @Query("sort_type") Long r7, @Query("sort") Integer r8, @Query("target_filter_type") String r9, @Query("common_pass_through") String r10, @Query("is_first_enter") Boolean r11, @Query("click_products") String r12, @Query("target_category") String r13, @Query("upgrade_version") Integer r14, @Query("force_insert_info") String r15, @Query("target_sub_category") String r16, @Query("selected_filter") String r17);

    @GET("/window/dynamic_insert_card/")
    Observable<WindowTabDataListResponseDTODeprecated> getShopTabInsertData(@Query("sec_author_id") String r1, @Query("target_category") String r2, @Query("filter_pids") String r3, @Query("pass_through_api") String r4, @QueryMap(encode = true) Map<String, String> r5);

    @GET("/window/dynamic_insert_card/bff/")
    Observable<WindowHybridTabDataListResponseDTO> getShopTabInsertDataBff(@Query("sec_author_id") String r1, @Query("target_category") String r2, @Query("filter_pids") String r3, @Query("pass_through_api") String r4, @Query("ec_extra") String r5, @QueryMap(encode = true) Map<String, String> r6);

    @GET("/window/extensioncard/")
    Observable<WindowExtensionDataListResponseDTO> getWindowExtensionData(@Query("sec_author_id") String r1, @Query("extension_card_param") String r2);

    @GET("/window/tab/bff/")
    Observable<WindowHybridTabDataListResponseDTO> getWindowTabBffDataList(@Header("Ec-Native-Prefetch") Integer r1, @Query("sec_author_id") String r2, @Query("target_tab_type") int r3, @Query("cursor") int r4, @Query("size") Integer r5, @Query("pass_through_api") String r6, @Query("sort_type") Long r7, @Query("sort") Integer r8, @Query("target_filter_type") String r9, @Query("common_pass_through") String r10, @Query("is_first_enter") Boolean r11, @Query("click_products") String r12, @Query("target_category") String r13, @Query("upgrade_version") Integer r14, @Query("force_insert_info") String r15, @Query("ec_extra") String r16, @Query("local_card_versions") String r17, @Query("target_sub_category") String r18, @Query("selected_filter") String r19);

    @GET("{path}")
    Observable<WindowHybridTabDataListResponseDTO> getWindowTabExtBffDataList(@Path(encode = false, value = "path") String r1, @Query("sec_author_id") String r2, @Query("target_tab_type") int r3, @Query("cursor") int r4, @Query("size") Integer r5, @Query("pass_through_api") String r6, @Query("sort_type") Long r7, @Query("sort") Integer r8, @Query("target_filter_type") String r9, @Query("common_pass_through") String r10, @Query("is_first_enter") Boolean r11, @Query("click_products") String r12, @Query("target_category") String r13, @Query("upgrade_version") Integer r14, @Query("force_insert_info") String r15, @Query("ec_extra") String r16, @Query("local_card_versions") String r17, @Query("target_sub_category") String r18, @Query("selected_filter") String r19);

    @GET("/window/follow/delete/")
    Observable<WindowFollowDeleteDTO> unfollowShop(@Query("sec_author_id") String r1, @Query("pass_through_api") String r2);
}
