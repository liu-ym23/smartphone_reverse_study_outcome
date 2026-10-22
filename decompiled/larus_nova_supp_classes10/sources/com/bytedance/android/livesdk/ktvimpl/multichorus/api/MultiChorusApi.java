package com.bytedance.android.livesdk.ktvimpl.multichorus.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'J(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH'J\u001e\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JF\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\nH'JF\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\nH'J4\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\n2\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005H'¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/api/MultiChorusApi;", "", "", "roomId", "userId", "", "userOpenId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "multiChorusPrepareApplyPermit", "", "silenceStatus", "multiChorusPrepareApply", "multiChorusCancelPrepareApply", "songId", "singerId", "singerOpenId", "songType", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/api/b;", "joinMultiChorus", "leaveMultiChorus", "count", "cursor", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/api/a;", "getMultiChorusWaitingList", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface MultiChorusApi {
    @GET("/webcast/ktv/get_multi_chorus_waiting_list/")
    Observable<e<a>> getMultiChorusWaitingList(@Query("room_id") long r1, @Query("count") int r3, @Query("cursor") String r4);

    @GET("/webcast/ktv/join_multi_chorus/")
    Observable<e<b>> joinMultiChorus(@Query("room_id") long r1, @Query("song_id") long r3, @Query("singer_id") long r5, @Query("singer_open_id") String r7, @Query("song_type") int r8);

    @GET("/webcast/ktv/leave_multi_chorus/")
    Observable<e<Object>> leaveMultiChorus(@Query("room_id") long r1, @Query("song_id") long r3, @Query("singer_id") long r5, @Query("singer_open_id") String r7, @Query("song_type") int r8);

    @GET("/webcast/ktv/multi_chorus_cancel_prepare_apply/")
    Observable<e<Object>> multiChorusCancelPrepareApply(@Query("room_id") long r1);

    @GET("/webcast/ktv/multi_chorus_prepare_apply/")
    Observable<e<Object>> multiChorusPrepareApply(@Query("room_id") long r1, @Query("silence_status") int r3);

    @GET("/webcast/ktv/multi_chorus_prepare_apply_permit/")
    Observable<e<Object>> multiChorusPrepareApplyPermit(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_open_id") String r5);
}
