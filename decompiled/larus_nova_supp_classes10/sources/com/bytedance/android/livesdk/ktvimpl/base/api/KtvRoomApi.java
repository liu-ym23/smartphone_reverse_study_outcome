package com.bytedance.android.livesdk.ktvimpl.base.api;

import com.bytedance.android.live.ktv.common.model.api.b;
import com.bytedance.android.live.ktv.common.model.api.c0;
import com.bytedance.android.live.ktv.common.model.api.d;
import com.bytedance.android.live.ktv.common.model.api.d0;
import com.bytedance.android.live.ktv.common.model.api.e0;
import com.bytedance.android.live.ktv.common.model.api.g;
import com.bytedance.android.live.ktv.common.model.api.h;
import com.bytedance.android.live.ktv.common.model.api.n;
import com.bytedance.android.live.ktv.common.model.api.q;
import com.bytedance.android.live.ktv.common.model.api.r0;
import com.bytedance.android.live.ktv.common.model.api.v;
import com.bytedance.android.live.ktv.common.model.api.x;
import com.bytedance.android.live.ktv.common.model.api.y;
import com.bytedance.android.live.ktv.common.model.api.y0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.a;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.h1;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'J<\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH'JJ\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0011H'J<\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00060\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u0011H'J<\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00060\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u0011H'J2\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001d\u001a\u00020\u0002H'JW\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00112\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b%\u0010&JK\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00060\u00052\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u00112\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b*\u0010+J(\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00060\u00052\b\b\u0001\u0010,\u001a\u00020\u00112\b\b\u0003\u0010-\u001a\u00020\nH'J,\u00103\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000202\u0018\u00010\u0006012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JB\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u00112\b\b\u0001\u0010\t\u001a\u00020\u00022\n\b\u0001\u00104\u001a\u0004\u0018\u00010\u0011H'J\u001e\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JJ\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00108\u001a\u00020\n2\b\b\u0001\u00109\u001a\u00020\u00022\b\b\u0001\u0010:\u001a\u00020\u00022\b\b\u0001\u0010;\u001a\u00020\u00022\b\b\u0001\u0010<\u001a\u00020\nH'J\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J\u001e\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J\"\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010A\u001a\u00020\u0002H'JH\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00022\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010C\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0002H'J2\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010F\u001a\u00020\u0011H'J(\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010I\u001a\u00020\nH'J8\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\u00022\b\b\u0001\u0010M\u001a\u00020\u00112\b\b\u0001\u0010N\u001a\u00020\u0002H'J\\\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\u00060\u00052\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010A\u001a\u00020P2\b\b\u0001\u0010\u0016\u001a\u00020\u00022\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010Q\u001a\u00020\u00022\b\b\u0001\u0010R\u001a\u00020\u0002H'J\u001e\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u001e0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JP\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0\u00060\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010W\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001d\u001a\u00020\u0002H'J3\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0\u00060\u00052\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010[\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b]\u0010^J,\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010_\u001a\u00020\u00112\b\b\u0001\u0010`\u001a\u00020\u0002H'¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/api/KtvRoomApi;", "", "", "roomId", "linkerId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/ktv/common/model/api/h;", "getOrderSongList", "songId", "", "action", "Lcom/bytedance/android/live/ktv/common/model/api/y0;", "updateSingerState", "actionType", "songType", "toUserId", "", "toOpenId", "Lcom/bytedance/android/live/network/response/a;", "pausePlayMusic", "anchorId", "singerId", "singerOpenId", "Lcom/bytedance/android/live/ktv/common/model/api/d0;", "getKtvUserContributorHotRank", "Lcom/bytedance/android/live/ktv/common/model/api/e0;", "getKtvUserWeeklyHotRank", LayoutSizeLargeModeConfig.TYPE_SIZE_DP, "count", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/ktv/common/model/api/y;", "getPreviewSongs", "vId", "orderUid", "orderOpenUid", "Lcom/bytedance/android/live/ktv/common/model/api/b;", "getAtmosphereVideoInfoByVid", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "songName", "fetchType", "Lcom/bytedance/android/live/ktv/common/model/api/a;", "fetchAtmosphereVideoInfo", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "group_ids", LocationMonitorConst.TYPE, "Lcom/bytedance/android/live/ktv/common/model/api/v;", "getKtvGroupUser", "keys", "Lio/reactivex/Single;", "Lcom/bytedance/android/livesdk/chatroom/model/h1;", "getAudienceSettings", "extra", "addSongStatusForRebroadcast", "Lcom/bytedance/android/live/ktv/common/model/api/c0;", "getSingingChallengeOptionParams", "changeType", "switchStatus", "targetScore", "targetDurationSecond", "challengeType", "singingChallengeConfigChangedNotice", "startSingingChallenge", "Lcom/bytedance/android/live/ktv/common/model/api/x;", "getSingingChallengeStatus", "score", "reportChallengeMidiResult", "singingStartTime", "Lcom/bytedance/android/live/ktv/common/model/api/e;", "getKtvSingingHotResult", "singerIdString", "Lcom/bytedance/android/live/ktv/common/model/api/n;", "getUserFollowRelation", "group_type", "Lcom/bytedance/android/live/ktv/common/model/api/q;", "getGroupInfo", "to_user_id", "to_open_id", "group_id", "inviteGuestToKtvGroup", "", "totalLyricsCount", "sungLyricsCount", "Lcom/bytedance/android/live/ktv/common/model/api/r0;", "reportMidiScore", "Lcom/bytedance/android/live/ktv/common/model/api/g;", "getMidiConfig", "requestType", "Lcom/bytedance/android/live/ktv/common/model/api/d;", "getHighScoreSongList", "jumpScene", "jumpRooms", "Lcom/bytedance/android/live/soloktv/model/e;", "jumpRealTimeChorusRoom", "(Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "toUsers", "status", "updateRealtimeChorusGuestStatus", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface KtvRoomApi {
    @FormUrlEncoded
    @POST("/webcast/ktv/add_song_status_for_rebroadcast/")
    Observable<a> addSongStatusForRebroadcast(@Field("room_id") long r1, @Field("singer_id") long r3, @Field("singer_open_id") String r5, @Field("song_id") long r6, @Field("extra") String r8);

    @GET("/webcast/ktv/fetch_atmosphere_video_info/")
    Observable<e<com.bytedance.android.live.ktv.common.model.api.a>> fetchAtmosphereVideoInfo(@Query("room_id") Long r1, @Query("song_id") Long r2, @Query("song_name") String r3, @Query("fetch_type") Integer r4);

    @FormUrlEncoded
    @POST("/webcast/ktv/get_atmosphere_video/")
    Observable<e<b>> getAtmosphereVideoInfoByVid(@Field("room_id") Long r1, @Field("vid") String r2, @Field("song_id") Long r3, @Field("order_user_id") Long r4, @Field("order_open_id") String r5);

    @PbRequest("linkmic_audience")
    @GET("/webcast/linkmic_audience/get_audience_settings/")
    Single<e<h1>> getAudienceSettings(@Query("keys") String r1, @Query("room_id") long r2);

    @PbRequest("linkmic_audience")
    @GET("/webcast/linkmic_audience/get_group_info/")
    Observable<e<q>> getGroupInfo(@Query("room_id") long r1, @Query("group_type") int r3);

    @GET("/webcast/ktv/get_high_score_sung_songs/")
    Observable<e<d>> getHighScoreSongList(@Query("to_user_id") long r1, @Query("to_open_id") String r3, @Query("request_type") int r4, @Query("room_id") long r5, @Query(LayoutSizeLargeModeConfig.TYPE_SIZE_DP) long r7, @Query("count") long r9);

    @PbRequest("linkmic_audience")
    @GET("/webcast/linkmic_audience/ingroup_delegate/")
    Observable<e<v>> getKtvGroupUser(@Query("group_ids") String r1, @Query(LocationMonitorConst.TYPE) int r2);

    @FormUrlEncoded
    @POST("/webcast/ktv/get_ktv_singing_hot_result/")
    Observable<e<com.bytedance.android.live.ktv.common.model.api.e>> getKtvSingingHotResult(@Field("room_id") long r1, @Field("singer_id") long r3, @Field("singer_open_id") String r5, @Field("singing_start_time") long r6, @Field("song_id") long r8);

    @FormUrlEncoded
    @POST("/webcast/ktv/get_ktv_user_song_contributor_rank/")
    Observable<e<d0>> getKtvUserContributorHotRank(@Field("song_id") long r1, @Field("room_id") long r3, @Field("singer_id") long r5, @Field("singer_open_id") String r7);

    @FormUrlEncoded
    @POST("/webcast/ktv/get_ktv_user_weekly_hot_rank_pos/")
    Observable<e<e0>> getKtvUserWeeklyHotRank(@Field("song_id") long r1, @Field("room_id") long r3, @Field("singer_id") long r5, @Field("singer_open_id") String r7);

    @GET("/webcast/ktv/get_midi_config/")
    Observable<Response<g>> getMidiConfig(@Query("room_id") long r1);

    @GET("/webcast/linkmic_audience/ktv/get_ordered_song_list/")
    Observable<e<h>> getOrderSongList(@Query("room_id") long r1, @Query("linker_id") long r3);

    @GET("/webcast/ktv/get_ktv_cold_starting_song_list/")
    Observable<Response<y>> getPreviewSongs(@Query("room_id") long r1, @Query(LayoutSizeLargeModeConfig.TYPE_SIZE_DP) long r3, @Query("count") long r5);

    @GET("/webcast/ktv/get_singing_challenge_option/")
    Observable<e<c0>> getSingingChallengeOptionParams(@Query("room_id") long r1);

    @GET("/webcast/ktv/get_singing_challenge_status/")
    Observable<e<x>> getSingingChallengeStatus(@Query("room_id") long r1);

    @FormUrlEncoded
    @POST("/webcast/ktv/get_user_follow_relation/")
    Observable<e<n>> getUserFollowRelation(@Field("room_id") long r1, @Field("to_user") long r3, @Field("to_user_open_id") String r5);

    @FormUrlEncoded
    @PbRequest("linkmic_audience")
    @POST("/webcast/linkmic_audience/group_invite/")
    Observable<a> inviteGuestToKtvGroup(@Field("room_id") long r1, @Field("to_user_id") long r3, @Field("to_open_id") String r5, @Field("group_id") long r6);

    @FormUrlEncoded
    @POST("/webcast/ktv/jump_real_time_chorus_room/")
    Observable<e<com.bytedance.android.live.soloktv.model.e>> jumpRealTimeChorusRoom(@Field("jump_scene") Integer r1, @Field("jump_rooms") String r2);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/ktv/pause_play/")
    Observable<a> pausePlayMusic(@Field("song_id") long r1, @Field("action_type") int r3, @Field("room_id") long r4, @Field("song_type") int r6, @Field("to_user_id") long r7, @Field("to_open_id") String r9);

    @GET("/webcast/ktv/report_challenge_midi_result/")
    Observable<a> reportChallengeMidiResult(@Query("room_id") long r1, @Query("score") long r3);

    @GET("/webcast/ktv/report_midi_score/")
    Observable<e<r0>> reportMidiScore(@Query("song_id") long r1, @Query("room_id") long r3, @Query("score") double r5, @Query("singer_id") long r7, @Query("singer_open_id") String r9, @Query("total_lyric_count") long r10, @Query("sung_lyric_count") long r12);

    @FormUrlEncoded
    @POST("/webcast/ktv/singing_challenge_config_changed_notice/")
    Observable<a> singingChallengeConfigChangedNotice(@Field("room_id") long r1, @Field("config_changed_type") int r3, @Field("switch_status") long r4, @Field("target_score") long r6, @Field("target_duration_second") long r8, @Field("ktv_challenge_type") int r10);

    @FormUrlEncoded
    @POST("/webcast/ktv/start_singing_challenge_notice/")
    Observable<a> startSingingChallenge(@Field("room_id") long r1);

    @GET("/webcast/ktv/update_real_time_chorus_guest_status/")
    Observable<a> updateRealtimeChorusGuestStatus(@Query("room_id") long r1, @Query("to_users") String r3, @Query("status") long r4);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/ktv/update_singer_state/")
    Observable<e<y0>> updateSingerState(@Field("room_id") long r1, @Field("linker_id") long r3, @Field("song_id") long r5, @Field("action") int r7);
}
