package com.bytedance.android.livesdk.ktvimpl.concert_stage.interfaces;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/concert_stage/interfaces/ChorusConcertApi;", "", "", "roomId", "", "chorusId", "", "leaveType", "userType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "leaveChorus", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ChorusConcertApi {
    @POST("/webcast/ktv/leave_chorus/")
    Observable<e<Object>> leaveChorus(@Query("room_id") long r1, @Query("chorus_id") String r3, @Query("leave_type") int r4, @Query("user_type") int r5);
}
