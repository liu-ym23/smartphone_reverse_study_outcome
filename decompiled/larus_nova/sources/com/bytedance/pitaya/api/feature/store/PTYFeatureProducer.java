package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureProducer;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "getDictFeature", "", "featureName", "params", "Lorg/json/JSONObject;", "getGroupName", "getNumericFeature", "", "getSeqFeature", "Lorg/json/JSONArray;", "getStringFeature", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class PTYFeatureProducer implements ReflectionCall {
    public PTYFeatureProducer() {
    }

    public abstract JSONObject getDictFeature(String r100, JSONObject r101);

    public abstract String getGroupName();

    public abstract float getNumericFeature(String r100, JSONObject r101);

    public abstract JSONArray getSeqFeature(String r100, JSONObject r101);

    public abstract String getStringFeature(String r100, JSONObject r101);

    private final String getDictFeature(String r100, String r101) {
        if (r101.length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L12;
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L11
    L13:
        JSONObject r104 = getDictFeature(r100, r103);
        if (r104 != null) goto L16;
        return null;
    L16:
        return r104.toString();
    L6:
        r102 = false;
    L12:
        r103 = null;
        goto L13
    }

    private final float getNumericFeature(String r100, String r101) {
        JSONObject r102 = null;
        if (r101.length() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L12;
        r102 = new JSONObject(r101);     // Catch: Throwable -> L13
        goto L12
    L6:
        r103 = false;
    L12:
        return getNumericFeature(r100, r102);
    }

    private final String getSeqFeature(String r100, String r101) {
        if (r101.length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L12;
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L11
    L13:
        JSONArray r104 = getSeqFeature(r100, r103);
        if (r104 != null) goto L16;
        return null;
    L16:
        return r104.toString();
    L6:
        r102 = false;
    L12:
        r103 = null;
        goto L13
    }

    private final String getStringFeature(String r100, String r101) {
        JSONObject r102 = null;
        if (r101.length() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L12;
        r102 = new JSONObject(r101);     // Catch: Throwable -> L13
        goto L12
    L6:
        r103 = false;
    L12:
        return getStringFeature(r100, r102);
    }
}
