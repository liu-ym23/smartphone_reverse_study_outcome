package com.bytedance.fresco.cloudcontrol;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class CloudControlCache {
    private static final String KEY_ANIMATED_ADAPTIVE_POLICY = "animated_adaptive_policy";
    private static final String KEY_CLOUD_CONTROL_CONFIG = "CloudControlConfig";
    public static final String KEY_DECODE_HEIC_USE_SYSTEM_API_FIRST = "decode_heic_use_system_api_first";
    private static final String KEY_ENABLE_HEIF = "enable_heif";
    private static final String KEY_ENABLE_SR = "enable_sr";
    private static final String KEY_FETCH_SETTING_INTERVAL = "FetchSettingInterval";
    private static final String KEY_HTTP2_ENABLE = "ttnet_h2_enabled";
    private static final String KEY_HTTPDNS_AUTH_ID = "Httpdns_auth_id";
    private static final String KEY_HTTPDNS_AUTH_KEY = "Httpdns_auth_key";
    private static final String KEY_HTTPDNS_ENABLE = "ttnet_http_dns_enabled";
    private static final String KEY_HTTPDNS_SERVICEID = "ttnet_http_dns_serviceid";
    private static final String KEY_IMAGE_ADAPTIVE_FORMAT = "image_adaptive_format";
    private static final String KEY_IMAGE_MONITOR_ERROR_V2 = "ImageMonitorErrorV2";
    private static final String KEY_IMAGE_MONITOR_V2 = "ImageMonitorV2";
    private static final String KEY_LAST_FETCH_SETTING_TS = "LastFetchSetting";
    private static final String KEY_STATIC_ADAPTIVE_POLICY = "static_adaptive_policy";
    private static final String KEY_TTNET_CONFIG = "TTNetConfig";
    private static final String SHARED_NAME = "ImageCloudControl";
    private static final String TAG = "CloudControlCache";
    private static final String[] TTNET_SETTINGS_KEYS = null;
    private final int ENABLE_HTTP2;
    private final int ENABLE_HTTPDNS;
    private SharedPreferences mSharedPreferences;

    public String getAnimatedAdaptivePolicy() {
        return this.mSharedPreferences.getString(KEY_ANIMATED_ADAPTIVE_POLICY, null);
    }

    public String getCloudControlConfig() {
        return this.mSharedPreferences.getString(KEY_CLOUD_CONTROL_CONFIG, "No config, default value here");
    }

    public int getFetchSettingInterval() {
        return this.mSharedPreferences.getInt(KEY_FETCH_SETTING_INTERVAL, AnnouncementViewModel.HOUR_DURATION);
    }

    public String getHttpdnsAuthId() {
        return this.mSharedPreferences.getString(KEY_HTTPDNS_AUTH_ID, null);
    }

    public String getHttpdnsAuthKey() {
        return this.mSharedPreferences.getString(KEY_HTTPDNS_AUTH_KEY, null);
    }

    public float getImageMonitorErrorV2() {
        return this.mSharedPreferences.getFloat(KEY_IMAGE_MONITOR_ERROR_V2, 1.0f);
    }

    public float getImageMonitorV2() {
        return this.mSharedPreferences.getFloat(KEY_IMAGE_MONITOR_V2, 0.0f);
    }

    public long getLastFetchSettingTimeStamp() {
        return this.mSharedPreferences.getLong(KEY_LAST_FETCH_SETTING_TS, 0);
    }

    public String getStaticAdaptivePolicy() {
        return this.mSharedPreferences.getString(KEY_STATIC_ADAPTIVE_POLICY, null);
    }

    public String getTTNetConfig() {
        return this.mSharedPreferences.getString(KEY_TTNET_CONFIG, null);
    }

    public int isDecodeHeicUseSystemApiFirst() {
        return this.mSharedPreferences.getInt(KEY_DECODE_HEIC_USE_SYSTEM_API_FIRST, 0);
    }

    public int isEnableHeif() {
        return this.mSharedPreferences.getInt(KEY_ENABLE_HEIF, 1);
    }

    public boolean isEnableHttp2() {
        return this.mSharedPreferences.getBoolean(KEY_HTTP2_ENABLE, false);
    }

    public boolean isEnableHttpdns() {
        return this.mSharedPreferences.getBoolean(KEY_HTTPDNS_ENABLE, false);
    }

    public int isEnableSr() {
        return this.mSharedPreferences.getInt(KEY_ENABLE_SR, 0);
    }

    static {
        TTNET_SETTINGS_KEYS = new String[]{"ttnet_preconnect_urls", "ttnet_socket_pool_param", "ttnet_h2_config", KEY_HTTP2_ENABLE};
    }

    public CloudControlCache(Context r100) {
        this.ENABLE_HTTPDNS = 1;
        this.ENABLE_HTTP2 = 1;
        this.mSharedPreferences = r100.getSharedPreferences(SHARED_NAME, 0);
    }

    private JSONObject generateTtnetJson(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r100, "httpdns_settings");     // Catch: Exception -> L11
        int r104 = r103.optInt(KEY_HTTPDNS_ENABLE);     // Catch: Exception -> L11
        cacheHttpdnsConfig(r103.optString(KEY_HTTPDNS_SERVICEID), null, r104);     // Catch: Exception -> L11
        Iterator<String> r105 = r103.keys();     // Catch: Exception -> L11
    L4:
        if (r105.hasNext() == false) goto L27;
        String r106 = r105.next();     // Catch: Exception -> L11
        r102.put(r106.toString(), r103.get(r106));     // Catch: Exception -> L9
    L9:
        Objects.toString(r106);     // Catch: Exception -> L11
    L27:
        JSONObject r107 = JSONObjectProtectorUtils.getJSONObject(r100, "ttnet_settings");     // Catch: Exception -> L20
        cacheHttp2Config(r107.optInt(KEY_HTTP2_ENABLE));     // Catch: Exception -> L20
        String[] r108 = TTNET_SETTINGS_KEYS;     // Catch: Exception -> L20
        int r109 = r108.length;     // Catch: Exception -> L20
        int r110 = 0;
    L14:
        if (r110 >= r109) goto L35;
        String r111 = r108[r110];     // Catch: Exception -> L20
        r102.put(r111, r107.get(r111));     // Catch: Exception -> L18
    L19:
        r110 = r110 + 1;
    L35:
        r101.put("data", r102);     // Catch: JSONException -> L24
        r101.put("message", "success");     // Catch: JSONException -> L24
    L26:
        return r101;
    L24:
        e = move-exception;
        e.getMessage();
    L20:
        e = move-exception;
        e.getMessage();
    L11:
        e = move-exception;
        e.getMessage();
        goto L27
    }

    private String getAdaptiveFormats(JSONArray r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L7:
        if (r102 >= r100.length()) goto L16;
        if (r102 > 0) goto L17;
    L10:
        r101.append(JSONArrayProtectorUtils.getString(r100, r102));     // Catch: JSONException -> L12
    L14:
        r102 = r102 + 1;
        goto L7
    L17:
        r101.append(",");     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L16:
        return r101.toString();
    }

    public void cacheCloudConfig(JSONObject r110) {
        JSONObject r100 = JSONObjectProtectorUtils.getJSONObject(r110, "data");     // Catch: Exception -> L5
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, "custom_settings");     // Catch: Exception -> L5
        JSONObject r102 = generateTtnetJson(r101);     // Catch: Exception -> L5
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r100, "general_settings");     // Catch: Exception -> L5
        JSONObject r111 = JSONObjectProtectorUtils.getJSONObject(r101, "allow_log_type");     // Catch: Exception -> L5
        JSONObject r112 = JSONObjectProtectorUtils.getJSONObject(r101, KEY_IMAGE_ADAPTIVE_FORMAT);     // Catch: Exception -> L5
        int r113 = r101.optInt(KEY_ENABLE_SR);     // Catch: Exception -> L5
        int r114 = r101.optInt(KEY_ENABLE_HEIF);     // Catch: Exception -> L5
        int r104 = r101.optInt(KEY_DECODE_HEIC_USE_SYSTEM_API_FIRST);     // Catch: Exception -> L5
        float r115 = (float) r111.optDouble("imagex_load_monitor");     // Catch: Exception -> L5
        float r105 = (float) r111.optDouble("imagex_load_monitor_error");     // Catch: Exception -> L5
        int r106 = r103.optInt("fetch_settings_interval");     // Catch: Exception -> L5
        String r107 = getAdaptiveFormats(r112.optJSONArray(KEY_STATIC_ADAPTIVE_POLICY));     // Catch: Exception -> L5
        String r116 = getAdaptiveFormats(r112.optJSONArray(KEY_ANIMATED_ADAPTIVE_POLICY));     // Catch: Exception -> L5
        SharedPreferences.Editor r117 = this.mSharedPreferences.edit();     // Catch: Exception -> L5
        r117.putFloat(KEY_IMAGE_MONITOR_V2, r115);     // Catch: Exception -> L5
        r117.putFloat(KEY_IMAGE_MONITOR_ERROR_V2, r105);     // Catch: Exception -> L5
        r117.putInt(KEY_FETCH_SETTING_INTERVAL, r106);     // Catch: Exception -> L5
        r117.putLong(KEY_LAST_FETCH_SETTING_TS, System.currentTimeMillis());     // Catch: Exception -> L5
        r117.putString(KEY_CLOUD_CONTROL_CONFIG, r110.toString());     // Catch: Exception -> L5
        r117.putString(KEY_TTNET_CONFIG, r102.toString());     // Catch: Exception -> L5
        r117.putInt(KEY_ENABLE_SR, r113);     // Catch: Exception -> L5
        r117.putInt(KEY_ENABLE_HEIF, r114);     // Catch: Exception -> L5
        r117.putInt(KEY_DECODE_HEIC_USE_SYSTEM_API_FIRST, r104);     // Catch: Exception -> L5
        r117.putString(KEY_ANIMATED_ADAPTIVE_POLICY, r116);     // Catch: Exception -> L5
        r117.putString(KEY_STATIC_ADAPTIVE_POLICY, r107);     // Catch: Exception -> L5
        r117.apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void cacheHttp2Config(int r100) {
        SharedPreferences.Editor r101 = this.mSharedPreferences.edit();
        if (r100 != 1) goto L5;
        r101.putBoolean(KEY_HTTP2_ENABLE, true);
    L6:
        r101.apply();
        return;
    L5:
        r101.putBoolean(KEY_HTTP2_ENABLE, false);
        goto L6
    }

    public void cacheHttpdnsConfig(String r100, String r101, int r102) {
        SharedPreferences.Editor r103 = this.mSharedPreferences.edit();
        r103.putString(KEY_HTTPDNS_AUTH_ID, r100);
        r103.putString(KEY_HTTPDNS_AUTH_KEY, r101);
        if (r102 != 1) goto L5;
        r103.putBoolean(KEY_HTTPDNS_ENABLE, true);
    L6:
        r103.apply();
        return;
    L5:
        r103.putBoolean(KEY_HTTPDNS_ENABLE, false);
        goto L6
    }
}
