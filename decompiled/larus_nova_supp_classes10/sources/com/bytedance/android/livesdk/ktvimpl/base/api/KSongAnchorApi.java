package com.bytedance.android.livesdk.ktvimpl.base.api;

import com.bytedance.android.live.ktv.common.model.api.l;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/api/KSongAnchorApi;", "", "", "roomId", "", "lastItemId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/ktv/common/model/api/l;", "getSungSongList", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface KSongAnchorApi {
    @GET("/webcast/ktv/get_sung_song_list/")
    Observable<e<l>> getSungSongList(@Query("room_id") long r1, @Query("last_item_id") String r3);
}
