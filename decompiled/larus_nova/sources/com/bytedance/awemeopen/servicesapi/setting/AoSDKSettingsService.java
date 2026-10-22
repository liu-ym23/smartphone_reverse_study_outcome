package com.bytedance.awemeopen.servicesapi.setting;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/setting/AoSDKSettingsService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoSDKSettingsService extends IBdpService {
    JSONObject getSettings();

    JSONObject getSettings(String r100);

    JSONArray getSettingsArray(String r100);

    void updateSettings(boolean r100, String r101);
}
