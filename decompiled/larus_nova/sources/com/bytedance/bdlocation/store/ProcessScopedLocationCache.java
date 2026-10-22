package com.bytedance.bdlocation.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.BDLocationProcessUtils;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ProcessScopedLocationCache extends Enum<ProcessScopedLocationCache> {
    private static final /* synthetic */ ProcessScopedLocationCache[] $VALUES = null;
    public static final ProcessScopedLocationCache LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR = null;
    private static volatile SharedPreferences SHARED_PREFERENCES = null;
    private static final String SP_NAME_PREFIX = "PROCESS_SCOPED_LOCATION_CACHE_";
    private final String mKey;

    static {
        ProcessScopedLocationCache r100 = new ProcessScopedLocationCache("LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR", 0, "last_info_request_key_params_json_str");
        LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR = r100;
        $VALUES = new ProcessScopedLocationCache[]{r100};
        SHARED_PREFERENCES = null;
    }

    public static ProcessScopedLocationCache[] values() {
        return (ProcessScopedLocationCache[]) $VALUES.clone();
    }

    private static SharedPreferences getSharedPreferencesOfCurrentProcess(Context r100) {
        if (SHARED_PREFERENCES != null) goto L23;
        monitor-enter(ProcessScopedLocationCache.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (SHARED_PREFERENCES == null) goto L9;
    L17:
        monitor-exit(ProcessScopedLocationCache.class);     // Catch: Throwable -> L19
        goto L23
    L9:
        if (r100 != null) goto L12;
        monitor-exit(ProcessScopedLocationCache.class);     // Catch: Throwable -> L19
        return null;
    L12:
        String r101 = BDLocationProcessUtils.getCurrentProcessName(r100);     // Catch: Throwable -> L19
        if (r101 != null) goto L16;
        monitor-exit(ProcessScopedLocationCache.class);     // Catch: Throwable -> L19
        return null;
    L16:
        SHARED_PREFERENCES = r100.getSharedPreferences(SP_NAME_PREFIX.concat(r101), 0);     // Catch: Throwable -> L19
        Logger.i("Successfully created SharedPreferences: PROCESS_SCOPED_LOCATION_CACHE_".concat(r101));     // Catch: Throwable -> L19
    L23:
        return SHARED_PREFERENCES;
    }

    public static ProcessScopedLocationCache valueOf(String r100) {
        return (ProcessScopedLocationCache) a.a(ProcessScopedLocationCache.class, r100);
    }

    public void applyString(Context r100, String r101) {
        SharedPreferences r102 = getSharedPreferencesOfCurrentProcess(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.edit().putString(this.mKey, r101).apply();
    }

    public String getString(Context r100, String r101) {
        SharedPreferences r102 = getSharedPreferencesOfCurrentProcess(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.getString(this.mKey, r101);
    }

    private ProcessScopedLocationCache(String r100, int r101, String r102) {
        super(r100, r101);
        this.mKey = r102;
    }
}
