package com.bytedance.android.livesdk.linkvideo;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J]\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/LinkVideoApi;", "", "", LocationMonitorConst.TYPE, "", "maxCursor", "minCursor", "count", "", "teenagerMode", "", "scene", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lgf2/b;", "videoList", "(ILjava/lang/Long;Ljava/lang/Long;IZLjava/lang/String;)Lio/reactivex/Observable;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LinkVideoApi {
    @GET("/webcast/room/video_list/")
    Observable<Response<gf2.b>> videoList(@Query(LocationMonitorConst.TYPE) int r1, @Query("max_cursor") Long r2, @Query("min_cursor") Long r3, @Query("count") int r4, @Query("teenager_mode") boolean r5, @Query("scene") String r6);
}
