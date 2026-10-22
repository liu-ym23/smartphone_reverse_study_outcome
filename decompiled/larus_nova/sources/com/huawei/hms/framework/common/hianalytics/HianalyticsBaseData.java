package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class HianalyticsBaseData {
    public static final String EVENT_ID = "url_request";
    public static final int FALSE = 0;
    public static final String SDK_NAME = "sdk_name";
    public static final String SDK_TYPE = "sdk_type";
    public static final String SDK_VERSION = "sdk_version";
    private static final String TAG = "HianalyticsBaseData";
    public static final int TRUE = 1;
    private LinkedHashMap<String, String> data;

    public String toString() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, String>> r101 = get().entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<String, String> r102 = r101.next();     // Catch: JSONException -> L8
        r100.put(r102.getKey(), r102.getValue());     // Catch: JSONException -> L8
    L11:
        return r100.toString();
    L8:
        e = move-exception;
        Logger.w(TAG, "catch JSONException", e);
        goto L11
    }

    public HianalyticsBaseData() {
        LinkedHashMap<String, String> r100 = new LinkedHashMap();
        this.data = r100;
        r100.put(SDK_TYPE, "UxPP");
        this.data.put("sdk_name", "networkkit");
    }

    public LinkedHashMap<String, String> get() {
        return this.data;
    }

    public HianalyticsBaseData put(LinkedHashMap<String, String> r100) {
        if (r100 != null) goto L4;
    L7:
        Logger.v(TAG, "data is null");
    L8:
        return this;
    L4:
        if (r100.isEmpty() == true) goto L7;
        this.data.putAll(r100);
        goto L8
    }

    public HianalyticsBaseData put(String r100, long r101) {
        if (r100 != null) goto L4;
        Logger.v(TAG, "key = null : value = " + r101);
    L5:
        return this;
    L4:
        this.data.put(r100, "" + r101);
        goto L5
    }

    public HianalyticsBaseData put(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        this.data.put(r100, r101);
    L7:
        return this;
    L6:
        Logger.v(TAG, "key = " + r100 + " : value = " + r101);
        goto L7
    }

    public HianalyticsBaseData putIfNotDefault(String r100, long r101, long r102) {
        if (r101 != r102) goto L6;
        return this;
    L6:
        return put(r100, r101);
    }
}
