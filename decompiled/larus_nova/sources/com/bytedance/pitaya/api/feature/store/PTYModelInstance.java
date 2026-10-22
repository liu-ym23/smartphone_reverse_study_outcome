package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.facebook.keyframes.model.KFImage;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0003J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\u0006\u0010\u0017\u001a\u00020\u0007J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001cJ*\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYModelInstance;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "instanceID", "", "featureStr", "(Ljava/lang/String;Ljava/lang/String;)V", KFImage.FEATURES_JSON_FIELD, "Lorg/json/JSONObject;", "getInstanceID", "()Ljava/lang/String;", "labels", "", "", "predicts", "addLabel", "", "name", "value", "addPredict", "getFeature", "", "featureName", "getFeatureStr", SystemAppletMethod.METHOD_GET_FEATURES, "getLabelsStr", "getPredictsStr", "updateFeatures", "json", "updateFeatures$pitayacore_release", "upload", "sampleRate", "business", "version", "", "tag", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYModelInstance implements ReflectionCall {
    private JSONObject features;
    private final String instanceID;
    private final Map<String, Float> labels;
    private final Map<String, Float> predicts;

    private final String getFeatureStr() {
        return this.features.toString();
    }

    private final String getLabelsStr() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, Float>> r101 = this.labels.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<String, Float> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue());
        goto L4
    L7:
        return r100.toString();
    }

    private final String getPredictsStr() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, Float>> r101 = this.predicts.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<String, Float> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue());
        goto L4
    L7:
        return r100.toString();
    }

    public final JSONObject getFeatures() {
        return this.features;
    }

    public final String getInstanceID() {
        return this.instanceID;
    }

    public final Object getFeature(String r100) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        return this.features.opt(r100);
    }

    public final void updateFeatures$pitayacore_release(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        this.features = r100;
    }

    public PTYModelInstance(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "instanceID");
        Intrinsics.checkNotNullParameter(r101, "featureStr");
        this.instanceID = r100;
        this.features = new JSONObject(r101);
        this.labels = new LinkedHashMap();
        this.predicts = new LinkedHashMap();
    }

    public final void addLabel(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Float r102 = Float.valueOf(r101);
        this.labels.put(r100, r102);
    }

    public final void addPredict(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Float r102 = Float.valueOf(r101);
        this.predicts.put(r100, r102);
    }

    public final void upload(float r100, String r101, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "business");
        Intrinsics.checkNotNullParameter(r111, "tag");
        IFeatureStore r102 = PTYFeatureStoreInstance.INSTANCE.getFeatureStore();
        if (r102 == null) goto L6;
        r102.upload(this, r100, r101, r110, r111);
        return;
    }

    public static /* synthetic */ void upload$default(PTYModelInstance r100, float r101, String r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = 0;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = "";
    L8:
        r100.upload(r101, r102, r103, r104);
    }
}
