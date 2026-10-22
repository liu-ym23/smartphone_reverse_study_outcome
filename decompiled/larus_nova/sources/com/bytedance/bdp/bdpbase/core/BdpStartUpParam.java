package com.bytedance.bdp.bdpbase.core;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Surface;
import com.bytedance.bdp.bdpbase.core.container.BdpAppContainer;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class BdpStartUpParam extends HashMap<String, Object> {
    public static final String KEY_APP_CONTAINER = "key_app_container";
    public static final String KEY_APP_STATUS_LISTENER = "key_app_status_listener";
    public static final String KEY_ASSIGNED_TECH_TYPE = "key_assigned_tech_type";
    public static final String KEY_EXTRAS = "key_extras";
    public static final String KEY_EXT_CONFIG_JSON = "key_ext_config_json";
    public static final String KEY_FALLBACK_URL = "key_fallback_url";
    public static final String KEY_LAUNCH_ID = "key_launch_id";
    public static final String KEY_LIVE_SURFACE = "key_live_surface";
    public static final String KEY_LOCAL_META = "key_local_meta";
    public static final String KEY_MGL_OPEN_LISTENER = "key_mgl_open_listener";
    public static final String KEY_NET_META = "key_net_meta";
    public static final String KEY_PLUGIN_INSTALL_CONTEXT = "key_plugin_install_context";
    public static final String KEY_PLUGIN_NAME = "key_plugin_name";
    public static final String KEY_START_MODE = "key_start_mode";
    private String mRouteId;
    long mStartActivityCpuTime;
    long mStartActivityTs;
    vpc.a oatVerifyResult;

    public vpc.a getOatVerifyResult() {
        return null;
    }

    public void setOatVerifyResult(vpc.a r100) {
    }

    public BdpAppContainer getAppContainer() {
        if (containsKey(KEY_APP_CONTAINER) == true) goto L5;
        return null;
    L5:
        return (BdpAppContainer) get(KEY_APP_CONTAINER);
    }

    public BdpAppStatusListener getAppStatusListener() {
        if (containsKey(KEY_APP_STATUS_LISTENER) == true) goto L5;
        return null;
    L5:
        return (BdpAppStatusListener) get(KEY_APP_STATUS_LISTENER);
    }

    public int getAssignedTechType() {
        if (containsKey(KEY_ASSIGNED_TECH_TYPE) == false) goto L8;
        Object r100 = get(KEY_ASSIGNED_TECH_TYPE);
        if ((r100 instanceof Integer) == true) goto L7;
        return 0;
    L7:
        return ((Integer) r100).intValue();
    L8:
        return 0;
    }

    public JSONObject getExtConfigJSON() {
        if (containsKey(KEY_EXT_CONFIG_JSON) == false) goto L8;
        Object r100 = get(KEY_EXT_CONFIG_JSON);
        if ((r100 instanceof JSONObject) == true) goto L7;
        return null;
    L7:
        return (JSONObject) r100;
    L8:
        return null;
    }

    public Bundle getExtras() {
        if (containsKey(KEY_EXTRAS) == true) goto L5;
        return null;
    L5:
        return (Bundle) get(KEY_EXTRAS);
    }

    public String getFallbackUrl() {
        if (containsKey(KEY_FALLBACK_URL) == true) goto L5;
        return null;
    L5:
        return (String) get(KEY_FALLBACK_URL);
    }

    public Object getLocalMeta() {
        if (containsKey(KEY_LOCAL_META) == true) goto L5;
        return null;
    L5:
        return get(KEY_LOCAL_META);
    }

    public Object getNetMeta() {
        if (containsKey(KEY_NET_META) == true) goto L5;
        return null;
    L5:
        return get(KEY_NET_META);
    }

    public Context getPluginInstallContext() {
        if (containsKey(KEY_PLUGIN_INSTALL_CONTEXT) == false) goto L8;
        Object r100 = get(KEY_PLUGIN_INSTALL_CONTEXT);
        if (r100 != null) goto L7;
        return null;
    L7:
        return (Context) r100;
    L8:
        return null;
    }

    public String getPluginName() {
        if (containsKey(KEY_PLUGIN_NAME) == false) goto L8;
        Object r100 = get(KEY_PLUGIN_NAME);
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.toString();
    L8:
        return "";
    }

    public long getStartCurTimeMs() {
        Object r100 = get("bdp_open_start_timestamp");
        if ((r100 instanceof Long) == true) goto L5;
        return 0;
    L5:
        return ((Long) r100).longValue();
    }

    public String getStartMode() {
        if (containsKey(KEY_START_MODE) == false) goto L8;
        Object r100 = get(KEY_START_MODE);
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.toString();
    L8:
        return "";
    }

    public long getStartUptimeMillis() {
        Object r100 = get("bdp_open_start_uptime");
        if ((r100 instanceof Long) == true) goto L5;
        return 0;
    L5:
        return ((Long) r100).longValue();
    }

    public Surface getSurface() {
        if (containsKey(KEY_LIVE_SURFACE) == true) goto L5;
        return null;
    L5:
        return (Surface) get(KEY_LIVE_SURFACE);
    }

    public BdpStartUpParam() {
        this.mRouteId = UUID.randomUUID().toString().substring(0, 8) + System.nanoTime();
    }

    public void resetStartActivityTime() {
        this.mStartActivityTs = System.currentTimeMillis();
        this.mStartActivityCpuTime = SystemClock.uptimeMillis();
    }

    public void resetStartTime() {
        put("bdp_open_start_timestamp", Long.valueOf(System.currentTimeMillis()));
        put("bdp_open_start_uptime", Long.valueOf(SystemClock.uptimeMillis()));
    }

    public String getRouteId() {
        return this.mRouteId;
    }

    public long getStartActivityCpuTime() {
        return this.mStartActivityCpuTime;
    }

    public long getStartActivityTs() {
        return this.mStartActivityTs;
    }

    public <T> T getValue(String r100) {
        return (T) get(r100);
    }

    public BdpStartUpParam setAppContainer(BdpAppContainer r100) {
        put(KEY_APP_CONTAINER, r100);
        return this;
    }

    public BdpStartUpParam setAppStatusListener(BdpAppStatusListener r100) {
        put(KEY_APP_STATUS_LISTENER, r100);
        return this;
    }

    public BdpStartUpParam setAssignedTechType(int r100) {
        put(KEY_ASSIGNED_TECH_TYPE, Integer.valueOf(r100));
        return this;
    }

    public BdpStartUpParam setExtConfigJSON(JSONObject r100) {
        put(KEY_EXT_CONFIG_JSON, r100);
        return this;
    }

    public BdpStartUpParam setExtras(Bundle r100) {
        put(KEY_EXTRAS, r100);
        return this;
    }

    public BdpStartUpParam setFallback(String r100) {
        put(KEY_FALLBACK_URL, r100);
        return this;
    }

    public BdpStartUpParam setLiveSurface(Surface r100) {
        put(KEY_LIVE_SURFACE, r100);
        return this;
    }

    public BdpStartUpParam setLocalMeta(Object r100) {
        put(KEY_LOCAL_META, r100);
        return this;
    }

    public BdpStartUpParam setNetMeta(Object r100) {
        put(KEY_NET_META, r100);
        return this;
    }

    public BdpStartUpParam setPluginInstallContext(Context r100) {
        put(KEY_PLUGIN_INSTALL_CONTEXT, r100);
        return this;
    }

    public BdpStartUpParam setPluginName(String r100) {
        put(KEY_PLUGIN_NAME, r100);
        return this;
    }

    public void setRouteId(String r100) {
        this.mRouteId = r100;
    }

    public BdpStartUpParam setStartMode(String r100) {
        put(KEY_START_MODE, r100);
        return this;
    }

    public void setStartActivityTime(long r100, long r101) {
        this.mStartActivityTs = r100;
        this.mStartActivityCpuTime = r101;
    }

    public void setStartTime(long r100, long r101) {
        put("bdp_open_start_timestamp", Long.valueOf(r100));
        put("bdp_open_start_uptime", Long.valueOf(r101));
    }
}
