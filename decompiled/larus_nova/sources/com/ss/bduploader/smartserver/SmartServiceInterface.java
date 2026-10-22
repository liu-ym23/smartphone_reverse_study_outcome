package com.ss.bduploader.smartserver;

import com.ss.ugc.clientai.core.api.SmartInputData;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public interface SmartServiceInterface {
    void configServer();

    int getIntelligentInput(JSONObject r100, SmartInputData r101);

    void preloadEnv();

    void runAsync(Map r100, SmartServiceListener r101);

    float runAsyncJsonObject(JSONObject r100, SmartServiceListener r101);

    float runSync(Map r100);

    float runSyncJsonObject(JSONObject r100);

    boolean serviceEnabled();

    void setIntValue(int r100, int r101);

    void setStringValue(int r100, String r101);
}
