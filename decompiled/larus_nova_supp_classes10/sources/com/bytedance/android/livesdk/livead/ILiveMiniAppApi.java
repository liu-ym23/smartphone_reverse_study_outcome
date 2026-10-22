package com.bytedance.android.livesdk.livead;

import com.bytedance.android.live.base.model.user.CoverImageModel;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.LiveAdAuthResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampInfoResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSearchResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSelectionResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSensitiveResponse;
import com.bytedance.android.livesdk.livead.model.a;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'J2\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'JF\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\fH'JF\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\fH'J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J,\u0010\u0019\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0018\u00010\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'J2\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00112\b\b\u0001\u0010\u001a\u001a\u00020\u0002H'J=\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b \u0010!J\u001e\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00070$2\b\b\u0001\u0010#\u001a\u00020\"H'J(\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u00062\b\b\u0001\u0010\u0004\u001a\u00020\u00112\b\b\u0001\u0010'\u001a\u00020\u0002H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006+À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/livead/ILiveMiniAppApi;", "", "", "url", "roomId", "stamps", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampInfoResponse;", "saveStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "deleteStamp", "", LocationMonitorConst.TYPE, "stampId", "status", "updateStamp", "", "tabId", "page", "pageSize", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionResponse;", "selectStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/LiveAdAuthResponse;", "checkMiniappAuthList", "getStampInfo", "keyword", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSearchResponse;", "searchStamp", "businessType", "text", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSensitiveResponse;", "checkStamp", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "typedOutput", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/base/model/user/CoverImageModel;", "uploadAvatar", "appId", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/livead/model/a;", "getEntranceVisiable", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMiniAppApi {
    @GET
    Observable<LiveAdAuthResponse> checkMiniappAuthList(@Url String r1);

    @GET
    Observable<Response<StampSensitiveResponse>> checkStamp(@Url String r1, @Query(LocationMonitorConst.TYPE) Integer r2, @Query("text") String r3);

    @FormUrlEncoded
    @POST
    Observable<Response<BaseResponse>> deleteStamp(@Url String r1, @Field("room_id") String r2, @Field("stamps") String r3);

    @GET("https://hotsoon.snssdk.com/webcast/stamp/entrance_visiable/")
    Observable<e<a>> getEntranceVisiable(@Query("room_id") long r1, @Query("app_id") String r3);

    @GET
    Observable<Response<StampInfoResponse>> getStampInfo(@Url String r1, @Query("room_id") String r2);

    @FormUrlEncoded
    @POST
    Observable<Response<StampInfoResponse>> saveStamp(@Url String r1, @Field("room_id") String r2, @Field("stamps") String r3);

    @GET
    Observable<Response<StampSearchResponse>> searchStamp(@Url String r1, @Query(LocationMonitorConst.TYPE) long r2, @Query("keyword") String r4);

    @GET
    Observable<Response<StampSelectionResponse>> selectStamp(@Url String r1, @Query(LocationMonitorConst.TYPE) long r2, @Query("tab_id") String r4, @Query("page") int r5, @Query("page_size") int r6);

    @FormUrlEncoded
    @POST
    Observable<Response<BaseResponse>> updateStamp(@Url String r1, @Field("room_id") String r2, @Field(LocationMonitorConst.TYPE) int r3, @Field("stamp_id") String r4, @Field("status") int r5);

    @POST("/webcast/room/upload/image/")
    Single<Response<CoverImageModel>> uploadAvatar(@Body TypedOutput r1);
}
