package com.bytedance.android.livesdk.livematrix;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/livematrix/LiveMatrixApi;", "", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/livematrix/a;", "checkLiveMatrixEntrance", "", "token", "joinLiveMatrix", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveMatrixApi {
    @GET("/webcast/linkmic_audience/live_matrix/check_entrance/")
    Observable<Response<a>> checkLiveMatrixEntrance();

    @GET("/webcast/linkmic_audience/live_matrix/join/")
    Observable<Response<Object>> joinLiveMatrix(@Query("invite_token") String r1);
}
