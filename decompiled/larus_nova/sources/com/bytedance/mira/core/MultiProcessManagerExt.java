package com.bytedance.mira.core;

import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.plugin.PluginManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public class MultiProcessManagerExt {
    private static final String LAST_HOST_UPDATE_VERSION_CODE = "ext_last_host_update_version_code";
    private static final String LAST_RUN_IN_PLUGIN_ACTIVITY_NAME_LIST_KEY = "ext_last_run_in_plugin_activity_name_list_key";
    private static final int MAX_CACHE_SIZE = 30;
    private static final Object PLACE_HOLDER = null;
    private static final String SP_PLUGIN_MULTI_PROCESS_INFO_PRE = "ext_plugin_multi_process_info_";
    private static final String SP_PLUGIN_MULTI_PROCESS_VERSION_PRE = "ext_plugin_multi_process_version_";
    private static volatile MultiProcessManagerExt sInstance;
    private final LruCacheExt<String, Object> infoCache;
    private String infoKey;
    private android.content.SharedPreferences infoSp;
    private String processName;
    private int updateVersionCode;
    private android.content.SharedPreferences versionSp;

    static {
        PLACE_HOLDER = new Object();
    }

    private void checkAndClearSharedPreferences() {
        int r100 = this.versionSp.getInt(LAST_HOST_UPDATE_VERSION_CODE, -1);
        boolean r101 = true;
        if (r100 != (-1)) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        this.infoSp.edit().remove(buildInfoKey(r100)).apply();
    L10:
        if (r100 != (-1)) goto L12;
    L15:
        if (r101 == false) goto L18;
        this.versionSp.edit().putInt(LAST_HOST_UPDATE_VERSION_CODE, this.updateVersionCode).apply();
        return;
    L18:
        return;
    L12:
        if (r100 != this.updateVersionCode) goto L15;
        r101 = false;
        goto L15
    L5:
        if (r100 == this.updateVersionCode) goto L7;
        r102 = true;
        goto L8
    }

    public static MultiProcessManagerExt getInst() {
        if (sInstance != null) goto L15;
        monitor-enter(MultiProcessManagerExt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MultiProcessManagerExt();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MultiProcessManagerExt.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void initInfoCache() {
        Iterator<String> r100 = this.infoSp.getStringSet(this.infoKey, new HashSet()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        String r101 = r100.next();
        this.infoCache.put(r101, PLACE_HOLDER);
        goto L4
    }

    private void initSharedPreferences() {
        this.versionSp = getSharedPreferences(buildVersionSpName(this.processName));
        this.infoSp = getSharedPreferences(buildInfoSpName(this.processName));
    }

    public Set<String> getPluginActivityClassName() {
        return this.infoCache.originKeySet();
    }

    private MultiProcessManagerExt() {
        this.infoCache = new LruCacheExt(30);
        initBaseInfo();
        initSharedPreferences();
        checkAndClearSharedPreferences();
        initInfoCache();
    }

    private void initBaseInfo() {
        String r100 = ProcessHelper.getCurrentProcessName(Mira.getAppContext());
        this.processName = r100;
        this.processName = r100.replaceAll("[^a-zA-Z0-9_]", "_");
        int r101 = PluginManager.getInstance().getHostUpdateVerCode();
        this.updateVersionCode = r101;
        this.infoKey = buildInfoKey(r101);
    }

    private static String buildInfoKey(int r100) {
        return "ext_last_run_in_plugin_activity_name_list_key_" + r100;
    }

    private static String buildInfoSpName(String r100) {
        return SP_PLUGIN_MULTI_PROCESS_INFO_PRE + r100;
    }

    private static String buildVersionSpName(String r100) {
        return SP_PLUGIN_MULTI_PROCESS_VERSION_PRE + r100;
    }

    private static android.content.SharedPreferences getSharedPreferences(String r100) {
        return Mira.getAppContext().getSharedPreferences(r100, 0);
    }

    public void addPluginActivityClassName(String r100) {
        this.infoCache.put(r100, PLACE_HOLDER);
        this.infoCache.get(r100);
        this.infoSp.edit().putStringSet(this.infoKey, this.infoCache.originKeySet()).apply();
    }
}
