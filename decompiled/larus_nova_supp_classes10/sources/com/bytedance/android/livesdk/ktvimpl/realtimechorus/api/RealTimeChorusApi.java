package com.bytedance.android.livesdk.ktvimpl.realtimechorus.api;

import com.bytedance.android.live.ktv.common.model.api.i;
import com.bytedance.android.live.ktv.common.model.api.w;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001Jd\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000bH'J\u001e\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J2\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0002H'JP\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u000b2\b\b\u0001\u0010\u0016\u001a\u00020\u000b2\b\b\u0001\u0010\u0017\u001a\u00020\u0006H'J<\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00192\b\b\u0001\u0010\u0015\u001a\u00020\u000b2\b\b\u0001\u0010\u0016\u001a\u00020\u000bH'JZ\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00022\b\b\u0001\u0010 \u001a\u00020\u0019H'¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/api/RealTimeChorusApi;", "", "", "roomId", "chorusId", "segment", "", "segmentAvgScore", "avgScore", "volume", "networkStatus", "", "reportType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "reportClientChorusInfo", "Lcom/bytedance/android/live/ktv/common/model/api/i;", "getChorusSetting", "songId", "Lcom/bytedance/android/live/ktv/common/model/api/w;", "joinChorus", "leaveType", "userType", "totalScore", "leaveChorus", "", "room_id", "singer_volume", "accompaniment_volume", "chorus_singers_volume", "lyric_switch", "original_song_switch", "tuning_effect", "reportTunningInfo", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface RealTimeChorusApi {
    @GET("/webcast/ktv/get_real_time_chorus_setting/")
    Observable<e<i>> getChorusSetting(@Query("room_id") long r1);

    @POST("/webcast/ktv/join_chorus/")
    Observable<e<w>> joinChorus(@Query("room_id") long r1, @Query("chorus_id") long r3, @Query("song_id") long r5);

    @POST("/webcast/ktv/leave_chorus/")
    Observable<e<Object>> leaveChorus(@Query("room_id") long r1, @Query("chorus_id") long r3, @Query("average_midi_score") double r5, @Query("leave_type") int r7, @Query("user_type") int r8, @Query("midi_tatal_score") double r9);

    @POST("/webcast/ktv/leave_chorus/")
    Observable<e<Object>> leaveChorus(@Query("room_id") long r1, @Query("chorus_id") String r3, @Query("leave_type") int r4, @Query("user_type") int r5);

    @POST("/webcast/ktv/report_client_chorus_info/")
    Observable<e<Object>> reportClientChorusInfo(@Query("room_id") long r1, @Query("chorus_id") long r3, @Query("segment") long r5, @Query("single_segment_midi_score") double r7, @Query("average_midi_score") double r9, @Query("volume") long r11, @Query("network_status") long r13, @Query("report_type") int r15);

    @POST("/webcast/ktv/report_tuning_info/")
    Observable<e<Object>> reportTunningInfo(@Query("room_id") long r1, @Query("singer_volume") long r3, @Query("accompaniment_volume") long r5, @Query("chorus_singers_volume") long r7, @Query("lyric_switch") long r9, @Query("original_song_switch") long r11, @Query("tuning_effect") String r13);
}
