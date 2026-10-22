package com.ss.ttvideoengine.selector.strategy;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class GearStrategyConfig {
    private final Map<Integer, Object> mConfigValue;
    private String mExtraConfig;
    private IGearStrategyListener mGearStrategyListener;
    private final Map<String, String> mParam;
    private String mParsedStrategyConfigString;
    private Object mUserData;

    public GearStrategyConfig() {
        this.mGearStrategyListener = null;
        this.mUserData = null;
        this.mExtraConfig = "";
        this.mConfigValue = Collections.synchronizedMap(new HashMap());
        this.mParam = new HashMap();
    }

    public void parse() {
        JSONObject r100 = null;
        String r101 = getStringValue(3, null, false);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        monitor-enter(GearStrategyConfig.class);
        GearStrategyConfig r102 = GearStrategy.getGlobalConfig();     // Catch: Throwable -> L100
        if (r101 == null) goto L15;
        if (TextUtils.equals(r101, r102.mParsedStrategyConfigString) == false) goto L15;
        TTVideoEngineLog.d(GearStrategy.TAG, "global parsed already");     // Catch: Throwable -> L100
        monitor-exit(GearStrategyConfig.class);     // Catch: Throwable -> L100
        return;
    L15:
        if (TextUtils.equals(this.mParsedStrategyConfigString, r101) == false) goto L19;
        TTVideoEngineLog.d(GearStrategy.TAG, "parsed already");     // Catch: Throwable -> L100
        monitor-exit(GearStrategyConfig.class);     // Catch: Throwable -> L100
        return;
    L19:
        this.mParsedStrategyConfigString = r101;     // Catch: Throwable -> L100
        monitor-exit(GearStrategyConfig.class);     // Catch: Throwable -> L100
        r100 = new JSONObject(r101).optJSONObject(GearStrategyConsts.GEAR_STRATEGY_CONFIG_NAME);     // Catch: JSONException -> L23
        TTVideoEngineLog.d(GearStrategy.TAG, "parse success " + r101);     // Catch: JSONException -> L23
    L25:
        if (r100 != null) goto L28;
        return;
    L28:
        if (r100.has(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE) == false) goto L31;
        setIntValue(1, r100.optInt(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE, -1));
    L31:
        if (r100.has(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_MODULE) == false) goto L34;
        setIntValue(2, r100.optInt(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_MODULE, -1));
    L34:
        if (r100.has("switch_cs_model") == false) goto L37;
        setIntValue(44, r100.optInt("switch_cs_model", 1));
    L37:
        if (r100.has("fixed_level") == false) goto L40;
        setIntValue(45, r100.optInt("fixed_level", 2));
    L40:
        if (r100.has("startup_model") == false) goto L43;
        setIntValue(46, r100.optInt("startup_model", 0));
    L43:
        if (r100.has("startup_bandwidth_parameter") == false) goto L46;
        setFloatValue(47, TTHelper.safeParseFloat(r100, "startup_bandwidth_parameter", 0.9f));
    L46:
        if (r100.has("startup_first_param_str") == false) goto L49;
        setDoubleValue(48, TTHelper.safeParseDouble(r100, "startup_first_param_str", AudioStats.AUDIO_AMPLITUDE_NONE));
    L49:
        if (r100.has("startup_second_param_str") == false) goto L52;
        setDoubleValue(49, TTHelper.safeParseDouble(r100, "startup_second_param_str", 2.67952228E-5d));
    L52:
        if (r100.has("startup_third_param_str") == false) goto L55;
        setDoubleValue(50, TTHelper.safeParseDouble(r100, "startup_third_param_str", 0.151840652d));
    L55:
        if (r100.has("startup_fourth_param_str") == false) goto L58;
        setDoubleValue(51, TTHelper.safeParseDouble(r100, "startup_fourth_param_str", 69.0106422d));
    L58:
        if (r100.has("startup_use_cache") == false) goto L61;
        setIntValue(52, r100.optInt("startup_use_cache", 0));
    L61:
        if (r100.has("flow_json") == false) goto L64;
        setStringValue(53, r100.optString("flow_json"));
    L64:
        if (r100.has("preload_json") == false) goto L67;
        setStringValue(54, r100.optString("preload_json"));
    L67:
        if (r100.has("startup_json") == false) goto L70;
        setStringValue(55, r100.optString("startup_json"));
    L70:
        if (r100.has("abr_pool_enable") == false) goto L73;
        setIntValue(56, r100.optInt("abr_pool_enable", 0));
    L73:
        if (r100.has("startup_algo_type") == false) goto L76;
        setIntValue(16, r100.optInt("startup_algo_type", 0));
    L76:
        if (r100.has("startup_speed_type") == false) goto L79;
        setIntValue(9, r100.optInt("startup_speed_type", 4));
    L79:
        if (r100.has("wifi_default_resolution_index") == false) goto L82;
        setIntValue(17, r100.optInt("wifi_default_resolution_index", -1));
    L82:
        if (r100.has("wifi_max_resolution_index") == false) goto L85;
        setIntValue(21, r100.optInt("wifi_max_resolution_index", -1));
    L85:
        if (r100.has("cellular_max_resolution_index") == false) goto L88;
        setIntValue(19, r100.optInt("cellular_max_resolution_index", -1));
    L88:
        if (r100.has("wifi_default_resolution_quality") == false) goto L91;
        setStringValue(18, r100.optString("wifi_default_resolution_quality"));
    L91:
        if (r100.has("wifi_max_resolution_quality") == false) goto L94;
        setStringValue(22, r100.optString("wifi_max_resolution_quality"));
    L94:
        if (r100.has("cellular_max_resolution_quality") == false) goto L97;
        setStringValue(20, r100.optString("cellular_max_resolution_quality"));
    L97:
        if (r100.has("startup_narrow_screen_use_width") == false) goto L106;
        setIntValue(31, r100.optInt("startup_narrow_screen_use_width", 0));
        return;
    L106:
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        TTVideoEngineLog.d(GearStrategy.TAG, "parse error " + r101);
    L100:
        th = move-exception;
        throw th;
    }

    public String getExtraConfig() {
        return this.mExtraConfig;
    }

    public IGearStrategyListener getGearStrategyListener() {
        return this.mGearStrategyListener;
    }

    public Map<String, String> getParam() {
        return this.mParam;
    }

    public Object getUserData() {
        return this.mUserData;
    }

    public double getDoubleValue(int r100) {
        return getDoubleValue(r100, -1.0d);
    }

    public float getFloatValue(int r100) {
        return getFloatValue(r100, -1.0f);
    }

    public int getIntValue(int r100) {
        return getIntValue(r100, -1);
    }

    public <T> T getObjectValue(int r100) {
        return (T) getObjectValue(r100, null);
    }

    public String getStringValue(int r100) {
        return getStringValue(r100, null);
    }

    public GearStrategyConfig setExtraConfig(String r100) {
        this.mExtraConfig = r100;
        return this;
    }

    public GearStrategyConfig setGearStrategyListener(IGearStrategyListener r100) {
        this.mGearStrategyListener = r100;
        return this;
    }

    public GearStrategyConfig setUserData(Object r100) {
        this.mUserData = r100;
        return this;
    }

    public double getDoubleValue(int r100, double r101) {
        return getDoubleValue(r100, r101, true);
    }

    public float getFloatValue(int r100, float r101) {
        return getFloatValue(r100, r101, true);
    }

    public int getIntValue(int r100, int r101) {
        return getIntValue(r100, r101, true);
    }

    public <T> T getObjectValue(int r100, T r101) {
        return (T) getObjectValue(r100, r101, true);
    }

    public String getStringValue(int r100, String r101) {
        return getStringValue(r100, r101, true);
    }

    public GearStrategyConfig setDoubleValue(int r100, double r101) {
        this.mConfigValue.put(Integer.valueOf(r100), Double.valueOf(r101));
        return this;
    }

    public GearStrategyConfig setFloatValue(int r100, float r101) {
        this.mConfigValue.put(Integer.valueOf(r100), Float.valueOf(r101));
        return this;
    }

    public GearStrategyConfig setIntValue(int r100, int r101) {
        this.mConfigValue.put(Integer.valueOf(r100), Integer.valueOf(r101));
        return this;
    }

    public GearStrategyConfig setIntValueIfNotExist(int r100, int r101) {
        if (this.mConfigValue.containsKey(Integer.valueOf(r100)) == true) goto L5;
        this.mConfigValue.put(Integer.valueOf(r100), Integer.valueOf(r101));
    L5:
        return this;
    }

    public GearStrategyConfig setObjectValue(int r100, Object r101) {
        this.mConfigValue.put(Integer.valueOf(r100), r101);
        return this;
    }

    public GearStrategyConfig setObjectValueIfNotExist(int r100, Object r101) {
        if (this.mConfigValue.containsKey(Integer.valueOf(r100)) == true) goto L5;
        this.mConfigValue.put(Integer.valueOf(r100), r101);
    L5:
        return this;
    }

    public GearStrategyConfig setStringValue(int r100, String r101) {
        this.mConfigValue.put(Integer.valueOf(r100), r101);
        return this;
    }

    public GearStrategyConfig setStringValueIfNotExist(int r100, String r101) {
        if (this.mConfigValue.containsKey(Integer.valueOf(r100)) == true) goto L5;
        this.mConfigValue.put(Integer.valueOf(r100), r101);
    L5:
        return this;
    }

    public double getDoubleValue(int r100, double r101, boolean r102) {
        Object r103 = this.mConfigValue.get(Integer.valueOf(r100));
        if ((r103 instanceof Double) == true) goto L5;
        if (r102 == false) goto L12;
        GearStrategyConfig r104 = GearStrategy.getGlobalConfig();
        if (r104 != this) goto L11;
        return r101;
    L11:
        return r104.getDoubleValue(r100, r101, false);
    L12:
        return r101;
    L5:
        return ((Double) r103).doubleValue();
    }

    public float getFloatValue(int r100, float r101, boolean r102) {
        Object r103 = this.mConfigValue.get(Integer.valueOf(r100));
        if ((r103 instanceof Float) == true) goto L5;
        if (r102 == false) goto L12;
        GearStrategyConfig r104 = GearStrategy.getGlobalConfig();
        if (r104 != this) goto L11;
        return r101;
    L11:
        return r104.getFloatValue(r100, r101, false);
    L12:
        return r101;
    L5:
        return ((Float) r103).floatValue();
    }

    public int getIntValue(int r100, int r101, boolean r102) {
        Object r103 = this.mConfigValue.get(Integer.valueOf(r100));
        if ((r103 instanceof Integer) == true) goto L5;
        if (r102 == false) goto L12;
        GearStrategyConfig r104 = GearStrategy.getGlobalConfig();
        if (r104 != this) goto L11;
        return r101;
    L11:
        return r104.getIntValue(r100, r101, false);
    L12:
        return r101;
    L5:
        return ((Integer) r103).intValue();
    }

    public <T> T getObjectValue(int r100, T r101, boolean r102) {
        T r103 = (T) this.mConfigValue.get(Integer.valueOf(r100));
        if (r103 == null) goto L5;
        return r103;
    L5:
        if (r102 == false) goto L11;
        GearStrategyConfig r104 = GearStrategy.getGlobalConfig();
        if (r104 != this) goto L10;
        return r101;
    L10:
        return (T) r104.getObjectValue(r100, r101, false);
    L11:
        return r101;
    }

    public String getStringValue(int r100, String r101, boolean r102) {
        Object r103 = this.mConfigValue.get(Integer.valueOf(r100));
        if ((r103 instanceof String) == true) goto L5;
        if (r102 == false) goto L12;
        GearStrategyConfig r104 = GearStrategy.getGlobalConfig();
        if (r104 != this) goto L11;
        return r101;
    L11:
        return r104.getStringValue(r100, r101, false);
    L12:
        return r101;
    L5:
        return (String) r103;
    }
}
