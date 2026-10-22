package com.bytedance.sdk.open.douyin.settings;

import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public class OpenSettingsManager {
    private static final String TAG = "OpenSettingsManager";
    private static volatile OpenSettingsManager instance;
    private final HashMap<String, Object> cache;
    private Gson mGson;

    public static class SDKConfig {

        @SerializedName("auth_entrance")
        public int authEntrance;

        @SerializedName("init_ticket_sdk")
        public int initTicketSDK;

        @SerializedName("share_entrance")
        public int shareEntrance;

        public SDKConfig() {
            this.initTicketSDK = 1;
            this.authEntrance = 3;
            this.shareEntrance = 7;
        }
    }

    private OpenSettingsManager() {
        this.mGson = new Gson();
        this.cache = new HashMap();
    }

    private <T> T getValue(String r100, Class r101) {
        return (T) this.cache.get(r100);
    L4:
        e = move-exception;
        LogUtils.e(TAG, new Object[]{e});
        return null;
    }

    public static OpenSettingsManager inst() {
        if (instance != null) goto L15;
        monitor-enter(OpenSettingsManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new OpenSettingsManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OpenSettingsManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public SDKConfig getSDKConfig() {
        SDKConfig r100 = (SDKConfig) getValueSafely("open_sdk_config", SDKConfig.class);     // Catch: Exception -> L9
        if (r100 == null) goto L8;
        this.cache.put("open_sdk_config", r100);     // Catch: Exception -> L9
        return r100;
    L8:
        return new SDKConfig();
    }

    public <T> T getValueSafely(String r100, Class<T> r101) {
        T r102 = (T) getValue(r100, r101);
        if (r102 == null) goto L23;
    L17:
        return r102;
    L23:
        Object r103 = this.mGson.fromJson(OpenSettings.get().opt(r100).toString(), r101);     // Catch: Throwable -> L9 Exception -> L11
        if (r103 == null) goto L20;
        this.cache.put(r100, r103);     // Catch: Throwable -> L9 Exception -> L11
        r102 = (T) r103;
        goto L20
    L20:
    L11:
        e = move-exception;
        LogUtils.e(TAG, new Object[]{e});     // Catch: Throwable -> L9
    L9:
        th = th;
    L16:
        LogUtils.e(TAG, new Object[]{th});
    L14:
        th = th;
        r102 = null;
        goto L16
    }
}
