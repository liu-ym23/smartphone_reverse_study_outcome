package com.ss.videoarch.strategy;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class FeatureBundleBridge {
    private static final String TAG = "FeatureBundleBridge";
    static int kSourceAppType = 1;
    static int kSourceFeatureType = 2;
    static int kSourceUnknown;
    private IAppInfoBundle mBundle;
    private int mSourceType;

    private void encodeUrlParams(JSONObject r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.length()) goto L24;
        String r102 = JSONArrayProtectorUtils.getString(r100.names(), r101);     // Catch: UnsupportedEncodingException -> L18 JSONException -> L21
        String r103 = r100.optString(r102);     // Catch: UnsupportedEncodingException -> L18 JSONException -> L21
        if (TextUtils.isEmpty(r102) == true) goto L17;
        if (TextUtils.isEmpty(r103) == true) goto L17;
        String r104 = URLEncoder.encode(r102, "UTF-8");     // Catch: UnsupportedEncodingException -> L18 JSONException -> L21
        String r105 = URLEncoder.encode(r103, "UTF-8");     // Catch: UnsupportedEncodingException -> L18 JSONException -> L21
        if (TextUtils.equals(r104, r102) == true) goto L15;
    L16:
        r100.remove(r102);     // Catch: UnsupportedEncodingException -> L18 JSONException -> L21
        r100.put(r104, r105);     // Catch: UnsupportedEncodingException -> L18 JSONException -> L21
        goto L17
    L15:
        if (TextUtils.equals(r105, r103) == false) goto L16;
    L17:
        r101 = r101 + 1;
        goto L7
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L21:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public FeatureBundleBridge(IAppInfoBundle r100, int r101) {
        this.mBundle = r100;
        this.mSourceType = r101;
    }

    public double getFloatValueForKey(String r100, double r101) {
        IAppInfoBundle r102 = this.mBundle;
        if (r102 == null) goto L6;
        r101 = ((Double) r102.getAppInfoForKey(r100, Double.valueOf(r101))).doubleValue();
    L6:
        return r101;
    }

    public int getIntValueForKey(String r100, int r101) {
        IAppInfoBundle r102 = this.mBundle;
        if (r102 == null) goto L6;
        r101 = ((Integer) r102.getAppInfoForKey(r100, Integer.valueOf(r101))).intValue();
    L6:
        return r101;
    }

    public JSONArray getJSONArrayValueForKey(String r100, JSONArray r101) {
        JSONArray r102 = new JSONArray();
        IAppInfoBundle r103 = this.mBundle;
        if (r103 != null) goto L5;
        return r102;
    L5:
        JSONArray r104 = (JSONArray) r103.getAppInfoForKey(r100, r101);
        if (r104 == null) goto L8;
        r102 = r104;
    L8:
        r102.toString();
        return r102;
    }

    public JSONObject getJSONObjectValueForKey(String r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();
        IAppInfoBundle r103 = this.mBundle;
        if (r103 != null) goto L5;
        return r102;
    L5:
        JSONObject r104 = (JSONObject) r103.getAppInfoForKey(r100, r101);
        if (TextUtils.equals("url_common_params", r100) == false) goto L8;
        encodeUrlParams(r104);
    L8:
        Objects.toString(r104);
        if (r104 == null) goto L11;
        r102 = r104;
    L11:
        r102.toString();
        return r102;
    }

    public String getStringValueForKey(String r100, String r101) {
        IAppInfoBundle r102 = this.mBundle;
        if (r102 == null) goto L6;
        r101 = (String) r102.getAppInfoForKey(r100, r101);
    L6:
        return r101;
    }

    public void onStrategyResult(String r100, JSONObject r101) {
        IAppInfoBundle r102 = this.mBundle;
        if (r102 == null) goto L6;
        r102.onStrategyResult(r100, r101);
        return;
    }
}
