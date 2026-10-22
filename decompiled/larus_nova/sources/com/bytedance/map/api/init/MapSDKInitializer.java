package com.bytedance.map.api.init;

import android.content.Context;
import com.bytedance.map.api.settings.MapSettingsUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class MapSDKInitializer {
    private static final String TAG = "MapSDKInitializer";
    private static volatile boolean sInitialized;

    public MapSDKInitializer() {
    }

    public static boolean isInitialized() {
        return sInitialized;
    }

    public static void init(Context r100) {
        if (sInitialized == true) goto L18;
        if (r100 != null) goto L7;
        return;
    L7:
        monitor-enter(MapSDKInitializer.class);
    L15:
        th = move-exception;
        throw th;
    L9:
        if (sInitialized == false) goto L12;
        monitor-exit(MapSDKInitializer.class);     // Catch: Throwable -> L15
        return;
    L12:
        MapSettingsUtil.init(r100.getApplicationContext());     // Catch: Throwable -> L15
        sInitialized = true;     // Catch: Throwable -> L15
        monitor-exit(MapSDKInitializer.class);     // Catch: Throwable -> L15
        return;
    }

    public static void updateSettings(Context r100, JSONObject r101) {
        if (r100 == null) goto L10;
        if (r101 != null) goto L6;
        return;
    L6:
        if (sInitialized == true) goto L8;
        init(r100);
    L8:
        MapSettingsUtil.updateSettings(r100.getApplicationContext(), r101);
        return;
    }
}
