package com.bytedance.sdk.bridge.js.auth;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface ConfigRequestApi {
    @GET("/client_auth/js_sdk/config/v1/")
    Call<String> getConfig(@QueryMap Map<String, String> r100);
}
