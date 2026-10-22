package com.bytedance.ug.sdk.luckydog.api.task.resource;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import uk7.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0019\b\u0001\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u00040\u0002H'¨\u0006\n"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/task/resource/ILuckyDogResourceRequestApi;", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "scene", "Lcom/bytedance/retrofit2/Call;", "Luk7/a;", "Lcom/google/gson/JsonObject;", "getResourceLaunch", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public interface ILuckyDogResourceRequestApi {
    @POST("/luckycat/activity/i/api/v:version/resource/gcall/launch/")
    Call<a<JsonObject>> getResourceLaunch(@Body Map<String, Object> r100);
}
