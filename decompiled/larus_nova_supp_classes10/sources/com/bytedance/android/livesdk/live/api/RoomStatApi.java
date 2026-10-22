package com.bytedance.android.livesdk.live.api;

import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import ng2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface RoomStatApi {
    @FormUrlEncoded
    @POST("/webcast/room/check_alive/")
    Observable<ListResponse<f>> checkRoom(@Header("x-tt-request-tag") String r1, @Field("room_ids") String r2);
}
