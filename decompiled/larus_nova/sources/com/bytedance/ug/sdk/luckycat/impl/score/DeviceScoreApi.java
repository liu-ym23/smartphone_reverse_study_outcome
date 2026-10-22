package com.bytedance.ug.sdk.luckycat.impl.score;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface DeviceScoreApi {
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/luckycat/activity/phone_score/")
    Call<String> getDeviceScore(@Body Map<String, Object> r100);
}
