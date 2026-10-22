package com.bytedance.android.livesdk.live.api;

import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livesdk.live.model.UserLiveStatusResponse;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface SaasRoomStatApi {
    @FormUrlEncoded
    @POST("/webcast/openapi/distribution/check_user_live_status/")
    Observable<ListResponse<UserLiveStatusResponse>> checkRoomLive(@Field("open_user_ids") String r1, @Field("distribution_scenes") String r2, @Field("relative_logids") String r3, @Field("is_living") String r4);
}
