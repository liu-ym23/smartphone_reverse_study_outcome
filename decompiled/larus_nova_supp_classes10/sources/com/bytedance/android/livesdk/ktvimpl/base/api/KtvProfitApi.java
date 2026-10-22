package com.bytedance.android.livesdk.ktvimpl.base.api;

import com.bytedance.android.live.ktv.common.model.api.ChangeDressResponse;
import com.bytedance.android.live.ktv.common.model.api.b1;
import com.bytedance.android.live.ktv.common.model.api.c;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jd\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u0004H'J<\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\nH'J(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000f0\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u0002H'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/api/KtvProfitApi;", "", "", "roomId", "", "dressType", "", "fromDressId", "toDressId", "mode", "", "isSinger", "songId", "midiOwnerDegree", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/ktv/common/model/api/ChangeDressResponse;", "changeDress", "Lcom/bytedance/android/live/ktv/common/model/api/c;", "getDressPageList", "Lcom/bytedance/android/live/ktv/common/model/api/b1;", "wearMidiSkin", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface KtvProfitApi {
    @GET("/webcast/ktv_profit/change_dress/")
    Observable<e<ChangeDressResponse>> changeDress(@Query("room_id") long r1, @Query("dress_type") int r3, @Query("from_dress_id") String r4, @Query("to_dress_id") String r5, @Query("mode") int r6, @Query("is_singer") boolean r7, @Query("song_id") long r8, @Query("midi_owner_degree") int r10);

    @GET("/webcast/ktv_profit/get_dress_page_list/")
    Observable<e<c>> getDressPageList(@Query("room_id") long r1, @Query("dress_type") int r3, @Query("mode") int r4, @Query("is_singer") boolean r5);

    @GET("/webcast/ktv_profit/wear_midi_skin/")
    Observable<e<b1>> wearMidiSkin(@Query("room_id") long r1, @Query("song_id") long r3);
}
