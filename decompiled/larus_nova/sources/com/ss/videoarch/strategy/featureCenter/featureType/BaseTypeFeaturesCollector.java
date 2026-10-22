package com.ss.videoarch.strategy.featureCenter.featureType;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class BaseTypeFeaturesCollector {
    private static final String TAG = "BaseTypeFeaturesCollector";
    public FeatureConfigInfo mFeatureConfigInfo;
    protected String mTypeKey;

    public JSONObject fillInputFeature(JSONObject r100, String r101, String r102, String r103, JSONObject r104) {
        return null;
    }

    public JSONObject fillInputFeatures(JSONObject r100, JSONArray r101, String r102, String r103, JSONObject r104) {
        return null;
    }

    public JSONObject fillInputRTFeatures(JSONObject r100, JSONArray r101, String r102, String r103, JSONObject r104) {
        return null;
    }

    public void initFeatureConfig() {
        FeatureConfigInfo r100 = this.mFeatureConfigInfo;
        if (r100 == null) goto L6;
        r100.initSettingsConfig();
        return;
    }

    public BaseTypeFeaturesCollector() {
        this.mTypeKey = "BaseType";
        this.mFeatureConfigInfo = new FeatureConfigInfo();
    }

    public int getNetWorkType(String r100) {
        if (r100 != null) goto L5;
    L15:
        return 0;
    L5:
        if (r100.length() == 0) goto L15;
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L9
    L11:
        if (r101 != null) goto L14;
        return 0;
    L14:
        return r101.optInt("net_effective_connection_type");
    L9:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L11
    }

    public boolean isValid(String r100) {
        FeatureConfigInfo r101 = this.mFeatureConfigInfo;
        if (r101 == null) goto L9;
        JSONArray r102 = r101.mFeaturesList;
        if (r102 == null) goto L9;
        if (r102.toString().contains(r100) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
