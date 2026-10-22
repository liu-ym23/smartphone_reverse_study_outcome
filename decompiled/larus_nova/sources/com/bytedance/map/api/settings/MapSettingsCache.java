package com.bytedance.map.api.settings;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes21.dex */
class MapSettingsCache {
    private static volatile MapSettingsCache sInstance;
    private SharedPreferences mSP;

    public MapSettingsCache() {
    }

    public static MapSettingsCache getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(MapSettingsCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MapSettingsCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MapSettingsCache.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public String getSettings() {
        SharedPreferences r100 = this.mSP;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getString(MapSettingsConst.SP_KEY_SETTINGS, null);
    }

    public void init(Context r100) {
        if (this.mSP != null) goto L7;
        if (r100 == null) goto L8;
        this.mSP = r100.getApplicationContext().getSharedPreferences(MapSettingsConst.SP_NAME, 0);
        return;
    L8:
        return;
    }

    public void saveSettings(String r100) {
        SharedPreferences r101 = this.mSP;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.edit().putString(MapSettingsConst.SP_KEY_SETTINGS, r100).apply();
        return;
    L8:
        return;
    }
}
