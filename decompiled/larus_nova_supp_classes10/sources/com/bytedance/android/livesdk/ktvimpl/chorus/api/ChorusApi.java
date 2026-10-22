package com.bytedance.android.livesdk.ktvimpl.chorus.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'J<\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u0002H'J(\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'J\u001e\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/chorus/api/ChorusApi;", "", "", "roomId", "channelId", "", "reason", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "closeChorus", "ChorusId", "openChorus", "Lcom/bytedance/android/livesdk/ktvimpl/chorus/api/a;", "getChorusOrderedSongList", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ChorusApi {
    @GET("/webcast/ktv/close_chorus/")
    Observable<e<Object>> closeChorus(@Query("room_id") long r1, @Query("linker_id") long r3, @Query("reason") int r5);

    @GET("/webcast/ktv/close_chorus/")
    Observable<e<Object>> closeChorus(@Query("room_id") long r1, @Query("linker_id") long r3, @Query("reason") int r5, @Query("chorus_id") long r6);

    @GET("/webcast/ktv/get_chorus_ordered_song_list/")
    Observable<e<a>> getChorusOrderedSongList(@Query("room_id") long r1);

    @GET("/webcast/ktv/open_chorus/")
    Observable<e<Object>> openChorus(@Query("room_id") long r1, @Query("linker_id") long r3);
}
