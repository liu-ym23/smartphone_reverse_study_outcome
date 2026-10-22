package com.ss.videoarch.strategy.dataCenter.config.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class PersistenceConfigInfo {
    private static final String TAG = "PersistenceConfig";
    private String mConfigTableConfig;
    public int mConfigTableDelayTime;
    public int mConfigTableEnable;
    public int mConfigTableUpdateLimit;
    public int mEnable;
    private String mHisTableConfig;
    public int mHisTableEnable;
    public int mHisTableRecordLimit;
    public int mHisTableUpdateLimit;
    public int mNodeCacheTime;
    private String mNodeTableConfig;
    public int mNodeTableEnable;
    public int mNodeUpdateLimit;
    public String mParams;
    public int mUserTableEnable;

    public PersistenceConfigInfo() {
        this.mParams = "";
        this.mEnable = -1;
        this.mNodeTableEnable = -1;
        this.mNodeCacheTime = 300000;
        this.mNodeUpdateLimit = 1;
        this.mHisTableEnable = -1;
        this.mHisTableUpdateLimit = 10;
        this.mHisTableRecordLimit = 100;
        this.mConfigTableEnable = -1;
        this.mConfigTableUpdateLimit = 10;
        this.mConfigTableDelayTime = 300000;
        this.mUserTableEnable = -1;
        this.mNodeTableConfig = "";
        this.mHisTableConfig = "";
        this.mConfigTableConfig = "";
    }

    public void initSettingsConfig(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L49;
        JSONObject r101 = new JSONObject();
        r101 = new JSONObject(r100);     // Catch: JSONException -> L7
    L9:
        this.mEnable = r101.optInt("enable");
        this.mNodeTableConfig = r101.optString("node_table");
        this.mHisTableConfig = r101.optString("his_table");
        this.mConfigTableConfig = r101.optString("config_table");
        if (TextUtils.isEmpty(this.mHisTableConfig) == true) goto L23;
        JSONObject r102 = new JSONObject();
        r102 = new JSONObject(this.mHisTableConfig);     // Catch: JSONException -> L14
    L16:
        this.mHisTableEnable = r102.optInt("enable");
        if (r102.has("update_limit") == false) goto L20;
        this.mHisTableUpdateLimit = r102.optInt("update_limit");
    L20:
        if (r102.has("record_limit") == false) goto L23;
        this.mHisTableRecordLimit = r102.optInt("record_limit");
    L14:
        e = move-exception;
        e.printStackTrace();
    L23:
        if (TextUtils.isEmpty(this.mNodeTableConfig) == true) goto L36;
        JSONObject r103 = new JSONObject();
        r103 = new JSONObject(this.mNodeTableConfig);     // Catch: JSONException -> L27
    L29:
        this.mNodeTableEnable = r103.optInt("enable");
        if (r103.has("cache_time") == false) goto L33;
        this.mNodeCacheTime = r103.optInt("cache_time");
    L33:
        if (r103.has("update_limit") == false) goto L36;
        this.mNodeUpdateLimit = r103.optInt("update_limit");
    L27:
        e = move-exception;
        e.printStackTrace();
    L36:
        if (TextUtils.isEmpty(this.mConfigTableConfig) == true) goto L49;
        JSONObject r104 = new JSONObject();
        r104 = new JSONObject(this.mConfigTableConfig);     // Catch: JSONException -> L40
    L42:
        this.mConfigTableEnable = r104.optInt("enable");
        if (r104.has("update_limit") == false) goto L46;
        this.mConfigTableUpdateLimit = r104.optInt("update_limit");
    L46:
        if (r104.has("delay_time") == false) goto L49;
        this.mConfigTableDelayTime = r104.optInt("delay_time");
    L40:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
