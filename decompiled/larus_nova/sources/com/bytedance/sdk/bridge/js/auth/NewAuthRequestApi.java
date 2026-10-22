package com.bytedance.sdk.bridge.js.auth;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes22.dex */
public interface NewAuthRequestApi {
    @Headers({"Content-Type:application/json"})
    @POST("/src/server/v2/package")
    Call<String> requesAuthInfo(@Body JsonObject r100);
}
