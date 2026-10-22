package com.ss.videoarch.strategy.featureCenter.featureType;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TypePushFeaturesCollector extends BaseTypeFeaturesCollector {
    private static volatile TypePushFeaturesCollector sInstance;
    private JSONObject mCurCallerInfo;

    public static TypePushFeaturesCollector inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TypePushFeaturesCollector.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TypePushFeaturesCollector();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TypePushFeaturesCollector.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TypePushFeaturesCollector() {
        this.mCurCallerInfo = null;
        this.mTypeKey = "TypePushFeature";
        FeatureConfigInfo r100 = this.mFeatureConfigInfo;
        if (r100 == null) goto L6;
        r100.mFeatureTypeName = "TypePushFeature";
        return;
    }

    public void setCurCallerInfo(JSONObject r100) {
        this.mCurCallerInfo = r100;
    }

    public <T> T getCallerInfo(String r100, T r101) {
        if (this.mCurCallerInfo == null) goto L21;
        r100.getClass();
        if (r100.equals("stream_session_vv_id") == true) goto L16;
        if (r100.equals("neptuneName") == false) goto L21;
        if (r101.getClass() != String.class) goto L16;
        if (this.mCurCallerInfo.has("neptuneName") == false) goto L16;
        return (T) this.mCurCallerInfo.optString("neptuneName");
    L16:
        if (r101.getClass() != String.class) goto L21;
        if (this.mCurCallerInfo.has("stream_session_vv_id") == false) goto L21;
        return (T) this.mCurCallerInfo.optString("stream_session_vv_id");
    L21:
        return r101;
    }

    @Override // com.ss.videoarch.strategy.featureCenter.featureType.BaseTypeFeaturesCollector
    public JSONObject fillInputFeatures(JSONObject r100, JSONArray r101, String r102, String r103, JSONObject r104) {
        int r105 = 0;
    L4:
        if (r105 >= r101.length()) goto L25;
        String r106 = r101.optString(r105);
        if (r106.hashCode() == 927307017) goto L10;
    L12:
        byte r107 = -1;
    L13:
        if (r107 != 0) goto L24;
        JSONObject r108 = this.mCurCallerInfo;     // Catch: JSONException -> L22
        if (r108 != null) goto L18;
    L20:
        r100.put(r106, null);     // Catch: JSONException -> L22
        goto L24
    L18:
        if (r108.has("neptuneName") == false) goto L20;
        r100.put(r106, this.mCurCallerInfo.optJSONObject("neptuneName"));     // Catch: JSONException -> L22
    L24:
        r105 = r105 + 1;
        goto L4
    L10:
        if (r106.equals("PUSH-neptuneName") == false) goto L12;
        r107 = 0;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L25:
        return r100;
    }
}
