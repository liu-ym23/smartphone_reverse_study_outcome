package com.bytedance.map.api.settings;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class MapSettingsUtil {
    private static final String TAG = "MapSettingsUtil";
    private static volatile BdMapSettingsConfig.BdMapInnerConfig sConfig;
    private static volatile boolean sInitialized;

    public MapSettingsUtil() {
    }

    private static BdMapSettingsConfig.BdMapInnerConfig getConfig() {
        if (sConfig != null) goto L5;
        String r100 = MapSettingsCache.getInstance().getSettings();     // Catch: Exception -> L12
        if (r100 == null) goto L11;
        sConfig = BdMapSettingsConfig.BdMapInnerConfig.fromJson(new JSONObject(r100));     // Catch: Exception -> L12
        boolean r101 = sConfig.useNewStyleApi;     // Catch: Exception -> L12
        boolean r102 = sConfig.enableStyleRetry;     // Catch: Exception -> L12
        boolean r103 = sConfig.enableMapServicePool;     // Catch: Exception -> L12
        return sConfig;
    L11:
        return new BdMapSettingsConfig.BdMapInnerConfig();
    L5:
        return sConfig;
    }

    public static boolean isEnableMapServicePool() {
        return getConfig().enableMapServicePool;
    }

    public static boolean isEnableStyleRetry() {
        return getConfig().enableStyleRetry;
    }

    public static boolean isUseNewStyleApi() {
        return getConfig().useNewStyleApi;
    }

    public static void init(Context r100) {
        if (sInitialized == true) goto L7;
        if (r100 == null) goto L8;
        MapSettingsCache.getInstance().init(r100);
        sInitialized = true;
        return;
    L8:
        return;
    }

    public static void updateSettings(Context r100, JSONObject r101) {
        if (r100 == null) goto L15;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.has(MapSettingsConst.STORAGE_KEY) == false) goto L8;
        r101 = r101.optJSONObject(MapSettingsConst.STORAGE_KEY);
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.has(MapSettingsConst.INNER_KEY) == false) goto L17;
        JSONObject r102 = r101.optJSONObject(MapSettingsConst.INNER_KEY);
        if (r102 == null) goto L18;
        sConfig = BdMapSettingsConfig.BdMapInnerConfig.fromJson(r102);
        MapSettingsCache.getInstance().init(r100);
        MapSettingsCache.getInstance().saveSettings(r102.toString());
        boolean r103 = sConfig.useNewStyleApi;
        boolean r104 = sConfig.enableStyleRetry;
        boolean r105 = sConfig.enableMapServicePool;
        return;
    L18:
        return;
    L17:
        return;
    }
}
