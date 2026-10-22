package com.bytedance.android.livesdk.live.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdkapi.depend.model.live.FeedInterposeData;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0088\u0001\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0013H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/live/api/FeedInnerInterposeApi;", "", "feedInnerInterpose", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseListResponse;", "Lcom/bytedance/android/livesdkapi/depend/model/live/FeedInterposeData;", "Lcom/bytedance/android/live/base/model/Extra;", "needMap", "", "sourceKey", "", "isDraw", "actionType", "similarRoomId", "maxTime", "roomId", "ownerId", "enterSource", "isPad", "", "isLandeScape", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface FeedInnerInterposeApi {
    @GET("/webcast/room/interpose/")
    Observable<BaseListResponse<FeedInterposeData, Extra>> feedInnerInterpose(@Query("need_map") long r1, @Query("source_key") String r3, @Query("is_draw") long r4, @Query("action_type") String r6, @Query("similar_room_id") long r7, @Query("max_time") long r9, @Query("draw_room_id") long r11, @Query("draw_room_owner_id") String r13, @Query("enter_source") String r14, @Query("is_pad") boolean r15, @Query("is_landscape") boolean r16);
}
