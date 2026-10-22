package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import uk7.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JK\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0018\b\u0001\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u001b\b\u0001\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\u00050\u0002H'J1\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u001b\b\u0001\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\u00050\u0002H'J*\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u0002H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/settings/commonsettings/api/ILuckyDogCommonSettingRequestApi;", "", "", "", "params", "Lkotlin/jvm/JvmSuppressWildcards;", "scene", "Lcom/bytedance/retrofit2/Call;", "Luk7/a;", "Lcom/google/gson/JsonObject;", "getStaticSettings", "getDynamicSettings", "", "getPollingSettings", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public interface ILuckyDogCommonSettingRequestApi {
    @POST("/luckycat/activity/settings/get_dynamic_settings/")
    Call<a<JsonObject>> getDynamicSettings(@Body Map<String, Object> r100);

    @POST("/luckycat/activity/settings/get_polling_settings/")
    Call<a<JsonObject>> getPollingSettings(@Body Map<String, Integer> r100);

    @POST("/luckycat/activity/settings/get_static_settings/")
    Call<a<JsonObject>> getStaticSettings(@QueryMap Map<String, String> r100, @Body Map<String, Object> r101);
}
