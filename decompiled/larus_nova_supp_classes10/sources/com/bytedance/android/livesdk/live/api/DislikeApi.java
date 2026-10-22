package com.bytedance.android.livesdk.live.api;

import com.bytedance.android.live.base.model.live.DislikeResult;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface DislikeApi {
    @GET("/webcast/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoom(@Query("id") long r1, @Query("owner_uid") String r3, @Query("request_id") String r4, @Query("enter_source") String r5, @Query("source") String r6, @Query("log_pb") String r7);

    @FormUrlEncoded
    @POST
    Observable<Response<String>> dislikeRoomForAwemeRawData(@Url String r1, @Field("room_id") long r2, @Field("owner_uid") long r4, @Field("request_id") String r6, @Field("source") String r7, @Field("enter_from_merge") String r8, @Field("enter_method") String r9, @Field("ad_id") String r10, @Field("creative_id") String r11, @Field("log_extra") String r12, @Field(LocationMonitorConst.TAG) String r13, @Field("dislike_ad_type") String r14);

    @FormUrlEncoded
    @POST
    Observable<Response<String>> dislikeRoomForAwemeRawDataWithReason(@Url String r1, @Field("room_id") long r2, @Field("owner_uid") long r4, @Field("request_id") String r6, @Field("source") String r7, @Field("enter_from_merge") String r8, @Field("enter_method") String r9, @Field("ad_id") String r10, @Field("creative_id") String r11, @Field("log_extra") String r12, @Field(LocationMonitorConst.TAG) String r13, @Field("dislike_ad_type") String r14, @Field("reason") int r15);

    @GET("/webcast/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoomForDouyin(@Query("room_id") long r1, @Query("owner_uid") long r3, @Query("request_id") String r5, @Query("source") String r6, @Query("enter_from_merge") String r7, @Query("enter_method") String r8, @Query("ad_id") String r9, @Query("creative_id") String r10, @Query("log_extra") String r11, @Query(LocationMonitorConst.TAG) String r12, @Query("enter_preview_time") long r13, @Query("enter_room_time") long r15);

    @GET("/webcast/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoomForDouyinWithMultiReason(@Query("room_id") long r1, @Query("owner_uid") long r3, @Query("request_id") String r5, @Query("source") String r6, @Query("enter_from_merge") String r7, @Query("enter_method") String r8, @Query("ad_id") String r9, @Query("creative_id") String r10, @Query("log_extra") String r11, @Query(LocationMonitorConst.TAG) String r12, @Query("multi_reason") String r13, @Query("enter_preview_time") long r14, @Query("enter_room_time") long r16);

    @GET("/webcast/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoomForDouyinWithReason(@Query("room_id") long r1, @Query("owner_uid") long r3, @Query("request_id") String r5, @Query("source") String r6, @Query("enter_from_merge") String r7, @Query("enter_method") String r8, @Query("ad_id") String r9, @Query("creative_id") String r10, @Query("log_extra") String r11, @Query(LocationMonitorConst.TAG) String r12, @Query("reason") int r13, @Query("enter_preview_time") long r14, @Query("enter_room_time") long r16);

    @FormUrlEncoded
    @POST("/webcast/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoomForSaaS(@Query("room_id") long r1, @Query("owner_open_id") String r3, @Query("request_id") String r4, @Query("source") String r5, @Query("enter_from_merge") String r6, @Query("enter_method") String r7, @Field("ad_id") String r8, @Field("creative_id") String r9, @Field("log_extra") String r10, @Field(LocationMonitorConst.TAG) String r11, @Query("position_type") int r12);

    @GET("/webcast/show/dislike/")
    Observable<Response<Void>> dislikeShow(@Query("episode_id") long r1);
}
