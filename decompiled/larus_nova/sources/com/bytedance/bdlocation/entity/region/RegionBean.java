package com.bytedance.bdlocation.entity.region;

import android.text.TextUtils;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class RegionBean {
    public static final int DEFAULT_EXPIRE_TIME = 21600000;
    private static final String KEY_ASCINAME = "ASCIName";
    private static final String KEY_CODE = "Code";
    private static final String KEY_EXPIRE_TIME = "expire_time";
    private static final String KEY_GEO_NAME = "GeoNameID";
    private static final String KEY_NAME = "Name";
    private static final String KEY_SOURCE = "source";
    public static final int TYPE_SOURCE_CLIENT_CACHE = 1;
    public static final int TYPE_SOURCE_CLIENT_FALLBACK = 2;
    public static final int TYPE_SOURCE_CLIENT_REALTIME = 0;
    public String asciName;
    public String code;
    public String errorCode;
    public long expireTime;
    public long geoNameID;
    public String name;
    public int source;

    public boolean isValid() {
        if (TextUtils.isEmpty(this.errorCode) == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(this.code) == false) goto L9;
        return false;
    L9:
        if (this.expireTime > 0) goto L11;
        return false;
    L11:
        if (System.currentTimeMillis() > this.expireTime) goto L15;
        return true;
    L15:
        return false;
    }

    public String parseToJsonString() {
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L4
        r100.put(KEY_CODE, this.code);     // Catch: JSONException -> L4
        r100.put(KEY_GEO_NAME, this.geoNameID);     // Catch: JSONException -> L4
        r100.put(KEY_ASCINAME, this.asciName);     // Catch: JSONException -> L4
        r100.put(KEY_NAME, this.name);     // Catch: JSONException -> L4
        r100.put(KEY_EXPIRE_TIME, this.expireTime);     // Catch: JSONException -> L4
        r100.put("source", this.source);     // Catch: JSONException -> L4
        return r100.toString();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String toString() {
        return "RegionBean{code='" + this.code + "', geoNameID=" + this.geoNameID + ", asciName='" + this.asciName + "', name='" + this.name + "', source=" + this.source + ", expireTime=" + this.expireTime + '}';
    }

    private RegionBean() {
    }

    public static RegionBean buildFromErrorCode(String r100) {
        RegionBean r101 = new RegionBean();
        r101.errorCode = r100;
        return r101;
    }

    public static RegionBean buildFromLocal(String r100) {
        RegionBean r101 = new RegionBean();
        r101.source = 2;
        r101.code = r100;
        r101.expireTime = System.currentTimeMillis() + 21600000;
        return r101;
    }

    public static RegionBean buildFromJsonString(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L7
        RegionBean r103 = new RegionBean();     // Catch: JSONException -> L7
        r103.code = JsonUtil.safeOptString(r102, KEY_CODE, null);     // Catch: JSONException -> L7
        r103.geoNameID = JsonUtil.safeOptLong(r102, KEY_GEO_NAME, 0);     // Catch: JSONException -> L7
        r103.asciName = JsonUtil.safeOptString(r102, KEY_ASCINAME, null);     // Catch: JSONException -> L7
        r103.name = JsonUtil.safeOptString(r102, KEY_NAME, null);     // Catch: JSONException -> L7
        r103.expireTime = JsonUtil.safeOptLong(r102, KEY_EXPIRE_TIME, System.currentTimeMillis() + 21600000);     // Catch: JSONException -> L7
        r103.source = r101;     // Catch: JSONException -> L7
        return r103;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
