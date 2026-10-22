package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api;

import com.bytedance.android.live.ktv.common.model.api.a1;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.a;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.i;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.j;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.k;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.l;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.m;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.n;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J<\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007H'J(\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u0005H'J(\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0007H'J(\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0007H'J\u001e\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J*\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0016H'J(\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u0005H'J\u001e\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J2\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u0016H'J4\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010 \u001a\u00020\u00022\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0016H'J(\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010#\u001a\u00020\u0002H'JF\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010%\u001a\u00020\u00162\b\b\u0001\u0010&\u001a\u00020\u00022\b\b\u0001\u0010'\u001a\u00020\u00162\b\b\u0001\u0010(\u001a\u00020\u0007H'J2\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010#\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\u0005H'J1\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b/\u00100J(\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\u0007H'J(\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010#\u001a\u00020\u0002H'¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/api/KtvComponentApi;", "", "", "roomId", "audienceSingEnable", "", "openSource", "", "autoOpenChallenge", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/j;", "openKtvComponent", "closeSource", "closeKtvComponent", "enable", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/k;", "updateAudienceSingEnableSetting", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/m;", "updateMultiChorusEnableSetting", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/g;", "getAudienceSingEnableSetting", "", "cursor", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/i;", "getSongWaitingList", "silenceStatus", "addSongPrepareApply", "cancelAddSongPrepareApply", "permitUserId", "permitOpenId", "addSongPrepareApplyPermit", "count", "Lcom/bytedance/android/live/ktv/common/model/api/a1;", "getWantSingSongList", "songId", "applyWantListenSong", "wantListenCursor", "recommendListCursor", "queryId", "isFirstCall", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/a;", "getListenSongList", "mode", "chooseSong", "stageHideLyricsSwitch", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/l;", "updateKtvComponentSetting", "(JLjava/lang/Boolean;)Lio/reactivex/Observable;", "open", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/n;", "updateRealTimeChorusSwitch", "chorusPreAddSong", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface KtvComponentApi {
    @FormUrlEncoded
    @POST("/webcast/ktv/add_song_prepare_apply/")
    Observable<e<Object>> addSongPrepareApply(@Field("room_id") long r1, @Field("silence_status") int r3);

    @FormUrlEncoded
    @POST("/webcast/ktv/add_song_prepare_apply_permit/")
    Observable<e<Object>> addSongPrepareApplyPermit(@Field("room_id") long r1, @Field("to_user_id") long r3, @Field("to_open_id") String r5);

    @FormUrlEncoded
    @POST("/webcast/ktv/want_to_listen/")
    Observable<e<Object>> applyWantListenSong(@Field("room_id") long r1, @Field("song_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/ktv/add_song_cancel_prepare_apply/")
    Observable<e<Object>> cancelAddSongPrepareApply(@Field("room_id") long r1);

    @FormUrlEncoded
    @POST("/webcast/interact/ktv/choose/song")
    Observable<e<Object>> chooseSong(@Field("room_id") long r1, @Field("song_id") long r3, @Field("mode") int r5);

    @FormUrlEncoded
    @POST("/webcast/ktv/chorus_pre_add_song/")
    Observable<e<Object>> chorusPreAddSong(@Field("room_id") long r1, @Field("song_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/ktv/close_ktv_component/")
    Observable<e<Object>> closeKtvComponent(@Field("room_id") long r1, @Field("close_source") int r3);

    @GET("/webcast/ktv/get_ktv_component_setting/")
    Observable<e<g>> getAudienceSingEnableSetting(@Query("room_id") long r1);

    @GET("/webcast/ktv/get_listen_song_list/")
    Observable<e<a>> getListenSongList(@Query("room_id") long r1, @Query("want_listen_cursor") String r3, @Query("recommend_list_cursor") long r4, @Query("query_id") String r6, @Query("is_first_call") boolean r7);

    @GET("/webcast/ktv/get_song_waiting_list/")
    Observable<e<i>> getSongWaitingList(@Query("room_id") long r1, @Query("cursor") String r3);

    @GET("/webcast/ktv/want_to_sing_song_list/")
    Observable<e<a1>> getWantSingSongList(@Query("room_id") long r1, @Query("count") long r3, @Query("cursor") String r5);

    @FormUrlEncoded
    @POST("/webcast/ktv/open_ktv_component/")
    Observable<e<j>> openKtvComponent(@Field("room_id") long r1, @Field("audience_add_song_switch") long r3, @Field("open_source") int r5, @Field("auto_turn_on_sing_challenge") boolean r6);

    @FormUrlEncoded
    @POST("/webcast/ktv/update_audience_add_song_setting/")
    Observable<e<k>> updateAudienceSingEnableSetting(@Field("room_id") long r1, @Field("open") boolean r3);

    @FormUrlEncoded
    @POST("/webcast/ktv/update_ktv_component_feature_settings/")
    Observable<e<l>> updateKtvComponentSetting(@Field("room_id") long r1, @Field("stage_hide_lyrics_switch") Boolean r3);

    @FormUrlEncoded
    @POST("/webcast/ktv/update_multi_chorus_setting/")
    Observable<e<m>> updateMultiChorusEnableSetting(@Field("room_id") long r1, @Field("open") boolean r3);

    @FormUrlEncoded
    @POST("/webcast/ktv/update_real_time_chorus_switch/")
    Observable<e<n>> updateRealTimeChorusSwitch(@Field("room_id") long r1, @Field("open") boolean r3);
}
