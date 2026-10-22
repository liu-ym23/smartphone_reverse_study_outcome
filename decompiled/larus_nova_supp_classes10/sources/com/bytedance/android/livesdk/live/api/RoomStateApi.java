package com.bytedance.android.livesdk.live.api;

import com.bytedance.android.live.base.UplinkService;
import com.bytedance.android.live.broadcast.api.model.h0;
import com.bytedance.android.livesdk.chatroom.model.s;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jz\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0002H'Jz\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0002H'¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/live/api/RoomStateApi;", "", "", "userIds", "scenes", "adTypes", "isWhiteAds", "relativeLogIds", "isLiving", "requestTag", "eventMark", "itemIds", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/chatroom/model/s;", "checkUserLiveStatus", "creationId", "title", "text", "textExtras", "anchorId", "anchorTag", "anchorContent", "anchorTitle", LocationMonitorConst.TYPE, "Lcom/bytedance/android/live/broadcast/api/model/h0;", "genCreateRoomTopic", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RoomStateApi {
    @UplinkService(20002)
    @FormUrlEncoded
    @POST("/webcast/distribution/check_user_live_status/")
    Observable<s> checkUserLiveStatus(@Field(encode = false, value = "user_ids") String r1, @Field(encode = false, value = "distribution_scenes") String r2, @Field(encode = false, value = "ad_type_flags") String r3, @Field(encode = false, value = "ad_white_flags") String r4, @Field("relative_logids") String r5, @Field("is_living") String r6, @Header("x-tt-request-tag") String r7, @Field("event_mark") String r8, @Field("item_ids") String r9);

    @FormUrlEncoded
    @POST("/webcast/anchor/gen_create_room_topic/")
    Observable<h0> genCreateRoomTopic(@Field("creation_id") String r1, @Field("title") String r2, @Field("text") String r3, @Field("text_extra") String r4, @Field("anchor_id") String r5, @Field("anchor_tag") String r6, @Field("anchor_content") String r7, @Field("anchor_title") String r8, @Field("anchor_type") String r9);
}
