package com.bytedance.map.api.settings;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class BdMapSettingsConfig {

    public static class BdMapInnerConfig {
        public boolean enableMapServicePool;
        public boolean enableStyleRetry;
        public boolean useNewStyleApi;

        public BdMapInnerConfig() {
            this.useNewStyleApi = false;
            this.enableStyleRetry = false;
            this.enableMapServicePool = true;
        }

        public static BdMapInnerConfig fromJson(JSONObject r100) {
            BdMapInnerConfig r101 = new BdMapInnerConfig();
            if (r100 != null) goto L5;
            return r101;
        L5:
            r101.useNewStyleApi = r100.optBoolean(MapSettingsConst.KEY_USE_NEW_STYLE_API, r101.useNewStyleApi);
            r101.enableStyleRetry = r100.optBoolean(MapSettingsConst.KEY_ENABLE_STYLE_RETRY, r101.enableStyleRetry);
            r101.enableMapServicePool = r100.optBoolean(MapSettingsConst.KEY_ENABLE_MAP_SERVICE_POOL, r101.enableMapServicePool);
            return r101;
        }
    }

    public BdMapSettingsConfig() {
    }
}
