package com.bytedance.services.slardar.config;

import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IConfigManager extends IService {
    void fetchConfig();

    int getConfigInt(String r100, int r101);

    JSONObject getConfigJSON(String r100);

    boolean getLogTypeSwitch(String r100);

    boolean getMetricTypeSwitch(String r100);

    boolean getServiceSwitch(String r100);

    boolean getSwitch(String r100);

    boolean isConfigReady();

    String queryConfig();

    void registerConfigListener(IConfigListener r100);

    void registerResponseConfigListener(IResponseConfigListener r100);

    JSONObject retrieveSettingsParams();

    void unregisterConfigListener(IConfigListener r100);

    void unregisterResponseConfigListener(IResponseConfigListener r100);

    boolean updateWithSpecificAidResult(JSONObject r100);
}
