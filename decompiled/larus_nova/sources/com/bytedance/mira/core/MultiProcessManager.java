package com.bytedance.mira.core;

import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.ProcessHelper;

/* JADX INFO: loaded from: classes21.dex */
public class MultiProcessManager {
    private static final String LAST_RUN_IN_PLUGIN_ACTIVITY_NAME_KEY = "last_run_in_plugin_activity_name_key";
    private static volatile MultiProcessManager sInstance;
    private android.content.SharedPreferences mPreferences;

    public static MultiProcessManager getInst() {
        if (sInstance != null) goto L15;
        monitor-enter(MultiProcessManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MultiProcessManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MultiProcessManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public String getLastRunInPluginActivityClassName() {
        return this.mPreferences.getString(LAST_RUN_IN_PLUGIN_ACTIVITY_NAME_KEY, null);
    }

    private MultiProcessManager() {
        String r100 = ProcessHelper.getCurrentProcessName(Mira.getAppContext()).replaceAll("[^a-zA-Z0-9_]", "_");
        this.mPreferences = Mira.getAppContext().getSharedPreferences("plugin_multi_process_info_" + r100, 0);
    }

    public boolean setLastRunInPluginActivityClassName(String r100) {
        this.mPreferences.edit().putString(LAST_RUN_IN_PLUGIN_ACTIVITY_NAME_KEY, r100).apply();
        return true;
    }
}
