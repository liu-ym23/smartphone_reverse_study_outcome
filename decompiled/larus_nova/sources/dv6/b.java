package dv6;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.retrofit2.intercept.Interceptor;
import io.reactivex.Single;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes21.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f470157a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f470158a = null;

        static {
            f470158a = new a();
        }

        public a() {
        }

        public static b a() {
            qt6.b r100 = HostServiceUtilsKt.S();
            if (LiveLifeSaaSUtil.C() == false) goto L5;
            r100.h();
            String r101 = "https://life-service-open.scsjsd.com";
        L7:
            return (b) r100.b(r101, b.class, CollectionsKt.listOf(new Interceptor[]{new dv6.a(), new c()}));
        L5:
            r101 = CJPayConstant.TT_CJ_PAY_FOLLOW_HOST;
            goto L7
        }
    }

    static {
        f470157a = a.f470158a;
    }

    @FormUrlEncoded
    @POST("/aweme/v1/saiyan/live/coupon/collect")
    Single<String> a(@Field("room_id") String r100, @Field("coupon_id") String r101, @Field("coupon_batch_id") String r102, @Field(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE) Integer r103, @Field("entry_point") Integer r104, @Field("launch_id") String r105, @Field("benefit_id") String r106, @Field(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE) Integer r107, @Field(BdpAppEventConstant.PARAMS_LAUNCH_TYPE) Integer r108, @Field("idempotent_id") String r110, @Field("launch_id_v2") String r111, @FieldMap Map<String, Object> r112, @HeaderMap Map<String, String> r113);

    @GET
    Single<String> b(@Url String r100, @Query("agg_card_id") String r101, @Query("location_permission") String r102, @Query("room_id") String r103, @Query("anchor_open_id") String r104, @Query("anchor_id") String r105, @Query("offset") Integer r106, @Query(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT) Integer r107, @Query("selected_tab_id") Integer r108, @Query(AudienceGamePromoteDetailActionHandler.PARA_DEFAULT_TAB_ID) Integer r110, @Query("guess_like_limit") Integer r111, @Query("guess_like_schema_type") Integer r112, @QueryMap Map<String, String> r113, @HeaderMap Map<String, String> r114);

    @GET("/data/life/live/agg/card/detail/paged/")
    Single<String> c(@Query("agg_card_id") String r100, @Query("location_permission") String r101, @Query("room_id") String r102, @Query("anchor_open_id") String r103, @Query("anchor_id") String r104, @Query("offset") Integer r105, @Query(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT) Integer r106, @Query("selected_tab_id") Integer r107, @Query(AudienceGamePromoteDetailActionHandler.PARA_DEFAULT_TAB_ID) Integer r108, @Query("guess_like_limit") Integer r110, @Query("guess_like_schema_type") Integer r111, @QueryMap Map<String, String> r112, @HeaderMap Map<String, String> r113);

    @FormUrlEncoded
    @POST("/data/life/live/card/click/")
    Single<String> d(@Field("room_id") String r100, @Field("card_id") String r101, @Field(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE) String r102);

    @FormUrlEncoded
    @POST
    Single<String> e(@Url String r100, @FieldMap Map<String, Object> r101, @HeaderMap Map<String, String> r102);

    @GET("/data/life/live/agg/card/detail/search/")
    Single<String> f(@Query("agg_card_id") String r100, @Query("location_permission") String r101, @Query("room_id") String r102, @Query("anchor_open_id") String r103, @Query("anchor_id") String r104, @Query("offset") Integer r105, @Query(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT) Integer r106, @Query("query") String r107, @QueryMap Map<String, String> r108, @HeaderMap Map<String, String> r110);

    @GET("/data/life/live/agg/card/detail/")
    Single<String> g(@Query("agg_card_id") String r100, @Query("location_permission") String r101, @Query("room_id") String r102, @Query("anchor_open_id") String r103, @Query("anchor_id") String r104, @QueryMap Map<String, String> r105, @HeaderMap Map<String, String> r106);

    @FormUrlEncoded
    @POST("/data/life/live/coupon/collect")
    Single<String> h(@Field("coupon_infos") String r100, @Field("collect_scene") int r101, @Field("collect_source") int r102, @Field("enter_room_params") String r103);

    @POST
    Single<String> i(@Url String r100, @Body Map<String, Object> r101, @HeaderMap Map<String, String> r102);

    @GET
    Single<String> j(@Url String r100, @QueryMap Map<String, String> r101);
}
